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
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.Exception;
import fpml.confirmation.Exception.ExceptionBuilder;
import fpml.confirmation.Exception.ExceptionBuilderImpl;
import fpml.confirmation.Exception.ExceptionImpl;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.ExecutionAdviceException;
import fpml.confirmation.ExecutionAdviceException.ExecutionAdviceExceptionBuilder;
import fpml.confirmation.ExecutionAdviceException.ExecutionAdviceExceptionBuilderImpl;
import fpml.confirmation.ExecutionAdviceException.ExecutionAdviceExceptionImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ExecutionAdviceExceptionMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExecutionAdviceException", builder=ExecutionAdviceException.ExecutionAdviceExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExecutionAdviceException extends Exception {

	ExecutionAdviceExceptionMeta metaData = new ExecutionAdviceExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ExecutionAdviceException build();
	
	ExecutionAdviceException.ExecutionAdviceExceptionBuilder toBuilder();
	
	static ExecutionAdviceException.ExecutionAdviceExceptionBuilder builder() {
		return new ExecutionAdviceException.ExecutionAdviceExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionAdviceException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionAdviceException> getType() {
		return ExecutionAdviceException.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.class, getExceptionModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionAdviceExceptionBuilder extends ExecutionAdviceException, Exception.ExceptionBuilder {
		ExecutionAdviceException.ExecutionAdviceExceptionBuilder setExpectedBuild(Integer expectedBuild);
		ExecutionAdviceException.ExecutionAdviceExceptionBuilder setActualBuild(Integer actualBuild);
		ExecutionAdviceException.ExecutionAdviceExceptionBuilder setHeader(ExceptionMessageHeader header);
		ExecutionAdviceException.ExecutionAdviceExceptionBuilder setValidationModel(ValidationModel validationModel);
		ExecutionAdviceException.ExecutionAdviceExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ExecutionAdviceException.ExecutionAdviceExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		ExecutionAdviceException.ExecutionAdviceExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionAdviceException  ***********************/
	class ExecutionAdviceExceptionImpl extends Exception.ExceptionImpl implements ExecutionAdviceException {
		
		protected ExecutionAdviceExceptionImpl(ExecutionAdviceException.ExecutionAdviceExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public ExecutionAdviceException build() {
			return this;
		}
		
		@Override
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder toBuilder() {
			ExecutionAdviceException.ExecutionAdviceExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionAdviceException.ExecutionAdviceExceptionBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAdviceException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExecutionAdviceException  ***********************/
	class ExecutionAdviceExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements ExecutionAdviceException.ExecutionAdviceExceptionBuilder {
	
	
		public ExecutionAdviceExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionAdviceException build() {
			return new ExecutionAdviceException.ExecutionAdviceExceptionImpl(this);
		}
		
		@Override
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAdviceException.ExecutionAdviceExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExecutionAdviceException.ExecutionAdviceExceptionBuilder o = (ExecutionAdviceException.ExecutionAdviceExceptionBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAdviceExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
