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
import fpml.confirmation.Message;
import fpml.confirmation.Message.MessageBuilder;
import fpml.confirmation.Message.MessageBuilderImpl;
import fpml.confirmation.Message.MessageImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ExceptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the basic content for a message sent to inform another system that some exception has been detected.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Exception", builder=Exception.ExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Exception extends Message {

	ExceptionMeta metaData = new ExceptionMeta();

	/*********************** Getter Methods  ***********************/
	ExceptionMessageHeader getHeader();
	ValidationModel getValidationModel();
	CorrelationAndOptionalSequenceModel getCorrelationAndOptionalSequenceModel();
	ExceptionModel getExceptionModel();

	/*********************** Build Methods  ***********************/
	Exception build();
	
	Exception.ExceptionBuilder toBuilder();
	
	static Exception.ExceptionBuilder builder() {
		return new Exception.ExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Exception> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Exception> getType() {
		return Exception.class;
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
	interface ExceptionBuilder extends Exception, Message.MessageBuilder {
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder getOrCreateHeader();
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder getHeader();
		ValidationModel.ValidationModelBuilder getOrCreateValidationModel();
		ValidationModel.ValidationModelBuilder getValidationModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getOrCreateCorrelationAndOptionalSequenceModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getCorrelationAndOptionalSequenceModel();
		ExceptionModel.ExceptionModelBuilder getOrCreateExceptionModel();
		ExceptionModel.ExceptionModelBuilder getExceptionModel();
		Exception.ExceptionBuilder setExpectedBuild(Integer expectedBuild);
		Exception.ExceptionBuilder setActualBuild(Integer actualBuild);
		Exception.ExceptionBuilder setHeader(ExceptionMessageHeader header);
		Exception.ExceptionBuilder setValidationModel(ValidationModel validationModel);
		Exception.ExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		Exception.ExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		Exception.ExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of Exception  ***********************/
	class ExceptionImpl extends Message.MessageImpl implements Exception {
		private final ExceptionMessageHeader header;
		private final ValidationModel validationModel;
		private final CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel;
		private final ExceptionModel exceptionModel;
		
		protected ExceptionImpl(Exception.ExceptionBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validationModel = ofNullable(builder.getValidationModel()).map(f->f.build()).orElse(null);
			this.correlationAndOptionalSequenceModel = ofNullable(builder.getCorrelationAndOptionalSequenceModel()).map(f->f.build()).orElse(null);
			this.exceptionModel = ofNullable(builder.getExceptionModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		public ExceptionMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("validationModel")
		public ValidationModel getValidationModel() {
			return validationModel;
		}
		
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CorrelationAndOptionalSequenceModel getCorrelationAndOptionalSequenceModel() {
			return correlationAndOptionalSequenceModel;
		}
		
		@Override
		@RosettaAttribute("exceptionModel")
		public ExceptionModel getExceptionModel() {
			return exceptionModel;
		}
		
		@Override
		public Exception build() {
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder toBuilder() {
			Exception.ExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Exception.ExceptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidationModel()).ifPresent(builder::setValidationModel);
			ofNullable(getCorrelationAndOptionalSequenceModel()).ifPresent(builder::setCorrelationAndOptionalSequenceModel);
			ofNullable(getExceptionModel()).ifPresent(builder::setExceptionModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Exception _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(correlationAndOptionalSequenceModel, _that.getCorrelationAndOptionalSequenceModel())) return false;
			if (!Objects.equals(exceptionModel, _that.getExceptionModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (correlationAndOptionalSequenceModel != null ? correlationAndOptionalSequenceModel.hashCode() : 0);
			_result = 31 * _result + (exceptionModel != null ? exceptionModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Exception {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"exceptionModel=" + this.exceptionModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Exception  ***********************/
	class ExceptionBuilderImpl extends Message.MessageBuilderImpl  implements Exception.ExceptionBuilder {
	
		protected ExceptionMessageHeader.ExceptionMessageHeaderBuilder header;
		protected ValidationModel.ValidationModelBuilder validationModel;
		protected CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder correlationAndOptionalSequenceModel;
		protected ExceptionModel.ExceptionModelBuilder exceptionModel;
	
		public ExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("header")
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder getOrCreateHeader() {
			ExceptionMessageHeader.ExceptionMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ExceptionMessageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("validationModel")
		public ValidationModel.ValidationModelBuilder getValidationModel() {
			return validationModel;
		}
		
		@Override
		public ValidationModel.ValidationModelBuilder getOrCreateValidationModel() {
			ValidationModel.ValidationModelBuilder result;
			if (validationModel!=null) {
				result = validationModel;
			}
			else {
				result = validationModel = ValidationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getCorrelationAndOptionalSequenceModel() {
			return correlationAndOptionalSequenceModel;
		}
		
		@Override
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getOrCreateCorrelationAndOptionalSequenceModel() {
			CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder result;
			if (correlationAndOptionalSequenceModel!=null) {
				result = correlationAndOptionalSequenceModel;
			}
			else {
				result = correlationAndOptionalSequenceModel = CorrelationAndOptionalSequenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exceptionModel")
		public ExceptionModel.ExceptionModelBuilder getExceptionModel() {
			return exceptionModel;
		}
		
		@Override
		public ExceptionModel.ExceptionModelBuilder getOrCreateExceptionModel() {
			ExceptionModel.ExceptionModelBuilder result;
			if (exceptionModel!=null) {
				result = exceptionModel;
			}
			else {
				result = exceptionModel = ExceptionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public Exception.ExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public Exception.ExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public Exception.ExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public Exception.ExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public Exception.ExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public Exception.ExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public Exception build() {
			return new Exception.ExceptionImpl(this);
		}
		
		@Override
		public Exception.ExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Exception.ExceptionBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			if (validationModel!=null && !validationModel.prune().hasData()) validationModel = null;
			if (correlationAndOptionalSequenceModel!=null && !correlationAndOptionalSequenceModel.prune().hasData()) correlationAndOptionalSequenceModel = null;
			if (exceptionModel!=null && !exceptionModel.prune().hasData()) exceptionModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getValidationModel()!=null && getValidationModel().hasData()) return true;
			if (getCorrelationAndOptionalSequenceModel()!=null && getCorrelationAndOptionalSequenceModel().hasData()) return true;
			if (getExceptionModel()!=null && getExceptionModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Exception.ExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Exception.ExceptionBuilder o = (Exception.ExceptionBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidationModel(), o.getValidationModel(), this::setValidationModel);
			merger.mergeRosetta(getCorrelationAndOptionalSequenceModel(), o.getCorrelationAndOptionalSequenceModel(), this::setCorrelationAndOptionalSequenceModel);
			merger.mergeRosetta(getExceptionModel(), o.getExceptionModel(), this::setExceptionModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Exception _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(correlationAndOptionalSequenceModel, _that.getCorrelationAndOptionalSequenceModel())) return false;
			if (!Objects.equals(exceptionModel, _that.getExceptionModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (correlationAndOptionalSequenceModel != null ? correlationAndOptionalSequenceModel.hashCode() : 0);
			_result = 31 * _result + (exceptionModel != null ? exceptionModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExceptionBuilder {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"exceptionModel=" + this.exceptionModel +
			'}' + " " + super.toString();
		}
	}
}
