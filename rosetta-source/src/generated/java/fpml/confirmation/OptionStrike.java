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
import fpml.confirmation.OptionNumericStrike;
import fpml.confirmation.OptionNumericStrike.OptionNumericStrikeBuilder;
import fpml.confirmation.OptionNumericStrike.OptionNumericStrikeBuilderImpl;
import fpml.confirmation.OptionNumericStrike.OptionNumericStrikeImpl;
import fpml.confirmation.OptionStrike;
import fpml.confirmation.OptionStrike.OptionStrikeBuilder;
import fpml.confirmation.OptionStrike.OptionStrikeBuilderImpl;
import fpml.confirmation.OptionStrike.OptionStrikeImpl;
import fpml.confirmation.meta.OptionStrikeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the strike price for an equity option. The strike price is either: (i) in respect of an index option transaction, the level of the relevant index specified or otherwise determined in the transaction; or (ii) in respect of a share option transaction, the price per share specified or otherwise determined in the transaction. This can be expressed either as a percentage of notional amount or as an absolute value.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionStrike", builder=OptionStrike.OptionStrikeBuilderImpl.class, version="${project.version}")
public interface OptionStrike extends OptionNumericStrike {

	OptionStrikeMeta metaData = new OptionStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	OptionStrike build();
	
	OptionStrike.OptionStrikeBuilder toBuilder();
	
	static OptionStrike.OptionStrikeBuilder builder() {
		return new OptionStrike.OptionStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionStrike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionStrike> getType() {
		return OptionStrike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionStrikeBuilder extends OptionStrike, OptionNumericStrike.OptionNumericStrikeBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		OptionStrike.OptionStrikeBuilder setStrikePrice(BigDecimal strikePrice);
		OptionStrike.OptionStrikeBuilder setStrikePercentage(BigDecimal strikePercentage);
		OptionStrike.OptionStrikeBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		OptionStrike.OptionStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of OptionStrike  ***********************/
	class OptionStrikeImpl extends OptionNumericStrike.OptionNumericStrikeImpl implements OptionStrike {
		private final Currency currency;
		
		protected OptionStrikeImpl(OptionStrike.OptionStrikeBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public OptionStrike build() {
			return this;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder toBuilder() {
			OptionStrike.OptionStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionStrike.OptionStrikeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionStrike {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionStrike  ***********************/
	class OptionStrikeBuilderImpl extends OptionNumericStrike.OptionNumericStrikeBuilderImpl  implements OptionStrike.OptionStrikeBuilder {
	
		protected Currency.CurrencyBuilder currency;
	
		public OptionStrikeBuilderImpl() {
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
		public OptionStrike.OptionStrikeBuilder setStrikePrice(BigDecimal strikePrice) {
			this.strikePrice = strikePrice==null?null:strikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("strikePercentage")
		public OptionStrike.OptionStrikeBuilder setStrikePercentage(BigDecimal strikePercentage) {
			this.strikePercentage = strikePercentage==null?null:strikePercentage;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public OptionStrike.OptionStrikeBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public OptionStrike build() {
			return new OptionStrike.OptionStrikeImpl(this);
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionStrike.OptionStrikeBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionStrike.OptionStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionStrike.OptionStrikeBuilder o = (OptionStrike.OptionStrikeBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionStrikeBuilder {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
