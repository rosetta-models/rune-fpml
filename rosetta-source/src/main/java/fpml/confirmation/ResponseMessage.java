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
import fpml.confirmation.Message;
import fpml.confirmation.Message.MessageBuilder;
import fpml.confirmation.Message.MessageBuilderImpl;
import fpml.confirmation.Message.MessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ResponseMessageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type refining the generic message content model to make it specific to response messages.
 * @version ${project.version}
 */
@RosettaDataType(value="ResponseMessage", builder=ResponseMessage.ResponseMessageBuilderImpl.class, version="${project.version}")
public interface ResponseMessage extends Message {

	ResponseMessageMeta metaData = new ResponseMessageMeta();

	/*********************** Getter Methods  ***********************/
	ResponseMessageHeader getHeader();
	ValidationModel getValidationModel();
	CorrelationAndOptionalSequenceModel getCorrelationAndOptionalSequenceModel();
	OnBehalfOfModel getOnBehalfOfModel();

	/*********************** Build Methods  ***********************/
	ResponseMessage build();
	
	ResponseMessage.ResponseMessageBuilder toBuilder();
	
	static ResponseMessage.ResponseMessageBuilder builder() {
		return new ResponseMessage.ResponseMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResponseMessage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ResponseMessage> getType() {
		return ResponseMessage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResponseMessageBuilder extends ResponseMessage, Message.MessageBuilder {
		ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader();
		ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader();
		ValidationModel.ValidationModelBuilder getOrCreateValidationModel();
		ValidationModel.ValidationModelBuilder getValidationModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getOrCreateCorrelationAndOptionalSequenceModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getCorrelationAndOptionalSequenceModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOrCreateOnBehalfOfModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOnBehalfOfModel();
		ResponseMessage.ResponseMessageBuilder setExpectedBuild(Integer expectedBuild);
		ResponseMessage.ResponseMessageBuilder setActualBuild(Integer actualBuild);
		ResponseMessage.ResponseMessageBuilder setHeader(ResponseMessageHeader header);
		ResponseMessage.ResponseMessageBuilder setValidationModel(ValidationModel validationModel);
		ResponseMessage.ResponseMessageBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ResponseMessage.ResponseMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
		}
		

		ResponseMessage.ResponseMessageBuilder prune();
	}

	/*********************** Immutable Implementation of ResponseMessage  ***********************/
	class ResponseMessageImpl extends Message.MessageImpl implements ResponseMessage {
		private final ResponseMessageHeader header;
		private final ValidationModel validationModel;
		private final CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel;
		private final OnBehalfOfModel onBehalfOfModel;
		
		protected ResponseMessageImpl(ResponseMessage.ResponseMessageBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validationModel = ofNullable(builder.getValidationModel()).map(f->f.build()).orElse(null);
			this.correlationAndOptionalSequenceModel = ofNullable(builder.getCorrelationAndOptionalSequenceModel()).map(f->f.build()).orElse(null);
			this.onBehalfOfModel = ofNullable(builder.getOnBehalfOfModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		public ResponseMessageHeader getHeader() {
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
		@RosettaAttribute("onBehalfOfModel")
		public OnBehalfOfModel getOnBehalfOfModel() {
			return onBehalfOfModel;
		}
		
		@Override
		public ResponseMessage build() {
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder toBuilder() {
			ResponseMessage.ResponseMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResponseMessage.ResponseMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidationModel()).ifPresent(builder::setValidationModel);
			ofNullable(getCorrelationAndOptionalSequenceModel()).ifPresent(builder::setCorrelationAndOptionalSequenceModel);
			ofNullable(getOnBehalfOfModel()).ifPresent(builder::setOnBehalfOfModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResponseMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(correlationAndOptionalSequenceModel, _that.getCorrelationAndOptionalSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (correlationAndOptionalSequenceModel != null ? correlationAndOptionalSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResponseMessage {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ResponseMessage  ***********************/
	class ResponseMessageBuilderImpl extends Message.MessageBuilderImpl  implements ResponseMessage.ResponseMessageBuilder {
	
		protected ResponseMessageHeader.ResponseMessageHeaderBuilder header;
		protected ValidationModel.ValidationModelBuilder validationModel;
		protected CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder correlationAndOptionalSequenceModel;
		protected OnBehalfOfModel.OnBehalfOfModelBuilder onBehalfOfModel;
	
		public ResponseMessageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("header")
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader() {
			ResponseMessageHeader.ResponseMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ResponseMessageHeader.builder();
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
		@RosettaAttribute("onBehalfOfModel")
		public OnBehalfOfModel.OnBehalfOfModelBuilder getOnBehalfOfModel() {
			return onBehalfOfModel;
		}
		
		@Override
		public OnBehalfOfModel.OnBehalfOfModelBuilder getOrCreateOnBehalfOfModel() {
			OnBehalfOfModel.OnBehalfOfModelBuilder result;
			if (onBehalfOfModel!=null) {
				result = onBehalfOfModel;
			}
			else {
				result = onBehalfOfModel = OnBehalfOfModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public ResponseMessage.ResponseMessageBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ResponseMessage.ResponseMessageBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ResponseMessage.ResponseMessageBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ResponseMessage.ResponseMessageBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ResponseMessage.ResponseMessageBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ResponseMessage.ResponseMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		
		@Override
		public ResponseMessage build() {
			return new ResponseMessage.ResponseMessageImpl(this);
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResponseMessage.ResponseMessageBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			if (validationModel!=null && !validationModel.prune().hasData()) validationModel = null;
			if (correlationAndOptionalSequenceModel!=null && !correlationAndOptionalSequenceModel.prune().hasData()) correlationAndOptionalSequenceModel = null;
			if (onBehalfOfModel!=null && !onBehalfOfModel.prune().hasData()) onBehalfOfModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getValidationModel()!=null && getValidationModel().hasData()) return true;
			if (getCorrelationAndOptionalSequenceModel()!=null && getCorrelationAndOptionalSequenceModel().hasData()) return true;
			if (getOnBehalfOfModel()!=null && getOnBehalfOfModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResponseMessage.ResponseMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ResponseMessage.ResponseMessageBuilder o = (ResponseMessage.ResponseMessageBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidationModel(), o.getValidationModel(), this::setValidationModel);
			merger.mergeRosetta(getCorrelationAndOptionalSequenceModel(), o.getCorrelationAndOptionalSequenceModel(), this::setCorrelationAndOptionalSequenceModel);
			merger.mergeRosetta(getOnBehalfOfModel(), o.getOnBehalfOfModel(), this::setOnBehalfOfModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResponseMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(correlationAndOptionalSequenceModel, _that.getCorrelationAndOptionalSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (correlationAndOptionalSequenceModel != null ? correlationAndOptionalSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResponseMessageBuilder {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}
}
