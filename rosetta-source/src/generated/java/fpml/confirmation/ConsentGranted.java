package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.ApprovalId;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.ConsentGranted;
import fpml.confirmation.ConsentGranted.ConsentGrantedBuilder;
import fpml.confirmation.ConsentGranted.ConsentGrantedBuilderImpl;
import fpml.confirmation.ConsentGranted.ConsentGrantedImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.CreditLimitInformation;
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.PortfolioReferenceBaseModel;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ConsentGrantedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message indicating that the sender grants consent for the recipient to perform the requested action.
 * @version ${project.version}
 */
@RosettaDataType(value="ConsentGranted", builder=ConsentGranted.ConsentGrantedBuilderImpl.class, version="${project.version}")
public interface ConsentGranted extends ResponseMessage {

	ConsentGrantedMeta metaData = new ConsentGrantedMeta();

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
	/**
	 * An identifer for a specific appoval, to allow the approval to be identified and tracked.
	 */
	ApprovalId getApprovalId();
	PortfolioReferenceBaseModel getPortfolioReferenceBaseModel();
	EventsOrInfoModel getEventsOrInfoModel();
	List<? extends CreditLimitInformation> getCreditLimitInformation();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ConsentGranted build();
	
	ConsentGranted.ConsentGrantedBuilder toBuilder();
	
	static ConsentGranted.ConsentGrantedBuilder builder() {
		return new ConsentGranted.ConsentGrantedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConsentGranted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConsentGranted> getType() {
		return ConsentGranted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("type"), processor, ApprovalType.class, getType_());
		processRosetta(path.newSubPath("approver"), processor, PersonId.class, getApprover());
		processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.class, getApprovingPartyReference());
		processRosetta(path.newSubPath("approvalId"), processor, ApprovalId.class, getApprovalId());
		processRosetta(path.newSubPath("portfolioReferenceBaseModel"), processor, PortfolioReferenceBaseModel.class, getPortfolioReferenceBaseModel());
		processRosetta(path.newSubPath("eventsOrInfoModel"), processor, EventsOrInfoModel.class, getEventsOrInfoModel());
		processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.class, getCreditLimitInformation());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConsentGrantedBuilder extends ConsentGranted, ResponseMessage.ResponseMessageBuilder {
		ApprovalType.ApprovalTypeBuilder getOrCreateType();
		ApprovalType.ApprovalTypeBuilder getType_();
		PersonId.PersonIdBuilder getOrCreateApprover();
		PersonId.PersonIdBuilder getApprover();
		PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference();
		PartyReference.PartyReferenceBuilder getApprovingPartyReference();
		ApprovalId.ApprovalIdBuilder getOrCreateApprovalId();
		ApprovalId.ApprovalIdBuilder getApprovalId();
		PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder getOrCreatePortfolioReferenceBaseModel();
		PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder getPortfolioReferenceBaseModel();
		EventsOrInfoModel.EventsOrInfoModelBuilder getOrCreateEventsOrInfoModel();
		EventsOrInfoModel.EventsOrInfoModelBuilder getEventsOrInfoModel();
		CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation(int _index);
		List<? extends CreditLimitInformation.CreditLimitInformationBuilder> getCreditLimitInformation();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ConsentGranted.ConsentGrantedBuilder setExpectedBuild(Integer expectedBuild);
		ConsentGranted.ConsentGrantedBuilder setActualBuild(Integer actualBuild);
		ConsentGranted.ConsentGrantedBuilder setHeader(ResponseMessageHeader header);
		ConsentGranted.ConsentGrantedBuilder setValidationModel(ValidationModel validationModel);
		ConsentGranted.ConsentGrantedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ConsentGranted.ConsentGrantedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ConsentGranted.ConsentGrantedBuilder setType(ApprovalType type);
		ConsentGranted.ConsentGrantedBuilder setApprover(PersonId approver);
		ConsentGranted.ConsentGrantedBuilder setApprovingPartyReference(PartyReference approvingPartyReference);
		ConsentGranted.ConsentGrantedBuilder setApprovalId(ApprovalId approvalId);
		ConsentGranted.ConsentGrantedBuilder setPortfolioReferenceBaseModel(PortfolioReferenceBaseModel portfolioReferenceBaseModel);
		ConsentGranted.ConsentGrantedBuilder setEventsOrInfoModel(EventsOrInfoModel eventsOrInfoModel);
		ConsentGranted.ConsentGrantedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation0);
		ConsentGranted.ConsentGrantedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation1, int _idx);
		ConsentGranted.ConsentGrantedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation2);
		ConsentGranted.ConsentGrantedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation3);
		ConsentGranted.ConsentGrantedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("type"), processor, ApprovalType.ApprovalTypeBuilder.class, getType_());
			processRosetta(path.newSubPath("approver"), processor, PersonId.PersonIdBuilder.class, getApprover());
			processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovingPartyReference());
			processRosetta(path.newSubPath("approvalId"), processor, ApprovalId.ApprovalIdBuilder.class, getApprovalId());
			processRosetta(path.newSubPath("portfolioReferenceBaseModel"), processor, PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder.class, getPortfolioReferenceBaseModel());
			processRosetta(path.newSubPath("eventsOrInfoModel"), processor, EventsOrInfoModel.EventsOrInfoModelBuilder.class, getEventsOrInfoModel());
			processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.CreditLimitInformationBuilder.class, getCreditLimitInformation());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ConsentGranted.ConsentGrantedBuilder prune();
	}

	/*********************** Immutable Implementation of ConsentGranted  ***********************/
	class ConsentGrantedImpl extends ResponseMessage.ResponseMessageImpl implements ConsentGranted {
		private final ApprovalType type;
		private final PersonId approver;
		private final PartyReference approvingPartyReference;
		private final ApprovalId approvalId;
		private final PortfolioReferenceBaseModel portfolioReferenceBaseModel;
		private final EventsOrInfoModel eventsOrInfoModel;
		private final List<? extends CreditLimitInformation> creditLimitInformation;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ConsentGrantedImpl(ConsentGranted.ConsentGrantedBuilder builder) {
			super(builder);
			this.type = ofNullable(builder.getType_()).map(f->f.build()).orElse(null);
			this.approver = ofNullable(builder.getApprover()).map(f->f.build()).orElse(null);
			this.approvingPartyReference = ofNullable(builder.getApprovingPartyReference()).map(f->f.build()).orElse(null);
			this.approvalId = ofNullable(builder.getApprovalId()).map(f->f.build()).orElse(null);
			this.portfolioReferenceBaseModel = ofNullable(builder.getPortfolioReferenceBaseModel()).map(f->f.build()).orElse(null);
			this.eventsOrInfoModel = ofNullable(builder.getEventsOrInfoModel()).map(f->f.build()).orElse(null);
			this.creditLimitInformation = ofNullable(builder.getCreditLimitInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("approvalId")
		public ApprovalId getApprovalId() {
			return approvalId;
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceBaseModel")
		public PortfolioReferenceBaseModel getPortfolioReferenceBaseModel() {
			return portfolioReferenceBaseModel;
		}
		
		@Override
		@RosettaAttribute("eventsOrInfoModel")
		public EventsOrInfoModel getEventsOrInfoModel() {
			return eventsOrInfoModel;
		}
		
		@Override
		@RosettaAttribute("creditLimitInformation")
		public List<? extends CreditLimitInformation> getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ConsentGranted build() {
			return this;
		}
		
		@Override
		public ConsentGranted.ConsentGrantedBuilder toBuilder() {
			ConsentGranted.ConsentGrantedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConsentGranted.ConsentGrantedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getType_()).ifPresent(builder::setType);
			ofNullable(getApprover()).ifPresent(builder::setApprover);
			ofNullable(getApprovingPartyReference()).ifPresent(builder::setApprovingPartyReference);
			ofNullable(getApprovalId()).ifPresent(builder::setApprovalId);
			ofNullable(getPortfolioReferenceBaseModel()).ifPresent(builder::setPortfolioReferenceBaseModel);
			ofNullable(getEventsOrInfoModel()).ifPresent(builder::setEventsOrInfoModel);
			ofNullable(getCreditLimitInformation()).ifPresent(builder::setCreditLimitInformation);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConsentGranted _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(approvalId, _that.getApprovalId())) return false;
			if (!Objects.equals(portfolioReferenceBaseModel, _that.getPortfolioReferenceBaseModel())) return false;
			if (!Objects.equals(eventsOrInfoModel, _that.getEventsOrInfoModel())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvalId != null ? approvalId.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceBaseModel != null ? portfolioReferenceBaseModel.hashCode() : 0);
			_result = 31 * _result + (eventsOrInfoModel != null ? eventsOrInfoModel.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConsentGranted {" +
				"type=" + this.type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"approvalId=" + this.approvalId + ", " +
				"portfolioReferenceBaseModel=" + this.portfolioReferenceBaseModel + ", " +
				"eventsOrInfoModel=" + this.eventsOrInfoModel + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConsentGranted  ***********************/
	class ConsentGrantedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements ConsentGranted.ConsentGrantedBuilder {
	
		protected ApprovalType.ApprovalTypeBuilder type;
		protected PersonId.PersonIdBuilder approver;
		protected PartyReference.PartyReferenceBuilder approvingPartyReference;
		protected ApprovalId.ApprovalIdBuilder approvalId;
		protected PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder portfolioReferenceBaseModel;
		protected EventsOrInfoModel.EventsOrInfoModelBuilder eventsOrInfoModel;
		protected List<CreditLimitInformation.CreditLimitInformationBuilder> creditLimitInformation = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ConsentGrantedBuilderImpl() {
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
		@RosettaAttribute("approvalId")
		public ApprovalId.ApprovalIdBuilder getApprovalId() {
			return approvalId;
		}
		
		@Override
		public ApprovalId.ApprovalIdBuilder getOrCreateApprovalId() {
			ApprovalId.ApprovalIdBuilder result;
			if (approvalId!=null) {
				result = approvalId;
			}
			else {
				result = approvalId = ApprovalId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceBaseModel")
		public PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder getPortfolioReferenceBaseModel() {
			return portfolioReferenceBaseModel;
		}
		
		@Override
		public PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder getOrCreatePortfolioReferenceBaseModel() {
			PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder result;
			if (portfolioReferenceBaseModel!=null) {
				result = portfolioReferenceBaseModel;
			}
			else {
				result = portfolioReferenceBaseModel = PortfolioReferenceBaseModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventsOrInfoModel")
		public EventsOrInfoModel.EventsOrInfoModelBuilder getEventsOrInfoModel() {
			return eventsOrInfoModel;
		}
		
		@Override
		public EventsOrInfoModel.EventsOrInfoModelBuilder getOrCreateEventsOrInfoModel() {
			EventsOrInfoModel.EventsOrInfoModelBuilder result;
			if (eventsOrInfoModel!=null) {
				result = eventsOrInfoModel;
			}
			else {
				result = eventsOrInfoModel = EventsOrInfoModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditLimitInformation")
		public List<? extends CreditLimitInformation.CreditLimitInformationBuilder> getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		public CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation(int _index) {
		
			if (creditLimitInformation==null) {
				this.creditLimitInformation = new ArrayList<>();
			}
			CreditLimitInformation.CreditLimitInformationBuilder result;
			return getIndex(creditLimitInformation, _index, () -> {
						CreditLimitInformation.CreditLimitInformationBuilder newCreditLimitInformation = CreditLimitInformation.builder();
						return newCreditLimitInformation;
					});
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
		public ConsentGranted.ConsentGrantedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ConsentGranted.ConsentGrantedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ConsentGranted.ConsentGrantedBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ConsentGranted.ConsentGrantedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ConsentGranted.ConsentGrantedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ConsentGranted.ConsentGrantedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("type")
		public ConsentGranted.ConsentGrantedBuilder setType(ApprovalType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approver")
		public ConsentGranted.ConsentGrantedBuilder setApprover(PersonId approver) {
			this.approver = approver==null?null:approver.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvingPartyReference")
		public ConsentGranted.ConsentGrantedBuilder setApprovingPartyReference(PartyReference approvingPartyReference) {
			this.approvingPartyReference = approvingPartyReference==null?null:approvingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvalId")
		public ConsentGranted.ConsentGrantedBuilder setApprovalId(ApprovalId approvalId) {
			this.approvalId = approvalId==null?null:approvalId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("portfolioReferenceBaseModel")
		public ConsentGranted.ConsentGrantedBuilder setPortfolioReferenceBaseModel(PortfolioReferenceBaseModel portfolioReferenceBaseModel) {
			this.portfolioReferenceBaseModel = portfolioReferenceBaseModel==null?null:portfolioReferenceBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventsOrInfoModel")
		public ConsentGranted.ConsentGrantedBuilder setEventsOrInfoModel(EventsOrInfoModel eventsOrInfoModel) {
			this.eventsOrInfoModel = eventsOrInfoModel==null?null:eventsOrInfoModel.toBuilder();
			return this;
		}
		@Override
		public ConsentGranted.ConsentGrantedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation) {
			if (creditLimitInformation!=null) this.creditLimitInformation.add(creditLimitInformation.toBuilder());
			return this;
		}
		
		@Override
		public ConsentGranted.ConsentGrantedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation, int _idx) {
			getIndex(this.creditLimitInformation, _idx, () -> creditLimitInformation.toBuilder());
			return this;
		}
		@Override 
		public ConsentGranted.ConsentGrantedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
			if (creditLimitInformations != null) {
				for (CreditLimitInformation toAdd : creditLimitInformations) {
					this.creditLimitInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("creditLimitInformation")
		public ConsentGranted.ConsentGrantedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
			if (creditLimitInformations == null)  {
				this.creditLimitInformation = new ArrayList<>();
			}
			else {
				this.creditLimitInformation = creditLimitInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ConsentGranted.ConsentGrantedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ConsentGranted build() {
			return new ConsentGranted.ConsentGrantedImpl(this);
		}
		
		@Override
		public ConsentGranted.ConsentGrantedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConsentGranted.ConsentGrantedBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			if (approver!=null && !approver.prune().hasData()) approver = null;
			if (approvingPartyReference!=null && !approvingPartyReference.prune().hasData()) approvingPartyReference = null;
			if (approvalId!=null && !approvalId.prune().hasData()) approvalId = null;
			if (portfolioReferenceBaseModel!=null && !portfolioReferenceBaseModel.prune().hasData()) portfolioReferenceBaseModel = null;
			if (eventsOrInfoModel!=null && !eventsOrInfoModel.prune().hasData()) eventsOrInfoModel = null;
			creditLimitInformation = creditLimitInformation.stream().filter(b->b!=null).<CreditLimitInformation.CreditLimitInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getType_()!=null && getType_().hasData()) return true;
			if (getApprover()!=null && getApprover().hasData()) return true;
			if (getApprovingPartyReference()!=null && getApprovingPartyReference().hasData()) return true;
			if (getApprovalId()!=null && getApprovalId().hasData()) return true;
			if (getPortfolioReferenceBaseModel()!=null && getPortfolioReferenceBaseModel().hasData()) return true;
			if (getEventsOrInfoModel()!=null && getEventsOrInfoModel().hasData()) return true;
			if (getCreditLimitInformation()!=null && getCreditLimitInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConsentGranted.ConsentGrantedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConsentGranted.ConsentGrantedBuilder o = (ConsentGranted.ConsentGrantedBuilder) other;
			
			merger.mergeRosetta(getType_(), o.getType_(), this::setType);
			merger.mergeRosetta(getApprover(), o.getApprover(), this::setApprover);
			merger.mergeRosetta(getApprovingPartyReference(), o.getApprovingPartyReference(), this::setApprovingPartyReference);
			merger.mergeRosetta(getApprovalId(), o.getApprovalId(), this::setApprovalId);
			merger.mergeRosetta(getPortfolioReferenceBaseModel(), o.getPortfolioReferenceBaseModel(), this::setPortfolioReferenceBaseModel);
			merger.mergeRosetta(getEventsOrInfoModel(), o.getEventsOrInfoModel(), this::setEventsOrInfoModel);
			merger.mergeRosetta(getCreditLimitInformation(), o.getCreditLimitInformation(), this::getOrCreateCreditLimitInformation);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConsentGranted _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(approvalId, _that.getApprovalId())) return false;
			if (!Objects.equals(portfolioReferenceBaseModel, _that.getPortfolioReferenceBaseModel())) return false;
			if (!Objects.equals(eventsOrInfoModel, _that.getEventsOrInfoModel())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvalId != null ? approvalId.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceBaseModel != null ? portfolioReferenceBaseModel.hashCode() : 0);
			_result = 31 * _result + (eventsOrInfoModel != null ? eventsOrInfoModel.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConsentGrantedBuilder {" +
				"type=" + this.type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"approvalId=" + this.approvalId + ", " +
				"portfolioReferenceBaseModel=" + this.portfolioReferenceBaseModel + ", " +
				"eventsOrInfoModel=" + this.eventsOrInfoModel + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
