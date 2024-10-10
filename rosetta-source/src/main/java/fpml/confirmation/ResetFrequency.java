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
import fpml.confirmation.Frequency;
import fpml.confirmation.Frequency.FrequencyBuilder;
import fpml.confirmation.Frequency.FrequencyBuilderImpl;
import fpml.confirmation.Frequency.FrequencyImpl;
import fpml.confirmation.PeriodExtendedEnum;
import fpml.confirmation.ResetFrequency;
import fpml.confirmation.ResetFrequency.ResetFrequencyBuilder;
import fpml.confirmation.ResetFrequency.ResetFrequencyBuilderImpl;
import fpml.confirmation.ResetFrequency.ResetFrequencyImpl;
import fpml.confirmation.WeeklyRollConventionEnum;
import fpml.confirmation.meta.ResetFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the reset frequency. In the case of a weekly reset, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency the this implies that more or more reset dates is established for each calculation period and some form of rate averaginhg is applicable. The specific averaging method of calculation is specified in FloatingRateCalculation. In case the reset frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
 * @version ${project.version}
 */
@RosettaDataType(value="ResetFrequency", builder=ResetFrequency.ResetFrequencyBuilderImpl.class, version="${project.version}")
public interface ResetFrequency extends Frequency {

	ResetFrequencyMeta metaData = new ResetFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.
	 */
	WeeklyRollConventionEnum getWeeklyRollConvention();

	/*********************** Build Methods  ***********************/
	ResetFrequency build();
	
	ResetFrequency.ResetFrequencyBuilder toBuilder();
	
	static ResetFrequency.ResetFrequencyBuilder builder() {
		return new ResetFrequency.ResetFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetFrequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ResetFrequency> getType() {
		return ResetFrequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("weeklyRollConvention"), WeeklyRollConventionEnum.class, getWeeklyRollConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetFrequencyBuilder extends ResetFrequency, Frequency.FrequencyBuilder {
		ResetFrequency.ResetFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		ResetFrequency.ResetFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		ResetFrequency.ResetFrequencyBuilder setId(String id);
		ResetFrequency.ResetFrequencyBuilder setWeeklyRollConvention(WeeklyRollConventionEnum weeklyRollConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("weeklyRollConvention"), WeeklyRollConventionEnum.class, getWeeklyRollConvention(), this);
		}
		

		ResetFrequency.ResetFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of ResetFrequency  ***********************/
	class ResetFrequencyImpl extends Frequency.FrequencyImpl implements ResetFrequency {
		private final WeeklyRollConventionEnum weeklyRollConvention;
		
		protected ResetFrequencyImpl(ResetFrequency.ResetFrequencyBuilder builder) {
			super(builder);
			this.weeklyRollConvention = builder.getWeeklyRollConvention();
		}
		
		@Override
		@RosettaAttribute("weeklyRollConvention")
		public WeeklyRollConventionEnum getWeeklyRollConvention() {
			return weeklyRollConvention;
		}
		
		@Override
		public ResetFrequency build() {
			return this;
		}
		
		@Override
		public ResetFrequency.ResetFrequencyBuilder toBuilder() {
			ResetFrequency.ResetFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetFrequency.ResetFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getWeeklyRollConvention()).ifPresent(builder::setWeeklyRollConvention);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(weeklyRollConvention, _that.getWeeklyRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weeklyRollConvention != null ? weeklyRollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetFrequency {" +
				"weeklyRollConvention=" + this.weeklyRollConvention +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ResetFrequency  ***********************/
	class ResetFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl  implements ResetFrequency.ResetFrequencyBuilder {
	
		protected WeeklyRollConventionEnum weeklyRollConvention;
	
		public ResetFrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("weeklyRollConvention")
		public WeeklyRollConventionEnum getWeeklyRollConvention() {
			return weeklyRollConvention;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public ResetFrequency.ResetFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public ResetFrequency.ResetFrequencyBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ResetFrequency.ResetFrequencyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("weeklyRollConvention")
		public ResetFrequency.ResetFrequencyBuilder setWeeklyRollConvention(WeeklyRollConventionEnum weeklyRollConvention) {
			this.weeklyRollConvention = weeklyRollConvention==null?null:weeklyRollConvention;
			return this;
		}
		
		@Override
		public ResetFrequency build() {
			return new ResetFrequency.ResetFrequencyImpl(this);
		}
		
		@Override
		public ResetFrequency.ResetFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetFrequency.ResetFrequencyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getWeeklyRollConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetFrequency.ResetFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ResetFrequency.ResetFrequencyBuilder o = (ResetFrequency.ResetFrequencyBuilder) other;
			
			
			merger.mergeBasic(getWeeklyRollConvention(), o.getWeeklyRollConvention(), this::setWeeklyRollConvention);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(weeklyRollConvention, _that.getWeeklyRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weeklyRollConvention != null ? weeklyRollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetFrequencyBuilder {" +
				"weeklyRollConvention=" + this.weeklyRollConvention +
			'}' + " " + super.toString();
		}
	}
}
