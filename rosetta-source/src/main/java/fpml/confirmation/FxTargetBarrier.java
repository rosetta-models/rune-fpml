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
import fpml.confirmation.FxTargetBarrier;
import fpml.confirmation.FxTargetBarrier.FxTargetBarrierBuilder;
import fpml.confirmation.FxTargetBarrier.FxTargetBarrierBuilderImpl;
import fpml.confirmation.FxTargetBarrier.FxTargetBarrierImpl;
import fpml.confirmation.FxTargetRebate;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.FxTargetBarrierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTargetBarrier", builder=FxTargetBarrier.FxTargetBarrierBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTargetBarrier extends FxComplexBarrierBase {

	FxTargetBarrierMeta metaData = new FxTargetBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A rebate payable in the event of knockout. This element may be produced in conjunction with a Global Knockout barrier (barrierType = &quot;Knockout&quot; scope = &quot;Global&quot;), and must be omitted otherwise.
	 */
	FxTargetRebate getRebate();

	/*********************** Build Methods  ***********************/
	FxTargetBarrier build();
	
	FxTargetBarrier.FxTargetBarrierBuilder toBuilder();
	
	static FxTargetBarrier.FxTargetBarrierBuilder builder() {
		return new FxTargetBarrier.FxTargetBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetBarrier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetBarrier> getType() {
		return FxTargetBarrier.class;
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
		processRosetta(path.newSubPath("rebate"), processor, FxTargetRebate.class, getRebate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetBarrierBuilder extends FxTargetBarrier, FxComplexBarrierBase.FxComplexBarrierBaseBuilder {
		FxTargetRebate.FxTargetRebateBuilder getOrCreateRebate();
		FxTargetRebate.FxTargetRebateBuilder getRebate();
		FxTargetBarrier.FxTargetBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType);
		FxTargetBarrier.FxTargetBarrierBuilder setStyle(FxBarrierStyleEnum style);
		FxTargetBarrier.FxTargetBarrierBuilder setScope(FxBarrierScopeEnum scope);
		FxTargetBarrier.FxTargetBarrierBuilder setCondition(ConditionEnum condition);
		FxTargetBarrier.FxTargetBarrierBuilder setTriggerRate(Schedule triggerRate);
		FxTargetBarrier.FxTargetBarrierBuilder setFxComplexBarrierBaseSequence0(FxComplexBarrierBaseSequence0 fxComplexBarrierBaseSequence0);
		FxTargetBarrier.FxTargetBarrierBuilder setFxComplexBarrierBaseSequence1(FxComplexBarrierBaseSequence1 fxComplexBarrierBaseSequence1);
		FxTargetBarrier.FxTargetBarrierBuilder setId(String id);
		FxTargetBarrier.FxTargetBarrierBuilder setRebate(FxTargetRebate rebate);

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
			processRosetta(path.newSubPath("rebate"), processor, FxTargetRebate.FxTargetRebateBuilder.class, getRebate());
		}
		

		FxTargetBarrier.FxTargetBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetBarrier  ***********************/
	class FxTargetBarrierImpl extends FxComplexBarrierBase.FxComplexBarrierBaseImpl implements FxTargetBarrier {
		private final FxTargetRebate rebate;
		
		protected FxTargetBarrierImpl(FxTargetBarrier.FxTargetBarrierBuilder builder) {
			super(builder);
			this.rebate = ofNullable(builder.getRebate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rebate")
		public FxTargetRebate getRebate() {
			return rebate;
		}
		
		@Override
		public FxTargetBarrier build() {
			return this;
		}
		
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder toBuilder() {
			FxTargetBarrier.FxTargetBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetBarrier.FxTargetBarrierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRebate()).ifPresent(builder::setRebate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetBarrier _that = getType().cast(o);
		
			if (!Objects.equals(rebate, _that.getRebate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebate != null ? rebate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetBarrier {" +
				"rebate=" + this.rebate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetBarrier  ***********************/
	class FxTargetBarrierBuilderImpl extends FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl  implements FxTargetBarrier.FxTargetBarrierBuilder {
	
		protected FxTargetRebate.FxTargetRebateBuilder rebate;
	
		public FxTargetBarrierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rebate")
		public FxTargetRebate.FxTargetRebateBuilder getRebate() {
			return rebate;
		}
		
		@Override
		public FxTargetRebate.FxTargetRebateBuilder getOrCreateRebate() {
			FxTargetRebate.FxTargetRebateBuilder result;
			if (rebate!=null) {
				result = rebate;
			}
			else {
				result = rebate = FxTargetRebate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrierType")
		public FxTargetBarrier.FxTargetBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType) {
			this.barrierType = barrierType==null?null:barrierType;
			return this;
		}
		@Override
		@RosettaAttribute("style")
		public FxTargetBarrier.FxTargetBarrierBuilder setStyle(FxBarrierStyleEnum style) {
			this.style = style==null?null:style;
			return this;
		}
		@Override
		@RosettaAttribute("scope")
		public FxTargetBarrier.FxTargetBarrierBuilder setScope(FxBarrierScopeEnum scope) {
			this.scope = scope==null?null:scope;
			return this;
		}
		@Override
		@RosettaAttribute("condition")
		public FxTargetBarrier.FxTargetBarrierBuilder setCondition(ConditionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxTargetBarrier.FxTargetBarrierBuilder setTriggerRate(Schedule triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence0")
		public FxTargetBarrier.FxTargetBarrierBuilder setFxComplexBarrierBaseSequence0(FxComplexBarrierBaseSequence0 fxComplexBarrierBaseSequence0) {
			this.fxComplexBarrierBaseSequence0 = fxComplexBarrierBaseSequence0==null?null:fxComplexBarrierBaseSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence1")
		public FxTargetBarrier.FxTargetBarrierBuilder setFxComplexBarrierBaseSequence1(FxComplexBarrierBaseSequence1 fxComplexBarrierBaseSequence1) {
			this.fxComplexBarrierBaseSequence1 = fxComplexBarrierBaseSequence1==null?null:fxComplexBarrierBaseSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxTargetBarrier.FxTargetBarrierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("rebate")
		public FxTargetBarrier.FxTargetBarrierBuilder setRebate(FxTargetRebate rebate) {
			this.rebate = rebate==null?null:rebate.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetBarrier build() {
			return new FxTargetBarrier.FxTargetBarrierImpl(this);
		}
		
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder prune() {
			super.prune();
			if (rebate!=null && !rebate.prune().hasData()) rebate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRebate()!=null && getRebate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTargetBarrier.FxTargetBarrierBuilder o = (FxTargetBarrier.FxTargetBarrierBuilder) other;
			
			merger.mergeRosetta(getRebate(), o.getRebate(), this::setRebate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetBarrier _that = getType().cast(o);
		
			if (!Objects.equals(rebate, _that.getRebate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebate != null ? rebate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetBarrierBuilder {" +
				"rebate=" + this.rebate +
			'}' + " " + super.toString();
		}
	}
}
