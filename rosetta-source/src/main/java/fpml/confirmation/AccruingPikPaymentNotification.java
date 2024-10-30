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
import fpml.confirmation.AbstractFacilityNotification;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilder;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationImpl;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.AccruingPikPaymentNotification;
import fpml.confirmation.AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder;
import fpml.confirmation.AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilderImpl;
import fpml.confirmation.AccruingPikPaymentNotification.AccruingPikPaymentNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AccruingPikPaymentNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate an accruing PIK rate being capitalized by the borrower.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccruingPikPaymentNotification", builder=AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccruingPikPaymentNotification extends AbstractFacilityNotification {

	AccruingPikPaymentNotificationMeta metaData = new AccruingPikPaymentNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AccruingPikPayment getAccruingPikPayment();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	AccruingPikPaymentNotification build();
	
	AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder toBuilder();
	
	static AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder builder() {
		return new AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingPikPaymentNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingPikPaymentNotification> getType() {
		return AccruingPikPaymentNotification.class;
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
		processRosetta(path.newSubPath("accruingPikPayment"), processor, AccruingPikPayment.class, getAccruingPikPayment());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingPikPaymentNotificationBuilder extends AccruingPikPaymentNotification, AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
		AccruingPikPayment.AccruingPikPaymentBuilder getOrCreateAccruingPikPayment();
		AccruingPikPayment.AccruingPikPaymentBuilder getAccruingPikPayment();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setActualBuild(Integer actualBuild);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setHeader(RequestMessageHeader header);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setValidationModel(ValidationModel validationModel);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setIsCorrection(Boolean isCorrection);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setNoticeDate(Date noticeDate);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addEventPayment(EventPayment eventPayment0);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setAccruingPikPayment(AccruingPikPayment accruingPikPayment);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addParty(Party party0);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addParty(Party party1, int _idx);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addParty(List<? extends Party> party2);
		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("accruingPikPayment"), processor, AccruingPikPayment.AccruingPikPaymentBuilder.class, getAccruingPikPayment());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingPikPaymentNotification  ***********************/
	class AccruingPikPaymentNotificationImpl extends AbstractFacilityNotification.AbstractFacilityNotificationImpl implements AccruingPikPaymentNotification {
		private final AccruingPikPayment accruingPikPayment;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected AccruingPikPaymentNotificationImpl(AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder builder) {
			super(builder);
			this.accruingPikPayment = ofNullable(builder.getAccruingPikPayment()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingPikPayment")
		public AccruingPikPayment getAccruingPikPayment() {
			return accruingPikPayment;
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
		public AccruingPikPaymentNotification build() {
			return this;
		}
		
		@Override
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder toBuilder() {
			AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccruingPikPayment()).ifPresent(builder::setAccruingPikPayment);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikPaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(accruingPikPayment, _that.getAccruingPikPayment())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingPikPayment != null ? accruingPikPayment.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikPaymentNotification {" +
				"accruingPikPayment=" + this.accruingPikPayment + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingPikPaymentNotification  ***********************/
	class AccruingPikPaymentNotificationBuilderImpl extends AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl  implements AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder {
	
		protected AccruingPikPayment.AccruingPikPaymentBuilder accruingPikPayment;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public AccruingPikPaymentNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accruingPikPayment")
		public AccruingPikPayment.AccruingPikPaymentBuilder getAccruingPikPayment() {
			return accruingPikPayment;
		}
		
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder getOrCreateAccruingPikPayment() {
			AccruingPikPayment.AccruingPikPaymentBuilder result;
			if (accruingPikPayment!=null) {
				result = accruingPikPayment;
			}
			else {
				result = accruingPikPayment = AccruingPikPayment.builder();
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
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		@RosettaAttribute("eventPayment")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition) {
			this.facilityPosition = facilityPosition==null?null:facilityPosition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingPikPayment")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setAccruingPikPayment(AccruingPikPayment accruingPikPayment) {
			this.accruingPikPayment = accruingPikPayment==null?null:accruingPikPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder setParty(List<? extends Party> partys) {
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
		public AccruingPikPaymentNotification build() {
			return new AccruingPikPaymentNotification.AccruingPikPaymentNotificationImpl(this);
		}
		
		@Override
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder prune() {
			super.prune();
			if (accruingPikPayment!=null && !accruingPikPayment.prune().hasData()) accruingPikPayment = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccruingPikPayment()!=null && getAccruingPikPayment().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder o = (AccruingPikPaymentNotification.AccruingPikPaymentNotificationBuilder) other;
			
			merger.mergeRosetta(getAccruingPikPayment(), o.getAccruingPikPayment(), this::setAccruingPikPayment);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikPaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(accruingPikPayment, _that.getAccruingPikPayment())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingPikPayment != null ? accruingPikPayment.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikPaymentNotificationBuilder {" +
				"accruingPikPayment=" + this.accruingPikPayment + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
