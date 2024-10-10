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
import fpml.confirmation.AbstractContractNotification;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationBuilder;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationBuilderImpl;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LoanBulkServicingNotification;
import fpml.confirmation.LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder;
import fpml.confirmation.LoanBulkServicingNotification.LoanBulkServicingNotificationBuilderImpl;
import fpml.confirmation.LoanBulkServicingNotification.LoanBulkServicingNotificationImpl;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanBulkServicingNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate multiple business events, within a single notification.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanBulkServicingNotification", builder=LoanBulkServicingNotification.LoanBulkServicingNotificationBuilderImpl.class, version="${project.version}")
public interface LoanBulkServicingNotification extends AbstractContractNotification {

	LoanBulkServicingNotificationMeta metaData = new LoanBulkServicingNotificationMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends LoanBulkServicingNotificationChoice0> getLoanBulkServicingNotificationChoice0();
	List<? extends LoanBulkServicingNotificationChoice1> getLoanBulkServicingNotificationChoice1();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotification build();
	
	LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder toBuilder();
	
	static LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder() {
		return new LoanBulkServicingNotification.LoanBulkServicingNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanBulkServicingNotification> getType() {
		return LoanBulkServicingNotification.class;
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
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
		processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.class, getFacilityOutstandingsPosition());
		processRosetta(path.newSubPath("loanBulkServicingNotificationChoice0"), processor, LoanBulkServicingNotificationChoice0.class, getLoanBulkServicingNotificationChoice0());
		processRosetta(path.newSubPath("loanBulkServicingNotificationChoice1"), processor, LoanBulkServicingNotificationChoice1.class, getLoanBulkServicingNotificationChoice1());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationBuilder extends LoanBulkServicingNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder getOrCreateLoanBulkServicingNotificationChoice0(int _index);
		List<? extends LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder> getLoanBulkServicingNotificationChoice0();
		LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder getOrCreateLoanBulkServicingNotificationChoice1(int _index);
		List<? extends LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder> getLoanBulkServicingNotificationChoice1();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setActualBuild(Integer actualBuild);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setHeader(RequestMessageHeader header);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setNoticeDate(Date noticeDate);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment eventPayment0);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice0(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice00);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice0(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice01, int _idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice0(List<? extends LoanBulkServicingNotificationChoice0> loanBulkServicingNotificationChoice02);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationChoice0(List<? extends LoanBulkServicingNotificationChoice0> loanBulkServicingNotificationChoice03);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice1(LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice10);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice1(LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice11, int _idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice1(List<? extends LoanBulkServicingNotificationChoice1> loanBulkServicingNotificationChoice12);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationChoice1(List<? extends LoanBulkServicingNotificationChoice1> loanBulkServicingNotificationChoice13);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party party0);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party party1, int _idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(List<? extends Party> party2);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setParty(List<? extends Party> party3);

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
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
			processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder.class, getFacilityOutstandingsPosition());
			processRosetta(path.newSubPath("loanBulkServicingNotificationChoice0"), processor, LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder.class, getLoanBulkServicingNotificationChoice0());
			processRosetta(path.newSubPath("loanBulkServicingNotificationChoice1"), processor, LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder.class, getLoanBulkServicingNotificationChoice1());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotification  ***********************/
	class LoanBulkServicingNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements LoanBulkServicingNotification {
		private final List<? extends LoanBulkServicingNotificationChoice0> loanBulkServicingNotificationChoice0;
		private final List<? extends LoanBulkServicingNotificationChoice1> loanBulkServicingNotificationChoice1;
		private final List<? extends Party> party;
		
		protected LoanBulkServicingNotificationImpl(LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder) {
			super(builder);
			this.loanBulkServicingNotificationChoice0 = ofNullable(builder.getLoanBulkServicingNotificationChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanBulkServicingNotificationChoice1 = ofNullable(builder.getLoanBulkServicingNotificationChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoice0")
		public List<? extends LoanBulkServicingNotificationChoice0> getLoanBulkServicingNotificationChoice0() {
			return loanBulkServicingNotificationChoice0;
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoice1")
		public List<? extends LoanBulkServicingNotificationChoice1> getLoanBulkServicingNotificationChoice1() {
			return loanBulkServicingNotificationChoice1;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanBulkServicingNotification build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder toBuilder() {
			LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanBulkServicingNotificationChoice0()).ifPresent(builder::setLoanBulkServicingNotificationChoice0);
			ofNullable(getLoanBulkServicingNotificationChoice1()).ifPresent(builder::setLoanBulkServicingNotificationChoice1);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanBulkServicingNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanBulkServicingNotificationChoice0, _that.getLoanBulkServicingNotificationChoice0())) return false;
			if (!ListEquals.listEquals(loanBulkServicingNotificationChoice1, _that.getLoanBulkServicingNotificationChoice1())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanBulkServicingNotificationChoice0 != null ? loanBulkServicingNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationChoice1 != null ? loanBulkServicingNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotification {" +
				"loanBulkServicingNotificationChoice0=" + this.loanBulkServicingNotificationChoice0 + ", " +
				"loanBulkServicingNotificationChoice1=" + this.loanBulkServicingNotificationChoice1 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotification  ***********************/
	class LoanBulkServicingNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl  implements LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder {
	
		protected List<LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder> loanBulkServicingNotificationChoice0 = new ArrayList<>();
		protected List<LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder> loanBulkServicingNotificationChoice1 = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanBulkServicingNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoice0")
		public List<? extends LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder> getLoanBulkServicingNotificationChoice0() {
			return loanBulkServicingNotificationChoice0;
		}
		
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder getOrCreateLoanBulkServicingNotificationChoice0(int _index) {
		
			if (loanBulkServicingNotificationChoice0==null) {
				this.loanBulkServicingNotificationChoice0 = new ArrayList<>();
			}
			LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder result;
			return getIndex(loanBulkServicingNotificationChoice0, _index, () -> {
						LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder newLoanBulkServicingNotificationChoice0 = LoanBulkServicingNotificationChoice0.builder();
						return newLoanBulkServicingNotificationChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoice1")
		public List<? extends LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder> getLoanBulkServicingNotificationChoice1() {
			return loanBulkServicingNotificationChoice1;
		}
		
		public LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder getOrCreateLoanBulkServicingNotificationChoice1(int _index) {
		
			if (loanBulkServicingNotificationChoice1==null) {
				this.loanBulkServicingNotificationChoice1 = new ArrayList<>();
			}
			LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder result;
			return getIndex(loanBulkServicingNotificationChoice1, _index, () -> {
						LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder newLoanBulkServicingNotificationChoice1 = LoanBulkServicingNotificationChoice1.builder();
						return newLoanBulkServicingNotificationChoice1;
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
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null)  {
				this.eventPayment = new ArrayList<>();
			}
			else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOutstandingsPosition")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions == null)  {
				this.facilityOutstandingsPosition = new ArrayList<>();
			}
			else {
				this.facilityOutstandingsPosition = facilityOutstandingsPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice0(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
			if (loanBulkServicingNotificationChoice0!=null) this.loanBulkServicingNotificationChoice0.add(loanBulkServicingNotificationChoice0.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice0(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0, int _idx) {
			getIndex(this.loanBulkServicingNotificationChoice0, _idx, () -> loanBulkServicingNotificationChoice0.toBuilder());
			return this;
		}
		@Override 
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice0(List<? extends LoanBulkServicingNotificationChoice0> loanBulkServicingNotificationChoice0s) {
			if (loanBulkServicingNotificationChoice0s != null) {
				for (LoanBulkServicingNotificationChoice0 toAdd : loanBulkServicingNotificationChoice0s) {
					this.loanBulkServicingNotificationChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanBulkServicingNotificationChoice0")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationChoice0(List<? extends LoanBulkServicingNotificationChoice0> loanBulkServicingNotificationChoice0s) {
			if (loanBulkServicingNotificationChoice0s == null)  {
				this.loanBulkServicingNotificationChoice0 = new ArrayList<>();
			}
			else {
				this.loanBulkServicingNotificationChoice0 = loanBulkServicingNotificationChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice1(LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice1) {
			if (loanBulkServicingNotificationChoice1!=null) this.loanBulkServicingNotificationChoice1.add(loanBulkServicingNotificationChoice1.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice1(LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice1, int _idx) {
			getIndex(this.loanBulkServicingNotificationChoice1, _idx, () -> loanBulkServicingNotificationChoice1.toBuilder());
			return this;
		}
		@Override 
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice1(List<? extends LoanBulkServicingNotificationChoice1> loanBulkServicingNotificationChoice1s) {
			if (loanBulkServicingNotificationChoice1s != null) {
				for (LoanBulkServicingNotificationChoice1 toAdd : loanBulkServicingNotificationChoice1s) {
					this.loanBulkServicingNotificationChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanBulkServicingNotificationChoice1")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationChoice1(List<? extends LoanBulkServicingNotificationChoice1> loanBulkServicingNotificationChoice1s) {
			if (loanBulkServicingNotificationChoice1s == null)  {
				this.loanBulkServicingNotificationChoice1 = new ArrayList<>();
			}
			else {
				this.loanBulkServicingNotificationChoice1 = loanBulkServicingNotificationChoice1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanBulkServicingNotification build() {
			return new LoanBulkServicingNotification.LoanBulkServicingNotificationImpl(this);
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder prune() {
			super.prune();
			loanBulkServicingNotificationChoice0 = loanBulkServicingNotificationChoice0.stream().filter(b->b!=null).<LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanBulkServicingNotificationChoice1 = loanBulkServicingNotificationChoice1.stream().filter(b->b!=null).<LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanBulkServicingNotificationChoice0()!=null && getLoanBulkServicingNotificationChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanBulkServicingNotificationChoice1()!=null && getLoanBulkServicingNotificationChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder o = (LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder) other;
			
			merger.mergeRosetta(getLoanBulkServicingNotificationChoice0(), o.getLoanBulkServicingNotificationChoice0(), this::getOrCreateLoanBulkServicingNotificationChoice0);
			merger.mergeRosetta(getLoanBulkServicingNotificationChoice1(), o.getLoanBulkServicingNotificationChoice1(), this::getOrCreateLoanBulkServicingNotificationChoice1);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanBulkServicingNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanBulkServicingNotificationChoice0, _that.getLoanBulkServicingNotificationChoice0())) return false;
			if (!ListEquals.listEquals(loanBulkServicingNotificationChoice1, _that.getLoanBulkServicingNotificationChoice1())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanBulkServicingNotificationChoice0 != null ? loanBulkServicingNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationChoice1 != null ? loanBulkServicingNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationBuilder {" +
				"loanBulkServicingNotificationChoice0=" + this.loanBulkServicingNotificationChoice0 + ", " +
				"loanBulkServicingNotificationChoice1=" + this.loanBulkServicingNotificationChoice1 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
