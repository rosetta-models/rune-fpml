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
import fpml.confirmation.WeatherStation;
import fpml.confirmation.WeatherStation.WeatherStationBuilder;
import fpml.confirmation.WeatherStation.WeatherStationBuilderImpl;
import fpml.confirmation.WeatherStation.WeatherStationImpl;
import fpml.confirmation.WeatherStationAirport;
import fpml.confirmation.WeatherStationWBAN;
import fpml.confirmation.WeatherStationWMO;
import fpml.confirmation.meta.WeatherStationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Weather Station.
 * @version ${project.version}
 */
@RosettaDataType(value="WeatherStation", builder=WeatherStation.WeatherStationBuilderImpl.class, version="${project.version}")
public interface WeatherStation extends RosettaModelObject {

	WeatherStationMeta metaData = new WeatherStationMeta();

	/*********************** Getter Methods  ***********************/
	BusinessCenter getWeatherStationCity();
	WeatherStationAirport getWeatherStationAirport();
	WeatherStationWBAN getWeatherStationWBAN();
	WeatherStationWMO getWeatherStationWMO();

	/*********************** Build Methods  ***********************/
	WeatherStation build();
	
	WeatherStation.WeatherStationBuilder toBuilder();
	
	static WeatherStation.WeatherStationBuilder builder() {
		return new WeatherStation.WeatherStationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherStation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherStation> getType() {
		return WeatherStation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("weatherStationCity"), processor, BusinessCenter.class, getWeatherStationCity());
		processRosetta(path.newSubPath("weatherStationAirport"), processor, WeatherStationAirport.class, getWeatherStationAirport());
		processRosetta(path.newSubPath("weatherStationWBAN"), processor, WeatherStationWBAN.class, getWeatherStationWBAN());
		processRosetta(path.newSubPath("weatherStationWMO"), processor, WeatherStationWMO.class, getWeatherStationWMO());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherStationBuilder extends WeatherStation, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder getOrCreateWeatherStationCity();
		BusinessCenter.BusinessCenterBuilder getWeatherStationCity();
		WeatherStationAirport.WeatherStationAirportBuilder getOrCreateWeatherStationAirport();
		WeatherStationAirport.WeatherStationAirportBuilder getWeatherStationAirport();
		WeatherStationWBAN.WeatherStationWBANBuilder getOrCreateWeatherStationWBAN();
		WeatherStationWBAN.WeatherStationWBANBuilder getWeatherStationWBAN();
		WeatherStationWMO.WeatherStationWMOBuilder getOrCreateWeatherStationWMO();
		WeatherStationWMO.WeatherStationWMOBuilder getWeatherStationWMO();
		WeatherStation.WeatherStationBuilder setWeatherStationCity(BusinessCenter weatherStationCity);
		WeatherStation.WeatherStationBuilder setWeatherStationAirport(WeatherStationAirport weatherStationAirport);
		WeatherStation.WeatherStationBuilder setWeatherStationWBAN(WeatherStationWBAN weatherStationWBAN);
		WeatherStation.WeatherStationBuilder setWeatherStationWMO(WeatherStationWMO weatherStationWMO);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("weatherStationCity"), processor, BusinessCenter.BusinessCenterBuilder.class, getWeatherStationCity());
			processRosetta(path.newSubPath("weatherStationAirport"), processor, WeatherStationAirport.WeatherStationAirportBuilder.class, getWeatherStationAirport());
			processRosetta(path.newSubPath("weatherStationWBAN"), processor, WeatherStationWBAN.WeatherStationWBANBuilder.class, getWeatherStationWBAN());
			processRosetta(path.newSubPath("weatherStationWMO"), processor, WeatherStationWMO.WeatherStationWMOBuilder.class, getWeatherStationWMO());
		}
		

		WeatherStation.WeatherStationBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherStation  ***********************/
	class WeatherStationImpl implements WeatherStation {
		private final BusinessCenter weatherStationCity;
		private final WeatherStationAirport weatherStationAirport;
		private final WeatherStationWBAN weatherStationWBAN;
		private final WeatherStationWMO weatherStationWMO;
		
		protected WeatherStationImpl(WeatherStation.WeatherStationBuilder builder) {
			this.weatherStationCity = ofNullable(builder.getWeatherStationCity()).map(f->f.build()).orElse(null);
			this.weatherStationAirport = ofNullable(builder.getWeatherStationAirport()).map(f->f.build()).orElse(null);
			this.weatherStationWBAN = ofNullable(builder.getWeatherStationWBAN()).map(f->f.build()).orElse(null);
			this.weatherStationWMO = ofNullable(builder.getWeatherStationWMO()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("weatherStationCity")
		public BusinessCenter getWeatherStationCity() {
			return weatherStationCity;
		}
		
		@Override
		@RosettaAttribute("weatherStationAirport")
		public WeatherStationAirport getWeatherStationAirport() {
			return weatherStationAirport;
		}
		
		@Override
		@RosettaAttribute("weatherStationWBAN")
		public WeatherStationWBAN getWeatherStationWBAN() {
			return weatherStationWBAN;
		}
		
		@Override
		@RosettaAttribute("weatherStationWMO")
		public WeatherStationWMO getWeatherStationWMO() {
			return weatherStationWMO;
		}
		
		@Override
		public WeatherStation build() {
			return this;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder toBuilder() {
			WeatherStation.WeatherStationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherStation.WeatherStationBuilder builder) {
			ofNullable(getWeatherStationCity()).ifPresent(builder::setWeatherStationCity);
			ofNullable(getWeatherStationAirport()).ifPresent(builder::setWeatherStationAirport);
			ofNullable(getWeatherStationWBAN()).ifPresent(builder::setWeatherStationWBAN);
			ofNullable(getWeatherStationWMO()).ifPresent(builder::setWeatherStationWMO);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStation _that = getType().cast(o);
		
			if (!Objects.equals(weatherStationCity, _that.getWeatherStationCity())) return false;
			if (!Objects.equals(weatherStationAirport, _that.getWeatherStationAirport())) return false;
			if (!Objects.equals(weatherStationWBAN, _that.getWeatherStationWBAN())) return false;
			if (!Objects.equals(weatherStationWMO, _that.getWeatherStationWMO())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weatherStationCity != null ? weatherStationCity.hashCode() : 0);
			_result = 31 * _result + (weatherStationAirport != null ? weatherStationAirport.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBAN != null ? weatherStationWBAN.hashCode() : 0);
			_result = 31 * _result + (weatherStationWMO != null ? weatherStationWMO.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStation {" +
				"weatherStationCity=" + this.weatherStationCity + ", " +
				"weatherStationAirport=" + this.weatherStationAirport + ", " +
				"weatherStationWBAN=" + this.weatherStationWBAN + ", " +
				"weatherStationWMO=" + this.weatherStationWMO +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherStation  ***********************/
	class WeatherStationBuilderImpl implements WeatherStation.WeatherStationBuilder {
	
		protected BusinessCenter.BusinessCenterBuilder weatherStationCity;
		protected WeatherStationAirport.WeatherStationAirportBuilder weatherStationAirport;
		protected WeatherStationWBAN.WeatherStationWBANBuilder weatherStationWBAN;
		protected WeatherStationWMO.WeatherStationWMOBuilder weatherStationWMO;
	
		public WeatherStationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("weatherStationCity")
		public BusinessCenter.BusinessCenterBuilder getWeatherStationCity() {
			return weatherStationCity;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateWeatherStationCity() {
			BusinessCenter.BusinessCenterBuilder result;
			if (weatherStationCity!=null) {
				result = weatherStationCity;
			}
			else {
				result = weatherStationCity = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationAirport")
		public WeatherStationAirport.WeatherStationAirportBuilder getWeatherStationAirport() {
			return weatherStationAirport;
		}
		
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder getOrCreateWeatherStationAirport() {
			WeatherStationAirport.WeatherStationAirportBuilder result;
			if (weatherStationAirport!=null) {
				result = weatherStationAirport;
			}
			else {
				result = weatherStationAirport = WeatherStationAirport.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationWBAN")
		public WeatherStationWBAN.WeatherStationWBANBuilder getWeatherStationWBAN() {
			return weatherStationWBAN;
		}
		
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder getOrCreateWeatherStationWBAN() {
			WeatherStationWBAN.WeatherStationWBANBuilder result;
			if (weatherStationWBAN!=null) {
				result = weatherStationWBAN;
			}
			else {
				result = weatherStationWBAN = WeatherStationWBAN.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationWMO")
		public WeatherStationWMO.WeatherStationWMOBuilder getWeatherStationWMO() {
			return weatherStationWMO;
		}
		
		@Override
		public WeatherStationWMO.WeatherStationWMOBuilder getOrCreateWeatherStationWMO() {
			WeatherStationWMO.WeatherStationWMOBuilder result;
			if (weatherStationWMO!=null) {
				result = weatherStationWMO;
			}
			else {
				result = weatherStationWMO = WeatherStationWMO.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationCity")
		public WeatherStation.WeatherStationBuilder setWeatherStationCity(BusinessCenter weatherStationCity) {
			this.weatherStationCity = weatherStationCity==null?null:weatherStationCity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherStationAirport")
		public WeatherStation.WeatherStationBuilder setWeatherStationAirport(WeatherStationAirport weatherStationAirport) {
			this.weatherStationAirport = weatherStationAirport==null?null:weatherStationAirport.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherStationWBAN")
		public WeatherStation.WeatherStationBuilder setWeatherStationWBAN(WeatherStationWBAN weatherStationWBAN) {
			this.weatherStationWBAN = weatherStationWBAN==null?null:weatherStationWBAN.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherStationWMO")
		public WeatherStation.WeatherStationBuilder setWeatherStationWMO(WeatherStationWMO weatherStationWMO) {
			this.weatherStationWMO = weatherStationWMO==null?null:weatherStationWMO.toBuilder();
			return this;
		}
		
		@Override
		public WeatherStation build() {
			return new WeatherStation.WeatherStationImpl(this);
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStation.WeatherStationBuilder prune() {
			if (weatherStationCity!=null && !weatherStationCity.prune().hasData()) weatherStationCity = null;
			if (weatherStationAirport!=null && !weatherStationAirport.prune().hasData()) weatherStationAirport = null;
			if (weatherStationWBAN!=null && !weatherStationWBAN.prune().hasData()) weatherStationWBAN = null;
			if (weatherStationWMO!=null && !weatherStationWMO.prune().hasData()) weatherStationWMO = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getWeatherStationCity()!=null && getWeatherStationCity().hasData()) return true;
			if (getWeatherStationAirport()!=null && getWeatherStationAirport().hasData()) return true;
			if (getWeatherStationWBAN()!=null && getWeatherStationWBAN().hasData()) return true;
			if (getWeatherStationWMO()!=null && getWeatherStationWMO().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStation.WeatherStationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherStation.WeatherStationBuilder o = (WeatherStation.WeatherStationBuilder) other;
			
			merger.mergeRosetta(getWeatherStationCity(), o.getWeatherStationCity(), this::setWeatherStationCity);
			merger.mergeRosetta(getWeatherStationAirport(), o.getWeatherStationAirport(), this::setWeatherStationAirport);
			merger.mergeRosetta(getWeatherStationWBAN(), o.getWeatherStationWBAN(), this::setWeatherStationWBAN);
			merger.mergeRosetta(getWeatherStationWMO(), o.getWeatherStationWMO(), this::setWeatherStationWMO);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStation _that = getType().cast(o);
		
			if (!Objects.equals(weatherStationCity, _that.getWeatherStationCity())) return false;
			if (!Objects.equals(weatherStationAirport, _that.getWeatherStationAirport())) return false;
			if (!Objects.equals(weatherStationWBAN, _that.getWeatherStationWBAN())) return false;
			if (!Objects.equals(weatherStationWMO, _that.getWeatherStationWMO())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weatherStationCity != null ? weatherStationCity.hashCode() : 0);
			_result = 31 * _result + (weatherStationAirport != null ? weatherStationAirport.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBAN != null ? weatherStationWBAN.hashCode() : 0);
			_result = 31 * _result + (weatherStationWMO != null ? weatherStationWMO.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationBuilder {" +
				"weatherStationCity=" + this.weatherStationCity + ", " +
				"weatherStationAirport=" + this.weatherStationAirport + ", " +
				"weatherStationWBAN=" + this.weatherStationWBAN + ", " +
				"weatherStationWMO=" + this.weatherStationWMO +
			'}';
		}
	}
}
