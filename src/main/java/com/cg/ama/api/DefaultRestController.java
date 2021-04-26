 
package com.cg.ama.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path="/")
public class DefaultRestController {
	
	@GetMapping
	public ResponseEntity<String> defaultAction() {
		return new ResponseEntity<>("Asset Management API v1", HttpStatus.OK);
	}
}