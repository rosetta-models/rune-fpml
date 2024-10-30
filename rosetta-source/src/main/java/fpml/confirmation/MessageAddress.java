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
import fpml.confirmation.MessageAddress;
import fpml.confirmation.MessageAddress.MessageAddressBuilder;
import fpml.confirmation.MessageAddress.MessageAddressBuilderImpl;
import fpml.confirmation.MessageAddress.MessageAddressImpl;
import fpml.confirmation.meta.MessageAddressMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for identifying a message address.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MessageAddress", builder=MessageAddress.MessageAddressBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MessageAddress extends RosettaModelObject {

	MessageAddressMeta metaData = new MessageAddressMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMessageAddressScheme();

	/*********************** Build Methods  ***********************/
	MessageAddress build();
	
	MessageAddress.MessageAddressBuilder toBuilder();
	
	static MessageAddress.MessageAddressBuilder builder() {
		return new MessageAddress.MessageAddressBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageAddress> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MessageAddress> getType() {
		return MessageAddress.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("messageAddressScheme"), String.class, getMessageAddressScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageAddressBuilder extends MessageAddress, RosettaModelObjectBuilder {
		MessageAddress.MessageAddressBuilder setValue(String value);
		MessageAddress.MessageAddressBuilder setMessageAddressScheme(String messageAddressScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("messageAddressScheme"), String.class, getMessageAddressScheme(), this);
		}
		

		MessageAddress.MessageAddressBuilder prune();
	}

	/*********************** Immutable Implementation of MessageAddress  ***********************/
	class MessageAddressImpl implements MessageAddress {
		private final String value;
		private final String messageAddressScheme;
		
		protected MessageAddressImpl(MessageAddress.MessageAddressBuilder builder) {
			this.value = builder.getValue();
			this.messageAddressScheme = builder.getMessageAddressScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("messageAddressScheme")
		public String getMessageAddressScheme() {
			return messageAddressScheme;
		}
		
		@Override
		public MessageAddress build() {
			return this;
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder toBuilder() {
			MessageAddress.MessageAddressBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageAddress.MessageAddressBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMessageAddressScheme()).ifPresent(builder::setMessageAddressScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageAddress _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageAddressScheme, _that.getMessageAddressScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageAddressScheme != null ? messageAddressScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageAddress {" +
				"value=" + this.value + ", " +
				"messageAddressScheme=" + this.messageAddressScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MessageAddress  ***********************/
	class MessageAddressBuilderImpl implements MessageAddress.MessageAddressBuilder {
	
		protected String value;
		protected String messageAddressScheme;
	
		public MessageAddressBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("messageAddressScheme")
		public String getMessageAddressScheme() {
			return messageAddressScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MessageAddress.MessageAddressBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("messageAddressScheme")
		public MessageAddress.MessageAddressBuilder setMessageAddressScheme(String messageAddressScheme) {
			this.messageAddressScheme = messageAddressScheme==null?null:messageAddressScheme;
			return this;
		}
		
		@Override
		public MessageAddress build() {
			return new MessageAddress.MessageAddressImpl(this);
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageAddress.MessageAddressBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMessageAddressScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageAddress.MessageAddressBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageAddress.MessageAddressBuilder o = (MessageAddress.MessageAddressBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMessageAddressScheme(), o.getMessageAddressScheme(), this::setMessageAddressScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageAddress _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageAddressScheme, _that.getMessageAddressScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageAddressScheme != null ? messageAddressScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageAddressBuilder {" +
				"value=" + this.value + ", " +
				"messageAddressScheme=" + this.messageAddressScheme +
			'}';
		}
	}
}
