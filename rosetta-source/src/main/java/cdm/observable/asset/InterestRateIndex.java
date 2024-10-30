package cdm.observable.asset;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexBuilder;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexBuilderImpl;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexImpl;
import cdm.observable.asset.meta.InterestRateIndexMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specification of an interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="InterestRateIndex", builder=InterestRateIndex.InterestRateIndexBuilderImpl.class, version="6.0.0-dev.76")
public interface InterestRateIndex extends IndexBase {

	InterestRateIndexMeta metaData = new InterestRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reference index that is used to specify the floating interest rate.
	 */
	FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the floating rate tenor.
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	InterestRateIndex build();
	
	InterestRateIndex.InterestRateIndexBuilder toBuilder();
	
	static InterestRateIndex.InterestRateIndexBuilder builder() {
		return new InterestRateIndex.InterestRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestRateIndex> getType() {
		return InterestRateIndex.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("provider"), processor, LegalEntity.class, getProvider());
		processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateIndexBuilder extends InterestRateIndex, IndexBase.IndexBaseBuilder {
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex();
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		Period.PeriodBuilder getIndexTenor();
		InterestRateIndex.InterestRateIndexBuilder addIdentifier(AssetIdentifier identifier0);
		InterestRateIndex.InterestRateIndexBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		InterestRateIndex.InterestRateIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		InterestRateIndex.InterestRateIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		InterestRateIndex.InterestRateIndexBuilder addTaxonomy(Taxonomy taxonomy0);
		InterestRateIndex.InterestRateIndexBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		InterestRateIndex.InterestRateIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		InterestRateIndex.InterestRateIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		InterestRateIndex.InterestRateIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		InterestRateIndex.InterestRateIndexBuilder setExchange(LegalEntity exchange);
		InterestRateIndex.InterestRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange0);
		InterestRateIndex.InterestRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		InterestRateIndex.InterestRateIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		InterestRateIndex.InterestRateIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);
		InterestRateIndex.InterestRateIndexBuilder setName(FieldWithMetaString name0);
		InterestRateIndex.InterestRateIndexBuilder setNameValue(String name1);
		InterestRateIndex.InterestRateIndexBuilder setProvider(LegalEntity provider);
		InterestRateIndex.InterestRateIndexBuilder setAssetClass(AssetClassEnum assetClass);
		InterestRateIndex.InterestRateIndexBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex0);
		InterestRateIndex.InterestRateIndexBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex1);
		InterestRateIndex.InterestRateIndexBuilder setIndexTenor(Period indexTenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("provider"), processor, LegalEntity.LegalEntityBuilder.class, getProvider());
			processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		InterestRateIndex.InterestRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of InterestRateIndex  ***********************/
	class InterestRateIndexImpl extends IndexBase.IndexBaseImpl implements InterestRateIndex {
		private final FieldWithMetaFloatingRateIndexEnum floatingRateIndex;
		private final Period indexTenor;
		
		protected InterestRateIndexImpl(InterestRateIndex.InterestRateIndexBuilder builder) {
			super(builder);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public InterestRateIndex build() {
			return this;
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder toBuilder() {
			InterestRateIndex.InterestRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateIndex.InterestRateIndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateIndex {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestRateIndex  ***********************/
	class InterestRateIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl  implements InterestRateIndex.InterestRateIndexBuilder {
	
		protected FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
	
		public InterestRateIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex() {
			FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FieldWithMetaFloatingRateIndexEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public InterestRateIndex.InterestRateIndexBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public InterestRateIndex.InterestRateIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InterestRateIndex.InterestRateIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		public InterestRateIndex.InterestRateIndexBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public InterestRateIndex.InterestRateIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InterestRateIndex.InterestRateIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys == null)  {
				this.taxonomy = new ArrayList<>();
			}
			else {
				this.taxonomy = taxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("isExchangeListed")
		public InterestRateIndex.InterestRateIndexBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public InterestRateIndex.InterestRateIndexBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public InterestRateIndex.InterestRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public InterestRateIndex.InterestRateIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InterestRateIndex.InterestRateIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges == null)  {
				this.relatedExchange = new ArrayList<>();
			}
			else {
				this.relatedExchange = relatedExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("name")
		public InterestRateIndex.InterestRateIndexBuilder setName(FieldWithMetaString name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		@Override
		public InterestRateIndex.InterestRateIndexBuilder setNameValue(String name) {
			this.getOrCreateName().setValue(name);
			return this;
		}
		@Override
		@RosettaAttribute("provider")
		public InterestRateIndex.InterestRateIndexBuilder setProvider(LegalEntity provider) {
			this.provider = provider==null?null:provider.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("assetClass")
		public InterestRateIndex.InterestRateIndexBuilder setAssetClass(AssetClassEnum assetClass) {
			this.assetClass = assetClass==null?null:assetClass;
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndex")
		public InterestRateIndex.InterestRateIndexBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		public InterestRateIndex.InterestRateIndexBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex) {
			this.getOrCreateFloatingRateIndex().setValue(floatingRateIndex);
			return this;
		}
		@Override
		@RosettaAttribute("indexTenor")
		public InterestRateIndex.InterestRateIndexBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateIndex build() {
			return new InterestRateIndex.InterestRateIndexImpl(this);
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateIndex.InterestRateIndexBuilder prune() {
			super.prune();
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndex()!=null) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateIndex.InterestRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestRateIndex.InterestRateIndexBuilder o = (InterestRateIndex.InterestRateIndexBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateIndexBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}' + " " + super.toString();
		}
	}
}
