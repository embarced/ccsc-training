package ccsc.testing.api.builder;

import ccsc.testing.data.Address;

public class AddressOptionsObject {
	private String street = "Musterstraße 1";
	private String zipCode = "12345";
	private String city = "Musterstadt";

	public Address build() {
		return new Address(street, zipCode, city);
	}

	public AddressOptionsObject withStreet(String street) {
		this.street = street;
		return this;
	}

	public AddressOptionsObject withZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public AddressOptionsObject withCity(String city) {
		this.city = city;
		return this;
	}
}


