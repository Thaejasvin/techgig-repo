package com.techgig.challenge.worddictionary.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techgig.challenge.worddictionary.entity.Definition;

@RestController
public class RestDictController {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Definition definition;

	JSONParser jsonParser = new JSONParser();
	
	@GetMapping("/define/{word}")
	public Definition listDefinition(@PathVariable String word) {
		
		try {
			JSONObject obj = (JSONObject) jsonParser
					.parse(new BufferedReader(new InputStreamReader(new ClassPathResource("dict.json").getInputStream())));
			JSONArray ja = new JSONArray();
			ja.add(obj);
			for (Object o : ja) {
				JSONObject jo = (JSONObject) o;
				definition.setWord(word);
				definition.setDefinition(jo.get(word).toString());
			}

		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return definition;
	}

}
