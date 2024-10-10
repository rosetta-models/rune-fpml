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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractLoanTrade;
import fpml.confirmation.AbstractLoanTrade.AbstractLoanTradeBuilder;
import fpml.confirmation.AbstractLoanTrade.AbstractLoanTradeBuilderImpl;
import fpml.confirmation.AbstractLoanTrade.AbstractLoanTradeImpl;
import fpml.confirmation.BuySellEnum;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.LoanTradingTypeEnum;
import fpml.confirmation.LoanTransfer;
import fpml.confirmation.LoanTransfer.LoanTransferBuilder;
import fpml.confirmation.LoanTransfer.LoanTransferBuilderImpl;
import fpml.confirmation.LoanTransfer.LoanTransferImpl;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.LoanTransferMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An event structure defining counterparty-to-admin agent loan trade information.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTransfer", builder=LoanTransfer.LoanTransferBuilderImpl.class, version="${project.version}")
public interface LoanTransfer extends AbstractLoanTrade {

	LoanTransferMeta metaData = new LoanTransferMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party responsible for remitting the transfer fee to the admin agent (buyer or seller).
	 */
	BuySellEnum getTransferFeeRemittedBy();

	/*********************** Build Methods  ***********************/
	LoanTransfer build();
	
	LoanTransfer.LoanTransferBuilder toBuilder();
	
	static LoanTransfer.LoanTransferBuilder builder() {
		return new LoanTransfer.LoanTransferBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTransfer> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTransfer> getType() {
		return LoanTransfer.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processor.processBasic(path.newSubPath("tradeDate"), Date.class, getTradeDate(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("type"), LoanTradingTypeEnum.class, getType(), this);
		processor.processBasic(path.newSubPath("whenIssuedFlag"), Boolean.class, getWhenIssuedFlag(), this);
		processRosetta(path.newSubPath("loanTradingSettlementTermsModel"), processor, LoanTradingSettlementTermsModel.class, getLoanTradingSettlementTermsModel());
		processor.processBasic(path.newSubPath("transferFeeRemittedBy"), BuySellEnum.class, getTransferFeeRemittedBy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTransferBuilder extends LoanTransfer, AbstractLoanTrade.AbstractLoanTradeBuilder {
		LoanTransfer.LoanTransferBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		LoanTransfer.LoanTransferBuilder setFacilityReference(FacilityReference facilityReference);
		LoanTransfer.LoanTransferBuilder setAmount(Money amount);
		LoanTransfer.LoanTransferBuilder setComment(String comment);
		LoanTransfer.LoanTransferBuilder setTradeDate(Date tradeDate);
		LoanTransfer.LoanTransferBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		LoanTransfer.LoanTransferBuilder setType(LoanTradingTypeEnum type);
		LoanTransfer.LoanTransferBuilder setWhenIssuedFlag(Boolean whenIssuedFlag);
		LoanTransfer.LoanTransferBuilder setLoanTradingSettlementTermsModel(LoanTradingSettlementTermsModel loanTradingSettlementTermsModel);
		LoanTransfer.LoanTransferBuilder setTransferFeeRemittedBy(BuySellEnum transferFeeRemittedBy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processor.processBasic(path.newSubPath("tradeDate"), Date.class, getTradeDate(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("type"), LoanTradingTypeEnum.class, getType(), this);
			processor.processBasic(path.newSubPath("whenIssuedFlag"), Boolean.class, getWhenIssuedFlag(), this);
			processRosetta(path.newSubPath("loanTradingSettlementTermsModel"), processor, LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder.class, getLoanTradingSettlementTermsModel());
			processor.processBasic(path.newSubPath("transferFeeRemittedBy"), BuySellEnum.class, getTransferFeeRemittedBy(), this);
		}
		

		LoanTransfer.LoanTransferBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTransfer  ***********************/
	class LoanTransferImpl extends AbstractLoanTrade.AbstractLoanTradeImpl implements LoanTransfer {
		private final BuySellEnum transferFeeRemittedBy;
		
		protected LoanTransferImpl(LoanTransfer.LoanTransferBuilder builder) {
			super(builder);
			this.transferFeeRemittedBy = builder.getTransferFeeRemittedBy();
		}
		
		@Override
		@RosettaAttribute("transferFeeRemittedBy")
		public BuySellEnum getTransferFeeRemittedBy() {
			return transferFeeRemittedBy;
		}
		
		@Override
		public LoanTransfer build() {
			return this;
		}
		
		@Override
		public LoanTransfer.LoanTransferBuilder toBuilder() {
			LoanTransfer.LoanTransferBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTransfer.LoanTransferBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTransferFeeRemittedBy()).ifPresent(builder::setTransferFeeRemittedBy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTransfer _that = getType().cast(o);
		
			if (!Objects.equals(transferFeeRemittedBy, _that.getTransferFeeRemittedBy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (transferFeeRemittedBy != null ? transferFeeRemittedBy.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransfer {" +
				"transferFeeRemittedBy=" + this.transferFeeRemittedBy +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTransfer  ***********************/
	class LoanTransferBuilderImpl extends AbstractLoanTrade.AbstractLoanTradeBuilderImpl  implements LoanTransfer.LoanTransferBuilder {
	
		protected BuySellEnum transferFeeRemittedBy;
	
		public LoanTransferBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transferFeeRemittedBy")
		public BuySellEnum getTransferFeeRemittedBy() {
			return transferFeeRemittedBy;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public LoanTransfer.LoanTransferBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier) {
			this.tradeIdentifier = tradeIdentifier==null?null:tradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public LoanTransfer.LoanTransferBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanTransfer.LoanTransferBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTransfer.LoanTransferBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("tradeDate")
		public LoanTransfer.LoanTransferBuilder setTradeDate(Date tradeDate) {
			this.tradeDate = tradeDate==null?null:tradeDate;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public LoanTransfer.LoanTransferBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("type")
		public LoanTransfer.LoanTransferBuilder setType(LoanTradingTypeEnum type) {
			this.type = type==null?null:type;
			return this;
		}
		@Override
		@RosettaAttribute("whenIssuedFlag")
		public LoanTransfer.LoanTransferBuilder setWhenIssuedFlag(Boolean whenIssuedFlag) {
			this.whenIssuedFlag = whenIssuedFlag==null?null:whenIssuedFlag;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradingSettlementTermsModel")
		public LoanTransfer.LoanTransferBuilder setLoanTradingSettlementTermsModel(LoanTradingSettlementTermsModel loanTradingSettlementTermsModel) {
			this.loanTradingSettlementTermsModel = loanTradingSettlementTermsModel==null?null:loanTradingSettlementTermsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transferFeeRemittedBy")
		public LoanTransfer.LoanTransferBuilder setTransferFeeRemittedBy(BuySellEnum transferFeeRemittedBy) {
			this.transferFeeRemittedBy = transferFeeRemittedBy==null?null:transferFeeRemittedBy;
			return this;
		}
		
		@Override
		public LoanTransfer build() {
			return new LoanTransfer.LoanTransferImpl(this);
		}
		
		@Override
		public LoanTransfer.LoanTransferBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransfer.LoanTransferBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTransferFeeRemittedBy()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransfer.LoanTransferBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTransfer.LoanTransferBuilder o = (LoanTransfer.LoanTransferBuilder) other;
			
			
			merger.mergeBasic(getTransferFeeRemittedBy(), o.getTransferFeeRemittedBy(), this::setTransferFeeRemittedBy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTransfer _that = getType().cast(o);
		
			if (!Objects.equals(transferFeeRemittedBy, _that.getTransferFeeRemittedBy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (transferFeeRemittedBy != null ? transferFeeRemittedBy.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferBuilder {" +
				"transferFeeRemittedBy=" + this.transferFeeRemittedBy +
			'}' + " " + super.toString();
		}
	}
}
