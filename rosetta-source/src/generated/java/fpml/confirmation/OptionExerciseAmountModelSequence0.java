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
import fpml.confirmation.Money;
import fpml.confirmation.OptionExerciseAmountModelSequence0;
import fpml.confirmation.OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder;
import fpml.confirmation.OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0BuilderImpl;
import fpml.confirmation.OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Impl;
import fpml.confirmation.meta.OptionExerciseAmountModelSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExerciseAmountModelSequence0", builder=OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0BuilderImpl.class, version="${project.version}")
public interface OptionExerciseAmountModelSequence0 extends RosettaModelObject {

	OptionExerciseAmountModelSequence0Meta metaData = new OptionExerciseAmountModelSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 */
	Money getExerciseInNotionalAmount();
	/**
	 * Specifies the Notional amount after the Change
	 */
	Money getOutstandingNotionalAmount();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountModelSequence0 build();
	
	OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder toBuilder();
	
	static OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder builder() {
		return new OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountModelSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountModelSequence0> getType() {
		return OptionExerciseAmountModelSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.class, getExerciseInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.class, getOutstandingNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountModelSequence0Builder extends OptionExerciseAmountModelSequence0, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateExerciseInNotionalAmount();
		Money.MoneyBuilder getExerciseInNotionalAmount();
		Money.MoneyBuilder getOrCreateOutstandingNotionalAmount();
		Money.MoneyBuilder getOutstandingNotionalAmount();
		OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder setExerciseInNotionalAmount(Money exerciseInNotionalAmount);
		OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder setOutstandingNotionalAmount(Money outstandingNotionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.MoneyBuilder.class, getExerciseInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.MoneyBuilder.class, getOutstandingNotionalAmount());
		}
		

		OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountModelSequence0  ***********************/
	class OptionExerciseAmountModelSequence0Impl implements OptionExerciseAmountModelSequence0 {
		private final Money exerciseInNotionalAmount;
		private final Money outstandingNotionalAmount;
		
		protected OptionExerciseAmountModelSequence0Impl(OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder builder) {
			this.exerciseInNotionalAmount = ofNullable(builder.getExerciseInNotionalAmount()).map(f->f.build()).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		public Money getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public Money getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public OptionExerciseAmountModelSequence0 build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder toBuilder() {
			OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder builder) {
			ofNullable(getExerciseInNotionalAmount()).ifPresent(builder::setExerciseInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModelSequence0 {" +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountModelSequence0  ***********************/
	class OptionExerciseAmountModelSequence0BuilderImpl implements OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder {
	
		protected Money.MoneyBuilder exerciseInNotionalAmount;
		protected Money.MoneyBuilder outstandingNotionalAmount;
	
		public OptionExerciseAmountModelSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		public Money.MoneyBuilder getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateExerciseInNotionalAmount() {
			Money.MoneyBuilder result;
			if (exerciseInNotionalAmount!=null) {
				result = exerciseInNotionalAmount;
			}
			else {
				result = exerciseInNotionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public Money.MoneyBuilder getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateOutstandingNotionalAmount() {
			Money.MoneyBuilder result;
			if (outstandingNotionalAmount!=null) {
				result = outstandingNotionalAmount;
			}
			else {
				result = outstandingNotionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder setExerciseInNotionalAmount(Money exerciseInNotionalAmount) {
			this.exerciseInNotionalAmount = exerciseInNotionalAmount==null?null:exerciseInNotionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder setOutstandingNotionalAmount(Money outstandingNotionalAmount) {
			this.outstandingNotionalAmount = outstandingNotionalAmount==null?null:outstandingNotionalAmount.toBuilder();
			return this;
		}
		
		@Override
		public OptionExerciseAmountModelSequence0 build() {
			return new OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Impl(this);
		}
		
		@Override
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder prune() {
			if (exerciseInNotionalAmount!=null && !exerciseInNotionalAmount.prune().hasData()) exerciseInNotionalAmount = null;
			if (outstandingNotionalAmount!=null && !outstandingNotionalAmount.prune().hasData()) outstandingNotionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseInNotionalAmount()!=null && getExerciseInNotionalAmount().hasData()) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder o = (OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder) other;
			
			merger.mergeRosetta(getExerciseInNotionalAmount(), o.getExerciseInNotionalAmount(), this::setExerciseInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::setOutstandingNotionalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModelSequence0Builder {" +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}
}
