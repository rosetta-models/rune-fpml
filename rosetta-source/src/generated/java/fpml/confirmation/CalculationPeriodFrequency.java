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
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder;
import fpml.confirmation.CalculationPeriodFrequency.CalculationPeriodFrequencyBuilderImpl;
import fpml.confirmation.CalculationPeriodFrequency.CalculationPeriodFrequencyImpl;
import fpml.confirmation.Frequency;
import fpml.confirmation.Frequency.FrequencyBuilder;
import fpml.confirmation.Frequency.FrequencyBuilderImpl;
import fpml.confirmation.Frequency.FrequencyImpl;
import fpml.confirmation.PeriodExtendedEnum;
import fpml.confirmation.RollConventionEnum;
import fpml.confirmation.meta.CalculationPeriodFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the frequency at which calculation period end dates occur within the regular part of the calculation period schedule and thier roll date convention. In case the calculation frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
 * @version ${project.version}
 */
@RosettaDataType(value="CalculationPeriodFrequency", builder=CalculationPeriodFrequency.CalculationPeriodFrequencyBuilderImpl.class, version="${project.version}")
public interface CalculationPeriodFrequency extends Frequency {

	CalculationPeriodFrequencyMeta metaData = new CalculationPeriodFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Used in conjunction with a frequency and the regular period start date of a calculation period, determines each calculation period end date within the regular part of a calculation period schedule.
	 */
	RollConventionEnum getRollConvention();

	/*********************** Build Methods  ***********************/
	CalculationPeriodFrequency build();
	
	CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder toBuilder();
	
	static CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder() {
		return new CalculationPeriodFrequency.CalculationPeriodFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodFrequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationPeriodFrequency> getType() {
		return CalculationPeriodFrequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("rollConvention"), RollConventionEnum.class, getRollConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodFrequencyBuilder extends CalculationPeriodFrequency, Frequency.FrequencyBuilder {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setId(String id);
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setRollConvention(RollConventionEnum rollConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("rollConvention"), RollConventionEnum.class, getRollConvention(), this);
		}
		

		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodFrequency  ***********************/
	class CalculationPeriodFrequencyImpl extends Frequency.FrequencyImpl implements CalculationPeriodFrequency {
		private final RollConventionEnum rollConvention;
		
		protected CalculationPeriodFrequencyImpl(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder) {
			super(builder);
			this.rollConvention = builder.getRollConvention();
		}
		
		@Override
		@RosettaAttribute("rollConvention")
		public RollConventionEnum getRollConvention() {
			return rollConvention;
		}
		
		@Override
		public CalculationPeriodFrequency build() {
			return this;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder toBuilder() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRollConvention()).ifPresent(builder::setRollConvention);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodFrequency _that = getType().cast(o);
		
			if (!Objects.equals(rollConvention, _that.getRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rollConvention != null ? rollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodFrequency {" +
				"rollConvention=" + this.rollConvention +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationPeriodFrequency  ***********************/
	class CalculationPeriodFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl  implements CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder {
	
		protected RollConventionEnum rollConvention;
	
		public CalculationPeriodFrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rollConvention")
		public RollConventionEnum getRollConvention() {
			return rollConvention;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("rollConvention")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder setRollConvention(RollConventionEnum rollConvention) {
			this.rollConvention = rollConvention==null?null:rollConvention;
			return this;
		}
		
		@Override
		public CalculationPeriodFrequency build() {
			return new CalculationPeriodFrequency.CalculationPeriodFrequencyImpl(this);
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRollConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder o = (CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder) other;
			
			
			merger.mergeBasic(getRollConvention(), o.getRollConvention(), this::setRollConvention);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodFrequency _that = getType().cast(o);
		
			if (!Objects.equals(rollConvention, _that.getRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rollConvention != null ? rollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodFrequencyBuilder {" +
				"rollConvention=" + this.rollConvention +
			'}' + " " + super.toString();
		}
	}
}
