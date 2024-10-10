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
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.CashflowNotional.CashflowNotionalBuilder;
import fpml.confirmation.CashflowNotional.CashflowNotionalBuilderImpl;
import fpml.confirmation.CashflowNotional.CashflowNotionalImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.meta.CashflowNotionalMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The notional/principal value/quantity/volume used to compute the cashflow.
 * @version ${project.version}
 */
@RosettaDataType(value="CashflowNotional", builder=CashflowNotional.CashflowNotionalBuilderImpl.class, version="${project.version}")
public interface CashflowNotional extends RosettaModelObject {

	CashflowNotionalMeta metaData = new CashflowNotionalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();
	/**
	 * The units in which an amount (not monetary) is denominated.
	 */
	String getUnits();
	/**
	 * The quantity of notional (in currency or other units).
	 */
	BigDecimal getAmount();
	String getId();

	/*********************** Build Methods  ***********************/
	CashflowNotional build();
	
	CashflowNotional.CashflowNotionalBuilder toBuilder();
	
	static CashflowNotional.CashflowNotionalBuilder builder() {
		return new CashflowNotional.CashflowNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashflowNotional> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashflowNotional> getType() {
		return CashflowNotional.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowNotionalBuilder extends CashflowNotional, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		CashflowNotional.CashflowNotionalBuilder setCurrency(Currency currency);
		CashflowNotional.CashflowNotionalBuilder setUnits(String units);
		CashflowNotional.CashflowNotionalBuilder setAmount(BigDecimal amount);
		CashflowNotional.CashflowNotionalBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CashflowNotional.CashflowNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of CashflowNotional  ***********************/
	class CashflowNotionalImpl implements CashflowNotional {
		private final Currency currency;
		private final String units;
		private final BigDecimal amount;
		private final String id;
		
		protected CashflowNotionalImpl(CashflowNotional.CashflowNotionalBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.units = builder.getUnits();
			this.amount = builder.getAmount();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CashflowNotional build() {
			return this;
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder toBuilder() {
			CashflowNotional.CashflowNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashflowNotional.CashflowNotionalBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getUnits()).ifPresent(builder::setUnits);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowNotional _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(units, _that.getUnits())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowNotional {" +
				"currency=" + this.currency + ", " +
				"units=" + this.units + ", " +
				"amount=" + this.amount + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CashflowNotional  ***********************/
	class CashflowNotionalBuilderImpl implements CashflowNotional.CashflowNotionalBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected String units;
		protected BigDecimal amount;
		protected String id;
	
		public CashflowNotionalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("currency")
		public CashflowNotional.CashflowNotionalBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("units")
		public CashflowNotional.CashflowNotionalBuilder setUnits(String units) {
			this.units = units==null?null:units;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public CashflowNotional.CashflowNotionalBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CashflowNotional.CashflowNotionalBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CashflowNotional build() {
			return new CashflowNotional.CashflowNotionalImpl(this);
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowNotional.CashflowNotionalBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getUnits()!=null) return true;
			if (getAmount()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowNotional.CashflowNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashflowNotional.CashflowNotionalBuilder o = (CashflowNotional.CashflowNotionalBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getUnits(), o.getUnits(), this::setUnits);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowNotional _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(units, _that.getUnits())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowNotionalBuilder {" +
				"currency=" + this.currency + ", " +
				"units=" + this.units + ", " +
				"amount=" + this.amount + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
