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
import fpml.confirmation.ApprovalType;
import fpml.confirmation.ConsentRefused;
import fpml.confirmation.ConsentRefused.ConsentRefusedBuilder;
import fpml.confirmation.ConsentRefused.ConsentRefusedBuilderImpl;
import fpml.confirmation.ConsentRefused.ConsentRefusedImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.CreditLimitInformation;
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.PortfolioReferenceBaseModel;
import fpml.confirmation.Reason;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ConsentRefusedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message indicating that the sender does not grant consent for the recipient to perform the requested action.
 * @version ${project.version}
 */
@RosettaDataType(value="ConsentRefused", builder=ConsentRefused.ConsentRefusedBuilderImpl.class, version="${project.version}")
public interface ConsentRefused extends ResponseMessage {

	ConsentRefusedMeta metaData = new ConsentRefusedMeta();

	/*********************** Getter Methods  ***********************/
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
	PortfolioReferenceBaseModel getPortfolioReferenceBaseModel();
	EventsOrInfoModel getEventsOrInfoModel();
	List<? extends CreditLimitInformation> getCreditLimitInformation();
	PartiesAndAccountsModel getPartiesAndAccountsModel();
	List<? extends Reason> getReason();

	/*********************** Build Methods  ***********************/
	ConsentRefused build();
	
	ConsentRefused.ConsentRefusedBuilder toBuilder();
	
	static ConsentRefused.ConsentRefusedBuilder builder() {
		return new ConsentRefused.ConsentRefusedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConsentRefused> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConsentRefused> getType() {
		return ConsentRefused.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("_type"), processor, ApprovalType.class, get_type());
		processRosetta(path.newSubPath("approver"), processor, PersonId.class, getApprover());
		processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.class, getApprovingPartyReference());
		processRosetta(path.newSubPath("portfolioReferenceBaseModel"), processor, PortfolioReferenceBaseModel.class, getPortfolioReferenceBaseModel());
		processRosetta(path.newSubPath("eventsOrInfoModel"), processor, EventsOrInfoModel.class, getEventsOrInfoModel());
		processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.class, getCreditLimitInformation());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConsentRefusedBuilder extends ConsentRefused, ResponseMessage.ResponseMessageBuilder {
		ApprovalType.ApprovalTypeBuilder getOrCreate_type();
		ApprovalType.ApprovalTypeBuilder get_type();
		PersonId.PersonIdBuilder getOrCreateApprover();
		PersonId.PersonIdBuilder getApprover();
		PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference();
		PartyReference.PartyReferenceBuilder getApprovingPartyReference();
		PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder getOrCreatePortfolioReferenceBaseModel();
		PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder getPortfolioReferenceBaseModel();
		EventsOrInfoModel.EventsOrInfoModelBuilder getOrCreateEventsOrInfoModel();
		EventsOrInfoModel.EventsOrInfoModelBuilder getEventsOrInfoModel();
		CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation(int _index);
		List<? extends CreditLimitInformation.CreditLimitInformationBuilder> getCreditLimitInformation();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		Reason.ReasonBuilder getOrCreateReason(int _index);
		List<? extends Reason.ReasonBuilder> getReason();
		ConsentRefused.ConsentRefusedBuilder setExpectedBuild(Integer expectedBuild);
		ConsentRefused.ConsentRefusedBuilder setActualBuild(Integer actualBuild);
		ConsentRefused.ConsentRefusedBuilder setHeader(ResponseMessageHeader header);
		ConsentRefused.ConsentRefusedBuilder setValidationModel(ValidationModel validationModel);
		ConsentRefused.ConsentRefusedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ConsentRefused.ConsentRefusedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ConsentRefused.ConsentRefusedBuilder set_type(ApprovalType _type);
		ConsentRefused.ConsentRefusedBuilder setApprover(PersonId approver);
		ConsentRefused.ConsentRefusedBuilder setApprovingPartyReference(PartyReference approvingPartyReference);
		ConsentRefused.ConsentRefusedBuilder setPortfolioReferenceBaseModel(PortfolioReferenceBaseModel portfolioReferenceBaseModel);
		ConsentRefused.ConsentRefusedBuilder setEventsOrInfoModel(EventsOrInfoModel eventsOrInfoModel);
		ConsentRefused.ConsentRefusedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation0);
		ConsentRefused.ConsentRefusedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation1, int _idx);
		ConsentRefused.ConsentRefusedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation2);
		ConsentRefused.ConsentRefusedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation3);
		ConsentRefused.ConsentRefusedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);
		ConsentRefused.ConsentRefusedBuilder addReason(Reason reason0);
		ConsentRefused.ConsentRefusedBuilder addReason(Reason reason1, int _idx);
		ConsentRefused.ConsentRefusedBuilder addReason(List<? extends Reason> reason2);
		ConsentRefused.ConsentRefusedBuilder setReason(List<? extends Reason> reason3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("_type"), processor, ApprovalType.ApprovalTypeBuilder.class, get_type());
			processRosetta(path.newSubPath("approver"), processor, PersonId.PersonIdBuilder.class, getApprover());
			processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovingPartyReference());
			processRosetta(path.newSubPath("portfolioReferenceBaseModel"), processor, PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder.class, getPortfolioReferenceBaseModel());
			processRosetta(path.newSubPath("eventsOrInfoModel"), processor, EventsOrInfoModel.EventsOrInfoModelBuilder.class, getEventsOrInfoModel());
			processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.CreditLimitInformationBuilder.class, getCreditLimitInformation());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
		}
		

		ConsentRefused.ConsentRefusedBuilder prune();
	}

	/*********************** Immutable Implementation of ConsentRefused  ***********************/
	class ConsentRefusedImpl extends ResponseMessage.ResponseMessageImpl implements ConsentRefused {
		private final ApprovalType _type;
		private final PersonId approver;
		private final PartyReference approvingPartyReference;
		private final PortfolioReferenceBaseModel portfolioReferenceBaseModel;
		private final EventsOrInfoModel eventsOrInfoModel;
		private final List<? extends CreditLimitInformation> creditLimitInformation;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		private final List<? extends Reason> reason;
		
		protected ConsentRefusedImpl(ConsentRefused.ConsentRefusedBuilder builder) {
			super(builder);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.approver = ofNullable(builder.getApprover()).map(f->f.build()).orElse(null);
			this.approvingPartyReference = ofNullable(builder.getApprovingPartyReference()).map(f->f.build()).orElse(null);
			this.portfolioReferenceBaseModel = ofNullable(builder.getPortfolioReferenceBaseModel()).map(f->f.build()).orElse(null);
			this.eventsOrInfoModel = ofNullable(builder.getEventsOrInfoModel()).map(f->f.build()).orElse(null);
			this.creditLimitInformation = ofNullable(builder.getCreditLimitInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		public ConsentRefused build() {
			return this;
		}
		
		@Override
		public ConsentRefused.ConsentRefusedBuilder toBuilder() {
			ConsentRefused.ConsentRefusedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConsentRefused.ConsentRefusedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getApprover()).ifPresent(builder::setApprover);
			ofNullable(getApprovingPartyReference()).ifPresent(builder::setApprovingPartyReference);
			ofNullable(getPortfolioReferenceBaseModel()).ifPresent(builder::setPortfolioReferenceBaseModel);
			ofNullable(getEventsOrInfoModel()).ifPresent(builder::setEventsOrInfoModel);
			ofNullable(getCreditLimitInformation()).ifPresent(builder::setCreditLimitInformation);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConsentRefused _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(portfolioReferenceBaseModel, _that.getPortfolioReferenceBaseModel())) return false;
			if (!Objects.equals(eventsOrInfoModel, _that.getEventsOrInfoModel())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceBaseModel != null ? portfolioReferenceBaseModel.hashCode() : 0);
			_result = 31 * _result + (eventsOrInfoModel != null ? eventsOrInfoModel.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConsentRefused {" +
				"_type=" + this._type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"portfolioReferenceBaseModel=" + this.portfolioReferenceBaseModel + ", " +
				"eventsOrInfoModel=" + this.eventsOrInfoModel + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConsentRefused  ***********************/
	class ConsentRefusedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements ConsentRefused.ConsentRefusedBuilder {
	
		protected ApprovalType.ApprovalTypeBuilder _type;
		protected PersonId.PersonIdBuilder approver;
		protected PartyReference.PartyReferenceBuilder approvingPartyReference;
		protected PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder portfolioReferenceBaseModel;
		protected EventsOrInfoModel.EventsOrInfoModelBuilder eventsOrInfoModel;
		protected List<CreditLimitInformation.CreditLimitInformationBuilder> creditLimitInformation = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
	
		public ConsentRefusedBuilderImpl() {
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
		
		@Override
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
		@RosettaAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int _index) {
		
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			Reason.ReasonBuilder result;
			return getIndex(reason, _index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public ConsentRefused.ConsentRefusedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ConsentRefused.ConsentRefusedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ConsentRefused.ConsentRefusedBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ConsentRefused.ConsentRefusedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ConsentRefused.ConsentRefusedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ConsentRefused.ConsentRefusedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public ConsentRefused.ConsentRefusedBuilder set_type(ApprovalType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approver")
		public ConsentRefused.ConsentRefusedBuilder setApprover(PersonId approver) {
			this.approver = approver==null?null:approver.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvingPartyReference")
		public ConsentRefused.ConsentRefusedBuilder setApprovingPartyReference(PartyReference approvingPartyReference) {
			this.approvingPartyReference = approvingPartyReference==null?null:approvingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("portfolioReferenceBaseModel")
		public ConsentRefused.ConsentRefusedBuilder setPortfolioReferenceBaseModel(PortfolioReferenceBaseModel portfolioReferenceBaseModel) {
			this.portfolioReferenceBaseModel = portfolioReferenceBaseModel==null?null:portfolioReferenceBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventsOrInfoModel")
		public ConsentRefused.ConsentRefusedBuilder setEventsOrInfoModel(EventsOrInfoModel eventsOrInfoModel) {
			this.eventsOrInfoModel = eventsOrInfoModel==null?null:eventsOrInfoModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditLimitInformation")
		public ConsentRefused.ConsentRefusedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation) {
			if (creditLimitInformation!=null) this.creditLimitInformation.add(creditLimitInformation.toBuilder());
			return this;
		}
		
		@Override
		public ConsentRefused.ConsentRefusedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation, int _idx) {
			getIndex(this.creditLimitInformation, _idx, () -> creditLimitInformation.toBuilder());
			return this;
		}
		@Override 
		public ConsentRefused.ConsentRefusedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
			if (creditLimitInformations != null) {
				for (CreditLimitInformation toAdd : creditLimitInformations) {
					this.creditLimitInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ConsentRefused.ConsentRefusedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
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
		public ConsentRefused.ConsentRefusedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("reason")
		public ConsentRefused.ConsentRefusedBuilder addReason(Reason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public ConsentRefused.ConsentRefusedBuilder addReason(Reason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public ConsentRefused.ConsentRefusedBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ConsentRefused.ConsentRefusedBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null)  {
				this.reason = new ArrayList<>();
			}
			else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ConsentRefused build() {
			return new ConsentRefused.ConsentRefusedImpl(this);
		}
		
		@Override
		public ConsentRefused.ConsentRefusedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConsentRefused.ConsentRefusedBuilder prune() {
			super.prune();
			if (_type!=null && !_type.prune().hasData()) _type = null;
			if (approver!=null && !approver.prune().hasData()) approver = null;
			if (approvingPartyReference!=null && !approvingPartyReference.prune().hasData()) approvingPartyReference = null;
			if (portfolioReferenceBaseModel!=null && !portfolioReferenceBaseModel.prune().hasData()) portfolioReferenceBaseModel = null;
			if (eventsOrInfoModel!=null && !eventsOrInfoModel.prune().hasData()) eventsOrInfoModel = null;
			creditLimitInformation = creditLimitInformation.stream().filter(b->b!=null).<CreditLimitInformation.CreditLimitInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			if (getApprover()!=null && getApprover().hasData()) return true;
			if (getApprovingPartyReference()!=null && getApprovingPartyReference().hasData()) return true;
			if (getPortfolioReferenceBaseModel()!=null && getPortfolioReferenceBaseModel().hasData()) return true;
			if (getEventsOrInfoModel()!=null && getEventsOrInfoModel().hasData()) return true;
			if (getCreditLimitInformation()!=null && getCreditLimitInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConsentRefused.ConsentRefusedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConsentRefused.ConsentRefusedBuilder o = (ConsentRefused.ConsentRefusedBuilder) other;
			
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			merger.mergeRosetta(getApprover(), o.getApprover(), this::setApprover);
			merger.mergeRosetta(getApprovingPartyReference(), o.getApprovingPartyReference(), this::setApprovingPartyReference);
			merger.mergeRosetta(getPortfolioReferenceBaseModel(), o.getPortfolioReferenceBaseModel(), this::setPortfolioReferenceBaseModel);
			merger.mergeRosetta(getEventsOrInfoModel(), o.getEventsOrInfoModel(), this::setEventsOrInfoModel);
			merger.mergeRosetta(getCreditLimitInformation(), o.getCreditLimitInformation(), this::getOrCreateCreditLimitInformation);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConsentRefused _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(portfolioReferenceBaseModel, _that.getPortfolioReferenceBaseModel())) return false;
			if (!Objects.equals(eventsOrInfoModel, _that.getEventsOrInfoModel())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceBaseModel != null ? portfolioReferenceBaseModel.hashCode() : 0);
			_result = 31 * _result + (eventsOrInfoModel != null ? eventsOrInfoModel.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConsentRefusedBuilder {" +
				"_type=" + this._type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"portfolioReferenceBaseModel=" + this.portfolioReferenceBaseModel + ", " +
				"eventsOrInfoModel=" + this.eventsOrInfoModel + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}
}
