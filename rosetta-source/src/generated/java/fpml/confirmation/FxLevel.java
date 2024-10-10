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
import fpml.confirmation.FxLevel;
import fpml.confirmation.FxLevel.FxLevelBuilder;
import fpml.confirmation.FxLevel.FxLevelBuilderImpl;
import fpml.confirmation.FxLevel.FxLevelImpl;
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.Step;
import fpml.confirmation.meta.FxLevelMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Level is expressed as Schedule, with an initial value and optional steps.
 * @version ${project.version}
 */
@RosettaDataType(value="FxLevel", builder=FxLevel.FxLevelBuilderImpl.class, version="${project.version}")
public interface FxLevel extends Schedule {

	FxLevelMeta metaData = new FxLevelMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxLevel build();
	
	FxLevel.FxLevelBuilder toBuilder();
	
	static FxLevel.FxLevelBuilder builder() {
		return new FxLevel.FxLevelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxLevel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxLevel> getType() {
		return FxLevel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxLevelBuilder extends FxLevel, Schedule.ScheduleBuilder {
		FxLevel.FxLevelBuilder setInitialValue(BigDecimal initialValue);
		FxLevel.FxLevelBuilder addStep(Step step0);
		FxLevel.FxLevelBuilder addStep(Step step1, int _idx);
		FxLevel.FxLevelBuilder addStep(List<? extends Step> step2);
		FxLevel.FxLevelBuilder setStep(List<? extends Step> step3);
		FxLevel.FxLevelBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxLevel.FxLevelBuilder prune();
	}

	/*********************** Immutable Implementation of FxLevel  ***********************/
	class FxLevelImpl extends Schedule.ScheduleImpl implements FxLevel {
		
		protected FxLevelImpl(FxLevel.FxLevelBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxLevel build() {
			return this;
		}
		
		@Override
		public FxLevel.FxLevelBuilder toBuilder() {
			FxLevel.FxLevelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxLevel.FxLevelBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxLevel {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxLevel  ***********************/
	class FxLevelBuilderImpl extends Schedule.ScheduleBuilderImpl  implements FxLevel.FxLevelBuilder {
	
	
		public FxLevelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialValue")
		public FxLevel.FxLevelBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public FxLevel.FxLevelBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public FxLevel.FxLevelBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public FxLevel.FxLevelBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public FxLevel.FxLevelBuilder setStep(List<? extends Step> steps) {
			if (steps == null)  {
				this.step = new ArrayList<>();
			}
			else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxLevel.FxLevelBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxLevel build() {
			return new FxLevel.FxLevelImpl(this);
		}
		
		@Override
		public FxLevel.FxLevelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLevel.FxLevelBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLevel.FxLevelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxLevel.FxLevelBuilder o = (FxLevel.FxLevelBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxLevelBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
