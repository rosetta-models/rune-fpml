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
import fpml.confirmation.ExchangeTradedOptionSequence;
import fpml.confirmation.ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder;
import fpml.confirmation.ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilderImpl;
import fpml.confirmation.ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceImpl;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.meta.ExchangeTradedOptionSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExchangeTradedOptionSequence", builder=ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExchangeTradedOptionSequence extends RosettaModelObject {

	ExchangeTradedOptionSequenceMeta metaData = new ExchangeTradedOptionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the price at which the option can be exercised.
	 */
	BigDecimal getStrike();
	/**
	 * The currency in which the strike of the option is expressed.
	 */
	Currency getStrikeCurrency();
	/**
	 * Units in which the option strike is expressed e.g. currency Amount, BasisPoints, Percentage, Rate. Reportable reference data under MiFID RTS 22
	 */
	PriceQuoteUnits getStrikeUnits();

	/*********************** Build Methods  ***********************/
	ExchangeTradedOptionSequence build();
	
	ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder toBuilder();
	
	static ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder builder() {
		return new ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedOptionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeTradedOptionSequence> getType() {
		return ExchangeTradedOptionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		processRosetta(path.newSubPath("strikeCurrency"), processor, Currency.class, getStrikeCurrency());
		processRosetta(path.newSubPath("strikeUnits"), processor, PriceQuoteUnits.class, getStrikeUnits());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedOptionSequenceBuilder extends ExchangeTradedOptionSequence, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateStrikeCurrency();
		Currency.CurrencyBuilder getStrikeCurrency();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateStrikeUnits();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getStrikeUnits();
		ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder setStrike(BigDecimal strike);
		ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder setStrikeCurrency(Currency strikeCurrency);
		ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder setStrikeUnits(PriceQuoteUnits strikeUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
			processRosetta(path.newSubPath("strikeCurrency"), processor, Currency.CurrencyBuilder.class, getStrikeCurrency());
			processRosetta(path.newSubPath("strikeUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getStrikeUnits());
		}
		

		ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedOptionSequence  ***********************/
	class ExchangeTradedOptionSequenceImpl implements ExchangeTradedOptionSequence {
		private final BigDecimal strike;
		private final Currency strikeCurrency;
		private final PriceQuoteUnits strikeUnits;
		
		protected ExchangeTradedOptionSequenceImpl(ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder builder) {
			this.strike = builder.getStrike();
			this.strikeCurrency = ofNullable(builder.getStrikeCurrency()).map(f->f.build()).orElse(null);
			this.strikeUnits = ofNullable(builder.getStrikeUnits()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("strikeCurrency")
		public Currency getStrikeCurrency() {
			return strikeCurrency;
		}
		
		@Override
		@RosettaAttribute("strikeUnits")
		public PriceQuoteUnits getStrikeUnits() {
			return strikeUnits;
		}
		
		@Override
		public ExchangeTradedOptionSequence build() {
			return this;
		}
		
		@Override
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder toBuilder() {
			ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder builder) {
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getStrikeCurrency()).ifPresent(builder::setStrikeCurrency);
			ofNullable(getStrikeUnits()).ifPresent(builder::setStrikeUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeTradedOptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeCurrency, _that.getStrikeCurrency())) return false;
			if (!Objects.equals(strikeUnits, _that.getStrikeUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeCurrency != null ? strikeCurrency.hashCode() : 0);
			_result = 31 * _result + (strikeUnits != null ? strikeUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedOptionSequence {" +
				"strike=" + this.strike + ", " +
				"strikeCurrency=" + this.strikeCurrency + ", " +
				"strikeUnits=" + this.strikeUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeTradedOptionSequence  ***********************/
	class ExchangeTradedOptionSequenceBuilderImpl implements ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder {
	
		protected BigDecimal strike;
		protected Currency.CurrencyBuilder strikeCurrency;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder strikeUnits;
	
		public ExchangeTradedOptionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("strikeCurrency")
		public Currency.CurrencyBuilder getStrikeCurrency() {
			return strikeCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateStrikeCurrency() {
			Currency.CurrencyBuilder result;
			if (strikeCurrency!=null) {
				result = strikeCurrency;
			}
			else {
				result = strikeCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikeUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getStrikeUnits() {
			return strikeUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateStrikeUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (strikeUnits!=null) {
				result = strikeUnits;
			}
			else {
				result = strikeUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder setStrike(BigDecimal strike) {
			this.strike = strike==null?null:strike;
			return this;
		}
		@Override
		@RosettaAttribute("strikeCurrency")
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder setStrikeCurrency(Currency strikeCurrency) {
			this.strikeCurrency = strikeCurrency==null?null:strikeCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikeUnits")
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder setStrikeUnits(PriceQuoteUnits strikeUnits) {
			this.strikeUnits = strikeUnits==null?null:strikeUnits.toBuilder();
			return this;
		}
		
		@Override
		public ExchangeTradedOptionSequence build() {
			return new ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceImpl(this);
		}
		
		@Override
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder prune() {
			if (strikeCurrency!=null && !strikeCurrency.prune().hasData()) strikeCurrency = null;
			if (strikeUnits!=null && !strikeUnits.prune().hasData()) strikeUnits = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrike()!=null) return true;
			if (getStrikeCurrency()!=null && getStrikeCurrency().hasData()) return true;
			if (getStrikeUnits()!=null && getStrikeUnits().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder o = (ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder) other;
			
			merger.mergeRosetta(getStrikeCurrency(), o.getStrikeCurrency(), this::setStrikeCurrency);
			merger.mergeRosetta(getStrikeUnits(), o.getStrikeUnits(), this::setStrikeUnits);
			
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeTradedOptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeCurrency, _that.getStrikeCurrency())) return false;
			if (!Objects.equals(strikeUnits, _that.getStrikeUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeCurrency != null ? strikeCurrency.hashCode() : 0);
			_result = 31 * _result + (strikeUnits != null ? strikeUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedOptionSequenceBuilder {" +
				"strike=" + this.strike + ", " +
				"strikeCurrency=" + this.strikeCurrency + ", " +
				"strikeUnits=" + this.strikeUnits +
			'}';
		}
	}
}
