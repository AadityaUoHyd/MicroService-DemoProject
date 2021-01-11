package com.aadi.cloudGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return "User service is taking longer than expected. Please try again later.";
	}
	
	@GetMapping("/deptServiceFallBack")
	public String deptServiceFallBackMethod() {
		return "Department service is taking longer than expected. Please try again later.";
	}
}
