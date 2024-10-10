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
import fpml.confirmation.FeeRateOptionBase;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilder;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilderImpl;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FeeRateOptionBaseMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract type that specifies an underlying fixed rate cash accrual option.
 * @version ${project.version}
 */
@RosettaDataType(value="FeeRateOptionBase", builder=FeeRateOptionBase.FeeRateOptionBaseBuilderImpl.class, version="${project.version}")
public interface FeeRateOptionBase extends AccrualOptionBase {

	FeeRateOptionBaseMeta metaData = new FeeRateOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getRate();

	/*********************** Build Methods  ***********************/
	FeeRateOptionBase build();
	
	FeeRateOptionBase.FeeRateOptionBaseBuilder toBuilder();
	
	static FeeRateOptionBase.FeeRateOptionBaseBuilder builder() {
		return new FeeRateOptionBase.FeeRateOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeRateOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeeRateOptionBase> getType() {
		return FeeRateOptionBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeRateOptionBaseBuilder extends FeeRateOptionBase, AccrualOptionBase.AccrualOptionBaseBuilder {
		FeeRateOptionBase.FeeRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		FeeRateOptionBase.FeeRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FeeRateOptionBase.FeeRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);
		FeeRateOptionBase.FeeRateOptionBaseBuilder setRate(BigDecimal rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		FeeRateOptionBase.FeeRateOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FeeRateOptionBase  ***********************/
	class FeeRateOptionBaseImpl extends AccrualOptionBase.AccrualOptionBaseImpl implements FeeRateOptionBase {
		private final BigDecimal rate;
		
		protected FeeRateOptionBaseImpl(FeeRateOptionBase.FeeRateOptionBaseBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public FeeRateOptionBase build() {
			return this;
		}
		
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder toBuilder() {
			FeeRateOptionBase.FeeRateOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeRateOptionBase.FeeRateOptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeRateOptionBase {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FeeRateOptionBase  ***********************/
	class FeeRateOptionBaseBuilderImpl extends AccrualOptionBase.AccrualOptionBaseBuilderImpl  implements FeeRateOptionBase.FeeRateOptionBaseBuilder {
	
		protected BigDecimal rate;
	
		public FeeRateOptionBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		
		@Override
		public FeeRateOptionBase build() {
			return new FeeRateOptionBase.FeeRateOptionBaseImpl(this);
		}
		
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FeeRateOptionBase.FeeRateOptionBaseBuilder o = (FeeRateOptionBase.FeeRateOptionBaseBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeRateOptionBaseBuilder {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}
