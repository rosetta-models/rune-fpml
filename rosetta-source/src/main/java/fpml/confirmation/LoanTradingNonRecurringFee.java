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
import fpml.confirmation.LoanTradingNonRecurringFee;
import fpml.confirmation.LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder;
import fpml.confirmation.LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilderImpl;
import fpml.confirmation.LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeImpl;
import fpml.confirmation.LoanTradingNonRecurringFeeTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonRecurringMiscFeeType;
import fpml.confirmation.meta.LoanTradingNonRecurringFeeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that details the underlying elements that affect the calculation of a fee accrual.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradingNonRecurringFee", builder=LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradingNonRecurringFee extends RosettaModelObject {

	LoanTradingNonRecurringFeeMeta metaData = new LoanTradingNonRecurringFeeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The total accrual amount.
	 */
	NonNegativeMoney getAmount();
	/**
	 * Describes the type of the accruing fee.
	 */
	LoanTradingNonRecurringFeeTypeEnum getFeeType();
	/**
	 * Miscellaneous nonrecurring fee type.
	 */
	NonRecurringMiscFeeType getMiscFeeType();

	/*********************** Build Methods  ***********************/
	LoanTradingNonRecurringFee build();
	
	LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder toBuilder();
	
	static LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder builder() {
		return new LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingNonRecurringFee> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingNonRecurringFee> getType() {
		return LoanTradingNonRecurringFee.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("feeType"), LoanTradingNonRecurringFeeTypeEnum.class, getFeeType(), this);
		processRosetta(path.newSubPath("miscFeeType"), processor, NonRecurringMiscFeeType.class, getMiscFeeType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingNonRecurringFeeBuilder extends LoanTradingNonRecurringFee, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getOrCreateMiscFeeType();
		NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getMiscFeeType();
		LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder setAmount(NonNegativeMoney amount);
		LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder setFeeType(LoanTradingNonRecurringFeeTypeEnum feeType);
		LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder setMiscFeeType(NonRecurringMiscFeeType miscFeeType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("feeType"), LoanTradingNonRecurringFeeTypeEnum.class, getFeeType(), this);
			processRosetta(path.newSubPath("miscFeeType"), processor, NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder.class, getMiscFeeType());
		}
		

		LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingNonRecurringFee  ***********************/
	class LoanTradingNonRecurringFeeImpl implements LoanTradingNonRecurringFee {
		private final NonNegativeMoney amount;
		private final LoanTradingNonRecurringFeeTypeEnum feeType;
		private final NonRecurringMiscFeeType miscFeeType;
		
		protected LoanTradingNonRecurringFeeImpl(LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.feeType = builder.getFeeType();
			this.miscFeeType = ofNullable(builder.getMiscFeeType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("feeType")
		public LoanTradingNonRecurringFeeTypeEnum getFeeType() {
			return feeType;
		}
		
		@Override
		@RosettaAttribute("miscFeeType")
		public NonRecurringMiscFeeType getMiscFeeType() {
			return miscFeeType;
		}
		
		@Override
		public LoanTradingNonRecurringFee build() {
			return this;
		}
		
		@Override
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder toBuilder() {
			LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getFeeType()).ifPresent(builder::setFeeType);
			ofNullable(getMiscFeeType()).ifPresent(builder::setMiscFeeType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingNonRecurringFee _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(feeType, _that.getFeeType())) return false;
			if (!Objects.equals(miscFeeType, _that.getMiscFeeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (feeType != null ? feeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (miscFeeType != null ? miscFeeType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingNonRecurringFee {" +
				"amount=" + this.amount + ", " +
				"feeType=" + this.feeType + ", " +
				"miscFeeType=" + this.miscFeeType +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingNonRecurringFee  ***********************/
	class LoanTradingNonRecurringFeeBuilderImpl implements LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected LoanTradingNonRecurringFeeTypeEnum feeType;
		protected NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder miscFeeType;
	
		public LoanTradingNonRecurringFeeBuilderImpl() {
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
		@RosettaAttribute("feeType")
		public LoanTradingNonRecurringFeeTypeEnum getFeeType() {
			return feeType;
		}
		
		@Override
		@RosettaAttribute("miscFeeType")
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getMiscFeeType() {
			return miscFeeType;
		}
		
		@Override
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getOrCreateMiscFeeType() {
			NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder result;
			if (miscFeeType!=null) {
				result = miscFeeType;
			}
			else {
				result = miscFeeType = NonRecurringMiscFeeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeType")
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder setFeeType(LoanTradingNonRecurringFeeTypeEnum feeType) {
			this.feeType = feeType==null?null:feeType;
			return this;
		}
		@Override
		@RosettaAttribute("miscFeeType")
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder setMiscFeeType(NonRecurringMiscFeeType miscFeeType) {
			this.miscFeeType = miscFeeType==null?null:miscFeeType.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingNonRecurringFee build() {
			return new LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeImpl(this);
		}
		
		@Override
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (miscFeeType!=null && !miscFeeType.prune().hasData()) miscFeeType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getFeeType()!=null) return true;
			if (getMiscFeeType()!=null && getMiscFeeType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder o = (LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getMiscFeeType(), o.getMiscFeeType(), this::setMiscFeeType);
			
			merger.mergeBasic(getFeeType(), o.getFeeType(), this::setFeeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingNonRecurringFee _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(feeType, _that.getFeeType())) return false;
			if (!Objects.equals(miscFeeType, _that.getMiscFeeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (feeType != null ? feeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (miscFeeType != null ? miscFeeType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingNonRecurringFeeBuilder {" +
				"amount=" + this.amount + ", " +
				"feeType=" + this.feeType + ", " +
				"miscFeeType=" + this.miscFeeType +
			'}';
		}
	}
}
