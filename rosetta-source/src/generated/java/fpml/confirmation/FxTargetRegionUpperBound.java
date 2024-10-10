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
import fpml.confirmation.FxRegionUpperBoundDirectionEnum;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.FxTargetRegionUpperBound;
import fpml.confirmation.FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder;
import fpml.confirmation.FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilderImpl;
import fpml.confirmation.FxTargetRegionUpperBound.FxTargetRegionUpperBoundImpl;
import fpml.confirmation.meta.FxTargetRegionUpperBoundMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetRegionUpperBound", builder=FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilderImpl.class, version="${project.version}")
public interface FxTargetRegionUpperBound extends RosettaModelObject {

	FxTargetRegionUpperBoundMeta metaData = new FxTargetRegionUpperBoundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * AtOrBelow, Below.
	 */
	FxRegionUpperBoundDirectionEnum getCondition();
	FxTargetConditionLevelModel getFxTargetConditionLevelModel();

	/*********************** Build Methods  ***********************/
	FxTargetRegionUpperBound build();
	
	FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder toBuilder();
	
	static FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder builder() {
		return new FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetRegionUpperBound> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetRegionUpperBound> getType() {
		return FxTargetRegionUpperBound.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), FxRegionUpperBoundDirectionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("fxTargetConditionLevelModel"), processor, FxTargetConditionLevelModel.class, getFxTargetConditionLevelModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetRegionUpperBoundBuilder extends FxTargetRegionUpperBound, RosettaModelObjectBuilder {
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getOrCreateFxTargetConditionLevelModel();
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getFxTargetConditionLevelModel();
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder setCondition(FxRegionUpperBoundDirectionEnum condition);
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder setFxTargetConditionLevelModel(FxTargetConditionLevelModel fxTargetConditionLevelModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), FxRegionUpperBoundDirectionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("fxTargetConditionLevelModel"), processor, FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder.class, getFxTargetConditionLevelModel());
		}
		

		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetRegionUpperBound  ***********************/
	class FxTargetRegionUpperBoundImpl implements FxTargetRegionUpperBound {
		private final FxRegionUpperBoundDirectionEnum condition;
		private final FxTargetConditionLevelModel fxTargetConditionLevelModel;
		
		protected FxTargetRegionUpperBoundImpl(FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder builder) {
			this.condition = builder.getCondition();
			this.fxTargetConditionLevelModel = ofNullable(builder.getFxTargetConditionLevelModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxRegionUpperBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxTargetConditionLevelModel")
		public FxTargetConditionLevelModel getFxTargetConditionLevelModel() {
			return fxTargetConditionLevelModel;
		}
		
		@Override
		public FxTargetRegionUpperBound build() {
			return this;
		}
		
		@Override
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder toBuilder() {
			FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getFxTargetConditionLevelModel()).ifPresent(builder::setFxTargetConditionLevelModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionUpperBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxTargetConditionLevelModel, _that.getFxTargetConditionLevelModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxTargetConditionLevelModel != null ? fxTargetConditionLevelModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionUpperBound {" +
				"condition=" + this.condition + ", " +
				"fxTargetConditionLevelModel=" + this.fxTargetConditionLevelModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetRegionUpperBound  ***********************/
	class FxTargetRegionUpperBoundBuilderImpl implements FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder {
	
		protected FxRegionUpperBoundDirectionEnum condition;
		protected FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder fxTargetConditionLevelModel;
	
		public FxTargetRegionUpperBoundBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("condition")
		public FxRegionUpperBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxTargetConditionLevelModel")
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getFxTargetConditionLevelModel() {
			return fxTargetConditionLevelModel;
		}
		
		@Override
		public FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getOrCreateFxTargetConditionLevelModel() {
			FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder result;
			if (fxTargetConditionLevelModel!=null) {
				result = fxTargetConditionLevelModel;
			}
			else {
				result = fxTargetConditionLevelModel = FxTargetConditionLevelModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder setCondition(FxRegionUpperBoundDirectionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetConditionLevelModel")
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder setFxTargetConditionLevelModel(FxTargetConditionLevelModel fxTargetConditionLevelModel) {
			this.fxTargetConditionLevelModel = fxTargetConditionLevelModel==null?null:fxTargetConditionLevelModel.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetRegionUpperBound build() {
			return new FxTargetRegionUpperBound.FxTargetRegionUpperBoundImpl(this);
		}
		
		@Override
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder prune() {
			if (fxTargetConditionLevelModel!=null && !fxTargetConditionLevelModel.prune().hasData()) fxTargetConditionLevelModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getFxTargetConditionLevelModel()!=null && getFxTargetConditionLevelModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder o = (FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder) other;
			
			merger.mergeRosetta(getFxTargetConditionLevelModel(), o.getFxTargetConditionLevelModel(), this::setFxTargetConditionLevelModel);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionUpperBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxTargetConditionLevelModel, _that.getFxTargetConditionLevelModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxTargetConditionLevelModel != null ? fxTargetConditionLevelModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionUpperBoundBuilder {" +
				"condition=" + this.condition + ", " +
				"fxTargetConditionLevelModel=" + this.fxTargetConditionLevelModel +
			'}';
		}
	}
}
