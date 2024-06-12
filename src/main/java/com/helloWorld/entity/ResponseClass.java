package com.helloWorld.entity;

import org.antlr.v4.runtime.misc.TestRig;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ResponseClass {
	public ResponseClass(Integer idInteger, String responseString) {
		super();
		this.idInteger = idInteger;
		this.responseString = responseString;
	}
	@Id
	private Integer idInteger;
	private String responseString;
	public Integer getIdInteger() {
		return idInteger;
	}
	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}
	public String getResponseString() {
		return responseString;
	}
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
}
