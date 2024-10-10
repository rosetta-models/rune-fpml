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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.CommodityAsianModel;
import fpml.confirmation.CommodityAsianModel.CommodityAsianModelBuilder;
import fpml.confirmation.CommodityAsianModel.CommodityAsianModelBuilderImpl;
import fpml.confirmation.CommodityAsianModel.CommodityAsianModelImpl;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.meta.CommodityAsianModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Model group containing features specific to Asian/averaging commodity options.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityAsianModel", builder=CommodityAsianModel.CommodityAsianModelBuilderImpl.class, version="${project.version}")
public interface CommodityAsianModel extends RosettaModelObject {

	CommodityAsianModelMeta metaData = new CommodityAsianModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A parametric representation of the Calculation Periods of the Commodity Option Transaction.
	 */
	CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule();
	/**
	 * An absolute representation of the Calculation Period start dates of the Commodity Option Transaction.
	 */
	AdjustableDates getCalculationPeriods();
	/**
	 * The dates on which the option will price.
	 */
	CommodityPricingDates getPricingDates();
	/**
	 * The Method of Averaging if there is more than one Pricing Date.
	 */
	AveragingMethodEnum getAveragingMethod();

	/*********************** Build Methods  ***********************/
	CommodityAsianModel build();
	
	CommodityAsianModel.CommodityAsianModelBuilder toBuilder();
	
	static CommodityAsianModel.CommodityAsianModelBuilder builder() {
		return new CommodityAsianModel.CommodityAsianModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityAsianModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityAsianModel> getType() {
		return CommodityAsianModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getCalculationPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.class, getCalculationPeriods());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityAsianModelBuilder extends CommodityAsianModel, RosettaModelObjectBuilder {
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule();
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods();
		AdjustableDates.AdjustableDatesBuilder getCalculationPeriods();
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityAsianModel.CommodityAsianModelBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		CommodityAsianModel.CommodityAsianModelBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		CommodityAsianModel.CommodityAsianModelBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityAsianModel.CommodityAsianModelBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getCalculationPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationPeriods());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		}
		

		CommodityAsianModel.CommodityAsianModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityAsianModel  ***********************/
	class CommodityAsianModelImpl implements CommodityAsianModel {
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final AdjustableDates calculationPeriods;
		private final CommodityPricingDates pricingDates;
		private final AveragingMethodEnum averagingMethod;
		
		protected CommodityAsianModelImpl(CommodityAsianModel.CommodityAsianModelBuilder builder) {
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		public AdjustableDates getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public CommodityAsianModel build() {
			return this;
		}
		
		@Override
		public CommodityAsianModel.CommodityAsianModelBuilder toBuilder() {
			CommodityAsianModel.CommodityAsianModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityAsianModel.CommodityAsianModelBuilder builder) {
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityAsianModel _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAsianModel {" +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityAsianModel  ***********************/
	class CommodityAsianModelBuilderImpl implements CommodityAsianModel.CommodityAsianModelBuilder {
	
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected AveragingMethodEnum averagingMethod;
	
		public CommodityAsianModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (calculationPeriodsSchedule!=null) {
				result = calculationPeriodsSchedule;
			}
			else {
				result = calculationPeriodsSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		public AdjustableDates.AdjustableDatesBuilder getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationPeriods!=null) {
				result = calculationPeriods;
			}
			else {
				result = calculationPeriods = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates() {
			CommodityPricingDates.CommodityPricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = CommodityPricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityAsianModel.CommodityAsianModelBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = calculationPeriodsSchedule==null?null:calculationPeriodsSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriods")
		public CommodityAsianModel.CommodityAsianModelBuilder setCalculationPeriods(AdjustableDates calculationPeriods) {
			this.calculationPeriods = calculationPeriods==null?null:calculationPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityAsianModel.CommodityAsianModelBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public CommodityAsianModel.CommodityAsianModelBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		
		@Override
		public CommodityAsianModel build() {
			return new CommodityAsianModel.CommodityAsianModelImpl(this);
		}
		
		@Override
		public CommodityAsianModel.CommodityAsianModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAsianModel.CommodityAsianModelBuilder prune() {
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAsianModel.CommodityAsianModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityAsianModel.CommodityAsianModelBuilder o = (CommodityAsianModel.CommodityAsianModelBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityAsianModel _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAsianModelBuilder {" +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod +
			'}';
		}
	}
}
