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
import fpml.confirmation.Calculation;
import fpml.confirmation.Calculation.CalculationBuilder;
import fpml.confirmation.Calculation.CalculationBuilderImpl;
import fpml.confirmation.Calculation.CalculationImpl;
import fpml.confirmation.CalculationSequence;
import fpml.confirmation.CompoundingMethodEnum;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.Discounting;
import fpml.confirmation.FxLinkedNotionalSchedule;
import fpml.confirmation.Notional;
import fpml.confirmation.Rate;
import fpml.confirmation.meta.CalculationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type definining the parameters used in the calculation of fixed or floating calculation period amounts.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Calculation", builder=Calculation.CalculationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Calculation extends RosettaModelObject {

	CalculationMeta metaData = new CalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The notional amount or notional amount schedule.
	 */
	Notional getNotionalSchedule();
	/**
	 * A notional amount schedule where each notional that applied to a calculation period is calculated with reference to a notional amount or notional amount schedule in a different currency by means of a spot currency exchange rate which is normally observed at the beginning of each period.
	 */
	FxLinkedNotionalSchedule getFxLinkedNotionalSchedule();
	CalculationSequence getCalculationSequence();
	Rate getRateCalculation();
	/**
	 * The day count fraction.
	 */
	DayCountFraction getDayCountFraction();
	/**
	 * The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.
	 */
	Discounting getDiscounting();
	/**
	 * If more that one calculation period contributes to a single payment amount this element specifies whether compounding is applicable, and if so, what compounding method is to be used. This element must only be included when more that one calculation period contributes to a single payment amount.
	 */
	CompoundingMethodEnum getCompoundingMethod();

	/*********************** Build Methods  ***********************/
	Calculation build();
	
	Calculation.CalculationBuilder toBuilder();
	
	static Calculation.CalculationBuilder builder() {
		return new Calculation.CalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Calculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Calculation> getType() {
		return Calculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalSchedule"), processor, Notional.class, getNotionalSchedule());
		processRosetta(path.newSubPath("fxLinkedNotionalSchedule"), processor, FxLinkedNotionalSchedule.class, getFxLinkedNotionalSchedule());
		processRosetta(path.newSubPath("calculationSequence"), processor, CalculationSequence.class, getCalculationSequence());
		processRosetta(path.newSubPath("rateCalculation"), processor, Rate.class, getRateCalculation());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("discounting"), processor, Discounting.class, getDiscounting());
		processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationBuilder extends Calculation, RosettaModelObjectBuilder {
		Notional.NotionalBuilder getOrCreateNotionalSchedule();
		Notional.NotionalBuilder getNotionalSchedule();
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getOrCreateFxLinkedNotionalSchedule();
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getFxLinkedNotionalSchedule();
		CalculationSequence.CalculationSequenceBuilder getOrCreateCalculationSequence();
		CalculationSequence.CalculationSequenceBuilder getCalculationSequence();
		Rate.RateBuilder getOrCreateRateCalculation();
		Rate.RateBuilder getRateCalculation();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Discounting.DiscountingBuilder getOrCreateDiscounting();
		Discounting.DiscountingBuilder getDiscounting();
		Calculation.CalculationBuilder setNotionalSchedule(Notional notionalSchedule);
		Calculation.CalculationBuilder setFxLinkedNotionalSchedule(FxLinkedNotionalSchedule fxLinkedNotionalSchedule);
		Calculation.CalculationBuilder setCalculationSequence(CalculationSequence calculationSequence);
		Calculation.CalculationBuilder setRateCalculation(Rate rateCalculation);
		Calculation.CalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		Calculation.CalculationBuilder setDiscounting(Discounting discounting);
		Calculation.CalculationBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalSchedule"), processor, Notional.NotionalBuilder.class, getNotionalSchedule());
			processRosetta(path.newSubPath("fxLinkedNotionalSchedule"), processor, FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder.class, getFxLinkedNotionalSchedule());
			processRosetta(path.newSubPath("calculationSequence"), processor, CalculationSequence.CalculationSequenceBuilder.class, getCalculationSequence());
			processRosetta(path.newSubPath("rateCalculation"), processor, Rate.RateBuilder.class, getRateCalculation());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("discounting"), processor, Discounting.DiscountingBuilder.class, getDiscounting());
			processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
		}
		

		Calculation.CalculationBuilder prune();
	}

	/*********************** Immutable Implementation of Calculation  ***********************/
	class CalculationImpl implements Calculation {
		private final Notional notionalSchedule;
		private final FxLinkedNotionalSchedule fxLinkedNotionalSchedule;
		private final CalculationSequence calculationSequence;
		private final Rate rateCalculation;
		private final DayCountFraction dayCountFraction;
		private final Discounting discounting;
		private final CompoundingMethodEnum compoundingMethod;
		
		protected CalculationImpl(Calculation.CalculationBuilder builder) {
			this.notionalSchedule = ofNullable(builder.getNotionalSchedule()).map(f->f.build()).orElse(null);
			this.fxLinkedNotionalSchedule = ofNullable(builder.getFxLinkedNotionalSchedule()).map(f->f.build()).orElse(null);
			this.calculationSequence = ofNullable(builder.getCalculationSequence()).map(f->f.build()).orElse(null);
			this.rateCalculation = ofNullable(builder.getRateCalculation()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.discounting = ofNullable(builder.getDiscounting()).map(f->f.build()).orElse(null);
			this.compoundingMethod = builder.getCompoundingMethod();
		}
		
		@Override
		@RosettaAttribute("notionalSchedule")
		public Notional getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("fxLinkedNotionalSchedule")
		public FxLinkedNotionalSchedule getFxLinkedNotionalSchedule() {
			return fxLinkedNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("calculationSequence")
		public CalculationSequence getCalculationSequence() {
			return calculationSequence;
		}
		
		@Override
		@RosettaAttribute("rateCalculation")
		public Rate getRateCalculation() {
			return rateCalculation;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("discounting")
		public Discounting getDiscounting() {
			return discounting;
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		public Calculation build() {
			return this;
		}
		
		@Override
		public Calculation.CalculationBuilder toBuilder() {
			Calculation.CalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Calculation.CalculationBuilder builder) {
			ofNullable(getNotionalSchedule()).ifPresent(builder::setNotionalSchedule);
			ofNullable(getFxLinkedNotionalSchedule()).ifPresent(builder::setFxLinkedNotionalSchedule);
			ofNullable(getCalculationSequence()).ifPresent(builder::setCalculationSequence);
			ofNullable(getRateCalculation()).ifPresent(builder::setRateCalculation);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getDiscounting()).ifPresent(builder::setDiscounting);
			ofNullable(getCompoundingMethod()).ifPresent(builder::setCompoundingMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Calculation _that = getType().cast(o);
		
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(fxLinkedNotionalSchedule, _that.getFxLinkedNotionalSchedule())) return false;
			if (!Objects.equals(calculationSequence, _that.getCalculationSequence())) return false;
			if (!Objects.equals(rateCalculation, _that.getRateCalculation())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(discounting, _that.getDiscounting())) return false;
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.hashCode() : 0);
			_result = 31 * _result + (fxLinkedNotionalSchedule != null ? fxLinkedNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationSequence != null ? calculationSequence.hashCode() : 0);
			_result = 31 * _result + (rateCalculation != null ? rateCalculation.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (discounting != null ? discounting.hashCode() : 0);
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Calculation {" +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"fxLinkedNotionalSchedule=" + this.fxLinkedNotionalSchedule + ", " +
				"calculationSequence=" + this.calculationSequence + ", " +
				"rateCalculation=" + this.rateCalculation + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"discounting=" + this.discounting + ", " +
				"compoundingMethod=" + this.compoundingMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of Calculation  ***********************/
	class CalculationBuilderImpl implements Calculation.CalculationBuilder {
	
		protected Notional.NotionalBuilder notionalSchedule;
		protected FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder fxLinkedNotionalSchedule;
		protected CalculationSequence.CalculationSequenceBuilder calculationSequence;
		protected Rate.RateBuilder rateCalculation;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Discounting.DiscountingBuilder discounting;
		protected CompoundingMethodEnum compoundingMethod;
	
		public CalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalSchedule")
		public Notional.NotionalBuilder getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		public Notional.NotionalBuilder getOrCreateNotionalSchedule() {
			Notional.NotionalBuilder result;
			if (notionalSchedule!=null) {
				result = notionalSchedule;
			}
			else {
				result = notionalSchedule = Notional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxLinkedNotionalSchedule")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getFxLinkedNotionalSchedule() {
			return fxLinkedNotionalSchedule;
		}
		
		@Override
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getOrCreateFxLinkedNotionalSchedule() {
			FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder result;
			if (fxLinkedNotionalSchedule!=null) {
				result = fxLinkedNotionalSchedule;
			}
			else {
				result = fxLinkedNotionalSchedule = FxLinkedNotionalSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationSequence")
		public CalculationSequence.CalculationSequenceBuilder getCalculationSequence() {
			return calculationSequence;
		}
		
		@Override
		public CalculationSequence.CalculationSequenceBuilder getOrCreateCalculationSequence() {
			CalculationSequence.CalculationSequenceBuilder result;
			if (calculationSequence!=null) {
				result = calculationSequence;
			}
			else {
				result = calculationSequence = CalculationSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateCalculation")
		public Rate.RateBuilder getRateCalculation() {
			return rateCalculation;
		}
		
		@Override
		public Rate.RateBuilder getOrCreateRateCalculation() {
			Rate.RateBuilder result;
			if (rateCalculation!=null) {
				result = rateCalculation;
			}
			else {
				result = rateCalculation = Rate.builder();
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
		@RosettaAttribute("discounting")
		public Discounting.DiscountingBuilder getDiscounting() {
			return discounting;
		}
		
		@Override
		public Discounting.DiscountingBuilder getOrCreateDiscounting() {
			Discounting.DiscountingBuilder result;
			if (discounting!=null) {
				result = discounting;
			}
			else {
				result = discounting = Discounting.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		@RosettaAttribute("notionalSchedule")
		public Calculation.CalculationBuilder setNotionalSchedule(Notional notionalSchedule) {
			this.notionalSchedule = notionalSchedule==null?null:notionalSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxLinkedNotionalSchedule")
		public Calculation.CalculationBuilder setFxLinkedNotionalSchedule(FxLinkedNotionalSchedule fxLinkedNotionalSchedule) {
			this.fxLinkedNotionalSchedule = fxLinkedNotionalSchedule==null?null:fxLinkedNotionalSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationSequence")
		public Calculation.CalculationBuilder setCalculationSequence(CalculationSequence calculationSequence) {
			this.calculationSequence = calculationSequence==null?null:calculationSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateCalculation")
		public Calculation.CalculationBuilder setRateCalculation(Rate rateCalculation) {
			this.rateCalculation = rateCalculation==null?null:rateCalculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public Calculation.CalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("discounting")
		public Calculation.CalculationBuilder setDiscounting(Discounting discounting) {
			this.discounting = discounting==null?null:discounting.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compoundingMethod")
		public Calculation.CalculationBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod) {
			this.compoundingMethod = compoundingMethod==null?null:compoundingMethod;
			return this;
		}
		
		@Override
		public Calculation build() {
			return new Calculation.CalculationImpl(this);
		}
		
		@Override
		public Calculation.CalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Calculation.CalculationBuilder prune() {
			if (notionalSchedule!=null && !notionalSchedule.prune().hasData()) notionalSchedule = null;
			if (fxLinkedNotionalSchedule!=null && !fxLinkedNotionalSchedule.prune().hasData()) fxLinkedNotionalSchedule = null;
			if (calculationSequence!=null && !calculationSequence.prune().hasData()) calculationSequence = null;
			if (rateCalculation!=null && !rateCalculation.prune().hasData()) rateCalculation = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (discounting!=null && !discounting.prune().hasData()) discounting = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalSchedule()!=null && getNotionalSchedule().hasData()) return true;
			if (getFxLinkedNotionalSchedule()!=null && getFxLinkedNotionalSchedule().hasData()) return true;
			if (getCalculationSequence()!=null && getCalculationSequence().hasData()) return true;
			if (getRateCalculation()!=null && getRateCalculation().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getDiscounting()!=null && getDiscounting().hasData()) return true;
			if (getCompoundingMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Calculation.CalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Calculation.CalculationBuilder o = (Calculation.CalculationBuilder) other;
			
			merger.mergeRosetta(getNotionalSchedule(), o.getNotionalSchedule(), this::setNotionalSchedule);
			merger.mergeRosetta(getFxLinkedNotionalSchedule(), o.getFxLinkedNotionalSchedule(), this::setFxLinkedNotionalSchedule);
			merger.mergeRosetta(getCalculationSequence(), o.getCalculationSequence(), this::setCalculationSequence);
			merger.mergeRosetta(getRateCalculation(), o.getRateCalculation(), this::setRateCalculation);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getDiscounting(), o.getDiscounting(), this::setDiscounting);
			
			merger.mergeBasic(getCompoundingMethod(), o.getCompoundingMethod(), this::setCompoundingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Calculation _that = getType().cast(o);
		
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(fxLinkedNotionalSchedule, _that.getFxLinkedNotionalSchedule())) return false;
			if (!Objects.equals(calculationSequence, _that.getCalculationSequence())) return false;
			if (!Objects.equals(rateCalculation, _that.getRateCalculation())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(discounting, _that.getDiscounting())) return false;
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.hashCode() : 0);
			_result = 31 * _result + (fxLinkedNotionalSchedule != null ? fxLinkedNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationSequence != null ? calculationSequence.hashCode() : 0);
			_result = 31 * _result + (rateCalculation != null ? rateCalculation.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (discounting != null ? discounting.hashCode() : 0);
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationBuilder {" +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"fxLinkedNotionalSchedule=" + this.fxLinkedNotionalSchedule + ", " +
				"calculationSequence=" + this.calculationSequence + ", " +
				"rateCalculation=" + this.rateCalculation + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"discounting=" + this.discounting + ", " +
				"compoundingMethod=" + this.compoundingMethod +
			'}';
		}
	}
}
