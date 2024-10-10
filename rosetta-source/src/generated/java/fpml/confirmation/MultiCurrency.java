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
import fpml.confirmation.MultiCurrency;
import fpml.confirmation.MultiCurrency.MultiCurrencyBuilder;
import fpml.confirmation.MultiCurrency.MultiCurrencyBuilderImpl;
import fpml.confirmation.MultiCurrency.MultiCurrencyImpl;
import fpml.confirmation.meta.MultiCurrencyMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A struture that defines all the currencies in which funds can be drawn against a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="MultiCurrency", builder=MultiCurrency.MultiCurrencyBuilderImpl.class, version="${project.version}")
public interface MultiCurrency extends RosettaModelObject {

	MultiCurrencyMeta metaData = new MultiCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * List of currencies in which the borrower(s) may draw funds.
	 */
	List<? extends Currency> getDrawCurrency();

	/*********************** Build Methods  ***********************/
	MultiCurrency build();
	
	MultiCurrency.MultiCurrencyBuilder toBuilder();
	
	static MultiCurrency.MultiCurrencyBuilder builder() {
		return new MultiCurrency.MultiCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MultiCurrency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MultiCurrency> getType() {
		return MultiCurrency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("drawCurrency"), processor, Currency.class, getDrawCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MultiCurrencyBuilder extends MultiCurrency, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateDrawCurrency(int _index);
		List<? extends Currency.CurrencyBuilder> getDrawCurrency();
		MultiCurrency.MultiCurrencyBuilder addDrawCurrency(Currency drawCurrency0);
		MultiCurrency.MultiCurrencyBuilder addDrawCurrency(Currency drawCurrency1, int _idx);
		MultiCurrency.MultiCurrencyBuilder addDrawCurrency(List<? extends Currency> drawCurrency2);
		MultiCurrency.MultiCurrencyBuilder setDrawCurrency(List<? extends Currency> drawCurrency3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("drawCurrency"), processor, Currency.CurrencyBuilder.class, getDrawCurrency());
		}
		

		MultiCurrency.MultiCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of MultiCurrency  ***********************/
	class MultiCurrencyImpl implements MultiCurrency {
		private final List<? extends Currency> drawCurrency;
		
		protected MultiCurrencyImpl(MultiCurrency.MultiCurrencyBuilder builder) {
			this.drawCurrency = ofNullable(builder.getDrawCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("drawCurrency")
		public List<? extends Currency> getDrawCurrency() {
			return drawCurrency;
		}
		
		@Override
		public MultiCurrency build() {
			return this;
		}
		
		@Override
		public MultiCurrency.MultiCurrencyBuilder toBuilder() {
			MultiCurrency.MultiCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MultiCurrency.MultiCurrencyBuilder builder) {
			ofNullable(getDrawCurrency()).ifPresent(builder::setDrawCurrency);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultiCurrency _that = getType().cast(o);
		
			if (!ListEquals.listEquals(drawCurrency, _that.getDrawCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drawCurrency != null ? drawCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultiCurrency {" +
				"drawCurrency=" + this.drawCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of MultiCurrency  ***********************/
	class MultiCurrencyBuilderImpl implements MultiCurrency.MultiCurrencyBuilder {
	
		protected List<Currency.CurrencyBuilder> drawCurrency = new ArrayList<>();
	
		public MultiCurrencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("drawCurrency")
		public List<? extends Currency.CurrencyBuilder> getDrawCurrency() {
			return drawCurrency;
		}
		
		public Currency.CurrencyBuilder getOrCreateDrawCurrency(int _index) {
		
			if (drawCurrency==null) {
				this.drawCurrency = new ArrayList<>();
			}
			Currency.CurrencyBuilder result;
			return getIndex(drawCurrency, _index, () -> {
						Currency.CurrencyBuilder newDrawCurrency = Currency.builder();
						return newDrawCurrency;
					});
		}
		
		@Override
		public MultiCurrency.MultiCurrencyBuilder addDrawCurrency(Currency drawCurrency) {
			if (drawCurrency!=null) this.drawCurrency.add(drawCurrency.toBuilder());
			return this;
		}
		
		@Override
		public MultiCurrency.MultiCurrencyBuilder addDrawCurrency(Currency drawCurrency, int _idx) {
			getIndex(this.drawCurrency, _idx, () -> drawCurrency.toBuilder());
			return this;
		}
		@Override 
		public MultiCurrency.MultiCurrencyBuilder addDrawCurrency(List<? extends Currency> drawCurrencys) {
			if (drawCurrencys != null) {
				for (Currency toAdd : drawCurrencys) {
					this.drawCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("drawCurrency")
		public MultiCurrency.MultiCurrencyBuilder setDrawCurrency(List<? extends Currency> drawCurrencys) {
			if (drawCurrencys == null)  {
				this.drawCurrency = new ArrayList<>();
			}
			else {
				this.drawCurrency = drawCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public MultiCurrency build() {
			return new MultiCurrency.MultiCurrencyImpl(this);
		}
		
		@Override
		public MultiCurrency.MultiCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultiCurrency.MultiCurrencyBuilder prune() {
			drawCurrency = drawCurrency.stream().filter(b->b!=null).<Currency.CurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDrawCurrency()!=null && getDrawCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultiCurrency.MultiCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MultiCurrency.MultiCurrencyBuilder o = (MultiCurrency.MultiCurrencyBuilder) other;
			
			merger.mergeRosetta(getDrawCurrency(), o.getDrawCurrency(), this::getOrCreateDrawCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultiCurrency _that = getType().cast(o);
		
			if (!ListEquals.listEquals(drawCurrency, _that.getDrawCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drawCurrency != null ? drawCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultiCurrencyBuilder {" +
				"drawCurrency=" + this.drawCurrency +
			'}';
		}
	}
}
