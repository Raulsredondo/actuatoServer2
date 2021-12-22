package com.bootcamp.actuator2.actuatoServer2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("/micro2")
public class Controller {

	private Counter counter;
	
	public Controller(MeterRegistry registry) {
		this.counter = Counter.builder("invocaciones.hello").description("Invocaciones totales").register(registry);
	}
	
	@GetMapping(path="/helloWorld")
	public String helloWord() {
		counter.increment();
		return "Hello World";
	}
}