package com.example.CodeJam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping(value = "/")
	public String Hello() {
		return "Hello World";
	}

}