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
import fpml.confirmation.FxPivot;
import fpml.confirmation.FxPivot.FxPivotBuilder;
import fpml.confirmation.FxPivot.FxPivotBuilderImpl;
import fpml.confirmation.FxPivot.FxPivotImpl;
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.Step;
import fpml.confirmation.meta.FxPivotMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Pivot is expressed as Schedule, with an initial value and optional steps.
 * @version ${project.version}
 */
@RosettaDataType(value="FxPivot", builder=FxPivot.FxPivotBuilderImpl.class, version="${project.version}")
public interface FxPivot extends Schedule {

	FxPivotMeta metaData = new FxPivotMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxPivot build();
	
	FxPivot.FxPivotBuilder toBuilder();
	
	static FxPivot.FxPivotBuilder builder() {
		return new FxPivot.FxPivotBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPivot> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxPivot> getType() {
		return FxPivot.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPivotBuilder extends FxPivot, Schedule.ScheduleBuilder {
		FxPivot.FxPivotBuilder setInitialValue(BigDecimal initialValue);
		FxPivot.FxPivotBuilder addStep(Step step0);
		FxPivot.FxPivotBuilder addStep(Step step1, int _idx);
		FxPivot.FxPivotBuilder addStep(List<? extends Step> step2);
		FxPivot.FxPivotBuilder setStep(List<? extends Step> step3);
		FxPivot.FxPivotBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxPivot.FxPivotBuilder prune();
	}

	/*********************** Immutable Implementation of FxPivot  ***********************/
	class FxPivotImpl extends Schedule.ScheduleImpl implements FxPivot {
		
		protected FxPivotImpl(FxPivot.FxPivotBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxPivot build() {
			return this;
		}
		
		@Override
		public FxPivot.FxPivotBuilder toBuilder() {
			FxPivot.FxPivotBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPivot.FxPivotBuilder builder) {
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
			return "FxPivot {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPivot  ***********************/
	class FxPivotBuilderImpl extends Schedule.ScheduleBuilderImpl  implements FxPivot.FxPivotBuilder {
	
	
		public FxPivotBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialValue")
		public FxPivot.FxPivotBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public FxPivot.FxPivotBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public FxPivot.FxPivotBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public FxPivot.FxPivotBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public FxPivot.FxPivotBuilder setStep(List<? extends Step> steps) {
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
		public FxPivot.FxPivotBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxPivot build() {
			return new FxPivot.FxPivotImpl(this);
		}
		
		@Override
		public FxPivot.FxPivotBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPivot.FxPivotBuilder prune() {
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
		public FxPivot.FxPivotBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxPivot.FxPivotBuilder o = (FxPivot.FxPivotBuilder) other;
			
			
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
			return "FxPivotBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
