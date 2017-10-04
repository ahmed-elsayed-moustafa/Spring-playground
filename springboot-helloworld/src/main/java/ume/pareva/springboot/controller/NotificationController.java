package ume.pareva.springboot.controller;

import java.net.URI;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ume.pareva.springboot.JsonObject.PayguruUnsubDTO;
import ume.pareva.springboot.models.BillingNotification;
import ume.pareva.springboot.models.CredentialService;
import ume.pareva.springboot.models.SubscriptionNotification;
import ume.pareva.springboot.other.IncompleteServiceRequestException;
import ume.pareva.springboot.service.BillingNotificationService;
import ume.pareva.springboot.service.CredentialServiceService;
import ume.pareva.springboot.service.SubscriptionNotificationService;

@RequestMapping("/billing")
@RestController
public class NotificationController {

	public static final String unsubUrlhttp = "http://api.trend-tech.net/MicroPayment/cancel-subscription";
	public static final String unsubUrlhttps = "https://api.trend-tech.net/MicroPayment/cancel-subscription";

	@Autowired
	private BillingNotificationService bs;

	@Autowired
	private SubscriptionNotificationService ss;

	@Autowired
	private CredentialServiceService css;

	@RequestMapping(value = "/BillingNotification", method = RequestMethod.GET)
	public Object getParamatersBN(@RequestParam(value = "msisdn", required = true) String msisdn,
			@RequestParam("txId") String txid, @RequestParam(value = "status", required = true) String statusno,
			@RequestParam("operator") String operator, @RequestParam(value = "order", required = true) String orderno,
			@RequestParam("item") String item, @RequestParam("amount") String amount,
			@RequestParam(value = "service", required = true) String service, @RequestParam("error") String error,
			@RequestParam("errorDesc") String errorDesc,
			@RequestParam(value = "billingType", required = true) String billingType,
			@RequestParam(value = "subsId", required = true) String subsid, @RequestParam("xxQSxx") String xxQSxx)
			throws IncompleteServiceRequestException {

		BillingNotification billing = new BillingNotification(msisdn, txid, amount, service, orderno, item, subsid,
				error, errorDesc, billingType, statusno, operator, xxQSxx);

		// bs.add(billing)
		return billing.toString();
	}

	@RequestMapping(value = "/SubscriptionNotification", method = RequestMethod.GET)
	public String getParamaterSN(@RequestParam(value = "msisdn", required = true) String msisdn,
			@RequestParam("txId") String txid, @RequestParam(value = "status", required = true) String statusno,
			@RequestParam(value = "operator", required = true) String operator,
			@RequestParam(value = "order", required = true) String orderno, @RequestParam("service") String service,
			@RequestParam(value = "billingType", required = true) String billingType,
			@RequestParam(value = "subsId", required = true) String subsid, @RequestParam("xxQSxx") String xxQSxx)
			throws IncompleteServiceRequestException {

		SubscriptionNotification subscription = new SubscriptionNotification(msisdn, txid, orderno, subsid, service,
				billingType, statusno, operator, xxQSxx);

		// ss.add(subscription);
		return subscription.toString();
	}

	@RequestMapping(value = "/CredentialService", method = RequestMethod.GET)
	public String getParamaterSN(@RequestParam("subsId") String subsid, @RequestParam("trans_id") String trans_id,
			@RequestParam("securekey") String securekey) {

		CredentialService credential = new CredentialService(subsid, trans_id, securekey);

		JSONObject obj = credential.JSONResponse();
		return obj.toJSONString();
	}

	@RequestMapping(value = "/Unsubscription/{merchantId}/{serviceId}/{subscriptionId}", method = RequestMethod.GET)
	public PayguruUnsubDTO getParamater(@PathVariable(value = "merchantId") String merchantId,
			@PathVariable(value = "serviceId") String serviceId,
			@PathVariable(value = "subscriptionId") String subscriptionId) {
		URI uri = UriComponentsBuilder.fromUriString(unsubUrlhttp).path("/{user-details}")
				.buildAndExpand(merchantId + "/" + serviceId + "/" + subscriptionId).toUri();
		RestTemplate restTemplate = new RestTemplate();
		PayguruUnsubDTO response = restTemplate.getForObject(uri, PayguruUnsubDTO.class);
		return response;
	}

}
