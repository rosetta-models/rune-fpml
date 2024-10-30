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
import fpml.confirmation.BuySellEnum;
import fpml.confirmation.LoanTradingAccrualSettlementEnum;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilderImpl;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelImpl;
import fpml.confirmation.LoanTradingDocTypeEnum;
import fpml.confirmation.meta.LoanTradingCounterpartyCashSettlementRulesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model which contains the master trade settlement terms.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradingCounterpartyCashSettlementRulesModel", builder=LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradingCounterpartyCashSettlementRulesModel extends RosettaModelObject {

	LoanTradingCounterpartyCashSettlementRulesModelMeta metaData = new LoanTradingCounterpartyCashSettlementRulesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines whether the loan trade is being settled under par or distressed documentation.
	 */
	LoanTradingDocTypeEnum getDocumentationType();
	/**
	 * Defines the way in which interest (and fees) will be handled between the buyer and seller of the loan.
	 */
	LoanTradingAccrualSettlementEnum getAccrualSettlementType();
	/**
	 * Defines whether delayed compensation is due at settlement of the loan trade.
	 */
	Boolean getDelayedCompensationFlag();
	/**
	 * Defines the benefit of all amendment fees, consent, waiver, ticking and other non-recurring fees occurring between trade date and settlement date.
	 */
	BuySellEnum getNonRecurringFeesBenefactor();

	/*********************** Build Methods  ***********************/
	LoanTradingCounterpartyCashSettlementRulesModel build();
	
	LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder toBuilder();
	
	static LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder builder() {
		return new LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingCounterpartyCashSettlementRulesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingCounterpartyCashSettlementRulesModel> getType() {
		return LoanTradingCounterpartyCashSettlementRulesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("documentationType"), LoanTradingDocTypeEnum.class, getDocumentationType(), this);
		processor.processBasic(path.newSubPath("accrualSettlementType"), LoanTradingAccrualSettlementEnum.class, getAccrualSettlementType(), this);
		processor.processBasic(path.newSubPath("delayedCompensationFlag"), Boolean.class, getDelayedCompensationFlag(), this);
		processor.processBasic(path.newSubPath("nonRecurringFeesBenefactor"), BuySellEnum.class, getNonRecurringFeesBenefactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingCounterpartyCashSettlementRulesModelBuilder extends LoanTradingCounterpartyCashSettlementRulesModel, RosettaModelObjectBuilder {
		LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setDocumentationType(LoanTradingDocTypeEnum documentationType);
		LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setAccrualSettlementType(LoanTradingAccrualSettlementEnum accrualSettlementType);
		LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setDelayedCompensationFlag(Boolean delayedCompensationFlag);
		LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setNonRecurringFeesBenefactor(BuySellEnum nonRecurringFeesBenefactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("documentationType"), LoanTradingDocTypeEnum.class, getDocumentationType(), this);
			processor.processBasic(path.newSubPath("accrualSettlementType"), LoanTradingAccrualSettlementEnum.class, getAccrualSettlementType(), this);
			processor.processBasic(path.newSubPath("delayedCompensationFlag"), Boolean.class, getDelayedCompensationFlag(), this);
			processor.processBasic(path.newSubPath("nonRecurringFeesBenefactor"), BuySellEnum.class, getNonRecurringFeesBenefactor(), this);
		}
		

		LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingCounterpartyCashSettlementRulesModel  ***********************/
	class LoanTradingCounterpartyCashSettlementRulesModelImpl implements LoanTradingCounterpartyCashSettlementRulesModel {
		private final LoanTradingDocTypeEnum documentationType;
		private final LoanTradingAccrualSettlementEnum accrualSettlementType;
		private final Boolean delayedCompensationFlag;
		private final BuySellEnum nonRecurringFeesBenefactor;
		
		protected LoanTradingCounterpartyCashSettlementRulesModelImpl(LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder builder) {
			this.documentationType = builder.getDocumentationType();
			this.accrualSettlementType = builder.getAccrualSettlementType();
			this.delayedCompensationFlag = builder.getDelayedCompensationFlag();
			this.nonRecurringFeesBenefactor = builder.getNonRecurringFeesBenefactor();
		}
		
		@Override
		@RosettaAttribute("documentationType")
		public LoanTradingDocTypeEnum getDocumentationType() {
			return documentationType;
		}
		
		@Override
		@RosettaAttribute("accrualSettlementType")
		public LoanTradingAccrualSettlementEnum getAccrualSettlementType() {
			return accrualSettlementType;
		}
		
		@Override
		@RosettaAttribute("delayedCompensationFlag")
		public Boolean getDelayedCompensationFlag() {
			return delayedCompensationFlag;
		}
		
		@Override
		@RosettaAttribute("nonRecurringFeesBenefactor")
		public BuySellEnum getNonRecurringFeesBenefactor() {
			return nonRecurringFeesBenefactor;
		}
		
		@Override
		public LoanTradingCounterpartyCashSettlementRulesModel build() {
			return this;
		}
		
		@Override
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder toBuilder() {
			LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder builder) {
			ofNullable(getDocumentationType()).ifPresent(builder::setDocumentationType);
			ofNullable(getAccrualSettlementType()).ifPresent(builder::setAccrualSettlementType);
			ofNullable(getDelayedCompensationFlag()).ifPresent(builder::setDelayedCompensationFlag);
			ofNullable(getNonRecurringFeesBenefactor()).ifPresent(builder::setNonRecurringFeesBenefactor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartyCashSettlementRulesModel _that = getType().cast(o);
		
			if (!Objects.equals(documentationType, _that.getDocumentationType())) return false;
			if (!Objects.equals(accrualSettlementType, _that.getAccrualSettlementType())) return false;
			if (!Objects.equals(delayedCompensationFlag, _that.getDelayedCompensationFlag())) return false;
			if (!Objects.equals(nonRecurringFeesBenefactor, _that.getNonRecurringFeesBenefactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentationType != null ? documentationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (accrualSettlementType != null ? accrualSettlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delayedCompensationFlag != null ? delayedCompensationFlag.hashCode() : 0);
			_result = 31 * _result + (nonRecurringFeesBenefactor != null ? nonRecurringFeesBenefactor.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartyCashSettlementRulesModel {" +
				"documentationType=" + this.documentationType + ", " +
				"accrualSettlementType=" + this.accrualSettlementType + ", " +
				"delayedCompensationFlag=" + this.delayedCompensationFlag + ", " +
				"nonRecurringFeesBenefactor=" + this.nonRecurringFeesBenefactor +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingCounterpartyCashSettlementRulesModel  ***********************/
	class LoanTradingCounterpartyCashSettlementRulesModelBuilderImpl implements LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder {
	
		protected LoanTradingDocTypeEnum documentationType;
		protected LoanTradingAccrualSettlementEnum accrualSettlementType;
		protected Boolean delayedCompensationFlag;
		protected BuySellEnum nonRecurringFeesBenefactor;
	
		public LoanTradingCounterpartyCashSettlementRulesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("documentationType")
		public LoanTradingDocTypeEnum getDocumentationType() {
			return documentationType;
		}
		
		@Override
		@RosettaAttribute("accrualSettlementType")
		public LoanTradingAccrualSettlementEnum getAccrualSettlementType() {
			return accrualSettlementType;
		}
		
		@Override
		@RosettaAttribute("delayedCompensationFlag")
		public Boolean getDelayedCompensationFlag() {
			return delayedCompensationFlag;
		}
		
		@Override
		@RosettaAttribute("nonRecurringFeesBenefactor")
		public BuySellEnum getNonRecurringFeesBenefactor() {
			return nonRecurringFeesBenefactor;
		}
		
		@Override
		@RosettaAttribute("documentationType")
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setDocumentationType(LoanTradingDocTypeEnum documentationType) {
			this.documentationType = documentationType==null?null:documentationType;
			return this;
		}
		@Override
		@RosettaAttribute("accrualSettlementType")
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setAccrualSettlementType(LoanTradingAccrualSettlementEnum accrualSettlementType) {
			this.accrualSettlementType = accrualSettlementType==null?null:accrualSettlementType;
			return this;
		}
		@Override
		@RosettaAttribute("delayedCompensationFlag")
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setDelayedCompensationFlag(Boolean delayedCompensationFlag) {
			this.delayedCompensationFlag = delayedCompensationFlag==null?null:delayedCompensationFlag;
			return this;
		}
		@Override
		@RosettaAttribute("nonRecurringFeesBenefactor")
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder setNonRecurringFeesBenefactor(BuySellEnum nonRecurringFeesBenefactor) {
			this.nonRecurringFeesBenefactor = nonRecurringFeesBenefactor==null?null:nonRecurringFeesBenefactor;
			return this;
		}
		
		@Override
		public LoanTradingCounterpartyCashSettlementRulesModel build() {
			return new LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelImpl(this);
		}
		
		@Override
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDocumentationType()!=null) return true;
			if (getAccrualSettlementType()!=null) return true;
			if (getDelayedCompensationFlag()!=null) return true;
			if (getNonRecurringFeesBenefactor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder o = (LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder) other;
			
			
			merger.mergeBasic(getDocumentationType(), o.getDocumentationType(), this::setDocumentationType);
			merger.mergeBasic(getAccrualSettlementType(), o.getAccrualSettlementType(), this::setAccrualSettlementType);
			merger.mergeBasic(getDelayedCompensationFlag(), o.getDelayedCompensationFlag(), this::setDelayedCompensationFlag);
			merger.mergeBasic(getNonRecurringFeesBenefactor(), o.getNonRecurringFeesBenefactor(), this::setNonRecurringFeesBenefactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartyCashSettlementRulesModel _that = getType().cast(o);
		
			if (!Objects.equals(documentationType, _that.getDocumentationType())) return false;
			if (!Objects.equals(accrualSettlementType, _that.getAccrualSettlementType())) return false;
			if (!Objects.equals(delayedCompensationFlag, _that.getDelayedCompensationFlag())) return false;
			if (!Objects.equals(nonRecurringFeesBenefactor, _that.getNonRecurringFeesBenefactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentationType != null ? documentationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (accrualSettlementType != null ? accrualSettlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delayedCompensationFlag != null ? delayedCompensationFlag.hashCode() : 0);
			_result = 31 * _result + (nonRecurringFeesBenefactor != null ? nonRecurringFeesBenefactor.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartyCashSettlementRulesModelBuilder {" +
				"documentationType=" + this.documentationType + ", " +
				"accrualSettlementType=" + this.accrualSettlementType + ", " +
				"delayedCompensationFlag=" + this.delayedCompensationFlag + ", " +
				"nonRecurringFeesBenefactor=" + this.nonRecurringFeesBenefactor +
			'}';
		}
	}
}
