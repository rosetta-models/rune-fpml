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
import fpml.confirmation.EventRequestAcknowledgement;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementBuilder;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.EventRequestAcknowledgementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the structure for a message acknowledging an event request.
 * @version ${project.version}
 */
@RosettaDataType(value="EventRequestAcknowledgement", builder=EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl.class, version="${project.version}")
public interface EventRequestAcknowledgement extends ResponseMessage {

	EventRequestAcknowledgementMeta metaData = new EventRequestAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/
	UnprocessedElementWrapper getOriginalMessage();
	TradeReferenceInformationModel getTradeReferenceInformationModel();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	EventRequestAcknowledgement build();
	
	EventRequestAcknowledgement.EventRequestAcknowledgementBuilder toBuilder();
	
	static EventRequestAcknowledgement.EventRequestAcknowledgementBuilder builder() {
		return new EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventRequestAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventRequestAcknowledgement> getType() {
		return EventRequestAcknowledgement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventRequestAcknowledgementBuilder extends EventRequestAcknowledgement, ResponseMessage.ResponseMessageBuilder {
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setActualBuild(Integer actualBuild);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		EventRequestAcknowledgement.EventRequestAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of EventRequestAcknowledgement  ***********************/
	class EventRequestAcknowledgementImpl extends ResponseMessage.ResponseMessageImpl implements EventRequestAcknowledgement {
		private final UnprocessedElementWrapper originalMessage;
		private final TradeReferenceInformationModel tradeReferenceInformationModel;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected EventRequestAcknowledgementImpl(EventRequestAcknowledgement.EventRequestAcknowledgementBuilder builder) {
			super(builder);
			this.originalMessage = ofNullable(builder.getOriginalMessage()).map(f->f.build()).orElse(null);
			this.tradeReferenceInformationModel = ofNullable(builder.getTradeReferenceInformationModel()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		public UnprocessedElementWrapper getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public EventRequestAcknowledgement build() {
			return this;
		}
		
		@Override
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder toBuilder() {
			EventRequestAcknowledgement.EventRequestAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventRequestAcknowledgement.EventRequestAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOriginalMessage()).ifPresent(builder::setOriginalMessage);
			ofNullable(getTradeReferenceInformationModel()).ifPresent(builder::setTradeReferenceInformationModel);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventRequestAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventRequestAcknowledgement {" +
				"originalMessage=" + this.originalMessage + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EventRequestAcknowledgement  ***********************/
	class EventRequestAcknowledgementBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
	
		protected UnprocessedElementWrapper.UnprocessedElementWrapperBuilder originalMessage;
		protected TradeReferenceInformationModel.TradeReferenceInformationModelBuilder tradeReferenceInformationModel;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public EventRequestAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("originalMessage")
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder result;
			if (originalMessage!=null) {
				result = originalMessage;
			}
			else {
				result = originalMessage = UnprocessedElementWrapper.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel() {
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder result;
			if (tradeReferenceInformationModel!=null) {
				result = tradeReferenceInformationModel;
			}
			else {
				result = tradeReferenceInformationModel = TradeReferenceInformationModel.builder();
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
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public EventRequestAcknowledgement build() {
			return new EventRequestAcknowledgement.EventRequestAcknowledgementImpl(this);
		}
		
		@Override
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder prune() {
			super.prune();
			if (originalMessage!=null && !originalMessage.prune().hasData()) originalMessage = null;
			if (tradeReferenceInformationModel!=null && !tradeReferenceInformationModel.prune().hasData()) tradeReferenceInformationModel = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOriginalMessage()!=null && getOriginalMessage().hasData()) return true;
			if (getTradeReferenceInformationModel()!=null && getTradeReferenceInformationModel().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventRequestAcknowledgement.EventRequestAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EventRequestAcknowledgement.EventRequestAcknowledgementBuilder o = (EventRequestAcknowledgement.EventRequestAcknowledgementBuilder) other;
			
			merger.mergeRosetta(getOriginalMessage(), o.getOriginalMessage(), this::setOriginalMessage);
			merger.mergeRosetta(getTradeReferenceInformationModel(), o.getTradeReferenceInformationModel(), this::setTradeReferenceInformationModel);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventRequestAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventRequestAcknowledgementBuilder {" +
				"originalMessage=" + this.originalMessage + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
