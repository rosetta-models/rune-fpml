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
import fpml.confirmation.EquityStrike;
import fpml.confirmation.EquityStrike.EquityStrikeBuilder;
import fpml.confirmation.EquityStrike.EquityStrikeBuilderImpl;
import fpml.confirmation.EquityStrike.EquityStrikeImpl;
import fpml.confirmation.EquityStrikeSequence;
import fpml.confirmation.meta.EquityStrikeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the strike price for an equity option. The strike price is either: (i) in respect of an index option transaction, the level of the relevant index specified or otherwise determined in the transaction; or (ii) in respect of a share option transaction, the price per share specified or otherwise determined in the transaction. This can be expressed either as a percentage of notional amount or as an absolute value.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityStrike", builder=EquityStrike.EquityStrikeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityStrike extends RosettaModelObject {

	EquityStrikeMeta metaData = new EquityStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The price or level at which the option has been struck.
	 */
	BigDecimal getStrikePrice();
	EquityStrikeSequence getEquityStrikeSequence();
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	EquityStrike build();
	
	EquityStrike.EquityStrikeBuilder toBuilder();
	
	static EquityStrike.EquityStrikeBuilder builder() {
		return new EquityStrike.EquityStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityStrike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityStrike> getType() {
		return EquityStrike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processRosetta(path.newSubPath("equityStrikeSequence"), processor, EquityStrikeSequence.class, getEquityStrikeSequence());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityStrikeBuilder extends EquityStrike, RosettaModelObjectBuilder {
		EquityStrikeSequence.EquityStrikeSequenceBuilder getOrCreateEquityStrikeSequence();
		EquityStrikeSequence.EquityStrikeSequenceBuilder getEquityStrikeSequence();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		EquityStrike.EquityStrikeBuilder setStrikePrice(BigDecimal strikePrice);
		EquityStrike.EquityStrikeBuilder setEquityStrikeSequence(EquityStrikeSequence equityStrikeSequence);
		EquityStrike.EquityStrikeBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processRosetta(path.newSubPath("equityStrikeSequence"), processor, EquityStrikeSequence.EquityStrikeSequenceBuilder.class, getEquityStrikeSequence());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		EquityStrike.EquityStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of EquityStrike  ***********************/
	class EquityStrikeImpl implements EquityStrike {
		private final BigDecimal strikePrice;
		private final EquityStrikeSequence equityStrikeSequence;
		private final Currency currency;
		
		protected EquityStrikeImpl(EquityStrike.EquityStrikeBuilder builder) {
			this.strikePrice = builder.getStrikePrice();
			this.equityStrikeSequence = ofNullable(builder.getEquityStrikeSequence()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("equityStrikeSequence")
		public EquityStrikeSequence getEquityStrikeSequence() {
			return equityStrikeSequence;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public EquityStrike build() {
			return this;
		}
		
		@Override
		public EquityStrike.EquityStrikeBuilder toBuilder() {
			EquityStrike.EquityStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityStrike.EquityStrikeBuilder builder) {
			ofNullable(getStrikePrice()).ifPresent(builder::setStrikePrice);
			ofNullable(getEquityStrikeSequence()).ifPresent(builder::setEquityStrikeSequence);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(equityStrikeSequence, _that.getEquityStrikeSequence())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (equityStrikeSequence != null ? equityStrikeSequence.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityStrike {" +
				"strikePrice=" + this.strikePrice + ", " +
				"equityStrikeSequence=" + this.equityStrikeSequence + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityStrike  ***********************/
	class EquityStrikeBuilderImpl implements EquityStrike.EquityStrikeBuilder {
	
		protected BigDecimal strikePrice;
		protected EquityStrikeSequence.EquityStrikeSequenceBuilder equityStrikeSequence;
		protected Currency.CurrencyBuilder currency;
	
		public EquityStrikeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("equityStrikeSequence")
		public EquityStrikeSequence.EquityStrikeSequenceBuilder getEquityStrikeSequence() {
			return equityStrikeSequence;
		}
		
		@Override
		public EquityStrikeSequence.EquityStrikeSequenceBuilder getOrCreateEquityStrikeSequence() {
			EquityStrikeSequence.EquityStrikeSequenceBuilder result;
			if (equityStrikeSequence!=null) {
				result = equityStrikeSequence;
			}
			else {
				result = equityStrikeSequence = EquityStrikeSequence.builder();
			}
			
			return result;
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
		@RosettaAttribute("strikePrice")
		public EquityStrike.EquityStrikeBuilder setStrikePrice(BigDecimal strikePrice) {
			this.strikePrice = strikePrice==null?null:strikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("equityStrikeSequence")
		public EquityStrike.EquityStrikeBuilder setEquityStrikeSequence(EquityStrikeSequence equityStrikeSequence) {
			this.equityStrikeSequence = equityStrikeSequence==null?null:equityStrikeSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public EquityStrike.EquityStrikeBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public EquityStrike build() {
			return new EquityStrike.EquityStrikeImpl(this);
		}
		
		@Override
		public EquityStrike.EquityStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityStrike.EquityStrikeBuilder prune() {
			if (equityStrikeSequence!=null && !equityStrikeSequence.prune().hasData()) equityStrikeSequence = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikePrice()!=null) return true;
			if (getEquityStrikeSequence()!=null && getEquityStrikeSequence().hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityStrike.EquityStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityStrike.EquityStrikeBuilder o = (EquityStrike.EquityStrikeBuilder) other;
			
			merger.mergeRosetta(getEquityStrikeSequence(), o.getEquityStrikeSequence(), this::setEquityStrikeSequence);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(equityStrikeSequence, _that.getEquityStrikeSequence())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (equityStrikeSequence != null ? equityStrikeSequence.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityStrikeBuilder {" +
				"strikePrice=" + this.strikePrice + ", " +
				"equityStrikeSequence=" + this.equityStrikeSequence + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
