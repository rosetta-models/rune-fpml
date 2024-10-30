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
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent;
import fpml.confirmation.LoanAllocationTransferFeeOwedNotification;
import fpml.confirmation.LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder;
import fpml.confirmation.LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilderImpl;
import fpml.confirmation.LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationImpl;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAllocationTransferFeeOwedNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate transfer fee details, from admin agent to counterparty.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanAllocationTransferFeeOwedNotification", builder=LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanAllocationTransferFeeOwedNotification extends AbstractLoanTradingNotification {

	LoanAllocationTransferFeeOwedNotificationMeta metaData = new LoanAllocationTransferFeeOwedNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to detail the fee owed to the agent for the transfer of a commitment from seller to buyer.
	 */
	List<? extends LoanAllocationTransferFeeOwedEvent> getFeeOwed();
	List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel();
	List<? extends FacilityDetailsModel> getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationTransferFeeOwedNotification build();
	
	LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder toBuilder();
	
	static LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder builder() {
		return new LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationTransferFeeOwedNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationTransferFeeOwedNotification> getType() {
		return LoanAllocationTransferFeeOwedNotification.class;
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
		processRosetta(path.newSubPath("feeOwed"), processor, LoanAllocationTransferFeeOwedEvent.class, getFeeOwed());
		processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.class, getLoanTradeAllocationDetailsModel());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationTransferFeeOwedNotificationBuilder extends LoanAllocationTransferFeeOwedNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder getOrCreateFeeOwed(int _index);
		List<? extends LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder> getFeeOwed();
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder getOrCreateLoanTradeAllocationDetailsModel(int _index);
		List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index);
		List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setActualBuild(Integer actualBuild);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setHeader(RequestMessageHeader header);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setNoticeDate(Date noticeDate);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFeeOwed(LoanAllocationTransferFeeOwedEvent feeOwed0);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFeeOwed(LoanAllocationTransferFeeOwedEvent feeOwed1, int _idx);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFeeOwed(List<? extends LoanAllocationTransferFeeOwedEvent> feeOwed2);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setFeeOwed(List<? extends LoanAllocationTransferFeeOwedEvent> feeOwed3);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel0);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel1, int _idx);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel2);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel3);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel0);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel1, int _idx);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel2);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel3);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addParty(Party party0);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addParty(Party party1, int _idx);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addParty(List<? extends Party> party2);
		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("feeOwed"), processor, LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder.class, getFeeOwed());
			processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder.class, getLoanTradeAllocationDetailsModel());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationTransferFeeOwedNotification  ***********************/
	class LoanAllocationTransferFeeOwedNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanAllocationTransferFeeOwedNotification {
		private final List<? extends LoanAllocationTransferFeeOwedEvent> feeOwed;
		private final List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel;
		private final List<? extends FacilityDetailsModel> facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanAllocationTransferFeeOwedNotificationImpl(LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder builder) {
			super(builder);
			this.feeOwed = ofNullable(builder.getFeeOwed()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanTradeAllocationDetailsModel = ofNullable(builder.getLoanTradeAllocationDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feeOwed")
		public List<? extends LoanAllocationTransferFeeOwedEvent> getFeeOwed() {
			return feeOwed;
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
		public LoanAllocationTransferFeeOwedNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder toBuilder() {
			LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFeeOwed()).ifPresent(builder::setFeeOwed);
			ofNullable(getLoanTradeAllocationDetailsModel()).ifPresent(builder::setLoanTradeAllocationDetailsModel);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeOwedNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feeOwed, _that.getFeeOwed())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeOwed != null ? feeOwed.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeOwedNotification {" +
				"feeOwed=" + this.feeOwed + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationTransferFeeOwedNotification  ***********************/
	class LoanAllocationTransferFeeOwedNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder {
	
		protected List<LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder> feeOwed = new ArrayList<>();
		protected List<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> loanTradeAllocationDetailsModel = new ArrayList<>();
		protected List<FacilityDetailsModel.FacilityDetailsModelBuilder> facilityDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanAllocationTransferFeeOwedNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeOwed")
		public List<? extends LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder> getFeeOwed() {
			return feeOwed;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder getOrCreateFeeOwed(int _index) {
		
			if (feeOwed==null) {
				this.feeOwed = new ArrayList<>();
			}
			LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder result;
			return getIndex(feeOwed, _index, () -> {
						LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder newFeeOwed = LoanAllocationTransferFeeOwedEvent.builder();
						return newFeeOwed;
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
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeOwed")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFeeOwed(LoanAllocationTransferFeeOwedEvent feeOwed) {
			if (feeOwed!=null) this.feeOwed.add(feeOwed.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFeeOwed(LoanAllocationTransferFeeOwedEvent feeOwed, int _idx) {
			getIndex(this.feeOwed, _idx, () -> feeOwed.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFeeOwed(List<? extends LoanAllocationTransferFeeOwedEvent> feeOweds) {
			if (feeOweds != null) {
				for (LoanAllocationTransferFeeOwedEvent toAdd : feeOweds) {
					this.feeOwed.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setFeeOwed(List<? extends LoanAllocationTransferFeeOwedEvent> feeOweds) {
			if (feeOweds == null)  {
				this.feeOwed = new ArrayList<>();
			}
			else {
				this.feeOwed = feeOweds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel) {
			if (loanTradeAllocationDetailsModel!=null) this.loanTradeAllocationDetailsModel.add(loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel, int _idx) {
			getIndex(this.loanTradeAllocationDetailsModel, _idx, () -> loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
			if (loanTradeAllocationDetailsModels != null) {
				for (LoanTradeAllocationDetailsModel toAdd : loanTradeAllocationDetailsModels) {
					this.loanTradeAllocationDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
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
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			if (facilityDetailsModel!=null) this.facilityDetailsModel.add(facilityDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel, int _idx) {
			getIndex(this.facilityDetailsModel, _idx, () -> facilityDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels != null) {
				for (FacilityDetailsModel toAdd : facilityDetailsModels) {
					this.facilityDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
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
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanAllocationTransferFeeOwedNotification build() {
			return new LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder prune() {
			super.prune();
			feeOwed = feeOwed.stream().filter(b->b!=null).<LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanTradeAllocationDetailsModel = loanTradeAllocationDetailsModel.stream().filter(b->b!=null).<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityDetailsModel = facilityDetailsModel.stream().filter(b->b!=null).<FacilityDetailsModel.FacilityDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFeeOwed()!=null && getFeeOwed().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanTradeAllocationDetailsModel()!=null && getLoanTradeAllocationDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder o = (LoanAllocationTransferFeeOwedNotification.LoanAllocationTransferFeeOwedNotificationBuilder) other;
			
			merger.mergeRosetta(getFeeOwed(), o.getFeeOwed(), this::getOrCreateFeeOwed);
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
		
			LoanAllocationTransferFeeOwedNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feeOwed, _that.getFeeOwed())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeOwed != null ? feeOwed.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeOwedNotificationBuilder {" +
				"feeOwed=" + this.feeOwed + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
