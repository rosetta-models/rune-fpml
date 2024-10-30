package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Basket.BasketBuilder;
import cdm.observable.asset.Basket.BasketBuilderImpl;
import cdm.observable.asset.Basket.BasketImpl;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.meta.BasketMeta;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a custom basket by referencing an identifier and its constituents.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="Basket", builder=Basket.BasketBuilderImpl.class, version="6.0.0-dev.76")
public interface Basket extends AssetBase {

	BasketMeta metaData = new BasketMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the constituents of the basket
	 */
	List<? extends FieldWithMetaBasketConstituent> getBasketConstituent();

	/*********************** Build Methods  ***********************/
	Basket build();
	
	Basket.BasketBuilder toBuilder();
	
	static Basket.BasketBuilder builder() {
		return new Basket.BasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Basket> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Basket> getType() {
		return Basket.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("basketConstituent"), processor, FieldWithMetaBasketConstituent.class, getBasketConstituent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketBuilder extends Basket, AssetBase.AssetBaseBuilder {
		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder getOrCreateBasketConstituent(int _index);
		List<? extends FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> getBasketConstituent();
		Basket.BasketBuilder addIdentifier(AssetIdentifier identifier0);
		Basket.BasketBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		Basket.BasketBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		Basket.BasketBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy0);
		Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		Basket.BasketBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		Basket.BasketBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		Basket.BasketBuilder setIsExchangeListed(Boolean isExchangeListed);
		Basket.BasketBuilder setExchange(LegalEntity exchange);
		Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange0);
		Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		Basket.BasketBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		Basket.BasketBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);
		Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent0);
		Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent1, int _idx);
		Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent2);
		Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent3, int _idx);
		Basket.BasketBuilder addBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituent4);
		Basket.BasketBuilder setBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituent5);
		Basket.BasketBuilder addBasketConstituentValue(List<? extends BasketConstituent> basketConstituent6);
		Basket.BasketBuilder setBasketConstituentValue(List<? extends BasketConstituent> basketConstituent7);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("basketConstituent"), processor, FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder.class, getBasketConstituent());
		}
		

		Basket.BasketBuilder prune();
	}

	/*********************** Immutable Implementation of Basket  ***********************/
	class BasketImpl extends AssetBase.AssetBaseImpl implements Basket {
		private final List<? extends FieldWithMetaBasketConstituent> basketConstituent;
		
		protected BasketImpl(Basket.BasketBuilder builder) {
			super(builder);
			this.basketConstituent = ofNullable(builder.getBasketConstituent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		public List<? extends FieldWithMetaBasketConstituent> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public Basket build() {
			return this;
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			Basket.BasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Basket.BasketBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBasketConstituent()).ifPresent(builder::setBasketConstituent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Basket {" +
				"basketConstituent=" + this.basketConstituent +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Basket  ***********************/
	class BasketBuilderImpl extends AssetBase.AssetBaseBuilderImpl  implements Basket.BasketBuilder {
	
		protected List<FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> basketConstituent = new ArrayList<>();
	
		public BasketBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("basketConstituent")
		public List<? extends FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder getOrCreateBasketConstituent(int _index) {
		
			if (basketConstituent==null) {
				this.basketConstituent = new ArrayList<>();
			}
			FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder result;
			return getIndex(basketConstituent, _index, () -> {
						FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder newBasketConstituent = FieldWithMetaBasketConstituent.builder();
						newBasketConstituent.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newBasketConstituent;
					});
		}
		
		@Override
		@RosettaAttribute("identifier")
		public Basket.BasketBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public Basket.BasketBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public Basket.BasketBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public Basket.BasketBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public Basket.BasketBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public Basket.BasketBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		@RosettaAttribute("basketConstituent")
		public Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent) {
			if (basketConstituent!=null) this.basketConstituent.add(basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent, int _idx) {
			getIndex(this.basketConstituent, _idx, () -> basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent) {
			this.getOrCreateBasketConstituent(-1).setValue(basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent, int _idx) {
			this.getOrCreateBasketConstituent(_idx).setValue(basketConstituent.toBuilder());
			return this;
		}
		@Override 
		public Basket.BasketBuilder addBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (FieldWithMetaBasketConstituent toAdd : basketConstituents) {
					this.basketConstituent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder setBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituents) {
			if (basketConstituents == null)  {
				this.basketConstituent = new ArrayList<>();
			}
			else {
				this.basketConstituent = basketConstituents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(List<? extends BasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (BasketConstituent toAdd : basketConstituents) {
					this.addBasketConstituentValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder setBasketConstituentValue(List<? extends BasketConstituent> basketConstituents) {
			this.basketConstituent.clear();
			if (basketConstituents!=null) {
				basketConstituents.forEach(this::addBasketConstituentValue);
			}
			return this;
		}
		
		
		@Override
		public Basket build() {
			return new Basket.BasketImpl(this);
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder prune() {
			super.prune();
			basketConstituent = basketConstituent.stream().filter(b->b!=null).<FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBasketConstituent()!=null && getBasketConstituent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Basket.BasketBuilder o = (Basket.BasketBuilder) other;
			
			merger.mergeRosetta(getBasketConstituent(), o.getBasketConstituent(), this::getOrCreateBasketConstituent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketBuilder {" +
				"basketConstituent=" + this.basketConstituent +
			'}' + " " + super.toString();
		}
	}
}
