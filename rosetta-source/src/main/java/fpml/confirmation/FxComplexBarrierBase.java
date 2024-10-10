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
import fpml.confirmation.FxBarrierScopeEnum;
import fpml.confirmation.FxBarrierStyleEnum;
import fpml.confirmation.FxBarrierTypeSimpleEnum;
import fpml.confirmation.FxComplexBarrierBase;
import fpml.confirmation.FxComplexBarrierBase.FxComplexBarrierBaseBuilder;
import fpml.confirmation.FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl;
import fpml.confirmation.FxComplexBarrierBase.FxComplexBarrierBaseImpl;
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import fpml.confirmation.FxComplexBarrierBaseSequence1;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.FxComplexBarrierBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxComplexBarrierBase", builder=FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl.class, version="${project.version}")
public interface FxComplexBarrierBase extends RosettaModelObject {

	FxComplexBarrierBaseMeta metaData = new FxComplexBarrierBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the outcome (action) in the event that the barrier is triggered i.e. whether the product becomes active (Knockin) or is extinguished (Knockout).
	 */
	FxBarrierTypeSimpleEnum getBarrierType();
	/**
	 * The barrier observation style: continuous (American) or discrete (European).
	 */
	FxBarrierStyleEnum getStyle();
	/**
	 * The scope of the barrier (PerExpiry|Global). Specifies whether the barrier has effect for the current expiry period (in the case of a multi-phase product), or for the product as a whole.
	 */
	FxBarrierScopeEnum getScope();
	/**
	 * Defines the condition when the barrier applies: AtOrAbove, AtOrBelow, Above, Below.
	 */
	ConditionEnum getCondition();
	/**
	 * The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a barrier event is deemed to have occurred.
	 */
	Schedule getTriggerRate();
	FxComplexBarrierBaseSequence0 getFxComplexBarrierBaseSequence0();
	FxComplexBarrierBaseSequence1 getFxComplexBarrierBaseSequence1();
	/**
	 * Attribute to be able to point to the
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	FxComplexBarrierBase build();
	
	FxComplexBarrierBase.FxComplexBarrierBaseBuilder toBuilder();
	
	static FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder() {
		return new FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxComplexBarrierBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxComplexBarrierBase> getType() {
		return FxComplexBarrierBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
		processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
		processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("triggerRate"), processor, Schedule.class, getTriggerRate());
		processRosetta(path.newSubPath("fxComplexBarrierBaseSequence0"), processor, FxComplexBarrierBaseSequence0.class, getFxComplexBarrierBaseSequence0());
		processRosetta(path.newSubPath("fxComplexBarrierBaseSequence1"), processor, FxComplexBarrierBaseSequence1.class, getFxComplexBarrierBaseSequence1());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxComplexBarrierBaseBuilder extends FxComplexBarrierBase, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateTriggerRate();
		Schedule.ScheduleBuilder getTriggerRate();
		FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder getOrCreateFxComplexBarrierBaseSequence0();
		FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder getFxComplexBarrierBaseSequence0();
		FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder getOrCreateFxComplexBarrierBaseSequence1();
		FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder getFxComplexBarrierBaseSequence1();
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setStyle(FxBarrierStyleEnum style);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setScope(FxBarrierScopeEnum scope);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setCondition(ConditionEnum condition);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setTriggerRate(Schedule triggerRate);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setFxComplexBarrierBaseSequence0(FxComplexBarrierBaseSequence0 fxComplexBarrierBaseSequence0);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setFxComplexBarrierBaseSequence1(FxComplexBarrierBaseSequence1 fxComplexBarrierBaseSequence1);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
			processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
			processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("triggerRate"), processor, Schedule.ScheduleBuilder.class, getTriggerRate());
			processRosetta(path.newSubPath("fxComplexBarrierBaseSequence0"), processor, FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder.class, getFxComplexBarrierBaseSequence0());
			processRosetta(path.newSubPath("fxComplexBarrierBaseSequence1"), processor, FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder.class, getFxComplexBarrierBaseSequence1());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxComplexBarrierBase.FxComplexBarrierBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FxComplexBarrierBase  ***********************/
	class FxComplexBarrierBaseImpl implements FxComplexBarrierBase {
		private final FxBarrierTypeSimpleEnum barrierType;
		private final FxBarrierStyleEnum style;
		private final FxBarrierScopeEnum scope;
		private final ConditionEnum condition;
		private final Schedule triggerRate;
		private final FxComplexBarrierBaseSequence0 fxComplexBarrierBaseSequence0;
		private final FxComplexBarrierBaseSequence1 fxComplexBarrierBaseSequence1;
		private final String id;
		
		protected FxComplexBarrierBaseImpl(FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder) {
			this.barrierType = builder.getBarrierType();
			this.style = builder.getStyle();
			this.scope = builder.getScope();
			this.condition = builder.getCondition();
			this.triggerRate = ofNullable(builder.getTriggerRate()).map(f->f.build()).orElse(null);
			this.fxComplexBarrierBaseSequence0 = ofNullable(builder.getFxComplexBarrierBaseSequence0()).map(f->f.build()).orElse(null);
			this.fxComplexBarrierBaseSequence1 = ofNullable(builder.getFxComplexBarrierBaseSequence1()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("barrierType")
		public FxBarrierTypeSimpleEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("style")
		public FxBarrierStyleEnum getStyle() {
			return style;
		}
		
		@Override
		@RosettaAttribute("scope")
		public FxBarrierScopeEnum getScope() {
			return scope;
		}
		
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public Schedule getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence0")
		public FxComplexBarrierBaseSequence0 getFxComplexBarrierBaseSequence0() {
			return fxComplexBarrierBaseSequence0;
		}
		
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence1")
		public FxComplexBarrierBaseSequence1 getFxComplexBarrierBaseSequence1() {
			return fxComplexBarrierBaseSequence1;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxComplexBarrierBase build() {
			return this;
		}
		
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder toBuilder() {
			FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder) {
			ofNullable(getBarrierType()).ifPresent(builder::setBarrierType);
			ofNullable(getStyle()).ifPresent(builder::setStyle);
			ofNullable(getScope()).ifPresent(builder::setScope);
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getFxComplexBarrierBaseSequence0()).ifPresent(builder::setFxComplexBarrierBaseSequence0);
			ofNullable(getFxComplexBarrierBaseSequence1()).ifPresent(builder::setFxComplexBarrierBaseSequence1);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBase _that = getType().cast(o);
		
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(style, _that.getStyle())) return false;
			if (!Objects.equals(scope, _that.getScope())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(fxComplexBarrierBaseSequence0, _that.getFxComplexBarrierBaseSequence0())) return false;
			if (!Objects.equals(fxComplexBarrierBaseSequence1, _that.getFxComplexBarrierBaseSequence1())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (style != null ? style.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (scope != null ? scope.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (fxComplexBarrierBaseSequence0 != null ? fxComplexBarrierBaseSequence0.hashCode() : 0);
			_result = 31 * _result + (fxComplexBarrierBaseSequence1 != null ? fxComplexBarrierBaseSequence1.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxComplexBarrierBase {" +
				"barrierType=" + this.barrierType + ", " +
				"style=" + this.style + ", " +
				"scope=" + this.scope + ", " +
				"condition=" + this.condition + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"fxComplexBarrierBaseSequence0=" + this.fxComplexBarrierBaseSequence0 + ", " +
				"fxComplexBarrierBaseSequence1=" + this.fxComplexBarrierBaseSequence1 + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxComplexBarrierBase  ***********************/
	class FxComplexBarrierBaseBuilderImpl implements FxComplexBarrierBase.FxComplexBarrierBaseBuilder {
	
		protected FxBarrierTypeSimpleEnum barrierType;
		protected FxBarrierStyleEnum style;
		protected FxBarrierScopeEnum scope;
		protected ConditionEnum condition;
		protected Schedule.ScheduleBuilder triggerRate;
		protected FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder fxComplexBarrierBaseSequence0;
		protected FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder fxComplexBarrierBaseSequence1;
		protected String id;
	
		public FxComplexBarrierBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("barrierType")
		public FxBarrierTypeSimpleEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("style")
		public FxBarrierStyleEnum getStyle() {
			return style;
		}
		
		@Override
		@RosettaAttribute("scope")
		public FxBarrierScopeEnum getScope() {
			return scope;
		}
		
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public Schedule.ScheduleBuilder getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateTriggerRate() {
			Schedule.ScheduleBuilder result;
			if (triggerRate!=null) {
				result = triggerRate;
			}
			else {
				result = triggerRate = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence0")
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder getFxComplexBarrierBaseSequence0() {
			return fxComplexBarrierBaseSequence0;
		}
		
		@Override
		public FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder getOrCreateFxComplexBarrierBaseSequence0() {
			FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder result;
			if (fxComplexBarrierBaseSequence0!=null) {
				result = fxComplexBarrierBaseSequence0;
			}
			else {
				result = fxComplexBarrierBaseSequence0 = FxComplexBarrierBaseSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence1")
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder getFxComplexBarrierBaseSequence1() {
			return fxComplexBarrierBaseSequence1;
		}
		
		@Override
		public FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder getOrCreateFxComplexBarrierBaseSequence1() {
			FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder result;
			if (fxComplexBarrierBaseSequence1!=null) {
				result = fxComplexBarrierBaseSequence1;
			}
			else {
				result = fxComplexBarrierBaseSequence1 = FxComplexBarrierBaseSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("barrierType")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType) {
			this.barrierType = barrierType==null?null:barrierType;
			return this;
		}
		@Override
		@RosettaAttribute("style")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setStyle(FxBarrierStyleEnum style) {
			this.style = style==null?null:style;
			return this;
		}
		@Override
		@RosettaAttribute("scope")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setScope(FxBarrierScopeEnum scope) {
			this.scope = scope==null?null:scope;
			return this;
		}
		@Override
		@RosettaAttribute("condition")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setCondition(ConditionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setTriggerRate(Schedule triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence0")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setFxComplexBarrierBaseSequence0(FxComplexBarrierBaseSequence0 fxComplexBarrierBaseSequence0) {
			this.fxComplexBarrierBaseSequence0 = fxComplexBarrierBaseSequence0==null?null:fxComplexBarrierBaseSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence1")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setFxComplexBarrierBaseSequence1(FxComplexBarrierBaseSequence1 fxComplexBarrierBaseSequence1) {
			this.fxComplexBarrierBaseSequence1 = fxComplexBarrierBaseSequence1==null?null:fxComplexBarrierBaseSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxComplexBarrierBase build() {
			return new FxComplexBarrierBase.FxComplexBarrierBaseImpl(this);
		}
		
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder prune() {
			if (triggerRate!=null && !triggerRate.prune().hasData()) triggerRate = null;
			if (fxComplexBarrierBaseSequence0!=null && !fxComplexBarrierBaseSequence0.prune().hasData()) fxComplexBarrierBaseSequence0 = null;
			if (fxComplexBarrierBaseSequence1!=null && !fxComplexBarrierBaseSequence1.prune().hasData()) fxComplexBarrierBaseSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBarrierType()!=null) return true;
			if (getStyle()!=null) return true;
			if (getScope()!=null) return true;
			if (getCondition()!=null) return true;
			if (getTriggerRate()!=null && getTriggerRate().hasData()) return true;
			if (getFxComplexBarrierBaseSequence0()!=null && getFxComplexBarrierBaseSequence0().hasData()) return true;
			if (getFxComplexBarrierBaseSequence1()!=null && getFxComplexBarrierBaseSequence1().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxComplexBarrierBase.FxComplexBarrierBaseBuilder o = (FxComplexBarrierBase.FxComplexBarrierBaseBuilder) other;
			
			merger.mergeRosetta(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeRosetta(getFxComplexBarrierBaseSequence0(), o.getFxComplexBarrierBaseSequence0(), this::setFxComplexBarrierBaseSequence0);
			merger.mergeRosetta(getFxComplexBarrierBaseSequence1(), o.getFxComplexBarrierBaseSequence1(), this::setFxComplexBarrierBaseSequence1);
			
			merger.mergeBasic(getBarrierType(), o.getBarrierType(), this::setBarrierType);
			merger.mergeBasic(getStyle(), o.getStyle(), this::setStyle);
			merger.mergeBasic(getScope(), o.getScope(), this::setScope);
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBase _that = getType().cast(o);
		
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(style, _that.getStyle())) return false;
			if (!Objects.equals(scope, _that.getScope())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(fxComplexBarrierBaseSequence0, _that.getFxComplexBarrierBaseSequence0())) return false;
			if (!Objects.equals(fxComplexBarrierBaseSequence1, _that.getFxComplexBarrierBaseSequence1())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (style != null ? style.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (scope != null ? scope.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (fxComplexBarrierBaseSequence0 != null ? fxComplexBarrierBaseSequence0.hashCode() : 0);
			_result = 31 * _result + (fxComplexBarrierBaseSequence1 != null ? fxComplexBarrierBaseSequence1.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxComplexBarrierBaseBuilder {" +
				"barrierType=" + this.barrierType + ", " +
				"style=" + this.style + ", " +
				"scope=" + this.scope + ", " +
				"condition=" + this.condition + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"fxComplexBarrierBaseSequence0=" + this.fxComplexBarrierBaseSequence0 + ", " +
				"fxComplexBarrierBaseSequence1=" + this.fxComplexBarrierBaseSequence1 + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
