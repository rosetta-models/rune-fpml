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
import fpml.confirmation.EquityDerivativeBase;
import fpml.confirmation.EquityDerivativeBase.EquityDerivativeBaseBuilder;
import fpml.confirmation.EquityDerivativeBase.EquityDerivativeBaseBuilderImpl;
import fpml.confirmation.EquityDerivativeBase.EquityDerivativeBaseImpl;
import fpml.confirmation.EquityDerivativeLongFormBase;
import fpml.confirmation.EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder;
import fpml.confirmation.EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl;
import fpml.confirmation.EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseImpl;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.EquityDerivativeLongFormBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * type for defining the common features of equity derivatives.
 * @version ${project.version}
 */
@RosettaDataType(value="EquityDerivativeLongFormBase", builder=EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl.class, version="${project.version}")
public interface EquityDerivativeLongFormBase extends EquityDerivativeBase {

	EquityDerivativeLongFormBaseMeta metaData = new EquityDerivativeLongFormBaseMeta();

	/*********************** Getter Methods  ***********************/
	DividendConditions getDividendConditions();
	/**
	 * Defines how adjustments will be made to the contract should one or more of the extraordinary events occur.
	 */
	MethodOfAdjustmentEnum getMethodOfAdjustment();
	/**
	 * Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	EquityDerivativeLongFormBase build();
	
	EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder toBuilder();
	
	static EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder() {
		return new EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityDerivativeLongFormBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityDerivativeLongFormBase> getType() {
		return EquityDerivativeLongFormBase.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityDerivativeLongFormBaseBuilder extends EquityDerivativeLongFormBase, EquityDerivativeBase.EquityDerivativeBaseBuilder {
		DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions();
		DividendConditions.DividendConditionsBuilder getDividendConditions();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setProductModel(ProductModel productModel);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setId(String id);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setOptionType(EquityOptionTypeEnum optionType);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityEffectiveDate(Date equityEffectiveDate);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setUnderlyer(Underlyer underlyer);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setNotional(NonNegativeMoney notional);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setFeatureModel(FeatureModel featureModel);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setStrategyFeature(StrategyFeature strategyFeature);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setDividendConditions(DividendConditions dividendConditions);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

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
		}
		

		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityDerivativeLongFormBase  ***********************/
	class EquityDerivativeLongFormBaseImpl extends EquityDerivativeBase.EquityDerivativeBaseImpl implements EquityDerivativeLongFormBase {
		private final DividendConditions dividendConditions;
		private final MethodOfAdjustmentEnum methodOfAdjustment;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected EquityDerivativeLongFormBaseImpl(EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder) {
			super(builder);
			this.dividendConditions = ofNullable(builder.getDividendConditions()).map(f->f.build()).orElse(null);
			this.methodOfAdjustment = builder.getMethodOfAdjustment();
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendConditions")
		public DividendConditions getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public EquityDerivativeLongFormBase build() {
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder toBuilder() {
			EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDividendConditions()).ifPresent(builder::setDividendConditions);
			ofNullable(getMethodOfAdjustment()).ifPresent(builder::setMethodOfAdjustment);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeLongFormBase _that = getType().cast(o);
		
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeLongFormBase {" +
				"dividendConditions=" + this.dividendConditions + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityDerivativeLongFormBase  ***********************/
	class EquityDerivativeLongFormBaseBuilderImpl extends EquityDerivativeBase.EquityDerivativeBaseBuilderImpl  implements EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder {
	
		protected DividendConditions.DividendConditionsBuilder dividendConditions;
		protected MethodOfAdjustmentEnum methodOfAdjustment;
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
	
		public EquityDerivativeLongFormBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendConditions")
		public DividendConditions.DividendConditionsBuilder getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions() {
			DividendConditions.DividendConditionsBuilder result;
			if (dividendConditions!=null) {
				result = dividendConditions;
			}
			else {
				result = dividendConditions = DividendConditions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setOptionType(EquityOptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityEffectiveDate")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityEffectiveDate(Date equityEffectiveDate) {
			this.equityEffectiveDate = equityEffectiveDate==null?null:equityEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featureModel")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setFeatureModel(FeatureModel featureModel) {
			this.featureModel = featureModel==null?null:featureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendConditions")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setDividendConditions(DividendConditions dividendConditions) {
			this.dividendConditions = dividendConditions==null?null:dividendConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment) {
			this.methodOfAdjustment = methodOfAdjustment==null?null:methodOfAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase build() {
			return new EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseImpl(this);
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder prune() {
			super.prune();
			if (dividendConditions!=null && !dividendConditions.prune().hasData()) dividendConditions = null;
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDividendConditions()!=null && getDividendConditions().hasData()) return true;
			if (getMethodOfAdjustment()!=null) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder o = (EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder) other;
			
			merger.mergeRosetta(getDividendConditions(), o.getDividendConditions(), this::setDividendConditions);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			merger.mergeBasic(getMethodOfAdjustment(), o.getMethodOfAdjustment(), this::setMethodOfAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeLongFormBase _that = getType().cast(o);
		
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeLongFormBaseBuilder {" +
				"dividendConditions=" + this.dividendConditions + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
