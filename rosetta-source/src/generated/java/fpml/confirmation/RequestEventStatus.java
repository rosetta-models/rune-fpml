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
import fpml.confirmation.BusinessProcess;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventIdentifier;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestEventStatus;
import fpml.confirmation.RequestEventStatus.RequestEventStatusBuilder;
import fpml.confirmation.RequestEventStatus.RequestEventStatusBuilderImpl;
import fpml.confirmation.RequestEventStatus.RequestEventStatusImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestEventStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the content model for a message allowing one party to query the status of one event (trade or post-trade event) previously sent to another party.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestEventStatus", builder=RequestEventStatus.RequestEventStatusBuilderImpl.class, version="${project.version}")
public interface RequestEventStatus extends NonCorrectableRequestMessage {

	RequestEventStatusMeta metaData = new RequestEventStatusMeta();

	/*********************** Getter Methods  ***********************/
	BusinessProcess getBusinessProcess();
	EventIdentifier getEventIdentifier();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestEventStatus build();
	
	RequestEventStatus.RequestEventStatusBuilder toBuilder();
	
	static RequestEventStatus.RequestEventStatusBuilder builder() {
		return new RequestEventStatus.RequestEventStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestEventStatus> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestEventStatus> getType() {
		return RequestEventStatus.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("businessProcess"), processor, BusinessProcess.class, getBusinessProcess());
		processRosetta(path.newSubPath("eventIdentifier"), processor, EventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestEventStatusBuilder extends RequestEventStatus, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		BusinessProcess.BusinessProcessBuilder getOrCreateBusinessProcess();
		BusinessProcess.BusinessProcessBuilder getBusinessProcess();
		EventIdentifier.EventIdentifierBuilder getOrCreateEventIdentifier();
		EventIdentifier.EventIdentifierBuilder getEventIdentifier();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestEventStatus.RequestEventStatusBuilder setExpectedBuild(Integer expectedBuild);
		RequestEventStatus.RequestEventStatusBuilder setActualBuild(Integer actualBuild);
		RequestEventStatus.RequestEventStatusBuilder setHeader(RequestMessageHeader header);
		RequestEventStatus.RequestEventStatusBuilder setValidationModel(ValidationModel validationModel);
		RequestEventStatus.RequestEventStatusBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestEventStatus.RequestEventStatusBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestEventStatus.RequestEventStatusBuilder setBusinessProcess(BusinessProcess businessProcess);
		RequestEventStatus.RequestEventStatusBuilder setEventIdentifier(EventIdentifier eventIdentifier);
		RequestEventStatus.RequestEventStatusBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("businessProcess"), processor, BusinessProcess.BusinessProcessBuilder.class, getBusinessProcess());
			processRosetta(path.newSubPath("eventIdentifier"), processor, EventIdentifier.EventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestEventStatus.RequestEventStatusBuilder prune();
	}

	/*********************** Immutable Implementation of RequestEventStatus  ***********************/
	class RequestEventStatusImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements RequestEventStatus {
		private final BusinessProcess businessProcess;
		private final EventIdentifier eventIdentifier;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestEventStatusImpl(RequestEventStatus.RequestEventStatusBuilder builder) {
			super(builder);
			this.businessProcess = ofNullable(builder.getBusinessProcess()).map(f->f.build()).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessProcess")
		public BusinessProcess getBusinessProcess() {
			return businessProcess;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public EventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestEventStatus build() {
			return this;
		}
		
		@Override
		public RequestEventStatus.RequestEventStatusBuilder toBuilder() {
			RequestEventStatus.RequestEventStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestEventStatus.RequestEventStatusBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessProcess()).ifPresent(builder::setBusinessProcess);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestEventStatus _that = getType().cast(o);
		
			if (!Objects.equals(businessProcess, _that.getBusinessProcess())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessProcess != null ? businessProcess.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestEventStatus {" +
				"businessProcess=" + this.businessProcess + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestEventStatus  ***********************/
	class RequestEventStatusBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements RequestEventStatus.RequestEventStatusBuilder {
	
		protected BusinessProcess.BusinessProcessBuilder businessProcess;
		protected EventIdentifier.EventIdentifierBuilder eventIdentifier;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestEventStatusBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessProcess")
		public BusinessProcess.BusinessProcessBuilder getBusinessProcess() {
			return businessProcess;
		}
		
		@Override
		public BusinessProcess.BusinessProcessBuilder getOrCreateBusinessProcess() {
			BusinessProcess.BusinessProcessBuilder result;
			if (businessProcess!=null) {
				result = businessProcess;
			}
			else {
				result = businessProcess = BusinessProcess.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public EventIdentifier.EventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder getOrCreateEventIdentifier() {
			EventIdentifier.EventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = EventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder result;
			if (partiesAndAccountsModel!=null) {
				result = partiesAndAccountsModel;
			}
			else {
				result = partiesAndAccountsModel = PartiesAndAccountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public RequestEventStatus.RequestEventStatusBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestEventStatus.RequestEventStatusBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestEventStatus.RequestEventStatusBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestEventStatus.RequestEventStatusBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestEventStatus.RequestEventStatusBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestEventStatus.RequestEventStatusBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessProcess")
		public RequestEventStatus.RequestEventStatusBuilder setBusinessProcess(BusinessProcess businessProcess) {
			this.businessProcess = businessProcess==null?null:businessProcess.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventIdentifier")
		public RequestEventStatus.RequestEventStatusBuilder setEventIdentifier(EventIdentifier eventIdentifier) {
			this.eventIdentifier = eventIdentifier==null?null:eventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestEventStatus.RequestEventStatusBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestEventStatus build() {
			return new RequestEventStatus.RequestEventStatusImpl(this);
		}
		
		@Override
		public RequestEventStatus.RequestEventStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestEventStatus.RequestEventStatusBuilder prune() {
			super.prune();
			if (businessProcess!=null && !businessProcess.prune().hasData()) businessProcess = null;
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessProcess()!=null && getBusinessProcess().hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestEventStatus.RequestEventStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestEventStatus.RequestEventStatusBuilder o = (RequestEventStatus.RequestEventStatusBuilder) other;
			
			merger.mergeRosetta(getBusinessProcess(), o.getBusinessProcess(), this::setBusinessProcess);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestEventStatus _that = getType().cast(o);
		
			if (!Objects.equals(businessProcess, _that.getBusinessProcess())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessProcess != null ? businessProcess.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestEventStatusBuilder {" +
				"businessProcess=" + this.businessProcess + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
