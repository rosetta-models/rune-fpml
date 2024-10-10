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
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactors;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilderImpl;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsImpl;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence;
import fpml.confirmation.meta.LoanTradingCounterpartySettlementFundingFactorsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines the factors that impact settlement cashflows.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingCounterpartySettlementFundingFactors", builder=LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilderImpl.class, version="${project.version}")
public interface LoanTradingCounterpartySettlementFundingFactors extends RosettaModelObject {

	LoanTradingCounterpartySettlementFundingFactorsMeta metaData = new LoanTradingCounterpartySettlementFundingFactorsMeta();

	/*********************** Getter Methods  ***********************/
	LoanTradingCounterpartySettlementFundingFactorsSequence getLoanTradingCounterpartySettlementFundingFactorsSequence();
	/**
	 * Countparty shares of the transfer fee owed to the agent.
	 */
	BuyerSellerAmounts getTransferFeeAmounts();

	/*********************** Build Methods  ***********************/
	LoanTradingCounterpartySettlementFundingFactors build();
	
	LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder toBuilder();
	
	static LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder() {
		return new LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingCounterpartySettlementFundingFactors> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingCounterpartySettlementFundingFactors> getType() {
		return LoanTradingCounterpartySettlementFundingFactors.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanTradingCounterpartySettlementFundingFactorsSequence"), processor, LoanTradingCounterpartySettlementFundingFactorsSequence.class, getLoanTradingCounterpartySettlementFundingFactorsSequence());
		processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.class, getTransferFeeAmounts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingCounterpartySettlementFundingFactorsBuilder extends LoanTradingCounterpartySettlementFundingFactors, RosettaModelObjectBuilder {
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder getOrCreateLoanTradingCounterpartySettlementFundingFactorsSequence();
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder getLoanTradingCounterpartySettlementFundingFactorsSequence();
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getOrCreateTransferFeeAmounts();
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getTransferFeeAmounts();
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setLoanTradingCounterpartySettlementFundingFactorsSequence(LoanTradingCounterpartySettlementFundingFactorsSequence loanTradingCounterpartySettlementFundingFactorsSequence);
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setTransferFeeAmounts(BuyerSellerAmounts transferFeeAmounts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanTradingCounterpartySettlementFundingFactorsSequence"), processor, LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder.class, getLoanTradingCounterpartySettlementFundingFactorsSequence());
			processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.BuyerSellerAmountsBuilder.class, getTransferFeeAmounts());
		}
		

		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingCounterpartySettlementFundingFactors  ***********************/
	class LoanTradingCounterpartySettlementFundingFactorsImpl implements LoanTradingCounterpartySettlementFundingFactors {
		private final LoanTradingCounterpartySettlementFundingFactorsSequence loanTradingCounterpartySettlementFundingFactorsSequence;
		private final BuyerSellerAmounts transferFeeAmounts;
		
		protected LoanTradingCounterpartySettlementFundingFactorsImpl(LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder) {
			this.loanTradingCounterpartySettlementFundingFactorsSequence = ofNullable(builder.getLoanTradingCounterpartySettlementFundingFactorsSequence()).map(f->f.build()).orElse(null);
			this.transferFeeAmounts = ofNullable(builder.getTransferFeeAmounts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradingCounterpartySettlementFundingFactorsSequence")
		public LoanTradingCounterpartySettlementFundingFactorsSequence getLoanTradingCounterpartySettlementFundingFactorsSequence() {
			return loanTradingCounterpartySettlementFundingFactorsSequence;
		}
		
		@Override
		@RosettaAttribute("transferFeeAmounts")
		public BuyerSellerAmounts getTransferFeeAmounts() {
			return transferFeeAmounts;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors build() {
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder toBuilder() {
			LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder) {
			ofNullable(getLoanTradingCounterpartySettlementFundingFactorsSequence()).ifPresent(builder::setLoanTradingCounterpartySettlementFundingFactorsSequence);
			ofNullable(getTransferFeeAmounts()).ifPresent(builder::setTransferFeeAmounts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartySettlementFundingFactors _that = getType().cast(o);
		
			if (!Objects.equals(loanTradingCounterpartySettlementFundingFactorsSequence, _that.getLoanTradingCounterpartySettlementFundingFactorsSequence())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanTradingCounterpartySettlementFundingFactorsSequence != null ? loanTradingCounterpartySettlementFundingFactorsSequence.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartySettlementFundingFactors {" +
				"loanTradingCounterpartySettlementFundingFactorsSequence=" + this.loanTradingCounterpartySettlementFundingFactorsSequence + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingCounterpartySettlementFundingFactors  ***********************/
	class LoanTradingCounterpartySettlementFundingFactorsBuilderImpl implements LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder {
	
		protected LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder loanTradingCounterpartySettlementFundingFactorsSequence;
		protected BuyerSellerAmounts.BuyerSellerAmountsBuilder transferFeeAmounts;
	
		public LoanTradingCounterpartySettlementFundingFactorsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanTradingCounterpartySettlementFundingFactorsSequence")
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder getLoanTradingCounterpartySettlementFundingFactorsSequence() {
			return loanTradingCounterpartySettlementFundingFactorsSequence;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder getOrCreateLoanTradingCounterpartySettlementFundingFactorsSequence() {
			LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder result;
			if (loanTradingCounterpartySettlementFundingFactorsSequence!=null) {
				result = loanTradingCounterpartySettlementFundingFactorsSequence;
			}
			else {
				result = loanTradingCounterpartySettlementFundingFactorsSequence = LoanTradingCounterpartySettlementFundingFactorsSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferFeeAmounts")
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder getTransferFeeAmounts() {
			return transferFeeAmounts;
		}
		
		@Override
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder getOrCreateTransferFeeAmounts() {
			BuyerSellerAmounts.BuyerSellerAmountsBuilder result;
			if (transferFeeAmounts!=null) {
				result = transferFeeAmounts;
			}
			else {
				result = transferFeeAmounts = BuyerSellerAmounts.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanTradingCounterpartySettlementFundingFactorsSequence")
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setLoanTradingCounterpartySettlementFundingFactorsSequence(LoanTradingCounterpartySettlementFundingFactorsSequence loanTradingCounterpartySettlementFundingFactorsSequence) {
			this.loanTradingCounterpartySettlementFundingFactorsSequence = loanTradingCounterpartySettlementFundingFactorsSequence==null?null:loanTradingCounterpartySettlementFundingFactorsSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transferFeeAmounts")
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setTransferFeeAmounts(BuyerSellerAmounts transferFeeAmounts) {
			this.transferFeeAmounts = transferFeeAmounts==null?null:transferFeeAmounts.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors build() {
			return new LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsImpl(this);
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder prune() {
			if (loanTradingCounterpartySettlementFundingFactorsSequence!=null && !loanTradingCounterpartySettlementFundingFactorsSequence.prune().hasData()) loanTradingCounterpartySettlementFundingFactorsSequence = null;
			if (transferFeeAmounts!=null && !transferFeeAmounts.prune().hasData()) transferFeeAmounts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanTradingCounterpartySettlementFundingFactorsSequence()!=null && getLoanTradingCounterpartySettlementFundingFactorsSequence().hasData()) return true;
			if (getTransferFeeAmounts()!=null && getTransferFeeAmounts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder o = (LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder) other;
			
			merger.mergeRosetta(getLoanTradingCounterpartySettlementFundingFactorsSequence(), o.getLoanTradingCounterpartySettlementFundingFactorsSequence(), this::setLoanTradingCounterpartySettlementFundingFactorsSequence);
			merger.mergeRosetta(getTransferFeeAmounts(), o.getTransferFeeAmounts(), this::setTransferFeeAmounts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartySettlementFundingFactors _that = getType().cast(o);
		
			if (!Objects.equals(loanTradingCounterpartySettlementFundingFactorsSequence, _that.getLoanTradingCounterpartySettlementFundingFactorsSequence())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanTradingCounterpartySettlementFundingFactorsSequence != null ? loanTradingCounterpartySettlementFundingFactorsSequence.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartySettlementFundingFactorsBuilder {" +
				"loanTradingCounterpartySettlementFundingFactorsSequence=" + this.loanTradingCounterpartySettlementFundingFactorsSequence + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}
}
