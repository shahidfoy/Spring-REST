package com.shahidfoy.springrest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	// GET
	// URI - /hello-world
	// method - "Hello World"
	// @RequestMapping(method=RequestMethod.GET, path="/helloworld")
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	// helloworld-bean
	@GetMapping(path="/helloworld-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	// helloworld/path-variable/automotivemech
	@GetMapping(path="/helloworld/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s", name));
	}
	
	@GetMapping(path="/helloworld-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

}
