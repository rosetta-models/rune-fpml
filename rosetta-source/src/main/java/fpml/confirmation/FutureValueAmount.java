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
import fpml.confirmation.Currency;
import fpml.confirmation.FutureValueAmount;
import fpml.confirmation.FutureValueAmount.FutureValueAmountBuilder;
import fpml.confirmation.FutureValueAmount.FutureValueAmountBuilderImpl;
import fpml.confirmation.FutureValueAmount.FutureValueAmountImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilder;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilderImpl;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyImpl;
import fpml.confirmation.meta.FutureValueAmountMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a currency amount as at a future value date.
 * @version ${project.version}
 */
@RosettaDataType(value="FutureValueAmount", builder=FutureValueAmount.FutureValueAmountBuilderImpl.class, version="${project.version}")
public interface FutureValueAmount extends NonNegativeMoney {

	FutureValueAmountMeta metaData = new FutureValueAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
	 */
	Integer getCalculationPeriodNumberOfDays();
	/**
	 * Adjusted value date of the future value amount.
	 */
	Date getValueDate();

	/*********************** Build Methods  ***********************/
	FutureValueAmount build();
	
	FutureValueAmount.FutureValueAmountBuilder toBuilder();
	
	static FutureValueAmount.FutureValueAmountBuilder builder() {
		return new FutureValueAmount.FutureValueAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FutureValueAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FutureValueAmount> getType() {
		return FutureValueAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
		processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FutureValueAmountBuilder extends FutureValueAmount, NonNegativeMoney.NonNegativeMoneyBuilder {
		FutureValueAmount.FutureValueAmountBuilder setCurrency(Currency currency);
		FutureValueAmount.FutureValueAmountBuilder setId(String id);
		FutureValueAmount.FutureValueAmountBuilder setAmount(BigDecimal amount);
		FutureValueAmount.FutureValueAmountBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays);
		FutureValueAmount.FutureValueAmountBuilder setValueDate(Date valueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
			processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
		}
		

		FutureValueAmount.FutureValueAmountBuilder prune();
	}

	/*********************** Immutable Implementation of FutureValueAmount  ***********************/
	class FutureValueAmountImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements FutureValueAmount {
		private final Integer calculationPeriodNumberOfDays;
		private final Date valueDate;
		
		protected FutureValueAmountImpl(FutureValueAmount.FutureValueAmountBuilder builder) {
			super(builder);
			this.calculationPeriodNumberOfDays = builder.getCalculationPeriodNumberOfDays();
			this.valueDate = builder.getValueDate();
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		public Date getValueDate() {
			return valueDate;
		}
		
		@Override
		public FutureValueAmount build() {
			return this;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder toBuilder() {
			FutureValueAmount.FutureValueAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FutureValueAmount.FutureValueAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCalculationPeriodNumberOfDays()).ifPresent(builder::setCalculationPeriodNumberOfDays);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FutureValueAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureValueAmount {" +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FutureValueAmount  ***********************/
	class FutureValueAmountBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl  implements FutureValueAmount.FutureValueAmountBuilder {
	
		protected Integer calculationPeriodNumberOfDays;
		protected Date valueDate;
	
		public FutureValueAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		public Date getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("currency")
		public FutureValueAmount.FutureValueAmountBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FutureValueAmount.FutureValueAmountBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public FutureValueAmount.FutureValueAmountBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		public FutureValueAmount.FutureValueAmountBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays) {
			this.calculationPeriodNumberOfDays = calculationPeriodNumberOfDays==null?null:calculationPeriodNumberOfDays;
			return this;
		}
		@Override
		@RosettaAttribute("valueDate")
		public FutureValueAmount.FutureValueAmountBuilder setValueDate(Date valueDate) {
			this.valueDate = valueDate==null?null:valueDate;
			return this;
		}
		
		@Override
		public FutureValueAmount build() {
			return new FutureValueAmount.FutureValueAmountImpl(this);
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCalculationPeriodNumberOfDays()!=null) return true;
			if (getValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FutureValueAmount.FutureValueAmountBuilder o = (FutureValueAmount.FutureValueAmountBuilder) other;
			
			
			merger.mergeBasic(getCalculationPeriodNumberOfDays(), o.getCalculationPeriodNumberOfDays(), this::setCalculationPeriodNumberOfDays);
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FutureValueAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureValueAmountBuilder {" +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}
}
