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
import fpml.confirmation.NotificationMessage;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilder;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilderImpl;
import fpml.confirmation.NotificationMessage.NotificationMessageImpl;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.ServiceAdvisory;
import fpml.confirmation.ServiceNotification;
import fpml.confirmation.ServiceNotification.ServiceNotificationBuilder;
import fpml.confirmation.ServiceNotification.ServiceNotificationBuilderImpl;
import fpml.confirmation.ServiceNotification.ServiceNotificationImpl;
import fpml.confirmation.ServiceProcessingStatus;
import fpml.confirmation.ServiceStatus;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ServiceNotificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the content model for a message that allows a service to send a notification message to a user of the service.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ServiceNotification", builder=ServiceNotification.ServiceNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ServiceNotification extends NotificationMessage {

	ServiceNotificationMeta metaData = new ServiceNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the service to which the message applies
	 */
	String getServiceName();
	/**
	 * The current state of the service (e.g. Available, Unavailable).
	 */
	ServiceStatus getStatus();
	/**
	 * A description of the stage of processing of the service, for example EndofDayProcessingCutoffOccurred, EndOfDayProcessingCompleted. [TBD: could be combined with advisory]
	 */
	ServiceProcessingStatus getProcessingStatus();
	/**
	 * A human-readable message providing information about the service..
	 */
	ServiceAdvisory getAdvisory();

	/*********************** Build Methods  ***********************/
	ServiceNotification build();
	
	ServiceNotification.ServiceNotificationBuilder toBuilder();
	
	static ServiceNotification.ServiceNotificationBuilder builder() {
		return new ServiceNotification.ServiceNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ServiceNotification> getType() {
		return ServiceNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
		processRosetta(path.newSubPath("status"), processor, ServiceStatus.class, getStatus());
		processRosetta(path.newSubPath("processingStatus"), processor, ServiceProcessingStatus.class, getProcessingStatus());
		processRosetta(path.newSubPath("advisory"), processor, ServiceAdvisory.class, getAdvisory());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceNotificationBuilder extends ServiceNotification, NotificationMessage.NotificationMessageBuilder {
		ServiceStatus.ServiceStatusBuilder getOrCreateStatus();
		ServiceStatus.ServiceStatusBuilder getStatus();
		ServiceProcessingStatus.ServiceProcessingStatusBuilder getOrCreateProcessingStatus();
		ServiceProcessingStatus.ServiceProcessingStatusBuilder getProcessingStatus();
		ServiceAdvisory.ServiceAdvisoryBuilder getOrCreateAdvisory();
		ServiceAdvisory.ServiceAdvisoryBuilder getAdvisory();
		ServiceNotification.ServiceNotificationBuilder setExpectedBuild(Integer expectedBuild);
		ServiceNotification.ServiceNotificationBuilder setActualBuild(Integer actualBuild);
		ServiceNotification.ServiceNotificationBuilder setHeader(NotificationMessageHeader header);
		ServiceNotification.ServiceNotificationBuilder setValidationModel(ValidationModel validationModel);
		ServiceNotification.ServiceNotificationBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ServiceNotification.ServiceNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ServiceNotification.ServiceNotificationBuilder setServiceName(String serviceName);
		ServiceNotification.ServiceNotificationBuilder setStatus(ServiceStatus status);
		ServiceNotification.ServiceNotificationBuilder setProcessingStatus(ServiceProcessingStatus processingStatus);
		ServiceNotification.ServiceNotificationBuilder setAdvisory(ServiceAdvisory advisory);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
			processRosetta(path.newSubPath("status"), processor, ServiceStatus.ServiceStatusBuilder.class, getStatus());
			processRosetta(path.newSubPath("processingStatus"), processor, ServiceProcessingStatus.ServiceProcessingStatusBuilder.class, getProcessingStatus());
			processRosetta(path.newSubPath("advisory"), processor, ServiceAdvisory.ServiceAdvisoryBuilder.class, getAdvisory());
		}
		

		ServiceNotification.ServiceNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceNotification  ***********************/
	class ServiceNotificationImpl extends NotificationMessage.NotificationMessageImpl implements ServiceNotification {
		private final String serviceName;
		private final ServiceStatus status;
		private final ServiceProcessingStatus processingStatus;
		private final ServiceAdvisory advisory;
		
		protected ServiceNotificationImpl(ServiceNotification.ServiceNotificationBuilder builder) {
			super(builder);
			this.serviceName = builder.getServiceName();
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
			this.processingStatus = ofNullable(builder.getProcessingStatus()).map(f->f.build()).orElse(null);
			this.advisory = ofNullable(builder.getAdvisory()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("status")
		public ServiceStatus getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("processingStatus")
		public ServiceProcessingStatus getProcessingStatus() {
			return processingStatus;
		}
		
		@Override
		@RosettaAttribute("advisory")
		public ServiceAdvisory getAdvisory() {
			return advisory;
		}
		
		@Override
		public ServiceNotification build() {
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder toBuilder() {
			ServiceNotification.ServiceNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceNotification.ServiceNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getServiceName()).ifPresent(builder::setServiceName);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getProcessingStatus()).ifPresent(builder::setProcessingStatus);
			ofNullable(getAdvisory()).ifPresent(builder::setAdvisory);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ServiceNotification _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(processingStatus, _that.getProcessingStatus())) return false;
			if (!Objects.equals(advisory, _that.getAdvisory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (processingStatus != null ? processingStatus.hashCode() : 0);
			_result = 31 * _result + (advisory != null ? advisory.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceNotification {" +
				"serviceName=" + this.serviceName + ", " +
				"status=" + this.status + ", " +
				"processingStatus=" + this.processingStatus + ", " +
				"advisory=" + this.advisory +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ServiceNotification  ***********************/
	class ServiceNotificationBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl  implements ServiceNotification.ServiceNotificationBuilder {
	
		protected String serviceName;
		protected ServiceStatus.ServiceStatusBuilder status;
		protected ServiceProcessingStatus.ServiceProcessingStatusBuilder processingStatus;
		protected ServiceAdvisory.ServiceAdvisoryBuilder advisory;
	
		public ServiceNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("status")
		public ServiceStatus.ServiceStatusBuilder getStatus() {
			return status;
		}
		
		@Override
		public ServiceStatus.ServiceStatusBuilder getOrCreateStatus() {
			ServiceStatus.ServiceStatusBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = ServiceStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("processingStatus")
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder getProcessingStatus() {
			return processingStatus;
		}
		
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder getOrCreateProcessingStatus() {
			ServiceProcessingStatus.ServiceProcessingStatusBuilder result;
			if (processingStatus!=null) {
				result = processingStatus;
			}
			else {
				result = processingStatus = ServiceProcessingStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("advisory")
		public ServiceAdvisory.ServiceAdvisoryBuilder getAdvisory() {
			return advisory;
		}
		
		@Override
		public ServiceAdvisory.ServiceAdvisoryBuilder getOrCreateAdvisory() {
			ServiceAdvisory.ServiceAdvisoryBuilder result;
			if (advisory!=null) {
				result = advisory;
			}
			else {
				result = advisory = ServiceAdvisory.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public ServiceNotification.ServiceNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ServiceNotification.ServiceNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ServiceNotification.ServiceNotificationBuilder setHeader(NotificationMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ServiceNotification.ServiceNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ServiceNotification.ServiceNotificationBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ServiceNotification.ServiceNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("serviceName")
		public ServiceNotification.ServiceNotificationBuilder setServiceName(String serviceName) {
			this.serviceName = serviceName==null?null:serviceName;
			return this;
		}
		@Override
		@RosettaAttribute("status")
		public ServiceNotification.ServiceNotificationBuilder setStatus(ServiceStatus status) {
			this.status = status==null?null:status.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("processingStatus")
		public ServiceNotification.ServiceNotificationBuilder setProcessingStatus(ServiceProcessingStatus processingStatus) {
			this.processingStatus = processingStatus==null?null:processingStatus.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("advisory")
		public ServiceNotification.ServiceNotificationBuilder setAdvisory(ServiceAdvisory advisory) {
			this.advisory = advisory==null?null:advisory.toBuilder();
			return this;
		}
		
		@Override
		public ServiceNotification build() {
			return new ServiceNotification.ServiceNotificationImpl(this);
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceNotification.ServiceNotificationBuilder prune() {
			super.prune();
			if (status!=null && !status.prune().hasData()) status = null;
			if (processingStatus!=null && !processingStatus.prune().hasData()) processingStatus = null;
			if (advisory!=null && !advisory.prune().hasData()) advisory = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getServiceName()!=null) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			if (getProcessingStatus()!=null && getProcessingStatus().hasData()) return true;
			if (getAdvisory()!=null && getAdvisory().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceNotification.ServiceNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ServiceNotification.ServiceNotificationBuilder o = (ServiceNotification.ServiceNotificationBuilder) other;
			
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeRosetta(getProcessingStatus(), o.getProcessingStatus(), this::setProcessingStatus);
			merger.mergeRosetta(getAdvisory(), o.getAdvisory(), this::setAdvisory);
			
			merger.mergeBasic(getServiceName(), o.getServiceName(), this::setServiceName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ServiceNotification _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(processingStatus, _that.getProcessingStatus())) return false;
			if (!Objects.equals(advisory, _that.getAdvisory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (processingStatus != null ? processingStatus.hashCode() : 0);
			_result = 31 * _result + (advisory != null ? advisory.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceNotificationBuilder {" +
				"serviceName=" + this.serviceName + ", " +
				"status=" + this.status + ", " +
				"processingStatus=" + this.processingStatus + ", " +
				"advisory=" + this.advisory +
			'}' + " " + super.toString();
		}
	}
}
