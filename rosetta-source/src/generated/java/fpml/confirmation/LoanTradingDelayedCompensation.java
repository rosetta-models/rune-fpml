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
import fpml.confirmation.LoanTradingDelayedCompensation;
import fpml.confirmation.LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder;
import fpml.confirmation.LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilderImpl;
import fpml.confirmation.LoanTradingDelayedCompensation.LoanTradingDelayedCompensationImpl;
import fpml.confirmation.LoanTradingSettlementAccrualsModel;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanTradingDelayedCompensationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that incorporates elements of interest and fee accruals, for the purpose of defining delayed compensation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingDelayedCompensation", builder=LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilderImpl.class, version="${project.version}")
public interface LoanTradingDelayedCompensation extends RosettaModelObject {

	LoanTradingDelayedCompensationMeta metaData = new LoanTradingDelayedCompensationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The total delayed compensation amount. This is the sum of all the loan contract, letter of credit and on-going fee accrual amounts.
	 */
	NonNegativeMoney getAmount();
	LoanTradingSettlementAccrualsModel getLoanTradingSettlementAccrualsModel();

	/*********************** Build Methods  ***********************/
	LoanTradingDelayedCompensation build();
	
	LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder toBuilder();
	
	static LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder() {
		return new LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingDelayedCompensation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingDelayedCompensation> getType() {
		return LoanTradingDelayedCompensation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("loanTradingSettlementAccrualsModel"), processor, LoanTradingSettlementAccrualsModel.class, getLoanTradingSettlementAccrualsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingDelayedCompensationBuilder extends LoanTradingDelayedCompensation, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder getOrCreateLoanTradingSettlementAccrualsModel();
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder getLoanTradingSettlementAccrualsModel();
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setAmount(NonNegativeMoney amount);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setLoanTradingSettlementAccrualsModel(LoanTradingSettlementAccrualsModel loanTradingSettlementAccrualsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("loanTradingSettlementAccrualsModel"), processor, LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder.class, getLoanTradingSettlementAccrualsModel());
		}
		

		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingDelayedCompensation  ***********************/
	class LoanTradingDelayedCompensationImpl implements LoanTradingDelayedCompensation {
		private final NonNegativeMoney amount;
		private final LoanTradingSettlementAccrualsModel loanTradingSettlementAccrualsModel;
		
		protected LoanTradingDelayedCompensationImpl(LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.loanTradingSettlementAccrualsModel = ofNullable(builder.getLoanTradingSettlementAccrualsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("loanTradingSettlementAccrualsModel")
		public LoanTradingSettlementAccrualsModel getLoanTradingSettlementAccrualsModel() {
			return loanTradingSettlementAccrualsModel;
		}
		
		@Override
		public LoanTradingDelayedCompensation build() {
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder toBuilder() {
			LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getLoanTradingSettlementAccrualsModel()).ifPresent(builder::setLoanTradingSettlementAccrualsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingDelayedCompensation _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(loanTradingSettlementAccrualsModel, _that.getLoanTradingSettlementAccrualsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (loanTradingSettlementAccrualsModel != null ? loanTradingSettlementAccrualsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingDelayedCompensation {" +
				"amount=" + this.amount + ", " +
				"loanTradingSettlementAccrualsModel=" + this.loanTradingSettlementAccrualsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingDelayedCompensation  ***********************/
	class LoanTradingDelayedCompensationBuilderImpl implements LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder loanTradingSettlementAccrualsModel;
	
		public LoanTradingDelayedCompensationBuilderImpl() {
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
		@RosettaAttribute("loanTradingSettlementAccrualsModel")
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder getLoanTradingSettlementAccrualsModel() {
			return loanTradingSettlementAccrualsModel;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder getOrCreateLoanTradingSettlementAccrualsModel() {
			LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder result;
			if (loanTradingSettlementAccrualsModel!=null) {
				result = loanTradingSettlementAccrualsModel;
			}
			else {
				result = loanTradingSettlementAccrualsModel = LoanTradingSettlementAccrualsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanTradingSettlementAccrualsModel")
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setLoanTradingSettlementAccrualsModel(LoanTradingSettlementAccrualsModel loanTradingSettlementAccrualsModel) {
			this.loanTradingSettlementAccrualsModel = loanTradingSettlementAccrualsModel==null?null:loanTradingSettlementAccrualsModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation build() {
			return new LoanTradingDelayedCompensation.LoanTradingDelayedCompensationImpl(this);
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (loanTradingSettlementAccrualsModel!=null && !loanTradingSettlementAccrualsModel.prune().hasData()) loanTradingSettlementAccrualsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getLoanTradingSettlementAccrualsModel()!=null && getLoanTradingSettlementAccrualsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder o = (LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getLoanTradingSettlementAccrualsModel(), o.getLoanTradingSettlementAccrualsModel(), this::setLoanTradingSettlementAccrualsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingDelayedCompensation _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(loanTradingSettlementAccrualsModel, _that.getLoanTradingSettlementAccrualsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (loanTradingSettlementAccrualsModel != null ? loanTradingSettlementAccrualsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingDelayedCompensationBuilder {" +
				"amount=" + this.amount + ", " +
				"loanTradingSettlementAccrualsModel=" + this.loanTradingSettlementAccrualsModel +
			'}';
		}
	}
}
