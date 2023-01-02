package org.banking.demo.misc;

import org.springframework.stereotype.Component;

/**
 * 
 * @author admin
 * Custom Error message
 //	Example -
//	{
//	    "timestamp": "2023-01-02T17:32:31.864+00:00",
//	    "status": 403,
//	    "error": "Forbidden",
//	    "message": "Forbidden",
//	    "path": "/account/raj2021/getByAccountNumber/8000145"
//	}
 */
@Component
public class Error {

	private String timestamp;
	private Integer status;
	private String error;
	private String messgae;
	private String path;
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	
}
