package ccsc.testing.api.testobjects;

public class OrderDataTestObjectGroup {

	private final static OrderTestObjects orders;

	static {
		orders = new OrderTestObjects();
	}

	public OrderTestObjects orders() {
		return orders;
	}
}
