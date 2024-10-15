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
import fpml.confirmation.AbstractLoanTradingNotification;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.LoanTransferSettlementEvent;
import fpml.confirmation.LoanTransferSettlementNotification;
import fpml.confirmation.LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder;
import fpml.confirmation.LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilderImpl;
import fpml.confirmation.LoanTransferSettlementNotification.LoanTransferSettlementNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanTransferSettlementNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate trade settlement position and outstandings details, from admin agent to counterparty.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTransferSettlementNotification", builder=LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilderImpl.class, version="${project.version}")
public interface LoanTransferSettlementNotification extends AbstractLoanTradingNotification {

	LoanTransferSettlementNotificationMeta metaData = new LoanTransferSettlementNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The transfer settlement event.
	 */
	List<? extends LoanTransferSettlementEvent> getSettlement();
	List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel();
	List<? extends FacilityLoanContractDetailsModel> getFacilityLoanContractDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTransferSettlementNotification build();
	
	LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder toBuilder();
	
	static LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder builder() {
		return new LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTransferSettlementNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTransferSettlementNotification> getType() {
		return LoanTransferSettlementNotification.class;
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
		processRosetta(path.newSubPath("settlement"), processor, LoanTransferSettlementEvent.class, getSettlement());
		processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.class, getLoanTradeAllocationDetailsModel());
		processRosetta(path.newSubPath("facilityLoanContractDetailsModel"), processor, FacilityLoanContractDetailsModel.class, getFacilityLoanContractDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTransferSettlementNotificationBuilder extends LoanTransferSettlementNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder getOrCreateSettlement(int _index);
		List<? extends LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder> getSettlement();
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder getOrCreateLoanTradeAllocationDetailsModel(int _index);
		List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel();
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder getOrCreateFacilityLoanContractDetailsModel(int _index);
		List<? extends FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder> getFacilityLoanContractDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setActualBuild(Integer actualBuild);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setHeader(RequestMessageHeader header);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setNoticeDate(Date noticeDate);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addSettlement(LoanTransferSettlementEvent settlement0);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addSettlement(LoanTransferSettlementEvent settlement1, int _idx);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addSettlement(List<? extends LoanTransferSettlementEvent> settlement2);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setSettlement(List<? extends LoanTransferSettlementEvent> settlement3);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel0);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel1, int _idx);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel2);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel3);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel0);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel1, int _idx);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModel2);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModel3);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addParty(Party party0);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addParty(Party party1, int _idx);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addParty(List<? extends Party> party2);
		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("settlement"), processor, LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder.class, getSettlement());
			processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder.class, getLoanTradeAllocationDetailsModel());
			processRosetta(path.newSubPath("facilityLoanContractDetailsModel"), processor, FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder.class, getFacilityLoanContractDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTransferSettlementNotification  ***********************/
	class LoanTransferSettlementNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanTransferSettlementNotification {
		private final List<? extends LoanTransferSettlementEvent> settlement;
		private final List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel;
		private final List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanTransferSettlementNotificationImpl(LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder builder) {
			super(builder);
			this.settlement = ofNullable(builder.getSettlement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanTradeAllocationDetailsModel = ofNullable(builder.getLoanTradeAllocationDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityLoanContractDetailsModel = ofNullable(builder.getFacilityLoanContractDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlement")
		public List<? extends LoanTransferSettlementEvent> getSettlement() {
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
		public LoanTransferSettlementNotification build() {
			return this;
		}
		
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder toBuilder() {
			LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder builder) {
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
		
			LoanTransferSettlementNotification _that = getType().cast(o);
		
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
			return "LoanTransferSettlementNotification {" +
				"settlement=" + this.settlement + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityLoanContractDetailsModel=" + this.facilityLoanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTransferSettlementNotification  ***********************/
	class LoanTransferSettlementNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder {
	
		protected List<LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder> settlement = new ArrayList<>();
		protected List<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> loanTradeAllocationDetailsModel = new ArrayList<>();
		protected List<FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder> facilityLoanContractDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanTransferSettlementNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlement")
		public List<? extends LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder> getSettlement() {
			return settlement;
		}
		
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder getOrCreateSettlement(int _index) {
		
			if (settlement==null) {
				this.settlement = new ArrayList<>();
			}
			LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder result;
			return getIndex(settlement, _index, () -> {
						LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder newSettlement = LoanTransferSettlementEvent.builder();
						return newSettlement;
					});
		}
		
		@Override
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel() {
			return loanTradeAllocationDetailsModel;
		}
		
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
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addSettlement(LoanTransferSettlementEvent settlement) {
			if (settlement!=null) this.settlement.add(settlement.toBuilder());
			return this;
		}
		
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addSettlement(LoanTransferSettlementEvent settlement, int _idx) {
			getIndex(this.settlement, _idx, () -> settlement.toBuilder());
			return this;
		}
		@Override 
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addSettlement(List<? extends LoanTransferSettlementEvent> settlements) {
			if (settlements != null) {
				for (LoanTransferSettlementEvent toAdd : settlements) {
					this.settlement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlement")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setSettlement(List<? extends LoanTransferSettlementEvent> settlements) {
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
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel) {
			if (loanTradeAllocationDetailsModel!=null) this.loanTradeAllocationDetailsModel.add(loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel, int _idx) {
			getIndex(this.loanTradeAllocationDetailsModel, _idx, () -> loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
			if (loanTradeAllocationDetailsModels != null) {
				for (LoanTradeAllocationDetailsModel toAdd : loanTradeAllocationDetailsModels) {
					this.loanTradeAllocationDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
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
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel) {
			if (facilityLoanContractDetailsModel!=null) this.facilityLoanContractDetailsModel.add(facilityLoanContractDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addFacilityLoanContractDetailsModel(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel, int _idx) {
			getIndex(this.facilityLoanContractDetailsModel, _idx, () -> facilityLoanContractDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModels) {
			if (facilityLoanContractDetailsModels != null) {
				for (FacilityLoanContractDetailsModel toAdd : facilityLoanContractDetailsModels) {
					this.facilityLoanContractDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityLoanContractDetailsModel")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setFacilityLoanContractDetailsModel(List<? extends FacilityLoanContractDetailsModel> facilityLoanContractDetailsModels) {
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
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanTransferSettlementNotification build() {
			return new LoanTransferSettlementNotification.LoanTransferSettlementNotificationImpl(this);
		}
		
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder prune() {
			super.prune();
			settlement = settlement.stream().filter(b->b!=null).<LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
		public LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder o = (LoanTransferSettlementNotification.LoanTransferSettlementNotificationBuilder) other;
			
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
		
			LoanTransferSettlementNotification _that = getType().cast(o);
		
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
			return "LoanTransferSettlementNotificationBuilder {" +
				"settlement=" + this.settlement + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityLoanContractDetailsModel=" + this.facilityLoanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
