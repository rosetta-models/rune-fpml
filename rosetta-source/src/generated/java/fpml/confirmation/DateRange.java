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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.DateRange;
import fpml.confirmation.DateRange.DateRangeBuilder;
import fpml.confirmation.DateRange.DateRangeBuilderImpl;
import fpml.confirmation.DateRange.DateRangeImpl;
import fpml.confirmation.meta.DateRangeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the first and the last date. The first date must fall before the last date.
 * @version ${project.version}
 */
@RosettaDataType(value="DateRange", builder=DateRange.DateRangeBuilderImpl.class, version="${project.version}")
public interface DateRange extends RosettaModelObject {

	DateRangeMeta metaData = new DateRangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first date of a date range.
	 */
	Date getUnadjustedFirstDate();
	/**
	 * The last date of a date range.
	 */
	Date getUnadjustedLastDate();

	/*********************** Build Methods  ***********************/
	DateRange build();
	
	DateRange.DateRangeBuilder toBuilder();
	
	static DateRange.DateRangeBuilder builder() {
		return new DateRange.DateRangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateRange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DateRange> getType() {
		return DateRange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedFirstDate"), Date.class, getUnadjustedFirstDate(), this);
		processor.processBasic(path.newSubPath("unadjustedLastDate"), Date.class, getUnadjustedLastDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateRangeBuilder extends DateRange, RosettaModelObjectBuilder {
		DateRange.DateRangeBuilder setUnadjustedFirstDate(Date unadjustedFirstDate);
		DateRange.DateRangeBuilder setUnadjustedLastDate(Date unadjustedLastDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedFirstDate"), Date.class, getUnadjustedFirstDate(), this);
			processor.processBasic(path.newSubPath("unadjustedLastDate"), Date.class, getUnadjustedLastDate(), this);
		}
		

		DateRange.DateRangeBuilder prune();
	}

	/*********************** Immutable Implementation of DateRange  ***********************/
	class DateRangeImpl implements DateRange {
		private final Date unadjustedFirstDate;
		private final Date unadjustedLastDate;
		
		protected DateRangeImpl(DateRange.DateRangeBuilder builder) {
			this.unadjustedFirstDate = builder.getUnadjustedFirstDate();
			this.unadjustedLastDate = builder.getUnadjustedLastDate();
		}
		
		@Override
		@RosettaAttribute("unadjustedFirstDate")
		public Date getUnadjustedFirstDate() {
			return unadjustedFirstDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedLastDate")
		public Date getUnadjustedLastDate() {
			return unadjustedLastDate;
		}
		
		@Override
		public DateRange build() {
			return this;
		}
		
		@Override
		public DateRange.DateRangeBuilder toBuilder() {
			DateRange.DateRangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRange.DateRangeBuilder builder) {
			ofNullable(getUnadjustedFirstDate()).ifPresent(builder::setUnadjustedFirstDate);
			ofNullable(getUnadjustedLastDate()).ifPresent(builder::setUnadjustedLastDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRange _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedFirstDate, _that.getUnadjustedFirstDate())) return false;
			if (!Objects.equals(unadjustedLastDate, _that.getUnadjustedLastDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedFirstDate != null ? unadjustedFirstDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedLastDate != null ? unadjustedLastDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRange {" +
				"unadjustedFirstDate=" + this.unadjustedFirstDate + ", " +
				"unadjustedLastDate=" + this.unadjustedLastDate +
			'}';
		}
	}

	/*********************** Builder Implementation of DateRange  ***********************/
	class DateRangeBuilderImpl implements DateRange.DateRangeBuilder {
	
		protected Date unadjustedFirstDate;
		protected Date unadjustedLastDate;
	
		public DateRangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("unadjustedFirstDate")
		public Date getUnadjustedFirstDate() {
			return unadjustedFirstDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedLastDate")
		public Date getUnadjustedLastDate() {
			return unadjustedLastDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedFirstDate")
		public DateRange.DateRangeBuilder setUnadjustedFirstDate(Date unadjustedFirstDate) {
			this.unadjustedFirstDate = unadjustedFirstDate==null?null:unadjustedFirstDate;
			return this;
		}
		@Override
		@RosettaAttribute("unadjustedLastDate")
		public DateRange.DateRangeBuilder setUnadjustedLastDate(Date unadjustedLastDate) {
			this.unadjustedLastDate = unadjustedLastDate==null?null:unadjustedLastDate;
			return this;
		}
		
		@Override
		public DateRange build() {
			return new DateRange.DateRangeImpl(this);
		}
		
		@Override
		public DateRange.DateRangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRange.DateRangeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedFirstDate()!=null) return true;
			if (getUnadjustedLastDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRange.DateRangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRange.DateRangeBuilder o = (DateRange.DateRangeBuilder) other;
			
			
			merger.mergeBasic(getUnadjustedFirstDate(), o.getUnadjustedFirstDate(), this::setUnadjustedFirstDate);
			merger.mergeBasic(getUnadjustedLastDate(), o.getUnadjustedLastDate(), this::setUnadjustedLastDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRange _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedFirstDate, _that.getUnadjustedFirstDate())) return false;
			if (!Objects.equals(unadjustedLastDate, _that.getUnadjustedLastDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedFirstDate != null ? unadjustedFirstDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedLastDate != null ? unadjustedLastDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRangeBuilder {" +
				"unadjustedFirstDate=" + this.unadjustedFirstDate + ", " +
				"unadjustedLastDate=" + this.unadjustedLastDate +
			'}';
		}
	}
}
