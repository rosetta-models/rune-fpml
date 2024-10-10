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
import fpml.confirmation.QuoteBasisEnum;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairBuilder;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl;
import fpml.confirmation.QuotedCurrencyPair.QuotedCurrencyPairImpl;
import fpml.confirmation.meta.QuotedCurrencyPairMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the composition of a rate that has been quoted or is to be quoted. This includes the two currencies and the quotation relationship between the two currencies and is used as a building block throughout the FX specification.
 * @version ${project.version}
 */
@RosettaDataType(value="QuotedCurrencyPair", builder=QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl.class, version="${project.version}")
public interface QuotedCurrencyPair extends RosettaModelObject {

	QuotedCurrencyPairMeta metaData = new QuotedCurrencyPairMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first currency specified when a pair of currencies is to be evaluated.
	 */
	Currency getCurrency1();
	/**
	 * The second currency specified when a pair of currencies is to be evaluated.
	 */
	Currency getCurrency2();
	/**
	 * The method by which the exchange rate is quoted.
	 */
	QuoteBasisEnum getQuoteBasis();

	/*********************** Build Methods  ***********************/
	QuotedCurrencyPair build();
	
	QuotedCurrencyPair.QuotedCurrencyPairBuilder toBuilder();
	
	static QuotedCurrencyPair.QuotedCurrencyPairBuilder builder() {
		return new QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuotedCurrencyPair> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuotedCurrencyPair> getType() {
		return QuotedCurrencyPair.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency1"), processor, Currency.class, getCurrency1());
		processRosetta(path.newSubPath("currency2"), processor, Currency.class, getCurrency2());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuotedCurrencyPairBuilder extends QuotedCurrencyPair, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency1();
		Currency.CurrencyBuilder getCurrency1();
		Currency.CurrencyBuilder getOrCreateCurrency2();
		Currency.CurrencyBuilder getCurrency2();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency1(Currency currency1);
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency2(Currency currency2);
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency1"), processor, Currency.CurrencyBuilder.class, getCurrency1());
			processRosetta(path.newSubPath("currency2"), processor, Currency.CurrencyBuilder.class, getCurrency2());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		}
		

		QuotedCurrencyPair.QuotedCurrencyPairBuilder prune();
	}

	/*********************** Immutable Implementation of QuotedCurrencyPair  ***********************/
	class QuotedCurrencyPairImpl implements QuotedCurrencyPair {
		private final Currency currency1;
		private final Currency currency2;
		private final QuoteBasisEnum quoteBasis;
		
		protected QuotedCurrencyPairImpl(QuotedCurrencyPair.QuotedCurrencyPairBuilder builder) {
			this.currency1 = ofNullable(builder.getCurrency1()).map(f->f.build()).orElse(null);
			this.currency2 = ofNullable(builder.getCurrency2()).map(f->f.build()).orElse(null);
			this.quoteBasis = builder.getQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("currency1")
		public Currency getCurrency1() {
			return currency1;
		}
		
		@Override
		@RosettaAttribute("currency2")
		public Currency getCurrency2() {
			return currency2;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		public QuotedCurrencyPair build() {
			return this;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder toBuilder() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuotedCurrencyPair.QuotedCurrencyPairBuilder builder) {
			ofNullable(getCurrency1()).ifPresent(builder::setCurrency1);
			ofNullable(getCurrency2()).ifPresent(builder::setCurrency2);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotedCurrencyPair _that = getType().cast(o);
		
			if (!Objects.equals(currency1, _that.getCurrency1())) return false;
			if (!Objects.equals(currency2, _that.getCurrency2())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency1 != null ? currency1.hashCode() : 0);
			_result = 31 * _result + (currency2 != null ? currency2.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotedCurrencyPair {" +
				"currency1=" + this.currency1 + ", " +
				"currency2=" + this.currency2 + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}

	/*********************** Builder Implementation of QuotedCurrencyPair  ***********************/
	class QuotedCurrencyPairBuilderImpl implements QuotedCurrencyPair.QuotedCurrencyPairBuilder {
	
		protected Currency.CurrencyBuilder currency1;
		protected Currency.CurrencyBuilder currency2;
		protected QuoteBasisEnum quoteBasis;
	
		public QuotedCurrencyPairBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency1")
		public Currency.CurrencyBuilder getCurrency1() {
			return currency1;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency1() {
			Currency.CurrencyBuilder result;
			if (currency1!=null) {
				result = currency1;
			}
			else {
				result = currency1 = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency2")
		public Currency.CurrencyBuilder getCurrency2() {
			return currency2;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency2() {
			Currency.CurrencyBuilder result;
			if (currency2!=null) {
				result = currency2;
			}
			else {
				result = currency2 = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		@RosettaAttribute("currency1")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency1(Currency currency1) {
			this.currency1 = currency1==null?null:currency1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency2")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency2(Currency currency2) {
			this.currency2 = currency2==null?null:currency2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quoteBasis")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setQuoteBasis(QuoteBasisEnum quoteBasis) {
			this.quoteBasis = quoteBasis==null?null:quoteBasis;
			return this;
		}
		
		@Override
		public QuotedCurrencyPair build() {
			return new QuotedCurrencyPair.QuotedCurrencyPairImpl(this);
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder prune() {
			if (currency1!=null && !currency1.prune().hasData()) currency1 = null;
			if (currency2!=null && !currency2.prune().hasData()) currency2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency1()!=null && getCurrency1().hasData()) return true;
			if (getCurrency2()!=null && getCurrency2().hasData()) return true;
			if (getQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder o = (QuotedCurrencyPair.QuotedCurrencyPairBuilder) other;
			
			merger.mergeRosetta(getCurrency1(), o.getCurrency1(), this::setCurrency1);
			merger.mergeRosetta(getCurrency2(), o.getCurrency2(), this::setCurrency2);
			
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotedCurrencyPair _that = getType().cast(o);
		
			if (!Objects.equals(currency1, _that.getCurrency1())) return false;
			if (!Objects.equals(currency2, _that.getCurrency2())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency1 != null ? currency1.hashCode() : 0);
			_result = 31 * _result + (currency2 != null ? currency2.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotedCurrencyPairBuilder {" +
				"currency1=" + this.currency1 + ", " +
				"currency2=" + this.currency2 + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}
}
