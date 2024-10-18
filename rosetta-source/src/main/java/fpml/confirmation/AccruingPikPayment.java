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
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilder;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilderImpl;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventImpl;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.AccruingPikPayment.AccruingPikPaymentBuilder;
import fpml.confirmation.AccruingPikPayment.AccruingPikPaymentBuilderImpl;
import fpml.confirmation.AccruingPikPayment.AccruingPikPaymentImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.AccruingPikPaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a payment to facilitate capitalization of interest on all outstanding contracts against a particular facility.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingPikPayment", builder=AccruingPikPayment.AccruingPikPaymentBuilderImpl.class, version="${project.version}")
public interface AccruingPikPayment extends AbstractFacilityEvent {

	AccruingPikPaymentMeta metaData = new AccruingPikPaymentMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();
	MoneyWithParticipantShare getAmount();
	/**
	 * A schedule that incorporates all sub-periods of an accrual calculation.
	 */
	List<? extends AccrualPeriod> getAccrualSchedule();

	/*********************** Build Methods  ***********************/
	AccruingPikPayment build();
	
	AccruingPikPayment.AccruingPikPaymentBuilder toBuilder();
	
	static AccruingPikPayment.AccruingPikPaymentBuilder builder() {
		return new AccruingPikPayment.AccruingPikPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingPikPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingPikPayment> getType() {
		return AccruingPikPayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.class, getAccrualSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingPikPaymentBuilder extends AccruingPikPayment, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int _index);
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule();
		AccruingPikPayment.AccruingPikPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AccruingPikPayment.AccruingPikPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AccruingPikPayment.AccruingPikPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AccruingPikPayment.AccruingPikPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AccruingPikPayment.AccruingPikPaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AccruingPikPayment.AccruingPikPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AccruingPikPayment.AccruingPikPaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AccruingPikPayment.AccruingPikPaymentBuilder setComment(String comment);
		AccruingPikPayment.AccruingPikPaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AccruingPikPayment.AccruingPikPaymentBuilder setEffectiveDate(Date effectiveDate);
		AccruingPikPayment.AccruingPikPaymentBuilder setFacilityReference(FacilityReference facilityReference);
		AccruingPikPayment.AccruingPikPaymentBuilder setPeriodModel(PeriodModel periodModel);
		AccruingPikPayment.AccruingPikPaymentBuilder setAmount(MoneyWithParticipantShare amount);
		AccruingPikPayment.AccruingPikPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule0);
		AccruingPikPayment.AccruingPikPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule1, int _idx);
		AccruingPikPayment.AccruingPikPaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule2);
		AccruingPikPayment.AccruingPikPaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualSchedule());
		}
		

		AccruingPikPayment.AccruingPikPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingPikPayment  ***********************/
	class AccruingPikPaymentImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingPikPayment {
		private final PeriodModel periodModel;
		private final MoneyWithParticipantShare amount;
		private final List<? extends AccrualPeriod> accrualSchedule;
		
		protected AccruingPikPaymentImpl(AccruingPikPayment.AccruingPikPaymentBuilder builder) {
			super(builder);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accrualSchedule = ofNullable(builder.getAccrualSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("accrualSchedule")
		public List<? extends AccrualPeriod> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		@Override
		public AccruingPikPayment build() {
			return this;
		}
		
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder toBuilder() {
			AccruingPikPayment.AccruingPikPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingPikPayment.AccruingPikPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrualSchedule()).ifPresent(builder::setAccrualSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikPayment _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikPayment {" +
				"periodModel=" + this.periodModel + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingPikPayment  ***********************/
	class AccruingPikPaymentBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements AccruingPikPayment.AccruingPikPaymentBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualSchedule = new ArrayList<>();
	
		public AccruingPikPaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel.PeriodModelBuilder getPeriodModel() {
			return periodModel;
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder getOrCreatePeriodModel() {
			PeriodModel.PeriodModelBuilder result;
			if (periodModel!=null) {
				result = periodModel;
			}
			else {
				result = periodModel = PeriodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualSchedule")
		public List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int _index) {
		
			if (accrualSchedule==null) {
				this.accrualSchedule = new ArrayList<>();
			}
			AccrualPeriod.AccrualPeriodBuilder result;
			return getIndex(accrualSchedule, _index, () -> {
						AccrualPeriod.AccrualPeriodBuilder newAccrualSchedule = AccrualPeriod.builder();
						return newAccrualSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public AccruingPikPayment.AccruingPikPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AccruingPikPayment.AccruingPikPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingPikPayment.AccruingPikPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public AccruingPikPayment.AccruingPikPaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AccruingPikPayment.AccruingPikPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AccruingPikPayment.AccruingPikPaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AccruingPikPayment.AccruingPikPaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AccruingPikPayment.AccruingPikPaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AccruingPikPayment.AccruingPikPaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AccruingPikPayment.AccruingPikPaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public AccruingPikPayment.AccruingPikPaymentBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public AccruingPikPayment.AccruingPikPaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrualSchedule")
		public AccruingPikPayment.AccruingPikPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule) {
			if (accrualSchedule!=null) this.accrualSchedule.add(accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule, int _idx) {
			getIndex(this.accrualSchedule, _idx, () -> accrualSchedule.toBuilder());
			return this;
		}
		@Override 
		public AccruingPikPayment.AccruingPikPaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules != null) {
				for (AccrualPeriod toAdd : accrualSchedules) {
					this.accrualSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingPikPayment.AccruingPikPaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules == null)  {
				this.accrualSchedule = new ArrayList<>();
			}
			else {
				this.accrualSchedule = accrualSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AccruingPikPayment build() {
			return new AccruingPikPayment.AccruingPikPaymentImpl(this);
		}
		
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder prune() {
			super.prune();
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			accrualSchedule = accrualSchedule.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrualSchedule()!=null && getAccrualSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingPikPayment.AccruingPikPaymentBuilder o = (AccruingPikPayment.AccruingPikPaymentBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccrualSchedule(), o.getAccrualSchedule(), this::getOrCreateAccrualSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikPayment _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikPaymentBuilder {" +
				"periodModel=" + this.periodModel + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule +
			'}' + " " + super.toString();
		}
	}
}
