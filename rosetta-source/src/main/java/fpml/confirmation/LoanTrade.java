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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LoanTrade;
import fpml.confirmation.LoanTrade.LoanTradeBuilder;
import fpml.confirmation.LoanTrade.LoanTradeBuilderImpl;
import fpml.confirmation.LoanTrade.LoanTradeImpl;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.LoanTradingTypeEnum;
import fpml.confirmation.LoanTransferFee;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.LoanTradeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines counterparty-to-counterparty loan trade information. This structure contains the main (e.g. fund manager/main counterparty) trade details.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTrade", builder=LoanTrade.LoanTradeBuilderImpl.class, version="${project.version}")
public interface LoanTrade extends AbstractLoanTrade {

	LoanTradeMeta metaData = new LoanTradeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The trade price, notated as a decimal, to be expressed as a percentage multiplied by the commitment amount.
	 */
	BigDecimal getPrice();
	/**
	 * Details of the transfer fee owed to the admin agent.
	 */
	LoanTransferFee getTransferFee();
	LoanTradingCounterpartyCashSettlementRulesModel getLoanTradingCounterpartyCashSettlementRulesModel();
	LoanTradingParticipationSettlementTermsModel getLoanTradingParticipationSettlementTermsModel();

	/*********************** Build Methods  ***********************/
	LoanTrade build();
	
	LoanTrade.LoanTradeBuilder toBuilder();
	
	static LoanTrade.LoanTradeBuilder builder() {
		return new LoanTrade.LoanTradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTrade> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTrade> getType() {
		return LoanTrade.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processor.processBasic(path.newSubPath("tradeDate"), Date.class, getTradeDate(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("_type"), LoanTradingTypeEnum.class, get_type(), this);
		processor.processBasic(path.newSubPath("whenIssuedFlag"), Boolean.class, getWhenIssuedFlag(), this);
		processRosetta(path.newSubPath("loanTradingSettlementTermsModel"), processor, LoanTradingSettlementTermsModel.class, getLoanTradingSettlementTermsModel());
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("transferFee"), processor, LoanTransferFee.class, getTransferFee());
		processRosetta(path.newSubPath("loanTradingCounterpartyCashSettlementRulesModel"), processor, LoanTradingCounterpartyCashSettlementRulesModel.class, getLoanTradingCounterpartyCashSettlementRulesModel());
		processRosetta(path.newSubPath("loanTradingParticipationSettlementTermsModel"), processor, LoanTradingParticipationSettlementTermsModel.class, getLoanTradingParticipationSettlementTermsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeBuilder extends LoanTrade, AbstractLoanTrade.AbstractLoanTradeBuilder {
		LoanTransferFee.LoanTransferFeeBuilder getOrCreateTransferFee();
		LoanTransferFee.LoanTransferFeeBuilder getTransferFee();
		LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder getOrCreateLoanTradingCounterpartyCashSettlementRulesModel();
		LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder getLoanTradingCounterpartyCashSettlementRulesModel();
		LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder getOrCreateLoanTradingParticipationSettlementTermsModel();
		LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder getLoanTradingParticipationSettlementTermsModel();
		LoanTrade.LoanTradeBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		LoanTrade.LoanTradeBuilder setFacilityReference(FacilityReference facilityReference);
		LoanTrade.LoanTradeBuilder setAmount(Money amount);
		LoanTrade.LoanTradeBuilder setComment(String comment);
		LoanTrade.LoanTradeBuilder setTradeDate(Date tradeDate);
		LoanTrade.LoanTradeBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		LoanTrade.LoanTradeBuilder set_type(LoanTradingTypeEnum _type);
		LoanTrade.LoanTradeBuilder setWhenIssuedFlag(Boolean whenIssuedFlag);
		LoanTrade.LoanTradeBuilder setLoanTradingSettlementTermsModel(LoanTradingSettlementTermsModel loanTradingSettlementTermsModel);
		LoanTrade.LoanTradeBuilder setPrice(BigDecimal price);
		LoanTrade.LoanTradeBuilder setTransferFee(LoanTransferFee transferFee);
		LoanTrade.LoanTradeBuilder setLoanTradingCounterpartyCashSettlementRulesModel(LoanTradingCounterpartyCashSettlementRulesModel loanTradingCounterpartyCashSettlementRulesModel);
		LoanTrade.LoanTradeBuilder setLoanTradingParticipationSettlementTermsModel(LoanTradingParticipationSettlementTermsModel loanTradingParticipationSettlementTermsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processor.processBasic(path.newSubPath("tradeDate"), Date.class, getTradeDate(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("_type"), LoanTradingTypeEnum.class, get_type(), this);
			processor.processBasic(path.newSubPath("whenIssuedFlag"), Boolean.class, getWhenIssuedFlag(), this);
			processRosetta(path.newSubPath("loanTradingSettlementTermsModel"), processor, LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder.class, getLoanTradingSettlementTermsModel());
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("transferFee"), processor, LoanTransferFee.LoanTransferFeeBuilder.class, getTransferFee());
			processRosetta(path.newSubPath("loanTradingCounterpartyCashSettlementRulesModel"), processor, LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder.class, getLoanTradingCounterpartyCashSettlementRulesModel());
			processRosetta(path.newSubPath("loanTradingParticipationSettlementTermsModel"), processor, LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder.class, getLoanTradingParticipationSettlementTermsModel());
		}
		

		LoanTrade.LoanTradeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTrade  ***********************/
	class LoanTradeImpl extends AbstractLoanTrade.AbstractLoanTradeImpl implements LoanTrade {
		private final BigDecimal price;
		private final LoanTransferFee transferFee;
		private final LoanTradingCounterpartyCashSettlementRulesModel loanTradingCounterpartyCashSettlementRulesModel;
		private final LoanTradingParticipationSettlementTermsModel loanTradingParticipationSettlementTermsModel;
		
		protected LoanTradeImpl(LoanTrade.LoanTradeBuilder builder) {
			super(builder);
			this.price = builder.getPrice();
			this.transferFee = ofNullable(builder.getTransferFee()).map(f->f.build()).orElse(null);
			this.loanTradingCounterpartyCashSettlementRulesModel = ofNullable(builder.getLoanTradingCounterpartyCashSettlementRulesModel()).map(f->f.build()).orElse(null);
			this.loanTradingParticipationSettlementTermsModel = ofNullable(builder.getLoanTradingParticipationSettlementTermsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("transferFee")
		public LoanTransferFee getTransferFee() {
			return transferFee;
		}
		
		@Override
		@RosettaAttribute("loanTradingCounterpartyCashSettlementRulesModel")
		public LoanTradingCounterpartyCashSettlementRulesModel getLoanTradingCounterpartyCashSettlementRulesModel() {
			return loanTradingCounterpartyCashSettlementRulesModel;
		}
		
		@Override
		@RosettaAttribute("loanTradingParticipationSettlementTermsModel")
		public LoanTradingParticipationSettlementTermsModel getLoanTradingParticipationSettlementTermsModel() {
			return loanTradingParticipationSettlementTermsModel;
		}
		
		@Override
		public LoanTrade build() {
			return this;
		}
		
		@Override
		public LoanTrade.LoanTradeBuilder toBuilder() {
			LoanTrade.LoanTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTrade.LoanTradeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getTransferFee()).ifPresent(builder::setTransferFee);
			ofNullable(getLoanTradingCounterpartyCashSettlementRulesModel()).ifPresent(builder::setLoanTradingCounterpartyCashSettlementRulesModel);
			ofNullable(getLoanTradingParticipationSettlementTermsModel()).ifPresent(builder::setLoanTradingParticipationSettlementTermsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTrade _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!Objects.equals(loanTradingCounterpartyCashSettlementRulesModel, _that.getLoanTradingCounterpartyCashSettlementRulesModel())) return false;
			if (!Objects.equals(loanTradingParticipationSettlementTermsModel, _that.getLoanTradingParticipationSettlementTermsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (loanTradingCounterpartyCashSettlementRulesModel != null ? loanTradingCounterpartyCashSettlementRulesModel.hashCode() : 0);
			_result = 31 * _result + (loanTradingParticipationSettlementTermsModel != null ? loanTradingParticipationSettlementTermsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTrade {" +
				"price=" + this.price + ", " +
				"transferFee=" + this.transferFee + ", " +
				"loanTradingCounterpartyCashSettlementRulesModel=" + this.loanTradingCounterpartyCashSettlementRulesModel + ", " +
				"loanTradingParticipationSettlementTermsModel=" + this.loanTradingParticipationSettlementTermsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTrade  ***********************/
	class LoanTradeBuilderImpl extends AbstractLoanTrade.AbstractLoanTradeBuilderImpl  implements LoanTrade.LoanTradeBuilder {
	
		protected BigDecimal price;
		protected LoanTransferFee.LoanTransferFeeBuilder transferFee;
		protected LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder loanTradingCounterpartyCashSettlementRulesModel;
		protected LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder loanTradingParticipationSettlementTermsModel;
	
		public LoanTradeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("transferFee")
		public LoanTransferFee.LoanTransferFeeBuilder getTransferFee() {
			return transferFee;
		}
		
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder getOrCreateTransferFee() {
			LoanTransferFee.LoanTransferFeeBuilder result;
			if (transferFee!=null) {
				result = transferFee;
			}
			else {
				result = transferFee = LoanTransferFee.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanTradingCounterpartyCashSettlementRulesModel")
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder getLoanTradingCounterpartyCashSettlementRulesModel() {
			return loanTradingCounterpartyCashSettlementRulesModel;
		}
		
		@Override
		public LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder getOrCreateLoanTradingCounterpartyCashSettlementRulesModel() {
			LoanTradingCounterpartyCashSettlementRulesModel.LoanTradingCounterpartyCashSettlementRulesModelBuilder result;
			if (loanTradingCounterpartyCashSettlementRulesModel!=null) {
				result = loanTradingCounterpartyCashSettlementRulesModel;
			}
			else {
				result = loanTradingCounterpartyCashSettlementRulesModel = LoanTradingCounterpartyCashSettlementRulesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanTradingParticipationSettlementTermsModel")
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder getLoanTradingParticipationSettlementTermsModel() {
			return loanTradingParticipationSettlementTermsModel;
		}
		
		@Override
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder getOrCreateLoanTradingParticipationSettlementTermsModel() {
			LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder result;
			if (loanTradingParticipationSettlementTermsModel!=null) {
				result = loanTradingParticipationSettlementTermsModel;
			}
			else {
				result = loanTradingParticipationSettlementTermsModel = LoanTradingParticipationSettlementTermsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public LoanTrade.LoanTradeBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier) {
			this.tradeIdentifier = tradeIdentifier==null?null:tradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public LoanTrade.LoanTradeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanTrade.LoanTradeBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTrade.LoanTradeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("tradeDate")
		public LoanTrade.LoanTradeBuilder setTradeDate(Date tradeDate) {
			this.tradeDate = tradeDate==null?null:tradeDate;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public LoanTrade.LoanTradeBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public LoanTrade.LoanTradeBuilder set_type(LoanTradingTypeEnum _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		@Override
		@RosettaAttribute("whenIssuedFlag")
		public LoanTrade.LoanTradeBuilder setWhenIssuedFlag(Boolean whenIssuedFlag) {
			this.whenIssuedFlag = whenIssuedFlag==null?null:whenIssuedFlag;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradingSettlementTermsModel")
		public LoanTrade.LoanTradeBuilder setLoanTradingSettlementTermsModel(LoanTradingSettlementTermsModel loanTradingSettlementTermsModel) {
			this.loanTradingSettlementTermsModel = loanTradingSettlementTermsModel==null?null:loanTradingSettlementTermsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("price")
		public LoanTrade.LoanTradeBuilder setPrice(BigDecimal price) {
			this.price = price==null?null:price;
			return this;
		}
		@Override
		@RosettaAttribute("transferFee")
		public LoanTrade.LoanTradeBuilder setTransferFee(LoanTransferFee transferFee) {
			this.transferFee = transferFee==null?null:transferFee.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanTradingCounterpartyCashSettlementRulesModel")
		public LoanTrade.LoanTradeBuilder setLoanTradingCounterpartyCashSettlementRulesModel(LoanTradingCounterpartyCashSettlementRulesModel loanTradingCounterpartyCashSettlementRulesModel) {
			this.loanTradingCounterpartyCashSettlementRulesModel = loanTradingCounterpartyCashSettlementRulesModel==null?null:loanTradingCounterpartyCashSettlementRulesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanTradingParticipationSettlementTermsModel")
		public LoanTrade.LoanTradeBuilder setLoanTradingParticipationSettlementTermsModel(LoanTradingParticipationSettlementTermsModel loanTradingParticipationSettlementTermsModel) {
			this.loanTradingParticipationSettlementTermsModel = loanTradingParticipationSettlementTermsModel==null?null:loanTradingParticipationSettlementTermsModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanTrade build() {
			return new LoanTrade.LoanTradeImpl(this);
		}
		
		@Override
		public LoanTrade.LoanTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTrade.LoanTradeBuilder prune() {
			super.prune();
			if (transferFee!=null && !transferFee.prune().hasData()) transferFee = null;
			if (loanTradingCounterpartyCashSettlementRulesModel!=null && !loanTradingCounterpartyCashSettlementRulesModel.prune().hasData()) loanTradingCounterpartyCashSettlementRulesModel = null;
			if (loanTradingParticipationSettlementTermsModel!=null && !loanTradingParticipationSettlementTermsModel.prune().hasData()) loanTradingParticipationSettlementTermsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPrice()!=null) return true;
			if (getTransferFee()!=null && getTransferFee().hasData()) return true;
			if (getLoanTradingCounterpartyCashSettlementRulesModel()!=null && getLoanTradingCounterpartyCashSettlementRulesModel().hasData()) return true;
			if (getLoanTradingParticipationSettlementTermsModel()!=null && getLoanTradingParticipationSettlementTermsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTrade.LoanTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTrade.LoanTradeBuilder o = (LoanTrade.LoanTradeBuilder) other;
			
			merger.mergeRosetta(getTransferFee(), o.getTransferFee(), this::setTransferFee);
			merger.mergeRosetta(getLoanTradingCounterpartyCashSettlementRulesModel(), o.getLoanTradingCounterpartyCashSettlementRulesModel(), this::setLoanTradingCounterpartyCashSettlementRulesModel);
			merger.mergeRosetta(getLoanTradingParticipationSettlementTermsModel(), o.getLoanTradingParticipationSettlementTermsModel(), this::setLoanTradingParticipationSettlementTermsModel);
			
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTrade _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!Objects.equals(loanTradingCounterpartyCashSettlementRulesModel, _that.getLoanTradingCounterpartyCashSettlementRulesModel())) return false;
			if (!Objects.equals(loanTradingParticipationSettlementTermsModel, _that.getLoanTradingParticipationSettlementTermsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (loanTradingCounterpartyCashSettlementRulesModel != null ? loanTradingCounterpartyCashSettlementRulesModel.hashCode() : 0);
			_result = 31 * _result + (loanTradingParticipationSettlementTermsModel != null ? loanTradingParticipationSettlementTermsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeBuilder {" +
				"price=" + this.price + ", " +
				"transferFee=" + this.transferFee + ", " +
				"loanTradingCounterpartyCashSettlementRulesModel=" + this.loanTradingCounterpartyCashSettlementRulesModel + ", " +
				"loanTradingParticipationSettlementTermsModel=" + this.loanTradingParticipationSettlementTermsModel +
			'}' + " " + super.toString();
		}
	}
}
