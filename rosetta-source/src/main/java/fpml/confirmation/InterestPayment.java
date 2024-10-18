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
import fpml.confirmation.InterestCalculationMethodEnum;
import fpml.confirmation.InterestPayment;
import fpml.confirmation.InterestPayment.InterestPaymentBuilder;
import fpml.confirmation.InterestPayment.InterestPaymentBuilderImpl;
import fpml.confirmation.InterestPayment.InterestPaymentImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.LoanInterestPayment;
import fpml.confirmation.LoanInterestPayment.LoanInterestPaymentBuilder;
import fpml.confirmation.LoanInterestPayment.LoanInterestPaymentBuilderImpl;
import fpml.confirmation.LoanInterestPayment.LoanInterestPaymentImpl;
import fpml.confirmation.LoanInterestPaymentSequence;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.InterestPaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestPayment", builder=InterestPayment.InterestPaymentBuilderImpl.class, version="${project.version}")
public interface InterestPayment extends LoanInterestPayment {

	InterestPaymentMeta metaData = new InterestPaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	InterestPayment build();
	
	InterestPayment.InterestPaymentBuilder toBuilder();
	
	static InterestPayment.InterestPaymentBuilder builder() {
		return new InterestPayment.InterestPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestPayment> getType() {
		return InterestPayment.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processor.processBasic(path.newSubPath("calculationMethod"), InterestCalculationMethodEnum.class, getCalculationMethod(), this);
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("loanInterestPaymentSequence"), processor, LoanInterestPaymentSequence.class, getLoanInterestPaymentSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestPaymentBuilder extends InterestPayment, LoanInterestPayment.LoanInterestPaymentBuilder {
		InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		InterestPayment.InterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		InterestPayment.InterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		InterestPayment.InterestPaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		InterestPayment.InterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		InterestPayment.InterestPaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		InterestPayment.InterestPaymentBuilder setComment(String comment);
		InterestPayment.InterestPaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		InterestPayment.InterestPaymentBuilder setEffectiveDate(Date effectiveDate);
		InterestPayment.InterestPaymentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		InterestPayment.InterestPaymentBuilder setPeriodModel(PeriodModel periodModel);
		InterestPayment.InterestPaymentBuilder setCalculationMethod(InterestCalculationMethodEnum calculationMethod);
		InterestPayment.InterestPaymentBuilder setAmount(MoneyWithParticipantShare amount);
		InterestPayment.InterestPaymentBuilder setLoanInterestPaymentSequence(LoanInterestPaymentSequence loanInterestPaymentSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processor.processBasic(path.newSubPath("calculationMethod"), InterestCalculationMethodEnum.class, getCalculationMethod(), this);
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("loanInterestPaymentSequence"), processor, LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder.class, getLoanInterestPaymentSequence());
		}
		

		InterestPayment.InterestPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of InterestPayment  ***********************/
	class InterestPaymentImpl extends LoanInterestPayment.LoanInterestPaymentImpl implements InterestPayment {
		
		protected InterestPaymentImpl(InterestPayment.InterestPaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public InterestPayment build() {
			return this;
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder toBuilder() {
			InterestPayment.InterestPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestPayment.InterestPaymentBuilder builder) {
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
			return "InterestPayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestPayment  ***********************/
	class InterestPaymentBuilderImpl extends LoanInterestPayment.LoanInterestPaymentBuilderImpl  implements InterestPayment.InterestPaymentBuilder {
	
	
		public InterestPaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public InterestPayment.InterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InterestPayment.InterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public InterestPayment.InterestPaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public InterestPayment.InterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public InterestPayment.InterestPaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public InterestPayment.InterestPaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public InterestPayment.InterestPaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public InterestPayment.InterestPaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public InterestPayment.InterestPaymentBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public InterestPayment.InterestPaymentBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationMethod")
		public InterestPayment.InterestPaymentBuilder setCalculationMethod(InterestCalculationMethodEnum calculationMethod) {
			this.calculationMethod = calculationMethod==null?null:calculationMethod;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public InterestPayment.InterestPaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanInterestPaymentSequence")
		public InterestPayment.InterestPaymentBuilder setLoanInterestPaymentSequence(LoanInterestPaymentSequence loanInterestPaymentSequence) {
			this.loanInterestPaymentSequence = loanInterestPaymentSequence==null?null:loanInterestPaymentSequence.toBuilder();
			return this;
		}
		
		@Override
		public InterestPayment build() {
			return new InterestPayment.InterestPaymentImpl(this);
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestPayment.InterestPaymentBuilder prune() {
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
		public InterestPayment.InterestPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestPayment.InterestPaymentBuilder o = (InterestPayment.InterestPaymentBuilder) other;
			
			
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
			return "InterestPaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
