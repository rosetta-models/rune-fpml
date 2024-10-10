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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.FundingFeePayment;
import fpml.confirmation.FundingFeePayment.FundingFeePaymentBuilder;
import fpml.confirmation.FundingFeePayment.FundingFeePaymentBuilderImpl;
import fpml.confirmation.FundingFeePayment.FundingFeePaymentImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilder;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentImpl;
import fpml.confirmation.meta.FundingFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A fee associated with the funding requirements for given facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FundingFeePayment", builder=FundingFeePayment.FundingFeePaymentBuilderImpl.class, version="${project.version}")
public interface FundingFeePayment extends NonRecurringFeePayment {

	FundingFeePaymentMeta metaData = new FundingFeePaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FundingFeePayment build();
	
	FundingFeePayment.FundingFeePaymentBuilder toBuilder();
	
	static FundingFeePayment.FundingFeePaymentBuilder builder() {
		return new FundingFeePayment.FundingFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FundingFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FundingFeePayment> getType() {
		return FundingFeePayment.class;
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
	interface FundingFeePaymentBuilder extends FundingFeePayment, NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
		FundingFeePayment.FundingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FundingFeePayment.FundingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FundingFeePayment.FundingFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FundingFeePayment.FundingFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FundingFeePayment.FundingFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FundingFeePayment.FundingFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FundingFeePayment.FundingFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FundingFeePayment.FundingFeePaymentBuilder setComment(String comment);
		FundingFeePayment.FundingFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FundingFeePayment.FundingFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		FundingFeePayment.FundingFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		FundingFeePayment.FundingFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		FundingFeePayment.FundingFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		FundingFeePayment.FundingFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		FundingFeePayment.FundingFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		FundingFeePayment.FundingFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);

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
		

		FundingFeePayment.FundingFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of FundingFeePayment  ***********************/
	class FundingFeePaymentImpl extends NonRecurringFeePayment.NonRecurringFeePaymentImpl implements FundingFeePayment {
		
		protected FundingFeePaymentImpl(FundingFeePayment.FundingFeePaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public FundingFeePayment build() {
			return this;
		}
		
		@Override
		public FundingFeePayment.FundingFeePaymentBuilder toBuilder() {
			FundingFeePayment.FundingFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FundingFeePayment.FundingFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "FundingFeePayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FundingFeePayment  ***********************/
	class FundingFeePaymentBuilderImpl extends NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl  implements FundingFeePayment.FundingFeePaymentBuilder {
	
	
		public FundingFeePaymentBuilderImpl() {
		}
	
		@Override
		public FundingFeePayment.FundingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FundingFeePayment.FundingFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FundingFeePayment.FundingFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public FundingFeePayment.FundingFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FundingFeePayment.FundingFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FundingFeePayment.FundingFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FundingFeePayment.FundingFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FundingFeePayment.FundingFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FundingFeePayment.FundingFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FundingFeePayment.FundingFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FundingFeePayment.FundingFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public FundingFeePayment.FundingFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public FundingFeePayment.FundingFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public FundingFeePayment.FundingFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public FundingFeePayment.FundingFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public FundingFeePayment.FundingFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public FundingFeePayment build() {
			return new FundingFeePayment.FundingFeePaymentImpl(this);
		}
		
		@Override
		public FundingFeePayment.FundingFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FundingFeePayment.FundingFeePaymentBuilder prune() {
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
		public FundingFeePayment.FundingFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FundingFeePayment.FundingFeePaymentBuilder o = (FundingFeePayment.FundingFeePaymentBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "FundingFeePaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
