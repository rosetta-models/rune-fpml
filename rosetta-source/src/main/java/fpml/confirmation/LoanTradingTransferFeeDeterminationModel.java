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
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilderImpl;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanTradingTransferFeeDeterminationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model which contains factors associated with the payment of a transfer fee.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradingTransferFeeDeterminationModel", builder=LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradingTransferFeeDeterminationModel extends RosettaModelObject {

	LoanTradingTransferFeeDeterminationModelMeta metaData = new LoanTradingTransferFeeDeterminationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A flag defining whether the transfer fee is to be waived for this allocation.
	 */
	Boolean getWaivedFlag();
	/**
	 * Amount of transfer fee owed to the admin agent for the allocation, per the credit agreement.
	 */
	NonNegativeMoney getCreditAgreementAmount();
	/**
	 * Amount of transfer fee owed to the admin agent for the allocation, as determined by the agent.
	 */
	NonNegativeMoney getAgentAmount();

	/*********************** Build Methods  ***********************/
	LoanTradingTransferFeeDeterminationModel build();
	
	LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder toBuilder();
	
	static LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder builder() {
		return new LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingTransferFeeDeterminationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingTransferFeeDeterminationModel> getType() {
		return LoanTradingTransferFeeDeterminationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("waivedFlag"), Boolean.class, getWaivedFlag(), this);
		processRosetta(path.newSubPath("creditAgreementAmount"), processor, NonNegativeMoney.class, getCreditAgreementAmount());
		processRosetta(path.newSubPath("agentAmount"), processor, NonNegativeMoney.class, getAgentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingTransferFeeDeterminationModelBuilder extends LoanTradingTransferFeeDeterminationModel, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCreditAgreementAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getCreditAgreementAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAgentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAgentAmount();
		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder setWaivedFlag(Boolean waivedFlag);
		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder setCreditAgreementAmount(NonNegativeMoney creditAgreementAmount);
		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder setAgentAmount(NonNegativeMoney agentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("waivedFlag"), Boolean.class, getWaivedFlag(), this);
			processRosetta(path.newSubPath("creditAgreementAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getCreditAgreementAmount());
			processRosetta(path.newSubPath("agentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAgentAmount());
		}
		

		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingTransferFeeDeterminationModel  ***********************/
	class LoanTradingTransferFeeDeterminationModelImpl implements LoanTradingTransferFeeDeterminationModel {
		private final Boolean waivedFlag;
		private final NonNegativeMoney creditAgreementAmount;
		private final NonNegativeMoney agentAmount;
		
		protected LoanTradingTransferFeeDeterminationModelImpl(LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder builder) {
			this.waivedFlag = builder.getWaivedFlag();
			this.creditAgreementAmount = ofNullable(builder.getCreditAgreementAmount()).map(f->f.build()).orElse(null);
			this.agentAmount = ofNullable(builder.getAgentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("waivedFlag")
		public Boolean getWaivedFlag() {
			return waivedFlag;
		}
		
		@Override
		@RosettaAttribute("creditAgreementAmount")
		public NonNegativeMoney getCreditAgreementAmount() {
			return creditAgreementAmount;
		}
		
		@Override
		@RosettaAttribute("agentAmount")
		public NonNegativeMoney getAgentAmount() {
			return agentAmount;
		}
		
		@Override
		public LoanTradingTransferFeeDeterminationModel build() {
			return this;
		}
		
		@Override
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder toBuilder() {
			LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder builder) {
			ofNullable(getWaivedFlag()).ifPresent(builder::setWaivedFlag);
			ofNullable(getCreditAgreementAmount()).ifPresent(builder::setCreditAgreementAmount);
			ofNullable(getAgentAmount()).ifPresent(builder::setAgentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingTransferFeeDeterminationModel _that = getType().cast(o);
		
			if (!Objects.equals(waivedFlag, _that.getWaivedFlag())) return false;
			if (!Objects.equals(creditAgreementAmount, _that.getCreditAgreementAmount())) return false;
			if (!Objects.equals(agentAmount, _that.getAgentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (waivedFlag != null ? waivedFlag.hashCode() : 0);
			_result = 31 * _result + (creditAgreementAmount != null ? creditAgreementAmount.hashCode() : 0);
			_result = 31 * _result + (agentAmount != null ? agentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingTransferFeeDeterminationModel {" +
				"waivedFlag=" + this.waivedFlag + ", " +
				"creditAgreementAmount=" + this.creditAgreementAmount + ", " +
				"agentAmount=" + this.agentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingTransferFeeDeterminationModel  ***********************/
	class LoanTradingTransferFeeDeterminationModelBuilderImpl implements LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder {
	
		protected Boolean waivedFlag;
		protected NonNegativeMoney.NonNegativeMoneyBuilder creditAgreementAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder agentAmount;
	
		public LoanTradingTransferFeeDeterminationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("waivedFlag")
		public Boolean getWaivedFlag() {
			return waivedFlag;
		}
		
		@Override
		@RosettaAttribute("creditAgreementAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getCreditAgreementAmount() {
			return creditAgreementAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCreditAgreementAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (creditAgreementAmount!=null) {
				result = creditAgreementAmount;
			}
			else {
				result = creditAgreementAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("agentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAgentAmount() {
			return agentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAgentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (agentAmount!=null) {
				result = agentAmount;
			}
			else {
				result = agentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("waivedFlag")
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder setWaivedFlag(Boolean waivedFlag) {
			this.waivedFlag = waivedFlag==null?null:waivedFlag;
			return this;
		}
		@Override
		@RosettaAttribute("creditAgreementAmount")
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder setCreditAgreementAmount(NonNegativeMoney creditAgreementAmount) {
			this.creditAgreementAmount = creditAgreementAmount==null?null:creditAgreementAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("agentAmount")
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder setAgentAmount(NonNegativeMoney agentAmount) {
			this.agentAmount = agentAmount==null?null:agentAmount.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingTransferFeeDeterminationModel build() {
			return new LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelImpl(this);
		}
		
		@Override
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder prune() {
			if (creditAgreementAmount!=null && !creditAgreementAmount.prune().hasData()) creditAgreementAmount = null;
			if (agentAmount!=null && !agentAmount.prune().hasData()) agentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getWaivedFlag()!=null) return true;
			if (getCreditAgreementAmount()!=null && getCreditAgreementAmount().hasData()) return true;
			if (getAgentAmount()!=null && getAgentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder o = (LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder) other;
			
			merger.mergeRosetta(getCreditAgreementAmount(), o.getCreditAgreementAmount(), this::setCreditAgreementAmount);
			merger.mergeRosetta(getAgentAmount(), o.getAgentAmount(), this::setAgentAmount);
			
			merger.mergeBasic(getWaivedFlag(), o.getWaivedFlag(), this::setWaivedFlag);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingTransferFeeDeterminationModel _that = getType().cast(o);
		
			if (!Objects.equals(waivedFlag, _that.getWaivedFlag())) return false;
			if (!Objects.equals(creditAgreementAmount, _that.getCreditAgreementAmount())) return false;
			if (!Objects.equals(agentAmount, _that.getAgentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (waivedFlag != null ? waivedFlag.hashCode() : 0);
			_result = 31 * _result + (creditAgreementAmount != null ? creditAgreementAmount.hashCode() : 0);
			_result = 31 * _result + (agentAmount != null ? agentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingTransferFeeDeterminationModelBuilder {" +
				"waivedFlag=" + this.waivedFlag + ", " +
				"creditAgreementAmount=" + this.creditAgreementAmount + ", " +
				"agentAmount=" + this.agentAmount +
			'}';
		}
	}
}
