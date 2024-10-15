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
import fpml.confirmation.FxRegionLowerBoundDirectionEnum;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.FxTargetRegionLowerBound;
import fpml.confirmation.FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder;
import fpml.confirmation.FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilderImpl;
import fpml.confirmation.FxTargetRegionLowerBound.FxTargetRegionLowerBoundImpl;
import fpml.confirmation.meta.FxTargetRegionLowerBoundMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetRegionLowerBound", builder=FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilderImpl.class, version="${project.version}")
public interface FxTargetRegionLowerBound extends RosettaModelObject {

	FxTargetRegionLowerBoundMeta metaData = new FxTargetRegionLowerBoundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * AtOrAbove, Above.
	 */
	FxRegionLowerBoundDirectionEnum getCondition();
	FxTargetConditionLevelModel getFxTargetConditionLevelModel();

	/*********************** Build Methods  ***********************/
	FxTargetRegionLowerBound build();
	
	FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder toBuilder();
	
	static FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder() {
		return new FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetRegionLowerBound> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetRegionLowerBound> getType() {
		return FxTargetRegionLowerBound.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("fxTargetConditionLevelModel"), processor, FxTargetConditionLevelModel.class, getFxTargetConditionLevelModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetRegionLowerBoundBuilder extends FxTargetRegionLowerBound, RosettaModelObjectBuilder {
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getOrCreateFxTargetConditionLevelModel();
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getFxTargetConditionLevelModel();
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum condition);
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setFxTargetConditionLevelModel(FxTargetConditionLevelModel fxTargetConditionLevelModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("fxTargetConditionLevelModel"), processor, FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder.class, getFxTargetConditionLevelModel());
		}
		

		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetRegionLowerBound  ***********************/
	class FxTargetRegionLowerBoundImpl implements FxTargetRegionLowerBound {
		private final FxRegionLowerBoundDirectionEnum condition;
		private final FxTargetConditionLevelModel fxTargetConditionLevelModel;
		
		protected FxTargetRegionLowerBoundImpl(FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder) {
			this.condition = builder.getCondition();
			this.fxTargetConditionLevelModel = ofNullable(builder.getFxTargetConditionLevelModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxRegionLowerBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxTargetConditionLevelModel")
		public FxTargetConditionLevelModel getFxTargetConditionLevelModel() {
			return fxTargetConditionLevelModel;
		}
		
		@Override
		public FxTargetRegionLowerBound build() {
			return this;
		}
		
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder toBuilder() {
			FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getFxTargetConditionLevelModel()).ifPresent(builder::setFxTargetConditionLevelModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionLowerBound _that = getType().cast(o);
		
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
			return "FxTargetRegionLowerBound {" +
				"condition=" + this.condition + ", " +
				"fxTargetConditionLevelModel=" + this.fxTargetConditionLevelModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetRegionLowerBound  ***********************/
	class FxTargetRegionLowerBoundBuilderImpl implements FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder {
	
		protected FxRegionLowerBoundDirectionEnum condition;
		protected FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder fxTargetConditionLevelModel;
	
		public FxTargetRegionLowerBoundBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("condition")
		public FxRegionLowerBoundDirectionEnum getCondition() {
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
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetConditionLevelModel")
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setFxTargetConditionLevelModel(FxTargetConditionLevelModel fxTargetConditionLevelModel) {
			this.fxTargetConditionLevelModel = fxTargetConditionLevelModel==null?null:fxTargetConditionLevelModel.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetRegionLowerBound build() {
			return new FxTargetRegionLowerBound.FxTargetRegionLowerBoundImpl(this);
		}
		
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder prune() {
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
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder o = (FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder) other;
			
			merger.mergeRosetta(getFxTargetConditionLevelModel(), o.getFxTargetConditionLevelModel(), this::setFxTargetConditionLevelModel);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionLowerBound _that = getType().cast(o);
		
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
			return "FxTargetRegionLowerBoundBuilder {" +
				"condition=" + this.condition + ", " +
				"fxTargetConditionLevelModel=" + this.fxTargetConditionLevelModel +
			'}';
		}
	}
}
