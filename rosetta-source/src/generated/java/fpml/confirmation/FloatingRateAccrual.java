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
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateAccrual;
import fpml.confirmation.FloatingRateAccrual.FloatingRateAccrualBuilder;
import fpml.confirmation.FloatingRateAccrual.FloatingRateAccrualBuilderImpl;
import fpml.confirmation.FloatingRateAccrual.FloatingRateAccrualImpl;
import fpml.confirmation.FloatingRateAccrualSequence;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.FloatingRateOptionBase;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseBuilder;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseBuilderImpl;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseImpl;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodWithDaysModel;
import fpml.confirmation.meta.FloatingRateAccrualMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A full definition of the accrual characteristics of a loan contract. This structure defines both the underlying base rate as well as any additional margins and costs associated with the loan contract.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateAccrual", builder=FloatingRateAccrual.FloatingRateAccrualBuilderImpl.class, version="${project.version}")
public interface FloatingRateAccrual extends FloatingRateOptionBase {

	FloatingRateAccrualMeta metaData = new FloatingRateAccrualMeta();

	/*********************** Getter Methods  ***********************/
	PeriodWithDaysModel getPeriodWithDaysModel();
	FloatingRateAccrualSequence getFloatingRateAccrualSequence();
	/**
	 * Projected interest payment details.
	 */
	PaymentProjection getPaymentProjection();

	/*********************** Build Methods  ***********************/
	FloatingRateAccrual build();
	
	FloatingRateAccrual.FloatingRateAccrualBuilder toBuilder();
	
	static FloatingRateAccrual.FloatingRateAccrualBuilder builder() {
		return new FloatingRateAccrual.FloatingRateAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateAccrual> getType() {
		return FloatingRateAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("floatingRateIndexLoanModel"), processor, FloatingRateIndexLoanModel.class, getFloatingRateIndexLoanModel());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.class, getPeriodWithDaysModel());
		processRosetta(path.newSubPath("floatingRateAccrualSequence"), processor, FloatingRateAccrualSequence.class, getFloatingRateAccrualSequence());
		processRosetta(path.newSubPath("paymentProjection"), processor, PaymentProjection.class, getPaymentProjection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateAccrualBuilder extends FloatingRateAccrual, FloatingRateOptionBase.FloatingRateOptionBaseBuilder {
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getOrCreatePeriodWithDaysModel();
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getPeriodWithDaysModel();
		FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder getOrCreateFloatingRateAccrualSequence();
		FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder getFloatingRateAccrualSequence();
		PaymentProjection.PaymentProjectionBuilder getOrCreatePaymentProjection();
		PaymentProjection.PaymentProjectionBuilder getPaymentProjection();
		FloatingRateAccrual.FloatingRateAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		FloatingRateAccrual.FloatingRateAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FloatingRateAccrual.FloatingRateAccrualBuilder setPaymentFrequency(Period paymentFrequency);
		FloatingRateAccrual.FloatingRateAccrualBuilder setFloatingRateIndexLoanModel(FloatingRateIndexLoanModel floatingRateIndexLoanModel);
		FloatingRateAccrual.FloatingRateAccrualBuilder setSpread(BigDecimal spread);
		FloatingRateAccrual.FloatingRateAccrualBuilder setPikSpread(BigDecimal pikSpread);
		FloatingRateAccrual.FloatingRateAccrualBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel);
		FloatingRateAccrual.FloatingRateAccrualBuilder setFloatingRateAccrualSequence(FloatingRateAccrualSequence floatingRateAccrualSequence);
		FloatingRateAccrual.FloatingRateAccrualBuilder setPaymentProjection(PaymentProjection paymentProjection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("floatingRateIndexLoanModel"), processor, FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder.class, getFloatingRateIndexLoanModel());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
			processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.PeriodWithDaysModelBuilder.class, getPeriodWithDaysModel());
			processRosetta(path.newSubPath("floatingRateAccrualSequence"), processor, FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder.class, getFloatingRateAccrualSequence());
			processRosetta(path.newSubPath("paymentProjection"), processor, PaymentProjection.PaymentProjectionBuilder.class, getPaymentProjection());
		}
		

		FloatingRateAccrual.FloatingRateAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateAccrual  ***********************/
	class FloatingRateAccrualImpl extends FloatingRateOptionBase.FloatingRateOptionBaseImpl implements FloatingRateAccrual {
		private final PeriodWithDaysModel periodWithDaysModel;
		private final FloatingRateAccrualSequence floatingRateAccrualSequence;
		private final PaymentProjection paymentProjection;
		
		protected FloatingRateAccrualImpl(FloatingRateAccrual.FloatingRateAccrualBuilder builder) {
			super(builder);
			this.periodWithDaysModel = ofNullable(builder.getPeriodWithDaysModel()).map(f->f.build()).orElse(null);
			this.floatingRateAccrualSequence = ofNullable(builder.getFloatingRateAccrualSequence()).map(f->f.build()).orElse(null);
			this.paymentProjection = ofNullable(builder.getPaymentProjection()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public PeriodWithDaysModel getPeriodWithDaysModel() {
			return periodWithDaysModel;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrualSequence")
		public FloatingRateAccrualSequence getFloatingRateAccrualSequence() {
			return floatingRateAccrualSequence;
		}
		
		@Override
		@RosettaAttribute("paymentProjection")
		public PaymentProjection getPaymentProjection() {
			return paymentProjection;
		}
		
		@Override
		public FloatingRateAccrual build() {
			return this;
		}
		
		@Override
		public FloatingRateAccrual.FloatingRateAccrualBuilder toBuilder() {
			FloatingRateAccrual.FloatingRateAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateAccrual.FloatingRateAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodWithDaysModel()).ifPresent(builder::setPeriodWithDaysModel);
			ofNullable(getFloatingRateAccrualSequence()).ifPresent(builder::setFloatingRateAccrualSequence);
			ofNullable(getPaymentProjection()).ifPresent(builder::setPaymentProjection);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(floatingRateAccrualSequence, _that.getFloatingRateAccrualSequence())) return false;
			if (!Objects.equals(paymentProjection, _that.getPaymentProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrualSequence != null ? floatingRateAccrualSequence.hashCode() : 0);
			_result = 31 * _result + (paymentProjection != null ? paymentProjection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateAccrual {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"floatingRateAccrualSequence=" + this.floatingRateAccrualSequence + ", " +
				"paymentProjection=" + this.paymentProjection +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateAccrual  ***********************/
	class FloatingRateAccrualBuilderImpl extends FloatingRateOptionBase.FloatingRateOptionBaseBuilderImpl  implements FloatingRateAccrual.FloatingRateAccrualBuilder {
	
		protected PeriodWithDaysModel.PeriodWithDaysModelBuilder periodWithDaysModel;
		protected FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder floatingRateAccrualSequence;
		protected PaymentProjection.PaymentProjectionBuilder paymentProjection;
	
		public FloatingRateAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder getPeriodWithDaysModel() {
			return periodWithDaysModel;
		}
		
		@Override
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder getOrCreatePeriodWithDaysModel() {
			PeriodWithDaysModel.PeriodWithDaysModelBuilder result;
			if (periodWithDaysModel!=null) {
				result = periodWithDaysModel;
			}
			else {
				result = periodWithDaysModel = PeriodWithDaysModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrualSequence")
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder getFloatingRateAccrualSequence() {
			return floatingRateAccrualSequence;
		}
		
		@Override
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder getOrCreateFloatingRateAccrualSequence() {
			FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder result;
			if (floatingRateAccrualSequence!=null) {
				result = floatingRateAccrualSequence;
			}
			else {
				result = floatingRateAccrualSequence = FloatingRateAccrualSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentProjection")
		public PaymentProjection.PaymentProjectionBuilder getPaymentProjection() {
			return paymentProjection;
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder getOrCreatePaymentProjection() {
			PaymentProjection.PaymentProjectionBuilder result;
			if (paymentProjection!=null) {
				result = paymentProjection;
			}
			else {
				result = paymentProjection = PaymentProjection.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexLoanModel")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setFloatingRateIndexLoanModel(FloatingRateIndexLoanModel floatingRateIndexLoanModel) {
			this.floatingRateIndexLoanModel = floatingRateIndexLoanModel==null?null:floatingRateIndexLoanModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spread")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		@Override
		@RosettaAttribute("pikSpread")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setPikSpread(BigDecimal pikSpread) {
			this.pikSpread = pikSpread==null?null:pikSpread;
			return this;
		}
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel) {
			this.periodWithDaysModel = periodWithDaysModel==null?null:periodWithDaysModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateAccrualSequence")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setFloatingRateAccrualSequence(FloatingRateAccrualSequence floatingRateAccrualSequence) {
			this.floatingRateAccrualSequence = floatingRateAccrualSequence==null?null:floatingRateAccrualSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentProjection")
		public FloatingRateAccrual.FloatingRateAccrualBuilder setPaymentProjection(PaymentProjection paymentProjection) {
			this.paymentProjection = paymentProjection==null?null:paymentProjection.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateAccrual build() {
			return new FloatingRateAccrual.FloatingRateAccrualImpl(this);
		}
		
		@Override
		public FloatingRateAccrual.FloatingRateAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateAccrual.FloatingRateAccrualBuilder prune() {
			super.prune();
			if (periodWithDaysModel!=null && !periodWithDaysModel.prune().hasData()) periodWithDaysModel = null;
			if (floatingRateAccrualSequence!=null && !floatingRateAccrualSequence.prune().hasData()) floatingRateAccrualSequence = null;
			if (paymentProjection!=null && !paymentProjection.prune().hasData()) paymentProjection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodWithDaysModel()!=null && getPeriodWithDaysModel().hasData()) return true;
			if (getFloatingRateAccrualSequence()!=null && getFloatingRateAccrualSequence().hasData()) return true;
			if (getPaymentProjection()!=null && getPaymentProjection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateAccrual.FloatingRateAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateAccrual.FloatingRateAccrualBuilder o = (FloatingRateAccrual.FloatingRateAccrualBuilder) other;
			
			merger.mergeRosetta(getPeriodWithDaysModel(), o.getPeriodWithDaysModel(), this::setPeriodWithDaysModel);
			merger.mergeRosetta(getFloatingRateAccrualSequence(), o.getFloatingRateAccrualSequence(), this::setFloatingRateAccrualSequence);
			merger.mergeRosetta(getPaymentProjection(), o.getPaymentProjection(), this::setPaymentProjection);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(floatingRateAccrualSequence, _that.getFloatingRateAccrualSequence())) return false;
			if (!Objects.equals(paymentProjection, _that.getPaymentProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrualSequence != null ? floatingRateAccrualSequence.hashCode() : 0);
			_result = 31 * _result + (paymentProjection != null ? paymentProjection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateAccrualBuilder {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"floatingRateAccrualSequence=" + this.floatingRateAccrualSequence + ", " +
				"paymentProjection=" + this.paymentProjection +
			'}' + " " + super.toString();
		}
	}
}
