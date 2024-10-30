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
import fpml.confirmation.FxDigitalOptionSequence1;
import fpml.confirmation.FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder;
import fpml.confirmation.FxDigitalOptionSequence1.FxDigitalOptionSequence1BuilderImpl;
import fpml.confirmation.FxDigitalOptionSequence1.FxDigitalOptionSequence1Impl;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.FxTrigger;
import fpml.confirmation.meta.FxDigitalOptionSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxDigitalOptionSequence1", builder=FxDigitalOptionSequence1.FxDigitalOptionSequence1BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxDigitalOptionSequence1 extends RosettaModelObject {

	FxDigitalOptionSequence1Meta metaData = new FxDigitalOptionSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parameters for defining the exercise period for an European style option.
	 */
	FxEuropeanExercise getEuropeanExercise();
	/**
	 * Defines one or more conditions underwhich the option will payout if exercisable.
	 */
	List<? extends FxTrigger> getTrigger();

	/*********************** Build Methods  ***********************/
	FxDigitalOptionSequence1 build();
	
	FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder toBuilder();
	
	static FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder builder() {
		return new FxDigitalOptionSequence1.FxDigitalOptionSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDigitalOptionSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDigitalOptionSequence1> getType() {
		return FxDigitalOptionSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("trigger"), processor, FxTrigger.class, getTrigger());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDigitalOptionSequence1Builder extends FxDigitalOptionSequence1, RosettaModelObjectBuilder {
		FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise();
		FxTrigger.FxTriggerBuilder getOrCreateTrigger(int _index);
		List<? extends FxTrigger.FxTriggerBuilder> getTrigger();
		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder setEuropeanExercise(FxEuropeanExercise europeanExercise);
		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder addTrigger(FxTrigger trigger0);
		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder addTrigger(FxTrigger trigger1, int _idx);
		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder addTrigger(List<? extends FxTrigger> trigger2);
		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder setTrigger(List<? extends FxTrigger> trigger3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.FxEuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("trigger"), processor, FxTrigger.FxTriggerBuilder.class, getTrigger());
		}
		

		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder prune();
	}

	/*********************** Immutable Implementation of FxDigitalOptionSequence1  ***********************/
	class FxDigitalOptionSequence1Impl implements FxDigitalOptionSequence1 {
		private final FxEuropeanExercise europeanExercise;
		private final List<? extends FxTrigger> trigger;
		
		protected FxDigitalOptionSequence1Impl(FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder builder) {
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.trigger = ofNullable(builder.getTrigger()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public FxEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("trigger")
		public List<? extends FxTrigger> getTrigger() {
			return trigger;
		}
		
		@Override
		public FxDigitalOptionSequence1 build() {
			return this;
		}
		
		@Override
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder toBuilder() {
			FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder builder) {
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDigitalOptionSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!ListEquals.listEquals(trigger, _that.getTrigger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOptionSequence1 {" +
				"europeanExercise=" + this.europeanExercise + ", " +
				"trigger=" + this.trigger +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDigitalOptionSequence1  ***********************/
	class FxDigitalOptionSequence1BuilderImpl implements FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder {
	
		protected FxEuropeanExercise.FxEuropeanExerciseBuilder europeanExercise;
		protected List<FxTrigger.FxTriggerBuilder> trigger = new ArrayList<>();
	
		public FxDigitalOptionSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("europeanExercise")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			FxEuropeanExercise.FxEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = FxEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trigger")
		public List<? extends FxTrigger.FxTriggerBuilder> getTrigger() {
			return trigger;
		}
		
		@Override
		public FxTrigger.FxTriggerBuilder getOrCreateTrigger(int _index) {
		
			if (trigger==null) {
				this.trigger = new ArrayList<>();
			}
			FxTrigger.FxTriggerBuilder result;
			return getIndex(trigger, _index, () -> {
						FxTrigger.FxTriggerBuilder newTrigger = FxTrigger.builder();
						return newTrigger;
					});
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder setEuropeanExercise(FxEuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trigger")
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder addTrigger(FxTrigger trigger) {
			if (trigger!=null) this.trigger.add(trigger.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder addTrigger(FxTrigger trigger, int _idx) {
			getIndex(this.trigger, _idx, () -> trigger.toBuilder());
			return this;
		}
		@Override 
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder addTrigger(List<? extends FxTrigger> triggers) {
			if (triggers != null) {
				for (FxTrigger toAdd : triggers) {
					this.trigger.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder setTrigger(List<? extends FxTrigger> triggers) {
			if (triggers == null)  {
				this.trigger = new ArrayList<>();
			}
			else {
				this.trigger = triggers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxDigitalOptionSequence1 build() {
			return new FxDigitalOptionSequence1.FxDigitalOptionSequence1Impl(this);
		}
		
		@Override
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder prune() {
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			trigger = trigger.stream().filter(b->b!=null).<FxTrigger.FxTriggerBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getTrigger()!=null && getTrigger().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder o = (FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder) other;
			
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::getOrCreateTrigger);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDigitalOptionSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!ListEquals.listEquals(trigger, _that.getTrigger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOptionSequence1Builder {" +
				"europeanExercise=" + this.europeanExercise + ", " +
				"trigger=" + this.trigger +
			'}';
		}
	}
}
