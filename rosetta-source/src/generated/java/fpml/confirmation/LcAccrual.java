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
import fpml.confirmation.FeeRateOptionBase;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilder;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilderImpl;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseImpl;
import fpml.confirmation.LcAccrual;
import fpml.confirmation.LcAccrual.LcAccrualBuilder;
import fpml.confirmation.LcAccrual.LcAccrualBuilderImpl;
import fpml.confirmation.LcAccrual.LcAccrualImpl;
import fpml.confirmation.LcAccrualSequence;
import fpml.confirmation.Period;
import fpml.confirmation.meta.LcAccrualMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A full definition of the accrual characteristics of a letter of credit. This structure defines both the underlying letter of credit issuance fee rate as well as any FX rates applied.
 * @version ${project.version}
 */
@RosettaDataType(value="LcAccrual", builder=LcAccrual.LcAccrualBuilderImpl.class, version="${project.version}")
public interface LcAccrual extends FeeRateOptionBase {

	LcAccrualMeta metaData = new LcAccrualMeta();

	/*********************** Getter Methods  ***********************/
	LcAccrualSequence getLcAccrualSequence();

	/*********************** Build Methods  ***********************/
	LcAccrual build();
	
	LcAccrual.LcAccrualBuilder toBuilder();
	
	static LcAccrual.LcAccrualBuilder builder() {
		return new LcAccrual.LcAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcAccrual> getType() {
		return LcAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("lcAccrualSequence"), processor, LcAccrualSequence.class, getLcAccrualSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcAccrualBuilder extends LcAccrual, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		LcAccrualSequence.LcAccrualSequenceBuilder getOrCreateLcAccrualSequence();
		LcAccrualSequence.LcAccrualSequenceBuilder getLcAccrualSequence();
		LcAccrual.LcAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		LcAccrual.LcAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		LcAccrual.LcAccrualBuilder setPaymentFrequency(Period paymentFrequency);
		LcAccrual.LcAccrualBuilder setRate(BigDecimal rate);
		LcAccrual.LcAccrualBuilder setLcAccrualSequence(LcAccrualSequence lcAccrualSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("lcAccrualSequence"), processor, LcAccrualSequence.LcAccrualSequenceBuilder.class, getLcAccrualSequence());
		}
		

		LcAccrual.LcAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LcAccrual  ***********************/
	class LcAccrualImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements LcAccrual {
		private final LcAccrualSequence lcAccrualSequence;
		
		protected LcAccrualImpl(LcAccrual.LcAccrualBuilder builder) {
			super(builder);
			this.lcAccrualSequence = ofNullable(builder.getLcAccrualSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcAccrualSequence")
		public LcAccrualSequence getLcAccrualSequence() {
			return lcAccrualSequence;
		}
		
		@Override
		public LcAccrual build() {
			return this;
		}
		
		@Override
		public LcAccrual.LcAccrualBuilder toBuilder() {
			LcAccrual.LcAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcAccrual.LcAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLcAccrualSequence()).ifPresent(builder::setLcAccrualSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAccrual _that = getType().cast(o);
		
			if (!Objects.equals(lcAccrualSequence, _that.getLcAccrualSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcAccrualSequence != null ? lcAccrualSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAccrual {" +
				"lcAccrualSequence=" + this.lcAccrualSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcAccrual  ***********************/
	class LcAccrualBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl  implements LcAccrual.LcAccrualBuilder {
	
		protected LcAccrualSequence.LcAccrualSequenceBuilder lcAccrualSequence;
	
		public LcAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lcAccrualSequence")
		public LcAccrualSequence.LcAccrualSequenceBuilder getLcAccrualSequence() {
			return lcAccrualSequence;
		}
		
		@Override
		public LcAccrualSequence.LcAccrualSequenceBuilder getOrCreateLcAccrualSequence() {
			LcAccrualSequence.LcAccrualSequenceBuilder result;
			if (lcAccrualSequence!=null) {
				result = lcAccrualSequence;
			}
			else {
				result = lcAccrualSequence = LcAccrualSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public LcAccrual.LcAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public LcAccrual.LcAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public LcAccrual.LcAccrualBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public LcAccrual.LcAccrualBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("lcAccrualSequence")
		public LcAccrual.LcAccrualBuilder setLcAccrualSequence(LcAccrualSequence lcAccrualSequence) {
			this.lcAccrualSequence = lcAccrualSequence==null?null:lcAccrualSequence.toBuilder();
			return this;
		}
		
		@Override
		public LcAccrual build() {
			return new LcAccrual.LcAccrualImpl(this);
		}
		
		@Override
		public LcAccrual.LcAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAccrual.LcAccrualBuilder prune() {
			super.prune();
			if (lcAccrualSequence!=null && !lcAccrualSequence.prune().hasData()) lcAccrualSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLcAccrualSequence()!=null && getLcAccrualSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAccrual.LcAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcAccrual.LcAccrualBuilder o = (LcAccrual.LcAccrualBuilder) other;
			
			merger.mergeRosetta(getLcAccrualSequence(), o.getLcAccrualSequence(), this::setLcAccrualSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAccrual _that = getType().cast(o);
		
			if (!Objects.equals(lcAccrualSequence, _that.getLcAccrualSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcAccrualSequence != null ? lcAccrualSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAccrualBuilder {" +
				"lcAccrualSequence=" + this.lcAccrualSequence +
			'}' + " " + super.toString();
		}
	}
}
