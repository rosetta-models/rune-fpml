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
import fpml.confirmation.AbstractLoanTradePaymentNotification;
import fpml.confirmation.AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder;
import fpml.confirmation.AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanTradePayment;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradeTransferFeeDueEvent;
import fpml.confirmation.LoanTradeTransferFeeDueNotification;
import fpml.confirmation.LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder;
import fpml.confirmation.LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilderImpl;
import fpml.confirmation.LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationImpl;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanTradeTransferFeeDueNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate transfer fee details, from admin agent to counterparty.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradeTransferFeeDueNotification", builder=LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradeTransferFeeDueNotification extends AbstractLoanTradePaymentNotification {

	LoanTradeTransferFeeDueNotificationMeta metaData = new LoanTradeTransferFeeDueNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to indicate the transfer fee due at the loan trade level.
	 */
	List<? extends LoanTradeTransferFeeDueEvent> getFeeDue();
	/**
	 * A summary of the trade.
	 */
	List<? extends LoanTradeSummary> getTradeSummary();
	List<? extends FacilityDetailsModel> getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTradeTransferFeeDueNotification build();
	
	LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder toBuilder();
	
	static LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder builder() {
		return new LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeTransferFeeDueNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeTransferFeeDueNotification> getType() {
		return LoanTradeTransferFeeDueNotification.class;
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
		processRosetta(path.newSubPath("payment"), processor, LoanTradePayment.class, getPayment());
		processRosetta(path.newSubPath("feeDue"), processor, LoanTradeTransferFeeDueEvent.class, getFeeDue());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeTransferFeeDueNotificationBuilder extends LoanTradeTransferFeeDueNotification, AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder {
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder getOrCreateFeeDue(int _index);
		List<? extends LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder> getFeeDue();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary(int _index);
		List<? extends LoanTradeSummary.LoanTradeSummaryBuilder> getTradeSummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index);
		List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setActualBuild(Integer actualBuild);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setHeader(RequestMessageHeader header);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setNoticeDate(Date noticeDate);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addPayment(LoanTradePayment payment0);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addPayment(LoanTradePayment payment1, int _idx);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addPayment(List<? extends LoanTradePayment> payment2);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setPayment(List<? extends LoanTradePayment> payment3);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFeeDue(LoanTradeTransferFeeDueEvent feeDue0);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFeeDue(LoanTradeTransferFeeDueEvent feeDue1, int _idx);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFeeDue(List<? extends LoanTradeTransferFeeDueEvent> feeDue2);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setFeeDue(List<? extends LoanTradeTransferFeeDueEvent> feeDue3);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary0);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary1, int _idx);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addTradeSummary(List<? extends LoanTradeSummary> tradeSummary2);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setTradeSummary(List<? extends LoanTradeSummary> tradeSummary3);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel0);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel1, int _idx);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel2);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel3);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addParty(Party party0);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addParty(Party party1, int _idx);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addParty(List<? extends Party> party2);
		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("payment"), processor, LoanTradePayment.LoanTradePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("feeDue"), processor, LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder.class, getFeeDue());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeTransferFeeDueNotification  ***********************/
	class LoanTradeTransferFeeDueNotificationImpl extends AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationImpl implements LoanTradeTransferFeeDueNotification {
		private final List<? extends LoanTradeTransferFeeDueEvent> feeDue;
		private final List<? extends LoanTradeSummary> tradeSummary;
		private final List<? extends FacilityDetailsModel> facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanTradeTransferFeeDueNotificationImpl(LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder builder) {
			super(builder);
			this.feeDue = ofNullable(builder.getFeeDue()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feeDue")
		public List<? extends LoanTradeTransferFeeDueEvent> getFeeDue() {
			return feeDue;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public List<? extends LoanTradeSummary> getTradeSummary() {
			return tradeSummary;
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
		public LoanTradeTransferFeeDueNotification build() {
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder toBuilder() {
			LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFeeDue()).ifPresent(builder::setFeeDue);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeDueNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feeDue, _that.getFeeDue())) return false;
			if (!ListEquals.listEquals(tradeSummary, _that.getTradeSummary())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeDue != null ? feeDue.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeDueNotification {" +
				"feeDue=" + this.feeDue + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeTransferFeeDueNotification  ***********************/
	class LoanTradeTransferFeeDueNotificationBuilderImpl extends AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilderImpl  implements LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder {
	
		protected List<LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder> feeDue = new ArrayList<>();
		protected List<LoanTradeSummary.LoanTradeSummaryBuilder> tradeSummary = new ArrayList<>();
		protected List<FacilityDetailsModel.FacilityDetailsModelBuilder> facilityDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanTradeTransferFeeDueNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeDue")
		public List<? extends LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder> getFeeDue() {
			return feeDue;
		}
		
		@Override
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder getOrCreateFeeDue(int _index) {
		
			if (feeDue==null) {
				this.feeDue = new ArrayList<>();
			}
			LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder result;
			return getIndex(feeDue, _index, () -> {
						LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder newFeeDue = LoanTradeTransferFeeDueEvent.builder();
						return newFeeDue;
					});
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public List<? extends LoanTradeSummary.LoanTradeSummaryBuilder> getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary(int _index) {
		
			if (tradeSummary==null) {
				this.tradeSummary = new ArrayList<>();
			}
			LoanTradeSummary.LoanTradeSummaryBuilder result;
			return getIndex(tradeSummary, _index, () -> {
						LoanTradeSummary.LoanTradeSummaryBuilder newTradeSummary = LoanTradeSummary.builder();
						return newTradeSummary;
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
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addPayment(LoanTradePayment payment) {
			if (payment!=null) this.payment.add(payment.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addPayment(LoanTradePayment payment, int _idx) {
			getIndex(this.payment, _idx, () -> payment.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addPayment(List<? extends LoanTradePayment> payments) {
			if (payments != null) {
				for (LoanTradePayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setPayment(List<? extends LoanTradePayment> payments) {
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
		@RosettaAttribute("feeDue")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFeeDue(LoanTradeTransferFeeDueEvent feeDue) {
			if (feeDue!=null) this.feeDue.add(feeDue.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFeeDue(LoanTradeTransferFeeDueEvent feeDue, int _idx) {
			getIndex(this.feeDue, _idx, () -> feeDue.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFeeDue(List<? extends LoanTradeTransferFeeDueEvent> feeDues) {
			if (feeDues != null) {
				for (LoanTradeTransferFeeDueEvent toAdd : feeDues) {
					this.feeDue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setFeeDue(List<? extends LoanTradeTransferFeeDueEvent> feeDues) {
			if (feeDues == null)  {
				this.feeDue = new ArrayList<>();
			}
			else {
				this.feeDue = feeDues.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary) {
			if (tradeSummary!=null) this.tradeSummary.add(tradeSummary.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary, int _idx) {
			getIndex(this.tradeSummary, _idx, () -> tradeSummary.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addTradeSummary(List<? extends LoanTradeSummary> tradeSummarys) {
			if (tradeSummarys != null) {
				for (LoanTradeSummary toAdd : tradeSummarys) {
					this.tradeSummary.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setTradeSummary(List<? extends LoanTradeSummary> tradeSummarys) {
			if (tradeSummarys == null)  {
				this.tradeSummary = new ArrayList<>();
			}
			else {
				this.tradeSummary = tradeSummarys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			if (facilityDetailsModel!=null) this.facilityDetailsModel.add(facilityDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel, int _idx) {
			getIndex(this.facilityDetailsModel, _idx, () -> facilityDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels != null) {
				for (FacilityDetailsModel toAdd : facilityDetailsModels) {
					this.facilityDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
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
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanTradeTransferFeeDueNotification build() {
			return new LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationImpl(this);
		}
		
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder prune() {
			super.prune();
			feeDue = feeDue.stream().filter(b->b!=null).<LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeSummary = tradeSummary.stream().filter(b->b!=null).<LoanTradeSummary.LoanTradeSummaryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityDetailsModel = facilityDetailsModel.stream().filter(b->b!=null).<FacilityDetailsModel.FacilityDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFeeDue()!=null && getFeeDue().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeSummary()!=null && getTradeSummary().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder o = (LoanTradeTransferFeeDueNotification.LoanTradeTransferFeeDueNotificationBuilder) other;
			
			merger.mergeRosetta(getFeeDue(), o.getFeeDue(), this::getOrCreateFeeDue);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::getOrCreateTradeSummary);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::getOrCreateFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeDueNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feeDue, _that.getFeeDue())) return false;
			if (!ListEquals.listEquals(tradeSummary, _that.getTradeSummary())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeDue != null ? feeDue.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeDueNotificationBuilder {" +
				"feeDue=" + this.feeDue + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
