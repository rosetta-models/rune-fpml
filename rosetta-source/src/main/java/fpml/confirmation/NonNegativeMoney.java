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
import fpml.confirmation.Currency;
import fpml.confirmation.MoneyBase;
import fpml.confirmation.MoneyBase.MoneyBaseBuilder;
import fpml.confirmation.MoneyBase.MoneyBaseBuilderImpl;
import fpml.confirmation.MoneyBase.MoneyBaseImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilder;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilderImpl;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyImpl;
import fpml.confirmation.meta.NonNegativeMoneyMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a non negative money amount.
 * @version ${project.version}
 */
@RosettaDataType(value="NonNegativeMoney", builder=NonNegativeMoney.NonNegativeMoneyBuilderImpl.class, version="${project.version}")
public interface NonNegativeMoney extends MoneyBase {

	NonNegativeMoneyMeta metaData = new NonNegativeMoneyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The non negative monetary quantity in currency units.
	 */
	BigDecimal getAmount();

	/*********************** Build Methods  ***********************/
	NonNegativeMoney build();
	
	NonNegativeMoney.NonNegativeMoneyBuilder toBuilder();
	
	static NonNegativeMoney.NonNegativeMoneyBuilder builder() {
		return new NonNegativeMoney.NonNegativeMoneyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeMoney> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonNegativeMoney> getType() {
		return NonNegativeMoney.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeMoneyBuilder extends NonNegativeMoney, MoneyBase.MoneyBaseBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder setCurrency(Currency currency);
		NonNegativeMoney.NonNegativeMoneyBuilder setId(String id);
		NonNegativeMoney.NonNegativeMoneyBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		NonNegativeMoney.NonNegativeMoneyBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeMoney  ***********************/
	class NonNegativeMoneyImpl extends MoneyBase.MoneyBaseImpl implements NonNegativeMoney {
		private final BigDecimal amount;
		
		protected NonNegativeMoneyImpl(NonNegativeMoney.NonNegativeMoneyBuilder builder) {
			super(builder);
			this.amount = builder.getAmount();
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney build() {
			return this;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder toBuilder() {
			NonNegativeMoney.NonNegativeMoneyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeMoney.NonNegativeMoneyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeMoney _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeMoney {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeMoney  ***********************/
	class NonNegativeMoneyBuilderImpl extends MoneyBase.MoneyBaseBuilderImpl  implements NonNegativeMoney.NonNegativeMoneyBuilder {
	
		protected BigDecimal amount;
	
		public NonNegativeMoneyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("currency")
		public NonNegativeMoney.NonNegativeMoneyBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public NonNegativeMoney.NonNegativeMoneyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		
		@Override
		public NonNegativeMoney build() {
			return new NonNegativeMoney.NonNegativeMoneyImpl(this);
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonNegativeMoney.NonNegativeMoneyBuilder o = (NonNegativeMoney.NonNegativeMoneyBuilder) other;
			
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeMoney _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeMoneyBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
