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
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualLeverage;
import fpml.confirmation.FxAccrualLeverage.FxAccrualLeverageBuilder;
import fpml.confirmation.FxAccrualLeverage.FxAccrualLeverageBuilderImpl;
import fpml.confirmation.FxAccrualLeverage.FxAccrualLeverageImpl;
import fpml.confirmation.FxAccrualLeverageSequence;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.FxAccrualLeverageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualLeverage", builder=FxAccrualLeverage.FxAccrualLeverageBuilderImpl.class, version="${project.version}")
public interface FxAccrualLeverage extends RosettaModelObject {

	FxAccrualLeverageMeta metaData = new FxAccrualLeverageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Condition in which leverage applies.
	 */
	ConditionEnum getCondition();
	FxAccrualConditionLevelModel getFxAccrualConditionLevelModel();
	/**
	 * Leverage rate with optional steps. Format is 2 for 200%.
	 */
	Schedule getRatio();
	FxAccrualLeverageSequence getFxAccrualLeverageSequence();
	String getId();

	/*********************** Build Methods  ***********************/
	FxAccrualLeverage build();
	
	FxAccrualLeverage.FxAccrualLeverageBuilder toBuilder();
	
	static FxAccrualLeverage.FxAccrualLeverageBuilder builder() {
		return new FxAccrualLeverage.FxAccrualLeverageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualLeverage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualLeverage> getType() {
		return FxAccrualLeverage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("fxAccrualConditionLevelModel"), processor, FxAccrualConditionLevelModel.class, getFxAccrualConditionLevelModel());
		processRosetta(path.newSubPath("ratio"), processor, Schedule.class, getRatio());
		processRosetta(path.newSubPath("fxAccrualLeverageSequence"), processor, FxAccrualLeverageSequence.class, getFxAccrualLeverageSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualLeverageBuilder extends FxAccrualLeverage, RosettaModelObjectBuilder {
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getOrCreateFxAccrualConditionLevelModel();
		FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder getFxAccrualConditionLevelModel();
		Schedule.ScheduleBuilder getOrCreateRatio();
		Schedule.ScheduleBuilder getRatio();
		FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder getOrCreateFxAccrualLeverageSequence();
		FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder getFxAccrualLeverageSequence();
		FxAccrualLeverage.FxAccrualLeverageBuilder setCondition(ConditionEnum condition);
		FxAccrualLeverage.FxAccrualLeverageBuilder setFxAccrualConditionLevelModel(FxAccrualConditionLevelModel fxAccrualConditionLevelModel);
		FxAccrualLeverage.FxAccrualLeverageBuilder setRatio(Schedule ratio);
		FxAccrualLeverage.FxAccrualLeverageBuilder setFxAccrualLeverageSequence(FxAccrualLeverageSequence fxAccrualLeverageSequence);
		FxAccrualLeverage.FxAccrualLeverageBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("fxAccrualConditionLevelModel"), processor, FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder.class, getFxAccrualConditionLevelModel());
			processRosetta(path.newSubPath("ratio"), processor, Schedule.ScheduleBuilder.class, getRatio());
			processRosetta(path.newSubPath("fxAccrualLeverageSequence"), processor, FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder.class, getFxAccrualLeverageSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxAccrualLeverage.FxAccrualLeverageBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualLeverage  ***********************/
	class FxAccrualLeverageImpl implements FxAccrualLeverage {
		private final ConditionEnum condition;
		private final FxAccrualConditionLevelModel fxAccrualConditionLevelModel;
		private final Schedule ratio;
		private final FxAccrualLeverageSequence fxAccrualLeverageSequence;
		private final String id;
		
		protected FxAccrualLeverageImpl(FxAccrualLeverage.FxAccrualLeverageBuilder builder) {
			this.condition = builder.getCondition();
			this.fxAccrualConditionLevelModel = ofNullable(builder.getFxAccrualConditionLevelModel()).map(f->f.build()).orElse(null);
			this.ratio = ofNullable(builder.getRatio()).map(f->f.build()).orElse(null);
			this.fxAccrualLeverageSequence = ofNullable(builder.getFxAccrualLeverageSequence()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModel")
		public FxAccrualConditionLevelModel getFxAccrualConditionLevelModel() {
			return fxAccrualConditionLevelModel;
		}
		
		@Override
		@RosettaAttribute("ratio")
		public Schedule getRatio() {
			return ratio;
		}
		
		@Override
		@RosettaAttribute("fxAccrualLeverageSequence")
		public FxAccrualLeverageSequence getFxAccrualLeverageSequence() {
			return fxAccrualLeverageSequence;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxAccrualLeverage build() {
			return this;
		}
		
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder toBuilder() {
			FxAccrualLeverage.FxAccrualLeverageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualLeverage.FxAccrualLeverageBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getFxAccrualConditionLevelModel()).ifPresent(builder::setFxAccrualConditionLevelModel);
			ofNullable(getRatio()).ifPresent(builder::setRatio);
			ofNullable(getFxAccrualLeverageSequence()).ifPresent(builder::setFxAccrualLeverageSequence);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLeverage _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxAccrualConditionLevelModel, _that.getFxAccrualConditionLevelModel())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(fxAccrualLeverageSequence, _that.getFxAccrualLeverageSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxAccrualConditionLevelModel != null ? fxAccrualConditionLevelModel.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (fxAccrualLeverageSequence != null ? fxAccrualLeverageSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLeverage {" +
				"condition=" + this.condition + ", " +
				"fxAccrualConditionLevelModel=" + this.fxAccrualConditionLevelModel + ", " +
				"ratio=" + this.ratio + ", " +
				"fxAccrualLeverageSequence=" + this.fxAccrualLeverageSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualLeverage  ***********************/
	class FxAccrualLeverageBuilderImpl implements FxAccrualLeverage.FxAccrualLeverageBuilder {
	
		protected ConditionEnum condition;
		protected FxAccrualConditionLevelModel.FxAccrualConditionLevelModelBuilder fxAccrualConditionLevelModel;
		protected Schedule.ScheduleBuilder ratio;
		protected FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder fxAccrualLeverageSequence;
		protected String id;
	
		public FxAccrualLeverageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
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
		@RosettaAttribute("fxAccrualLeverageSequence")
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder getFxAccrualLeverageSequence() {
			return fxAccrualLeverageSequence;
		}
		
		@Override
		public FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder getOrCreateFxAccrualLeverageSequence() {
			FxAccrualLeverageSequence.FxAccrualLeverageSequenceBuilder result;
			if (fxAccrualLeverageSequence!=null) {
				result = fxAccrualLeverageSequence;
			}
			else {
				result = fxAccrualLeverageSequence = FxAccrualLeverageSequence.builder();
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
		public FxAccrualLeverage.FxAccrualLeverageBuilder setCondition(ConditionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualConditionLevelModel")
		public FxAccrualLeverage.FxAccrualLeverageBuilder setFxAccrualConditionLevelModel(FxAccrualConditionLevelModel fxAccrualConditionLevelModel) {
			this.fxAccrualConditionLevelModel = fxAccrualConditionLevelModel==null?null:fxAccrualConditionLevelModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("ratio")
		public FxAccrualLeverage.FxAccrualLeverageBuilder setRatio(Schedule ratio) {
			this.ratio = ratio==null?null:ratio.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualLeverageSequence")
		public FxAccrualLeverage.FxAccrualLeverageBuilder setFxAccrualLeverageSequence(FxAccrualLeverageSequence fxAccrualLeverageSequence) {
			this.fxAccrualLeverageSequence = fxAccrualLeverageSequence==null?null:fxAccrualLeverageSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxAccrualLeverage.FxAccrualLeverageBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxAccrualLeverage build() {
			return new FxAccrualLeverage.FxAccrualLeverageImpl(this);
		}
		
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder prune() {
			if (fxAccrualConditionLevelModel!=null && !fxAccrualConditionLevelModel.prune().hasData()) fxAccrualConditionLevelModel = null;
			if (ratio!=null && !ratio.prune().hasData()) ratio = null;
			if (fxAccrualLeverageSequence!=null && !fxAccrualLeverageSequence.prune().hasData()) fxAccrualLeverageSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getFxAccrualConditionLevelModel()!=null && getFxAccrualConditionLevelModel().hasData()) return true;
			if (getRatio()!=null && getRatio().hasData()) return true;
			if (getFxAccrualLeverageSequence()!=null && getFxAccrualLeverageSequence().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualLeverage.FxAccrualLeverageBuilder o = (FxAccrualLeverage.FxAccrualLeverageBuilder) other;
			
			merger.mergeRosetta(getFxAccrualConditionLevelModel(), o.getFxAccrualConditionLevelModel(), this::setFxAccrualConditionLevelModel);
			merger.mergeRosetta(getRatio(), o.getRatio(), this::setRatio);
			merger.mergeRosetta(getFxAccrualLeverageSequence(), o.getFxAccrualLeverageSequence(), this::setFxAccrualLeverageSequence);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLeverage _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(fxAccrualConditionLevelModel, _that.getFxAccrualConditionLevelModel())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(fxAccrualLeverageSequence, _that.getFxAccrualLeverageSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxAccrualConditionLevelModel != null ? fxAccrualConditionLevelModel.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (fxAccrualLeverageSequence != null ? fxAccrualLeverageSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLeverageBuilder {" +
				"condition=" + this.condition + ", " +
				"fxAccrualConditionLevelModel=" + this.fxAccrualConditionLevelModel + ", " +
				"ratio=" + this.ratio + ", " +
				"fxAccrualLeverageSequence=" + this.fxAccrualLeverageSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
