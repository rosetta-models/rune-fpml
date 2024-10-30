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
import fpml.confirmation.EventStatusException;
import fpml.confirmation.EventStatusException.EventStatusExceptionBuilder;
import fpml.confirmation.EventStatusException.EventStatusExceptionBuilderImpl;
import fpml.confirmation.EventStatusException.EventStatusExceptionImpl;
import fpml.confirmation.Exception;
import fpml.confirmation.Exception.ExceptionBuilder;
import fpml.confirmation.Exception.ExceptionBuilderImpl;
import fpml.confirmation.Exception.ExceptionImpl;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.EventStatusExceptionMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventStatusException", builder=EventStatusException.EventStatusExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventStatusException extends Exception {

	EventStatusExceptionMeta metaData = new EventStatusExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	EventStatusException build();
	
	EventStatusException.EventStatusExceptionBuilder toBuilder();
	
	static EventStatusException.EventStatusExceptionBuilder builder() {
		return new EventStatusException.EventStatusExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventStatusException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventStatusException> getType() {
		return EventStatusException.class;
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
	interface EventStatusExceptionBuilder extends EventStatusException, Exception.ExceptionBuilder {
		EventStatusException.EventStatusExceptionBuilder setExpectedBuild(Integer expectedBuild);
		EventStatusException.EventStatusExceptionBuilder setActualBuild(Integer actualBuild);
		EventStatusException.EventStatusExceptionBuilder setHeader(ExceptionMessageHeader header);
		EventStatusException.EventStatusExceptionBuilder setValidationModel(ValidationModel validationModel);
		EventStatusException.EventStatusExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		EventStatusException.EventStatusExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		EventStatusException.EventStatusExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of EventStatusException  ***********************/
	class EventStatusExceptionImpl extends Exception.ExceptionImpl implements EventStatusException {
		
		protected EventStatusExceptionImpl(EventStatusException.EventStatusExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public EventStatusException build() {
			return this;
		}
		
		@Override
		public EventStatusException.EventStatusExceptionBuilder toBuilder() {
			EventStatusException.EventStatusExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventStatusException.EventStatusExceptionBuilder builder) {
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
			return "EventStatusException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EventStatusException  ***********************/
	class EventStatusExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements EventStatusException.EventStatusExceptionBuilder {
	
	
		public EventStatusExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public EventStatusException.EventStatusExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public EventStatusException.EventStatusExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public EventStatusException.EventStatusExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public EventStatusException.EventStatusExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public EventStatusException.EventStatusExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public EventStatusException.EventStatusExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public EventStatusException build() {
			return new EventStatusException.EventStatusExceptionImpl(this);
		}
		
		@Override
		public EventStatusException.EventStatusExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventStatusException.EventStatusExceptionBuilder prune() {
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
		public EventStatusException.EventStatusExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EventStatusException.EventStatusExceptionBuilder o = (EventStatusException.EventStatusExceptionBuilder) other;
			
			
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
			return "EventStatusExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
