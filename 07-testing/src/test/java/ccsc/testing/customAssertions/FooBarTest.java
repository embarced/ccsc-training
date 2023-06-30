package ccsc.testing.customAssertions;

import ccsc.testing.data.FooBar;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ccsc.testing.api.assertions.CustomAssertions;

public class FooBarTest {

	@Test
	@Disabled
	void testFooBar() {
		FooBar fooBar = new FooBar(true, false);

		CustomAssertions.assertThat(fooBar).isAProperFooBar();
	}
}
