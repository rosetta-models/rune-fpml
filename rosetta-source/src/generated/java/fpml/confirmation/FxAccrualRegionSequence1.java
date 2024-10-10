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
import fpml.confirmation.FxAccrualRegionSequence1;
import fpml.confirmation.FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder;
import fpml.confirmation.FxAccrualRegionSequence1.FxAccrualRegionSequence1BuilderImpl;
import fpml.confirmation.FxAccrualRegionSequence1.FxAccrualRegionSequence1Impl;
import fpml.confirmation.FxCounterCurrencyAmount;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.meta.FxAccrualRegionSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualRegionSequence1", builder=FxAccrualRegionSequence1.FxAccrualRegionSequence1BuilderImpl.class, version="${project.version}")
public interface FxAccrualRegionSequence1 extends RosettaModelObject {

	FxAccrualRegionSequence1Meta metaData = new FxAccrualRegionSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Notional amount Schedule. The notional value of the product per settlement period. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 * The opposite currency amount. The &#39;counterCurrencyAmount&#39; element is supplied if the accrual process operates on specific amounts of both notional and counter currency within this accrual region.
	 */
	FxCounterCurrencyAmount getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxAccrualRegionSequence1 build();
	
	FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder toBuilder();
	
	static FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder builder() {
		return new FxAccrualRegionSequence1.FxAccrualRegionSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualRegionSequence1> getType() {
		return FxAccrualRegionSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionSequence1Builder extends FxAccrualRegionSequence1, RosettaModelObjectBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getCounterCurrencyAmount();
		FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder setCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder.class, getCounterCurrencyAmount());
		}
		

		FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionSequence1  ***********************/
	class FxAccrualRegionSequence1Impl implements FxAccrualRegionSequence1 {
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxCounterCurrencyAmount counterCurrencyAmount;
		
		protected FxAccrualRegionSequence1Impl(FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder builder) {
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
		public FxAccrualRegionSequence1 build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder toBuilder() {
			FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder builder) {
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionSequence1 _that = getType().cast(o);
		
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
			return "FxAccrualRegionSequence1 {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionSequence1  ***********************/
	class FxAccrualRegionSequence1BuilderImpl implements FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder counterCurrencyAmount;
	
		public FxAccrualRegionSequence1BuilderImpl() {
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
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder setCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount) {
			this.counterCurrencyAmount = counterCurrencyAmount==null?null:counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegionSequence1 build() {
			return new FxAccrualRegionSequence1.FxAccrualRegionSequence1Impl(this);
		}
		
		@Override
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder prune() {
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
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder o = (FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionSequence1 _that = getType().cast(o);
		
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
			return "FxAccrualRegionSequence1Builder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
