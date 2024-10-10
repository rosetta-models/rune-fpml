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
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.OptionBase;
import fpml.confirmation.OptionBase.OptionBaseBuilder;
import fpml.confirmation.OptionBase.OptionBaseBuilderImpl;
import fpml.confirmation.OptionBase.OptionBaseImpl;
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
import fpml.confirmation.meta.OptionBaseExtendedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Base type for options starting with the 4-3 release, until we refactor the schema as part of the 5-0 release series.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionBaseExtended", builder=OptionBaseExtended.OptionBaseExtendedBuilderImpl.class, version="${project.version}")
public interface OptionBaseExtended extends OptionBase {

	OptionBaseExtendedMeta metaData = new OptionBaseExtendedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The option premium payable by the buyer to the seller.
	 */
	Premium getPremium();
	Exercise getExercise();
	/**
	 * A set of parameters defining procedures associated with the exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * An Option feature such as quanto, asian, barrier, knock.
	 */
	OptionFeature getFeature();
	NotionalAmountReference getNotionalReference();
	Money getNotionalAmount();
	OptionDenominationModel getOptionDenominationModel();
	OptionSettlementModel getOptionSettlementModel();

	/*********************** Build Methods  ***********************/
	OptionBaseExtended build();
	
	OptionBaseExtended.OptionBaseExtendedBuilder toBuilder();
	
	static OptionBaseExtended.OptionBaseExtendedBuilder builder() {
		return new OptionBaseExtended.OptionBaseExtendedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionBaseExtended> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionBaseExtended> getType() {
		return OptionBaseExtended.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionBaseExtendedBuilder extends OptionBaseExtended, OptionBase.OptionBaseBuilder {
		Premium.PremiumBuilder getOrCreatePremium();
		Premium.PremiumBuilder getPremium();
		Exercise.ExerciseBuilder getOrCreateExercise();
		Exercise.ExerciseBuilder getExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		OptionFeature.OptionFeatureBuilder getOrCreateFeature();
		OptionFeature.OptionFeatureBuilder getFeature();
		NotionalAmountReference.NotionalAmountReferenceBuilder getOrCreateNotionalReference();
		NotionalAmountReference.NotionalAmountReferenceBuilder getNotionalReference();
		Money.MoneyBuilder getOrCreateNotionalAmount();
		Money.MoneyBuilder getNotionalAmount();
		OptionDenominationModel.OptionDenominationModelBuilder getOrCreateOptionDenominationModel();
		OptionDenominationModel.OptionDenominationModelBuilder getOptionDenominationModel();
		OptionSettlementModel.OptionSettlementModelBuilder getOrCreateOptionSettlementModel();
		OptionSettlementModel.OptionSettlementModelBuilder getOptionSettlementModel();
		OptionBaseExtended.OptionBaseExtendedBuilder setProductModel(ProductModel productModel);
		OptionBaseExtended.OptionBaseExtendedBuilder setId(String id);
		OptionBaseExtended.OptionBaseExtendedBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		OptionBaseExtended.OptionBaseExtendedBuilder setOptionType(OptionTypeEnum optionType);
		OptionBaseExtended.OptionBaseExtendedBuilder setPremium(Premium premium);
		OptionBaseExtended.OptionBaseExtendedBuilder setExercise(Exercise exercise);
		OptionBaseExtended.OptionBaseExtendedBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		OptionBaseExtended.OptionBaseExtendedBuilder setFeature(OptionFeature feature);
		OptionBaseExtended.OptionBaseExtendedBuilder setNotionalReference(NotionalAmountReference notionalReference);
		OptionBaseExtended.OptionBaseExtendedBuilder setNotionalAmount(Money notionalAmount);
		OptionBaseExtended.OptionBaseExtendedBuilder setOptionDenominationModel(OptionDenominationModel optionDenominationModel);
		OptionBaseExtended.OptionBaseExtendedBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);

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
		}
		

		OptionBaseExtended.OptionBaseExtendedBuilder prune();
	}

	/*********************** Immutable Implementation of OptionBaseExtended  ***********************/
	class OptionBaseExtendedImpl extends OptionBase.OptionBaseImpl implements OptionBaseExtended {
		private final Premium premium;
		private final Exercise exercise;
		private final ExerciseProcedure exerciseProcedure;
		private final OptionFeature feature;
		private final NotionalAmountReference notionalReference;
		private final Money notionalAmount;
		private final OptionDenominationModel optionDenominationModel;
		private final OptionSettlementModel optionSettlementModel;
		
		protected OptionBaseExtendedImpl(OptionBaseExtended.OptionBaseExtendedBuilder builder) {
			super(builder);
			this.premium = ofNullable(builder.getPremium()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.feature = ofNullable(builder.getFeature()).map(f->f.build()).orElse(null);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.optionDenominationModel = ofNullable(builder.getOptionDenominationModel()).map(f->f.build()).orElse(null);
			this.optionSettlementModel = ofNullable(builder.getOptionSettlementModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("premium")
		public Premium getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Exercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("feature")
		public OptionFeature getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalAmountReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public Money getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("optionDenominationModel")
		public OptionDenominationModel getOptionDenominationModel() {
			return optionDenominationModel;
		}
		
		@Override
		@RosettaAttribute("optionSettlementModel")
		public OptionSettlementModel getOptionSettlementModel() {
			return optionSettlementModel;
		}
		
		@Override
		public OptionBaseExtended build() {
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder toBuilder() {
			OptionBaseExtended.OptionBaseExtendedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionBaseExtended.OptionBaseExtendedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getOptionDenominationModel()).ifPresent(builder::setOptionDenominationModel);
			ofNullable(getOptionSettlementModel()).ifPresent(builder::setOptionSettlementModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionBaseExtended _that = getType().cast(o);
		
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(optionDenominationModel, _that.getOptionDenominationModel())) return false;
			if (!Objects.equals(optionSettlementModel, _that.getOptionSettlementModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (optionDenominationModel != null ? optionDenominationModel.hashCode() : 0);
			_result = 31 * _result + (optionSettlementModel != null ? optionSettlementModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBaseExtended {" +
				"premium=" + this.premium + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"feature=" + this.feature + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"optionDenominationModel=" + this.optionDenominationModel + ", " +
				"optionSettlementModel=" + this.optionSettlementModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionBaseExtended  ***********************/
	class OptionBaseExtendedBuilderImpl extends OptionBase.OptionBaseBuilderImpl  implements OptionBaseExtended.OptionBaseExtendedBuilder {
	
		protected Premium.PremiumBuilder premium;
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected OptionFeature.OptionFeatureBuilder feature;
		protected NotionalAmountReference.NotionalAmountReferenceBuilder notionalReference;
		protected Money.MoneyBuilder notionalAmount;
		protected OptionDenominationModel.OptionDenominationModelBuilder optionDenominationModel;
		protected OptionSettlementModel.OptionSettlementModelBuilder optionSettlementModel;
	
		public OptionBaseExtendedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("premium")
		public Premium.PremiumBuilder getPremium() {
			return premium;
		}
		
		@Override
		public Premium.PremiumBuilder getOrCreatePremium() {
			Premium.PremiumBuilder result;
			if (premium!=null) {
				result = premium;
			}
			else {
				result = premium = Premium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Exercise.ExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public Exercise.ExerciseBuilder getOrCreateExercise() {
			Exercise.ExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = Exercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feature")
		public OptionFeature.OptionFeatureBuilder getFeature() {
			return feature;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder getOrCreateFeature() {
			OptionFeature.OptionFeatureBuilder result;
			if (feature!=null) {
				result = feature;
			}
			else {
				result = feature = OptionFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalAmountReference.NotionalAmountReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalAmountReference.NotionalAmountReferenceBuilder getOrCreateNotionalReference() {
			NotionalAmountReference.NotionalAmountReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public Money.MoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNotionalAmount() {
			Money.MoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionDenominationModel")
		public OptionDenominationModel.OptionDenominationModelBuilder getOptionDenominationModel() {
			return optionDenominationModel;
		}
		
		@Override
		public OptionDenominationModel.OptionDenominationModelBuilder getOrCreateOptionDenominationModel() {
			OptionDenominationModel.OptionDenominationModelBuilder result;
			if (optionDenominationModel!=null) {
				result = optionDenominationModel;
			}
			else {
				result = optionDenominationModel = OptionDenominationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionSettlementModel")
		public OptionSettlementModel.OptionSettlementModelBuilder getOptionSettlementModel() {
			return optionSettlementModel;
		}
		
		@Override
		public OptionSettlementModel.OptionSettlementModelBuilder getOrCreateOptionSettlementModel() {
			OptionSettlementModel.OptionSettlementModelBuilder result;
			if (optionSettlementModel!=null) {
				result = optionSettlementModel;
			}
			else {
				result = optionSettlementModel = OptionSettlementModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public OptionBaseExtended.OptionBaseExtendedBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public OptionBaseExtended.OptionBaseExtendedBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public OptionBaseExtended.OptionBaseExtendedBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public OptionBaseExtended.OptionBaseExtendedBuilder setOptionType(OptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public OptionBaseExtended.OptionBaseExtendedBuilder setPremium(Premium premium) {
			this.premium = premium==null?null:premium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public OptionBaseExtended.OptionBaseExtendedBuilder setExercise(Exercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public OptionBaseExtended.OptionBaseExtendedBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feature")
		public OptionBaseExtended.OptionBaseExtendedBuilder setFeature(OptionFeature feature) {
			this.feature = feature==null?null:feature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalReference")
		public OptionBaseExtended.OptionBaseExtendedBuilder setNotionalReference(NotionalAmountReference notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public OptionBaseExtended.OptionBaseExtendedBuilder setNotionalAmount(Money notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionDenominationModel")
		public OptionBaseExtended.OptionBaseExtendedBuilder setOptionDenominationModel(OptionDenominationModel optionDenominationModel) {
			this.optionDenominationModel = optionDenominationModel==null?null:optionDenominationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public OptionBaseExtended.OptionBaseExtendedBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		
		@Override
		public OptionBaseExtended build() {
			return new OptionBaseExtended.OptionBaseExtendedImpl(this);
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder prune() {
			super.prune();
			if (premium!=null && !premium.prune().hasData()) premium = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (feature!=null && !feature.prune().hasData()) feature = null;
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (optionDenominationModel!=null && !optionDenominationModel.prune().hasData()) optionDenominationModel = null;
			if (optionSettlementModel!=null && !optionSettlementModel.prune().hasData()) optionSettlementModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPremium()!=null && getPremium().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getFeature()!=null && getFeature().hasData()) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getOptionDenominationModel()!=null && getOptionDenominationModel().hasData()) return true;
			if (getOptionSettlementModel()!=null && getOptionSettlementModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionBaseExtended.OptionBaseExtendedBuilder o = (OptionBaseExtended.OptionBaseExtendedBuilder) other;
			
			merger.mergeRosetta(getPremium(), o.getPremium(), this::setPremium);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::setFeature);
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getOptionDenominationModel(), o.getOptionDenominationModel(), this::setOptionDenominationModel);
			merger.mergeRosetta(getOptionSettlementModel(), o.getOptionSettlementModel(), this::setOptionSettlementModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionBaseExtended _that = getType().cast(o);
		
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(optionDenominationModel, _that.getOptionDenominationModel())) return false;
			if (!Objects.equals(optionSettlementModel, _that.getOptionSettlementModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (optionDenominationModel != null ? optionDenominationModel.hashCode() : 0);
			_result = 31 * _result + (optionSettlementModel != null ? optionSettlementModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBaseExtendedBuilder {" +
				"premium=" + this.premium + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"feature=" + this.feature + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"optionDenominationModel=" + this.optionDenominationModel + ", " +
				"optionSettlementModel=" + this.optionSettlementModel +
			'}' + " " + super.toString();
		}
	}
}
