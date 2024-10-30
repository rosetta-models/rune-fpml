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
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.BondCalculationModel.BondCalculationModelBuilder;
import fpml.confirmation.BondCalculationModel.BondCalculationModelBuilderImpl;
import fpml.confirmation.BondCalculationModel.BondCalculationModelImpl;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.Period;
import fpml.confirmation.meta.BondCalculationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group that specifies Bond Calculation elements.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BondCalculationModel", builder=BondCalculationModel.BondCalculationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BondCalculationModel extends RosettaModelObject {

	BondCalculationModelMeta metaData = new BondCalculationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the frequency at which the bond pays, e.g. 6M.
	 */
	Period getPaymentFrequency();
	/**
	 * The day count basis for the bond.
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	BondCalculationModel build();
	
	BondCalculationModel.BondCalculationModelBuilder toBuilder();
	
	static BondCalculationModel.BondCalculationModelBuilder builder() {
		return new BondCalculationModel.BondCalculationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondCalculationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BondCalculationModel> getType() {
		return BondCalculationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondCalculationModelBuilder extends BondCalculationModel, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		Period.PeriodBuilder getPaymentFrequency();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		BondCalculationModel.BondCalculationModelBuilder setPaymentFrequency(Period paymentFrequency);
		BondCalculationModel.BondCalculationModelBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		BondCalculationModel.BondCalculationModelBuilder prune();
	}

	/*********************** Immutable Implementation of BondCalculationModel  ***********************/
	class BondCalculationModelImpl implements BondCalculationModel {
		private final Period paymentFrequency;
		private final DayCountFraction dayCountFraction;
		
		protected BondCalculationModelImpl(BondCalculationModel.BondCalculationModelBuilder builder) {
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public BondCalculationModel build() {
			return this;
		}
		
		@Override
		public BondCalculationModel.BondCalculationModelBuilder toBuilder() {
			BondCalculationModel.BondCalculationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondCalculationModel.BondCalculationModelBuilder builder) {
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondCalculationModel _that = getType().cast(o);
		
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondCalculationModel {" +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of BondCalculationModel  ***********************/
	class BondCalculationModelBuilderImpl implements BondCalculationModel.BondCalculationModelBuilder {
	
		protected Period.PeriodBuilder paymentFrequency;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
	
		public BondCalculationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentFrequency")
		public Period.PeriodBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePaymentFrequency() {
			Period.PeriodBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Period.builder();
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
		@RosettaAttribute("paymentFrequency")
		public BondCalculationModel.BondCalculationModelBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public BondCalculationModel.BondCalculationModelBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public BondCalculationModel build() {
			return new BondCalculationModel.BondCalculationModelImpl(this);
		}
		
		@Override
		public BondCalculationModel.BondCalculationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondCalculationModel.BondCalculationModelBuilder prune() {
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondCalculationModel.BondCalculationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondCalculationModel.BondCalculationModelBuilder o = (BondCalculationModel.BondCalculationModelBuilder) other;
			
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondCalculationModel _that = getType().cast(o);
		
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondCalculationModelBuilder {" +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}
}
