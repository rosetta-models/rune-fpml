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
import fpml.confirmation.ConfirmationException;
import fpml.confirmation.ConfirmationException.ConfirmationExceptionBuilder;
import fpml.confirmation.ConfirmationException.ConfirmationExceptionBuilderImpl;
import fpml.confirmation.ConfirmationException.ConfirmationExceptionImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.Exception;
import fpml.confirmation.Exception.ExceptionBuilder;
import fpml.confirmation.Exception.ExceptionBuilderImpl;
import fpml.confirmation.Exception.ExceptionImpl;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ConfirmationExceptionMeta;


/**
 * A message sent to inform another system that some exception has been detected.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ConfirmationException", builder=ConfirmationException.ConfirmationExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ConfirmationException extends Exception {

	ConfirmationExceptionMeta metaData = new ConfirmationExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ConfirmationException build();
	
	ConfirmationException.ConfirmationExceptionBuilder toBuilder();
	
	static ConfirmationException.ConfirmationExceptionBuilder builder() {
		return new ConfirmationException.ConfirmationExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConfirmationException> getType() {
		return ConfirmationException.class;
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
	interface ConfirmationExceptionBuilder extends ConfirmationException, Exception.ExceptionBuilder {
		ConfirmationException.ConfirmationExceptionBuilder setExpectedBuild(Integer expectedBuild);
		ConfirmationException.ConfirmationExceptionBuilder setActualBuild(Integer actualBuild);
		ConfirmationException.ConfirmationExceptionBuilder setHeader(ExceptionMessageHeader header);
		ConfirmationException.ConfirmationExceptionBuilder setValidationModel(ValidationModel validationModel);
		ConfirmationException.ConfirmationExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ConfirmationException.ConfirmationExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		ConfirmationException.ConfirmationExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationException  ***********************/
	class ConfirmationExceptionImpl extends Exception.ExceptionImpl implements ConfirmationException {
		
		protected ConfirmationExceptionImpl(ConfirmationException.ConfirmationExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public ConfirmationException build() {
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder toBuilder() {
			ConfirmationException.ConfirmationExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationException.ConfirmationExceptionBuilder builder) {
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
			return "ConfirmationException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConfirmationException  ***********************/
	class ConfirmationExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements ConfirmationException.ConfirmationExceptionBuilder {
	
	
		public ConfirmationExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ConfirmationException.ConfirmationExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ConfirmationException.ConfirmationExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ConfirmationException.ConfirmationExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ConfirmationException.ConfirmationExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ConfirmationException.ConfirmationExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public ConfirmationException.ConfirmationExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public ConfirmationException build() {
			return new ConfirmationException.ConfirmationExceptionImpl(this);
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder prune() {
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
		public ConfirmationException.ConfirmationExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConfirmationException.ConfirmationExceptionBuilder o = (ConfirmationException.ConfirmationExceptionBuilder) other;
			
			
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
			return "ConfirmationExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
