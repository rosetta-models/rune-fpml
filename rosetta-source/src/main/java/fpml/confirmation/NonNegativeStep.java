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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.NonNegativeStep;
import fpml.confirmation.NonNegativeStep.NonNegativeStepBuilder;
import fpml.confirmation.NonNegativeStep.NonNegativeStepBuilderImpl;
import fpml.confirmation.NonNegativeStep.NonNegativeStepImpl;
import fpml.confirmation.StepBase;
import fpml.confirmation.StepBase.StepBaseBuilder;
import fpml.confirmation.StepBase.StepBaseBuilderImpl;
import fpml.confirmation.StepBase.StepBaseImpl;
import fpml.confirmation.meta.NonNegativeStepMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a step date and non-negative step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="NonNegativeStep", builder=NonNegativeStep.NonNegativeStepBuilderImpl.class, version="${project.version}")
public interface NonNegativeStep extends StepBase {

	NonNegativeStepMeta metaData = new NonNegativeStepMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
	 */
	BigDecimal getStepValue();

	/*********************** Build Methods  ***********************/
	NonNegativeStep build();
	
	NonNegativeStep.NonNegativeStepBuilder toBuilder();
	
	static NonNegativeStep.NonNegativeStepBuilder builder() {
		return new NonNegativeStep.NonNegativeStepBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeStep> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonNegativeStep> getType() {
		return NonNegativeStep.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("stepDate"), Date.class, getStepDate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("stepValue"), BigDecimal.class, getStepValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeStepBuilder extends NonNegativeStep, StepBase.StepBaseBuilder {
		NonNegativeStep.NonNegativeStepBuilder setStepDate(Date stepDate);
		NonNegativeStep.NonNegativeStepBuilder setId(String id);
		NonNegativeStep.NonNegativeStepBuilder setStepValue(BigDecimal stepValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("stepDate"), Date.class, getStepDate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("stepValue"), BigDecimal.class, getStepValue(), this);
		}
		

		NonNegativeStep.NonNegativeStepBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeStep  ***********************/
	class NonNegativeStepImpl extends StepBase.StepBaseImpl implements NonNegativeStep {
		private final BigDecimal stepValue;
		
		protected NonNegativeStepImpl(NonNegativeStep.NonNegativeStepBuilder builder) {
			super(builder);
			this.stepValue = builder.getStepValue();
		}
		
		@Override
		@RosettaAttribute("stepValue")
		public BigDecimal getStepValue() {
			return stepValue;
		}
		
		@Override
		public NonNegativeStep build() {
			return this;
		}
		
		@Override
		public NonNegativeStep.NonNegativeStepBuilder toBuilder() {
			NonNegativeStep.NonNegativeStepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeStep.NonNegativeStepBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStepValue()).ifPresent(builder::setStepValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeStep _that = getType().cast(o);
		
			if (!Objects.equals(stepValue, _that.getStepValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (stepValue != null ? stepValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeStep {" +
				"stepValue=" + this.stepValue +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeStep  ***********************/
	class NonNegativeStepBuilderImpl extends StepBase.StepBaseBuilderImpl  implements NonNegativeStep.NonNegativeStepBuilder {
	
		protected BigDecimal stepValue;
	
		public NonNegativeStepBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("stepValue")
		public BigDecimal getStepValue() {
			return stepValue;
		}
		
		@Override
		@RosettaAttribute("stepDate")
		public NonNegativeStep.NonNegativeStepBuilder setStepDate(Date stepDate) {
			this.stepDate = stepDate==null?null:stepDate;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public NonNegativeStep.NonNegativeStepBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("stepValue")
		public NonNegativeStep.NonNegativeStepBuilder setStepValue(BigDecimal stepValue) {
			this.stepValue = stepValue==null?null:stepValue;
			return this;
		}
		
		@Override
		public NonNegativeStep build() {
			return new NonNegativeStep.NonNegativeStepImpl(this);
		}
		
		@Override
		public NonNegativeStep.NonNegativeStepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeStep.NonNegativeStepBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStepValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeStep.NonNegativeStepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonNegativeStep.NonNegativeStepBuilder o = (NonNegativeStep.NonNegativeStepBuilder) other;
			
			
			merger.mergeBasic(getStepValue(), o.getStepValue(), this::setStepValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeStep _that = getType().cast(o);
		
			if (!Objects.equals(stepValue, _that.getStepValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (stepValue != null ? stepValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeStepBuilder {" +
				"stepValue=" + this.stepValue +
			'}' + " " + super.toString();
		}
	}
}
