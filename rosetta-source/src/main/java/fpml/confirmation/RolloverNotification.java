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
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.Rollover;
import fpml.confirmation.RolloverNotification;
import fpml.confirmation.RolloverNotification.RolloverNotificationBuilder;
import fpml.confirmation.RolloverNotification.RolloverNotificationBuilderImpl;
import fpml.confirmation.RolloverNotification.RolloverNotificationImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RolloverNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification designed to communicate the combination of business events associated with a rollover transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="RolloverNotification", builder=RolloverNotification.RolloverNotificationBuilderImpl.class, version="${project.version}")
public interface RolloverNotification extends AbstractContractNotification {

	RolloverNotificationMeta metaData = new RolloverNotificationMeta();

	/*********************** Getter Methods  ***********************/
	Rollover getRollover();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	RolloverNotification build();
	
	RolloverNotification.RolloverNotificationBuilder toBuilder();
	
	static RolloverNotification.RolloverNotificationBuilder builder() {
		return new RolloverNotification.RolloverNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RolloverNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RolloverNotification> getType() {
		return RolloverNotification.class;
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
		processRosetta(path.newSubPath("rollover"), processor, Rollover.class, getRollover());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RolloverNotificationBuilder extends RolloverNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		Rollover.RolloverBuilder getOrCreateRollover();
		Rollover.RolloverBuilder getRollover();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		RolloverNotification.RolloverNotificationBuilder setExpectedBuild(Integer expectedBuild);
		RolloverNotification.RolloverNotificationBuilder setActualBuild(Integer actualBuild);
		RolloverNotification.RolloverNotificationBuilder setHeader(RequestMessageHeader header);
		RolloverNotification.RolloverNotificationBuilder setValidationModel(ValidationModel validationModel);
		RolloverNotification.RolloverNotificationBuilder setIsCorrection(Boolean isCorrection);
		RolloverNotification.RolloverNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RolloverNotification.RolloverNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RolloverNotification.RolloverNotificationBuilder setNoticeDate(Date noticeDate);
		RolloverNotification.RolloverNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		RolloverNotification.RolloverNotificationBuilder addEventPayment(EventPayment eventPayment0);
		RolloverNotification.RolloverNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		RolloverNotification.RolloverNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		RolloverNotification.RolloverNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		RolloverNotification.RolloverNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		RolloverNotification.RolloverNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		RolloverNotification.RolloverNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		RolloverNotification.RolloverNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);
		RolloverNotification.RolloverNotificationBuilder setRollover(Rollover rollover);
		RolloverNotification.RolloverNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		RolloverNotification.RolloverNotificationBuilder addParty(Party party0);
		RolloverNotification.RolloverNotificationBuilder addParty(Party party1, int _idx);
		RolloverNotification.RolloverNotificationBuilder addParty(List<? extends Party> party2);
		RolloverNotification.RolloverNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("rollover"), processor, Rollover.RolloverBuilder.class, getRollover());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		RolloverNotification.RolloverNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of RolloverNotification  ***********************/
	class RolloverNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements RolloverNotification {
		private final Rollover rollover;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected RolloverNotificationImpl(RolloverNotification.RolloverNotificationBuilder builder) {
			super(builder);
			this.rollover = ofNullable(builder.getRollover()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rollover")
		public Rollover getRollover() {
			return rollover;
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
		public RolloverNotification build() {
			return this;
		}
		
		@Override
		public RolloverNotification.RolloverNotificationBuilder toBuilder() {
			RolloverNotification.RolloverNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RolloverNotification.RolloverNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRollover()).ifPresent(builder::setRollover);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RolloverNotification _that = getType().cast(o);
		
			if (!Objects.equals(rollover, _that.getRollover())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rollover != null ? rollover.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RolloverNotification {" +
				"rollover=" + this.rollover + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RolloverNotification  ***********************/
	class RolloverNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl  implements RolloverNotification.RolloverNotificationBuilder {
	
		protected Rollover.RolloverBuilder rollover;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public RolloverNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rollover")
		public Rollover.RolloverBuilder getRollover() {
			return rollover;
		}
		
		@Override
		public Rollover.RolloverBuilder getOrCreateRollover() {
			Rollover.RolloverBuilder result;
			if (rollover!=null) {
				result = rollover;
			}
			else {
				result = rollover = Rollover.builder();
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
		public RolloverNotification.RolloverNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RolloverNotification.RolloverNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RolloverNotification.RolloverNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RolloverNotification.RolloverNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RolloverNotification.RolloverNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RolloverNotification.RolloverNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RolloverNotification.RolloverNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public RolloverNotification.RolloverNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public RolloverNotification.RolloverNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public RolloverNotification.RolloverNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public RolloverNotification.RolloverNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public RolloverNotification.RolloverNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public RolloverNotification.RolloverNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public RolloverNotification.RolloverNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public RolloverNotification.RolloverNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public RolloverNotification.RolloverNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOutstandingsPosition")
		public RolloverNotification.RolloverNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
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
		@RosettaAttribute("rollover")
		public RolloverNotification.RolloverNotificationBuilder setRollover(Rollover rollover) {
			this.rollover = rollover==null?null:rollover.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public RolloverNotification.RolloverNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public RolloverNotification.RolloverNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public RolloverNotification.RolloverNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public RolloverNotification.RolloverNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public RolloverNotification.RolloverNotificationBuilder setParty(List<? extends Party> partys) {
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
		public RolloverNotification build() {
			return new RolloverNotification.RolloverNotificationImpl(this);
		}
		
		@Override
		public RolloverNotification.RolloverNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RolloverNotification.RolloverNotificationBuilder prune() {
			super.prune();
			if (rollover!=null && !rollover.prune().hasData()) rollover = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRollover()!=null && getRollover().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RolloverNotification.RolloverNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RolloverNotification.RolloverNotificationBuilder o = (RolloverNotification.RolloverNotificationBuilder) other;
			
			merger.mergeRosetta(getRollover(), o.getRollover(), this::setRollover);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RolloverNotification _that = getType().cast(o);
		
			if (!Objects.equals(rollover, _that.getRollover())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rollover != null ? rollover.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RolloverNotificationBuilder {" +
				"rollover=" + this.rollover + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
