package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.meta.IndexBaseMeta;
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
 * Identifies an index by referencing an identifier.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="IndexBase", builder=IndexBase.IndexBaseBuilderImpl.class, version="6.0.0-dev.76")
public interface IndexBase extends AssetBase {

	IndexBaseMeta metaData = new IndexBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A description of the Index.
	 */
	FieldWithMetaString getName();
	/**
	 * The organisation that creates or maintains the Index.
	 */
	LegalEntity getProvider();
	/**
	 * The Asset Class of the Index.
	 */
	AssetClassEnum getAssetClass();

	/*********************** Build Methods  ***********************/
	IndexBase build();
	
	IndexBase.IndexBaseBuilder toBuilder();
	
	static IndexBase.IndexBaseBuilder builder() {
		return new IndexBase.IndexBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexBase> getType() {
		return IndexBase.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexBaseBuilder extends IndexBase, AssetBase.AssetBaseBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName();
		FieldWithMetaString.FieldWithMetaStringBuilder getName();
		LegalEntity.LegalEntityBuilder getOrCreateProvider();
		LegalEntity.LegalEntityBuilder getProvider();
		IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier identifier0);
		IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		IndexBase.IndexBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		IndexBase.IndexBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy taxonomy0);
		IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		IndexBase.IndexBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		IndexBase.IndexBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		IndexBase.IndexBaseBuilder setIsExchangeListed(Boolean isExchangeListed);
		IndexBase.IndexBaseBuilder setExchange(LegalEntity exchange);
		IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity relatedExchange0);
		IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		IndexBase.IndexBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		IndexBase.IndexBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);
		IndexBase.IndexBaseBuilder setName(FieldWithMetaString name0);
		IndexBase.IndexBaseBuilder setNameValue(String name1);
		IndexBase.IndexBaseBuilder setProvider(LegalEntity provider);
		IndexBase.IndexBaseBuilder setAssetClass(AssetClassEnum assetClass);

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
		}
		

		IndexBase.IndexBaseBuilder prune();
	}

	/*********************** Immutable Implementation of IndexBase  ***********************/
	class IndexBaseImpl extends AssetBase.AssetBaseImpl implements IndexBase {
		private final FieldWithMetaString name;
		private final LegalEntity provider;
		private final AssetClassEnum assetClass;
		
		protected IndexBaseImpl(IndexBase.IndexBaseBuilder builder) {
			super(builder);
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.provider = ofNullable(builder.getProvider()).map(f->f.build()).orElse(null);
			this.assetClass = builder.getAssetClass();
		}
		
		@Override
		@RosettaAttribute("name")
		public FieldWithMetaString getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("provider")
		public LegalEntity getProvider() {
			return provider;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		public AssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@Override
		public IndexBase build() {
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder toBuilder() {
			IndexBase.IndexBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexBase.IndexBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getProvider()).ifPresent(builder::setProvider);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexBase _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(provider, _that.getProvider())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (provider != null ? provider.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBase {" +
				"name=" + this.name + ", " +
				"provider=" + this.provider + ", " +
				"assetClass=" + this.assetClass +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IndexBase  ***********************/
	class IndexBaseBuilderImpl extends AssetBase.AssetBaseBuilderImpl  implements IndexBase.IndexBaseBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder name;
		protected LegalEntity.LegalEntityBuilder provider;
		protected AssetClassEnum assetClass;
	
		public IndexBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public FieldWithMetaString.FieldWithMetaStringBuilder getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("provider")
		public LegalEntity.LegalEntityBuilder getProvider() {
			return provider;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateProvider() {
			LegalEntity.LegalEntityBuilder result;
			if (provider!=null) {
				result = provider;
			}
			else {
				result = provider = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		public AssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public IndexBase.IndexBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndexBase.IndexBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public IndexBase.IndexBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndexBase.IndexBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public IndexBase.IndexBaseBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public IndexBase.IndexBaseBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public IndexBase.IndexBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndexBase.IndexBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public IndexBase.IndexBaseBuilder setName(FieldWithMetaString name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		@Override
		public IndexBase.IndexBaseBuilder setNameValue(String name) {
			this.getOrCreateName().setValue(name);
			return this;
		}
		@Override
		@RosettaAttribute("provider")
		public IndexBase.IndexBaseBuilder setProvider(LegalEntity provider) {
			this.provider = provider==null?null:provider.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("assetClass")
		public IndexBase.IndexBaseBuilder setAssetClass(AssetClassEnum assetClass) {
			this.assetClass = assetClass==null?null:assetClass;
			return this;
		}
		
		@Override
		public IndexBase build() {
			return new IndexBase.IndexBaseImpl(this);
		}
		
		@Override
		public IndexBase.IndexBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexBase.IndexBaseBuilder prune() {
			super.prune();
			if (name!=null && !name.prune().hasData()) name = null;
			if (provider!=null && !provider.prune().hasData()) provider = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getName()!=null) return true;
			if (getProvider()!=null && getProvider().hasData()) return true;
			if (getAssetClass()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexBase.IndexBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IndexBase.IndexBaseBuilder o = (IndexBase.IndexBaseBuilder) other;
			
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getProvider(), o.getProvider(), this::setProvider);
			
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClass);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexBase _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(provider, _that.getProvider())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (provider != null ? provider.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBaseBuilder {" +
				"name=" + this.name + ", " +
				"provider=" + this.provider + ", " +
				"assetClass=" + this.assetClass +
			'}' + " " + super.toString();
		}
	}
}
