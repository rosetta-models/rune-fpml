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
import fpml.confirmation.MessageRejected;
import fpml.confirmation.MessageRejected.MessageRejectedBuilder;
import fpml.confirmation.MessageRejected.MessageRejectedBuilderImpl;
import fpml.confirmation.MessageRejected.MessageRejectedImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.MessageRejectedMeta;


/**
 * The root element used for rejected message exceptions
 * @version ${project.version}
 */
@RosettaDataType(value="MessageRejected", builder=MessageRejected.MessageRejectedBuilderImpl.class, version="${project.version}")
public interface MessageRejected extends Exception {

	MessageRejectedMeta metaData = new MessageRejectedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MessageRejected build();
	
	MessageRejected.MessageRejectedBuilder toBuilder();
	
	static MessageRejected.MessageRejectedBuilder builder() {
		return new MessageRejected.MessageRejectedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageRejected> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MessageRejected> getType() {
		return MessageRejected.class;
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
	interface MessageRejectedBuilder extends MessageRejected, Exception.ExceptionBuilder {
		MessageRejected.MessageRejectedBuilder setExpectedBuild(Integer expectedBuild);
		MessageRejected.MessageRejectedBuilder setActualBuild(Integer actualBuild);
		MessageRejected.MessageRejectedBuilder setHeader(ExceptionMessageHeader header);
		MessageRejected.MessageRejectedBuilder setValidationModel(ValidationModel validationModel);
		MessageRejected.MessageRejectedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		MessageRejected.MessageRejectedBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		MessageRejected.MessageRejectedBuilder prune();
	}

	/*********************** Immutable Implementation of MessageRejected  ***********************/
	class MessageRejectedImpl extends Exception.ExceptionImpl implements MessageRejected {
		
		protected MessageRejectedImpl(MessageRejected.MessageRejectedBuilder builder) {
			super(builder);
		}
		
		@Override
		public MessageRejected build() {
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder toBuilder() {
			MessageRejected.MessageRejectedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageRejected.MessageRejectedBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "MessageRejected {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MessageRejected  ***********************/
	class MessageRejectedBuilderImpl extends Exception.ExceptionBuilderImpl  implements MessageRejected.MessageRejectedBuilder {
	
	
		public MessageRejectedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public MessageRejected.MessageRejectedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public MessageRejected.MessageRejectedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public MessageRejected.MessageRejectedBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public MessageRejected.MessageRejectedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public MessageRejected.MessageRejectedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public MessageRejected.MessageRejectedBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public MessageRejected build() {
			return new MessageRejected.MessageRejectedImpl(this);
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageRejected.MessageRejectedBuilder prune() {
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
		public MessageRejected.MessageRejectedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MessageRejected.MessageRejectedBuilder o = (MessageRejected.MessageRejectedBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "MessageRejectedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
