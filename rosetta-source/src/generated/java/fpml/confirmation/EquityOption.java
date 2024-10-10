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
import fpml.confirmation.DividendConditions;
import fpml.confirmation.EquityDerivativeLongFormBase;
import fpml.confirmation.EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder;
import fpml.confirmation.EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl;
import fpml.confirmation.EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseImpl;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOption;
import fpml.confirmation.EquityOption.EquityOptionBuilder;
import fpml.confirmation.EquityOption.EquityOptionBuilderImpl;
import fpml.confirmation.EquityOption.EquityOptionImpl;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.EquityOptionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A component describing an Equity Option product. A type for defining equity options.
 * @version ${project.version}
 */
@RosettaDataType(value="EquityOption", builder=EquityOption.EquityOptionBuilderImpl.class, version="${project.version}")
public interface EquityOption extends EquityDerivativeLongFormBase {

	EquityOptionMeta metaData = new EquityOptionMeta();

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
	 * The number of shares per option comprised in the option transaction.
	 */
	BigDecimal getOptionEntitlement();
	/**
	 * The equity option premium payable by the buyer to the seller.
	 */
	EquityPremium getEquityPremium();

	/*********************** Build Methods  ***********************/
	EquityOption build();
	
	EquityOption.EquityOptionBuilder toBuilder();
	
	static EquityOption.EquityOptionBuilder builder() {
		return new EquityOption.EquityOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityOption> getType() {
		return EquityOption.class;
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
		processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.class, getDividendConditions());
		processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
		processRosetta(path.newSubPath("strike"), processor, EquityStrike.class, getStrike());
		processor.processBasic(path.newSubPath("spotPrice"), BigDecimal.class, getSpotPrice(), this);
		processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.class, getEquityPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityOptionBuilder extends EquityOption, EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder {
		EquityStrike.EquityStrikeBuilder getOrCreateStrike();
		EquityStrike.EquityStrikeBuilder getStrike();
		EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium();
		EquityPremium.EquityPremiumBuilder getEquityPremium();
		EquityOption.EquityOptionBuilder setProductModel(ProductModel productModel);
		EquityOption.EquityOptionBuilder setId(String id);
		EquityOption.EquityOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		EquityOption.EquityOptionBuilder setOptionType(EquityOptionTypeEnum optionType);
		EquityOption.EquityOptionBuilder setEquityEffectiveDate(Date equityEffectiveDate);
		EquityOption.EquityOptionBuilder setUnderlyer(Underlyer underlyer);
		EquityOption.EquityOptionBuilder setNotional(NonNegativeMoney notional);
		EquityOption.EquityOptionBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		EquityOption.EquityOptionBuilder setFeatureModel(FeatureModel featureModel);
		EquityOption.EquityOptionBuilder setStrategyFeature(StrategyFeature strategyFeature);
		EquityOption.EquityOptionBuilder setDividendConditions(DividendConditions dividendConditions);
		EquityOption.EquityOptionBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		EquityOption.EquityOptionBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		EquityOption.EquityOptionBuilder setStrike(EquityStrike strike);
		EquityOption.EquityOptionBuilder setSpotPrice(BigDecimal spotPrice);
		EquityOption.EquityOptionBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		EquityOption.EquityOptionBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		EquityOption.EquityOptionBuilder setEquityPremium(EquityPremium equityPremium);

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
			processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.DividendConditionsBuilder.class, getDividendConditions());
			processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
			processRosetta(path.newSubPath("strike"), processor, EquityStrike.EquityStrikeBuilder.class, getStrike());
			processor.processBasic(path.newSubPath("spotPrice"), BigDecimal.class, getSpotPrice(), this);
			processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.EquityPremiumBuilder.class, getEquityPremium());
		}
		

		EquityOption.EquityOptionBuilder prune();
	}

	/*********************** Immutable Implementation of EquityOption  ***********************/
	class EquityOptionImpl extends EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseImpl implements EquityOption {
		private final EquityStrike strike;
		private final BigDecimal spotPrice;
		private final BigDecimal numberOfOptions;
		private final BigDecimal optionEntitlement;
		private final EquityPremium equityPremium;
		
		protected EquityOptionImpl(EquityOption.EquityOptionBuilder builder) {
			super(builder);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.spotPrice = builder.getSpotPrice();
			this.numberOfOptions = builder.getNumberOfOptions();
			this.optionEntitlement = builder.getOptionEntitlement();
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
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("equityPremium")
		public EquityPremium getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		public EquityOption build() {
			return this;
		}
		
		@Override
		public EquityOption.EquityOptionBuilder toBuilder() {
			EquityOption.EquityOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityOption.EquityOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getSpotPrice()).ifPresent(builder::setSpotPrice);
			ofNullable(getNumberOfOptions()).ifPresent(builder::setNumberOfOptions);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getEquityPremium()).ifPresent(builder::setEquityPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityOption {" +
				"strike=" + this.strike + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"equityPremium=" + this.equityPremium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityOption  ***********************/
	class EquityOptionBuilderImpl extends EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl  implements EquityOption.EquityOptionBuilder {
	
		protected EquityStrike.EquityStrikeBuilder strike;
		protected BigDecimal spotPrice;
		protected BigDecimal numberOfOptions;
		protected BigDecimal optionEntitlement;
		protected EquityPremium.EquityPremiumBuilder equityPremium;
	
		public EquityOptionBuilderImpl() {
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
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
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
		public EquityOption.EquityOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquityOption.EquityOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public EquityOption.EquityOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public EquityOption.EquityOptionBuilder setOptionType(EquityOptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public EquityOption.EquityOptionBuilder setEquityEffectiveDate(Date equityEffectiveDate) {
			this.equityEffectiveDate = equityEffectiveDate==null?null:equityEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public EquityOption.EquityOptionBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public EquityOption.EquityOptionBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public EquityOption.EquityOptionBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featureModel")
		public EquityOption.EquityOptionBuilder setFeatureModel(FeatureModel featureModel) {
			this.featureModel = featureModel==null?null:featureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public EquityOption.EquityOptionBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendConditions")
		public EquityOption.EquityOptionBuilder setDividendConditions(DividendConditions dividendConditions) {
			this.dividendConditions = dividendConditions==null?null:dividendConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public EquityOption.EquityOptionBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment) {
			this.methodOfAdjustment = methodOfAdjustment==null?null:methodOfAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public EquityOption.EquityOptionBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public EquityOption.EquityOptionBuilder setStrike(EquityStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotPrice")
		public EquityOption.EquityOptionBuilder setSpotPrice(BigDecimal spotPrice) {
			this.spotPrice = spotPrice==null?null:spotPrice;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfOptions")
		public EquityOption.EquityOptionBuilder setNumberOfOptions(BigDecimal numberOfOptions) {
			this.numberOfOptions = numberOfOptions==null?null:numberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("optionEntitlement")
		public EquityOption.EquityOptionBuilder setOptionEntitlement(BigDecimal optionEntitlement) {
			this.optionEntitlement = optionEntitlement==null?null:optionEntitlement;
			return this;
		}
		@Override
		@RosettaAttribute("equityPremium")
		public EquityOption.EquityOptionBuilder setEquityPremium(EquityPremium equityPremium) {
			this.equityPremium = equityPremium==null?null:equityPremium.toBuilder();
			return this;
		}
		
		@Override
		public EquityOption build() {
			return new EquityOption.EquityOptionImpl(this);
		}
		
		@Override
		public EquityOption.EquityOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityOption.EquityOptionBuilder prune() {
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
			if (getOptionEntitlement()!=null) return true;
			if (getEquityPremium()!=null && getEquityPremium().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityOption.EquityOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityOption.EquityOptionBuilder o = (EquityOption.EquityOptionBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getEquityPremium(), o.getEquityPremium(), this::setEquityPremium);
			
			merger.mergeBasic(getSpotPrice(), o.getSpotPrice(), this::setSpotPrice);
			merger.mergeBasic(getNumberOfOptions(), o.getNumberOfOptions(), this::setNumberOfOptions);
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityOptionBuilder {" +
				"strike=" + this.strike + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"equityPremium=" + this.equityPremium +
			'}' + " " + super.toString();
		}
	}
}
