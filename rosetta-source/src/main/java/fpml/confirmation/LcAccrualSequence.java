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
import fpml.confirmation.FxTerms;
import fpml.confirmation.LcAccrualSequence;
import fpml.confirmation.LcAccrualSequence.LcAccrualSequenceBuilder;
import fpml.confirmation.LcAccrualSequence.LcAccrualSequenceBuilderImpl;
import fpml.confirmation.LcAccrualSequence.LcAccrualSequenceImpl;
import fpml.confirmation.meta.LcAccrualSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LcAccrualSequence", builder=LcAccrualSequence.LcAccrualSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LcAccrualSequence extends RosettaModelObject {

	LcAccrualSequenceMeta metaData = new LcAccrualSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which the letter of credit accrual is denominated. This field should ONLY be populated when the accrual currency is different to the base letter of credit currency.
	 */
	Currency getCurrency();
	/**
	 * Defines exchange rate between the letter of credit accrual and letter of credit currencies.
	 */
	FxTerms getLcFxRate();

	/*********************** Build Methods  ***********************/
	LcAccrualSequence build();
	
	LcAccrualSequence.LcAccrualSequenceBuilder toBuilder();
	
	static LcAccrualSequence.LcAccrualSequenceBuilder builder() {
		return new LcAccrualSequence.LcAccrualSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcAccrualSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcAccrualSequence> getType() {
		return LcAccrualSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.class, getLcFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcAccrualSequenceBuilder extends LcAccrualSequence, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		FxTerms.FxTermsBuilder getOrCreateLcFxRate();
		FxTerms.FxTermsBuilder getLcFxRate();
		LcAccrualSequence.LcAccrualSequenceBuilder setCurrency(Currency currency);
		LcAccrualSequence.LcAccrualSequenceBuilder setLcFxRate(FxTerms lcFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.FxTermsBuilder.class, getLcFxRate());
		}
		

		LcAccrualSequence.LcAccrualSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LcAccrualSequence  ***********************/
	class LcAccrualSequenceImpl implements LcAccrualSequence {
		private final Currency currency;
		private final FxTerms lcFxRate;
		
		protected LcAccrualSequenceImpl(LcAccrualSequence.LcAccrualSequenceBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.lcFxRate = ofNullable(builder.getLcFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("lcFxRate")
		public FxTerms getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		public LcAccrualSequence build() {
			return this;
		}
		
		@Override
		public LcAccrualSequence.LcAccrualSequenceBuilder toBuilder() {
			LcAccrualSequence.LcAccrualSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcAccrualSequence.LcAccrualSequenceBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getLcFxRate()).ifPresent(builder::setLcFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcAccrualSequence _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAccrualSequence {" +
				"currency=" + this.currency + ", " +
				"lcFxRate=" + this.lcFxRate +
			'}';
		}
	}

	/*********************** Builder Implementation of LcAccrualSequence  ***********************/
	class LcAccrualSequenceBuilderImpl implements LcAccrualSequence.LcAccrualSequenceBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected FxTerms.FxTermsBuilder lcFxRate;
	
		public LcAccrualSequenceBuilderImpl() {
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
		@RosettaAttribute("lcFxRate")
		public FxTerms.FxTermsBuilder getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateLcFxRate() {
			FxTerms.FxTermsBuilder result;
			if (lcFxRate!=null) {
				result = lcFxRate;
			}
			else {
				result = lcFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public LcAccrualSequence.LcAccrualSequenceBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lcFxRate")
		public LcAccrualSequence.LcAccrualSequenceBuilder setLcFxRate(FxTerms lcFxRate) {
			this.lcFxRate = lcFxRate==null?null:lcFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LcAccrualSequence build() {
			return new LcAccrualSequence.LcAccrualSequenceImpl(this);
		}
		
		@Override
		public LcAccrualSequence.LcAccrualSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAccrualSequence.LcAccrualSequenceBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (lcFxRate!=null && !lcFxRate.prune().hasData()) lcFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getLcFxRate()!=null && getLcFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAccrualSequence.LcAccrualSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LcAccrualSequence.LcAccrualSequenceBuilder o = (LcAccrualSequence.LcAccrualSequenceBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getLcFxRate(), o.getLcFxRate(), this::setLcFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcAccrualSequence _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAccrualSequenceBuilder {" +
				"currency=" + this.currency + ", " +
				"lcFxRate=" + this.lcFxRate +
			'}';
		}
	}
}
