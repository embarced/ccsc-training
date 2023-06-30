package ccsc.testing.api.assertions;

import ccsc.testing.data.FooBar;
import ccsc.testing.service.NextGenerationOrderService.OrderResult;

public class CustomAssertions {

	public static OrderResultAssert assertThat(OrderResult actual) {
		return new OrderResultAssert(actual);
	}

	public static FooBarAssert assertThat(FooBar actual) {
		return new FooBarAssert(actual);
	}
}
