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
import fpml.confirmation.FxAverageRateObservation;
import fpml.confirmation.FxAverageRateObservation.FxAverageRateObservationBuilder;
import fpml.confirmation.FxAverageRateObservation.FxAverageRateObservationBuilderImpl;
import fpml.confirmation.FxAverageRateObservation.FxAverageRateObservationImpl;
import fpml.confirmation.meta.FxAverageRateObservationMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that, for average rate options, is used to describe each specific observation date, as opposed to a parametric frequency of rate observations.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAverageRateObservation", builder=FxAverageRateObservation.FxAverageRateObservationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAverageRateObservation extends RosettaModelObject {

	FxAverageRateObservationMeta metaData = new FxAverageRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A specific date for which an observation against a particular rate will be made and will be used for subsequent computations.
	 */
	Date getDate();
	/**
	 * An optional factor that can be used for weighting certain observation dates. Typically, firms will weight each date with a factor of 1 if there are standard, unweighted adjustments.
	 */
	BigDecimal getAverageRateWeightingFactor();
	/**
	 * The observed rate of exchange between the two option currencies. In the absence of rateObservationQuoteBasis, the rate is assumed to be quoted as per option strike/strikeQuoteBasis.
	 */
	BigDecimal getRate();

	/*********************** Build Methods  ***********************/
	FxAverageRateObservation build();
	
	FxAverageRateObservation.FxAverageRateObservationBuilder toBuilder();
	
	static FxAverageRateObservation.FxAverageRateObservationBuilder builder() {
		return new FxAverageRateObservation.FxAverageRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAverageRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAverageRateObservation> getType() {
		return FxAverageRateObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("averageRateWeightingFactor"), BigDecimal.class, getAverageRateWeightingFactor(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAverageRateObservationBuilder extends FxAverageRateObservation, RosettaModelObjectBuilder {
		FxAverageRateObservation.FxAverageRateObservationBuilder setDate(Date date);
		FxAverageRateObservation.FxAverageRateObservationBuilder setAverageRateWeightingFactor(BigDecimal averageRateWeightingFactor);
		FxAverageRateObservation.FxAverageRateObservationBuilder setRate(BigDecimal rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("averageRateWeightingFactor"), BigDecimal.class, getAverageRateWeightingFactor(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		FxAverageRateObservation.FxAverageRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of FxAverageRateObservation  ***********************/
	class FxAverageRateObservationImpl implements FxAverageRateObservation {
		private final Date date;
		private final BigDecimal averageRateWeightingFactor;
		private final BigDecimal rate;
		
		protected FxAverageRateObservationImpl(FxAverageRateObservation.FxAverageRateObservationBuilder builder) {
			this.date = builder.getDate();
			this.averageRateWeightingFactor = builder.getAverageRateWeightingFactor();
			this.rate = builder.getRate();
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("averageRateWeightingFactor")
		public BigDecimal getAverageRateWeightingFactor() {
			return averageRateWeightingFactor;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public FxAverageRateObservation build() {
			return this;
		}
		
		@Override
		public FxAverageRateObservation.FxAverageRateObservationBuilder toBuilder() {
			FxAverageRateObservation.FxAverageRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAverageRateObservation.FxAverageRateObservationBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getAverageRateWeightingFactor()).ifPresent(builder::setAverageRateWeightingFactor);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAverageRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(averageRateWeightingFactor, _that.getAverageRateWeightingFactor())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (averageRateWeightingFactor != null ? averageRateWeightingFactor.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRateObservation {" +
				"date=" + this.date + ", " +
				"averageRateWeightingFactor=" + this.averageRateWeightingFactor + ", " +
				"rate=" + this.rate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAverageRateObservation  ***********************/
	class FxAverageRateObservationBuilderImpl implements FxAverageRateObservation.FxAverageRateObservationBuilder {
	
		protected Date date;
		protected BigDecimal averageRateWeightingFactor;
		protected BigDecimal rate;
	
		public FxAverageRateObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("averageRateWeightingFactor")
		public BigDecimal getAverageRateWeightingFactor() {
			return averageRateWeightingFactor;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("date")
		public FxAverageRateObservation.FxAverageRateObservationBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("averageRateWeightingFactor")
		public FxAverageRateObservation.FxAverageRateObservationBuilder setAverageRateWeightingFactor(BigDecimal averageRateWeightingFactor) {
			this.averageRateWeightingFactor = averageRateWeightingFactor==null?null:averageRateWeightingFactor;
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public FxAverageRateObservation.FxAverageRateObservationBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		
		@Override
		public FxAverageRateObservation build() {
			return new FxAverageRateObservation.FxAverageRateObservationImpl(this);
		}
		
		@Override
		public FxAverageRateObservation.FxAverageRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRateObservation.FxAverageRateObservationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getAverageRateWeightingFactor()!=null) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRateObservation.FxAverageRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAverageRateObservation.FxAverageRateObservationBuilder o = (FxAverageRateObservation.FxAverageRateObservationBuilder) other;
			
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getAverageRateWeightingFactor(), o.getAverageRateWeightingFactor(), this::setAverageRateWeightingFactor);
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAverageRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(averageRateWeightingFactor, _that.getAverageRateWeightingFactor())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (averageRateWeightingFactor != null ? averageRateWeightingFactor.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRateObservationBuilder {" +
				"date=" + this.date + ", " +
				"averageRateWeightingFactor=" + this.averageRateWeightingFactor + ", " +
				"rate=" + this.rate +
			'}';
		}
	}
}
