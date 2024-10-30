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
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SpreadSchedule", builder=SpreadSchedule.SpreadScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SpreadSchedule extends Schedule {

	SpreadScheduleMeta metaData = new SpreadScheduleMeta();

	/*********************** Getter Methods  ***********************/
	SpreadScheduleType get_type();

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
		processRosetta(path.newSubPath("_type"), processor, SpreadScheduleType.class, get_type());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpreadScheduleBuilder extends SpreadSchedule, Schedule.ScheduleBuilder {
		SpreadScheduleType.SpreadScheduleTypeBuilder getOrCreate_type();
		SpreadScheduleType.SpreadScheduleTypeBuilder get_type();
		SpreadSchedule.SpreadScheduleBuilder setInitialValue(BigDecimal initialValue);
		SpreadSchedule.SpreadScheduleBuilder addStep(Step step0);
		SpreadSchedule.SpreadScheduleBuilder addStep(Step step1, int _idx);
		SpreadSchedule.SpreadScheduleBuilder addStep(List<? extends Step> step2);
		SpreadSchedule.SpreadScheduleBuilder setStep(List<? extends Step> step3);
		SpreadSchedule.SpreadScheduleBuilder setId(String id);
		SpreadSchedule.SpreadScheduleBuilder set_type(SpreadScheduleType _type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("_type"), processor, SpreadScheduleType.SpreadScheduleTypeBuilder.class, get_type());
		}
		

		SpreadSchedule.SpreadScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of SpreadSchedule  ***********************/
	class SpreadScheduleImpl extends Schedule.ScheduleImpl implements SpreadSchedule {
		private final SpreadScheduleType _type;
		
		protected SpreadScheduleImpl(SpreadSchedule.SpreadScheduleBuilder builder) {
			super(builder);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("_type")
		public SpreadScheduleType get_type() {
			return _type;
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
			ofNullable(get_type()).ifPresent(builder::set_type);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadSchedule {" +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SpreadSchedule  ***********************/
	class SpreadScheduleBuilderImpl extends Schedule.ScheduleBuilderImpl  implements SpreadSchedule.SpreadScheduleBuilder {
	
		protected SpreadScheduleType.SpreadScheduleTypeBuilder _type;
	
		public SpreadScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("_type")
		public SpreadScheduleType.SpreadScheduleTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder getOrCreate_type() {
			SpreadScheduleType.SpreadScheduleTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = SpreadScheduleType.builder();
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
		@RosettaAttribute("step")
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
		@RosettaAttribute("_type")
		public SpreadSchedule.SpreadScheduleBuilder set_type(SpreadScheduleType _type) {
			this._type = _type==null?null:_type.toBuilder();
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
			if (_type!=null && !_type.prune().hasData()) _type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadSchedule.SpreadScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SpreadSchedule.SpreadScheduleBuilder o = (SpreadSchedule.SpreadScheduleBuilder) other;
			
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleBuilder {" +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}
}
