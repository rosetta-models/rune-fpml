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
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1BuilderImpl;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Impl;
import fpml.confirmation.ObservedPrice;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.meta.NoTouchLowerBarrierObservationSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchLowerBarrierObservationSequence1", builder=NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1BuilderImpl.class, version="${project.version}")
public interface NoTouchLowerBarrierObservationSequence1 extends RosettaModelObject {

	NoTouchLowerBarrierObservationSequence1Meta metaData = new NoTouchLowerBarrierObservationSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The price value (level) which was attained/breached, in order to trigger the barrier event.
	 */
	PositiveMoney getTriggerPrice();
	/**
	 * The minimum value observed during the condition period
	 */
	ObservedPrice getMinimumObservedPrice();

	/*********************** Build Methods  ***********************/
	NoTouchLowerBarrierObservationSequence1 build();
	
	NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder toBuilder();
	
	static NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder builder() {
		return new NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchLowerBarrierObservationSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchLowerBarrierObservationSequence1> getType() {
		return NoTouchLowerBarrierObservationSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.class, getTriggerPrice());
		processRosetta(path.newSubPath("minimumObservedPrice"), processor, ObservedPrice.class, getMinimumObservedPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchLowerBarrierObservationSequence1Builder extends NoTouchLowerBarrierObservationSequence1, RosettaModelObjectBuilder {
		PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice();
		PositiveMoney.PositiveMoneyBuilder getTriggerPrice();
		ObservedPrice.ObservedPriceBuilder getOrCreateMinimumObservedPrice();
		ObservedPrice.ObservedPriceBuilder getMinimumObservedPrice();
		NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder setTriggerPrice(PositiveMoney triggerPrice);
		NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder setMinimumObservedPrice(ObservedPrice minimumObservedPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTriggerPrice());
			processRosetta(path.newSubPath("minimumObservedPrice"), processor, ObservedPrice.ObservedPriceBuilder.class, getMinimumObservedPrice());
		}
		

		NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder prune();
	}

	/*********************** Immutable Implementation of NoTouchLowerBarrierObservationSequence1  ***********************/
	class NoTouchLowerBarrierObservationSequence1Impl implements NoTouchLowerBarrierObservationSequence1 {
		private final PositiveMoney triggerPrice;
		private final ObservedPrice minimumObservedPrice;
		
		protected NoTouchLowerBarrierObservationSequence1Impl(NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder builder) {
			this.triggerPrice = ofNullable(builder.getTriggerPrice()).map(f->f.build()).orElse(null);
			this.minimumObservedPrice = ofNullable(builder.getMinimumObservedPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		public PositiveMoney getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		@RosettaAttribute("minimumObservedPrice")
		public ObservedPrice getMinimumObservedPrice() {
			return minimumObservedPrice;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence1 build() {
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder toBuilder() {
			NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder builder) {
			ofNullable(getTriggerPrice()).ifPresent(builder::setTriggerPrice);
			ofNullable(getMinimumObservedPrice()).ifPresent(builder::setMinimumObservedPrice);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(minimumObservedPrice, _that.getMinimumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (minimumObservedPrice != null ? minimumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservationSequence1 {" +
				"triggerPrice=" + this.triggerPrice + ", " +
				"minimumObservedPrice=" + this.minimumObservedPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchLowerBarrierObservationSequence1  ***********************/
	class NoTouchLowerBarrierObservationSequence1BuilderImpl implements NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder {
	
		protected PositiveMoney.PositiveMoneyBuilder triggerPrice;
		protected ObservedPrice.ObservedPriceBuilder minimumObservedPrice;
	
		public NoTouchLowerBarrierObservationSequence1BuilderImpl() {
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
		@RosettaAttribute("minimumObservedPrice")
		public ObservedPrice.ObservedPriceBuilder getMinimumObservedPrice() {
			return minimumObservedPrice;
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder getOrCreateMinimumObservedPrice() {
			ObservedPrice.ObservedPriceBuilder result;
			if (minimumObservedPrice!=null) {
				result = minimumObservedPrice;
			}
			else {
				result = minimumObservedPrice = ObservedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder setTriggerPrice(PositiveMoney triggerPrice) {
			this.triggerPrice = triggerPrice==null?null:triggerPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("minimumObservedPrice")
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder setMinimumObservedPrice(ObservedPrice minimumObservedPrice) {
			this.minimumObservedPrice = minimumObservedPrice==null?null:minimumObservedPrice.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence1 build() {
			return new NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Impl(this);
		}
		
		@Override
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder prune() {
			if (triggerPrice!=null && !triggerPrice.prune().hasData()) triggerPrice = null;
			if (minimumObservedPrice!=null && !minimumObservedPrice.prune().hasData()) minimumObservedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerPrice()!=null && getTriggerPrice().hasData()) return true;
			if (getMinimumObservedPrice()!=null && getMinimumObservedPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder o = (NoTouchLowerBarrierObservationSequence1.NoTouchLowerBarrierObservationSequence1Builder) other;
			
			merger.mergeRosetta(getTriggerPrice(), o.getTriggerPrice(), this::setTriggerPrice);
			merger.mergeRosetta(getMinimumObservedPrice(), o.getMinimumObservedPrice(), this::setMinimumObservedPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(minimumObservedPrice, _that.getMinimumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (minimumObservedPrice != null ? minimumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservationSequence1Builder {" +
				"triggerPrice=" + this.triggerPrice + ", " +
				"minimumObservedPrice=" + this.minimumObservedPrice +
			'}';
		}
	}
}
