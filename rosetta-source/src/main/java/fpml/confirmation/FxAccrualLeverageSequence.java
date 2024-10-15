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
import fpml.confirmation.FxAccrualLeverageSequence;
import fpml.confirmation.FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder;
import fpml.confirmation.FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilderImpl;
import fpml.confirmation.FxAccrualLeverageSequence.FxAccrualLeverageSequenceImpl;
import fpml.confirmation.FxCounterCurrencyAmount;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.meta.FxAccrualLeverageSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualLeverageSequence", builder=FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualLeverageSequence extends RosettaModelObject {

	FxAccrualLeverageSequenceMeta metaData = new FxAccrualLeverageSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Notional amount Schedule. The notional value of the product per settlement period. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 * The opposite currency amount. The counterCurrencyAmount element is only optional if averageStrike component is present, in all other cases this element must be populated.
	 */
	FxCounterCurrencyAmount getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxAccrualLeverageSequence build();
	
	FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder toBuilder();
	
	static FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder builder() {
		return new FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualLeverageSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualLeverageSequence> getType() {
		return FxAccrualLeverageSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualLeverageSequenceBuilder extends FxAccrualLeverageSequence, RosettaModelObjectBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getCounterCurrencyAmount();
		FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder setCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder.class, getCounterCurrencyAmount());
		}
		

		FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualLeverageSequence  ***********************/
	class FxAccrualLeverageSequenceImpl implements FxAccrualLeverageSequence {
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxCounterCurrencyAmount counterCurrencyAmount;
		
		protected FxAccrualLeverageSequenceImpl(FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder builder) {
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxCounterCurrencyAmount getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxAccrualLeverageSequence build() {
			return this;
		}
		
		@Override
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder toBuilder() {
			FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder builder) {
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLeverageSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLeverageSequence {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualLeverageSequence  ***********************/
	class FxAccrualLeverageSequenceBuilderImpl implements FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder counterCurrencyAmount;
	
		public FxAccrualLeverageSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount() {
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder result;
			if (counterCurrencyAmount!=null) {
				result = counterCurrencyAmount;
			}
			else {
				result = counterCurrencyAmount = FxCounterCurrencyAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder setCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount) {
			this.counterCurrencyAmount = counterCurrencyAmount==null?null:counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualLeverageSequence build() {
			return new FxAccrualLeverageSequence.FxAccrualLeverageSequenceImpl(this);
		}
		
		@Override
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder prune() {
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (counterCurrencyAmount!=null && !counterCurrencyAmount.prune().hasData()) counterCurrencyAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder o = (FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLeverageSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLeverageSequenceBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
