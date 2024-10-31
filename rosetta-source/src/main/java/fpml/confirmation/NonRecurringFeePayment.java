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
import fpml.confirmation.AbstractFacilityContractEvent;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilder;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentImpl;
import fpml.confirmation.meta.NonRecurringFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event describing a non-recurring fee being paid at either the loan contract or facility level.
 * @version ${project.version}
 */
@RosettaDataType(value="NonRecurringFeePayment", builder=NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl.class, version="${project.version}")
public interface NonRecurringFeePayment extends AbstractFacilityContractEvent {

	NonRecurringFeePaymentMeta metaData = new NonRecurringFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	NonRecurringFeePayment build();
	
	NonRecurringFeePayment.NonRecurringFeePaymentBuilder toBuilder();
	
	static NonRecurringFeePayment.NonRecurringFeePaymentBuilder builder() {
		return new NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonRecurringFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonRecurringFeePayment> getType() {
		return NonRecurringFeePayment.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonRecurringFeePaymentBuilder extends NonRecurringFeePayment, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setComment(String comment);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);

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
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		NonRecurringFeePayment.NonRecurringFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of NonRecurringFeePayment  ***********************/
	class NonRecurringFeePaymentImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements NonRecurringFeePayment {
		private final MoneyWithParticipantShare amount;
		
		protected NonRecurringFeePaymentImpl(NonRecurringFeePayment.NonRecurringFeePaymentBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public NonRecurringFeePayment build() {
			return this;
		}
		
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder toBuilder() {
			NonRecurringFeePayment.NonRecurringFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonRecurringFeePayment.NonRecurringFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonRecurringFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonRecurringFeePayment {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonRecurringFeePayment  ***********************/
	class NonRecurringFeePaymentBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl  implements NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
	
		public NonRecurringFeePaymentBuilderImpl() {
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
		@RosettaAttribute("eventIdentifier")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null)  {
				this.loanContractReference = new ArrayList<>();
			}
			else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("amount")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public NonRecurringFeePayment build() {
			return new NonRecurringFeePayment.NonRecurringFeePaymentImpl(this);
		}
		
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonRecurringFeePayment.NonRecurringFeePaymentBuilder o = (NonRecurringFeePayment.NonRecurringFeePaymentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonRecurringFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonRecurringFeePaymentBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
