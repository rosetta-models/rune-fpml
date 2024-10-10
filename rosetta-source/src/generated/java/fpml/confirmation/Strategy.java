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
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ProductReference;
import fpml.confirmation.Strategy;
import fpml.confirmation.Strategy.StrategyBuilder;
import fpml.confirmation.Strategy.StrategyBuilderImpl;
import fpml.confirmation.Strategy.StrategyImpl;
import fpml.confirmation.StrategyComponentIdentification;
import fpml.confirmation.meta.StrategyMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A strategy product. A type defining a group of products making up a single trade.
 * @version ${project.version}
 */
@RosettaDataType(value="Strategy", builder=Strategy.StrategyBuilderImpl.class, version="${project.version}")
public interface Strategy extends Product {

	StrategyMeta metaData = new StrategyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Provides distinct identification for a component of a strategy.
	 */
	List<? extends StrategyComponentIdentification> getStrategyComponentIdentifier();
	/**
	 * Indicates which product within a strategy represents the premium payment.
	 */
	ProductReference getPremiumProductReference();
	List<? extends Product> getProduct();

	/*********************** Build Methods  ***********************/
	Strategy build();
	
	Strategy.StrategyBuilder toBuilder();
	
	static Strategy.StrategyBuilder builder() {
		return new Strategy.StrategyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Strategy> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Strategy> getType() {
		return Strategy.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("strategyComponentIdentifier"), processor, StrategyComponentIdentification.class, getStrategyComponentIdentifier());
		processRosetta(path.newSubPath("premiumProductReference"), processor, ProductReference.class, getPremiumProductReference());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrategyBuilder extends Strategy, Product.ProductBuilder {
		StrategyComponentIdentification.StrategyComponentIdentificationBuilder getOrCreateStrategyComponentIdentifier(int _index);
		List<? extends StrategyComponentIdentification.StrategyComponentIdentificationBuilder> getStrategyComponentIdentifier();
		ProductReference.ProductReferenceBuilder getOrCreatePremiumProductReference();
		ProductReference.ProductReferenceBuilder getPremiumProductReference();
		Product.ProductBuilder getOrCreateProduct(int _index);
		List<? extends Product.ProductBuilder> getProduct();
		Strategy.StrategyBuilder setProductModel(ProductModel productModel);
		Strategy.StrategyBuilder setId(String id);
		Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification strategyComponentIdentifier0);
		Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification strategyComponentIdentifier1, int _idx);
		Strategy.StrategyBuilder addStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifier2);
		Strategy.StrategyBuilder setStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifier3);
		Strategy.StrategyBuilder setPremiumProductReference(ProductReference premiumProductReference);
		Strategy.StrategyBuilder addProduct(Product product0);
		Strategy.StrategyBuilder addProduct(Product product1, int _idx);
		Strategy.StrategyBuilder addProduct(List<? extends Product> product2);
		Strategy.StrategyBuilder setProduct(List<? extends Product> product3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("strategyComponentIdentifier"), processor, StrategyComponentIdentification.StrategyComponentIdentificationBuilder.class, getStrategyComponentIdentifier());
			processRosetta(path.newSubPath("premiumProductReference"), processor, ProductReference.ProductReferenceBuilder.class, getPremiumProductReference());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
		}
		

		Strategy.StrategyBuilder prune();
	}

	/*********************** Immutable Implementation of Strategy  ***********************/
	class StrategyImpl extends Product.ProductImpl implements Strategy {
		private final List<? extends StrategyComponentIdentification> strategyComponentIdentifier;
		private final ProductReference premiumProductReference;
		private final List<? extends Product> product;
		
		protected StrategyImpl(Strategy.StrategyBuilder builder) {
			super(builder);
			this.strategyComponentIdentifier = ofNullable(builder.getStrategyComponentIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premiumProductReference = ofNullable(builder.getPremiumProductReference()).map(f->f.build()).orElse(null);
			this.product = ofNullable(builder.getProduct()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strategyComponentIdentifier")
		public List<? extends StrategyComponentIdentification> getStrategyComponentIdentifier() {
			return strategyComponentIdentifier;
		}
		
		@Override
		@RosettaAttribute("premiumProductReference")
		public ProductReference getPremiumProductReference() {
			return premiumProductReference;
		}
		
		@Override
		@RosettaAttribute("product")
		public List<? extends Product> getProduct() {
			return product;
		}
		
		@Override
		public Strategy build() {
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder toBuilder() {
			Strategy.StrategyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Strategy.StrategyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrategyComponentIdentifier()).ifPresent(builder::setStrategyComponentIdentifier);
			ofNullable(getPremiumProductReference()).ifPresent(builder::setPremiumProductReference);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Strategy _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strategyComponentIdentifier, _that.getStrategyComponentIdentifier())) return false;
			if (!Objects.equals(premiumProductReference, _that.getPremiumProductReference())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strategyComponentIdentifier != null ? strategyComponentIdentifier.hashCode() : 0);
			_result = 31 * _result + (premiumProductReference != null ? premiumProductReference.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Strategy {" +
				"strategyComponentIdentifier=" + this.strategyComponentIdentifier + ", " +
				"premiumProductReference=" + this.premiumProductReference + ", " +
				"product=" + this.product +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Strategy  ***********************/
	class StrategyBuilderImpl extends Product.ProductBuilderImpl  implements Strategy.StrategyBuilder {
	
		protected List<StrategyComponentIdentification.StrategyComponentIdentificationBuilder> strategyComponentIdentifier = new ArrayList<>();
		protected ProductReference.ProductReferenceBuilder premiumProductReference;
		protected List<Product.ProductBuilder> product = new ArrayList<>();
	
		public StrategyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strategyComponentIdentifier")
		public List<? extends StrategyComponentIdentification.StrategyComponentIdentificationBuilder> getStrategyComponentIdentifier() {
			return strategyComponentIdentifier;
		}
		
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder getOrCreateStrategyComponentIdentifier(int _index) {
		
			if (strategyComponentIdentifier==null) {
				this.strategyComponentIdentifier = new ArrayList<>();
			}
			StrategyComponentIdentification.StrategyComponentIdentificationBuilder result;
			return getIndex(strategyComponentIdentifier, _index, () -> {
						StrategyComponentIdentification.StrategyComponentIdentificationBuilder newStrategyComponentIdentifier = StrategyComponentIdentification.builder();
						return newStrategyComponentIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("premiumProductReference")
		public ProductReference.ProductReferenceBuilder getPremiumProductReference() {
			return premiumProductReference;
		}
		
		@Override
		public ProductReference.ProductReferenceBuilder getOrCreatePremiumProductReference() {
			ProductReference.ProductReferenceBuilder result;
			if (premiumProductReference!=null) {
				result = premiumProductReference;
			}
			else {
				result = premiumProductReference = ProductReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("product")
		public List<? extends Product.ProductBuilder> getProduct() {
			return product;
		}
		
		public Product.ProductBuilder getOrCreateProduct(int _index) {
		
			if (product==null) {
				this.product = new ArrayList<>();
			}
			Product.ProductBuilder result;
			return getIndex(product, _index, () -> {
						Product.ProductBuilder newProduct = Product.builder();
						return newProduct;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public Strategy.StrategyBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Strategy.StrategyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification strategyComponentIdentifier) {
			if (strategyComponentIdentifier!=null) this.strategyComponentIdentifier.add(strategyComponentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addStrategyComponentIdentifier(StrategyComponentIdentification strategyComponentIdentifier, int _idx) {
			getIndex(this.strategyComponentIdentifier, _idx, () -> strategyComponentIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Strategy.StrategyBuilder addStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifiers) {
			if (strategyComponentIdentifiers != null) {
				for (StrategyComponentIdentification toAdd : strategyComponentIdentifiers) {
					this.strategyComponentIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("strategyComponentIdentifier")
		public Strategy.StrategyBuilder setStrategyComponentIdentifier(List<? extends StrategyComponentIdentification> strategyComponentIdentifiers) {
			if (strategyComponentIdentifiers == null)  {
				this.strategyComponentIdentifier = new ArrayList<>();
			}
			else {
				this.strategyComponentIdentifier = strategyComponentIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("premiumProductReference")
		public Strategy.StrategyBuilder setPremiumProductReference(ProductReference premiumProductReference) {
			this.premiumProductReference = premiumProductReference==null?null:premiumProductReference.toBuilder();
			return this;
		}
		@Override
		public Strategy.StrategyBuilder addProduct(Product product) {
			if (product!=null) this.product.add(product.toBuilder());
			return this;
		}
		
		@Override
		public Strategy.StrategyBuilder addProduct(Product product, int _idx) {
			getIndex(this.product, _idx, () -> product.toBuilder());
			return this;
		}
		@Override 
		public Strategy.StrategyBuilder addProduct(List<? extends Product> products) {
			if (products != null) {
				for (Product toAdd : products) {
					this.product.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("product")
		public Strategy.StrategyBuilder setProduct(List<? extends Product> products) {
			if (products == null)  {
				this.product = new ArrayList<>();
			}
			else {
				this.product = products.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Strategy build() {
			return new Strategy.StrategyImpl(this);
		}
		
		@Override
		public Strategy.StrategyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strategy.StrategyBuilder prune() {
			super.prune();
			strategyComponentIdentifier = strategyComponentIdentifier.stream().filter(b->b!=null).<StrategyComponentIdentification.StrategyComponentIdentificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (premiumProductReference!=null && !premiumProductReference.prune().hasData()) premiumProductReference = null;
			product = product.stream().filter(b->b!=null).<Product.ProductBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrategyComponentIdentifier()!=null && getStrategyComponentIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremiumProductReference()!=null && getPremiumProductReference().hasData()) return true;
			if (getProduct()!=null && getProduct().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strategy.StrategyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Strategy.StrategyBuilder o = (Strategy.StrategyBuilder) other;
			
			merger.mergeRosetta(getStrategyComponentIdentifier(), o.getStrategyComponentIdentifier(), this::getOrCreateStrategyComponentIdentifier);
			merger.mergeRosetta(getPremiumProductReference(), o.getPremiumProductReference(), this::setPremiumProductReference);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::getOrCreateProduct);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Strategy _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strategyComponentIdentifier, _that.getStrategyComponentIdentifier())) return false;
			if (!Objects.equals(premiumProductReference, _that.getPremiumProductReference())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strategyComponentIdentifier != null ? strategyComponentIdentifier.hashCode() : 0);
			_result = 31 * _result + (premiumProductReference != null ? premiumProductReference.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrategyBuilder {" +
				"strategyComponentIdentifier=" + this.strategyComponentIdentifier + ", " +
				"premiumProductReference=" + this.premiumProductReference + ", " +
				"product=" + this.product +
			'}' + " " + super.toString();
		}
	}
}
