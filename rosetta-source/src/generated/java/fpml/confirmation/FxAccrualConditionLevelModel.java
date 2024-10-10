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
import fpml.confirmation.FxAccrualAverageStrikeReference;
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder;
import fpml.confirmation.FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilderImpl;
import fpml.confirmation.FxAccrualConditionLevelModel.FxAccrualConditionLevelModelImpl;
import fpml.confirmation.FxAccrualConditionLevelModelSequence;
import fpml.confirmation.FxAccrualStrikeReference;
import fpml.confirmation.FxAccrualTriggerReference;
import fpml.confirmation.meta.FxAccrualConditionLevelModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Conditions can be expressed in different ways: as a specific level, or a reference to a strike, or a reference to an average strike in FxAccrualForward and FxAccrualOption, or a reference to a trigger in FxDigitalOption.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualConditionLevelModel", builder=FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilderImpl.class, version="${project.version}")
public interface FxAccrualConditionLevelModel extends RosettaModelObject {

	FxAccrualConditionLevelModelMeta metaData = new FxAccrualConditionLevelModelMeta();

	/*********************** Getter Methods  ***********************/
	FxAccrualConditionLevelModelSequence getFxAccrualConditionLevelModelSequence();
	/**
	 * Reference to a strike defined within the FxAccrualForward and FxAccrualOption products.
	 */
	FxAccrualStrikeReference getStrikeReference();
	/**
	 * Reference to an average rate defined within the FxAccrualForward and FxAccrualOption products.
	 */
	FxAccrualAverageStrikeReference getAverageStrikeReference();
	/**
	 * Reference to a trigger defined within the FxAccrualDigitalOption product.
	 */
	FxAccrualTriggerReference getTriggerReference();

	/*********************** Build Methods  ***********************/
	FxAccrualConditionLevelModel build();
	
	FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder toBuilder();
	
	static FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder builder() {
		return new FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualConditionLevelModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualConditionLevelModel> getType() {
		return FxAccrualConditionLevelModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxAccrualConditionLevelModelSequence"), processor, FxAccrualConditionLevelModelSequence.class, getFxAccrualConditionLevelModelSequence());
		processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.class, getStrikeReference());
		processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.class, getAverageStrikeReference());
		processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.class, getTriggerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualConditionLevelModelBuilder extends FxAccrualConditionLevelModel, RosettaModelObjectBuilder {
		FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder getOrCreateFxAccrualConditionLevelModelSequence();
		FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder getFxAccrualConditionLevelModelSequence();
		FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getOrCreateStrikeReference();
		FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getStrikeReference();
		FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getOrCreateAverageStrikeReference();
		FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getAverageStrikeReference();
		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getOrCreateTriggerReference();
		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getTriggerReference();
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setFxAccrualConditionLevelModelSequence(FxAccrualConditionLevelModelSequence fxAccrualConditionLevelModelSequence);
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setStrikeReference(FxAccrualStrikeReference strikeReference);
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference averageStrikeReference);
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setTriggerReference(FxAccrualTriggerReference triggerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxAccrualConditionLevelModelSequence"), processor, FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder.class, getFxAccrualConditionLevelModelSequence());
			processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder.class, getStrikeReference());
			processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder.class, getAverageStrikeReference());
			processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder.class, getTriggerReference());
		}
		

		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualConditionLevelModel  ***********************/
	class FxAccrualConditionLevelModelImpl implements FxAccrualConditionLevelModel {
		private final FxAccrualConditionLevelModelSequence fxAccrualConditionLevelModelSequence;
		private final FxAccrualStrikeReference strikeReference;
		private final FxAccrualAverageStrikeReference averageStrikeReference;
		private final FxAccrualTriggerReference triggerReference;
		
		protected FxAccrualConditionLevelModelImpl(FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder builder) {
			this.fxAccrualConditionLevelModelSequence = ofNullable(builder.getFxAccrualConditionLevelModelSequence()).map(f->f.build()).orElse(null);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
			this.averageStrikeReference = ofNullable(builder.getAverageStrikeReference()).map(f->f.build()).orElse(null);
			this.triggerReference = ofNullable(builder.getTriggerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModelSequence")
		public FxAccrualConditionLevelModelSequence getFxAccrualConditionLevelModelSequence() {
			return fxAccrualConditionLevelModelSequence;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		public FxAccrualStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		@RosettaAttribute("averageStrikeReference")
		public FxAccrualAverageStrikeReference getAverageStrikeReference() {
			return averageStrikeReference;
		}
		
		@Override
		@RosettaAttribute("triggerReference")
		public FxAccrualTriggerReference getTriggerReference() {
			return triggerReference;
		}
		
		@Override
		public FxAccrualConditionLevelModel build() {
			return this;
		}
		
		@Override
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder toBuilder() {
			FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder builder) {
			ofNullable(getFxAccrualConditionLevelModelSequence()).ifPresent(builder::setFxAccrualConditionLevelModelSequence);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
			ofNullable(getAverageStrikeReference()).ifPresent(builder::setAverageStrikeReference);
			ofNullable(getTriggerReference()).ifPresent(builder::setTriggerReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualConditionLevelModel _that = getType().cast(o);
		
			if (!Objects.equals(fxAccrualConditionLevelModelSequence, _that.getFxAccrualConditionLevelModelSequence())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(averageStrikeReference, _that.getAverageStrikeReference())) return false;
			if (!Objects.equals(triggerReference, _that.getTriggerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxAccrualConditionLevelModelSequence != null ? fxAccrualConditionLevelModelSequence.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (averageStrikeReference != null ? averageStrikeReference.hashCode() : 0);
			_result = 31 * _result + (triggerReference != null ? triggerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualConditionLevelModel {" +
				"fxAccrualConditionLevelModelSequence=" + this.fxAccrualConditionLevelModelSequence + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"averageStrikeReference=" + this.averageStrikeReference + ", " +
				"triggerReference=" + this.triggerReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualConditionLevelModel  ***********************/
	class FxAccrualConditionLevelModelBuilderImpl implements FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder {
	
		protected FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder fxAccrualConditionLevelModelSequence;
		protected FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder strikeReference;
		protected FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder averageStrikeReference;
		protected FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder triggerReference;
	
		public FxAccrualConditionLevelModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModelSequence")
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder getFxAccrualConditionLevelModelSequence() {
			return fxAccrualConditionLevelModelSequence;
		}
		
		@Override
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder getOrCreateFxAccrualConditionLevelModelSequence() {
			FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder result;
			if (fxAccrualConditionLevelModelSequence!=null) {
				result = fxAccrualConditionLevelModelSequence;
			}
			else {
				result = fxAccrualConditionLevelModelSequence = FxAccrualConditionLevelModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxAccrualStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageStrikeReference")
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getAverageStrikeReference() {
			return averageStrikeReference;
		}
		
		@Override
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getOrCreateAverageStrikeReference() {
			FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder result;
			if (averageStrikeReference!=null) {
				result = averageStrikeReference;
			}
			else {
				result = averageStrikeReference = FxAccrualAverageStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerReference")
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getTriggerReference() {
			return triggerReference;
		}
		
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getOrCreateTriggerReference() {
			FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder result;
			if (triggerReference!=null) {
				result = triggerReference;
			}
			else {
				result = triggerReference = FxAccrualTriggerReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModelSequence")
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setFxAccrualConditionLevelModelSequence(FxAccrualConditionLevelModelSequence fxAccrualConditionLevelModelSequence) {
			this.fxAccrualConditionLevelModelSequence = fxAccrualConditionLevelModelSequence==null?null:fxAccrualConditionLevelModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikeReference")
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setStrikeReference(FxAccrualStrikeReference strikeReference) {
			this.strikeReference = strikeReference==null?null:strikeReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averageStrikeReference")
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference averageStrikeReference) {
			this.averageStrikeReference = averageStrikeReference==null?null:averageStrikeReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerReference")
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder setTriggerReference(FxAccrualTriggerReference triggerReference) {
			this.triggerReference = triggerReference==null?null:triggerReference.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualConditionLevelModel build() {
			return new FxAccrualConditionLevelModel.FxAccrualConditionLevelModelImpl(this);
		}
		
		@Override
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder prune() {
			if (fxAccrualConditionLevelModelSequence!=null && !fxAccrualConditionLevelModelSequence.prune().hasData()) fxAccrualConditionLevelModelSequence = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			if (averageStrikeReference!=null && !averageStrikeReference.prune().hasData()) averageStrikeReference = null;
			if (triggerReference!=null && !triggerReference.prune().hasData()) triggerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxAccrualConditionLevelModelSequence()!=null && getFxAccrualConditionLevelModelSequence().hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			if (getAverageStrikeReference()!=null && getAverageStrikeReference().hasData()) return true;
			if (getTriggerReference()!=null && getTriggerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder o = (FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder) other;
			
			merger.mergeRosetta(getFxAccrualConditionLevelModelSequence(), o.getFxAccrualConditionLevelModelSequence(), this::setFxAccrualConditionLevelModelSequence);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			merger.mergeRosetta(getAverageStrikeReference(), o.getAverageStrikeReference(), this::setAverageStrikeReference);
			merger.mergeRosetta(getTriggerReference(), o.getTriggerReference(), this::setTriggerReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualConditionLevelModel _that = getType().cast(o);
		
			if (!Objects.equals(fxAccrualConditionLevelModelSequence, _that.getFxAccrualConditionLevelModelSequence())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(averageStrikeReference, _that.getAverageStrikeReference())) return false;
			if (!Objects.equals(triggerReference, _that.getTriggerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxAccrualConditionLevelModelSequence != null ? fxAccrualConditionLevelModelSequence.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (averageStrikeReference != null ? averageStrikeReference.hashCode() : 0);
			_result = 31 * _result + (triggerReference != null ? triggerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualConditionLevelModelBuilder {" +
				"fxAccrualConditionLevelModelSequence=" + this.fxAccrualConditionLevelModelSequence + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"averageStrikeReference=" + this.averageStrikeReference + ", " +
				"triggerReference=" + this.triggerReference +
			'}';
		}
	}
}
