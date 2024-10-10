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
import fpml.confirmation.FxAccrualRegionUpperBound;
import fpml.confirmation.FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder;
import fpml.confirmation.FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilderImpl;
import fpml.confirmation.FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundImpl;
import fpml.confirmation.FxRegionUpperBoundDirectionEnum;
import fpml.confirmation.meta.FxAccrualRegionUpperBoundMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualRegionUpperBound", builder=FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilderImpl.class, version="${project.version}")
public interface FxAccrualRegionUpperBound extends RosettaModelObject {

	FxAccrualRegionUpperBoundMeta metaData = new FxAccrualRegionUpperBoundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Upper Bound Direction. It only contains the AtOrBelow and Below values.
	 */
	FxRegionUpperBoundDirectionEnum getCondition();
	FxAccrualConditionLevelModel getFxAccrualConditionLevelModel();

	/*********************** Build Methods  ***********************/
	FxAccrualRegionUpperBound build();
	
	FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder toBuilder();
	
	static FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder() {
		return new FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionUpperBound> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualRegionUpperBound> getType() {
		return FxAccrualRegionUpperBound.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), FxRegionUpperBoundDirectionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("fxAccrualConditionLevelModel"), processor, FxAccrualConditionLevelModel.class, getFxAccrualConditionLevelModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionUpperBoundBuilder extends FxAccrualRegionUpperBound, RosettaModelObjectBuilder {
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getOrCreateFxAccrualConditionLevelModel();
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getFxAccrualConditionLevelModel();
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setCondition(FxRegionUpperBoundDirectionEnum condition);
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setFxAccrualConditionLevelModel(FxAccrualConditionLevelModel fxAccrualConditionLevelModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), FxRegionUpperBoundDirectionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("fxAccrualConditionLevelModel"), processor, FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder.class, getFxAccrualConditionLevelModel());
		}
		

		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionUpperBound  ***********************/
	class FxAccrualRegionUpperBoundImpl implements FxAccrualRegionUpperBound {
		private final FxRegionUpperBoundDirectionEnum condition;
		private final FxAccrualConditionLevelModel fxAccrualConditionLevelModel;
		
		protected FxAccrualRegionUpperBoundImpl(FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder) {
			this.condition = builder.getCondition();
			this.fxAccrualConditionLevelModel = ofNullable(builder.getFxAccrualConditionLevelModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxRegionUpperBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModel")
		public FxAccrualConditionLevelModel getFxAccrualConditionLevelModel() {
			return fxAccrualConditionLevelModel;
		}
		
		@Override
		public FxAccrualRegionUpperBound build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder toBuilder() {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getFxAccrualConditionLevelModel()).ifPresent(builder::setFxAccrualConditionLevelModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionUpperBound _that = getType().cast(o);
		
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
			return "FxAccrualRegionUpperBound {" +
				"condition=" + this.condition + ", " +
				"fxAccrualConditionLevelModel=" + this.fxAccrualConditionLevelModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionUpperBound  ***********************/
	class FxAccrualRegionUpperBoundBuilderImpl implements FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder {
	
		protected FxRegionUpperBoundDirectionEnum condition;
		protected FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder fxAccrualConditionLevelModel;
	
		public FxAccrualRegionUpperBoundBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("condition")
		public FxRegionUpperBoundDirectionEnum getCondition() {
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
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setCondition(FxRegionUpperBoundDirectionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModel")
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setFxAccrualConditionLevelModel(FxAccrualConditionLevelModel fxAccrualConditionLevelModel) {
			this.fxAccrualConditionLevelModel = fxAccrualConditionLevelModel==null?null:fxAccrualConditionLevelModel.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegionUpperBound build() {
			return new FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundImpl(this);
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder prune() {
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
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder o = (FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder) other;
			
			merger.mergeRosetta(getFxAccrualConditionLevelModel(), o.getFxAccrualConditionLevelModel(), this::setFxAccrualConditionLevelModel);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionUpperBound _that = getType().cast(o);
		
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
			return "FxAccrualRegionUpperBoundBuilder {" +
				"condition=" + this.condition + ", " +
				"fxAccrualConditionLevelModel=" + this.fxAccrualConditionLevelModel +
			'}';
		}
	}
}
