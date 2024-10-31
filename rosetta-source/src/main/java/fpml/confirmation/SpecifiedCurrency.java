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
import fpml.confirmation.Currency;
import fpml.confirmation.SpecifiedCurrency;
import fpml.confirmation.SpecifiedCurrency.SpecifiedCurrencyBuilder;
import fpml.confirmation.SpecifiedCurrency.SpecifiedCurrencyBuilderImpl;
import fpml.confirmation.SpecifiedCurrency.SpecifiedCurrencyImpl;
import fpml.confirmation.meta.SpecifiedCurrencyMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SpecifiedCurrency", builder=SpecifiedCurrency.SpecifiedCurrencyBuilderImpl.class, version="${project.version}")
public interface SpecifiedCurrency extends RosettaModelObject {

	SpecifiedCurrencyMeta metaData = new SpecifiedCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether the specified currency provision is applicable.
	 */
	Boolean getApplicable();
	/**
	 * The currency in which an amount is denominated.
	 */
	List<? extends Currency> getCurrency();

	/*********************** Build Methods  ***********************/
	SpecifiedCurrency build();
	
	SpecifiedCurrency.SpecifiedCurrencyBuilder toBuilder();
	
	static SpecifiedCurrency.SpecifiedCurrencyBuilder builder() {
		return new SpecifiedCurrency.SpecifiedCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpecifiedCurrency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SpecifiedCurrency> getType() {
		return SpecifiedCurrency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpecifiedCurrencyBuilder extends SpecifiedCurrency, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency(int _index);
		List<? extends Currency.CurrencyBuilder> getCurrency();
		SpecifiedCurrency.SpecifiedCurrencyBuilder setApplicable(Boolean applicable);
		SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency currency0);
		SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency currency1, int _idx);
		SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(List<? extends Currency> currency2);
		SpecifiedCurrency.SpecifiedCurrencyBuilder setCurrency(List<? extends Currency> currency3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		SpecifiedCurrency.SpecifiedCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of SpecifiedCurrency  ***********************/
	class SpecifiedCurrencyImpl implements SpecifiedCurrency {
		private final Boolean applicable;
		private final List<? extends Currency> currency;
		
		protected SpecifiedCurrencyImpl(SpecifiedCurrency.SpecifiedCurrencyBuilder builder) {
			this.applicable = builder.getApplicable();
			this.currency = ofNullable(builder.getCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("currency")
		public List<? extends Currency> getCurrency() {
			return currency;
		}
		
		@Override
		public SpecifiedCurrency build() {
			return this;
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder toBuilder() {
			SpecifiedCurrency.SpecifiedCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecifiedCurrency.SpecifiedCurrencyBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedCurrency {" +
				"applicable=" + this.applicable + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of SpecifiedCurrency  ***********************/
	class SpecifiedCurrencyBuilderImpl implements SpecifiedCurrency.SpecifiedCurrencyBuilder {
	
		protected Boolean applicable;
		protected List<Currency.CurrencyBuilder> currency = new ArrayList<>();
	
		public SpecifiedCurrencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("currency")
		public List<? extends Currency.CurrencyBuilder> getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency(int _index) {
		
			if (currency==null) {
				this.currency = new ArrayList<>();
			}
			Currency.CurrencyBuilder result;
			return getIndex(currency, _index, () -> {
						Currency.CurrencyBuilder newCurrency = Currency.builder();
						return newCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("applicable")
		public SpecifiedCurrency.SpecifiedCurrencyBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency currency) {
			if (currency!=null) this.currency.add(currency.toBuilder());
			return this;
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency currency, int _idx) {
			getIndex(this.currency, _idx, () -> currency.toBuilder());
			return this;
		}
		@Override 
		public SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(List<? extends Currency> currencys) {
			if (currencys != null) {
				for (Currency toAdd : currencys) {
					this.currency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SpecifiedCurrency.SpecifiedCurrencyBuilder setCurrency(List<? extends Currency> currencys) {
			if (currencys == null)  {
				this.currency = new ArrayList<>();
			}
			else {
				this.currency = currencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SpecifiedCurrency build() {
			return new SpecifiedCurrency.SpecifiedCurrencyImpl(this);
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder prune() {
			currency = currency.stream().filter(b->b!=null).<Currency.CurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getCurrency()!=null && getCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecifiedCurrency.SpecifiedCurrencyBuilder o = (SpecifiedCurrency.SpecifiedCurrencyBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::getOrCreateCurrency);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedCurrencyBuilder {" +
				"applicable=" + this.applicable + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
