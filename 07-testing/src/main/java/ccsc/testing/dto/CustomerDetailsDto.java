package ccsc.testing.dto;

public record CustomerDetailsDto(String customerReference, boolean isPremium, boolean hasOrderBlock,
								 String countryOfOrigin) {
}