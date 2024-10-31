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
import fpml.confirmation.LoanAllocationTransferFeeDueEvent;
import fpml.confirmation.LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder;
import fpml.confirmation.LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilderImpl;
import fpml.confirmation.LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanAllocationTransferFeeDueEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines details related to the admin agent&#39;s determination of transfer fee(s) owed on an allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationTransferFeeDueEvent", builder=LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilderImpl.class, version="${project.version}")
public interface LoanAllocationTransferFeeDueEvent extends AbstractLoanAllocationEvent {

	LoanAllocationTransferFeeDueEventMeta metaData = new LoanAllocationTransferFeeDueEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Amount of transfer fee due to the admin agent for the allocation.
	 */
	NonNegativeMoney getAmount();
	/**
	 * The business date on which the transfer fee is due.
	 */
	Date getDueDate();

	/*********************** Build Methods  ***********************/
	LoanAllocationTransferFeeDueEvent build();
	
	LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder toBuilder();
	
	static LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder builder() {
		return new LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationTransferFeeDueEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationTransferFeeDueEvent> getType() {
		return LoanAllocationTransferFeeDueEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("dueDate"), Date.class, getDueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationTransferFeeDueEventBuilder extends LoanAllocationTransferFeeDueEvent, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setComment(String comment);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addAllocationReference(LoanAllocationReference allocationReference0);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addAllocationReference(LoanAllocationReference allocationReference1, int _idx);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference2);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference3);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setAmount(NonNegativeMoney amount);
		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setDueDate(Date dueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("dueDate"), Date.class, getDueDate(), this);
		}
		

		LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationTransferFeeDueEvent  ***********************/
	class LoanAllocationTransferFeeDueEventImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanAllocationTransferFeeDueEvent {
		private final NonNegativeMoney amount;
		private final Date dueDate;
		
		protected LoanAllocationTransferFeeDueEventImpl(LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.dueDate = builder.getDueDate();
		}
		
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("dueDate")
		public Date getDueDate() {
			return dueDate;
		}
		
		@Override
		public LoanAllocationTransferFeeDueEvent build() {
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder toBuilder() {
			LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getDueDate()).ifPresent(builder::setDueDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeDueEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(dueDate, _that.getDueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (dueDate != null ? dueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeDueEvent {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationTransferFeeDueEvent  ***********************/
	class LoanAllocationTransferFeeDueEventBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl  implements LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected Date dueDate;
	
		public LoanAllocationTransferFeeDueEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dueDate")
		public Date getDueDate() {
			return dueDate;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addAllocationReference(LoanAllocationReference allocationReference) {
			if (allocationReference!=null) this.allocationReference.add(allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addAllocationReference(LoanAllocationReference allocationReference, int _idx) {
			getIndex(this.allocationReference, _idx, () -> allocationReference.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
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
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dueDate")
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder setDueDate(Date dueDate) {
			this.dueDate = dueDate==null?null:dueDate;
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDueEvent build() {
			return new LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventImpl(this);
		}
		
		@Override
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getDueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder o = (LoanAllocationTransferFeeDueEvent.LoanAllocationTransferFeeDueEventBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getDueDate(), o.getDueDate(), this::setDueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeDueEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(dueDate, _that.getDueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (dueDate != null ? dueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeDueEventBuilder {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}
}
