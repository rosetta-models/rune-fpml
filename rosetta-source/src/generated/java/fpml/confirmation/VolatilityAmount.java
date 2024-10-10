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
import fpml.confirmation.Volatility;
import fpml.confirmation.VolatilityAmount;
import fpml.confirmation.VolatilityAmount.VolatilityAmountBuilder;
import fpml.confirmation.VolatilityAmount.VolatilityAmountBuilderImpl;
import fpml.confirmation.VolatilityAmount.VolatilityAmountImpl;
import fpml.confirmation.meta.VolatilityAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="VolatilityAmount", builder=VolatilityAmount.VolatilityAmountBuilderImpl.class, version="${project.version}")
public interface VolatilityAmount extends CalculatedAmount {

	VolatilityAmountMeta metaData = new VolatilityAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies Volatility.
	 */
	Volatility getVolatility();

	/*********************** Build Methods  ***********************/
	VolatilityAmount build();
	
	VolatilityAmount.VolatilityAmountBuilder toBuilder();
	
	static VolatilityAmount.VolatilityAmountBuilder builder() {
		return new VolatilityAmount.VolatilityAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilityAmount> getType() {
		return VolatilityAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.class, getDividendsModel());
		processRosetta(path.newSubPath("volatility"), processor, Volatility.class, getVolatility());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityAmountBuilder extends VolatilityAmount, CalculatedAmount.CalculatedAmountBuilder {
		Volatility.VolatilityBuilder getOrCreateVolatility();
		Volatility.VolatilityBuilder getVolatility();
		VolatilityAmount.VolatilityAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		VolatilityAmount.VolatilityAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		VolatilityAmount.VolatilityAmountBuilder setDividendsModel(DividendsModel dividendsModel);
		VolatilityAmount.VolatilityAmountBuilder setVolatility(Volatility volatility);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.DividendsModelBuilder.class, getDividendsModel());
			processRosetta(path.newSubPath("volatility"), processor, Volatility.VolatilityBuilder.class, getVolatility());
		}
		

		VolatilityAmount.VolatilityAmountBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityAmount  ***********************/
	class VolatilityAmountImpl extends CalculatedAmount.CalculatedAmountImpl implements VolatilityAmount {
		private final Volatility volatility;
		
		protected VolatilityAmountImpl(VolatilityAmount.VolatilityAmountBuilder builder) {
			super(builder);
			this.volatility = ofNullable(builder.getVolatility()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("volatility")
		public Volatility getVolatility() {
			return volatility;
		}
		
		@Override
		public VolatilityAmount build() {
			return this;
		}
		
		@Override
		public VolatilityAmount.VolatilityAmountBuilder toBuilder() {
			VolatilityAmount.VolatilityAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityAmount.VolatilityAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVolatility()).ifPresent(builder::setVolatility);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityAmount _that = getType().cast(o);
		
			if (!Objects.equals(volatility, _that.getVolatility())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatility != null ? volatility.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityAmount {" +
				"volatility=" + this.volatility +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityAmount  ***********************/
	class VolatilityAmountBuilderImpl extends CalculatedAmount.CalculatedAmountBuilderImpl  implements VolatilityAmount.VolatilityAmountBuilder {
	
		protected Volatility.VolatilityBuilder volatility;
	
		public VolatilityAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("volatility")
		public Volatility.VolatilityBuilder getVolatility() {
			return volatility;
		}
		
		@Override
		public Volatility.VolatilityBuilder getOrCreateVolatility() {
			Volatility.VolatilityBuilder result;
			if (volatility!=null) {
				result = volatility;
			}
			else {
				result = volatility = Volatility.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public VolatilityAmount.VolatilityAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates) {
			this.calculationDates = calculationDates==null?null:calculationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("observationStartDate")
		public VolatilityAmount.VolatilityAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendsModel")
		public VolatilityAmount.VolatilityAmountBuilder setDividendsModel(DividendsModel dividendsModel) {
			this.dividendsModel = dividendsModel==null?null:dividendsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("volatility")
		public VolatilityAmount.VolatilityAmountBuilder setVolatility(Volatility volatility) {
			this.volatility = volatility==null?null:volatility.toBuilder();
			return this;
		}
		
		@Override
		public VolatilityAmount build() {
			return new VolatilityAmount.VolatilityAmountImpl(this);
		}
		
		@Override
		public VolatilityAmount.VolatilityAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder prune() {
			super.prune();
			if (volatility!=null && !volatility.prune().hasData()) volatility = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVolatility()!=null && getVolatility().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VolatilityAmount.VolatilityAmountBuilder o = (VolatilityAmount.VolatilityAmountBuilder) other;
			
			merger.mergeRosetta(getVolatility(), o.getVolatility(), this::setVolatility);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityAmount _that = getType().cast(o);
		
			if (!Objects.equals(volatility, _that.getVolatility())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatility != null ? volatility.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityAmountBuilder {" +
				"volatility=" + this.volatility +
			'}' + " " + super.toString();
		}
	}
}
