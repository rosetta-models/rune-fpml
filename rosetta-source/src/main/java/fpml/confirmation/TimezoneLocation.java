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
import fpml.confirmation.TimezoneLocation;
import fpml.confirmation.TimezoneLocation.TimezoneLocationBuilder;
import fpml.confirmation.TimezoneLocation.TimezoneLocationBuilderImpl;
import fpml.confirmation.TimezoneLocation.TimezoneLocationImpl;
import fpml.confirmation.meta.TimezoneLocationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A geophraphic location for the purposes of defining a prevailing time according to the tz database.
 * @version ${project.version}
 */
@RosettaDataType(value="TimezoneLocation", builder=TimezoneLocation.TimezoneLocationBuilderImpl.class, version="${project.version}")
public interface TimezoneLocation extends RosettaModelObject {

	TimezoneLocationMeta metaData = new TimezoneLocationMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTimezoneLocationScheme();

	/*********************** Build Methods  ***********************/
	TimezoneLocation build();
	
	TimezoneLocation.TimezoneLocationBuilder toBuilder();
	
	static TimezoneLocation.TimezoneLocationBuilder builder() {
		return new TimezoneLocation.TimezoneLocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TimezoneLocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TimezoneLocation> getType() {
		return TimezoneLocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("timezoneLocationScheme"), String.class, getTimezoneLocationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TimezoneLocationBuilder extends TimezoneLocation, RosettaModelObjectBuilder {
		TimezoneLocation.TimezoneLocationBuilder setValue(String value);
		TimezoneLocation.TimezoneLocationBuilder setTimezoneLocationScheme(String timezoneLocationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("timezoneLocationScheme"), String.class, getTimezoneLocationScheme(), this);
		}
		

		TimezoneLocation.TimezoneLocationBuilder prune();
	}

	/*********************** Immutable Implementation of TimezoneLocation  ***********************/
	class TimezoneLocationImpl implements TimezoneLocation {
		private final String value;
		private final String timezoneLocationScheme;
		
		protected TimezoneLocationImpl(TimezoneLocation.TimezoneLocationBuilder builder) {
			this.value = builder.getValue();
			this.timezoneLocationScheme = builder.getTimezoneLocationScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("timezoneLocationScheme")
		public String getTimezoneLocationScheme() {
			return timezoneLocationScheme;
		}
		
		@Override
		public TimezoneLocation build() {
			return this;
		}
		
		@Override
		public TimezoneLocation.TimezoneLocationBuilder toBuilder() {
			TimezoneLocation.TimezoneLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimezoneLocation.TimezoneLocationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTimezoneLocationScheme()).ifPresent(builder::setTimezoneLocationScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimezoneLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(timezoneLocationScheme, _that.getTimezoneLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (timezoneLocationScheme != null ? timezoneLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimezoneLocation {" +
				"value=" + this.value + ", " +
				"timezoneLocationScheme=" + this.timezoneLocationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TimezoneLocation  ***********************/
	class TimezoneLocationBuilderImpl implements TimezoneLocation.TimezoneLocationBuilder {
	
		protected String value;
		protected String timezoneLocationScheme;
	
		public TimezoneLocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("timezoneLocationScheme")
		public String getTimezoneLocationScheme() {
			return timezoneLocationScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public TimezoneLocation.TimezoneLocationBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("timezoneLocationScheme")
		public TimezoneLocation.TimezoneLocationBuilder setTimezoneLocationScheme(String timezoneLocationScheme) {
			this.timezoneLocationScheme = timezoneLocationScheme==null?null:timezoneLocationScheme;
			return this;
		}
		
		@Override
		public TimezoneLocation build() {
			return new TimezoneLocation.TimezoneLocationImpl(this);
		}
		
		@Override
		public TimezoneLocation.TimezoneLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimezoneLocation.TimezoneLocationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTimezoneLocationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimezoneLocation.TimezoneLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimezoneLocation.TimezoneLocationBuilder o = (TimezoneLocation.TimezoneLocationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTimezoneLocationScheme(), o.getTimezoneLocationScheme(), this::setTimezoneLocationScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimezoneLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(timezoneLocationScheme, _that.getTimezoneLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (timezoneLocationScheme != null ? timezoneLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimezoneLocationBuilder {" +
				"value=" + this.value + ", " +
				"timezoneLocationScheme=" + this.timezoneLocationScheme +
			'}';
		}
	}
}
