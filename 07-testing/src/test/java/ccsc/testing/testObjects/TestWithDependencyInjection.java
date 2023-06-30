package ccsc.testing.testObjects;

import ccsc.testing.dto.OrderDto;
import ccsc.testing.service.NextGenerationOrderService;
import ccsc.testing.service.NextGenerationOrderService.OrderResult;
import ccsc.testing.user.Role;
import ccsc.testing.user.User;
import ccsc.testing.values.PartNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ccsc.testing.api.assertions.CustomAssertions;
import ccsc.testing.api.builder.ItemDtoBuilder;
import ccsc.testing.api.builder.OrderDtoBuilder;
import ccsc.testing.api.injection.TestUser;
import ccsc.testing.api.injection.UsesTestObjects;
import ccsc.testing.api.testobjects.TestObjects;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static ccsc.testing.api.injection.TestUser.UserType.ADMINISTRATOR;

@UsesTestObjects
public class TestWithDependencyInjection {

	@Test
	@DisplayName("Standard-User injizieren")
	void injectStandardUser(User user) {
		assertThat(user.getUsername()).isEqualTo(TestObjects.users().anyCustomer().getUsername());
		assertThat(user.getRole()).isEqualTo(Role.CUSTOMER);
	}

	@Test
	@DisplayName("Per Annotation spezifiziertes Testobjekt injizieren")
	void injectAdministratorUser(@TestUser(ADMINISTRATOR) User user) {
		assertThat(user.getRole()).isEqualTo(Role.ADMINISTRATOR);
	}

	@Test
	@DisplayName("Mehrere Testobjekte und Builder injizieren")
	void injectManyObjects(OrderDto order,
						  PartNumber partNumber,
						  ItemDtoBuilder itemDtoBuilder,
						  OrderDtoBuilder orderDtoBuilder) {

		itemDtoBuilder.withPartNumber(partNumber);
		orderDtoBuilder.withItems(singletonList(itemDtoBuilder.build()));

		NextGenerationOrderService service = new NextGenerationOrderService();

		OrderResult result =
				service.executeOrder(orderDtoBuilder.build());

		CustomAssertions.assertThat(result).wasSuccessful();
	}
}
