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
import fpml.confirmation.ApprovalType;
import fpml.confirmation.CompressionModel;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.RequestConsent;
import fpml.confirmation.RequestConsent.RequestConsentBuilder;
import fpml.confirmation.RequestConsent.RequestConsentBuilderImpl;
import fpml.confirmation.RequestConsent.RequestConsentImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestedAction;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestConsentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message requesting that the sender be authorized by the recipient to peform an action.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestConsent", builder=RequestConsent.RequestConsentBuilderImpl.class, version="${project.version}")
public interface RequestConsent extends CorrectableRequestMessage {

	RequestConsentMeta metaData = new RequestConsentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reason the consent was requested.
	 */
	RequestedAction getRequestedAction();
	/**
	 * The type of approval (e.g. &quot;pre-clearing credit&quot;).
	 */
	ApprovalType get_type();
	/**
	 * The full name or identifiying ID of the relevant approver.
	 */
	PersonId getApprover();
	/**
	 * A pointer style reference to a party defined elsewhere in the document. The party referenced needs to approve the specified item (e.g. trade or allocation).
	 */
	PartyReference getApprovingPartyReference();
	PortfolioReferenceModel getPortfolioReferenceModel();
	CompressionModel getCompressionModel();
	TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel();
	/**
	 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 */
	DeClear getDeClear();
	EventValuationModel getEventValuationModel();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestConsent build();
	
	RequestConsent.RequestConsentBuilder toBuilder();
	
	static RequestConsent.RequestConsentBuilder builder() {
		return new RequestConsent.RequestConsentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestConsent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestConsent> getType() {
		return RequestConsent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("requestedAction"), processor, RequestedAction.class, getRequestedAction());
		processRosetta(path.newSubPath("_type"), processor, ApprovalType.class, get_type());
		processRosetta(path.newSubPath("approver"), processor, PersonId.class, getApprover());
		processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.class, getApprovingPartyReference());
		processRosetta(path.newSubPath("portfolioReferenceModel"), processor, PortfolioReferenceModel.class, getPortfolioReferenceModel());
		processRosetta(path.newSubPath("compressionModel"), processor, CompressionModel.class, getCompressionModel());
		processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.class, getTradingAndPostTradeEventsModel());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.class, getEventValuationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestConsentBuilder extends RequestConsent, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		RequestedAction.RequestedActionBuilder getOrCreateRequestedAction();
		RequestedAction.RequestedActionBuilder getRequestedAction();
		ApprovalType.ApprovalTypeBuilder getOrCreate_type();
		ApprovalType.ApprovalTypeBuilder get_type();
		PersonId.PersonIdBuilder getOrCreateApprover();
		PersonId.PersonIdBuilder getApprover();
		PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference();
		PartyReference.PartyReferenceBuilder getApprovingPartyReference();
		PortfolioReferenceModel.PortfolioReferenceModelBuilder getOrCreatePortfolioReferenceModel();
		PortfolioReferenceModel.PortfolioReferenceModelBuilder getPortfolioReferenceModel();
		CompressionModel.CompressionModelBuilder getOrCreateCompressionModel();
		CompressionModel.CompressionModelBuilder getCompressionModel();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel();
		DeClear.DeClearBuilder getOrCreateDeClear();
		DeClear.DeClearBuilder getDeClear();
		EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel();
		EventValuationModel.EventValuationModelBuilder getEventValuationModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestConsent.RequestConsentBuilder setExpectedBuild(Integer expectedBuild);
		RequestConsent.RequestConsentBuilder setActualBuild(Integer actualBuild);
		RequestConsent.RequestConsentBuilder setHeader(RequestMessageHeader header);
		RequestConsent.RequestConsentBuilder setValidationModel(ValidationModel validationModel);
		RequestConsent.RequestConsentBuilder setIsCorrection(Boolean isCorrection);
		RequestConsent.RequestConsentBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestConsent.RequestConsentBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestConsent.RequestConsentBuilder setRequestedAction(RequestedAction requestedAction);
		RequestConsent.RequestConsentBuilder set_type(ApprovalType _type);
		RequestConsent.RequestConsentBuilder setApprover(PersonId approver);
		RequestConsent.RequestConsentBuilder setApprovingPartyReference(PartyReference approvingPartyReference);
		RequestConsent.RequestConsentBuilder setPortfolioReferenceModel(PortfolioReferenceModel portfolioReferenceModel);
		RequestConsent.RequestConsentBuilder setCompressionModel(CompressionModel compressionModel);
		RequestConsent.RequestConsentBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel);
		RequestConsent.RequestConsentBuilder setDeClear(DeClear deClear);
		RequestConsent.RequestConsentBuilder setEventValuationModel(EventValuationModel eventValuationModel);
		RequestConsent.RequestConsentBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("requestedAction"), processor, RequestedAction.RequestedActionBuilder.class, getRequestedAction());
			processRosetta(path.newSubPath("_type"), processor, ApprovalType.ApprovalTypeBuilder.class, get_type());
			processRosetta(path.newSubPath("approver"), processor, PersonId.PersonIdBuilder.class, getApprover());
			processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovingPartyReference());
			processRosetta(path.newSubPath("portfolioReferenceModel"), processor, PortfolioReferenceModel.PortfolioReferenceModelBuilder.class, getPortfolioReferenceModel());
			processRosetta(path.newSubPath("compressionModel"), processor, CompressionModel.CompressionModelBuilder.class, getCompressionModel());
			processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder.class, getTradingAndPostTradeEventsModel());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.EventValuationModelBuilder.class, getEventValuationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestConsent.RequestConsentBuilder prune();
	}

	/*********************** Immutable Implementation of RequestConsent  ***********************/
	class RequestConsentImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestConsent {
		private final RequestedAction requestedAction;
		private final ApprovalType _type;
		private final PersonId approver;
		private final PartyReference approvingPartyReference;
		private final PortfolioReferenceModel portfolioReferenceModel;
		private final CompressionModel compressionModel;
		private final TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel;
		private final DeClear deClear;
		private final EventValuationModel eventValuationModel;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestConsentImpl(RequestConsent.RequestConsentBuilder builder) {
			super(builder);
			this.requestedAction = ofNullable(builder.getRequestedAction()).map(f->f.build()).orElse(null);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.approver = ofNullable(builder.getApprover()).map(f->f.build()).orElse(null);
			this.approvingPartyReference = ofNullable(builder.getApprovingPartyReference()).map(f->f.build()).orElse(null);
			this.portfolioReferenceModel = ofNullable(builder.getPortfolioReferenceModel()).map(f->f.build()).orElse(null);
			this.compressionModel = ofNullable(builder.getCompressionModel()).map(f->f.build()).orElse(null);
			this.tradingAndPostTradeEventsModel = ofNullable(builder.getTradingAndPostTradeEventsModel()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.eventValuationModel = ofNullable(builder.getEventValuationModel()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		public RequestedAction getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		@RosettaAttribute("_type")
		public ApprovalType get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("approver")
		public PersonId getApprover() {
			return approver;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		public PartyReference getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public PortfolioReferenceModel getPortfolioReferenceModel() {
			return portfolioReferenceModel;
		}
		
		@Override
		@RosettaAttribute("compressionModel")
		public CompressionModel getCompressionModel() {
			return compressionModel;
		}
		
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel() {
			return tradingAndPostTradeEventsModel;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
		}
		
		@Override
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestConsent build() {
			return this;
		}
		
		@Override
		public RequestConsent.RequestConsentBuilder toBuilder() {
			RequestConsent.RequestConsentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestConsent.RequestConsentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRequestedAction()).ifPresent(builder::setRequestedAction);
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getApprover()).ifPresent(builder::setApprover);
			ofNullable(getApprovingPartyReference()).ifPresent(builder::setApprovingPartyReference);
			ofNullable(getPortfolioReferenceModel()).ifPresent(builder::setPortfolioReferenceModel);
			ofNullable(getCompressionModel()).ifPresent(builder::setCompressionModel);
			ofNullable(getTradingAndPostTradeEventsModel()).ifPresent(builder::setTradingAndPostTradeEventsModel);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getEventValuationModel()).ifPresent(builder::setEventValuationModel);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConsent _that = getType().cast(o);
		
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(portfolioReferenceModel, _that.getPortfolioReferenceModel())) return false;
			if (!Objects.equals(compressionModel, _that.getCompressionModel())) return false;
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceModel != null ? portfolioReferenceModel.hashCode() : 0);
			_result = 31 * _result + (compressionModel != null ? compressionModel.hashCode() : 0);
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConsent {" +
				"requestedAction=" + this.requestedAction + ", " +
				"_type=" + this._type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"portfolioReferenceModel=" + this.portfolioReferenceModel + ", " +
				"compressionModel=" + this.compressionModel + ", " +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestConsent  ***********************/
	class RequestConsentBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestConsent.RequestConsentBuilder {
	
		protected RequestedAction.RequestedActionBuilder requestedAction;
		protected ApprovalType.ApprovalTypeBuilder _type;
		protected PersonId.PersonIdBuilder approver;
		protected PartyReference.PartyReferenceBuilder approvingPartyReference;
		protected PortfolioReferenceModel.PortfolioReferenceModelBuilder portfolioReferenceModel;
		protected CompressionModel.CompressionModelBuilder compressionModel;
		protected TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder tradingAndPostTradeEventsModel;
		protected DeClear.DeClearBuilder deClear;
		protected EventValuationModel.EventValuationModelBuilder eventValuationModel;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestConsentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("requestedAction")
		public RequestedAction.RequestedActionBuilder getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		public RequestedAction.RequestedActionBuilder getOrCreateRequestedAction() {
			RequestedAction.RequestedActionBuilder result;
			if (requestedAction!=null) {
				result = requestedAction;
			}
			else {
				result = requestedAction = RequestedAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public ApprovalType.ApprovalTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public ApprovalType.ApprovalTypeBuilder getOrCreate_type() {
			ApprovalType.ApprovalTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = ApprovalType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approver")
		public PersonId.PersonIdBuilder getApprover() {
			return approver;
		}
		
		@Override
		public PersonId.PersonIdBuilder getOrCreateApprover() {
			PersonId.PersonIdBuilder result;
			if (approver!=null) {
				result = approver;
			}
			else {
				result = approver = PersonId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		public PartyReference.PartyReferenceBuilder getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (approvingPartyReference!=null) {
				result = approvingPartyReference;
			}
			else {
				result = approvingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder getPortfolioReferenceModel() {
			return portfolioReferenceModel;
		}
		
		@Override
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder getOrCreatePortfolioReferenceModel() {
			PortfolioReferenceModel.PortfolioReferenceModelBuilder result;
			if (portfolioReferenceModel!=null) {
				result = portfolioReferenceModel;
			}
			else {
				result = portfolioReferenceModel = PortfolioReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compressionModel")
		public CompressionModel.CompressionModelBuilder getCompressionModel() {
			return compressionModel;
		}
		
		@Override
		public CompressionModel.CompressionModelBuilder getOrCreateCompressionModel() {
			CompressionModel.CompressionModelBuilder result;
			if (compressionModel!=null) {
				result = compressionModel;
			}
			else {
				result = compressionModel = CompressionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel() {
			return tradingAndPostTradeEventsModel;
		}
		
		@Override
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel() {
			TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder result;
			if (tradingAndPostTradeEventsModel!=null) {
				result = tradingAndPostTradeEventsModel;
			}
			else {
				result = tradingAndPostTradeEventsModel = TradingAndPostTradeEventsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear.DeClearBuilder getDeClear() {
			return deClear;
		}
		
		@Override
		public DeClear.DeClearBuilder getOrCreateDeClear() {
			DeClear.DeClearBuilder result;
			if (deClear!=null) {
				result = deClear;
			}
			else {
				result = deClear = DeClear.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel.EventValuationModelBuilder getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		public EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel() {
			EventValuationModel.EventValuationModelBuilder result;
			if (eventValuationModel!=null) {
				result = eventValuationModel;
			}
			else {
				result = eventValuationModel = EventValuationModel.builder();
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
		public RequestConsent.RequestConsentBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestConsent.RequestConsentBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestConsent.RequestConsentBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestConsent.RequestConsentBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestConsent.RequestConsentBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestConsent.RequestConsentBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestConsent.RequestConsentBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("requestedAction")
		public RequestConsent.RequestConsentBuilder setRequestedAction(RequestedAction requestedAction) {
			this.requestedAction = requestedAction==null?null:requestedAction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public RequestConsent.RequestConsentBuilder set_type(ApprovalType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approver")
		public RequestConsent.RequestConsentBuilder setApprover(PersonId approver) {
			this.approver = approver==null?null:approver.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvingPartyReference")
		public RequestConsent.RequestConsentBuilder setApprovingPartyReference(PartyReference approvingPartyReference) {
			this.approvingPartyReference = approvingPartyReference==null?null:approvingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public RequestConsent.RequestConsentBuilder setPortfolioReferenceModel(PortfolioReferenceModel portfolioReferenceModel) {
			this.portfolioReferenceModel = portfolioReferenceModel==null?null:portfolioReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compressionModel")
		public RequestConsent.RequestConsentBuilder setCompressionModel(CompressionModel compressionModel) {
			this.compressionModel = compressionModel==null?null:compressionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public RequestConsent.RequestConsentBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			this.tradingAndPostTradeEventsModel = tradingAndPostTradeEventsModel==null?null:tradingAndPostTradeEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deClear")
		public RequestConsent.RequestConsentBuilder setDeClear(DeClear deClear) {
			this.deClear = deClear==null?null:deClear.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventValuationModel")
		public RequestConsent.RequestConsentBuilder setEventValuationModel(EventValuationModel eventValuationModel) {
			this.eventValuationModel = eventValuationModel==null?null:eventValuationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestConsent.RequestConsentBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestConsent build() {
			return new RequestConsent.RequestConsentImpl(this);
		}
		
		@Override
		public RequestConsent.RequestConsentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConsent.RequestConsentBuilder prune() {
			super.prune();
			if (requestedAction!=null && !requestedAction.prune().hasData()) requestedAction = null;
			if (_type!=null && !_type.prune().hasData()) _type = null;
			if (approver!=null && !approver.prune().hasData()) approver = null;
			if (approvingPartyReference!=null && !approvingPartyReference.prune().hasData()) approvingPartyReference = null;
			if (portfolioReferenceModel!=null && !portfolioReferenceModel.prune().hasData()) portfolioReferenceModel = null;
			if (compressionModel!=null && !compressionModel.prune().hasData()) compressionModel = null;
			if (tradingAndPostTradeEventsModel!=null && !tradingAndPostTradeEventsModel.prune().hasData()) tradingAndPostTradeEventsModel = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (eventValuationModel!=null && !eventValuationModel.prune().hasData()) eventValuationModel = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRequestedAction()!=null && getRequestedAction().hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			if (getApprover()!=null && getApprover().hasData()) return true;
			if (getApprovingPartyReference()!=null && getApprovingPartyReference().hasData()) return true;
			if (getPortfolioReferenceModel()!=null && getPortfolioReferenceModel().hasData()) return true;
			if (getCompressionModel()!=null && getCompressionModel().hasData()) return true;
			if (getTradingAndPostTradeEventsModel()!=null && getTradingAndPostTradeEventsModel().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getEventValuationModel()!=null && getEventValuationModel().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConsent.RequestConsentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestConsent.RequestConsentBuilder o = (RequestConsent.RequestConsentBuilder) other;
			
			merger.mergeRosetta(getRequestedAction(), o.getRequestedAction(), this::setRequestedAction);
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			merger.mergeRosetta(getApprover(), o.getApprover(), this::setApprover);
			merger.mergeRosetta(getApprovingPartyReference(), o.getApprovingPartyReference(), this::setApprovingPartyReference);
			merger.mergeRosetta(getPortfolioReferenceModel(), o.getPortfolioReferenceModel(), this::setPortfolioReferenceModel);
			merger.mergeRosetta(getCompressionModel(), o.getCompressionModel(), this::setCompressionModel);
			merger.mergeRosetta(getTradingAndPostTradeEventsModel(), o.getTradingAndPostTradeEventsModel(), this::setTradingAndPostTradeEventsModel);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getEventValuationModel(), o.getEventValuationModel(), this::setEventValuationModel);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConsent _that = getType().cast(o);
		
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(portfolioReferenceModel, _that.getPortfolioReferenceModel())) return false;
			if (!Objects.equals(compressionModel, _that.getCompressionModel())) return false;
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceModel != null ? portfolioReferenceModel.hashCode() : 0);
			_result = 31 * _result + (compressionModel != null ? compressionModel.hashCode() : 0);
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConsentBuilder {" +
				"requestedAction=" + this.requestedAction + ", " +
				"_type=" + this._type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"portfolioReferenceModel=" + this.portfolioReferenceModel + ", " +
				"compressionModel=" + this.compressionModel + ", " +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
