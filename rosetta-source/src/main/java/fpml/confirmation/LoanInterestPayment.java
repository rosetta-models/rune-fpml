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
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilder;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.InterestCalculationMethodEnum;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.LoanInterestPayment;
import fpml.confirmation.LoanInterestPayment.LoanInterestPaymentBuilder;
import fpml.confirmation.LoanInterestPayment.LoanInterestPaymentBuilderImpl;
import fpml.confirmation.LoanInterestPayment.LoanInterestPaymentImpl;
import fpml.confirmation.LoanInterestPaymentSequence;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.LoanInterestPaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing the lender-specific payment of interest amounts for a given accrual period against a single loan contract.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanInterestPayment", builder=LoanInterestPayment.LoanInterestPaymentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanInterestPayment extends AbstractLoanContractEvent {

	LoanInterestPaymentMeta metaData = new LoanInterestPaymentMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();
	/**
	 * Defines whether the agent bank is making an interest payment based on the lender pro-rata share at the end of the period (snapshot) or based on the lender position throughout the period (which is the default).
	 */
	InterestCalculationMethodEnum getCalculationMethod();
	MoneyWithParticipantShare getAmount();
	LoanInterestPaymentSequence getLoanInterestPaymentSequence();

	/*********************** Build Methods  ***********************/
	LoanInterestPayment build();
	
	LoanInterestPayment.LoanInterestPaymentBuilder toBuilder();
	
	static LoanInterestPayment.LoanInterestPaymentBuilder builder() {
		return new LoanInterestPayment.LoanInterestPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanInterestPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanInterestPayment> getType() {
		return LoanInterestPayment.class;
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
	interface LoanInterestPaymentBuilder extends LoanInterestPayment, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder getOrCreateLoanInterestPaymentSequence();
		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder getLoanInterestPaymentSequence();
		LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanInterestPayment.LoanInterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanInterestPayment.LoanInterestPaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanInterestPayment.LoanInterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanInterestPayment.LoanInterestPaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanInterestPayment.LoanInterestPaymentBuilder setComment(String comment);
		LoanInterestPayment.LoanInterestPaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LoanInterestPayment.LoanInterestPaymentBuilder setEffectiveDate(Date effectiveDate);
		LoanInterestPayment.LoanInterestPaymentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanInterestPayment.LoanInterestPaymentBuilder setPeriodModel(PeriodModel periodModel);
		LoanInterestPayment.LoanInterestPaymentBuilder setCalculationMethod(InterestCalculationMethodEnum calculationMethod);
		LoanInterestPayment.LoanInterestPaymentBuilder setAmount(MoneyWithParticipantShare amount);
		LoanInterestPayment.LoanInterestPaymentBuilder setLoanInterestPaymentSequence(LoanInterestPaymentSequence loanInterestPaymentSequence);

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
		

		LoanInterestPayment.LoanInterestPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanInterestPayment  ***********************/
	class LoanInterestPaymentImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanInterestPayment {
		private final PeriodModel periodModel;
		private final InterestCalculationMethodEnum calculationMethod;
		private final MoneyWithParticipantShare amount;
		private final LoanInterestPaymentSequence loanInterestPaymentSequence;
		
		protected LoanInterestPaymentImpl(LoanInterestPayment.LoanInterestPaymentBuilder builder) {
			super(builder);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.calculationMethod = builder.getCalculationMethod();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.loanInterestPaymentSequence = ofNullable(builder.getLoanInterestPaymentSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("calculationMethod")
		public InterestCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("loanInterestPaymentSequence")
		public LoanInterestPaymentSequence getLoanInterestPaymentSequence() {
			return loanInterestPaymentSequence;
		}
		
		@Override
		public LoanInterestPayment build() {
			return this;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder toBuilder() {
			LoanInterestPayment.LoanInterestPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanInterestPayment.LoanInterestPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getCalculationMethod()).ifPresent(builder::setCalculationMethod);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getLoanInterestPaymentSequence()).ifPresent(builder::setLoanInterestPaymentSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanInterestPayment _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(loanInterestPaymentSequence, _that.getLoanInterestPaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (loanInterestPaymentSequence != null ? loanInterestPaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanInterestPayment {" +
				"periodModel=" + this.periodModel + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"loanInterestPaymentSequence=" + this.loanInterestPaymentSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanInterestPayment  ***********************/
	class LoanInterestPaymentBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements LoanInterestPayment.LoanInterestPaymentBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected InterestCalculationMethodEnum calculationMethod;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder loanInterestPaymentSequence;
	
		public LoanInterestPaymentBuilderImpl() {
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
		@RosettaAttribute("calculationMethod")
		public InterestCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
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
		@RosettaAttribute("loanInterestPaymentSequence")
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder getLoanInterestPaymentSequence() {
			return loanInterestPaymentSequence;
		}
		
		@Override
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder getOrCreateLoanInterestPaymentSequence() {
			LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder result;
			if (loanInterestPaymentSequence!=null) {
				result = loanInterestPaymentSequence;
			}
			else {
				result = loanInterestPaymentSequence = LoanInterestPaymentSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanInterestPayment.LoanInterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanInterestPayment.LoanInterestPaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanInterestPayment.LoanInterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanInterestPayment.LoanInterestPaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanInterestPayment.LoanInterestPaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LoanInterestPayment.LoanInterestPaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LoanInterestPayment.LoanInterestPaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanInterestPayment.LoanInterestPaymentBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public LoanInterestPayment.LoanInterestPaymentBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationMethod")
		public LoanInterestPayment.LoanInterestPaymentBuilder setCalculationMethod(InterestCalculationMethodEnum calculationMethod) {
			this.calculationMethod = calculationMethod==null?null:calculationMethod;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanInterestPayment.LoanInterestPaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanInterestPaymentSequence")
		public LoanInterestPayment.LoanInterestPaymentBuilder setLoanInterestPaymentSequence(LoanInterestPaymentSequence loanInterestPaymentSequence) {
			this.loanInterestPaymentSequence = loanInterestPaymentSequence==null?null:loanInterestPaymentSequence.toBuilder();
			return this;
		}
		
		@Override
		public LoanInterestPayment build() {
			return new LoanInterestPayment.LoanInterestPaymentImpl(this);
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder prune() {
			super.prune();
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (loanInterestPaymentSequence!=null && !loanInterestPaymentSequence.prune().hasData()) loanInterestPaymentSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getCalculationMethod()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getLoanInterestPaymentSequence()!=null && getLoanInterestPaymentSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanInterestPayment.LoanInterestPaymentBuilder o = (LoanInterestPayment.LoanInterestPaymentBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getLoanInterestPaymentSequence(), o.getLoanInterestPaymentSequence(), this::setLoanInterestPaymentSequence);
			
			merger.mergeBasic(getCalculationMethod(), o.getCalculationMethod(), this::setCalculationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanInterestPayment _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(loanInterestPaymentSequence, _that.getLoanInterestPaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (loanInterestPaymentSequence != null ? loanInterestPaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanInterestPaymentBuilder {" +
				"periodModel=" + this.periodModel + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"loanInterestPaymentSequence=" + this.loanInterestPaymentSequence +
			'}' + " " + super.toString();
		}
	}
}
