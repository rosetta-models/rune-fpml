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
import fpml.confirmation.FxFlexibleForwardRate;
import fpml.confirmation.FxFlexibleForwardRate.FxFlexibleForwardRateBuilder;
import fpml.confirmation.FxFlexibleForwardRate.FxFlexibleForwardRateBuilderImpl;
import fpml.confirmation.FxFlexibleForwardRate.FxFlexibleForwardRateImpl;
import fpml.confirmation.QuoteBasisEnum;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairBuilder;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairImpl;
import fpml.confirmation.meta.FxFlexibleForwardRateMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxFlexibleForwardRate", builder=FxFlexibleForwardRate.FxFlexibleForwardRateBuilderImpl.class, version="${project.version}")
public interface FxFlexibleForwardRate extends QuotedCurrencyPair {

	FxFlexibleForwardRateMeta metaData = new FxFlexibleForwardRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Constant rate value, applicable for the duration of the execution period.
	 */
	BigDecimal getRate();
	/**
	 * The spot exchange rate for the specified currency pair as per the specified quote basis, as at the trade date.
	 */
	BigDecimal getSpotRate();

	/*********************** Build Methods  ***********************/
	FxFlexibleForwardRate build();
	
	FxFlexibleForwardRate.FxFlexibleForwardRateBuilder toBuilder();
	
	static FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder() {
		return new FxFlexibleForwardRate.FxFlexibleForwardRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFlexibleForwardRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFlexibleForwardRate> getType() {
		return FxFlexibleForwardRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency1"), processor, Currency.class, getCurrency1());
		processRosetta(path.newSubPath("currency2"), processor, Currency.class, getCurrency2());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFlexibleForwardRateBuilder extends FxFlexibleForwardRate, QuotedCurrencyPair.QuotedCurrencyPairBuilder {
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency1(Currency currency1);
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency2(Currency currency2);
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setRate(BigDecimal rate);
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setSpotRate(BigDecimal spotRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency1"), processor, Currency.CurrencyBuilder.class, getCurrency1());
			processRosetta(path.newSubPath("currency2"), processor, Currency.CurrencyBuilder.class, getCurrency2());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		}
		

		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder prune();
	}

	/*********************** Immutable Implementation of FxFlexibleForwardRate  ***********************/
	class FxFlexibleForwardRateImpl extends QuotedCurrencyPair.QuotedCurrencyPairImpl implements FxFlexibleForwardRate {
		private final BigDecimal rate;
		private final BigDecimal spotRate;
		
		protected FxFlexibleForwardRateImpl(FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
			this.spotRate = builder.getSpotRate();
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		public FxFlexibleForwardRate build() {
			return this;
		}
		
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder toBuilder() {
			FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForwardRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardRate {" +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFlexibleForwardRate  ***********************/
	class FxFlexibleForwardRateBuilderImpl extends QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl  implements FxFlexibleForwardRate.FxFlexibleForwardRateBuilder {
	
		protected BigDecimal rate;
		protected BigDecimal spotRate;
	
		public FxFlexibleForwardRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("currency1")
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency1(Currency currency1) {
			this.currency1 = currency1==null?null:currency1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency2")
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency2(Currency currency2) {
			this.currency2 = currency2==null?null:currency2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quoteBasis")
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setQuoteBasis(QuoteBasisEnum quoteBasis) {
			this.quoteBasis = quoteBasis==null?null:quoteBasis;
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		
		@Override
		public FxFlexibleForwardRate build() {
			return new FxFlexibleForwardRate.FxFlexibleForwardRateImpl(this);
		}
		
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			if (getSpotRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxFlexibleForwardRate.FxFlexibleForwardRateBuilder o = (FxFlexibleForwardRate.FxFlexibleForwardRateBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForwardRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardRateBuilder {" +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate +
			'}' + " " + super.toString();
		}
	}
}
