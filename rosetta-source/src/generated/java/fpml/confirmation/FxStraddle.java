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
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.Currency;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.FxStraddle;
import fpml.confirmation.FxStraddle.FxStraddleBuilder;
import fpml.confirmation.FxStraddle.FxStraddleBuilderImpl;
import fpml.confirmation.FxStraddle.FxStraddleImpl;
import fpml.confirmation.FxStraddlePremium;
import fpml.confirmation.FxStraddleTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FxStraddleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Straddle details. Straddle is composed of two options: a call and a put involving the quotedCurrencyPair.
 * @version ${project.version}
 */
@RosettaDataType(value="FxStraddle", builder=FxStraddle.FxStraddleBuilderImpl.class, version="${project.version}")
public interface FxStraddle extends RosettaModelObject {

	FxStraddleMeta metaData = new FxStraddleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type Straddle as agreed on the Trade Date, e.g. at the money forward straddle, or delta neutral straddle.
	 */
	FxStraddleTypeEnum getStraddleType();
	/**
	 * A Tenor (time to maturity) of the straddle starting from the Fixing Date (e.g. 1y, 3m)
	 */
	Period getTenorPeriod();
	/**
	 * The parameters for exercising the FxStraddle (underlying options), the underlying options are always European style options.
	 */
	FxEuropeanExercise getEuropeanExercise();
	/**
	 * A set of parameters defining procedures associated with the exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * The currency amount for the FxStraddle. This will be the notional for the underlying options, which may be exercised by the Buyer.
	 */
	NonNegativeMoney getNotional();
	/**
	 * The counter currency and amount for the FxStraddle. The Counter Currency Amount is determined using the notional and the Strike Price (which is determined at the fixingTime on the fixingDate).
	 */
	Currency getCounterCurrency();
	/**
	 * Defines the FX Straddle premium amount, payer and dates. This amount is also determined at the fixingTime on the fixingDate.
	 */
	List<? extends FxStraddlePremium> getPremium();
	/**
	 * DEPRECATED. The settlement date is already expressed by europeanExercise/valueDate. The Settlement Date for the FxStraddle (if exercised at the expiryTime on the expiry Date).
	 */
	AdjustableOrAdjustedDate getSettlementDate();
	/**
	 * Specifies the settlement type for the FxStraddle. If deliverable then this element is removed. If non-deliverable, then the In-The-Money amount of the relevant option within the FxStraddle is paid by the Seller to the Buyer. The In-The-Money amount is calculated using the parameters within this element.
	 */
	FxCashSettlementSimple getCashSettlement();

	/*********************** Build Methods  ***********************/
	FxStraddle build();
	
	FxStraddle.FxStraddleBuilder toBuilder();
	
	static FxStraddle.FxStraddleBuilder builder() {
		return new FxStraddle.FxStraddleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStraddle> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxStraddle> getType() {
		return FxStraddle.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("straddleType"), FxStraddleTypeEnum.class, getStraddleType(), this);
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
		processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("counterCurrency"), processor, Currency.class, getCounterCurrency());
		processRosetta(path.newSubPath("premium"), processor, FxStraddlePremium.class, getPremium());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.class, getSettlementDate());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStraddleBuilder extends FxStraddle, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateTenorPeriod();
		Period.PeriodBuilder getTenorPeriod();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional();
		NonNegativeMoney.NonNegativeMoneyBuilder getNotional();
		Currency.CurrencyBuilder getOrCreateCounterCurrency();
		Currency.CurrencyBuilder getCounterCurrency();
		FxStraddlePremium.FxStraddlePremiumBuilder getOrCreatePremium(int _index);
		List<? extends FxStraddlePremium.FxStraddlePremiumBuilder> getPremium();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		FxStraddle.FxStraddleBuilder setStraddleType(FxStraddleTypeEnum straddleType);
		FxStraddle.FxStraddleBuilder setTenorPeriod(Period tenorPeriod);
		FxStraddle.FxStraddleBuilder setEuropeanExercise(FxEuropeanExercise europeanExercise);
		FxStraddle.FxStraddleBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxStraddle.FxStraddleBuilder setNotional(NonNegativeMoney notional);
		FxStraddle.FxStraddleBuilder setCounterCurrency(Currency counterCurrency);
		FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium premium0);
		FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium premium1, int _idx);
		FxStraddle.FxStraddleBuilder addPremium(List<? extends FxStraddlePremium> premium2);
		FxStraddle.FxStraddleBuilder setPremium(List<? extends FxStraddlePremium> premium3);
		FxStraddle.FxStraddleBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate);
		FxStraddle.FxStraddleBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("straddleType"), FxStraddleTypeEnum.class, getStraddleType(), this);
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
			processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.FxEuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("counterCurrency"), processor, Currency.CurrencyBuilder.class, getCounterCurrency());
			processRosetta(path.newSubPath("premium"), processor, FxStraddlePremium.FxStraddlePremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
		}
		

		FxStraddle.FxStraddleBuilder prune();
	}

	/*********************** Immutable Implementation of FxStraddle  ***********************/
	class FxStraddleImpl implements FxStraddle {
		private final FxStraddleTypeEnum straddleType;
		private final Period tenorPeriod;
		private final FxEuropeanExercise europeanExercise;
		private final ExerciseProcedure exerciseProcedure;
		private final NonNegativeMoney notional;
		private final Currency counterCurrency;
		private final List<? extends FxStraddlePremium> premium;
		private final AdjustableOrAdjustedDate settlementDate;
		private final FxCashSettlementSimple cashSettlement;
		
		protected FxStraddleImpl(FxStraddle.FxStraddleBuilder builder) {
			this.straddleType = builder.getStraddleType();
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.counterCurrency = ofNullable(builder.getCounterCurrency()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("straddleType")
		public FxStraddleTypeEnum getStraddleType() {
			return straddleType;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
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
		@RosettaAttribute("notional")
		public NonNegativeMoney getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("counterCurrency")
		public Currency getCounterCurrency() {
			return counterCurrency;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxStraddlePremium> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrAdjustedDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxCashSettlementSimple getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxStraddle build() {
			return this;
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder toBuilder() {
			FxStraddle.FxStraddleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStraddle.FxStraddleBuilder builder) {
			ofNullable(getStraddleType()).ifPresent(builder::setStraddleType);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getCounterCurrency()).ifPresent(builder::setCounterCurrency);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxStraddle _that = getType().cast(o);
		
			if (!Objects.equals(straddleType, _that.getStraddleType())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(counterCurrency, _that.getCounterCurrency())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (straddleType != null ? straddleType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (counterCurrency != null ? counterCurrency.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddle {" +
				"straddleType=" + this.straddleType + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"notional=" + this.notional + ", " +
				"counterCurrency=" + this.counterCurrency + ", " +
				"premium=" + this.premium + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}';
		}
	}

	/*********************** Builder Implementation of FxStraddle  ***********************/
	class FxStraddleBuilderImpl implements FxStraddle.FxStraddleBuilder {
	
		protected FxStraddleTypeEnum straddleType;
		protected Period.PeriodBuilder tenorPeriod;
		protected FxEuropeanExercise.FxEuropeanExerciseBuilder europeanExercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notional;
		protected Currency.CurrencyBuilder counterCurrency;
		protected List<FxStraddlePremium.FxStraddlePremiumBuilder> premium = new ArrayList<>();
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder settlementDate;
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
	
		public FxStraddleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("straddleType")
		public FxStraddleTypeEnum getStraddleType() {
			return straddleType;
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
		@RosettaAttribute("notional")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotional() {
			return notional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrency")
		public Currency.CurrencyBuilder getCounterCurrency() {
			return counterCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCounterCurrency() {
			Currency.CurrencyBuilder result;
			if (counterCurrency!=null) {
				result = counterCurrency;
			}
			else {
				result = counterCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxStraddlePremium.FxStraddlePremiumBuilder> getPremium() {
			return premium;
		}
		
		public FxStraddlePremium.FxStraddlePremiumBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			FxStraddlePremium.FxStraddlePremiumBuilder result;
			return getIndex(premium, _index, () -> {
						FxStraddlePremium.FxStraddlePremiumBuilder newPremium = FxStraddlePremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlementSimple.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("straddleType")
		public FxStraddle.FxStraddleBuilder setStraddleType(FxStraddleTypeEnum straddleType) {
			this.straddleType = straddleType==null?null:straddleType;
			return this;
		}
		@Override
		@RosettaAttribute("tenorPeriod")
		public FxStraddle.FxStraddleBuilder setTenorPeriod(Period tenorPeriod) {
			this.tenorPeriod = tenorPeriod==null?null:tenorPeriod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("europeanExercise")
		public FxStraddle.FxStraddleBuilder setEuropeanExercise(FxEuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public FxStraddle.FxStraddleBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public FxStraddle.FxStraddleBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrency")
		public FxStraddle.FxStraddleBuilder setCounterCurrency(Currency counterCurrency) {
			this.counterCurrency = counterCurrency==null?null:counterCurrency.toBuilder();
			return this;
		}
		@Override
		public FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public FxStraddle.FxStraddleBuilder addPremium(List<? extends FxStraddlePremium> premiums) {
			if (premiums != null) {
				for (FxStraddlePremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("premium")
		public FxStraddle.FxStraddleBuilder setPremium(List<? extends FxStraddlePremium> premiums) {
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
		@RosettaAttribute("settlementDate")
		public FxStraddle.FxStraddleBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public FxStraddle.FxStraddleBuilder setCashSettlement(FxCashSettlementSimple cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxStraddle build() {
			return new FxStraddle.FxStraddleImpl(this);
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddle.FxStraddleBuilder prune() {
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (counterCurrency!=null && !counterCurrency.prune().hasData()) counterCurrency = null;
			premium = premium.stream().filter(b->b!=null).<FxStraddlePremium.FxStraddlePremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStraddleType()!=null) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getCounterCurrency()!=null && getCounterCurrency().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddle.FxStraddleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxStraddle.FxStraddleBuilder o = (FxStraddle.FxStraddleBuilder) other;
			
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getCounterCurrency(), o.getCounterCurrency(), this::setCounterCurrency);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			
			merger.mergeBasic(getStraddleType(), o.getStraddleType(), this::setStraddleType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxStraddle _that = getType().cast(o);
		
			if (!Objects.equals(straddleType, _that.getStraddleType())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(counterCurrency, _that.getCounterCurrency())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (straddleType != null ? straddleType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (counterCurrency != null ? counterCurrency.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddleBuilder {" +
				"straddleType=" + this.straddleType + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"notional=" + this.notional + ", " +
				"counterCurrency=" + this.counterCurrency + ", " +
				"premium=" + this.premium + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}';
		}
	}
}
