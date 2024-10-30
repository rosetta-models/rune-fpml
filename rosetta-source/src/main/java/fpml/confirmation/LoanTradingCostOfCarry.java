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
import fpml.confirmation.LoanTradingCostOfCarry;
import fpml.confirmation.LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder;
import fpml.confirmation.LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilderImpl;
import fpml.confirmation.LoanTradingCostOfCarry.LoanTradingCostOfCarryImpl;
import fpml.confirmation.LoanTradingCostOfCarryAccrual;
import fpml.confirmation.Money;
import fpml.confirmation.meta.LoanTradingCostOfCarryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that incorporates elements of an accrual calculation, for the purpose of defining cost-of-carry.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradingCostOfCarry", builder=LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradingCostOfCarry extends RosettaModelObject {

	LoanTradingCostOfCarryMeta metaData = new LoanTradingCostOfCarryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount of cost of carry accrued for the given loan contract. Funded Amount * Price + (100-Price) * Unfunded - (100-Price) * Paydown - Non-Recurring Fees.
	 */
	Money getAmount();
	/**
	 * Details of the accrual schedule in support of the cost of carry amount: The commencement amount is the calculated &#39;value&#39; of the asset being purchased/sold, as of the end of the REGULAR settlement period (e.g. at T+7 for Par). This amount takes into account ALL potential adjustments, price and utilized/unutilized balances as of the regular settlement date. Hence, the reference amount will be the commencement amount and the rate will be the average LIBOR (between T+7 and actual settlement date). If however, the settlement amount at the END of the delay period has changed by more than 25 percent as compared to the commencement amount, then the (calculated) settlement amount for each applicable day within the delay period must be calculated and used to accrue the cost of carry. The average LIBOR will still be the applicable rate.
	 */
	LoanTradingCostOfCarryAccrual getAccrual();

	/*********************** Build Methods  ***********************/
	LoanTradingCostOfCarry build();
	
	LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder toBuilder();
	
	static LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder() {
		return new LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingCostOfCarry> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingCostOfCarry> getType() {
		return LoanTradingCostOfCarry.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("accrual"), processor, LoanTradingCostOfCarryAccrual.class, getAccrual());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingCostOfCarryBuilder extends LoanTradingCostOfCarry, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getOrCreateAccrual();
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getAccrual();
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAmount(Money amount);
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAccrual(LoanTradingCostOfCarryAccrual accrual);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrual"), processor, LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder.class, getAccrual());
		}
		

		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingCostOfCarry  ***********************/
	class LoanTradingCostOfCarryImpl implements LoanTradingCostOfCarry {
		private final Money amount;
		private final LoanTradingCostOfCarryAccrual accrual;
		
		protected LoanTradingCostOfCarryImpl(LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("accrual")
		public LoanTradingCostOfCarryAccrual getAccrual() {
			return accrual;
		}
		
		@Override
		public LoanTradingCostOfCarry build() {
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder toBuilder() {
			LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCostOfCarry _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCostOfCarry {" +
				"amount=" + this.amount + ", " +
				"accrual=" + this.accrual +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingCostOfCarry  ***********************/
	class LoanTradingCostOfCarryBuilderImpl implements LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder {
	
		protected Money.MoneyBuilder amount;
		protected LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder accrual;
	
		public LoanTradingCostOfCarryBuilderImpl() {
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
		@RosettaAttribute("accrual")
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getAccrual() {
			return accrual;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getOrCreateAccrual() {
			LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder result;
			if (accrual!=null) {
				result = accrual;
			}
			else {
				result = accrual = LoanTradingCostOfCarryAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrual")
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAccrual(LoanTradingCostOfCarryAccrual accrual) {
			this.accrual = accrual==null?null:accrual.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarry build() {
			return new LoanTradingCostOfCarry.LoanTradingCostOfCarryImpl(this);
		}
		
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder o = (LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCostOfCarry _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCostOfCarryBuilder {" +
				"amount=" + this.amount + ", " +
				"accrual=" + this.accrual +
			'}';
		}
	}
}
