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
import fpml.confirmation.AssetClass;
import fpml.confirmation.ProductId;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ProductModel.ProductModelBuilder;
import fpml.confirmation.ProductModel.ProductModelBuilderImpl;
import fpml.confirmation.ProductModel.ProductModelImpl;
import fpml.confirmation.ProductType;
import fpml.confirmation.meta.ProductModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ProductModel", builder=ProductModel.ProductModelBuilderImpl.class, version="${project.version}")
public interface ProductModel extends RosettaModelObject {

	ProductModelMeta metaData = new ProductModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A classification of the most important risk class of the trade. FpML defines a simple asset class categorization using a coding scheme.
	 */
	AssetClass getPrimaryAssetClass();
	/**
	 * A classification of additional risk classes of the trade, if any. FpML defines a simple asset class categorization using a coding scheme.
	 */
	List<? extends AssetClass> getSecondaryAssetClass();
	/**
	 * A classification of the type of product. FpML defines a simple product categorization using a coding scheme.
	 */
	List<? extends ProductType> getProductType();
	/**
	 * A product reference identifier. The product ID is an identifier that describes the key economic characteristics of the trade type, with the exception of concepts such as size (notional, quantity, number of units) and price (fixed rate, strike, etc.) that are negotiated for each transaction. It can be used to hold identifiers such as the &quot;UPI&quot; (universal product identifier) required by certain regulatory reporting rules. It can also be used to hold identifiers of benchmark products or product temnplates used by certain trading systems or facilities. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
	 */
	List<? extends ProductId> getProductId();
	/**
	 * A classification of the risk class of the trade. FpML defines a simple asset class categorization using a coding scheme.
	 */
	List<? extends AssetClass> getAssetClass();

	/*********************** Build Methods  ***********************/
	ProductModel build();
	
	ProductModel.ProductModelBuilder toBuilder();
	
	static ProductModel.ProductModelBuilder builder() {
		return new ProductModel.ProductModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProductModel> getType() {
		return ProductModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductModelBuilder extends ProductModel, RosettaModelObjectBuilder {
		AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass();
		AssetClass.AssetClassBuilder getPrimaryAssetClass();
		AssetClass.AssetClassBuilder getOrCreateSecondaryAssetClass(int _index);
		List<? extends AssetClass.AssetClassBuilder> getSecondaryAssetClass();
		ProductType.ProductTypeBuilder getOrCreateProductType(int _index);
		List<? extends ProductType.ProductTypeBuilder> getProductType();
		ProductId.ProductIdBuilder getOrCreateProductId(int _index);
		List<? extends ProductId.ProductIdBuilder> getProductId();
		AssetClass.AssetClassBuilder getOrCreateAssetClass(int _index);
		List<? extends AssetClass.AssetClassBuilder> getAssetClass();
		ProductModel.ProductModelBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		ProductModel.ProductModelBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass0);
		ProductModel.ProductModelBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass1, int _idx);
		ProductModel.ProductModelBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass2);
		ProductModel.ProductModelBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass3);
		ProductModel.ProductModelBuilder addProductType(ProductType productType0);
		ProductModel.ProductModelBuilder addProductType(ProductType productType1, int _idx);
		ProductModel.ProductModelBuilder addProductType(List<? extends ProductType> productType2);
		ProductModel.ProductModelBuilder setProductType(List<? extends ProductType> productType3);
		ProductModel.ProductModelBuilder addProductId(ProductId productId0);
		ProductModel.ProductModelBuilder addProductId(ProductId productId1, int _idx);
		ProductModel.ProductModelBuilder addProductId(List<? extends ProductId> productId2);
		ProductModel.ProductModelBuilder setProductId(List<? extends ProductId> productId3);
		ProductModel.ProductModelBuilder addAssetClass(AssetClass assetClass0);
		ProductModel.ProductModelBuilder addAssetClass(AssetClass assetClass1, int _idx);
		ProductModel.ProductModelBuilder addAssetClass(List<? extends AssetClass> assetClass2);
		ProductModel.ProductModelBuilder setAssetClass(List<? extends AssetClass> assetClass3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
		}
		

		ProductModel.ProductModelBuilder prune();
	}

	/*********************** Immutable Implementation of ProductModel  ***********************/
	class ProductModelImpl implements ProductModel {
		private final AssetClass primaryAssetClass;
		private final List<? extends AssetClass> secondaryAssetClass;
		private final List<? extends ProductType> productType;
		private final List<? extends ProductId> productId;
		private final List<? extends AssetClass> assetClass;
		
		protected ProductModelImpl(ProductModel.ProductModelBuilder builder) {
			this.primaryAssetClass = ofNullable(builder.getPrimaryAssetClass()).map(f->f.build()).orElse(null);
			this.secondaryAssetClass = ofNullable(builder.getSecondaryAssetClass()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productType = ofNullable(builder.getProductType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productId = ofNullable(builder.getProductId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.assetClass = ofNullable(builder.getAssetClass()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		public AssetClass getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		public List<? extends AssetClass> getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("productType")
		public List<? extends ProductType> getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("productId")
		public List<? extends ProductId> getProductId() {
			return productId;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		public List<? extends AssetClass> getAssetClass() {
			return assetClass;
		}
		
		@Override
		public ProductModel build() {
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder toBuilder() {
			ProductModel.ProductModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductModel.ProductModelBuilder builder) {
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getSecondaryAssetClass()).ifPresent(builder::setSecondaryAssetClass);
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getProductId()).ifPresent(builder::setProductId);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductModel _that = getType().cast(o);
		
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!ListEquals.listEquals(productId, _that.getProductId())) return false;
			if (!ListEquals.listEquals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductModel {" +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId + ", " +
				"assetClass=" + this.assetClass +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductModel  ***********************/
	class ProductModelBuilderImpl implements ProductModel.ProductModelBuilder {
	
		protected AssetClass.AssetClassBuilder primaryAssetClass;
		protected List<AssetClass.AssetClassBuilder> secondaryAssetClass = new ArrayList<>();
		protected List<ProductType.ProductTypeBuilder> productType = new ArrayList<>();
		protected List<ProductId.ProductIdBuilder> productId = new ArrayList<>();
		protected List<AssetClass.AssetClassBuilder> assetClass = new ArrayList<>();
	
		public ProductModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("primaryAssetClass")
		public AssetClass.AssetClassBuilder getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass() {
			AssetClass.AssetClassBuilder result;
			if (primaryAssetClass!=null) {
				result = primaryAssetClass;
			}
			else {
				result = primaryAssetClass = AssetClass.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		public List<? extends AssetClass.AssetClassBuilder> getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		public AssetClass.AssetClassBuilder getOrCreateSecondaryAssetClass(int _index) {
		
			if (secondaryAssetClass==null) {
				this.secondaryAssetClass = new ArrayList<>();
			}
			AssetClass.AssetClassBuilder result;
			return getIndex(secondaryAssetClass, _index, () -> {
						AssetClass.AssetClassBuilder newSecondaryAssetClass = AssetClass.builder();
						return newSecondaryAssetClass;
					});
		}
		
		@Override
		@RosettaAttribute("productType")
		public List<? extends ProductType.ProductTypeBuilder> getProductType() {
			return productType;
		}
		
		public ProductType.ProductTypeBuilder getOrCreateProductType(int _index) {
		
			if (productType==null) {
				this.productType = new ArrayList<>();
			}
			ProductType.ProductTypeBuilder result;
			return getIndex(productType, _index, () -> {
						ProductType.ProductTypeBuilder newProductType = ProductType.builder();
						return newProductType;
					});
		}
		
		@Override
		@RosettaAttribute("productId")
		public List<? extends ProductId.ProductIdBuilder> getProductId() {
			return productId;
		}
		
		public ProductId.ProductIdBuilder getOrCreateProductId(int _index) {
		
			if (productId==null) {
				this.productId = new ArrayList<>();
			}
			ProductId.ProductIdBuilder result;
			return getIndex(productId, _index, () -> {
						ProductId.ProductIdBuilder newProductId = ProductId.builder();
						return newProductId;
					});
		}
		
		@Override
		@RosettaAttribute("assetClass")
		public List<? extends AssetClass.AssetClassBuilder> getAssetClass() {
			return assetClass;
		}
		
		public AssetClass.AssetClassBuilder getOrCreateAssetClass(int _index) {
		
			if (assetClass==null) {
				this.assetClass = new ArrayList<>();
			}
			AssetClass.AssetClassBuilder result;
			return getIndex(assetClass, _index, () -> {
						AssetClass.AssetClassBuilder newAssetClass = AssetClass.builder();
						return newAssetClass;
					});
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		public ProductModel.ProductModelBuilder setPrimaryAssetClass(AssetClass primaryAssetClass) {
			this.primaryAssetClass = primaryAssetClass==null?null:primaryAssetClass.toBuilder();
			return this;
		}
		@Override
		public ProductModel.ProductModelBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass) {
			if (secondaryAssetClass!=null) this.secondaryAssetClass.add(secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int _idx) {
			getIndex(this.secondaryAssetClass, _idx, () -> secondaryAssetClass.toBuilder());
			return this;
		}
		@Override 
		public ProductModel.ProductModelBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("secondaryAssetClass")
		public ProductModel.ProductModelBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null)  {
				this.secondaryAssetClass = new ArrayList<>();
			}
			else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder addProductType(ProductType productType) {
			if (productType!=null) this.productType.add(productType.toBuilder());
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder addProductType(ProductType productType, int _idx) {
			getIndex(this.productType, _idx, () -> productType.toBuilder());
			return this;
		}
		@Override 
		public ProductModel.ProductModelBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("productType")
		public ProductModel.ProductModelBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null)  {
				this.productType = new ArrayList<>();
			}
			else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder addProductId(ProductId productId) {
			if (productId!=null) this.productId.add(productId.toBuilder());
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder addProductId(ProductId productId, int _idx) {
			getIndex(this.productId, _idx, () -> productId.toBuilder());
			return this;
		}
		@Override 
		public ProductModel.ProductModelBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("productId")
		public ProductModel.ProductModelBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null)  {
				this.productId = new ArrayList<>();
			}
			else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder addAssetClass(AssetClass assetClass) {
			if (assetClass!=null) this.assetClass.add(assetClass.toBuilder());
			return this;
		}
		
		@Override
		public ProductModel.ProductModelBuilder addAssetClass(AssetClass assetClass, int _idx) {
			getIndex(this.assetClass, _idx, () -> assetClass.toBuilder());
			return this;
		}
		@Override 
		public ProductModel.ProductModelBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("assetClass")
		public ProductModel.ProductModelBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null)  {
				this.assetClass = new ArrayList<>();
			}
			else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ProductModel build() {
			return new ProductModel.ProductModelImpl(this);
		}
		
		@Override
		public ProductModel.ProductModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductModel.ProductModelBuilder prune() {
			if (primaryAssetClass!=null && !primaryAssetClass.prune().hasData()) primaryAssetClass = null;
			secondaryAssetClass = secondaryAssetClass.stream().filter(b->b!=null).<AssetClass.AssetClassBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productType = productType.stream().filter(b->b!=null).<ProductType.ProductTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productId = productId.stream().filter(b->b!=null).<ProductId.ProductIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			assetClass = assetClass.stream().filter(b->b!=null).<AssetClass.AssetClassBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryAssetClass()!=null && getPrimaryAssetClass().hasData()) return true;
			if (getSecondaryAssetClass()!=null && getSecondaryAssetClass().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductType()!=null && getProductType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductId()!=null && getProductId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAssetClass()!=null && getAssetClass().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductModel.ProductModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductModel.ProductModelBuilder o = (ProductModel.ProductModelBuilder) other;
			
			merger.mergeRosetta(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeRosetta(getSecondaryAssetClass(), o.getSecondaryAssetClass(), this::getOrCreateSecondaryAssetClass);
			merger.mergeRosetta(getProductType(), o.getProductType(), this::getOrCreateProductType);
			merger.mergeRosetta(getProductId(), o.getProductId(), this::getOrCreateProductId);
			merger.mergeRosetta(getAssetClass(), o.getAssetClass(), this::getOrCreateAssetClass);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductModel _that = getType().cast(o);
		
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!ListEquals.listEquals(productId, _that.getProductId())) return false;
			if (!ListEquals.listEquals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductModelBuilder {" +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId + ", " +
				"assetClass=" + this.assetClass +
			'}';
		}
	}
}
