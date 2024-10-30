package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetBuilder;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetBuilderImpl;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetImpl;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.meta.DigitalAssetMeta;
import cdm.base.staticdata.party.LegalEntity;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An Asset that exists only in digital form, eg Bitcoin or Ethereum, that is not backed by other Assets; excludes the digital representation of other Assets, eg coins or Tokenised assets.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="DigitalAsset", builder=DigitalAsset.DigitalAssetBuilderImpl.class, version="6.0.0-dev.76")
public interface DigitalAsset extends AssetBase {

	DigitalAssetMeta metaData = new DigitalAssetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DigitalAsset build();
	
	DigitalAsset.DigitalAssetBuilder toBuilder();
	
	static DigitalAsset.DigitalAssetBuilder builder() {
		return new DigitalAsset.DigitalAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DigitalAsset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DigitalAsset> getType() {
		return DigitalAsset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DigitalAssetBuilder extends DigitalAsset, AssetBase.AssetBaseBuilder {
		DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier identifier0);
		DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		DigitalAsset.DigitalAssetBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		DigitalAsset.DigitalAssetBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy taxonomy0);
		DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		DigitalAsset.DigitalAssetBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		DigitalAsset.DigitalAssetBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		DigitalAsset.DigitalAssetBuilder setIsExchangeListed(Boolean isExchangeListed);
		DigitalAsset.DigitalAssetBuilder setExchange(LegalEntity exchange);
		DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity relatedExchange0);
		DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		DigitalAsset.DigitalAssetBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		DigitalAsset.DigitalAssetBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
		}
		

		DigitalAsset.DigitalAssetBuilder prune();
	}

	/*********************** Immutable Implementation of DigitalAsset  ***********************/
	class DigitalAssetImpl extends AssetBase.AssetBaseImpl implements DigitalAsset {
		
		protected DigitalAssetImpl(DigitalAsset.DigitalAssetBuilder builder) {
			super(builder);
		}
		
		@Override
		public DigitalAsset build() {
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder toBuilder() {
			DigitalAsset.DigitalAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DigitalAsset.DigitalAssetBuilder builder) {
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
			return "DigitalAsset {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DigitalAsset  ***********************/
	class DigitalAssetBuilderImpl extends AssetBase.AssetBaseBuilderImpl  implements DigitalAsset.DigitalAssetBuilder {
	
	
		public DigitalAssetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("identifier")
		public DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public DigitalAsset.DigitalAssetBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DigitalAsset.DigitalAssetBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public DigitalAsset.DigitalAssetBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DigitalAsset.DigitalAssetBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public DigitalAsset.DigitalAssetBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public DigitalAsset.DigitalAssetBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public DigitalAsset.DigitalAssetBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DigitalAsset.DigitalAssetBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public DigitalAsset build() {
			return new DigitalAsset.DigitalAssetImpl(this);
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigitalAsset.DigitalAssetBuilder prune() {
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
		public DigitalAsset.DigitalAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DigitalAsset.DigitalAssetBuilder o = (DigitalAsset.DigitalAssetBuilder) other;
			
			
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
			return "DigitalAssetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
