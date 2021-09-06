//package com.DbRelations.Entities;
//
//import java.io.IOException;
//
//import org.springframework.boot.jackson.JsonComponent;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
//@JsonComponent
//public class SeriesJsonSerializer extends JsonSerializer<Series>{
//
//	@Override
//	public void serialize(Series series, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
//		
//		System.out.println(series);
//		
//		jsonGenerator.writeStartObject();
////		jsonGenerator.writeEmbeddedObject(series);
//		
//		jsonGenerator.writeNumberField("id", series.getId());
//		jsonGenerator.writeStringField("name", series.getName());
//		jsonGenerator.writeNumberField("numberOfSeasons", series.getNumberOfSeasons());
//		jsonGenerator.writeNumberField("releaseDate", series.getReleaseDate());
//		jsonGenerator.writeStringField("studio", series.getStudio());
//		
//		if (series.getSoundtrack() != null) {
//			System.out.println("tem soundtrack");
////			jsonGenerator.writeNumberField("soundtrackId", getSoundtrackId(series.getSoundtrack()));
//			jsonGenerator.writeNumberField("soundtrackId", series.getSoundtrack().getId());
//		}
//		
//		
//		jsonGenerator.writeEndObject();
//		
////		 Tá dando um errão. Ve isso aqui.
//	}
//	
////	private static int getSoundtrackId(Soundtrack soundtrack) {
////		int id = soundtrack.getId();
////		
////		return id;
////	}
//
//}
