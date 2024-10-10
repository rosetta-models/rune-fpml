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
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Period;
import fpml.confirmation.Rounding;
import fpml.confirmation.WeatherLegCalculation;
import fpml.confirmation.WeatherLegCalculation.WeatherLegCalculationBuilder;
import fpml.confirmation.WeatherLegCalculation.WeatherLegCalculationBuilderImpl;
import fpml.confirmation.WeatherLegCalculation.WeatherLegCalculationImpl;
import fpml.confirmation.WeatherSettlementLevelEnum;
import fpml.confirmation.meta.WeatherLegCalculationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to capture details of the calculation of the Payment Amount on a Weather Index Transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="WeatherLegCalculation", builder=WeatherLegCalculation.WeatherLegCalculationBuilderImpl.class, version="${project.version}")
public interface WeatherLegCalculation extends RosettaModelObject {

	WeatherLegCalculationMeta metaData = new WeatherLegCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Settlement Level means either the cumulative number of Weather Index Units for each day in the Calculation Period (Cumulative) or the cumulative number of Weather Index Units for each day in the Calculation Period divided by the number of days in the Calculation Period (Average) or the maximum number of Weather Index Units for any day in the Calculation Period (Maximum) or the minimum number of Weather Index Units for any day in the Calculation Period.
	 */
	WeatherSettlementLevelEnum getSettlementLevel();
	/**
	 * If Reference Level Equals Zero is specified to be applicable then CPD means, for any day during the Calculation Period, (A) 1 if the Daily Precipitation for that day is greater than or equal to the CPD Reference Level or (B) zero if the the Daily Precipitation for that day is less than the CPD Reference Level. If Reference Level Equals Zero is specified not to be applicable then CPD means, for any day during the Calculation Period, (A) 1 if the Daily Precipitation for that day is greater than the CPD Reference Level or 0 if the Daily Precipitation for that day is less than or equal to the CPD Reference Level.
	 */
	Boolean getReferenceLevelEqualsZero();
	/**
	 * The number of days following the final day of the Calculation Period specified in the Confirmation on which is is practicable to provide the notice that the Calculation Agent is required to give for that Settlement Date or Payment Date.
	 */
	Period getCalculationDate();
	/**
	 * A day on which commmercial banks settle payments and are open for general business in the place(s) specified in the Confirmation. See Section 1.3 of the ISDA 2005 Commodity Definitions.
	 */
	BusinessCenter getBusinessDays();
	/**
	 * The date payment often revised after its publication, this indicates if the payment date could be recalculated.
	 */
	Boolean getDataCorrection();
	/**
	 * If &#39;dataCorrection&#39;=true, this indicates how long after the initial publication of the data corrections can be made.
	 */
	Period getCorrectionPeriod();
	/**
	 * The maximum total payment amount that will be paid in any particular transaction.
	 */
	NonNegativeMoney getMaximumPaymentAmount();
	/**
	 * The maximum payment amount that will be paid in any particular Calculation Period.
	 */
	NonNegativeMoney getMaximumTransactionPaymentAmount();
	/**
	 * Rounding direction and precision for price values.
	 */
	Rounding getRounding();

	/*********************** Build Methods  ***********************/
	WeatherLegCalculation build();
	
	WeatherLegCalculation.WeatherLegCalculationBuilder toBuilder();
	
	static WeatherLegCalculation.WeatherLegCalculationBuilder builder() {
		return new WeatherLegCalculation.WeatherLegCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherLegCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherLegCalculation> getType() {
		return WeatherLegCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("settlementLevel"), WeatherSettlementLevelEnum.class, getSettlementLevel(), this);
		processor.processBasic(path.newSubPath("referenceLevelEqualsZero"), Boolean.class, getReferenceLevelEqualsZero(), this);
		processRosetta(path.newSubPath("calculationDate"), processor, Period.class, getCalculationDate());
		processRosetta(path.newSubPath("businessDays"), processor, BusinessCenter.class, getBusinessDays());
		processor.processBasic(path.newSubPath("dataCorrection"), Boolean.class, getDataCorrection(), this);
		processRosetta(path.newSubPath("correctionPeriod"), processor, Period.class, getCorrectionPeriod());
		processRosetta(path.newSubPath("maximumPaymentAmount"), processor, NonNegativeMoney.class, getMaximumPaymentAmount());
		processRosetta(path.newSubPath("maximumTransactionPaymentAmount"), processor, NonNegativeMoney.class, getMaximumTransactionPaymentAmount());
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherLegCalculationBuilder extends WeatherLegCalculation, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateCalculationDate();
		Period.PeriodBuilder getCalculationDate();
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessDays();
		BusinessCenter.BusinessCenterBuilder getBusinessDays();
		Period.PeriodBuilder getOrCreateCorrectionPeriod();
		Period.PeriodBuilder getCorrectionPeriod();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMaximumPaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getMaximumPaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMaximumTransactionPaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getMaximumTransactionPaymentAmount();
		Rounding.RoundingBuilder getOrCreateRounding();
		Rounding.RoundingBuilder getRounding();
		WeatherLegCalculation.WeatherLegCalculationBuilder setSettlementLevel(WeatherSettlementLevelEnum settlementLevel);
		WeatherLegCalculation.WeatherLegCalculationBuilder setReferenceLevelEqualsZero(Boolean referenceLevelEqualsZero);
		WeatherLegCalculation.WeatherLegCalculationBuilder setCalculationDate(Period calculationDate);
		WeatherLegCalculation.WeatherLegCalculationBuilder setBusinessDays(BusinessCenter businessDays);
		WeatherLegCalculation.WeatherLegCalculationBuilder setDataCorrection(Boolean dataCorrection);
		WeatherLegCalculation.WeatherLegCalculationBuilder setCorrectionPeriod(Period correctionPeriod);
		WeatherLegCalculation.WeatherLegCalculationBuilder setMaximumPaymentAmount(NonNegativeMoney maximumPaymentAmount);
		WeatherLegCalculation.WeatherLegCalculationBuilder setMaximumTransactionPaymentAmount(NonNegativeMoney maximumTransactionPaymentAmount);
		WeatherLegCalculation.WeatherLegCalculationBuilder setRounding(Rounding rounding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("settlementLevel"), WeatherSettlementLevelEnum.class, getSettlementLevel(), this);
			processor.processBasic(path.newSubPath("referenceLevelEqualsZero"), Boolean.class, getReferenceLevelEqualsZero(), this);
			processRosetta(path.newSubPath("calculationDate"), processor, Period.PeriodBuilder.class, getCalculationDate());
			processRosetta(path.newSubPath("businessDays"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessDays());
			processor.processBasic(path.newSubPath("dataCorrection"), Boolean.class, getDataCorrection(), this);
			processRosetta(path.newSubPath("correctionPeriod"), processor, Period.PeriodBuilder.class, getCorrectionPeriod());
			processRosetta(path.newSubPath("maximumPaymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getMaximumPaymentAmount());
			processRosetta(path.newSubPath("maximumTransactionPaymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getMaximumTransactionPaymentAmount());
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		WeatherLegCalculation.WeatherLegCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherLegCalculation  ***********************/
	class WeatherLegCalculationImpl implements WeatherLegCalculation {
		private final WeatherSettlementLevelEnum settlementLevel;
		private final Boolean referenceLevelEqualsZero;
		private final Period calculationDate;
		private final BusinessCenter businessDays;
		private final Boolean dataCorrection;
		private final Period correctionPeriod;
		private final NonNegativeMoney maximumPaymentAmount;
		private final NonNegativeMoney maximumTransactionPaymentAmount;
		private final Rounding rounding;
		
		protected WeatherLegCalculationImpl(WeatherLegCalculation.WeatherLegCalculationBuilder builder) {
			this.settlementLevel = builder.getSettlementLevel();
			this.referenceLevelEqualsZero = builder.getReferenceLevelEqualsZero();
			this.calculationDate = ofNullable(builder.getCalculationDate()).map(f->f.build()).orElse(null);
			this.businessDays = ofNullable(builder.getBusinessDays()).map(f->f.build()).orElse(null);
			this.dataCorrection = builder.getDataCorrection();
			this.correctionPeriod = ofNullable(builder.getCorrectionPeriod()).map(f->f.build()).orElse(null);
			this.maximumPaymentAmount = ofNullable(builder.getMaximumPaymentAmount()).map(f->f.build()).orElse(null);
			this.maximumTransactionPaymentAmount = ofNullable(builder.getMaximumTransactionPaymentAmount()).map(f->f.build()).orElse(null);
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementLevel")
		public WeatherSettlementLevelEnum getSettlementLevel() {
			return settlementLevel;
		}
		
		@Override
		@RosettaAttribute("referenceLevelEqualsZero")
		public Boolean getReferenceLevelEqualsZero() {
			return referenceLevelEqualsZero;
		}
		
		@Override
		@RosettaAttribute("calculationDate")
		public Period getCalculationDate() {
			return calculationDate;
		}
		
		@Override
		@RosettaAttribute("businessDays")
		public BusinessCenter getBusinessDays() {
			return businessDays;
		}
		
		@Override
		@RosettaAttribute("dataCorrection")
		public Boolean getDataCorrection() {
			return dataCorrection;
		}
		
		@Override
		@RosettaAttribute("correctionPeriod")
		public Period getCorrectionPeriod() {
			return correctionPeriod;
		}
		
		@Override
		@RosettaAttribute("maximumPaymentAmount")
		public NonNegativeMoney getMaximumPaymentAmount() {
			return maximumPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("maximumTransactionPaymentAmount")
		public NonNegativeMoney getMaximumTransactionPaymentAmount() {
			return maximumTransactionPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		public WeatherLegCalculation build() {
			return this;
		}
		
		@Override
		public WeatherLegCalculation.WeatherLegCalculationBuilder toBuilder() {
			WeatherLegCalculation.WeatherLegCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherLegCalculation.WeatherLegCalculationBuilder builder) {
			ofNullable(getSettlementLevel()).ifPresent(builder::setSettlementLevel);
			ofNullable(getReferenceLevelEqualsZero()).ifPresent(builder::setReferenceLevelEqualsZero);
			ofNullable(getCalculationDate()).ifPresent(builder::setCalculationDate);
			ofNullable(getBusinessDays()).ifPresent(builder::setBusinessDays);
			ofNullable(getDataCorrection()).ifPresent(builder::setDataCorrection);
			ofNullable(getCorrectionPeriod()).ifPresent(builder::setCorrectionPeriod);
			ofNullable(getMaximumPaymentAmount()).ifPresent(builder::setMaximumPaymentAmount);
			ofNullable(getMaximumTransactionPaymentAmount()).ifPresent(builder::setMaximumTransactionPaymentAmount);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherLegCalculation _that = getType().cast(o);
		
			if (!Objects.equals(settlementLevel, _that.getSettlementLevel())) return false;
			if (!Objects.equals(referenceLevelEqualsZero, _that.getReferenceLevelEqualsZero())) return false;
			if (!Objects.equals(calculationDate, _that.getCalculationDate())) return false;
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			if (!Objects.equals(dataCorrection, _that.getDataCorrection())) return false;
			if (!Objects.equals(correctionPeriod, _that.getCorrectionPeriod())) return false;
			if (!Objects.equals(maximumPaymentAmount, _that.getMaximumPaymentAmount())) return false;
			if (!Objects.equals(maximumTransactionPaymentAmount, _that.getMaximumTransactionPaymentAmount())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementLevel != null ? settlementLevel.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceLevelEqualsZero != null ? referenceLevelEqualsZero.hashCode() : 0);
			_result = 31 * _result + (calculationDate != null ? calculationDate.hashCode() : 0);
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			_result = 31 * _result + (dataCorrection != null ? dataCorrection.hashCode() : 0);
			_result = 31 * _result + (correctionPeriod != null ? correctionPeriod.hashCode() : 0);
			_result = 31 * _result + (maximumPaymentAmount != null ? maximumPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (maximumTransactionPaymentAmount != null ? maximumTransactionPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherLegCalculation {" +
				"settlementLevel=" + this.settlementLevel + ", " +
				"referenceLevelEqualsZero=" + this.referenceLevelEqualsZero + ", " +
				"calculationDate=" + this.calculationDate + ", " +
				"businessDays=" + this.businessDays + ", " +
				"dataCorrection=" + this.dataCorrection + ", " +
				"correctionPeriod=" + this.correctionPeriod + ", " +
				"maximumPaymentAmount=" + this.maximumPaymentAmount + ", " +
				"maximumTransactionPaymentAmount=" + this.maximumTransactionPaymentAmount + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherLegCalculation  ***********************/
	class WeatherLegCalculationBuilderImpl implements WeatherLegCalculation.WeatherLegCalculationBuilder {
	
		protected WeatherSettlementLevelEnum settlementLevel;
		protected Boolean referenceLevelEqualsZero;
		protected Period.PeriodBuilder calculationDate;
		protected BusinessCenter.BusinessCenterBuilder businessDays;
		protected Boolean dataCorrection;
		protected Period.PeriodBuilder correctionPeriod;
		protected NonNegativeMoney.NonNegativeMoneyBuilder maximumPaymentAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder maximumTransactionPaymentAmount;
		protected Rounding.RoundingBuilder rounding;
	
		public WeatherLegCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementLevel")
		public WeatherSettlementLevelEnum getSettlementLevel() {
			return settlementLevel;
		}
		
		@Override
		@RosettaAttribute("referenceLevelEqualsZero")
		public Boolean getReferenceLevelEqualsZero() {
			return referenceLevelEqualsZero;
		}
		
		@Override
		@RosettaAttribute("calculationDate")
		public Period.PeriodBuilder getCalculationDate() {
			return calculationDate;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateCalculationDate() {
			Period.PeriodBuilder result;
			if (calculationDate!=null) {
				result = calculationDate;
			}
			else {
				result = calculationDate = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessDays")
		public BusinessCenter.BusinessCenterBuilder getBusinessDays() {
			return businessDays;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessDays() {
			BusinessCenter.BusinessCenterBuilder result;
			if (businessDays!=null) {
				result = businessDays;
			}
			else {
				result = businessDays = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dataCorrection")
		public Boolean getDataCorrection() {
			return dataCorrection;
		}
		
		@Override
		@RosettaAttribute("correctionPeriod")
		public Period.PeriodBuilder getCorrectionPeriod() {
			return correctionPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateCorrectionPeriod() {
			Period.PeriodBuilder result;
			if (correctionPeriod!=null) {
				result = correctionPeriod;
			}
			else {
				result = correctionPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumPaymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getMaximumPaymentAmount() {
			return maximumPaymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMaximumPaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (maximumPaymentAmount!=null) {
				result = maximumPaymentAmount;
			}
			else {
				result = maximumPaymentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumTransactionPaymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getMaximumTransactionPaymentAmount() {
			return maximumTransactionPaymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMaximumTransactionPaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (maximumTransactionPaymentAmount!=null) {
				result = maximumTransactionPaymentAmount;
			}
			else {
				result = maximumTransactionPaymentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementLevel")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setSettlementLevel(WeatherSettlementLevelEnum settlementLevel) {
			this.settlementLevel = settlementLevel==null?null:settlementLevel;
			return this;
		}
		@Override
		@RosettaAttribute("referenceLevelEqualsZero")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setReferenceLevelEqualsZero(Boolean referenceLevelEqualsZero) {
			this.referenceLevelEqualsZero = referenceLevelEqualsZero==null?null:referenceLevelEqualsZero;
			return this;
		}
		@Override
		@RosettaAttribute("calculationDate")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setCalculationDate(Period calculationDate) {
			this.calculationDate = calculationDate==null?null:calculationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessDays")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setBusinessDays(BusinessCenter businessDays) {
			this.businessDays = businessDays==null?null:businessDays.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dataCorrection")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setDataCorrection(Boolean dataCorrection) {
			this.dataCorrection = dataCorrection==null?null:dataCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correctionPeriod")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setCorrectionPeriod(Period correctionPeriod) {
			this.correctionPeriod = correctionPeriod==null?null:correctionPeriod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maximumPaymentAmount")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setMaximumPaymentAmount(NonNegativeMoney maximumPaymentAmount) {
			this.maximumPaymentAmount = maximumPaymentAmount==null?null:maximumPaymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maximumTransactionPaymentAmount")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setMaximumTransactionPaymentAmount(NonNegativeMoney maximumTransactionPaymentAmount) {
			this.maximumTransactionPaymentAmount = maximumTransactionPaymentAmount==null?null:maximumTransactionPaymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rounding")
		public WeatherLegCalculation.WeatherLegCalculationBuilder setRounding(Rounding rounding) {
			this.rounding = rounding==null?null:rounding.toBuilder();
			return this;
		}
		
		@Override
		public WeatherLegCalculation build() {
			return new WeatherLegCalculation.WeatherLegCalculationImpl(this);
		}
		
		@Override
		public WeatherLegCalculation.WeatherLegCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherLegCalculation.WeatherLegCalculationBuilder prune() {
			if (calculationDate!=null && !calculationDate.prune().hasData()) calculationDate = null;
			if (businessDays!=null && !businessDays.prune().hasData()) businessDays = null;
			if (correctionPeriod!=null && !correctionPeriod.prune().hasData()) correctionPeriod = null;
			if (maximumPaymentAmount!=null && !maximumPaymentAmount.prune().hasData()) maximumPaymentAmount = null;
			if (maximumTransactionPaymentAmount!=null && !maximumTransactionPaymentAmount.prune().hasData()) maximumTransactionPaymentAmount = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementLevel()!=null) return true;
			if (getReferenceLevelEqualsZero()!=null) return true;
			if (getCalculationDate()!=null && getCalculationDate().hasData()) return true;
			if (getBusinessDays()!=null && getBusinessDays().hasData()) return true;
			if (getDataCorrection()!=null) return true;
			if (getCorrectionPeriod()!=null && getCorrectionPeriod().hasData()) return true;
			if (getMaximumPaymentAmount()!=null && getMaximumPaymentAmount().hasData()) return true;
			if (getMaximumTransactionPaymentAmount()!=null && getMaximumTransactionPaymentAmount().hasData()) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherLegCalculation.WeatherLegCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherLegCalculation.WeatherLegCalculationBuilder o = (WeatherLegCalculation.WeatherLegCalculationBuilder) other;
			
			merger.mergeRosetta(getCalculationDate(), o.getCalculationDate(), this::setCalculationDate);
			merger.mergeRosetta(getBusinessDays(), o.getBusinessDays(), this::setBusinessDays);
			merger.mergeRosetta(getCorrectionPeriod(), o.getCorrectionPeriod(), this::setCorrectionPeriod);
			merger.mergeRosetta(getMaximumPaymentAmount(), o.getMaximumPaymentAmount(), this::setMaximumPaymentAmount);
			merger.mergeRosetta(getMaximumTransactionPaymentAmount(), o.getMaximumTransactionPaymentAmount(), this::setMaximumTransactionPaymentAmount);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			
			merger.mergeBasic(getSettlementLevel(), o.getSettlementLevel(), this::setSettlementLevel);
			merger.mergeBasic(getReferenceLevelEqualsZero(), o.getReferenceLevelEqualsZero(), this::setReferenceLevelEqualsZero);
			merger.mergeBasic(getDataCorrection(), o.getDataCorrection(), this::setDataCorrection);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherLegCalculation _that = getType().cast(o);
		
			if (!Objects.equals(settlementLevel, _that.getSettlementLevel())) return false;
			if (!Objects.equals(referenceLevelEqualsZero, _that.getReferenceLevelEqualsZero())) return false;
			if (!Objects.equals(calculationDate, _that.getCalculationDate())) return false;
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			if (!Objects.equals(dataCorrection, _that.getDataCorrection())) return false;
			if (!Objects.equals(correctionPeriod, _that.getCorrectionPeriod())) return false;
			if (!Objects.equals(maximumPaymentAmount, _that.getMaximumPaymentAmount())) return false;
			if (!Objects.equals(maximumTransactionPaymentAmount, _that.getMaximumTransactionPaymentAmount())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementLevel != null ? settlementLevel.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceLevelEqualsZero != null ? referenceLevelEqualsZero.hashCode() : 0);
			_result = 31 * _result + (calculationDate != null ? calculationDate.hashCode() : 0);
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			_result = 31 * _result + (dataCorrection != null ? dataCorrection.hashCode() : 0);
			_result = 31 * _result + (correctionPeriod != null ? correctionPeriod.hashCode() : 0);
			_result = 31 * _result + (maximumPaymentAmount != null ? maximumPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (maximumTransactionPaymentAmount != null ? maximumTransactionPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherLegCalculationBuilder {" +
				"settlementLevel=" + this.settlementLevel + ", " +
				"referenceLevelEqualsZero=" + this.referenceLevelEqualsZero + ", " +
				"calculationDate=" + this.calculationDate + ", " +
				"businessDays=" + this.businessDays + ", " +
				"dataCorrection=" + this.dataCorrection + ", " +
				"correctionPeriod=" + this.correctionPeriod + ", " +
				"maximumPaymentAmount=" + this.maximumPaymentAmount + ", " +
				"maximumTransactionPaymentAmount=" + this.maximumTransactionPaymentAmount + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}
}
