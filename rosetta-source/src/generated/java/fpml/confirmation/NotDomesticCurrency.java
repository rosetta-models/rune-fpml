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
import fpml.confirmation.NotDomesticCurrency;
import fpml.confirmation.NotDomesticCurrency.NotDomesticCurrencyBuilder;
import fpml.confirmation.NotDomesticCurrency.NotDomesticCurrencyBuilderImpl;
import fpml.confirmation.NotDomesticCurrency.NotDomesticCurrencyImpl;
import fpml.confirmation.meta.NotDomesticCurrencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotDomesticCurrency", builder=NotDomesticCurrency.NotDomesticCurrencyBuilderImpl.class, version="${project.version}")
public interface NotDomesticCurrency extends RosettaModelObject {

	NotDomesticCurrencyMeta metaData = new NotDomesticCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether the not domestic currency provision is applicable.
	 */
	Boolean getApplicable();
	/**
	 * An explicit specification of the domestic currency.
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	NotDomesticCurrency build();
	
	NotDomesticCurrency.NotDomesticCurrencyBuilder toBuilder();
	
	static NotDomesticCurrency.NotDomesticCurrencyBuilder builder() {
		return new NotDomesticCurrency.NotDomesticCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotDomesticCurrency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotDomesticCurrency> getType() {
		return NotDomesticCurrency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotDomesticCurrencyBuilder extends NotDomesticCurrency, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		NotDomesticCurrency.NotDomesticCurrencyBuilder setApplicable(Boolean applicable);
		NotDomesticCurrency.NotDomesticCurrencyBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		NotDomesticCurrency.NotDomesticCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of NotDomesticCurrency  ***********************/
	class NotDomesticCurrencyImpl implements NotDomesticCurrency {
		private final Boolean applicable;
		private final Currency currency;
		
		protected NotDomesticCurrencyImpl(NotDomesticCurrency.NotDomesticCurrencyBuilder builder) {
			this.applicable = builder.getApplicable();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public NotDomesticCurrency build() {
			return this;
		}
		
		@Override
		public NotDomesticCurrency.NotDomesticCurrencyBuilder toBuilder() {
			NotDomesticCurrency.NotDomesticCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotDomesticCurrency.NotDomesticCurrencyBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotDomesticCurrency _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotDomesticCurrency {" +
				"applicable=" + this.applicable + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of NotDomesticCurrency  ***********************/
	class NotDomesticCurrencyBuilderImpl implements NotDomesticCurrency.NotDomesticCurrencyBuilder {
	
		protected Boolean applicable;
		protected Currency.CurrencyBuilder currency;
	
		public NotDomesticCurrencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicable")
		public NotDomesticCurrency.NotDomesticCurrencyBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public NotDomesticCurrency.NotDomesticCurrencyBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public NotDomesticCurrency build() {
			return new NotDomesticCurrency.NotDomesticCurrencyImpl(this);
		}
		
		@Override
		public NotDomesticCurrency.NotDomesticCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotDomesticCurrency.NotDomesticCurrencyBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotDomesticCurrency.NotDomesticCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotDomesticCurrency.NotDomesticCurrencyBuilder o = (NotDomesticCurrency.NotDomesticCurrencyBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotDomesticCurrency _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotDomesticCurrencyBuilder {" +
				"applicable=" + this.applicable + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
