package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.FxCounterCurrencyAmount;
import fpml.confirmation.FxTargetLeverageSequence;
import fpml.confirmation.FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder;
import fpml.confirmation.FxTargetLeverageSequence.FxTargetLeverageSequenceBuilderImpl;
import fpml.confirmation.FxTargetLeverageSequence.FxTargetLeverageSequenceImpl;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.meta.FxTargetLeverageSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetLeverageSequence", builder=FxTargetLeverageSequence.FxTargetLeverageSequenceBuilderImpl.class, version="${project.version}")
public interface FxTargetLeverageSequence extends RosettaModelObject {

	FxTargetLeverageSequenceMeta metaData = new FxTargetLeverageSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Leveraged notional expressed as amount with optional steps.
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 * The opposite currency amount of the Target.
	 */
	List<? extends FxCounterCurrencyAmount> getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxTargetLeverageSequence build();
	
	FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder toBuilder();
	
	static FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder builder() {
		return new FxTargetLeverageSequence.FxTargetLeverageSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetLeverageSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetLeverageSequence> getType() {
		return FxTargetLeverageSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetLeverageSequenceBuilder extends FxTargetLeverageSequence, RosettaModelObjectBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount(int _index);
		List<? extends FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder> getCounterCurrencyAmount();
		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount0);
		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount1, int _idx);
		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder addCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmount2);
		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder setCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmount3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder.class, getCounterCurrencyAmount());
		}
		

		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetLeverageSequence  ***********************/
	class FxTargetLeverageSequenceImpl implements FxTargetLeverageSequence {
		private final NonNegativeAmountSchedule notionalAmount;
		private final List<? extends FxCounterCurrencyAmount> counterCurrencyAmount;
		
		protected FxTargetLeverageSequenceImpl(FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder builder) {
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public List<? extends FxCounterCurrencyAmount> getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxTargetLeverageSequence build() {
			return this;
		}
		
		@Override
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder toBuilder() {
			FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder builder) {
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetLeverageSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
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
			return "FxTargetLeverageSequence {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetLeverageSequence  ***********************/
	class FxTargetLeverageSequenceBuilderImpl implements FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected List<FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder> counterCurrencyAmount = new ArrayList<>();
	
		public FxTargetLeverageSequenceBuilderImpl() {
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
		public List<? extends FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder> getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount(int _index) {
		
			if (counterCurrencyAmount==null) {
				this.counterCurrencyAmount = new ArrayList<>();
			}
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder result;
			return getIndex(counterCurrencyAmount, _index, () -> {
						FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder newCounterCurrencyAmount = FxCounterCurrencyAmount.builder();
						return newCounterCurrencyAmount;
					});
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount) {
			if (counterCurrencyAmount!=null) this.counterCurrencyAmount.add(counterCurrencyAmount.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount, int _idx) {
			getIndex(this.counterCurrencyAmount, _idx, () -> counterCurrencyAmount.toBuilder());
			return this;
		}
		@Override 
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder addCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmounts) {
			if (counterCurrencyAmounts != null) {
				for (FxCounterCurrencyAmount toAdd : counterCurrencyAmounts) {
					this.counterCurrencyAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("counterCurrencyAmount")
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder setCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmounts) {
			if (counterCurrencyAmounts == null)  {
				this.counterCurrencyAmount = new ArrayList<>();
			}
			else {
				this.counterCurrencyAmount = counterCurrencyAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxTargetLeverageSequence build() {
			return new FxTargetLeverageSequence.FxTargetLeverageSequenceImpl(this);
		}
		
		@Override
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder prune() {
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			counterCurrencyAmount = counterCurrencyAmount.stream().filter(b->b!=null).<FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder o = (FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::getOrCreateCounterCurrencyAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetLeverageSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
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
			return "FxTargetLeverageSequenceBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
