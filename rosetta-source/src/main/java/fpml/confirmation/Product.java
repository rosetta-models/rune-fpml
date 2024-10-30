package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.ProductMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract element used as a place holder for the substituting product elements. The base type which all FpML products extend.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Product", builder=Product.ProductBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Product extends RosettaModelObject {

	ProductMeta metaData = new ProductMeta();

	/*********************** Getter Methods  ***********************/
	ProductModel getProductModel();
	String getId();

	/*********************** Build Methods  ***********************/
	Product build();
	
	Product.ProductBuilder toBuilder();
	
	static Product.ProductBuilder builder() {
		return new Product.ProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Product> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Product> getType() {
		return Product.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductBuilder extends Product, RosettaModelObjectBuilder {
		ProductModel.ProductModelBuilder getOrCreateProductModel();
		ProductModel.ProductModelBuilder getProductModel();
		Product.ProductBuilder setProductModel(ProductModel productModel);
		Product.ProductBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Product.ProductBuilder prune();
	}

	/*********************** Immutable Implementation of Product  ***********************/
	class ProductImpl implements Product {
		private final ProductModel productModel;
		private final String id;
		
		protected ProductImpl(Product.ProductBuilder builder) {
			this.productModel = ofNullable(builder.getProductModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("productModel")
		public ProductModel getProductModel() {
			return productModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Product build() {
			return this;
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			Product.ProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Product.ProductBuilder builder) {
			ofNullable(getProductModel()).ifPresent(builder::setProductModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(productModel, _that.getProductModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productModel != null ? productModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Product {" +
				"productModel=" + this.productModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Product  ***********************/
	class ProductBuilderImpl implements Product.ProductBuilder {
	
		protected ProductModel.ProductModelBuilder productModel;
		protected String id;
	
		public ProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("productModel")
		public ProductModel.ProductModelBuilder getProductModel() {
			return productModel;
		}
		
		@Override
		public ProductModel.ProductModelBuilder getOrCreateProductModel() {
			ProductModel.ProductModelBuilder result;
			if (productModel!=null) {
				result = productModel;
			}
			else {
				result = productModel = ProductModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public Product.ProductBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Product.ProductBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Product build() {
			return new Product.ProductImpl(this);
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder prune() {
			if (productModel!=null && !productModel.prune().hasData()) productModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProductModel()!=null && getProductModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Product.ProductBuilder o = (Product.ProductBuilder) other;
			
			merger.mergeRosetta(getProductModel(), o.getProductModel(), this::setProductModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(productModel, _that.getProductModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productModel != null ? productModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductBuilder {" +
				"productModel=" + this.productModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
