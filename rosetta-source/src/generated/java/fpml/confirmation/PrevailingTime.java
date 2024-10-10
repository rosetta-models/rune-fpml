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
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.PrevailingTime.PrevailingTimeBuilder;
import fpml.confirmation.PrevailingTime.PrevailingTimeBuilderImpl;
import fpml.confirmation.PrevailingTime.PrevailingTimeImpl;
import fpml.confirmation.TimezoneLocation;
import fpml.confirmation.meta.PrevailingTimeMeta;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining a time with respect to a geographic location, for example 11:00 Phoenix, USA. This type should be used where a wider range of locations than those available as business centres is required.
 * @version ${project.version}
 */
@RosettaDataType(value="PrevailingTime", builder=PrevailingTime.PrevailingTimeBuilderImpl.class, version="${project.version}")
public interface PrevailingTime extends RosettaModelObject {

	PrevailingTimeMeta metaData = new PrevailingTimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A time specified in hh:mm:ss format where the second component must be &#39;00&#39;, e.g. 11am would be represented as 11:00:00.
	 */
	LocalTime getHourMinuteTime();
	/**
	 * The geographic location to which the hourMinuteTime applies. The time takes into account any current day light saving changes or other adjustments i.e. it is the prevaling time at the location.
	 */
	TimezoneLocation getLocation();

	/*********************** Build Methods  ***********************/
	PrevailingTime build();
	
	PrevailingTime.PrevailingTimeBuilder toBuilder();
	
	static PrevailingTime.PrevailingTimeBuilder builder() {
		return new PrevailingTime.PrevailingTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrevailingTime> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrevailingTime> getType() {
		return PrevailingTime.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
		processRosetta(path.newSubPath("location"), processor, TimezoneLocation.class, getLocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrevailingTimeBuilder extends PrevailingTime, RosettaModelObjectBuilder {
		TimezoneLocation.TimezoneLocationBuilder getOrCreateLocation();
		TimezoneLocation.TimezoneLocationBuilder getLocation();
		PrevailingTime.PrevailingTimeBuilder setHourMinuteTime(LocalTime hourMinuteTime);
		PrevailingTime.PrevailingTimeBuilder setLocation(TimezoneLocation location);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
			processRosetta(path.newSubPath("location"), processor, TimezoneLocation.TimezoneLocationBuilder.class, getLocation());
		}
		

		PrevailingTime.PrevailingTimeBuilder prune();
	}

	/*********************** Immutable Implementation of PrevailingTime  ***********************/
	class PrevailingTimeImpl implements PrevailingTime {
		private final LocalTime hourMinuteTime;
		private final TimezoneLocation location;
		
		protected PrevailingTimeImpl(PrevailingTime.PrevailingTimeBuilder builder) {
			this.hourMinuteTime = builder.getHourMinuteTime();
			this.location = ofNullable(builder.getLocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("hourMinuteTime")
		public LocalTime getHourMinuteTime() {
			return hourMinuteTime;
		}
		
		@Override
		@RosettaAttribute("location")
		public TimezoneLocation getLocation() {
			return location;
		}
		
		@Override
		public PrevailingTime build() {
			return this;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder toBuilder() {
			PrevailingTime.PrevailingTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrevailingTime.PrevailingTimeBuilder builder) {
			ofNullable(getHourMinuteTime()).ifPresent(builder::setHourMinuteTime);
			ofNullable(getLocation()).ifPresent(builder::setLocation);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrevailingTime _that = getType().cast(o);
		
			if (!Objects.equals(hourMinuteTime, _that.getHourMinuteTime())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (hourMinuteTime != null ? hourMinuteTime.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrevailingTime {" +
				"hourMinuteTime=" + this.hourMinuteTime + ", " +
				"location=" + this.location +
			'}';
		}
	}

	/*********************** Builder Implementation of PrevailingTime  ***********************/
	class PrevailingTimeBuilderImpl implements PrevailingTime.PrevailingTimeBuilder {
	
		protected LocalTime hourMinuteTime;
		protected TimezoneLocation.TimezoneLocationBuilder location;
	
		public PrevailingTimeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("hourMinuteTime")
		public LocalTime getHourMinuteTime() {
			return hourMinuteTime;
		}
		
		@Override
		@RosettaAttribute("location")
		public TimezoneLocation.TimezoneLocationBuilder getLocation() {
			return location;
		}
		
		@Override
		public TimezoneLocation.TimezoneLocationBuilder getOrCreateLocation() {
			TimezoneLocation.TimezoneLocationBuilder result;
			if (location!=null) {
				result = location;
			}
			else {
				result = location = TimezoneLocation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("hourMinuteTime")
		public PrevailingTime.PrevailingTimeBuilder setHourMinuteTime(LocalTime hourMinuteTime) {
			this.hourMinuteTime = hourMinuteTime==null?null:hourMinuteTime;
			return this;
		}
		@Override
		@RosettaAttribute("location")
		public PrevailingTime.PrevailingTimeBuilder setLocation(TimezoneLocation location) {
			this.location = location==null?null:location.toBuilder();
			return this;
		}
		
		@Override
		public PrevailingTime build() {
			return new PrevailingTime.PrevailingTimeImpl(this);
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrevailingTime.PrevailingTimeBuilder prune() {
			if (location!=null && !location.prune().hasData()) location = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHourMinuteTime()!=null) return true;
			if (getLocation()!=null && getLocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrevailingTime.PrevailingTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrevailingTime.PrevailingTimeBuilder o = (PrevailingTime.PrevailingTimeBuilder) other;
			
			merger.mergeRosetta(getLocation(), o.getLocation(), this::setLocation);
			
			merger.mergeBasic(getHourMinuteTime(), o.getHourMinuteTime(), this::setHourMinuteTime);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrevailingTime _that = getType().cast(o);
		
			if (!Objects.equals(hourMinuteTime, _that.getHourMinuteTime())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (hourMinuteTime != null ? hourMinuteTime.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrevailingTimeBuilder {" +
				"hourMinuteTime=" + this.hourMinuteTime + ", " +
				"location=" + this.location +
			'}';
		}
	}
}
