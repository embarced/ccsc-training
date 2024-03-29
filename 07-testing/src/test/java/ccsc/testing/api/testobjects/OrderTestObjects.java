package ccsc.testing.api.testobjects;

import ccsc.testing.api.builder.OrderDtoBuilder;
import ccsc.testing.dto.OrderDto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class OrderTestObjects {

	public OrderDto standardOrder() {
		return new OrderDto(TestObjects.users().anyCustomer(),
				"CO_10000",
				TestObjects.customerDetails().standardCustomer(),
				List.of(TestObjects.productData().items().standardItem()),
				null,
				"1",
				false,
				LocalDate.now(),
				Collections.emptyList());
	}

	public OrderDtoBuilder standardOrderBuilder() {
		return new OrderDtoBuilder();
	}
}
