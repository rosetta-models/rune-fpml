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
import fpml.confirmation.WeatherStationWMO;
import fpml.confirmation.WeatherStationWMO.WeatherStationWMOBuilder;
import fpml.confirmation.WeatherStationWMO.WeatherStationWMOBuilderImpl;
import fpml.confirmation.WeatherStationWMO.WeatherStationWMOImpl;
import fpml.confirmation.meta.WeatherStationWMOMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A code identifying a Weather Index WMO.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="WeatherStationWMO", builder=WeatherStationWMO.WeatherStationWMOBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface WeatherStationWMO extends RosettaModelObject {

	WeatherStationWMOMeta metaData = new WeatherStationWMOMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getWeatherStationWMOScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	WeatherStationWMO build();
	
	WeatherStationWMO.WeatherStationWMOBuilder toBuilder();
	
	static WeatherStationWMO.WeatherStationWMOBuilder builder() {
		return new WeatherStationWMO.WeatherStationWMOBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherStationWMO> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherStationWMO> getType() {
		return WeatherStationWMO.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("weatherStationWMOScheme"), String.class, getWeatherStationWMOScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherStationWMOBuilder extends WeatherStationWMO, RosettaModelObjectBuilder {
		WeatherStationWMO.WeatherStationWMOBuilder setValue(String value);
		WeatherStationWMO.WeatherStationWMOBuilder setWeatherStationWMOScheme(String weatherStationWMOScheme);
		WeatherStationWMO.WeatherStationWMOBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("weatherStationWMOScheme"), String.class, getWeatherStationWMOScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		WeatherStationWMO.WeatherStationWMOBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherStationWMO  ***********************/
	class WeatherStationWMOImpl implements WeatherStationWMO {
		private final String value;
		private final String weatherStationWMOScheme;
		private final String id;
		
		protected WeatherStationWMOImpl(WeatherStationWMO.WeatherStationWMOBuilder builder) {
			this.value = builder.getValue();
			this.weatherStationWMOScheme = builder.getWeatherStationWMOScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherStationWMOScheme")
		public String getWeatherStationWMOScheme() {
			return weatherStationWMOScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public WeatherStationWMO build() {
			return this;
		}
		
		@Override
		public WeatherStationWMO.WeatherStationWMOBuilder toBuilder() {
			WeatherStationWMO.WeatherStationWMOBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherStationWMO.WeatherStationWMOBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWeatherStationWMOScheme()).ifPresent(builder::setWeatherStationWMOScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationWMO _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationWMOScheme, _that.getWeatherStationWMOScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationWMOScheme != null ? weatherStationWMOScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationWMO {" +
				"value=" + this.value + ", " +
				"weatherStationWMOScheme=" + this.weatherStationWMOScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherStationWMO  ***********************/
	class WeatherStationWMOBuilderImpl implements WeatherStationWMO.WeatherStationWMOBuilder {
	
		protected String value;
		protected String weatherStationWMOScheme;
		protected String id;
	
		public WeatherStationWMOBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherStationWMOScheme")
		public String getWeatherStationWMOScheme() {
			return weatherStationWMOScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public WeatherStationWMO.WeatherStationWMOBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("weatherStationWMOScheme")
		public WeatherStationWMO.WeatherStationWMOBuilder setWeatherStationWMOScheme(String weatherStationWMOScheme) {
			this.weatherStationWMOScheme = weatherStationWMOScheme==null?null:weatherStationWMOScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public WeatherStationWMO.WeatherStationWMOBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public WeatherStationWMO build() {
			return new WeatherStationWMO.WeatherStationWMOImpl(this);
		}
		
		@Override
		public WeatherStationWMO.WeatherStationWMOBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationWMO.WeatherStationWMOBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWeatherStationWMOScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationWMO.WeatherStationWMOBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherStationWMO.WeatherStationWMOBuilder o = (WeatherStationWMO.WeatherStationWMOBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWeatherStationWMOScheme(), o.getWeatherStationWMOScheme(), this::setWeatherStationWMOScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationWMO _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationWMOScheme, _that.getWeatherStationWMOScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationWMOScheme != null ? weatherStationWMOScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationWMOBuilder {" +
				"value=" + this.value + ", " +
				"weatherStationWMOScheme=" + this.weatherStationWMOScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
