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
import fpml.confirmation.AmendmentFeePayment;
import fpml.confirmation.AmendmentFeePayment.AmendmentFeePaymentBuilder;
import fpml.confirmation.AmendmentFeePayment.AmendmentFeePaymentBuilderImpl;
import fpml.confirmation.AmendmentFeePayment.AmendmentFeePaymentImpl;
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
import fpml.confirmation.meta.AmendmentFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A fee charged to the borrower for an amendment being made to the originally agreed credit agreement. The fee is based on a rate (as stated in the agreement) applied to the current commitment level. Calculated as a percentage of the unutilized portion of the facility.
 * @version ${project.version}
 */
@RosettaDataType(value="AmendmentFeePayment", builder=AmendmentFeePayment.AmendmentFeePaymentBuilderImpl.class, version="${project.version}")
public interface AmendmentFeePayment extends NonRecurringFeePayment {

	AmendmentFeePaymentMeta metaData = new AmendmentFeePaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	AmendmentFeePayment build();
	
	AmendmentFeePayment.AmendmentFeePaymentBuilder toBuilder();
	
	static AmendmentFeePayment.AmendmentFeePaymentBuilder builder() {
		return new AmendmentFeePayment.AmendmentFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmendmentFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AmendmentFeePayment> getType() {
		return AmendmentFeePayment.class;
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
	interface AmendmentFeePaymentBuilder extends AmendmentFeePayment, NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
		AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setComment(String comment);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		AmendmentFeePayment.AmendmentFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		AmendmentFeePayment.AmendmentFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		AmendmentFeePayment.AmendmentFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		AmendmentFeePayment.AmendmentFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);

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
		

		AmendmentFeePayment.AmendmentFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of AmendmentFeePayment  ***********************/
	class AmendmentFeePaymentImpl extends NonRecurringFeePayment.NonRecurringFeePaymentImpl implements AmendmentFeePayment {
		
		protected AmendmentFeePaymentImpl(AmendmentFeePayment.AmendmentFeePaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public AmendmentFeePayment build() {
			return this;
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder toBuilder() {
			AmendmentFeePayment.AmendmentFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmendmentFeePayment.AmendmentFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmendmentFeePayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AmendmentFeePayment  ***********************/
	class AmendmentFeePaymentBuilderImpl extends NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl  implements AmendmentFeePayment.AmendmentFeePaymentBuilder {
	
	
		public AmendmentFeePaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public AmendmentFeePayment build() {
			return new AmendmentFeePayment.AmendmentFeePaymentImpl(this);
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AmendmentFeePayment.AmendmentFeePaymentBuilder o = (AmendmentFeePayment.AmendmentFeePaymentBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmendmentFeePaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
