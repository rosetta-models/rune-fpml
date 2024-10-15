package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.Step;
import fpml.confirmation.meta.ScheduleMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 * @version ${project.version}
 */
@RosettaDataType(value="Schedule", builder=Schedule.ScheduleBuilderImpl.class, version="${project.version}")
public interface Schedule extends RosettaModelObject {

	ScheduleMeta metaData = new ScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
	 */
	BigDecimal getInitialValue();
	/**
	 * The schedule of step date and value pairs. On each step date the associated step value becomes effective A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 */
	List<? extends Step> getStep();
	String getId();

	/*********************** Build Methods  ***********************/
	Schedule build();
	
	Schedule.ScheduleBuilder toBuilder();
	
	static Schedule.ScheduleBuilder builder() {
		return new Schedule.ScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Schedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Schedule> getType() {
		return Schedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ScheduleBuilder extends Schedule, RosettaModelObjectBuilder {
		Step.StepBuilder getOrCreateStep(int _index);
		List<? extends Step.StepBuilder> getStep();
		Schedule.ScheduleBuilder setInitialValue(BigDecimal initialValue);
		Schedule.ScheduleBuilder addStep(Step step0);
		Schedule.ScheduleBuilder addStep(Step step1, int _idx);
		Schedule.ScheduleBuilder addStep(List<? extends Step> step2);
		Schedule.ScheduleBuilder setStep(List<? extends Step> step3);
		Schedule.ScheduleBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Schedule.ScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of Schedule  ***********************/
	class ScheduleImpl implements Schedule {
		private final BigDecimal initialValue;
		private final List<? extends Step> step;
		private final String id;
		
		protected ScheduleImpl(Schedule.ScheduleBuilder builder) {
			this.initialValue = builder.getInitialValue();
			this.step = ofNullable(builder.getStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public BigDecimal getInitialValue() {
			return initialValue;
		}
		
		@Override
		@RosettaAttribute("step")
		public List<? extends Step> getStep() {
			return step;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Schedule build() {
			return this;
		}
		
		@Override
		public Schedule.ScheduleBuilder toBuilder() {
			Schedule.ScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Schedule.ScheduleBuilder builder) {
			ofNullable(getInitialValue()).ifPresent(builder::setInitialValue);
			ofNullable(getStep()).ifPresent(builder::setStep);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule _that = getType().cast(o);
		
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule {" +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Schedule  ***********************/
	class ScheduleBuilderImpl implements Schedule.ScheduleBuilder {
	
		protected BigDecimal initialValue;
		protected List<Step.StepBuilder> step = new ArrayList<>();
		protected String id;
	
		public ScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialValue")
		public BigDecimal getInitialValue() {
			return initialValue;
		}
		
		@Override
		@RosettaAttribute("step")
		public List<? extends Step.StepBuilder> getStep() {
			return step;
		}
		
		public Step.StepBuilder getOrCreateStep(int _index) {
		
			if (step==null) {
				this.step = new ArrayList<>();
			}
			Step.StepBuilder result;
			return getIndex(step, _index, () -> {
						Step.StepBuilder newStep = Step.builder();
						return newStep;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public Schedule.ScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public Schedule.ScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public Schedule.ScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public Schedule.ScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public Schedule.ScheduleBuilder setStep(List<? extends Step> steps) {
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
		public Schedule.ScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Schedule build() {
			return new Schedule.ScheduleImpl(this);
		}
		
		@Override
		public Schedule.ScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule.ScheduleBuilder prune() {
			step = step.stream().filter(b->b!=null).<Step.StepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialValue()!=null) return true;
			if (getStep()!=null && getStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule.ScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Schedule.ScheduleBuilder o = (Schedule.ScheduleBuilder) other;
			
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			merger.mergeBasic(getInitialValue(), o.getInitialValue(), this::setInitialValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule _that = getType().cast(o);
		
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ScheduleBuilder {" +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
