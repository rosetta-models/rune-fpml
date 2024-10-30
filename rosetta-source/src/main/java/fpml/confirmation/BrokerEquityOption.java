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
import fpml.confirmation.BrokerEquityOption;
import fpml.confirmation.BrokerEquityOption.BrokerEquityOptionBuilder;
import fpml.confirmation.BrokerEquityOption.BrokerEquityOptionBuilderImpl;
import fpml.confirmation.BrokerEquityOption.BrokerEquityOptionImpl;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.EquityDerivativeShortFormBase;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl;
import fpml.confirmation.EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.BrokerEquityOptionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A component describing a Broker View of an Equity Option. A type for defining the broker equity options.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BrokerEquityOption", builder=BrokerEquityOption.BrokerEquityOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BrokerEquityOption extends EquityDerivativeShortFormBase {

	BrokerEquityOptionMeta metaData = new BrokerEquityOptionMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getDeltaCrossed();
	Money getBrokerageFee();
	String getBrokerNotes();

	/*********************** Build Methods  ***********************/
	BrokerEquityOption build();
	
	BrokerEquityOption.BrokerEquityOptionBuilder toBuilder();
	
	static BrokerEquityOption.BrokerEquityOptionBuilder builder() {
		return new BrokerEquityOption.BrokerEquityOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BrokerEquityOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BrokerEquityOption> getType() {
		return BrokerEquityOption.class;
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
		processor.processBasic(path.newSubPath("deltaCrossed"), Boolean.class, getDeltaCrossed(), this);
		processRosetta(path.newSubPath("brokerageFee"), processor, Money.class, getBrokerageFee());
		processor.processBasic(path.newSubPath("brokerNotes"), String.class, getBrokerNotes(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BrokerEquityOptionBuilder extends BrokerEquityOption, EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder {
		Money.MoneyBuilder getOrCreateBrokerageFee();
		Money.MoneyBuilder getBrokerageFee();
		BrokerEquityOption.BrokerEquityOptionBuilder setProductModel(ProductModel productModel);
		BrokerEquityOption.BrokerEquityOptionBuilder setId(String id);
		BrokerEquityOption.BrokerEquityOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		BrokerEquityOption.BrokerEquityOptionBuilder setOptionType(EquityOptionTypeEnum optionType);
		BrokerEquityOption.BrokerEquityOptionBuilder setEquityEffectiveDate(Date equityEffectiveDate);
		BrokerEquityOption.BrokerEquityOptionBuilder setUnderlyer(Underlyer underlyer);
		BrokerEquityOption.BrokerEquityOptionBuilder setNotional(NonNegativeMoney notional);
		BrokerEquityOption.BrokerEquityOptionBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		BrokerEquityOption.BrokerEquityOptionBuilder setFeatureModel(FeatureModel featureModel);
		BrokerEquityOption.BrokerEquityOptionBuilder setStrategyFeature(StrategyFeature strategyFeature);
		BrokerEquityOption.BrokerEquityOptionBuilder setStrike(EquityStrike strike);
		BrokerEquityOption.BrokerEquityOptionBuilder setSpotPrice(BigDecimal spotPrice);
		BrokerEquityOption.BrokerEquityOptionBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		BrokerEquityOption.BrokerEquityOptionBuilder setEquityPremium(EquityPremium equityPremium);
		BrokerEquityOption.BrokerEquityOptionBuilder setDeltaCrossed(Boolean deltaCrossed);
		BrokerEquityOption.BrokerEquityOptionBuilder setBrokerageFee(Money brokerageFee);
		BrokerEquityOption.BrokerEquityOptionBuilder setBrokerNotes(String brokerNotes);

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
			processor.processBasic(path.newSubPath("deltaCrossed"), Boolean.class, getDeltaCrossed(), this);
			processRosetta(path.newSubPath("brokerageFee"), processor, Money.MoneyBuilder.class, getBrokerageFee());
			processor.processBasic(path.newSubPath("brokerNotes"), String.class, getBrokerNotes(), this);
		}
		

		BrokerEquityOption.BrokerEquityOptionBuilder prune();
	}

	/*********************** Immutable Implementation of BrokerEquityOption  ***********************/
	class BrokerEquityOptionImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl implements BrokerEquityOption {
		private final Boolean deltaCrossed;
		private final Money brokerageFee;
		private final String brokerNotes;
		
		protected BrokerEquityOptionImpl(BrokerEquityOption.BrokerEquityOptionBuilder builder) {
			super(builder);
			this.deltaCrossed = builder.getDeltaCrossed();
			this.brokerageFee = ofNullable(builder.getBrokerageFee()).map(f->f.build()).orElse(null);
			this.brokerNotes = builder.getBrokerNotes();
		}
		
		@Override
		@RosettaAttribute("deltaCrossed")
		public Boolean getDeltaCrossed() {
			return deltaCrossed;
		}
		
		@Override
		@RosettaAttribute("brokerageFee")
		public Money getBrokerageFee() {
			return brokerageFee;
		}
		
		@Override
		@RosettaAttribute("brokerNotes")
		public String getBrokerNotes() {
			return brokerNotes;
		}
		
		@Override
		public BrokerEquityOption build() {
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder toBuilder() {
			BrokerEquityOption.BrokerEquityOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BrokerEquityOption.BrokerEquityOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeltaCrossed()).ifPresent(builder::setDeltaCrossed);
			ofNullable(getBrokerageFee()).ifPresent(builder::setBrokerageFee);
			ofNullable(getBrokerNotes()).ifPresent(builder::setBrokerNotes);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BrokerEquityOption _that = getType().cast(o);
		
			if (!Objects.equals(deltaCrossed, _that.getDeltaCrossed())) return false;
			if (!Objects.equals(brokerageFee, _that.getBrokerageFee())) return false;
			if (!Objects.equals(brokerNotes, _that.getBrokerNotes())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deltaCrossed != null ? deltaCrossed.hashCode() : 0);
			_result = 31 * _result + (brokerageFee != null ? brokerageFee.hashCode() : 0);
			_result = 31 * _result + (brokerNotes != null ? brokerNotes.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerEquityOption {" +
				"deltaCrossed=" + this.deltaCrossed + ", " +
				"brokerageFee=" + this.brokerageFee + ", " +
				"brokerNotes=" + this.brokerNotes +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BrokerEquityOption  ***********************/
	class BrokerEquityOptionBuilderImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl  implements BrokerEquityOption.BrokerEquityOptionBuilder {
	
		protected Boolean deltaCrossed;
		protected Money.MoneyBuilder brokerageFee;
		protected String brokerNotes;
	
		public BrokerEquityOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deltaCrossed")
		public Boolean getDeltaCrossed() {
			return deltaCrossed;
		}
		
		@Override
		@RosettaAttribute("brokerageFee")
		public Money.MoneyBuilder getBrokerageFee() {
			return brokerageFee;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateBrokerageFee() {
			Money.MoneyBuilder result;
			if (brokerageFee!=null) {
				result = brokerageFee;
			}
			else {
				result = brokerageFee = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("brokerNotes")
		public String getBrokerNotes() {
			return brokerNotes;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public BrokerEquityOption.BrokerEquityOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BrokerEquityOption.BrokerEquityOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BrokerEquityOption.BrokerEquityOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public BrokerEquityOption.BrokerEquityOptionBuilder setOptionType(EquityOptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public BrokerEquityOption.BrokerEquityOptionBuilder setEquityEffectiveDate(Date equityEffectiveDate) {
			this.equityEffectiveDate = equityEffectiveDate==null?null:equityEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public BrokerEquityOption.BrokerEquityOptionBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public BrokerEquityOption.BrokerEquityOptionBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public BrokerEquityOption.BrokerEquityOptionBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featureModel")
		public BrokerEquityOption.BrokerEquityOptionBuilder setFeatureModel(FeatureModel featureModel) {
			this.featureModel = featureModel==null?null:featureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public BrokerEquityOption.BrokerEquityOptionBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public BrokerEquityOption.BrokerEquityOptionBuilder setStrike(EquityStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotPrice")
		public BrokerEquityOption.BrokerEquityOptionBuilder setSpotPrice(BigDecimal spotPrice) {
			this.spotPrice = spotPrice==null?null:spotPrice;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfOptions")
		public BrokerEquityOption.BrokerEquityOptionBuilder setNumberOfOptions(BigDecimal numberOfOptions) {
			this.numberOfOptions = numberOfOptions==null?null:numberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("equityPremium")
		public BrokerEquityOption.BrokerEquityOptionBuilder setEquityPremium(EquityPremium equityPremium) {
			this.equityPremium = equityPremium==null?null:equityPremium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deltaCrossed")
		public BrokerEquityOption.BrokerEquityOptionBuilder setDeltaCrossed(Boolean deltaCrossed) {
			this.deltaCrossed = deltaCrossed==null?null:deltaCrossed;
			return this;
		}
		@Override
		@RosettaAttribute("brokerageFee")
		public BrokerEquityOption.BrokerEquityOptionBuilder setBrokerageFee(Money brokerageFee) {
			this.brokerageFee = brokerageFee==null?null:brokerageFee.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("brokerNotes")
		public BrokerEquityOption.BrokerEquityOptionBuilder setBrokerNotes(String brokerNotes) {
			this.brokerNotes = brokerNotes==null?null:brokerNotes;
			return this;
		}
		
		@Override
		public BrokerEquityOption build() {
			return new BrokerEquityOption.BrokerEquityOptionImpl(this);
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder prune() {
			super.prune();
			if (brokerageFee!=null && !brokerageFee.prune().hasData()) brokerageFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeltaCrossed()!=null) return true;
			if (getBrokerageFee()!=null && getBrokerageFee().hasData()) return true;
			if (getBrokerNotes()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BrokerEquityOption.BrokerEquityOptionBuilder o = (BrokerEquityOption.BrokerEquityOptionBuilder) other;
			
			merger.mergeRosetta(getBrokerageFee(), o.getBrokerageFee(), this::setBrokerageFee);
			
			merger.mergeBasic(getDeltaCrossed(), o.getDeltaCrossed(), this::setDeltaCrossed);
			merger.mergeBasic(getBrokerNotes(), o.getBrokerNotes(), this::setBrokerNotes);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BrokerEquityOption _that = getType().cast(o);
		
			if (!Objects.equals(deltaCrossed, _that.getDeltaCrossed())) return false;
			if (!Objects.equals(brokerageFee, _that.getBrokerageFee())) return false;
			if (!Objects.equals(brokerNotes, _that.getBrokerNotes())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deltaCrossed != null ? deltaCrossed.hashCode() : 0);
			_result = 31 * _result + (brokerageFee != null ? brokerageFee.hashCode() : 0);
			_result = 31 * _result + (brokerNotes != null ? brokerNotes.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerEquityOptionBuilder {" +
				"deltaCrossed=" + this.deltaCrossed + ", " +
				"brokerageFee=" + this.brokerageFee + ", " +
				"brokerNotes=" + this.brokerNotes +
			'}' + " " + super.toString();
		}
	}
}
