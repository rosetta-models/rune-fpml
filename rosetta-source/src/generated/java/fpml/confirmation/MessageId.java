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
import fpml.confirmation.MessageId;
import fpml.confirmation.MessageId.MessageIdBuilder;
import fpml.confirmation.MessageId.MessageIdBuilderImpl;
import fpml.confirmation.MessageId.MessageIdImpl;
import fpml.confirmation.meta.MessageIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type use for message identifiers.
 * @version ${project.version}
 */
@RosettaDataType(value="MessageId", builder=MessageId.MessageIdBuilderImpl.class, version="${project.version}")
public interface MessageId extends RosettaModelObject {

	MessageIdMeta metaData = new MessageIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMessageIdScheme();

	/*********************** Build Methods  ***********************/
	MessageId build();
	
	MessageId.MessageIdBuilder toBuilder();
	
	static MessageId.MessageIdBuilder builder() {
		return new MessageId.MessageIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MessageId> getType() {
		return MessageId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("messageIdScheme"), String.class, getMessageIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageIdBuilder extends MessageId, RosettaModelObjectBuilder {
		MessageId.MessageIdBuilder setValue(String value);
		MessageId.MessageIdBuilder setMessageIdScheme(String messageIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("messageIdScheme"), String.class, getMessageIdScheme(), this);
		}
		

		MessageId.MessageIdBuilder prune();
	}

	/*********************** Immutable Implementation of MessageId  ***********************/
	class MessageIdImpl implements MessageId {
		private final String value;
		private final String messageIdScheme;
		
		protected MessageIdImpl(MessageId.MessageIdBuilder builder) {
			this.value = builder.getValue();
			this.messageIdScheme = builder.getMessageIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("messageIdScheme")
		public String getMessageIdScheme() {
			return messageIdScheme;
		}
		
		@Override
		public MessageId build() {
			return this;
		}
		
		@Override
		public MessageId.MessageIdBuilder toBuilder() {
			MessageId.MessageIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageId.MessageIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMessageIdScheme()).ifPresent(builder::setMessageIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageIdScheme, _that.getMessageIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageIdScheme != null ? messageIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageId {" +
				"value=" + this.value + ", " +
				"messageIdScheme=" + this.messageIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MessageId  ***********************/
	class MessageIdBuilderImpl implements MessageId.MessageIdBuilder {
	
		protected String value;
		protected String messageIdScheme;
	
		public MessageIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("messageIdScheme")
		public String getMessageIdScheme() {
			return messageIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MessageId.MessageIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("messageIdScheme")
		public MessageId.MessageIdBuilder setMessageIdScheme(String messageIdScheme) {
			this.messageIdScheme = messageIdScheme==null?null:messageIdScheme;
			return this;
		}
		
		@Override
		public MessageId build() {
			return new MessageId.MessageIdImpl(this);
		}
		
		@Override
		public MessageId.MessageIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageId.MessageIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMessageIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageId.MessageIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageId.MessageIdBuilder o = (MessageId.MessageIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMessageIdScheme(), o.getMessageIdScheme(), this::setMessageIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageIdScheme, _that.getMessageIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageIdScheme != null ? messageIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageIdBuilder {" +
				"value=" + this.value + ", " +
				"messageIdScheme=" + this.messageIdScheme +
			'}';
		}
	}
}
