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
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.AccrualPeriod.AccrualPeriodBuilder;
import fpml.confirmation.AccrualPeriod.AccrualPeriodBuilderImpl;
import fpml.confirmation.AccrualPeriod.AccrualPeriodImpl;
import fpml.confirmation.AccrualReferenceAmountTypeEnum;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodWithDaysModel;
import fpml.confirmation.meta.AccrualPeriodMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that describes the details of the underlying elements that explain the calculation of an accrual against a reference balance.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccrualPeriod", builder=AccrualPeriod.AccrualPeriodBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccrualPeriod extends RosettaModelObject {

	AccrualPeriodMeta metaData = new AccrualPeriodMeta();

	/*********************** Getter Methods  ***********************/
	PeriodWithDaysModel getPeriodWithDaysModel();
	/**
	 * Global and lender share amounts.
	 */
	MoneyWithParticipantShare getReferenceAmount();
	/**
	 * The rate applied to this period.
	 */
	AccrualReferenceAmountTypeEnum getReferenceAmountType();
	/**
	 * The rate applied to this period.
	 */
	BigDecimal getRate();
	/**
	 * The accrual amount over the defined period.
	 */
	MoneyWithParticipantShare getAccrualAmount();

	/*********************** Build Methods  ***********************/
	AccrualPeriod build();
	
	AccrualPeriod.AccrualPeriodBuilder toBuilder();
	
	static AccrualPeriod.AccrualPeriodBuilder builder() {
		return new AccrualPeriod.AccrualPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccrualPeriod> getType() {
		return AccrualPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.class, getPeriodWithDaysModel());
		processRosetta(path.newSubPath("referenceAmount"), processor, MoneyWithParticipantShare.class, getReferenceAmount());
		processor.processBasic(path.newSubPath("referenceAmountType"), AccrualReferenceAmountTypeEnum.class, getReferenceAmountType(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("accrualAmount"), processor, MoneyWithParticipantShare.class, getAccrualAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualPeriodBuilder extends AccrualPeriod, RosettaModelObjectBuilder {
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getOrCreatePeriodWithDaysModel();
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getPeriodWithDaysModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateReferenceAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getReferenceAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAccrualAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAccrualAmount();
		AccrualPeriod.AccrualPeriodBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel);
		AccrualPeriod.AccrualPeriodBuilder setReferenceAmount(MoneyWithParticipantShare referenceAmount);
		AccrualPeriod.AccrualPeriodBuilder setReferenceAmountType(AccrualReferenceAmountTypeEnum referenceAmountType);
		AccrualPeriod.AccrualPeriodBuilder setRate(BigDecimal rate);
		AccrualPeriod.AccrualPeriodBuilder setAccrualAmount(MoneyWithParticipantShare accrualAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.PeriodWithDaysModelBuilder.class, getPeriodWithDaysModel());
			processRosetta(path.newSubPath("referenceAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getReferenceAmount());
			processor.processBasic(path.newSubPath("referenceAmountType"), AccrualReferenceAmountTypeEnum.class, getReferenceAmountType(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("accrualAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAccrualAmount());
		}
		

		AccrualPeriod.AccrualPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of AccrualPeriod  ***********************/
	class AccrualPeriodImpl implements AccrualPeriod {
		private final PeriodWithDaysModel periodWithDaysModel;
		private final MoneyWithParticipantShare referenceAmount;
		private final AccrualReferenceAmountTypeEnum referenceAmountType;
		private final BigDecimal rate;
		private final MoneyWithParticipantShare accrualAmount;
		
		protected AccrualPeriodImpl(AccrualPeriod.AccrualPeriodBuilder builder) {
			this.periodWithDaysModel = ofNullable(builder.getPeriodWithDaysModel()).map(f->f.build()).orElse(null);
			this.referenceAmount = ofNullable(builder.getReferenceAmount()).map(f->f.build()).orElse(null);
			this.referenceAmountType = builder.getReferenceAmountType();
			this.rate = builder.getRate();
			this.accrualAmount = ofNullable(builder.getAccrualAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public PeriodWithDaysModel getPeriodWithDaysModel() {
			return periodWithDaysModel;
		}
		
		@Override
		@RosettaAttribute("referenceAmount")
		public MoneyWithParticipantShare getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		@RosettaAttribute("referenceAmountType")
		public AccrualReferenceAmountTypeEnum getReferenceAmountType() {
			return referenceAmountType;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("accrualAmount")
		public MoneyWithParticipantShare getAccrualAmount() {
			return accrualAmount;
		}
		
		@Override
		public AccrualPeriod build() {
			return this;
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder toBuilder() {
			AccrualPeriod.AccrualPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualPeriod.AccrualPeriodBuilder builder) {
			ofNullable(getPeriodWithDaysModel()).ifPresent(builder::setPeriodWithDaysModel);
			ofNullable(getReferenceAmount()).ifPresent(builder::setReferenceAmount);
			ofNullable(getReferenceAmountType()).ifPresent(builder::setReferenceAmountType);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getAccrualAmount()).ifPresent(builder::setAccrualAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualPeriod _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(referenceAmountType, _that.getReferenceAmountType())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(accrualAmount, _that.getAccrualAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (referenceAmountType != null ? referenceAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (accrualAmount != null ? accrualAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualPeriod {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"referenceAmountType=" + this.referenceAmountType + ", " +
				"rate=" + this.rate + ", " +
				"accrualAmount=" + this.accrualAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of AccrualPeriod  ***********************/
	class AccrualPeriodBuilderImpl implements AccrualPeriod.AccrualPeriodBuilder {
	
		protected PeriodWithDaysModel.PeriodWithDaysModelBuilder periodWithDaysModel;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder referenceAmount;
		protected AccrualReferenceAmountTypeEnum referenceAmountType;
		protected BigDecimal rate;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder accrualAmount;
	
		public AccrualPeriodBuilderImpl() {
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
		@RosettaAttribute("referenceAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateReferenceAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (referenceAmount!=null) {
				result = referenceAmount;
			}
			else {
				result = referenceAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceAmountType")
		public AccrualReferenceAmountTypeEnum getReferenceAmountType() {
			return referenceAmountType;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("accrualAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAccrualAmount() {
			return accrualAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAccrualAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (accrualAmount!=null) {
				result = accrualAmount;
			}
			else {
				result = accrualAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public AccrualPeriod.AccrualPeriodBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel) {
			this.periodWithDaysModel = periodWithDaysModel==null?null:periodWithDaysModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceAmount")
		public AccrualPeriod.AccrualPeriodBuilder setReferenceAmount(MoneyWithParticipantShare referenceAmount) {
			this.referenceAmount = referenceAmount==null?null:referenceAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceAmountType")
		public AccrualPeriod.AccrualPeriodBuilder setReferenceAmountType(AccrualReferenceAmountTypeEnum referenceAmountType) {
			this.referenceAmountType = referenceAmountType==null?null:referenceAmountType;
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public AccrualPeriod.AccrualPeriodBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("accrualAmount")
		public AccrualPeriod.AccrualPeriodBuilder setAccrualAmount(MoneyWithParticipantShare accrualAmount) {
			this.accrualAmount = accrualAmount==null?null:accrualAmount.toBuilder();
			return this;
		}
		
		@Override
		public AccrualPeriod build() {
			return new AccrualPeriod.AccrualPeriodImpl(this);
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder prune() {
			if (periodWithDaysModel!=null && !periodWithDaysModel.prune().hasData()) periodWithDaysModel = null;
			if (referenceAmount!=null && !referenceAmount.prune().hasData()) referenceAmount = null;
			if (accrualAmount!=null && !accrualAmount.prune().hasData()) accrualAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodWithDaysModel()!=null && getPeriodWithDaysModel().hasData()) return true;
			if (getReferenceAmount()!=null && getReferenceAmount().hasData()) return true;
			if (getReferenceAmountType()!=null) return true;
			if (getRate()!=null) return true;
			if (getAccrualAmount()!=null && getAccrualAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccrualPeriod.AccrualPeriodBuilder o = (AccrualPeriod.AccrualPeriodBuilder) other;
			
			merger.mergeRosetta(getPeriodWithDaysModel(), o.getPeriodWithDaysModel(), this::setPeriodWithDaysModel);
			merger.mergeRosetta(getReferenceAmount(), o.getReferenceAmount(), this::setReferenceAmount);
			merger.mergeRosetta(getAccrualAmount(), o.getAccrualAmount(), this::setAccrualAmount);
			
			merger.mergeBasic(getReferenceAmountType(), o.getReferenceAmountType(), this::setReferenceAmountType);
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualPeriod _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(referenceAmountType, _that.getReferenceAmountType())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(accrualAmount, _that.getAccrualAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (referenceAmountType != null ? referenceAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (accrualAmount != null ? accrualAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualPeriodBuilder {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"referenceAmountType=" + this.referenceAmountType + ", " +
				"rate=" + this.rate + ", " +
				"accrualAmount=" + this.accrualAmount +
			'}';
		}
	}
}
