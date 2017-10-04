package ume.pareva.springboot.models;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ume.pareva.springboot.other.IncompleteServiceRequestException;
import ume.pareva.springboot.other.BillingEnum;

@Table(name = "billingnotification")
@Entity(name = "billingnotification")
public class BillingNotification {

	@Id
	@Column(name = "Notification_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Notification_ID;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "txid")
	private String txid;

	@Column(name = "amount")
	private String amount;

	@Column(name = "service")
	private String service;

	@Column(name = "order_no")
	private String order_no;

	@Column(name = "item")
	private String item;

	@Column(name = "subsid")
	private String subsid;

	@Column(name = "errorCode")
	private String errorCode;

	@Column(name = "errorDescription")
	private String errorDescription;

	@Column(name = "billingtype")
	private String billingType;

	@Column(name = "status_no")
	private String status_no;

	@Column(name = "Operator")
	private String Operator;

	@Column(name = "querystring")
	private String QueryString;

	public BillingNotification() {
	}

	public BillingNotification(String... args) throws IncompleteServiceRequestException {
		if (Arrays.stream(args).anyMatch(x -> x.length() < 1)) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				if (args[i].length() < 1) {
					final int copy = i;
					Arrays.stream(BillingEnum.values()).filter(s -> copy == s.getIndex())
							.map(e -> e.name().toLowerCase() + ", ").forEach(builder::append);
				}
			}
			throw new IncompleteServiceRequestException(
					"Compulsory arguments missing: " + builder.toString().replaceAll(", $", ""));
		}
		this.msisdn = args[0];
		this.txid = args[1];
		this.amount = args[2];
		this.service = args[3];
		this.order_no = args[4];
		this.item = args[5];
		this.subsid = args[6];
		this.errorCode = args[7];
		this.errorDescription = args[8];
		this.billingType = args[9];
		this.status_no = args[10];
		this.Operator = args[11];
		this.QueryString = args[12];
	}

	public int getId() {
		return Notification_ID;
	}

	public void setId(int Notification_ID) {
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getOrderNo() {
		return order_no;
	}

	public void setOrderNo(String order_no) {
		this.order_no = order_no;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getSubsid() {
		return subsid;
	}

	public void setSubsid(String subsid) {
		this.subsid = subsid;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public String getStatus() {
		return status_no;
	}

	public void setStatus(String status_no) {
		this.status_no = status_no;
	}

	public String getOperator() {
		return Operator;
	}

	public void setOperator(String Operator) {
		this.Operator = Operator;
	}

	public String getXxQSxx() {
		return QueryString;
	}

	public void setXxQSxx(String QueryString) {
		this.QueryString = QueryString;
	}

	@Override
	public String toString() {
		return "BillingNotification [Notification_ID=" + Notification_ID + ", msisdn=" + msisdn + ", txid=" + txid
				+ ", amount=" + amount + ", service=" + service + ", order_no=" + order_no + ", item=" + item
				+ ", subsid=" + subsid + ", errorCode=" + errorCode + ", errorDescription=" + errorDescription
				+ ", billingType=" + billingType + ", status_no=" + status_no + ", Operator=" + Operator
				+ ", QueryString=" + QueryString + "]";
	}

}