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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityPhysicalExercise;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommoditySwaption;
import fpml.confirmation.CommoditySwaption.CommoditySwaptionBuilder;
import fpml.confirmation.CommoditySwaption.CommoditySwaptionBuilderImpl;
import fpml.confirmation.CommoditySwaption.CommoditySwaptionImpl;
import fpml.confirmation.CommoditySwaptionUnderlying;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.meta.CommoditySwaptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a commodity swaption product Commodity Swaption.
 * @version ${project.version}
 */
@RosettaDataType(value="CommoditySwaption", builder=CommoditySwaption.CommoditySwaptionBuilderImpl.class, version="${project.version}")
public interface CommoditySwaption extends Product {

	CommoditySwaptionMeta metaData = new CommoditySwaptionMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * The type of option transaction.
	 */
	PutCallEnum getOptionType();
	/**
	 * The underlying commodity swap definiton.
	 */
	CommoditySwaptionUnderlying getCommoditySwap();
	/**
	 * The parameters for defining how the commodity option can be exercised into a physical transaction.
	 */
	CommodityPhysicalExercise getPhysicalExercise();
	/**
	 * The option premium payable by the buyer to the seller.
	 */
	CommodityPremium getPremium();
	CommodityContentModel getCommodityContentModel();

	/*********************** Build Methods  ***********************/
	CommoditySwaption build();
	
	CommoditySwaption.CommoditySwaptionBuilder toBuilder();
	
	static CommoditySwaption.CommoditySwaptionBuilder builder() {
		return new CommoditySwaption.CommoditySwaptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwaption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySwaption> getType() {
		return CommoditySwaption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwaptionUnderlying.class, getCommoditySwap());
		processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.class, getPhysicalExercise());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.class, getCommodityContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySwaptionBuilder extends CommoditySwaption, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getOrCreateCommoditySwap();
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getCommoditySwap();
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise();
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise();
		CommodityPremium.CommodityPremiumBuilder getOrCreatePremium();
		CommodityPremium.CommodityPremiumBuilder getPremium();
		CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel();
		CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel();
		CommoditySwaption.CommoditySwaptionBuilder setProductModel(ProductModel productModel);
		CommoditySwaption.CommoditySwaptionBuilder setId(String id);
		CommoditySwaption.CommoditySwaptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		CommoditySwaption.CommoditySwaptionBuilder setOptionType(PutCallEnum optionType);
		CommoditySwaption.CommoditySwaptionBuilder setCommoditySwap(CommoditySwaptionUnderlying commoditySwap);
		CommoditySwaption.CommoditySwaptionBuilder setPhysicalExercise(CommodityPhysicalExercise physicalExercise);
		CommoditySwaption.CommoditySwaptionBuilder setPremium(CommodityPremium premium);
		CommoditySwaption.CommoditySwaptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder.class, getCommoditySwap());
			processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder.class, getPhysicalExercise());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
		}
		

		CommoditySwaption.CommoditySwaptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwaption  ***********************/
	class CommoditySwaptionImpl extends Product.ProductImpl implements CommoditySwaption {
		private final BuyerSellerModel buyerSellerModel;
		private final PutCallEnum optionType;
		private final CommoditySwaptionUnderlying commoditySwap;
		private final CommodityPhysicalExercise physicalExercise;
		private final CommodityPremium premium;
		private final CommodityContentModel commodityContentModel;
		
		protected CommoditySwaptionImpl(CommoditySwaption.CommoditySwaptionBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.commoditySwap = ofNullable(builder.getCommoditySwap()).map(f->f.build()).orElse(null);
			this.physicalExercise = ofNullable(builder.getPhysicalExercise()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).map(f->f.build()).orElse(null);
			this.commodityContentModel = ofNullable(builder.getCommodityContentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commoditySwap")
		public CommoditySwaptionUnderlying getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		public CommodityPhysicalExercise getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		@RosettaAttribute("premium")
		public CommodityPremium getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommoditySwaption build() {
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder toBuilder() {
			CommoditySwaption.CommoditySwaptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwaption.CommoditySwaptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommoditySwap()).ifPresent(builder::setCommoditySwap);
			ofNullable(getPhysicalExercise()).ifPresent(builder::setPhysicalExercise);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCommodityContentModel()).ifPresent(builder::setCommodityContentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySwaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaption {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"optionType=" + this.optionType + ", " +
				"commoditySwap=" + this.commoditySwap + ", " +
				"physicalExercise=" + this.physicalExercise + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySwaption  ***********************/
	class CommoditySwaptionBuilderImpl extends Product.ProductBuilderImpl  implements CommoditySwaption.CommoditySwaptionBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected PutCallEnum optionType;
		protected CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder commoditySwap;
		protected CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder physicalExercise;
		protected CommodityPremium.CommodityPremiumBuilder premium;
		protected CommodityContentModel.CommodityContentModelBuilder commodityContentModel;
	
		public CommoditySwaptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commoditySwap")
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getOrCreateCommoditySwap() {
			CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder result;
			if (commoditySwap!=null) {
				result = commoditySwap;
			}
			else {
				result = commoditySwap = CommoditySwaptionUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise() {
			CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder result;
			if (physicalExercise!=null) {
				result = physicalExercise;
			}
			else {
				result = physicalExercise = CommodityPhysicalExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public CommodityPremium.CommodityPremiumBuilder getPremium() {
			return premium;
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder getOrCreatePremium() {
			CommodityPremium.CommodityPremiumBuilder result;
			if (premium!=null) {
				result = premium;
			}
			else {
				result = premium = CommodityPremium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel() {
			CommodityContentModel.CommodityContentModelBuilder result;
			if (commodityContentModel!=null) {
				result = commodityContentModel;
			}
			else {
				result = commodityContentModel = CommodityContentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CommoditySwaption.CommoditySwaptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommoditySwaption.CommoditySwaptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public CommoditySwaption.CommoditySwaptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public CommoditySwaption.CommoditySwaptionBuilder setOptionType(PutCallEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("commoditySwap")
		public CommoditySwaption.CommoditySwaptionBuilder setCommoditySwap(CommoditySwaptionUnderlying commoditySwap) {
			this.commoditySwap = commoditySwap==null?null:commoditySwap.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalExercise")
		public CommoditySwaption.CommoditySwaptionBuilder setPhysicalExercise(CommodityPhysicalExercise physicalExercise) {
			this.physicalExercise = physicalExercise==null?null:physicalExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public CommoditySwaption.CommoditySwaptionBuilder setPremium(CommodityPremium premium) {
			this.premium = premium==null?null:premium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommoditySwaption.CommoditySwaptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySwaption build() {
			return new CommoditySwaption.CommoditySwaptionImpl(this);
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (commoditySwap!=null && !commoditySwap.prune().hasData()) commoditySwap = null;
			if (physicalExercise!=null && !physicalExercise.prune().hasData()) physicalExercise = null;
			if (premium!=null && !premium.prune().hasData()) premium = null;
			if (commodityContentModel!=null && !commodityContentModel.prune().hasData()) commodityContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getCommoditySwap()!=null && getCommoditySwap().hasData()) return true;
			if (getPhysicalExercise()!=null && getPhysicalExercise().hasData()) return true;
			if (getPremium()!=null && getPremium().hasData()) return true;
			if (getCommodityContentModel()!=null && getCommodityContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommoditySwaption.CommoditySwaptionBuilder o = (CommoditySwaption.CommoditySwaptionBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getCommoditySwap(), o.getCommoditySwap(), this::setCommoditySwap);
			merger.mergeRosetta(getPhysicalExercise(), o.getPhysicalExercise(), this::setPhysicalExercise);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::setPremium);
			merger.mergeRosetta(getCommodityContentModel(), o.getCommodityContentModel(), this::setCommodityContentModel);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySwaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaptionBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"optionType=" + this.optionType + ", " +
				"commoditySwap=" + this.commoditySwap + ", " +
				"physicalExercise=" + this.physicalExercise + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}
}
