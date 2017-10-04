package ume.pareva.springboot.other;

public enum BillingEnum{

	Msisdn(0), Txid(1), Amount(2), Service(3), Order_no(4), Item(5), Subsid(6), ErrorCode(7), ErrorDescription(
			8), BillingType(9), Status_no(10), Operator(11), QueryString(12);

	BillingEnum(int index) {
		this.index = index;
	}

	private final int index;

	public int getIndex() {
		return index;
	}
}
