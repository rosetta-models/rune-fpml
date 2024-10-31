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
import fpml.confirmation.LoanAllocationSettlementDateFinalizationNotification;
import fpml.confirmation.LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder;
import fpml.confirmation.LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilderImpl;
import fpml.confirmation.LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationImpl;
import fpml.confirmation.LoanSettlementDateFinalizationEvent;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAllocationSettlementDateFinalizationNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate finalized trade settlement date details, from admin agent to counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationSettlementDateFinalizationNotification", builder=LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilderImpl.class, version="${project.version}")
public interface LoanAllocationSettlementDateFinalizationNotification extends AbstractLoanTradingNotification {

	LoanAllocationSettlementDateFinalizationNotificationMeta metaData = new LoanAllocationSettlementDateFinalizationNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An event structure defining information related to date availability to settle an allocation.
	 */
	List<? extends LoanSettlementDateFinalizationEvent> getSettlementDateFinalization();
	List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel();
	List<? extends FacilityDetailsModel> getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementDateFinalizationNotification build();
	
	LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder toBuilder();
	
	static LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder builder() {
		return new LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementDateFinalizationNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationSettlementDateFinalizationNotification> getType() {
		return LoanAllocationSettlementDateFinalizationNotification.class;
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
		processRosetta(path.newSubPath("settlementDateFinalization"), processor, LoanSettlementDateFinalizationEvent.class, getSettlementDateFinalization());
		processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.class, getLoanTradeAllocationDetailsModel());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementDateFinalizationNotificationBuilder extends LoanAllocationSettlementDateFinalizationNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder getOrCreateSettlementDateFinalization(int _index);
		List<? extends LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder> getSettlementDateFinalization();
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder getOrCreateLoanTradeAllocationDetailsModel(int _index);
		List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index);
		List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setActualBuild(Integer actualBuild);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setHeader(RequestMessageHeader header);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setNoticeDate(Date noticeDate);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addSettlementDateFinalization(LoanSettlementDateFinalizationEvent settlementDateFinalization0);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addSettlementDateFinalization(LoanSettlementDateFinalizationEvent settlementDateFinalization1, int _idx);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addSettlementDateFinalization(List<? extends LoanSettlementDateFinalizationEvent> settlementDateFinalization2);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setSettlementDateFinalization(List<? extends LoanSettlementDateFinalizationEvent> settlementDateFinalization3);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel0);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel1, int _idx);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel2);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel3);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel0);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel1, int _idx);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel2);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel3);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addParty(Party party0);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addParty(Party party1, int _idx);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addParty(List<? extends Party> party2);
		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("settlementDateFinalization"), processor, LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder.class, getSettlementDateFinalization());
			processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder.class, getLoanTradeAllocationDetailsModel());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementDateFinalizationNotification  ***********************/
	class LoanAllocationSettlementDateFinalizationNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanAllocationSettlementDateFinalizationNotification {
		private final List<? extends LoanSettlementDateFinalizationEvent> settlementDateFinalization;
		private final List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel;
		private final List<? extends FacilityDetailsModel> facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanAllocationSettlementDateFinalizationNotificationImpl(LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder builder) {
			super(builder);
			this.settlementDateFinalization = ofNullable(builder.getSettlementDateFinalization()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanTradeAllocationDetailsModel = ofNullable(builder.getLoanTradeAllocationDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementDateFinalization")
		public List<? extends LoanSettlementDateFinalizationEvent> getSettlementDateFinalization() {
			return settlementDateFinalization;
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
		public LoanAllocationSettlementDateFinalizationNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder toBuilder() {
			LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementDateFinalization()).ifPresent(builder::setSettlementDateFinalization);
			ofNullable(getLoanTradeAllocationDetailsModel()).ifPresent(builder::setLoanTradeAllocationDetailsModel);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementDateFinalizationNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDateFinalization, _that.getSettlementDateFinalization())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDateFinalization != null ? settlementDateFinalization.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateFinalizationNotification {" +
				"settlementDateFinalization=" + this.settlementDateFinalization + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementDateFinalizationNotification  ***********************/
	class LoanAllocationSettlementDateFinalizationNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder {
	
		protected List<LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder> settlementDateFinalization = new ArrayList<>();
		protected List<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> loanTradeAllocationDetailsModel = new ArrayList<>();
		protected List<FacilityDetailsModel.FacilityDetailsModelBuilder> facilityDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanAllocationSettlementDateFinalizationNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementDateFinalization")
		public List<? extends LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder> getSettlementDateFinalization() {
			return settlementDateFinalization;
		}
		
		@Override
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder getOrCreateSettlementDateFinalization(int _index) {
		
			if (settlementDateFinalization==null) {
				this.settlementDateFinalization = new ArrayList<>();
			}
			LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder result;
			return getIndex(settlementDateFinalization, _index, () -> {
						LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder newSettlementDateFinalization = LoanSettlementDateFinalizationEvent.builder();
						return newSettlementDateFinalization;
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
		@RosettaAttribute("facilityDetailsModel")
		public List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
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
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDateFinalization")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addSettlementDateFinalization(LoanSettlementDateFinalizationEvent settlementDateFinalization) {
			if (settlementDateFinalization!=null) this.settlementDateFinalization.add(settlementDateFinalization.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addSettlementDateFinalization(LoanSettlementDateFinalizationEvent settlementDateFinalization, int _idx) {
			getIndex(this.settlementDateFinalization, _idx, () -> settlementDateFinalization.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addSettlementDateFinalization(List<? extends LoanSettlementDateFinalizationEvent> settlementDateFinalizations) {
			if (settlementDateFinalizations != null) {
				for (LoanSettlementDateFinalizationEvent toAdd : settlementDateFinalizations) {
					this.settlementDateFinalization.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setSettlementDateFinalization(List<? extends LoanSettlementDateFinalizationEvent> settlementDateFinalizations) {
			if (settlementDateFinalizations == null)  {
				this.settlementDateFinalization = new ArrayList<>();
			}
			else {
				this.settlementDateFinalization = settlementDateFinalizations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel) {
			if (loanTradeAllocationDetailsModel!=null) this.loanTradeAllocationDetailsModel.add(loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel, int _idx) {
			getIndex(this.loanTradeAllocationDetailsModel, _idx, () -> loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
			if (loanTradeAllocationDetailsModels != null) {
				for (LoanTradeAllocationDetailsModel toAdd : loanTradeAllocationDetailsModels) {
					this.loanTradeAllocationDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
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
		@RosettaAttribute("facilityDetailsModel")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			if (facilityDetailsModel!=null) this.facilityDetailsModel.add(facilityDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel, int _idx) {
			getIndex(this.facilityDetailsModel, _idx, () -> facilityDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels != null) {
				for (FacilityDetailsModel toAdd : facilityDetailsModels) {
					this.facilityDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
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
		@RosettaAttribute("party")
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanAllocationSettlementDateFinalizationNotification build() {
			return new LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder prune() {
			super.prune();
			settlementDateFinalization = settlementDateFinalization.stream().filter(b->b!=null).<LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanTradeAllocationDetailsModel = loanTradeAllocationDetailsModel.stream().filter(b->b!=null).<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityDetailsModel = facilityDetailsModel.stream().filter(b->b!=null).<FacilityDetailsModel.FacilityDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementDateFinalization()!=null && getSettlementDateFinalization().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanTradeAllocationDetailsModel()!=null && getLoanTradeAllocationDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder o = (LoanAllocationSettlementDateFinalizationNotification.LoanAllocationSettlementDateFinalizationNotificationBuilder) other;
			
			merger.mergeRosetta(getSettlementDateFinalization(), o.getSettlementDateFinalization(), this::getOrCreateSettlementDateFinalization);
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
		
			LoanAllocationSettlementDateFinalizationNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDateFinalization, _that.getSettlementDateFinalization())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDateFinalization != null ? settlementDateFinalization.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateFinalizationNotificationBuilder {" +
				"settlementDateFinalization=" + this.settlementDateFinalization + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
