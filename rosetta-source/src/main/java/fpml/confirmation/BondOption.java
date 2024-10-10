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
import fpml.confirmation.BondChoiceModel;
import fpml.confirmation.BondOption;
import fpml.confirmation.BondOption.BondOptionBuilder;
import fpml.confirmation.BondOption.BondOptionBuilderImpl;
import fpml.confirmation.BondOption.BondOptionImpl;
import fpml.confirmation.BondOptionStrike;
import fpml.confirmation.BuyerSellerModel;
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
import fpml.confirmation.meta.BondOptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A component describing a Bond Option product. A Bond Option
 * @version ${project.version}
 */
@RosettaDataType(value="BondOption", builder=BondOption.BondOptionBuilderImpl.class, version="${project.version}")
public interface BondOption extends OptionBaseExtended {

	BondOptionMeta metaData = new BondOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Strike of the the Bond Option.
	 */
	BondOptionStrike getStrike();
	BondChoiceModel getBondChoiceModel();

	/*********************** Build Methods  ***********************/
	BondOption build();
	
	BondOption.BondOptionBuilder toBuilder();
	
	static BondOption.BondOptionBuilder builder() {
		return new BondOption.BondOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BondOption> getType() {
		return BondOption.class;
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
		processRosetta(path.newSubPath("strike"), processor, BondOptionStrike.class, getStrike());
		processRosetta(path.newSubPath("bondChoiceModel"), processor, BondChoiceModel.class, getBondChoiceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondOptionBuilder extends BondOption, OptionBaseExtended.OptionBaseExtendedBuilder {
		BondOptionStrike.BondOptionStrikeBuilder getOrCreateStrike();
		BondOptionStrike.BondOptionStrikeBuilder getStrike();
		BondChoiceModel.BondChoiceModelBuilder getOrCreateBondChoiceModel();
		BondChoiceModel.BondChoiceModelBuilder getBondChoiceModel();
		BondOption.BondOptionBuilder setProductModel(ProductModel productModel);
		BondOption.BondOptionBuilder setId(String id);
		BondOption.BondOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		BondOption.BondOptionBuilder setOptionType(OptionTypeEnum optionType);
		BondOption.BondOptionBuilder setPremium(Premium premium);
		BondOption.BondOptionBuilder setExercise(Exercise exercise);
		BondOption.BondOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		BondOption.BondOptionBuilder setFeature(OptionFeature feature);
		BondOption.BondOptionBuilder setNotionalReference(NotionalAmountReference notionalReference);
		BondOption.BondOptionBuilder setNotionalAmount(Money notionalAmount);
		BondOption.BondOptionBuilder setOptionDenominationModel(OptionDenominationModel optionDenominationModel);
		BondOption.BondOptionBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		BondOption.BondOptionBuilder setStrike(BondOptionStrike strike);
		BondOption.BondOptionBuilder setBondChoiceModel(BondChoiceModel bondChoiceModel);

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
			processRosetta(path.newSubPath("strike"), processor, BondOptionStrike.BondOptionStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("bondChoiceModel"), processor, BondChoiceModel.BondChoiceModelBuilder.class, getBondChoiceModel());
		}
		

		BondOption.BondOptionBuilder prune();
	}

	/*********************** Immutable Implementation of BondOption  ***********************/
	class BondOptionImpl extends OptionBaseExtended.OptionBaseExtendedImpl implements BondOption {
		private final BondOptionStrike strike;
		private final BondChoiceModel bondChoiceModel;
		
		protected BondOptionImpl(BondOption.BondOptionBuilder builder) {
			super(builder);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.bondChoiceModel = ofNullable(builder.getBondChoiceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		public BondOptionStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("bondChoiceModel")
		public BondChoiceModel getBondChoiceModel() {
			return bondChoiceModel;
		}
		
		@Override
		public BondOption build() {
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder toBuilder() {
			BondOption.BondOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondOption.BondOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getBondChoiceModel()).ifPresent(builder::setBondChoiceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BondOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(bondChoiceModel, _that.getBondChoiceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (bondChoiceModel != null ? bondChoiceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondOption {" +
				"strike=" + this.strike + ", " +
				"bondChoiceModel=" + this.bondChoiceModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BondOption  ***********************/
	class BondOptionBuilderImpl extends OptionBaseExtended.OptionBaseExtendedBuilderImpl  implements BondOption.BondOptionBuilder {
	
		protected BondOptionStrike.BondOptionStrikeBuilder strike;
		protected BondChoiceModel.BondChoiceModelBuilder bondChoiceModel;
	
		public BondOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strike")
		public BondOptionStrike.BondOptionStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder getOrCreateStrike() {
			BondOptionStrike.BondOptionStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = BondOptionStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bondChoiceModel")
		public BondChoiceModel.BondChoiceModelBuilder getBondChoiceModel() {
			return bondChoiceModel;
		}
		
		@Override
		public BondChoiceModel.BondChoiceModelBuilder getOrCreateBondChoiceModel() {
			BondChoiceModel.BondChoiceModelBuilder result;
			if (bondChoiceModel!=null) {
				result = bondChoiceModel;
			}
			else {
				result = bondChoiceModel = BondChoiceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public BondOption.BondOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BondOption.BondOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BondOption.BondOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public BondOption.BondOptionBuilder setOptionType(OptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public BondOption.BondOptionBuilder setPremium(Premium premium) {
			this.premium = premium==null?null:premium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public BondOption.BondOptionBuilder setExercise(Exercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public BondOption.BondOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feature")
		public BondOption.BondOptionBuilder setFeature(OptionFeature feature) {
			this.feature = feature==null?null:feature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalReference")
		public BondOption.BondOptionBuilder setNotionalReference(NotionalAmountReference notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public BondOption.BondOptionBuilder setNotionalAmount(Money notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionDenominationModel")
		public BondOption.BondOptionBuilder setOptionDenominationModel(OptionDenominationModel optionDenominationModel) {
			this.optionDenominationModel = optionDenominationModel==null?null:optionDenominationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public BondOption.BondOptionBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public BondOption.BondOptionBuilder setStrike(BondOptionStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("bondChoiceModel")
		public BondOption.BondOptionBuilder setBondChoiceModel(BondChoiceModel bondChoiceModel) {
			this.bondChoiceModel = bondChoiceModel==null?null:bondChoiceModel.toBuilder();
			return this;
		}
		
		@Override
		public BondOption build() {
			return new BondOption.BondOptionImpl(this);
		}
		
		@Override
		public BondOption.BondOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondOption.BondOptionBuilder prune() {
			super.prune();
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (bondChoiceModel!=null && !bondChoiceModel.prune().hasData()) bondChoiceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getBondChoiceModel()!=null && getBondChoiceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondOption.BondOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BondOption.BondOptionBuilder o = (BondOption.BondOptionBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getBondChoiceModel(), o.getBondChoiceModel(), this::setBondChoiceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BondOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(bondChoiceModel, _that.getBondChoiceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (bondChoiceModel != null ? bondChoiceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondOptionBuilder {" +
				"strike=" + this.strike + ", " +
				"bondChoiceModel=" + this.bondChoiceModel +
			'}' + " " + super.toString();
		}
	}
}
