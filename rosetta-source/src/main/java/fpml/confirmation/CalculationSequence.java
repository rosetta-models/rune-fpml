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
import fpml.confirmation.CalculationSequence;
import fpml.confirmation.CalculationSequence.CalculationSequenceBuilder;
import fpml.confirmation.CalculationSequence.CalculationSequenceBuilderImpl;
import fpml.confirmation.CalculationSequence.CalculationSequenceImpl;
import fpml.confirmation.FutureValueAmount;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.CalculationSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CalculationSequence", builder=CalculationSequence.CalculationSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CalculationSequence extends RosettaModelObject {

	CalculationSequenceMeta metaData = new CalculationSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Schedule getFixedRateSchedule();
	/**
	 * The future value notional is normally only required for BRL CDI Swaps. The value is calculated as follows: Future Value Notional = Notional Amount * (1 + Fixed Rate) ^ (Fixed Rate Day Count Fraction). The currency should always match that expressed in the notional schedule. The value date should match the adjusted termination date.
	 */
	FutureValueAmount getFutureValueNotional();

	/*********************** Build Methods  ***********************/
	CalculationSequence build();
	
	CalculationSequence.CalculationSequenceBuilder toBuilder();
	
	static CalculationSequence.CalculationSequenceBuilder builder() {
		return new CalculationSequence.CalculationSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationSequence> getType() {
		return CalculationSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.class, getFixedRateSchedule());
		processRosetta(path.newSubPath("futureValueNotional"), processor, FutureValueAmount.class, getFutureValueNotional());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationSequenceBuilder extends CalculationSequence, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateFixedRateSchedule();
		Schedule.ScheduleBuilder getFixedRateSchedule();
		FutureValueAmount.FutureValueAmountBuilder getOrCreateFutureValueNotional();
		FutureValueAmount.FutureValueAmountBuilder getFutureValueNotional();
		CalculationSequence.CalculationSequenceBuilder setFixedRateSchedule(Schedule fixedRateSchedule);
		CalculationSequence.CalculationSequenceBuilder setFutureValueNotional(FutureValueAmount futureValueNotional);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFixedRateSchedule());
			processRosetta(path.newSubPath("futureValueNotional"), processor, FutureValueAmount.FutureValueAmountBuilder.class, getFutureValueNotional());
		}
		

		CalculationSequence.CalculationSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationSequence  ***********************/
	class CalculationSequenceImpl implements CalculationSequence {
		private final Schedule fixedRateSchedule;
		private final FutureValueAmount futureValueNotional;
		
		protected CalculationSequenceImpl(CalculationSequence.CalculationSequenceBuilder builder) {
			this.fixedRateSchedule = ofNullable(builder.getFixedRateSchedule()).map(f->f.build()).orElse(null);
			this.futureValueNotional = ofNullable(builder.getFutureValueNotional()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		public Schedule getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		@RosettaAttribute("futureValueNotional")
		public FutureValueAmount getFutureValueNotional() {
			return futureValueNotional;
		}
		
		@Override
		public CalculationSequence build() {
			return this;
		}
		
		@Override
		public CalculationSequence.CalculationSequenceBuilder toBuilder() {
			CalculationSequence.CalculationSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationSequence.CalculationSequenceBuilder builder) {
			ofNullable(getFixedRateSchedule()).ifPresent(builder::setFixedRateSchedule);
			ofNullable(getFutureValueNotional()).ifPresent(builder::setFutureValueNotional);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationSequence _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(futureValueNotional, _that.getFutureValueNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (futureValueNotional != null ? futureValueNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationSequence {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"futureValueNotional=" + this.futureValueNotional +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationSequence  ***********************/
	class CalculationSequenceBuilderImpl implements CalculationSequence.CalculationSequenceBuilder {
	
		protected Schedule.ScheduleBuilder fixedRateSchedule;
		protected FutureValueAmount.FutureValueAmountBuilder futureValueNotional;
	
		public CalculationSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedRateSchedule")
		public Schedule.ScheduleBuilder getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRateSchedule() {
			Schedule.ScheduleBuilder result;
			if (fixedRateSchedule!=null) {
				result = fixedRateSchedule;
			}
			else {
				result = fixedRateSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("futureValueNotional")
		public FutureValueAmount.FutureValueAmountBuilder getFutureValueNotional() {
			return futureValueNotional;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder getOrCreateFutureValueNotional() {
			FutureValueAmount.FutureValueAmountBuilder result;
			if (futureValueNotional!=null) {
				result = futureValueNotional;
			}
			else {
				result = futureValueNotional = FutureValueAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		public CalculationSequence.CalculationSequenceBuilder setFixedRateSchedule(Schedule fixedRateSchedule) {
			this.fixedRateSchedule = fixedRateSchedule==null?null:fixedRateSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("futureValueNotional")
		public CalculationSequence.CalculationSequenceBuilder setFutureValueNotional(FutureValueAmount futureValueNotional) {
			this.futureValueNotional = futureValueNotional==null?null:futureValueNotional.toBuilder();
			return this;
		}
		
		@Override
		public CalculationSequence build() {
			return new CalculationSequence.CalculationSequenceImpl(this);
		}
		
		@Override
		public CalculationSequence.CalculationSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationSequence.CalculationSequenceBuilder prune() {
			if (fixedRateSchedule!=null && !fixedRateSchedule.prune().hasData()) fixedRateSchedule = null;
			if (futureValueNotional!=null && !futureValueNotional.prune().hasData()) futureValueNotional = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateSchedule()!=null && getFixedRateSchedule().hasData()) return true;
			if (getFutureValueNotional()!=null && getFutureValueNotional().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationSequence.CalculationSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationSequence.CalculationSequenceBuilder o = (CalculationSequence.CalculationSequenceBuilder) other;
			
			merger.mergeRosetta(getFixedRateSchedule(), o.getFixedRateSchedule(), this::setFixedRateSchedule);
			merger.mergeRosetta(getFutureValueNotional(), o.getFutureValueNotional(), this::setFutureValueNotional);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationSequence _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(futureValueNotional, _that.getFutureValueNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (futureValueNotional != null ? futureValueNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationSequenceBuilder {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"futureValueNotional=" + this.futureValueNotional +
			'}';
		}
	}
}
