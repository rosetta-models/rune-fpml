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
import fpml.confirmation.FxAccrualRegion;
import fpml.confirmation.FxAccrualRegion.FxAccrualRegionBuilder;
import fpml.confirmation.FxAccrualRegion.FxAccrualRegionBuilderImpl;
import fpml.confirmation.FxAccrualRegion.FxAccrualRegionImpl;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAccrualRegionSequence0;
import fpml.confirmation.FxAccrualRegionSequence1;
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.FxAccrualRegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a region of spot rate where the notional for the settlement period accrues by the accrued amount per fixing each time the spot rate fixes within the region.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualRegion", builder=FxAccrualRegion.FxAccrualRegionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualRegion extends RosettaModelObject {

	FxAccrualRegionMeta metaData = new FxAccrualRegionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the FX rate used as the basis for the condition (the accrual region).
	 */
	FxRateObservableReference getObservableReference();
	FxAccrualRegionBoundModel getFxAccrualRegionBoundModel();
	FxAccrualRegionSequence0 getFxAccrualRegionSequence0();
	/**
	 * Defines the end date of the observation period for the barrier. If ommitted, the last barrier observation point is understood to be the last fixing date in the fixing schedule.
	 */
	Date getEndDate();
	/**
	 * A multiplier applied to the notional amount per fixing of each currency to specify the amount accrued each time the spot rate fixes within the accrual region. If the accrualFactor is omitted, the factor is one.
	 */
	Schedule getAccrualFactor();
	FxAccrualRegionSequence1 getFxAccrualRegionSequence1();

	/*********************** Build Methods  ***********************/
	FxAccrualRegion build();
	
	FxAccrualRegion.FxAccrualRegionBuilder toBuilder();
	
	static FxAccrualRegion.FxAccrualRegionBuilder builder() {
		return new FxAccrualRegion.FxAccrualRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualRegion> getType() {
		return FxAccrualRegion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.class, getObservableReference());
		processRosetta(path.newSubPath("fxAccrualRegionBoundModel"), processor, FxAccrualRegionBoundModel.class, getFxAccrualRegionBoundModel());
		processRosetta(path.newSubPath("fxAccrualRegionSequence0"), processor, FxAccrualRegionSequence0.class, getFxAccrualRegionSequence0());
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processRosetta(path.newSubPath("accrualFactor"), processor, Schedule.class, getAccrualFactor());
		processRosetta(path.newSubPath("fxAccrualRegionSequence1"), processor, FxAccrualRegionSequence1.class, getFxAccrualRegionSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionBuilder extends FxAccrualRegion, RosettaModelObjectBuilder {
		FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference();
		FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference();
		FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getOrCreateFxAccrualRegionBoundModel();
		FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getFxAccrualRegionBoundModel();
		FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder getOrCreateFxAccrualRegionSequence0();
		FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder getFxAccrualRegionSequence0();
		Schedule.ScheduleBuilder getOrCreateAccrualFactor();
		Schedule.ScheduleBuilder getAccrualFactor();
		FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder getOrCreateFxAccrualRegionSequence1();
		FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder getFxAccrualRegionSequence1();
		FxAccrualRegion.FxAccrualRegionBuilder setObservableReference(FxRateObservableReference observableReference);
		FxAccrualRegion.FxAccrualRegionBuilder setFxAccrualRegionBoundModel(FxAccrualRegionBoundModel fxAccrualRegionBoundModel);
		FxAccrualRegion.FxAccrualRegionBuilder setFxAccrualRegionSequence0(FxAccrualRegionSequence0 fxAccrualRegionSequence0);
		FxAccrualRegion.FxAccrualRegionBuilder setEndDate(Date endDate);
		FxAccrualRegion.FxAccrualRegionBuilder setAccrualFactor(Schedule accrualFactor);
		FxAccrualRegion.FxAccrualRegionBuilder setFxAccrualRegionSequence1(FxAccrualRegionSequence1 fxAccrualRegionSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.FxRateObservableReferenceBuilder.class, getObservableReference());
			processRosetta(path.newSubPath("fxAccrualRegionBoundModel"), processor, FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder.class, getFxAccrualRegionBoundModel());
			processRosetta(path.newSubPath("fxAccrualRegionSequence0"), processor, FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder.class, getFxAccrualRegionSequence0());
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processRosetta(path.newSubPath("accrualFactor"), processor, Schedule.ScheduleBuilder.class, getAccrualFactor());
			processRosetta(path.newSubPath("fxAccrualRegionSequence1"), processor, FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder.class, getFxAccrualRegionSequence1());
		}
		

		FxAccrualRegion.FxAccrualRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegion  ***********************/
	class FxAccrualRegionImpl implements FxAccrualRegion {
		private final FxRateObservableReference observableReference;
		private final FxAccrualRegionBoundModel fxAccrualRegionBoundModel;
		private final FxAccrualRegionSequence0 fxAccrualRegionSequence0;
		private final Date endDate;
		private final Schedule accrualFactor;
		private final FxAccrualRegionSequence1 fxAccrualRegionSequence1;
		
		protected FxAccrualRegionImpl(FxAccrualRegion.FxAccrualRegionBuilder builder) {
			this.observableReference = ofNullable(builder.getObservableReference()).map(f->f.build()).orElse(null);
			this.fxAccrualRegionBoundModel = ofNullable(builder.getFxAccrualRegionBoundModel()).map(f->f.build()).orElse(null);
			this.fxAccrualRegionSequence0 = ofNullable(builder.getFxAccrualRegionSequence0()).map(f->f.build()).orElse(null);
			this.endDate = builder.getEndDate();
			this.accrualFactor = ofNullable(builder.getAccrualFactor()).map(f->f.build()).orElse(null);
			this.fxAccrualRegionSequence1 = ofNullable(builder.getFxAccrualRegionSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observableReference")
		public FxRateObservableReference getObservableReference() {
			return observableReference;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModel")
		public FxAccrualRegionBoundModel getFxAccrualRegionBoundModel() {
			return fxAccrualRegionBoundModel;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionSequence0")
		public FxAccrualRegionSequence0 getFxAccrualRegionSequence0() {
			return fxAccrualRegionSequence0;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		public Schedule getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionSequence1")
		public FxAccrualRegionSequence1 getFxAccrualRegionSequence1() {
			return fxAccrualRegionSequence1;
		}
		
		@Override
		public FxAccrualRegion build() {
			return this;
		}
		
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder toBuilder() {
			FxAccrualRegion.FxAccrualRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegion.FxAccrualRegionBuilder builder) {
			ofNullable(getObservableReference()).ifPresent(builder::setObservableReference);
			ofNullable(getFxAccrualRegionBoundModel()).ifPresent(builder::setFxAccrualRegionBoundModel);
			ofNullable(getFxAccrualRegionSequence0()).ifPresent(builder::setFxAccrualRegionSequence0);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getAccrualFactor()).ifPresent(builder::setAccrualFactor);
			ofNullable(getFxAccrualRegionSequence1()).ifPresent(builder::setFxAccrualRegionSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegion _that = getType().cast(o);
		
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(fxAccrualRegionBoundModel, _that.getFxAccrualRegionBoundModel())) return false;
			if (!Objects.equals(fxAccrualRegionSequence0, _that.getFxAccrualRegionSequence0())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(fxAccrualRegionSequence1, _that.getFxAccrualRegionSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionBoundModel != null ? fxAccrualRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionSequence0 != null ? fxAccrualRegionSequence0.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionSequence1 != null ? fxAccrualRegionSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegion {" +
				"observableReference=" + this.observableReference + ", " +
				"fxAccrualRegionBoundModel=" + this.fxAccrualRegionBoundModel + ", " +
				"fxAccrualRegionSequence0=" + this.fxAccrualRegionSequence0 + ", " +
				"endDate=" + this.endDate + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"fxAccrualRegionSequence1=" + this.fxAccrualRegionSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegion  ***********************/
	class FxAccrualRegionBuilderImpl implements FxAccrualRegion.FxAccrualRegionBuilder {
	
		protected FxRateObservableReference.FxRateObservableReferenceBuilder observableReference;
		protected FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder fxAccrualRegionBoundModel;
		protected FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder fxAccrualRegionSequence0;
		protected Date endDate;
		protected Schedule.ScheduleBuilder accrualFactor;
		protected FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder fxAccrualRegionSequence1;
	
		public FxAccrualRegionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observableReference")
		public FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference() {
			return observableReference;
		}
		
		@Override
		public FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference() {
			FxRateObservableReference.FxRateObservableReferenceBuilder result;
			if (observableReference!=null) {
				result = observableReference;
			}
			else {
				result = observableReference = FxRateObservableReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModel")
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getFxAccrualRegionBoundModel() {
			return fxAccrualRegionBoundModel;
		}
		
		@Override
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getOrCreateFxAccrualRegionBoundModel() {
			FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder result;
			if (fxAccrualRegionBoundModel!=null) {
				result = fxAccrualRegionBoundModel;
			}
			else {
				result = fxAccrualRegionBoundModel = FxAccrualRegionBoundModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionSequence0")
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder getFxAccrualRegionSequence0() {
			return fxAccrualRegionSequence0;
		}
		
		@Override
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder getOrCreateFxAccrualRegionSequence0() {
			FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder result;
			if (fxAccrualRegionSequence0!=null) {
				result = fxAccrualRegionSequence0;
			}
			else {
				result = fxAccrualRegionSequence0 = FxAccrualRegionSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		public Schedule.ScheduleBuilder getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateAccrualFactor() {
			Schedule.ScheduleBuilder result;
			if (accrualFactor!=null) {
				result = accrualFactor;
			}
			else {
				result = accrualFactor = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionSequence1")
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder getFxAccrualRegionSequence1() {
			return fxAccrualRegionSequence1;
		}
		
		@Override
		public FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder getOrCreateFxAccrualRegionSequence1() {
			FxAccrualRegionSequence1.FxAccrualRegionSequence1Builder result;
			if (fxAccrualRegionSequence1!=null) {
				result = fxAccrualRegionSequence1;
			}
			else {
				result = fxAccrualRegionSequence1 = FxAccrualRegionSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observableReference")
		public FxAccrualRegion.FxAccrualRegionBuilder setObservableReference(FxRateObservableReference observableReference) {
			this.observableReference = observableReference==null?null:observableReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModel")
		public FxAccrualRegion.FxAccrualRegionBuilder setFxAccrualRegionBoundModel(FxAccrualRegionBoundModel fxAccrualRegionBoundModel) {
			this.fxAccrualRegionBoundModel = fxAccrualRegionBoundModel==null?null:fxAccrualRegionBoundModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualRegionSequence0")
		public FxAccrualRegion.FxAccrualRegionBuilder setFxAccrualRegionSequence0(FxAccrualRegionSequence0 fxAccrualRegionSequence0) {
			this.fxAccrualRegionSequence0 = fxAccrualRegionSequence0==null?null:fxAccrualRegionSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public FxAccrualRegion.FxAccrualRegionBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		@Override
		@RosettaAttribute("accrualFactor")
		public FxAccrualRegion.FxAccrualRegionBuilder setAccrualFactor(Schedule accrualFactor) {
			this.accrualFactor = accrualFactor==null?null:accrualFactor.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualRegionSequence1")
		public FxAccrualRegion.FxAccrualRegionBuilder setFxAccrualRegionSequence1(FxAccrualRegionSequence1 fxAccrualRegionSequence1) {
			this.fxAccrualRegionSequence1 = fxAccrualRegionSequence1==null?null:fxAccrualRegionSequence1.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegion build() {
			return new FxAccrualRegion.FxAccrualRegionImpl(this);
		}
		
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder prune() {
			if (observableReference!=null && !observableReference.prune().hasData()) observableReference = null;
			if (fxAccrualRegionBoundModel!=null && !fxAccrualRegionBoundModel.prune().hasData()) fxAccrualRegionBoundModel = null;
			if (fxAccrualRegionSequence0!=null && !fxAccrualRegionSequence0.prune().hasData()) fxAccrualRegionSequence0 = null;
			if (accrualFactor!=null && !accrualFactor.prune().hasData()) accrualFactor = null;
			if (fxAccrualRegionSequence1!=null && !fxAccrualRegionSequence1.prune().hasData()) fxAccrualRegionSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservableReference()!=null && getObservableReference().hasData()) return true;
			if (getFxAccrualRegionBoundModel()!=null && getFxAccrualRegionBoundModel().hasData()) return true;
			if (getFxAccrualRegionSequence0()!=null && getFxAccrualRegionSequence0().hasData()) return true;
			if (getEndDate()!=null) return true;
			if (getAccrualFactor()!=null && getAccrualFactor().hasData()) return true;
			if (getFxAccrualRegionSequence1()!=null && getFxAccrualRegionSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegion.FxAccrualRegionBuilder o = (FxAccrualRegion.FxAccrualRegionBuilder) other;
			
			merger.mergeRosetta(getObservableReference(), o.getObservableReference(), this::setObservableReference);
			merger.mergeRosetta(getFxAccrualRegionBoundModel(), o.getFxAccrualRegionBoundModel(), this::setFxAccrualRegionBoundModel);
			merger.mergeRosetta(getFxAccrualRegionSequence0(), o.getFxAccrualRegionSequence0(), this::setFxAccrualRegionSequence0);
			merger.mergeRosetta(getAccrualFactor(), o.getAccrualFactor(), this::setAccrualFactor);
			merger.mergeRosetta(getFxAccrualRegionSequence1(), o.getFxAccrualRegionSequence1(), this::setFxAccrualRegionSequence1);
			
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegion _that = getType().cast(o);
		
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(fxAccrualRegionBoundModel, _that.getFxAccrualRegionBoundModel())) return false;
			if (!Objects.equals(fxAccrualRegionSequence0, _that.getFxAccrualRegionSequence0())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(fxAccrualRegionSequence1, _that.getFxAccrualRegionSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionBoundModel != null ? fxAccrualRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionSequence0 != null ? fxAccrualRegionSequence0.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionSequence1 != null ? fxAccrualRegionSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionBuilder {" +
				"observableReference=" + this.observableReference + ", " +
				"fxAccrualRegionBoundModel=" + this.fxAccrualRegionBoundModel + ", " +
				"fxAccrualRegionSequence0=" + this.fxAccrualRegionSequence0 + ", " +
				"endDate=" + this.endDate + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"fxAccrualRegionSequence1=" + this.fxAccrualRegionSequence1 +
			'}';
		}
	}
}
