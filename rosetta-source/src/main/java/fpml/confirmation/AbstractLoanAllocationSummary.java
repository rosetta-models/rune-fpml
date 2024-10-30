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
import fpml.confirmation.AbstractLoanAllocationSummary;
import fpml.confirmation.AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder;
import fpml.confirmation.AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryImpl;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.Money;
import fpml.confirmation.meta.AbstractLoanAllocationSummaryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An underlying structure defining fundamental allocation event information.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AbstractLoanAllocationSummary", builder=AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AbstractLoanAllocationSummary extends RosettaModelObject {

	AbstractLoanAllocationSummaryMeta metaData = new AbstractLoanAllocationSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique allocation id used to identify the allocation record.
	 */
	LoanAllocationIdentifier getAllocationIdentifier();
	/**
	 * Amount allocated.
	 */
	Money getAmount();
	/**
	 * A freetext field which allows the sender to add further details around the allocation event.
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	AbstractLoanAllocationSummary build();
	
	AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder toBuilder();
	
	static AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder builder() {
		return new AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanAllocationSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanAllocationSummary> getType() {
		return AbstractLoanAllocationSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.class, getAllocationIdentifier());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanAllocationSummaryBuilder extends AbstractLoanAllocationSummary, RosettaModelObjectBuilder {
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationIdentifier();
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getAllocationIdentifier();
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder setAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier);
		AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder setAmount(Money amount);
		AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.LoanAllocationIdentifierBuilder.class, getAllocationIdentifier());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanAllocationSummary  ***********************/
	class AbstractLoanAllocationSummaryImpl implements AbstractLoanAllocationSummary {
		private final LoanAllocationIdentifier allocationIdentifier;
		private final Money amount;
		private final String comment;
		
		protected AbstractLoanAllocationSummaryImpl(AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder builder) {
			this.allocationIdentifier = ofNullable(builder.getAllocationIdentifier()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.comment = builder.getComment();
		}
		
		@Override
		@RosettaAttribute("allocationIdentifier")
		public LoanAllocationIdentifier getAllocationIdentifier() {
			return allocationIdentifier;
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		public AbstractLoanAllocationSummary build() {
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder toBuilder() {
			AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder builder) {
			ofNullable(getAllocationIdentifier()).ifPresent(builder::setAllocationIdentifier);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanAllocationSummary _that = getType().cast(o);
		
			if (!Objects.equals(allocationIdentifier, _that.getAllocationIdentifier())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationIdentifier != null ? allocationIdentifier.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationSummary {" +
				"allocationIdentifier=" + this.allocationIdentifier + ", " +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractLoanAllocationSummary  ***********************/
	class AbstractLoanAllocationSummaryBuilderImpl implements AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder {
	
		protected LoanAllocationIdentifier.LoanAllocationIdentifierBuilder allocationIdentifier;
		protected Money.MoneyBuilder amount;
		protected String comment;
	
		public AbstractLoanAllocationSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationIdentifier")
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getAllocationIdentifier() {
			return allocationIdentifier;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationIdentifier() {
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder result;
			if (allocationIdentifier!=null) {
				result = allocationIdentifier;
			}
			else {
				result = allocationIdentifier = LoanAllocationIdentifier.builder();
			}
			
			return result;
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
		@RosettaAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		@RosettaAttribute("allocationIdentifier")
		public AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder setAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier) {
			this.allocationIdentifier = allocationIdentifier==null?null:allocationIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSummary build() {
			return new AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryImpl(this);
		}
		
		@Override
		public AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder prune() {
			if (allocationIdentifier!=null && !allocationIdentifier.prune().hasData()) allocationIdentifier = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationIdentifier()!=null && getAllocationIdentifier().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder o = (AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder) other;
			
			merger.mergeRosetta(getAllocationIdentifier(), o.getAllocationIdentifier(), this::setAllocationIdentifier);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanAllocationSummary _that = getType().cast(o);
		
			if (!Objects.equals(allocationIdentifier, _that.getAllocationIdentifier())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationIdentifier != null ? allocationIdentifier.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationSummaryBuilder {" +
				"allocationIdentifier=" + this.allocationIdentifier + ", " +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}';
		}
	}
}
