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
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.CalculatedAmount;
import fpml.confirmation.CalculatedAmount.CalculatedAmountBuilder;
import fpml.confirmation.CalculatedAmount.CalculatedAmountBuilderImpl;
import fpml.confirmation.CalculatedAmount.CalculatedAmountImpl;
import fpml.confirmation.DividendsModel;
import fpml.confirmation.meta.CalculatedAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract base class for all calculated money amounts, which are in the currency of the cash multiplier of the calculation.
 * @version ${project.version}
 */
@RosettaDataType(value="CalculatedAmount", builder=CalculatedAmount.CalculatedAmountBuilderImpl.class, version="${project.version}")
public interface CalculatedAmount extends RosettaModelObject {

	CalculatedAmountMeta metaData = new CalculatedAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the date on which a calculation or an observation will be performed for the purpose of calculating the amount.
	 */
	AdjustableRelativeOrPeriodicDates getCalculationDates();
	/**
	 * The start of the period over which observations are made which are used in the calculation Used when the observation start date differs from the trade date such as for forward starting swaps. Observation Start Date in accordance with the ISDA 2002 Equity Derivatives Definitions. Observation Period Start Date in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 */
	AdjustableOrRelativeDate getObservationStartDate();
	DividendsModel getDividendsModel();

	/*********************** Build Methods  ***********************/
	CalculatedAmount build();
	
	CalculatedAmount.CalculatedAmountBuilder toBuilder();
	
	static CalculatedAmount.CalculatedAmountBuilder builder() {
		return new CalculatedAmount.CalculatedAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculatedAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculatedAmount> getType() {
		return CalculatedAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.class, getDividendsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculatedAmountBuilder extends CalculatedAmount, RosettaModelObjectBuilder {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateObservationStartDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getObservationStartDate();
		DividendsModel.DividendsModelBuilder getOrCreateDividendsModel();
		DividendsModel.DividendsModelBuilder getDividendsModel();
		CalculatedAmount.CalculatedAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		CalculatedAmount.CalculatedAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		CalculatedAmount.CalculatedAmountBuilder setDividendsModel(DividendsModel dividendsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.DividendsModelBuilder.class, getDividendsModel());
		}
		

		CalculatedAmount.CalculatedAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CalculatedAmount  ***********************/
	class CalculatedAmountImpl implements CalculatedAmount {
		private final AdjustableRelativeOrPeriodicDates calculationDates;
		private final AdjustableOrRelativeDate observationStartDate;
		private final DividendsModel dividendsModel;
		
		protected CalculatedAmountImpl(CalculatedAmount.CalculatedAmountBuilder builder) {
			this.calculationDates = ofNullable(builder.getCalculationDates()).map(f->f.build()).orElse(null);
			this.observationStartDate = ofNullable(builder.getObservationStartDate()).map(f->f.build()).orElse(null);
			this.dividendsModel = ofNullable(builder.getDividendsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		public AdjustableOrRelativeDate getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("dividendsModel")
		public DividendsModel getDividendsModel() {
			return dividendsModel;
		}
		
		@Override
		public CalculatedAmount build() {
			return this;
		}
		
		@Override
		public CalculatedAmount.CalculatedAmountBuilder toBuilder() {
			CalculatedAmount.CalculatedAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculatedAmount.CalculatedAmountBuilder builder) {
			ofNullable(getCalculationDates()).ifPresent(builder::setCalculationDates);
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getDividendsModel()).ifPresent(builder::setDividendsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(dividendsModel, _that.getDividendsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (dividendsModel != null ? dividendsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedAmount {" +
				"calculationDates=" + this.calculationDates + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"dividendsModel=" + this.dividendsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculatedAmount  ***********************/
	class CalculatedAmountBuilderImpl implements CalculatedAmount.CalculatedAmountBuilder {
	
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder calculationDates;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder observationStartDate;
		protected DividendsModel.DividendsModelBuilder dividendsModel;
	
		public CalculatedAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (calculationDates!=null) {
				result = calculationDates;
			}
			else {
				result = calculationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateObservationStartDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (observationStartDate!=null) {
				result = observationStartDate;
			}
			else {
				result = observationStartDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendsModel")
		public DividendsModel.DividendsModelBuilder getDividendsModel() {
			return dividendsModel;
		}
		
		@Override
		public DividendsModel.DividendsModelBuilder getOrCreateDividendsModel() {
			DividendsModel.DividendsModelBuilder result;
			if (dividendsModel!=null) {
				result = dividendsModel;
			}
			else {
				result = dividendsModel = DividendsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public CalculatedAmount.CalculatedAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates) {
			this.calculationDates = calculationDates==null?null:calculationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("observationStartDate")
		public CalculatedAmount.CalculatedAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendsModel")
		public CalculatedAmount.CalculatedAmountBuilder setDividendsModel(DividendsModel dividendsModel) {
			this.dividendsModel = dividendsModel==null?null:dividendsModel.toBuilder();
			return this;
		}
		
		@Override
		public CalculatedAmount build() {
			return new CalculatedAmount.CalculatedAmountImpl(this);
		}
		
		@Override
		public CalculatedAmount.CalculatedAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder prune() {
			if (calculationDates!=null && !calculationDates.prune().hasData()) calculationDates = null;
			if (observationStartDate!=null && !observationStartDate.prune().hasData()) observationStartDate = null;
			if (dividendsModel!=null && !dividendsModel.prune().hasData()) dividendsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationDates()!=null && getCalculationDates().hasData()) return true;
			if (getObservationStartDate()!=null && getObservationStartDate().hasData()) return true;
			if (getDividendsModel()!=null && getDividendsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculatedAmount.CalculatedAmountBuilder o = (CalculatedAmount.CalculatedAmountBuilder) other;
			
			merger.mergeRosetta(getCalculationDates(), o.getCalculationDates(), this::setCalculationDates);
			merger.mergeRosetta(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			merger.mergeRosetta(getDividendsModel(), o.getDividendsModel(), this::setDividendsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(dividendsModel, _that.getDividendsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (dividendsModel != null ? dividendsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedAmountBuilder {" +
				"calculationDates=" + this.calculationDates + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"dividendsModel=" + this.dividendsModel +
			'}';
		}
	}
}
