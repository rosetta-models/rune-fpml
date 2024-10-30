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
import fpml.confirmation.ConditionEnum;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.FxTargetLeverage;
import fpml.confirmation.FxTargetLeverage.FxTargetLeverageBuilder;
import fpml.confirmation.FxTargetLeverage.FxTargetLeverageBuilderImpl;
import fpml.confirmation.FxTargetLeverage.FxTargetLeverageImpl;
import fpml.confirmation.FxTargetLeverageSequence;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.FxTargetLeverageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTargetLeverage", builder=FxTargetLeverage.FxTargetLeverageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTargetLeverage extends RosettaModelObject {

	FxTargetLeverageMeta metaData = new FxTargetLeverageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Condition in which leverage applies.
	 */
	ConditionEnum getCondition();
	FxTargetConditionLevelModel getFxTargetConditionLevelModel();
	/**
	 * Leverage rate with optional steps. Format is 2 for 200%.
	 */
	Schedule getRatio();
	FxTargetLeverageSequence getFxTargetLeverageSequence();
	String getId();

	/*********************** Build Methods  ***********************/
	FxTargetLeverage build();
	
	FxTargetLeverage.FxTargetLeverageBuilder toBuilder();
	
	static FxTargetLeverage.FxTargetLeverageBuilder builder() {
		return new FxTargetLeverage.FxTargetLeverageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetLeverage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetLeverage> getType() {
		return FxTargetLeverage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("fxTargetConditionLevelModel"), processor, FxTargetConditionLevelModel.class, getFxTargetConditionLevelModel());
		processRosetta(path.newSubPath("ratio"), processor, Schedule.class, getRatio());
		processRosetta(path.newSubPath("fxTargetLeverageSequence"), processor, FxTargetLeverageSequence.class, getFxTargetLeverageSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetLeverageBuilder extends FxTargetLeverage, RosettaModelObjectBuilder {
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getOrCreateFxTargetConditionLevelModel();
		FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder getFxTargetConditionLevelModel();
		Schedule.ScheduleBuilder getOrCreateRatio();
		Schedule.ScheduleBuilder getRatio();
		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder getOrCreateFxTargetLeverageSequence();
		FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder getFxTargetLeverageSequence();
		FxTargetLeverage.FxTargetLeverageBuilder setCondition(ConditionEnum condition);
		FxTargetLeverage.FxTargetLeverageBuilder setFxTargetConditionLevelModel(FxTargetConditionLevelModel fxTargetConditionLevelModel);
		FxTargetLeverage.FxTargetLeverageBuilder setRatio(Schedule ratio);
		FxTargetLeverage.FxTargetLeverageBuilder setFxTargetLeverageSequence(FxTargetLeverageSequence fxTargetLeverageSequence);
		FxTargetLeverage.FxTargetLeverageBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("fxTargetConditionLevelModel"), processor, FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder.class, getFxTargetConditionLevelModel());
			processRosetta(path.newSubPath("ratio"), processor, Schedule.ScheduleBuilder.class, getRatio());
			processRosetta(path.newSubPath("fxTargetLeverageSequence"), processor, FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder.class, getFxTargetLeverageSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxTargetLeverage.FxTargetLeverageBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetLeverage  ***********************/
	class FxTargetLeverageImpl implements FxTargetLeverage {
		private final ConditionEnum condition;
		private final FxTargetConditionLevelModel fxTargetConditionLevelModel;
		private final Schedule ratio;
		private final FxTargetLeverageSequence fxTargetLeverageSequence;
		private final String id;
		
		protected FxTargetLeverageImpl(FxTargetLeverage.FxTargetLeverageBuilder builder) {
			this.condition = builder.getCondition();
			this.fxTargetConditionLevelModel = ofNullable(builder.getFxTargetConditionLevelModel()).map(f->f.build()).orElse(null);
			this.ratio = ofNullable(builder.getRatio()).map(f->f.build()).orElse(null);
			this.fxTargetLeverageSequence = ofNullable(builder.getFxTargetLeverageSequence()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxTargetConditionLevelModel")
		public FxTargetConditionLevelModel getFxTargetConditionLevelModel() {
			return fxTargetConditionLevelModel;
		}
		
		@Override
		@RosettaAttribute("ratio")
		public Schedule getRatio() {
			return ratio;
		}
		
		@Override
		@RosettaAttribute("fxTargetLeverageSequence")
		public FxTargetLeverageSequence getFxTargetLeverageSequence() {
			return fxTargetLeverageSequence;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxTargetLeverage build() {
			return this;
		}
		
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder toBuilder() {
			FxTargetLeverage.FxTargetLeverageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetLeverage.FxTargetLeverageBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getFxTargetConditionLevelModel()).ifPresent(builder::setFxTargetConditionLevelModel);
			ofNullable(getRatio()).ifPresent(builder::setRatio);
			ofNullable(getFxTargetLeverageSequence()).ifPresent(builder::setFxTargetLeverageSequence);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetLeverage _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxTargetConditionLevelModel, _that.getFxTargetConditionLevelModel())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(fxTargetLeverageSequence, _that.getFxTargetLeverageSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxTargetConditionLevelModel != null ? fxTargetConditionLevelModel.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (fxTargetLeverageSequence != null ? fxTargetLeverageSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetLeverage {" +
				"condition=" + this.condition + ", " +
				"fxTargetConditionLevelModel=" + this.fxTargetConditionLevelModel + ", " +
				"ratio=" + this.ratio + ", " +
				"fxTargetLeverageSequence=" + this.fxTargetLeverageSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetLeverage  ***********************/
	class FxTargetLeverageBuilderImpl implements FxTargetLeverage.FxTargetLeverageBuilder {
	
		protected ConditionEnum condition;
		protected FxTargetConditionLevelModel.FxTargetConditionLevelModelBuilder fxTargetConditionLevelModel;
		protected Schedule.ScheduleBuilder ratio;
		protected FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder fxTargetLeverageSequence;
		protected String id;
	
		public FxTargetLeverageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
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
		@RosettaAttribute("ratio")
		public Schedule.ScheduleBuilder getRatio() {
			return ratio;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateRatio() {
			Schedule.ScheduleBuilder result;
			if (ratio!=null) {
				result = ratio;
			}
			else {
				result = ratio = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxTargetLeverageSequence")
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder getFxTargetLeverageSequence() {
			return fxTargetLeverageSequence;
		}
		
		@Override
		public FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder getOrCreateFxTargetLeverageSequence() {
			FxTargetLeverageSequence.FxTargetLeverageSequenceBuilder result;
			if (fxTargetLeverageSequence!=null) {
				result = fxTargetLeverageSequence;
			}
			else {
				result = fxTargetLeverageSequence = FxTargetLeverageSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxTargetLeverage.FxTargetLeverageBuilder setCondition(ConditionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetConditionLevelModel")
		public FxTargetLeverage.FxTargetLeverageBuilder setFxTargetConditionLevelModel(FxTargetConditionLevelModel fxTargetConditionLevelModel) {
			this.fxTargetConditionLevelModel = fxTargetConditionLevelModel==null?null:fxTargetConditionLevelModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("ratio")
		public FxTargetLeverage.FxTargetLeverageBuilder setRatio(Schedule ratio) {
			this.ratio = ratio==null?null:ratio.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetLeverageSequence")
		public FxTargetLeverage.FxTargetLeverageBuilder setFxTargetLeverageSequence(FxTargetLeverageSequence fxTargetLeverageSequence) {
			this.fxTargetLeverageSequence = fxTargetLeverageSequence==null?null:fxTargetLeverageSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxTargetLeverage.FxTargetLeverageBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxTargetLeverage build() {
			return new FxTargetLeverage.FxTargetLeverageImpl(this);
		}
		
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder prune() {
			if (fxTargetConditionLevelModel!=null && !fxTargetConditionLevelModel.prune().hasData()) fxTargetConditionLevelModel = null;
			if (ratio!=null && !ratio.prune().hasData()) ratio = null;
			if (fxTargetLeverageSequence!=null && !fxTargetLeverageSequence.prune().hasData()) fxTargetLeverageSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getFxTargetConditionLevelModel()!=null && getFxTargetConditionLevelModel().hasData()) return true;
			if (getRatio()!=null && getRatio().hasData()) return true;
			if (getFxTargetLeverageSequence()!=null && getFxTargetLeverageSequence().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetLeverage.FxTargetLeverageBuilder o = (FxTargetLeverage.FxTargetLeverageBuilder) other;
			
			merger.mergeRosetta(getFxTargetConditionLevelModel(), o.getFxTargetConditionLevelModel(), this::setFxTargetConditionLevelModel);
			merger.mergeRosetta(getRatio(), o.getRatio(), this::setRatio);
			merger.mergeRosetta(getFxTargetLeverageSequence(), o.getFxTargetLeverageSequence(), this::setFxTargetLeverageSequence);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetLeverage _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxTargetConditionLevelModel, _that.getFxTargetConditionLevelModel())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(fxTargetLeverageSequence, _that.getFxTargetLeverageSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxTargetConditionLevelModel != null ? fxTargetConditionLevelModel.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (fxTargetLeverageSequence != null ? fxTargetLeverageSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetLeverageBuilder {" +
				"condition=" + this.condition + ", " +
				"fxTargetConditionLevelModel=" + this.fxTargetConditionLevelModel + ", " +
				"ratio=" + this.ratio + ", " +
				"fxTargetLeverageSequence=" + this.fxTargetLeverageSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
