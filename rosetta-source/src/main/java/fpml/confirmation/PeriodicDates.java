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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.PeriodicDates;
import fpml.confirmation.PeriodicDates.PeriodicDatesBuilder;
import fpml.confirmation.PeriodicDates.PeriodicDatesBuilderImpl;
import fpml.confirmation.PeriodicDates.PeriodicDatesImpl;
import fpml.confirmation.meta.PeriodicDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PeriodicDates", builder=PeriodicDates.PeriodicDatesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PeriodicDates extends RosettaModelObject {

	PeriodicDatesMeta metaData = new PeriodicDatesMeta();

	/*********************** Getter Methods  ***********************/
	AdjustableOrRelativeDate getCalculationStartDate();
	AdjustableOrRelativeDate getCalculationEndDate();
	/**
	 * The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
	 */
	CalculationPeriodFrequency getCalculationPeriodFrequency();
	/**
	 * The business day convention to apply to each calculation period end date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 */
	BusinessDayAdjustments getCalculationPeriodDatesAdjustments();

	/*********************** Build Methods  ***********************/
	PeriodicDates build();
	
	PeriodicDates.PeriodicDatesBuilder toBuilder();
	
	static PeriodicDates.PeriodicDatesBuilder builder() {
		return new PeriodicDates.PeriodicDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PeriodicDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PeriodicDates> getType() {
		return PeriodicDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationStartDate"), processor, AdjustableOrRelativeDate.class, getCalculationStartDate());
		processRosetta(path.newSubPath("calculationEndDate"), processor, AdjustableOrRelativeDate.class, getCalculationEndDate());
		processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.class, getCalculationPeriodFrequency());
		processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.class, getCalculationPeriodDatesAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodicDatesBuilder extends PeriodicDates, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCalculationStartDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCalculationStartDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCalculationEndDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCalculationEndDate();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments();
		PeriodicDates.PeriodicDatesBuilder setCalculationStartDate(AdjustableOrRelativeDate calculationStartDate);
		PeriodicDates.PeriodicDatesBuilder setCalculationEndDate(AdjustableOrRelativeDate calculationEndDate);
		PeriodicDates.PeriodicDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency);
		PeriodicDates.PeriodicDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments calculationPeriodDatesAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCalculationStartDate());
			processRosetta(path.newSubPath("calculationEndDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCalculationEndDate());
			processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getCalculationPeriodFrequency());
			processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getCalculationPeriodDatesAdjustments());
		}
		

		PeriodicDates.PeriodicDatesBuilder prune();
	}

	/*********************** Immutable Implementation of PeriodicDates  ***********************/
	class PeriodicDatesImpl implements PeriodicDates {
		private final AdjustableOrRelativeDate calculationStartDate;
		private final AdjustableOrRelativeDate calculationEndDate;
		private final CalculationPeriodFrequency calculationPeriodFrequency;
		private final BusinessDayAdjustments calculationPeriodDatesAdjustments;
		
		protected PeriodicDatesImpl(PeriodicDates.PeriodicDatesBuilder builder) {
			this.calculationStartDate = ofNullable(builder.getCalculationStartDate()).map(f->f.build()).orElse(null);
			this.calculationEndDate = ofNullable(builder.getCalculationEndDate()).map(f->f.build()).orElse(null);
			this.calculationPeriodFrequency = ofNullable(builder.getCalculationPeriodFrequency()).map(f->f.build()).orElse(null);
			this.calculationPeriodDatesAdjustments = ofNullable(builder.getCalculationPeriodDatesAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationStartDate")
		public AdjustableOrRelativeDate getCalculationStartDate() {
			return calculationStartDate;
		}
		
		@Override
		@RosettaAttribute("calculationEndDate")
		public AdjustableOrRelativeDate getCalculationEndDate() {
			return calculationEndDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public CalculationPeriodFrequency getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		public BusinessDayAdjustments getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		public PeriodicDates build() {
			return this;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder toBuilder() {
			PeriodicDates.PeriodicDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodicDates.PeriodicDatesBuilder builder) {
			ofNullable(getCalculationStartDate()).ifPresent(builder::setCalculationStartDate);
			ofNullable(getCalculationEndDate()).ifPresent(builder::setCalculationEndDate);
			ofNullable(getCalculationPeriodFrequency()).ifPresent(builder::setCalculationPeriodFrequency);
			ofNullable(getCalculationPeriodDatesAdjustments()).ifPresent(builder::setCalculationPeriodDatesAdjustments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationStartDate, _that.getCalculationStartDate())) return false;
			if (!Objects.equals(calculationEndDate, _that.getCalculationEndDate())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationStartDate != null ? calculationStartDate.hashCode() : 0);
			_result = 31 * _result + (calculationEndDate != null ? calculationEndDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicDates {" +
				"calculationStartDate=" + this.calculationStartDate + ", " +
				"calculationEndDate=" + this.calculationEndDate + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency + ", " +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments +
			'}';
		}
	}

	/*********************** Builder Implementation of PeriodicDates  ***********************/
	class PeriodicDatesBuilderImpl implements PeriodicDates.PeriodicDatesBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder calculationStartDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder calculationEndDate;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder calculationPeriodDatesAdjustments;
	
		public PeriodicDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationStartDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCalculationStartDate() {
			return calculationStartDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCalculationStartDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (calculationStartDate!=null) {
				result = calculationStartDate;
			}
			else {
				result = calculationStartDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationEndDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCalculationEndDate() {
			return calculationEndDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCalculationEndDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (calculationEndDate!=null) {
				result = calculationEndDate;
			}
			else {
				result = calculationEndDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (calculationPeriodFrequency!=null) {
				result = calculationPeriodFrequency;
			}
			else {
				result = calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (calculationPeriodDatesAdjustments!=null) {
				result = calculationPeriodDatesAdjustments;
			}
			else {
				result = calculationPeriodDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationStartDate")
		public PeriodicDates.PeriodicDatesBuilder setCalculationStartDate(AdjustableOrRelativeDate calculationStartDate) {
			this.calculationStartDate = calculationStartDate==null?null:calculationStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationEndDate")
		public PeriodicDates.PeriodicDatesBuilder setCalculationEndDate(AdjustableOrRelativeDate calculationEndDate) {
			this.calculationEndDate = calculationEndDate==null?null:calculationEndDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public PeriodicDates.PeriodicDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency) {
			this.calculationPeriodFrequency = calculationPeriodFrequency==null?null:calculationPeriodFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		public PeriodicDates.PeriodicDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments calculationPeriodDatesAdjustments) {
			this.calculationPeriodDatesAdjustments = calculationPeriodDatesAdjustments==null?null:calculationPeriodDatesAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public PeriodicDates build() {
			return new PeriodicDates.PeriodicDatesImpl(this);
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicDates.PeriodicDatesBuilder prune() {
			if (calculationStartDate!=null && !calculationStartDate.prune().hasData()) calculationStartDate = null;
			if (calculationEndDate!=null && !calculationEndDate.prune().hasData()) calculationEndDate = null;
			if (calculationPeriodFrequency!=null && !calculationPeriodFrequency.prune().hasData()) calculationPeriodFrequency = null;
			if (calculationPeriodDatesAdjustments!=null && !calculationPeriodDatesAdjustments.prune().hasData()) calculationPeriodDatesAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationStartDate()!=null && getCalculationStartDate().hasData()) return true;
			if (getCalculationEndDate()!=null && getCalculationEndDate().hasData()) return true;
			if (getCalculationPeriodFrequency()!=null && getCalculationPeriodFrequency().hasData()) return true;
			if (getCalculationPeriodDatesAdjustments()!=null && getCalculationPeriodDatesAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicDates.PeriodicDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodicDates.PeriodicDatesBuilder o = (PeriodicDates.PeriodicDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationStartDate(), o.getCalculationStartDate(), this::setCalculationStartDate);
			merger.mergeRosetta(getCalculationEndDate(), o.getCalculationEndDate(), this::setCalculationEndDate);
			merger.mergeRosetta(getCalculationPeriodFrequency(), o.getCalculationPeriodFrequency(), this::setCalculationPeriodFrequency);
			merger.mergeRosetta(getCalculationPeriodDatesAdjustments(), o.getCalculationPeriodDatesAdjustments(), this::setCalculationPeriodDatesAdjustments);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationStartDate, _that.getCalculationStartDate())) return false;
			if (!Objects.equals(calculationEndDate, _that.getCalculationEndDate())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationStartDate != null ? calculationStartDate.hashCode() : 0);
			_result = 31 * _result + (calculationEndDate != null ? calculationEndDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicDatesBuilder {" +
				"calculationStartDate=" + this.calculationStartDate + ", " +
				"calculationEndDate=" + this.calculationEndDate + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency + ", " +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments +
			'}';
		}
	}
}
