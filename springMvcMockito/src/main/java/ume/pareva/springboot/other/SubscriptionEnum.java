package ume.pareva.springboot.other;

public enum SubscriptionEnum {

	Msisdn(0), Txid(1), Service(2), Orderno(3), Subsid(4), BillingType(5), Status(6), Operator(7), xxQSxx(8);

	SubscriptionEnum(int index) {
		this.index = index;
	}

	private final int index;

	public int getIndex() {
		return index;
	}
}
