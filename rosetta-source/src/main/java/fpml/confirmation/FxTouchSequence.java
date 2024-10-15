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
import fpml.confirmation.FxTouchSequence;
import fpml.confirmation.FxTouchSequence.FxTouchSequenceBuilder;
import fpml.confirmation.FxTouchSequence.FxTouchSequenceBuilderImpl;
import fpml.confirmation.FxTouchSequence.FxTouchSequenceImpl;
import fpml.confirmation.FxTouchSequenceSequence;
import fpml.confirmation.meta.FxTouchSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTouchSequence", builder=FxTouchSequence.FxTouchSequenceBuilderImpl.class, version="${project.version}")
public interface FxTouchSequence extends RosettaModelObject {

	FxTouchSequenceMeta metaData = new FxTouchSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the observation period for an american trigger starts. If the start date is not present, then the date and time of the start of the period is deemed to be the date and time the transaction was entered into.
	 */
	Date getObservationStartDate();
	/**
	 * The time on the start date at which the observation period for an american trigger starts. If the time is not present and the start date is equivalent to the transaction date, the time is deemed to be the time the transaction was entered into. If the time is not present and the start date is other than the transaction date, then the time is deemed to be the same as the expiration time.
	 */
	BusinessCenterTime getObservationStartTime();
	FxTouchSequenceSequence getFxTouchSequenceSequence();

	/*********************** Build Methods  ***********************/
	FxTouchSequence build();
	
	FxTouchSequence.FxTouchSequenceBuilder toBuilder();
	
	static FxTouchSequence.FxTouchSequenceBuilder builder() {
		return new FxTouchSequence.FxTouchSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTouchSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTouchSequence> getType() {
		return FxTouchSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
		processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.class, getObservationStartTime());
		processRosetta(path.newSubPath("fxTouchSequenceSequence"), processor, FxTouchSequenceSequence.class, getFxTouchSequenceSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTouchSequenceBuilder extends FxTouchSequence, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationStartTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationStartTime();
		FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder getOrCreateFxTouchSequenceSequence();
		FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder getFxTouchSequenceSequence();
		FxTouchSequence.FxTouchSequenceBuilder setObservationStartDate(Date observationStartDate);
		FxTouchSequence.FxTouchSequenceBuilder setObservationStartTime(BusinessCenterTime observationStartTime);
		FxTouchSequence.FxTouchSequenceBuilder setFxTouchSequenceSequence(FxTouchSequenceSequence fxTouchSequenceSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
			processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationStartTime());
			processRosetta(path.newSubPath("fxTouchSequenceSequence"), processor, FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder.class, getFxTouchSequenceSequence());
		}
		

		FxTouchSequence.FxTouchSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTouchSequence  ***********************/
	class FxTouchSequenceImpl implements FxTouchSequence {
		private final Date observationStartDate;
		private final BusinessCenterTime observationStartTime;
		private final FxTouchSequenceSequence fxTouchSequenceSequence;
		
		protected FxTouchSequenceImpl(FxTouchSequence.FxTouchSequenceBuilder builder) {
			this.observationStartDate = builder.getObservationStartDate();
			this.observationStartTime = ofNullable(builder.getObservationStartTime()).map(f->f.build()).orElse(null);
			this.fxTouchSequenceSequence = ofNullable(builder.getFxTouchSequenceSequence()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("fxTouchSequenceSequence")
		public FxTouchSequenceSequence getFxTouchSequenceSequence() {
			return fxTouchSequenceSequence;
		}
		
		@Override
		public FxTouchSequence build() {
			return this;
		}
		
		@Override
		public FxTouchSequence.FxTouchSequenceBuilder toBuilder() {
			FxTouchSequence.FxTouchSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTouchSequence.FxTouchSequenceBuilder builder) {
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getObservationStartTime()).ifPresent(builder::setObservationStartTime);
			ofNullable(getFxTouchSequenceSequence()).ifPresent(builder::setFxTouchSequenceSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouchSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(fxTouchSequenceSequence, _that.getFxTouchSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (fxTouchSequenceSequence != null ? fxTouchSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTouchSequence {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"fxTouchSequenceSequence=" + this.fxTouchSequenceSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTouchSequence  ***********************/
	class FxTouchSequenceBuilderImpl implements FxTouchSequence.FxTouchSequenceBuilder {
	
		protected Date observationStartDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationStartTime;
		protected FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder fxTouchSequenceSequence;
	
		public FxTouchSequenceBuilderImpl() {
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
		@RosettaAttribute("fxTouchSequenceSequence")
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder getFxTouchSequenceSequence() {
			return fxTouchSequenceSequence;
		}
		
		@Override
		public FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder getOrCreateFxTouchSequenceSequence() {
			FxTouchSequenceSequence.FxTouchSequenceSequenceBuilder result;
			if (fxTouchSequenceSequence!=null) {
				result = fxTouchSequenceSequence;
			}
			else {
				result = fxTouchSequenceSequence = FxTouchSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		public FxTouchSequence.FxTouchSequenceBuilder setObservationStartDate(Date observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationStartTime")
		public FxTouchSequence.FxTouchSequenceBuilder setObservationStartTime(BusinessCenterTime observationStartTime) {
			this.observationStartTime = observationStartTime==null?null:observationStartTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxTouchSequenceSequence")
		public FxTouchSequence.FxTouchSequenceBuilder setFxTouchSequenceSequence(FxTouchSequenceSequence fxTouchSequenceSequence) {
			this.fxTouchSequenceSequence = fxTouchSequenceSequence==null?null:fxTouchSequenceSequence.toBuilder();
			return this;
		}
		
		@Override
		public FxTouchSequence build() {
			return new FxTouchSequence.FxTouchSequenceImpl(this);
		}
		
		@Override
		public FxTouchSequence.FxTouchSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTouchSequence.FxTouchSequenceBuilder prune() {
			if (observationStartTime!=null && !observationStartTime.prune().hasData()) observationStartTime = null;
			if (fxTouchSequenceSequence!=null && !fxTouchSequenceSequence.prune().hasData()) fxTouchSequenceSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationStartDate()!=null) return true;
			if (getObservationStartTime()!=null && getObservationStartTime().hasData()) return true;
			if (getFxTouchSequenceSequence()!=null && getFxTouchSequenceSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTouchSequence.FxTouchSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTouchSequence.FxTouchSequenceBuilder o = (FxTouchSequence.FxTouchSequenceBuilder) other;
			
			merger.mergeRosetta(getObservationStartTime(), o.getObservationStartTime(), this::setObservationStartTime);
			merger.mergeRosetta(getFxTouchSequenceSequence(), o.getFxTouchSequenceSequence(), this::setFxTouchSequenceSequence);
			
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouchSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(fxTouchSequenceSequence, _that.getFxTouchSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (fxTouchSequenceSequence != null ? fxTouchSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTouchSequenceBuilder {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"fxTouchSequenceSequence=" + this.fxTouchSequenceSequence +
			'}';
		}
	}
}
