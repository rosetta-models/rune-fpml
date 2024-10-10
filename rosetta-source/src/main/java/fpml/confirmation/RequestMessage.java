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
import fpml.confirmation.Message;
import fpml.confirmation.Message.MessageBuilder;
import fpml.confirmation.Message.MessageBuilderImpl;
import fpml.confirmation.Message.MessageImpl;
import fpml.confirmation.RequestMessage;
import fpml.confirmation.RequestMessage.RequestMessageBuilder;
import fpml.confirmation.RequestMessage.RequestMessageBuilderImpl;
import fpml.confirmation.RequestMessage.RequestMessageImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestMessageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the basic content of a message that requests the receiver to perform some business operation determined by the message type and its content.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestMessage", builder=RequestMessage.RequestMessageBuilderImpl.class, version="${project.version}")
public interface RequestMessage extends Message {

	RequestMessageMeta metaData = new RequestMessageMeta();

	/*********************** Getter Methods  ***********************/
	RequestMessageHeader getHeader();
	ValidationModel getValidationModel();

	/*********************** Build Methods  ***********************/
	RequestMessage build();
	
	RequestMessage.RequestMessageBuilder toBuilder();
	
	static RequestMessage.RequestMessageBuilder builder() {
		return new RequestMessage.RequestMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestMessage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestMessage> getType() {
		return RequestMessage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestMessageBuilder extends RequestMessage, Message.MessageBuilder {
		RequestMessageHeader.RequestMessageHeaderBuilder getOrCreateHeader();
		RequestMessageHeader.RequestMessageHeaderBuilder getHeader();
		ValidationModel.ValidationModelBuilder getOrCreateValidationModel();
		ValidationModel.ValidationModelBuilder getValidationModel();
		RequestMessage.RequestMessageBuilder setExpectedBuild(Integer expectedBuild);
		RequestMessage.RequestMessageBuilder setActualBuild(Integer actualBuild);
		RequestMessage.RequestMessageBuilder setHeader(RequestMessageHeader header);
		RequestMessage.RequestMessageBuilder setValidationModel(ValidationModel validationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
		}
		

		RequestMessage.RequestMessageBuilder prune();
	}

	/*********************** Immutable Implementation of RequestMessage  ***********************/
	class RequestMessageImpl extends Message.MessageImpl implements RequestMessage {
		private final RequestMessageHeader header;
		private final ValidationModel validationModel;
		
		protected RequestMessageImpl(RequestMessage.RequestMessageBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validationModel = ofNullable(builder.getValidationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		public RequestMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("validationModel")
		public ValidationModel getValidationModel() {
			return validationModel;
		}
		
		@Override
		public RequestMessage build() {
			return this;
		}
		
		@Override
		public RequestMessage.RequestMessageBuilder toBuilder() {
			RequestMessage.RequestMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestMessage.RequestMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidationModel()).ifPresent(builder::setValidationModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestMessage {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestMessage  ***********************/
	class RequestMessageBuilderImpl extends Message.MessageBuilderImpl  implements RequestMessage.RequestMessageBuilder {
	
		protected RequestMessageHeader.RequestMessageHeaderBuilder header;
		protected ValidationModel.ValidationModelBuilder validationModel;
	
		public RequestMessageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("header")
		public RequestMessageHeader.RequestMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder getOrCreateHeader() {
			RequestMessageHeader.RequestMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = RequestMessageHeader.builder();
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
		@RosettaAttribute("expectedBuild")
		public RequestMessage.RequestMessageBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestMessage.RequestMessageBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestMessage.RequestMessageBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestMessage.RequestMessageBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestMessage build() {
			return new RequestMessage.RequestMessageImpl(this);
		}
		
		@Override
		public RequestMessage.RequestMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestMessage.RequestMessageBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			if (validationModel!=null && !validationModel.prune().hasData()) validationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getValidationModel()!=null && getValidationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestMessage.RequestMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestMessage.RequestMessageBuilder o = (RequestMessage.RequestMessageBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidationModel(), o.getValidationModel(), this::setValidationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestMessageBuilder {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel +
			'}' + " " + super.toString();
		}
	}
}
