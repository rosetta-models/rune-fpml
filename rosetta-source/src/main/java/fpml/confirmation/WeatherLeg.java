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
import fpml.confirmation.CommodityRelativePaymentDates;
import fpml.confirmation.FinancialSwapLeg;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilder;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilderImpl;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.WeatherCalculationPeriodModel;
import fpml.confirmation.WeatherIndex;
import fpml.confirmation.WeatherIndexData;
import fpml.confirmation.WeatherLeg;
import fpml.confirmation.WeatherLeg.WeatherLegBuilder;
import fpml.confirmation.WeatherLeg.WeatherLegBuilderImpl;
import fpml.confirmation.WeatherLeg.WeatherLegImpl;
import fpml.confirmation.WeatherLegCalculation;
import fpml.confirmation.meta.WeatherLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A weather leg of a Commodity Swap defines Weather Index Swap transactions. Weather Index Swap transactions are OTC derivative transactions which settle financially based on an index calculated from observations of temperature, precipitation and other weather-related measurements at weather stations throughout the world. Sub-Annex C of the 2005 ISDA Commodity Definitions provides definitions and terms for a number of types of weather indices. These indices include: HDD (heating degree days), CDD (cooling degree days), CPD (critical precipitation days). Weather Index Swap transactions result in a cash flow to one of the two counterparties each Calculation Period depending on the relationship between the Settlement Level and the Weather Index Level. A Weather Index swap transaction always consists of a commodity swap element as a parent to two weatherLeg elements.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="WeatherLeg", builder=WeatherLeg.WeatherLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface WeatherLeg extends FinancialSwapLeg {

	WeatherLegMeta metaData = new WeatherLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defining the Weather Index Level or Weather Index Strike Level.
	 */
	WeatherIndex getWeatherIndexLevel();
	WeatherCalculationPeriodModel getWeatherCalculationPeriodModel();
	/**
	 * Defines the price per weather index unit.
	 */
	NonNegativeMoney getWeatherNotionalAmount();
	/**
	 * Defines details relevant to the calculation of the aggregate weather index amount.
	 */
	WeatherLegCalculation getCalculation();
	/**
	 * The Payment Dates of the trade relative to the Calculation Periods or Calculation Date
	 */
	CommodityRelativePaymentDates getPaymentDates();
	/**
	 * Specifies where the data (e.g. CPD) have been collected, an actual physical reference point (weather station) and various fall back arrangements.
	 */
	WeatherIndexData getWeatherIndexData();

	/*********************** Build Methods  ***********************/
	WeatherLeg build();
	
	WeatherLeg.WeatherLegBuilder toBuilder();
	
	static WeatherLeg.WeatherLegBuilder builder() {
		return new WeatherLeg.WeatherLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherLeg> getType() {
		return WeatherLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("weatherIndexLevel"), processor, WeatherIndex.class, getWeatherIndexLevel());
		processRosetta(path.newSubPath("weatherCalculationPeriodModel"), processor, WeatherCalculationPeriodModel.class, getWeatherCalculationPeriodModel());
		processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.class, getWeatherNotionalAmount());
		processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("paymentDates"), processor, CommodityRelativePaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.class, getWeatherIndexData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherLegBuilder extends WeatherLeg, FinancialSwapLeg.FinancialSwapLegBuilder {
		WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexLevel();
		WeatherIndex.WeatherIndexBuilder getWeatherIndexLevel();
		WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder getOrCreateWeatherCalculationPeriodModel();
		WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder getWeatherCalculationPeriodModel();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateWeatherNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getWeatherNotionalAmount();
		WeatherLegCalculation.WeatherLegCalculationBuilder getOrCreateCalculation();
		WeatherLegCalculation.WeatherLegCalculationBuilder getCalculation();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreatePaymentDates();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getPaymentDates();
		WeatherIndexData.WeatherIndexDataBuilder getOrCreateWeatherIndexData();
		WeatherIndexData.WeatherIndexDataBuilder getWeatherIndexData();
		WeatherLeg.WeatherLegBuilder setId(String id);
		WeatherLeg.WeatherLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		WeatherLeg.WeatherLegBuilder setWeatherIndexLevel(WeatherIndex weatherIndexLevel);
		WeatherLeg.WeatherLegBuilder setWeatherCalculationPeriodModel(WeatherCalculationPeriodModel weatherCalculationPeriodModel);
		WeatherLeg.WeatherLegBuilder setWeatherNotionalAmount(NonNegativeMoney weatherNotionalAmount);
		WeatherLeg.WeatherLegBuilder setCalculation(WeatherLegCalculation calculation);
		WeatherLeg.WeatherLegBuilder setPaymentDates(CommodityRelativePaymentDates paymentDates);
		WeatherLeg.WeatherLegBuilder setWeatherIndexData(WeatherIndexData weatherIndexData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("weatherIndexLevel"), processor, WeatherIndex.WeatherIndexBuilder.class, getWeatherIndexLevel());
			processRosetta(path.newSubPath("weatherCalculationPeriodModel"), processor, WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder.class, getWeatherCalculationPeriodModel());
			processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getWeatherNotionalAmount());
			processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.WeatherLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("paymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.WeatherIndexDataBuilder.class, getWeatherIndexData());
		}
		

		WeatherLeg.WeatherLegBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherLeg  ***********************/
	class WeatherLegImpl extends FinancialSwapLeg.FinancialSwapLegImpl implements WeatherLeg {
		private final WeatherIndex weatherIndexLevel;
		private final WeatherCalculationPeriodModel weatherCalculationPeriodModel;
		private final NonNegativeMoney weatherNotionalAmount;
		private final WeatherLegCalculation calculation;
		private final CommodityRelativePaymentDates paymentDates;
		private final WeatherIndexData weatherIndexData;
		
		protected WeatherLegImpl(WeatherLeg.WeatherLegBuilder builder) {
			super(builder);
			this.weatherIndexLevel = ofNullable(builder.getWeatherIndexLevel()).map(f->f.build()).orElse(null);
			this.weatherCalculationPeriodModel = ofNullable(builder.getWeatherCalculationPeriodModel()).map(f->f.build()).orElse(null);
			this.weatherNotionalAmount = ofNullable(builder.getWeatherNotionalAmount()).map(f->f.build()).orElse(null);
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.weatherIndexData = ofNullable(builder.getWeatherIndexData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("weatherIndexLevel")
		public WeatherIndex getWeatherIndexLevel() {
			return weatherIndexLevel;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodModel")
		public WeatherCalculationPeriodModel getWeatherCalculationPeriodModel() {
			return weatherCalculationPeriodModel;
		}
		
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		public NonNegativeMoney getWeatherNotionalAmount() {
			return weatherNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("calculation")
		public WeatherLegCalculation getCalculation() {
			return calculation;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public CommodityRelativePaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("weatherIndexData")
		public WeatherIndexData getWeatherIndexData() {
			return weatherIndexData;
		}
		
		@Override
		public WeatherLeg build() {
			return this;
		}
		
		@Override
		public WeatherLeg.WeatherLegBuilder toBuilder() {
			WeatherLeg.WeatherLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherLeg.WeatherLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getWeatherIndexLevel()).ifPresent(builder::setWeatherIndexLevel);
			ofNullable(getWeatherCalculationPeriodModel()).ifPresent(builder::setWeatherCalculationPeriodModel);
			ofNullable(getWeatherNotionalAmount()).ifPresent(builder::setWeatherNotionalAmount);
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getWeatherIndexData()).ifPresent(builder::setWeatherIndexData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			WeatherLeg _that = getType().cast(o);
		
			if (!Objects.equals(weatherIndexLevel, _that.getWeatherIndexLevel())) return false;
			if (!Objects.equals(weatherCalculationPeriodModel, _that.getWeatherCalculationPeriodModel())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weatherIndexLevel != null ? weatherIndexLevel.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodModel != null ? weatherCalculationPeriodModel.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherLeg {" +
				"weatherIndexLevel=" + this.weatherIndexLevel + ", " +
				"weatherCalculationPeriodModel=" + this.weatherCalculationPeriodModel + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"calculation=" + this.calculation + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"weatherIndexData=" + this.weatherIndexData +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of WeatherLeg  ***********************/
	class WeatherLegBuilderImpl extends FinancialSwapLeg.FinancialSwapLegBuilderImpl  implements WeatherLeg.WeatherLegBuilder {
	
		protected WeatherIndex.WeatherIndexBuilder weatherIndexLevel;
		protected WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder weatherCalculationPeriodModel;
		protected NonNegativeMoney.NonNegativeMoneyBuilder weatherNotionalAmount;
		protected WeatherLegCalculation.WeatherLegCalculationBuilder calculation;
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder paymentDates;
		protected WeatherIndexData.WeatherIndexDataBuilder weatherIndexData;
	
		public WeatherLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("weatherIndexLevel")
		public WeatherIndex.WeatherIndexBuilder getWeatherIndexLevel() {
			return weatherIndexLevel;
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexLevel() {
			WeatherIndex.WeatherIndexBuilder result;
			if (weatherIndexLevel!=null) {
				result = weatherIndexLevel;
			}
			else {
				result = weatherIndexLevel = WeatherIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodModel")
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder getWeatherCalculationPeriodModel() {
			return weatherCalculationPeriodModel;
		}
		
		@Override
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder getOrCreateWeatherCalculationPeriodModel() {
			WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder result;
			if (weatherCalculationPeriodModel!=null) {
				result = weatherCalculationPeriodModel;
			}
			else {
				result = weatherCalculationPeriodModel = WeatherCalculationPeriodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getWeatherNotionalAmount() {
			return weatherNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateWeatherNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (weatherNotionalAmount!=null) {
				result = weatherNotionalAmount;
			}
			else {
				result = weatherNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculation")
		public WeatherLegCalculation.WeatherLegCalculationBuilder getCalculation() {
			return calculation;
		}
		
		@Override
		public WeatherLegCalculation.WeatherLegCalculationBuilder getOrCreateCalculation() {
			WeatherLegCalculation.WeatherLegCalculationBuilder result;
			if (calculation!=null) {
				result = calculation;
			}
			else {
				result = calculation = WeatherLegCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreatePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherIndexData")
		public WeatherIndexData.WeatherIndexDataBuilder getWeatherIndexData() {
			return weatherIndexData;
		}
		
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder getOrCreateWeatherIndexData() {
			WeatherIndexData.WeatherIndexDataBuilder result;
			if (weatherIndexData!=null) {
				result = weatherIndexData;
			}
			else {
				result = weatherIndexData = WeatherIndexData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public WeatherLeg.WeatherLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public WeatherLeg.WeatherLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherIndexLevel")
		public WeatherLeg.WeatherLegBuilder setWeatherIndexLevel(WeatherIndex weatherIndexLevel) {
			this.weatherIndexLevel = weatherIndexLevel==null?null:weatherIndexLevel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherCalculationPeriodModel")
		public WeatherLeg.WeatherLegBuilder setWeatherCalculationPeriodModel(WeatherCalculationPeriodModel weatherCalculationPeriodModel) {
			this.weatherCalculationPeriodModel = weatherCalculationPeriodModel==null?null:weatherCalculationPeriodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		public WeatherLeg.WeatherLegBuilder setWeatherNotionalAmount(NonNegativeMoney weatherNotionalAmount) {
			this.weatherNotionalAmount = weatherNotionalAmount==null?null:weatherNotionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculation")
		public WeatherLeg.WeatherLegBuilder setCalculation(WeatherLegCalculation calculation) {
			this.calculation = calculation==null?null:calculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDates")
		public WeatherLeg.WeatherLegBuilder setPaymentDates(CommodityRelativePaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherIndexData")
		public WeatherLeg.WeatherLegBuilder setWeatherIndexData(WeatherIndexData weatherIndexData) {
			this.weatherIndexData = weatherIndexData==null?null:weatherIndexData.toBuilder();
			return this;
		}
		
		@Override
		public WeatherLeg build() {
			return new WeatherLeg.WeatherLegImpl(this);
		}
		
		@Override
		public WeatherLeg.WeatherLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherLeg.WeatherLegBuilder prune() {
			super.prune();
			if (weatherIndexLevel!=null && !weatherIndexLevel.prune().hasData()) weatherIndexLevel = null;
			if (weatherCalculationPeriodModel!=null && !weatherCalculationPeriodModel.prune().hasData()) weatherCalculationPeriodModel = null;
			if (weatherNotionalAmount!=null && !weatherNotionalAmount.prune().hasData()) weatherNotionalAmount = null;
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (weatherIndexData!=null && !weatherIndexData.prune().hasData()) weatherIndexData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getWeatherIndexLevel()!=null && getWeatherIndexLevel().hasData()) return true;
			if (getWeatherCalculationPeriodModel()!=null && getWeatherCalculationPeriodModel().hasData()) return true;
			if (getWeatherNotionalAmount()!=null && getWeatherNotionalAmount().hasData()) return true;
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getWeatherIndexData()!=null && getWeatherIndexData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherLeg.WeatherLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			WeatherLeg.WeatherLegBuilder o = (WeatherLeg.WeatherLegBuilder) other;
			
			merger.mergeRosetta(getWeatherIndexLevel(), o.getWeatherIndexLevel(), this::setWeatherIndexLevel);
			merger.mergeRosetta(getWeatherCalculationPeriodModel(), o.getWeatherCalculationPeriodModel(), this::setWeatherCalculationPeriodModel);
			merger.mergeRosetta(getWeatherNotionalAmount(), o.getWeatherNotionalAmount(), this::setWeatherNotionalAmount);
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getWeatherIndexData(), o.getWeatherIndexData(), this::setWeatherIndexData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			WeatherLeg _that = getType().cast(o);
		
			if (!Objects.equals(weatherIndexLevel, _that.getWeatherIndexLevel())) return false;
			if (!Objects.equals(weatherCalculationPeriodModel, _that.getWeatherCalculationPeriodModel())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weatherIndexLevel != null ? weatherIndexLevel.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodModel != null ? weatherCalculationPeriodModel.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherLegBuilder {" +
				"weatherIndexLevel=" + this.weatherIndexLevel + ", " +
				"weatherCalculationPeriodModel=" + this.weatherCalculationPeriodModel + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"calculation=" + this.calculation + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"weatherIndexData=" + this.weatherIndexData +
			'}' + " " + super.toString();
		}
	}
}
