package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Address;
import fpml.confirmation.Address.AddressBuilder;
import fpml.confirmation.Address.AddressBuilderImpl;
import fpml.confirmation.Address.AddressImpl;
import fpml.confirmation.CountryCode;
import fpml.confirmation.StreetAddress;
import fpml.confirmation.meta.AddressMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that represents a physical postal address.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Address", builder=Address.AddressBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Address extends RosettaModelObject {

	AddressMeta metaData = new AddressMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The set of street and building number information that identifies a postal address within a city.
	 */
	StreetAddress getStreetAddress();
	/**
	 * The city component of a postal address.
	 */
	String getCity();
	/**
	 * A country subdivision used in postal addresses in some countries. For example, US states, Canadian provinces, Swiss cantons.
	 */
	String getState();
	/**
	 * The ISO 3166 standard code for the country within which the postal address is located.
	 */
	CountryCode getCountry();
	/**
	 * The code, required for computerised mail sorting systems, that is allocated to a physical address by a national postal authority.
	 */
	String getPostalCode();

	/*********************** Build Methods  ***********************/
	Address build();
	
	Address.AddressBuilder toBuilder();
	
	static Address.AddressBuilder builder() {
		return new Address.AddressBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Address> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Address> getType() {
		return Address.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("streetAddress"), processor, StreetAddress.class, getStreetAddress());
		processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
		processor.processBasic(path.newSubPath("state"), String.class, getState(), this);
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
		processor.processBasic(path.newSubPath("postalCode"), String.class, getPostalCode(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AddressBuilder extends Address, RosettaModelObjectBuilder {
		StreetAddress.StreetAddressBuilder getOrCreateStreetAddress();
		StreetAddress.StreetAddressBuilder getStreetAddress();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		CountryCode.CountryCodeBuilder getCountry();
		Address.AddressBuilder setStreetAddress(StreetAddress streetAddress);
		Address.AddressBuilder setCity(String city);
		Address.AddressBuilder setState(String state);
		Address.AddressBuilder setCountry(CountryCode country);
		Address.AddressBuilder setPostalCode(String postalCode);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("streetAddress"), processor, StreetAddress.StreetAddressBuilder.class, getStreetAddress());
			processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
			processor.processBasic(path.newSubPath("state"), String.class, getState(), this);
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
			processor.processBasic(path.newSubPath("postalCode"), String.class, getPostalCode(), this);
		}
		

		Address.AddressBuilder prune();
	}

	/*********************** Immutable Implementation of Address  ***********************/
	class AddressImpl implements Address {
		private final StreetAddress streetAddress;
		private final String city;
		private final String state;
		private final CountryCode country;
		private final String postalCode;
		
		protected AddressImpl(Address.AddressBuilder builder) {
			this.streetAddress = ofNullable(builder.getStreetAddress()).map(f->f.build()).orElse(null);
			this.city = builder.getCity();
			this.state = builder.getState();
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.postalCode = builder.getPostalCode();
		}
		
		@Override
		@RosettaAttribute("streetAddress")
		public StreetAddress getStreetAddress() {
			return streetAddress;
		}
		
		@Override
		@RosettaAttribute("city")
		public String getCity() {
			return city;
		}
		
		@Override
		@RosettaAttribute("state")
		public String getState() {
			return state;
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode getCountry() {
			return country;
		}
		
		@Override
		@RosettaAttribute("postalCode")
		public String getPostalCode() {
			return postalCode;
		}
		
		@Override
		public Address build() {
			return this;
		}
		
		@Override
		public Address.AddressBuilder toBuilder() {
			Address.AddressBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Address.AddressBuilder builder) {
			ofNullable(getStreetAddress()).ifPresent(builder::setStreetAddress);
			ofNullable(getCity()).ifPresent(builder::setCity);
			ofNullable(getState()).ifPresent(builder::setState);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getPostalCode()).ifPresent(builder::setPostalCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Address _that = getType().cast(o);
		
			if (!Objects.equals(streetAddress, _that.getStreetAddress())) return false;
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(postalCode, _that.getPostalCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (streetAddress != null ? streetAddress.hashCode() : 0);
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (postalCode != null ? postalCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Address {" +
				"streetAddress=" + this.streetAddress + ", " +
				"city=" + this.city + ", " +
				"state=" + this.state + ", " +
				"country=" + this.country + ", " +
				"postalCode=" + this.postalCode +
			'}';
		}
	}

	/*********************** Builder Implementation of Address  ***********************/
	class AddressBuilderImpl implements Address.AddressBuilder {
	
		protected StreetAddress.StreetAddressBuilder streetAddress;
		protected String city;
		protected String state;
		protected CountryCode.CountryCodeBuilder country;
		protected String postalCode;
	
		public AddressBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("streetAddress")
		public StreetAddress.StreetAddressBuilder getStreetAddress() {
			return streetAddress;
		}
		
		@Override
		public StreetAddress.StreetAddressBuilder getOrCreateStreetAddress() {
			StreetAddress.StreetAddressBuilder result;
			if (streetAddress!=null) {
				result = streetAddress;
			}
			else {
				result = streetAddress = StreetAddress.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("city")
		public String getCity() {
			return city;
		}
		
		@Override
		@RosettaAttribute("state")
		public String getState() {
			return state;
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode.CountryCodeBuilder getCountry() {
			return country;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateCountry() {
			CountryCode.CountryCodeBuilder result;
			if (country!=null) {
				result = country;
			}
			else {
				result = country = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postalCode")
		public String getPostalCode() {
			return postalCode;
		}
		
		@Override
		@RosettaAttribute("streetAddress")
		public Address.AddressBuilder setStreetAddress(StreetAddress streetAddress) {
			this.streetAddress = streetAddress==null?null:streetAddress.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("city")
		public Address.AddressBuilder setCity(String city) {
			this.city = city==null?null:city;
			return this;
		}
		@Override
		@RosettaAttribute("state")
		public Address.AddressBuilder setState(String state) {
			this.state = state==null?null:state;
			return this;
		}
		@Override
		@RosettaAttribute("country")
		public Address.AddressBuilder setCountry(CountryCode country) {
			this.country = country==null?null:country.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("postalCode")
		public Address.AddressBuilder setPostalCode(String postalCode) {
			this.postalCode = postalCode==null?null:postalCode;
			return this;
		}
		
		@Override
		public Address build() {
			return new Address.AddressImpl(this);
		}
		
		@Override
		public Address.AddressBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Address.AddressBuilder prune() {
			if (streetAddress!=null && !streetAddress.prune().hasData()) streetAddress = null;
			if (country!=null && !country.prune().hasData()) country = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStreetAddress()!=null && getStreetAddress().hasData()) return true;
			if (getCity()!=null) return true;
			if (getState()!=null) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			if (getPostalCode()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Address.AddressBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Address.AddressBuilder o = (Address.AddressBuilder) other;
			
			merger.mergeRosetta(getStreetAddress(), o.getStreetAddress(), this::setStreetAddress);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			
			merger.mergeBasic(getCity(), o.getCity(), this::setCity);
			merger.mergeBasic(getState(), o.getState(), this::setState);
			merger.mergeBasic(getPostalCode(), o.getPostalCode(), this::setPostalCode);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Address _that = getType().cast(o);
		
			if (!Objects.equals(streetAddress, _that.getStreetAddress())) return false;
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(postalCode, _that.getPostalCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (streetAddress != null ? streetAddress.hashCode() : 0);
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (postalCode != null ? postalCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AddressBuilder {" +
				"streetAddress=" + this.streetAddress + ", " +
				"city=" + this.city + ", " +
				"state=" + this.state + ", " +
				"country=" + this.country + ", " +
				"postalCode=" + this.postalCode +
			'}';
		}
	}
}
