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
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualRegionLowerBound;
import fpml.confirmation.FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder;
import fpml.confirmation.FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilderImpl;
import fpml.confirmation.FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundImpl;
import fpml.confirmation.FxRegionLowerBoundDirectionEnum;
import fpml.confirmation.meta.FxAccrualRegionLowerBoundMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualRegionLowerBound", builder=FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualRegionLowerBound extends RosettaModelObject {

	FxAccrualRegionLowerBoundMeta metaData = new FxAccrualRegionLowerBoundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Lower Bound Direction. It only contains the AtOrAbove and Above values.
	 */
	FxRegionLowerBoundDirectionEnum getCondition();
	FxAccrualConditionLevelModel getFxAccrualConditionLevelModel();

	/*********************** Build Methods  ***********************/
	FxAccrualRegionLowerBound build();
	
	FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder toBuilder();
	
	static FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder() {
		return new FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionLowerBound> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualRegionLowerBound> getType() {
		return FxAccrualRegionLowerBound.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("fxAccrualConditionLevelModel"), processor, FxAccrualConditionLevelModel.class, getFxAccrualConditionLevelModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionLowerBoundBuilder extends FxAccrualRegionLowerBound, RosettaModelObjectBuilder {
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getOrCreateFxAccrualConditionLevelModel();
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getFxAccrualConditionLevelModel();
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum condition);
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setFxAccrualConditionLevelModel(FxAccrualConditionLevelModel fxAccrualConditionLevelModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("fxAccrualConditionLevelModel"), processor, FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder.class, getFxAccrualConditionLevelModel());
		}
		

		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionLowerBound  ***********************/
	class FxAccrualRegionLowerBoundImpl implements FxAccrualRegionLowerBound {
		private final FxRegionLowerBoundDirectionEnum condition;
		private final FxAccrualConditionLevelModel fxAccrualConditionLevelModel;
		
		protected FxAccrualRegionLowerBoundImpl(FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder) {
			this.condition = builder.getCondition();
			this.fxAccrualConditionLevelModel = ofNullable(builder.getFxAccrualConditionLevelModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxRegionLowerBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModel")
		public FxAccrualConditionLevelModel getFxAccrualConditionLevelModel() {
			return fxAccrualConditionLevelModel;
		}
		
		@Override
		public FxAccrualRegionLowerBound build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder toBuilder() {
			FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getFxAccrualConditionLevelModel()).ifPresent(builder::setFxAccrualConditionLevelModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionLowerBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxAccrualConditionLevelModel, _that.getFxAccrualConditionLevelModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxAccrualConditionLevelModel != null ? fxAccrualConditionLevelModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionLowerBound {" +
				"condition=" + this.condition + ", " +
				"fxAccrualConditionLevelModel=" + this.fxAccrualConditionLevelModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionLowerBound  ***********************/
	class FxAccrualRegionLowerBoundBuilderImpl implements FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder {
	
		protected FxRegionLowerBoundDirectionEnum condition;
		protected FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder fxAccrualConditionLevelModel;
	
		public FxAccrualRegionLowerBoundBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("condition")
		public FxRegionLowerBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModel")
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getFxAccrualConditionLevelModel() {
			return fxAccrualConditionLevelModel;
		}
		
		@Override
		public FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getOrCreateFxAccrualConditionLevelModel() {
			FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder result;
			if (fxAccrualConditionLevelModel!=null) {
				result = fxAccrualConditionLevelModel;
			}
			else {
				result = fxAccrualConditionLevelModel = FxAccrualConditionLevelModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModel")
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setFxAccrualConditionLevelModel(FxAccrualConditionLevelModel fxAccrualConditionLevelModel) {
			this.fxAccrualConditionLevelModel = fxAccrualConditionLevelModel==null?null:fxAccrualConditionLevelModel.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegionLowerBound build() {
			return new FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundImpl(this);
		}
		
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder prune() {
			if (fxAccrualConditionLevelModel!=null && !fxAccrualConditionLevelModel.prune().hasData()) fxAccrualConditionLevelModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getFxAccrualConditionLevelModel()!=null && getFxAccrualConditionLevelModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder o = (FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder) other;
			
			merger.mergeRosetta(getFxAccrualConditionLevelModel(), o.getFxAccrualConditionLevelModel(), this::setFxAccrualConditionLevelModel);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionLowerBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxAccrualConditionLevelModel, _that.getFxAccrualConditionLevelModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxAccrualConditionLevelModel != null ? fxAccrualConditionLevelModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionLowerBoundBuilder {" +
				"condition=" + this.condition + ", " +
				"fxAccrualConditionLevelModel=" + this.fxAccrualConditionLevelModel +
			'}';
		}
	}
}
