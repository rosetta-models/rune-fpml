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
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0BuilderImpl;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Impl;
import fpml.confirmation.ObservedRate;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.NoTouchUpperBarrierObservationSequence0Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchUpperBarrierObservationSequence0", builder=NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0BuilderImpl.class, version="${project.version}")
public interface NoTouchUpperBarrierObservationSequence0 extends RosettaModelObject {

	NoTouchUpperBarrierObservationSequence0Meta metaData = new NoTouchUpperBarrierObservationSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The rate value (level) which was attained/breached, in order to trigger the barrier event.
	 */
	BigDecimal getTriggerRate();
	/**
	 * Defines the currency pair and quote basis for an FX rate.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The maximum value observed during the condition period
	 */
	ObservedRate getMaximumObservedRate();

	/*********************** Build Methods  ***********************/
	NoTouchUpperBarrierObservationSequence0 build();
	
	NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder toBuilder();
	
	static NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder builder() {
		return new NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchUpperBarrierObservationSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchUpperBarrierObservationSequence0> getType() {
		return NoTouchUpperBarrierObservationSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("maximumObservedRate"), processor, ObservedRate.class, getMaximumObservedRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchUpperBarrierObservationSequence0Builder extends NoTouchUpperBarrierObservationSequence0, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		ObservedRate.ObservedRateBuilder getOrCreateMaximumObservedRate();
		ObservedRate.ObservedRateBuilder getMaximumObservedRate();
		NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder setTriggerRate(BigDecimal triggerRate);
		NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder setMaximumObservedRate(ObservedRate maximumObservedRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("maximumObservedRate"), processor, ObservedRate.ObservedRateBuilder.class, getMaximumObservedRate());
		}
		

		NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder prune();
	}

	/*********************** Immutable Implementation of NoTouchUpperBarrierObservationSequence0  ***********************/
	class NoTouchUpperBarrierObservationSequence0Impl implements NoTouchUpperBarrierObservationSequence0 {
		private final BigDecimal triggerRate;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final ObservedRate maximumObservedRate;
		
		protected NoTouchUpperBarrierObservationSequence0Impl(NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder builder) {
			this.triggerRate = builder.getTriggerRate();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.maximumObservedRate = ofNullable(builder.getMaximumObservedRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("maximumObservedRate")
		public ObservedRate getMaximumObservedRate() {
			return maximumObservedRate;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence0 build() {
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder toBuilder() {
			NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder builder) {
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getMaximumObservedRate()).ifPresent(builder::setMaximumObservedRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(maximumObservedRate, _that.getMaximumObservedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (maximumObservedRate != null ? maximumObservedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservationSequence0 {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"maximumObservedRate=" + this.maximumObservedRate +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchUpperBarrierObservationSequence0  ***********************/
	class NoTouchUpperBarrierObservationSequence0BuilderImpl implements NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder {
	
		protected BigDecimal triggerRate;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected ObservedRate.ObservedRateBuilder maximumObservedRate;
	
		public NoTouchUpperBarrierObservationSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
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
		@RosettaAttribute("maximumObservedRate")
		public ObservedRate.ObservedRateBuilder getMaximumObservedRate() {
			return maximumObservedRate;
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder getOrCreateMaximumObservedRate() {
			ObservedRate.ObservedRateBuilder result;
			if (maximumObservedRate!=null) {
				result = maximumObservedRate;
			}
			else {
				result = maximumObservedRate = ObservedRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maximumObservedRate")
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder setMaximumObservedRate(ObservedRate maximumObservedRate) {
			this.maximumObservedRate = maximumObservedRate==null?null:maximumObservedRate.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence0 build() {
			return new NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Impl(this);
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (maximumObservedRate!=null && !maximumObservedRate.prune().hasData()) maximumObservedRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerRate()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getMaximumObservedRate()!=null && getMaximumObservedRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder o = (NoTouchUpperBarrierObservationSequence0.NoTouchUpperBarrierObservationSequence0Builder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getMaximumObservedRate(), o.getMaximumObservedRate(), this::setMaximumObservedRate);
			
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(maximumObservedRate, _that.getMaximumObservedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (maximumObservedRate != null ? maximumObservedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservationSequence0Builder {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"maximumObservedRate=" + this.maximumObservedRate +
			'}';
		}
	}
}
