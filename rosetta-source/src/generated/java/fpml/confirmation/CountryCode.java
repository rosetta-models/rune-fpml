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
import fpml.confirmation.CountryCode;
import fpml.confirmation.CountryCode.CountryCodeBuilder;
import fpml.confirmation.CountryCode.CountryCodeBuilderImpl;
import fpml.confirmation.CountryCode.CountryCodeImpl;
import fpml.confirmation.meta.CountryCodeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The code representation of a country or an area of special sovereignty. By default it is a valid 2 character country code as defined by the ISO standard 3166-1 alpha-2 - Codes for representation of countries http://www.niso.org/standards/resources/3166.html.
 * @version ${project.version}
 */
@RosettaDataType(value="CountryCode", builder=CountryCode.CountryCodeBuilderImpl.class, version="${project.version}")
public interface CountryCode extends RosettaModelObject {

	CountryCodeMeta metaData = new CountryCodeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCountryScheme();

	/*********************** Build Methods  ***********************/
	CountryCode build();
	
	CountryCode.CountryCodeBuilder toBuilder();
	
	static CountryCode.CountryCodeBuilder builder() {
		return new CountryCode.CountryCodeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CountryCode> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CountryCode> getType() {
		return CountryCode.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("countryScheme"), String.class, getCountryScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CountryCodeBuilder extends CountryCode, RosettaModelObjectBuilder {
		CountryCode.CountryCodeBuilder setValue(String value);
		CountryCode.CountryCodeBuilder setCountryScheme(String countryScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("countryScheme"), String.class, getCountryScheme(), this);
		}
		

		CountryCode.CountryCodeBuilder prune();
	}

	/*********************** Immutable Implementation of CountryCode  ***********************/
	class CountryCodeImpl implements CountryCode {
		private final String value;
		private final String countryScheme;
		
		protected CountryCodeImpl(CountryCode.CountryCodeBuilder builder) {
			this.value = builder.getValue();
			this.countryScheme = builder.getCountryScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("countryScheme")
		public String getCountryScheme() {
			return countryScheme;
		}
		
		@Override
		public CountryCode build() {
			return this;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder toBuilder() {
			CountryCode.CountryCodeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CountryCode.CountryCodeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCountryScheme()).ifPresent(builder::setCountryScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CountryCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(countryScheme, _that.getCountryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (countryScheme != null ? countryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CountryCode {" +
				"value=" + this.value + ", " +
				"countryScheme=" + this.countryScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CountryCode  ***********************/
	class CountryCodeBuilderImpl implements CountryCode.CountryCodeBuilder {
	
		protected String value;
		protected String countryScheme;
	
		public CountryCodeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("countryScheme")
		public String getCountryScheme() {
			return countryScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CountryCode.CountryCodeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("countryScheme")
		public CountryCode.CountryCodeBuilder setCountryScheme(String countryScheme) {
			this.countryScheme = countryScheme==null?null:countryScheme;
			return this;
		}
		
		@Override
		public CountryCode build() {
			return new CountryCode.CountryCodeImpl(this);
		}
		
		@Override
		public CountryCode.CountryCodeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CountryCode.CountryCodeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCountryScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CountryCode.CountryCodeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CountryCode.CountryCodeBuilder o = (CountryCode.CountryCodeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCountryScheme(), o.getCountryScheme(), this::setCountryScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CountryCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(countryScheme, _that.getCountryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (countryScheme != null ? countryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CountryCodeBuilder {" +
				"value=" + this.value + ", " +
				"countryScheme=" + this.countryScheme +
			'}';
		}
	}
}
