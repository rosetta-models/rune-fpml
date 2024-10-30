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
import fpml.confirmation.CalculationAmount;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FixedAmountCalculation;
import fpml.confirmation.FixedAmountCalculation.FixedAmountCalculationBuilder;
import fpml.confirmation.FixedAmountCalculation.FixedAmountCalculationBuilderImpl;
import fpml.confirmation.FixedAmountCalculation.FixedAmountCalculationImpl;
import fpml.confirmation.FixedRate;
import fpml.confirmation.meta.FixedAmountCalculationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FixedAmountCalculation", builder=FixedAmountCalculation.FixedAmountCalculationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FixedAmountCalculation extends RosettaModelObject {

	FixedAmountCalculationMeta metaData = new FixedAmountCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The notional amount used in the calculation of fixed amounts where an amount is calculated on a formula basis, i.e. fixed amount = fixed rate payer calculation amount x fixed rate x fixed rate day count fraction. ISDA 2003 Term: Fixed Rate Payer Calculation Amount.
	 */
	CalculationAmount getCalculationAmount();
	/**
	 * The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 */
	FixedRate getFixedRate();
	/**
	 * The day count fraction. ISDA 2003 Term: Fixed Rate Day Count Fraction.
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	FixedAmountCalculation build();
	
	FixedAmountCalculation.FixedAmountCalculationBuilder toBuilder();
	
	static FixedAmountCalculation.FixedAmountCalculationBuilder builder() {
		return new FixedAmountCalculation.FixedAmountCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedAmountCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedAmountCalculation> getType() {
		return FixedAmountCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.class, getCalculationAmount());
		processRosetta(path.newSubPath("fixedRate"), processor, FixedRate.class, getFixedRate());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedAmountCalculationBuilder extends FixedAmountCalculation, RosettaModelObjectBuilder {
		CalculationAmount.CalculationAmountBuilder getOrCreateCalculationAmount();
		CalculationAmount.CalculationAmountBuilder getCalculationAmount();
		FixedRate.FixedRateBuilder getOrCreateFixedRate();
		FixedRate.FixedRateBuilder getFixedRate();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		FixedAmountCalculation.FixedAmountCalculationBuilder setCalculationAmount(CalculationAmount calculationAmount);
		FixedAmountCalculation.FixedAmountCalculationBuilder setFixedRate(FixedRate fixedRate);
		FixedAmountCalculation.FixedAmountCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.CalculationAmountBuilder.class, getCalculationAmount());
			processRosetta(path.newSubPath("fixedRate"), processor, FixedRate.FixedRateBuilder.class, getFixedRate());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		FixedAmountCalculation.FixedAmountCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FixedAmountCalculation  ***********************/
	class FixedAmountCalculationImpl implements FixedAmountCalculation {
		private final CalculationAmount calculationAmount;
		private final FixedRate fixedRate;
		private final DayCountFraction dayCountFraction;
		
		protected FixedAmountCalculationImpl(FixedAmountCalculation.FixedAmountCalculationBuilder builder) {
			this.calculationAmount = ofNullable(builder.getCalculationAmount()).map(f->f.build()).orElse(null);
			this.fixedRate = ofNullable(builder.getFixedRate()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		public CalculationAmount getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public FixedRate getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public FixedAmountCalculation build() {
			return this;
		}
		
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder toBuilder() {
			FixedAmountCalculation.FixedAmountCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedAmountCalculation.FixedAmountCalculationBuilder builder) {
			ofNullable(getCalculationAmount()).ifPresent(builder::setCalculationAmount);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedAmountCalculation {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedAmountCalculation  ***********************/
	class FixedAmountCalculationBuilderImpl implements FixedAmountCalculation.FixedAmountCalculationBuilder {
	
		protected CalculationAmount.CalculationAmountBuilder calculationAmount;
		protected FixedRate.FixedRateBuilder fixedRate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
	
		public FixedAmountCalculationBuilderImpl() {
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
		@RosettaAttribute("fixedRate")
		public FixedRate.FixedRateBuilder getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public FixedRate.FixedRateBuilder getOrCreateFixedRate() {
			FixedRate.FixedRateBuilder result;
			if (fixedRate!=null) {
				result = fixedRate;
			}
			else {
				result = fixedRate = FixedRate.builder();
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
		@RosettaAttribute("calculationAmount")
		public FixedAmountCalculation.FixedAmountCalculationBuilder setCalculationAmount(CalculationAmount calculationAmount) {
			this.calculationAmount = calculationAmount==null?null:calculationAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public FixedAmountCalculation.FixedAmountCalculationBuilder setFixedRate(FixedRate fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FixedAmountCalculation.FixedAmountCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public FixedAmountCalculation build() {
			return new FixedAmountCalculation.FixedAmountCalculationImpl(this);
		}
		
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder prune() {
			if (calculationAmount!=null && !calculationAmount.prune().hasData()) calculationAmount = null;
			if (fixedRate!=null && !fixedRate.prune().hasData()) fixedRate = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAmount()!=null && getCalculationAmount().hasData()) return true;
			if (getFixedRate()!=null && getFixedRate().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedAmountCalculation.FixedAmountCalculationBuilder o = (FixedAmountCalculation.FixedAmountCalculationBuilder) other;
			
			merger.mergeRosetta(getCalculationAmount(), o.getCalculationAmount(), this::setCalculationAmount);
			merger.mergeRosetta(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedAmountCalculationBuilder {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}
}
