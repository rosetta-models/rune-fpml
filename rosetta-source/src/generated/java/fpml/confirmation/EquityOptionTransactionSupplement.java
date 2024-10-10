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
import fpml.confirmation.CountryCode;
import fpml.confirmation.EquityDerivativeShortFormBase;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOptionTransactionSupplement;
import fpml.confirmation.EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder;
import fpml.confirmation.EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilderImpl;
import fpml.confirmation.EquityOptionTransactionSupplement.EquityOptionTransactionSupplementImpl;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.IndexAnnexFallbackModel;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.EquityOptionTransactionSupplementMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A component describing an Equity Option Transaction Supplement. A type for defining equity option transaction supplements.
 * @version ${project.version}
 */
@RosettaDataType(value="EquityOptionTransactionSupplement", builder=EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilderImpl.class, version="${project.version}")
public interface EquityOptionTransactionSupplement extends EquityDerivativeShortFormBase {

	EquityOptionTransactionSupplementMeta metaData = new EquityOptionTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * For a share option transaction, a flag used to indicate whether the transaction is to be treated as an &#39;exchange look-alike&#39;. This designation has significance for how share adjustments (arising from corporate actions) will be determined for the transaction. For an &#39;exchange look-alike&#39; transaction the relevant share adjustments will follow that for a corresponding designated contract listed on the related exchange (referred to as Options Exchange Adjustment (ISDA defined term), otherwise the share adjustments will be determined by the calculation agent (referred to as Calculation Agent Adjustment (ISDA defined term)).
	 */
	Boolean getExchangeLookAlike();
	/**
	 * For an index option transaction, a flag used in conjuction with Futures Price Valuation (ISDA defined term) to indicate whether the Nearest Index Contract provision is applicable. The Nearest Index Contract provision is a rule for determining the Exchange-traded Contract (ISDA defined term) without having to explicitly state the actual contract, delivery month and exchange on which it is traded.
	 */
	Boolean getExchangeTradedContractNearest();
	IndexAnnexFallbackModel getIndexAnnexFallbackModel();
	MethodOfAdjustmentEnum getMethodOfAdjustment();
	/**
	 * Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 */
	CountryCode getLocalJurisdiction();
	/**
	 * The number of shares per option comprised in the option transaction supplement.
	 */
	BigDecimal getOptionEntitlement();
	/**
	 * Specifies the contract multiplier that can be associated with an index option.
	 */
	BigDecimal getMultiplier();
	/**
	 * A component to contain elements that represent an extraordinary event.
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	EquityOptionTransactionSupplement build();
	
	EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder toBuilder();
	
	static EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder() {
		return new EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityOptionTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityOptionTransactionSupplement> getType() {
		return EquityOptionTransactionSupplement.class;
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
		processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
		processor.processBasic(path.newSubPath("exchangeTradedContractNearest"), Boolean.class, getExchangeTradedContractNearest(), this);
		processRosetta(path.newSubPath("indexAnnexFallbackModel"), processor, IndexAnnexFallbackModel.class, getIndexAnnexFallbackModel());
		processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
		processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.class, getLocalJurisdiction());
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityOptionTransactionSupplementBuilder extends EquityOptionTransactionSupplement, EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder {
		IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getOrCreateIndexAnnexFallbackModel();
		IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getIndexAnnexFallbackModel();
		CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction();
		CountryCode.CountryCodeBuilder getLocalJurisdiction();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setProductModel(ProductModel productModel);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setId(String id);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionType(EquityOptionTypeEnum optionType);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityEffectiveDate(Date equityEffectiveDate);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setUnderlyer(Underlyer underlyer);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNotional(NonNegativeMoney notional);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setFeatureModel(FeatureModel featureModel);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrategyFeature(StrategyFeature strategyFeature);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrike(EquityStrike strike);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSpotPrice(BigDecimal spotPrice);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeTradedContractNearest(Boolean exchangeTradedContractNearest);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setIndexAnnexFallbackModel(IndexAnnexFallbackModel indexAnnexFallbackModel);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setLocalJurisdiction(CountryCode localJurisdiction);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

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
			processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
			processor.processBasic(path.newSubPath("exchangeTradedContractNearest"), Boolean.class, getExchangeTradedContractNearest(), this);
			processRosetta(path.newSubPath("indexAnnexFallbackModel"), processor, IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder.class, getIndexAnnexFallbackModel());
			processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
			processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getLocalJurisdiction());
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of EquityOptionTransactionSupplement  ***********************/
	class EquityOptionTransactionSupplementImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl implements EquityOptionTransactionSupplement {
		private final Boolean exchangeLookAlike;
		private final Boolean exchangeTradedContractNearest;
		private final IndexAnnexFallbackModel indexAnnexFallbackModel;
		private final MethodOfAdjustmentEnum methodOfAdjustment;
		private final CountryCode localJurisdiction;
		private final BigDecimal optionEntitlement;
		private final BigDecimal multiplier;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected EquityOptionTransactionSupplementImpl(EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder) {
			super(builder);
			this.exchangeLookAlike = builder.getExchangeLookAlike();
			this.exchangeTradedContractNearest = builder.getExchangeTradedContractNearest();
			this.indexAnnexFallbackModel = ofNullable(builder.getIndexAnnexFallbackModel()).map(f->f.build()).orElse(null);
			this.methodOfAdjustment = builder.getMethodOfAdjustment();
			this.localJurisdiction = ofNullable(builder.getLocalJurisdiction()).map(f->f.build()).orElse(null);
			this.optionEntitlement = builder.getOptionEntitlement();
			this.multiplier = builder.getMultiplier();
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public Boolean getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		@RosettaAttribute("indexAnnexFallbackModel")
		public IndexAnnexFallbackModel getIndexAnnexFallbackModel() {
			return indexAnnexFallbackModel;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		public CountryCode getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public EquityOptionTransactionSupplement build() {
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder toBuilder() {
			EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExchangeLookAlike()).ifPresent(builder::setExchangeLookAlike);
			ofNullable(getExchangeTradedContractNearest()).ifPresent(builder::setExchangeTradedContractNearest);
			ofNullable(getIndexAnnexFallbackModel()).ifPresent(builder::setIndexAnnexFallbackModel);
			ofNullable(getMethodOfAdjustment()).ifPresent(builder::setMethodOfAdjustment);
			ofNullable(getLocalJurisdiction()).ifPresent(builder::setLocalJurisdiction);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(indexAnnexFallbackModel, _that.getIndexAnnexFallbackModel())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (indexAnnexFallbackModel != null ? indexAnnexFallbackModel.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityOptionTransactionSupplement {" +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"indexAnnexFallbackModel=" + this.indexAnnexFallbackModel + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityOptionTransactionSupplement  ***********************/
	class EquityOptionTransactionSupplementBuilderImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl  implements EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder {
	
		protected Boolean exchangeLookAlike;
		protected Boolean exchangeTradedContractNearest;
		protected IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder indexAnnexFallbackModel;
		protected MethodOfAdjustmentEnum methodOfAdjustment;
		protected CountryCode.CountryCodeBuilder localJurisdiction;
		protected BigDecimal optionEntitlement;
		protected BigDecimal multiplier;
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
	
		public EquityOptionTransactionSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public Boolean getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		@RosettaAttribute("indexAnnexFallbackModel")
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getIndexAnnexFallbackModel() {
			return indexAnnexFallbackModel;
		}
		
		@Override
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getOrCreateIndexAnnexFallbackModel() {
			IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder result;
			if (indexAnnexFallbackModel!=null) {
				result = indexAnnexFallbackModel;
			}
			else {
				result = indexAnnexFallbackModel = IndexAnnexFallbackModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		public CountryCode.CountryCodeBuilder getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (localJurisdiction!=null) {
				result = localJurisdiction;
			}
			else {
				result = localJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionType(EquityOptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityEffectiveDate(Date equityEffectiveDate) {
			this.equityEffectiveDate = equityEffectiveDate==null?null:equityEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featureModel")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setFeatureModel(FeatureModel featureModel) {
			this.featureModel = featureModel==null?null:featureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrike(EquityStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotPrice")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSpotPrice(BigDecimal spotPrice) {
			this.spotPrice = spotPrice==null?null:spotPrice;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfOptions")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNumberOfOptions(BigDecimal numberOfOptions) {
			this.numberOfOptions = numberOfOptions==null?null:numberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("equityPremium")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium) {
			this.equityPremium = equityPremium==null?null:equityPremium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeLookAlike")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike) {
			this.exchangeLookAlike = exchangeLookAlike==null?null:exchangeLookAlike;
			return this;
		}
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeTradedContractNearest(Boolean exchangeTradedContractNearest) {
			this.exchangeTradedContractNearest = exchangeTradedContractNearest==null?null:exchangeTradedContractNearest;
			return this;
		}
		@Override
		@RosettaAttribute("indexAnnexFallbackModel")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setIndexAnnexFallbackModel(IndexAnnexFallbackModel indexAnnexFallbackModel) {
			this.indexAnnexFallbackModel = indexAnnexFallbackModel==null?null:indexAnnexFallbackModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment) {
			this.methodOfAdjustment = methodOfAdjustment==null?null:methodOfAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("localJurisdiction")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setLocalJurisdiction(CountryCode localJurisdiction) {
			this.localJurisdiction = localJurisdiction==null?null:localJurisdiction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionEntitlement")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement) {
			this.optionEntitlement = optionEntitlement==null?null:optionEntitlement;
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement build() {
			return new EquityOptionTransactionSupplement.EquityOptionTransactionSupplementImpl(this);
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder prune() {
			super.prune();
			if (indexAnnexFallbackModel!=null && !indexAnnexFallbackModel.prune().hasData()) indexAnnexFallbackModel = null;
			if (localJurisdiction!=null && !localJurisdiction.prune().hasData()) localJurisdiction = null;
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExchangeLookAlike()!=null) return true;
			if (getExchangeTradedContractNearest()!=null) return true;
			if (getIndexAnnexFallbackModel()!=null && getIndexAnnexFallbackModel().hasData()) return true;
			if (getMethodOfAdjustment()!=null) return true;
			if (getLocalJurisdiction()!=null && getLocalJurisdiction().hasData()) return true;
			if (getOptionEntitlement()!=null) return true;
			if (getMultiplier()!=null) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder o = (EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getIndexAnnexFallbackModel(), o.getIndexAnnexFallbackModel(), this::setIndexAnnexFallbackModel);
			merger.mergeRosetta(getLocalJurisdiction(), o.getLocalJurisdiction(), this::setLocalJurisdiction);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			merger.mergeBasic(getExchangeLookAlike(), o.getExchangeLookAlike(), this::setExchangeLookAlike);
			merger.mergeBasic(getExchangeTradedContractNearest(), o.getExchangeTradedContractNearest(), this::setExchangeTradedContractNearest);
			merger.mergeBasic(getMethodOfAdjustment(), o.getMethodOfAdjustment(), this::setMethodOfAdjustment);
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(indexAnnexFallbackModel, _that.getIndexAnnexFallbackModel())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (indexAnnexFallbackModel != null ? indexAnnexFallbackModel.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityOptionTransactionSupplementBuilder {" +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"indexAnnexFallbackModel=" + this.indexAnnexFallbackModel + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
