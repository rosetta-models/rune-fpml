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
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import fpml.confirmation.FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder;
import fpml.confirmation.FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0BuilderImpl;
import fpml.confirmation.FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Impl;
import fpml.confirmation.meta.FxComplexBarrierBaseSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxComplexBarrierBaseSequence0", builder=FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0BuilderImpl.class, version="${project.version}")
public interface FxComplexBarrierBaseSequence0 extends RosettaModelObject {

	FxComplexBarrierBaseSequence0Meta metaData = new FxComplexBarrierBaseSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the observation period for an american barrier starts. If the start date is not present, then the date and time of the start of the period is deemed to be the date and time the transaction was entered into.
	 */
	Date getObservationStartDate();
	/**
	 * The time on the start date at which the observation period for an american barrier starts. If the time is not present and the start date is equivalent to the transaction date, the time is deemed to be the time the transaction was entered into. If the time is not present and the start date is other than the transaction date, then the time is deemed to be the same as the expiration time.
	 */
	BusinessCenterTime getObservationStartTime();

	/*********************** Build Methods  ***********************/
	FxComplexBarrierBaseSequence0 build();
	
	FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder toBuilder();
	
	static FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder builder() {
		return new FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxComplexBarrierBaseSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxComplexBarrierBaseSequence0> getType() {
		return FxComplexBarrierBaseSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
		processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.class, getObservationStartTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxComplexBarrierBaseSequence0Builder extends FxComplexBarrierBaseSequence0, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationStartTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationStartTime();
		FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder setObservationStartDate(Date observationStartDate);
		FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder setObservationStartTime(BusinessCenterTime observationStartTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
			processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationStartTime());
		}
		

		FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder prune();
	}

	/*********************** Immutable Implementation of FxComplexBarrierBaseSequence0  ***********************/
	class FxComplexBarrierBaseSequence0Impl implements FxComplexBarrierBaseSequence0 {
		private final Date observationStartDate;
		private final BusinessCenterTime observationStartTime;
		
		protected FxComplexBarrierBaseSequence0Impl(FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder builder) {
			this.observationStartDate = builder.getObservationStartDate();
			this.observationStartTime = ofNullable(builder.getObservationStartTime()).map(f->f.build()).orElse(null);
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
		public FxComplexBarrierBaseSequence0 build() {
			return this;
		}
		
		@Override
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder toBuilder() {
			FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder builder) {
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getObservationStartTime()).ifPresent(builder::setObservationStartTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBaseSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxComplexBarrierBaseSequence0 {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxComplexBarrierBaseSequence0  ***********************/
	class FxComplexBarrierBaseSequence0BuilderImpl implements FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder {
	
		protected Date observationStartDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationStartTime;
	
		public FxComplexBarrierBaseSequence0BuilderImpl() {
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
		@RosettaAttribute("observationStartDate")
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder setObservationStartDate(Date observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationStartTime")
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder setObservationStartTime(BusinessCenterTime observationStartTime) {
			this.observationStartTime = observationStartTime==null?null:observationStartTime.toBuilder();
			return this;
		}
		
		@Override
		public FxComplexBarrierBaseSequence0 build() {
			return new FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Impl(this);
		}
		
		@Override
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder prune() {
			if (observationStartTime!=null && !observationStartTime.prune().hasData()) observationStartTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationStartDate()!=null) return true;
			if (getObservationStartTime()!=null && getObservationStartTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder o = (FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder) other;
			
			merger.mergeRosetta(getObservationStartTime(), o.getObservationStartTime(), this::setObservationStartTime);
			
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBaseSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxComplexBarrierBaseSequence0Builder {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime +
			'}';
		}
	}
}
