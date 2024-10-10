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
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0BuilderImpl;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Impl;
import fpml.confirmation.ObservedRate;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.NoTouchLowerBarrierObservationSequence0Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchLowerBarrierObservationSequence0", builder=NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0BuilderImpl.class, version="${project.version}")
public interface NoTouchLowerBarrierObservationSequence0 extends RosettaModelObject {

	NoTouchLowerBarrierObservationSequence0Meta metaData = new NoTouchLowerBarrierObservationSequence0Meta();

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
	 * The minimum value observed during the condition period.
	 */
	ObservedRate getMinimumObservedRate();

	/*********************** Build Methods  ***********************/
	NoTouchLowerBarrierObservationSequence0 build();
	
	NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder toBuilder();
	
	static NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder builder() {
		return new NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchLowerBarrierObservationSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchLowerBarrierObservationSequence0> getType() {
		return NoTouchLowerBarrierObservationSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("minimumObservedRate"), processor, ObservedRate.class, getMinimumObservedRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchLowerBarrierObservationSequence0Builder extends NoTouchLowerBarrierObservationSequence0, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		ObservedRate.ObservedRateBuilder getOrCreateMinimumObservedRate();
		ObservedRate.ObservedRateBuilder getMinimumObservedRate();
		NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder setTriggerRate(BigDecimal triggerRate);
		NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder setMinimumObservedRate(ObservedRate minimumObservedRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("minimumObservedRate"), processor, ObservedRate.ObservedRateBuilder.class, getMinimumObservedRate());
		}
		

		NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder prune();
	}

	/*********************** Immutable Implementation of NoTouchLowerBarrierObservationSequence0  ***********************/
	class NoTouchLowerBarrierObservationSequence0Impl implements NoTouchLowerBarrierObservationSequence0 {
		private final BigDecimal triggerRate;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final ObservedRate minimumObservedRate;
		
		protected NoTouchLowerBarrierObservationSequence0Impl(NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder builder) {
			this.triggerRate = builder.getTriggerRate();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.minimumObservedRate = ofNullable(builder.getMinimumObservedRate()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("minimumObservedRate")
		public ObservedRate getMinimumObservedRate() {
			return minimumObservedRate;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence0 build() {
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder toBuilder() {
			NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder builder) {
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getMinimumObservedRate()).ifPresent(builder::setMinimumObservedRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(minimumObservedRate, _that.getMinimumObservedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (minimumObservedRate != null ? minimumObservedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservationSequence0 {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"minimumObservedRate=" + this.minimumObservedRate +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchLowerBarrierObservationSequence0  ***********************/
	class NoTouchLowerBarrierObservationSequence0BuilderImpl implements NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder {
	
		protected BigDecimal triggerRate;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected ObservedRate.ObservedRateBuilder minimumObservedRate;
	
		public NoTouchLowerBarrierObservationSequence0BuilderImpl() {
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
		@RosettaAttribute("minimumObservedRate")
		public ObservedRate.ObservedRateBuilder getMinimumObservedRate() {
			return minimumObservedRate;
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder getOrCreateMinimumObservedRate() {
			ObservedRate.ObservedRateBuilder result;
			if (minimumObservedRate!=null) {
				result = minimumObservedRate;
			}
			else {
				result = minimumObservedRate = ObservedRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("minimumObservedRate")
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder setMinimumObservedRate(ObservedRate minimumObservedRate) {
			this.minimumObservedRate = minimumObservedRate==null?null:minimumObservedRate.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence0 build() {
			return new NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Impl(this);
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (minimumObservedRate!=null && !minimumObservedRate.prune().hasData()) minimumObservedRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerRate()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getMinimumObservedRate()!=null && getMinimumObservedRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder o = (NoTouchLowerBarrierObservationSequence0.NoTouchLowerBarrierObservationSequence0Builder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getMinimumObservedRate(), o.getMinimumObservedRate(), this::setMinimumObservedRate);
			
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(minimumObservedRate, _that.getMinimumObservedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (minimumObservedRate != null ? minimumObservedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservationSequence0Builder {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"minimumObservedRate=" + this.minimumObservedRate +
			'}';
		}
	}
}
