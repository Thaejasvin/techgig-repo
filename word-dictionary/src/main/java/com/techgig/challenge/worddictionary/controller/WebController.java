package com.techgig.challenge.worddictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String homePage() {
		return "index";
	}
}
