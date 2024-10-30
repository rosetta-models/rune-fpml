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
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.DateOffset;
import fpml.confirmation.DateOffset.DateOffsetBuilder;
import fpml.confirmation.DateOffset.DateOffsetBuilderImpl;
import fpml.confirmation.DateOffset.DateOffsetImpl;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.Offset;
import fpml.confirmation.Offset.OffsetBuilder;
import fpml.confirmation.Offset.OffsetBuilderImpl;
import fpml.confirmation.Offset.OffsetImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.meta.DateOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining an offset used in calculating a date when this date is defined in reference to another date through a date offset. The type includes the convention for adjusting the date and an optional sequence element to indicate the order in a sequence of multiple date offsets.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DateOffset", builder=DateOffset.DateOffsetBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DateOffset extends Offset {

	DateOffsetMeta metaData = new DateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();

	/*********************** Build Methods  ***********************/
	DateOffset build();
	
	DateOffset.DateOffsetBuilder toBuilder();
	
	static DateOffset.DateOffsetBuilder builder() {
		return new DateOffset.DateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateOffset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DateOffset> getType() {
		return DateOffset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateOffsetBuilder extends DateOffset, Offset.OffsetBuilder {
		DateOffset.DateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		DateOffset.DateOffsetBuilder setPeriod(PeriodEnum period);
		DateOffset.DateOffsetBuilder setId(String id);
		DateOffset.DateOffsetBuilder setDayType(DayTypeEnum dayType);
		DateOffset.DateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		}
		

		DateOffset.DateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of DateOffset  ***********************/
	class DateOffsetImpl extends Offset.OffsetImpl implements DateOffset {
		private final BusinessDayConventionEnum businessDayConvention;
		
		protected DateOffsetImpl(DateOffset.DateOffsetBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public DateOffset build() {
			return this;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder toBuilder() {
			DateOffset.DateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateOffset.DateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateOffset {" +
				"businessDayConvention=" + this.businessDayConvention +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DateOffset  ***********************/
	class DateOffsetBuilderImpl extends Offset.OffsetBuilderImpl  implements DateOffset.DateOffsetBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
	
		public DateOffsetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public DateOffset.DateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public DateOffset.DateOffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DateOffset.DateOffsetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public DateOffset.DateOffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public DateOffset.DateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		
		@Override
		public DateOffset build() {
			return new DateOffset.DateOffsetImpl(this);
		}
		
		@Override
		public DateOffset.DateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateOffset.DateOffsetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateOffset.DateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DateOffset.DateOffsetBuilder o = (DateOffset.DateOffsetBuilder) other;
			
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateOffsetBuilder {" +
				"businessDayConvention=" + this.businessDayConvention +
			'}' + " " + super.toString();
		}
	}
}
