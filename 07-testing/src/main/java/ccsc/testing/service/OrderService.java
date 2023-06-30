package ccsc.testing.service;

import ccsc.testing.dto.OrderDto;

public class OrderService {

	public boolean executeOrder(OrderDto order) {
		if (order == null) {
			return true;
		} else {
			return !order.customerDetails().hasOrderBlock();
		}
	}


}
