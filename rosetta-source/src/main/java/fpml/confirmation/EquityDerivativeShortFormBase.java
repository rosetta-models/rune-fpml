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
import fpml.confirmation.EquityDerivativeShortFormBase;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.EquityDerivativeShortFormBaseMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining short form equity option basic features.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityDerivativeShortFormBase", builder=EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityDerivativeShortFormBase extends EquityDerivativeBase {

	EquityDerivativeShortFormBaseMeta metaData = new EquityDerivativeShortFormBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines whether it is a price or level at which the option has been, or will be, struck.
	 */
	EquityStrike getStrike();
	/**
	 * The price per share, index or basket observed on the trade or effective date.
	 */
	BigDecimal getSpotPrice();
	/**
	 * The number of options comprised in the option transaction.
	 */
	BigDecimal getNumberOfOptions();
	/**
	 * The equity option premium payable by the buyer to the seller.
	 */
	EquityPremium getEquityPremium();

	/*********************** Build Methods  ***********************/
	EquityDerivativeShortFormBase build();
	
	EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder toBuilder();
	
	static EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder() {
		return new EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityDerivativeShortFormBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityDerivativeShortFormBase> getType() {
		return EquityDerivativeShortFormBase.class;
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
		processRosetta(path.newSubPath("strike"), processor, EquityStrike.class, getStrike());
		processor.processBasic(path.newSubPath("spotPrice"), BigDecimal.class, getSpotPrice(), this);
		processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
		processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.class, getEquityPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityDerivativeShortFormBaseBuilder extends EquityDerivativeShortFormBase, EquityDerivativeBase.EquityDerivativeBaseBuilder {
		EquityStrike.EquityStrikeBuilder getOrCreateStrike();
		EquityStrike.EquityStrikeBuilder getStrike();
		EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium();
		EquityPremium.EquityPremiumBuilder getEquityPremium();
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setProductModel(ProductModel productModel);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setId(String id);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setOptionType(EquityOptionTypeEnum optionType);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityEffectiveDate(Date equityEffectiveDate);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setUnderlyer(Underlyer underlyer);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNotional(NonNegativeMoney notional);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setFeatureModel(FeatureModel featureModel);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrategyFeature(StrategyFeature strategyFeature);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrike(EquityStrike strike);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSpotPrice(BigDecimal spotPrice);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityPremium(EquityPremium equityPremium);

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
			processRosetta(path.newSubPath("strike"), processor, EquityStrike.EquityStrikeBuilder.class, getStrike());
			processor.processBasic(path.newSubPath("spotPrice"), BigDecimal.class, getSpotPrice(), this);
			processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
			processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.EquityPremiumBuilder.class, getEquityPremium());
		}
		

		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityDerivativeShortFormBase  ***********************/
	class EquityDerivativeShortFormBaseImpl extends EquityDerivativeBase.EquityDerivativeBaseImpl implements EquityDerivativeShortFormBase {
		private final EquityStrike strike;
		private final BigDecimal spotPrice;
		private final BigDecimal numberOfOptions;
		private final EquityPremium equityPremium;
		
		protected EquityDerivativeShortFormBaseImpl(EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder) {
			super(builder);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.spotPrice = builder.getSpotPrice();
			this.numberOfOptions = builder.getNumberOfOptions();
			this.equityPremium = ofNullable(builder.getEquityPremium()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		public EquityStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("spotPrice")
		public BigDecimal getSpotPrice() {
			return spotPrice;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("equityPremium")
		public EquityPremium getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		public EquityDerivativeShortFormBase build() {
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder toBuilder() {
			EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getSpotPrice()).ifPresent(builder::setSpotPrice);
			ofNullable(getNumberOfOptions()).ifPresent(builder::setNumberOfOptions);
			ofNullable(getEquityPremium()).ifPresent(builder::setEquityPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeShortFormBase _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeShortFormBase {" +
				"strike=" + this.strike + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"equityPremium=" + this.equityPremium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityDerivativeShortFormBase  ***********************/
	class EquityDerivativeShortFormBaseBuilderImpl extends EquityDerivativeBase.EquityDerivativeBaseBuilderImpl  implements EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder {
	
		protected EquityStrike.EquityStrikeBuilder strike;
		protected BigDecimal spotPrice;
		protected BigDecimal numberOfOptions;
		protected EquityPremium.EquityPremiumBuilder equityPremium;
	
		public EquityDerivativeShortFormBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strike")
		public EquityStrike.EquityStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public EquityStrike.EquityStrikeBuilder getOrCreateStrike() {
			EquityStrike.EquityStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = EquityStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotPrice")
		public BigDecimal getSpotPrice() {
			return spotPrice;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("equityPremium")
		public EquityPremium.EquityPremiumBuilder getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium() {
			EquityPremium.EquityPremiumBuilder result;
			if (equityPremium!=null) {
				result = equityPremium;
			}
			else {
				result = equityPremium = EquityPremium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setOptionType(EquityOptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityEffectiveDate(Date equityEffectiveDate) {
			this.equityEffectiveDate = equityEffectiveDate==null?null:equityEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featureModel")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setFeatureModel(FeatureModel featureModel) {
			this.featureModel = featureModel==null?null:featureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrike(EquityStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotPrice")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSpotPrice(BigDecimal spotPrice) {
			this.spotPrice = spotPrice==null?null:spotPrice;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfOptions")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNumberOfOptions(BigDecimal numberOfOptions) {
			this.numberOfOptions = numberOfOptions==null?null:numberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("equityPremium")
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityPremium(EquityPremium equityPremium) {
			this.equityPremium = equityPremium==null?null:equityPremium.toBuilder();
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase build() {
			return new EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl(this);
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder prune() {
			super.prune();
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (equityPremium!=null && !equityPremium.prune().hasData()) equityPremium = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getSpotPrice()!=null) return true;
			if (getNumberOfOptions()!=null) return true;
			if (getEquityPremium()!=null && getEquityPremium().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder o = (EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getEquityPremium(), o.getEquityPremium(), this::setEquityPremium);
			
			merger.mergeBasic(getSpotPrice(), o.getSpotPrice(), this::setSpotPrice);
			merger.mergeBasic(getNumberOfOptions(), o.getNumberOfOptions(), this::setNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeShortFormBase _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeShortFormBaseBuilder {" +
				"strike=" + this.strike + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"equityPremium=" + this.equityPremium +
			'}' + " " + super.toString();
		}
	}
}
