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
import fpml.confirmation.TradeChangeAdviceException;
import fpml.confirmation.TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder;
import fpml.confirmation.TradeChangeAdviceException.TradeChangeAdviceExceptionBuilderImpl;
import fpml.confirmation.TradeChangeAdviceException.TradeChangeAdviceExceptionImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.TradeChangeAdviceExceptionMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeChangeAdviceException", builder=TradeChangeAdviceException.TradeChangeAdviceExceptionBuilderImpl.class, version="${project.version}")
public interface TradeChangeAdviceException extends Exception {

	TradeChangeAdviceExceptionMeta metaData = new TradeChangeAdviceExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TradeChangeAdviceException build();
	
	TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder toBuilder();
	
	static TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder() {
		return new TradeChangeAdviceException.TradeChangeAdviceExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeAdviceException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeChangeAdviceException> getType() {
		return TradeChangeAdviceException.class;
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
	interface TradeChangeAdviceExceptionBuilder extends TradeChangeAdviceException, Exception.ExceptionBuilder {
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setExpectedBuild(Integer expectedBuild);
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setActualBuild(Integer actualBuild);
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setHeader(ExceptionMessageHeader header);
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setValidationModel(ValidationModel validationModel);
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeAdviceException  ***********************/
	class TradeChangeAdviceExceptionImpl extends Exception.ExceptionImpl implements TradeChangeAdviceException {
		
		protected TradeChangeAdviceExceptionImpl(TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public TradeChangeAdviceException build() {
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder toBuilder() {
			TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder) {
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
			return "TradeChangeAdviceException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeAdviceException  ***********************/
	class TradeChangeAdviceExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder {
	
	
		public TradeChangeAdviceExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeChangeAdviceException build() {
			return new TradeChangeAdviceException.TradeChangeAdviceExceptionImpl(this);
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder prune() {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder o = (TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder) other;
			
			
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
			return "TradeChangeAdviceExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
