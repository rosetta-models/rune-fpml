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
import fpml.confirmation.TradeReferenceInformationUpdateException;
import fpml.confirmation.TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder;
import fpml.confirmation.TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilderImpl;
import fpml.confirmation.TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.TradeReferenceInformationUpdateExceptionMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradeReferenceInformationUpdateException", builder=TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradeReferenceInformationUpdateException extends Exception {

	TradeReferenceInformationUpdateExceptionMeta metaData = new TradeReferenceInformationUpdateExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TradeReferenceInformationUpdateException build();
	
	TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder toBuilder();
	
	static TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder() {
		return new TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReferenceInformationUpdateException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeReferenceInformationUpdateException> getType() {
		return TradeReferenceInformationUpdateException.class;
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
	interface TradeReferenceInformationUpdateExceptionBuilder extends TradeReferenceInformationUpdateException, Exception.ExceptionBuilder {
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setExpectedBuild(Integer expectedBuild);
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setActualBuild(Integer actualBuild);
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setHeader(ExceptionMessageHeader header);
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setValidationModel(ValidationModel validationModel);
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of TradeReferenceInformationUpdateException  ***********************/
	class TradeReferenceInformationUpdateExceptionImpl extends Exception.ExceptionImpl implements TradeReferenceInformationUpdateException {
		
		protected TradeReferenceInformationUpdateExceptionImpl(TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public TradeReferenceInformationUpdateException build() {
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder toBuilder() {
			TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder) {
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
			return "TradeReferenceInformationUpdateException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeReferenceInformationUpdateException  ***********************/
	class TradeReferenceInformationUpdateExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder {
	
	
		public TradeReferenceInformationUpdateExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException build() {
			return new TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionImpl(this);
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder prune() {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder o = (TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder) other;
			
			
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
			return "TradeReferenceInformationUpdateExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
