package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxAccrualDigitalOption;
import fpml.confirmation.FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder;
import fpml.confirmation.FxAccrualDigitalOption.FxAccrualDigitalOptionBuilderImpl;
import fpml.confirmation.FxAccrualDigitalOption.FxAccrualDigitalOptionImpl;
import fpml.confirmation.FxAccrualTrigger;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.Option;
import fpml.confirmation.Option.OptionBuilder;
import fpml.confirmation.Option.OptionBuilderImpl;
import fpml.confirmation.Option.OptionImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.FxAccrualDigitalOptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structured option product which consists of a single digital option or a strip of digital options. At each settlement the settled amounts are a fraction of the notional amount for that settlement period calculated as the number of fixings which fall within accrual regions divided by the total number of fixings in the settlement period. An FX Accrual Digital Option product The product defines a list of fixing (or observation) dates. There are m total fixings. At the expiry date of the product, the buyer of the option has the right to an FX settlement with n/m * Notional. Payout can be cash or physical.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualDigitalOption", builder=FxAccrualDigitalOption.FxAccrualDigitalOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualDigitalOption extends Option {

	FxAccrualDigitalOptionMeta metaData = new FxAccrualDigitalOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Notional amount Schedule. The notional value of the product. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 * Describes accrual features within the product.
	 */
	FxAccrual getAccrual();
	FxExpiryDateOrScheduleModel getFxExpiryDateOrScheduleModel();
	FxSettlementDateOrScheduleModel getFxSettlementDateOrScheduleModel();
	/**
	 * A set of parameters defining procedures associated with the exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * Defines one or more conditions under which the option will payout if exercisable.
	 */
	FxAccrualTrigger getTrigger();
	/**
	 * Defines a knockout barrier conditions where if a barrier event occurs, the accrual process is terminated for the duration of all remaining accrual periods. Settlement rights for the next settlement are either retained or extinguished.
	 */
	List<? extends FxAccrualBarrier> getBarrier();
	/**
	 * Premium amount or premium installment amount for an option.
	 */
	List<? extends FxOptionPremium> getPremium();

	/*********************** Build Methods  ***********************/
	FxAccrualDigitalOption build();
	
	FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder toBuilder();
	
	static FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder() {
		return new FxAccrualDigitalOption.FxAccrualDigitalOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualDigitalOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualDigitalOption> getType() {
		return FxAccrualDigitalOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.class, getFxExpiryDateOrScheduleModel());
		processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.class, getFxSettlementDateOrScheduleModel());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("trigger"), processor, FxAccrualTrigger.class, getTrigger());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualDigitalOptionBuilder extends FxAccrualDigitalOption, Option.OptionBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxAccrual.FxAccrualBuilder getOrCreateAccrual();
		FxAccrual.FxAccrualBuilder getAccrual();
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getOrCreateFxExpiryDateOrScheduleModel();
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getFxExpiryDateOrScheduleModel();
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getOrCreateFxSettlementDateOrScheduleModel();
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getFxSettlementDateOrScheduleModel();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		FxAccrualTrigger.FxAccrualTriggerBuilder getOrCreateTrigger();
		FxAccrualTrigger.FxAccrualTriggerBuilder getTrigger();
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int _index);
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int _index);
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setProductModel(ProductModel productModel);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setId(String id);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setAccrual(FxAccrual accrual);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setTrigger(FxAccrualTrigger trigger);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier barrier0);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier barrier1, int _idx);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barrier2);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barrier3);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium premium0);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium premium1, int _idx);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premium2);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premium3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder.class, getFxExpiryDateOrScheduleModel());
			processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder.class, getFxSettlementDateOrScheduleModel());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("trigger"), processor, FxAccrualTrigger.FxAccrualTriggerBuilder.class, getTrigger());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualDigitalOption  ***********************/
	class FxAccrualDigitalOptionImpl extends Option.OptionImpl implements FxAccrualDigitalOption {
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel;
		private final FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel;
		private final ExerciseProcedure exerciseProcedure;
		private final FxAccrualTrigger trigger;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxAccrualDigitalOptionImpl(FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder) {
			super(builder);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.fxExpiryDateOrScheduleModel = ofNullable(builder.getFxExpiryDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.fxSettlementDateOrScheduleModel = ofNullable(builder.getFxSettlementDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.trigger = ofNullable(builder.getTrigger()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("accrual")
		public FxAccrual getAccrual() {
			return accrual;
		}
		
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxExpiryDateOrScheduleModel getFxExpiryDateOrScheduleModel() {
			return fxExpiryDateOrScheduleModel;
		}
		
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxSettlementDateOrScheduleModel getFxSettlementDateOrScheduleModel() {
			return fxSettlementDateOrScheduleModel;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("trigger")
		public FxAccrualTrigger getTrigger() {
			return trigger;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxAccrualBarrier> getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxOptionPremium> getPremium() {
			return premium;
		}
		
		@Override
		public FxAccrualDigitalOption build() {
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder toBuilder() {
			FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getFxExpiryDateOrScheduleModel()).ifPresent(builder::setFxExpiryDateOrScheduleModel);
			ofNullable(getFxSettlementDateOrScheduleModel()).ifPresent(builder::setFxSettlementDateOrScheduleModel);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualDigitalOption {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"trigger=" + this.trigger + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualDigitalOption  ***********************/
	class FxAccrualDigitalOptionBuilderImpl extends Option.OptionBuilderImpl  implements FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder fxExpiryDateOrScheduleModel;
		protected FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder fxSettlementDateOrScheduleModel;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected FxAccrualTrigger.FxAccrualTriggerBuilder trigger;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
	
		public FxAccrualDigitalOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrual")
		public FxAccrual.FxAccrualBuilder getAccrual() {
			return accrual;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder getOrCreateAccrual() {
			FxAccrual.FxAccrualBuilder result;
			if (accrual!=null) {
				result = accrual;
			}
			else {
				result = accrual = FxAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getFxExpiryDateOrScheduleModel() {
			return fxExpiryDateOrScheduleModel;
		}
		
		@Override
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getOrCreateFxExpiryDateOrScheduleModel() {
			FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder result;
			if (fxExpiryDateOrScheduleModel!=null) {
				result = fxExpiryDateOrScheduleModel;
			}
			else {
				result = fxExpiryDateOrScheduleModel = FxExpiryDateOrScheduleModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getFxSettlementDateOrScheduleModel() {
			return fxSettlementDateOrScheduleModel;
		}
		
		@Override
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getOrCreateFxSettlementDateOrScheduleModel() {
			FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder result;
			if (fxSettlementDateOrScheduleModel!=null) {
				result = fxSettlementDateOrScheduleModel;
			}
			else {
				result = fxSettlementDateOrScheduleModel = FxSettlementDateOrScheduleModel.builder();
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
		@RosettaAttribute("trigger")
		public FxAccrualTrigger.FxAccrualTriggerBuilder getTrigger() {
			return trigger;
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder getOrCreateTrigger() {
			FxAccrualTrigger.FxAccrualTriggerBuilder result;
			if (trigger!=null) {
				result = trigger;
			}
			else {
				result = trigger = FxAccrualTrigger.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int _index) {
		
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			FxAccrualBarrier.FxAccrualBarrierBuilder result;
			return getIndex(barrier, _index, () -> {
						FxAccrualBarrier.FxAccrualBarrierBuilder newBarrier = FxAccrualBarrier.builder();
						return newBarrier;
					});
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			FxOptionPremium.FxOptionPremiumBuilder result;
			return getIndex(premium, _index, () -> {
						FxOptionPremium.FxOptionPremiumBuilder newPremium = FxOptionPremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrual")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setAccrual(FxAccrual accrual) {
			this.accrual = accrual==null?null:accrual.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
			this.fxExpiryDateOrScheduleModel = fxExpiryDateOrScheduleModel==null?null:fxExpiryDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel) {
			this.fxSettlementDateOrScheduleModel = fxSettlementDateOrScheduleModel==null?null:fxSettlementDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trigger")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setTrigger(FxAccrualTrigger trigger) {
			this.trigger = trigger==null?null:trigger.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers != null) {
				for (FxAccrualBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers == null)  {
				this.barrier = new ArrayList<>();
			}
			else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("premium")
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums != null) {
				for (FxOptionPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums == null)  {
				this.premium = new ArrayList<>();
			}
			else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxAccrualDigitalOption build() {
			return new FxAccrualDigitalOption.FxAccrualDigitalOptionImpl(this);
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder prune() {
			super.prune();
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (fxExpiryDateOrScheduleModel!=null && !fxExpiryDateOrScheduleModel.prune().hasData()) fxExpiryDateOrScheduleModel = null;
			if (fxSettlementDateOrScheduleModel!=null && !fxSettlementDateOrScheduleModel.prune().hasData()) fxSettlementDateOrScheduleModel = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (trigger!=null && !trigger.prune().hasData()) trigger = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			if (getFxExpiryDateOrScheduleModel()!=null && getFxExpiryDateOrScheduleModel().hasData()) return true;
			if (getFxSettlementDateOrScheduleModel()!=null && getFxSettlementDateOrScheduleModel().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getTrigger()!=null && getTrigger().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder o = (FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getFxExpiryDateOrScheduleModel(), o.getFxExpiryDateOrScheduleModel(), this::setFxExpiryDateOrScheduleModel);
			merger.mergeRosetta(getFxSettlementDateOrScheduleModel(), o.getFxSettlementDateOrScheduleModel(), this::setFxSettlementDateOrScheduleModel);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::setTrigger);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualDigitalOptionBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"trigger=" + this.trigger + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}
