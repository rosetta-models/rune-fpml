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
import fpml.confirmation.FxBarrierFeatureSequence;
import fpml.confirmation.FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder;
import fpml.confirmation.FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilderImpl;
import fpml.confirmation.FxBarrierFeatureSequence.FxBarrierFeatureSequenceImpl;
import fpml.confirmation.FxBarrierFeatureSequenceSequence;
import fpml.confirmation.meta.FxBarrierFeatureSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxBarrierFeatureSequence", builder=FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxBarrierFeatureSequence extends RosettaModelObject {

	FxBarrierFeatureSequenceMeta metaData = new FxBarrierFeatureSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the observation period for an american barrier starts. If the start date is not present, then the date and time of the start of the period is deemed to be the date and time the transaction was entered into.
	 */
	Date getObservationStartDate();
	/**
	 * The time on the start date at which the observation period for an american barrier starts. If the time is not present and the start date is equivalent to the transaction date, the time is deemed to be the time the transaction was entered into. If the time is not present and the start date is other than the transaction date, then the time is deemed to be the same as the expiration time.
	 */
	BusinessCenterTime getObservationStartTime();
	FxBarrierFeatureSequenceSequence getFxBarrierFeatureSequenceSequence();

	/*********************** Build Methods  ***********************/
	FxBarrierFeatureSequence build();
	
	FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder toBuilder();
	
	static FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder builder() {
		return new FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxBarrierFeatureSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxBarrierFeatureSequence> getType() {
		return FxBarrierFeatureSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
		processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.class, getObservationStartTime());
		processRosetta(path.newSubPath("fxBarrierFeatureSequenceSequence"), processor, FxBarrierFeatureSequenceSequence.class, getFxBarrierFeatureSequenceSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxBarrierFeatureSequenceBuilder extends FxBarrierFeatureSequence, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationStartTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationStartTime();
		FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder getOrCreateFxBarrierFeatureSequenceSequence();
		FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder getFxBarrierFeatureSequenceSequence();
		FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder setObservationStartDate(Date observationStartDate);
		FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder setObservationStartTime(BusinessCenterTime observationStartTime);
		FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder setFxBarrierFeatureSequenceSequence(FxBarrierFeatureSequenceSequence fxBarrierFeatureSequenceSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
			processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationStartTime());
			processRosetta(path.newSubPath("fxBarrierFeatureSequenceSequence"), processor, FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder.class, getFxBarrierFeatureSequenceSequence());
		}
		

		FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxBarrierFeatureSequence  ***********************/
	class FxBarrierFeatureSequenceImpl implements FxBarrierFeatureSequence {
		private final Date observationStartDate;
		private final BusinessCenterTime observationStartTime;
		private final FxBarrierFeatureSequenceSequence fxBarrierFeatureSequenceSequence;
		
		protected FxBarrierFeatureSequenceImpl(FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder builder) {
			this.observationStartDate = builder.getObservationStartDate();
			this.observationStartTime = ofNullable(builder.getObservationStartTime()).map(f->f.build()).orElse(null);
			this.fxBarrierFeatureSequenceSequence = ofNullable(builder.getFxBarrierFeatureSequenceSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		public Date getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationStartTime")
		public BusinessCenterTime getObservationStartTime() {
			return observationStartTime;
		}
		
		@Override
		@RosettaAttribute("fxBarrierFeatureSequenceSequence")
		public FxBarrierFeatureSequenceSequence getFxBarrierFeatureSequenceSequence() {
			return fxBarrierFeatureSequenceSequence;
		}
		
		@Override
		public FxBarrierFeatureSequence build() {
			return this;
		}
		
		@Override
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder toBuilder() {
			FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder builder) {
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getObservationStartTime()).ifPresent(builder::setObservationStartTime);
			ofNullable(getFxBarrierFeatureSequenceSequence()).ifPresent(builder::setFxBarrierFeatureSequenceSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBarrierFeatureSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(fxBarrierFeatureSequenceSequence, _that.getFxBarrierFeatureSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (fxBarrierFeatureSequenceSequence != null ? fxBarrierFeatureSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBarrierFeatureSequence {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"fxBarrierFeatureSequenceSequence=" + this.fxBarrierFeatureSequenceSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of FxBarrierFeatureSequence  ***********************/
	class FxBarrierFeatureSequenceBuilderImpl implements FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder {
	
		protected Date observationStartDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationStartTime;
		protected FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder fxBarrierFeatureSequenceSequence;
	
		public FxBarrierFeatureSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observationStartDate")
		public Date getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationStartTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationStartTime() {
			return observationStartTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationStartTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationStartTime!=null) {
				result = observationStartTime;
			}
			else {
				result = observationStartTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxBarrierFeatureSequenceSequence")
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder getFxBarrierFeatureSequenceSequence() {
			return fxBarrierFeatureSequenceSequence;
		}
		
		@Override
		public FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder getOrCreateFxBarrierFeatureSequenceSequence() {
			FxBarrierFeatureSequenceSequence.FxBarrierFeatureSequenceSequenceBuilder result;
			if (fxBarrierFeatureSequenceSequence!=null) {
				result = fxBarrierFeatureSequenceSequence;
			}
			else {
				result = fxBarrierFeatureSequenceSequence = FxBarrierFeatureSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder setObservationStartDate(Date observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationStartTime")
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder setObservationStartTime(BusinessCenterTime observationStartTime) {
			this.observationStartTime = observationStartTime==null?null:observationStartTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxBarrierFeatureSequenceSequence")
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder setFxBarrierFeatureSequenceSequence(FxBarrierFeatureSequenceSequence fxBarrierFeatureSequenceSequence) {
			this.fxBarrierFeatureSequenceSequence = fxBarrierFeatureSequenceSequence==null?null:fxBarrierFeatureSequenceSequence.toBuilder();
			return this;
		}
		
		@Override
		public FxBarrierFeatureSequence build() {
			return new FxBarrierFeatureSequence.FxBarrierFeatureSequenceImpl(this);
		}
		
		@Override
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder prune() {
			if (observationStartTime!=null && !observationStartTime.prune().hasData()) observationStartTime = null;
			if (fxBarrierFeatureSequenceSequence!=null && !fxBarrierFeatureSequenceSequence.prune().hasData()) fxBarrierFeatureSequenceSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationStartDate()!=null) return true;
			if (getObservationStartTime()!=null && getObservationStartTime().hasData()) return true;
			if (getFxBarrierFeatureSequenceSequence()!=null && getFxBarrierFeatureSequenceSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder o = (FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder) other;
			
			merger.mergeRosetta(getObservationStartTime(), o.getObservationStartTime(), this::setObservationStartTime);
			merger.mergeRosetta(getFxBarrierFeatureSequenceSequence(), o.getFxBarrierFeatureSequenceSequence(), this::setFxBarrierFeatureSequenceSequence);
			
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBarrierFeatureSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(fxBarrierFeatureSequenceSequence, _that.getFxBarrierFeatureSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (fxBarrierFeatureSequenceSequence != null ? fxBarrierFeatureSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBarrierFeatureSequenceBuilder {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"fxBarrierFeatureSequenceSequence=" + this.fxBarrierFeatureSequenceSequence +
			'}';
		}
	}
}
