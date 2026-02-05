package com.nelioalves.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

	public static String decodeParam (String text) {
		
		    return URLDecoder.decode(text, StandardCharsets.UTF_8);
	}
	
	
	public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
	    if (textDate == null || textDate.isBlank()) {
	        return defaultValue;
	    }

	    try {
	    	return LocalDate.parse(textDate, DateTimeFormatter.ISO_LOCAL_DATE);

	    } catch (DateTimeParseException e) {
	        return defaultValue;
	    }
	}

	
}
