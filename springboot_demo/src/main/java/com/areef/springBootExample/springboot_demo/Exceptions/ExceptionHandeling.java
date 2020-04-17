package com.areef.springBootExample.springboot_demo.Exceptions;

import java.util.Date;

public class ExceptionHandeling {

	private Date timeStamp;
	private String details;
	private String msssage;

	
	
	public ExceptionHandeling(Date timeStamp, String details, String msssage) {
		super();
		this.timeStamp = timeStamp;
		this.details = details;
		this.msssage = msssage;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setMsssage(String msssage) {
		this.msssage = msssage;
	}

}
