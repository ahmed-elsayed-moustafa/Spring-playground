package ume.pareva.springboot.JsonObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "service", "subscriptiondate", "cancellationdate", "renewaldate", "status",
		"cancellationSource" })

public class ObjectDTO {

	@JsonProperty("id")
	private static String id;
	@JsonProperty("service")
	private static String service;
	@JsonProperty("subscriptiondate")
	private static String subscriptiondate;
	@JsonProperty("cancellationdate")
	private static String cancellationdate;
	@JsonProperty("renewaldate")
	private static String renewaldate;
	@JsonProperty("status")
	private static String status;
	@JsonProperty("cancellationSource")
	private static String cancellationSource;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		ObjectDTO.id = id;
	}

	@JsonProperty("service")
	public String getService() {
		return service;
	}

	@JsonProperty("service")
	public void setService(String service) {
		ObjectDTO.service = service;
	}

	@JsonProperty("subscriptiondate")
	public String getSubscriptiondate() {
		return subscriptiondate;
	}

	@JsonProperty("subscriptiondate")
	public void setSubscriptiondate(String subscriptiondate) {
		ObjectDTO.subscriptiondate = subscriptiondate;
	}

	@JsonProperty("cancellationdate")
	public String getCancellationdate() {
		return cancellationdate;
	}

	@JsonProperty("cancellationdate")
	public void setCancellationdate(String cancellationdate) {
		ObjectDTO.cancellationdate = cancellationdate;
	}

	@JsonProperty("renewaldate")
	public String getRenewaldate() {
		return renewaldate;
	}

	@JsonProperty("renewaldate")
	public void setRenewaldate(String renewaldate) {
		ObjectDTO.renewaldate = renewaldate;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		ObjectDTO.status = status;
	}

	@JsonProperty("cancellationSource")
	public String getCancellationSource() {
		return cancellationSource;
	}

	@JsonProperty("cancellationSource")
	public void setCancellationSource(String cancellationSource) {
		ObjectDTO.cancellationSource = cancellationSource;
	}

	@Override
	public String toString() {
		return "ObjectDTO{" + "id=" + id + ", service=" + service + ", subscriptiondate=" + subscriptiondate
				+ ", cancellationdate=" + cancellationdate + ", renewaldate=" + renewaldate + ", status=" + status
				+ ", cancellationSource=" + cancellationSource + '}';
	}
}
