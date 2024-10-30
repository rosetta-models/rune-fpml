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
import fpml.confirmation.NumberOfUnitsReference;
import fpml.confirmation.OptionExerciseAmountsSequence3;
import fpml.confirmation.OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder;
import fpml.confirmation.OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3BuilderImpl;
import fpml.confirmation.OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Impl;
import fpml.confirmation.meta.OptionExerciseAmountsSequence3Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionExerciseAmountsSequence3", builder=OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionExerciseAmountsSequence3 extends RosettaModelObject {

	OptionExerciseAmountsSequence3Meta metaData = new OptionExerciseAmountsSequence3Meta();

	/*********************** Getter Methods  ***********************/
	NumberOfUnitsReference getNumberOfUnitsReference();
	/**
	 * Specifies the fixed amount by which the option should be exercised express as number of units.
	 */
	BigDecimal getExerciseInNumberOfUnits();
	/**
	 * Specifies the Number of Units
	 */
	BigDecimal getOutstandingNumberOfUnits();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountsSequence3 build();
	
	OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder toBuilder();
	
	static OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder builder() {
		return new OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountsSequence3> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountsSequence3> getType() {
		return OptionExerciseAmountsSequence3.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.class, getNumberOfUnitsReference());
		processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountsSequence3Builder extends OptionExerciseAmountsSequence3, RosettaModelObjectBuilder {
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getOrCreateNumberOfUnitsReference();
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getNumberOfUnitsReference();
		OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder setNumberOfUnitsReference(NumberOfUnitsReference numberOfUnitsReference);
		OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder setExerciseInNumberOfUnits(BigDecimal exerciseInNumberOfUnits);
		OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.NumberOfUnitsReferenceBuilder.class, getNumberOfUnitsReference());
			processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		}
		

		OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountsSequence3  ***********************/
	class OptionExerciseAmountsSequence3Impl implements OptionExerciseAmountsSequence3 {
		private final NumberOfUnitsReference numberOfUnitsReference;
		private final BigDecimal exerciseInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		
		protected OptionExerciseAmountsSequence3Impl(OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder builder) {
			this.numberOfUnitsReference = ofNullable(builder.getNumberOfUnitsReference()).map(f->f.build()).orElse(null);
			this.exerciseInNumberOfUnits = builder.getExerciseInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
		}
		
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		public NumberOfUnitsReference getNumberOfUnitsReference() {
			return numberOfUnitsReference;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		public OptionExerciseAmountsSequence3 build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder toBuilder() {
			OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder builder) {
			ofNullable(getNumberOfUnitsReference()).ifPresent(builder::setNumberOfUnitsReference);
			ofNullable(getExerciseInNumberOfUnits()).ifPresent(builder::setExerciseInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence3 _that = getType().cast(o);
		
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence3 {" +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountsSequence3  ***********************/
	class OptionExerciseAmountsSequence3BuilderImpl implements OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder {
	
		protected NumberOfUnitsReference.NumberOfUnitsReferenceBuilder numberOfUnitsReference;
		protected BigDecimal exerciseInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
	
		public OptionExerciseAmountsSequence3BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getNumberOfUnitsReference() {
			return numberOfUnitsReference;
		}
		
		@Override
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getOrCreateNumberOfUnitsReference() {
			NumberOfUnitsReference.NumberOfUnitsReferenceBuilder result;
			if (numberOfUnitsReference!=null) {
				result = numberOfUnitsReference;
			}
			else {
				result = numberOfUnitsReference = NumberOfUnitsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder setNumberOfUnitsReference(NumberOfUnitsReference numberOfUnitsReference) {
			this.numberOfUnitsReference = numberOfUnitsReference==null?null:numberOfUnitsReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseInNumberOfUnits")
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder setExerciseInNumberOfUnits(BigDecimal exerciseInNumberOfUnits) {
			this.exerciseInNumberOfUnits = exerciseInNumberOfUnits==null?null:exerciseInNumberOfUnits;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = outstandingNumberOfUnits==null?null:outstandingNumberOfUnits;
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence3 build() {
			return new OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Impl(this);
		}
		
		@Override
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder prune() {
			if (numberOfUnitsReference!=null && !numberOfUnitsReference.prune().hasData()) numberOfUnitsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfUnitsReference()!=null && getNumberOfUnitsReference().hasData()) return true;
			if (getExerciseInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder o = (OptionExerciseAmountsSequence3.OptionExerciseAmountsSequence3Builder) other;
			
			merger.mergeRosetta(getNumberOfUnitsReference(), o.getNumberOfUnitsReference(), this::setNumberOfUnitsReference);
			
			merger.mergeBasic(getExerciseInNumberOfUnits(), o.getExerciseInNumberOfUnits(), this::setExerciseInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence3 _that = getType().cast(o);
		
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence3Builder {" +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}
}
