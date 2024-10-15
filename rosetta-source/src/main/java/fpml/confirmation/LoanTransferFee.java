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
import fpml.confirmation.BuySellEnum;
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.LoanTransferFee;
import fpml.confirmation.LoanTransferFee.LoanTransferFeeBuilder;
import fpml.confirmation.LoanTransferFee.LoanTransferFeeBuilderImpl;
import fpml.confirmation.LoanTransferFee.LoanTransferFeeImpl;
import fpml.confirmation.LoanTransferFeeSequence;
import fpml.confirmation.meta.LoanTransferFeeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents countparty shares or alternatively the total amount of the assignment fee owed to the admin agent.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTransferFee", builder=LoanTransferFee.LoanTransferFeeBuilderImpl.class, version="${project.version}")
public interface LoanTransferFee extends RosettaModelObject {

	LoanTransferFeeMeta metaData = new LoanTransferFeeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party responsible for remitting the transfer fee to the admin agent (buyer or seller).
	 */
	BuySellEnum getRemittedBy();
	LoanTransferFeeSequence getLoanTransferFeeSequence();
	/**
	 * Countparty shares of the transfer fee owed to the agent.
	 */
	BuyerSellerAmounts getTransferFeeAmounts();

	/*********************** Build Methods  ***********************/
	LoanTransferFee build();
	
	LoanTransferFee.LoanTransferFeeBuilder toBuilder();
	
	static LoanTransferFee.LoanTransferFeeBuilder builder() {
		return new LoanTransferFee.LoanTransferFeeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTransferFee> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTransferFee> getType() {
		return LoanTransferFee.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("remittedBy"), BuySellEnum.class, getRemittedBy(), this);
		processRosetta(path.newSubPath("loanTransferFeeSequence"), processor, LoanTransferFeeSequence.class, getLoanTransferFeeSequence());
		processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.class, getTransferFeeAmounts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTransferFeeBuilder extends LoanTransferFee, RosettaModelObjectBuilder {
		LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder getOrCreateLoanTransferFeeSequence();
		LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder getLoanTransferFeeSequence();
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getOrCreateTransferFeeAmounts();
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getTransferFeeAmounts();
		LoanTransferFee.LoanTransferFeeBuilder setRemittedBy(BuySellEnum remittedBy);
		LoanTransferFee.LoanTransferFeeBuilder setLoanTransferFeeSequence(LoanTransferFeeSequence loanTransferFeeSequence);
		LoanTransferFee.LoanTransferFeeBuilder setTransferFeeAmounts(BuyerSellerAmounts transferFeeAmounts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("remittedBy"), BuySellEnum.class, getRemittedBy(), this);
			processRosetta(path.newSubPath("loanTransferFeeSequence"), processor, LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder.class, getLoanTransferFeeSequence());
			processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.BuyerSellerAmountsBuilder.class, getTransferFeeAmounts());
		}
		

		LoanTransferFee.LoanTransferFeeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTransferFee  ***********************/
	class LoanTransferFeeImpl implements LoanTransferFee {
		private final BuySellEnum remittedBy;
		private final LoanTransferFeeSequence loanTransferFeeSequence;
		private final BuyerSellerAmounts transferFeeAmounts;
		
		protected LoanTransferFeeImpl(LoanTransferFee.LoanTransferFeeBuilder builder) {
			this.remittedBy = builder.getRemittedBy();
			this.loanTransferFeeSequence = ofNullable(builder.getLoanTransferFeeSequence()).map(f->f.build()).orElse(null);
			this.transferFeeAmounts = ofNullable(builder.getTransferFeeAmounts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("remittedBy")
		public BuySellEnum getRemittedBy() {
			return remittedBy;
		}
		
		@Override
		@RosettaAttribute("loanTransferFeeSequence")
		public LoanTransferFeeSequence getLoanTransferFeeSequence() {
			return loanTransferFeeSequence;
		}
		
		@Override
		@RosettaAttribute("transferFeeAmounts")
		public BuyerSellerAmounts getTransferFeeAmounts() {
			return transferFeeAmounts;
		}
		
		@Override
		public LoanTransferFee build() {
			return this;
		}
		
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder toBuilder() {
			LoanTransferFee.LoanTransferFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTransferFee.LoanTransferFeeBuilder builder) {
			ofNullable(getRemittedBy()).ifPresent(builder::setRemittedBy);
			ofNullable(getLoanTransferFeeSequence()).ifPresent(builder::setLoanTransferFeeSequence);
			ofNullable(getTransferFeeAmounts()).ifPresent(builder::setTransferFeeAmounts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTransferFee _that = getType().cast(o);
		
			if (!Objects.equals(remittedBy, _that.getRemittedBy())) return false;
			if (!Objects.equals(loanTransferFeeSequence, _that.getLoanTransferFeeSequence())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (remittedBy != null ? remittedBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (loanTransferFeeSequence != null ? loanTransferFeeSequence.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferFee {" +
				"remittedBy=" + this.remittedBy + ", " +
				"loanTransferFeeSequence=" + this.loanTransferFeeSequence + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTransferFee  ***********************/
	class LoanTransferFeeBuilderImpl implements LoanTransferFee.LoanTransferFeeBuilder {
	
		protected BuySellEnum remittedBy;
		protected LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder loanTransferFeeSequence;
		protected BuyerSellerAmounts.BuyerSellerAmountsBuilder transferFeeAmounts;
	
		public LoanTransferFeeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("remittedBy")
		public BuySellEnum getRemittedBy() {
			return remittedBy;
		}
		
		@Override
		@RosettaAttribute("loanTransferFeeSequence")
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder getLoanTransferFeeSequence() {
			return loanTransferFeeSequence;
		}
		
		@Override
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder getOrCreateLoanTransferFeeSequence() {
			LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder result;
			if (loanTransferFeeSequence!=null) {
				result = loanTransferFeeSequence;
			}
			else {
				result = loanTransferFeeSequence = LoanTransferFeeSequence.builder();
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
		@RosettaAttribute("remittedBy")
		public LoanTransferFee.LoanTransferFeeBuilder setRemittedBy(BuySellEnum remittedBy) {
			this.remittedBy = remittedBy==null?null:remittedBy;
			return this;
		}
		@Override
		@RosettaAttribute("loanTransferFeeSequence")
		public LoanTransferFee.LoanTransferFeeBuilder setLoanTransferFeeSequence(LoanTransferFeeSequence loanTransferFeeSequence) {
			this.loanTransferFeeSequence = loanTransferFeeSequence==null?null:loanTransferFeeSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transferFeeAmounts")
		public LoanTransferFee.LoanTransferFeeBuilder setTransferFeeAmounts(BuyerSellerAmounts transferFeeAmounts) {
			this.transferFeeAmounts = transferFeeAmounts==null?null:transferFeeAmounts.toBuilder();
			return this;
		}
		
		@Override
		public LoanTransferFee build() {
			return new LoanTransferFee.LoanTransferFeeImpl(this);
		}
		
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder prune() {
			if (loanTransferFeeSequence!=null && !loanTransferFeeSequence.prune().hasData()) loanTransferFeeSequence = null;
			if (transferFeeAmounts!=null && !transferFeeAmounts.prune().hasData()) transferFeeAmounts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRemittedBy()!=null) return true;
			if (getLoanTransferFeeSequence()!=null && getLoanTransferFeeSequence().hasData()) return true;
			if (getTransferFeeAmounts()!=null && getTransferFeeAmounts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTransferFee.LoanTransferFeeBuilder o = (LoanTransferFee.LoanTransferFeeBuilder) other;
			
			merger.mergeRosetta(getLoanTransferFeeSequence(), o.getLoanTransferFeeSequence(), this::setLoanTransferFeeSequence);
			merger.mergeRosetta(getTransferFeeAmounts(), o.getTransferFeeAmounts(), this::setTransferFeeAmounts);
			
			merger.mergeBasic(getRemittedBy(), o.getRemittedBy(), this::setRemittedBy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTransferFee _that = getType().cast(o);
		
			if (!Objects.equals(remittedBy, _that.getRemittedBy())) return false;
			if (!Objects.equals(loanTransferFeeSequence, _that.getLoanTransferFeeSequence())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (remittedBy != null ? remittedBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (loanTransferFeeSequence != null ? loanTransferFeeSequence.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferFeeBuilder {" +
				"remittedBy=" + this.remittedBy + ", " +
				"loanTransferFeeSequence=" + this.loanTransferFeeSequence + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}
}
