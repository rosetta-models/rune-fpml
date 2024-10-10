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
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventBuilder;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventBuilderImpl;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventImpl;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LcIssuanceFeePayment;
import fpml.confirmation.LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder;
import fpml.confirmation.LcIssuanceFeePayment.LcIssuanceFeePaymentBuilderImpl;
import fpml.confirmation.LcIssuanceFeePayment.LcIssuanceFeePaymentImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.LcIssuanceFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a letter of credit issuance fee payment.
 * @version ${project.version}
 */
@RosettaDataType(value="LcIssuanceFeePayment", builder=LcIssuanceFeePayment.LcIssuanceFeePaymentBuilderImpl.class, version="${project.version}")
public interface LcIssuanceFeePayment extends AbstractLcEvent {

	LcIssuanceFeePaymentMeta metaData = new LcIssuanceFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique id associated with the loan accrual type.
	 */
	AccrualTypeId getId();
	PeriodModel getPeriodModel();
	MoneyWithParticipantShare getAmount();
	/**
	 * A schedule that incorporates all sub-periods of an accrual calculation.
	 */
	List<? extends AccrualPeriod> getAccrualSchedule();

	/*********************** Build Methods  ***********************/
	LcIssuanceFeePayment build();
	
	LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder toBuilder();
	
	static LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder() {
		return new LcIssuanceFeePayment.LcIssuanceFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcIssuanceFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcIssuanceFeePayment> getType() {
		return LcIssuanceFeePayment.class;
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
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
		processRosetta(path.newSubPath("id"), processor, AccrualTypeId.class, getId());
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.class, getAccrualSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcIssuanceFeePaymentBuilder extends LcIssuanceFeePayment, AbstractLcEvent.AbstractLcEventBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateId();
		AccrualTypeId.AccrualTypeIdBuilder getId();
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int _index);
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule();
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setComment(String comment);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setId(AccrualTypeId id);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setPeriodModel(PeriodModel periodModel);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule0);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule1, int _idx);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule2);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
			processRosetta(path.newSubPath("id"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getId());
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualSchedule());
		}
		

		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LcIssuanceFeePayment  ***********************/
	class LcIssuanceFeePaymentImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcIssuanceFeePayment {
		private final AccrualTypeId id;
		private final PeriodModel periodModel;
		private final MoneyWithParticipantShare amount;
		private final List<? extends AccrualPeriod> accrualSchedule;
		
		protected LcIssuanceFeePaymentImpl(LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder) {
			super(builder);
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accrualSchedule = ofNullable(builder.getAccrualSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		public AccrualTypeId getId() {
			return id;
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
		public LcIssuanceFeePayment build() {
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder toBuilder() {
			LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrualSchedule()).ifPresent(builder::setAccrualSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcIssuanceFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcIssuanceFeePayment {" +
				"id=" + this.id + ", " +
				"periodModel=" + this.periodModel + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcIssuanceFeePayment  ***********************/
	class LcIssuanceFeePaymentBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl  implements LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder id;
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualSchedule = new ArrayList<>();
	
		public LcIssuanceFeePaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public AccrualTypeId.AccrualTypeIdBuilder getId() {
			return id;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = AccrualTypeId.builder();
			}
			
			return result;
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
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setId(AccrualTypeId id) {
			this.id = id==null?null:id.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule) {
			if (accrualSchedule!=null) this.accrualSchedule.add(accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule, int _idx) {
			getIndex(this.accrualSchedule, _idx, () -> accrualSchedule.toBuilder());
			return this;
		}
		@Override 
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules != null) {
				for (AccrualPeriod toAdd : accrualSchedules) {
					this.accrualSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accrualSchedule")
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
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
		public LcIssuanceFeePayment build() {
			return new LcIssuanceFeePayment.LcIssuanceFeePaymentImpl(this);
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder prune() {
			super.prune();
			if (id!=null && !id.prune().hasData()) id = null;
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			accrualSchedule = accrualSchedule.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null && getId().hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrualSchedule()!=null && getAccrualSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder o = (LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
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
		
			LcIssuanceFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcIssuanceFeePaymentBuilder {" +
				"id=" + this.id + ", " +
				"periodModel=" + this.periodModel + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule +
			'}' + " " + super.toString();
		}
	}
}
