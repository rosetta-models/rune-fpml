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
import fpml.confirmation.Borrowing;
import fpml.confirmation.Borrowing.BorrowingBuilder;
import fpml.confirmation.Borrowing.BorrowingBuilderImpl;
import fpml.confirmation.Borrowing.BorrowingImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.ConditionsPrecedentMetEnum;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.BorrowingMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing the fact that a new loan contract (funded borrowing) has been requested by the borrower.
 * @version ${project.version}
 */
@RosettaDataType(value="Borrowing", builder=Borrowing.BorrowingBuilderImpl.class, version="${project.version}")
public interface Borrowing extends AbstractLoanContractEvent {

	BorrowingMeta metaData = new BorrowingMeta();

	/*********************** Getter Methods  ***********************/
	MoneyWithParticipantShare getAmount();
	/**
	 * An enumeration which describes whether the condition precent have been met, not met or been waived. Please note: this field in not required since conditions precedent may not be applicable in certain scenarios.
	 */
	ConditionsPrecedentMetEnum getConditionsPrecedentMet();

	/*********************** Build Methods  ***********************/
	Borrowing build();
	
	Borrowing.BorrowingBuilder toBuilder();
	
	static Borrowing.BorrowingBuilder builder() {
		return new Borrowing.BorrowingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Borrowing> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Borrowing> getType() {
		return Borrowing.class;
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
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("conditionsPrecedentMet"), ConditionsPrecedentMetEnum.class, getConditionsPrecedentMet(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BorrowingBuilder extends Borrowing, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		Borrowing.BorrowingBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		Borrowing.BorrowingBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		Borrowing.BorrowingBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		Borrowing.BorrowingBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		Borrowing.BorrowingBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		Borrowing.BorrowingBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		Borrowing.BorrowingBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		Borrowing.BorrowingBuilder setComment(String comment);
		Borrowing.BorrowingBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		Borrowing.BorrowingBuilder setEffectiveDate(Date effectiveDate);
		Borrowing.BorrowingBuilder setLoanContractReference(LoanContractReference loanContractReference);
		Borrowing.BorrowingBuilder setAmount(MoneyWithParticipantShare amount);
		Borrowing.BorrowingBuilder setConditionsPrecedentMet(ConditionsPrecedentMetEnum conditionsPrecedentMet);

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
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("conditionsPrecedentMet"), ConditionsPrecedentMetEnum.class, getConditionsPrecedentMet(), this);
		}
		

		Borrowing.BorrowingBuilder prune();
	}

	/*********************** Immutable Implementation of Borrowing  ***********************/
	class BorrowingImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements Borrowing {
		private final MoneyWithParticipantShare amount;
		private final ConditionsPrecedentMetEnum conditionsPrecedentMet;
		
		protected BorrowingImpl(Borrowing.BorrowingBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.conditionsPrecedentMet = builder.getConditionsPrecedentMet();
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("conditionsPrecedentMet")
		public ConditionsPrecedentMetEnum getConditionsPrecedentMet() {
			return conditionsPrecedentMet;
		}
		
		@Override
		public Borrowing build() {
			return this;
		}
		
		@Override
		public Borrowing.BorrowingBuilder toBuilder() {
			Borrowing.BorrowingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Borrowing.BorrowingBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getConditionsPrecedentMet()).ifPresent(builder::setConditionsPrecedentMet);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Borrowing _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(conditionsPrecedentMet, _that.getConditionsPrecedentMet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedentMet != null ? conditionsPrecedentMet.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Borrowing {" +
				"amount=" + this.amount + ", " +
				"conditionsPrecedentMet=" + this.conditionsPrecedentMet +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Borrowing  ***********************/
	class BorrowingBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements Borrowing.BorrowingBuilder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected ConditionsPrecedentMetEnum conditionsPrecedentMet;
	
		public BorrowingBuilderImpl() {
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
		@RosettaAttribute("conditionsPrecedentMet")
		public ConditionsPrecedentMetEnum getConditionsPrecedentMet() {
			return conditionsPrecedentMet;
		}
		
		@Override
		public Borrowing.BorrowingBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Borrowing.BorrowingBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Borrowing.BorrowingBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public Borrowing.BorrowingBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Borrowing.BorrowingBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public Borrowing.BorrowingBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public Borrowing.BorrowingBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public Borrowing.BorrowingBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public Borrowing.BorrowingBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public Borrowing.BorrowingBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public Borrowing.BorrowingBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public Borrowing.BorrowingBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("conditionsPrecedentMet")
		public Borrowing.BorrowingBuilder setConditionsPrecedentMet(ConditionsPrecedentMetEnum conditionsPrecedentMet) {
			this.conditionsPrecedentMet = conditionsPrecedentMet==null?null:conditionsPrecedentMet;
			return this;
		}
		
		@Override
		public Borrowing build() {
			return new Borrowing.BorrowingImpl(this);
		}
		
		@Override
		public Borrowing.BorrowingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Borrowing.BorrowingBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getConditionsPrecedentMet()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Borrowing.BorrowingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Borrowing.BorrowingBuilder o = (Borrowing.BorrowingBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getConditionsPrecedentMet(), o.getConditionsPrecedentMet(), this::setConditionsPrecedentMet);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Borrowing _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(conditionsPrecedentMet, _that.getConditionsPrecedentMet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedentMet != null ? conditionsPrecedentMet.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BorrowingBuilder {" +
				"amount=" + this.amount + ", " +
				"conditionsPrecedentMet=" + this.conditionsPrecedentMet +
			'}' + " " + super.toString();
		}
	}
}
