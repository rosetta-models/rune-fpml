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
import fpml.confirmation.WeatherStationWBAN;
import fpml.confirmation.WeatherStationWBAN.WeatherStationWBANBuilder;
import fpml.confirmation.WeatherStationWBAN.WeatherStationWBANBuilderImpl;
import fpml.confirmation.WeatherStationWBAN.WeatherStationWBANImpl;
import fpml.confirmation.meta.WeatherStationWBANMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A code identifying a Weather Station WBAN.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="WeatherStationWBAN", builder=WeatherStationWBAN.WeatherStationWBANBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface WeatherStationWBAN extends RosettaModelObject {

	WeatherStationWBANMeta metaData = new WeatherStationWBANMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getWeatherStationWBANScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	WeatherStationWBAN build();
	
	WeatherStationWBAN.WeatherStationWBANBuilder toBuilder();
	
	static WeatherStationWBAN.WeatherStationWBANBuilder builder() {
		return new WeatherStationWBAN.WeatherStationWBANBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherStationWBAN> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherStationWBAN> getType() {
		return WeatherStationWBAN.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("weatherStationWBANScheme"), String.class, getWeatherStationWBANScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherStationWBANBuilder extends WeatherStationWBAN, RosettaModelObjectBuilder {
		WeatherStationWBAN.WeatherStationWBANBuilder setValue(String value);
		WeatherStationWBAN.WeatherStationWBANBuilder setWeatherStationWBANScheme(String weatherStationWBANScheme);
		WeatherStationWBAN.WeatherStationWBANBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("weatherStationWBANScheme"), String.class, getWeatherStationWBANScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		WeatherStationWBAN.WeatherStationWBANBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherStationWBAN  ***********************/
	class WeatherStationWBANImpl implements WeatherStationWBAN {
		private final String value;
		private final String weatherStationWBANScheme;
		private final String id;
		
		protected WeatherStationWBANImpl(WeatherStationWBAN.WeatherStationWBANBuilder builder) {
			this.value = builder.getValue();
			this.weatherStationWBANScheme = builder.getWeatherStationWBANScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherStationWBANScheme")
		public String getWeatherStationWBANScheme() {
			return weatherStationWBANScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public WeatherStationWBAN build() {
			return this;
		}
		
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder toBuilder() {
			WeatherStationWBAN.WeatherStationWBANBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherStationWBAN.WeatherStationWBANBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWeatherStationWBANScheme()).ifPresent(builder::setWeatherStationWBANScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationWBAN _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationWBANScheme, _that.getWeatherStationWBANScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBANScheme != null ? weatherStationWBANScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationWBAN {" +
				"value=" + this.value + ", " +
				"weatherStationWBANScheme=" + this.weatherStationWBANScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherStationWBAN  ***********************/
	class WeatherStationWBANBuilderImpl implements WeatherStationWBAN.WeatherStationWBANBuilder {
	
		protected String value;
		protected String weatherStationWBANScheme;
		protected String id;
	
		public WeatherStationWBANBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherStationWBANScheme")
		public String getWeatherStationWBANScheme() {
			return weatherStationWBANScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public WeatherStationWBAN.WeatherStationWBANBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("weatherStationWBANScheme")
		public WeatherStationWBAN.WeatherStationWBANBuilder setWeatherStationWBANScheme(String weatherStationWBANScheme) {
			this.weatherStationWBANScheme = weatherStationWBANScheme==null?null:weatherStationWBANScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public WeatherStationWBAN.WeatherStationWBANBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public WeatherStationWBAN build() {
			return new WeatherStationWBAN.WeatherStationWBANImpl(this);
		}
		
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWeatherStationWBANScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherStationWBAN.WeatherStationWBANBuilder o = (WeatherStationWBAN.WeatherStationWBANBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWeatherStationWBANScheme(), o.getWeatherStationWBANScheme(), this::setWeatherStationWBANScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationWBAN _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationWBANScheme, _that.getWeatherStationWBANScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBANScheme != null ? weatherStationWBANScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationWBANBuilder {" +
				"value=" + this.value + ", " +
				"weatherStationWBANScheme=" + this.weatherStationWBANScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
