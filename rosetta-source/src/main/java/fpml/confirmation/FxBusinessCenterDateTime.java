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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxBusinessCenterDateTime;
import fpml.confirmation.FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder;
import fpml.confirmation.FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilderImpl;
import fpml.confirmation.FxBusinessCenterDateTime.FxBusinessCenterDateTimeImpl;
import fpml.confirmation.meta.FxBusinessCenterDateTimeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxBusinessCenterDateTime", builder=FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilderImpl.class, version="${project.version}")
public interface FxBusinessCenterDateTime extends RosettaModelObject {

	FxBusinessCenterDateTimeMeta metaData = new FxBusinessCenterDateTimeMeta();

	/*********************** Getter Methods  ***********************/
	Date getDate();
	BusinessCenterTime getTime();

	/*********************** Build Methods  ***********************/
	FxBusinessCenterDateTime build();
	
	FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder toBuilder();
	
	static FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder() {
		return new FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxBusinessCenterDateTime> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxBusinessCenterDateTime> getType() {
		return FxBusinessCenterDateTime.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processRosetta(path.newSubPath("time"), processor, BusinessCenterTime.class, getTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxBusinessCenterDateTimeBuilder extends FxBusinessCenterDateTime, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getTime();
		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setDate(Date date);
		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setTime(BusinessCenterTime time);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processRosetta(path.newSubPath("time"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getTime());
		}
		

		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder prune();
	}

	/*********************** Immutable Implementation of FxBusinessCenterDateTime  ***********************/
	class FxBusinessCenterDateTimeImpl implements FxBusinessCenterDateTime {
		private final Date date;
		private final BusinessCenterTime time;
		
		protected FxBusinessCenterDateTimeImpl(FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder) {
			this.date = builder.getDate();
			this.time = ofNullable(builder.getTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		public BusinessCenterTime getTime() {
			return time;
		}
		
		@Override
		public FxBusinessCenterDateTime build() {
			return this;
		}
		
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder toBuilder() {
			FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBusinessCenterDateTime _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBusinessCenterDateTime {" +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}

	/*********************** Builder Implementation of FxBusinessCenterDateTime  ***********************/
	class FxBusinessCenterDateTimeBuilderImpl implements FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder {
	
		protected Date date;
		protected BusinessCenterTime.BusinessCenterTimeBuilder time;
	
		public FxBusinessCenterDateTimeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		public BusinessCenterTime.BusinessCenterTimeBuilder getTime() {
			return time;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (time!=null) {
				result = time;
			}
			else {
				result = time = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("time")
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setTime(BusinessCenterTime time) {
			this.time = time==null?null:time.toBuilder();
			return this;
		}
		
		@Override
		public FxBusinessCenterDateTime build() {
			return new FxBusinessCenterDateTime.FxBusinessCenterDateTimeImpl(this);
		}
		
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder prune() {
			if (time!=null && !time.prune().hasData()) time = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getTime()!=null && getTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder o = (FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder) other;
			
			merger.mergeRosetta(getTime(), o.getTime(), this::setTime);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBusinessCenterDateTime _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBusinessCenterDateTimeBuilder {" +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}
}
