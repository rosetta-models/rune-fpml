package fpml.confirmation;

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
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilder;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilderImpl;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventImpl;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.AccruingFeePayment;
import fpml.confirmation.AccruingFeePayment.AccruingFeePaymentBuilder;
import fpml.confirmation.AccruingFeePayment.AccruingFeePaymentBuilderImpl;
import fpml.confirmation.AccruingFeePayment.AccruingFeePaymentImpl;
import fpml.confirmation.AccruingFeePaymentSequence;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.AccruingFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event describing an accruing fee payment made at the facility level.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccruingFeePayment", builder=AccruingFeePayment.AccruingFeePaymentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccruingFeePayment extends AbstractFacilityEvent {

	AccruingFeePaymentMeta metaData = new AccruingFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique id associated with the loan accrual type.
	 */
	AccrualTypeId getId();
	PeriodModel getPeriodModel();
	MoneyWithParticipantShare getAmount();
	AccruingFeePaymentSequence getAccruingFeePaymentSequence();

	/*********************** Build Methods  ***********************/
	AccruingFeePayment build();
	
	AccruingFeePayment.AccruingFeePaymentBuilder toBuilder();
	
	static AccruingFeePayment.AccruingFeePaymentBuilder builder() {
		return new AccruingFeePayment.AccruingFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeePayment> getType() {
		return AccruingFeePayment.class;
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
		processRosetta(path.newSubPath("id"), processor, AccrualTypeId.class, getId());
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("accruingFeePaymentSequence"), processor, AccruingFeePaymentSequence.class, getAccruingFeePaymentSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeePaymentBuilder extends AccruingFeePayment, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateId();
		AccrualTypeId.AccrualTypeIdBuilder getId();
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		AccruingFeePaymentSequence.AccruingFeePaymentSequenceBuilder getOrCreateAccruingFeePaymentSequence();
		AccruingFeePaymentSequence.AccruingFeePaymentSequenceBuilder getAccruingFeePaymentSequence();
		AccruingFeePayment.AccruingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AccruingFeePayment.AccruingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AccruingFeePayment.AccruingFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AccruingFeePayment.AccruingFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AccruingFeePayment.AccruingFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AccruingFeePayment.AccruingFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AccruingFeePayment.AccruingFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AccruingFeePayment.AccruingFeePaymentBuilder setComment(String comment);
		AccruingFeePayment.AccruingFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AccruingFeePayment.AccruingFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		AccruingFeePayment.AccruingFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		AccruingFeePayment.AccruingFeePaymentBuilder setId(AccrualTypeId id);
		AccruingFeePayment.AccruingFeePaymentBuilder setPeriodModel(PeriodModel periodModel);
		AccruingFeePayment.AccruingFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);
		AccruingFeePayment.AccruingFeePaymentBuilder setAccruingFeePaymentSequence(AccruingFeePaymentSequence accruingFeePaymentSequence);

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
			processRosetta(path.newSubPath("id"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getId());
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("accruingFeePaymentSequence"), processor, AccruingFeePaymentSequence.AccruingFeePaymentSequenceBuilder.class, getAccruingFeePaymentSequence());
		}
		

		AccruingFeePayment.AccruingFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeePayment  ***********************/
	class AccruingFeePaymentImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingFeePayment {
		private final AccrualTypeId id;
		private final PeriodModel periodModel;
		private final MoneyWithParticipantShare amount;
		private final AccruingFeePaymentSequence accruingFeePaymentSequence;
		
		protected AccruingFeePaymentImpl(AccruingFeePayment.AccruingFeePaymentBuilder builder) {
			super(builder);
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accruingFeePaymentSequence = ofNullable(builder.getAccruingFeePaymentSequence()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("accruingFeePaymentSequence")
		public AccruingFeePaymentSequence getAccruingFeePaymentSequence() {
			return accruingFeePaymentSequence;
		}
		
		@Override
		public AccruingFeePayment build() {
			return this;
		}
		
		@Override
		public AccruingFeePayment.AccruingFeePaymentBuilder toBuilder() {
			AccruingFeePayment.AccruingFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeePayment.AccruingFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccruingFeePaymentSequence()).ifPresent(builder::setAccruingFeePaymentSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accruingFeePaymentSequence, _that.getAccruingFeePaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accruingFeePaymentSequence != null ? accruingFeePaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeePayment {" +
				"id=" + this.id + ", " +
				"periodModel=" + this.periodModel + ", " +
				"amount=" + this.amount + ", " +
				"accruingFeePaymentSequence=" + this.accruingFeePaymentSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeePayment  ***********************/
	class AccruingFeePaymentBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements AccruingFeePayment.AccruingFeePaymentBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder id;
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected AccruingFeePaymentSequence.AccruingFeePaymentSequenceBuilder accruingFeePaymentSequence;
	
		public AccruingFeePaymentBuilderImpl() {
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
		@RosettaAttribute("accruingFeePaymentSequence")
		public AccruingFeePaymentSequence.AccruingFeePaymentSequenceBuilder getAccruingFeePaymentSequence() {
			return accruingFeePaymentSequence;
		}
		
		@Override
		public AccruingFeePaymentSequence.AccruingFeePaymentSequenceBuilder getOrCreateAccruingFeePaymentSequence() {
			AccruingFeePaymentSequence.AccruingFeePaymentSequenceBuilder result;
			if (accruingFeePaymentSequence!=null) {
				result = accruingFeePaymentSequence;
			}
			else {
				result = accruingFeePaymentSequence = AccruingFeePaymentSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public AccruingFeePayment.AccruingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeePayment.AccruingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeePayment.AccruingFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingFeePayment.AccruingFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AccruingFeePayment.AccruingFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AccruingFeePayment.AccruingFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AccruingFeePayment.AccruingFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AccruingFeePayment.AccruingFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AccruingFeePayment.AccruingFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AccruingFeePayment.AccruingFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AccruingFeePayment.AccruingFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AccruingFeePayment.AccruingFeePaymentBuilder setId(AccrualTypeId id) {
			this.id = id==null?null:id.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public AccruingFeePayment.AccruingFeePaymentBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public AccruingFeePayment.AccruingFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingFeePaymentSequence")
		public AccruingFeePayment.AccruingFeePaymentBuilder setAccruingFeePaymentSequence(AccruingFeePaymentSequence accruingFeePaymentSequence) {
			this.accruingFeePaymentSequence = accruingFeePaymentSequence==null?null:accruingFeePaymentSequence.toBuilder();
			return this;
		}
		
		@Override
		public AccruingFeePayment build() {
			return new AccruingFeePayment.AccruingFeePaymentImpl(this);
		}
		
		@Override
		public AccruingFeePayment.AccruingFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeePayment.AccruingFeePaymentBuilder prune() {
			super.prune();
			if (id!=null && !id.prune().hasData()) id = null;
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (accruingFeePaymentSequence!=null && !accruingFeePaymentSequence.prune().hasData()) accruingFeePaymentSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null && getId().hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccruingFeePaymentSequence()!=null && getAccruingFeePaymentSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeePayment.AccruingFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingFeePayment.AccruingFeePaymentBuilder o = (AccruingFeePayment.AccruingFeePaymentBuilder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccruingFeePaymentSequence(), o.getAccruingFeePaymentSequence(), this::setAccruingFeePaymentSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accruingFeePaymentSequence, _that.getAccruingFeePaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accruingFeePaymentSequence != null ? accruingFeePaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeePaymentBuilder {" +
				"id=" + this.id + ", " +
				"periodModel=" + this.periodModel + ", " +
				"amount=" + this.amount + ", " +
				"accruingFeePaymentSequence=" + this.accruingFeePaymentSequence +
			'}' + " " + super.toString();
		}
	}
}
