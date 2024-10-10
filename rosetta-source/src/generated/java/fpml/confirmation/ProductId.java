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
import fpml.confirmation.ProductId;
import fpml.confirmation.ProductId.ProductIdBuilder;
import fpml.confirmation.ProductId.ProductIdBuilderImpl;
import fpml.confirmation.ProductId.ProductIdImpl;
import fpml.confirmation.meta.ProductIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ProductId", builder=ProductId.ProductIdBuilderImpl.class, version="${project.version}")
public interface ProductId extends RosettaModelObject {

	ProductIdMeta metaData = new ProductIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getProductIdScheme();

	/*********************** Build Methods  ***********************/
	ProductId build();
	
	ProductId.ProductIdBuilder toBuilder();
	
	static ProductId.ProductIdBuilder builder() {
		return new ProductId.ProductIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProductId> getType() {
		return ProductId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("productIdScheme"), String.class, getProductIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductIdBuilder extends ProductId, RosettaModelObjectBuilder {
		ProductId.ProductIdBuilder setValue(String value);
		ProductId.ProductIdBuilder setProductIdScheme(String productIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("productIdScheme"), String.class, getProductIdScheme(), this);
		}
		

		ProductId.ProductIdBuilder prune();
	}

	/*********************** Immutable Implementation of ProductId  ***********************/
	class ProductIdImpl implements ProductId {
		private final String value;
		private final String productIdScheme;
		
		protected ProductIdImpl(ProductId.ProductIdBuilder builder) {
			this.value = builder.getValue();
			this.productIdScheme = builder.getProductIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("productIdScheme")
		public String getProductIdScheme() {
			return productIdScheme;
		}
		
		@Override
		public ProductId build() {
			return this;
		}
		
		@Override
		public ProductId.ProductIdBuilder toBuilder() {
			ProductId.ProductIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductId.ProductIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getProductIdScheme()).ifPresent(builder::setProductIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productIdScheme, _that.getProductIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productIdScheme != null ? productIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductId {" +
				"value=" + this.value + ", " +
				"productIdScheme=" + this.productIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductId  ***********************/
	class ProductIdBuilderImpl implements ProductId.ProductIdBuilder {
	
		protected String value;
		protected String productIdScheme;
	
		public ProductIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("productIdScheme")
		public String getProductIdScheme() {
			return productIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ProductId.ProductIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("productIdScheme")
		public ProductId.ProductIdBuilder setProductIdScheme(String productIdScheme) {
			this.productIdScheme = productIdScheme==null?null:productIdScheme;
			return this;
		}
		
		@Override
		public ProductId build() {
			return new ProductId.ProductIdImpl(this);
		}
		
		@Override
		public ProductId.ProductIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductId.ProductIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getProductIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductId.ProductIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductId.ProductIdBuilder o = (ProductId.ProductIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getProductIdScheme(), o.getProductIdScheme(), this::setProductIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productIdScheme, _that.getProductIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productIdScheme != null ? productIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductIdBuilder {" +
				"value=" + this.value + ", " +
				"productIdScheme=" + this.productIdScheme +
			'}';
		}
	}
}
