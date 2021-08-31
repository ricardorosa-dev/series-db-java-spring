package com.DbRelations.Entities;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class EpisodeJsonDeserializer extends JsonDeserializer<Episode>{

	@Override
	public Episode deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectCodec codec = jsonParser.getCodec();
		JsonNode root = codec.readTree(jsonParser);
		
		System.out.println(root);
		
		return null;
	}

}
