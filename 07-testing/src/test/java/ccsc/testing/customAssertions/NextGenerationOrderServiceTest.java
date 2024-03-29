package ccsc.testing.customAssertions;

import ccsc.testing.service.NextGenerationOrderService;
import ccsc.testing.service.NextGenerationOrderService.OrderResult;
import ccsc.testing.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ccsc.testing.api.assertions.CustomAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class NextGenerationOrderServiceTest {

	private NextGenerationOrderService service;

	@BeforeEach
	void setUp() {
		service = new NextGenerationOrderService();
	}

	@Test
	@DisplayName("Test mit assertTrue")
	void testSuccessfulOrder_withAssertTrue() {
		boolean orderSuccess = new OrderService().executeOrder(null);

		// Dieses Assert erschwert die Lesbarkeit.
		assertTrue(orderSuccess, "Order was not processed successfully.");
	}

	@Test
	@Disabled
	void testSuccessfulOrder() {
		OrderResult orderResult = service.executeOrder(null);

		EnumSet<OrderResult> successfulStates = EnumSet.of(
				OrderResult.SUCCESSFUL,
				OrderResult.SUCCESSFUL_PAYMENT_PENDING,
				OrderResult.SUCCESSFUL_PAID);

		// schlechte Lesbarkeit
		// Test muss Interna der Auftragsabwicklung kennen
		// es ist eine Beschreibung zum besseren Verständnis notwendig
		assertThat(successfulStates.contains(orderResult))
				.as("Order was placed successfully")
				.isTrue();
	}

	@Test
	@Disabled
	void testSuccessfulOrder_WithCustomAssertion() {
		OrderResult orderProcess = service.executeOrder(null);

		assertThat(orderProcess).wasSuccessful();
	}

	@Test
	void testFailedOrder_WithCustomAssertion() {
		OrderResult orderProcess = service.executeOrder(null);

		assertThat(orderProcess).hasFailed();
	}
}
