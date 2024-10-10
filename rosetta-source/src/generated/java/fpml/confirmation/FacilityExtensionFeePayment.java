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
import fpml.confirmation.FacilityExtensionFeePayment;
import fpml.confirmation.FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder;
import fpml.confirmation.FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilderImpl;
import fpml.confirmation.FacilityExtensionFeePayment.FacilityExtensionFeePaymentImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilder;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentImpl;
import fpml.confirmation.meta.FacilityExtensionFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This fee represents any fee paid by the borrower to the syndicate lenders for extending an existing facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityExtensionFeePayment", builder=FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilderImpl.class, version="${project.version}")
public interface FacilityExtensionFeePayment extends NonRecurringFeePayment {

	FacilityExtensionFeePaymentMeta metaData = new FacilityExtensionFeePaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FacilityExtensionFeePayment build();
	
	FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder toBuilder();
	
	static FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder builder() {
		return new FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityExtensionFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityExtensionFeePayment> getType() {
		return FacilityExtensionFeePayment.class;
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
	interface FacilityExtensionFeePaymentBuilder extends FacilityExtensionFeePayment, NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setComment(String comment);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);

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
		

		FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityExtensionFeePayment  ***********************/
	class FacilityExtensionFeePaymentImpl extends NonRecurringFeePayment.NonRecurringFeePaymentImpl implements FacilityExtensionFeePayment {
		
		protected FacilityExtensionFeePaymentImpl(FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public FacilityExtensionFeePayment build() {
			return this;
		}
		
		@Override
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder toBuilder() {
			FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder builder) {
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
			return "FacilityExtensionFeePayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityExtensionFeePayment  ***********************/
	class FacilityExtensionFeePaymentBuilderImpl extends NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl  implements FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder {
	
	
		public FacilityExtensionFeePaymentBuilderImpl() {
		}
	
		@Override
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public FacilityExtensionFeePayment build() {
			return new FacilityExtensionFeePayment.FacilityExtensionFeePaymentImpl(this);
		}
		
		@Override
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder prune() {
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
		public FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder o = (FacilityExtensionFeePayment.FacilityExtensionFeePaymentBuilder) other;
			
			
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
			return "FacilityExtensionFeePaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
