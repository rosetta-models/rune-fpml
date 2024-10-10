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
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.TriggerRateObservationSequence1;
import fpml.confirmation.TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder;
import fpml.confirmation.TriggerRateObservationSequence1.TriggerRateObservationSequence1BuilderImpl;
import fpml.confirmation.TriggerRateObservationSequence1.TriggerRateObservationSequence1Impl;
import fpml.confirmation.meta.TriggerRateObservationSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TriggerRateObservationSequence1", builder=TriggerRateObservationSequence1.TriggerRateObservationSequence1BuilderImpl.class, version="${project.version}")
public interface TriggerRateObservationSequence1 extends RosettaModelObject {

	TriggerRateObservationSequence1Meta metaData = new TriggerRateObservationSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The price value (level) which was attained/breached, in order to trigger the barrier event.
	 */
	PositiveMoney getTriggerPrice();
	/**
	 * The observed price value which triggered the barrier event.
	 */
	PositiveMoney getObservedPrice();

	/*********************** Build Methods  ***********************/
	TriggerRateObservationSequence1 build();
	
	TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder toBuilder();
	
	static TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder builder() {
		return new TriggerRateObservationSequence1.TriggerRateObservationSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TriggerRateObservationSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TriggerRateObservationSequence1> getType() {
		return TriggerRateObservationSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.class, getTriggerPrice());
		processRosetta(path.newSubPath("observedPrice"), processor, PositiveMoney.class, getObservedPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerRateObservationSequence1Builder extends TriggerRateObservationSequence1, RosettaModelObjectBuilder {
		PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice();
		PositiveMoney.PositiveMoneyBuilder getTriggerPrice();
		PositiveMoney.PositiveMoneyBuilder getOrCreateObservedPrice();
		PositiveMoney.PositiveMoneyBuilder getObservedPrice();
		TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder setTriggerPrice(PositiveMoney triggerPrice);
		TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder setObservedPrice(PositiveMoney observedPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTriggerPrice());
			processRosetta(path.newSubPath("observedPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getObservedPrice());
		}
		

		TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder prune();
	}

	/*********************** Immutable Implementation of TriggerRateObservationSequence1  ***********************/
	class TriggerRateObservationSequence1Impl implements TriggerRateObservationSequence1 {
		private final PositiveMoney triggerPrice;
		private final PositiveMoney observedPrice;
		
		protected TriggerRateObservationSequence1Impl(TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder builder) {
			this.triggerPrice = ofNullable(builder.getTriggerPrice()).map(f->f.build()).orElse(null);
			this.observedPrice = ofNullable(builder.getObservedPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		public PositiveMoney getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		@RosettaAttribute("observedPrice")
		public PositiveMoney getObservedPrice() {
			return observedPrice;
		}
		
		@Override
		public TriggerRateObservationSequence1 build() {
			return this;
		}
		
		@Override
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder toBuilder() {
			TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder builder) {
			ofNullable(getTriggerPrice()).ifPresent(builder::setTriggerPrice);
			ofNullable(getObservedPrice()).ifPresent(builder::setObservedPrice);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(observedPrice, _that.getObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (observedPrice != null ? observedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservationSequence1 {" +
				"triggerPrice=" + this.triggerPrice + ", " +
				"observedPrice=" + this.observedPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of TriggerRateObservationSequence1  ***********************/
	class TriggerRateObservationSequence1BuilderImpl implements TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder {
	
		protected PositiveMoney.PositiveMoneyBuilder triggerPrice;
		protected PositiveMoney.PositiveMoneyBuilder observedPrice;
	
		public TriggerRateObservationSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("triggerPrice")
		public PositiveMoney.PositiveMoneyBuilder getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (triggerPrice!=null) {
				result = triggerPrice;
			}
			else {
				result = triggerPrice = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observedPrice")
		public PositiveMoney.PositiveMoneyBuilder getObservedPrice() {
			return observedPrice;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateObservedPrice() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (observedPrice!=null) {
				result = observedPrice;
			}
			else {
				result = observedPrice = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder setTriggerPrice(PositiveMoney triggerPrice) {
			this.triggerPrice = triggerPrice==null?null:triggerPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("observedPrice")
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder setObservedPrice(PositiveMoney observedPrice) {
			this.observedPrice = observedPrice==null?null:observedPrice.toBuilder();
			return this;
		}
		
		@Override
		public TriggerRateObservationSequence1 build() {
			return new TriggerRateObservationSequence1.TriggerRateObservationSequence1Impl(this);
		}
		
		@Override
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder prune() {
			if (triggerPrice!=null && !triggerPrice.prune().hasData()) triggerPrice = null;
			if (observedPrice!=null && !observedPrice.prune().hasData()) observedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerPrice()!=null && getTriggerPrice().hasData()) return true;
			if (getObservedPrice()!=null && getObservedPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder o = (TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder) other;
			
			merger.mergeRosetta(getTriggerPrice(), o.getTriggerPrice(), this::setTriggerPrice);
			merger.mergeRosetta(getObservedPrice(), o.getObservedPrice(), this::setObservedPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(observedPrice, _that.getObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (observedPrice != null ? observedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservationSequence1Builder {" +
				"triggerPrice=" + this.triggerPrice + ", " +
				"observedPrice=" + this.observedPrice +
			'}';
		}
	}
}
