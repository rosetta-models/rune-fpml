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
import fpml.confirmation.FxTouchSequenceSequence;
import fpml.confirmation.FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder;
import fpml.confirmation.FxTouchSequenceSequence.FxTouchSequenceSequenceBuilderImpl;
import fpml.confirmation.FxTouchSequenceSequence.FxTouchSequenceSequenceImpl;
import fpml.confirmation.meta.FxTouchSequenceSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTouchSequenceSequence", builder=FxTouchSequenceSequence.FxTouchSequenceSequenceBuilderImpl.class, version="${project.version}")
public interface FxTouchSequenceSequence extends RosettaModelObject {

	FxTouchSequenceSequenceMeta metaData = new FxTouchSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the observation period for an american trigger ends. If the end date is not present, then the date and time of the end of the period is deemed to be the date and time of expiration.
	 */
	Date getObservationEndDate();
	/**
	 * The time on the end date at which the observation period for an american trigger ends. If the time is not present, then the time is deemed to be the same as the expiration time.
	 */
	BusinessCenterTime getObservationEndTime();

	/*********************** Build Methods  ***********************/
	FxTouchSequenceSequence build();
	
	FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder toBuilder();
	
	static FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder builder() {
		return new FxTouchSequenceSequence.FxTouchSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTouchSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTouchSequenceSequence> getType() {
		return FxTouchSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.class, getObservationEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTouchSequenceSequenceBuilder extends FxTouchSequenceSequence, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationEndTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationEndTime();
		FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder setObservationEndDate(Date observationEndDate);
		FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder setObservationEndTime(BusinessCenterTime observationEndTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationEndTime());
		}
		

		FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTouchSequenceSequence  ***********************/
	class FxTouchSequenceSequenceImpl implements FxTouchSequenceSequence {
		private final Date observationEndDate;
		private final BusinessCenterTime observationEndTime;
		
		protected FxTouchSequenceSequenceImpl(FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder builder) {
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
		public FxTouchSequenceSequence build() {
			return this;
		}
		
		@Override
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder toBuilder() {
			FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder builder) {
			ofNullable(getObservationEndDate()).ifPresent(builder::setObservationEndDate);
			ofNullable(getObservationEndTime()).ifPresent(builder::setObservationEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouchSequenceSequence _that = getType().cast(o);
		
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
			return "FxTouchSequenceSequence {" +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTouchSequenceSequence  ***********************/
	class FxTouchSequenceSequenceBuilderImpl implements FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder {
	
		protected Date observationEndDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationEndTime;
	
		public FxTouchSequenceSequenceBuilderImpl() {
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
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder setObservationEndDate(Date observationEndDate) {
			this.observationEndDate = observationEndDate==null?null:observationEndDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationEndTime")
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder setObservationEndTime(BusinessCenterTime observationEndTime) {
			this.observationEndTime = observationEndTime==null?null:observationEndTime.toBuilder();
			return this;
		}
		
		@Override
		public FxTouchSequenceSequence build() {
			return new FxTouchSequenceSequence.FxTouchSequenceSequenceImpl(this);
		}
		
		@Override
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder prune() {
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
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder o = (FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder) other;
			
			merger.mergeRosetta(getObservationEndTime(), o.getObservationEndTime(), this::setObservationEndTime);
			
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouchSequenceSequence _that = getType().cast(o);
		
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
			return "FxTouchSequenceSequenceBuilder {" +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}
}
