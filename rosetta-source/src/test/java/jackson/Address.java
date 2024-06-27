package jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Address.AddressBuilder.class)
public class Address {
    private final int houseNumber;
    private final String street;

    public Address(int houseNumber, String street) {
        this.houseNumber = houseNumber;
        this.street = street;
    }

    @JsonProperty
    public int getHouseNumber() {
        return houseNumber;
    }

    @JsonProperty
    public String getStreet() {
        return street;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class AddressBuilder {
        private int houseNumber;
        private String street;

        @JsonProperty
        public AddressBuilder setHouseNumber(int houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        @JsonProperty
        public AddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        @JsonProperty
        public int getHouseNumber() {
            return houseNumber;
        }

        @JsonProperty
        public String getStreet() {
            return street;
        }

        public Address build() {
            return new Address(houseNumber, street);
        }
    }
}
