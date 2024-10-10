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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxAmericanExercise;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.FxOption;
import fpml.confirmation.FxOption.FxOptionBuilder;
import fpml.confirmation.FxOption.FxOptionBuilderImpl;
import fpml.confirmation.FxOption.FxOptionImpl;
import fpml.confirmation.FxOptionFeatures;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxStrikePrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Option;
import fpml.confirmation.Option.OptionBuilder;
import fpml.confirmation.Option.OptionBuilderImpl;
import fpml.confirmation.Option.OptionImpl;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.meta.FxOptionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An FX option transaction definition. Describes an FX option with optional asian and barrier features.
 * @version ${project.version}
 */
@RosettaDataType(value="FxOption", builder=FxOption.FxOptionBuilderImpl.class, version="${project.version}")
public interface FxOption extends Option {

	FxOptionMeta metaData = new FxOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Effective date for a forward starting derivative. If this element is not present, the effective date is the trade date.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 */
	Period getTenorPeriod();
	/**
	 * The parameters for defining the exercise period for an American style option.
	 */
	FxAmericanExercise getAmericanExercise();
	/**
	 * The parameters for defining the exercise period for an European style option.
	 */
	FxEuropeanExercise getEuropeanExercise();
	/**
	 * A set of parameters defining procedures associated with the exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * The currency amount that the option gives the right to sell.
	 */
	NonNegativeMoney getPutCurrencyAmount();
	/**
	 * The currency amount that the option gives the right to buy.
	 */
	NonNegativeMoney getCallCurrencyAmount();
	/**
	 * Indicates how the product was original sold as a Put or a Call.
	 */
	PutCallEnum getSoldAs();
	/**
	 * Defines the option strike price.
	 */
	FxStrikePrice getStrike();
	/**
	 * An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move &quot;up&quot; or &quot;down&quot; to be triggered.
	 */
	BigDecimal getSpotRate();
	/**
	 * Describes additional features within the option.
	 */
	FxOptionFeatures getFeatures();
	/**
	 * Premium amount or premium installment amount for an option.
	 */
	FxOptionPremium getPremium();
	/**
	 * Specifies the currency and fixing details for cash settlement. This optional element is produced only where it has been specified at execution time that the option wlll be settled into a single cash payment - for example, in the case of a non-deliverable option (although note that an Fx option may be contractually cash settled, without necessarily being non-deliverable).
	 */
	FxCashSettlement getCashSettlement();

	/*********************** Build Methods  ***********************/
	FxOption build();
	
	FxOption.FxOptionBuilder toBuilder();
	
	static FxOption.FxOptionBuilder builder() {
		return new FxOption.FxOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxOption> getType() {
		return FxOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
		processRosetta(path.newSubPath("americanExercise"), processor, FxAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("putCurrencyAmount"), processor, NonNegativeMoney.class, getPutCurrencyAmount());
		processRosetta(path.newSubPath("callCurrencyAmount"), processor, NonNegativeMoney.class, getCallCurrencyAmount());
		processor.processBasic(path.newSubPath("soldAs"), PutCallEnum.class, getSoldAs(), this);
		processRosetta(path.newSubPath("strike"), processor, FxStrikePrice.class, getStrike());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("features"), processor, FxOptionFeatures.class, getFeatures());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlement.class, getCashSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionBuilder extends FxOption, Option.OptionBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		Period.PeriodBuilder getOrCreateTenorPeriod();
		Period.PeriodBuilder getTenorPeriod();
		FxAmericanExercise.FxAmericanExerciseBuilder getOrCreateAmericanExercise();
		FxAmericanExercise.FxAmericanExerciseBuilder getAmericanExercise();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePutCurrencyAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPutCurrencyAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCallCurrencyAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getCallCurrencyAmount();
		FxStrikePrice.FxStrikePriceBuilder getOrCreateStrike();
		FxStrikePrice.FxStrikePriceBuilder getStrike();
		FxOptionFeatures.FxOptionFeaturesBuilder getOrCreateFeatures();
		FxOptionFeatures.FxOptionFeaturesBuilder getFeatures();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium();
		FxOptionPremium.FxOptionPremiumBuilder getPremium();
		FxCashSettlement.FxCashSettlementBuilder getOrCreateCashSettlement();
		FxCashSettlement.FxCashSettlementBuilder getCashSettlement();
		FxOption.FxOptionBuilder setProductModel(ProductModel productModel);
		FxOption.FxOptionBuilder setId(String id);
		FxOption.FxOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		FxOption.FxOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		FxOption.FxOptionBuilder setTenorPeriod(Period tenorPeriod);
		FxOption.FxOptionBuilder setAmericanExercise(FxAmericanExercise americanExercise);
		FxOption.FxOptionBuilder setEuropeanExercise(FxEuropeanExercise europeanExercise);
		FxOption.FxOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxOption.FxOptionBuilder setPutCurrencyAmount(NonNegativeMoney putCurrencyAmount);
		FxOption.FxOptionBuilder setCallCurrencyAmount(NonNegativeMoney callCurrencyAmount);
		FxOption.FxOptionBuilder setSoldAs(PutCallEnum soldAs);
		FxOption.FxOptionBuilder setStrike(FxStrikePrice strike);
		FxOption.FxOptionBuilder setSpotRate(BigDecimal spotRate);
		FxOption.FxOptionBuilder setFeatures(FxOptionFeatures features);
		FxOption.FxOptionBuilder setPremium(FxOptionPremium premium);
		FxOption.FxOptionBuilder setCashSettlement(FxCashSettlement cashSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
			processRosetta(path.newSubPath("americanExercise"), processor, FxAmericanExercise.FxAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.FxEuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("putCurrencyAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPutCurrencyAmount());
			processRosetta(path.newSubPath("callCurrencyAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getCallCurrencyAmount());
			processor.processBasic(path.newSubPath("soldAs"), PutCallEnum.class, getSoldAs(), this);
			processRosetta(path.newSubPath("strike"), processor, FxStrikePrice.FxStrikePriceBuilder.class, getStrike());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("features"), processor, FxOptionFeatures.FxOptionFeaturesBuilder.class, getFeatures());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlement.FxCashSettlementBuilder.class, getCashSettlement());
		}
		

		FxOption.FxOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxOption  ***********************/
	class FxOptionImpl extends Option.OptionImpl implements FxOption {
		private final AdjustableOrRelativeDate effectiveDate;
		private final Period tenorPeriod;
		private final FxAmericanExercise americanExercise;
		private final FxEuropeanExercise europeanExercise;
		private final ExerciseProcedure exerciseProcedure;
		private final NonNegativeMoney putCurrencyAmount;
		private final NonNegativeMoney callCurrencyAmount;
		private final PutCallEnum soldAs;
		private final FxStrikePrice strike;
		private final BigDecimal spotRate;
		private final FxOptionFeatures features;
		private final FxOptionPremium premium;
		private final FxCashSettlement cashSettlement;
		
		protected FxOptionImpl(FxOption.FxOptionBuilder builder) {
			super(builder);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.putCurrencyAmount = ofNullable(builder.getPutCurrencyAmount()).map(f->f.build()).orElse(null);
			this.callCurrencyAmount = ofNullable(builder.getCallCurrencyAmount()).map(f->f.build()).orElse(null);
			this.soldAs = builder.getSoldAs();
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.features = ofNullable(builder.getFeatures()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public FxAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public FxEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("putCurrencyAmount")
		public NonNegativeMoney getPutCurrencyAmount() {
			return putCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("callCurrencyAmount")
		public NonNegativeMoney getCallCurrencyAmount() {
			return callCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("soldAs")
		public PutCallEnum getSoldAs() {
			return soldAs;
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("features")
		public FxOptionFeatures getFeatures() {
			return features;
		}
		
		@Override
		@RosettaAttribute("premium")
		public FxOptionPremium getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxCashSettlement getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxOption build() {
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder toBuilder() {
			FxOption.FxOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOption.FxOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getPutCurrencyAmount()).ifPresent(builder::setPutCurrencyAmount);
			ofNullable(getCallCurrencyAmount()).ifPresent(builder::setCallCurrencyAmount);
			ofNullable(getSoldAs()).ifPresent(builder::setSoldAs);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getFeatures()).ifPresent(builder::setFeatures);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(putCurrencyAmount, _that.getPutCurrencyAmount())) return false;
			if (!Objects.equals(callCurrencyAmount, _that.getCallCurrencyAmount())) return false;
			if (!Objects.equals(soldAs, _that.getSoldAs())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (putCurrencyAmount != null ? putCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (callCurrencyAmount != null ? callCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (soldAs != null ? soldAs.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOption {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"putCurrencyAmount=" + this.putCurrencyAmount + ", " +
				"callCurrencyAmount=" + this.callCurrencyAmount + ", " +
				"soldAs=" + this.soldAs + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"features=" + this.features + ", " +
				"premium=" + this.premium + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOption  ***********************/
	class FxOptionBuilderImpl extends Option.OptionBuilderImpl  implements FxOption.FxOptionBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected Period.PeriodBuilder tenorPeriod;
		protected FxAmericanExercise.FxAmericanExerciseBuilder americanExercise;
		protected FxEuropeanExercise.FxEuropeanExerciseBuilder europeanExercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected NonNegativeMoney.NonNegativeMoneyBuilder putCurrencyAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder callCurrencyAmount;
		protected PutCallEnum soldAs;
		protected FxStrikePrice.FxStrikePriceBuilder strike;
		protected BigDecimal spotRate;
		protected FxOptionFeatures.FxOptionFeaturesBuilder features;
		protected FxOptionPremium.FxOptionPremiumBuilder premium;
		protected FxCashSettlement.FxCashSettlementBuilder cashSettlement;
	
		public FxOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		public Period.PeriodBuilder getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenorPeriod() {
			Period.PeriodBuilder result;
			if (tenorPeriod!=null) {
				result = tenorPeriod;
			}
			else {
				result = tenorPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public FxAmericanExercise.FxAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder getOrCreateAmericanExercise() {
			FxAmericanExercise.FxAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = FxAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			FxEuropeanExercise.FxEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = FxEuropeanExercise.builder();
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
		@RosettaAttribute("putCurrencyAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPutCurrencyAmount() {
			return putCurrencyAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePutCurrencyAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (putCurrencyAmount!=null) {
				result = putCurrencyAmount;
			}
			else {
				result = putCurrencyAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("callCurrencyAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getCallCurrencyAmount() {
			return callCurrencyAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCallCurrencyAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (callCurrencyAmount!=null) {
				result = callCurrencyAmount;
			}
			else {
				result = callCurrencyAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("soldAs")
		public PutCallEnum getSoldAs() {
			return soldAs;
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxStrikePrice.FxStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxStrikePrice.FxStrikePriceBuilder getOrCreateStrike() {
			FxStrikePrice.FxStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("features")
		public FxOptionFeatures.FxOptionFeaturesBuilder getFeatures() {
			return features;
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder getOrCreateFeatures() {
			FxOptionFeatures.FxOptionFeaturesBuilder result;
			if (features!=null) {
				result = features;
			}
			else {
				result = features = FxOptionFeatures.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public FxOptionPremium.FxOptionPremiumBuilder getPremium() {
			return premium;
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium() {
			FxOptionPremium.FxOptionPremiumBuilder result;
			if (premium!=null) {
				result = premium;
			}
			else {
				result = premium = FxOptionPremium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxCashSettlement.FxCashSettlementBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder getOrCreateCashSettlement() {
			FxCashSettlement.FxCashSettlementBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxOption.FxOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxOption.FxOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public FxOption.FxOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FxOption.FxOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tenorPeriod")
		public FxOption.FxOptionBuilder setTenorPeriod(Period tenorPeriod) {
			this.tenorPeriod = tenorPeriod==null?null:tenorPeriod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("americanExercise")
		public FxOption.FxOptionBuilder setAmericanExercise(FxAmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("europeanExercise")
		public FxOption.FxOptionBuilder setEuropeanExercise(FxEuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public FxOption.FxOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("putCurrencyAmount")
		public FxOption.FxOptionBuilder setPutCurrencyAmount(NonNegativeMoney putCurrencyAmount) {
			this.putCurrencyAmount = putCurrencyAmount==null?null:putCurrencyAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("callCurrencyAmount")
		public FxOption.FxOptionBuilder setCallCurrencyAmount(NonNegativeMoney callCurrencyAmount) {
			this.callCurrencyAmount = callCurrencyAmount==null?null:callCurrencyAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("soldAs")
		public FxOption.FxOptionBuilder setSoldAs(PutCallEnum soldAs) {
			this.soldAs = soldAs==null?null:soldAs;
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public FxOption.FxOptionBuilder setStrike(FxStrikePrice strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxOption.FxOptionBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("features")
		public FxOption.FxOptionBuilder setFeatures(FxOptionFeatures features) {
			this.features = features==null?null:features.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public FxOption.FxOptionBuilder setPremium(FxOptionPremium premium) {
			this.premium = premium==null?null:premium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public FxOption.FxOptionBuilder setCashSettlement(FxCashSettlement cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxOption build() {
			return new FxOption.FxOptionImpl(this);
		}
		
		@Override
		public FxOption.FxOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOption.FxOptionBuilder prune() {
			super.prune();
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (putCurrencyAmount!=null && !putCurrencyAmount.prune().hasData()) putCurrencyAmount = null;
			if (callCurrencyAmount!=null && !callCurrencyAmount.prune().hasData()) callCurrencyAmount = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (features!=null && !features.prune().hasData()) features = null;
			if (premium!=null && !premium.prune().hasData()) premium = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getPutCurrencyAmount()!=null && getPutCurrencyAmount().hasData()) return true;
			if (getCallCurrencyAmount()!=null && getCallCurrencyAmount().hasData()) return true;
			if (getSoldAs()!=null) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getFeatures()!=null && getFeatures().hasData()) return true;
			if (getPremium()!=null && getPremium().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOption.FxOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxOption.FxOptionBuilder o = (FxOption.FxOptionBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getPutCurrencyAmount(), o.getPutCurrencyAmount(), this::setPutCurrencyAmount);
			merger.mergeRosetta(getCallCurrencyAmount(), o.getCallCurrencyAmount(), this::setCallCurrencyAmount);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getFeatures(), o.getFeatures(), this::setFeatures);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::setPremium);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			
			merger.mergeBasic(getSoldAs(), o.getSoldAs(), this::setSoldAs);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(putCurrencyAmount, _that.getPutCurrencyAmount())) return false;
			if (!Objects.equals(callCurrencyAmount, _that.getCallCurrencyAmount())) return false;
			if (!Objects.equals(soldAs, _that.getSoldAs())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (putCurrencyAmount != null ? putCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (callCurrencyAmount != null ? callCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (soldAs != null ? soldAs.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"putCurrencyAmount=" + this.putCurrencyAmount + ", " +
				"callCurrencyAmount=" + this.callCurrencyAmount + ", " +
				"soldAs=" + this.soldAs + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"features=" + this.features + ", " +
				"premium=" + this.premium + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}' + " " + super.toString();
		}
	}
}
