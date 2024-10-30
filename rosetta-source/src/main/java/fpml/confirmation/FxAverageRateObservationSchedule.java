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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.FxAverageRateObservationSchedule;
import fpml.confirmation.FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder;
import fpml.confirmation.FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilderImpl;
import fpml.confirmation.FxAverageRateObservationSchedule.FxAverageRateObservationScheduleImpl;
import fpml.confirmation.meta.FxAverageRateObservationScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes average rate options rate observations. This is used to describe a parametric frequency of rate observations against a particular rate. Typical frequencies might include daily, every Friday, etc.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAverageRateObservationSchedule", builder=FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAverageRateObservationSchedule extends RosettaModelObject {

	FxAverageRateObservationScheduleMeta metaData = new FxAverageRateObservationScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The start of the period over which observations are made to determine whether a trigger has occurred.
	 */
	Date getStartDate();
	/**
	 * The end of the period over which observations are made to determine whether a trigger event has occurred.
	 */
	Date getEndDate();
	/**
	 * The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
	 */
	CalculationPeriodFrequency getCalculationPeriodFrequency();

	/*********************** Build Methods  ***********************/
	FxAverageRateObservationSchedule build();
	
	FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder toBuilder();
	
	static FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder builder() {
		return new FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAverageRateObservationSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAverageRateObservationSchedule> getType() {
		return FxAverageRateObservationSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.class, getCalculationPeriodFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAverageRateObservationScheduleBuilder extends FxAverageRateObservationSchedule, RosettaModelObjectBuilder {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency();
		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder setStartDate(Date startDate);
		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder setEndDate(Date endDate);
		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getCalculationPeriodFrequency());
		}
		

		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxAverageRateObservationSchedule  ***********************/
	class FxAverageRateObservationScheduleImpl implements FxAverageRateObservationSchedule {
		private final Date startDate;
		private final Date endDate;
		private final CalculationPeriodFrequency calculationPeriodFrequency;
		
		protected FxAverageRateObservationScheduleImpl(FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.calculationPeriodFrequency = ofNullable(builder.getCalculationPeriodFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public CalculationPeriodFrequency getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		public FxAverageRateObservationSchedule build() {
			return this;
		}
		
		@Override
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder toBuilder() {
			FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getCalculationPeriodFrequency()).ifPresent(builder::setCalculationPeriodFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAverageRateObservationSchedule _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRateObservationSchedule {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAverageRateObservationSchedule  ***********************/
	class FxAverageRateObservationScheduleBuilderImpl implements FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder {
	
		protected Date startDate;
		protected Date endDate;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency;
	
		public FxAverageRateObservationScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
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
		@RosettaAttribute("startDate")
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency) {
			this.calculationPeriodFrequency = calculationPeriodFrequency==null?null:calculationPeriodFrequency.toBuilder();
			return this;
		}
		
		@Override
		public FxAverageRateObservationSchedule build() {
			return new FxAverageRateObservationSchedule.FxAverageRateObservationScheduleImpl(this);
		}
		
		@Override
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder prune() {
			if (calculationPeriodFrequency!=null && !calculationPeriodFrequency.prune().hasData()) calculationPeriodFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getCalculationPeriodFrequency()!=null && getCalculationPeriodFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder o = (FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodFrequency(), o.getCalculationPeriodFrequency(), this::setCalculationPeriodFrequency);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAverageRateObservationSchedule _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRateObservationScheduleBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency +
			'}';
		}
	}
}
