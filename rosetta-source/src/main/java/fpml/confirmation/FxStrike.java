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
import fpml.confirmation.FxStrike;
import fpml.confirmation.FxStrike.FxStrikeBuilder;
import fpml.confirmation.FxStrike.FxStrikeBuilderImpl;
import fpml.confirmation.FxStrike.FxStrikeImpl;
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.Step;
import fpml.confirmation.meta.FxStrikeMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Strike is expressed as Schedule, with an initial value and optional steps.
 * @version ${project.version}
 */
@RosettaDataType(value="FxStrike", builder=FxStrike.FxStrikeBuilderImpl.class, version="${project.version}")
public interface FxStrike extends Schedule {

	FxStrikeMeta metaData = new FxStrikeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxStrike build();
	
	FxStrike.FxStrikeBuilder toBuilder();
	
	static FxStrike.FxStrikeBuilder builder() {
		return new FxStrike.FxStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStrike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxStrike> getType() {
		return FxStrike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStrikeBuilder extends FxStrike, Schedule.ScheduleBuilder {
		FxStrike.FxStrikeBuilder setInitialValue(BigDecimal initialValue);
		FxStrike.FxStrikeBuilder addStep(Step step0);
		FxStrike.FxStrikeBuilder addStep(Step step1, int _idx);
		FxStrike.FxStrikeBuilder addStep(List<? extends Step> step2);
		FxStrike.FxStrikeBuilder setStep(List<? extends Step> step3);
		FxStrike.FxStrikeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxStrike.FxStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of FxStrike  ***********************/
	class FxStrikeImpl extends Schedule.ScheduleImpl implements FxStrike {
		
		protected FxStrikeImpl(FxStrike.FxStrikeBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxStrike build() {
			return this;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder toBuilder() {
			FxStrike.FxStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStrike.FxStrikeBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
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
			return "FxStrike {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxStrike  ***********************/
	class FxStrikeBuilderImpl extends Schedule.ScheduleBuilderImpl  implements FxStrike.FxStrikeBuilder {
	
	
		public FxStrikeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialValue")
		public FxStrike.FxStrikeBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		@RosettaAttribute("step")
		public FxStrike.FxStrikeBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public FxStrike.FxStrikeBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxStrike.FxStrikeBuilder setStep(List<? extends Step> steps) {
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
		public FxStrike.FxStrikeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxStrike build() {
			return new FxStrike.FxStrikeImpl(this);
		}
		
		@Override
		public FxStrike.FxStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStrike.FxStrikeBuilder prune() {
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
		public FxStrike.FxStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxStrike.FxStrikeBuilder o = (FxStrike.FxStrikeBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
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
			return "FxStrikeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
