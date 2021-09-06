package com.DbRelations.Entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

import com.DbRelations.Repository.SeriesRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ActorJsonDeserializer extends JsonDeserializer<Actor> {
	
	private final SeriesRepository seriesRepository;
	
	@Autowired
	public ActorJsonDeserializer(SeriesRepository seriesRepository) {
		this.seriesRepository = seriesRepository;
	}

	@Override
	public Actor deserialize(JsonParser jsonParser, DeserializationContext context) 
			throws IOException, JsonProcessingException {
		
		ObjectCodec codec = jsonParser.getCodec();
		JsonNode root = codec.readTree(jsonParser);
		
		Actor actor = new Actor();
		
		actor.setName(root.get("name").asText());
		actor.setRole(root.get("role").asText());
		actor.setActiveSince(root.get("activeSince").asInt());
		
		final String json = root.get("seriesId").asText();
		JsonNode arrNode = new ObjectMapper().readTree(json);
		
		// Crio uma lista e jogo cada serie aqui dentro
		List<Series> allSeries = new ArrayList<>();
		
		for (JsonNode objNode : arrNode) {
//			System.out.println(objNode);
			Series incomingSeries = seriesRepository
					.findById(Integer.valueOf(objNode.asText()))
					.orElseThrow(() -> new IllegalStateException(
							"The Id passed is not associated to any series."
					));
			allSeries.add(incomingSeries);
		}
		
		//Agora seto o seriesId como a Lista criada
		actor.setSeries(allSeries);
		
		return actor;
	}

}
