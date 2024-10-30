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
import fpml.confirmation.FxAccrualStrike;
import fpml.confirmation.FxAccrualStrike.FxAccrualStrikeBuilder;
import fpml.confirmation.FxAccrualStrike.FxAccrualStrikeBuilderImpl;
import fpml.confirmation.FxAccrualStrike.FxAccrualStrikeImpl;
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.Step;
import fpml.confirmation.meta.FxAccrualStrikeMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A shared type between accrual forwards and options where the FX accrual strike reference can point to.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualStrike", builder=FxAccrualStrike.FxAccrualStrikeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualStrike extends Schedule {

	FxAccrualStrikeMeta metaData = new FxAccrualStrikeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxAccrualStrike build();
	
	FxAccrualStrike.FxAccrualStrikeBuilder toBuilder();
	
	static FxAccrualStrike.FxAccrualStrikeBuilder builder() {
		return new FxAccrualStrike.FxAccrualStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualStrike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualStrike> getType() {
		return FxAccrualStrike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualStrikeBuilder extends FxAccrualStrike, Schedule.ScheduleBuilder {
		FxAccrualStrike.FxAccrualStrikeBuilder setInitialValue(BigDecimal initialValue);
		FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step step0);
		FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step step1, int _idx);
		FxAccrualStrike.FxAccrualStrikeBuilder addStep(List<? extends Step> step2);
		FxAccrualStrike.FxAccrualStrikeBuilder setStep(List<? extends Step> step3);
		FxAccrualStrike.FxAccrualStrikeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxAccrualStrike.FxAccrualStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualStrike  ***********************/
	class FxAccrualStrikeImpl extends Schedule.ScheduleImpl implements FxAccrualStrike {
		
		protected FxAccrualStrikeImpl(FxAccrualStrike.FxAccrualStrikeBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxAccrualStrike build() {
			return this;
		}
		
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder toBuilder() {
			FxAccrualStrike.FxAccrualStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualStrike.FxAccrualStrikeBuilder builder) {
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
			return "FxAccrualStrike {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualStrike  ***********************/
	class FxAccrualStrikeBuilderImpl extends Schedule.ScheduleBuilderImpl  implements FxAccrualStrike.FxAccrualStrikeBuilder {
	
	
		public FxAccrualStrikeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialValue")
		public FxAccrualStrike.FxAccrualStrikeBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		@RosettaAttribute("step")
		public FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualStrike.FxAccrualStrikeBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualStrike.FxAccrualStrikeBuilder setStep(List<? extends Step> steps) {
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
		public FxAccrualStrike.FxAccrualStrikeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxAccrualStrike build() {
			return new FxAccrualStrike.FxAccrualStrikeImpl(this);
		}
		
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualStrike.FxAccrualStrikeBuilder prune() {
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
		public FxAccrualStrike.FxAccrualStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualStrike.FxAccrualStrikeBuilder o = (FxAccrualStrike.FxAccrualStrikeBuilder) other;
			
			
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
			return "FxAccrualStrikeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
