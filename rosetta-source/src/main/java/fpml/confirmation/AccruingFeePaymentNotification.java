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
import fpml.confirmation.AccruingFeePayment;
import fpml.confirmation.AccruingFeePaymentNotification;
import fpml.confirmation.AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder;
import fpml.confirmation.AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilderImpl;
import fpml.confirmation.AccruingFeePaymentNotification.AccruingFeePaymentNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AccruingFeePaymentNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate an accruing fee payment made by the borrower.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingFeePaymentNotification", builder=AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilderImpl.class, version="${project.version}")
public interface AccruingFeePaymentNotification extends AbstractFacilityNotification {

	AccruingFeePaymentNotificationMeta metaData = new AccruingFeePaymentNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AccruingFeePayment getAccruingFeePayment();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	AccruingFeePaymentNotification build();
	
	AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder toBuilder();
	
	static AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder builder() {
		return new AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeePaymentNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeePaymentNotification> getType() {
		return AccruingFeePaymentNotification.class;
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
		processRosetta(path.newSubPath("accruingFeePayment"), processor, AccruingFeePayment.class, getAccruingFeePayment());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeePaymentNotificationBuilder extends AccruingFeePaymentNotification, AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
		AccruingFeePayment.AccruingFeePaymentBuilder getOrCreateAccruingFeePayment();
		AccruingFeePayment.AccruingFeePaymentBuilder getAccruingFeePayment();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setActualBuild(Integer actualBuild);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setHeader(RequestMessageHeader header);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setValidationModel(ValidationModel validationModel);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setIsCorrection(Boolean isCorrection);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setNoticeDate(Date noticeDate);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment0);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setAccruingFeePayment(AccruingFeePayment accruingFeePayment);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addParty(Party party0);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addParty(Party party1, int _idx);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addParty(List<? extends Party> party2);
		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("accruingFeePayment"), processor, AccruingFeePayment.AccruingFeePaymentBuilder.class, getAccruingFeePayment());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeePaymentNotification  ***********************/
	class AccruingFeePaymentNotificationImpl extends AbstractFacilityNotification.AbstractFacilityNotificationImpl implements AccruingFeePaymentNotification {
		private final AccruingFeePayment accruingFeePayment;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected AccruingFeePaymentNotificationImpl(AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder builder) {
			super(builder);
			this.accruingFeePayment = ofNullable(builder.getAccruingFeePayment()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingFeePayment")
		public AccruingFeePayment getAccruingFeePayment() {
			return accruingFeePayment;
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
		public AccruingFeePaymentNotification build() {
			return this;
		}
		
		@Override
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder toBuilder() {
			AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccruingFeePayment()).ifPresent(builder::setAccruingFeePayment);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeePaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeePayment, _that.getAccruingFeePayment())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeePayment != null ? accruingFeePayment.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeePaymentNotification {" +
				"accruingFeePayment=" + this.accruingFeePayment + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeePaymentNotification  ***********************/
	class AccruingFeePaymentNotificationBuilderImpl extends AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl  implements AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder {
	
		protected AccruingFeePayment.AccruingFeePaymentBuilder accruingFeePayment;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public AccruingFeePaymentNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accruingFeePayment")
		public AccruingFeePayment.AccruingFeePaymentBuilder getAccruingFeePayment() {
			return accruingFeePayment;
		}
		
		@Override
		public AccruingFeePayment.AccruingFeePaymentBuilder getOrCreateAccruingFeePayment() {
			AccruingFeePayment.AccruingFeePaymentBuilder result;
			if (accruingFeePayment!=null) {
				result = accruingFeePayment;
			}
			else {
				result = accruingFeePayment = AccruingFeePayment.builder();
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
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		@RosettaAttribute("eventPayment")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition) {
			this.facilityPosition = facilityPosition==null?null:facilityPosition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingFeePayment")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setAccruingFeePayment(AccruingFeePayment accruingFeePayment) {
			this.accruingFeePayment = accruingFeePayment==null?null:accruingFeePayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder setParty(List<? extends Party> partys) {
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
		public AccruingFeePaymentNotification build() {
			return new AccruingFeePaymentNotification.AccruingFeePaymentNotificationImpl(this);
		}
		
		@Override
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder prune() {
			super.prune();
			if (accruingFeePayment!=null && !accruingFeePayment.prune().hasData()) accruingFeePayment = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccruingFeePayment()!=null && getAccruingFeePayment().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder o = (AccruingFeePaymentNotification.AccruingFeePaymentNotificationBuilder) other;
			
			merger.mergeRosetta(getAccruingFeePayment(), o.getAccruingFeePayment(), this::setAccruingFeePayment);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeePaymentNotification _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeePayment, _that.getAccruingFeePayment())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeePayment != null ? accruingFeePayment.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeePaymentNotificationBuilder {" +
				"accruingFeePayment=" + this.accruingFeePayment + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
