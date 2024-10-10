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
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence;
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder;
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilderImpl;
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceImpl;
import fpml.confirmation.FxForwardStrikePrice;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.meta.FxAccrualLinearPayoffRegionSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualLinearPayoffRegionSequence", builder=FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualLinearPayoffRegionSequence extends RosettaModelObject {

	FxAccrualLinearPayoffRegionSequenceMeta metaData = new FxAccrualLinearPayoffRegionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The rate of exchange between the two currencies.
	 */
	FxForwardStrikePrice getStrike();
	/**
	 * The opposite currency amount. The counterCurrencyAmount element is only optional if averageStrike component is present or if the accrualRegion specifies the amount of counterCurrencyAmount to accrue, in all other cases this element must be populated.
	 */
	NonNegativeAmountSchedule getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxAccrualLinearPayoffRegionSequence build();
	
	FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder toBuilder();
	
	static FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder builder() {
		return new FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualLinearPayoffRegionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualLinearPayoffRegionSequence> getType() {
		return FxAccrualLinearPayoffRegionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("strike"), processor, FxForwardStrikePrice.class, getStrike());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualLinearPayoffRegionSequenceBuilder extends FxAccrualLinearPayoffRegionSequence, RosettaModelObjectBuilder {
		FxForwardStrikePrice.FxForwardStrikePriceBuilder getOrCreateStrike();
		FxForwardStrikePrice.FxForwardStrikePriceBuilder getStrike();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount();
		FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder setStrike(FxForwardStrikePrice strike);
		FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("strike"), processor, FxForwardStrikePrice.FxForwardStrikePriceBuilder.class, getStrike());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getCounterCurrencyAmount());
		}
		

		FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualLinearPayoffRegionSequence  ***********************/
	class FxAccrualLinearPayoffRegionSequenceImpl implements FxAccrualLinearPayoffRegionSequence {
		private final FxForwardStrikePrice strike;
		private final NonNegativeAmountSchedule counterCurrencyAmount;
		
		protected FxAccrualLinearPayoffRegionSequenceImpl(FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder builder) {
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxForwardStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxAccrualLinearPayoffRegionSequence build() {
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder toBuilder() {
			FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder builder) {
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLinearPayoffRegionSequence _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLinearPayoffRegionSequence {" +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualLinearPayoffRegionSequence  ***********************/
	class FxAccrualLinearPayoffRegionSequenceBuilderImpl implements FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder {
	
		protected FxForwardStrikePrice.FxForwardStrikePriceBuilder strike;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder counterCurrencyAmount;
	
		public FxAccrualLinearPayoffRegionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strike")
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder getOrCreateStrike() {
			FxForwardStrikePrice.FxForwardStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxForwardStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (counterCurrencyAmount!=null) {
				result = counterCurrencyAmount;
			}
			else {
				result = counterCurrencyAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder setStrike(FxForwardStrikePrice strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount) {
			this.counterCurrencyAmount = counterCurrencyAmount==null?null:counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegionSequence build() {
			return new FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceImpl(this);
		}
		
		@Override
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder prune() {
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (counterCurrencyAmount!=null && !counterCurrencyAmount.prune().hasData()) counterCurrencyAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder o = (FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLinearPayoffRegionSequence _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLinearPayoffRegionSequenceBuilder {" +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
