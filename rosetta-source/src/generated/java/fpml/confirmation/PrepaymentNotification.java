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
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.Prepayment;
import fpml.confirmation.PrepaymentNotification;
import fpml.confirmation.PrepaymentNotification.PrepaymentNotificationBuilder;
import fpml.confirmation.PrepaymentNotification.PrepaymentNotificationBuilderImpl;
import fpml.confirmation.PrepaymentNotification.PrepaymentNotificationImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.PrepaymentNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification designed to communicate the specific business events associated with a pre-payment made by the borrower.
 * @version ${project.version}
 */
@RosettaDataType(value="PrepaymentNotification", builder=PrepaymentNotification.PrepaymentNotificationBuilderImpl.class, version="${project.version}")
public interface PrepaymentNotification extends AbstractContractNotification {

	PrepaymentNotificationMeta metaData = new PrepaymentNotificationMeta();

	/*********************** Getter Methods  ***********************/
	Prepayment getPrepayment();
	FacilityDetailsModel getFacilityDetailsModel();
	LoanContractDetailsModel getLoanContractDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	PrepaymentNotification build();
	
	PrepaymentNotification.PrepaymentNotificationBuilder toBuilder();
	
	static PrepaymentNotification.PrepaymentNotificationBuilder builder() {
		return new PrepaymentNotification.PrepaymentNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrepaymentNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrepaymentNotification> getType() {
		return PrepaymentNotification.class;
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
		processRosetta(path.newSubPath("prepayment"), processor, Prepayment.class, getPrepayment());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.class, getLoanContractDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrepaymentNotificationBuilder extends PrepaymentNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		Prepayment.PrepaymentBuilder getOrCreatePrepayment();
		Prepayment.PrepaymentBuilder getPrepayment();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getLoanContractDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		PrepaymentNotification.PrepaymentNotificationBuilder setExpectedBuild(Integer expectedBuild);
		PrepaymentNotification.PrepaymentNotificationBuilder setActualBuild(Integer actualBuild);
		PrepaymentNotification.PrepaymentNotificationBuilder setHeader(RequestMessageHeader header);
		PrepaymentNotification.PrepaymentNotificationBuilder setValidationModel(ValidationModel validationModel);
		PrepaymentNotification.PrepaymentNotificationBuilder setIsCorrection(Boolean isCorrection);
		PrepaymentNotification.PrepaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		PrepaymentNotification.PrepaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		PrepaymentNotification.PrepaymentNotificationBuilder setNoticeDate(Date noticeDate);
		PrepaymentNotification.PrepaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		PrepaymentNotification.PrepaymentNotificationBuilder addEventPayment(EventPayment eventPayment0);
		PrepaymentNotification.PrepaymentNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		PrepaymentNotification.PrepaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		PrepaymentNotification.PrepaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		PrepaymentNotification.PrepaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		PrepaymentNotification.PrepaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		PrepaymentNotification.PrepaymentNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		PrepaymentNotification.PrepaymentNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);
		PrepaymentNotification.PrepaymentNotificationBuilder setPrepayment(Prepayment prepayment);
		PrepaymentNotification.PrepaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		PrepaymentNotification.PrepaymentNotificationBuilder setLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel);
		PrepaymentNotification.PrepaymentNotificationBuilder addParty(Party party0);
		PrepaymentNotification.PrepaymentNotificationBuilder addParty(Party party1, int _idx);
		PrepaymentNotification.PrepaymentNotificationBuilder addParty(List<? extends Party> party2);
		PrepaymentNotification.PrepaymentNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("prepayment"), processor, Prepayment.PrepaymentBuilder.class, getPrepayment());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.LoanContractDetailsModelBuilder.class, getLoanContractDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		PrepaymentNotification.PrepaymentNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of PrepaymentNotification  ***********************/
	class PrepaymentNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements PrepaymentNotification {
		private final Prepayment prepayment;
		private final FacilityDetailsModel facilityDetailsModel;
		private final LoanContractDetailsModel loanContractDetailsModel;
		private final List<? extends Party> party;
		
		protected PrepaymentNotificationImpl(PrepaymentNotification.PrepaymentNotificationBuilder builder) {
			super(builder);
			this.prepayment = ofNullable(builder.getPrepayment()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.loanContractDetailsModel = ofNullable(builder.getLoanContractDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("prepayment")
		public Prepayment getPrepayment() {
			return prepayment;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public LoanContractDetailsModel getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public PrepaymentNotification build() {
			return this;
		}
		
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder toBuilder() {
			PrepaymentNotification.PrepaymentNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrepaymentNotification.PrepaymentNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrepayment()).ifPresent(builder::setPrepayment);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLoanContractDetailsModel()).ifPresent(builder::setLoanContractDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PrepaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(prepayment, _that.getPrepayment())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prepayment != null ? prepayment.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrepaymentNotification {" +
				"prepayment=" + this.prepayment + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PrepaymentNotification  ***********************/
	class PrepaymentNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl  implements PrepaymentNotification.PrepaymentNotificationBuilder {
	
		protected Prepayment.PrepaymentBuilder prepayment;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected LoanContractDetailsModel.LoanContractDetailsModelBuilder loanContractDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public PrepaymentNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("prepayment")
		public Prepayment.PrepaymentBuilder getPrepayment() {
			return prepayment;
		}
		
		@Override
		public Prepayment.PrepaymentBuilder getOrCreatePrepayment() {
			Prepayment.PrepaymentBuilder result;
			if (prepayment!=null) {
				result = prepayment;
			}
			else {
				result = prepayment = Prepayment.builder();
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
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		@Override
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel() {
			LoanContractDetailsModel.LoanContractDetailsModelBuilder result;
			if (loanContractDetailsModel!=null) {
				result = loanContractDetailsModel;
			}
			else {
				result = loanContractDetailsModel = LoanContractDetailsModel.builder();
			}
			
			return result;
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
		public PrepaymentNotification.PrepaymentNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public PrepaymentNotification.PrepaymentNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public PrepaymentNotification.PrepaymentNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public PrepaymentNotification.PrepaymentNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public PrepaymentNotification.PrepaymentNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public PrepaymentNotification.PrepaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public PrepaymentNotification.PrepaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public PrepaymentNotification.PrepaymentNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public PrepaymentNotification.PrepaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public PrepaymentNotification.PrepaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public PrepaymentNotification.PrepaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public PrepaymentNotification.PrepaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public PrepaymentNotification.PrepaymentNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOutstandingsPosition")
		public PrepaymentNotification.PrepaymentNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
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
		@RosettaAttribute("prepayment")
		public PrepaymentNotification.PrepaymentNotificationBuilder setPrepayment(Prepayment prepayment) {
			this.prepayment = prepayment==null?null:prepayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public PrepaymentNotification.PrepaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public PrepaymentNotification.PrepaymentNotificationBuilder setLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel) {
			this.loanContractDetailsModel = loanContractDetailsModel==null?null:loanContractDetailsModel.toBuilder();
			return this;
		}
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public PrepaymentNotification.PrepaymentNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public PrepaymentNotification.PrepaymentNotificationBuilder setParty(List<? extends Party> partys) {
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
		public PrepaymentNotification build() {
			return new PrepaymentNotification.PrepaymentNotificationImpl(this);
		}
		
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder prune() {
			super.prune();
			if (prepayment!=null && !prepayment.prune().hasData()) prepayment = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			if (loanContractDetailsModel!=null && !loanContractDetailsModel.prune().hasData()) loanContractDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPrepayment()!=null && getPrepayment().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLoanContractDetailsModel()!=null && getLoanContractDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrepaymentNotification.PrepaymentNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PrepaymentNotification.PrepaymentNotificationBuilder o = (PrepaymentNotification.PrepaymentNotificationBuilder) other;
			
			merger.mergeRosetta(getPrepayment(), o.getPrepayment(), this::setPrepayment);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getLoanContractDetailsModel(), o.getLoanContractDetailsModel(), this::setLoanContractDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PrepaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(prepayment, _that.getPrepayment())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prepayment != null ? prepayment.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrepaymentNotificationBuilder {" +
				"prepayment=" + this.prepayment + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
