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
import fpml.confirmation.ActualPrice;
import fpml.confirmation.ActualPrice.ActualPriceBuilder;
import fpml.confirmation.ActualPrice.ActualPriceBuilderImpl;
import fpml.confirmation.ActualPrice.ActualPriceImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.PriceExpressionEnum;
import fpml.confirmation.meta.ActualPriceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ActualPrice", builder=ActualPrice.ActualPriceBuilderImpl.class, version="${project.version}")
public interface ActualPrice extends RosettaModelObject {

	ActualPriceMeta metaData = new ActualPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the currency associated with the net price. This element is not present if the price is expressed in percentage terms (as specified through the priceExpression element).
	 */
	Currency getCurrency();
	/**
	 * Specifies the net price amount. In the case of a fixed income security or a convertible bond, this price includes the accrued interests.
	 */
	BigDecimal getAmount();
	/**
	 * Specifies whether the price is expressed in absolute or relative terms.
	 */
	PriceExpressionEnum getPriceExpression();
	String getId();

	/*********************** Build Methods  ***********************/
	ActualPrice build();
	
	ActualPrice.ActualPriceBuilder toBuilder();
	
	static ActualPrice.ActualPriceBuilder builder() {
		return new ActualPrice.ActualPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActualPrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ActualPrice> getType() {
		return ActualPrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("priceExpression"), PriceExpressionEnum.class, getPriceExpression(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActualPriceBuilder extends ActualPrice, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		ActualPrice.ActualPriceBuilder setCurrency(Currency currency);
		ActualPrice.ActualPriceBuilder setAmount(BigDecimal amount);
		ActualPrice.ActualPriceBuilder setPriceExpression(PriceExpressionEnum priceExpression);
		ActualPrice.ActualPriceBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("priceExpression"), PriceExpressionEnum.class, getPriceExpression(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ActualPrice.ActualPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ActualPrice  ***********************/
	class ActualPriceImpl implements ActualPrice {
		private final Currency currency;
		private final BigDecimal amount;
		private final PriceExpressionEnum priceExpression;
		private final String id;
		
		protected ActualPriceImpl(ActualPrice.ActualPriceBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.amount = builder.getAmount();
			this.priceExpression = builder.getPriceExpression();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		public PriceExpressionEnum getPriceExpression() {
			return priceExpression;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ActualPrice build() {
			return this;
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder toBuilder() {
			ActualPrice.ActualPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActualPrice.ActualPriceBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPriceExpression()).ifPresent(builder::setPriceExpression);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActualPrice _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(priceExpression, _that.getPriceExpression())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (priceExpression != null ? priceExpression.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActualPrice {" +
				"currency=" + this.currency + ", " +
				"amount=" + this.amount + ", " +
				"priceExpression=" + this.priceExpression + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ActualPrice  ***********************/
	class ActualPriceBuilderImpl implements ActualPrice.ActualPriceBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected BigDecimal amount;
		protected PriceExpressionEnum priceExpression;
		protected String id;
	
		public ActualPriceBuilderImpl() {
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
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		public PriceExpressionEnum getPriceExpression() {
			return priceExpression;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("currency")
		public ActualPrice.ActualPriceBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public ActualPrice.ActualPriceBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("priceExpression")
		public ActualPrice.ActualPriceBuilder setPriceExpression(PriceExpressionEnum priceExpression) {
			this.priceExpression = priceExpression==null?null:priceExpression;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ActualPrice.ActualPriceBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ActualPrice build() {
			return new ActualPrice.ActualPriceImpl(this);
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActualPrice.ActualPriceBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getAmount()!=null) return true;
			if (getPriceExpression()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActualPrice.ActualPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActualPrice.ActualPriceBuilder o = (ActualPrice.ActualPriceBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getPriceExpression(), o.getPriceExpression(), this::setPriceExpression);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActualPrice _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(priceExpression, _that.getPriceExpression())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (priceExpression != null ? priceExpression.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActualPriceBuilder {" +
				"currency=" + this.currency + ", " +
				"amount=" + this.amount + ", " +
				"priceExpression=" + this.priceExpression + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
