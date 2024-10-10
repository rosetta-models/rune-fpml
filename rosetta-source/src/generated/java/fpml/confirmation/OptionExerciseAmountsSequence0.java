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
import fpml.confirmation.NotionalReference;
import fpml.confirmation.OptionExerciseAmountsSequence0;
import fpml.confirmation.OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder;
import fpml.confirmation.OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0BuilderImpl;
import fpml.confirmation.OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Impl;
import fpml.confirmation.meta.OptionExerciseAmountsSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExerciseAmountsSequence0", builder=OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0BuilderImpl.class, version="${project.version}")
public interface OptionExerciseAmountsSequence0 extends RosettaModelObject {

	OptionExerciseAmountsSequence0Meta metaData = new OptionExerciseAmountsSequence0Meta();

	/*********************** Getter Methods  ***********************/
	NotionalReference getNotionalReference();
	/**
	 * Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 */
	Money getExerciseInNotionalAmount();
	/**
	 * Specifies the Notional amount after the Change
	 */
	Money getOutstandingNotionalAmount();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountsSequence0 build();
	
	OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder toBuilder();
	
	static OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder builder() {
		return new OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountsSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountsSequence0> getType() {
		return OptionExerciseAmountsSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.class, getExerciseInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.class, getOutstandingNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountsSequence0Builder extends OptionExerciseAmountsSequence0, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference();
		NotionalReference.NotionalReferenceBuilder getNotionalReference();
		Money.MoneyBuilder getOrCreateExerciseInNotionalAmount();
		Money.MoneyBuilder getExerciseInNotionalAmount();
		Money.MoneyBuilder getOrCreateOutstandingNotionalAmount();
		Money.MoneyBuilder getOutstandingNotionalAmount();
		OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder setNotionalReference(NotionalReference notionalReference);
		OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder setExerciseInNotionalAmount(Money exerciseInNotionalAmount);
		OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder setOutstandingNotionalAmount(Money outstandingNotionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.MoneyBuilder.class, getExerciseInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.MoneyBuilder.class, getOutstandingNotionalAmount());
		}
		

		OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountsSequence0  ***********************/
	class OptionExerciseAmountsSequence0Impl implements OptionExerciseAmountsSequence0 {
		private final NotionalReference notionalReference;
		private final Money exerciseInNotionalAmount;
		private final Money outstandingNotionalAmount;
		
		protected OptionExerciseAmountsSequence0Impl(OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder builder) {
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.exerciseInNotionalAmount = ofNullable(builder.getExerciseInNotionalAmount()).map(f->f.build()).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalReference getNotionalReference() {
			return notionalReference;
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
		public OptionExerciseAmountsSequence0 build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder toBuilder() {
			OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder builder) {
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getExerciseInNotionalAmount()).ifPresent(builder::setExerciseInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence0 {" +
				"notionalReference=" + this.notionalReference + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountsSequence0  ***********************/
	class OptionExerciseAmountsSequence0BuilderImpl implements OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder {
	
		protected NotionalReference.NotionalReferenceBuilder notionalReference;
		protected Money.MoneyBuilder exerciseInNotionalAmount;
		protected Money.MoneyBuilder outstandingNotionalAmount;
	
		public OptionExerciseAmountsSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalReference.builder();
			}
			
			return result;
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
		@RosettaAttribute("notionalReference")
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder setNotionalReference(NotionalReference notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder setExerciseInNotionalAmount(Money exerciseInNotionalAmount) {
			this.exerciseInNotionalAmount = exerciseInNotionalAmount==null?null:exerciseInNotionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder setOutstandingNotionalAmount(Money outstandingNotionalAmount) {
			this.outstandingNotionalAmount = outstandingNotionalAmount==null?null:outstandingNotionalAmount.toBuilder();
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence0 build() {
			return new OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Impl(this);
		}
		
		@Override
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder prune() {
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (exerciseInNotionalAmount!=null && !exerciseInNotionalAmount.prune().hasData()) exerciseInNotionalAmount = null;
			if (outstandingNotionalAmount!=null && !outstandingNotionalAmount.prune().hasData()) outstandingNotionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getExerciseInNotionalAmount()!=null && getExerciseInNotionalAmount().hasData()) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder o = (OptionExerciseAmountsSequence0.OptionExerciseAmountsSequence0Builder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getExerciseInNotionalAmount(), o.getExerciseInNotionalAmount(), this::setExerciseInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::setOutstandingNotionalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence0Builder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}
}
