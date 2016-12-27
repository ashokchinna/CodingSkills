package com.cal.search.pojos;


import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CalBlockResp {

	private String subclasstype;
	
	private List<CalActivitiesResp> calActivitesResp;

	public String getSubclasstype() {
		return subclasstype;
	}

	public void setSubclasstype(String subclasstype) {
		this.subclasstype = subclasstype;
	}

	public List<CalActivitiesResp> getCalActivitesResp() {
		return calActivitesResp;
	}

	public void setCalActivitesResp(List<CalActivitiesResp> calActivitesResp) {
		this.calActivitesResp = calActivitesResp;
	}

		
	
	
}
