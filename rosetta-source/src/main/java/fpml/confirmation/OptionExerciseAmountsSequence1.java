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
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.OptionExerciseAmountsSequence1;
import fpml.confirmation.OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder;
import fpml.confirmation.OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1BuilderImpl;
import fpml.confirmation.OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Impl;
import fpml.confirmation.meta.OptionExerciseAmountsSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionExerciseAmountsSequence1", builder=OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionExerciseAmountsSequence1 extends RosettaModelObject {

	OptionExerciseAmountsSequence1Meta metaData = new OptionExerciseAmountsSequence1Meta();

	/*********************** Getter Methods  ***********************/
	NotionalReference getNotionalScheduleReference();
	/**
	 * Specifies the amount by which the option should be exercised expressed as notional schedule.
	 */
	NonNegativeAmountSchedule getExerciseInNotionalSchedule();
	/**
	 * Specifies the Notional schedule after the Change
	 */
	NonNegativeAmountSchedule getOutstandingNotionalSchedule();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountsSequence1 build();
	
	OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder toBuilder();
	
	static OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder builder() {
		return new OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountsSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountsSequence1> getType() {
		return OptionExerciseAmountsSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.class, getNotionalScheduleReference());
		processRosetta(path.newSubPath("exerciseInNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getExerciseInNotionalSchedule());
		processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getOutstandingNotionalSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountsSequence1Builder extends OptionExerciseAmountsSequence1, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalScheduleReference();
		NotionalReference.NotionalReferenceBuilder getNotionalScheduleReference();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateExerciseInNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getExerciseInNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateOutstandingNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOutstandingNotionalSchedule();
		OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder setNotionalScheduleReference(NotionalReference notionalScheduleReference);
		OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder setExerciseInNotionalSchedule(NonNegativeAmountSchedule exerciseInNotionalSchedule);
		OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder setOutstandingNotionalSchedule(NonNegativeAmountSchedule outstandingNotionalSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalScheduleReference());
			processRosetta(path.newSubPath("exerciseInNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getExerciseInNotionalSchedule());
			processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getOutstandingNotionalSchedule());
		}
		

		OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountsSequence1  ***********************/
	class OptionExerciseAmountsSequence1Impl implements OptionExerciseAmountsSequence1 {
		private final NotionalReference notionalScheduleReference;
		private final NonNegativeAmountSchedule exerciseInNotionalSchedule;
		private final NonNegativeAmountSchedule outstandingNotionalSchedule;
		
		protected OptionExerciseAmountsSequence1Impl(OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder builder) {
			this.notionalScheduleReference = ofNullable(builder.getNotionalScheduleReference()).map(f->f.build()).orElse(null);
			this.exerciseInNotionalSchedule = ofNullable(builder.getExerciseInNotionalSchedule()).map(f->f.build()).orElse(null);
			this.outstandingNotionalSchedule = ofNullable(builder.getOutstandingNotionalSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalScheduleReference")
		public NotionalReference getNotionalScheduleReference() {
			return notionalScheduleReference;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalSchedule")
		public NonNegativeAmountSchedule getExerciseInNotionalSchedule() {
			return exerciseInNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		public NonNegativeAmountSchedule getOutstandingNotionalSchedule() {
			return outstandingNotionalSchedule;
		}
		
		@Override
		public OptionExerciseAmountsSequence1 build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder toBuilder() {
			OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder builder) {
			ofNullable(getNotionalScheduleReference()).ifPresent(builder::setNotionalScheduleReference);
			ofNullable(getExerciseInNotionalSchedule()).ifPresent(builder::setExerciseInNotionalSchedule);
			ofNullable(getOutstandingNotionalSchedule()).ifPresent(builder::setOutstandingNotionalSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(exerciseInNotionalSchedule, _that.getExerciseInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalSchedule != null ? exerciseInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence1 {" +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"exerciseInNotionalSchedule=" + this.exerciseInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountsSequence1  ***********************/
	class OptionExerciseAmountsSequence1BuilderImpl implements OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder {
	
		protected NotionalReference.NotionalReferenceBuilder notionalScheduleReference;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder exerciseInNotionalSchedule;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder outstandingNotionalSchedule;
	
		public OptionExerciseAmountsSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalScheduleReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalScheduleReference() {
			return notionalScheduleReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalScheduleReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalScheduleReference!=null) {
				result = notionalScheduleReference;
			}
			else {
				result = notionalScheduleReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getExerciseInNotionalSchedule() {
			return exerciseInNotionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateExerciseInNotionalSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (exerciseInNotionalSchedule!=null) {
				result = exerciseInNotionalSchedule;
			}
			else {
				result = exerciseInNotionalSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOutstandingNotionalSchedule() {
			return outstandingNotionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateOutstandingNotionalSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (outstandingNotionalSchedule!=null) {
				result = outstandingNotionalSchedule;
			}
			else {
				result = outstandingNotionalSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalScheduleReference")
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder setNotionalScheduleReference(NotionalReference notionalScheduleReference) {
			this.notionalScheduleReference = notionalScheduleReference==null?null:notionalScheduleReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseInNotionalSchedule")
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder setExerciseInNotionalSchedule(NonNegativeAmountSchedule exerciseInNotionalSchedule) {
			this.exerciseInNotionalSchedule = exerciseInNotionalSchedule==null?null:exerciseInNotionalSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder setOutstandingNotionalSchedule(NonNegativeAmountSchedule outstandingNotionalSchedule) {
			this.outstandingNotionalSchedule = outstandingNotionalSchedule==null?null:outstandingNotionalSchedule.toBuilder();
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence1 build() {
			return new OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Impl(this);
		}
		
		@Override
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder prune() {
			if (notionalScheduleReference!=null && !notionalScheduleReference.prune().hasData()) notionalScheduleReference = null;
			if (exerciseInNotionalSchedule!=null && !exerciseInNotionalSchedule.prune().hasData()) exerciseInNotionalSchedule = null;
			if (outstandingNotionalSchedule!=null && !outstandingNotionalSchedule.prune().hasData()) outstandingNotionalSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalScheduleReference()!=null && getNotionalScheduleReference().hasData()) return true;
			if (getExerciseInNotionalSchedule()!=null && getExerciseInNotionalSchedule().hasData()) return true;
			if (getOutstandingNotionalSchedule()!=null && getOutstandingNotionalSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder o = (OptionExerciseAmountsSequence1.OptionExerciseAmountsSequence1Builder) other;
			
			merger.mergeRosetta(getNotionalScheduleReference(), o.getNotionalScheduleReference(), this::setNotionalScheduleReference);
			merger.mergeRosetta(getExerciseInNotionalSchedule(), o.getExerciseInNotionalSchedule(), this::setExerciseInNotionalSchedule);
			merger.mergeRosetta(getOutstandingNotionalSchedule(), o.getOutstandingNotionalSchedule(), this::setOutstandingNotionalSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(exerciseInNotionalSchedule, _that.getExerciseInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalSchedule != null ? exerciseInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence1Builder {" +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"exerciseInNotionalSchedule=" + this.exerciseInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule +
			'}';
		}
	}
}
