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
import fpml.confirmation.Money;
import fpml.confirmation.Money.MoneyBuilder;
import fpml.confirmation.Money.MoneyBuilderImpl;
import fpml.confirmation.Money.MoneyImpl;
import fpml.confirmation.MoneyBase;
import fpml.confirmation.MoneyBase.MoneyBaseBuilder;
import fpml.confirmation.MoneyBase.MoneyBaseBuilderImpl;
import fpml.confirmation.MoneyBase.MoneyBaseImpl;
import fpml.confirmation.meta.MoneyMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a currency amount.
 * @version ${project.version}
 */
@RosettaDataType(value="Money", builder=Money.MoneyBuilderImpl.class, version="${project.version}")
public interface Money extends MoneyBase {

	MoneyMeta metaData = new MoneyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The monetary quantity in currency units.
	 */
	BigDecimal getAmount();

	/*********************** Build Methods  ***********************/
	Money build();
	
	Money.MoneyBuilder toBuilder();
	
	static Money.MoneyBuilder builder() {
		return new Money.MoneyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Money> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Money> getType() {
		return Money.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyBuilder extends Money, MoneyBase.MoneyBaseBuilder {
		Money.MoneyBuilder setCurrency(Currency currency);
		Money.MoneyBuilder setId(String id);
		Money.MoneyBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		Money.MoneyBuilder prune();
	}

	/*********************** Immutable Implementation of Money  ***********************/
	class MoneyImpl extends MoneyBase.MoneyBaseImpl implements Money {
		private final BigDecimal amount;
		
		protected MoneyImpl(Money.MoneyBuilder builder) {
			super(builder);
			this.amount = builder.getAmount();
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public Money build() {
			return this;
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			Money.MoneyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Money.MoneyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
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
			return "Money {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Money  ***********************/
	class MoneyBuilderImpl extends MoneyBase.MoneyBaseBuilderImpl  implements Money.MoneyBuilder {
	
		protected BigDecimal amount;
	
		public MoneyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Money.MoneyBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Money.MoneyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public Money.MoneyBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		
		@Override
		public Money build() {
			return new Money.MoneyImpl(this);
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Money.MoneyBuilder prune() {
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
		public Money.MoneyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Money.MoneyBuilder o = (Money.MoneyBuilder) other;
			
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
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
			return "MoneyBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
