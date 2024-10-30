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
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractFacilityNotification;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilder;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationImpl;
import fpml.confirmation.AccruingFeeChangeNotification;
import fpml.confirmation.AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder;
import fpml.confirmation.AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilderImpl;
import fpml.confirmation.AccruingFeeChangeNotification.AccruingFeeChangeNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AccruingFeeChangeNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate a change in an accruing fee option. These options define the rates/calculations associated with facility-level accruing fees.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccruingFeeChangeNotification", builder=AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccruingFeeChangeNotification extends AbstractFacilityNotification {

	AccruingFeeChangeNotificationMeta metaData = new AccruingFeeChangeNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AbstractFacilityEvent getAccruingFeeChangeGroup();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	AccruingFeeChangeNotification build();
	
	AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder toBuilder();
	
	static AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder builder() {
		return new AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeChangeNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeeChangeNotification> getType() {
		return AccruingFeeChangeNotification.class;
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
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
		processRosetta(path.newSubPath("accruingFeeChangeGroup"), processor, AbstractFacilityEvent.class, getAccruingFeeChangeGroup());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeChangeNotificationBuilder extends AccruingFeeChangeNotification, AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
		AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateAccruingFeeChangeGroup();
		AbstractFacilityEvent.AbstractFacilityEventBuilder getAccruingFeeChangeGroup();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setActualBuild(Integer actualBuild);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setHeader(RequestMessageHeader header);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setValidationModel(ValidationModel validationModel);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setIsCorrection(Boolean isCorrection);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setNoticeDate(Date noticeDate);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addEventPayment(EventPayment eventPayment0);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setAccruingFeeChangeGroup(AbstractFacilityEvent accruingFeeChangeGroup);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addParty(Party party0);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addParty(Party party1, int _idx);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addParty(List<? extends Party> party2);
		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
			processRosetta(path.newSubPath("accruingFeeChangeGroup"), processor, AbstractFacilityEvent.AbstractFacilityEventBuilder.class, getAccruingFeeChangeGroup());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeChangeNotification  ***********************/
	class AccruingFeeChangeNotificationImpl extends AbstractFacilityNotification.AbstractFacilityNotificationImpl implements AccruingFeeChangeNotification {
		private final AbstractFacilityEvent accruingFeeChangeGroup;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected AccruingFeeChangeNotificationImpl(AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder builder) {
			super(builder);
			this.accruingFeeChangeGroup = ofNullable(builder.getAccruingFeeChangeGroup()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingFeeChangeGroup")
		public AbstractFacilityEvent getAccruingFeeChangeGroup() {
			return accruingFeeChangeGroup;
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
		public AccruingFeeChangeNotification build() {
			return this;
		}
		
		@Override
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder toBuilder() {
			AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccruingFeeChangeGroup()).ifPresent(builder::setAccruingFeeChangeGroup);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeChangeNotification _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeChangeGroup, _that.getAccruingFeeChangeGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeChangeGroup != null ? accruingFeeChangeGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChangeNotification {" +
				"accruingFeeChangeGroup=" + this.accruingFeeChangeGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeChangeNotification  ***********************/
	class AccruingFeeChangeNotificationBuilderImpl extends AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl  implements AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder {
	
		protected AbstractFacilityEvent.AbstractFacilityEventBuilder accruingFeeChangeGroup;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public AccruingFeeChangeNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accruingFeeChangeGroup")
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getAccruingFeeChangeGroup() {
			return accruingFeeChangeGroup;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateAccruingFeeChangeGroup() {
			AbstractFacilityEvent.AbstractFacilityEventBuilder result;
			if (accruingFeeChangeGroup!=null) {
				result = accruingFeeChangeGroup;
			}
			else {
				result = accruingFeeChangeGroup = AbstractFacilityEvent.builder();
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
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		@RosettaAttribute("eventPayment")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		@RosettaAttribute("facilityPosition")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition) {
			this.facilityPosition = facilityPosition==null?null:facilityPosition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingFeeChangeGroup")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setAccruingFeeChangeGroup(AbstractFacilityEvent accruingFeeChangeGroup) {
			this.accruingFeeChangeGroup = accruingFeeChangeGroup==null?null:accruingFeeChangeGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder setParty(List<? extends Party> partys) {
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
		public AccruingFeeChangeNotification build() {
			return new AccruingFeeChangeNotification.AccruingFeeChangeNotificationImpl(this);
		}
		
		@Override
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder prune() {
			super.prune();
			if (accruingFeeChangeGroup!=null && !accruingFeeChangeGroup.prune().hasData()) accruingFeeChangeGroup = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccruingFeeChangeGroup()!=null && getAccruingFeeChangeGroup().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder o = (AccruingFeeChangeNotification.AccruingFeeChangeNotificationBuilder) other;
			
			merger.mergeRosetta(getAccruingFeeChangeGroup(), o.getAccruingFeeChangeGroup(), this::setAccruingFeeChangeGroup);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeChangeNotification _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeChangeGroup, _that.getAccruingFeeChangeGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeChangeGroup != null ? accruingFeeChangeGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChangeNotificationBuilder {" +
				"accruingFeeChangeGroup=" + this.accruingFeeChangeGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
