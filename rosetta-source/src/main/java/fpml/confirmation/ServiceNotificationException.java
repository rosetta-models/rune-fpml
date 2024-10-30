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
import fpml.confirmation.ServiceNotificationException;
import fpml.confirmation.ServiceNotificationException.ServiceNotificationExceptionBuilder;
import fpml.confirmation.ServiceNotificationException.ServiceNotificationExceptionBuilderImpl;
import fpml.confirmation.ServiceNotificationException.ServiceNotificationExceptionImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ServiceNotificationExceptionMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ServiceNotificationException", builder=ServiceNotificationException.ServiceNotificationExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ServiceNotificationException extends Exception {

	ServiceNotificationExceptionMeta metaData = new ServiceNotificationExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ServiceNotificationException build();
	
	ServiceNotificationException.ServiceNotificationExceptionBuilder toBuilder();
	
	static ServiceNotificationException.ServiceNotificationExceptionBuilder builder() {
		return new ServiceNotificationException.ServiceNotificationExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceNotificationException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ServiceNotificationException> getType() {
		return ServiceNotificationException.class;
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
	interface ServiceNotificationExceptionBuilder extends ServiceNotificationException, Exception.ExceptionBuilder {
		ServiceNotificationException.ServiceNotificationExceptionBuilder setExpectedBuild(Integer expectedBuild);
		ServiceNotificationException.ServiceNotificationExceptionBuilder setActualBuild(Integer actualBuild);
		ServiceNotificationException.ServiceNotificationExceptionBuilder setHeader(ExceptionMessageHeader header);
		ServiceNotificationException.ServiceNotificationExceptionBuilder setValidationModel(ValidationModel validationModel);
		ServiceNotificationException.ServiceNotificationExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ServiceNotificationException.ServiceNotificationExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
		}
		

		ServiceNotificationException.ServiceNotificationExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceNotificationException  ***********************/
	class ServiceNotificationExceptionImpl extends Exception.ExceptionImpl implements ServiceNotificationException {
		
		protected ServiceNotificationExceptionImpl(ServiceNotificationException.ServiceNotificationExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public ServiceNotificationException build() {
			return this;
		}
		
		@Override
		public ServiceNotificationException.ServiceNotificationExceptionBuilder toBuilder() {
			ServiceNotificationException.ServiceNotificationExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceNotificationException.ServiceNotificationExceptionBuilder builder) {
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
			return "ServiceNotificationException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ServiceNotificationException  ***********************/
	class ServiceNotificationExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements ServiceNotificationException.ServiceNotificationExceptionBuilder {
	
	
		public ServiceNotificationExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ServiceNotificationException.ServiceNotificationExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ServiceNotificationException.ServiceNotificationExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ServiceNotificationException.ServiceNotificationExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ServiceNotificationException.ServiceNotificationExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ServiceNotificationException.ServiceNotificationExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public ServiceNotificationException.ServiceNotificationExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		
		@Override
		public ServiceNotificationException build() {
			return new ServiceNotificationException.ServiceNotificationExceptionImpl(this);
		}
		
		@Override
		public ServiceNotificationException.ServiceNotificationExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceNotificationException.ServiceNotificationExceptionBuilder prune() {
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
		public ServiceNotificationException.ServiceNotificationExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ServiceNotificationException.ServiceNotificationExceptionBuilder o = (ServiceNotificationException.ServiceNotificationExceptionBuilder) other;
			
			
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
			return "ServiceNotificationExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
