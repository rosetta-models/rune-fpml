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
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradeSummary.LoanTradeSummaryBuilder;
import fpml.confirmation.LoanTradeSummary.LoanTradeSummaryBuilderImpl;
import fpml.confirmation.LoanTradeSummary.LoanTradeSummaryImpl;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.LoanTradeSummaryMeta;


/**
 * A structure that defines all loan trade information i.e. this structure contains the main (e.g. fund manager/main counterparty) trade details.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradeSummary", builder=LoanTradeSummary.LoanTradeSummaryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradeSummary extends AbstractLoanTradeSummary {

	LoanTradeSummaryMeta metaData = new LoanTradeSummaryMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanTradeSummary build();
	
	LoanTradeSummary.LoanTradeSummaryBuilder toBuilder();
	
	static LoanTradeSummary.LoanTradeSummaryBuilder builder() {
		return new LoanTradeSummary.LoanTradeSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeSummary> getType() {
		return LoanTradeSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeSummaryBuilder extends LoanTradeSummary, AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder {
		LoanTradeSummary.LoanTradeSummaryBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		LoanTradeSummary.LoanTradeSummaryBuilder setFacilityReference(FacilityReference facilityReference);
		LoanTradeSummary.LoanTradeSummaryBuilder setAmount(Money amount);
		LoanTradeSummary.LoanTradeSummaryBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		LoanTradeSummary.LoanTradeSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeSummary  ***********************/
	class LoanTradeSummaryImpl extends AbstractLoanTradeSummary.AbstractLoanTradeSummaryImpl implements LoanTradeSummary {
		
		protected LoanTradeSummaryImpl(LoanTradeSummary.LoanTradeSummaryBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanTradeSummary build() {
			return this;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder toBuilder() {
			LoanTradeSummary.LoanTradeSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeSummary.LoanTradeSummaryBuilder builder) {
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
			return "LoanTradeSummary {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeSummary  ***********************/
	class LoanTradeSummaryBuilderImpl extends AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilderImpl  implements LoanTradeSummary.LoanTradeSummaryBuilder {
	
	
		public LoanTradeSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifier")
		public LoanTradeSummary.LoanTradeSummaryBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier) {
			this.tradeIdentifier = tradeIdentifier==null?null:tradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public LoanTradeSummary.LoanTradeSummaryBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanTradeSummary.LoanTradeSummaryBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTradeSummary.LoanTradeSummaryBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		
		@Override
		public LoanTradeSummary build() {
			return new LoanTradeSummary.LoanTradeSummaryImpl(this);
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder prune() {
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
		public LoanTradeSummary.LoanTradeSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeSummary.LoanTradeSummaryBuilder o = (LoanTradeSummary.LoanTradeSummaryBuilder) other;
			
			
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
			return "LoanTradeSummaryBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
