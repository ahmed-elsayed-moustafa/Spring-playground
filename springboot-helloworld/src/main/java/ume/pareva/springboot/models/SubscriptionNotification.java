package ume.pareva.springboot.models;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ume.pareva.springboot.other.BillingEnum;
import ume.pareva.springboot.other.IncompleteServiceRequestException;
import ume.pareva.springboot.other.SubscriptionEnum;

@Table(name = "subscriptionnotification")
@Entity(name = "subscriptionnotification")
public class SubscriptionNotification {

	@Id
	@GeneratedValue
	@Column(name = "Notification_ID")
	private int Notification_ID;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "txid")
	private String txid;

	@Column(name = "orderno")
	private String orderno;

	@Column(name = "subsid")
	private String subsid;

	@Column(name = "service")
	private String service;

	@Column(name = "billingType")
	private String billingType;

	@Column(name = "status")
	private String status;

	@Column(name = "operator")
	private String operator;

	@Column(name = "xxQSxx")
	private String xxQSxx;

	public SubscriptionNotification() {
	}

	public SubscriptionNotification(String... args) throws IncompleteServiceRequestException {
		if (Arrays.stream(args).anyMatch(x -> x.length() < 1)) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				if (args[i].length() < 1) {
					final int copy = i;
					Arrays.stream(SubscriptionEnum.values()).filter(s -> copy == s.getIndex())
							.map(e -> e.name().toLowerCase() + ", ").forEach(builder::append);
				}
			}
			throw new IncompleteServiceRequestException(
					"Compulsory arguments missing: " + builder.toString().replaceAll(", $", ""));
		}
		this.msisdn = args[0];
		this.txid = args[1];
		this.service = args[2];
		this.orderno = args[3];
		this.subsid = args[4];
		this.billingType = args[5];
		this.status = args[6];
		this.operator = args[7];
		this.xxQSxx = args[8];
	}

	public int getNotification_ID() {
		return Notification_ID;
	}

	public void setNotification_ID(int Notification_ID) {
		this.Notification_ID = Notification_ID;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getOrder() {
		return orderno;
	}

	public void setOrder(String orderno) {
		this.orderno = orderno;
	}

	public String getSubsid() {
		return subsid;
	}

	public void setSubsid(String subsid) {
		this.subsid = subsid;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getXxQSxx() {
		return xxQSxx;
	}

	public void setXxQSxx(String xxQSxx) {
		this.xxQSxx = xxQSxx;
	}

	@Override
	public String toString() {
		return "SubscriptionNotification [Notification_ID=" + Notification_ID + ", msisdn=" + msisdn + ", txid=" + txid
				+ ", orderno=" + orderno + ", subsid=" + subsid + ", service=" + service + ", billingType="
				+ billingType + ", status=" + status + ", operator=" + operator + ", xxQSxx=" + xxQSxx + "]";
	}

}