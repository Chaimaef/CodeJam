package com.example.CodeJam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

	@RequestMapping(value = "/hello")
	public String [] Hello() {
		String [] arr =   {"Hello World"};
		return arr;
	}
}