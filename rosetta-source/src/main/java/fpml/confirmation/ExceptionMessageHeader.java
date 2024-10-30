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
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionMessageHeader.ExceptionMessageHeaderBuilder;
import fpml.confirmation.ExceptionMessageHeader.ExceptionMessageHeaderBuilderImpl;
import fpml.confirmation.ExceptionMessageHeader.ExceptionMessageHeaderImpl;
import fpml.confirmation.MessageHeader;
import fpml.confirmation.MessageHeader.MessageHeaderBuilder;
import fpml.confirmation.MessageHeader.MessageHeaderBuilderImpl;
import fpml.confirmation.MessageHeader.MessageHeaderImpl;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.MessageId;
import fpml.confirmation.meta.ExceptionMessageHeaderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the content model for an exception message header.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExceptionMessageHeader", builder=ExceptionMessageHeader.ExceptionMessageHeaderBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExceptionMessageHeader extends MessageHeader {

	ExceptionMessageHeaderMeta metaData = new ExceptionMessageHeaderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A copy of the unique message identifier (within it own coding scheme) to which this message is responding.
	 */
	MessageId getInReplyTo();
	MessageHeaderModel getMessageHeaderModel();

	/*********************** Build Methods  ***********************/
	ExceptionMessageHeader build();
	
	ExceptionMessageHeader.ExceptionMessageHeaderBuilder toBuilder();
	
	static ExceptionMessageHeader.ExceptionMessageHeaderBuilder builder() {
		return new ExceptionMessageHeader.ExceptionMessageHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExceptionMessageHeader> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExceptionMessageHeader> getType() {
		return ExceptionMessageHeader.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("messageId"), processor, MessageId.class, getMessageId());
		processRosetta(path.newSubPath("inReplyTo"), processor, MessageId.class, getInReplyTo());
		processRosetta(path.newSubPath("messageHeaderModel"), processor, MessageHeaderModel.class, getMessageHeaderModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExceptionMessageHeaderBuilder extends ExceptionMessageHeader, MessageHeader.MessageHeaderBuilder {
		MessageId.MessageIdBuilder getOrCreateInReplyTo();
		MessageId.MessageIdBuilder getInReplyTo();
		MessageHeaderModel.MessageHeaderModelBuilder getOrCreateMessageHeaderModel();
		MessageHeaderModel.MessageHeaderModelBuilder getMessageHeaderModel();
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder setMessageId(MessageId messageId);
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder setInReplyTo(MessageId inReplyTo);
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder setMessageHeaderModel(MessageHeaderModel messageHeaderModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("messageId"), processor, MessageId.MessageIdBuilder.class, getMessageId());
			processRosetta(path.newSubPath("inReplyTo"), processor, MessageId.MessageIdBuilder.class, getInReplyTo());
			processRosetta(path.newSubPath("messageHeaderModel"), processor, MessageHeaderModel.MessageHeaderModelBuilder.class, getMessageHeaderModel());
		}
		

		ExceptionMessageHeader.ExceptionMessageHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of ExceptionMessageHeader  ***********************/
	class ExceptionMessageHeaderImpl extends MessageHeader.MessageHeaderImpl implements ExceptionMessageHeader {
		private final MessageId inReplyTo;
		private final MessageHeaderModel messageHeaderModel;
		
		protected ExceptionMessageHeaderImpl(ExceptionMessageHeader.ExceptionMessageHeaderBuilder builder) {
			super(builder);
			this.inReplyTo = ofNullable(builder.getInReplyTo()).map(f->f.build()).orElse(null);
			this.messageHeaderModel = ofNullable(builder.getMessageHeaderModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inReplyTo")
		public MessageId getInReplyTo() {
			return inReplyTo;
		}
		
		@Override
		@RosettaAttribute("messageHeaderModel")
		public MessageHeaderModel getMessageHeaderModel() {
			return messageHeaderModel;
		}
		
		@Override
		public ExceptionMessageHeader build() {
			return this;
		}
		
		@Override
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder toBuilder() {
			ExceptionMessageHeader.ExceptionMessageHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExceptionMessageHeader.ExceptionMessageHeaderBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInReplyTo()).ifPresent(builder::setInReplyTo);
			ofNullable(getMessageHeaderModel()).ifPresent(builder::setMessageHeaderModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExceptionMessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(inReplyTo, _that.getInReplyTo())) return false;
			if (!Objects.equals(messageHeaderModel, _that.getMessageHeaderModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inReplyTo != null ? inReplyTo.hashCode() : 0);
			_result = 31 * _result + (messageHeaderModel != null ? messageHeaderModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExceptionMessageHeader {" +
				"inReplyTo=" + this.inReplyTo + ", " +
				"messageHeaderModel=" + this.messageHeaderModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExceptionMessageHeader  ***********************/
	class ExceptionMessageHeaderBuilderImpl extends MessageHeader.MessageHeaderBuilderImpl  implements ExceptionMessageHeader.ExceptionMessageHeaderBuilder {
	
		protected MessageId.MessageIdBuilder inReplyTo;
		protected MessageHeaderModel.MessageHeaderModelBuilder messageHeaderModel;
	
		public ExceptionMessageHeaderBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("inReplyTo")
		public MessageId.MessageIdBuilder getInReplyTo() {
			return inReplyTo;
		}
		
		@Override
		public MessageId.MessageIdBuilder getOrCreateInReplyTo() {
			MessageId.MessageIdBuilder result;
			if (inReplyTo!=null) {
				result = inReplyTo;
			}
			else {
				result = inReplyTo = MessageId.builder();
			}
			
			return result;
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
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder setMessageId(MessageId messageId) {
			this.messageId = messageId==null?null:messageId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("inReplyTo")
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder setInReplyTo(MessageId inReplyTo) {
			this.inReplyTo = inReplyTo==null?null:inReplyTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("messageHeaderModel")
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder setMessageHeaderModel(MessageHeaderModel messageHeaderModel) {
			this.messageHeaderModel = messageHeaderModel==null?null:messageHeaderModel.toBuilder();
			return this;
		}
		
		@Override
		public ExceptionMessageHeader build() {
			return new ExceptionMessageHeader.ExceptionMessageHeaderImpl(this);
		}
		
		@Override
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder prune() {
			super.prune();
			if (inReplyTo!=null && !inReplyTo.prune().hasData()) inReplyTo = null;
			if (messageHeaderModel!=null && !messageHeaderModel.prune().hasData()) messageHeaderModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInReplyTo()!=null && getInReplyTo().hasData()) return true;
			if (getMessageHeaderModel()!=null && getMessageHeaderModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExceptionMessageHeader.ExceptionMessageHeaderBuilder o = (ExceptionMessageHeader.ExceptionMessageHeaderBuilder) other;
			
			merger.mergeRosetta(getInReplyTo(), o.getInReplyTo(), this::setInReplyTo);
			merger.mergeRosetta(getMessageHeaderModel(), o.getMessageHeaderModel(), this::setMessageHeaderModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExceptionMessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(inReplyTo, _that.getInReplyTo())) return false;
			if (!Objects.equals(messageHeaderModel, _that.getMessageHeaderModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inReplyTo != null ? inReplyTo.hashCode() : 0);
			_result = 31 * _result + (messageHeaderModel != null ? messageHeaderModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExceptionMessageHeaderBuilder {" +
				"inReplyTo=" + this.inReplyTo + ", " +
				"messageHeaderModel=" + this.messageHeaderModel +
			'}' + " " + super.toString();
		}
	}
}
