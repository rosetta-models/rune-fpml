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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxFlexibleForwardSequence;
import fpml.confirmation.FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder;
import fpml.confirmation.FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilderImpl;
import fpml.confirmation.FxFlexibleForwardSequence.FxFlexibleForwardSequenceImpl;
import fpml.confirmation.meta.FxFlexibleForwardSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxFlexibleForwardSequence", builder=FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxFlexibleForwardSequence extends RosettaModelObject {

	FxFlexibleForwardSequenceMeta metaData = new FxFlexibleForwardSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The earliest time of day at the specified business center, at which the client may execute a transaction.
	 */
	BusinessCenterTime getEarliestExecutionTime();
	/**
	 * The latest time of day at the specified business center, at which the client may execute a transaction.
	 */
	BusinessCenterTime getLatestExecutionTime();

	/*********************** Build Methods  ***********************/
	FxFlexibleForwardSequence build();
	
	FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder toBuilder();
	
	static FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder builder() {
		return new FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFlexibleForwardSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFlexibleForwardSequence> getType() {
		return FxFlexibleForwardSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("earliestExecutionTime"), processor, BusinessCenterTime.class, getEarliestExecutionTime());
		processRosetta(path.newSubPath("latestExecutionTime"), processor, BusinessCenterTime.class, getLatestExecutionTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFlexibleForwardSequenceBuilder extends FxFlexibleForwardSequence, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExecutionTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExecutionTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExecutionTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExecutionTime();
		FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder setEarliestExecutionTime(BusinessCenterTime earliestExecutionTime);
		FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder setLatestExecutionTime(BusinessCenterTime latestExecutionTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("earliestExecutionTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExecutionTime());
			processRosetta(path.newSubPath("latestExecutionTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExecutionTime());
		}
		

		FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxFlexibleForwardSequence  ***********************/
	class FxFlexibleForwardSequenceImpl implements FxFlexibleForwardSequence {
		private final BusinessCenterTime earliestExecutionTime;
		private final BusinessCenterTime latestExecutionTime;
		
		protected FxFlexibleForwardSequenceImpl(FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder builder) {
			this.earliestExecutionTime = ofNullable(builder.getEarliestExecutionTime()).map(f->f.build()).orElse(null);
			this.latestExecutionTime = ofNullable(builder.getLatestExecutionTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("earliestExecutionTime")
		public BusinessCenterTime getEarliestExecutionTime() {
			return earliestExecutionTime;
		}
		
		@Override
		@RosettaAttribute("latestExecutionTime")
		public BusinessCenterTime getLatestExecutionTime() {
			return latestExecutionTime;
		}
		
		@Override
		public FxFlexibleForwardSequence build() {
			return this;
		}
		
		@Override
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder toBuilder() {
			FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder builder) {
			ofNullable(getEarliestExecutionTime()).ifPresent(builder::setEarliestExecutionTime);
			ofNullable(getLatestExecutionTime()).ifPresent(builder::setLatestExecutionTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFlexibleForwardSequence _that = getType().cast(o);
		
			if (!Objects.equals(earliestExecutionTime, _that.getEarliestExecutionTime())) return false;
			if (!Objects.equals(latestExecutionTime, _that.getLatestExecutionTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earliestExecutionTime != null ? earliestExecutionTime.hashCode() : 0);
			_result = 31 * _result + (latestExecutionTime != null ? latestExecutionTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardSequence {" +
				"earliestExecutionTime=" + this.earliestExecutionTime + ", " +
				"latestExecutionTime=" + this.latestExecutionTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFlexibleForwardSequence  ***********************/
	class FxFlexibleForwardSequenceBuilderImpl implements FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExecutionTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExecutionTime;
	
		public FxFlexibleForwardSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("earliestExecutionTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExecutionTime() {
			return earliestExecutionTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExecutionTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (earliestExecutionTime!=null) {
				result = earliestExecutionTime;
			}
			else {
				result = earliestExecutionTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExecutionTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getLatestExecutionTime() {
			return latestExecutionTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExecutionTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (latestExecutionTime!=null) {
				result = latestExecutionTime;
			}
			else {
				result = latestExecutionTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("earliestExecutionTime")
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder setEarliestExecutionTime(BusinessCenterTime earliestExecutionTime) {
			this.earliestExecutionTime = earliestExecutionTime==null?null:earliestExecutionTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExecutionTime")
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder setLatestExecutionTime(BusinessCenterTime latestExecutionTime) {
			this.latestExecutionTime = latestExecutionTime==null?null:latestExecutionTime.toBuilder();
			return this;
		}
		
		@Override
		public FxFlexibleForwardSequence build() {
			return new FxFlexibleForwardSequence.FxFlexibleForwardSequenceImpl(this);
		}
		
		@Override
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder prune() {
			if (earliestExecutionTime!=null && !earliestExecutionTime.prune().hasData()) earliestExecutionTime = null;
			if (latestExecutionTime!=null && !latestExecutionTime.prune().hasData()) latestExecutionTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEarliestExecutionTime()!=null && getEarliestExecutionTime().hasData()) return true;
			if (getLatestExecutionTime()!=null && getLatestExecutionTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder o = (FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder) other;
			
			merger.mergeRosetta(getEarliestExecutionTime(), o.getEarliestExecutionTime(), this::setEarliestExecutionTime);
			merger.mergeRosetta(getLatestExecutionTime(), o.getLatestExecutionTime(), this::setLatestExecutionTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFlexibleForwardSequence _that = getType().cast(o);
		
			if (!Objects.equals(earliestExecutionTime, _that.getEarliestExecutionTime())) return false;
			if (!Objects.equals(latestExecutionTime, _that.getLatestExecutionTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earliestExecutionTime != null ? earliestExecutionTime.hashCode() : 0);
			_result = 31 * _result + (latestExecutionTime != null ? latestExecutionTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardSequenceBuilder {" +
				"earliestExecutionTime=" + this.earliestExecutionTime + ", " +
				"latestExecutionTime=" + this.latestExecutionTime +
			'}';
		}
	}
}
