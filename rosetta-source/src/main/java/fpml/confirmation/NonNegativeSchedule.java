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
import fpml.confirmation.NonNegativeSchedule;
import fpml.confirmation.NonNegativeSchedule.NonNegativeScheduleBuilder;
import fpml.confirmation.NonNegativeSchedule.NonNegativeScheduleBuilderImpl;
import fpml.confirmation.NonNegativeSchedule.NonNegativeScheduleImpl;
import fpml.confirmation.NonNegativeStep;
import fpml.confirmation.meta.NonNegativeScheduleMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a schedule of non-negative rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 * @version ${project.version}
 */
@RosettaDataType(value="NonNegativeSchedule", builder=NonNegativeSchedule.NonNegativeScheduleBuilderImpl.class, version="${project.version}")
public interface NonNegativeSchedule extends RosettaModelObject {

	NonNegativeScheduleMeta metaData = new NonNegativeScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The non-negative initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
	 */
	BigDecimal getInitialValue();
	/**
	 * The schedule of step date and non-negative value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 */
	List<? extends NonNegativeStep> getStep();
	String getId();

	/*********************** Build Methods  ***********************/
	NonNegativeSchedule build();
	
	NonNegativeSchedule.NonNegativeScheduleBuilder toBuilder();
	
	static NonNegativeSchedule.NonNegativeScheduleBuilder builder() {
		return new NonNegativeSchedule.NonNegativeScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonNegativeSchedule> getType() {
		return NonNegativeSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, NonNegativeStep.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeScheduleBuilder extends NonNegativeSchedule, RosettaModelObjectBuilder {
		NonNegativeStep.NonNegativeStepBuilder getOrCreateStep(int _index);
		List<? extends NonNegativeStep.NonNegativeStepBuilder> getStep();
		NonNegativeSchedule.NonNegativeScheduleBuilder setInitialValue(BigDecimal initialValue);
		NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep step0);
		NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep step1, int _idx);
		NonNegativeSchedule.NonNegativeScheduleBuilder addStep(List<? extends NonNegativeStep> step2);
		NonNegativeSchedule.NonNegativeScheduleBuilder setStep(List<? extends NonNegativeStep> step3);
		NonNegativeSchedule.NonNegativeScheduleBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, NonNegativeStep.NonNegativeStepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		NonNegativeSchedule.NonNegativeScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeSchedule  ***********************/
	class NonNegativeScheduleImpl implements NonNegativeSchedule {
		private final BigDecimal initialValue;
		private final List<? extends NonNegativeStep> step;
		private final String id;
		
		protected NonNegativeScheduleImpl(NonNegativeSchedule.NonNegativeScheduleBuilder builder) {
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
		public List<? extends NonNegativeStep> getStep() {
			return step;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public NonNegativeSchedule build() {
			return this;
		}
		
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder toBuilder() {
			NonNegativeSchedule.NonNegativeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeSchedule.NonNegativeScheduleBuilder builder) {
			ofNullable(getInitialValue()).ifPresent(builder::setInitialValue);
			ofNullable(getStep()).ifPresent(builder::setStep);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeSchedule _that = getType().cast(o);
		
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
			return "NonNegativeSchedule {" +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of NonNegativeSchedule  ***********************/
	class NonNegativeScheduleBuilderImpl implements NonNegativeSchedule.NonNegativeScheduleBuilder {
	
		protected BigDecimal initialValue;
		protected List<NonNegativeStep.NonNegativeStepBuilder> step = new ArrayList<>();
		protected String id;
	
		public NonNegativeScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialValue")
		public BigDecimal getInitialValue() {
			return initialValue;
		}
		
		@Override
		@RosettaAttribute("step")
		public List<? extends NonNegativeStep.NonNegativeStepBuilder> getStep() {
			return step;
		}
		
		@Override
		public NonNegativeStep.NonNegativeStepBuilder getOrCreateStep(int _index) {
		
			if (step==null) {
				this.step = new ArrayList<>();
			}
			NonNegativeStep.NonNegativeStepBuilder result;
			return getIndex(step, _index, () -> {
						NonNegativeStep.NonNegativeStepBuilder newStep = NonNegativeStep.builder();
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
		public NonNegativeSchedule.NonNegativeScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		@RosettaAttribute("step")
		public NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder addStep(NonNegativeStep step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public NonNegativeSchedule.NonNegativeScheduleBuilder addStep(List<? extends NonNegativeStep> steps) {
			if (steps != null) {
				for (NonNegativeStep toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NonNegativeSchedule.NonNegativeScheduleBuilder setStep(List<? extends NonNegativeStep> steps) {
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
		public NonNegativeSchedule.NonNegativeScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public NonNegativeSchedule build() {
			return new NonNegativeSchedule.NonNegativeScheduleImpl(this);
		}
		
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeSchedule.NonNegativeScheduleBuilder prune() {
			step = step.stream().filter(b->b!=null).<NonNegativeStep.NonNegativeStepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
		public NonNegativeSchedule.NonNegativeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonNegativeSchedule.NonNegativeScheduleBuilder o = (NonNegativeSchedule.NonNegativeScheduleBuilder) other;
			
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			merger.mergeBasic(getInitialValue(), o.getInitialValue(), this::setInitialValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeSchedule _that = getType().cast(o);
		
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
			return "NonNegativeScheduleBuilder {" +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
