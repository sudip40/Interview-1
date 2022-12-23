package com.sudip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sudip.model.EC;
import com.sudip.model.Entries;

@RestController
public class ProjectController {

	@GetMapping("/entries")
	public ResponseEntity<Entries[]> entries(){
		String uri="https://api.publicapis.org/entries";
		RestTemplate rt=new RestTemplate();
		EC ec=rt.getForObject(uri,EC.class);
		Entries[] ents=ec.getEntries();
		return new ResponseEntity<Entries[]>(ents,HttpStatus.OK);
	}
}
