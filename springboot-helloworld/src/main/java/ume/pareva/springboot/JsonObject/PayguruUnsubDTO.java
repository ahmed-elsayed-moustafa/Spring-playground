package ume.pareva.springboot.JsonObject;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Ahmed
 *
 *         This handles the main JSON response received from
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "response", "object" })
public class PayguruUnsubDTO implements Serializable{

	private static final long serialVersionUID = 1704157067127669699L;
	
	@JsonProperty("response")
	private Response response;
	@JsonProperty("object")
	private ObjectDTO objectdto;

	@JsonProperty("response")
	public Response getResponse() {
		return response;
	}

	@JsonProperty("response")
	public void setResponse(Response response) {
		this.response = response;
	}

	@JsonProperty("object")
	public ObjectDTO getObjectdto() {
		return objectdto;
	}

	@JsonProperty("object")
	public void setObjectdto(ObjectDTO objectdto) {
		this.objectdto = objectdto;
	}

	@Override
	public String toString() {
		return "PayguruUnsubDTO{" + "response=" + response + ", objectdto=" + objectdto + '}';
	}

}
