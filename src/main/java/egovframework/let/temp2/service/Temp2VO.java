package egovframework.let.temp2.service;

import java.io.Serializable;

import egovframework.com.cmm.ComDefaultVO;

public class Temp2VO extends ComDefaultVO implements Serializable {
	
	//임시데이터id
	private String tempId;
	
	//임시데이터값
	private String tempVal;

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getTempVal() {
		return tempVal;
	}

	public void setTempVal(String tempVal) {
		this.tempVal = tempVal;
	}
	
	
}
