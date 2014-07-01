package com.coderme.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class RestService {

	@Path("/test")
	@GET
	public String test() {
		return "SUCCESS";
	}
}
