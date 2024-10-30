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
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxRateObservable;
import fpml.confirmation.FxRateObservable.FxRateObservableBuilder;
import fpml.confirmation.FxRateObservable.FxRateObservableBuilderImpl;
import fpml.confirmation.FxRateObservable.FxRateObservableImpl;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxRateObservableMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxRateObservable", builder=FxRateObservable.FxRateObservableBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxRateObservable extends RosettaModelObject {

	FxRateObservableMeta metaData = new FxRateObservableMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * FX rate to be observed. The Quoted Currency Pair that is used across the product.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * Information source for fixing the exchange rate. It is the same for all fixing periods.
	 */
	FxInformationSource getInformationSource();
	/**
	 * Contains the currency exchange rates information used to cross between the traded currencies for non-base currency FX contracts.
	 */
	List<? extends FxCrossRateObservable> getCrossRate();
	String getId();

	/*********************** Build Methods  ***********************/
	FxRateObservable build();
	
	FxRateObservable.FxRateObservableBuilder toBuilder();
	
	static FxRateObservable.FxRateObservableBuilder builder() {
		return new FxRateObservable.FxRateObservableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRateObservable> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxRateObservable> getType() {
		return FxRateObservable.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.class, getCrossRate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRateObservableBuilder extends FxRateObservable, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxInformationSource.FxInformationSourceBuilder getOrCreateInformationSource();
		FxInformationSource.FxInformationSourceBuilder getInformationSource();
		FxCrossRateObservable.FxCrossRateObservableBuilder getOrCreateCrossRate(int _index);
		List<? extends FxCrossRateObservable.FxCrossRateObservableBuilder> getCrossRate();
		FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxRateObservable.FxRateObservableBuilder setInformationSource(FxInformationSource informationSource);
		FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable crossRate0);
		FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable crossRate1, int _idx);
		FxRateObservable.FxRateObservableBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate2);
		FxRateObservable.FxRateObservableBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate3);
		FxRateObservable.FxRateObservableBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.FxCrossRateObservableBuilder.class, getCrossRate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxRateObservable.FxRateObservableBuilder prune();
	}

	/*********************** Immutable Implementation of FxRateObservable  ***********************/
	class FxRateObservableImpl implements FxRateObservable {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final FxInformationSource informationSource;
		private final List<? extends FxCrossRateObservable> crossRate;
		private final String id;
		
		protected FxRateObservableImpl(FxRateObservable.FxRateObservableBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.crossRate = ofNullable(builder.getCrossRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public FxInformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		public List<? extends FxCrossRateObservable> getCrossRate() {
			return crossRate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxRateObservable build() {
			return this;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder toBuilder() {
			FxRateObservable.FxRateObservableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateObservable.FxRateObservableBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getCrossRate()).ifPresent(builder::setCrossRate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservable {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource + ", " +
				"crossRate=" + this.crossRate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxRateObservable  ***********************/
	class FxRateObservableBuilderImpl implements FxRateObservable.FxRateObservableBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected FxInformationSource.FxInformationSourceBuilder informationSource;
		protected List<FxCrossRateObservable.FxCrossRateObservableBuilder> crossRate = new ArrayList<>();
		protected String id;
	
		public FxRateObservableBuilderImpl() {
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
		@RosettaAttribute("informationSource")
		public FxInformationSource.FxInformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder getOrCreateInformationSource() {
			FxInformationSource.FxInformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = FxInformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		public List<? extends FxCrossRateObservable.FxCrossRateObservableBuilder> getCrossRate() {
			return crossRate;
		}
		
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder getOrCreateCrossRate(int _index) {
		
			if (crossRate==null) {
				this.crossRate = new ArrayList<>();
			}
			FxCrossRateObservable.FxCrossRateObservableBuilder result;
			return getIndex(crossRate, _index, () -> {
						FxCrossRateObservable.FxCrossRateObservableBuilder newCrossRate = FxCrossRateObservable.builder();
						return newCrossRate;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public FxRateObservable.FxRateObservableBuilder setInformationSource(FxInformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("crossRate")
		public FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable crossRate) {
			if (crossRate!=null) this.crossRate.add(crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable crossRate, int _idx) {
			getIndex(this.crossRate, _idx, () -> crossRate.toBuilder());
			return this;
		}
		@Override 
		public FxRateObservable.FxRateObservableBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates != null) {
				for (FxCrossRateObservable toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxRateObservable.FxRateObservableBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
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
		@RosettaAttribute("id")
		public FxRateObservable.FxRateObservableBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxRateObservable build() {
			return new FxRateObservable.FxRateObservableImpl(this);
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservable.FxRateObservableBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			crossRate = crossRate.stream().filter(b->b!=null).<FxCrossRateObservable.FxCrossRateObservableBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getCrossRate()!=null && getCrossRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservable.FxRateObservableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxRateObservable.FxRateObservableBuilder o = (FxRateObservable.FxRateObservableBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getCrossRate(), o.getCrossRate(), this::getOrCreateCrossRate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservableBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource + ", " +
				"crossRate=" + this.crossRate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
