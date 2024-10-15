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
import fpml.confirmation.Offset;
import fpml.confirmation.OffsetPrevailingTime;
import fpml.confirmation.OffsetPrevailingTime.OffsetPrevailingTimeBuilder;
import fpml.confirmation.OffsetPrevailingTime.OffsetPrevailingTimeBuilderImpl;
import fpml.confirmation.OffsetPrevailingTime.OffsetPrevailingTimeImpl;
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.meta.OffsetPrevailingTimeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Allows the specification of a time that may be on a day prior or subsequent to the day in question. This type is intended for use with a day of the week (i.e. where no actual date is specified) as part of, for example, a period that runs from 23:00-07:00 on a series of days and where holidays on the actual days would affect the entire time period.
 * @version ${project.version}
 */
@RosettaDataType(value="OffsetPrevailingTime", builder=OffsetPrevailingTime.OffsetPrevailingTimeBuilderImpl.class, version="${project.version}")
public interface OffsetPrevailingTime extends RosettaModelObject {

	OffsetPrevailingTimeMeta metaData = new OffsetPrevailingTimeMeta();

	/*********************** Getter Methods  ***********************/
	PrevailingTime getTime();
	/**
	 * Indicates whether time applies to the actual day specified (in which case this element should be omitted) the day prior to that day (in which case periodMultiplier should be -1 and period should be Day) or the day subsequent to that day (in which case periodMultiplier should be 1 and period should be Day).
	 */
	Offset getOffset();

	/*********************** Build Methods  ***********************/
	OffsetPrevailingTime build();
	
	OffsetPrevailingTime.OffsetPrevailingTimeBuilder toBuilder();
	
	static OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder() {
		return new OffsetPrevailingTime.OffsetPrevailingTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OffsetPrevailingTime> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OffsetPrevailingTime> getType() {
		return OffsetPrevailingTime.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("time"), processor, PrevailingTime.class, getTime());
		processRosetta(path.newSubPath("offset"), processor, Offset.class, getOffset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OffsetPrevailingTimeBuilder extends OffsetPrevailingTime, RosettaModelObjectBuilder {
		PrevailingTime.PrevailingTimeBuilder getOrCreateTime();
		PrevailingTime.PrevailingTimeBuilder getTime();
		Offset.OffsetBuilder getOrCreateOffset();
		Offset.OffsetBuilder getOffset();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder setTime(PrevailingTime time);
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder setOffset(Offset offset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("time"), processor, PrevailingTime.PrevailingTimeBuilder.class, getTime());
			processRosetta(path.newSubPath("offset"), processor, Offset.OffsetBuilder.class, getOffset());
		}
		

		OffsetPrevailingTime.OffsetPrevailingTimeBuilder prune();
	}

	/*********************** Immutable Implementation of OffsetPrevailingTime  ***********************/
	class OffsetPrevailingTimeImpl implements OffsetPrevailingTime {
		private final PrevailingTime time;
		private final Offset offset;
		
		protected OffsetPrevailingTimeImpl(OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder) {
			this.time = ofNullable(builder.getTime()).map(f->f.build()).orElse(null);
			this.offset = ofNullable(builder.getOffset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("time")
		public PrevailingTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("offset")
		public Offset getOffset() {
			return offset;
		}
		
		@Override
		public OffsetPrevailingTime build() {
			return this;
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder toBuilder() {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder) {
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getOffset()).ifPresent(builder::setOffset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OffsetPrevailingTime _that = getType().cast(o);
		
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OffsetPrevailingTime {" +
				"time=" + this.time + ", " +
				"offset=" + this.offset +
			'}';
		}
	}

	/*********************** Builder Implementation of OffsetPrevailingTime  ***********************/
	class OffsetPrevailingTimeBuilderImpl implements OffsetPrevailingTime.OffsetPrevailingTimeBuilder {
	
		protected PrevailingTime.PrevailingTimeBuilder time;
		protected Offset.OffsetBuilder offset;
	
		public OffsetPrevailingTimeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("time")
		public PrevailingTime.PrevailingTimeBuilder getTime() {
			return time;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (time!=null) {
				result = time;
			}
			else {
				result = time = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("offset")
		public Offset.OffsetBuilder getOffset() {
			return offset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateOffset() {
			Offset.OffsetBuilder result;
			if (offset!=null) {
				result = offset;
			}
			else {
				result = offset = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("time")
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder setTime(PrevailingTime time) {
			this.time = time==null?null:time.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("offset")
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder setOffset(Offset offset) {
			this.offset = offset==null?null:offset.toBuilder();
			return this;
		}
		
		@Override
		public OffsetPrevailingTime build() {
			return new OffsetPrevailingTime.OffsetPrevailingTimeImpl(this);
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder prune() {
			if (time!=null && !time.prune().hasData()) time = null;
			if (offset!=null && !offset.prune().hasData()) offset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTime()!=null && getTime().hasData()) return true;
			if (getOffset()!=null && getOffset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder o = (OffsetPrevailingTime.OffsetPrevailingTimeBuilder) other;
			
			merger.mergeRosetta(getTime(), o.getTime(), this::setTime);
			merger.mergeRosetta(getOffset(), o.getOffset(), this::setOffset);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OffsetPrevailingTime _that = getType().cast(o);
		
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OffsetPrevailingTimeBuilder {" +
				"time=" + this.time + ", " +
				"offset=" + this.offset +
			'}';
		}
	}
}
