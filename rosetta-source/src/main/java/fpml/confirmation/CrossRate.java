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
import fpml.confirmation.CrossRate;
import fpml.confirmation.CrossRate.CrossRateBuilder;
import fpml.confirmation.CrossRate.CrossRateBuilderImpl;
import fpml.confirmation.CrossRate.CrossRateImpl;
import fpml.confirmation.CrossRateSequence;
import fpml.confirmation.Currency;
import fpml.confirmation.QuoteBasisEnum;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairBuilder;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairImpl;
import fpml.confirmation.meta.CrossRateMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that is used for including the currency exchange rates used to cross between the traded currencies for non-base currency FX contracts.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CrossRate", builder=CrossRate.CrossRateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CrossRate extends QuotedCurrencyPair {

	CrossRateMeta metaData = new CrossRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The exchange rate used to cross between the traded currencies.
	 */
	BigDecimal getRate();
	CrossRateSequence getCrossRateSequence();

	/*********************** Build Methods  ***********************/
	CrossRate build();
	
	CrossRate.CrossRateBuilder toBuilder();
	
	static CrossRate.CrossRateBuilder builder() {
		return new CrossRate.CrossRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CrossRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CrossRate> getType() {
		return CrossRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency1"), processor, Currency.class, getCurrency1());
		processRosetta(path.newSubPath("currency2"), processor, Currency.class, getCurrency2());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("crossRateSequence"), processor, CrossRateSequence.class, getCrossRateSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CrossRateBuilder extends CrossRate, QuotedCurrencyPair.QuotedCurrencyPairBuilder {
		CrossRateSequence.CrossRateSequenceBuilder getOrCreateCrossRateSequence();
		CrossRateSequence.CrossRateSequenceBuilder getCrossRateSequence();
		CrossRate.CrossRateBuilder setCurrency1(Currency currency1);
		CrossRate.CrossRateBuilder setCurrency2(Currency currency2);
		CrossRate.CrossRateBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		CrossRate.CrossRateBuilder setRate(BigDecimal rate);
		CrossRate.CrossRateBuilder setCrossRateSequence(CrossRateSequence crossRateSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency1"), processor, Currency.CurrencyBuilder.class, getCurrency1());
			processRosetta(path.newSubPath("currency2"), processor, Currency.CurrencyBuilder.class, getCurrency2());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("crossRateSequence"), processor, CrossRateSequence.CrossRateSequenceBuilder.class, getCrossRateSequence());
		}
		

		CrossRate.CrossRateBuilder prune();
	}

	/*********************** Immutable Implementation of CrossRate  ***********************/
	class CrossRateImpl extends QuotedCurrencyPair.QuotedCurrencyPairImpl implements CrossRate {
		private final BigDecimal rate;
		private final CrossRateSequence crossRateSequence;
		
		protected CrossRateImpl(CrossRate.CrossRateBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
			this.crossRateSequence = ofNullable(builder.getCrossRateSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("crossRateSequence")
		public CrossRateSequence getCrossRateSequence() {
			return crossRateSequence;
		}
		
		@Override
		public CrossRate build() {
			return this;
		}
		
		@Override
		public CrossRate.CrossRateBuilder toBuilder() {
			CrossRate.CrossRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CrossRate.CrossRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getCrossRateSequence()).ifPresent(builder::setCrossRateSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CrossRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(crossRateSequence, _that.getCrossRateSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (crossRateSequence != null ? crossRateSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CrossRate {" +
				"rate=" + this.rate + ", " +
				"crossRateSequence=" + this.crossRateSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CrossRate  ***********************/
	class CrossRateBuilderImpl extends QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl  implements CrossRate.CrossRateBuilder {
	
		protected BigDecimal rate;
		protected CrossRateSequence.CrossRateSequenceBuilder crossRateSequence;
	
		public CrossRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("crossRateSequence")
		public CrossRateSequence.CrossRateSequenceBuilder getCrossRateSequence() {
			return crossRateSequence;
		}
		
		@Override
		public CrossRateSequence.CrossRateSequenceBuilder getOrCreateCrossRateSequence() {
			CrossRateSequence.CrossRateSequenceBuilder result;
			if (crossRateSequence!=null) {
				result = crossRateSequence;
			}
			else {
				result = crossRateSequence = CrossRateSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency1")
		public CrossRate.CrossRateBuilder setCurrency1(Currency currency1) {
			this.currency1 = currency1==null?null:currency1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency2")
		public CrossRate.CrossRateBuilder setCurrency2(Currency currency2) {
			this.currency2 = currency2==null?null:currency2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quoteBasis")
		public CrossRate.CrossRateBuilder setQuoteBasis(QuoteBasisEnum quoteBasis) {
			this.quoteBasis = quoteBasis==null?null:quoteBasis;
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public CrossRate.CrossRateBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("crossRateSequence")
		public CrossRate.CrossRateBuilder setCrossRateSequence(CrossRateSequence crossRateSequence) {
			this.crossRateSequence = crossRateSequence==null?null:crossRateSequence.toBuilder();
			return this;
		}
		
		@Override
		public CrossRate build() {
			return new CrossRate.CrossRateImpl(this);
		}
		
		@Override
		public CrossRate.CrossRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossRate.CrossRateBuilder prune() {
			super.prune();
			if (crossRateSequence!=null && !crossRateSequence.prune().hasData()) crossRateSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			if (getCrossRateSequence()!=null && getCrossRateSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossRate.CrossRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CrossRate.CrossRateBuilder o = (CrossRate.CrossRateBuilder) other;
			
			merger.mergeRosetta(getCrossRateSequence(), o.getCrossRateSequence(), this::setCrossRateSequence);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CrossRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(crossRateSequence, _that.getCrossRateSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (crossRateSequence != null ? crossRateSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CrossRateBuilder {" +
				"rate=" + this.rate + ", " +
				"crossRateSequence=" + this.crossRateSequence +
			'}' + " " + super.toString();
		}
	}
}
