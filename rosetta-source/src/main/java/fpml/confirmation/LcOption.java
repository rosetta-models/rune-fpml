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
import fpml.confirmation.LcOption;
import fpml.confirmation.LcOption.LcOptionBuilder;
import fpml.confirmation.LcOption.LcOptionBuilderImpl;
import fpml.confirmation.LcOption.LcOptionImpl;
import fpml.confirmation.LcType;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.LcOptionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the accruing L/C rate option associated within a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="LcOption", builder=LcOption.LcOptionBuilderImpl.class, version="${project.version}")
public interface LcOption extends FeeRateOptionBase {

	LcOptionMeta metaData = new LcOptionMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();
	/**
	 * The letter of credit type for which a fee rate is being provided.
	 */
	LcType get_type();
	/**
	 * The letter of credit notional amount. The amount is represented at the global and (optionally) atthe lender-specific level.
	 */
	MoneyWithParticipantShare getMinLcIssuanceFeeAmount();

	/*********************** Build Methods  ***********************/
	LcOption build();
	
	LcOption.LcOptionBuilder toBuilder();
	
	static LcOption.LcOptionBuilder builder() {
		return new LcOption.LcOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcOption> getType() {
		return LcOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processRosetta(path.newSubPath("_type"), processor, LcType.class, get_type());
		processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.class, getMinLcIssuanceFeeAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcOptionBuilder extends LcOption, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		LcType.LcTypeBuilder getOrCreate_type();
		LcType.LcTypeBuilder get_type();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount();
		LcOption.LcOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		LcOption.LcOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		LcOption.LcOptionBuilder setPaymentFrequency(Period paymentFrequency);
		LcOption.LcOptionBuilder setRate(BigDecimal rate);
		LcOption.LcOptionBuilder setPeriodModel(PeriodModel periodModel);
		LcOption.LcOptionBuilder set_type(LcType _type);
		LcOption.LcOptionBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare minLcIssuanceFeeAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processRosetta(path.newSubPath("_type"), processor, LcType.LcTypeBuilder.class, get_type());
			processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getMinLcIssuanceFeeAmount());
		}
		

		LcOption.LcOptionBuilder prune();
	}

	/*********************** Immutable Implementation of LcOption  ***********************/
	class LcOptionImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements LcOption {
		private final PeriodModel periodModel;
		private final LcType _type;
		private final MoneyWithParticipantShare minLcIssuanceFeeAmount;
		
		protected LcOptionImpl(LcOption.LcOptionBuilder builder) {
			super(builder);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.minLcIssuanceFeeAmount = ofNullable(builder.getMinLcIssuanceFeeAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LcType get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		public LcOption build() {
			return this;
		}
		
		@Override
		public LcOption.LcOptionBuilder toBuilder() {
			LcOption.LcOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcOption.LcOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getMinLcIssuanceFeeAmount()).ifPresent(builder::setMinLcIssuanceFeeAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcOption _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcOption {" +
				"periodModel=" + this.periodModel + ", " +
				"_type=" + this._type + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcOption  ***********************/
	class LcOptionBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl  implements LcOption.LcOptionBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected LcType.LcTypeBuilder _type;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder minLcIssuanceFeeAmount;
	
		public LcOptionBuilderImpl() {
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
		@RosettaAttribute("_type")
		public LcType.LcTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public LcType.LcTypeBuilder getOrCreate_type() {
			LcType.LcTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = LcType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (minLcIssuanceFeeAmount!=null) {
				result = minLcIssuanceFeeAmount;
			}
			else {
				result = minLcIssuanceFeeAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public LcOption.LcOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public LcOption.LcOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public LcOption.LcOptionBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public LcOption.LcOptionBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public LcOption.LcOptionBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public LcOption.LcOptionBuilder set_type(LcType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		public LcOption.LcOptionBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare minLcIssuanceFeeAmount) {
			this.minLcIssuanceFeeAmount = minLcIssuanceFeeAmount==null?null:minLcIssuanceFeeAmount.toBuilder();
			return this;
		}
		
		@Override
		public LcOption build() {
			return new LcOption.LcOptionImpl(this);
		}
		
		@Override
		public LcOption.LcOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcOption.LcOptionBuilder prune() {
			super.prune();
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (_type!=null && !_type.prune().hasData()) _type = null;
			if (minLcIssuanceFeeAmount!=null && !minLcIssuanceFeeAmount.prune().hasData()) minLcIssuanceFeeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			if (getMinLcIssuanceFeeAmount()!=null && getMinLcIssuanceFeeAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcOption.LcOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcOption.LcOptionBuilder o = (LcOption.LcOptionBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			merger.mergeRosetta(getMinLcIssuanceFeeAmount(), o.getMinLcIssuanceFeeAmount(), this::setMinLcIssuanceFeeAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcOption _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcOptionBuilder {" +
				"periodModel=" + this.periodModel + ", " +
				"_type=" + this._type + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount +
			'}' + " " + super.toString();
		}
	}
}
