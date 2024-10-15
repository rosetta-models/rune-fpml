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
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1BuilderImpl;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Impl;
import fpml.confirmation.ObservedPrice;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.meta.NoTouchUpperBarrierObservationSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchUpperBarrierObservationSequence1", builder=NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1BuilderImpl.class, version="${project.version}")
public interface NoTouchUpperBarrierObservationSequence1 extends RosettaModelObject {

	NoTouchUpperBarrierObservationSequence1Meta metaData = new NoTouchUpperBarrierObservationSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The price value (level) which was attained/breached, in order to trigger the barrier event.
	 */
	PositiveMoney getTriggerPrice();
	/**
	 * The maximum value observed during the condition period
	 */
	ObservedPrice getMaximumObservedPrice();

	/*********************** Build Methods  ***********************/
	NoTouchUpperBarrierObservationSequence1 build();
	
	NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder toBuilder();
	
	static NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder builder() {
		return new NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchUpperBarrierObservationSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchUpperBarrierObservationSequence1> getType() {
		return NoTouchUpperBarrierObservationSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.class, getTriggerPrice());
		processRosetta(path.newSubPath("maximumObservedPrice"), processor, ObservedPrice.class, getMaximumObservedPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchUpperBarrierObservationSequence1Builder extends NoTouchUpperBarrierObservationSequence1, RosettaModelObjectBuilder {
		PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice();
		PositiveMoney.PositiveMoneyBuilder getTriggerPrice();
		ObservedPrice.ObservedPriceBuilder getOrCreateMaximumObservedPrice();
		ObservedPrice.ObservedPriceBuilder getMaximumObservedPrice();
		NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder setTriggerPrice(PositiveMoney triggerPrice);
		NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder setMaximumObservedPrice(ObservedPrice maximumObservedPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTriggerPrice());
			processRosetta(path.newSubPath("maximumObservedPrice"), processor, ObservedPrice.ObservedPriceBuilder.class, getMaximumObservedPrice());
		}
		

		NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder prune();
	}

	/*********************** Immutable Implementation of NoTouchUpperBarrierObservationSequence1  ***********************/
	class NoTouchUpperBarrierObservationSequence1Impl implements NoTouchUpperBarrierObservationSequence1 {
		private final PositiveMoney triggerPrice;
		private final ObservedPrice maximumObservedPrice;
		
		protected NoTouchUpperBarrierObservationSequence1Impl(NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder builder) {
			this.triggerPrice = ofNullable(builder.getTriggerPrice()).map(f->f.build()).orElse(null);
			this.maximumObservedPrice = ofNullable(builder.getMaximumObservedPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		public PositiveMoney getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		@RosettaAttribute("maximumObservedPrice")
		public ObservedPrice getMaximumObservedPrice() {
			return maximumObservedPrice;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence1 build() {
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder toBuilder() {
			NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder builder) {
			ofNullable(getTriggerPrice()).ifPresent(builder::setTriggerPrice);
			ofNullable(getMaximumObservedPrice()).ifPresent(builder::setMaximumObservedPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(maximumObservedPrice, _that.getMaximumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (maximumObservedPrice != null ? maximumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservationSequence1 {" +
				"triggerPrice=" + this.triggerPrice + ", " +
				"maximumObservedPrice=" + this.maximumObservedPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchUpperBarrierObservationSequence1  ***********************/
	class NoTouchUpperBarrierObservationSequence1BuilderImpl implements NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder {
	
		protected PositiveMoney.PositiveMoneyBuilder triggerPrice;
		protected ObservedPrice.ObservedPriceBuilder maximumObservedPrice;
	
		public NoTouchUpperBarrierObservationSequence1BuilderImpl() {
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
		@RosettaAttribute("maximumObservedPrice")
		public ObservedPrice.ObservedPriceBuilder getMaximumObservedPrice() {
			return maximumObservedPrice;
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder getOrCreateMaximumObservedPrice() {
			ObservedPrice.ObservedPriceBuilder result;
			if (maximumObservedPrice!=null) {
				result = maximumObservedPrice;
			}
			else {
				result = maximumObservedPrice = ObservedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder setTriggerPrice(PositiveMoney triggerPrice) {
			this.triggerPrice = triggerPrice==null?null:triggerPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maximumObservedPrice")
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder setMaximumObservedPrice(ObservedPrice maximumObservedPrice) {
			this.maximumObservedPrice = maximumObservedPrice==null?null:maximumObservedPrice.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence1 build() {
			return new NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Impl(this);
		}
		
		@Override
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder prune() {
			if (triggerPrice!=null && !triggerPrice.prune().hasData()) triggerPrice = null;
			if (maximumObservedPrice!=null && !maximumObservedPrice.prune().hasData()) maximumObservedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerPrice()!=null && getTriggerPrice().hasData()) return true;
			if (getMaximumObservedPrice()!=null && getMaximumObservedPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder o = (NoTouchUpperBarrierObservationSequence1.NoTouchUpperBarrierObservationSequence1Builder) other;
			
			merger.mergeRosetta(getTriggerPrice(), o.getTriggerPrice(), this::setTriggerPrice);
			merger.mergeRosetta(getMaximumObservedPrice(), o.getMaximumObservedPrice(), this::setMaximumObservedPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(maximumObservedPrice, _that.getMaximumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (maximumObservedPrice != null ? maximumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservationSequence1Builder {" +
				"triggerPrice=" + this.triggerPrice + ", " +
				"maximumObservedPrice=" + this.maximumObservedPrice +
			'}';
		}
	}
}
