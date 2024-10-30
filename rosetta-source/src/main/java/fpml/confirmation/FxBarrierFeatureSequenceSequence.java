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
import fpml.confirmation.FxBarrierFeatureSequenceSequence;
import fpml.confirmation.FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder;
import fpml.confirmation.FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilderImpl;
import fpml.confirmation.FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceImpl;
import fpml.confirmation.meta.FxBarrierFeatureSequenceSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxBarrierFeatureSequenceSequence", builder=FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxBarrierFeatureSequenceSequence extends RosettaModelObject {

	FxBarrierFeatureSequenceSequenceMeta metaData = new FxBarrierFeatureSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the observation period for an american barrier ends. If the end date is not present, then the date and time of the end of the period is deemed to be the date and time of expiration.
	 */
	Date getObservationEndDate();
	/**
	 * The time on the end date at which the observation period for an american barrier ends. If the time is not present, then the time is deemed to be the same as the expiration time.
	 */
	BusinessCenterTime getObservationEndTime();

	/*********************** Build Methods  ***********************/
	FxBarrierFeatureSequenceSequence build();
	
	FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder toBuilder();
	
	static FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder builder() {
		return new FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxBarrierFeatureSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxBarrierFeatureSequenceSequence> getType() {
		return FxBarrierFeatureSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.class, getObservationEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxBarrierFeatureSequenceSequenceBuilder extends FxBarrierFeatureSequenceSequence, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationEndTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationEndTime();
		FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder setObservationEndDate(Date observationEndDate);
		FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder setObservationEndTime(BusinessCenterTime observationEndTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationEndTime());
		}
		

		FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxBarrierFeatureSequenceSequence  ***********************/
	class FxBarrierFeatureSequenceSequenceImpl implements FxBarrierFeatureSequenceSequence {
		private final Date observationEndDate;
		private final BusinessCenterTime observationEndTime;
		
		protected FxBarrierFeatureSequenceSequenceImpl(FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder builder) {
			this.observationEndDate = builder.getObservationEndDate();
			this.observationEndTime = ofNullable(builder.getObservationEndTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		public Date getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("observationEndTime")
		public BusinessCenterTime getObservationEndTime() {
			return observationEndTime;
		}
		
		@Override
		public FxBarrierFeatureSequenceSequence build() {
			return this;
		}
		
		@Override
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder toBuilder() {
			FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder builder) {
			ofNullable(getObservationEndDate()).ifPresent(builder::setObservationEndDate);
			ofNullable(getObservationEndTime()).ifPresent(builder::setObservationEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBarrierFeatureSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(observationEndTime, _that.getObservationEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (observationEndTime != null ? observationEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBarrierFeatureSequenceSequence {" +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxBarrierFeatureSequenceSequence  ***********************/
	class FxBarrierFeatureSequenceSequenceBuilderImpl implements FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder {
	
		protected Date observationEndDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationEndTime;
	
		public FxBarrierFeatureSequenceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observationEndDate")
		public Date getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("observationEndTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationEndTime() {
			return observationEndTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationEndTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationEndTime!=null) {
				result = observationEndTime;
			}
			else {
				result = observationEndTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder setObservationEndDate(Date observationEndDate) {
			this.observationEndDate = observationEndDate==null?null:observationEndDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationEndTime")
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder setObservationEndTime(BusinessCenterTime observationEndTime) {
			this.observationEndTime = observationEndTime==null?null:observationEndTime.toBuilder();
			return this;
		}
		
		@Override
		public FxBarrierFeatureSequenceSequence build() {
			return new FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceImpl(this);
		}
		
		@Override
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder prune() {
			if (observationEndTime!=null && !observationEndTime.prune().hasData()) observationEndTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationEndDate()!=null) return true;
			if (getObservationEndTime()!=null && getObservationEndTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder o = (FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder) other;
			
			merger.mergeRosetta(getObservationEndTime(), o.getObservationEndTime(), this::setObservationEndTime);
			
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBarrierFeatureSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(observationEndTime, _that.getObservationEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (observationEndTime != null ? observationEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBarrierFeatureSequenceSequenceBuilder {" +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}
}
