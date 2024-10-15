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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.DateRange;
import fpml.confirmation.DateReference;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetBuilder;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetBuilderImpl;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetImpl;
import fpml.confirmation.RelativeDates;
import fpml.confirmation.RelativeDates.RelativeDatesBuilder;
import fpml.confirmation.RelativeDates.RelativeDatesBuilderImpl;
import fpml.confirmation.RelativeDates.RelativeDatesImpl;
import fpml.confirmation.meta.RelativeDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing a set of dates defined as relative to another set of dates.
 * @version ${project.version}
 */
@RosettaDataType(value="RelativeDates", builder=RelativeDates.RelativeDatesBuilderImpl.class, version="${project.version}")
public interface RelativeDates extends RelativeDateOffset {

	RelativeDatesMeta metaData = new RelativeDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of periods in the referenced date schedule that are between each date in the relative date schedule. Thus a skip of 2 would mean that dates are relative to every second date in the referenced schedule. If present this should have a value greater than 1.
	 */
	Integer getPeriodSkip();
	/**
	 * The first and last dates of a schedule. This can be used to restrict the range of values in a reference series of dates.
	 */
	DateRange getScheduleBounds();

	/*********************** Build Methods  ***********************/
	RelativeDates build();
	
	RelativeDates.RelativeDatesBuilder toBuilder();
	
	static RelativeDates.RelativeDatesBuilder builder() {
		return new RelativeDates.RelativeDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativeDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RelativeDates> getType() {
		return RelativeDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
		processor.processBasic(path.newSubPath("periodSkip"), Integer.class, getPeriodSkip(), this);
		processRosetta(path.newSubPath("scheduleBounds"), processor, DateRange.class, getScheduleBounds());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativeDatesBuilder extends RelativeDates, RelativeDateOffset.RelativeDateOffsetBuilder {
		DateRange.DateRangeBuilder getOrCreateScheduleBounds();
		DateRange.DateRangeBuilder getScheduleBounds();
		RelativeDates.RelativeDatesBuilder setPeriodMultiplier(Integer periodMultiplier);
		RelativeDates.RelativeDatesBuilder setPeriod(PeriodEnum period);
		RelativeDates.RelativeDatesBuilder setId(String id);
		RelativeDates.RelativeDatesBuilder setDayType(DayTypeEnum dayType);
		RelativeDates.RelativeDatesBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		RelativeDates.RelativeDatesBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		RelativeDates.RelativeDatesBuilder setDateRelativeTo(DateReference dateRelativeTo);
		RelativeDates.RelativeDatesBuilder setAdjustedDate(IdentifiedDate adjustedDate);
		RelativeDates.RelativeDatesBuilder setPeriodSkip(Integer periodSkip);
		RelativeDates.RelativeDatesBuilder setScheduleBounds(DateRange scheduleBounds);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.DateReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
			processor.processBasic(path.newSubPath("periodSkip"), Integer.class, getPeriodSkip(), this);
			processRosetta(path.newSubPath("scheduleBounds"), processor, DateRange.DateRangeBuilder.class, getScheduleBounds());
		}
		

		RelativeDates.RelativeDatesBuilder prune();
	}

	/*********************** Immutable Implementation of RelativeDates  ***********************/
	class RelativeDatesImpl extends RelativeDateOffset.RelativeDateOffsetImpl implements RelativeDates {
		private final Integer periodSkip;
		private final DateRange scheduleBounds;
		
		protected RelativeDatesImpl(RelativeDates.RelativeDatesBuilder builder) {
			super(builder);
			this.periodSkip = builder.getPeriodSkip();
			this.scheduleBounds = ofNullable(builder.getScheduleBounds()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodSkip")
		public Integer getPeriodSkip() {
			return periodSkip;
		}
		
		@Override
		@RosettaAttribute("scheduleBounds")
		public DateRange getScheduleBounds() {
			return scheduleBounds;
		}
		
		@Override
		public RelativeDates build() {
			return this;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder toBuilder() {
			RelativeDates.RelativeDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDates.RelativeDatesBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodSkip()).ifPresent(builder::setPeriodSkip);
			ofNullable(getScheduleBounds()).ifPresent(builder::setScheduleBounds);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDates _that = getType().cast(o);
		
			if (!Objects.equals(periodSkip, _that.getPeriodSkip())) return false;
			if (!Objects.equals(scheduleBounds, _that.getScheduleBounds())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodSkip != null ? periodSkip.hashCode() : 0);
			_result = 31 * _result + (scheduleBounds != null ? scheduleBounds.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDates {" +
				"periodSkip=" + this.periodSkip + ", " +
				"scheduleBounds=" + this.scheduleBounds +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RelativeDates  ***********************/
	class RelativeDatesBuilderImpl extends RelativeDateOffset.RelativeDateOffsetBuilderImpl  implements RelativeDates.RelativeDatesBuilder {
	
		protected Integer periodSkip;
		protected DateRange.DateRangeBuilder scheduleBounds;
	
		public RelativeDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodSkip")
		public Integer getPeriodSkip() {
			return periodSkip;
		}
		
		@Override
		@RosettaAttribute("scheduleBounds")
		public DateRange.DateRangeBuilder getScheduleBounds() {
			return scheduleBounds;
		}
		
		@Override
		public DateRange.DateRangeBuilder getOrCreateScheduleBounds() {
			DateRange.DateRangeBuilder result;
			if (scheduleBounds!=null) {
				result = scheduleBounds;
			}
			else {
				result = scheduleBounds = DateRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public RelativeDates.RelativeDatesBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public RelativeDates.RelativeDatesBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public RelativeDates.RelativeDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public RelativeDates.RelativeDatesBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public RelativeDates.RelativeDatesBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public RelativeDates.RelativeDatesBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateRelativeTo")
		public RelativeDates.RelativeDatesBuilder setDateRelativeTo(DateReference dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public RelativeDates.RelativeDatesBuilder setAdjustedDate(IdentifiedDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodSkip")
		public RelativeDates.RelativeDatesBuilder setPeriodSkip(Integer periodSkip) {
			this.periodSkip = periodSkip==null?null:periodSkip;
			return this;
		}
		@Override
		@RosettaAttribute("scheduleBounds")
		public RelativeDates.RelativeDatesBuilder setScheduleBounds(DateRange scheduleBounds) {
			this.scheduleBounds = scheduleBounds==null?null:scheduleBounds.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDates build() {
			return new RelativeDates.RelativeDatesImpl(this);
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDates.RelativeDatesBuilder prune() {
			super.prune();
			if (scheduleBounds!=null && !scheduleBounds.prune().hasData()) scheduleBounds = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodSkip()!=null) return true;
			if (getScheduleBounds()!=null && getScheduleBounds().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDates.RelativeDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RelativeDates.RelativeDatesBuilder o = (RelativeDates.RelativeDatesBuilder) other;
			
			merger.mergeRosetta(getScheduleBounds(), o.getScheduleBounds(), this::setScheduleBounds);
			
			merger.mergeBasic(getPeriodSkip(), o.getPeriodSkip(), this::setPeriodSkip);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDates _that = getType().cast(o);
		
			if (!Objects.equals(periodSkip, _that.getPeriodSkip())) return false;
			if (!Objects.equals(scheduleBounds, _that.getScheduleBounds())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodSkip != null ? periodSkip.hashCode() : 0);
			_result = 31 * _result + (scheduleBounds != null ? scheduleBounds.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDatesBuilder {" +
				"periodSkip=" + this.periodSkip + ", " +
				"scheduleBounds=" + this.scheduleBounds +
			'}' + " " + super.toString();
		}
	}
}
