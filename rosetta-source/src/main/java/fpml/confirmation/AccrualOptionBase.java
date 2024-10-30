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
import fpml.confirmation.AccrualOptionBase;
import fpml.confirmation.AccrualOptionBase.AccrualOptionBaseBuilder;
import fpml.confirmation.AccrualOptionBase.AccrualOptionBaseBuilderImpl;
import fpml.confirmation.AccrualOptionBase.AccrualOptionBaseImpl;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.Period;
import fpml.confirmation.meta.AccrualOptionBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract type used for defining accrual structures within loan instruments.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccrualOptionBase", builder=AccrualOptionBase.AccrualOptionBaseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccrualOptionBase extends RosettaModelObject {

	AccrualOptionBaseMeta metaData = new AccrualOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique id associated with the loan accrual type.
	 */
	AccrualTypeId getAccrualOptionId();
	/**
	 * The day count basis for the accrual.
	 */
	DayCountFraction getDayCountFraction();
	Period getPaymentFrequency();

	/*********************** Build Methods  ***********************/
	AccrualOptionBase build();
	
	AccrualOptionBase.AccrualOptionBaseBuilder toBuilder();
	
	static AccrualOptionBase.AccrualOptionBaseBuilder builder() {
		return new AccrualOptionBase.AccrualOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccrualOptionBase> getType() {
		return AccrualOptionBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualOptionBaseBuilder extends AccrualOptionBase, RosettaModelObjectBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccrualOptionId();
		AccrualTypeId.AccrualTypeIdBuilder getAccrualOptionId();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		Period.PeriodBuilder getPaymentFrequency();
		AccrualOptionBase.AccrualOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		AccrualOptionBase.AccrualOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		AccrualOptionBase.AccrualOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
		}
		

		AccrualOptionBase.AccrualOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of AccrualOptionBase  ***********************/
	class AccrualOptionBaseImpl implements AccrualOptionBase {
		private final AccrualTypeId accrualOptionId;
		private final DayCountFraction dayCountFraction;
		private final Period paymentFrequency;
		
		protected AccrualOptionBaseImpl(AccrualOptionBase.AccrualOptionBaseBuilder builder) {
			this.accrualOptionId = ofNullable(builder.getAccrualOptionId()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public AccrualTypeId getAccrualOptionId() {
			return accrualOptionId;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public AccrualOptionBase build() {
			return this;
		}
		
		@Override
		public AccrualOptionBase.AccrualOptionBaseBuilder toBuilder() {
			AccrualOptionBase.AccrualOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualOptionBase.AccrualOptionBaseBuilder builder) {
			ofNullable(getAccrualOptionId()).ifPresent(builder::setAccrualOptionId);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(accrualOptionId, _that.getAccrualOptionId())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualOptionId != null ? accrualOptionId.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionBase {" +
				"accrualOptionId=" + this.accrualOptionId + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of AccrualOptionBase  ***********************/
	class AccrualOptionBaseBuilderImpl implements AccrualOptionBase.AccrualOptionBaseBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder accrualOptionId;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Period.PeriodBuilder paymentFrequency;
	
		public AccrualOptionBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accrualOptionId")
		public AccrualTypeId.AccrualTypeIdBuilder getAccrualOptionId() {
			return accrualOptionId;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccrualOptionId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (accrualOptionId!=null) {
				result = accrualOptionId;
			}
			else {
				result = accrualOptionId = AccrualTypeId.builder();
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
		@RosettaAttribute("accrualOptionId")
		public AccrualOptionBase.AccrualOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public AccrualOptionBase.AccrualOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public AccrualOptionBase.AccrualOptionBaseBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		
		@Override
		public AccrualOptionBase build() {
			return new AccrualOptionBase.AccrualOptionBaseImpl(this);
		}
		
		@Override
		public AccrualOptionBase.AccrualOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionBase.AccrualOptionBaseBuilder prune() {
			if (accrualOptionId!=null && !accrualOptionId.prune().hasData()) accrualOptionId = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccrualOptionId()!=null && getAccrualOptionId().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionBase.AccrualOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccrualOptionBase.AccrualOptionBaseBuilder o = (AccrualOptionBase.AccrualOptionBaseBuilder) other;
			
			merger.mergeRosetta(getAccrualOptionId(), o.getAccrualOptionId(), this::setAccrualOptionId);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(accrualOptionId, _that.getAccrualOptionId())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualOptionId != null ? accrualOptionId.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionBaseBuilder {" +
				"accrualOptionId=" + this.accrualOptionId + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}';
		}
	}
}
