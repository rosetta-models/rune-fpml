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
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.OptionExerciseAmountsSequence2;
import fpml.confirmation.OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder;
import fpml.confirmation.OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2BuilderImpl;
import fpml.confirmation.OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Impl;
import fpml.confirmation.meta.OptionExerciseAmountsSequence2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExerciseAmountsSequence2", builder=OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2BuilderImpl.class, version="${project.version}")
public interface OptionExerciseAmountsSequence2 extends RosettaModelObject {

	OptionExerciseAmountsSequence2Meta metaData = new OptionExerciseAmountsSequence2Meta();

	/*********************** Getter Methods  ***********************/
	NumberOfOptionsReference getNumberOfOptionsReference();
	/**
	 * Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 */
	BigDecimal getExerciseInNumberOfOptions();
	/**
	 * Specifies the Number of Options after the Change.
	 */
	BigDecimal getOutstandingNumberOfOptions();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountsSequence2 build();
	
	OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder toBuilder();
	
	static OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder builder() {
		return new OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountsSequence2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountsSequence2> getType() {
		return OptionExerciseAmountsSequence2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.class, getNumberOfOptionsReference());
		processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountsSequence2Builder extends OptionExerciseAmountsSequence2, RosettaModelObjectBuilder {
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getOrCreateNumberOfOptionsReference();
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getNumberOfOptionsReference();
		OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder setNumberOfOptionsReference(NumberOfOptionsReference numberOfOptionsReference);
		OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder setExerciseInNumberOfOptions(BigDecimal exerciseInNumberOfOptions);
		OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.NumberOfOptionsReferenceBuilder.class, getNumberOfOptionsReference());
			processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		}
		

		OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountsSequence2  ***********************/
	class OptionExerciseAmountsSequence2Impl implements OptionExerciseAmountsSequence2 {
		private final NumberOfOptionsReference numberOfOptionsReference;
		private final BigDecimal exerciseInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		
		protected OptionExerciseAmountsSequence2Impl(OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder builder) {
			this.numberOfOptionsReference = ofNullable(builder.getNumberOfOptionsReference()).map(f->f.build()).orElse(null);
			this.exerciseInNumberOfOptions = builder.getExerciseInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		public NumberOfOptionsReference getNumberOfOptionsReference() {
			return numberOfOptionsReference;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		public OptionExerciseAmountsSequence2 build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder toBuilder() {
			OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder builder) {
			ofNullable(getNumberOfOptionsReference()).ifPresent(builder::setNumberOfOptionsReference);
			ofNullable(getExerciseInNumberOfOptions()).ifPresent(builder::setExerciseInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence2 {" +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountsSequence2  ***********************/
	class OptionExerciseAmountsSequence2BuilderImpl implements OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder {
	
		protected NumberOfOptionsReference.NumberOfOptionsReferenceBuilder numberOfOptionsReference;
		protected BigDecimal exerciseInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
	
		public OptionExerciseAmountsSequence2BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getNumberOfOptionsReference() {
			return numberOfOptionsReference;
		}
		
		@Override
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getOrCreateNumberOfOptionsReference() {
			NumberOfOptionsReference.NumberOfOptionsReferenceBuilder result;
			if (numberOfOptionsReference!=null) {
				result = numberOfOptionsReference;
			}
			else {
				result = numberOfOptionsReference = NumberOfOptionsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder setNumberOfOptionsReference(NumberOfOptionsReference numberOfOptionsReference) {
			this.numberOfOptionsReference = numberOfOptionsReference==null?null:numberOfOptionsReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder setExerciseInNumberOfOptions(BigDecimal exerciseInNumberOfOptions) {
			this.exerciseInNumberOfOptions = exerciseInNumberOfOptions==null?null:exerciseInNumberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = outstandingNumberOfOptions==null?null:outstandingNumberOfOptions;
			return this;
		}
		
		@Override
		public OptionExerciseAmountsSequence2 build() {
			return new OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Impl(this);
		}
		
		@Override
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder prune() {
			if (numberOfOptionsReference!=null && !numberOfOptionsReference.prune().hasData()) numberOfOptionsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfOptionsReference()!=null && getNumberOfOptionsReference().hasData()) return true;
			if (getExerciseInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder o = (OptionExerciseAmountsSequence2.OptionExerciseAmountsSequence2Builder) other;
			
			merger.mergeRosetta(getNumberOfOptionsReference(), o.getNumberOfOptionsReference(), this::setNumberOfOptionsReference);
			
			merger.mergeBasic(getExerciseInNumberOfOptions(), o.getExerciseInNumberOfOptions(), this::setExerciseInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountsSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsSequence2Builder {" +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}
}
