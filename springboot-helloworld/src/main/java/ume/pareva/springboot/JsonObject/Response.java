package ume.pareva.springboot.JsonObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Ahmed
 * 
 *         This reflects below JSON response from PDF 4.6.2. Un-subscription
 *         Service for Portal Deck
 * 
 *         { "response":{ "status":"RESPONSE STATUS CODE", "message":"RESPONSE
 *         DETAILED MESSAGE" }, "object"://
 * 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "message" })
public class Response {

	@JsonProperty("status")
	private static String status;
	@JsonProperty("message")
	private static String message;

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		Response.status = status;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		Response.message = message;
	}

	@Override
	public String toString() {
		return "Response{" + "status=" + status + ", message=" + message + '}';
	}

}
