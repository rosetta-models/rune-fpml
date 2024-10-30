package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.EquityIndex.EquityIndexBuilder;
import cdm.observable.asset.EquityIndex.EquityIndexBuilderImpl;
import cdm.observable.asset.EquityIndex.EquityIndexImpl;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.meta.EquityIndexMeta;
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
import java.util.stream.Collectors;


/**
 * Specification of an index based on equity securities, e.g. the S&amp;P 500..
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="EquityIndex", builder=EquityIndex.EquityIndexBuilderImpl.class, version="6.0.0-dev.76")
public interface EquityIndex extends IndexBase {

	EquityIndexMeta metaData = new EquityIndexMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	EquityIndex build();
	
	EquityIndex.EquityIndexBuilder toBuilder();
	
	static EquityIndex.EquityIndexBuilder builder() {
		return new EquityIndex.EquityIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityIndex> getType() {
		return EquityIndex.class;
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
	interface EquityIndexBuilder extends EquityIndex, IndexBase.IndexBaseBuilder {
		EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier identifier0);
		EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		EquityIndex.EquityIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		EquityIndex.EquityIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy taxonomy0);
		EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		EquityIndex.EquityIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		EquityIndex.EquityIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		EquityIndex.EquityIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		EquityIndex.EquityIndexBuilder setExchange(LegalEntity exchange);
		EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity relatedExchange0);
		EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		EquityIndex.EquityIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		EquityIndex.EquityIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);
		EquityIndex.EquityIndexBuilder setName(FieldWithMetaString name0);
		EquityIndex.EquityIndexBuilder setNameValue(String name1);
		EquityIndex.EquityIndexBuilder setProvider(LegalEntity provider);
		EquityIndex.EquityIndexBuilder setAssetClass(AssetClassEnum assetClass);

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
		

		EquityIndex.EquityIndexBuilder prune();
	}

	/*********************** Immutable Implementation of EquityIndex  ***********************/
	class EquityIndexImpl extends IndexBase.IndexBaseImpl implements EquityIndex {
		
		protected EquityIndexImpl(EquityIndex.EquityIndexBuilder builder) {
			super(builder);
		}
		
		@Override
		public EquityIndex build() {
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder toBuilder() {
			EquityIndex.EquityIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityIndex.EquityIndexBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityIndex {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityIndex  ***********************/
	class EquityIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl  implements EquityIndex.EquityIndexBuilder {
	
	
		public EquityIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("identifier")
		public EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public EquityIndex.EquityIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EquityIndex.EquityIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public EquityIndex.EquityIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EquityIndex.EquityIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public EquityIndex.EquityIndexBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public EquityIndex.EquityIndexBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public EquityIndex.EquityIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EquityIndex.EquityIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public EquityIndex.EquityIndexBuilder setName(FieldWithMetaString name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		@Override
		public EquityIndex.EquityIndexBuilder setNameValue(String name) {
			this.getOrCreateName().setValue(name);
			return this;
		}
		@Override
		@RosettaAttribute("provider")
		public EquityIndex.EquityIndexBuilder setProvider(LegalEntity provider) {
			this.provider = provider==null?null:provider.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("assetClass")
		public EquityIndex.EquityIndexBuilder setAssetClass(AssetClassEnum assetClass) {
			this.assetClass = assetClass==null?null:assetClass;
			return this;
		}
		
		@Override
		public EquityIndex build() {
			return new EquityIndex.EquityIndexImpl(this);
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityIndex.EquityIndexBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityIndex.EquityIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityIndex.EquityIndexBuilder o = (EquityIndex.EquityIndexBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityIndexBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
