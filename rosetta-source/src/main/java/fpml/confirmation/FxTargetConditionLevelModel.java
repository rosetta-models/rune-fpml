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
import fpml.confirmation.FxComplexBarrierBaseReference;
import fpml.confirmation.FxLevel;
import fpml.confirmation.FxLevelReference;
import fpml.confirmation.FxPivotReference;
import fpml.confirmation.FxStrikeReference;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder;
import fpml.confirmation.FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilderImpl;
import fpml.confirmation.FxTargetConditionLevelModel.FxTargetConditionLevelModelImpl;
import fpml.confirmation.meta.FxTargetConditionLevelModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Conditions can be expressed in different ways: as a specific level, as strike, pivot, or barrier.
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetConditionLevelModel", builder=FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilderImpl.class, version="${project.version}")
public interface FxTargetConditionLevelModel extends RosettaModelObject {

	FxTargetConditionLevelModelMeta metaData = new FxTargetConditionLevelModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Level expressed as a level with optional steps different from strike, pivot, or barrier.
	 */
	FxLevel getLevel();
	/**
	 * Reference to a strike defined within the FX product.
	 */
	FxStrikeReference getStrikeReference();
	/**
	 * Reference to the pivot defined within the FX product.
	 */
	FxPivotReference getPivotReference();
	/**
	 * Reference to a perExpiryBarrier component to indicate theat the bound of the region is defined by the barrier component.
	 */
	FxComplexBarrierBaseReference getBarrierReference();
	/**
	 * Reference to a level defined within the FX product.
	 */
	FxLevelReference getLevelReference();

	/*********************** Build Methods  ***********************/
	FxTargetConditionLevelModel build();
	
	FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder toBuilder();
	
	static FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder builder() {
		return new FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetConditionLevelModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetConditionLevelModel> getType() {
		return FxTargetConditionLevelModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("level"), processor, FxLevel.class, getLevel());
		processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.class, getStrikeReference());
		processRosetta(path.newSubPath("pivotReference"), processor, FxPivotReference.class, getPivotReference());
		processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.class, getBarrierReference());
		processRosetta(path.newSubPath("levelReference"), processor, FxLevelReference.class, getLevelReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetConditionLevelModelBuilder extends FxTargetConditionLevelModel, RosettaModelObjectBuilder {
		FxLevel.FxLevelBuilder getOrCreateLevel();
		FxLevel.FxLevelBuilder getLevel();
		FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference();
		FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference();
		FxPivotReference.FxPivotReferenceBuilder getOrCreatePivotReference();
		FxPivotReference.FxPivotReferenceBuilder getPivotReference();
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference();
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference();
		FxLevelReference.FxLevelReferenceBuilder getOrCreateLevelReference();
		FxLevelReference.FxLevelReferenceBuilder getLevelReference();
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setLevel(FxLevel level);
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setStrikeReference(FxStrikeReference strikeReference);
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setPivotReference(FxPivotReference pivotReference);
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setBarrierReference(FxComplexBarrierBaseReference barrierReference);
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setLevelReference(FxLevelReference levelReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("level"), processor, FxLevel.FxLevelBuilder.class, getLevel());
			processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.FxStrikeReferenceBuilder.class, getStrikeReference());
			processRosetta(path.newSubPath("pivotReference"), processor, FxPivotReference.FxPivotReferenceBuilder.class, getPivotReference());
			processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder.class, getBarrierReference());
			processRosetta(path.newSubPath("levelReference"), processor, FxLevelReference.FxLevelReferenceBuilder.class, getLevelReference());
		}
		

		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetConditionLevelModel  ***********************/
	class FxTargetConditionLevelModelImpl implements FxTargetConditionLevelModel {
		private final FxLevel level;
		private final FxStrikeReference strikeReference;
		private final FxPivotReference pivotReference;
		private final FxComplexBarrierBaseReference barrierReference;
		private final FxLevelReference levelReference;
		
		protected FxTargetConditionLevelModelImpl(FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder builder) {
			this.level = ofNullable(builder.getLevel()).map(f->f.build()).orElse(null);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
			this.pivotReference = ofNullable(builder.getPivotReference()).map(f->f.build()).orElse(null);
			this.barrierReference = ofNullable(builder.getBarrierReference()).map(f->f.build()).orElse(null);
			this.levelReference = ofNullable(builder.getLevelReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("level")
		public FxLevel getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		public FxStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		@RosettaAttribute("pivotReference")
		public FxPivotReference getPivotReference() {
			return pivotReference;
		}
		
		@Override
		@RosettaAttribute("barrierReference")
		public FxComplexBarrierBaseReference getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		@RosettaAttribute("levelReference")
		public FxLevelReference getLevelReference() {
			return levelReference;
		}
		
		@Override
		public FxTargetConditionLevelModel build() {
			return this;
		}
		
		@Override
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder toBuilder() {
			FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder builder) {
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
			ofNullable(getPivotReference()).ifPresent(builder::setPivotReference);
			ofNullable(getBarrierReference()).ifPresent(builder::setBarrierReference);
			ofNullable(getLevelReference()).ifPresent(builder::setLevelReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConditionLevelModel _that = getType().cast(o);
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(pivotReference, _that.getPivotReference())) return false;
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(levelReference, _that.getLevelReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (pivotReference != null ? pivotReference.hashCode() : 0);
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (levelReference != null ? levelReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConditionLevelModel {" +
				"level=" + this.level + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"pivotReference=" + this.pivotReference + ", " +
				"barrierReference=" + this.barrierReference + ", " +
				"levelReference=" + this.levelReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetConditionLevelModel  ***********************/
	class FxTargetConditionLevelModelBuilderImpl implements FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder {
	
		protected FxLevel.FxLevelBuilder level;
		protected FxStrikeReference.FxStrikeReferenceBuilder strikeReference;
		protected FxPivotReference.FxPivotReferenceBuilder pivotReference;
		protected FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder barrierReference;
		protected FxLevelReference.FxLevelReferenceBuilder levelReference;
	
		public FxTargetConditionLevelModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("level")
		public FxLevel.FxLevelBuilder getLevel() {
			return level;
		}
		
		@Override
		public FxLevel.FxLevelBuilder getOrCreateLevel() {
			FxLevel.FxLevelBuilder result;
			if (level!=null) {
				result = level;
			}
			else {
				result = level = FxLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		public FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxStrikeReference.FxStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pivotReference")
		public FxPivotReference.FxPivotReferenceBuilder getPivotReference() {
			return pivotReference;
		}
		
		@Override
		public FxPivotReference.FxPivotReferenceBuilder getOrCreatePivotReference() {
			FxPivotReference.FxPivotReferenceBuilder result;
			if (pivotReference!=null) {
				result = pivotReference;
			}
			else {
				result = pivotReference = FxPivotReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrierReference")
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference() {
			FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder result;
			if (barrierReference!=null) {
				result = barrierReference;
			}
			else {
				result = barrierReference = FxComplexBarrierBaseReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("levelReference")
		public FxLevelReference.FxLevelReferenceBuilder getLevelReference() {
			return levelReference;
		}
		
		@Override
		public FxLevelReference.FxLevelReferenceBuilder getOrCreateLevelReference() {
			FxLevelReference.FxLevelReferenceBuilder result;
			if (levelReference!=null) {
				result = levelReference;
			}
			else {
				result = levelReference = FxLevelReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("level")
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setLevel(FxLevel level) {
			this.level = level==null?null:level.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikeReference")
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setStrikeReference(FxStrikeReference strikeReference) {
			this.strikeReference = strikeReference==null?null:strikeReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pivotReference")
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setPivotReference(FxPivotReference pivotReference) {
			this.pivotReference = pivotReference==null?null:pivotReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrierReference")
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setBarrierReference(FxComplexBarrierBaseReference barrierReference) {
			this.barrierReference = barrierReference==null?null:barrierReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("levelReference")
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder setLevelReference(FxLevelReference levelReference) {
			this.levelReference = levelReference==null?null:levelReference.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetConditionLevelModel build() {
			return new FxTargetConditionLevelModel.FxTargetConditionLevelModelImpl(this);
		}
		
		@Override
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder prune() {
			if (level!=null && !level.prune().hasData()) level = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			if (pivotReference!=null && !pivotReference.prune().hasData()) pivotReference = null;
			if (barrierReference!=null && !barrierReference.prune().hasData()) barrierReference = null;
			if (levelReference!=null && !levelReference.prune().hasData()) levelReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLevel()!=null && getLevel().hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			if (getPivotReference()!=null && getPivotReference().hasData()) return true;
			if (getBarrierReference()!=null && getBarrierReference().hasData()) return true;
			if (getLevelReference()!=null && getLevelReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder o = (FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder) other;
			
			merger.mergeRosetta(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			merger.mergeRosetta(getPivotReference(), o.getPivotReference(), this::setPivotReference);
			merger.mergeRosetta(getBarrierReference(), o.getBarrierReference(), this::setBarrierReference);
			merger.mergeRosetta(getLevelReference(), o.getLevelReference(), this::setLevelReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConditionLevelModel _that = getType().cast(o);
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(pivotReference, _that.getPivotReference())) return false;
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(levelReference, _that.getLevelReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (pivotReference != null ? pivotReference.hashCode() : 0);
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (levelReference != null ? levelReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConditionLevelModelBuilder {" +
				"level=" + this.level + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"pivotReference=" + this.pivotReference + ", " +
				"barrierReference=" + this.barrierReference + ", " +
				"levelReference=" + this.levelReference +
			'}';
		}
	}
}
