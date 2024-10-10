package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.CrossRate;
import fpml.confirmation.ExchangeRate;
import fpml.confirmation.ExchangeRate.ExchangeRateBuilder;
import fpml.confirmation.ExchangeRate.ExchangeRateBuilderImpl;
import fpml.confirmation.ExchangeRate.ExchangeRateImpl;
import fpml.confirmation.ExchangeRateSequence;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.ExchangeRateMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that is used for describing the exchange rate for a particular transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeRate", builder=ExchangeRate.ExchangeRateBuilderImpl.class, version="${project.version}")
public interface ExchangeRate extends RosettaModelObject {

	ExchangeRateMeta metaData = new ExchangeRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
	 */
	BigDecimal getRate();
	ExchangeRateSequence getExchangeRateSequence();
	/**
	 * An optional element that allow for definition of the currency exchange rates used to cross between the traded currencies for non-base currency FX contracts.
	 */
	List<? extends CrossRate> getCrossRate();

	/*********************** Build Methods  ***********************/
	ExchangeRate build();
	
	ExchangeRate.ExchangeRateBuilder toBuilder();
	
	static ExchangeRate.ExchangeRateBuilder builder() {
		return new ExchangeRate.ExchangeRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeRate> getType() {
		return ExchangeRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("exchangeRateSequence"), processor, ExchangeRateSequence.class, getExchangeRateSequence());
		processRosetta(path.newSubPath("crossRate"), processor, CrossRate.class, getCrossRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeRateBuilder extends ExchangeRate, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		ExchangeRateSequence.ExchangeRateSequenceBuilder getOrCreateExchangeRateSequence();
		ExchangeRateSequence.ExchangeRateSequenceBuilder getExchangeRateSequence();
		CrossRate.CrossRateBuilder getOrCreateCrossRate(int _index);
		List<? extends CrossRate.CrossRateBuilder> getCrossRate();
		ExchangeRate.ExchangeRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		ExchangeRate.ExchangeRateBuilder setRate(BigDecimal rate);
		ExchangeRate.ExchangeRateBuilder setExchangeRateSequence(ExchangeRateSequence exchangeRateSequence);
		ExchangeRate.ExchangeRateBuilder addCrossRate(CrossRate crossRate0);
		ExchangeRate.ExchangeRateBuilder addCrossRate(CrossRate crossRate1, int _idx);
		ExchangeRate.ExchangeRateBuilder addCrossRate(List<? extends CrossRate> crossRate2);
		ExchangeRate.ExchangeRateBuilder setCrossRate(List<? extends CrossRate> crossRate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("exchangeRateSequence"), processor, ExchangeRateSequence.ExchangeRateSequenceBuilder.class, getExchangeRateSequence());
			processRosetta(path.newSubPath("crossRate"), processor, CrossRate.CrossRateBuilder.class, getCrossRate());
		}
		

		ExchangeRate.ExchangeRateBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeRate  ***********************/
	class ExchangeRateImpl implements ExchangeRate {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal rate;
		private final ExchangeRateSequence exchangeRateSequence;
		private final List<? extends CrossRate> crossRate;
		
		protected ExchangeRateImpl(ExchangeRate.ExchangeRateBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.rate = builder.getRate();
			this.exchangeRateSequence = ofNullable(builder.getExchangeRateSequence()).map(f->f.build()).orElse(null);
			this.crossRate = ofNullable(builder.getCrossRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("exchangeRateSequence")
		public ExchangeRateSequence getExchangeRateSequence() {
			return exchangeRateSequence;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		public List<? extends CrossRate> getCrossRate() {
			return crossRate;
		}
		
		@Override
		public ExchangeRate build() {
			return this;
		}
		
		@Override
		public ExchangeRate.ExchangeRateBuilder toBuilder() {
			ExchangeRate.ExchangeRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeRate.ExchangeRateBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getExchangeRateSequence()).ifPresent(builder::setExchangeRateSequence);
			ofNullable(getCrossRate()).ifPresent(builder::setCrossRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(exchangeRateSequence, _that.getExchangeRateSequence())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (exchangeRateSequence != null ? exchangeRateSequence.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRate {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate + ", " +
				"exchangeRateSequence=" + this.exchangeRateSequence + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeRate  ***********************/
	class ExchangeRateBuilderImpl implements ExchangeRate.ExchangeRateBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal rate;
		protected ExchangeRateSequence.ExchangeRateSequenceBuilder exchangeRateSequence;
		protected List<CrossRate.CrossRateBuilder> crossRate = new ArrayList<>();
	
		public ExchangeRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("exchangeRateSequence")
		public ExchangeRateSequence.ExchangeRateSequenceBuilder getExchangeRateSequence() {
			return exchangeRateSequence;
		}
		
		@Override
		public ExchangeRateSequence.ExchangeRateSequenceBuilder getOrCreateExchangeRateSequence() {
			ExchangeRateSequence.ExchangeRateSequenceBuilder result;
			if (exchangeRateSequence!=null) {
				result = exchangeRateSequence;
			}
			else {
				result = exchangeRateSequence = ExchangeRateSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		public List<? extends CrossRate.CrossRateBuilder> getCrossRate() {
			return crossRate;
		}
		
		public CrossRate.CrossRateBuilder getOrCreateCrossRate(int _index) {
		
			if (crossRate==null) {
				this.crossRate = new ArrayList<>();
			}
			CrossRate.CrossRateBuilder result;
			return getIndex(crossRate, _index, () -> {
						CrossRate.CrossRateBuilder newCrossRate = CrossRate.builder();
						return newCrossRate;
					});
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public ExchangeRate.ExchangeRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public ExchangeRate.ExchangeRateBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("exchangeRateSequence")
		public ExchangeRate.ExchangeRateBuilder setExchangeRateSequence(ExchangeRateSequence exchangeRateSequence) {
			this.exchangeRateSequence = exchangeRateSequence==null?null:exchangeRateSequence.toBuilder();
			return this;
		}
		@Override
		public ExchangeRate.ExchangeRateBuilder addCrossRate(CrossRate crossRate) {
			if (crossRate!=null) this.crossRate.add(crossRate.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeRate.ExchangeRateBuilder addCrossRate(CrossRate crossRate, int _idx) {
			getIndex(this.crossRate, _idx, () -> crossRate.toBuilder());
			return this;
		}
		@Override 
		public ExchangeRate.ExchangeRateBuilder addCrossRate(List<? extends CrossRate> crossRates) {
			if (crossRates != null) {
				for (CrossRate toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("crossRate")
		public ExchangeRate.ExchangeRateBuilder setCrossRate(List<? extends CrossRate> crossRates) {
			if (crossRates == null)  {
				this.crossRate = new ArrayList<>();
			}
			else {
				this.crossRate = crossRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ExchangeRate build() {
			return new ExchangeRate.ExchangeRateImpl(this);
		}
		
		@Override
		public ExchangeRate.ExchangeRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRate.ExchangeRateBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (exchangeRateSequence!=null && !exchangeRateSequence.prune().hasData()) exchangeRateSequence = null;
			crossRate = crossRate.stream().filter(b->b!=null).<CrossRate.CrossRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getRate()!=null) return true;
			if (getExchangeRateSequence()!=null && getExchangeRateSequence().hasData()) return true;
			if (getCrossRate()!=null && getCrossRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRate.ExchangeRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeRate.ExchangeRateBuilder o = (ExchangeRate.ExchangeRateBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getExchangeRateSequence(), o.getExchangeRateSequence(), this::setExchangeRateSequence);
			merger.mergeRosetta(getCrossRate(), o.getCrossRate(), this::getOrCreateCrossRate);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(exchangeRateSequence, _that.getExchangeRateSequence())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (exchangeRateSequence != null ? exchangeRateSequence.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRateBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate + ", " +
				"exchangeRateSequence=" + this.exchangeRateSequence + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}
}
