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
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LcNotification;
import fpml.confirmation.LcNotification.LcNotificationBuilder;
import fpml.confirmation.LcNotification.LcNotificationBuilderImpl;
import fpml.confirmation.LcNotification.LcNotificationImpl;
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LcNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate various letter of credit business events.
 * @version ${project.version}
 */
@RosettaDataType(value="LcNotification", builder=LcNotification.LcNotificationBuilderImpl.class, version="${project.version}")
public interface LcNotification extends AbstractContractNotification {

	LcNotificationMeta metaData = new LcNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AbstractLcEvent getLcEventGroup();
	FacilityDetailsModel getFacilityDetailsModel();
	LetterOfCreditDetailsModel getLetterOfCreditDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LcNotification build();
	
	LcNotification.LcNotificationBuilder toBuilder();
	
	static LcNotification.LcNotificationBuilder builder() {
		return new LcNotification.LcNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcNotification> getType() {
		return LcNotification.class;
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
		processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.class, getLcEventGroup());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("letterOfCreditDetailsModel"), processor, LetterOfCreditDetailsModel.class, getLetterOfCreditDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcNotificationBuilder extends LcNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup();
		AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getOrCreateLetterOfCreditDetailsModel();
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getLetterOfCreditDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LcNotification.LcNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LcNotification.LcNotificationBuilder setActualBuild(Integer actualBuild);
		LcNotification.LcNotificationBuilder setHeader(RequestMessageHeader header);
		LcNotification.LcNotificationBuilder setValidationModel(ValidationModel validationModel);
		LcNotification.LcNotificationBuilder setIsCorrection(Boolean isCorrection);
		LcNotification.LcNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LcNotification.LcNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LcNotification.LcNotificationBuilder setNoticeDate(Date noticeDate);
		LcNotification.LcNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		LcNotification.LcNotificationBuilder addEventPayment(EventPayment eventPayment0);
		LcNotification.LcNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		LcNotification.LcNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		LcNotification.LcNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		LcNotification.LcNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		LcNotification.LcNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		LcNotification.LcNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		LcNotification.LcNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);
		LcNotification.LcNotificationBuilder setLcEventGroup(AbstractLcEvent lcEventGroup);
		LcNotification.LcNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LcNotification.LcNotificationBuilder setLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel);
		LcNotification.LcNotificationBuilder addParty(Party party0);
		LcNotification.LcNotificationBuilder addParty(Party party1, int _idx);
		LcNotification.LcNotificationBuilder addParty(List<? extends Party> party2);
		LcNotification.LcNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.AbstractLcEventBuilder.class, getLcEventGroup());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("letterOfCreditDetailsModel"), processor, LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder.class, getLetterOfCreditDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LcNotification.LcNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LcNotification  ***********************/
	class LcNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements LcNotification {
		private final AbstractLcEvent lcEventGroup;
		private final FacilityDetailsModel facilityDetailsModel;
		private final LetterOfCreditDetailsModel letterOfCreditDetailsModel;
		private final List<? extends Party> party;
		
		protected LcNotificationImpl(LcNotification.LcNotificationBuilder builder) {
			super(builder);
			this.lcEventGroup = ofNullable(builder.getLcEventGroup()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.letterOfCreditDetailsModel = ofNullable(builder.getLetterOfCreditDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		public AbstractLcEvent getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditDetailsModel")
		public LetterOfCreditDetailsModel getLetterOfCreditDetailsModel() {
			return letterOfCreditDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LcNotification build() {
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder toBuilder() {
			LcNotification.LcNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcNotification.LcNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLcEventGroup()).ifPresent(builder::setLcEventGroup);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLetterOfCreditDetailsModel()).ifPresent(builder::setLetterOfCreditDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcNotification _that = getType().cast(o);
		
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(letterOfCreditDetailsModel, _that.getLetterOfCreditDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditDetailsModel != null ? letterOfCreditDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcNotification {" +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"letterOfCreditDetailsModel=" + this.letterOfCreditDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcNotification  ***********************/
	class LcNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl  implements LcNotification.LcNotificationBuilder {
	
		protected AbstractLcEvent.AbstractLcEventBuilder lcEventGroup;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder letterOfCreditDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LcNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lcEventGroup")
		public AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup() {
			AbstractLcEvent.AbstractLcEventBuilder result;
			if (lcEventGroup!=null) {
				result = lcEventGroup;
			}
			else {
				result = lcEventGroup = AbstractLcEvent.builder();
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
		@RosettaAttribute("letterOfCreditDetailsModel")
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getLetterOfCreditDetailsModel() {
			return letterOfCreditDetailsModel;
		}
		
		@Override
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getOrCreateLetterOfCreditDetailsModel() {
			LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder result;
			if (letterOfCreditDetailsModel!=null) {
				result = letterOfCreditDetailsModel;
			}
			else {
				result = letterOfCreditDetailsModel = LetterOfCreditDetailsModel.builder();
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
		public LcNotification.LcNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LcNotification.LcNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LcNotification.LcNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LcNotification.LcNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LcNotification.LcNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LcNotification.LcNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LcNotification.LcNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LcNotification.LcNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public LcNotification.LcNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		@RosettaAttribute("eventPayment")
		public LcNotification.LcNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public LcNotification.LcNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LcNotification.LcNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		@RosettaAttribute("facilityOutstandingsPosition")
		public LcNotification.LcNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public LcNotification.LcNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LcNotification.LcNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
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
		@RosettaAttribute("lcEventGroup")
		public LcNotification.LcNotificationBuilder setLcEventGroup(AbstractLcEvent lcEventGroup) {
			this.lcEventGroup = lcEventGroup==null?null:lcEventGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LcNotification.LcNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditDetailsModel")
		public LcNotification.LcNotificationBuilder setLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel) {
			this.letterOfCreditDetailsModel = letterOfCreditDetailsModel==null?null:letterOfCreditDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public LcNotification.LcNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LcNotification.LcNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LcNotification.LcNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LcNotification build() {
			return new LcNotification.LcNotificationImpl(this);
		}
		
		@Override
		public LcNotification.LcNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcNotification.LcNotificationBuilder prune() {
			super.prune();
			if (lcEventGroup!=null && !lcEventGroup.prune().hasData()) lcEventGroup = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			if (letterOfCreditDetailsModel!=null && !letterOfCreditDetailsModel.prune().hasData()) letterOfCreditDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLcEventGroup()!=null && getLcEventGroup().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLetterOfCreditDetailsModel()!=null && getLetterOfCreditDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcNotification.LcNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcNotification.LcNotificationBuilder o = (LcNotification.LcNotificationBuilder) other;
			
			merger.mergeRosetta(getLcEventGroup(), o.getLcEventGroup(), this::setLcEventGroup);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getLetterOfCreditDetailsModel(), o.getLetterOfCreditDetailsModel(), this::setLetterOfCreditDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcNotification _that = getType().cast(o);
		
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(letterOfCreditDetailsModel, _that.getLetterOfCreditDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditDetailsModel != null ? letterOfCreditDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcNotificationBuilder {" +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"letterOfCreditDetailsModel=" + this.letterOfCreditDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
