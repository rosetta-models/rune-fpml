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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanAllocationSettlementEvent;
import fpml.confirmation.LoanAllocationSettlementNotification;
import fpml.confirmation.LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder;
import fpml.confirmation.LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilderImpl;
import fpml.confirmation.LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationImpl;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAllocationSettlementNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate trade settlement details (including funding economics), from counterparty to counterparty.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanAllocationSettlementNotification", builder=LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanAllocationSettlementNotification extends AbstractLoanAllocationPaymentNotification {

	LoanAllocationSettlementNotificationMeta metaData = new LoanAllocationSettlementNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to detail the settlement of an allocation.
	 */
	List<? extends LoanAllocationSettlementEvent> getSettlement();
	List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel();
	List<? extends FacilityLoanContractDetailsModel> getFacilityLoanContractDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementNotification build();
	
	LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder toBuilder();
	
	static LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder builder() {
		return new LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationSettlementNotification> getType() {
		return LoanAllocationSettlementNotification.class;
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
		processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.class, getRole());
		processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.class, getPayment());
		processRosetta(path.newSubPath("settlement"), processor, LoanAllocationSettlementEvent.class, getSettlement());
		processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.class, getLoanTradeAllocationDetailsModel());
		processRosetta(path.newSubPath("facilityLoanContractDetailsModel"), processor, FacilityLoanContractDetailsModel.class, getFacilityLoanContractDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementNotificationBuilder extends LoanAllocationSettlementNotification, AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder {
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder getOrCreateSettlement(int _index);
		List<? extends LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder> getSettlement();
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder getOrCreateLoanTradeAllocationDetailsModel(int _index);
		List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel();
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder getOrCreateFacilityLoanContractDetailsModel(int _index);
		List<? extends FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder> getFacilityLoanContractDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setActualBuild(Integer actualBuild);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setHeader(RequestMessageHeader header);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setNoticeDate(Date noticeDate);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addPayment(LoanAllocationPayment payment0);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addPayment(LoanAllocationPayment payment1, int _idx);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payment2);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payment3);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addSettlement(LoanAllocationSettlementEvent settlement0);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addSettlement(LoanAllocationSettlementEvent settlement1, int _idx);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addSettlement(List<? extends LoanAllocationSettlementEvent> settlement2);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setSettlement(List<? extends LoanAllocationSettlementEvent> settlement3);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel0);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel1, int _idx);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel2);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel3);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel0);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel1, int _idx);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModel2);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModel3);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addParty(Party party0);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addParty(Party party1, int _idx);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addParty(List<? extends Party> party2);
		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.LoanTradingPartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.LoanAllocationPaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("settlement"), processor, LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder.class, getSettlement());
			processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder.class, getLoanTradeAllocationDetailsModel());
			processRosetta(path.newSubPath("facilityLoanContractDetailsModel"), processor, FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder.class, getFacilityLoanContractDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementNotification  ***********************/
	class LoanAllocationSettlementNotificationImpl extends AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationImpl implements LoanAllocationSettlementNotification {
		private final List<? extends LoanAllocationSettlementEvent> settlement;
		private final List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel;
		private final List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanAllocationSettlementNotificationImpl(LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder builder) {
			super(builder);
			this.settlement = ofNullable(builder.getSettlement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanTradeAllocationDetailsModel = ofNullable(builder.getLoanTradeAllocationDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityLoanContractDetailsModel = ofNullable(builder.getFacilityLoanContractDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlement")
		public List<? extends LoanAllocationSettlementEvent> getSettlement() {
			return settlement;
		}
		
		@Override
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel() {
			return loanTradeAllocationDetailsModel;
		}
		
		@Override
		@RosettaAttribute("facilityLoanContractDetailsModel")
		public List<? extends FacilityLoanContractDetailsModel> getFacilityLoanContractDetailsModel() {
			return facilityLoanContractDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanAllocationSettlementNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder toBuilder() {
			LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlement()).ifPresent(builder::setSettlement);
			ofNullable(getLoanTradeAllocationDetailsModel()).ifPresent(builder::setLoanTradeAllocationDetailsModel);
			ofNullable(getFacilityLoanContractDetailsModel()).ifPresent(builder::setFacilityLoanContractDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlement, _that.getSettlement())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityLoanContractDetailsModel, _that.getFacilityLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlement != null ? settlement.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityLoanContractDetailsModel != null ? facilityLoanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementNotification {" +
				"settlement=" + this.settlement + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityLoanContractDetailsModel=" + this.facilityLoanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementNotification  ***********************/
	class LoanAllocationSettlementNotificationBuilderImpl extends AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilderImpl  implements LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder {
	
		protected List<LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder> settlement = new ArrayList<>();
		protected List<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> loanTradeAllocationDetailsModel = new ArrayList<>();
		protected List<FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder> facilityLoanContractDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanAllocationSettlementNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlement")
		public List<? extends LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder> getSettlement() {
			return settlement;
		}
		
		@Override
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder getOrCreateSettlement(int _index) {
		
			if (settlement==null) {
				this.settlement = new ArrayList<>();
			}
			LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder result;
			return getIndex(settlement, _index, () -> {
						LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder newSettlement = LoanAllocationSettlementEvent.builder();
						return newSettlement;
					});
		}
		
		@Override
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel() {
			return loanTradeAllocationDetailsModel;
		}
		
		@Override
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder getOrCreateLoanTradeAllocationDetailsModel(int _index) {
		
			if (loanTradeAllocationDetailsModel==null) {
				this.loanTradeAllocationDetailsModel = new ArrayList<>();
			}
			LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder result;
			return getIndex(loanTradeAllocationDetailsModel, _index, () -> {
						LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder newLoanTradeAllocationDetailsModel = LoanTradeAllocationDetailsModel.builder();
						return newLoanTradeAllocationDetailsModel;
					});
		}
		
		@Override
		@RosettaAttribute("facilityLoanContractDetailsModel")
		public List<? extends FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder> getFacilityLoanContractDetailsModel() {
			return facilityLoanContractDetailsModel;
		}
		
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder getOrCreateFacilityLoanContractDetailsModel(int _index) {
		
			if (facilityLoanContractDetailsModel==null) {
				this.facilityLoanContractDetailsModel = new ArrayList<>();
			}
			FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder result;
			return getIndex(facilityLoanContractDetailsModel, _index, () -> {
						FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder newFacilityLoanContractDetailsModel = FacilityLoanContractDetailsModel.builder();
						return newFacilityLoanContractDetailsModel;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addPayment(LoanAllocationPayment payment) {
			if (payment!=null) this.payment.add(payment.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addPayment(LoanAllocationPayment payment, int _idx) {
			getIndex(this.payment, _idx, () -> payment.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments != null) {
				for (LoanAllocationPayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments == null)  {
				this.payment = new ArrayList<>();
			}
			else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlement")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addSettlement(LoanAllocationSettlementEvent settlement) {
			if (settlement!=null) this.settlement.add(settlement.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addSettlement(LoanAllocationSettlementEvent settlement, int _idx) {
			getIndex(this.settlement, _idx, () -> settlement.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addSettlement(List<? extends LoanAllocationSettlementEvent> settlements) {
			if (settlements != null) {
				for (LoanAllocationSettlementEvent toAdd : settlements) {
					this.settlement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setSettlement(List<? extends LoanAllocationSettlementEvent> settlements) {
			if (settlements == null)  {
				this.settlement = new ArrayList<>();
			}
			else {
				this.settlement = settlements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel) {
			if (loanTradeAllocationDetailsModel!=null) this.loanTradeAllocationDetailsModel.add(loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel, int _idx) {
			getIndex(this.loanTradeAllocationDetailsModel, _idx, () -> loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
			if (loanTradeAllocationDetailsModels != null) {
				for (LoanTradeAllocationDetailsModel toAdd : loanTradeAllocationDetailsModels) {
					this.loanTradeAllocationDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
			if (loanTradeAllocationDetailsModels == null)  {
				this.loanTradeAllocationDetailsModel = new ArrayList<>();
			}
			else {
				this.loanTradeAllocationDetailsModel = loanTradeAllocationDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("facilityLoanContractDetailsModel")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel) {
			if (facilityLoanContractDetailsModel!=null) this.facilityLoanContractDetailsModel.add(facilityLoanContractDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel, int _idx) {
			getIndex(this.facilityLoanContractDetailsModel, _idx, () -> facilityLoanContractDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModels) {
			if (facilityLoanContractDetailsModels != null) {
				for (FacilityLoanContractDetailsModel toAdd : facilityLoanContractDetailsModels) {
					this.facilityLoanContractDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModels) {
			if (facilityLoanContractDetailsModels == null)  {
				this.facilityLoanContractDetailsModel = new ArrayList<>();
			}
			else {
				this.facilityLoanContractDetailsModel = facilityLoanContractDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanAllocationSettlementNotification build() {
			return new LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder prune() {
			super.prune();
			settlement = settlement.stream().filter(b->b!=null).<LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanTradeAllocationDetailsModel = loanTradeAllocationDetailsModel.stream().filter(b->b!=null).<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityLoanContractDetailsModel = facilityLoanContractDetailsModel.stream().filter(b->b!=null).<FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlement()!=null && getSettlement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanTradeAllocationDetailsModel()!=null && getLoanTradeAllocationDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityLoanContractDetailsModel()!=null && getFacilityLoanContractDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder o = (LoanAllocationSettlementNotification.LoanAllocationSettlementNotificationBuilder) other;
			
			merger.mergeRosetta(getSettlement(), o.getSettlement(), this::getOrCreateSettlement);
			merger.mergeRosetta(getLoanTradeAllocationDetailsModel(), o.getLoanTradeAllocationDetailsModel(), this::getOrCreateLoanTradeAllocationDetailsModel);
			merger.mergeRosetta(getFacilityLoanContractDetailsModel(), o.getFacilityLoanContractDetailsModel(), this::getOrCreateFacilityLoanContractDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlement, _that.getSettlement())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityLoanContractDetailsModel, _that.getFacilityLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlement != null ? settlement.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityLoanContractDetailsModel != null ? facilityLoanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementNotificationBuilder {" +
				"settlement=" + this.settlement + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityLoanContractDetailsModel=" + this.facilityLoanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
