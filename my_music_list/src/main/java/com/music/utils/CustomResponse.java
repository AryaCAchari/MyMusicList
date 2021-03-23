package com.music.utils;

import java.util.List;

public class CustomResponse {
	
	private Integer status;
	private String message;
	private Object data; 
	private List<Object> dataList;
	
	public CustomResponse(Integer status, Object data, String message) {		
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public CustomResponse(Integer status, List<Object> dataList, String message) {		
		this.status = status;
		this.message = message;
		this.dataList = dataList;
	}
	
	public CustomResponse(Integer status, Object data, List<Object> dataList, String message) {		
		this.status = status;
		this.message = message;
		this.data = data;
		this.dataList = dataList;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
}
