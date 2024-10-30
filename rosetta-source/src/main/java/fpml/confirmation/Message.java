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
import fpml.confirmation.Document;
import fpml.confirmation.Document.DocumentBuilder;
import fpml.confirmation.Document.DocumentBuilderImpl;
import fpml.confirmation.Document.DocumentImpl;
import fpml.confirmation.Message;
import fpml.confirmation.Message.MessageBuilder;
import fpml.confirmation.Message.MessageBuilderImpl;
import fpml.confirmation.Message.MessageImpl;
import fpml.confirmation.meta.MessageMeta;


/**
 * A type defining the basic structure of all FpML messages which is refined by its derived types.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Message", builder=Message.MessageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Message extends Document {

	MessageMeta metaData = new MessageMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Message build();
	
	Message.MessageBuilder toBuilder();
	
	static Message.MessageBuilder builder() {
		return new Message.MessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Message> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Message> getType() {
		return Message.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageBuilder extends Message, Document.DocumentBuilder {
		Message.MessageBuilder setExpectedBuild(Integer expectedBuild);
		Message.MessageBuilder setActualBuild(Integer actualBuild);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		}
		

		Message.MessageBuilder prune();
	}

	/*********************** Immutable Implementation of Message  ***********************/
	class MessageImpl extends Document.DocumentImpl implements Message {
		
		protected MessageImpl(Message.MessageBuilder builder) {
			super(builder);
		}
		
		@Override
		public Message build() {
			return this;
		}
		
		@Override
		public Message.MessageBuilder toBuilder() {
			Message.MessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Message.MessageBuilder builder) {
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
			return "Message {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Message  ***********************/
	class MessageBuilderImpl extends Document.DocumentBuilderImpl  implements Message.MessageBuilder {
	
	
		public MessageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public Message.MessageBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public Message.MessageBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		
		@Override
		public Message build() {
			return new Message.MessageImpl(this);
		}
		
		@Override
		public Message.MessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Message.MessageBuilder prune() {
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
		public Message.MessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Message.MessageBuilder o = (Message.MessageBuilder) other;
			
			
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
			return "MessageBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
