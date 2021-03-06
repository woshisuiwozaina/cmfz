package com.baizhi.entity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateSerilizer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator generator,
			SerializerProvider arg2) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String json = sdf.format(date);
		generator.writeString(json);

	}

}
