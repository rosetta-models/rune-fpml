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
import fpml.confirmation.ProductType;
import fpml.confirmation.ProductType.ProductTypeBuilder;
import fpml.confirmation.ProductType.ProductTypeBuilderImpl;
import fpml.confirmation.ProductType.ProductTypeImpl;
import fpml.confirmation.meta.ProductTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ProductType", builder=ProductType.ProductTypeBuilderImpl.class, version="${project.version}")
public interface ProductType extends RosettaModelObject {

	ProductTypeMeta metaData = new ProductTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getProductTypeScheme();

	/*********************** Build Methods  ***********************/
	ProductType build();
	
	ProductType.ProductTypeBuilder toBuilder();
	
	static ProductType.ProductTypeBuilder builder() {
		return new ProductType.ProductTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProductType> getType() {
		return ProductType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("productTypeScheme"), String.class, getProductTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductTypeBuilder extends ProductType, RosettaModelObjectBuilder {
		ProductType.ProductTypeBuilder setValue(String value);
		ProductType.ProductTypeBuilder setProductTypeScheme(String productTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("productTypeScheme"), String.class, getProductTypeScheme(), this);
		}
		

		ProductType.ProductTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ProductType  ***********************/
	class ProductTypeImpl implements ProductType {
		private final String value;
		private final String productTypeScheme;
		
		protected ProductTypeImpl(ProductType.ProductTypeBuilder builder) {
			this.value = builder.getValue();
			this.productTypeScheme = builder.getProductTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("productTypeScheme")
		public String getProductTypeScheme() {
			return productTypeScheme;
		}
		
		@Override
		public ProductType build() {
			return this;
		}
		
		@Override
		public ProductType.ProductTypeBuilder toBuilder() {
			ProductType.ProductTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductType.ProductTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getProductTypeScheme()).ifPresent(builder::setProductTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productTypeScheme, _that.getProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productTypeScheme != null ? productTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductType {" +
				"value=" + this.value + ", " +
				"productTypeScheme=" + this.productTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductType  ***********************/
	class ProductTypeBuilderImpl implements ProductType.ProductTypeBuilder {
	
		protected String value;
		protected String productTypeScheme;
	
		public ProductTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("productTypeScheme")
		public String getProductTypeScheme() {
			return productTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ProductType.ProductTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("productTypeScheme")
		public ProductType.ProductTypeBuilder setProductTypeScheme(String productTypeScheme) {
			this.productTypeScheme = productTypeScheme==null?null:productTypeScheme;
			return this;
		}
		
		@Override
		public ProductType build() {
			return new ProductType.ProductTypeImpl(this);
		}
		
		@Override
		public ProductType.ProductTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductType.ProductTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getProductTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductType.ProductTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductType.ProductTypeBuilder o = (ProductType.ProductTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getProductTypeScheme(), o.getProductTypeScheme(), this::setProductTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productTypeScheme, _that.getProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productTypeScheme != null ? productTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductTypeBuilder {" +
				"value=" + this.value + ", " +
				"productTypeScheme=" + this.productTypeScheme +
			'}';
		}
	}
}
