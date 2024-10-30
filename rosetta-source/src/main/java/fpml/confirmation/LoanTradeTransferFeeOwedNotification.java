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
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradeTransferFeeOwedEvent;
import fpml.confirmation.LoanTradeTransferFeeOwedNotification;
import fpml.confirmation.LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder;
import fpml.confirmation.LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilderImpl;
import fpml.confirmation.LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationImpl;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanTradeTransferFeeOwedNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate transfer fee details, from admin agent to counterparty.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradeTransferFeeOwedNotification", builder=LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradeTransferFeeOwedNotification extends AbstractLoanTradingNotification {

	LoanTradeTransferFeeOwedNotificationMeta metaData = new LoanTradeTransferFeeOwedNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to detail the fee owed to the agent for the transfer of a commitment from seller to buyer.
	 */
	LoanTradeTransferFeeOwedEvent getFeeOwed();
	/**
	 * A summary of the trade.
	 */
	LoanTradeSummary getTradeSummary();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTradeTransferFeeOwedNotification build();
	
	LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder toBuilder();
	
	static LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder builder() {
		return new LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeTransferFeeOwedNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeTransferFeeOwedNotification> getType() {
		return LoanTradeTransferFeeOwedNotification.class;
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
		processRosetta(path.newSubPath("feeOwed"), processor, LoanTradeTransferFeeOwedEvent.class, getFeeOwed());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeTransferFeeOwedNotificationBuilder extends LoanTradeTransferFeeOwedNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder getOrCreateFeeOwed();
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder getFeeOwed();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setActualBuild(Integer actualBuild);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setHeader(RequestMessageHeader header);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setNoticeDate(Date noticeDate);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setFeeOwed(LoanTradeTransferFeeOwedEvent feeOwed);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder addParty(Party party0);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder addParty(Party party1, int _idx);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder addParty(List<? extends Party> party2);
		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("feeOwed"), processor, LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder.class, getFeeOwed());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeTransferFeeOwedNotification  ***********************/
	class LoanTradeTransferFeeOwedNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanTradeTransferFeeOwedNotification {
		private final LoanTradeTransferFeeOwedEvent feeOwed;
		private final LoanTradeSummary tradeSummary;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanTradeTransferFeeOwedNotificationImpl(LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder builder) {
			super(builder);
			this.feeOwed = ofNullable(builder.getFeeOwed()).map(f->f.build()).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feeOwed")
		public LoanTradeTransferFeeOwedEvent getFeeOwed() {
			return feeOwed;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanTradeTransferFeeOwedNotification build() {
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder toBuilder() {
			LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFeeOwed()).ifPresent(builder::setFeeOwed);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeOwedNotification _that = getType().cast(o);
		
			if (!Objects.equals(feeOwed, _that.getFeeOwed())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeOwed != null ? feeOwed.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeOwedNotification {" +
				"feeOwed=" + this.feeOwed + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeTransferFeeOwedNotification  ***********************/
	class LoanTradeTransferFeeOwedNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder {
	
		protected LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder feeOwed;
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanTradeTransferFeeOwedNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeOwed")
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder getFeeOwed() {
			return feeOwed;
		}
		
		@Override
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder getOrCreateFeeOwed() {
			LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder result;
			if (feeOwed!=null) {
				result = feeOwed;
			}
			else {
				result = feeOwed = LoanTradeTransferFeeOwedEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary() {
			LoanTradeSummary.LoanTradeSummaryBuilder result;
			if (tradeSummary!=null) {
				result = tradeSummary;
			}
			else {
				result = tradeSummary = LoanTradeSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel() {
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			if (facilityDetailsModel!=null) {
				result = facilityDetailsModel;
			}
			else {
				result = facilityDetailsModel = FacilityDetailsModel.builder();
			}
			
			return result;
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
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeOwed")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setFeeOwed(LoanTradeTransferFeeOwedEvent feeOwed) {
			this.feeOwed = feeOwed==null?null:feeOwed.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary) {
			this.tradeSummary = tradeSummary==null?null:tradeSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanTradeTransferFeeOwedNotification build() {
			return new LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationImpl(this);
		}
		
		@Override
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder prune() {
			super.prune();
			if (feeOwed!=null && !feeOwed.prune().hasData()) feeOwed = null;
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFeeOwed()!=null && getFeeOwed().hasData()) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder o = (LoanTradeTransferFeeOwedNotification.LoanTradeTransferFeeOwedNotificationBuilder) other;
			
			merger.mergeRosetta(getFeeOwed(), o.getFeeOwed(), this::setFeeOwed);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeOwedNotification _that = getType().cast(o);
		
			if (!Objects.equals(feeOwed, _that.getFeeOwed())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeOwed != null ? feeOwed.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeOwedNotificationBuilder {" +
				"feeOwed=" + this.feeOwed + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
