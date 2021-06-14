// LkieyDTO.java

package com.webprj.project_green.dto;

public class GreenDtoLike {

	String userID;

	String userWriteTitle;

	String userIP;

	public String getUserID() {

		return userID;

	}

	public void setUserID(String userID) {

		this.userID = userID;

	}

	public String getUserWriteTitle() {

		return userWriteTitle;

	}

	public void setUserWriteTitle(String userWriteTitle) {

		this.userWriteTitle = userWriteTitle;

	}

	public String getUserIP() {

		return userIP;

	}

	public void setUserIP(String userIP) {

		this.userIP = userIP;

	}

	public GreenDtoLike(String userID, String userWriteTitle, String userIP) {

		super();

		this.userID = userID;

		this.userWriteTitle = userWriteTitle;

		this.userIP = userIP;

	}

}