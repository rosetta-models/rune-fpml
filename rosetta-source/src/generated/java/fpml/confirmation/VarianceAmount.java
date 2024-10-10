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
import fpml.confirmation.Variance;
import fpml.confirmation.VarianceAmount;
import fpml.confirmation.VarianceAmount.VarianceAmountBuilder;
import fpml.confirmation.VarianceAmount.VarianceAmountBuilderImpl;
import fpml.confirmation.VarianceAmount.VarianceAmountImpl;
import fpml.confirmation.meta.VarianceAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Calculation of a Variance Amount.
 * @version ${project.version}
 */
@RosettaDataType(value="VarianceAmount", builder=VarianceAmount.VarianceAmountBuilderImpl.class, version="${project.version}")
public interface VarianceAmount extends CalculatedAmount {

	VarianceAmountMeta metaData = new VarianceAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies Variance.
	 */
	Variance getVariance();

	/*********************** Build Methods  ***********************/
	VarianceAmount build();
	
	VarianceAmount.VarianceAmountBuilder toBuilder();
	
	static VarianceAmount.VarianceAmountBuilder builder() {
		return new VarianceAmount.VarianceAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VarianceAmount> getType() {
		return VarianceAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.class, getDividendsModel());
		processRosetta(path.newSubPath("variance"), processor, Variance.class, getVariance());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceAmountBuilder extends VarianceAmount, CalculatedAmount.CalculatedAmountBuilder {
		Variance.VarianceBuilder getOrCreateVariance();
		Variance.VarianceBuilder getVariance();
		VarianceAmount.VarianceAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		VarianceAmount.VarianceAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		VarianceAmount.VarianceAmountBuilder setDividendsModel(DividendsModel dividendsModel);
		VarianceAmount.VarianceAmountBuilder setVariance(Variance variance);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.DividendsModelBuilder.class, getDividendsModel());
			processRosetta(path.newSubPath("variance"), processor, Variance.VarianceBuilder.class, getVariance());
		}
		

		VarianceAmount.VarianceAmountBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceAmount  ***********************/
	class VarianceAmountImpl extends CalculatedAmount.CalculatedAmountImpl implements VarianceAmount {
		private final Variance variance;
		
		protected VarianceAmountImpl(VarianceAmount.VarianceAmountBuilder builder) {
			super(builder);
			this.variance = ofNullable(builder.getVariance()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("variance")
		public Variance getVariance() {
			return variance;
		}
		
		@Override
		public VarianceAmount build() {
			return this;
		}
		
		@Override
		public VarianceAmount.VarianceAmountBuilder toBuilder() {
			VarianceAmount.VarianceAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceAmount.VarianceAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVariance()).ifPresent(builder::setVariance);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceAmount _that = getType().cast(o);
		
			if (!Objects.equals(variance, _that.getVariance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (variance != null ? variance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceAmount {" +
				"variance=" + this.variance +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceAmount  ***********************/
	class VarianceAmountBuilderImpl extends CalculatedAmount.CalculatedAmountBuilderImpl  implements VarianceAmount.VarianceAmountBuilder {
	
		protected Variance.VarianceBuilder variance;
	
		public VarianceAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("variance")
		public Variance.VarianceBuilder getVariance() {
			return variance;
		}
		
		@Override
		public Variance.VarianceBuilder getOrCreateVariance() {
			Variance.VarianceBuilder result;
			if (variance!=null) {
				result = variance;
			}
			else {
				result = variance = Variance.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public VarianceAmount.VarianceAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates) {
			this.calculationDates = calculationDates==null?null:calculationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("observationStartDate")
		public VarianceAmount.VarianceAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendsModel")
		public VarianceAmount.VarianceAmountBuilder setDividendsModel(DividendsModel dividendsModel) {
			this.dividendsModel = dividendsModel==null?null:dividendsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("variance")
		public VarianceAmount.VarianceAmountBuilder setVariance(Variance variance) {
			this.variance = variance==null?null:variance.toBuilder();
			return this;
		}
		
		@Override
		public VarianceAmount build() {
			return new VarianceAmount.VarianceAmountImpl(this);
		}
		
		@Override
		public VarianceAmount.VarianceAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceAmount.VarianceAmountBuilder prune() {
			super.prune();
			if (variance!=null && !variance.prune().hasData()) variance = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVariance()!=null && getVariance().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceAmount.VarianceAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VarianceAmount.VarianceAmountBuilder o = (VarianceAmount.VarianceAmountBuilder) other;
			
			merger.mergeRosetta(getVariance(), o.getVariance(), this::setVariance);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceAmount _that = getType().cast(o);
		
			if (!Objects.equals(variance, _that.getVariance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (variance != null ? variance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceAmountBuilder {" +
				"variance=" + this.variance +
			'}' + " " + super.toString();
		}
	}
}
