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
import fpml.confirmation.Currency;
import fpml.confirmation.Currency.CurrencyBuilder;
import fpml.confirmation.Currency.CurrencyBuilderImpl;
import fpml.confirmation.Currency.CurrencyImpl;
import fpml.confirmation.meta.CurrencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The code representation of a currency or fund. By default it is a valid currency code as defined by the ISO standard 4217 - Codes for representation of currencies and funds http://www.iso.org/iso/en/prods-services/popstds/currencycodeslist.html.
 * @version ${project.version}
 */
@RosettaDataType(value="Currency", builder=Currency.CurrencyBuilderImpl.class, version="${project.version}")
public interface Currency extends RosettaModelObject {

	CurrencyMeta metaData = new CurrencyMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCurrencyScheme();

	/*********************** Build Methods  ***********************/
	Currency build();
	
	Currency.CurrencyBuilder toBuilder();
	
	static Currency.CurrencyBuilder builder() {
		return new Currency.CurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Currency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Currency> getType() {
		return Currency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("currencyScheme"), String.class, getCurrencyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CurrencyBuilder extends Currency, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder setValue(String value);
		Currency.CurrencyBuilder setCurrencyScheme(String currencyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("currencyScheme"), String.class, getCurrencyScheme(), this);
		}
		

		Currency.CurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of Currency  ***********************/
	class CurrencyImpl implements Currency {
		private final String value;
		private final String currencyScheme;
		
		protected CurrencyImpl(Currency.CurrencyBuilder builder) {
			this.value = builder.getValue();
			this.currencyScheme = builder.getCurrencyScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("currencyScheme")
		public String getCurrencyScheme() {
			return currencyScheme;
		}
		
		@Override
		public Currency build() {
			return this;
		}
		
		@Override
		public Currency.CurrencyBuilder toBuilder() {
			Currency.CurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Currency.CurrencyBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCurrencyScheme()).ifPresent(builder::setCurrencyScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Currency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(currencyScheme, _that.getCurrencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (currencyScheme != null ? currencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Currency {" +
				"value=" + this.value + ", " +
				"currencyScheme=" + this.currencyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Currency  ***********************/
	class CurrencyBuilderImpl implements Currency.CurrencyBuilder {
	
		protected String value;
		protected String currencyScheme;
	
		public CurrencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("currencyScheme")
		public String getCurrencyScheme() {
			return currencyScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public Currency.CurrencyBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("currencyScheme")
		public Currency.CurrencyBuilder setCurrencyScheme(String currencyScheme) {
			this.currencyScheme = currencyScheme==null?null:currencyScheme;
			return this;
		}
		
		@Override
		public Currency build() {
			return new Currency.CurrencyImpl(this);
		}
		
		@Override
		public Currency.CurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Currency.CurrencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCurrencyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Currency.CurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Currency.CurrencyBuilder o = (Currency.CurrencyBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCurrencyScheme(), o.getCurrencyScheme(), this::setCurrencyScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Currency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(currencyScheme, _that.getCurrencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (currencyScheme != null ? currencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyBuilder {" +
				"value=" + this.value + ", " +
				"currencyScheme=" + this.currencyScheme +
			'}';
		}
	}
}
