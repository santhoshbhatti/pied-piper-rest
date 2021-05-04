package com.pp.rest.versioning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.rest.versioning.vos.Name;
import com.pp.rest.versioning.vos.PersonV1;
import com.pp.rest.versioning.vos.PersonV2;

@RestController
public class VersioningController {
	@GetMapping("/v1/person")
	public PersonV1 uriVesioningV1() {
		return new PersonV1("Bob D'Nero");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 uriVesioningV2() {
		return new PersonV2(new Name("Bob", "D'nero"));
	}
	
	@GetMapping(value="/person/param",params = "version=1")
	public PersonV1 paramVersioningV1() {
		return new PersonV1("Bob D'nero");
	}
	
	@GetMapping(value="/person/param",params = "version=2")
	public PersonV2 paramVersioningV2() {
		return new PersonV2(new Name("Bob", "D'nero"));
	}
	
	@GetMapping(value="/person/header",headers ={"version=1"})
	public PersonV1 headerVersioningV1() {
		return new PersonV1("Bob D'nero");
	}
	
	@GetMapping(value="/person/header",headers = {"version=2"})
	public PersonV2 headerVersioningV2() {
		return new PersonV2(new Name("Bob", "D'nero"));
	}
	
	@GetMapping(value="/person/mimetype",produces ="application/vnd.company.app-v1+json" )
	public PersonV1 mimeVersioningV1() {
		return new PersonV1("Bob D'nero");
	}
	
	@GetMapping(value="/person/mimetype",produces = "application/vnd.company.app-v2+json")
	public PersonV2 mimeVersioningV2() {
		return new PersonV2(new Name("Bob", "D'nero"));
	}
	
}
