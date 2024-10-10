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
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.NonRecurringFeePaymentNotification;
import fpml.confirmation.NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder;
import fpml.confirmation.NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilderImpl;
import fpml.confirmation.NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.NonRecurringFeePaymentNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate a non-recurring fee payment made by the borrower.
 * @version ${project.version}
 */
@RosettaDataType(value="NonRecurringFeePaymentNotification", builder=NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilderImpl.class, version="${project.version}")
public interface NonRecurringFeePaymentNotification extends AbstractContractNotification {

	NonRecurringFeePaymentNotificationMeta metaData = new NonRecurringFeePaymentNotificationMeta();

	/*********************** Getter Methods  ***********************/
	NonRecurringFeePayment getFacilityFeePaymentGroup();
	FacilityDetailsModel getFacilityDetailsModel();
	List<? extends LoanContractDetailsModel> getLoanContractDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	NonRecurringFeePaymentNotification build();
	
	NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder toBuilder();
	
	static NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder builder() {
		return new NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonRecurringFeePaymentNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonRecurringFeePaymentNotification> getType() {
		return NonRecurringFeePaymentNotification.class;
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
		processRosetta(path.newSubPath("facilityFeePaymentGroup"), processor, NonRecurringFeePayment.class, getFacilityFeePaymentGroup());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.class, getLoanContractDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonRecurringFeePaymentNotificationBuilder extends NonRecurringFeePaymentNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder getOrCreateFacilityFeePaymentGroup();
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder getFacilityFeePaymentGroup();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel(int _index);
		List<? extends LoanContractDetailsModel.LoanContractDetailsModelBuilder> getLoanContractDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setExpectedBuild(Integer expectedBuild);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setActualBuild(Integer actualBuild);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setHeader(RequestMessageHeader header);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setValidationModel(ValidationModel validationModel);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setIsCorrection(Boolean isCorrection);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setNoticeDate(Date noticeDate);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment0);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setFacilityFeePaymentGroup(NonRecurringFeePayment facilityFeePaymentGroup);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel0);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel1, int _idx);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel2);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel3);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addParty(Party party0);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addParty(Party party1, int _idx);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addParty(List<? extends Party> party2);
		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("facilityFeePaymentGroup"), processor, NonRecurringFeePayment.NonRecurringFeePaymentBuilder.class, getFacilityFeePaymentGroup());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.LoanContractDetailsModelBuilder.class, getLoanContractDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of NonRecurringFeePaymentNotification  ***********************/
	class NonRecurringFeePaymentNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements NonRecurringFeePaymentNotification {
		private final NonRecurringFeePayment facilityFeePaymentGroup;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends LoanContractDetailsModel> loanContractDetailsModel;
		private final List<? extends Party> party;
		
		protected NonRecurringFeePaymentNotificationImpl(NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder builder) {
			super(builder);
			this.facilityFeePaymentGroup = ofNullable(builder.getFacilityFeePaymentGroup()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.loanContractDetailsModel = ofNullable(builder.getLoanContractDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityFeePaymentGroup")
		public NonRecurringFeePayment getFacilityFeePaymentGroup() {
			return facilityFeePaymentGroup;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public List<? extends LoanContractDetailsModel> getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public NonRecurringFeePaymentNotification build() {
			return this;
		}
		
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder toBuilder() {
			NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityFeePaymentGroup()).ifPresent(builder::setFacilityFeePaymentGroup);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLoanContractDetailsModel()).ifPresent(builder::setLoanContractDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonRecurringFeePaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityFeePaymentGroup, _that.getFacilityFeePaymentGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityFeePaymentGroup != null ? facilityFeePaymentGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonRecurringFeePaymentNotification {" +
				"facilityFeePaymentGroup=" + this.facilityFeePaymentGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonRecurringFeePaymentNotification  ***********************/
	class NonRecurringFeePaymentNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl  implements NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder {
	
		protected NonRecurringFeePayment.NonRecurringFeePaymentBuilder facilityFeePaymentGroup;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<LoanContractDetailsModel.LoanContractDetailsModelBuilder> loanContractDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public NonRecurringFeePaymentNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityFeePaymentGroup")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder getFacilityFeePaymentGroup() {
			return facilityFeePaymentGroup;
		}
		
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder getOrCreateFacilityFeePaymentGroup() {
			NonRecurringFeePayment.NonRecurringFeePaymentBuilder result;
			if (facilityFeePaymentGroup!=null) {
				result = facilityFeePaymentGroup;
			}
			else {
				result = facilityFeePaymentGroup = NonRecurringFeePayment.builder();
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
		@RosettaAttribute("loanContractDetailsModel")
		public List<? extends LoanContractDetailsModel.LoanContractDetailsModelBuilder> getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel(int _index) {
		
			if (loanContractDetailsModel==null) {
				this.loanContractDetailsModel = new ArrayList<>();
			}
			LoanContractDetailsModel.LoanContractDetailsModelBuilder result;
			return getIndex(loanContractDetailsModel, _index, () -> {
						LoanContractDetailsModel.LoanContractDetailsModelBuilder newLoanContractDetailsModel = LoanContractDetailsModel.builder();
						return newLoanContractDetailsModel;
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
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOutstandingsPosition")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
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
		@RosettaAttribute("facilityFeePaymentGroup")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setFacilityFeePaymentGroup(NonRecurringFeePayment facilityFeePaymentGroup) {
			this.facilityFeePaymentGroup = facilityFeePaymentGroup==null?null:facilityFeePaymentGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel) {
			if (loanContractDetailsModel!=null) this.loanContractDetailsModel.add(loanContractDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel, int _idx) {
			getIndex(this.loanContractDetailsModel, _idx, () -> loanContractDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
			if (loanContractDetailsModels != null) {
				for (LoanContractDetailsModel toAdd : loanContractDetailsModels) {
					this.loanContractDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractDetailsModel")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
			if (loanContractDetailsModels == null)  {
				this.loanContractDetailsModel = new ArrayList<>();
			}
			else {
				this.loanContractDetailsModel = loanContractDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder setParty(List<? extends Party> partys) {
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
		public NonRecurringFeePaymentNotification build() {
			return new NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationImpl(this);
		}
		
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder prune() {
			super.prune();
			if (facilityFeePaymentGroup!=null && !facilityFeePaymentGroup.prune().hasData()) facilityFeePaymentGroup = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			loanContractDetailsModel = loanContractDetailsModel.stream().filter(b->b!=null).<LoanContractDetailsModel.LoanContractDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityFeePaymentGroup()!=null && getFacilityFeePaymentGroup().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLoanContractDetailsModel()!=null && getLoanContractDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder o = (NonRecurringFeePaymentNotification.NonRecurringFeePaymentNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityFeePaymentGroup(), o.getFacilityFeePaymentGroup(), this::setFacilityFeePaymentGroup);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getLoanContractDetailsModel(), o.getLoanContractDetailsModel(), this::getOrCreateLoanContractDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonRecurringFeePaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityFeePaymentGroup, _that.getFacilityFeePaymentGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityFeePaymentGroup != null ? facilityFeePaymentGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonRecurringFeePaymentNotificationBuilder {" +
				"facilityFeePaymentGroup=" + this.facilityFeePaymentGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
