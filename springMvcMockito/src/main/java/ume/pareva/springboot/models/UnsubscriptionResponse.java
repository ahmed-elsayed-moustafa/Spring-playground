package ume.pareva.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "unsubscriptionresponse")
@Entity(name = "unsubscriptionresponse")
public class UnsubscriptionResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "unsubID")
	private int unsubID;
	
	@Column(name = "responseStatus")
	private  String responseStatus;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "subID")
	private String subID;
	
	@Column(name = "service")
	private String service;
	
	@Column(name = "subDate")
	private String subDate;
	
	@Column(name = "cancelDate")
	private String cancelDate;
	
	@Column(name = "renewDate")
	private String renewDate;
	
	@Column(name = "subStatus")
	private String subStatus;
	
	@Column(name = "cancelSource")
	private String cancelSource;
	
	public UnsubscriptionResponse() {
		
	}

	 UnsubscriptionResponse(String responseStatus, String message, String subID, 
	            String service, String subDate, String cancelDate, String renewDate, String subStatus, String cancelSource) {
	        this.responseStatus=responseStatus;
	        this.message=message;
	        this.subID=subID;
	        this.service=service;
	        this.subDate=subDate;
	        this.cancelDate=cancelDate;
	        this.renewDate=renewDate;
	        this.subStatus=subStatus;
	        this.cancelSource=cancelSource;
	    }
	
	
	public int getUnsubID() {
		return unsubID;
	}
	public void setUnsubID(int unsubID) {
		this.unsubID = unsubID;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubID() {
		return subID;
	}
	public void setSubID(String subID) {
		this.subID = subID;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSubDate() {
		return subDate;
	}
	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getRenewDate() {
		return renewDate;
	}
	public void setRenewDate(String renewDate) {
		this.renewDate = renewDate;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	public String getCancelSource() {
		return cancelSource;
	}
	public void setCancelSource(String cancelSource) {
		this.cancelSource = cancelSource;
	}
	@Override
	public String toString() {
		return "UnsubscriptionResponse [unsubID=" + unsubID + ", responseStatus=" + responseStatus + ", message="
				+ message + ", subID=" + subID + ", service=" + service + ", subDate=" + subDate + ", cancelDate="
				+ cancelDate + ", renewDate=" + renewDate + ", subStatus=" + subStatus + ", cancelSource="
				+ cancelSource + "]";
	} 
	
}
