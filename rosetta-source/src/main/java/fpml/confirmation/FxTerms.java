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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.FxFixing;
import fpml.confirmation.FxFixing.FxFixingBuilder;
import fpml.confirmation.FxFixing.FxFixingBuilderImpl;
import fpml.confirmation.FxFixing.FxFixingImpl;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.FxTerms;
import fpml.confirmation.FxTerms.FxTermsBuilder;
import fpml.confirmation.FxTerms.FxTermsBuilderImpl;
import fpml.confirmation.FxTerms.FxTermsImpl;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxTermsMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure which specifies FX conversion terms.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTerms", builder=FxTerms.FxTermsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTerms extends FxFixing {

	FxTermsMeta metaData = new FxTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
	 */
	BigDecimal getRate();

	/*********************** Build Methods  ***********************/
	FxTerms build();
	
	FxTerms.FxTermsBuilder toBuilder();
	
	static FxTerms.FxTermsBuilder builder() {
		return new FxTerms.FxTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTerms> getType() {
		return FxTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.class, getFxSpotRateSource());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTermsBuilder extends FxTerms, FxFixing.FxFixingBuilder {
		FxTerms.FxTermsBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxTerms.FxTermsBuilder setFixingDate(Date fixingDate);
		FxTerms.FxTermsBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource);
		FxTerms.FxTermsBuilder setRate(BigDecimal rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFxSpotRateSource());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		FxTerms.FxTermsBuilder prune();
	}

	/*********************** Immutable Implementation of FxTerms  ***********************/
	class FxTermsImpl extends FxFixing.FxFixingImpl implements FxTerms {
		private final BigDecimal rate;
		
		protected FxTermsImpl(FxTerms.FxTermsBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public FxTerms build() {
			return this;
		}
		
		@Override
		public FxTerms.FxTermsBuilder toBuilder() {
			FxTerms.FxTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTerms.FxTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTerms _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTerms {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTerms  ***********************/
	class FxTermsBuilderImpl extends FxFixing.FxFixingBuilderImpl  implements FxTerms.FxTermsBuilder {
	
		protected BigDecimal rate;
	
		public FxTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxTerms.FxTermsBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public FxTerms.FxTermsBuilder setFixingDate(Date fixingDate) {
			this.fixingDate = fixingDate==null?null:fixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxTerms.FxTermsBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource) {
			this.fxSpotRateSource = fxSpotRateSource==null?null:fxSpotRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public FxTerms.FxTermsBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		
		@Override
		public FxTerms build() {
			return new FxTerms.FxTermsImpl(this);
		}
		
		@Override
		public FxTerms.FxTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTerms.FxTermsBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTerms.FxTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTerms.FxTermsBuilder o = (FxTerms.FxTermsBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTerms _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTermsBuilder {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}
