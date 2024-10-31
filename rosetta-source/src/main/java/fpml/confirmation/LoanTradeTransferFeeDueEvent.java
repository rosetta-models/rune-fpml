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
import fpml.confirmation.AbstractLoanTradeEvent;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.LoanTradeTransferFeeDueEvent;
import fpml.confirmation.LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder;
import fpml.confirmation.LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilderImpl;
import fpml.confirmation.LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanTradeTransferFeeDueEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines details related to the admin agent&#39;s determination of transfer fee(s) owed on a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradeTransferFeeDueEvent", builder=LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilderImpl.class, version="${project.version}")
public interface LoanTradeTransferFeeDueEvent extends AbstractLoanTradeEvent {

	LoanTradeTransferFeeDueEventMeta metaData = new LoanTradeTransferFeeDueEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Amount of transfer fee owed to the admin agent for the trade.
	 */
	NonNegativeMoney getAmount();
	/**
	 * The business date on which the transfer fee is due.
	 */
	Date getDueDate();

	/*********************** Build Methods  ***********************/
	LoanTradeTransferFeeDueEvent build();
	
	LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder toBuilder();
	
	static LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder builder() {
		return new LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeTransferFeeDueEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeTransferFeeDueEvent> getType() {
		return LoanTradeTransferFeeDueEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("dueDate"), Date.class, getDueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeTransferFeeDueEventBuilder extends LoanTradeTransferFeeDueEvent, AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setComment(String comment);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setAmount(NonNegativeMoney amount);
		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setDueDate(Date dueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("dueDate"), Date.class, getDueDate(), this);
		}
		

		LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeTransferFeeDueEvent  ***********************/
	class LoanTradeTransferFeeDueEventImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventImpl implements LoanTradeTransferFeeDueEvent {
		private final NonNegativeMoney amount;
		private final Date dueDate;
		
		protected LoanTradeTransferFeeDueEventImpl(LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder builder) {
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
		public LoanTradeTransferFeeDueEvent build() {
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder toBuilder() {
			LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getDueDate()).ifPresent(builder::setDueDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeDueEvent _that = getType().cast(o);
		
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
			return "LoanTradeTransferFeeDueEvent {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeTransferFeeDueEvent  ***********************/
	class LoanTradeTransferFeeDueEventBuilderImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl  implements LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected Date dueDate;
	
		public LoanTradeTransferFeeDueEventBuilderImpl() {
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
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference) {
			this.loanTradeReference = loanTradeReference==null?null:loanTradeReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dueDate")
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder setDueDate(Date dueDate) {
			this.dueDate = dueDate==null?null:dueDate;
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDueEvent build() {
			return new LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventImpl(this);
		}
		
		@Override
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder prune() {
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
		public LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder o = (LoanTradeTransferFeeDueEvent.LoanTradeTransferFeeDueEventBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getDueDate(), o.getDueDate(), this::setDueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeDueEvent _that = getType().cast(o);
		
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
			return "LoanTradeTransferFeeDueEventBuilder {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}
}
