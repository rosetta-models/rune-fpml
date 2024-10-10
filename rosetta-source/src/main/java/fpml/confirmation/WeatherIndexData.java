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
import fpml.confirmation.DataProvider;
import fpml.confirmation.DisruptionFallback;
import fpml.confirmation.ReferenceLevel;
import fpml.confirmation.WeatherIndexData;
import fpml.confirmation.WeatherIndexData.WeatherIndexDataBuilder;
import fpml.confirmation.WeatherIndexData.WeatherIndexDataBuilderImpl;
import fpml.confirmation.WeatherIndexData.WeatherIndexDataImpl;
import fpml.confirmation.WeatherStation;
import fpml.confirmation.meta.WeatherIndexDataMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="WeatherIndexData", builder=WeatherIndexData.WeatherIndexDataBuilderImpl.class, version="${project.version}")
public interface WeatherIndexData extends RosettaModelObject {

	WeatherIndexDataMeta metaData = new WeatherIndexDataMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference level is the number of degree-days (in the case of HDD and CDD) or inches/millimeters (in the case of CPD) on which the differential is calculated. In the case of HDD it is the number of degree-days below this reference level. In the case of CDD it is the number of degree days above this reference level. In the case of CPD it is number of inches/millimeters above this reference level.
	 */
	ReferenceLevel getReferenceLevel();
	/**
	 * The provider of either temperature data or precipitation data specified by the parties in the related Confirmation.
	 */
	DataProvider getDataProvider();
	/**
	 * If specified by the parties to apply in the related Confirmation, Final Edited Data means that the parties will have recourse to Primary Disruption Fallbacks even if relevant data is available from the Data Provider, so long as such data is not published in its final edited form. Otherwise the parties will have recourse to Primary Disruption Fallbacks only if relevant data is unavailable from the Data Provider on a relevant day.
	 */
	Boolean getFinalEditedData();
	/**
	 * The source or sources of weather index data specified by the parties in the related Confirmation. Examples include: AU-CBM (the Commonwealth Bureau of Meteorology in Australia) and CM-SMI (the Swiss Meteorological Institute).
	 */
	WeatherStation getWeatherStation();
	/**
	 * If weather index data is not available for the weather station specified by the parties in the related Confirmation, the first alternative Weather Index Station.
	 */
	WeatherStation getWeatherStationFallback();
	/**
	 * If weather index data is neither available for the weather station specified by the parties in the related Confirmation nor the first alternative Weather Index Station, the second alternative Weather Index Station.
	 */
	WeatherStation getWeatherStationSecondFallback();
	/**
	 * A provider of either temperature data or precipitation data specified by the parties in the related Confirmation. If the parties fail to specify an Alternative Data Provider, the &quot;Fallback Data&quot; Disruption Fallback will not apply.
	 */
	Boolean getAlternativeDataProvider();
	/**
	 * If the parties specify &quot;Not Applicable&quot;, the &quot;Synoptic Data&quot; Disruption Fallback will not apply. Synoptic Data means that maximum and/or minimum temperature or daily precipitation at the location for the Missing Data Day will be the maxium and/or minimum temperature or daily precipitation for that day at the Location (Weather Index Station) which has not been subject to ultimate quality control, integrity or verification process.
	 */
	Boolean getSynopticDataFallback();
	/**
	 * The Weather Index Station from which data with which to apply the &quot;Adjustement to Fallback Station Data&quot; terms. See Section 11.20 of the 2005 ISDA Commodity Definitions.
	 */
	Boolean getAdjustmentToFallbackWeatherStation();
	/**
	 * A list of actions available to the parties should a Primary Disruption Event occur. A Primary Disruption Event means if maximum or minimum temperature or precipitation data for a Missing Data Day is required to determine a Payment Amount then the maximum and/or minimum temperature or the daily precipitation for that day will be determined in accordance with the first applicable Primary Disruption Fallback.
	 */
	DisruptionFallback getPrimaryDisruptionFallbacks();
	/**
	 * A list of actions available to the parties should a Secondary Disruption Event occur. A Primary Disruption Event means if maximum or minimum temperature or precipitation data for a Missing Data Day is required to determine a Payment Amount then the maximum and/or minimum temperature or the daily precipitation for that day will be determined in accordance with the first applicable Secondary Disruption Fallback.
	 */
	DisruptionFallback getSecondaryDisruptionFallbacks();

	/*********************** Build Methods  ***********************/
	WeatherIndexData build();
	
	WeatherIndexData.WeatherIndexDataBuilder toBuilder();
	
	static WeatherIndexData.WeatherIndexDataBuilder builder() {
		return new WeatherIndexData.WeatherIndexDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherIndexData> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherIndexData> getType() {
		return WeatherIndexData.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceLevel"), processor, ReferenceLevel.class, getReferenceLevel());
		processRosetta(path.newSubPath("dataProvider"), processor, DataProvider.class, getDataProvider());
		processor.processBasic(path.newSubPath("finalEditedData"), Boolean.class, getFinalEditedData(), this);
		processRosetta(path.newSubPath("weatherStation"), processor, WeatherStation.class, getWeatherStation());
		processRosetta(path.newSubPath("weatherStationFallback"), processor, WeatherStation.class, getWeatherStationFallback());
		processRosetta(path.newSubPath("weatherStationSecondFallback"), processor, WeatherStation.class, getWeatherStationSecondFallback());
		processor.processBasic(path.newSubPath("alternativeDataProvider"), Boolean.class, getAlternativeDataProvider(), this);
		processor.processBasic(path.newSubPath("synopticDataFallback"), Boolean.class, getSynopticDataFallback(), this);
		processor.processBasic(path.newSubPath("adjustmentToFallbackWeatherStation"), Boolean.class, getAdjustmentToFallbackWeatherStation(), this);
		processRosetta(path.newSubPath("primaryDisruptionFallbacks"), processor, DisruptionFallback.class, getPrimaryDisruptionFallbacks());
		processRosetta(path.newSubPath("secondaryDisruptionFallbacks"), processor, DisruptionFallback.class, getSecondaryDisruptionFallbacks());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherIndexDataBuilder extends WeatherIndexData, RosettaModelObjectBuilder {
		ReferenceLevel.ReferenceLevelBuilder getOrCreateReferenceLevel();
		ReferenceLevel.ReferenceLevelBuilder getReferenceLevel();
		DataProvider.DataProviderBuilder getOrCreateDataProvider();
		DataProvider.DataProviderBuilder getDataProvider();
		WeatherStation.WeatherStationBuilder getOrCreateWeatherStation();
		WeatherStation.WeatherStationBuilder getWeatherStation();
		WeatherStation.WeatherStationBuilder getOrCreateWeatherStationFallback();
		WeatherStation.WeatherStationBuilder getWeatherStationFallback();
		WeatherStation.WeatherStationBuilder getOrCreateWeatherStationSecondFallback();
		WeatherStation.WeatherStationBuilder getWeatherStationSecondFallback();
		DisruptionFallback.DisruptionFallbackBuilder getOrCreatePrimaryDisruptionFallbacks();
		DisruptionFallback.DisruptionFallbackBuilder getPrimaryDisruptionFallbacks();
		DisruptionFallback.DisruptionFallbackBuilder getOrCreateSecondaryDisruptionFallbacks();
		DisruptionFallback.DisruptionFallbackBuilder getSecondaryDisruptionFallbacks();
		WeatherIndexData.WeatherIndexDataBuilder setReferenceLevel(ReferenceLevel referenceLevel);
		WeatherIndexData.WeatherIndexDataBuilder setDataProvider(DataProvider dataProvider);
		WeatherIndexData.WeatherIndexDataBuilder setFinalEditedData(Boolean finalEditedData);
		WeatherIndexData.WeatherIndexDataBuilder setWeatherStation(WeatherStation weatherStation);
		WeatherIndexData.WeatherIndexDataBuilder setWeatherStationFallback(WeatherStation weatherStationFallback);
		WeatherIndexData.WeatherIndexDataBuilder setWeatherStationSecondFallback(WeatherStation weatherStationSecondFallback);
		WeatherIndexData.WeatherIndexDataBuilder setAlternativeDataProvider(Boolean alternativeDataProvider);
		WeatherIndexData.WeatherIndexDataBuilder setSynopticDataFallback(Boolean synopticDataFallback);
		WeatherIndexData.WeatherIndexDataBuilder setAdjustmentToFallbackWeatherStation(Boolean adjustmentToFallbackWeatherStation);
		WeatherIndexData.WeatherIndexDataBuilder setPrimaryDisruptionFallbacks(DisruptionFallback primaryDisruptionFallbacks);
		WeatherIndexData.WeatherIndexDataBuilder setSecondaryDisruptionFallbacks(DisruptionFallback secondaryDisruptionFallbacks);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceLevel"), processor, ReferenceLevel.ReferenceLevelBuilder.class, getReferenceLevel());
			processRosetta(path.newSubPath("dataProvider"), processor, DataProvider.DataProviderBuilder.class, getDataProvider());
			processor.processBasic(path.newSubPath("finalEditedData"), Boolean.class, getFinalEditedData(), this);
			processRosetta(path.newSubPath("weatherStation"), processor, WeatherStation.WeatherStationBuilder.class, getWeatherStation());
			processRosetta(path.newSubPath("weatherStationFallback"), processor, WeatherStation.WeatherStationBuilder.class, getWeatherStationFallback());
			processRosetta(path.newSubPath("weatherStationSecondFallback"), processor, WeatherStation.WeatherStationBuilder.class, getWeatherStationSecondFallback());
			processor.processBasic(path.newSubPath("alternativeDataProvider"), Boolean.class, getAlternativeDataProvider(), this);
			processor.processBasic(path.newSubPath("synopticDataFallback"), Boolean.class, getSynopticDataFallback(), this);
			processor.processBasic(path.newSubPath("adjustmentToFallbackWeatherStation"), Boolean.class, getAdjustmentToFallbackWeatherStation(), this);
			processRosetta(path.newSubPath("primaryDisruptionFallbacks"), processor, DisruptionFallback.DisruptionFallbackBuilder.class, getPrimaryDisruptionFallbacks());
			processRosetta(path.newSubPath("secondaryDisruptionFallbacks"), processor, DisruptionFallback.DisruptionFallbackBuilder.class, getSecondaryDisruptionFallbacks());
		}
		

		WeatherIndexData.WeatherIndexDataBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherIndexData  ***********************/
	class WeatherIndexDataImpl implements WeatherIndexData {
		private final ReferenceLevel referenceLevel;
		private final DataProvider dataProvider;
		private final Boolean finalEditedData;
		private final WeatherStation weatherStation;
		private final WeatherStation weatherStationFallback;
		private final WeatherStation weatherStationSecondFallback;
		private final Boolean alternativeDataProvider;
		private final Boolean synopticDataFallback;
		private final Boolean adjustmentToFallbackWeatherStation;
		private final DisruptionFallback primaryDisruptionFallbacks;
		private final DisruptionFallback secondaryDisruptionFallbacks;
		
		protected WeatherIndexDataImpl(WeatherIndexData.WeatherIndexDataBuilder builder) {
			this.referenceLevel = ofNullable(builder.getReferenceLevel()).map(f->f.build()).orElse(null);
			this.dataProvider = ofNullable(builder.getDataProvider()).map(f->f.build()).orElse(null);
			this.finalEditedData = builder.getFinalEditedData();
			this.weatherStation = ofNullable(builder.getWeatherStation()).map(f->f.build()).orElse(null);
			this.weatherStationFallback = ofNullable(builder.getWeatherStationFallback()).map(f->f.build()).orElse(null);
			this.weatherStationSecondFallback = ofNullable(builder.getWeatherStationSecondFallback()).map(f->f.build()).orElse(null);
			this.alternativeDataProvider = builder.getAlternativeDataProvider();
			this.synopticDataFallback = builder.getSynopticDataFallback();
			this.adjustmentToFallbackWeatherStation = builder.getAdjustmentToFallbackWeatherStation();
			this.primaryDisruptionFallbacks = ofNullable(builder.getPrimaryDisruptionFallbacks()).map(f->f.build()).orElse(null);
			this.secondaryDisruptionFallbacks = ofNullable(builder.getSecondaryDisruptionFallbacks()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceLevel")
		public ReferenceLevel getReferenceLevel() {
			return referenceLevel;
		}
		
		@Override
		@RosettaAttribute("dataProvider")
		public DataProvider getDataProvider() {
			return dataProvider;
		}
		
		@Override
		@RosettaAttribute("finalEditedData")
		public Boolean getFinalEditedData() {
			return finalEditedData;
		}
		
		@Override
		@RosettaAttribute("weatherStation")
		public WeatherStation getWeatherStation() {
			return weatherStation;
		}
		
		@Override
		@RosettaAttribute("weatherStationFallback")
		public WeatherStation getWeatherStationFallback() {
			return weatherStationFallback;
		}
		
		@Override
		@RosettaAttribute("weatherStationSecondFallback")
		public WeatherStation getWeatherStationSecondFallback() {
			return weatherStationSecondFallback;
		}
		
		@Override
		@RosettaAttribute("alternativeDataProvider")
		public Boolean getAlternativeDataProvider() {
			return alternativeDataProvider;
		}
		
		@Override
		@RosettaAttribute("synopticDataFallback")
		public Boolean getSynopticDataFallback() {
			return synopticDataFallback;
		}
		
		@Override
		@RosettaAttribute("adjustmentToFallbackWeatherStation")
		public Boolean getAdjustmentToFallbackWeatherStation() {
			return adjustmentToFallbackWeatherStation;
		}
		
		@Override
		@RosettaAttribute("primaryDisruptionFallbacks")
		public DisruptionFallback getPrimaryDisruptionFallbacks() {
			return primaryDisruptionFallbacks;
		}
		
		@Override
		@RosettaAttribute("secondaryDisruptionFallbacks")
		public DisruptionFallback getSecondaryDisruptionFallbacks() {
			return secondaryDisruptionFallbacks;
		}
		
		@Override
		public WeatherIndexData build() {
			return this;
		}
		
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder toBuilder() {
			WeatherIndexData.WeatherIndexDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherIndexData.WeatherIndexDataBuilder builder) {
			ofNullable(getReferenceLevel()).ifPresent(builder::setReferenceLevel);
			ofNullable(getDataProvider()).ifPresent(builder::setDataProvider);
			ofNullable(getFinalEditedData()).ifPresent(builder::setFinalEditedData);
			ofNullable(getWeatherStation()).ifPresent(builder::setWeatherStation);
			ofNullable(getWeatherStationFallback()).ifPresent(builder::setWeatherStationFallback);
			ofNullable(getWeatherStationSecondFallback()).ifPresent(builder::setWeatherStationSecondFallback);
			ofNullable(getAlternativeDataProvider()).ifPresent(builder::setAlternativeDataProvider);
			ofNullable(getSynopticDataFallback()).ifPresent(builder::setSynopticDataFallback);
			ofNullable(getAdjustmentToFallbackWeatherStation()).ifPresent(builder::setAdjustmentToFallbackWeatherStation);
			ofNullable(getPrimaryDisruptionFallbacks()).ifPresent(builder::setPrimaryDisruptionFallbacks);
			ofNullable(getSecondaryDisruptionFallbacks()).ifPresent(builder::setSecondaryDisruptionFallbacks);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndexData _that = getType().cast(o);
		
			if (!Objects.equals(referenceLevel, _that.getReferenceLevel())) return false;
			if (!Objects.equals(dataProvider, _that.getDataProvider())) return false;
			if (!Objects.equals(finalEditedData, _that.getFinalEditedData())) return false;
			if (!Objects.equals(weatherStation, _that.getWeatherStation())) return false;
			if (!Objects.equals(weatherStationFallback, _that.getWeatherStationFallback())) return false;
			if (!Objects.equals(weatherStationSecondFallback, _that.getWeatherStationSecondFallback())) return false;
			if (!Objects.equals(alternativeDataProvider, _that.getAlternativeDataProvider())) return false;
			if (!Objects.equals(synopticDataFallback, _that.getSynopticDataFallback())) return false;
			if (!Objects.equals(adjustmentToFallbackWeatherStation, _that.getAdjustmentToFallbackWeatherStation())) return false;
			if (!Objects.equals(primaryDisruptionFallbacks, _that.getPrimaryDisruptionFallbacks())) return false;
			if (!Objects.equals(secondaryDisruptionFallbacks, _that.getSecondaryDisruptionFallbacks())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceLevel != null ? referenceLevel.hashCode() : 0);
			_result = 31 * _result + (dataProvider != null ? dataProvider.hashCode() : 0);
			_result = 31 * _result + (finalEditedData != null ? finalEditedData.hashCode() : 0);
			_result = 31 * _result + (weatherStation != null ? weatherStation.hashCode() : 0);
			_result = 31 * _result + (weatherStationFallback != null ? weatherStationFallback.hashCode() : 0);
			_result = 31 * _result + (weatherStationSecondFallback != null ? weatherStationSecondFallback.hashCode() : 0);
			_result = 31 * _result + (alternativeDataProvider != null ? alternativeDataProvider.hashCode() : 0);
			_result = 31 * _result + (synopticDataFallback != null ? synopticDataFallback.hashCode() : 0);
			_result = 31 * _result + (adjustmentToFallbackWeatherStation != null ? adjustmentToFallbackWeatherStation.hashCode() : 0);
			_result = 31 * _result + (primaryDisruptionFallbacks != null ? primaryDisruptionFallbacks.hashCode() : 0);
			_result = 31 * _result + (secondaryDisruptionFallbacks != null ? secondaryDisruptionFallbacks.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndexData {" +
				"referenceLevel=" + this.referenceLevel + ", " +
				"dataProvider=" + this.dataProvider + ", " +
				"finalEditedData=" + this.finalEditedData + ", " +
				"weatherStation=" + this.weatherStation + ", " +
				"weatherStationFallback=" + this.weatherStationFallback + ", " +
				"weatherStationSecondFallback=" + this.weatherStationSecondFallback + ", " +
				"alternativeDataProvider=" + this.alternativeDataProvider + ", " +
				"synopticDataFallback=" + this.synopticDataFallback + ", " +
				"adjustmentToFallbackWeatherStation=" + this.adjustmentToFallbackWeatherStation + ", " +
				"primaryDisruptionFallbacks=" + this.primaryDisruptionFallbacks + ", " +
				"secondaryDisruptionFallbacks=" + this.secondaryDisruptionFallbacks +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherIndexData  ***********************/
	class WeatherIndexDataBuilderImpl implements WeatherIndexData.WeatherIndexDataBuilder {
	
		protected ReferenceLevel.ReferenceLevelBuilder referenceLevel;
		protected DataProvider.DataProviderBuilder dataProvider;
		protected Boolean finalEditedData;
		protected WeatherStation.WeatherStationBuilder weatherStation;
		protected WeatherStation.WeatherStationBuilder weatherStationFallback;
		protected WeatherStation.WeatherStationBuilder weatherStationSecondFallback;
		protected Boolean alternativeDataProvider;
		protected Boolean synopticDataFallback;
		protected Boolean adjustmentToFallbackWeatherStation;
		protected DisruptionFallback.DisruptionFallbackBuilder primaryDisruptionFallbacks;
		protected DisruptionFallback.DisruptionFallbackBuilder secondaryDisruptionFallbacks;
	
		public WeatherIndexDataBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("referenceLevel")
		public ReferenceLevel.ReferenceLevelBuilder getReferenceLevel() {
			return referenceLevel;
		}
		
		@Override
		public ReferenceLevel.ReferenceLevelBuilder getOrCreateReferenceLevel() {
			ReferenceLevel.ReferenceLevelBuilder result;
			if (referenceLevel!=null) {
				result = referenceLevel;
			}
			else {
				result = referenceLevel = ReferenceLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dataProvider")
		public DataProvider.DataProviderBuilder getDataProvider() {
			return dataProvider;
		}
		
		@Override
		public DataProvider.DataProviderBuilder getOrCreateDataProvider() {
			DataProvider.DataProviderBuilder result;
			if (dataProvider!=null) {
				result = dataProvider;
			}
			else {
				result = dataProvider = DataProvider.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalEditedData")
		public Boolean getFinalEditedData() {
			return finalEditedData;
		}
		
		@Override
		@RosettaAttribute("weatherStation")
		public WeatherStation.WeatherStationBuilder getWeatherStation() {
			return weatherStation;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder getOrCreateWeatherStation() {
			WeatherStation.WeatherStationBuilder result;
			if (weatherStation!=null) {
				result = weatherStation;
			}
			else {
				result = weatherStation = WeatherStation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationFallback")
		public WeatherStation.WeatherStationBuilder getWeatherStationFallback() {
			return weatherStationFallback;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder getOrCreateWeatherStationFallback() {
			WeatherStation.WeatherStationBuilder result;
			if (weatherStationFallback!=null) {
				result = weatherStationFallback;
			}
			else {
				result = weatherStationFallback = WeatherStation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationSecondFallback")
		public WeatherStation.WeatherStationBuilder getWeatherStationSecondFallback() {
			return weatherStationSecondFallback;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder getOrCreateWeatherStationSecondFallback() {
			WeatherStation.WeatherStationBuilder result;
			if (weatherStationSecondFallback!=null) {
				result = weatherStationSecondFallback;
			}
			else {
				result = weatherStationSecondFallback = WeatherStation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("alternativeDataProvider")
		public Boolean getAlternativeDataProvider() {
			return alternativeDataProvider;
		}
		
		@Override
		@RosettaAttribute("synopticDataFallback")
		public Boolean getSynopticDataFallback() {
			return synopticDataFallback;
		}
		
		@Override
		@RosettaAttribute("adjustmentToFallbackWeatherStation")
		public Boolean getAdjustmentToFallbackWeatherStation() {
			return adjustmentToFallbackWeatherStation;
		}
		
		@Override
		@RosettaAttribute("primaryDisruptionFallbacks")
		public DisruptionFallback.DisruptionFallbackBuilder getPrimaryDisruptionFallbacks() {
			return primaryDisruptionFallbacks;
		}
		
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder getOrCreatePrimaryDisruptionFallbacks() {
			DisruptionFallback.DisruptionFallbackBuilder result;
			if (primaryDisruptionFallbacks!=null) {
				result = primaryDisruptionFallbacks;
			}
			else {
				result = primaryDisruptionFallbacks = DisruptionFallback.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryDisruptionFallbacks")
		public DisruptionFallback.DisruptionFallbackBuilder getSecondaryDisruptionFallbacks() {
			return secondaryDisruptionFallbacks;
		}
		
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder getOrCreateSecondaryDisruptionFallbacks() {
			DisruptionFallback.DisruptionFallbackBuilder result;
			if (secondaryDisruptionFallbacks!=null) {
				result = secondaryDisruptionFallbacks;
			}
			else {
				result = secondaryDisruptionFallbacks = DisruptionFallback.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceLevel")
		public WeatherIndexData.WeatherIndexDataBuilder setReferenceLevel(ReferenceLevel referenceLevel) {
			this.referenceLevel = referenceLevel==null?null:referenceLevel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dataProvider")
		public WeatherIndexData.WeatherIndexDataBuilder setDataProvider(DataProvider dataProvider) {
			this.dataProvider = dataProvider==null?null:dataProvider.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finalEditedData")
		public WeatherIndexData.WeatherIndexDataBuilder setFinalEditedData(Boolean finalEditedData) {
			this.finalEditedData = finalEditedData==null?null:finalEditedData;
			return this;
		}
		@Override
		@RosettaAttribute("weatherStation")
		public WeatherIndexData.WeatherIndexDataBuilder setWeatherStation(WeatherStation weatherStation) {
			this.weatherStation = weatherStation==null?null:weatherStation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherStationFallback")
		public WeatherIndexData.WeatherIndexDataBuilder setWeatherStationFallback(WeatherStation weatherStationFallback) {
			this.weatherStationFallback = weatherStationFallback==null?null:weatherStationFallback.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherStationSecondFallback")
		public WeatherIndexData.WeatherIndexDataBuilder setWeatherStationSecondFallback(WeatherStation weatherStationSecondFallback) {
			this.weatherStationSecondFallback = weatherStationSecondFallback==null?null:weatherStationSecondFallback.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("alternativeDataProvider")
		public WeatherIndexData.WeatherIndexDataBuilder setAlternativeDataProvider(Boolean alternativeDataProvider) {
			this.alternativeDataProvider = alternativeDataProvider==null?null:alternativeDataProvider;
			return this;
		}
		@Override
		@RosettaAttribute("synopticDataFallback")
		public WeatherIndexData.WeatherIndexDataBuilder setSynopticDataFallback(Boolean synopticDataFallback) {
			this.synopticDataFallback = synopticDataFallback==null?null:synopticDataFallback;
			return this;
		}
		@Override
		@RosettaAttribute("adjustmentToFallbackWeatherStation")
		public WeatherIndexData.WeatherIndexDataBuilder setAdjustmentToFallbackWeatherStation(Boolean adjustmentToFallbackWeatherStation) {
			this.adjustmentToFallbackWeatherStation = adjustmentToFallbackWeatherStation==null?null:adjustmentToFallbackWeatherStation;
			return this;
		}
		@Override
		@RosettaAttribute("primaryDisruptionFallbacks")
		public WeatherIndexData.WeatherIndexDataBuilder setPrimaryDisruptionFallbacks(DisruptionFallback primaryDisruptionFallbacks) {
			this.primaryDisruptionFallbacks = primaryDisruptionFallbacks==null?null:primaryDisruptionFallbacks.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("secondaryDisruptionFallbacks")
		public WeatherIndexData.WeatherIndexDataBuilder setSecondaryDisruptionFallbacks(DisruptionFallback secondaryDisruptionFallbacks) {
			this.secondaryDisruptionFallbacks = secondaryDisruptionFallbacks==null?null:secondaryDisruptionFallbacks.toBuilder();
			return this;
		}
		
		@Override
		public WeatherIndexData build() {
			return new WeatherIndexData.WeatherIndexDataImpl(this);
		}
		
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder prune() {
			if (referenceLevel!=null && !referenceLevel.prune().hasData()) referenceLevel = null;
			if (dataProvider!=null && !dataProvider.prune().hasData()) dataProvider = null;
			if (weatherStation!=null && !weatherStation.prune().hasData()) weatherStation = null;
			if (weatherStationFallback!=null && !weatherStationFallback.prune().hasData()) weatherStationFallback = null;
			if (weatherStationSecondFallback!=null && !weatherStationSecondFallback.prune().hasData()) weatherStationSecondFallback = null;
			if (primaryDisruptionFallbacks!=null && !primaryDisruptionFallbacks.prune().hasData()) primaryDisruptionFallbacks = null;
			if (secondaryDisruptionFallbacks!=null && !secondaryDisruptionFallbacks.prune().hasData()) secondaryDisruptionFallbacks = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceLevel()!=null && getReferenceLevel().hasData()) return true;
			if (getDataProvider()!=null && getDataProvider().hasData()) return true;
			if (getFinalEditedData()!=null) return true;
			if (getWeatherStation()!=null && getWeatherStation().hasData()) return true;
			if (getWeatherStationFallback()!=null && getWeatherStationFallback().hasData()) return true;
			if (getWeatherStationSecondFallback()!=null && getWeatherStationSecondFallback().hasData()) return true;
			if (getAlternativeDataProvider()!=null) return true;
			if (getSynopticDataFallback()!=null) return true;
			if (getAdjustmentToFallbackWeatherStation()!=null) return true;
			if (getPrimaryDisruptionFallbacks()!=null && getPrimaryDisruptionFallbacks().hasData()) return true;
			if (getSecondaryDisruptionFallbacks()!=null && getSecondaryDisruptionFallbacks().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherIndexData.WeatherIndexDataBuilder o = (WeatherIndexData.WeatherIndexDataBuilder) other;
			
			merger.mergeRosetta(getReferenceLevel(), o.getReferenceLevel(), this::setReferenceLevel);
			merger.mergeRosetta(getDataProvider(), o.getDataProvider(), this::setDataProvider);
			merger.mergeRosetta(getWeatherStation(), o.getWeatherStation(), this::setWeatherStation);
			merger.mergeRosetta(getWeatherStationFallback(), o.getWeatherStationFallback(), this::setWeatherStationFallback);
			merger.mergeRosetta(getWeatherStationSecondFallback(), o.getWeatherStationSecondFallback(), this::setWeatherStationSecondFallback);
			merger.mergeRosetta(getPrimaryDisruptionFallbacks(), o.getPrimaryDisruptionFallbacks(), this::setPrimaryDisruptionFallbacks);
			merger.mergeRosetta(getSecondaryDisruptionFallbacks(), o.getSecondaryDisruptionFallbacks(), this::setSecondaryDisruptionFallbacks);
			
			merger.mergeBasic(getFinalEditedData(), o.getFinalEditedData(), this::setFinalEditedData);
			merger.mergeBasic(getAlternativeDataProvider(), o.getAlternativeDataProvider(), this::setAlternativeDataProvider);
			merger.mergeBasic(getSynopticDataFallback(), o.getSynopticDataFallback(), this::setSynopticDataFallback);
			merger.mergeBasic(getAdjustmentToFallbackWeatherStation(), o.getAdjustmentToFallbackWeatherStation(), this::setAdjustmentToFallbackWeatherStation);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndexData _that = getType().cast(o);
		
			if (!Objects.equals(referenceLevel, _that.getReferenceLevel())) return false;
			if (!Objects.equals(dataProvider, _that.getDataProvider())) return false;
			if (!Objects.equals(finalEditedData, _that.getFinalEditedData())) return false;
			if (!Objects.equals(weatherStation, _that.getWeatherStation())) return false;
			if (!Objects.equals(weatherStationFallback, _that.getWeatherStationFallback())) return false;
			if (!Objects.equals(weatherStationSecondFallback, _that.getWeatherStationSecondFallback())) return false;
			if (!Objects.equals(alternativeDataProvider, _that.getAlternativeDataProvider())) return false;
			if (!Objects.equals(synopticDataFallback, _that.getSynopticDataFallback())) return false;
			if (!Objects.equals(adjustmentToFallbackWeatherStation, _that.getAdjustmentToFallbackWeatherStation())) return false;
			if (!Objects.equals(primaryDisruptionFallbacks, _that.getPrimaryDisruptionFallbacks())) return false;
			if (!Objects.equals(secondaryDisruptionFallbacks, _that.getSecondaryDisruptionFallbacks())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceLevel != null ? referenceLevel.hashCode() : 0);
			_result = 31 * _result + (dataProvider != null ? dataProvider.hashCode() : 0);
			_result = 31 * _result + (finalEditedData != null ? finalEditedData.hashCode() : 0);
			_result = 31 * _result + (weatherStation != null ? weatherStation.hashCode() : 0);
			_result = 31 * _result + (weatherStationFallback != null ? weatherStationFallback.hashCode() : 0);
			_result = 31 * _result + (weatherStationSecondFallback != null ? weatherStationSecondFallback.hashCode() : 0);
			_result = 31 * _result + (alternativeDataProvider != null ? alternativeDataProvider.hashCode() : 0);
			_result = 31 * _result + (synopticDataFallback != null ? synopticDataFallback.hashCode() : 0);
			_result = 31 * _result + (adjustmentToFallbackWeatherStation != null ? adjustmentToFallbackWeatherStation.hashCode() : 0);
			_result = 31 * _result + (primaryDisruptionFallbacks != null ? primaryDisruptionFallbacks.hashCode() : 0);
			_result = 31 * _result + (secondaryDisruptionFallbacks != null ? secondaryDisruptionFallbacks.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndexDataBuilder {" +
				"referenceLevel=" + this.referenceLevel + ", " +
				"dataProvider=" + this.dataProvider + ", " +
				"finalEditedData=" + this.finalEditedData + ", " +
				"weatherStation=" + this.weatherStation + ", " +
				"weatherStationFallback=" + this.weatherStationFallback + ", " +
				"weatherStationSecondFallback=" + this.weatherStationSecondFallback + ", " +
				"alternativeDataProvider=" + this.alternativeDataProvider + ", " +
				"synopticDataFallback=" + this.synopticDataFallback + ", " +
				"adjustmentToFallbackWeatherStation=" + this.adjustmentToFallbackWeatherStation + ", " +
				"primaryDisruptionFallbacks=" + this.primaryDisruptionFallbacks + ", " +
				"secondaryDisruptionFallbacks=" + this.secondaryDisruptionFallbacks +
			'}';
		}
	}
}
