package com.DbRelations.Entities;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.DbRelations.Repository.SeriesRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class SoundtrackJsonDeserializer extends JsonDeserializer<Soundtrack>{
	
	private final SeriesRepository seriesRepository;
		
	@Autowired
	public SoundtrackJsonDeserializer(SeriesRepository seriesRepository) {
		this.seriesRepository = seriesRepository;
	}

	@Override
	public Soundtrack deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		
		ObjectCodec codec = jsonParser.getCodec();
		JsonNode root = codec.readTree(jsonParser);
		
//		System.out.println(root);
		
		Soundtrack soundtrack = new Soundtrack();
		
		soundtrack.setName(root.get("name").asText());
		soundtrack.setMusician(root.get("musician").asText());
		
		Series incomingSeries = seriesRepository
				.findById(Integer.valueOf(root.get("seriesId").asText()))
				.orElseThrow(() -> new IllegalStateException(
						"The Id passed is not associated to any series."
				));
		
		soundtrack.setSeriesId(incomingSeries);
		
		return soundtrack;
	}

}
