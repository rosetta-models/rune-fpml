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
import fpml.confirmation.OptionExerciseAmountModelSequence2;
import fpml.confirmation.OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder;
import fpml.confirmation.OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2BuilderImpl;
import fpml.confirmation.OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Impl;
import fpml.confirmation.meta.OptionExerciseAmountModelSequence2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExerciseAmountModelSequence2", builder=OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2BuilderImpl.class, version="${project.version}")
public interface OptionExerciseAmountModelSequence2 extends RosettaModelObject {

	OptionExerciseAmountModelSequence2Meta metaData = new OptionExerciseAmountModelSequence2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the fixed amount by which the option should be exercised express as number of units.
	 */
	BigDecimal getExerciseInNumberOfUnits();
	/**
	 * Specifies the Number of Units
	 */
	BigDecimal getOutstandingNumberOfUnits();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountModelSequence2 build();
	
	OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder toBuilder();
	
	static OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder builder() {
		return new OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountModelSequence2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountModelSequence2> getType() {
		return OptionExerciseAmountModelSequence2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountModelSequence2Builder extends OptionExerciseAmountModelSequence2, RosettaModelObjectBuilder {
		OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder setExerciseInNumberOfUnits(BigDecimal exerciseInNumberOfUnits);
		OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		}
		

		OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountModelSequence2  ***********************/
	class OptionExerciseAmountModelSequence2Impl implements OptionExerciseAmountModelSequence2 {
		private final BigDecimal exerciseInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		
		protected OptionExerciseAmountModelSequence2Impl(OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder builder) {
			this.exerciseInNumberOfUnits = builder.getExerciseInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
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
		public OptionExerciseAmountModelSequence2 build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder toBuilder() {
			OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder builder) {
			ofNullable(getExerciseInNumberOfUnits()).ifPresent(builder::setExerciseInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModelSequence2 {" +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountModelSequence2  ***********************/
	class OptionExerciseAmountModelSequence2BuilderImpl implements OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder {
	
		protected BigDecimal exerciseInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
	
		public OptionExerciseAmountModelSequence2BuilderImpl() {
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
		@RosettaAttribute("exerciseInNumberOfUnits")
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder setExerciseInNumberOfUnits(BigDecimal exerciseInNumberOfUnits) {
			this.exerciseInNumberOfUnits = exerciseInNumberOfUnits==null?null:exerciseInNumberOfUnits;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = outstandingNumberOfUnits==null?null:outstandingNumberOfUnits;
			return this;
		}
		
		@Override
		public OptionExerciseAmountModelSequence2 build() {
			return new OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Impl(this);
		}
		
		@Override
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder o = (OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder) other;
			
			
			merger.mergeBasic(getExerciseInNumberOfUnits(), o.getExerciseInNumberOfUnits(), this::setExerciseInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModelSequence2Builder {" +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}
}
