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
import fpml.confirmation.FacilityFeePaymentGroup;
import fpml.confirmation.FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder;
import fpml.confirmation.FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilderImpl;
import fpml.confirmation.FacilityFeePaymentGroup.FacilityFeePaymentGroupImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilder;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentImpl;
import fpml.confirmation.meta.FacilityFeePaymentGroupMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Head of the substitution group for all facility fee payment events.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityFeePaymentGroup", builder=FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilderImpl.class, version="${project.version}")
public interface FacilityFeePaymentGroup extends NonRecurringFeePayment {

	FacilityFeePaymentGroupMeta metaData = new FacilityFeePaymentGroupMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FacilityFeePaymentGroup build();
	
	FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder toBuilder();
	
	static FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder builder() {
		return new FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityFeePaymentGroup> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityFeePaymentGroup> getType() {
		return FacilityFeePaymentGroup.class;
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
	interface FacilityFeePaymentGroupBuilder extends FacilityFeePaymentGroup, NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setComment(String comment);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setEffectiveDate(Date effectiveDate);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setFacilityReference(FacilityReference facilityReference);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setAmount(MoneyWithParticipantShare amount);

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
		

		FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityFeePaymentGroup  ***********************/
	class FacilityFeePaymentGroupImpl extends NonRecurringFeePayment.NonRecurringFeePaymentImpl implements FacilityFeePaymentGroup {
		
		protected FacilityFeePaymentGroupImpl(FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder builder) {
			super(builder);
		}
		
		@Override
		public FacilityFeePaymentGroup build() {
			return this;
		}
		
		@Override
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder toBuilder() {
			FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder builder) {
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
			return "FacilityFeePaymentGroup {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityFeePaymentGroup  ***********************/
	class FacilityFeePaymentGroupBuilderImpl extends NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl  implements FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder {
	
	
		public FacilityFeePaymentGroupBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public FacilityFeePaymentGroup build() {
			return new FacilityFeePaymentGroup.FacilityFeePaymentGroupImpl(this);
		}
		
		@Override
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder prune() {
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
		public FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder o = (FacilityFeePaymentGroup.FacilityFeePaymentGroupBuilder) other;
			
			
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
			return "FacilityFeePaymentGroupBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
