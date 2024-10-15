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
import fpml.confirmation.Correlation;
import fpml.confirmation.CorrelationAmount;
import fpml.confirmation.CorrelationAmount.CorrelationAmountBuilder;
import fpml.confirmation.CorrelationAmount.CorrelationAmountBuilderImpl;
import fpml.confirmation.CorrelationAmount.CorrelationAmountImpl;
import fpml.confirmation.DividendsModel;
import fpml.confirmation.meta.CorrelationAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Correlation Amount.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationAmount", builder=CorrelationAmount.CorrelationAmountBuilderImpl.class, version="${project.version}")
public interface CorrelationAmount extends CalculatedAmount {

	CorrelationAmountMeta metaData = new CorrelationAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies Correlation.
	 */
	Correlation getCorrelation();

	/*********************** Build Methods  ***********************/
	CorrelationAmount build();
	
	CorrelationAmount.CorrelationAmountBuilder toBuilder();
	
	static CorrelationAmount.CorrelationAmountBuilder builder() {
		return new CorrelationAmount.CorrelationAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationAmount> getType() {
		return CorrelationAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.class, getDividendsModel());
		processRosetta(path.newSubPath("correlation"), processor, Correlation.class, getCorrelation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationAmountBuilder extends CorrelationAmount, CalculatedAmount.CalculatedAmountBuilder {
		Correlation.CorrelationBuilder getOrCreateCorrelation();
		Correlation.CorrelationBuilder getCorrelation();
		CorrelationAmount.CorrelationAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		CorrelationAmount.CorrelationAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		CorrelationAmount.CorrelationAmountBuilder setDividendsModel(DividendsModel dividendsModel);
		CorrelationAmount.CorrelationAmountBuilder setCorrelation(Correlation correlation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.DividendsModelBuilder.class, getDividendsModel());
			processRosetta(path.newSubPath("correlation"), processor, Correlation.CorrelationBuilder.class, getCorrelation());
		}
		

		CorrelationAmount.CorrelationAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationAmount  ***********************/
	class CorrelationAmountImpl extends CalculatedAmount.CalculatedAmountImpl implements CorrelationAmount {
		private final Correlation correlation;
		
		protected CorrelationAmountImpl(CorrelationAmount.CorrelationAmountBuilder builder) {
			super(builder);
			this.correlation = ofNullable(builder.getCorrelation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlation")
		public Correlation getCorrelation() {
			return correlation;
		}
		
		@Override
		public CorrelationAmount build() {
			return this;
		}
		
		@Override
		public CorrelationAmount.CorrelationAmountBuilder toBuilder() {
			CorrelationAmount.CorrelationAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationAmount.CorrelationAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCorrelation()).ifPresent(builder::setCorrelation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationAmount _that = getType().cast(o);
		
			if (!Objects.equals(correlation, _that.getCorrelation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlation != null ? correlation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationAmount {" +
				"correlation=" + this.correlation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrelationAmount  ***********************/
	class CorrelationAmountBuilderImpl extends CalculatedAmount.CalculatedAmountBuilderImpl  implements CorrelationAmount.CorrelationAmountBuilder {
	
		protected Correlation.CorrelationBuilder correlation;
	
		public CorrelationAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("correlation")
		public Correlation.CorrelationBuilder getCorrelation() {
			return correlation;
		}
		
		@Override
		public Correlation.CorrelationBuilder getOrCreateCorrelation() {
			Correlation.CorrelationBuilder result;
			if (correlation!=null) {
				result = correlation;
			}
			else {
				result = correlation = Correlation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public CorrelationAmount.CorrelationAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates) {
			this.calculationDates = calculationDates==null?null:calculationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("observationStartDate")
		public CorrelationAmount.CorrelationAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendsModel")
		public CorrelationAmount.CorrelationAmountBuilder setDividendsModel(DividendsModel dividendsModel) {
			this.dividendsModel = dividendsModel==null?null:dividendsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlation")
		public CorrelationAmount.CorrelationAmountBuilder setCorrelation(Correlation correlation) {
			this.correlation = correlation==null?null:correlation.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationAmount build() {
			return new CorrelationAmount.CorrelationAmountImpl(this);
		}
		
		@Override
		public CorrelationAmount.CorrelationAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder prune() {
			super.prune();
			if (correlation!=null && !correlation.prune().hasData()) correlation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCorrelation()!=null && getCorrelation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CorrelationAmount.CorrelationAmountBuilder o = (CorrelationAmount.CorrelationAmountBuilder) other;
			
			merger.mergeRosetta(getCorrelation(), o.getCorrelation(), this::setCorrelation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationAmount _that = getType().cast(o);
		
			if (!Objects.equals(correlation, _that.getCorrelation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlation != null ? correlation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationAmountBuilder {" +
				"correlation=" + this.correlation +
			'}' + " " + super.toString();
		}
	}
}
