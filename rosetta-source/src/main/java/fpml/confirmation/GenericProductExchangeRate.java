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
import fpml.confirmation.GenericProductExchangeRate;
import fpml.confirmation.GenericProductExchangeRate.GenericProductExchangeRateBuilder;
import fpml.confirmation.GenericProductExchangeRate.GenericProductExchangeRateBuilderImpl;
import fpml.confirmation.GenericProductExchangeRate.GenericProductExchangeRateImpl;
import fpml.confirmation.GenericProductExchangeRateSequence;
import fpml.confirmation.GenericProductQuotedCurrencyPair;
import fpml.confirmation.meta.GenericProductExchangeRateMeta;
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
@RosettaDataType(value="GenericProductExchangeRate", builder=GenericProductExchangeRate.GenericProductExchangeRateBuilderImpl.class, version="${project.version}")
public interface GenericProductExchangeRate extends RosettaModelObject {

	GenericProductExchangeRateMeta metaData = new GenericProductExchangeRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	GenericProductQuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
	 */
	BigDecimal getRate();
	GenericProductExchangeRateSequence getGenericProductExchangeRateSequence();
	/**
	 * An optional element that allow for definition of the currency exchange rates used to cross between the traded currencies for non-base currency FX contracts.
	 */
	List<? extends CrossRate> getCrossRate();

	/*********************** Build Methods  ***********************/
	GenericProductExchangeRate build();
	
	GenericProductExchangeRate.GenericProductExchangeRateBuilder toBuilder();
	
	static GenericProductExchangeRate.GenericProductExchangeRateBuilder builder() {
		return new GenericProductExchangeRate.GenericProductExchangeRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericProductExchangeRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericProductExchangeRate> getType() {
		return GenericProductExchangeRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, GenericProductQuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("genericProductExchangeRateSequence"), processor, GenericProductExchangeRateSequence.class, getGenericProductExchangeRateSequence());
		processRosetta(path.newSubPath("crossRate"), processor, CrossRate.class, getCrossRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericProductExchangeRateBuilder extends GenericProductExchangeRate, RosettaModelObjectBuilder {
		GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getQuotedCurrencyPair();
		GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder getOrCreateGenericProductExchangeRateSequence();
		GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder getGenericProductExchangeRateSequence();
		CrossRate.CrossRateBuilder getOrCreateCrossRate(int _index);
		List<? extends CrossRate.CrossRateBuilder> getCrossRate();
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setQuotedCurrencyPair(GenericProductQuotedCurrencyPair quotedCurrencyPair);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setRate(BigDecimal rate);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setGenericProductExchangeRateSequence(GenericProductExchangeRateSequence genericProductExchangeRateSequence);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate crossRate0);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate crossRate1, int _idx);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(List<? extends CrossRate> crossRate2);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setCrossRate(List<? extends CrossRate> crossRate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("genericProductExchangeRateSequence"), processor, GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder.class, getGenericProductExchangeRateSequence());
			processRosetta(path.newSubPath("crossRate"), processor, CrossRate.CrossRateBuilder.class, getCrossRate());
		}
		

		GenericProductExchangeRate.GenericProductExchangeRateBuilder prune();
	}

	/*********************** Immutable Implementation of GenericProductExchangeRate  ***********************/
	class GenericProductExchangeRateImpl implements GenericProductExchangeRate {
		private final GenericProductQuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal rate;
		private final GenericProductExchangeRateSequence genericProductExchangeRateSequence;
		private final List<? extends CrossRate> crossRate;
		
		protected GenericProductExchangeRateImpl(GenericProductExchangeRate.GenericProductExchangeRateBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.rate = builder.getRate();
			this.genericProductExchangeRateSequence = ofNullable(builder.getGenericProductExchangeRateSequence()).map(f->f.build()).orElse(null);
			this.crossRate = ofNullable(builder.getCrossRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public GenericProductQuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("genericProductExchangeRateSequence")
		public GenericProductExchangeRateSequence getGenericProductExchangeRateSequence() {
			return genericProductExchangeRateSequence;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		public List<? extends CrossRate> getCrossRate() {
			return crossRate;
		}
		
		@Override
		public GenericProductExchangeRate build() {
			return this;
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder toBuilder() {
			GenericProductExchangeRate.GenericProductExchangeRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericProductExchangeRate.GenericProductExchangeRateBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getGenericProductExchangeRateSequence()).ifPresent(builder::setGenericProductExchangeRateSequence);
			ofNullable(getCrossRate()).ifPresent(builder::setCrossRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(genericProductExchangeRateSequence, _that.getGenericProductExchangeRateSequence())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (genericProductExchangeRateSequence != null ? genericProductExchangeRateSequence.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRate {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate + ", " +
				"genericProductExchangeRateSequence=" + this.genericProductExchangeRateSequence + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericProductExchangeRate  ***********************/
	class GenericProductExchangeRateBuilderImpl implements GenericProductExchangeRate.GenericProductExchangeRateBuilder {
	
		protected GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal rate;
		protected GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder genericProductExchangeRateSequence;
		protected List<CrossRate.CrossRateBuilder> crossRate = new ArrayList<>();
	
		public GenericProductExchangeRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = GenericProductQuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("genericProductExchangeRateSequence")
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder getGenericProductExchangeRateSequence() {
			return genericProductExchangeRateSequence;
		}
		
		@Override
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder getOrCreateGenericProductExchangeRateSequence() {
			GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder result;
			if (genericProductExchangeRateSequence!=null) {
				result = genericProductExchangeRateSequence;
			}
			else {
				result = genericProductExchangeRateSequence = GenericProductExchangeRateSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		public List<? extends CrossRate.CrossRateBuilder> getCrossRate() {
			return crossRate;
		}
		
		@Override
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
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setQuotedCurrencyPair(GenericProductQuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("genericProductExchangeRateSequence")
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setGenericProductExchangeRateSequence(GenericProductExchangeRateSequence genericProductExchangeRateSequence) {
			this.genericProductExchangeRateSequence = genericProductExchangeRateSequence==null?null:genericProductExchangeRateSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("crossRate")
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate crossRate) {
			if (crossRate!=null) this.crossRate.add(crossRate.toBuilder());
			return this;
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate crossRate, int _idx) {
			getIndex(this.crossRate, _idx, () -> crossRate.toBuilder());
			return this;
		}
		@Override 
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(List<? extends CrossRate> crossRates) {
			if (crossRates != null) {
				for (CrossRate toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setCrossRate(List<? extends CrossRate> crossRates) {
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
		public GenericProductExchangeRate build() {
			return new GenericProductExchangeRate.GenericProductExchangeRateImpl(this);
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (genericProductExchangeRateSequence!=null && !genericProductExchangeRateSequence.prune().hasData()) genericProductExchangeRateSequence = null;
			crossRate = crossRate.stream().filter(b->b!=null).<CrossRate.CrossRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getRate()!=null) return true;
			if (getGenericProductExchangeRateSequence()!=null && getGenericProductExchangeRateSequence().hasData()) return true;
			if (getCrossRate()!=null && getCrossRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericProductExchangeRate.GenericProductExchangeRateBuilder o = (GenericProductExchangeRate.GenericProductExchangeRateBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getGenericProductExchangeRateSequence(), o.getGenericProductExchangeRateSequence(), this::setGenericProductExchangeRateSequence);
			merger.mergeRosetta(getCrossRate(), o.getCrossRate(), this::getOrCreateCrossRate);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(genericProductExchangeRateSequence, _that.getGenericProductExchangeRateSequence())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (genericProductExchangeRateSequence != null ? genericProductExchangeRateSequence.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRateBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate + ", " +
				"genericProductExchangeRateSequence=" + this.genericProductExchangeRateSequence + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}
}
