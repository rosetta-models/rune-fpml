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
import fpml.confirmation.FxAccrualOption;
import fpml.confirmation.FxAccrualOption.FxAccrualOptionBuilder;
import fpml.confirmation.FxAccrualOption.FxAccrualOptionBuilderImpl;
import fpml.confirmation.FxAccrualOption.FxAccrualOptionImpl;
import fpml.confirmation.FxAccrualOptionSequence;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.Option;
import fpml.confirmation.Option.OptionBuilder;
import fpml.confirmation.Option.OptionBuilderImpl;
import fpml.confirmation.Option.OptionImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallCurrencyModel;
import fpml.confirmation.meta.FxAccrualOptionMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A financial contract between two parties (the buyer and the seller) that provides the buyer the right to buy a currency (or receive a payment) at expiry. The distinctive characteristic of this contract is that the Notional to be transacted at expiry is uncertain and depends on the amount of time that the underlying currency trades within a pre-set level, or levels (the &#39;accrual barrier&#39;, or &#39;barriers&#39;). The total Notional is only known at the end of the accrual period, and this extra uncertainty can make an accrual option substantially cheaper than the comparable vanilla one. An FX Accrual Option product The product defines a list of fixing (or observation) dates. There are m total fixings. At the expiry date of the product, the buyer of the option has the right to an FX settlement with n/m * Notional. Payout can be cash or physical.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualOption", builder=FxAccrualOption.FxAccrualOptionBuilderImpl.class, version="${project.version}")
public interface FxAccrualOption extends Option {

	FxAccrualOptionMeta metaData = new FxAccrualOptionMeta();

	/*********************** Getter Methods  ***********************/
	PutCallCurrencyModel getPutCallCurrencyModel();
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
	 * An optional element used for FX forwards and certain types of FX OTC options. For deals consummated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move &quot;up&quot; or &quot;down&quot; to be triggered.
	 */
	BigDecimal getSpotRate();
	FxAccrualOptionSequence getFxAccrualOptionSequence();
	/**
	 * Average Strike: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 */
	FxAverageStrike getAverageStrike();
	/**
	 * Average Rate: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 */
	FxAverageRate getAverageRate();
	/**
	 * Defines a knockout barrier conditions where if a barrier event occurs, the accrual process is terminated for the duration of all remaining accrual periods. Settlement rights for the next settlement are either retained or extinguished.
	 */
	List<? extends FxAccrualBarrier> getBarrier();
	/**
	 * Premium amount or premium installment amount for an option.
	 */
	List<? extends FxOptionPremium> getPremium();

	/*********************** Build Methods  ***********************/
	FxAccrualOption build();
	
	FxAccrualOption.FxAccrualOptionBuilder toBuilder();
	
	static FxAccrualOption.FxAccrualOptionBuilder builder() {
		return new FxAccrualOption.FxAccrualOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualOption> getType() {
		return FxAccrualOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("putCallCurrencyModel"), processor, PutCallCurrencyModel.class, getPutCallCurrencyModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.class, getFxExpiryDateOrScheduleModel());
		processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.class, getFxSettlementDateOrScheduleModel());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("fxAccrualOptionSequence"), processor, FxAccrualOptionSequence.class, getFxAccrualOptionSequence());
		processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.class, getAverageStrike());
		processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.class, getAverageRate());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualOptionBuilder extends FxAccrualOption, Option.OptionBuilder {
		PutCallCurrencyModel.PutCallCurrencyModelBuilder getOrCreatePutCallCurrencyModel();
		PutCallCurrencyModel.PutCallCurrencyModelBuilder getPutCallCurrencyModel();
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
		FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder getOrCreateFxAccrualOptionSequence();
		FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder getFxAccrualOptionSequence();
		FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike();
		FxAverageStrike.FxAverageStrikeBuilder getAverageStrike();
		FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate();
		FxAverageRate.FxAverageRateBuilder getAverageRate();
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int _index);
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int _index);
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		FxAccrualOption.FxAccrualOptionBuilder setProductModel(ProductModel productModel);
		FxAccrualOption.FxAccrualOptionBuilder setId(String id);
		FxAccrualOption.FxAccrualOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		FxAccrualOption.FxAccrualOptionBuilder setPutCallCurrencyModel(PutCallCurrencyModel putCallCurrencyModel);
		FxAccrualOption.FxAccrualOptionBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualOption.FxAccrualOptionBuilder setAccrual(FxAccrual accrual);
		FxAccrualOption.FxAccrualOptionBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel);
		FxAccrualOption.FxAccrualOptionBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel);
		FxAccrualOption.FxAccrualOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxAccrualOption.FxAccrualOptionBuilder setSpotRate(BigDecimal spotRate);
		FxAccrualOption.FxAccrualOptionBuilder setFxAccrualOptionSequence(FxAccrualOptionSequence fxAccrualOptionSequence);
		FxAccrualOption.FxAccrualOptionBuilder setAverageStrike(FxAverageStrike averageStrike);
		FxAccrualOption.FxAccrualOptionBuilder setAverageRate(FxAverageRate averageRate);
		FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier barrier0);
		FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier barrier1, int _idx);
		FxAccrualOption.FxAccrualOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barrier2);
		FxAccrualOption.FxAccrualOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barrier3);
		FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium premium0);
		FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium premium1, int _idx);
		FxAccrualOption.FxAccrualOptionBuilder addPremium(List<? extends FxOptionPremium> premium2);
		FxAccrualOption.FxAccrualOptionBuilder setPremium(List<? extends FxOptionPremium> premium3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("putCallCurrencyModel"), processor, PutCallCurrencyModel.PutCallCurrencyModelBuilder.class, getPutCallCurrencyModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder.class, getFxExpiryDateOrScheduleModel());
			processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder.class, getFxSettlementDateOrScheduleModel());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("fxAccrualOptionSequence"), processor, FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder.class, getFxAccrualOptionSequence());
			processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.FxAverageStrikeBuilder.class, getAverageStrike());
			processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.FxAverageRateBuilder.class, getAverageRate());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxAccrualOption.FxAccrualOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualOption  ***********************/
	class FxAccrualOptionImpl extends Option.OptionImpl implements FxAccrualOption {
		private final PutCallCurrencyModel putCallCurrencyModel;
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel;
		private final FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel;
		private final ExerciseProcedure exerciseProcedure;
		private final BigDecimal spotRate;
		private final FxAccrualOptionSequence fxAccrualOptionSequence;
		private final FxAverageStrike averageStrike;
		private final FxAverageRate averageRate;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxAccrualOptionImpl(FxAccrualOption.FxAccrualOptionBuilder builder) {
			super(builder);
			this.putCallCurrencyModel = ofNullable(builder.getPutCallCurrencyModel()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.fxExpiryDateOrScheduleModel = ofNullable(builder.getFxExpiryDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.fxSettlementDateOrScheduleModel = ofNullable(builder.getFxSettlementDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.fxAccrualOptionSequence = ofNullable(builder.getFxAccrualOptionSequence()).map(f->f.build()).orElse(null);
			this.averageStrike = ofNullable(builder.getAverageStrike()).map(f->f.build()).orElse(null);
			this.averageRate = ofNullable(builder.getAverageRate()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("putCallCurrencyModel")
		public PutCallCurrencyModel getPutCallCurrencyModel() {
			return putCallCurrencyModel;
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
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("fxAccrualOptionSequence")
		public FxAccrualOptionSequence getFxAccrualOptionSequence() {
			return fxAccrualOptionSequence;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		public FxAverageStrike getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		@RosettaAttribute("averageRate")
		public FxAverageRate getAverageRate() {
			return averageRate;
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
		public FxAccrualOption build() {
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder toBuilder() {
			FxAccrualOption.FxAccrualOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualOption.FxAccrualOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPutCallCurrencyModel()).ifPresent(builder::setPutCallCurrencyModel);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getFxExpiryDateOrScheduleModel()).ifPresent(builder::setFxExpiryDateOrScheduleModel);
			ofNullable(getFxSettlementDateOrScheduleModel()).ifPresent(builder::setFxSettlementDateOrScheduleModel);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getFxAccrualOptionSequence()).ifPresent(builder::setFxAccrualOptionSequence);
			ofNullable(getAverageStrike()).ifPresent(builder::setAverageStrike);
			ofNullable(getAverageRate()).ifPresent(builder::setAverageRate);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualOption _that = getType().cast(o);
		
			if (!Objects.equals(putCallCurrencyModel, _that.getPutCallCurrencyModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxAccrualOptionSequence, _that.getFxAccrualOptionSequence())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (putCallCurrencyModel != null ? putCallCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxAccrualOptionSequence != null ? fxAccrualOptionSequence.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualOption {" +
				"putCallCurrencyModel=" + this.putCallCurrencyModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxAccrualOptionSequence=" + this.fxAccrualOptionSequence + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualOption  ***********************/
	class FxAccrualOptionBuilderImpl extends Option.OptionBuilderImpl  implements FxAccrualOption.FxAccrualOptionBuilder {
	
		protected PutCallCurrencyModel.PutCallCurrencyModelBuilder putCallCurrencyModel;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder fxExpiryDateOrScheduleModel;
		protected FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder fxSettlementDateOrScheduleModel;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected BigDecimal spotRate;
		protected FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder fxAccrualOptionSequence;
		protected FxAverageStrike.FxAverageStrikeBuilder averageStrike;
		protected FxAverageRate.FxAverageRateBuilder averageRate;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
	
		public FxAccrualOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("putCallCurrencyModel")
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder getPutCallCurrencyModel() {
			return putCallCurrencyModel;
		}
		
		@Override
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder getOrCreatePutCallCurrencyModel() {
			PutCallCurrencyModel.PutCallCurrencyModelBuilder result;
			if (putCallCurrencyModel!=null) {
				result = putCallCurrencyModel;
			}
			else {
				result = putCallCurrencyModel = PutCallCurrencyModel.builder();
			}
			
			return result;
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
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("fxAccrualOptionSequence")
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder getFxAccrualOptionSequence() {
			return fxAccrualOptionSequence;
		}
		
		@Override
		public FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder getOrCreateFxAccrualOptionSequence() {
			FxAccrualOptionSequence.FxAccrualOptionSequenceBuilder result;
			if (fxAccrualOptionSequence!=null) {
				result = fxAccrualOptionSequence;
			}
			else {
				result = fxAccrualOptionSequence = FxAccrualOptionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		public FxAverageStrike.FxAverageStrikeBuilder getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike() {
			FxAverageStrike.FxAverageStrikeBuilder result;
			if (averageStrike!=null) {
				result = averageStrike;
			}
			else {
				result = averageStrike = FxAverageStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageRate")
		public FxAverageRate.FxAverageRateBuilder getAverageRate() {
			return averageRate;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate() {
			FxAverageRate.FxAverageRateBuilder result;
			if (averageRate!=null) {
				result = averageRate;
			}
			else {
				result = averageRate = FxAverageRate.builder();
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
		public FxAccrualOption.FxAccrualOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxAccrualOption.FxAccrualOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public FxAccrualOption.FxAccrualOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("putCallCurrencyModel")
		public FxAccrualOption.FxAccrualOptionBuilder setPutCallCurrencyModel(PutCallCurrencyModel putCallCurrencyModel) {
			this.putCallCurrencyModel = putCallCurrencyModel==null?null:putCallCurrencyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxAccrualOption.FxAccrualOptionBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrual")
		public FxAccrualOption.FxAccrualOptionBuilder setAccrual(FxAccrual accrual) {
			this.accrual = accrual==null?null:accrual.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxAccrualOption.FxAccrualOptionBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
			this.fxExpiryDateOrScheduleModel = fxExpiryDateOrScheduleModel==null?null:fxExpiryDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxAccrualOption.FxAccrualOptionBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel) {
			this.fxSettlementDateOrScheduleModel = fxSettlementDateOrScheduleModel==null?null:fxSettlementDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public FxAccrualOption.FxAccrualOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxAccrualOption.FxAccrualOptionBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualOptionSequence")
		public FxAccrualOption.FxAccrualOptionBuilder setFxAccrualOptionSequence(FxAccrualOptionSequence fxAccrualOptionSequence) {
			this.fxAccrualOptionSequence = fxAccrualOptionSequence==null?null:fxAccrualOptionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averageStrike")
		public FxAccrualOption.FxAccrualOptionBuilder setAverageStrike(FxAverageStrike averageStrike) {
			this.averageStrike = averageStrike==null?null:averageStrike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averageRate")
		public FxAccrualOption.FxAccrualOptionBuilder setAverageRate(FxAverageRate averageRate) {
			this.averageRate = averageRate==null?null:averageRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualOption.FxAccrualOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers != null) {
				for (FxAccrualBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualOption.FxAccrualOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
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
		public FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualOption.FxAccrualOptionBuilder addPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums != null) {
				for (FxOptionPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualOption.FxAccrualOptionBuilder setPremium(List<? extends FxOptionPremium> premiums) {
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
		public FxAccrualOption build() {
			return new FxAccrualOption.FxAccrualOptionImpl(this);
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder prune() {
			super.prune();
			if (putCallCurrencyModel!=null && !putCallCurrencyModel.prune().hasData()) putCallCurrencyModel = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (fxExpiryDateOrScheduleModel!=null && !fxExpiryDateOrScheduleModel.prune().hasData()) fxExpiryDateOrScheduleModel = null;
			if (fxSettlementDateOrScheduleModel!=null && !fxSettlementDateOrScheduleModel.prune().hasData()) fxSettlementDateOrScheduleModel = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (fxAccrualOptionSequence!=null && !fxAccrualOptionSequence.prune().hasData()) fxAccrualOptionSequence = null;
			if (averageStrike!=null && !averageStrike.prune().hasData()) averageStrike = null;
			if (averageRate!=null && !averageRate.prune().hasData()) averageRate = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPutCallCurrencyModel()!=null && getPutCallCurrencyModel().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			if (getFxExpiryDateOrScheduleModel()!=null && getFxExpiryDateOrScheduleModel().hasData()) return true;
			if (getFxSettlementDateOrScheduleModel()!=null && getFxSettlementDateOrScheduleModel().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getFxAccrualOptionSequence()!=null && getFxAccrualOptionSequence().hasData()) return true;
			if (getAverageStrike()!=null && getAverageStrike().hasData()) return true;
			if (getAverageRate()!=null && getAverageRate().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualOption.FxAccrualOptionBuilder o = (FxAccrualOption.FxAccrualOptionBuilder) other;
			
			merger.mergeRosetta(getPutCallCurrencyModel(), o.getPutCallCurrencyModel(), this::setPutCallCurrencyModel);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getFxExpiryDateOrScheduleModel(), o.getFxExpiryDateOrScheduleModel(), this::setFxExpiryDateOrScheduleModel);
			merger.mergeRosetta(getFxSettlementDateOrScheduleModel(), o.getFxSettlementDateOrScheduleModel(), this::setFxSettlementDateOrScheduleModel);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getFxAccrualOptionSequence(), o.getFxAccrualOptionSequence(), this::setFxAccrualOptionSequence);
			merger.mergeRosetta(getAverageStrike(), o.getAverageStrike(), this::setAverageStrike);
			merger.mergeRosetta(getAverageRate(), o.getAverageRate(), this::setAverageRate);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualOption _that = getType().cast(o);
		
			if (!Objects.equals(putCallCurrencyModel, _that.getPutCallCurrencyModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxAccrualOptionSequence, _that.getFxAccrualOptionSequence())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (putCallCurrencyModel != null ? putCallCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxAccrualOptionSequence != null ? fxAccrualOptionSequence.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualOptionBuilder {" +
				"putCallCurrencyModel=" + this.putCallCurrencyModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxAccrualOptionSequence=" + this.fxAccrualOptionSequence + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}
