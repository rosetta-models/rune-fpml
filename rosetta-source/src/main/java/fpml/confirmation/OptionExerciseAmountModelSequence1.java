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
import fpml.confirmation.OptionExerciseAmountModelSequence1;
import fpml.confirmation.OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder;
import fpml.confirmation.OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1BuilderImpl;
import fpml.confirmation.OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Impl;
import fpml.confirmation.meta.OptionExerciseAmountModelSequence1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExerciseAmountModelSequence1", builder=OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1BuilderImpl.class, version="${project.version}")
public interface OptionExerciseAmountModelSequence1 extends RosettaModelObject {

	OptionExerciseAmountModelSequence1Meta metaData = new OptionExerciseAmountModelSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 */
	BigDecimal getExerciseInNumberOfOptions();
	/**
	 * Specifies the Number of Options after the Change.
	 */
	BigDecimal getOutstandingNumberOfOptions();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountModelSequence1 build();
	
	OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder toBuilder();
	
	static OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder builder() {
		return new OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountModelSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountModelSequence1> getType() {
		return OptionExerciseAmountModelSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountModelSequence1Builder extends OptionExerciseAmountModelSequence1, RosettaModelObjectBuilder {
		OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder setExerciseInNumberOfOptions(BigDecimal exerciseInNumberOfOptions);
		OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		}
		

		OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountModelSequence1  ***********************/
	class OptionExerciseAmountModelSequence1Impl implements OptionExerciseAmountModelSequence1 {
		private final BigDecimal exerciseInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		
		protected OptionExerciseAmountModelSequence1Impl(OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder builder) {
			this.exerciseInNumberOfOptions = builder.getExerciseInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
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
		public OptionExerciseAmountModelSequence1 build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder toBuilder() {
			OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder builder) {
			ofNullable(getExerciseInNumberOfOptions()).ifPresent(builder::setExerciseInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModelSequence1 {" +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountModelSequence1  ***********************/
	class OptionExerciseAmountModelSequence1BuilderImpl implements OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder {
	
		protected BigDecimal exerciseInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
	
		public OptionExerciseAmountModelSequence1BuilderImpl() {
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
		@RosettaAttribute("exerciseInNumberOfOptions")
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder setExerciseInNumberOfOptions(BigDecimal exerciseInNumberOfOptions) {
			this.exerciseInNumberOfOptions = exerciseInNumberOfOptions==null?null:exerciseInNumberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = outstandingNumberOfOptions==null?null:outstandingNumberOfOptions;
			return this;
		}
		
		@Override
		public OptionExerciseAmountModelSequence1 build() {
			return new OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Impl(this);
		}
		
		@Override
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder o = (OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder) other;
			
			
			merger.mergeBasic(getExerciseInNumberOfOptions(), o.getExerciseInNumberOfOptions(), this::setExerciseInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModelSequence1Builder {" +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}
}
