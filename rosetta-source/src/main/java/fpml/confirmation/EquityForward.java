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
import fpml.confirmation.EquityForward;
import fpml.confirmation.EquityForward.EquityForwardBuilder;
import fpml.confirmation.EquityForward.EquityForwardBuilderImpl;
import fpml.confirmation.EquityForward.EquityForwardImpl;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.EquityForwardMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A component describing an Equity Forward product. A type for defining equity forwards.
 * @version ${project.version}
 */
@RosettaDataType(value="EquityForward", builder=EquityForward.EquityForwardBuilderImpl.class, version="${project.version}")
public interface EquityForward extends EquityDerivativeLongFormBase {

	EquityForwardMeta metaData = new EquityForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The forward price per share, index or basket.
	 */
	NonNegativeMoney getForwardPrice();

	/*********************** Build Methods  ***********************/
	EquityForward build();
	
	EquityForward.EquityForwardBuilder toBuilder();
	
	static EquityForward.EquityForwardBuilder builder() {
		return new EquityForward.EquityForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityForward> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityForward> getType() {
		return EquityForward.class;
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
		processRosetta(path.newSubPath("forwardPrice"), processor, NonNegativeMoney.class, getForwardPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityForwardBuilder extends EquityForward, EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateForwardPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getForwardPrice();
		EquityForward.EquityForwardBuilder setProductModel(ProductModel productModel);
		EquityForward.EquityForwardBuilder setId(String id);
		EquityForward.EquityForwardBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		EquityForward.EquityForwardBuilder setOptionType(EquityOptionTypeEnum optionType);
		EquityForward.EquityForwardBuilder setEquityEffectiveDate(Date equityEffectiveDate);
		EquityForward.EquityForwardBuilder setUnderlyer(Underlyer underlyer);
		EquityForward.EquityForwardBuilder setNotional(NonNegativeMoney notional);
		EquityForward.EquityForwardBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		EquityForward.EquityForwardBuilder setFeatureModel(FeatureModel featureModel);
		EquityForward.EquityForwardBuilder setStrategyFeature(StrategyFeature strategyFeature);
		EquityForward.EquityForwardBuilder setDividendConditions(DividendConditions dividendConditions);
		EquityForward.EquityForwardBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		EquityForward.EquityForwardBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		EquityForward.EquityForwardBuilder setForwardPrice(NonNegativeMoney forwardPrice);

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
			processRosetta(path.newSubPath("forwardPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getForwardPrice());
		}
		

		EquityForward.EquityForwardBuilder prune();
	}

	/*********************** Immutable Implementation of EquityForward  ***********************/
	class EquityForwardImpl extends EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseImpl implements EquityForward {
		private final NonNegativeMoney forwardPrice;
		
		protected EquityForwardImpl(EquityForward.EquityForwardBuilder builder) {
			super(builder);
			this.forwardPrice = ofNullable(builder.getForwardPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("forwardPrice")
		public NonNegativeMoney getForwardPrice() {
			return forwardPrice;
		}
		
		@Override
		public EquityForward build() {
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder toBuilder() {
			EquityForward.EquityForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityForward.EquityForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getForwardPrice()).ifPresent(builder::setForwardPrice);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityForward _that = getType().cast(o);
		
			if (!Objects.equals(forwardPrice, _that.getForwardPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (forwardPrice != null ? forwardPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityForward {" +
				"forwardPrice=" + this.forwardPrice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityForward  ***********************/
	class EquityForwardBuilderImpl extends EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl  implements EquityForward.EquityForwardBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder forwardPrice;
	
		public EquityForwardBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("forwardPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getForwardPrice() {
			return forwardPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateForwardPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (forwardPrice!=null) {
				result = forwardPrice;
			}
			else {
				result = forwardPrice = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public EquityForward.EquityForwardBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquityForward.EquityForwardBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public EquityForward.EquityForwardBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public EquityForward.EquityForwardBuilder setOptionType(EquityOptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public EquityForward.EquityForwardBuilder setEquityEffectiveDate(Date equityEffectiveDate) {
			this.equityEffectiveDate = equityEffectiveDate==null?null:equityEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public EquityForward.EquityForwardBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public EquityForward.EquityForwardBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public EquityForward.EquityForwardBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featureModel")
		public EquityForward.EquityForwardBuilder setFeatureModel(FeatureModel featureModel) {
			this.featureModel = featureModel==null?null:featureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public EquityForward.EquityForwardBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendConditions")
		public EquityForward.EquityForwardBuilder setDividendConditions(DividendConditions dividendConditions) {
			this.dividendConditions = dividendConditions==null?null:dividendConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public EquityForward.EquityForwardBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment) {
			this.methodOfAdjustment = methodOfAdjustment==null?null:methodOfAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public EquityForward.EquityForwardBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("forwardPrice")
		public EquityForward.EquityForwardBuilder setForwardPrice(NonNegativeMoney forwardPrice) {
			this.forwardPrice = forwardPrice==null?null:forwardPrice.toBuilder();
			return this;
		}
		
		@Override
		public EquityForward build() {
			return new EquityForward.EquityForwardImpl(this);
		}
		
		@Override
		public EquityForward.EquityForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityForward.EquityForwardBuilder prune() {
			super.prune();
			if (forwardPrice!=null && !forwardPrice.prune().hasData()) forwardPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getForwardPrice()!=null && getForwardPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityForward.EquityForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityForward.EquityForwardBuilder o = (EquityForward.EquityForwardBuilder) other;
			
			merger.mergeRosetta(getForwardPrice(), o.getForwardPrice(), this::setForwardPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityForward _that = getType().cast(o);
		
			if (!Objects.equals(forwardPrice, _that.getForwardPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (forwardPrice != null ? forwardPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityForwardBuilder {" +
				"forwardPrice=" + this.forwardPrice +
			'}' + " " + super.toString();
		}
	}
}
