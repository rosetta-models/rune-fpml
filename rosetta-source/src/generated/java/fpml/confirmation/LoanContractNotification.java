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
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.LoanContractNotification;
import fpml.confirmation.LoanContractNotification.LoanContractNotificationBuilder;
import fpml.confirmation.LoanContractNotification.LoanContractNotificationBuilderImpl;
import fpml.confirmation.LoanContractNotification.LoanContractNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanContractNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate various loan contract business events.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractNotification", builder=LoanContractNotification.LoanContractNotificationBuilderImpl.class, version="${project.version}")
public interface LoanContractNotification extends AbstractContractNotification {

	LoanContractNotificationMeta metaData = new LoanContractNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AbstractLoanContractEvent getLoanContractEventGroup();
	FacilityDetailsModel getFacilityDetailsModel();
	LoanContractDetailsModel getLoanContractDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanContractNotification build();
	
	LoanContractNotification.LoanContractNotificationBuilder toBuilder();
	
	static LoanContractNotification.LoanContractNotificationBuilder builder() {
		return new LoanContractNotification.LoanContractNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractNotification> getType() {
		return LoanContractNotification.class;
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
		processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanContractEvent.class, getLoanContractEventGroup());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.class, getLoanContractDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractNotificationBuilder extends LoanContractNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder getOrCreateLoanContractEventGroup();
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder getLoanContractEventGroup();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getLoanContractDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanContractNotification.LoanContractNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanContractNotification.LoanContractNotificationBuilder setActualBuild(Integer actualBuild);
		LoanContractNotification.LoanContractNotificationBuilder setHeader(RequestMessageHeader header);
		LoanContractNotification.LoanContractNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanContractNotification.LoanContractNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanContractNotification.LoanContractNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanContractNotification.LoanContractNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanContractNotification.LoanContractNotificationBuilder setNoticeDate(Date noticeDate);
		LoanContractNotification.LoanContractNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment eventPayment0);
		LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		LoanContractNotification.LoanContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		LoanContractNotification.LoanContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		LoanContractNotification.LoanContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		LoanContractNotification.LoanContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		LoanContractNotification.LoanContractNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		LoanContractNotification.LoanContractNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);
		LoanContractNotification.LoanContractNotificationBuilder setLoanContractEventGroup(AbstractLoanContractEvent loanContractEventGroup);
		LoanContractNotification.LoanContractNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanContractNotification.LoanContractNotificationBuilder setLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel);
		LoanContractNotification.LoanContractNotificationBuilder addParty(Party party0);
		LoanContractNotification.LoanContractNotificationBuilder addParty(Party party1, int _idx);
		LoanContractNotification.LoanContractNotificationBuilder addParty(List<? extends Party> party2);
		LoanContractNotification.LoanContractNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanContractEvent.AbstractLoanContractEventBuilder.class, getLoanContractEventGroup());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.LoanContractDetailsModelBuilder.class, getLoanContractDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanContractNotification.LoanContractNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractNotification  ***********************/
	class LoanContractNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements LoanContractNotification {
		private final AbstractLoanContractEvent loanContractEventGroup;
		private final FacilityDetailsModel facilityDetailsModel;
		private final LoanContractDetailsModel loanContractDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanContractNotificationImpl(LoanContractNotification.LoanContractNotificationBuilder builder) {
			super(builder);
			this.loanContractEventGroup = ofNullable(builder.getLoanContractEventGroup()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.loanContractDetailsModel = ofNullable(builder.getLoanContractDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		public AbstractLoanContractEvent getLoanContractEventGroup() {
			return loanContractEventGroup;
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
		public LoanContractNotification build() {
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder toBuilder() {
			LoanContractNotification.LoanContractNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractNotification.LoanContractNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanContractEventGroup()).ifPresent(builder::setLoanContractEventGroup);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLoanContractDetailsModel()).ifPresent(builder::setLoanContractDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractNotification _that = getType().cast(o);
		
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractNotification {" +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractNotification  ***********************/
	class LoanContractNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl  implements LoanContractNotification.LoanContractNotificationBuilder {
	
		protected AbstractLoanContractEvent.AbstractLoanContractEventBuilder loanContractEventGroup;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected LoanContractDetailsModel.LoanContractDetailsModelBuilder loanContractDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanContractNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanContractEventGroup")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder getOrCreateLoanContractEventGroup() {
			AbstractLoanContractEvent.AbstractLoanContractEventBuilder result;
			if (loanContractEventGroup!=null) {
				result = loanContractEventGroup;
			}
			else {
				result = loanContractEventGroup = AbstractLoanContractEvent.builder();
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
		public LoanContractNotification.LoanContractNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanContractNotification.LoanContractNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanContractNotification.LoanContractNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanContractNotification.LoanContractNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanContractNotification.LoanContractNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanContractNotification.LoanContractNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanContractNotification.LoanContractNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanContractNotification.LoanContractNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public LoanContractNotification.LoanContractNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public LoanContractNotification.LoanContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public LoanContractNotification.LoanContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public LoanContractNotification.LoanContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public LoanContractNotification.LoanContractNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOutstandingsPosition")
		public LoanContractNotification.LoanContractNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
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
		@RosettaAttribute("loanContractEventGroup")
		public LoanContractNotification.LoanContractNotificationBuilder setLoanContractEventGroup(AbstractLoanContractEvent loanContractEventGroup) {
			this.loanContractEventGroup = loanContractEventGroup==null?null:loanContractEventGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanContractNotification.LoanContractNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public LoanContractNotification.LoanContractNotificationBuilder setLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel) {
			this.loanContractDetailsModel = loanContractDetailsModel==null?null:loanContractDetailsModel.toBuilder();
			return this;
		}
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanContractNotification.LoanContractNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanContractNotification.LoanContractNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanContractNotification build() {
			return new LoanContractNotification.LoanContractNotificationImpl(this);
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder prune() {
			super.prune();
			if (loanContractEventGroup!=null && !loanContractEventGroup.prune().hasData()) loanContractEventGroup = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			if (loanContractDetailsModel!=null && !loanContractDetailsModel.prune().hasData()) loanContractDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanContractEventGroup()!=null && getLoanContractEventGroup().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLoanContractDetailsModel()!=null && getLoanContractDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanContractNotification.LoanContractNotificationBuilder o = (LoanContractNotification.LoanContractNotificationBuilder) other;
			
			merger.mergeRosetta(getLoanContractEventGroup(), o.getLoanContractEventGroup(), this::setLoanContractEventGroup);
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
		
			LoanContractNotification _that = getType().cast(o);
		
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractNotificationBuilder {" +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
