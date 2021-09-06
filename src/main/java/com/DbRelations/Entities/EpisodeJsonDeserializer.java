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

public class EpisodeJsonDeserializer extends JsonDeserializer<Episode>{
	
	private final SeriesRepository seriesRepository;
	
	@Autowired
	public EpisodeJsonDeserializer(SeriesRepository seriesRepository) {
		this.seriesRepository = seriesRepository;
	}

	@Override
	public Episode deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		
		ObjectCodec codec = jsonParser.getCodec();
		JsonNode root = codec.readTree(jsonParser);
		
//		System.out.println(root);
		
		Episode episode = new Episode();
		
		episode.setSeason(root.get("season").asInt());
		episode.setEpisodeNumber(root.get("episodeNumber").asInt());
		episode.setName(root.get("name").asText());
		episode.setSummary(root.get("summary").asText());
		
		Series incomingSeries = seriesRepository
				.findById(Integer.valueOf(root.get("seriesId").asText()))
				.orElseThrow(() -> new IllegalStateException(
						"The Id passed is not associated to any series."
				));
		
		episode.setSeriesId(incomingSeries);
		
		return episode;
	}

}
