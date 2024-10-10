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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CalculationAmount;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingAmountCalculation;
import fpml.confirmation.FloatingAmountCalculation.FloatingAmountCalculationBuilder;
import fpml.confirmation.FloatingAmountCalculation.FloatingAmountCalculationBuilderImpl;
import fpml.confirmation.FloatingAmountCalculation.FloatingAmountCalculationImpl;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.meta.FloatingAmountCalculationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingAmountCalculation", builder=FloatingAmountCalculation.FloatingAmountCalculationBuilderImpl.class, version="${project.version}")
public interface FloatingAmountCalculation extends RosettaModelObject {

	FloatingAmountCalculationMeta metaData = new FloatingAmountCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The notional amount used in the calculation of fixed amounts where an amount is calculated on a formula basis, i.e. fixed amount = fixed rate payer calculation amount x fixed rate x fixed rate day count fraction. ISDA 2003 Term: Fixed Rate Payer Calculation Amount.
	 */
	CalculationAmount getCalculationAmount();
	/**
	 * The calculation period floating rate.
	 */
	FloatingRateCalculation getFloatingRate();
	/**
	 * The day count fraction. ISDA 2003 Term: Fixed Rate Day Count Fraction.
	 */
	DayCountFraction getDayCountFraction();
	Date getInitialFixingDate();
	AdjustableDate getFinalFixingDate();

	/*********************** Build Methods  ***********************/
	FloatingAmountCalculation build();
	
	FloatingAmountCalculation.FloatingAmountCalculationBuilder toBuilder();
	
	static FloatingAmountCalculation.FloatingAmountCalculationBuilder builder() {
		return new FloatingAmountCalculation.FloatingAmountCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingAmountCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingAmountCalculation> getType() {
		return FloatingAmountCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.class, getCalculationAmount());
		processRosetta(path.newSubPath("floatingRate"), processor, FloatingRateCalculation.class, getFloatingRate());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("initialFixingDate"), Date.class, getInitialFixingDate(), this);
		processRosetta(path.newSubPath("finalFixingDate"), processor, AdjustableDate.class, getFinalFixingDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingAmountCalculationBuilder extends FloatingAmountCalculation, RosettaModelObjectBuilder {
		CalculationAmount.CalculationAmountBuilder getOrCreateCalculationAmount();
		CalculationAmount.CalculationAmountBuilder getCalculationAmount();
		FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRate();
		FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRate();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		AdjustableDate.AdjustableDateBuilder getOrCreateFinalFixingDate();
		AdjustableDate.AdjustableDateBuilder getFinalFixingDate();
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setCalculationAmount(CalculationAmount calculationAmount);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setFloatingRate(FloatingRateCalculation floatingRate);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setInitialFixingDate(Date initialFixingDate);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setFinalFixingDate(AdjustableDate finalFixingDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.CalculationAmountBuilder.class, getCalculationAmount());
			processRosetta(path.newSubPath("floatingRate"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRate());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("initialFixingDate"), Date.class, getInitialFixingDate(), this);
			processRosetta(path.newSubPath("finalFixingDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getFinalFixingDate());
		}
		

		FloatingAmountCalculation.FloatingAmountCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingAmountCalculation  ***********************/
	class FloatingAmountCalculationImpl implements FloatingAmountCalculation {
		private final CalculationAmount calculationAmount;
		private final FloatingRateCalculation floatingRate;
		private final DayCountFraction dayCountFraction;
		private final Date initialFixingDate;
		private final AdjustableDate finalFixingDate;
		
		protected FloatingAmountCalculationImpl(FloatingAmountCalculation.FloatingAmountCalculationBuilder builder) {
			this.calculationAmount = ofNullable(builder.getCalculationAmount()).map(f->f.build()).orElse(null);
			this.floatingRate = ofNullable(builder.getFloatingRate()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.initialFixingDate = builder.getInitialFixingDate();
			this.finalFixingDate = ofNullable(builder.getFinalFixingDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		public CalculationAmount getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		public FloatingRateCalculation getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("initialFixingDate")
		public Date getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		@RosettaAttribute("finalFixingDate")
		public AdjustableDate getFinalFixingDate() {
			return finalFixingDate;
		}
		
		@Override
		public FloatingAmountCalculation build() {
			return this;
		}
		
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder toBuilder() {
			FloatingAmountCalculation.FloatingAmountCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingAmountCalculation.FloatingAmountCalculationBuilder builder) {
			ofNullable(getCalculationAmount()).ifPresent(builder::setCalculationAmount);
			ofNullable(getFloatingRate()).ifPresent(builder::setFloatingRate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getInitialFixingDate()).ifPresent(builder::setInitialFixingDate);
			ofNullable(getFinalFixingDate()).ifPresent(builder::setFinalFixingDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(finalFixingDate, _that.getFinalFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (finalFixingDate != null ? finalFixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingAmountCalculation {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"floatingRate=" + this.floatingRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"finalFixingDate=" + this.finalFixingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingAmountCalculation  ***********************/
	class FloatingAmountCalculationBuilderImpl implements FloatingAmountCalculation.FloatingAmountCalculationBuilder {
	
		protected CalculationAmount.CalculationAmountBuilder calculationAmount;
		protected FloatingRateCalculation.FloatingRateCalculationBuilder floatingRate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Date initialFixingDate;
		protected AdjustableDate.AdjustableDateBuilder finalFixingDate;
	
		public FloatingAmountCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationAmount")
		public CalculationAmount.CalculationAmountBuilder getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder getOrCreateCalculationAmount() {
			CalculationAmount.CalculationAmountBuilder result;
			if (calculationAmount!=null) {
				result = calculationAmount;
			}
			else {
				result = calculationAmount = CalculationAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		public FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRate() {
			FloatingRateCalculation.FloatingRateCalculationBuilder result;
			if (floatingRate!=null) {
				result = floatingRate;
			}
			else {
				result = floatingRate = FloatingRateCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialFixingDate")
		public Date getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		@RosettaAttribute("finalFixingDate")
		public AdjustableDate.AdjustableDateBuilder getFinalFixingDate() {
			return finalFixingDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateFinalFixingDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (finalFixingDate!=null) {
				result = finalFixingDate;
			}
			else {
				result = finalFixingDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setCalculationAmount(CalculationAmount calculationAmount) {
			this.calculationAmount = calculationAmount==null?null:calculationAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRate")
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setFloatingRate(FloatingRateCalculation floatingRate) {
			this.floatingRate = floatingRate==null?null:floatingRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialFixingDate")
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setInitialFixingDate(Date initialFixingDate) {
			this.initialFixingDate = initialFixingDate==null?null:initialFixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("finalFixingDate")
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setFinalFixingDate(AdjustableDate finalFixingDate) {
			this.finalFixingDate = finalFixingDate==null?null:finalFixingDate.toBuilder();
			return this;
		}
		
		@Override
		public FloatingAmountCalculation build() {
			return new FloatingAmountCalculation.FloatingAmountCalculationImpl(this);
		}
		
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder prune() {
			if (calculationAmount!=null && !calculationAmount.prune().hasData()) calculationAmount = null;
			if (floatingRate!=null && !floatingRate.prune().hasData()) floatingRate = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (finalFixingDate!=null && !finalFixingDate.prune().hasData()) finalFixingDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAmount()!=null && getCalculationAmount().hasData()) return true;
			if (getFloatingRate()!=null && getFloatingRate().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getInitialFixingDate()!=null) return true;
			if (getFinalFixingDate()!=null && getFinalFixingDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingAmountCalculation.FloatingAmountCalculationBuilder o = (FloatingAmountCalculation.FloatingAmountCalculationBuilder) other;
			
			merger.mergeRosetta(getCalculationAmount(), o.getCalculationAmount(), this::setCalculationAmount);
			merger.mergeRosetta(getFloatingRate(), o.getFloatingRate(), this::setFloatingRate);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getFinalFixingDate(), o.getFinalFixingDate(), this::setFinalFixingDate);
			
			merger.mergeBasic(getInitialFixingDate(), o.getInitialFixingDate(), this::setInitialFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(finalFixingDate, _that.getFinalFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (finalFixingDate != null ? finalFixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingAmountCalculationBuilder {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"floatingRate=" + this.floatingRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"finalFixingDate=" + this.finalFixingDate +
			'}';
		}
	}
}
