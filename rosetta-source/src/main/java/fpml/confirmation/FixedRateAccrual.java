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
import fpml.confirmation.FixedRateAccrual;
import fpml.confirmation.FixedRateAccrual.FixedRateAccrualBuilder;
import fpml.confirmation.FixedRateAccrual.FixedRateAccrualBuilderImpl;
import fpml.confirmation.FixedRateAccrual.FixedRateAccrualImpl;
import fpml.confirmation.FixedRateAccrualSequence;
import fpml.confirmation.FixedRateOptionBase;
import fpml.confirmation.FixedRateOptionBase.FixedRateOptionBaseBuilder;
import fpml.confirmation.FixedRateOptionBase.FixedRateOptionBaseBuilderImpl;
import fpml.confirmation.FixedRateOptionBase.FixedRateOptionBaseImpl;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodWithDaysModel;
import fpml.confirmation.meta.FixedRateAccrualMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A full definition of the fixed rate accrual characteristics of a loan contract. This structure defines both the underlying base rate as well as any additional margins and costs associated with the loan contract.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FixedRateAccrual", builder=FixedRateAccrual.FixedRateAccrualBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FixedRateAccrual extends FixedRateOptionBase {

	FixedRateAccrualMeta metaData = new FixedRateAccrualMeta();

	/*********************** Getter Methods  ***********************/
	PeriodWithDaysModel getPeriodWithDaysModel();
	FixedRateAccrualSequence getFixedRateAccrualSequence();
	/**
	 * Projected interest payment details.
	 */
	PaymentProjection getPaymentProjection();

	/*********************** Build Methods  ***********************/
	FixedRateAccrual build();
	
	FixedRateAccrual.FixedRateAccrualBuilder toBuilder();
	
	static FixedRateAccrual.FixedRateAccrualBuilder builder() {
		return new FixedRateAccrual.FixedRateAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRateAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedRateAccrual> getType() {
		return FixedRateAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.class, getPeriodWithDaysModel());
		processRosetta(path.newSubPath("fixedRateAccrualSequence"), processor, FixedRateAccrualSequence.class, getFixedRateAccrualSequence());
		processRosetta(path.newSubPath("paymentProjection"), processor, PaymentProjection.class, getPaymentProjection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRateAccrualBuilder extends FixedRateAccrual, FixedRateOptionBase.FixedRateOptionBaseBuilder {
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getOrCreatePeriodWithDaysModel();
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getPeriodWithDaysModel();
		FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder getOrCreateFixedRateAccrualSequence();
		FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder getFixedRateAccrualSequence();
		PaymentProjection.PaymentProjectionBuilder getOrCreatePaymentProjection();
		PaymentProjection.PaymentProjectionBuilder getPaymentProjection();
		FixedRateAccrual.FixedRateAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		FixedRateAccrual.FixedRateAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FixedRateAccrual.FixedRateAccrualBuilder setPaymentFrequency(Period paymentFrequency);
		FixedRateAccrual.FixedRateAccrualBuilder setRate(BigDecimal rate);
		FixedRateAccrual.FixedRateAccrualBuilder setPikSpread(BigDecimal pikSpread);
		FixedRateAccrual.FixedRateAccrualBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel);
		FixedRateAccrual.FixedRateAccrualBuilder setFixedRateAccrualSequence(FixedRateAccrualSequence fixedRateAccrualSequence);
		FixedRateAccrual.FixedRateAccrualBuilder setPaymentProjection(PaymentProjection paymentProjection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
			processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.PeriodWithDaysModelBuilder.class, getPeriodWithDaysModel());
			processRosetta(path.newSubPath("fixedRateAccrualSequence"), processor, FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder.class, getFixedRateAccrualSequence());
			processRosetta(path.newSubPath("paymentProjection"), processor, PaymentProjection.PaymentProjectionBuilder.class, getPaymentProjection());
		}
		

		FixedRateAccrual.FixedRateAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of FixedRateAccrual  ***********************/
	class FixedRateAccrualImpl extends FixedRateOptionBase.FixedRateOptionBaseImpl implements FixedRateAccrual {
		private final PeriodWithDaysModel periodWithDaysModel;
		private final FixedRateAccrualSequence fixedRateAccrualSequence;
		private final PaymentProjection paymentProjection;
		
		protected FixedRateAccrualImpl(FixedRateAccrual.FixedRateAccrualBuilder builder) {
			super(builder);
			this.periodWithDaysModel = ofNullable(builder.getPeriodWithDaysModel()).map(f->f.build()).orElse(null);
			this.fixedRateAccrualSequence = ofNullable(builder.getFixedRateAccrualSequence()).map(f->f.build()).orElse(null);
			this.paymentProjection = ofNullable(builder.getPaymentProjection()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public PeriodWithDaysModel getPeriodWithDaysModel() {
			return periodWithDaysModel;
		}
		
		@Override
		@RosettaAttribute("fixedRateAccrualSequence")
		public FixedRateAccrualSequence getFixedRateAccrualSequence() {
			return fixedRateAccrualSequence;
		}
		
		@Override
		@RosettaAttribute("paymentProjection")
		public PaymentProjection getPaymentProjection() {
			return paymentProjection;
		}
		
		@Override
		public FixedRateAccrual build() {
			return this;
		}
		
		@Override
		public FixedRateAccrual.FixedRateAccrualBuilder toBuilder() {
			FixedRateAccrual.FixedRateAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRateAccrual.FixedRateAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodWithDaysModel()).ifPresent(builder::setPeriodWithDaysModel);
			ofNullable(getFixedRateAccrualSequence()).ifPresent(builder::setFixedRateAccrualSequence);
			ofNullable(getPaymentProjection()).ifPresent(builder::setPaymentProjection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(fixedRateAccrualSequence, _that.getFixedRateAccrualSequence())) return false;
			if (!Objects.equals(paymentProjection, _that.getPaymentProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (fixedRateAccrualSequence != null ? fixedRateAccrualSequence.hashCode() : 0);
			_result = 31 * _result + (paymentProjection != null ? paymentProjection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateAccrual {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"fixedRateAccrualSequence=" + this.fixedRateAccrualSequence + ", " +
				"paymentProjection=" + this.paymentProjection +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedRateAccrual  ***********************/
	class FixedRateAccrualBuilderImpl extends FixedRateOptionBase.FixedRateOptionBaseBuilderImpl  implements FixedRateAccrual.FixedRateAccrualBuilder {
	
		protected PeriodWithDaysModel.PeriodWithDaysModelBuilder periodWithDaysModel;
		protected FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder fixedRateAccrualSequence;
		protected PaymentProjection.PaymentProjectionBuilder paymentProjection;
	
		public FixedRateAccrualBuilderImpl() {
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
		@RosettaAttribute("fixedRateAccrualSequence")
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder getFixedRateAccrualSequence() {
			return fixedRateAccrualSequence;
		}
		
		@Override
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder getOrCreateFixedRateAccrualSequence() {
			FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder result;
			if (fixedRateAccrualSequence!=null) {
				result = fixedRateAccrualSequence;
			}
			else {
				result = fixedRateAccrualSequence = FixedRateAccrualSequence.builder();
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
		public FixedRateAccrual.FixedRateAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FixedRateAccrual.FixedRateAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public FixedRateAccrual.FixedRateAccrualBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public FixedRateAccrual.FixedRateAccrualBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("pikSpread")
		public FixedRateAccrual.FixedRateAccrualBuilder setPikSpread(BigDecimal pikSpread) {
			this.pikSpread = pikSpread==null?null:pikSpread;
			return this;
		}
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public FixedRateAccrual.FixedRateAccrualBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel) {
			this.periodWithDaysModel = periodWithDaysModel==null?null:periodWithDaysModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRateAccrualSequence")
		public FixedRateAccrual.FixedRateAccrualBuilder setFixedRateAccrualSequence(FixedRateAccrualSequence fixedRateAccrualSequence) {
			this.fixedRateAccrualSequence = fixedRateAccrualSequence==null?null:fixedRateAccrualSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentProjection")
		public FixedRateAccrual.FixedRateAccrualBuilder setPaymentProjection(PaymentProjection paymentProjection) {
			this.paymentProjection = paymentProjection==null?null:paymentProjection.toBuilder();
			return this;
		}
		
		@Override
		public FixedRateAccrual build() {
			return new FixedRateAccrual.FixedRateAccrualImpl(this);
		}
		
		@Override
		public FixedRateAccrual.FixedRateAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateAccrual.FixedRateAccrualBuilder prune() {
			super.prune();
			if (periodWithDaysModel!=null && !periodWithDaysModel.prune().hasData()) periodWithDaysModel = null;
			if (fixedRateAccrualSequence!=null && !fixedRateAccrualSequence.prune().hasData()) fixedRateAccrualSequence = null;
			if (paymentProjection!=null && !paymentProjection.prune().hasData()) paymentProjection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodWithDaysModel()!=null && getPeriodWithDaysModel().hasData()) return true;
			if (getFixedRateAccrualSequence()!=null && getFixedRateAccrualSequence().hasData()) return true;
			if (getPaymentProjection()!=null && getPaymentProjection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateAccrual.FixedRateAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FixedRateAccrual.FixedRateAccrualBuilder o = (FixedRateAccrual.FixedRateAccrualBuilder) other;
			
			merger.mergeRosetta(getPeriodWithDaysModel(), o.getPeriodWithDaysModel(), this::setPeriodWithDaysModel);
			merger.mergeRosetta(getFixedRateAccrualSequence(), o.getFixedRateAccrualSequence(), this::setFixedRateAccrualSequence);
			merger.mergeRosetta(getPaymentProjection(), o.getPaymentProjection(), this::setPaymentProjection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(fixedRateAccrualSequence, _that.getFixedRateAccrualSequence())) return false;
			if (!Objects.equals(paymentProjection, _that.getPaymentProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (fixedRateAccrualSequence != null ? fixedRateAccrualSequence.hashCode() : 0);
			_result = 31 * _result + (paymentProjection != null ? paymentProjection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateAccrualBuilder {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"fixedRateAccrualSequence=" + this.fixedRateAccrualSequence + ", " +
				"paymentProjection=" + this.paymentProjection +
			'}' + " " + super.toString();
		}
	}
}
