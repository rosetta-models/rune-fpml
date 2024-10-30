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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityFinancialOptionModel;
import fpml.confirmation.CommodityOption;
import fpml.confirmation.CommodityOption.CommodityOptionBuilder;
import fpml.confirmation.CommodityOption.CommodityOptionBuilderImpl;
import fpml.confirmation.CommodityOption.CommodityOptionImpl;
import fpml.confirmation.CommodityPhysicalOptionModel;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommodityWeatherOptionModel;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.meta.CommodityOptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a commodity option product. The product support for financially-settled exercises or exercise into physical forward contracts written on precious and non-precious metals. options in FpML is based on the creation of a &#39;commodityOption&#39; product. The product references the &#39;commodity&#39; underlyer in order to support the underlying asset of the option. Defines a commodity option product type. The product support for financially-settled exercises or exercise into physical forward contracts written on precious and non-precious metals. options in FpML is based on the creation of a &#39;commodityOption&#39; product. The product references the &#39;commodity&#39; underlyer in order to support the underlying asset of the option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityOption", builder=CommodityOption.CommodityOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityOption extends Product {

	CommodityOptionMeta metaData = new CommodityOptionMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * The type of option transaction.
	 */
	PutCallEnum getOptionType();
	CommodityFinancialOptionModel getCommodityFinancialOptionModel();
	CommodityPhysicalOptionModel getCommodityPhysicalOptionModel();
	CommodityWeatherOptionModel getCommodityWeatherOptionModel();
	/**
	 * The option premium payable by the buyer to the seller.
	 */
	List<? extends CommodityPremium> getPremium();
	CommodityContentModel getCommodityContentModel();

	/*********************** Build Methods  ***********************/
	CommodityOption build();
	
	CommodityOption.CommodityOptionBuilder toBuilder();
	
	static CommodityOption.CommodityOptionBuilder builder() {
		return new CommodityOption.CommodityOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityOption> getType() {
		return CommodityOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("commodityFinancialOptionModel"), processor, CommodityFinancialOptionModel.class, getCommodityFinancialOptionModel());
		processRosetta(path.newSubPath("commodityPhysicalOptionModel"), processor, CommodityPhysicalOptionModel.class, getCommodityPhysicalOptionModel());
		processRosetta(path.newSubPath("commodityWeatherOptionModel"), processor, CommodityWeatherOptionModel.class, getCommodityWeatherOptionModel());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.class, getCommodityContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityOptionBuilder extends CommodityOption, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder getOrCreateCommodityFinancialOptionModel();
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder getCommodityFinancialOptionModel();
		CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder getOrCreateCommodityPhysicalOptionModel();
		CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder getCommodityPhysicalOptionModel();
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder getOrCreateCommodityWeatherOptionModel();
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder getCommodityWeatherOptionModel();
		CommodityPremium.CommodityPremiumBuilder getOrCreatePremium(int _index);
		List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium();
		CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel();
		CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel();
		CommodityOption.CommodityOptionBuilder setProductModel(ProductModel productModel);
		CommodityOption.CommodityOptionBuilder setId(String id);
		CommodityOption.CommodityOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		CommodityOption.CommodityOptionBuilder setOptionType(PutCallEnum optionType);
		CommodityOption.CommodityOptionBuilder setCommodityFinancialOptionModel(CommodityFinancialOptionModel commodityFinancialOptionModel);
		CommodityOption.CommodityOptionBuilder setCommodityPhysicalOptionModel(CommodityPhysicalOptionModel commodityPhysicalOptionModel);
		CommodityOption.CommodityOptionBuilder setCommodityWeatherOptionModel(CommodityWeatherOptionModel commodityWeatherOptionModel);
		CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium premium0);
		CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium premium1, int _idx);
		CommodityOption.CommodityOptionBuilder addPremium(List<? extends CommodityPremium> premium2);
		CommodityOption.CommodityOptionBuilder setPremium(List<? extends CommodityPremium> premium3);
		CommodityOption.CommodityOptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("commodityFinancialOptionModel"), processor, CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder.class, getCommodityFinancialOptionModel());
			processRosetta(path.newSubPath("commodityPhysicalOptionModel"), processor, CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder.class, getCommodityPhysicalOptionModel());
			processRosetta(path.newSubPath("commodityWeatherOptionModel"), processor, CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder.class, getCommodityWeatherOptionModel());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
		}
		

		CommodityOption.CommodityOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityOption  ***********************/
	class CommodityOptionImpl extends Product.ProductImpl implements CommodityOption {
		private final BuyerSellerModel buyerSellerModel;
		private final PutCallEnum optionType;
		private final CommodityFinancialOptionModel commodityFinancialOptionModel;
		private final CommodityPhysicalOptionModel commodityPhysicalOptionModel;
		private final CommodityWeatherOptionModel commodityWeatherOptionModel;
		private final List<? extends CommodityPremium> premium;
		private final CommodityContentModel commodityContentModel;
		
		protected CommodityOptionImpl(CommodityOption.CommodityOptionBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.commodityFinancialOptionModel = ofNullable(builder.getCommodityFinancialOptionModel()).map(f->f.build()).orElse(null);
			this.commodityPhysicalOptionModel = ofNullable(builder.getCommodityPhysicalOptionModel()).map(f->f.build()).orElse(null);
			this.commodityWeatherOptionModel = ofNullable(builder.getCommodityWeatherOptionModel()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("commodityFinancialOptionModel")
		public CommodityFinancialOptionModel getCommodityFinancialOptionModel() {
			return commodityFinancialOptionModel;
		}
		
		@Override
		@RosettaAttribute("commodityPhysicalOptionModel")
		public CommodityPhysicalOptionModel getCommodityPhysicalOptionModel() {
			return commodityPhysicalOptionModel;
		}
		
		@Override
		@RosettaAttribute("commodityWeatherOptionModel")
		public CommodityWeatherOptionModel getCommodityWeatherOptionModel() {
			return commodityWeatherOptionModel;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends CommodityPremium> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityOption build() {
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder toBuilder() {
			CommodityOption.CommodityOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityOption.CommodityOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommodityFinancialOptionModel()).ifPresent(builder::setCommodityFinancialOptionModel);
			ofNullable(getCommodityPhysicalOptionModel()).ifPresent(builder::setCommodityPhysicalOptionModel);
			ofNullable(getCommodityWeatherOptionModel()).ifPresent(builder::setCommodityWeatherOptionModel);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCommodityContentModel()).ifPresent(builder::setCommodityContentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityOption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodityFinancialOptionModel, _that.getCommodityFinancialOptionModel())) return false;
			if (!Objects.equals(commodityPhysicalOptionModel, _that.getCommodityPhysicalOptionModel())) return false;
			if (!Objects.equals(commodityWeatherOptionModel, _that.getCommodityWeatherOptionModel())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityFinancialOptionModel != null ? commodityFinancialOptionModel.hashCode() : 0);
			_result = 31 * _result + (commodityPhysicalOptionModel != null ? commodityPhysicalOptionModel.hashCode() : 0);
			_result = 31 * _result + (commodityWeatherOptionModel != null ? commodityWeatherOptionModel.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOption {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"optionType=" + this.optionType + ", " +
				"commodityFinancialOptionModel=" + this.commodityFinancialOptionModel + ", " +
				"commodityPhysicalOptionModel=" + this.commodityPhysicalOptionModel + ", " +
				"commodityWeatherOptionModel=" + this.commodityWeatherOptionModel + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityOption  ***********************/
	class CommodityOptionBuilderImpl extends Product.ProductBuilderImpl  implements CommodityOption.CommodityOptionBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected PutCallEnum optionType;
		protected CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder commodityFinancialOptionModel;
		protected CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder commodityPhysicalOptionModel;
		protected CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder commodityWeatherOptionModel;
		protected List<CommodityPremium.CommodityPremiumBuilder> premium = new ArrayList<>();
		protected CommodityContentModel.CommodityContentModelBuilder commodityContentModel;
	
		public CommodityOptionBuilderImpl() {
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
		@RosettaAttribute("commodityFinancialOptionModel")
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder getCommodityFinancialOptionModel() {
			return commodityFinancialOptionModel;
		}
		
		@Override
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder getOrCreateCommodityFinancialOptionModel() {
			CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder result;
			if (commodityFinancialOptionModel!=null) {
				result = commodityFinancialOptionModel;
			}
			else {
				result = commodityFinancialOptionModel = CommodityFinancialOptionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPhysicalOptionModel")
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder getCommodityPhysicalOptionModel() {
			return commodityPhysicalOptionModel;
		}
		
		@Override
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder getOrCreateCommodityPhysicalOptionModel() {
			CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder result;
			if (commodityPhysicalOptionModel!=null) {
				result = commodityPhysicalOptionModel;
			}
			else {
				result = commodityPhysicalOptionModel = CommodityPhysicalOptionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityWeatherOptionModel")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder getCommodityWeatherOptionModel() {
			return commodityWeatherOptionModel;
		}
		
		@Override
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder getOrCreateCommodityWeatherOptionModel() {
			CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder result;
			if (commodityWeatherOptionModel!=null) {
				result = commodityWeatherOptionModel;
			}
			else {
				result = commodityWeatherOptionModel = CommodityWeatherOptionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			CommodityPremium.CommodityPremiumBuilder result;
			return getIndex(premium, _index, () -> {
						CommodityPremium.CommodityPremiumBuilder newPremium = CommodityPremium.builder();
						return newPremium;
					});
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
		public CommodityOption.CommodityOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityOption.CommodityOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public CommodityOption.CommodityOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public CommodityOption.CommodityOptionBuilder setOptionType(PutCallEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("commodityFinancialOptionModel")
		public CommodityOption.CommodityOptionBuilder setCommodityFinancialOptionModel(CommodityFinancialOptionModel commodityFinancialOptionModel) {
			this.commodityFinancialOptionModel = commodityFinancialOptionModel==null?null:commodityFinancialOptionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPhysicalOptionModel")
		public CommodityOption.CommodityOptionBuilder setCommodityPhysicalOptionModel(CommodityPhysicalOptionModel commodityPhysicalOptionModel) {
			this.commodityPhysicalOptionModel = commodityPhysicalOptionModel==null?null:commodityPhysicalOptionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityWeatherOptionModel")
		public CommodityOption.CommodityOptionBuilder setCommodityWeatherOptionModel(CommodityWeatherOptionModel commodityWeatherOptionModel) {
			this.commodityWeatherOptionModel = commodityWeatherOptionModel==null?null:commodityWeatherOptionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public CommodityOption.CommodityOptionBuilder addPremium(List<? extends CommodityPremium> premiums) {
			if (premiums != null) {
				for (CommodityPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityOption.CommodityOptionBuilder setPremium(List<? extends CommodityPremium> premiums) {
			if (premiums == null)  {
				this.premium = new ArrayList<>();
			}
			else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityOption.CommodityOptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityOption build() {
			return new CommodityOption.CommodityOptionImpl(this);
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOption.CommodityOptionBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (commodityFinancialOptionModel!=null && !commodityFinancialOptionModel.prune().hasData()) commodityFinancialOptionModel = null;
			if (commodityPhysicalOptionModel!=null && !commodityPhysicalOptionModel.prune().hasData()) commodityPhysicalOptionModel = null;
			if (commodityWeatherOptionModel!=null && !commodityWeatherOptionModel.prune().hasData()) commodityWeatherOptionModel = null;
			premium = premium.stream().filter(b->b!=null).<CommodityPremium.CommodityPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityContentModel!=null && !commodityContentModel.prune().hasData()) commodityContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getCommodityFinancialOptionModel()!=null && getCommodityFinancialOptionModel().hasData()) return true;
			if (getCommodityPhysicalOptionModel()!=null && getCommodityPhysicalOptionModel().hasData()) return true;
			if (getCommodityWeatherOptionModel()!=null && getCommodityWeatherOptionModel().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityContentModel()!=null && getCommodityContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOption.CommodityOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityOption.CommodityOptionBuilder o = (CommodityOption.CommodityOptionBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getCommodityFinancialOptionModel(), o.getCommodityFinancialOptionModel(), this::setCommodityFinancialOptionModel);
			merger.mergeRosetta(getCommodityPhysicalOptionModel(), o.getCommodityPhysicalOptionModel(), this::setCommodityPhysicalOptionModel);
			merger.mergeRosetta(getCommodityWeatherOptionModel(), o.getCommodityWeatherOptionModel(), this::setCommodityWeatherOptionModel);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getCommodityContentModel(), o.getCommodityContentModel(), this::setCommodityContentModel);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityOption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodityFinancialOptionModel, _that.getCommodityFinancialOptionModel())) return false;
			if (!Objects.equals(commodityPhysicalOptionModel, _that.getCommodityPhysicalOptionModel())) return false;
			if (!Objects.equals(commodityWeatherOptionModel, _that.getCommodityWeatherOptionModel())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityFinancialOptionModel != null ? commodityFinancialOptionModel.hashCode() : 0);
			_result = 31 * _result + (commodityPhysicalOptionModel != null ? commodityPhysicalOptionModel.hashCode() : 0);
			_result = 31 * _result + (commodityWeatherOptionModel != null ? commodityWeatherOptionModel.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOptionBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"optionType=" + this.optionType + ", " +
				"commodityFinancialOptionModel=" + this.commodityFinancialOptionModel + ", " +
				"commodityPhysicalOptionModel=" + this.commodityPhysicalOptionModel + ", " +
				"commodityWeatherOptionModel=" + this.commodityWeatherOptionModel + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}
}
