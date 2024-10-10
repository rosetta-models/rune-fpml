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
import fpml.confirmation.FxKnockoutLevel;
import fpml.confirmation.FxKnockoutLevel.FxKnockoutLevelBuilder;
import fpml.confirmation.FxKnockoutLevel.FxKnockoutLevelBuilderImpl;
import fpml.confirmation.FxKnockoutLevel.FxKnockoutLevelImpl;
import fpml.confirmation.FxSettlementAdjustmentMethodEnum;
import fpml.confirmation.FxTargetStyleEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.FxKnockoutLevelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the Target level of gain.
 * @version ${project.version}
 */
@RosettaDataType(value="FxKnockoutLevel", builder=FxKnockoutLevel.FxKnockoutLevelBuilderImpl.class, version="${project.version}")
public interface FxKnockoutLevel extends RosettaModelObject {

	FxKnockoutLevelMeta metaData = new FxKnockoutLevelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Target level expressed as a cash amount.
	 */
	NonNegativeMoney getAmount();
	/**
	 * Target level expressed as intrinsic value (cumulative benefit over the prevailing spot rate at each observation point).
	 */
	BigDecimal getIntrinsicValue();
	/**
	 * Target style when it settles, whether it is Inclusive, Exclusive, or Exact. Exclusive: the gain for the knockout period is adjusted to zero i.e. the target yields zero value in the final period. Exact: the gain for the knockout period is adjusted to yield a final accumulated value equal to the target level. Inclusive: the gain for the knockout period is equal to the whole benefit of the final fixing over spot i.e. the final accumulated value may exceed the target level.
	 */
	FxTargetStyleEnum getTargetStyle();
	/**
	 * Specifies the calculation method by which the final accumulated value is adjusted equal to the target value, in the case where the target style is &quot;Exact&quot;. This element must be produced (only) where the target style is &quot;Exact&quot;, and should be omitted otherwise.
	 */
	FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle();

	/*********************** Build Methods  ***********************/
	FxKnockoutLevel build();
	
	FxKnockoutLevel.FxKnockoutLevelBuilder toBuilder();
	
	static FxKnockoutLevel.FxKnockoutLevelBuilder builder() {
		return new FxKnockoutLevel.FxKnockoutLevelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxKnockoutLevel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxKnockoutLevel> getType() {
		return FxKnockoutLevel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("intrinsicValue"), BigDecimal.class, getIntrinsicValue(), this);
		processor.processBasic(path.newSubPath("targetStyle"), FxTargetStyleEnum.class, getTargetStyle(), this);
		processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxKnockoutLevelBuilder extends FxKnockoutLevel, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		FxKnockoutLevel.FxKnockoutLevelBuilder setAmount(NonNegativeMoney amount);
		FxKnockoutLevel.FxKnockoutLevelBuilder setIntrinsicValue(BigDecimal intrinsicValue);
		FxKnockoutLevel.FxKnockoutLevelBuilder setTargetStyle(FxTargetStyleEnum targetStyle);
		FxKnockoutLevel.FxKnockoutLevelBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("intrinsicValue"), BigDecimal.class, getIntrinsicValue(), this);
			processor.processBasic(path.newSubPath("targetStyle"), FxTargetStyleEnum.class, getTargetStyle(), this);
			processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
		}
		

		FxKnockoutLevel.FxKnockoutLevelBuilder prune();
	}

	/*********************** Immutable Implementation of FxKnockoutLevel  ***********************/
	class FxKnockoutLevelImpl implements FxKnockoutLevel {
		private final NonNegativeMoney amount;
		private final BigDecimal intrinsicValue;
		private final FxTargetStyleEnum targetStyle;
		private final FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		
		protected FxKnockoutLevelImpl(FxKnockoutLevel.FxKnockoutLevelBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.intrinsicValue = builder.getIntrinsicValue();
			this.targetStyle = builder.getTargetStyle();
			this.settlementAdjustmentStyle = builder.getSettlementAdjustmentStyle();
		}
		
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("intrinsicValue")
		public BigDecimal getIntrinsicValue() {
			return intrinsicValue;
		}
		
		@Override
		@RosettaAttribute("targetStyle")
		public FxTargetStyleEnum getTargetStyle() {
			return targetStyle;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		public FxKnockoutLevel build() {
			return this;
		}
		
		@Override
		public FxKnockoutLevel.FxKnockoutLevelBuilder toBuilder() {
			FxKnockoutLevel.FxKnockoutLevelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxKnockoutLevel.FxKnockoutLevelBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getIntrinsicValue()).ifPresent(builder::setIntrinsicValue);
			ofNullable(getTargetStyle()).ifPresent(builder::setTargetStyle);
			ofNullable(getSettlementAdjustmentStyle()).ifPresent(builder::setSettlementAdjustmentStyle);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxKnockoutLevel _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(intrinsicValue, _that.getIntrinsicValue())) return false;
			if (!Objects.equals(targetStyle, _that.getTargetStyle())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (intrinsicValue != null ? intrinsicValue.hashCode() : 0);
			_result = 31 * _result + (targetStyle != null ? targetStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxKnockoutLevel {" +
				"amount=" + this.amount + ", " +
				"intrinsicValue=" + this.intrinsicValue + ", " +
				"targetStyle=" + this.targetStyle + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}

	/*********************** Builder Implementation of FxKnockoutLevel  ***********************/
	class FxKnockoutLevelBuilderImpl implements FxKnockoutLevel.FxKnockoutLevelBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected BigDecimal intrinsicValue;
		protected FxTargetStyleEnum targetStyle;
		protected FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
	
		public FxKnockoutLevelBuilderImpl() {
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
		@RosettaAttribute("intrinsicValue")
		public BigDecimal getIntrinsicValue() {
			return intrinsicValue;
		}
		
		@Override
		@RosettaAttribute("targetStyle")
		public FxTargetStyleEnum getTargetStyle() {
			return targetStyle;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		@RosettaAttribute("amount")
		public FxKnockoutLevel.FxKnockoutLevelBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("intrinsicValue")
		public FxKnockoutLevel.FxKnockoutLevelBuilder setIntrinsicValue(BigDecimal intrinsicValue) {
			this.intrinsicValue = intrinsicValue==null?null:intrinsicValue;
			return this;
		}
		@Override
		@RosettaAttribute("targetStyle")
		public FxKnockoutLevel.FxKnockoutLevelBuilder setTargetStyle(FxTargetStyleEnum targetStyle) {
			this.targetStyle = targetStyle==null?null:targetStyle;
			return this;
		}
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxKnockoutLevel.FxKnockoutLevelBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle) {
			this.settlementAdjustmentStyle = settlementAdjustmentStyle==null?null:settlementAdjustmentStyle;
			return this;
		}
		
		@Override
		public FxKnockoutLevel build() {
			return new FxKnockoutLevel.FxKnockoutLevelImpl(this);
		}
		
		@Override
		public FxKnockoutLevel.FxKnockoutLevelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxKnockoutLevel.FxKnockoutLevelBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getIntrinsicValue()!=null) return true;
			if (getTargetStyle()!=null) return true;
			if (getSettlementAdjustmentStyle()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxKnockoutLevel.FxKnockoutLevelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxKnockoutLevel.FxKnockoutLevelBuilder o = (FxKnockoutLevel.FxKnockoutLevelBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getIntrinsicValue(), o.getIntrinsicValue(), this::setIntrinsicValue);
			merger.mergeBasic(getTargetStyle(), o.getTargetStyle(), this::setTargetStyle);
			merger.mergeBasic(getSettlementAdjustmentStyle(), o.getSettlementAdjustmentStyle(), this::setSettlementAdjustmentStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxKnockoutLevel _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(intrinsicValue, _that.getIntrinsicValue())) return false;
			if (!Objects.equals(targetStyle, _that.getTargetStyle())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (intrinsicValue != null ? intrinsicValue.hashCode() : 0);
			_result = 31 * _result + (targetStyle != null ? targetStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxKnockoutLevelBuilder {" +
				"amount=" + this.amount + ", " +
				"intrinsicValue=" + this.intrinsicValue + ", " +
				"targetStyle=" + this.targetStyle + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}
}
