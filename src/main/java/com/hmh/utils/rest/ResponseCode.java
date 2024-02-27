package com.hmh.utils.rest;

/**
 * 
 * @author Ranjeet
 *
 */

public enum ResponseCode {
	OK(200), 
	CREATED(201),
	NOCONTENT(204),
	SERVERERROR(503), 
	BADREQUEST(400),
	UNAUTHORIZED(401),
	FOREBIDDEN(403),
	NOTFOUND(404);
	
	private int statusCode;

	ResponseCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int code() {
		return statusCode;
	}
}
