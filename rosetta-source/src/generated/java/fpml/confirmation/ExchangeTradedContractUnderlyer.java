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
import fpml.confirmation.Asset;
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder;
import fpml.confirmation.ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilderImpl;
import fpml.confirmation.ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerImpl;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.ExchangeTradedContractUnderlyerMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing a single underlyer
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeTradedContractUnderlyer", builder=ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilderImpl.class, version="${project.version}")
public interface ExchangeTradedContractUnderlyer extends RosettaModelObject {

	ExchangeTradedContractUnderlyerMeta metaData = new ExchangeTradedContractUnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndexModel getFloatingRateIndexModel();
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	List<? extends Asset> getUnderlyingAsset();

	/*********************** Build Methods  ***********************/
	ExchangeTradedContractUnderlyer build();
	
	ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder toBuilder();
	
	static ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder() {
		return new ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedContractUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeTradedContractUnderlyer> getType() {
		return ExchangeTradedContractUnderlyer.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.class, getFloatingRateIndexModel());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedContractUnderlyerBuilder extends ExchangeTradedContractUnderlyer, RosettaModelObjectBuilder {
		FloatingRateIndexModel.FloatingRateIndexModelBuilder getOrCreateFloatingRateIndexModel();
		FloatingRateIndexModel.FloatingRateIndexModelBuilder getFloatingRateIndexModel();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		Asset.AssetBuilder getOrCreateUnderlyingAsset(int _index);
		List<? extends Asset.AssetBuilder> getUnderlyingAsset();
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset underlyingAsset0);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset underlyingAsset1, int _idx);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(List<? extends Asset> underlyingAsset2);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setUnderlyingAsset(List<? extends Asset> underlyingAsset3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.FloatingRateIndexModelBuilder.class, getFloatingRateIndexModel());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
		}
		

		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedContractUnderlyer  ***********************/
	class ExchangeTradedContractUnderlyerImpl implements ExchangeTradedContractUnderlyer {
		private final FloatingRateIndexModel floatingRateIndexModel;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final List<? extends Asset> underlyingAsset;
		
		protected ExchangeTradedContractUnderlyerImpl(ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder) {
			this.floatingRateIndexModel = ofNullable(builder.getFloatingRateIndexModel()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRateIndexModel getFloatingRateIndexModel() {
			return floatingRateIndexModel;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public List<? extends Asset> getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer build() {
			return this;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder toBuilder() {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder) {
			ofNullable(getFloatingRateIndexModel()).ifPresent(builder::setFloatingRateIndexModel);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeTradedContractUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexModel, _that.getFloatingRateIndexModel())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!ListEquals.listEquals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndexModel != null ? floatingRateIndexModel.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContractUnderlyer {" +
				"floatingRateIndexModel=" + this.floatingRateIndexModel + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"underlyingAsset=" + this.underlyingAsset +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeTradedContractUnderlyer  ***********************/
	class ExchangeTradedContractUnderlyerBuilderImpl implements ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder {
	
		protected FloatingRateIndexModel.FloatingRateIndexModelBuilder floatingRateIndexModel;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected List<Asset.AssetBuilder> underlyingAsset = new ArrayList<>();
	
		public ExchangeTradedContractUnderlyerBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder getFloatingRateIndexModel() {
			return floatingRateIndexModel;
		}
		
		@Override
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder getOrCreateFloatingRateIndexModel() {
			FloatingRateIndexModel.FloatingRateIndexModelBuilder result;
			if (floatingRateIndexModel!=null) {
				result = floatingRateIndexModel;
			}
			else {
				result = floatingRateIndexModel = FloatingRateIndexModel.builder();
			}
			
			return result;
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
		@RosettaAttribute("underlyingAsset")
		public List<? extends Asset.AssetBuilder> getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		public Asset.AssetBuilder getOrCreateUnderlyingAsset(int _index) {
		
			if (underlyingAsset==null) {
				this.underlyingAsset = new ArrayList<>();
			}
			Asset.AssetBuilder result;
			return getIndex(underlyingAsset, _index, () -> {
						Asset.AssetBuilder newUnderlyingAsset = Asset.builder();
						return newUnderlyingAsset;
					});
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel) {
			this.floatingRateIndexModel = floatingRateIndexModel==null?null:floatingRateIndexModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset underlyingAsset) {
			if (underlyingAsset!=null) this.underlyingAsset.add(underlyingAsset.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset underlyingAsset, int _idx) {
			getIndex(this.underlyingAsset, _idx, () -> underlyingAsset.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(List<? extends Asset> underlyingAssets) {
			if (underlyingAssets != null) {
				for (Asset toAdd : underlyingAssets) {
					this.underlyingAsset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("underlyingAsset")
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setUnderlyingAsset(List<? extends Asset> underlyingAssets) {
			if (underlyingAssets == null)  {
				this.underlyingAsset = new ArrayList<>();
			}
			else {
				this.underlyingAsset = underlyingAssets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ExchangeTradedContractUnderlyer build() {
			return new ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerImpl(this);
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder prune() {
			if (floatingRateIndexModel!=null && !floatingRateIndexModel.prune().hasData()) floatingRateIndexModel = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			underlyingAsset = underlyingAsset.stream().filter(b->b!=null).<Asset.AssetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndexModel()!=null && getFloatingRateIndexModel().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder o = (ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndexModel(), o.getFloatingRateIndexModel(), this::setFloatingRateIndexModel);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::getOrCreateUnderlyingAsset);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeTradedContractUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexModel, _that.getFloatingRateIndexModel())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!ListEquals.listEquals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndexModel != null ? floatingRateIndexModel.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContractUnderlyerBuilder {" +
				"floatingRateIndexModel=" + this.floatingRateIndexModel + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"underlyingAsset=" + this.underlyingAsset +
			'}';
		}
	}
}
