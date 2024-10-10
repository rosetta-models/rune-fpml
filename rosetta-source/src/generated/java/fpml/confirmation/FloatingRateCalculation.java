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
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.FloatingRate;
import fpml.confirmation.FloatingRate.FloatingRateBuilder;
import fpml.confirmation.FloatingRate.FloatingRateBuilderImpl;
import fpml.confirmation.FloatingRate.FloatingRateImpl;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.FloatingRateCalculation.FloatingRateCalculationBuilder;
import fpml.confirmation.FloatingRateCalculation.FloatingRateCalculationBuilderImpl;
import fpml.confirmation.FloatingRateCalculation.FloatingRateCalculationImpl;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.NegativeInterestRateTreatmentEnum;
import fpml.confirmation.RateTreatmentEnum;
import fpml.confirmation.Rounding;
import fpml.confirmation.Schedule;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.StrikeSchedule;
import fpml.confirmation.meta.FloatingRateCalculationMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A floating rate calculation definition. A type defining the floating rate and definitions relating to the calculation of floating rate amounts.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateCalculation", builder=FloatingRateCalculation.FloatingRateCalculationBuilderImpl.class, version="${project.version}")
public interface FloatingRateCalculation extends FloatingRate {

	FloatingRateCalculationMeta metaData = new FloatingRateCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
	 */
	BigDecimal getInitialRate();
	/**
	 * The rounding convention to apply to the final rate used in determination of a calculation period amount.
	 */
	Rounding getFinalRateRounding();
	/**
	 * If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 * The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
	 */
	NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment();

	/*********************** Build Methods  ***********************/
	FloatingRateCalculation build();
	
	FloatingRateCalculation.FloatingRateCalculationBuilder toBuilder();
	
	static FloatingRateCalculation.FloatingRateCalculationBuilder builder() {
		return new FloatingRateCalculation.FloatingRateCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateCalculation> getType() {
		return FloatingRateCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.class, getFloatingRateIndexModel());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.class, getFloatingRateMultiplierSchedule());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processor.processBasic(path.newSubPath("initialRate"), BigDecimal.class, getInitialRate(), this);
		processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.class, getFinalRateRounding());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateCalculationBuilder extends FloatingRateCalculation, FloatingRate.FloatingRateBuilder {
		Rounding.RoundingBuilder getOrCreateFinalRateRounding();
		Rounding.RoundingBuilder getFinalRateRounding();
		FloatingRateCalculation.FloatingRateCalculationBuilder setId(String id);
		FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel);
		FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule0);
		FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule1, int _idx);
		FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule2);
		FloatingRateCalculation.FloatingRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule3);
		FloatingRateCalculation.FloatingRateCalculationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule0);
		FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule1, int _idx);
		FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule2);
		FloatingRateCalculation.FloatingRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule3);
		FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule0);
		FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule1, int _idx);
		FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule2);
		FloatingRateCalculation.FloatingRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule3);
		FloatingRateCalculation.FloatingRateCalculationBuilder setInitialRate(BigDecimal initialRate);
		FloatingRateCalculation.FloatingRateCalculationBuilder setFinalRateRounding(Rounding finalRateRounding);
		FloatingRateCalculation.FloatingRateCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		FloatingRateCalculation.FloatingRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.FloatingRateIndexModelBuilder.class, getFloatingRateIndexModel());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.ScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processor.processBasic(path.newSubPath("initialRate"), BigDecimal.class, getInitialRate(), this);
			processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.RoundingBuilder.class, getFinalRateRounding());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
		}
		

		FloatingRateCalculation.FloatingRateCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateCalculation  ***********************/
	class FloatingRateCalculationImpl extends FloatingRate.FloatingRateImpl implements FloatingRateCalculation {
		private final BigDecimal initialRate;
		private final Rounding finalRateRounding;
		private final AveragingMethodEnum averagingMethod;
		private final NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		protected FloatingRateCalculationImpl(FloatingRateCalculation.FloatingRateCalculationBuilder builder) {
			super(builder);
			this.initialRate = builder.getInitialRate();
			this.finalRateRounding = ofNullable(builder.getFinalRateRounding()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.negativeInterestRateTreatment = builder.getNegativeInterestRateTreatment();
		}
		
		@Override
		@RosettaAttribute("initialRate")
		public BigDecimal getInitialRate() {
			return initialRate;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		public Rounding getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
		@Override
		public FloatingRateCalculation build() {
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder toBuilder() {
			FloatingRateCalculation.FloatingRateCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateCalculation.FloatingRateCalculationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInitialRate()).ifPresent(builder::setInitialRate);
			ofNullable(getFinalRateRounding()).ifPresent(builder::setFinalRateRounding);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getNegativeInterestRateTreatment()).ifPresent(builder::setNegativeInterestRateTreatment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateCalculation {" +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateCalculation  ***********************/
	class FloatingRateCalculationBuilderImpl extends FloatingRate.FloatingRateBuilderImpl  implements FloatingRateCalculation.FloatingRateCalculationBuilder {
	
		protected BigDecimal initialRate;
		protected Rounding.RoundingBuilder finalRateRounding;
		protected AveragingMethodEnum averagingMethod;
		protected NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
	
		public FloatingRateCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialRate")
		public BigDecimal getInitialRate() {
			return initialRate;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		public Rounding.RoundingBuilder getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateFinalRateRounding() {
			Rounding.RoundingBuilder result;
			if (finalRateRounding!=null) {
				result = finalRateRounding;
			}
			else {
				result = finalRateRounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
		@Override
		@RosettaAttribute("id")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel) {
			this.floatingRateIndexModel = floatingRateIndexModel==null?null:floatingRateIndexModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = floatingRateMultiplierSchedule==null?null:floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("spreadSchedule")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null)  {
				this.spreadSchedule = new ArrayList<>();
			}
			else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setRateTreatment(RateTreatmentEnum rateTreatment) {
			this.rateTreatment = rateTreatment==null?null:rateTreatment;
			return this;
		}
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule) {
			if (capRateSchedule!=null) this.capRateSchedule.add(capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx) {
			getIndex(this.capRateSchedule, _idx, () -> capRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("capRateSchedule")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules == null)  {
				this.capRateSchedule = new ArrayList<>();
			}
			else {
				this.capRateSchedule = capRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule) {
			if (floorRateSchedule!=null) this.floorRateSchedule.add(floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx) {
			getIndex(this.floorRateSchedule, _idx, () -> floorRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("floorRateSchedule")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules == null)  {
				this.floorRateSchedule = new ArrayList<>();
			}
			else {
				this.floorRateSchedule = floorRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("initialRate")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setInitialRate(BigDecimal initialRate) {
			this.initialRate = initialRate==null?null:initialRate;
			return this;
		}
		@Override
		@RosettaAttribute("finalRateRounding")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFinalRateRounding(Rounding finalRateRounding) {
			this.finalRateRounding = finalRateRounding==null?null:finalRateRounding.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		public FloatingRateCalculation.FloatingRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = negativeInterestRateTreatment==null?null:negativeInterestRateTreatment;
			return this;
		}
		
		@Override
		public FloatingRateCalculation build() {
			return new FloatingRateCalculation.FloatingRateCalculationImpl(this);
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder prune() {
			super.prune();
			if (finalRateRounding!=null && !finalRateRounding.prune().hasData()) finalRateRounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInitialRate()!=null) return true;
			if (getFinalRateRounding()!=null && getFinalRateRounding().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getNegativeInterestRateTreatment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateCalculation.FloatingRateCalculationBuilder o = (FloatingRateCalculation.FloatingRateCalculationBuilder) other;
			
			merger.mergeRosetta(getFinalRateRounding(), o.getFinalRateRounding(), this::setFinalRateRounding);
			
			merger.mergeBasic(getInitialRate(), o.getInitialRate(), this::setInitialRate);
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getNegativeInterestRateTreatment(), o.getNegativeInterestRateTreatment(), this::setNegativeInterestRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateCalculationBuilder {" +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}
}
