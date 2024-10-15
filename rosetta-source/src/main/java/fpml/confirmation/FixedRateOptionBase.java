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
import fpml.confirmation.FixedRateOptionBase;
import fpml.confirmation.FixedRateOptionBase.FixedRateOptionBaseBuilder;
import fpml.confirmation.FixedRateOptionBase.FixedRateOptionBaseBuilderImpl;
import fpml.confirmation.FixedRateOptionBase.FixedRateOptionBaseImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FixedRateOptionBaseMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract type that specifies an underlying fixed rate cash accrual option.
 * @version ${project.version}
 */
@RosettaDataType(value="FixedRateOptionBase", builder=FixedRateOptionBase.FixedRateOptionBaseBuilderImpl.class, version="${project.version}")
public interface FixedRateOptionBase extends AccrualOptionBase {

	FixedRateOptionBaseMeta metaData = new FixedRateOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getRate();
	BigDecimal getPikSpread();

	/*********************** Build Methods  ***********************/
	FixedRateOptionBase build();
	
	FixedRateOptionBase.FixedRateOptionBaseBuilder toBuilder();
	
	static FixedRateOptionBase.FixedRateOptionBaseBuilder builder() {
		return new FixedRateOptionBase.FixedRateOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRateOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedRateOptionBase> getType() {
		return FixedRateOptionBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRateOptionBaseBuilder extends FixedRateOptionBase, AccrualOptionBase.AccrualOptionBaseBuilder {
		FixedRateOptionBase.FixedRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		FixedRateOptionBase.FixedRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FixedRateOptionBase.FixedRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);
		FixedRateOptionBase.FixedRateOptionBaseBuilder setRate(BigDecimal rate);
		FixedRateOptionBase.FixedRateOptionBaseBuilder setPikSpread(BigDecimal pikSpread);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		}
		

		FixedRateOptionBase.FixedRateOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FixedRateOptionBase  ***********************/
	class FixedRateOptionBaseImpl extends AccrualOptionBase.AccrualOptionBaseImpl implements FixedRateOptionBase {
		private final BigDecimal rate;
		private final BigDecimal pikSpread;
		
		protected FixedRateOptionBaseImpl(FixedRateOptionBase.FixedRateOptionBaseBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
			this.pikSpread = builder.getPikSpread();
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		public FixedRateOptionBase build() {
			return this;
		}
		
		@Override
		public FixedRateOptionBase.FixedRateOptionBaseBuilder toBuilder() {
			FixedRateOptionBase.FixedRateOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRateOptionBase.FixedRateOptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getPikSpread()).ifPresent(builder::setPikSpread);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateOptionBase {" +
				"rate=" + this.rate + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedRateOptionBase  ***********************/
	class FixedRateOptionBaseBuilderImpl extends AccrualOptionBase.AccrualOptionBaseBuilderImpl  implements FixedRateOptionBase.FixedRateOptionBaseBuilder {
	
		protected BigDecimal rate;
		protected BigDecimal pikSpread;
	
		public FixedRateOptionBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public FixedRateOptionBase.FixedRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FixedRateOptionBase.FixedRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public FixedRateOptionBase.FixedRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public FixedRateOptionBase.FixedRateOptionBaseBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("pikSpread")
		public FixedRateOptionBase.FixedRateOptionBaseBuilder setPikSpread(BigDecimal pikSpread) {
			this.pikSpread = pikSpread==null?null:pikSpread;
			return this;
		}
		
		@Override
		public FixedRateOptionBase build() {
			return new FixedRateOptionBase.FixedRateOptionBaseImpl(this);
		}
		
		@Override
		public FixedRateOptionBase.FixedRateOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateOptionBase.FixedRateOptionBaseBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			if (getPikSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateOptionBase.FixedRateOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FixedRateOptionBase.FixedRateOptionBaseBuilder o = (FixedRateOptionBase.FixedRateOptionBaseBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getPikSpread(), o.getPikSpread(), this::setPikSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateOptionBaseBuilder {" +
				"rate=" + this.rate + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}
}
