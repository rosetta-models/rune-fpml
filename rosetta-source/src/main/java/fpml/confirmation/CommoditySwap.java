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
import fpml.confirmation.CommoditySwap;
import fpml.confirmation.CommoditySwap.CommoditySwapBuilder;
import fpml.confirmation.CommoditySwap.CommoditySwapBuilderImpl;
import fpml.confirmation.CommoditySwap.CommoditySwapImpl;
import fpml.confirmation.CommoditySwapDetailsModel;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CommoditySwapMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a commodity swap product. The commodity swap product model is designed to support fixed-float swaps, float-float swaps, fixed vs. physical swaps, float vs. physical swaps as well as, weather specific swaps. Its design is fully compatible with other FpML products and the product reuses standard common types.
 * @version ${project.version}
 */
@RosettaDataType(value="CommoditySwap", builder=CommoditySwap.CommoditySwapBuilderImpl.class, version="${project.version}")
public interface CommoditySwap extends Product {

	CommoditySwapMeta metaData = new CommoditySwapMeta();

	/*********************** Getter Methods  ***********************/
	CommoditySwapDetailsModel getCommoditySwapDetailsModel();

	/*********************** Build Methods  ***********************/
	CommoditySwap build();
	
	CommoditySwap.CommoditySwapBuilder toBuilder();
	
	static CommoditySwap.CommoditySwapBuilder builder() {
		return new CommoditySwap.CommoditySwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySwap> getType() {
		return CommoditySwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commoditySwapDetailsModel"), processor, CommoditySwapDetailsModel.class, getCommoditySwapDetailsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySwapBuilder extends CommoditySwap, Product.ProductBuilder {
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getOrCreateCommoditySwapDetailsModel();
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getCommoditySwapDetailsModel();
		CommoditySwap.CommoditySwapBuilder setProductModel(ProductModel productModel);
		CommoditySwap.CommoditySwapBuilder setId(String id);
		CommoditySwap.CommoditySwapBuilder setCommoditySwapDetailsModel(CommoditySwapDetailsModel commoditySwapDetailsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commoditySwapDetailsModel"), processor, CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder.class, getCommoditySwapDetailsModel());
		}
		

		CommoditySwap.CommoditySwapBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwap  ***********************/
	class CommoditySwapImpl extends Product.ProductImpl implements CommoditySwap {
		private final CommoditySwapDetailsModel commoditySwapDetailsModel;
		
		protected CommoditySwapImpl(CommoditySwap.CommoditySwapBuilder builder) {
			super(builder);
			this.commoditySwapDetailsModel = ofNullable(builder.getCommoditySwapDetailsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commoditySwapDetailsModel")
		public CommoditySwapDetailsModel getCommoditySwapDetailsModel() {
			return commoditySwapDetailsModel;
		}
		
		@Override
		public CommoditySwap build() {
			return this;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder toBuilder() {
			CommoditySwap.CommoditySwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwap.CommoditySwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommoditySwapDetailsModel()).ifPresent(builder::setCommoditySwapDetailsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySwap _that = getType().cast(o);
		
			if (!Objects.equals(commoditySwapDetailsModel, _that.getCommoditySwapDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commoditySwapDetailsModel != null ? commoditySwapDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwap {" +
				"commoditySwapDetailsModel=" + this.commoditySwapDetailsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySwap  ***********************/
	class CommoditySwapBuilderImpl extends Product.ProductBuilderImpl  implements CommoditySwap.CommoditySwapBuilder {
	
		protected CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder commoditySwapDetailsModel;
	
		public CommoditySwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commoditySwapDetailsModel")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getCommoditySwapDetailsModel() {
			return commoditySwapDetailsModel;
		}
		
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getOrCreateCommoditySwapDetailsModel() {
			CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder result;
			if (commoditySwapDetailsModel!=null) {
				result = commoditySwapDetailsModel;
			}
			else {
				result = commoditySwapDetailsModel = CommoditySwapDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CommoditySwap.CommoditySwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommoditySwap.CommoditySwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commoditySwapDetailsModel")
		public CommoditySwap.CommoditySwapBuilder setCommoditySwapDetailsModel(CommoditySwapDetailsModel commoditySwapDetailsModel) {
			this.commoditySwapDetailsModel = commoditySwapDetailsModel==null?null:commoditySwapDetailsModel.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySwap build() {
			return new CommoditySwap.CommoditySwapImpl(this);
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwap.CommoditySwapBuilder prune() {
			super.prune();
			if (commoditySwapDetailsModel!=null && !commoditySwapDetailsModel.prune().hasData()) commoditySwapDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommoditySwapDetailsModel()!=null && getCommoditySwapDetailsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwap.CommoditySwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommoditySwap.CommoditySwapBuilder o = (CommoditySwap.CommoditySwapBuilder) other;
			
			merger.mergeRosetta(getCommoditySwapDetailsModel(), o.getCommoditySwapDetailsModel(), this::setCommoditySwapDetailsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySwap _that = getType().cast(o);
		
			if (!Objects.equals(commoditySwapDetailsModel, _that.getCommoditySwapDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commoditySwapDetailsModel != null ? commoditySwapDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwapBuilder {" +
				"commoditySwapDetailsModel=" + this.commoditySwapDetailsModel +
			'}' + " " + super.toString();
		}
	}
}
