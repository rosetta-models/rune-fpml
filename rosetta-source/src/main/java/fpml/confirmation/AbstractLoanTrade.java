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
import fpml.confirmation.AbstractLoanTradeSummary;
import fpml.confirmation.AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder;
import fpml.confirmation.AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilderImpl;
import fpml.confirmation.AbstractLoanTradeSummary.AbstractLoanTradeSummaryImpl;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.LoanTradingTypeEnum;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.AbstractLoanTradeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An underlying structure defining fundamental master loan trade event information.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanTrade", builder=AbstractLoanTrade.AbstractLoanTradeBuilderImpl.class, version="${project.version}")
public interface AbstractLoanTrade extends AbstractLoanTradeSummary {

	AbstractLoanTradeMeta metaData = new AbstractLoanTradeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The trade date associated with a specified trade record.
	 */
	Date getTradeDate();
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * Primary or Secondary.
	 */
	LoanTradingTypeEnum get_type();
	/**
	 * A flag to indicate the dependency of a secondary market loan trade upon the closing of a primary market loan structuring and syndication process.
	 */
	Boolean getWhenIssuedFlag();
	LoanTradingSettlementTermsModel getLoanTradingSettlementTermsModel();

	/*********************** Build Methods  ***********************/
	AbstractLoanTrade build();
	
	AbstractLoanTrade.AbstractLoanTradeBuilder toBuilder();
	
	static AbstractLoanTrade.AbstractLoanTradeBuilder builder() {
		return new AbstractLoanTrade.AbstractLoanTradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanTrade> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanTrade> getType() {
		return AbstractLoanTrade.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanTradeBuilder extends AbstractLoanTrade, AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder getOrCreateLoanTradingSettlementTermsModel();
		LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder getLoanTradingSettlementTermsModel();
		AbstractLoanTrade.AbstractLoanTradeBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		AbstractLoanTrade.AbstractLoanTradeBuilder setFacilityReference(FacilityReference facilityReference);
		AbstractLoanTrade.AbstractLoanTradeBuilder setAmount(Money amount);
		AbstractLoanTrade.AbstractLoanTradeBuilder setComment(String comment);
		AbstractLoanTrade.AbstractLoanTradeBuilder setTradeDate(Date tradeDate);
		AbstractLoanTrade.AbstractLoanTradeBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		AbstractLoanTrade.AbstractLoanTradeBuilder set_type(LoanTradingTypeEnum _type);
		AbstractLoanTrade.AbstractLoanTradeBuilder setWhenIssuedFlag(Boolean whenIssuedFlag);
		AbstractLoanTrade.AbstractLoanTradeBuilder setLoanTradingSettlementTermsModel(LoanTradingSettlementTermsModel loanTradingSettlementTermsModel);

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
		}
		

		AbstractLoanTrade.AbstractLoanTradeBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanTrade  ***********************/
	class AbstractLoanTradeImpl extends AbstractLoanTradeSummary.AbstractLoanTradeSummaryImpl implements AbstractLoanTrade {
		private final Date tradeDate;
		private final BuyerSellerModel buyerSellerModel;
		private final LoanTradingTypeEnum _type;
		private final Boolean whenIssuedFlag;
		private final LoanTradingSettlementTermsModel loanTradingSettlementTermsModel;
		
		protected AbstractLoanTradeImpl(AbstractLoanTrade.AbstractLoanTradeBuilder builder) {
			super(builder);
			this.tradeDate = builder.getTradeDate();
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this._type = builder.get_type();
			this.whenIssuedFlag = builder.getWhenIssuedFlag();
			this.loanTradingSettlementTermsModel = ofNullable(builder.getLoanTradingSettlementTermsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		public Date getTradeDate() {
			return tradeDate;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanTradingTypeEnum get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("whenIssuedFlag")
		public Boolean getWhenIssuedFlag() {
			return whenIssuedFlag;
		}
		
		@Override
		@RosettaAttribute("loanTradingSettlementTermsModel")
		public LoanTradingSettlementTermsModel getLoanTradingSettlementTermsModel() {
			return loanTradingSettlementTermsModel;
		}
		
		@Override
		public AbstractLoanTrade build() {
			return this;
		}
		
		@Override
		public AbstractLoanTrade.AbstractLoanTradeBuilder toBuilder() {
			AbstractLoanTrade.AbstractLoanTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanTrade.AbstractLoanTradeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeDate()).ifPresent(builder::setTradeDate);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getWhenIssuedFlag()).ifPresent(builder::setWhenIssuedFlag);
			ofNullable(getLoanTradingSettlementTermsModel()).ifPresent(builder::setLoanTradingSettlementTermsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTrade _that = getType().cast(o);
		
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(whenIssuedFlag, _that.getWhenIssuedFlag())) return false;
			if (!Objects.equals(loanTradingSettlementTermsModel, _that.getLoanTradingSettlementTermsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (whenIssuedFlag != null ? whenIssuedFlag.hashCode() : 0);
			_result = 31 * _result + (loanTradingSettlementTermsModel != null ? loanTradingSettlementTermsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTrade {" +
				"tradeDate=" + this.tradeDate + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"_type=" + this._type + ", " +
				"whenIssuedFlag=" + this.whenIssuedFlag + ", " +
				"loanTradingSettlementTermsModel=" + this.loanTradingSettlementTermsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanTrade  ***********************/
	class AbstractLoanTradeBuilderImpl extends AbstractLoanTradeSummary.AbstractLoanTradeSummaryBuilderImpl  implements AbstractLoanTrade.AbstractLoanTradeBuilder {
	
		protected Date tradeDate;
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected LoanTradingTypeEnum _type;
		protected Boolean whenIssuedFlag;
		protected LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder loanTradingSettlementTermsModel;
	
		public AbstractLoanTradeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeDate")
		public Date getTradeDate() {
			return tradeDate;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanTradingTypeEnum get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("whenIssuedFlag")
		public Boolean getWhenIssuedFlag() {
			return whenIssuedFlag;
		}
		
		@Override
		@RosettaAttribute("loanTradingSettlementTermsModel")
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder getLoanTradingSettlementTermsModel() {
			return loanTradingSettlementTermsModel;
		}
		
		@Override
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder getOrCreateLoanTradingSettlementTermsModel() {
			LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder result;
			if (loanTradingSettlementTermsModel!=null) {
				result = loanTradingSettlementTermsModel;
			}
			else {
				result = loanTradingSettlementTermsModel = LoanTradingSettlementTermsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier) {
			this.tradeIdentifier = tradeIdentifier==null?null:tradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("tradeDate")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setTradeDate(Date tradeDate) {
			this.tradeDate = tradeDate==null?null:tradeDate;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public AbstractLoanTrade.AbstractLoanTradeBuilder set_type(LoanTradingTypeEnum _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		@Override
		@RosettaAttribute("whenIssuedFlag")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setWhenIssuedFlag(Boolean whenIssuedFlag) {
			this.whenIssuedFlag = whenIssuedFlag==null?null:whenIssuedFlag;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradingSettlementTermsModel")
		public AbstractLoanTrade.AbstractLoanTradeBuilder setLoanTradingSettlementTermsModel(LoanTradingSettlementTermsModel loanTradingSettlementTermsModel) {
			this.loanTradingSettlementTermsModel = loanTradingSettlementTermsModel==null?null:loanTradingSettlementTermsModel.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanTrade build() {
			return new AbstractLoanTrade.AbstractLoanTradeImpl(this);
		}
		
		@Override
		public AbstractLoanTrade.AbstractLoanTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTrade.AbstractLoanTradeBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (loanTradingSettlementTermsModel!=null && !loanTradingSettlementTermsModel.prune().hasData()) loanTradingSettlementTermsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeDate()!=null) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (get_type()!=null) return true;
			if (getWhenIssuedFlag()!=null) return true;
			if (getLoanTradingSettlementTermsModel()!=null && getLoanTradingSettlementTermsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTrade.AbstractLoanTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanTrade.AbstractLoanTradeBuilder o = (AbstractLoanTrade.AbstractLoanTradeBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getLoanTradingSettlementTermsModel(), o.getLoanTradingSettlementTermsModel(), this::setLoanTradingSettlementTermsModel);
			
			merger.mergeBasic(getTradeDate(), o.getTradeDate(), this::setTradeDate);
			merger.mergeBasic(get_type(), o.get_type(), this::set_type);
			merger.mergeBasic(getWhenIssuedFlag(), o.getWhenIssuedFlag(), this::setWhenIssuedFlag);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTrade _that = getType().cast(o);
		
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(whenIssuedFlag, _that.getWhenIssuedFlag())) return false;
			if (!Objects.equals(loanTradingSettlementTermsModel, _that.getLoanTradingSettlementTermsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (whenIssuedFlag != null ? whenIssuedFlag.hashCode() : 0);
			_result = 31 * _result + (loanTradingSettlementTermsModel != null ? loanTradingSettlementTermsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradeBuilder {" +
				"tradeDate=" + this.tradeDate + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"_type=" + this._type + ", " +
				"whenIssuedFlag=" + this.whenIssuedFlag + ", " +
				"loanTradingSettlementTermsModel=" + this.loanTradingSettlementTermsModel +
			'}' + " " + super.toString();
		}
	}
}
