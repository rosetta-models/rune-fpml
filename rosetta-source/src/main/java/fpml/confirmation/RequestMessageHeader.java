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
import fpml.confirmation.MessageHeader;
import fpml.confirmation.MessageHeader.MessageHeaderBuilder;
import fpml.confirmation.MessageHeader.MessageHeaderBuilderImpl;
import fpml.confirmation.MessageHeader.MessageHeaderImpl;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.MessageId;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestMessageHeader.RequestMessageHeaderBuilder;
import fpml.confirmation.RequestMessageHeader.RequestMessageHeaderBuilderImpl;
import fpml.confirmation.RequestMessageHeader.RequestMessageHeaderImpl;
import fpml.confirmation.meta.RequestMessageHeaderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type refining the generic message header content to make it specific to request messages.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestMessageHeader", builder=RequestMessageHeader.RequestMessageHeaderBuilderImpl.class, version="${project.version}")
public interface RequestMessageHeader extends MessageHeader {

	RequestMessageHeaderMeta metaData = new RequestMessageHeaderMeta();

	/*********************** Getter Methods  ***********************/
	MessageHeaderModel getMessageHeaderModel();

	/*********************** Build Methods  ***********************/
	RequestMessageHeader build();
	
	RequestMessageHeader.RequestMessageHeaderBuilder toBuilder();
	
	static RequestMessageHeader.RequestMessageHeaderBuilder builder() {
		return new RequestMessageHeader.RequestMessageHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestMessageHeader> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestMessageHeader> getType() {
		return RequestMessageHeader.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("messageId"), processor, MessageId.class, getMessageId());
		processRosetta(path.newSubPath("messageHeaderModel"), processor, MessageHeaderModel.class, getMessageHeaderModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestMessageHeaderBuilder extends RequestMessageHeader, MessageHeader.MessageHeaderBuilder {
		MessageHeaderModel.MessageHeaderModelBuilder getOrCreateMessageHeaderModel();
		MessageHeaderModel.MessageHeaderModelBuilder getMessageHeaderModel();
		RequestMessageHeader.RequestMessageHeaderBuilder setMessageId(MessageId messageId);
		RequestMessageHeader.RequestMessageHeaderBuilder setMessageHeaderModel(MessageHeaderModel messageHeaderModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("messageId"), processor, MessageId.MessageIdBuilder.class, getMessageId());
			processRosetta(path.newSubPath("messageHeaderModel"), processor, MessageHeaderModel.MessageHeaderModelBuilder.class, getMessageHeaderModel());
		}
		

		RequestMessageHeader.RequestMessageHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of RequestMessageHeader  ***********************/
	class RequestMessageHeaderImpl extends MessageHeader.MessageHeaderImpl implements RequestMessageHeader {
		private final MessageHeaderModel messageHeaderModel;
		
		protected RequestMessageHeaderImpl(RequestMessageHeader.RequestMessageHeaderBuilder builder) {
			super(builder);
			this.messageHeaderModel = ofNullable(builder.getMessageHeaderModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("messageHeaderModel")
		public MessageHeaderModel getMessageHeaderModel() {
			return messageHeaderModel;
		}
		
		@Override
		public RequestMessageHeader build() {
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder toBuilder() {
			RequestMessageHeader.RequestMessageHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestMessageHeader.RequestMessageHeaderBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMessageHeaderModel()).ifPresent(builder::setMessageHeaderModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestMessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(messageHeaderModel, _that.getMessageHeaderModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (messageHeaderModel != null ? messageHeaderModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestMessageHeader {" +
				"messageHeaderModel=" + this.messageHeaderModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestMessageHeader  ***********************/
	class RequestMessageHeaderBuilderImpl extends MessageHeader.MessageHeaderBuilderImpl  implements RequestMessageHeader.RequestMessageHeaderBuilder {
	
		protected MessageHeaderModel.MessageHeaderModelBuilder messageHeaderModel;
	
		public RequestMessageHeaderBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("messageHeaderModel")
		public MessageHeaderModel.MessageHeaderModelBuilder getMessageHeaderModel() {
			return messageHeaderModel;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder getOrCreateMessageHeaderModel() {
			MessageHeaderModel.MessageHeaderModelBuilder result;
			if (messageHeaderModel!=null) {
				result = messageHeaderModel;
			}
			else {
				result = messageHeaderModel = MessageHeaderModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("messageId")
		public RequestMessageHeader.RequestMessageHeaderBuilder setMessageId(MessageId messageId) {
			this.messageId = messageId==null?null:messageId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("messageHeaderModel")
		public RequestMessageHeader.RequestMessageHeaderBuilder setMessageHeaderModel(MessageHeaderModel messageHeaderModel) {
			this.messageHeaderModel = messageHeaderModel==null?null:messageHeaderModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestMessageHeader build() {
			return new RequestMessageHeader.RequestMessageHeaderImpl(this);
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder prune() {
			super.prune();
			if (messageHeaderModel!=null && !messageHeaderModel.prune().hasData()) messageHeaderModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMessageHeaderModel()!=null && getMessageHeaderModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestMessageHeader.RequestMessageHeaderBuilder o = (RequestMessageHeader.RequestMessageHeaderBuilder) other;
			
			merger.mergeRosetta(getMessageHeaderModel(), o.getMessageHeaderModel(), this::setMessageHeaderModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestMessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(messageHeaderModel, _that.getMessageHeaderModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (messageHeaderModel != null ? messageHeaderModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestMessageHeaderBuilder {" +
				"messageHeaderModel=" + this.messageHeaderModel +
			'}' + " " + super.toString();
		}
	}
}
