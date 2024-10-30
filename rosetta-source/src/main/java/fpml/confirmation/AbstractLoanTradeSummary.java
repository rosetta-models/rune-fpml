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
import fpml.confirmation.AbstractLoanTradeSummary;
import fpml.confirmation.AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder;
import fpml.confirmation.AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilderImpl;
import fpml.confirmation.AbstractLoanTradeSummary.AbstractLoanTradeSummaryImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.AbstractLoanTradeSummaryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An underlying structure defining all loan trade information i.e. this structure contains the main (e.g. fund manager/main counterparty) trade details.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AbstractLoanTradeSummary", builder=AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AbstractLoanTradeSummary extends RosettaModelObject {

	AbstractLoanTradeSummaryMeta metaData = new AbstractLoanTradeSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique trade ids used to identify the trade record.
	 */
	TradeIdentifier getTradeIdentifier();
	/**
	 * Reference to the facility traded.
	 */
	FacilityReference getFacilityReference();
	/**
	 * The commitment amount traded as of the original trade date.
	 */
	Money getAmount();
	/**
	 * A freetext field which allows the sender to add further details around the trade event.
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	AbstractLoanTradeSummary build();
	
	AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder toBuilder();
	
	static AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder builder() {
		return new AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanTradeSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanTradeSummary> getType() {
		return AbstractLoanTradeSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanTradeSummaryBuilder extends AbstractLoanTradeSummary, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier();
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setFacilityReference(FacilityReference facilityReference);
		AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setAmount(Money amount);
		AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanTradeSummary  ***********************/
	class AbstractLoanTradeSummaryImpl implements AbstractLoanTradeSummary {
		private final TradeIdentifier tradeIdentifier;
		private final FacilityReference facilityReference;
		private final Money amount;
		private final String comment;
		
		protected AbstractLoanTradeSummaryImpl(AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.comment = builder.getComment();
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
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
		public AbstractLoanTradeSummary build() {
			return this;
		}
		
		@Override
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder toBuilder() {
			AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanTradeSummary _that = getType().cast(o);
		
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradeSummary {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractLoanTradeSummary  ***********************/
	class AbstractLoanTradeSummaryBuilderImpl implements AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder {
	
		protected TradeIdentifier.TradeIdentifierBuilder tradeIdentifier;
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		protected Money.MoneyBuilder amount;
		protected String comment;
	
		public AbstractLoanTradeSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
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
		@RosettaAttribute("tradeIdentifier")
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier) {
			this.tradeIdentifier = tradeIdentifier==null?null:tradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		
		@Override
		public AbstractLoanTradeSummary build() {
			return new AbstractLoanTradeSummary.AbstractLoanTradeSummaryImpl(this);
		}
		
		@Override
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder prune() {
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder o = (AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanTradeSummary _that = getType().cast(o);
		
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradeSummaryBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}';
		}
	}
}
