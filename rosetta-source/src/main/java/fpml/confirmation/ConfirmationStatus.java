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
import fpml.confirmation.ConfirmationStatus;
import fpml.confirmation.ConfirmationStatus.ConfirmationStatusBuilder;
import fpml.confirmation.ConfirmationStatus.ConfirmationStatusBuilderImpl;
import fpml.confirmation.ConfirmationStatus.ConfirmationStatusImpl;
import fpml.confirmation.ConfirmationStatusSequence;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.EventStatus;
import fpml.confirmation.EventsChoice;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ConfirmationStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The confirmationStatus message provides the status of the matching process: matched, mismatched, unmatched, or alleged. It may also provide the best fit trade(s) or event(s) as result of the matching process. Message for sending matching results. Response message that returns the status of an event that have been submitted for matching.
 * @version ${project.version}
 */
@RosettaDataType(value="ConfirmationStatus", builder=ConfirmationStatus.ConfirmationStatusBuilderImpl.class, version="${project.version}")
public interface ConfirmationStatus extends ResponseMessage {

	ConfirmationStatusMeta metaData = new ConfirmationStatusMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the confirmation status of a trade or post-trade event (e.g. Matched, Mismatched, Unmatched, Alleged).
	 */
	EventStatus getStatus();
	ConfirmationStatusSequence getConfirmationStatusSequence();
	/**
	 * Event (trade post-trade event) asserted by the &quot;other side&#39;s&quot; party.
	 */
	EventsChoice getAllegedEvent();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ConfirmationStatus build();
	
	ConfirmationStatus.ConfirmationStatusBuilder toBuilder();
	
	static ConfirmationStatus.ConfirmationStatusBuilder builder() {
		return new ConfirmationStatus.ConfirmationStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationStatus> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConfirmationStatus> getType() {
		return ConfirmationStatus.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("status"), processor, EventStatus.class, getStatus());
		processRosetta(path.newSubPath("confirmationStatusSequence"), processor, ConfirmationStatusSequence.class, getConfirmationStatusSequence());
		processRosetta(path.newSubPath("allegedEvent"), processor, EventsChoice.class, getAllegedEvent());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConfirmationStatusBuilder extends ConfirmationStatus, ResponseMessage.ResponseMessageBuilder {
		EventStatus.EventStatusBuilder getOrCreateStatus();
		EventStatus.EventStatusBuilder getStatus();
		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder getOrCreateConfirmationStatusSequence();
		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder getConfirmationStatusSequence();
		EventsChoice.EventsChoiceBuilder getOrCreateAllegedEvent();
		EventsChoice.EventsChoiceBuilder getAllegedEvent();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ConfirmationStatus.ConfirmationStatusBuilder setExpectedBuild(Integer expectedBuild);
		ConfirmationStatus.ConfirmationStatusBuilder setActualBuild(Integer actualBuild);
		ConfirmationStatus.ConfirmationStatusBuilder setHeader(ResponseMessageHeader header);
		ConfirmationStatus.ConfirmationStatusBuilder setValidationModel(ValidationModel validationModel);
		ConfirmationStatus.ConfirmationStatusBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ConfirmationStatus.ConfirmationStatusBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ConfirmationStatus.ConfirmationStatusBuilder setStatus(EventStatus status);
		ConfirmationStatus.ConfirmationStatusBuilder setConfirmationStatusSequence(ConfirmationStatusSequence confirmationStatusSequence);
		ConfirmationStatus.ConfirmationStatusBuilder setAllegedEvent(EventsChoice allegedEvent);
		ConfirmationStatus.ConfirmationStatusBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("status"), processor, EventStatus.EventStatusBuilder.class, getStatus());
			processRosetta(path.newSubPath("confirmationStatusSequence"), processor, ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder.class, getConfirmationStatusSequence());
			processRosetta(path.newSubPath("allegedEvent"), processor, EventsChoice.EventsChoiceBuilder.class, getAllegedEvent());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ConfirmationStatus.ConfirmationStatusBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationStatus  ***********************/
	class ConfirmationStatusImpl extends ResponseMessage.ResponseMessageImpl implements ConfirmationStatus {
		private final EventStatus status;
		private final ConfirmationStatusSequence confirmationStatusSequence;
		private final EventsChoice allegedEvent;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ConfirmationStatusImpl(ConfirmationStatus.ConfirmationStatusBuilder builder) {
			super(builder);
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
			this.confirmationStatusSequence = ofNullable(builder.getConfirmationStatusSequence()).map(f->f.build()).orElse(null);
			this.allegedEvent = ofNullable(builder.getAllegedEvent()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("status")
		public EventStatus getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("confirmationStatusSequence")
		public ConfirmationStatusSequence getConfirmationStatusSequence() {
			return confirmationStatusSequence;
		}
		
		@Override
		@RosettaAttribute("allegedEvent")
		public EventsChoice getAllegedEvent() {
			return allegedEvent;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ConfirmationStatus build() {
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder toBuilder() {
			ConfirmationStatus.ConfirmationStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationStatus.ConfirmationStatusBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getConfirmationStatusSequence()).ifPresent(builder::setConfirmationStatusSequence);
			ofNullable(getAllegedEvent()).ifPresent(builder::setAllegedEvent);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationStatus _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(confirmationStatusSequence, _that.getConfirmationStatusSequence())) return false;
			if (!Objects.equals(allegedEvent, _that.getAllegedEvent())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (confirmationStatusSequence != null ? confirmationStatusSequence.hashCode() : 0);
			_result = 31 * _result + (allegedEvent != null ? allegedEvent.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationStatus {" +
				"status=" + this.status + ", " +
				"confirmationStatusSequence=" + this.confirmationStatusSequence + ", " +
				"allegedEvent=" + this.allegedEvent + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConfirmationStatus  ***********************/
	class ConfirmationStatusBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements ConfirmationStatus.ConfirmationStatusBuilder {
	
		protected EventStatus.EventStatusBuilder status;
		protected ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder confirmationStatusSequence;
		protected EventsChoice.EventsChoiceBuilder allegedEvent;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ConfirmationStatusBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("status")
		public EventStatus.EventStatusBuilder getStatus() {
			return status;
		}
		
		@Override
		public EventStatus.EventStatusBuilder getOrCreateStatus() {
			EventStatus.EventStatusBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = EventStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("confirmationStatusSequence")
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder getConfirmationStatusSequence() {
			return confirmationStatusSequence;
		}
		
		@Override
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder getOrCreateConfirmationStatusSequence() {
			ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder result;
			if (confirmationStatusSequence!=null) {
				result = confirmationStatusSequence;
			}
			else {
				result = confirmationStatusSequence = ConfirmationStatusSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allegedEvent")
		public EventsChoice.EventsChoiceBuilder getAllegedEvent() {
			return allegedEvent;
		}
		
		@Override
		public EventsChoice.EventsChoiceBuilder getOrCreateAllegedEvent() {
			EventsChoice.EventsChoiceBuilder result;
			if (allegedEvent!=null) {
				result = allegedEvent;
			}
			else {
				result = allegedEvent = EventsChoice.builder();
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
		public ConfirmationStatus.ConfirmationStatusBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ConfirmationStatus.ConfirmationStatusBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ConfirmationStatus.ConfirmationStatusBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ConfirmationStatus.ConfirmationStatusBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ConfirmationStatus.ConfirmationStatusBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ConfirmationStatus.ConfirmationStatusBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("status")
		public ConfirmationStatus.ConfirmationStatusBuilder setStatus(EventStatus status) {
			this.status = status==null?null:status.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("confirmationStatusSequence")
		public ConfirmationStatus.ConfirmationStatusBuilder setConfirmationStatusSequence(ConfirmationStatusSequence confirmationStatusSequence) {
			this.confirmationStatusSequence = confirmationStatusSequence==null?null:confirmationStatusSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allegedEvent")
		public ConfirmationStatus.ConfirmationStatusBuilder setAllegedEvent(EventsChoice allegedEvent) {
			this.allegedEvent = allegedEvent==null?null:allegedEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ConfirmationStatus.ConfirmationStatusBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ConfirmationStatus build() {
			return new ConfirmationStatus.ConfirmationStatusImpl(this);
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder prune() {
			super.prune();
			if (status!=null && !status.prune().hasData()) status = null;
			if (confirmationStatusSequence!=null && !confirmationStatusSequence.prune().hasData()) confirmationStatusSequence = null;
			if (allegedEvent!=null && !allegedEvent.prune().hasData()) allegedEvent = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			if (getConfirmationStatusSequence()!=null && getConfirmationStatusSequence().hasData()) return true;
			if (getAllegedEvent()!=null && getAllegedEvent().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConfirmationStatus.ConfirmationStatusBuilder o = (ConfirmationStatus.ConfirmationStatusBuilder) other;
			
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeRosetta(getConfirmationStatusSequence(), o.getConfirmationStatusSequence(), this::setConfirmationStatusSequence);
			merger.mergeRosetta(getAllegedEvent(), o.getAllegedEvent(), this::setAllegedEvent);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationStatus _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(confirmationStatusSequence, _that.getConfirmationStatusSequence())) return false;
			if (!Objects.equals(allegedEvent, _that.getAllegedEvent())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (confirmationStatusSequence != null ? confirmationStatusSequence.hashCode() : 0);
			_result = 31 * _result + (allegedEvent != null ? allegedEvent.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationStatusBuilder {" +
				"status=" + this.status + ", " +
				"confirmationStatusSequence=" + this.confirmationStatusSequence + ", " +
				"allegedEvent=" + this.allegedEvent + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
