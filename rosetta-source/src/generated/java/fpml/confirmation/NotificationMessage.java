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
import fpml.confirmation.NotificationMessage;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilder;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilderImpl;
import fpml.confirmation.NotificationMessage.NotificationMessageImpl;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.NotificationMessageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the basic content for a message sent to inform another system that some &#39;business event&#39; has occured. Notifications are not expected to be replied to.
 * @version ${project.version}
 */
@RosettaDataType(value="NotificationMessage", builder=NotificationMessage.NotificationMessageBuilderImpl.class, version="${project.version}")
public interface NotificationMessage extends Message {

	NotificationMessageMeta metaData = new NotificationMessageMeta();

	/*********************** Getter Methods  ***********************/
	NotificationMessageHeader getHeader();
	ValidationModel getValidationModel();
	CorrelationAndOptionalSequenceModel getCorrelationAndOptionalSequenceModel();
	OnBehalfOfModel getOnBehalfOfModel();

	/*********************** Build Methods  ***********************/
	NotificationMessage build();
	
	NotificationMessage.NotificationMessageBuilder toBuilder();
	
	static NotificationMessage.NotificationMessageBuilder builder() {
		return new NotificationMessage.NotificationMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotificationMessage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotificationMessage> getType() {
		return NotificationMessage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotificationMessageBuilder extends NotificationMessage, Message.MessageBuilder {
		NotificationMessageHeader.NotificationMessageHeaderBuilder getOrCreateHeader();
		NotificationMessageHeader.NotificationMessageHeaderBuilder getHeader();
		ValidationModel.ValidationModelBuilder getOrCreateValidationModel();
		ValidationModel.ValidationModelBuilder getValidationModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getOrCreateCorrelationAndOptionalSequenceModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getCorrelationAndOptionalSequenceModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOrCreateOnBehalfOfModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOnBehalfOfModel();
		NotificationMessage.NotificationMessageBuilder setExpectedBuild(Integer expectedBuild);
		NotificationMessage.NotificationMessageBuilder setActualBuild(Integer actualBuild);
		NotificationMessage.NotificationMessageBuilder setHeader(NotificationMessageHeader header);
		NotificationMessage.NotificationMessageBuilder setValidationModel(ValidationModel validationModel);
		NotificationMessage.NotificationMessageBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		NotificationMessage.NotificationMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
		}
		

		NotificationMessage.NotificationMessageBuilder prune();
	}

	/*********************** Immutable Implementation of NotificationMessage  ***********************/
	class NotificationMessageImpl extends Message.MessageImpl implements NotificationMessage {
		private final NotificationMessageHeader header;
		private final ValidationModel validationModel;
		private final CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel;
		private final OnBehalfOfModel onBehalfOfModel;
		
		protected NotificationMessageImpl(NotificationMessage.NotificationMessageBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validationModel = ofNullable(builder.getValidationModel()).map(f->f.build()).orElse(null);
			this.correlationAndOptionalSequenceModel = ofNullable(builder.getCorrelationAndOptionalSequenceModel()).map(f->f.build()).orElse(null);
			this.onBehalfOfModel = ofNullable(builder.getOnBehalfOfModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		public NotificationMessageHeader getHeader() {
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
		public NotificationMessage build() {
			return this;
		}
		
		@Override
		public NotificationMessage.NotificationMessageBuilder toBuilder() {
			NotificationMessage.NotificationMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotificationMessage.NotificationMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidationModel()).ifPresent(builder::setValidationModel);
			ofNullable(getCorrelationAndOptionalSequenceModel()).ifPresent(builder::setCorrelationAndOptionalSequenceModel);
			ofNullable(getOnBehalfOfModel()).ifPresent(builder::setOnBehalfOfModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NotificationMessage _that = getType().cast(o);
		
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
			return "NotificationMessage {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NotificationMessage  ***********************/
	class NotificationMessageBuilderImpl extends Message.MessageBuilderImpl  implements NotificationMessage.NotificationMessageBuilder {
	
		protected NotificationMessageHeader.NotificationMessageHeaderBuilder header;
		protected ValidationModel.ValidationModelBuilder validationModel;
		protected CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder correlationAndOptionalSequenceModel;
		protected OnBehalfOfModel.OnBehalfOfModelBuilder onBehalfOfModel;
	
		public NotificationMessageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("header")
		public NotificationMessageHeader.NotificationMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public NotificationMessageHeader.NotificationMessageHeaderBuilder getOrCreateHeader() {
			NotificationMessageHeader.NotificationMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = NotificationMessageHeader.builder();
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
		public NotificationMessage.NotificationMessageBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public NotificationMessage.NotificationMessageBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public NotificationMessage.NotificationMessageBuilder setHeader(NotificationMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public NotificationMessage.NotificationMessageBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public NotificationMessage.NotificationMessageBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public NotificationMessage.NotificationMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		
		@Override
		public NotificationMessage build() {
			return new NotificationMessage.NotificationMessageImpl(this);
		}
		
		@Override
		public NotificationMessage.NotificationMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationMessage.NotificationMessageBuilder prune() {
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
		public NotificationMessage.NotificationMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NotificationMessage.NotificationMessageBuilder o = (NotificationMessage.NotificationMessageBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidationModel(), o.getValidationModel(), this::setValidationModel);
			merger.mergeRosetta(getCorrelationAndOptionalSequenceModel(), o.getCorrelationAndOptionalSequenceModel(), this::setCorrelationAndOptionalSequenceModel);
			merger.mergeRosetta(getOnBehalfOfModel(), o.getOnBehalfOfModel(), this::setOnBehalfOfModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NotificationMessage _that = getType().cast(o);
		
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
			return "NotificationMessageBuilder {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}
}
