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
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanAllocationTransferFeeDueEvent;
import fpml.confirmation.LoanAllocationTransferFeeDueNotification;
import fpml.confirmation.LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder;
import fpml.confirmation.LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilderImpl;
import fpml.confirmation.LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationImpl;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAllocationTransferFeeDueNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate transfer fee details, from admin agent to counterparty.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationTransferFeeDueNotification", builder=LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilderImpl.class, version="${project.version}")
public interface LoanAllocationTransferFeeDueNotification extends AbstractLoanAllocationPaymentNotification {

	LoanAllocationTransferFeeDueNotificationMeta metaData = new LoanAllocationTransferFeeDueNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to indicate the transfer fee due at the allocation level.
	 */
	List<? extends LoanAllocationTransferFeeDueEvent> getFeeDue();
	List<? extends LoanTradeAllocationDetailsModel> getLoanTradeAllocationDetailsModel();
	List<? extends FacilityDetailsModel> getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationTransferFeeDueNotification build();
	
	LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder toBuilder();
	
	static LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder builder() {
		return new LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationTransferFeeDueNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationTransferFeeDueNotification> getType() {
		return LoanAllocationTransferFeeDueNotification.class;
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
		processRosetta(path.newSubPath("feeDue"), processor, LoanAllocationTransferFeeDueEvent.class, getFeeDue());
		processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.class, getLoanTradeAllocationDetailsModel());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationTransferFeeDueNotificationBuilder extends LoanAllocationTransferFeeDueNotification, AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder {
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder getOrCreateFeeDue(int _index);
		List<? extends LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder> getFeeDue();
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder getOrCreateLoanTradeAllocationDetailsModel(int _index);
		List<? extends LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> getLoanTradeAllocationDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index);
		List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setActualBuild(Integer actualBuild);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setHeader(RequestMessageHeader header);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setNoticeDate(Date noticeDate);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addPayment(LoanAllocationPayment payment0);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addPayment(LoanAllocationPayment payment1, int _idx);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payment2);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payment3);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFeeDue(LoanAllocationTransferFeeDueEvent feeDue0);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFeeDue(LoanAllocationTransferFeeDueEvent feeDue1, int _idx);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFeeDue(List<? extends LoanAllocationTransferFeeDueEvent> feeDue2);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setFeeDue(List<? extends LoanAllocationTransferFeeDueEvent> feeDue3);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel0);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel1, int _idx);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel2);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel3);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel0);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel1, int _idx);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel2);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel3);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addParty(Party party0);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addParty(Party party1, int _idx);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addParty(List<? extends Party> party2);
		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("feeDue"), processor, LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder.class, getFeeDue());
			processRosetta(path.newSubPath("loanTradeAllocationDetailsModel"), processor, LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder.class, getLoanTradeAllocationDetailsModel());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationTransferFeeDueNotification  ***********************/
	class LoanAllocationTransferFeeDueNotificationImpl extends AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationImpl implements LoanAllocationTransferFeeDueNotification {
		private final List<? extends LoanAllocationTransferFeeDueEvent> feeDue;
		private final List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModel;
		private final List<? extends FacilityDetailsModel> facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanAllocationTransferFeeDueNotificationImpl(LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder builder) {
			super(builder);
			this.feeDue = ofNullable(builder.getFeeDue()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanTradeAllocationDetailsModel = ofNullable(builder.getLoanTradeAllocationDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feeDue")
		public List<? extends LoanAllocationTransferFeeDueEvent> getFeeDue() {
			return feeDue;
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
		public LoanAllocationTransferFeeDueNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder toBuilder() {
			LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFeeDue()).ifPresent(builder::setFeeDue);
			ofNullable(getLoanTradeAllocationDetailsModel()).ifPresent(builder::setLoanTradeAllocationDetailsModel);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeDueNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feeDue, _that.getFeeDue())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeDue != null ? feeDue.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeDueNotification {" +
				"feeDue=" + this.feeDue + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationTransferFeeDueNotification  ***********************/
	class LoanAllocationTransferFeeDueNotificationBuilderImpl extends AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilderImpl  implements LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder {
	
		protected List<LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder> feeDue = new ArrayList<>();
		protected List<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder> loanTradeAllocationDetailsModel = new ArrayList<>();
		protected List<FacilityDetailsModel.FacilityDetailsModelBuilder> facilityDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanAllocationTransferFeeDueNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeDue")
		public List<? extends LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder> getFeeDue() {
			return feeDue;
		}
		
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder getOrCreateFeeDue(int _index) {
		
			if (feeDue==null) {
				this.feeDue = new ArrayList<>();
			}
			LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder result;
			return getIndex(feeDue, _index, () -> {
						LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder newFeeDue = LoanAllocationTransferFeeDueEvent.builder();
						return newFeeDue;
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
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addPayment(LoanAllocationPayment payment) {
			if (payment!=null) this.payment.add(payment.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addPayment(LoanAllocationPayment payment, int _idx) {
			getIndex(this.payment, _idx, () -> payment.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments != null) {
				for (LoanAllocationPayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("payment")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payments) {
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
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFeeDue(LoanAllocationTransferFeeDueEvent feeDue) {
			if (feeDue!=null) this.feeDue.add(feeDue.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFeeDue(LoanAllocationTransferFeeDueEvent feeDue, int _idx) {
			getIndex(this.feeDue, _idx, () -> feeDue.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFeeDue(List<? extends LoanAllocationTransferFeeDueEvent> feeDues) {
			if (feeDues != null) {
				for (LoanAllocationTransferFeeDueEvent toAdd : feeDues) {
					this.feeDue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("feeDue")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setFeeDue(List<? extends LoanAllocationTransferFeeDueEvent> feeDues) {
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
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel) {
			if (loanTradeAllocationDetailsModel!=null) this.loanTradeAllocationDetailsModel.add(loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addLoanTradeAllocationDetailsModel(LoanTradeAllocationDetailsModel loanTradeAllocationDetailsModel, int _idx) {
			getIndex(this.loanTradeAllocationDetailsModel, _idx, () -> loanTradeAllocationDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
			if (loanTradeAllocationDetailsModels != null) {
				for (LoanTradeAllocationDetailsModel toAdd : loanTradeAllocationDetailsModels) {
					this.loanTradeAllocationDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanTradeAllocationDetailsModel")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setLoanTradeAllocationDetailsModel(List<? extends LoanTradeAllocationDetailsModel> loanTradeAllocationDetailsModels) {
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
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			if (facilityDetailsModel!=null) this.facilityDetailsModel.add(facilityDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel, int _idx) {
			getIndex(this.facilityDetailsModel, _idx, () -> facilityDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels != null) {
				for (FacilityDetailsModel toAdd : facilityDetailsModels) {
					this.facilityDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityDetailsModel")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
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
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanAllocationTransferFeeDueNotification build() {
			return new LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder prune() {
			super.prune();
			feeDue = feeDue.stream().filter(b->b!=null).<LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanTradeAllocationDetailsModel = loanTradeAllocationDetailsModel.stream().filter(b->b!=null).<LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityDetailsModel = facilityDetailsModel.stream().filter(b->b!=null).<FacilityDetailsModel.FacilityDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFeeDue()!=null && getFeeDue().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanTradeAllocationDetailsModel()!=null && getLoanTradeAllocationDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder o = (LoanAllocationTransferFeeDueNotification.LoanAllocationTransferFeeDueNotificationBuilder) other;
			
			merger.mergeRosetta(getFeeDue(), o.getFeeDue(), this::getOrCreateFeeDue);
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
		
			LoanAllocationTransferFeeDueNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feeDue, _that.getFeeDue())) return false;
			if (!ListEquals.listEquals(loanTradeAllocationDetailsModel, _that.getLoanTradeAllocationDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeDue != null ? feeDue.hashCode() : 0);
			_result = 31 * _result + (loanTradeAllocationDetailsModel != null ? loanTradeAllocationDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeDueNotificationBuilder {" +
				"feeDue=" + this.feeDue + ", " +
				"loanTradeAllocationDetailsModel=" + this.loanTradeAllocationDetailsModel + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
