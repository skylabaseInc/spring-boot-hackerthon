package com.example.demo.dto.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ErrorDetail {
	private String title;
	private int status;
	private String datail;
	private long timeStamp;
	private String path;
	private String developerMessage;
	private Map<String ,List<ValidationError>> errors = new HashMap<String,List<ValidationError>>();
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int i) {
		this.status = i;
	}
	public String getDatail() {
		return datail;
	}
	public void setDatail(String datail) {
		this.datail = datail;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long l) {
		this.timeStamp = l;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	public Map<String, List<ValidationError>> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, List<ValidationError>> errors) {
		this.errors = errors;
	}
	public void setDetail(String message) {
		// TODO Auto-generated method stub
		
	}

	
}
