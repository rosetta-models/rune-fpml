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
import fpml.confirmation.ObservationFrequency;
import fpml.confirmation.ObservationFrequency.ObservationFrequencyBuilder;
import fpml.confirmation.ObservationFrequency.ObservationFrequencyBuilderImpl;
import fpml.confirmation.ObservationFrequency.ObservationFrequencyImpl;
import fpml.confirmation.Period;
import fpml.confirmation.Period.PeriodBuilder;
import fpml.confirmation.Period.PeriodBuilderImpl;
import fpml.confirmation.Period.PeriodImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.RollConventionEnum;
import fpml.confirmation.meta.ObservationFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the frequency at which calculation period end dates occur within the regular part of the calculation period schedule and thier roll date convention. In case the calculation frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
 * @version ${project.version}
 */
@RosettaDataType(value="ObservationFrequency", builder=ObservationFrequency.ObservationFrequencyBuilderImpl.class, version="${project.version}")
public interface ObservationFrequency extends Period {

	ObservationFrequencyMeta metaData = new ObservationFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Used in conjunction with a frequency and the regular period start date of an observation period, determines each observation period end date within the regular part of a observation period schedule.
	 */
	RollConventionEnum getPeriodConvention();

	/*********************** Build Methods  ***********************/
	ObservationFrequency build();
	
	ObservationFrequency.ObservationFrequencyBuilder toBuilder();
	
	static ObservationFrequency.ObservationFrequencyBuilder builder() {
		return new ObservationFrequency.ObservationFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationFrequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObservationFrequency> getType() {
		return ObservationFrequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodConvention"), RollConventionEnum.class, getPeriodConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationFrequencyBuilder extends ObservationFrequency, Period.PeriodBuilder {
		ObservationFrequency.ObservationFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		ObservationFrequency.ObservationFrequencyBuilder setPeriod(PeriodEnum period);
		ObservationFrequency.ObservationFrequencyBuilder setId(String id);
		ObservationFrequency.ObservationFrequencyBuilder setPeriodConvention(RollConventionEnum periodConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodConvention"), RollConventionEnum.class, getPeriodConvention(), this);
		}
		

		ObservationFrequency.ObservationFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationFrequency  ***********************/
	class ObservationFrequencyImpl extends Period.PeriodImpl implements ObservationFrequency {
		private final RollConventionEnum periodConvention;
		
		protected ObservationFrequencyImpl(ObservationFrequency.ObservationFrequencyBuilder builder) {
			super(builder);
			this.periodConvention = builder.getPeriodConvention();
		}
		
		@Override
		@RosettaAttribute("periodConvention")
		public RollConventionEnum getPeriodConvention() {
			return periodConvention;
		}
		
		@Override
		public ObservationFrequency build() {
			return this;
		}
		
		@Override
		public ObservationFrequency.ObservationFrequencyBuilder toBuilder() {
			ObservationFrequency.ObservationFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationFrequency.ObservationFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodConvention()).ifPresent(builder::setPeriodConvention);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationFrequency _that = getType().cast(o);
		
			if (!Objects.equals(periodConvention, _that.getPeriodConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodConvention != null ? periodConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationFrequency {" +
				"periodConvention=" + this.periodConvention +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObservationFrequency  ***********************/
	class ObservationFrequencyBuilderImpl extends Period.PeriodBuilderImpl  implements ObservationFrequency.ObservationFrequencyBuilder {
	
		protected RollConventionEnum periodConvention;
	
		public ObservationFrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodConvention")
		public RollConventionEnum getPeriodConvention() {
			return periodConvention;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public ObservationFrequency.ObservationFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public ObservationFrequency.ObservationFrequencyBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ObservationFrequency.ObservationFrequencyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("periodConvention")
		public ObservationFrequency.ObservationFrequencyBuilder setPeriodConvention(RollConventionEnum periodConvention) {
			this.periodConvention = periodConvention==null?null:periodConvention;
			return this;
		}
		
		@Override
		public ObservationFrequency build() {
			return new ObservationFrequency.ObservationFrequencyImpl(this);
		}
		
		@Override
		public ObservationFrequency.ObservationFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationFrequency.ObservationFrequencyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationFrequency.ObservationFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ObservationFrequency.ObservationFrequencyBuilder o = (ObservationFrequency.ObservationFrequencyBuilder) other;
			
			
			merger.mergeBasic(getPeriodConvention(), o.getPeriodConvention(), this::setPeriodConvention);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationFrequency _that = getType().cast(o);
		
			if (!Objects.equals(periodConvention, _that.getPeriodConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodConvention != null ? periodConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationFrequencyBuilder {" +
				"periodConvention=" + this.periodConvention +
			'}' + " " + super.toString();
		}
	}
}
