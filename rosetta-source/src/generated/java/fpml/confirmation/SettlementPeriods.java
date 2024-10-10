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
import fpml.confirmation.CommodityBusinessCalendar;
import fpml.confirmation.DayOfWeekExtEnum;
import fpml.confirmation.OffsetPrevailingTime;
import fpml.confirmation.SettlementPeriodDurationEnum;
import fpml.confirmation.SettlementPeriods;
import fpml.confirmation.SettlementPeriods.SettlementPeriodsBuilder;
import fpml.confirmation.SettlementPeriods.SettlementPeriodsBuilderImpl;
import fpml.confirmation.SettlementPeriods.SettlementPeriodsImpl;
import fpml.confirmation.meta.SettlementPeriodsMeta;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies a set of Settlement Periods associated with an Electricity Transaction for delivery on an Applicable Day or for a series of Applicable Days.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementPeriods", builder=SettlementPeriods.SettlementPeriodsBuilderImpl.class, version="${project.version}")
public interface SettlementPeriods extends RosettaModelObject {

	SettlementPeriodsMeta metaData = new SettlementPeriodsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The length of each Settlement Period.
	 */
	SettlementPeriodDurationEnum getDuration();
	/**
	 * Specifies the Applicable Day with respect to a range of Settlement Periods. This element can only be omitted if includesHolidays is present, in which case this range of Settlement Periods will apply to days that are holidays only.
	 */
	List<DayOfWeekExtEnum> getApplicableDay();
	/**
	 * Specifies the hour-ending Start Time with respect to a range of Settlement Periods.
	 */
	OffsetPrevailingTime getStartTime();
	/**
	 * Specifies the hour-ending End Time with respect to a range of Settlement Periods. If neither startTime nor endTime contain an offset element and endTime is earlier than startTime, this indicates that the time period &quot;wraps around&quot; midnight. For example, if startTime is 23:00 and endTime is 01:00 then Settlement Periods apply from 22:00 to 23:00 and 23:00 to 00:00 and 00:00 to 01:00 on each included day.
	 */
	OffsetPrevailingTime getEndTime();
	/**
	 * Specifies the duration of the time window during which settlement/delivery occurs.
	 */
	LocalTime getTimeDuration();
	/**
	 * Indicates that days that are holidays according to the referenced commodity business calendar should be excluded from this range of Settlement Periods, even if such day is an applicable day.
	 */
	CommodityBusinessCalendar getExcludeHolidays();
	/**
	 * Indicates that days that are holidays according to the referenced commodity business calendar should be included in this range of Settlement Periods, even if such day is not an applicable day.
	 */
	CommodityBusinessCalendar getIncludeHolidays();
	String getId();

	/*********************** Build Methods  ***********************/
	SettlementPeriods build();
	
	SettlementPeriods.SettlementPeriodsBuilder toBuilder();
	
	static SettlementPeriods.SettlementPeriodsBuilder builder() {
		return new SettlementPeriods.SettlementPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriods> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriods> getType() {
		return SettlementPeriods.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("duration"), SettlementPeriodDurationEnum.class, getDuration(), this);
		processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
		processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.class, getStartTime());
		processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.class, getEndTime());
		processor.processBasic(path.newSubPath("timeDuration"), LocalTime.class, getTimeDuration(), this);
		processRosetta(path.newSubPath("excludeHolidays"), processor, CommodityBusinessCalendar.class, getExcludeHolidays());
		processRosetta(path.newSubPath("includeHolidays"), processor, CommodityBusinessCalendar.class, getIncludeHolidays());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsBuilder extends SettlementPeriods, RosettaModelObjectBuilder {
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateStartTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getStartTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateEndTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getEndTime();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateExcludeHolidays();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getExcludeHolidays();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateIncludeHolidays();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getIncludeHolidays();
		SettlementPeriods.SettlementPeriodsBuilder setDuration(SettlementPeriodDurationEnum duration);
		SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum applicableDay0);
		SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum applicableDay1, int _idx);
		SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDay2);
		SettlementPeriods.SettlementPeriodsBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDay3);
		SettlementPeriods.SettlementPeriodsBuilder setStartTime(OffsetPrevailingTime startTime);
		SettlementPeriods.SettlementPeriodsBuilder setEndTime(OffsetPrevailingTime endTime);
		SettlementPeriods.SettlementPeriodsBuilder setTimeDuration(LocalTime timeDuration);
		SettlementPeriods.SettlementPeriodsBuilder setExcludeHolidays(CommodityBusinessCalendar excludeHolidays);
		SettlementPeriods.SettlementPeriodsBuilder setIncludeHolidays(CommodityBusinessCalendar includeHolidays);
		SettlementPeriods.SettlementPeriodsBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("duration"), SettlementPeriodDurationEnum.class, getDuration(), this);
			processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
			processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getStartTime());
			processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getEndTime());
			processor.processBasic(path.newSubPath("timeDuration"), LocalTime.class, getTimeDuration(), this);
			processRosetta(path.newSubPath("excludeHolidays"), processor, CommodityBusinessCalendar.CommodityBusinessCalendarBuilder.class, getExcludeHolidays());
			processRosetta(path.newSubPath("includeHolidays"), processor, CommodityBusinessCalendar.CommodityBusinessCalendarBuilder.class, getIncludeHolidays());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SettlementPeriods.SettlementPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriods  ***********************/
	class SettlementPeriodsImpl implements SettlementPeriods {
		private final SettlementPeriodDurationEnum duration;
		private final List<DayOfWeekExtEnum> applicableDay;
		private final OffsetPrevailingTime startTime;
		private final OffsetPrevailingTime endTime;
		private final LocalTime timeDuration;
		private final CommodityBusinessCalendar excludeHolidays;
		private final CommodityBusinessCalendar includeHolidays;
		private final String id;
		
		protected SettlementPeriodsImpl(SettlementPeriods.SettlementPeriodsBuilder builder) {
			this.duration = builder.getDuration();
			this.applicableDay = ofNullable(builder.getApplicableDay()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.startTime = ofNullable(builder.getStartTime()).map(f->f.build()).orElse(null);
			this.endTime = ofNullable(builder.getEndTime()).map(f->f.build()).orElse(null);
			this.timeDuration = builder.getTimeDuration();
			this.excludeHolidays = ofNullable(builder.getExcludeHolidays()).map(f->f.build()).orElse(null);
			this.includeHolidays = ofNullable(builder.getIncludeHolidays()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("duration")
		public SettlementPeriodDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("applicableDay")
		public List<DayOfWeekExtEnum> getApplicableDay() {
			return applicableDay;
		}
		
		@Override
		@RosettaAttribute("startTime")
		public OffsetPrevailingTime getStartTime() {
			return startTime;
		}
		
		@Override
		@RosettaAttribute("endTime")
		public OffsetPrevailingTime getEndTime() {
			return endTime;
		}
		
		@Override
		@RosettaAttribute("timeDuration")
		public LocalTime getTimeDuration() {
			return timeDuration;
		}
		
		@Override
		@RosettaAttribute("excludeHolidays")
		public CommodityBusinessCalendar getExcludeHolidays() {
			return excludeHolidays;
		}
		
		@Override
		@RosettaAttribute("includeHolidays")
		public CommodityBusinessCalendar getIncludeHolidays() {
			return includeHolidays;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SettlementPeriods build() {
			return this;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder toBuilder() {
			SettlementPeriods.SettlementPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriods.SettlementPeriodsBuilder builder) {
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getApplicableDay()).ifPresent(builder::setApplicableDay);
			ofNullable(getStartTime()).ifPresent(builder::setStartTime);
			ofNullable(getEndTime()).ifPresent(builder::setEndTime);
			ofNullable(getTimeDuration()).ifPresent(builder::setTimeDuration);
			ofNullable(getExcludeHolidays()).ifPresent(builder::setExcludeHolidays);
			ofNullable(getIncludeHolidays()).ifPresent(builder::setIncludeHolidays);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriods _that = getType().cast(o);
		
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			if (!Objects.equals(timeDuration, _that.getTimeDuration())) return false;
			if (!Objects.equals(excludeHolidays, _that.getExcludeHolidays())) return false;
			if (!Objects.equals(includeHolidays, _that.getIncludeHolidays())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(java.lang.Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			_result = 31 * _result + (timeDuration != null ? timeDuration.hashCode() : 0);
			_result = 31 * _result + (excludeHolidays != null ? excludeHolidays.hashCode() : 0);
			_result = 31 * _result + (includeHolidays != null ? includeHolidays.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriods {" +
				"duration=" + this.duration + ", " +
				"applicableDay=" + this.applicableDay + ", " +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime + ", " +
				"timeDuration=" + this.timeDuration + ", " +
				"excludeHolidays=" + this.excludeHolidays + ", " +
				"includeHolidays=" + this.includeHolidays + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriods  ***********************/
	class SettlementPeriodsBuilderImpl implements SettlementPeriods.SettlementPeriodsBuilder {
	
		protected SettlementPeriodDurationEnum duration;
		protected List<DayOfWeekExtEnum> applicableDay = new ArrayList<>();
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder startTime;
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder endTime;
		protected LocalTime timeDuration;
		protected CommodityBusinessCalendar.CommodityBusinessCalendarBuilder excludeHolidays;
		protected CommodityBusinessCalendar.CommodityBusinessCalendarBuilder includeHolidays;
		protected String id;
	
		public SettlementPeriodsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("duration")
		public SettlementPeriodDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("applicableDay")
		public List<DayOfWeekExtEnum> getApplicableDay() {
			return applicableDay;
		}
		
		@Override
		@RosettaAttribute("startTime")
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getStartTime() {
			return startTime;
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateStartTime() {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder result;
			if (startTime!=null) {
				result = startTime;
			}
			else {
				result = startTime = OffsetPrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endTime")
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getEndTime() {
			return endTime;
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateEndTime() {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder result;
			if (endTime!=null) {
				result = endTime;
			}
			else {
				result = endTime = OffsetPrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timeDuration")
		public LocalTime getTimeDuration() {
			return timeDuration;
		}
		
		@Override
		@RosettaAttribute("excludeHolidays")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getExcludeHolidays() {
			return excludeHolidays;
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateExcludeHolidays() {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder result;
			if (excludeHolidays!=null) {
				result = excludeHolidays;
			}
			else {
				result = excludeHolidays = CommodityBusinessCalendar.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("includeHolidays")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getIncludeHolidays() {
			return includeHolidays;
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateIncludeHolidays() {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder result;
			if (includeHolidays!=null) {
				result = includeHolidays;
			}
			else {
				result = includeHolidays = CommodityBusinessCalendar.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("duration")
		public SettlementPeriods.SettlementPeriodsBuilder setDuration(SettlementPeriodDurationEnum duration) {
			this.duration = duration==null?null:duration;
			return this;
		}
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum applicableDay) {
			if (applicableDay!=null) this.applicableDay.add(applicableDay);
			return this;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum applicableDay, int _idx) {
			getIndex(this.applicableDay, _idx, () -> applicableDay);
			return this;
		}
		@Override 
		public SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
			if (applicableDays != null) {
				for (DayOfWeekExtEnum toAdd : applicableDays) {
					this.applicableDay.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("applicableDay")
		public SettlementPeriods.SettlementPeriodsBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
			if (applicableDays == null)  {
				this.applicableDay = new ArrayList<>();
			}
			else {
				this.applicableDay = applicableDays.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("startTime")
		public SettlementPeriods.SettlementPeriodsBuilder setStartTime(OffsetPrevailingTime startTime) {
			this.startTime = startTime==null?null:startTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endTime")
		public SettlementPeriods.SettlementPeriodsBuilder setEndTime(OffsetPrevailingTime endTime) {
			this.endTime = endTime==null?null:endTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("timeDuration")
		public SettlementPeriods.SettlementPeriodsBuilder setTimeDuration(LocalTime timeDuration) {
			this.timeDuration = timeDuration==null?null:timeDuration;
			return this;
		}
		@Override
		@RosettaAttribute("excludeHolidays")
		public SettlementPeriods.SettlementPeriodsBuilder setExcludeHolidays(CommodityBusinessCalendar excludeHolidays) {
			this.excludeHolidays = excludeHolidays==null?null:excludeHolidays.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("includeHolidays")
		public SettlementPeriods.SettlementPeriodsBuilder setIncludeHolidays(CommodityBusinessCalendar includeHolidays) {
			this.includeHolidays = includeHolidays==null?null:includeHolidays.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SettlementPeriods.SettlementPeriodsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SettlementPeriods build() {
			return new SettlementPeriods.SettlementPeriodsImpl(this);
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder prune() {
			if (startTime!=null && !startTime.prune().hasData()) startTime = null;
			if (endTime!=null && !endTime.prune().hasData()) endTime = null;
			if (excludeHolidays!=null && !excludeHolidays.prune().hasData()) excludeHolidays = null;
			if (includeHolidays!=null && !includeHolidays.prune().hasData()) includeHolidays = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDuration()!=null) return true;
			if (getApplicableDay()!=null && !getApplicableDay().isEmpty()) return true;
			if (getStartTime()!=null && getStartTime().hasData()) return true;
			if (getEndTime()!=null && getEndTime().hasData()) return true;
			if (getTimeDuration()!=null) return true;
			if (getExcludeHolidays()!=null && getExcludeHolidays().hasData()) return true;
			if (getIncludeHolidays()!=null && getIncludeHolidays().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriods.SettlementPeriodsBuilder o = (SettlementPeriods.SettlementPeriodsBuilder) other;
			
			merger.mergeRosetta(getStartTime(), o.getStartTime(), this::setStartTime);
			merger.mergeRosetta(getEndTime(), o.getEndTime(), this::setEndTime);
			merger.mergeRosetta(getExcludeHolidays(), o.getExcludeHolidays(), this::setExcludeHolidays);
			merger.mergeRosetta(getIncludeHolidays(), o.getIncludeHolidays(), this::setIncludeHolidays);
			
			merger.mergeBasic(getDuration(), o.getDuration(), this::setDuration);
			merger.mergeBasic(getApplicableDay(), o.getApplicableDay(), (Consumer<DayOfWeekExtEnum>) this::addApplicableDay);
			merger.mergeBasic(getTimeDuration(), o.getTimeDuration(), this::setTimeDuration);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriods _that = getType().cast(o);
		
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			if (!Objects.equals(timeDuration, _that.getTimeDuration())) return false;
			if (!Objects.equals(excludeHolidays, _that.getExcludeHolidays())) return false;
			if (!Objects.equals(includeHolidays, _that.getIncludeHolidays())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(java.lang.Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			_result = 31 * _result + (timeDuration != null ? timeDuration.hashCode() : 0);
			_result = 31 * _result + (excludeHolidays != null ? excludeHolidays.hashCode() : 0);
			_result = 31 * _result + (includeHolidays != null ? includeHolidays.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsBuilder {" +
				"duration=" + this.duration + ", " +
				"applicableDay=" + this.applicableDay + ", " +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime + ", " +
				"timeDuration=" + this.timeDuration + ", " +
				"excludeHolidays=" + this.excludeHolidays + ", " +
				"includeHolidays=" + this.includeHolidays + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
