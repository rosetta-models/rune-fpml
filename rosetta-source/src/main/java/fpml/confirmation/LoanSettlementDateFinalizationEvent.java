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
import fpml.confirmation.AbstractLoanAllocationEvent;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanSettlementDateFinalizationEvent;
import fpml.confirmation.LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder;
import fpml.confirmation.LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilderImpl;
import fpml.confirmation.LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventImpl;
import fpml.confirmation.Money;
import fpml.confirmation.meta.LoanSettlementDateFinalizationEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event structure defining the trade settlement date.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanSettlementDateFinalizationEvent", builder=LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilderImpl.class, version="${project.version}")
public interface LoanSettlementDateFinalizationEvent extends AbstractLoanAllocationEvent {

	LoanSettlementDateFinalizationEventMeta metaData = new LoanSettlementDateFinalizationEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount settled.
	 */
	Money getAmount();
	/**
	 * The settlement date associated with a single loan trade allocation.
	 */
	Date getSettlementDate();

	/*********************** Build Methods  ***********************/
	LoanSettlementDateFinalizationEvent build();
	
	LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder toBuilder();
	
	static LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder builder() {
		return new LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanSettlementDateFinalizationEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanSettlementDateFinalizationEvent> getType() {
		return LoanSettlementDateFinalizationEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanSettlementDateFinalizationEventBuilder extends LoanSettlementDateFinalizationEvent, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setComment(String comment);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addAllocationReference(LoanAllocationReference allocationReference0);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addAllocationReference(LoanAllocationReference allocationReference1, int _idx);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference2);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference3);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setAmount(Money amount);
		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setSettlementDate(Date settlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
		}
		

		LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanSettlementDateFinalizationEvent  ***********************/
	class LoanSettlementDateFinalizationEventImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanSettlementDateFinalizationEvent {
		private final Money amount;
		private final Date settlementDate;
		
		protected LoanSettlementDateFinalizationEventImpl(LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.settlementDate = builder.getSettlementDate();
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public Date getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public LoanSettlementDateFinalizationEvent build() {
			return this;
		}
		
		@Override
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder toBuilder() {
			LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanSettlementDateFinalizationEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSettlementDateFinalizationEvent {" +
				"amount=" + this.amount + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanSettlementDateFinalizationEvent  ***********************/
	class LoanSettlementDateFinalizationEventBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl  implements LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder {
	
		protected Money.MoneyBuilder amount;
		protected Date settlementDate;
	
		public LoanSettlementDateFinalizationEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public Date getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReference")
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addAllocationReference(LoanAllocationReference allocationReference) {
			if (allocationReference!=null) this.allocationReference.add(allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addAllocationReference(LoanAllocationReference allocationReference, int _idx) {
			getIndex(this.allocationReference, _idx, () -> allocationReference.toBuilder());
			return this;
		}
		@Override 
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences == null)  {
				this.allocationReference = new ArrayList<>();
			}
			else {
				this.allocationReference = allocationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		
		@Override
		public LoanSettlementDateFinalizationEvent build() {
			return new LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventImpl(this);
		}
		
		@Override
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getSettlementDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder o = (LoanSettlementDateFinalizationEvent.LoanSettlementDateFinalizationEventBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanSettlementDateFinalizationEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSettlementDateFinalizationEventBuilder {" +
				"amount=" + this.amount + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}
}
