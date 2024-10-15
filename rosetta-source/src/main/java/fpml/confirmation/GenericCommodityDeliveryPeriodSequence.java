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
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilderImpl;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceImpl;
import fpml.confirmation.OffsetPrevailingTime;
import fpml.confirmation.meta.GenericCommodityDeliveryPeriodSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericCommodityDeliveryPeriodSequence", builder=GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilderImpl.class, version="${project.version}")
public interface GenericCommodityDeliveryPeriodSequence extends RosettaModelObject {

	GenericCommodityDeliveryPeriodSequenceMeta metaData = new GenericCommodityDeliveryPeriodSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the hour-ending Start Time with respect to a range of Settlement Periods.
	 */
	OffsetPrevailingTime getStartTime();
	/**
	 * Specifies the hour-ending End Time with respect to a range of Settlement Periods. If neither startTime nor endTime contain an offset element and endTime is earlier than startTime, this indicates that the time period &quot;wraps around&quot; midnight. For example, if startTime is 23:00 and endTime is 01:00 then Settlement Periods apply from 00:00 to 01:00 and 23:00 to 00:00 on each included day.
	 */
	OffsetPrevailingTime getEndTime();

	/*********************** Build Methods  ***********************/
	GenericCommodityDeliveryPeriodSequence build();
	
	GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder toBuilder();
	
	static GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder builder() {
		return new GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericCommodityDeliveryPeriodSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericCommodityDeliveryPeriodSequence> getType() {
		return GenericCommodityDeliveryPeriodSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.class, getStartTime());
		processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.class, getEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericCommodityDeliveryPeriodSequenceBuilder extends GenericCommodityDeliveryPeriodSequence, RosettaModelObjectBuilder {
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateStartTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getStartTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateEndTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getEndTime();
		GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder setStartTime(OffsetPrevailingTime startTime);
		GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder setEndTime(OffsetPrevailingTime endTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getStartTime());
			processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getEndTime());
		}
		

		GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of GenericCommodityDeliveryPeriodSequence  ***********************/
	class GenericCommodityDeliveryPeriodSequenceImpl implements GenericCommodityDeliveryPeriodSequence {
		private final OffsetPrevailingTime startTime;
		private final OffsetPrevailingTime endTime;
		
		protected GenericCommodityDeliveryPeriodSequenceImpl(GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder builder) {
			this.startTime = ofNullable(builder.getStartTime()).map(f->f.build()).orElse(null);
			this.endTime = ofNullable(builder.getEndTime()).map(f->f.build()).orElse(null);
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
		public GenericCommodityDeliveryPeriodSequence build() {
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder toBuilder() {
			GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder builder) {
			ofNullable(getStartTime()).ifPresent(builder::setStartTime);
			ofNullable(getEndTime()).ifPresent(builder::setEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityDeliveryPeriodSequence _that = getType().cast(o);
		
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityDeliveryPeriodSequence {" +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericCommodityDeliveryPeriodSequence  ***********************/
	class GenericCommodityDeliveryPeriodSequenceBuilderImpl implements GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder {
	
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder startTime;
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder endTime;
	
		public GenericCommodityDeliveryPeriodSequenceBuilderImpl() {
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
		@RosettaAttribute("startTime")
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder setStartTime(OffsetPrevailingTime startTime) {
			this.startTime = startTime==null?null:startTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endTime")
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder setEndTime(OffsetPrevailingTime endTime) {
			this.endTime = endTime==null?null:endTime.toBuilder();
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriodSequence build() {
			return new GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceImpl(this);
		}
		
		@Override
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder prune() {
			if (startTime!=null && !startTime.prune().hasData()) startTime = null;
			if (endTime!=null && !endTime.prune().hasData()) endTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartTime()!=null && getStartTime().hasData()) return true;
			if (getEndTime()!=null && getEndTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder o = (GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder) other;
			
			merger.mergeRosetta(getStartTime(), o.getStartTime(), this::setStartTime);
			merger.mergeRosetta(getEndTime(), o.getEndTime(), this::setEndTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityDeliveryPeriodSequence _that = getType().cast(o);
		
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityDeliveryPeriodSequenceBuilder {" +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime +
			'}';
		}
	}
}
