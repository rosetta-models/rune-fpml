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
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.SpreadSchedule.SpreadScheduleBuilder;
import fpml.confirmation.SpreadSchedule.SpreadScheduleBuilderImpl;
import fpml.confirmation.SpreadSchedule.SpreadScheduleImpl;
import fpml.confirmation.SpreadScheduleType;
import fpml.confirmation.Step;
import fpml.confirmation.meta.SpreadScheduleMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Adds an optional spread type element to the Schedule to identify a long or short spread value.
 * @version ${project.version}
 */
@RosettaDataType(value="SpreadSchedule", builder=SpreadSchedule.SpreadScheduleBuilderImpl.class, version="${project.version}")
public interface SpreadSchedule extends Schedule {

	SpreadScheduleMeta metaData = new SpreadScheduleMeta();

	/*********************** Getter Methods  ***********************/
	SpreadScheduleType getType();

	/*********************** Build Methods  ***********************/
	SpreadSchedule build();
	
	SpreadSchedule.SpreadScheduleBuilder toBuilder();
	
	static SpreadSchedule.SpreadScheduleBuilder builder() {
		return new SpreadSchedule.SpreadScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpreadSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SpreadSchedule> getType() {
		return SpreadSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("type"), processor, SpreadScheduleType.class, getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpreadScheduleBuilder extends SpreadSchedule, Schedule.ScheduleBuilder {
		SpreadScheduleType.SpreadScheduleTypeBuilder getOrCreateType();
		SpreadScheduleType.SpreadScheduleTypeBuilder getType();
		SpreadSchedule.SpreadScheduleBuilder setInitialValue(BigDecimal initialValue);
		SpreadSchedule.SpreadScheduleBuilder addStep(Step step0);
		SpreadSchedule.SpreadScheduleBuilder addStep(Step step1, int _idx);
		SpreadSchedule.SpreadScheduleBuilder addStep(List<? extends Step> step2);
		SpreadSchedule.SpreadScheduleBuilder setStep(List<? extends Step> step3);
		SpreadSchedule.SpreadScheduleBuilder setId(String id);
		SpreadSchedule.SpreadScheduleBuilder setType(SpreadScheduleType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("type"), processor, SpreadScheduleType.SpreadScheduleTypeBuilder.class, getType());
		}
		

		SpreadSchedule.SpreadScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of SpreadSchedule  ***********************/
	class SpreadScheduleImpl extends Schedule.ScheduleImpl implements SpreadSchedule {
		private final SpreadScheduleType type;
		
		protected SpreadScheduleImpl(SpreadSchedule.SpreadScheduleBuilder builder) {
			super(builder);
			this.type = ofNullable(builder.getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		public SpreadScheduleType getType() {
			return type;
		}
		
		@Override
		public SpreadSchedule build() {
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder toBuilder() {
			SpreadSchedule.SpreadScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpreadSchedule.SpreadScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadSchedule {" +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SpreadSchedule  ***********************/
	class SpreadScheduleBuilderImpl extends Schedule.ScheduleBuilderImpl  implements SpreadSchedule.SpreadScheduleBuilder {
	
		protected SpreadScheduleType.SpreadScheduleTypeBuilder type;
	
		public SpreadScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public SpreadScheduleType.SpreadScheduleTypeBuilder getType() {
			return type;
		}
		
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder getOrCreateType() {
			SpreadScheduleType.SpreadScheduleTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = SpreadScheduleType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public SpreadSchedule.SpreadScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public SpreadSchedule.SpreadScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public SpreadSchedule.SpreadScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public SpreadSchedule.SpreadScheduleBuilder setStep(List<? extends Step> steps) {
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
		public SpreadSchedule.SpreadScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("type")
		public SpreadSchedule.SpreadScheduleBuilder setType(SpreadScheduleType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		
		@Override
		public SpreadSchedule build() {
			return new SpreadSchedule.SpreadScheduleImpl(this);
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadSchedule.SpreadScheduleBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getType()!=null && getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadSchedule.SpreadScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SpreadSchedule.SpreadScheduleBuilder o = (SpreadSchedule.SpreadScheduleBuilder) other;
			
			merger.mergeRosetta(getType(), o.getType(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleBuilder {" +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}
}
