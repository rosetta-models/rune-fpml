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
import fpml.confirmation.FxComplexBarrierBaseSequence1;
import fpml.confirmation.FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder;
import fpml.confirmation.FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1BuilderImpl;
import fpml.confirmation.FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Impl;
import fpml.confirmation.meta.FxComplexBarrierBaseSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxComplexBarrierBaseSequence1", builder=FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1BuilderImpl.class, version="${project.version}")
public interface FxComplexBarrierBaseSequence1 extends RosettaModelObject {

	FxComplexBarrierBaseSequence1Meta metaData = new FxComplexBarrierBaseSequence1Meta();

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
	FxComplexBarrierBaseSequence1 build();
	
	FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder toBuilder();
	
	static FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder builder() {
		return new FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxComplexBarrierBaseSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxComplexBarrierBaseSequence1> getType() {
		return FxComplexBarrierBaseSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.class, getObservationEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxComplexBarrierBaseSequence1Builder extends FxComplexBarrierBaseSequence1, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationEndTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationEndTime();
		FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder setObservationEndDate(Date observationEndDate);
		FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder setObservationEndTime(BusinessCenterTime observationEndTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationEndTime());
		}
		

		FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder prune();
	}

	/*********************** Immutable Implementation of FxComplexBarrierBaseSequence1  ***********************/
	class FxComplexBarrierBaseSequence1Impl implements FxComplexBarrierBaseSequence1 {
		private final Date observationEndDate;
		private final BusinessCenterTime observationEndTime;
		
		protected FxComplexBarrierBaseSequence1Impl(FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder builder) {
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
		public FxComplexBarrierBaseSequence1 build() {
			return this;
		}
		
		@Override
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder toBuilder() {
			FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder builder) {
			ofNullable(getObservationEndDate()).ifPresent(builder::setObservationEndDate);
			ofNullable(getObservationEndTime()).ifPresent(builder::setObservationEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBaseSequence1 _that = getType().cast(o);
		
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
			return "FxComplexBarrierBaseSequence1 {" +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxComplexBarrierBaseSequence1  ***********************/
	class FxComplexBarrierBaseSequence1BuilderImpl implements FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder {
	
		protected Date observationEndDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationEndTime;
	
		public FxComplexBarrierBaseSequence1BuilderImpl() {
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
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder setObservationEndDate(Date observationEndDate) {
			this.observationEndDate = observationEndDate==null?null:observationEndDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationEndTime")
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder setObservationEndTime(BusinessCenterTime observationEndTime) {
			this.observationEndTime = observationEndTime==null?null:observationEndTime.toBuilder();
			return this;
		}
		
		@Override
		public FxComplexBarrierBaseSequence1 build() {
			return new FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Impl(this);
		}
		
		@Override
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder prune() {
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
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder o = (FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder) other;
			
			merger.mergeRosetta(getObservationEndTime(), o.getObservationEndTime(), this::setObservationEndTime);
			
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBaseSequence1 _that = getType().cast(o);
		
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
			return "FxComplexBarrierBaseSequence1Builder {" +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}
}
