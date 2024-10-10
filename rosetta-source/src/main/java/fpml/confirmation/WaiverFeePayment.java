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
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilder;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentImpl;
import fpml.confirmation.WaiverFeePayment;
import fpml.confirmation.WaiverFeePayment.WaiverFeePaymentBuilder;
import fpml.confirmation.WaiverFeePayment.WaiverFeePaymentBuilderImpl;
import fpml.confirmation.WaiverFeePayment.WaiverFeePaymentImpl;
import fpml.confirmation.meta.WaiverFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A fee structure that represents a payment made by the borrower to the syndicate lenders for processing and accepting a waiver request. The request is sent by the borrower to obtain approval from the syndicate lenders formally requesting waivers around particular terms of the credit agreement.
 * @version ${project.version}
 */
@RosettaDataType(value="WaiverFeePayment", builder=WaiverFeePayment.WaiverFeePaymentBuilderImpl.class, version="${project.version}")
public interface WaiverFeePayment extends NonRecurringFeePayment {

	WaiverFeePaymentMeta metaData = new WaiverFeePaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	WaiverFeePayment build();
	
	WaiverFeePayment.WaiverFeePaymentBuilder toBuilder();
	
	static WaiverFeePayment.WaiverFeePaymentBuilder builder() {
		return new WaiverFeePayment.WaiverFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WaiverFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WaiverFeePayment> getType() {
		return WaiverFeePayment.class;
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
	interface WaiverFeePaymentBuilder extends WaiverFeePayment, NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
		WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		WaiverFeePayment.WaiverFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		WaiverFeePayment.WaiverFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		WaiverFeePayment.WaiverFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		WaiverFeePayment.WaiverFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		WaiverFeePayment.WaiverFeePaymentBuilder setComment(String comment);
		WaiverFeePayment.WaiverFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		WaiverFeePayment.WaiverFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		WaiverFeePayment.WaiverFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		WaiverFeePayment.WaiverFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		WaiverFeePayment.WaiverFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		WaiverFeePayment.WaiverFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		WaiverFeePayment.WaiverFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		WaiverFeePayment.WaiverFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);

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
		

		WaiverFeePayment.WaiverFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of WaiverFeePayment  ***********************/
	class WaiverFeePaymentImpl extends NonRecurringFeePayment.NonRecurringFeePaymentImpl implements WaiverFeePayment {
		
		protected WaiverFeePaymentImpl(WaiverFeePayment.WaiverFeePaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public WaiverFeePayment build() {
			return this;
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder toBuilder() {
			WaiverFeePayment.WaiverFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WaiverFeePayment.WaiverFeePaymentBuilder builder) {
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
			return "WaiverFeePayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of WaiverFeePayment  ***********************/
	class WaiverFeePaymentBuilderImpl extends NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl  implements WaiverFeePayment.WaiverFeePaymentBuilder {
	
	
		public WaiverFeePaymentBuilderImpl() {
		}
	
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public WaiverFeePayment.WaiverFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public WaiverFeePayment.WaiverFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public WaiverFeePayment.WaiverFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public WaiverFeePayment.WaiverFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public WaiverFeePayment.WaiverFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public WaiverFeePayment.WaiverFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public WaiverFeePayment.WaiverFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public WaiverFeePayment.WaiverFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public WaiverFeePayment.WaiverFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public WaiverFeePayment.WaiverFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public WaiverFeePayment.WaiverFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public WaiverFeePayment build() {
			return new WaiverFeePayment.WaiverFeePaymentImpl(this);
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder prune() {
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
		public WaiverFeePayment.WaiverFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			WaiverFeePayment.WaiverFeePaymentBuilder o = (WaiverFeePayment.WaiverFeePaymentBuilder) other;
			
			
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
			return "WaiverFeePaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
