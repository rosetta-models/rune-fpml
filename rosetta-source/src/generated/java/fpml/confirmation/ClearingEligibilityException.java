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
import fpml.confirmation.ClearingEligibilityException;
import fpml.confirmation.ClearingEligibilityException.ClearingEligibilityExceptionBuilder;
import fpml.confirmation.ClearingEligibilityException.ClearingEligibilityExceptionBuilderImpl;
import fpml.confirmation.ClearingEligibilityException.ClearingEligibilityExceptionImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.Exception;
import fpml.confirmation.Exception.ExceptionBuilder;
import fpml.confirmation.Exception.ExceptionBuilderImpl;
import fpml.confirmation.Exception.ExceptionImpl;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ClearingEligibilityExceptionMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingEligibilityException", builder=ClearingEligibilityException.ClearingEligibilityExceptionBuilderImpl.class, version="${project.version}")
public interface ClearingEligibilityException extends Exception {

	ClearingEligibilityExceptionMeta metaData = new ClearingEligibilityExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ClearingEligibilityException build();
	
	ClearingEligibilityException.ClearingEligibilityExceptionBuilder toBuilder();
	
	static ClearingEligibilityException.ClearingEligibilityExceptionBuilder builder() {
		return new ClearingEligibilityException.ClearingEligibilityExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingEligibilityException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingEligibilityException> getType() {
		return ClearingEligibilityException.class;
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
	interface ClearingEligibilityExceptionBuilder extends ClearingEligibilityException, Exception.ExceptionBuilder {
		ClearingEligibilityException.ClearingEligibilityExceptionBuilder setExpectedBuild(Integer expectedBuild);
		ClearingEligibilityException.ClearingEligibilityExceptionBuilder setActualBuild(Integer actualBuild);
		ClearingEligibilityException.ClearingEligibilityExceptionBuilder setHeader(ExceptionMessageHeader header);
		ClearingEligibilityException.ClearingEligibilityExceptionBuilder setValidationModel(ValidationModel validationModel);
		ClearingEligibilityException.ClearingEligibilityExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ClearingEligibilityException.ClearingEligibilityExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		ClearingEligibilityException.ClearingEligibilityExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingEligibilityException  ***********************/
	class ClearingEligibilityExceptionImpl extends Exception.ExceptionImpl implements ClearingEligibilityException {
		
		protected ClearingEligibilityExceptionImpl(ClearingEligibilityException.ClearingEligibilityExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public ClearingEligibilityException build() {
			return this;
		}
		
		@Override
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder toBuilder() {
			ClearingEligibilityException.ClearingEligibilityExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingEligibilityException.ClearingEligibilityExceptionBuilder builder) {
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
			return "ClearingEligibilityException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingEligibilityException  ***********************/
	class ClearingEligibilityExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements ClearingEligibilityException.ClearingEligibilityExceptionBuilder {
	
	
		public ClearingEligibilityExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public ClearingEligibilityException build() {
			return new ClearingEligibilityException.ClearingEligibilityExceptionImpl(this);
		}
		
		@Override
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder prune() {
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
		public ClearingEligibilityException.ClearingEligibilityExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ClearingEligibilityException.ClearingEligibilityExceptionBuilder o = (ClearingEligibilityException.ClearingEligibilityExceptionBuilder) other;
			
			
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
			return "ClearingEligibilityExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
