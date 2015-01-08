public class Service extends Item {
	Double price;
	ServicePaymentTypes paymentType;

	Service(String name, String description, Double price,
			ServicePaymentTypes paymentType) {
		super(name, description);
		this.price = price;
		this.paymentType = paymentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printItem() {
		System.out.print("[ Name: " + super.name + ", Description: "
				+ super.description + ", Price: " + price + ", PaymentType: "
				+ paymentType + "]");

	}
}
