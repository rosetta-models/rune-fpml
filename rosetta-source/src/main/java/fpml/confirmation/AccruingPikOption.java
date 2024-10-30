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
import fpml.confirmation.AccruingPikOption;
import fpml.confirmation.AccruingPikOption.AccruingPikOptionBuilder;
import fpml.confirmation.AccruingPikOption.AccruingPikOptionBuilderImpl;
import fpml.confirmation.AccruingPikOption.AccruingPikOptionImpl;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FeeRateOptionBase;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilder;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilderImpl;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseImpl;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.AccruingPikOptionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the accruing PIK option associated within a facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccruingPikOption", builder=AccruingPikOption.AccruingPikOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccruingPikOption extends FeeRateOptionBase {

	AccruingPikOptionMeta metaData = new AccruingPikOptionMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();

	/*********************** Build Methods  ***********************/
	AccruingPikOption build();
	
	AccruingPikOption.AccruingPikOptionBuilder toBuilder();
	
	static AccruingPikOption.AccruingPikOptionBuilder builder() {
		return new AccruingPikOption.AccruingPikOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingPikOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingPikOption> getType() {
		return AccruingPikOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingPikOptionBuilder extends AccruingPikOption, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		AccruingPikOption.AccruingPikOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		AccruingPikOption.AccruingPikOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		AccruingPikOption.AccruingPikOptionBuilder setPaymentFrequency(Period paymentFrequency);
		AccruingPikOption.AccruingPikOptionBuilder setRate(BigDecimal rate);
		AccruingPikOption.AccruingPikOptionBuilder setPeriodModel(PeriodModel periodModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
		}
		

		AccruingPikOption.AccruingPikOptionBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingPikOption  ***********************/
	class AccruingPikOptionImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements AccruingPikOption {
		private final PeriodModel periodModel;
		
		protected AccruingPikOptionImpl(AccruingPikOption.AccruingPikOptionBuilder builder) {
			super(builder);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		public AccruingPikOption build() {
			return this;
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder toBuilder() {
			AccruingPikOption.AccruingPikOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingPikOption.AccruingPikOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikOption _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikOption {" +
				"periodModel=" + this.periodModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingPikOption  ***********************/
	class AccruingPikOptionBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl  implements AccruingPikOption.AccruingPikOptionBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
	
		public AccruingPikOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel.PeriodModelBuilder getPeriodModel() {
			return periodModel;
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder getOrCreatePeriodModel() {
			PeriodModel.PeriodModelBuilder result;
			if (periodModel!=null) {
				result = periodModel;
			}
			else {
				result = periodModel = PeriodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public AccruingPikOption.AccruingPikOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public AccruingPikOption.AccruingPikOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public AccruingPikOption.AccruingPikOptionBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public AccruingPikOption.AccruingPikOptionBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public AccruingPikOption.AccruingPikOptionBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		
		@Override
		public AccruingPikOption build() {
			return new AccruingPikOption.AccruingPikOptionImpl(this);
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder prune() {
			super.prune();
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingPikOption.AccruingPikOptionBuilder o = (AccruingPikOption.AccruingPikOptionBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikOption _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikOptionBuilder {" +
				"periodModel=" + this.periodModel +
			'}' + " " + super.toString();
		}
	}
}
