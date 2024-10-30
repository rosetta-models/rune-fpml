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
import fpml.confirmation.FxAsianFeatureSequence;
import fpml.confirmation.FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder;
import fpml.confirmation.FxAsianFeatureSequence.FxAsianFeatureSequenceBuilderImpl;
import fpml.confirmation.FxAsianFeatureSequence.FxAsianFeatureSequenceImpl;
import fpml.confirmation.FxAverageRateObservationSchedule;
import fpml.confirmation.FxRateObservationModel;
import fpml.confirmation.meta.FxAsianFeatureSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAsianFeatureSequence", builder=FxAsianFeatureSequence.FxAsianFeatureSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAsianFeatureSequence extends RosettaModelObject {

	FxAsianFeatureSequenceMeta metaData = new FxAsianFeatureSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Parametric schedule of rate observations.
	 */
	FxAverageRateObservationSchedule getObservationSchedule();
	FxRateObservationModel getFxRateObservationModel();

	/*********************** Build Methods  ***********************/
	FxAsianFeatureSequence build();
	
	FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder toBuilder();
	
	static FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder builder() {
		return new FxAsianFeatureSequence.FxAsianFeatureSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAsianFeatureSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAsianFeatureSequence> getType() {
		return FxAsianFeatureSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observationSchedule"), processor, FxAverageRateObservationSchedule.class, getObservationSchedule());
		processRosetta(path.newSubPath("fxRateObservationModel"), processor, FxRateObservationModel.class, getFxRateObservationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAsianFeatureSequenceBuilder extends FxAsianFeatureSequence, RosettaModelObjectBuilder {
		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getOrCreateObservationSchedule();
		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getObservationSchedule();
		FxRateObservationModel.FxRateObservationModelBuilder getOrCreateFxRateObservationModel();
		FxRateObservationModel.FxRateObservationModelBuilder getFxRateObservationModel();
		FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder setObservationSchedule(FxAverageRateObservationSchedule observationSchedule);
		FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder setFxRateObservationModel(FxRateObservationModel fxRateObservationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observationSchedule"), processor, FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder.class, getObservationSchedule());
			processRosetta(path.newSubPath("fxRateObservationModel"), processor, FxRateObservationModel.FxRateObservationModelBuilder.class, getFxRateObservationModel());
		}
		

		FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAsianFeatureSequence  ***********************/
	class FxAsianFeatureSequenceImpl implements FxAsianFeatureSequence {
		private final FxAverageRateObservationSchedule observationSchedule;
		private final FxRateObservationModel fxRateObservationModel;
		
		protected FxAsianFeatureSequenceImpl(FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder builder) {
			this.observationSchedule = ofNullable(builder.getObservationSchedule()).map(f->f.build()).orElse(null);
			this.fxRateObservationModel = ofNullable(builder.getFxRateObservationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationSchedule")
		public FxAverageRateObservationSchedule getObservationSchedule() {
			return observationSchedule;
		}
		
		@Override
		@RosettaAttribute("fxRateObservationModel")
		public FxRateObservationModel getFxRateObservationModel() {
			return fxRateObservationModel;
		}
		
		@Override
		public FxAsianFeatureSequence build() {
			return this;
		}
		
		@Override
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder toBuilder() {
			FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder builder) {
			ofNullable(getObservationSchedule()).ifPresent(builder::setObservationSchedule);
			ofNullable(getFxRateObservationModel()).ifPresent(builder::setFxRateObservationModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAsianFeatureSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationSchedule, _that.getObservationSchedule())) return false;
			if (!Objects.equals(fxRateObservationModel, _that.getFxRateObservationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationSchedule != null ? observationSchedule.hashCode() : 0);
			_result = 31 * _result + (fxRateObservationModel != null ? fxRateObservationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAsianFeatureSequence {" +
				"observationSchedule=" + this.observationSchedule + ", " +
				"fxRateObservationModel=" + this.fxRateObservationModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAsianFeatureSequence  ***********************/
	class FxAsianFeatureSequenceBuilderImpl implements FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder {
	
		protected FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder observationSchedule;
		protected FxRateObservationModel.FxRateObservationModelBuilder fxRateObservationModel;
	
		public FxAsianFeatureSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observationSchedule")
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getObservationSchedule() {
			return observationSchedule;
		}
		
		@Override
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getOrCreateObservationSchedule() {
			FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder result;
			if (observationSchedule!=null) {
				result = observationSchedule;
			}
			else {
				result = observationSchedule = FxAverageRateObservationSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxRateObservationModel")
		public FxRateObservationModel.FxRateObservationModelBuilder getFxRateObservationModel() {
			return fxRateObservationModel;
		}
		
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder getOrCreateFxRateObservationModel() {
			FxRateObservationModel.FxRateObservationModelBuilder result;
			if (fxRateObservationModel!=null) {
				result = fxRateObservationModel;
			}
			else {
				result = fxRateObservationModel = FxRateObservationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationSchedule")
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder setObservationSchedule(FxAverageRateObservationSchedule observationSchedule) {
			this.observationSchedule = observationSchedule==null?null:observationSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxRateObservationModel")
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder setFxRateObservationModel(FxRateObservationModel fxRateObservationModel) {
			this.fxRateObservationModel = fxRateObservationModel==null?null:fxRateObservationModel.toBuilder();
			return this;
		}
		
		@Override
		public FxAsianFeatureSequence build() {
			return new FxAsianFeatureSequence.FxAsianFeatureSequenceImpl(this);
		}
		
		@Override
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder prune() {
			if (observationSchedule!=null && !observationSchedule.prune().hasData()) observationSchedule = null;
			if (fxRateObservationModel!=null && !fxRateObservationModel.prune().hasData()) fxRateObservationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationSchedule()!=null && getObservationSchedule().hasData()) return true;
			if (getFxRateObservationModel()!=null && getFxRateObservationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder o = (FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder) other;
			
			merger.mergeRosetta(getObservationSchedule(), o.getObservationSchedule(), this::setObservationSchedule);
			merger.mergeRosetta(getFxRateObservationModel(), o.getFxRateObservationModel(), this::setFxRateObservationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAsianFeatureSequence _that = getType().cast(o);
		
			if (!Objects.equals(observationSchedule, _that.getObservationSchedule())) return false;
			if (!Objects.equals(fxRateObservationModel, _that.getFxRateObservationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationSchedule != null ? observationSchedule.hashCode() : 0);
			_result = 31 * _result + (fxRateObservationModel != null ? fxRateObservationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAsianFeatureSequenceBuilder {" +
				"observationSchedule=" + this.observationSchedule + ", " +
				"fxRateObservationModel=" + this.fxRateObservationModel +
			'}';
		}
	}
}
