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
import fpml.confirmation.AccruingFeeOption;
import fpml.confirmation.AccruingFeeOption.AccruingFeeOptionBuilder;
import fpml.confirmation.AccruingFeeOption.AccruingFeeOptionBuilderImpl;
import fpml.confirmation.AccruingFeeOption.AccruingFeeOptionImpl;
import fpml.confirmation.AccruingFeeType;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FeeRateOptionBase;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilder;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseBuilderImpl;
import fpml.confirmation.FeeRateOptionBase.FeeRateOptionBaseImpl;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodOptionalEndModel;
import fpml.confirmation.meta.AccruingFeeOptionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the accruing fee option associated within a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingFeeOption", builder=AccruingFeeOption.AccruingFeeOptionBuilderImpl.class, version="${project.version}")
public interface AccruingFeeOption extends FeeRateOptionBase {

	AccruingFeeOptionMeta metaData = new AccruingFeeOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The accruing fee type for which a rate is being provided.
	 */
	AccruingFeeType get_type();
	PeriodOptionalEndModel getPeriodOptionalEndModel();
	/**
	 * A freetext field which allows the sender to add further details around the business event.
	 */
	String getCalculationDefinition();

	/*********************** Build Methods  ***********************/
	AccruingFeeOption build();
	
	AccruingFeeOption.AccruingFeeOptionBuilder toBuilder();
	
	static AccruingFeeOption.AccruingFeeOptionBuilder builder() {
		return new AccruingFeeOption.AccruingFeeOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeeOption> getType() {
		return AccruingFeeOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("_type"), processor, AccruingFeeType.class, get_type());
		processRosetta(path.newSubPath("periodOptionalEndModel"), processor, PeriodOptionalEndModel.class, getPeriodOptionalEndModel());
		processor.processBasic(path.newSubPath("calculationDefinition"), String.class, getCalculationDefinition(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeOptionBuilder extends AccruingFeeOption, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		AccruingFeeType.AccruingFeeTypeBuilder getOrCreate_type();
		AccruingFeeType.AccruingFeeTypeBuilder get_type();
		PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getOrCreatePeriodOptionalEndModel();
		PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getPeriodOptionalEndModel();
		AccruingFeeOption.AccruingFeeOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		AccruingFeeOption.AccruingFeeOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		AccruingFeeOption.AccruingFeeOptionBuilder setPaymentFrequency(Period paymentFrequency);
		AccruingFeeOption.AccruingFeeOptionBuilder setRate(BigDecimal rate);
		AccruingFeeOption.AccruingFeeOptionBuilder set_type(AccruingFeeType _type);
		AccruingFeeOption.AccruingFeeOptionBuilder setPeriodOptionalEndModel(PeriodOptionalEndModel periodOptionalEndModel);
		AccruingFeeOption.AccruingFeeOptionBuilder setCalculationDefinition(String calculationDefinition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("_type"), processor, AccruingFeeType.AccruingFeeTypeBuilder.class, get_type());
			processRosetta(path.newSubPath("periodOptionalEndModel"), processor, PeriodOptionalEndModel.PeriodOptionalEndModelBuilder.class, getPeriodOptionalEndModel());
			processor.processBasic(path.newSubPath("calculationDefinition"), String.class, getCalculationDefinition(), this);
		}
		

		AccruingFeeOption.AccruingFeeOptionBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeOption  ***********************/
	class AccruingFeeOptionImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements AccruingFeeOption {
		private final AccruingFeeType _type;
		private final PeriodOptionalEndModel periodOptionalEndModel;
		private final String calculationDefinition;
		
		protected AccruingFeeOptionImpl(AccruingFeeOption.AccruingFeeOptionBuilder builder) {
			super(builder);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.periodOptionalEndModel = ofNullable(builder.getPeriodOptionalEndModel()).map(f->f.build()).orElse(null);
			this.calculationDefinition = builder.getCalculationDefinition();
		}
		
		@Override
		@RosettaAttribute("_type")
		public AccruingFeeType get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("periodOptionalEndModel")
		public PeriodOptionalEndModel getPeriodOptionalEndModel() {
			return periodOptionalEndModel;
		}
		
		@Override
		@RosettaAttribute("calculationDefinition")
		public String getCalculationDefinition() {
			return calculationDefinition;
		}
		
		@Override
		public AccruingFeeOption build() {
			return this;
		}
		
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder toBuilder() {
			AccruingFeeOption.AccruingFeeOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeOption.AccruingFeeOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getPeriodOptionalEndModel()).ifPresent(builder::setPeriodOptionalEndModel);
			ofNullable(getCalculationDefinition()).ifPresent(builder::setCalculationDefinition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeOption _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(periodOptionalEndModel, _that.getPeriodOptionalEndModel())) return false;
			if (!Objects.equals(calculationDefinition, _that.getCalculationDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (periodOptionalEndModel != null ? periodOptionalEndModel.hashCode() : 0);
			_result = 31 * _result + (calculationDefinition != null ? calculationDefinition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeOption {" +
				"_type=" + this._type + ", " +
				"periodOptionalEndModel=" + this.periodOptionalEndModel + ", " +
				"calculationDefinition=" + this.calculationDefinition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeOption  ***********************/
	class AccruingFeeOptionBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl  implements AccruingFeeOption.AccruingFeeOptionBuilder {
	
		protected AccruingFeeType.AccruingFeeTypeBuilder _type;
		protected PeriodOptionalEndModel.PeriodOptionalEndModelBuilder periodOptionalEndModel;
		protected String calculationDefinition;
	
		public AccruingFeeOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("_type")
		public AccruingFeeType.AccruingFeeTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder getOrCreate_type() {
			AccruingFeeType.AccruingFeeTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = AccruingFeeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodOptionalEndModel")
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getPeriodOptionalEndModel() {
			return periodOptionalEndModel;
		}
		
		@Override
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getOrCreatePeriodOptionalEndModel() {
			PeriodOptionalEndModel.PeriodOptionalEndModelBuilder result;
			if (periodOptionalEndModel!=null) {
				result = periodOptionalEndModel;
			}
			else {
				result = periodOptionalEndModel = PeriodOptionalEndModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDefinition")
		public String getCalculationDefinition() {
			return calculationDefinition;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public AccruingFeeOption.AccruingFeeOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public AccruingFeeOption.AccruingFeeOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public AccruingFeeOption.AccruingFeeOptionBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public AccruingFeeOption.AccruingFeeOptionBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public AccruingFeeOption.AccruingFeeOptionBuilder set_type(AccruingFeeType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodOptionalEndModel")
		public AccruingFeeOption.AccruingFeeOptionBuilder setPeriodOptionalEndModel(PeriodOptionalEndModel periodOptionalEndModel) {
			this.periodOptionalEndModel = periodOptionalEndModel==null?null:periodOptionalEndModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationDefinition")
		public AccruingFeeOption.AccruingFeeOptionBuilder setCalculationDefinition(String calculationDefinition) {
			this.calculationDefinition = calculationDefinition==null?null:calculationDefinition;
			return this;
		}
		
		@Override
		public AccruingFeeOption build() {
			return new AccruingFeeOption.AccruingFeeOptionImpl(this);
		}
		
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder prune() {
			super.prune();
			if (_type!=null && !_type.prune().hasData()) _type = null;
			if (periodOptionalEndModel!=null && !periodOptionalEndModel.prune().hasData()) periodOptionalEndModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			if (getPeriodOptionalEndModel()!=null && getPeriodOptionalEndModel().hasData()) return true;
			if (getCalculationDefinition()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingFeeOption.AccruingFeeOptionBuilder o = (AccruingFeeOption.AccruingFeeOptionBuilder) other;
			
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			merger.mergeRosetta(getPeriodOptionalEndModel(), o.getPeriodOptionalEndModel(), this::setPeriodOptionalEndModel);
			
			merger.mergeBasic(getCalculationDefinition(), o.getCalculationDefinition(), this::setCalculationDefinition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeOption _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(periodOptionalEndModel, _that.getPeriodOptionalEndModel())) return false;
			if (!Objects.equals(calculationDefinition, _that.getCalculationDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (periodOptionalEndModel != null ? periodOptionalEndModel.hashCode() : 0);
			_result = 31 * _result + (calculationDefinition != null ? calculationDefinition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeOptionBuilder {" +
				"_type=" + this._type + ", " +
				"periodOptionalEndModel=" + this.periodOptionalEndModel + ", " +
				"calculationDefinition=" + this.calculationDefinition +
			'}' + " " + super.toString();
		}
	}
}
