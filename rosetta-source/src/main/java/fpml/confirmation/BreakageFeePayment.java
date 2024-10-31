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
import fpml.confirmation.BreakageCalculatedByEnum;
import fpml.confirmation.BreakageFeePayment;
import fpml.confirmation.BreakageFeePayment.BreakageFeePaymentBuilder;
import fpml.confirmation.BreakageFeePayment.BreakageFeePaymentBuilderImpl;
import fpml.confirmation.BreakageFeePayment.BreakageFeePaymentImpl;
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
import fpml.confirmation.meta.BreakageFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A fee calculated as the cost of breaking financing against a loan contract which is repaid early.
 * @version ${project.version}
 */
@RosettaDataType(value="BreakageFeePayment", builder=BreakageFeePayment.BreakageFeePaymentBuilderImpl.class, version="${project.version}")
public interface BreakageFeePayment extends NonRecurringFeePayment {

	BreakageFeePaymentMeta metaData = new BreakageFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date by which any breakage costs (if applicable) must be submitted by Lenders to the Agent.
	 */
	Date getBreakageFeeClaimDate();
	/**
	 * Where breakage cost is applicable, this enumeration defines who is calculating it - agent bank or lender.
	 */
	BreakageCalculatedByEnum getBreakageFeeCalculatedBy();

	/*********************** Build Methods  ***********************/
	BreakageFeePayment build();
	
	BreakageFeePayment.BreakageFeePaymentBuilder toBuilder();
	
	static BreakageFeePayment.BreakageFeePaymentBuilder builder() {
		return new BreakageFeePayment.BreakageFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BreakageFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BreakageFeePayment> getType() {
		return BreakageFeePayment.class;
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
		processor.processBasic(path.newSubPath("breakageFeeClaimDate"), Date.class, getBreakageFeeClaimDate(), this);
		processor.processBasic(path.newSubPath("breakageFeeCalculatedBy"), BreakageCalculatedByEnum.class, getBreakageFeeCalculatedBy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BreakageFeePaymentBuilder extends BreakageFeePayment, NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
		BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		BreakageFeePayment.BreakageFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		BreakageFeePayment.BreakageFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		BreakageFeePayment.BreakageFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		BreakageFeePayment.BreakageFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		BreakageFeePayment.BreakageFeePaymentBuilder setComment(String comment);
		BreakageFeePayment.BreakageFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		BreakageFeePayment.BreakageFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		BreakageFeePayment.BreakageFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		BreakageFeePayment.BreakageFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		BreakageFeePayment.BreakageFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		BreakageFeePayment.BreakageFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		BreakageFeePayment.BreakageFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		BreakageFeePayment.BreakageFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);
		BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeClaimDate(Date breakageFeeClaimDate);
		BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeCalculatedBy(BreakageCalculatedByEnum breakageFeeCalculatedBy);

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
			processor.processBasic(path.newSubPath("breakageFeeClaimDate"), Date.class, getBreakageFeeClaimDate(), this);
			processor.processBasic(path.newSubPath("breakageFeeCalculatedBy"), BreakageCalculatedByEnum.class, getBreakageFeeCalculatedBy(), this);
		}
		

		BreakageFeePayment.BreakageFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of BreakageFeePayment  ***********************/
	class BreakageFeePaymentImpl extends NonRecurringFeePayment.NonRecurringFeePaymentImpl implements BreakageFeePayment {
		private final Date breakageFeeClaimDate;
		private final BreakageCalculatedByEnum breakageFeeCalculatedBy;
		
		protected BreakageFeePaymentImpl(BreakageFeePayment.BreakageFeePaymentBuilder builder) {
			super(builder);
			this.breakageFeeClaimDate = builder.getBreakageFeeClaimDate();
			this.breakageFeeCalculatedBy = builder.getBreakageFeeCalculatedBy();
		}
		
		@Override
		@RosettaAttribute("breakageFeeClaimDate")
		public Date getBreakageFeeClaimDate() {
			return breakageFeeClaimDate;
		}
		
		@Override
		@RosettaAttribute("breakageFeeCalculatedBy")
		public BreakageCalculatedByEnum getBreakageFeeCalculatedBy() {
			return breakageFeeCalculatedBy;
		}
		
		@Override
		public BreakageFeePayment build() {
			return this;
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder toBuilder() {
			BreakageFeePayment.BreakageFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BreakageFeePayment.BreakageFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBreakageFeeClaimDate()).ifPresent(builder::setBreakageFeeClaimDate);
			ofNullable(getBreakageFeeCalculatedBy()).ifPresent(builder::setBreakageFeeCalculatedBy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BreakageFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(breakageFeeClaimDate, _that.getBreakageFeeClaimDate())) return false;
			if (!Objects.equals(breakageFeeCalculatedBy, _that.getBreakageFeeCalculatedBy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (breakageFeeClaimDate != null ? breakageFeeClaimDate.hashCode() : 0);
			_result = 31 * _result + (breakageFeeCalculatedBy != null ? breakageFeeCalculatedBy.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BreakageFeePayment {" +
				"breakageFeeClaimDate=" + this.breakageFeeClaimDate + ", " +
				"breakageFeeCalculatedBy=" + this.breakageFeeCalculatedBy +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BreakageFeePayment  ***********************/
	class BreakageFeePaymentBuilderImpl extends NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl  implements BreakageFeePayment.BreakageFeePaymentBuilder {
	
		protected Date breakageFeeClaimDate;
		protected BreakageCalculatedByEnum breakageFeeCalculatedBy;
	
		public BreakageFeePaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("breakageFeeClaimDate")
		public Date getBreakageFeeClaimDate() {
			return breakageFeeClaimDate;
		}
		
		@Override
		@RosettaAttribute("breakageFeeCalculatedBy")
		public BreakageCalculatedByEnum getBreakageFeeCalculatedBy() {
			return breakageFeeCalculatedBy;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BreakageFeePayment.BreakageFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BreakageFeePayment.BreakageFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public BreakageFeePayment.BreakageFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public BreakageFeePayment.BreakageFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public BreakageFeePayment.BreakageFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public BreakageFeePayment.BreakageFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public BreakageFeePayment.BreakageFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public BreakageFeePayment.BreakageFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public BreakageFeePayment.BreakageFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public BreakageFeePayment.BreakageFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BreakageFeePayment.BreakageFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public BreakageFeePayment.BreakageFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("breakageFeeClaimDate")
		public BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeClaimDate(Date breakageFeeClaimDate) {
			this.breakageFeeClaimDate = breakageFeeClaimDate==null?null:breakageFeeClaimDate;
			return this;
		}
		@Override
		@RosettaAttribute("breakageFeeCalculatedBy")
		public BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeCalculatedBy(BreakageCalculatedByEnum breakageFeeCalculatedBy) {
			this.breakageFeeCalculatedBy = breakageFeeCalculatedBy==null?null:breakageFeeCalculatedBy;
			return this;
		}
		
		@Override
		public BreakageFeePayment build() {
			return new BreakageFeePayment.BreakageFeePaymentImpl(this);
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBreakageFeeClaimDate()!=null) return true;
			if (getBreakageFeeCalculatedBy()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BreakageFeePayment.BreakageFeePaymentBuilder o = (BreakageFeePayment.BreakageFeePaymentBuilder) other;
			
			
			merger.mergeBasic(getBreakageFeeClaimDate(), o.getBreakageFeeClaimDate(), this::setBreakageFeeClaimDate);
			merger.mergeBasic(getBreakageFeeCalculatedBy(), o.getBreakageFeeCalculatedBy(), this::setBreakageFeeCalculatedBy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BreakageFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(breakageFeeClaimDate, _that.getBreakageFeeClaimDate())) return false;
			if (!Objects.equals(breakageFeeCalculatedBy, _that.getBreakageFeeCalculatedBy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (breakageFeeClaimDate != null ? breakageFeeClaimDate.hashCode() : 0);
			_result = 31 * _result + (breakageFeeCalculatedBy != null ? breakageFeeCalculatedBy.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BreakageFeePaymentBuilder {" +
				"breakageFeeClaimDate=" + this.breakageFeeClaimDate + ", " +
				"breakageFeeCalculatedBy=" + this.breakageFeeCalculatedBy +
			'}' + " " + super.toString();
		}
	}
}
