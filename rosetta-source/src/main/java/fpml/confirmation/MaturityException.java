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
import fpml.confirmation.MaturityException;
import fpml.confirmation.MaturityException.MaturityExceptionBuilder;
import fpml.confirmation.MaturityException.MaturityExceptionBuilderImpl;
import fpml.confirmation.MaturityException.MaturityExceptionImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.MaturityExceptionMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MaturityException", builder=MaturityException.MaturityExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MaturityException extends Exception {

	MaturityExceptionMeta metaData = new MaturityExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MaturityException build();
	
	MaturityException.MaturityExceptionBuilder toBuilder();
	
	static MaturityException.MaturityExceptionBuilder builder() {
		return new MaturityException.MaturityExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MaturityException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MaturityException> getType() {
		return MaturityException.class;
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
	interface MaturityExceptionBuilder extends MaturityException, Exception.ExceptionBuilder {
		MaturityException.MaturityExceptionBuilder setExpectedBuild(Integer expectedBuild);
		MaturityException.MaturityExceptionBuilder setActualBuild(Integer actualBuild);
		MaturityException.MaturityExceptionBuilder setHeader(ExceptionMessageHeader header);
		MaturityException.MaturityExceptionBuilder setValidationModel(ValidationModel validationModel);
		MaturityException.MaturityExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		MaturityException.MaturityExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		MaturityException.MaturityExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of MaturityException  ***********************/
	class MaturityExceptionImpl extends Exception.ExceptionImpl implements MaturityException {
		
		protected MaturityExceptionImpl(MaturityException.MaturityExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public MaturityException build() {
			return this;
		}
		
		@Override
		public MaturityException.MaturityExceptionBuilder toBuilder() {
			MaturityException.MaturityExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MaturityException.MaturityExceptionBuilder builder) {
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
			return "MaturityException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MaturityException  ***********************/
	class MaturityExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements MaturityException.MaturityExceptionBuilder {
	
	
		public MaturityExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public MaturityException.MaturityExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public MaturityException.MaturityExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public MaturityException.MaturityExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public MaturityException.MaturityExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public MaturityException.MaturityExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public MaturityException.MaturityExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public MaturityException build() {
			return new MaturityException.MaturityExceptionImpl(this);
		}
		
		@Override
		public MaturityException.MaturityExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityException.MaturityExceptionBuilder prune() {
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
		public MaturityException.MaturityExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MaturityException.MaturityExceptionBuilder o = (MaturityException.MaturityExceptionBuilder) other;
			
			
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
			return "MaturityExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
