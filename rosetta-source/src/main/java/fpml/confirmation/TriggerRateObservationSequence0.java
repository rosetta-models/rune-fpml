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
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.TriggerRateObservationSequence0;
import fpml.confirmation.TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder;
import fpml.confirmation.TriggerRateObservationSequence0.TriggerRateObservationSequence0BuilderImpl;
import fpml.confirmation.TriggerRateObservationSequence0.TriggerRateObservationSequence0Impl;
import fpml.confirmation.meta.TriggerRateObservationSequence0Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TriggerRateObservationSequence0", builder=TriggerRateObservationSequence0.TriggerRateObservationSequence0BuilderImpl.class, version="${project.version}")
public interface TriggerRateObservationSequence0 extends RosettaModelObject {

	TriggerRateObservationSequence0Meta metaData = new TriggerRateObservationSequence0Meta();

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
	 * The observed rate value which triggered the barrier event.
	 */
	BigDecimal getObservedRate();

	/*********************** Build Methods  ***********************/
	TriggerRateObservationSequence0 build();
	
	TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder toBuilder();
	
	static TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder builder() {
		return new TriggerRateObservationSequence0.TriggerRateObservationSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TriggerRateObservationSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TriggerRateObservationSequence0> getType() {
		return TriggerRateObservationSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerRateObservationSequence0Builder extends TriggerRateObservationSequence0, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder setTriggerRate(BigDecimal triggerRate);
		TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder setObservedRate(BigDecimal observedRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
		}
		

		TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder prune();
	}

	/*********************** Immutable Implementation of TriggerRateObservationSequence0  ***********************/
	class TriggerRateObservationSequence0Impl implements TriggerRateObservationSequence0 {
		private final BigDecimal triggerRate;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal observedRate;
		
		protected TriggerRateObservationSequence0Impl(TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder builder) {
			this.triggerRate = builder.getTriggerRate();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.observedRate = builder.getObservedRate();
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
		@RosettaAttribute("observedRate")
		public BigDecimal getObservedRate() {
			return observedRate;
		}
		
		@Override
		public TriggerRateObservationSequence0 build() {
			return this;
		}
		
		@Override
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder toBuilder() {
			TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder builder) {
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getObservedRate()).ifPresent(builder::setObservedRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservationSequence0 {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"observedRate=" + this.observedRate +
			'}';
		}
	}

	/*********************** Builder Implementation of TriggerRateObservationSequence0  ***********************/
	class TriggerRateObservationSequence0BuilderImpl implements TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder {
	
		protected BigDecimal triggerRate;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal observedRate;
	
		public TriggerRateObservationSequence0BuilderImpl() {
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
		@RosettaAttribute("observedRate")
		public BigDecimal getObservedRate() {
			return observedRate;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("observedRate")
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder setObservedRate(BigDecimal observedRate) {
			this.observedRate = observedRate==null?null:observedRate;
			return this;
		}
		
		@Override
		public TriggerRateObservationSequence0 build() {
			return new TriggerRateObservationSequence0.TriggerRateObservationSequence0Impl(this);
		}
		
		@Override
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerRate()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getObservedRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder o = (TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeBasic(getObservedRate(), o.getObservedRate(), this::setObservedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservationSequence0Builder {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"observedRate=" + this.observedRate +
			'}';
		}
	}
}
