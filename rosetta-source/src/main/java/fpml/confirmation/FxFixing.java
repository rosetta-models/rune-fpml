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
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxFixingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate.
 * @version ${project.version}
 */
@RosettaDataType(value="FxFixing", builder=FxFixing.FxFixingBuilderImpl.class, version="${project.version}")
public interface FxFixing extends RosettaModelObject {

	FxFixingMeta metaData = new FxFixingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * Describes the specific date when a non-deliverable forward or cash-settled option will &quot;fix&quot; against a particular rate, which will be used to compute the ultimate cash settlement. This element should be omitted where a single, discrete fixing date cannot be identified e.g. on an american option, where fixing may occur at any date on a continuous range.
	 */
	Date getFixingDate();
	/**
	 * Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
	 */
	FxSpotRateSource getFxSpotRateSource();

	/*********************** Build Methods  ***********************/
	FxFixing build();
	
	FxFixing.FxFixingBuilder toBuilder();
	
	static FxFixing.FxFixingBuilder builder() {
		return new FxFixing.FxFixingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixing> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixing> getType() {
		return FxFixing.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.class, getFxSpotRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingBuilder extends FxFixing, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource();
		FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource();
		FxFixing.FxFixingBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxFixing.FxFixingBuilder setFixingDate(Date fixingDate);
		FxFixing.FxFixingBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFxSpotRateSource());
		}
		

		FxFixing.FxFixingBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixing  ***********************/
	class FxFixingImpl implements FxFixing {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final Date fixingDate;
		private final FxSpotRateSource fxSpotRateSource;
		
		protected FxFixingImpl(FxFixing.FxFixingBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.fixingDate = builder.getFixingDate();
			this.fxSpotRateSource = ofNullable(builder.getFxSpotRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxSpotRateSource getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public FxFixing build() {
			return this;
		}
		
		@Override
		public FxFixing.FxFixingBuilder toBuilder() {
			FxFixing.FxFixingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixing.FxFixingBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getFxSpotRateSource()).ifPresent(builder::setFxSpotRateSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixing _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixing {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixing  ***********************/
	class FxFixingBuilderImpl implements FxFixing.FxFixingBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected Date fixingDate;
		protected FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource;
	
		public FxFixingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (fxSpotRateSource!=null) {
				result = fxSpotRateSource;
			}
			else {
				result = fxSpotRateSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxFixing.FxFixingBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public FxFixing.FxFixingBuilder setFixingDate(Date fixingDate) {
			this.fixingDate = fixingDate==null?null:fixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxFixing.FxFixingBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource) {
			this.fxSpotRateSource = fxSpotRateSource==null?null:fxSpotRateSource.toBuilder();
			return this;
		}
		
		@Override
		public FxFixing build() {
			return new FxFixing.FxFixingImpl(this);
		}
		
		@Override
		public FxFixing.FxFixingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixing.FxFixingBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (fxSpotRateSource!=null && !fxSpotRateSource.prune().hasData()) fxSpotRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getFxSpotRateSource()!=null && getFxSpotRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixing.FxFixingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixing.FxFixingBuilder o = (FxFixing.FxFixingBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getFxSpotRateSource(), o.getFxSpotRateSource(), this::setFxSpotRateSource);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixing _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource +
			'}';
		}
	}
}
