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
import fpml.confirmation.ExecutionException;
import fpml.confirmation.ExecutionException.ExecutionExceptionBuilder;
import fpml.confirmation.ExecutionException.ExecutionExceptionBuilderImpl;
import fpml.confirmation.ExecutionException.ExecutionExceptionImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ExecutionExceptionMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="ExecutionException", builder=ExecutionException.ExecutionExceptionBuilderImpl.class, version="${project.version}")
public interface ExecutionException extends Exception {

	ExecutionExceptionMeta metaData = new ExecutionExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ExecutionException build();
	
	ExecutionException.ExecutionExceptionBuilder toBuilder();
	
	static ExecutionException.ExecutionExceptionBuilder builder() {
		return new ExecutionException.ExecutionExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionException> getType() {
		return ExecutionException.class;
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
	interface ExecutionExceptionBuilder extends ExecutionException, Exception.ExceptionBuilder {
		ExecutionException.ExecutionExceptionBuilder setExpectedBuild(Integer expectedBuild);
		ExecutionException.ExecutionExceptionBuilder setActualBuild(Integer actualBuild);
		ExecutionException.ExecutionExceptionBuilder setHeader(ExceptionMessageHeader header);
		ExecutionException.ExecutionExceptionBuilder setValidationModel(ValidationModel validationModel);
		ExecutionException.ExecutionExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ExecutionException.ExecutionExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		ExecutionException.ExecutionExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionException  ***********************/
	class ExecutionExceptionImpl extends Exception.ExceptionImpl implements ExecutionException {
		
		protected ExecutionExceptionImpl(ExecutionException.ExecutionExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public ExecutionException build() {
			return this;
		}
		
		@Override
		public ExecutionException.ExecutionExceptionBuilder toBuilder() {
			ExecutionException.ExecutionExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionException.ExecutionExceptionBuilder builder) {
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
			return "ExecutionException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExecutionException  ***********************/
	class ExecutionExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements ExecutionException.ExecutionExceptionBuilder {
	
	
		public ExecutionExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ExecutionException.ExecutionExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ExecutionException.ExecutionExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ExecutionException.ExecutionExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ExecutionException.ExecutionExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ExecutionException.ExecutionExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public ExecutionException.ExecutionExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionException build() {
			return new ExecutionException.ExecutionExceptionImpl(this);
		}
		
		@Override
		public ExecutionException.ExecutionExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionException.ExecutionExceptionBuilder prune() {
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
		public ExecutionException.ExecutionExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExecutionException.ExecutionExceptionBuilder o = (ExecutionException.ExecutionExceptionBuilder) other;
			
			
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
			return "ExecutionExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
