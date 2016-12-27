package com.cal.search.pojos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class CalActivitiesResp {
	
	private String subClassType;
	
	private String data;
	
	private String duration;
	
	private String level;
	
	private String messageClass;
	
	private String name;
	
	private String status;
	
	private Long timestamp;
	
	private String type;
	
	private List<CalActivitiesResp> calActivitesResp;

	public String getSubClassType() {
		return subClassType;
	}

	public void setSubClassType(String subClassType) {
		this.subClassType = subClassType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessageClass() {
		return messageClass;
	}

	public void setMessageClass(String messageClass) {
		this.messageClass = messageClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public List<CalActivitiesResp> getCalActivitesResp() {
		return calActivitesResp;
	}

	public void setCalActivitesResp(List<CalActivitiesResp> calActivitesResp) {
		this.calActivitesResp = calActivitesResp;
	}

	
}
