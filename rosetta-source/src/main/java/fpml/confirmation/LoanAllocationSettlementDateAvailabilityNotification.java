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
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanAllocationSettlementDateAvailabilityNotification;
import fpml.confirmation.LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder;
import fpml.confirmation.LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilderImpl;
import fpml.confirmation.LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationImpl;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAllocationSettlementDateAvailabilityNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate trade settlement date coordination (i.e. availability) details, between admin agent and counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationSettlementDateAvailabilityNotification", builder=LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilderImpl.class, version="${project.version}")
public interface LoanAllocationSettlementDateAvailabilityNotification extends AbstractLoanTradingNotification {

	LoanAllocationSettlementDateAvailabilityNotificationMeta metaData = new LoanAllocationSettlementDateAvailabilityNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An event structure defining information related to date availability to settle an allocation.
	 */
	List<? extends LoanSettlementDateAvailabilityEvent> getSettlementDateAvailability();
	List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel();
	List<? extends FacilityDetailsModel> getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementDateAvailabilityNotification build();
	
	LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder toBuilder();
	
	static LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder builder() {
		return new LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementDateAvailabilityNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationSettlementDateAvailabilityNotification> getType() {
		return LoanAllocationSettlementDateAvailabilityNotification.class;
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
		processRosetta(path.newSubPath("settlementDateAvailability"), processor, LoanSettlementDateAvailabilityEvent.class, getSettlementDateAvailability());
		processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.class, getLoanTradeAllocationDetailsModel());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementDateAvailabilityNotificationBuilder extends LoanAllocationSettlementDateAvailabilityNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder getOrCreateSettlementDateAvailability(int _index);
		List<? extends LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder> getSettlementDateAvailability();
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder getOrCreateLoanTradeAllocationDetailsModel(int _index);
		List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index);
		List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setActualBuild(Integer actualBuild);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setHeader(RequestMessageHeader header);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setNoticeDate(Date noticeDate);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addSettlementDateAvailability(LoanSettlementDateAvailabilityEvent settlementDateAvailability0);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addSettlementDateAvailability(LoanSettlementDateAvailabilityEvent settlementDateAvailability1, int _idx);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addSettlementDateAvailability(List<? extends LoanSettlementDateAvailabilityEvent> settlementDateAvailability2);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setSettlementDateAvailability(List<? extends LoanSettlementDateAvailabilityEvent> settlementDateAvailability3);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel0);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel1, int _idx);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel2);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel3);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel0);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel1, int _idx);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel2);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel3);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addParty(Party party0);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addParty(Party party1, int _idx);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addParty(List<? extends Party> party2);
		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("settlementDateAvailability"), processor, LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder.class, getSettlementDateAvailability());
			processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder.class, getLoanTradeAllocationDetailsModel());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementDateAvailabilityNotification  ***********************/
	class LoanAllocationSettlementDateAvailabilityNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanAllocationSettlementDateAvailabilityNotification {
		private final List<? extends LoanSettlementDateAvailabilityEvent> settlementDateAvailability;
		private final List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel;
		private final List<? extends FacilityDetailsModel> facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanAllocationSettlementDateAvailabilityNotificationImpl(LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder builder) {
			super(builder);
			this.settlementDateAvailability = ofNullable(builder.getSettlementDateAvailability()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanTradeAllocationDetailsModel = ofNullable(builder.getLoanTradeAllocationDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementDateAvailability")
		public List<? extends LoanSettlementDateAvailabilityEvent> getSettlementDateAvailability() {
			return settlementDateAvailability;
		}
		
		@Override
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel() {
			return loanTradeAllocationDetailsModel;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public List<? extends FacilityDetailsModel> getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder toBuilder() {
			LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementDateAvailability()).ifPresent(builder::setSettlementDateAvailability);
			ofNullable(getLoanTradeAllocationDetailsModel()).ifPresent(builder::setLoanTradeAllocationDetailsModel);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementDateAvailabilityNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDateAvailability, _that.getSettlementDateAvailability())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDateAvailability != null ? settlementDateAvailability.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateAvailabilityNotification {" +
				"settlementDateAvailability=" + this.settlementDateAvailability + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementDateAvailabilityNotification  ***********************/
	class LoanAllocationSettlementDateAvailabilityNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder {
	
		protected List<LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder> settlementDateAvailability = new ArrayList<>();
		protected List<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> loanTradeAllocationDetailsModel = new ArrayList<>();
		protected List<FacilityDetailsModel.FacilityDetailsModelBuilder> facilityDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanAllocationSettlementDateAvailabilityNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementDateAvailability")
		public List<? extends LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder> getSettlementDateAvailability() {
			return settlementDateAvailability;
		}
		
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder getOrCreateSettlementDateAvailability(int _index) {
		
			if (settlementDateAvailability==null) {
				this.settlementDateAvailability = new ArrayList<>();
			}
			LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder result;
			return getIndex(settlementDateAvailability, _index, () -> {
						LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder newSettlementDateAvailability = LoanSettlementDateAvailabilityEvent.builder();
						return newSettlementDateAvailability;
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
		@RosettaAttribute("facilityDetailsModel")
		public List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index) {
		
			if (facilityDetailsModel==null) {
				this.facilityDetailsModel = new ArrayList<>();
			}
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			return getIndex(facilityDetailsModel, _index, () -> {
						FacilityDetailsModel.FacilityDetailsModelBuilder newFacilityDetailsModel = FacilityDetailsModel.builder();
						return newFacilityDetailsModel;
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
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addSettlementDateAvailability(LoanSettlementDateAvailabilityEvent settlementDateAvailability) {
			if (settlementDateAvailability!=null) this.settlementDateAvailability.add(settlementDateAvailability.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addSettlementDateAvailability(LoanSettlementDateAvailabilityEvent settlementDateAvailability, int _idx) {
			getIndex(this.settlementDateAvailability, _idx, () -> settlementDateAvailability.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addSettlementDateAvailability(List<? extends LoanSettlementDateAvailabilityEvent> settlementDateAvailabilitys) {
			if (settlementDateAvailabilitys != null) {
				for (LoanSettlementDateAvailabilityEvent toAdd : settlementDateAvailabilitys) {
					this.settlementDateAvailability.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementDateAvailability")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setSettlementDateAvailability(List<? extends LoanSettlementDateAvailabilityEvent> settlementDateAvailabilitys) {
			if (settlementDateAvailabilitys == null)  {
				this.settlementDateAvailability = new ArrayList<>();
			}
			else {
				this.settlementDateAvailability = settlementDateAvailabilitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel) {
			if (loanTradeAllocationDetailsModel!=null) this.loanTradeAllocationDetailsModel.add(loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel, int _idx) {
			getIndex(this.loanTradeAllocationDetailsModel, _idx, () -> loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
			if (loanTradeAllocationDetailsModels != null) {
				for (LoanTradeAllocationDetailsModel toAdd : loanTradeAllocationDetailsModels) {
					this.loanTradeAllocationDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
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
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			if (facilityDetailsModel!=null) this.facilityDetailsModel.add(facilityDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel, int _idx) {
			getIndex(this.facilityDetailsModel, _idx, () -> facilityDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels != null) {
				for (FacilityDetailsModel toAdd : facilityDetailsModels) {
					this.facilityDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityDetailsModel")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels == null)  {
				this.facilityDetailsModel = new ArrayList<>();
			}
			else {
				this.facilityDetailsModel = facilityDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanAllocationSettlementDateAvailabilityNotification build() {
			return new LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder prune() {
			super.prune();
			settlementDateAvailability = settlementDateAvailability.stream().filter(b->b!=null).<LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanTradeAllocationDetailsModel = loanTradeAllocationDetailsModel.stream().filter(b->b!=null).<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityDetailsModel = facilityDetailsModel.stream().filter(b->b!=null).<FacilityDetailsModel.FacilityDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementDateAvailability()!=null && getSettlementDateAvailability().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanTradeAllocationDetailsModel()!=null && getLoanTradeAllocationDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder o = (LoanAllocationSettlementDateAvailabilityNotification.LoanAllocationSettlementDateAvailabilityNotificationBuilder) other;
			
			merger.mergeRosetta(getSettlementDateAvailability(), o.getSettlementDateAvailability(), this::getOrCreateSettlementDateAvailability);
			merger.mergeRosetta(getLoanTradeAllocationDetailsModel(), o.getLoanTradeAllocationDetailsModel(), this::getOrCreateLoanTradeAllocationDetailsModel);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::getOrCreateFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementDateAvailabilityNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDateAvailability, _that.getSettlementDateAvailability())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDateAvailability != null ? settlementDateAvailability.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateAvailabilityNotificationBuilder {" +
				"settlementDateAvailability=" + this.settlementDateAvailability + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
