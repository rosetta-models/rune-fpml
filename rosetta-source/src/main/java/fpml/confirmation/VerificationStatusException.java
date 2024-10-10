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
import fpml.confirmation.ValidationModel;
import fpml.confirmation.VerificationStatusException;
import fpml.confirmation.VerificationStatusException.VerificationStatusExceptionBuilder;
import fpml.confirmation.VerificationStatusException.VerificationStatusExceptionBuilderImpl;
import fpml.confirmation.VerificationStatusException.VerificationStatusExceptionImpl;
import fpml.confirmation.meta.VerificationStatusExceptionMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="VerificationStatusException", builder=VerificationStatusException.VerificationStatusExceptionBuilderImpl.class, version="${project.version}")
public interface VerificationStatusException extends Exception {

	VerificationStatusExceptionMeta metaData = new VerificationStatusExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	VerificationStatusException build();
	
	VerificationStatusException.VerificationStatusExceptionBuilder toBuilder();
	
	static VerificationStatusException.VerificationStatusExceptionBuilder builder() {
		return new VerificationStatusException.VerificationStatusExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VerificationStatusException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VerificationStatusException> getType() {
		return VerificationStatusException.class;
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
	interface VerificationStatusExceptionBuilder extends VerificationStatusException, Exception.ExceptionBuilder {
		VerificationStatusException.VerificationStatusExceptionBuilder setExpectedBuild(Integer expectedBuild);
		VerificationStatusException.VerificationStatusExceptionBuilder setActualBuild(Integer actualBuild);
		VerificationStatusException.VerificationStatusExceptionBuilder setHeader(ExceptionMessageHeader header);
		VerificationStatusException.VerificationStatusExceptionBuilder setValidationModel(ValidationModel validationModel);
		VerificationStatusException.VerificationStatusExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		VerificationStatusException.VerificationStatusExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		VerificationStatusException.VerificationStatusExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of VerificationStatusException  ***********************/
	class VerificationStatusExceptionImpl extends Exception.ExceptionImpl implements VerificationStatusException {
		
		protected VerificationStatusExceptionImpl(VerificationStatusException.VerificationStatusExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public VerificationStatusException build() {
			return this;
		}
		
		@Override
		public VerificationStatusException.VerificationStatusExceptionBuilder toBuilder() {
			VerificationStatusException.VerificationStatusExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VerificationStatusException.VerificationStatusExceptionBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "VerificationStatusException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VerificationStatusException  ***********************/
	class VerificationStatusExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements VerificationStatusException.VerificationStatusExceptionBuilder {
	
	
		public VerificationStatusExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public VerificationStatusException.VerificationStatusExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public VerificationStatusException.VerificationStatusExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public VerificationStatusException.VerificationStatusExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public VerificationStatusException.VerificationStatusExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public VerificationStatusException.VerificationStatusExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public VerificationStatusException.VerificationStatusExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public VerificationStatusException build() {
			return new VerificationStatusException.VerificationStatusExceptionImpl(this);
		}
		
		@Override
		public VerificationStatusException.VerificationStatusExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatusException.VerificationStatusExceptionBuilder prune() {
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
		public VerificationStatusException.VerificationStatusExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VerificationStatusException.VerificationStatusExceptionBuilder o = (VerificationStatusException.VerificationStatusExceptionBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "VerificationStatusExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
