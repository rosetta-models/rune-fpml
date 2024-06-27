package jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Person.PersonBuilder.class)
public class Person {
    private final String name;
    private final int age;
    private final Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public int getAge() {
        return age;
    }

    @JsonProperty
    @JsonUnwrapped
    public Address getAddress() {
        return address;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class PersonBuilder {
        private String name;
        private int age;
        private Address address;

        @JsonProperty
        PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty
        PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        @JsonProperty
        @JsonUnwrapped
        PersonBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        @JsonProperty
        public String getName() {
            return name;
        }

        @JsonProperty
        public int getAge() {
            return age;
        }

        @JsonProperty
        public Address getAddress() {
            return address;
        }

        Person build() {
            return new Person(name, age, address);
        }
    }
}
