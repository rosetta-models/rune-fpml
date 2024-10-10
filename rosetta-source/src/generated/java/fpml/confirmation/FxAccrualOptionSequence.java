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
import fpml.confirmation.FxAccrualOptionSequence;
import fpml.confirmation.FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder;
import fpml.confirmation.FxAccrualOptionSequence.FxAccrualOptionSequenceBuilderImpl;
import fpml.confirmation.FxAccrualOptionSequence.FxAccrualOptionSequenceImpl;
import fpml.confirmation.FxOptionStrikePrice;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.meta.FxAccrualOptionSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualOptionSequence", builder=FxAccrualOptionSequence.FxAccrualOptionSequenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualOptionSequence extends RosettaModelObject {

	FxAccrualOptionSequenceMeta metaData = new FxAccrualOptionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the option strike price.
	 */
	FxOptionStrikePrice getStrike();
	/**
	 * The opposite currency amount the amount which is not always deterministic.
	 */
	NonNegativeAmountSchedule getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxAccrualOptionSequence build();
	
	FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder toBuilder();
	
	static FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder builder() {
		return new FxAccrualOptionSequence.FxAccrualOptionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualOptionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualOptionSequence> getType() {
		return FxAccrualOptionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("strike"), processor, FxOptionStrikePrice.class, getStrike());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualOptionSequenceBuilder extends FxAccrualOptionSequence, RosettaModelObjectBuilder {
		FxOptionStrikePrice.FxOptionStrikePriceBuilder getOrCreateStrike();
		FxOptionStrikePrice.FxOptionStrikePriceBuilder getStrike();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount();
		FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder setStrike(FxOptionStrikePrice strike);
		FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("strike"), processor, FxOptionStrikePrice.FxOptionStrikePriceBuilder.class, getStrike());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getCounterCurrencyAmount());
		}
		

		FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualOptionSequence  ***********************/
	class FxAccrualOptionSequenceImpl implements FxAccrualOptionSequence {
		private final FxOptionStrikePrice strike;
		private final NonNegativeAmountSchedule counterCurrencyAmount;
		
		protected FxAccrualOptionSequenceImpl(FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder builder) {
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxOptionStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxAccrualOptionSequence build() {
			return this;
		}
		
		@Override
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder toBuilder() {
			FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder builder) {
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualOptionSequence _that = getType().cast(o);
		
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
			return "FxAccrualOptionSequence {" +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualOptionSequence  ***********************/
	class FxAccrualOptionSequenceBuilderImpl implements FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder {
	
		protected FxOptionStrikePrice.FxOptionStrikePriceBuilder strike;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder counterCurrencyAmount;
	
		public FxAccrualOptionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strike")
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder getOrCreateStrike() {
			FxOptionStrikePrice.FxOptionStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxOptionStrikePrice.builder();
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
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder setStrike(FxOptionStrikePrice strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount) {
			this.counterCurrencyAmount = counterCurrencyAmount==null?null:counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualOptionSequence build() {
			return new FxAccrualOptionSequence.FxAccrualOptionSequenceImpl(this);
		}
		
		@Override
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder prune() {
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
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder o = (FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualOptionSequence _that = getType().cast(o);
		
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
			return "FxAccrualOptionSequenceBuilder {" +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
