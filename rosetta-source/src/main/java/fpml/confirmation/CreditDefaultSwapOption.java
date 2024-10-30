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
import fpml.confirmation.CreditDefaultSwap;
import fpml.confirmation.CreditDefaultSwapOption;
import fpml.confirmation.CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder;
import fpml.confirmation.CreditDefaultSwapOption.CreditDefaultSwapOptionBuilderImpl;
import fpml.confirmation.CreditDefaultSwapOption.CreditDefaultSwapOptionImpl;
import fpml.confirmation.CreditOptionStrike;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.OptionBaseExtended;
import fpml.confirmation.OptionBaseExtended.OptionBaseExtendedBuilder;
import fpml.confirmation.OptionBaseExtended.OptionBaseExtendedBuilderImpl;
import fpml.confirmation.OptionBaseExtended.OptionBaseExtendedImpl;
import fpml.confirmation.OptionDenominationModel;
import fpml.confirmation.OptionFeature;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.Premium;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SwaptionPhysicalSettlement;
import fpml.confirmation.meta.CreditDefaultSwapOptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An option on a credit default swap. A complex type to support the credit default swap option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditDefaultSwapOption", builder=CreditDefaultSwapOption.CreditDefaultSwapOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditDefaultSwapOption extends OptionBaseExtended {

	CreditDefaultSwapOptionMeta metaData = new CreditDefaultSwapOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies any instructions on how the physical settlement is to be effected when the option is exercised.
	 */
	SwaptionPhysicalSettlement getClearingInstructions();
	/**
	 * Specifies the strike of the option on credit default swap.
	 */
	CreditOptionStrike getStrike();
	CreditDefaultSwap getCreditDefaultSwap();

	/*********************** Build Methods  ***********************/
	CreditDefaultSwapOption build();
	
	CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder toBuilder();
	
	static CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder() {
		return new CreditDefaultSwapOption.CreditDefaultSwapOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDefaultSwapOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditDefaultSwapOption> getType() {
		return CreditDefaultSwapOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("premium"), processor, Premium.class, getPremium());
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("feature"), processor, OptionFeature.class, getFeature());
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalAmountReference.class, getNotionalReference());
		processRosetta(path.newSubPath("notionalAmount"), processor, Money.class, getNotionalAmount());
		processRosetta(path.newSubPath("optionDenominationModel"), processor, OptionDenominationModel.class, getOptionDenominationModel());
		processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.class, getOptionSettlementModel());
		processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.class, getClearingInstructions());
		processRosetta(path.newSubPath("strike"), processor, CreditOptionStrike.class, getStrike());
		processRosetta(path.newSubPath("creditDefaultSwap"), processor, CreditDefaultSwap.class, getCreditDefaultSwap());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDefaultSwapOptionBuilder extends CreditDefaultSwapOption, OptionBaseExtended.OptionBaseExtendedBuilder {
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions();
		CreditOptionStrike.CreditOptionStrikeBuilder getOrCreateStrike();
		CreditOptionStrike.CreditOptionStrikeBuilder getStrike();
		CreditDefaultSwap.CreditDefaultSwapBuilder getOrCreateCreditDefaultSwap();
		CreditDefaultSwap.CreditDefaultSwapBuilder getCreditDefaultSwap();
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setProductModel(ProductModel productModel);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setId(String id);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionType(OptionTypeEnum optionType);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setPremium(Premium premium);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExercise(Exercise exercise);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setFeature(OptionFeature feature);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalReference(NotionalAmountReference notionalReference);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalAmount(Money notionalAmount);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionDenominationModel(OptionDenominationModel optionDenominationModel);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setStrike(CreditOptionStrike strike);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setCreditDefaultSwap(CreditDefaultSwap creditDefaultSwap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("premium"), processor, Premium.PremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("feature"), processor, OptionFeature.OptionFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalAmountReference.NotionalAmountReferenceBuilder.class, getNotionalReference());
			processRosetta(path.newSubPath("notionalAmount"), processor, Money.MoneyBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("optionDenominationModel"), processor, OptionDenominationModel.OptionDenominationModelBuilder.class, getOptionDenominationModel());
			processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.OptionSettlementModelBuilder.class, getOptionSettlementModel());
			processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder.class, getClearingInstructions());
			processRosetta(path.newSubPath("strike"), processor, CreditOptionStrike.CreditOptionStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("creditDefaultSwap"), processor, CreditDefaultSwap.CreditDefaultSwapBuilder.class, getCreditDefaultSwap());
		}
		

		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDefaultSwapOption  ***********************/
	class CreditDefaultSwapOptionImpl extends OptionBaseExtended.OptionBaseExtendedImpl implements CreditDefaultSwapOption {
		private final SwaptionPhysicalSettlement clearingInstructions;
		private final CreditOptionStrike strike;
		private final CreditDefaultSwap creditDefaultSwap;
		
		protected CreditDefaultSwapOptionImpl(CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder) {
			super(builder);
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.creditDefaultSwap = ofNullable(builder.getCreditDefaultSwap()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		@RosettaAttribute("strike")
		public CreditOptionStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwap")
		public CreditDefaultSwap getCreditDefaultSwap() {
			return creditDefaultSwap;
		}
		
		@Override
		public CreditDefaultSwapOption build() {
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder toBuilder() {
			CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCreditDefaultSwap()).ifPresent(builder::setCreditDefaultSwap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwapOption _that = getType().cast(o);
		
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(creditDefaultSwap, _that.getCreditDefaultSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwap != null ? creditDefaultSwap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapOption {" +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"strike=" + this.strike + ", " +
				"creditDefaultSwap=" + this.creditDefaultSwap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditDefaultSwapOption  ***********************/
	class CreditDefaultSwapOptionBuilderImpl extends OptionBaseExtended.OptionBaseExtendedBuilderImpl  implements CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder {
	
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder clearingInstructions;
		protected CreditOptionStrike.CreditOptionStrikeBuilder strike;
		protected CreditDefaultSwap.CreditDefaultSwapBuilder creditDefaultSwap;
	
		public CreditDefaultSwapOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = SwaptionPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public CreditOptionStrike.CreditOptionStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder getOrCreateStrike() {
			CreditOptionStrike.CreditOptionStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = CreditOptionStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwap")
		public CreditDefaultSwap.CreditDefaultSwapBuilder getCreditDefaultSwap() {
			return creditDefaultSwap;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder getOrCreateCreditDefaultSwap() {
			CreditDefaultSwap.CreditDefaultSwapBuilder result;
			if (creditDefaultSwap!=null) {
				result = creditDefaultSwap;
			}
			else {
				result = creditDefaultSwap = CreditDefaultSwap.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionType(OptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setPremium(Premium premium) {
			this.premium = premium==null?null:premium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExercise(Exercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feature")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setFeature(OptionFeature feature) {
			this.feature = feature==null?null:feature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalReference")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalReference(NotionalAmountReference notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalAmount(Money notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionDenominationModel")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionDenominationModel(OptionDenominationModel optionDenominationModel) {
			this.optionDenominationModel = optionDenominationModel==null?null:optionDenominationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearingInstructions")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions) {
			this.clearingInstructions = clearingInstructions==null?null:clearingInstructions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setStrike(CreditOptionStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditDefaultSwap")
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setCreditDefaultSwap(CreditDefaultSwap creditDefaultSwap) {
			this.creditDefaultSwap = creditDefaultSwap==null?null:creditDefaultSwap.toBuilder();
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption build() {
			return new CreditDefaultSwapOption.CreditDefaultSwapOptionImpl(this);
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder prune() {
			super.prune();
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (creditDefaultSwap!=null && !creditDefaultSwap.prune().hasData()) creditDefaultSwap = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getCreditDefaultSwap()!=null && getCreditDefaultSwap().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder o = (CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder) other;
			
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getCreditDefaultSwap(), o.getCreditDefaultSwap(), this::setCreditDefaultSwap);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwapOption _that = getType().cast(o);
		
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(creditDefaultSwap, _that.getCreditDefaultSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwap != null ? creditDefaultSwap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapOptionBuilder {" +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"strike=" + this.strike + ", " +
				"creditDefaultSwap=" + this.creditDefaultSwap +
			'}' + " " + super.toString();
		}
	}
}
