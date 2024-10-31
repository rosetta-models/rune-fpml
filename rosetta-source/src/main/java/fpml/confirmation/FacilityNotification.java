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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityNotification;
import fpml.confirmation.FacilityNotification.FacilityNotificationBuilder;
import fpml.confirmation.FacilityNotification.FacilityNotificationBuilderImpl;
import fpml.confirmation.FacilityNotification.FacilityNotificationImpl;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.FacilityNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification which can be used to communicate any facility-level business event.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityNotification", builder=FacilityNotification.FacilityNotificationBuilderImpl.class, version="${project.version}")
public interface FacilityNotification extends AbstractFacilityNotification {

	FacilityNotificationMeta metaData = new FacilityNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AbstractFacilityEvent getFacilityEventGroup();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	FacilityNotification build();
	
	FacilityNotification.FacilityNotificationBuilder toBuilder();
	
	static FacilityNotification.FacilityNotificationBuilder builder() {
		return new FacilityNotification.FacilityNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityNotification> getType() {
		return FacilityNotification.class;
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
		processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.class, getFacilityEventGroup());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityNotificationBuilder extends FacilityNotification, AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
		AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup();
		AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		FacilityNotification.FacilityNotificationBuilder setExpectedBuild(Integer expectedBuild);
		FacilityNotification.FacilityNotificationBuilder setActualBuild(Integer actualBuild);
		FacilityNotification.FacilityNotificationBuilder setHeader(RequestMessageHeader header);
		FacilityNotification.FacilityNotificationBuilder setValidationModel(ValidationModel validationModel);
		FacilityNotification.FacilityNotificationBuilder setIsCorrection(Boolean isCorrection);
		FacilityNotification.FacilityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		FacilityNotification.FacilityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		FacilityNotification.FacilityNotificationBuilder setNoticeDate(Date noticeDate);
		FacilityNotification.FacilityNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment eventPayment0);
		FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		FacilityNotification.FacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		FacilityNotification.FacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		FacilityNotification.FacilityNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);
		FacilityNotification.FacilityNotificationBuilder setFacilityEventGroup(AbstractFacilityEvent facilityEventGroup);
		FacilityNotification.FacilityNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		FacilityNotification.FacilityNotificationBuilder addParty(Party party0);
		FacilityNotification.FacilityNotificationBuilder addParty(Party party1, int _idx);
		FacilityNotification.FacilityNotificationBuilder addParty(List<? extends Party> party2);
		FacilityNotification.FacilityNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.AbstractFacilityEventBuilder.class, getFacilityEventGroup());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		FacilityNotification.FacilityNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityNotification  ***********************/
	class FacilityNotificationImpl extends AbstractFacilityNotification.AbstractFacilityNotificationImpl implements FacilityNotification {
		private final AbstractFacilityEvent facilityEventGroup;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected FacilityNotificationImpl(FacilityNotification.FacilityNotificationBuilder builder) {
			super(builder);
			this.facilityEventGroup = ofNullable(builder.getFacilityEventGroup()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		public AbstractFacilityEvent getFacilityEventGroup() {
			return facilityEventGroup;
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
		public FacilityNotification build() {
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder toBuilder() {
			FacilityNotification.FacilityNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityNotification.FacilityNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityEventGroup()).ifPresent(builder::setFacilityEventGroup);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityNotification {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityNotification  ***********************/
	class FacilityNotificationBuilderImpl extends AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl  implements FacilityNotification.FacilityNotificationBuilder {
	
		protected AbstractFacilityEvent.AbstractFacilityEventBuilder facilityEventGroup;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public FacilityNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityEventGroup")
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup() {
			AbstractFacilityEvent.AbstractFacilityEventBuilder result;
			if (facilityEventGroup!=null) {
				result = facilityEventGroup;
			}
			else {
				result = facilityEventGroup = AbstractFacilityEvent.builder();
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
		public FacilityNotification.FacilityNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public FacilityNotification.FacilityNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public FacilityNotification.FacilityNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public FacilityNotification.FacilityNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public FacilityNotification.FacilityNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public FacilityNotification.FacilityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public FacilityNotification.FacilityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public FacilityNotification.FacilityNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public FacilityNotification.FacilityNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		@RosettaAttribute("eventPayment")
		public FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public FacilityNotification.FacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityNotification.FacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public FacilityNotification.FacilityNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition) {
			this.facilityPosition = facilityPosition==null?null:facilityPosition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityEventGroup")
		public FacilityNotification.FacilityNotificationBuilder setFacilityEventGroup(AbstractFacilityEvent facilityEventGroup) {
			this.facilityEventGroup = facilityEventGroup==null?null:facilityEventGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityNotification.FacilityNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public FacilityNotification.FacilityNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public FacilityNotification.FacilityNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityNotification.FacilityNotificationBuilder setParty(List<? extends Party> partys) {
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
		public FacilityNotification build() {
			return new FacilityNotification.FacilityNotificationImpl(this);
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityNotification.FacilityNotificationBuilder prune() {
			super.prune();
			if (facilityEventGroup!=null && !facilityEventGroup.prune().hasData()) facilityEventGroup = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityEventGroup()!=null && getFacilityEventGroup().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityNotification.FacilityNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityNotification.FacilityNotificationBuilder o = (FacilityNotification.FacilityNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityEventGroup(), o.getFacilityEventGroup(), this::setFacilityEventGroup);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityNotificationBuilder {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
