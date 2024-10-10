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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.RequestConsentRetracted;
import fpml.confirmation.RequestConsentRetracted.RequestConsentRetractedBuilder;
import fpml.confirmation.RequestConsentRetracted.RequestConsentRetractedBuilderImpl;
import fpml.confirmation.RequestConsentRetracted.RequestConsentRetractedImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestConsentRetractedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message withdrawing a request that the sender be authorized by the recipient to peform an action.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestConsentRetracted", builder=RequestConsentRetracted.RequestConsentRetractedBuilderImpl.class, version="${project.version}")
public interface RequestConsentRetracted extends NonCorrectableRequestMessage {

	RequestConsentRetractedMeta metaData = new RequestConsentRetractedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of approval (e.g. &quot;pre-clearing credit&quot;).
	 */
	ApprovalType getType_();
	/**
	 * The full name or identifiying ID of the relevant approver.
	 */
	PersonId getApprover();
	/**
	 * A pointer style reference to a party defined elsewhere in the document. The party referenced needs to approve the specified item (e.g. trade or allocation).
	 */
	PartyReference getApprovingPartyReference();
	TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel();
	/**
	 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 */
	DeClear getDeClear();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestConsentRetracted build();
	
	RequestConsentRetracted.RequestConsentRetractedBuilder toBuilder();
	
	static RequestConsentRetracted.RequestConsentRetractedBuilder builder() {
		return new RequestConsentRetracted.RequestConsentRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestConsentRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestConsentRetracted> getType() {
		return RequestConsentRetracted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("type"), processor, ApprovalType.class, getType_());
		processRosetta(path.newSubPath("approver"), processor, PersonId.class, getApprover());
		processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.class, getApprovingPartyReference());
		processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.class, getTradingAndPostTradeEventsModel());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestConsentRetractedBuilder extends RequestConsentRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		ApprovalType.ApprovalTypeBuilder getOrCreateType();
		ApprovalType.ApprovalTypeBuilder getType_();
		PersonId.PersonIdBuilder getOrCreateApprover();
		PersonId.PersonIdBuilder getApprover();
		PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference();
		PartyReference.PartyReferenceBuilder getApprovingPartyReference();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel();
		DeClear.DeClearBuilder getOrCreateDeClear();
		DeClear.DeClearBuilder getDeClear();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestConsentRetracted.RequestConsentRetractedBuilder setExpectedBuild(Integer expectedBuild);
		RequestConsentRetracted.RequestConsentRetractedBuilder setActualBuild(Integer actualBuild);
		RequestConsentRetracted.RequestConsentRetractedBuilder setHeader(RequestMessageHeader header);
		RequestConsentRetracted.RequestConsentRetractedBuilder setValidationModel(ValidationModel validationModel);
		RequestConsentRetracted.RequestConsentRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestConsentRetracted.RequestConsentRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestConsentRetracted.RequestConsentRetractedBuilder setType(ApprovalType type);
		RequestConsentRetracted.RequestConsentRetractedBuilder setApprover(PersonId approver);
		RequestConsentRetracted.RequestConsentRetractedBuilder setApprovingPartyReference(PartyReference approvingPartyReference);
		RequestConsentRetracted.RequestConsentRetractedBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel);
		RequestConsentRetracted.RequestConsentRetractedBuilder setDeClear(DeClear deClear);
		RequestConsentRetracted.RequestConsentRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("type"), processor, ApprovalType.ApprovalTypeBuilder.class, getType_());
			processRosetta(path.newSubPath("approver"), processor, PersonId.PersonIdBuilder.class, getApprover());
			processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovingPartyReference());
			processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder.class, getTradingAndPostTradeEventsModel());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestConsentRetracted.RequestConsentRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of RequestConsentRetracted  ***********************/
	class RequestConsentRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements RequestConsentRetracted {
		private final ApprovalType type;
		private final PersonId approver;
		private final PartyReference approvingPartyReference;
		private final TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel;
		private final DeClear deClear;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestConsentRetractedImpl(RequestConsentRetracted.RequestConsentRetractedBuilder builder) {
			super(builder);
			this.type = ofNullable(builder.getType_()).map(f->f.build()).orElse(null);
			this.approver = ofNullable(builder.getApprover()).map(f->f.build()).orElse(null);
			this.approvingPartyReference = ofNullable(builder.getApprovingPartyReference()).map(f->f.build()).orElse(null);
			this.tradingAndPostTradeEventsModel = ofNullable(builder.getTradingAndPostTradeEventsModel()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		public ApprovalType getType_() {
			return type;
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
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestConsentRetracted build() {
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder toBuilder() {
			RequestConsentRetracted.RequestConsentRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestConsentRetracted.RequestConsentRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getType_()).ifPresent(builder::setType);
			ofNullable(getApprover()).ifPresent(builder::setApprover);
			ofNullable(getApprovingPartyReference()).ifPresent(builder::setApprovingPartyReference);
			ofNullable(getTradingAndPostTradeEventsModel()).ifPresent(builder::setTradingAndPostTradeEventsModel);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConsentRetracted _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConsentRetracted {" +
				"type=" + this.type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestConsentRetracted  ***********************/
	class RequestConsentRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements RequestConsentRetracted.RequestConsentRetractedBuilder {
	
		protected ApprovalType.ApprovalTypeBuilder type;
		protected PersonId.PersonIdBuilder approver;
		protected PartyReference.PartyReferenceBuilder approvingPartyReference;
		protected TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder tradingAndPostTradeEventsModel;
		protected DeClear.DeClearBuilder deClear;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestConsentRetractedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public ApprovalType.ApprovalTypeBuilder getType_() {
			return type;
		}
		
		@Override
		public ApprovalType.ApprovalTypeBuilder getOrCreateType() {
			ApprovalType.ApprovalTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = ApprovalType.builder();
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("type")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setType(ApprovalType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approver")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setApprover(PersonId approver) {
			this.approver = approver==null?null:approver.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvingPartyReference")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setApprovingPartyReference(PartyReference approvingPartyReference) {
			this.approvingPartyReference = approvingPartyReference==null?null:approvingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			this.tradingAndPostTradeEventsModel = tradingAndPostTradeEventsModel==null?null:tradingAndPostTradeEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deClear")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setDeClear(DeClear deClear) {
			this.deClear = deClear==null?null:deClear.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestConsentRetracted.RequestConsentRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestConsentRetracted build() {
			return new RequestConsentRetracted.RequestConsentRetractedImpl(this);
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			if (approver!=null && !approver.prune().hasData()) approver = null;
			if (approvingPartyReference!=null && !approvingPartyReference.prune().hasData()) approvingPartyReference = null;
			if (tradingAndPostTradeEventsModel!=null && !tradingAndPostTradeEventsModel.prune().hasData()) tradingAndPostTradeEventsModel = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getType_()!=null && getType_().hasData()) return true;
			if (getApprover()!=null && getApprover().hasData()) return true;
			if (getApprovingPartyReference()!=null && getApprovingPartyReference().hasData()) return true;
			if (getTradingAndPostTradeEventsModel()!=null && getTradingAndPostTradeEventsModel().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestConsentRetracted.RequestConsentRetractedBuilder o = (RequestConsentRetracted.RequestConsentRetractedBuilder) other;
			
			merger.mergeRosetta(getType_(), o.getType_(), this::setType);
			merger.mergeRosetta(getApprover(), o.getApprover(), this::setApprover);
			merger.mergeRosetta(getApprovingPartyReference(), o.getApprovingPartyReference(), this::setApprovingPartyReference);
			merger.mergeRosetta(getTradingAndPostTradeEventsModel(), o.getTradingAndPostTradeEventsModel(), this::setTradingAndPostTradeEventsModel);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConsentRetracted _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConsentRetractedBuilder {" +
				"type=" + this.type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
