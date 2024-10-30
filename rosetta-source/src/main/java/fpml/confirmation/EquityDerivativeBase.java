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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.EquityDerivativeBase;
import fpml.confirmation.EquityDerivativeBase.EquityDerivativeBaseBuilder;
import fpml.confirmation.EquityDerivativeBase.EquityDerivativeBaseBuilderImpl;
import fpml.confirmation.EquityDerivativeBase.EquityDerivativeBaseImpl;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.EquityDerivativeBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the common features of equity derivatives.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityDerivativeBase", builder=EquityDerivativeBase.EquityDerivativeBaseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityDerivativeBase extends Product {

	EquityDerivativeBaseMeta metaData = new EquityDerivativeBaseMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * The type of option transaction.
	 */
	EquityOptionTypeEnum getOptionType();
	/**
	 * Effective date for a forward starting option.
	 */
	Date getEquityEffectiveDate();
	/**
	 * Specifies the underlying component, which can be either one or many and consists in either equity, index or convertible bond component, or a combination of these.
	 */
	Underlyer getUnderlyer();
	/**
	 * The notional amount.
	 */
	NonNegativeMoney getNotional();
	/**
	 * The parameters for defining how the equity option can be exercised, how it is valued and how it is settled.
	 */
	EquityExerciseValuationSettlement getEquityExercise();
	FeatureModel getFeatureModel();
	/**
	 * A equity option simple strategy feature.
	 */
	StrategyFeature getStrategyFeature();

	/*********************** Build Methods  ***********************/
	EquityDerivativeBase build();
	
	EquityDerivativeBase.EquityDerivativeBaseBuilder toBuilder();
	
	static EquityDerivativeBase.EquityDerivativeBaseBuilder builder() {
		return new EquityDerivativeBase.EquityDerivativeBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityDerivativeBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityDerivativeBase> getType() {
		return EquityDerivativeBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), EquityOptionTypeEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("equityEffectiveDate"), Date.class, getEquityEffectiveDate(), this);
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.class, getEquityExercise());
		processRosetta(path.newSubPath("featureModel"), processor, FeatureModel.class, getFeatureModel());
		processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.class, getStrategyFeature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityDerivativeBaseBuilder extends EquityDerivativeBase, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		Underlyer.UnderlyerBuilder getUnderlyer();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional();
		NonNegativeMoney.NonNegativeMoneyBuilder getNotional();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise();
		FeatureModel.FeatureModelBuilder getOrCreateFeatureModel();
		FeatureModel.FeatureModelBuilder getFeatureModel();
		StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature();
		StrategyFeature.StrategyFeatureBuilder getStrategyFeature();
		EquityDerivativeBase.EquityDerivativeBaseBuilder setProductModel(ProductModel productModel);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setId(String id);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setOptionType(EquityOptionTypeEnum optionType);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityEffectiveDate(Date equityEffectiveDate);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setUnderlyer(Underlyer underlyer);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setNotional(NonNegativeMoney notional);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setFeatureModel(FeatureModel featureModel);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setStrategyFeature(StrategyFeature strategyFeature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), EquityOptionTypeEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("equityEffectiveDate"), Date.class, getEquityEffectiveDate(), this);
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder.class, getEquityExercise());
			processRosetta(path.newSubPath("featureModel"), processor, FeatureModel.FeatureModelBuilder.class, getFeatureModel());
			processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.StrategyFeatureBuilder.class, getStrategyFeature());
		}
		

		EquityDerivativeBase.EquityDerivativeBaseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityDerivativeBase  ***********************/
	class EquityDerivativeBaseImpl extends Product.ProductImpl implements EquityDerivativeBase {
		private final BuyerSellerModel buyerSellerModel;
		private final EquityOptionTypeEnum optionType;
		private final Date equityEffectiveDate;
		private final Underlyer underlyer;
		private final NonNegativeMoney notional;
		private final EquityExerciseValuationSettlement equityExercise;
		private final FeatureModel featureModel;
		private final StrategyFeature strategyFeature;
		
		protected EquityDerivativeBaseImpl(EquityDerivativeBase.EquityDerivativeBaseBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.equityEffectiveDate = builder.getEquityEffectiveDate();
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.equityExercise = ofNullable(builder.getEquityExercise()).map(f->f.build()).orElse(null);
			this.featureModel = ofNullable(builder.getFeatureModel()).map(f->f.build()).orElse(null);
			this.strategyFeature = ofNullable(builder.getStrategyFeature()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("optionType")
		public EquityOptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public Date getEquityEffectiveDate() {
			return equityEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public Underlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("notional")
		public NonNegativeMoney getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("equityExercise")
		public EquityExerciseValuationSettlement getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		@RosettaAttribute("featureModel")
		public FeatureModel getFeatureModel() {
			return featureModel;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		public StrategyFeature getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public EquityDerivativeBase build() {
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder toBuilder() {
			EquityDerivativeBase.EquityDerivativeBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityDerivativeBase.EquityDerivativeBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getEquityEffectiveDate()).ifPresent(builder::setEquityEffectiveDate);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getEquityExercise()).ifPresent(builder::setEquityExercise);
			ofNullable(getFeatureModel()).ifPresent(builder::setFeatureModel);
			ofNullable(getStrategyFeature()).ifPresent(builder::setStrategyFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(equityEffectiveDate, _that.getEquityEffectiveDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(featureModel, _that.getFeatureModel())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityEffectiveDate != null ? equityEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (featureModel != null ? featureModel.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeBase {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"optionType=" + this.optionType + ", " +
				"equityEffectiveDate=" + this.equityEffectiveDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"featureModel=" + this.featureModel + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityDerivativeBase  ***********************/
	class EquityDerivativeBaseBuilderImpl extends Product.ProductBuilderImpl  implements EquityDerivativeBase.EquityDerivativeBaseBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected EquityOptionTypeEnum optionType;
		protected Date equityEffectiveDate;
		protected Underlyer.UnderlyerBuilder underlyer;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notional;
		protected EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder equityExercise;
		protected FeatureModel.FeatureModelBuilder featureModel;
		protected StrategyFeature.StrategyFeatureBuilder strategyFeature;
	
		public EquityDerivativeBaseBuilderImpl() {
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
		public EquityOptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public Date getEquityEffectiveDate() {
			return equityEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public Underlyer.UnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder getOrCreateUnderlyer() {
			Underlyer.UnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = Underlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotional() {
			return notional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityExercise")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise() {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder result;
			if (equityExercise!=null) {
				result = equityExercise;
			}
			else {
				result = equityExercise = EquityExerciseValuationSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("featureModel")
		public FeatureModel.FeatureModelBuilder getFeatureModel() {
			return featureModel;
		}
		
		@Override
		public FeatureModel.FeatureModelBuilder getOrCreateFeatureModel() {
			FeatureModel.FeatureModelBuilder result;
			if (featureModel!=null) {
				result = featureModel;
			}
			else {
				result = featureModel = FeatureModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		public StrategyFeature.StrategyFeatureBuilder getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature() {
			StrategyFeature.StrategyFeatureBuilder result;
			if (strategyFeature!=null) {
				result = strategyFeature;
			}
			else {
				result = strategyFeature = StrategyFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setOptionType(EquityOptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityEffectiveDate(Date equityEffectiveDate) {
			this.equityEffectiveDate = equityEffectiveDate==null?null:equityEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featureModel")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setFeatureModel(FeatureModel featureModel) {
			this.featureModel = featureModel==null?null:featureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		
		@Override
		public EquityDerivativeBase build() {
			return new EquityDerivativeBase.EquityDerivativeBaseImpl(this);
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (equityExercise!=null && !equityExercise.prune().hasData()) equityExercise = null;
			if (featureModel!=null && !featureModel.prune().hasData()) featureModel = null;
			if (strategyFeature!=null && !strategyFeature.prune().hasData()) strategyFeature = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getEquityEffectiveDate()!=null) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getEquityExercise()!=null && getEquityExercise().hasData()) return true;
			if (getFeatureModel()!=null && getFeatureModel().hasData()) return true;
			if (getStrategyFeature()!=null && getStrategyFeature().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityDerivativeBase.EquityDerivativeBaseBuilder o = (EquityDerivativeBase.EquityDerivativeBaseBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getEquityExercise(), o.getEquityExercise(), this::setEquityExercise);
			merger.mergeRosetta(getFeatureModel(), o.getFeatureModel(), this::setFeatureModel);
			merger.mergeRosetta(getStrategyFeature(), o.getStrategyFeature(), this::setStrategyFeature);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getEquityEffectiveDate(), o.getEquityEffectiveDate(), this::setEquityEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(equityEffectiveDate, _that.getEquityEffectiveDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(featureModel, _that.getFeatureModel())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityEffectiveDate != null ? equityEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (featureModel != null ? featureModel.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeBaseBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"optionType=" + this.optionType + ", " +
				"equityEffectiveDate=" + this.equityEffectiveDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"featureModel=" + this.featureModel + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}' + " " + super.toString();
		}
	}
}
