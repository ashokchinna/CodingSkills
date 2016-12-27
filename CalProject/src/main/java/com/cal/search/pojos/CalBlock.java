package com.cal.search.pojos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CalBlock {

	private List<CalBlockResp> calBlockResp;

	public List<CalBlockResp> getCalBlockResp() {
		return calBlockResp;
	}

	public void setCalBlockResp(List<CalBlockResp> calBlockResp) {
		this.calBlockResp = calBlockResp;
	}

	
	
	
	
	
}
