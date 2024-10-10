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
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.CommodityWeatherOptionModel;
import fpml.confirmation.CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder;
import fpml.confirmation.CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilderImpl;
import fpml.confirmation.CommodityWeatherOptionModel.CommodityWeatherOptionModelImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.WeatherCalculationPeriodModel;
import fpml.confirmation.WeatherIndex;
import fpml.confirmation.WeatherIndexData;
import fpml.confirmation.WeatherLegCalculation;
import fpml.confirmation.meta.CommodityWeatherOptionModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Described Weather Index Option component. Weather Index Option transactions are OTC derivative transactions which settle financially based on an index calculated from observations of temperature and precipitation at weather stations throughout the world. Sub-Annex C of the 2005 ISDA Commodity Definitions provides definitions and terms for a number of types of weather indices. These indices include: HDD (heating degree days), CDD (cooling degree days), CPD (critical precipitation days). Weather Index Option Transactions results in a cash flow to the buyer depending on the relationship between the Settlement Level to the Weather Index Strike Level.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityWeatherOptionModel", builder=CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilderImpl.class, version="${project.version}")
public interface CommodityWeatherOptionModel extends RosettaModelObject {

	CommodityWeatherOptionModelMeta metaData = new CommodityWeatherOptionModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Effective date of an option.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	WeatherCalculationPeriodModel getWeatherCalculationPeriodModel();
	NonNegativeMoney getWeatherNotionalAmount();
	CommodityExercise getExercise();
	/**
	 * Weather Index strike price level is specified in terms of weather index units (e.g. 1 Days, 3 Inches, etc.)
	 */
	WeatherIndex getWeatherIndexStrikeLevel();
	/**
	 * Contains parameters which figure in the calculation of payments on a Weather Index Option.
	 */
	WeatherLegCalculation getCalculation();
	/**
	 * Specifies where the data (e.g. CPD) have been collected, an actual physical reference point (weather station) and various fall back arrangements.
	 */
	WeatherIndexData getWeatherIndexData();

	/*********************** Build Methods  ***********************/
	CommodityWeatherOptionModel build();
	
	CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder toBuilder();
	
	static CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder builder() {
		return new CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityWeatherOptionModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityWeatherOptionModel> getType() {
		return CommodityWeatherOptionModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("weatherCalculationPeriodModel"), processor, WeatherCalculationPeriodModel.class, getWeatherCalculationPeriodModel());
		processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.class, getWeatherNotionalAmount());
		processRosetta(path.newSubPath("exercise"), processor, CommodityExercise.class, getExercise());
		processRosetta(path.newSubPath("weatherIndexStrikeLevel"), processor, WeatherIndex.class, getWeatherIndexStrikeLevel());
		processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.class, getWeatherIndexData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityWeatherOptionModelBuilder extends CommodityWeatherOptionModel, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder getOrCreateWeatherCalculationPeriodModel();
		WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder getWeatherCalculationPeriodModel();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateWeatherNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getWeatherNotionalAmount();
		CommodityExercise.CommodityExerciseBuilder getOrCreateExercise();
		CommodityExercise.CommodityExerciseBuilder getExercise();
		WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexStrikeLevel();
		WeatherIndex.WeatherIndexBuilder getWeatherIndexStrikeLevel();
		WeatherLegCalculation.WeatherLegCalculationBuilder getOrCreateCalculation();
		WeatherLegCalculation.WeatherLegCalculationBuilder getCalculation();
		WeatherIndexData.WeatherIndexDataBuilder getOrCreateWeatherIndexData();
		WeatherIndexData.WeatherIndexDataBuilder getWeatherIndexData();
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherCalculationPeriodModel(WeatherCalculationPeriodModel weatherCalculationPeriodModel);
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherNotionalAmount(NonNegativeMoney weatherNotionalAmount);
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setExercise(CommodityExercise exercise);
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherIndexStrikeLevel(WeatherIndex weatherIndexStrikeLevel);
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setCalculation(WeatherLegCalculation calculation);
		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherIndexData(WeatherIndexData weatherIndexData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("weatherCalculationPeriodModel"), processor, WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder.class, getWeatherCalculationPeriodModel());
			processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getWeatherNotionalAmount());
			processRosetta(path.newSubPath("exercise"), processor, CommodityExercise.CommodityExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("weatherIndexStrikeLevel"), processor, WeatherIndex.WeatherIndexBuilder.class, getWeatherIndexStrikeLevel());
			processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.WeatherLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.WeatherIndexDataBuilder.class, getWeatherIndexData());
		}
		

		CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityWeatherOptionModel  ***********************/
	class CommodityWeatherOptionModelImpl implements CommodityWeatherOptionModel {
		private final AdjustableOrRelativeDate effectiveDate;
		private final WeatherCalculationPeriodModel weatherCalculationPeriodModel;
		private final NonNegativeMoney weatherNotionalAmount;
		private final CommodityExercise exercise;
		private final WeatherIndex weatherIndexStrikeLevel;
		private final WeatherLegCalculation calculation;
		private final WeatherIndexData weatherIndexData;
		
		protected CommodityWeatherOptionModelImpl(CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.weatherCalculationPeriodModel = ofNullable(builder.getWeatherCalculationPeriodModel()).map(f->f.build()).orElse(null);
			this.weatherNotionalAmount = ofNullable(builder.getWeatherNotionalAmount()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.weatherIndexStrikeLevel = ofNullable(builder.getWeatherIndexStrikeLevel()).map(f->f.build()).orElse(null);
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.weatherIndexData = ofNullable(builder.getWeatherIndexData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
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
		@RosettaAttribute("exercise")
		public CommodityExercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("weatherIndexStrikeLevel")
		public WeatherIndex getWeatherIndexStrikeLevel() {
			return weatherIndexStrikeLevel;
		}
		
		@Override
		@RosettaAttribute("calculation")
		public WeatherLegCalculation getCalculation() {
			return calculation;
		}
		
		@Override
		@RosettaAttribute("weatherIndexData")
		public WeatherIndexData getWeatherIndexData() {
			return weatherIndexData;
		}
		
		@Override
		public CommodityWeatherOptionModel build() {
			return this;
		}
		
		@Override
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder toBuilder() {
			CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getWeatherCalculationPeriodModel()).ifPresent(builder::setWeatherCalculationPeriodModel);
			ofNullable(getWeatherNotionalAmount()).ifPresent(builder::setWeatherNotionalAmount);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getWeatherIndexStrikeLevel()).ifPresent(builder::setWeatherIndexStrikeLevel);
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getWeatherIndexData()).ifPresent(builder::setWeatherIndexData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityWeatherOptionModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(weatherCalculationPeriodModel, _that.getWeatherCalculationPeriodModel())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(weatherIndexStrikeLevel, _that.getWeatherIndexStrikeLevel())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodModel != null ? weatherCalculationPeriodModel.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (weatherIndexStrikeLevel != null ? weatherIndexStrikeLevel.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityWeatherOptionModel {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"weatherCalculationPeriodModel=" + this.weatherCalculationPeriodModel + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"exercise=" + this.exercise + ", " +
				"weatherIndexStrikeLevel=" + this.weatherIndexStrikeLevel + ", " +
				"calculation=" + this.calculation + ", " +
				"weatherIndexData=" + this.weatherIndexData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityWeatherOptionModel  ***********************/
	class CommodityWeatherOptionModelBuilderImpl implements CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder weatherCalculationPeriodModel;
		protected NonNegativeMoney.NonNegativeMoneyBuilder weatherNotionalAmount;
		protected CommodityExercise.CommodityExerciseBuilder exercise;
		protected WeatherIndex.WeatherIndexBuilder weatherIndexStrikeLevel;
		protected WeatherLegCalculation.WeatherLegCalculationBuilder calculation;
		protected WeatherIndexData.WeatherIndexDataBuilder weatherIndexData;
	
		public CommodityWeatherOptionModelBuilderImpl() {
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
		@RosettaAttribute("exercise")
		public CommodityExercise.CommodityExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public CommodityExercise.CommodityExerciseBuilder getOrCreateExercise() {
			CommodityExercise.CommodityExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = CommodityExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherIndexStrikeLevel")
		public WeatherIndex.WeatherIndexBuilder getWeatherIndexStrikeLevel() {
			return weatherIndexStrikeLevel;
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexStrikeLevel() {
			WeatherIndex.WeatherIndexBuilder result;
			if (weatherIndexStrikeLevel!=null) {
				result = weatherIndexStrikeLevel;
			}
			else {
				result = weatherIndexStrikeLevel = WeatherIndex.builder();
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
		@RosettaAttribute("effectiveDate")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherCalculationPeriodModel")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherCalculationPeriodModel(WeatherCalculationPeriodModel weatherCalculationPeriodModel) {
			this.weatherCalculationPeriodModel = weatherCalculationPeriodModel==null?null:weatherCalculationPeriodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherNotionalAmount(NonNegativeMoney weatherNotionalAmount) {
			this.weatherNotionalAmount = weatherNotionalAmount==null?null:weatherNotionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setExercise(CommodityExercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherIndexStrikeLevel")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherIndexStrikeLevel(WeatherIndex weatherIndexStrikeLevel) {
			this.weatherIndexStrikeLevel = weatherIndexStrikeLevel==null?null:weatherIndexStrikeLevel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculation")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setCalculation(WeatherLegCalculation calculation) {
			this.calculation = calculation==null?null:calculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherIndexData")
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder setWeatherIndexData(WeatherIndexData weatherIndexData) {
			this.weatherIndexData = weatherIndexData==null?null:weatherIndexData.toBuilder();
			return this;
		}
		
		@Override
		public CommodityWeatherOptionModel build() {
			return new CommodityWeatherOptionModel.CommodityWeatherOptionModelImpl(this);
		}
		
		@Override
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (weatherCalculationPeriodModel!=null && !weatherCalculationPeriodModel.prune().hasData()) weatherCalculationPeriodModel = null;
			if (weatherNotionalAmount!=null && !weatherNotionalAmount.prune().hasData()) weatherNotionalAmount = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (weatherIndexStrikeLevel!=null && !weatherIndexStrikeLevel.prune().hasData()) weatherIndexStrikeLevel = null;
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (weatherIndexData!=null && !weatherIndexData.prune().hasData()) weatherIndexData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getWeatherCalculationPeriodModel()!=null && getWeatherCalculationPeriodModel().hasData()) return true;
			if (getWeatherNotionalAmount()!=null && getWeatherNotionalAmount().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getWeatherIndexStrikeLevel()!=null && getWeatherIndexStrikeLevel().hasData()) return true;
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getWeatherIndexData()!=null && getWeatherIndexData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder o = (CommodityWeatherOptionModel.CommodityWeatherOptionModelBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getWeatherCalculationPeriodModel(), o.getWeatherCalculationPeriodModel(), this::setWeatherCalculationPeriodModel);
			merger.mergeRosetta(getWeatherNotionalAmount(), o.getWeatherNotionalAmount(), this::setWeatherNotionalAmount);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getWeatherIndexStrikeLevel(), o.getWeatherIndexStrikeLevel(), this::setWeatherIndexStrikeLevel);
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getWeatherIndexData(), o.getWeatherIndexData(), this::setWeatherIndexData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityWeatherOptionModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(weatherCalculationPeriodModel, _that.getWeatherCalculationPeriodModel())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(weatherIndexStrikeLevel, _that.getWeatherIndexStrikeLevel())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodModel != null ? weatherCalculationPeriodModel.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (weatherIndexStrikeLevel != null ? weatherIndexStrikeLevel.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityWeatherOptionModelBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"weatherCalculationPeriodModel=" + this.weatherCalculationPeriodModel + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"exercise=" + this.exercise + ", " +
				"weatherIndexStrikeLevel=" + this.weatherIndexStrikeLevel + ", " +
				"calculation=" + this.calculation + ", " +
				"weatherIndexData=" + this.weatherIndexData +
			'}';
		}
	}
}
