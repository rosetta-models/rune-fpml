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
import fpml.confirmation.InterestCapitalization;
import fpml.confirmation.InterestCapitalization.InterestCapitalizationBuilder;
import fpml.confirmation.InterestCapitalization.InterestCapitalizationBuilderImpl;
import fpml.confirmation.InterestCapitalization.InterestCapitalizationImpl;
import fpml.confirmation.InterestCapitalizationSequence;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.InterestCapitalizationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing the lender-specific capitalization of interest amounts for a given accrual period against a single loan contract.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestCapitalization", builder=InterestCapitalization.InterestCapitalizationBuilderImpl.class, version="${project.version}")
public interface InterestCapitalization extends AbstractLoanContractEvent {

	InterestCapitalizationMeta metaData = new InterestCapitalizationMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();
	/**
	 * Defines the way in which the agent bank is allocating cash/PIK interest - can be (i) pro-rata at the time of the interest payment/PIK or (ii) based on the loan contract share throughout the interest period (which is the preferred method).
	 */
	InterestCalculationMethodEnum getCalculationMethod();
	MoneyWithParticipantShare getAmount();
	InterestCapitalizationSequence getInterestCapitalizationSequence();

	/*********************** Build Methods  ***********************/
	InterestCapitalization build();
	
	InterestCapitalization.InterestCapitalizationBuilder toBuilder();
	
	static InterestCapitalization.InterestCapitalizationBuilder builder() {
		return new InterestCapitalization.InterestCapitalizationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestCapitalization> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestCapitalization> getType() {
		return InterestCapitalization.class;
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
		processRosetta(path.newSubPath("interestCapitalizationSequence"), processor, InterestCapitalizationSequence.class, getInterestCapitalizationSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestCapitalizationBuilder extends InterestCapitalization, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder getOrCreateInterestCapitalizationSequence();
		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder getInterestCapitalizationSequence();
		InterestCapitalization.InterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		InterestCapitalization.InterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		InterestCapitalization.InterestCapitalizationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		InterestCapitalization.InterestCapitalizationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		InterestCapitalization.InterestCapitalizationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		InterestCapitalization.InterestCapitalizationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		InterestCapitalization.InterestCapitalizationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		InterestCapitalization.InterestCapitalizationBuilder setComment(String comment);
		InterestCapitalization.InterestCapitalizationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		InterestCapitalization.InterestCapitalizationBuilder setEffectiveDate(Date effectiveDate);
		InterestCapitalization.InterestCapitalizationBuilder setLoanContractReference(LoanContractReference loanContractReference);
		InterestCapitalization.InterestCapitalizationBuilder setPeriodModel(PeriodModel periodModel);
		InterestCapitalization.InterestCapitalizationBuilder setCalculationMethod(InterestCalculationMethodEnum calculationMethod);
		InterestCapitalization.InterestCapitalizationBuilder setAmount(MoneyWithParticipantShare amount);
		InterestCapitalization.InterestCapitalizationBuilder setInterestCapitalizationSequence(InterestCapitalizationSequence interestCapitalizationSequence);

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
			processRosetta(path.newSubPath("interestCapitalizationSequence"), processor, InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder.class, getInterestCapitalizationSequence());
		}
		

		InterestCapitalization.InterestCapitalizationBuilder prune();
	}

	/*********************** Immutable Implementation of InterestCapitalization  ***********************/
	class InterestCapitalizationImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements InterestCapitalization {
		private final PeriodModel periodModel;
		private final InterestCalculationMethodEnum calculationMethod;
		private final MoneyWithParticipantShare amount;
		private final InterestCapitalizationSequence interestCapitalizationSequence;
		
		protected InterestCapitalizationImpl(InterestCapitalization.InterestCapitalizationBuilder builder) {
			super(builder);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.calculationMethod = builder.getCalculationMethod();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.interestCapitalizationSequence = ofNullable(builder.getInterestCapitalizationSequence()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("interestCapitalizationSequence")
		public InterestCapitalizationSequence getInterestCapitalizationSequence() {
			return interestCapitalizationSequence;
		}
		
		@Override
		public InterestCapitalization build() {
			return this;
		}
		
		@Override
		public InterestCapitalization.InterestCapitalizationBuilder toBuilder() {
			InterestCapitalization.InterestCapitalizationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestCapitalization.InterestCapitalizationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getCalculationMethod()).ifPresent(builder::setCalculationMethod);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getInterestCapitalizationSequence()).ifPresent(builder::setInterestCapitalizationSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestCapitalization _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(interestCapitalizationSequence, _that.getInterestCapitalizationSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (interestCapitalizationSequence != null ? interestCapitalizationSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCapitalization {" +
				"periodModel=" + this.periodModel + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"interestCapitalizationSequence=" + this.interestCapitalizationSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestCapitalization  ***********************/
	class InterestCapitalizationBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements InterestCapitalization.InterestCapitalizationBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected InterestCalculationMethodEnum calculationMethod;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder interestCapitalizationSequence;
	
		public InterestCapitalizationBuilderImpl() {
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
		@RosettaAttribute("interestCapitalizationSequence")
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder getInterestCapitalizationSequence() {
			return interestCapitalizationSequence;
		}
		
		@Override
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder getOrCreateInterestCapitalizationSequence() {
			InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder result;
			if (interestCapitalizationSequence!=null) {
				result = interestCapitalizationSequence;
			}
			else {
				result = interestCapitalizationSequence = InterestCapitalizationSequence.builder();
			}
			
			return result;
		}
		
		@Override
		public InterestCapitalization.InterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public InterestCapitalization.InterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public InterestCapitalization.InterestCapitalizationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public InterestCapitalization.InterestCapitalizationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public InterestCapitalization.InterestCapitalizationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public InterestCapitalization.InterestCapitalizationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public InterestCapitalization.InterestCapitalizationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public InterestCapitalization.InterestCapitalizationBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public InterestCapitalization.InterestCapitalizationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public InterestCapitalization.InterestCapitalizationBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public InterestCapitalization.InterestCapitalizationBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public InterestCapitalization.InterestCapitalizationBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationMethod")
		public InterestCapitalization.InterestCapitalizationBuilder setCalculationMethod(InterestCalculationMethodEnum calculationMethod) {
			this.calculationMethod = calculationMethod==null?null:calculationMethod;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public InterestCapitalization.InterestCapitalizationBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestCapitalizationSequence")
		public InterestCapitalization.InterestCapitalizationBuilder setInterestCapitalizationSequence(InterestCapitalizationSequence interestCapitalizationSequence) {
			this.interestCapitalizationSequence = interestCapitalizationSequence==null?null:interestCapitalizationSequence.toBuilder();
			return this;
		}
		
		@Override
		public InterestCapitalization build() {
			return new InterestCapitalization.InterestCapitalizationImpl(this);
		}
		
		@Override
		public InterestCapitalization.InterestCapitalizationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCapitalization.InterestCapitalizationBuilder prune() {
			super.prune();
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (interestCapitalizationSequence!=null && !interestCapitalizationSequence.prune().hasData()) interestCapitalizationSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getCalculationMethod()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getInterestCapitalizationSequence()!=null && getInterestCapitalizationSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCapitalization.InterestCapitalizationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestCapitalization.InterestCapitalizationBuilder o = (InterestCapitalization.InterestCapitalizationBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getInterestCapitalizationSequence(), o.getInterestCapitalizationSequence(), this::setInterestCapitalizationSequence);
			
			merger.mergeBasic(getCalculationMethod(), o.getCalculationMethod(), this::setCalculationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestCapitalization _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(interestCapitalizationSequence, _that.getInterestCapitalizationSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (interestCapitalizationSequence != null ? interestCapitalizationSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCapitalizationBuilder {" +
				"periodModel=" + this.periodModel + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"interestCapitalizationSequence=" + this.interestCapitalizationSequence +
			'}' + " " + super.toString();
		}
	}
}
