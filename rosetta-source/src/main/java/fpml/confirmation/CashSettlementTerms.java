package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CashSettlementTerms;
import fpml.confirmation.CashSettlementTerms.CashSettlementTermsBuilder;
import fpml.confirmation.CashSettlementTerms.CashSettlementTermsBuilderImpl;
import fpml.confirmation.CashSettlementTerms.CashSettlementTermsImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.FixedRecoveryModel;
import fpml.confirmation.Money;
import fpml.confirmation.QuotationRateTypeEnum;
import fpml.confirmation.SettlementTerms;
import fpml.confirmation.SettlementTerms.SettlementTermsBuilder;
import fpml.confirmation.SettlementTerms.SettlementTermsBuilderImpl;
import fpml.confirmation.SettlementTerms.SettlementTermsImpl;
import fpml.confirmation.ValuationDate;
import fpml.confirmation.ValuationMethodEnum;
import fpml.confirmation.meta.CashSettlementTermsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CashSettlementTerms", builder=CashSettlementTerms.CashSettlementTermsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CashSettlementTerms extends SettlementTerms {

	CashSettlementTermsMeta metaData = new CashSettlementTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of business days after conditions to settlement have been satisfied when the calculation agent obtains a price quotation on the Reference Obligation for purposes of cash settlement. There may be one or more valuation dates. This is typically specified if the cash settlement amount is not a fixed amount. ISDA 2003 Term: Valuation Date
	 */
	ValuationDate getValuationDate();
	/**
	 * The time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time
	 */
	BusinessCenterTime getValuationTime();
	/**
	 * The type of price quotations to be requested from dealers when determining the market value of the reference obligation for purposes of cash settlement. For example, Bid, Offer or Mid-market. ISDA 2003 Term: Quotation Method
	 */
	QuotationRateTypeEnum getQuotationMethod();
	/**
	 * In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the quotation amount specifies an upper limit to the outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount equal to the floating rate payer calculation amount. ISDA 2003 Term: Quotation Amount
	 */
	Money getQuotationAmount();
	/**
	 * In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the minimum quotation amount specifies a minimum intended threshold amount of outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount of the lower of either USD 1,000,000 (or its equivalent in the relevant obligation currency) or the quotation amount. ISDA 2003 Term: Minimum Quotation Amount
	 */
	Money getMinimumQuotationAmount();
	/**
	 * A dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement. ISDA 2003 Term: Dealer
	 */
	List<String> getDealer();
	/**
	 * The number of business days used in the determination of the cash settlement payment date. If a cash settlement amount is specified, the cash settlement payment date will be this number of business days following the calculation of the final price. If a cash settlement amount is not specified, the cash settlement payment date will be this number of business days after all conditions to settlement are satisfied. ISDA 2003 Term: Cash Settlement Date
	 */
	Integer getCashSettlementBusinessDays();
	FixedRecoveryModel getFixedRecoveryModel();
	/**
	 * Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and If Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.
	 */
	Boolean getFixedSettlement();
	/**
	 * Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest
	 */
	Boolean getAccruedInterest();
	/**
	 * The ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. (ISDA 2003 Term: Valuation Method). For example, Market, Highest etc.
	 */
	ValuationMethodEnum getValuationMethod();

	/*********************** Build Methods  ***********************/
	CashSettlementTerms build();
	
	CashSettlementTerms.CashSettlementTermsBuilder toBuilder();
	
	static CashSettlementTerms.CashSettlementTermsBuilder builder() {
		return new CashSettlementTerms.CashSettlementTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlementTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashSettlementTerms> getType() {
		return CashSettlementTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("valuationDate"), processor, ValuationDate.class, getValuationDate());
		processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.class, getValuationTime());
		processor.processBasic(path.newSubPath("quotationMethod"), QuotationRateTypeEnum.class, getQuotationMethod(), this);
		processRosetta(path.newSubPath("quotationAmount"), processor, Money.class, getQuotationAmount());
		processRosetta(path.newSubPath("minimumQuotationAmount"), processor, Money.class, getMinimumQuotationAmount());
		processor.processBasic(path.newSubPath("dealer"), String.class, getDealer(), this);
		processor.processBasic(path.newSubPath("cashSettlementBusinessDays"), Integer.class, getCashSettlementBusinessDays(), this);
		processRosetta(path.newSubPath("fixedRecoveryModel"), processor, FixedRecoveryModel.class, getFixedRecoveryModel());
		processor.processBasic(path.newSubPath("fixedSettlement"), Boolean.class, getFixedSettlement(), this);
		processor.processBasic(path.newSubPath("accruedInterest"), Boolean.class, getAccruedInterest(), this);
		processor.processBasic(path.newSubPath("valuationMethod"), ValuationMethodEnum.class, getValuationMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementTermsBuilder extends CashSettlementTerms, SettlementTerms.SettlementTermsBuilder {
		ValuationDate.ValuationDateBuilder getOrCreateValuationDate();
		ValuationDate.ValuationDateBuilder getValuationDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime();
		Money.MoneyBuilder getOrCreateQuotationAmount();
		Money.MoneyBuilder getQuotationAmount();
		Money.MoneyBuilder getOrCreateMinimumQuotationAmount();
		Money.MoneyBuilder getMinimumQuotationAmount();
		FixedRecoveryModel.FixedRecoveryModelBuilder getOrCreateFixedRecoveryModel();
		FixedRecoveryModel.FixedRecoveryModelBuilder getFixedRecoveryModel();
		CashSettlementTerms.CashSettlementTermsBuilder setSettlementCurrency(Currency settlementCurrency);
		CashSettlementTerms.CashSettlementTermsBuilder setId(String id);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationDate(ValuationDate valuationDate);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationTime(BusinessCenterTime valuationTime);
		CashSettlementTerms.CashSettlementTermsBuilder setQuotationMethod(QuotationRateTypeEnum quotationMethod);
		CashSettlementTerms.CashSettlementTermsBuilder setQuotationAmount(Money quotationAmount);
		CashSettlementTerms.CashSettlementTermsBuilder setMinimumQuotationAmount(Money minimumQuotationAmount);
		CashSettlementTerms.CashSettlementTermsBuilder addDealer(String dealer0);
		CashSettlementTerms.CashSettlementTermsBuilder addDealer(String dealer1, int _idx);
		CashSettlementTerms.CashSettlementTermsBuilder addDealer(List<String> dealer2);
		CashSettlementTerms.CashSettlementTermsBuilder setDealer(List<String> dealer3);
		CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementBusinessDays(Integer cashSettlementBusinessDays);
		CashSettlementTerms.CashSettlementTermsBuilder setFixedRecoveryModel(FixedRecoveryModel fixedRecoveryModel);
		CashSettlementTerms.CashSettlementTermsBuilder setFixedSettlement(Boolean fixedSettlement);
		CashSettlementTerms.CashSettlementTermsBuilder setAccruedInterest(Boolean accruedInterest);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationMethod(ValuationMethodEnum valuationMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("valuationDate"), processor, ValuationDate.ValuationDateBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getValuationTime());
			processor.processBasic(path.newSubPath("quotationMethod"), QuotationRateTypeEnum.class, getQuotationMethod(), this);
			processRosetta(path.newSubPath("quotationAmount"), processor, Money.MoneyBuilder.class, getQuotationAmount());
			processRosetta(path.newSubPath("minimumQuotationAmount"), processor, Money.MoneyBuilder.class, getMinimumQuotationAmount());
			processor.processBasic(path.newSubPath("dealer"), String.class, getDealer(), this);
			processor.processBasic(path.newSubPath("cashSettlementBusinessDays"), Integer.class, getCashSettlementBusinessDays(), this);
			processRosetta(path.newSubPath("fixedRecoveryModel"), processor, FixedRecoveryModel.FixedRecoveryModelBuilder.class, getFixedRecoveryModel());
			processor.processBasic(path.newSubPath("fixedSettlement"), Boolean.class, getFixedSettlement(), this);
			processor.processBasic(path.newSubPath("accruedInterest"), Boolean.class, getAccruedInterest(), this);
			processor.processBasic(path.newSubPath("valuationMethod"), ValuationMethodEnum.class, getValuationMethod(), this);
		}
		

		CashSettlementTerms.CashSettlementTermsBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlementTerms  ***********************/
	class CashSettlementTermsImpl extends SettlementTerms.SettlementTermsImpl implements CashSettlementTerms {
		private final ValuationDate valuationDate;
		private final BusinessCenterTime valuationTime;
		private final QuotationRateTypeEnum quotationMethod;
		private final Money quotationAmount;
		private final Money minimumQuotationAmount;
		private final List<String> dealer;
		private final Integer cashSettlementBusinessDays;
		private final FixedRecoveryModel fixedRecoveryModel;
		private final Boolean fixedSettlement;
		private final Boolean accruedInterest;
		private final ValuationMethodEnum valuationMethod;
		
		protected CashSettlementTermsImpl(CashSettlementTerms.CashSettlementTermsBuilder builder) {
			super(builder);
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.valuationTime = ofNullable(builder.getValuationTime()).map(f->f.build()).orElse(null);
			this.quotationMethod = builder.getQuotationMethod();
			this.quotationAmount = ofNullable(builder.getQuotationAmount()).map(f->f.build()).orElse(null);
			this.minimumQuotationAmount = ofNullable(builder.getMinimumQuotationAmount()).map(f->f.build()).orElse(null);
			this.dealer = ofNullable(builder.getDealer()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cashSettlementBusinessDays = builder.getCashSettlementBusinessDays();
			this.fixedRecoveryModel = ofNullable(builder.getFixedRecoveryModel()).map(f->f.build()).orElse(null);
			this.fixedSettlement = builder.getFixedSettlement();
			this.accruedInterest = builder.getAccruedInterest();
			this.valuationMethod = builder.getValuationMethod();
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public ValuationDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		public BusinessCenterTime getValuationTime() {
			return valuationTime;
		}
		
		@Override
		@RosettaAttribute("quotationMethod")
		public QuotationRateTypeEnum getQuotationMethod() {
			return quotationMethod;
		}
		
		@Override
		@RosettaAttribute("quotationAmount")
		public Money getQuotationAmount() {
			return quotationAmount;
		}
		
		@Override
		@RosettaAttribute("minimumQuotationAmount")
		public Money getMinimumQuotationAmount() {
			return minimumQuotationAmount;
		}
		
		@Override
		@RosettaAttribute("dealer")
		public List<String> getDealer() {
			return dealer;
		}
		
		@Override
		@RosettaAttribute("cashSettlementBusinessDays")
		public Integer getCashSettlementBusinessDays() {
			return cashSettlementBusinessDays;
		}
		
		@Override
		@RosettaAttribute("fixedRecoveryModel")
		public FixedRecoveryModel getFixedRecoveryModel() {
			return fixedRecoveryModel;
		}
		
		@Override
		@RosettaAttribute("fixedSettlement")
		public Boolean getFixedSettlement() {
			return fixedSettlement;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		public Boolean getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		public ValuationMethodEnum getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		public CashSettlementTerms build() {
			return this;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder toBuilder() {
			CashSettlementTerms.CashSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlementTerms.CashSettlementTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationTime()).ifPresent(builder::setValuationTime);
			ofNullable(getQuotationMethod()).ifPresent(builder::setQuotationMethod);
			ofNullable(getQuotationAmount()).ifPresent(builder::setQuotationAmount);
			ofNullable(getMinimumQuotationAmount()).ifPresent(builder::setMinimumQuotationAmount);
			ofNullable(getDealer()).ifPresent(builder::setDealer);
			ofNullable(getCashSettlementBusinessDays()).ifPresent(builder::setCashSettlementBusinessDays);
			ofNullable(getFixedRecoveryModel()).ifPresent(builder::setFixedRecoveryModel);
			ofNullable(getFixedSettlement()).ifPresent(builder::setFixedSettlement);
			ofNullable(getAccruedInterest()).ifPresent(builder::setAccruedInterest);
			ofNullable(getValuationMethod()).ifPresent(builder::setValuationMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(quotationMethod, _that.getQuotationMethod())) return false;
			if (!Objects.equals(quotationAmount, _that.getQuotationAmount())) return false;
			if (!Objects.equals(minimumQuotationAmount, _that.getMinimumQuotationAmount())) return false;
			if (!ListEquals.listEquals(dealer, _that.getDealer())) return false;
			if (!Objects.equals(cashSettlementBusinessDays, _that.getCashSettlementBusinessDays())) return false;
			if (!Objects.equals(fixedRecoveryModel, _that.getFixedRecoveryModel())) return false;
			if (!Objects.equals(fixedSettlement, _that.getFixedSettlement())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (quotationMethod != null ? quotationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotationAmount != null ? quotationAmount.hashCode() : 0);
			_result = 31 * _result + (minimumQuotationAmount != null ? minimumQuotationAmount.hashCode() : 0);
			_result = 31 * _result + (dealer != null ? dealer.hashCode() : 0);
			_result = 31 * _result + (cashSettlementBusinessDays != null ? cashSettlementBusinessDays.hashCode() : 0);
			_result = 31 * _result + (fixedRecoveryModel != null ? fixedRecoveryModel.hashCode() : 0);
			_result = 31 * _result + (fixedSettlement != null ? fixedSettlement.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementTerms {" +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"quotationMethod=" + this.quotationMethod + ", " +
				"quotationAmount=" + this.quotationAmount + ", " +
				"minimumQuotationAmount=" + this.minimumQuotationAmount + ", " +
				"dealer=" + this.dealer + ", " +
				"cashSettlementBusinessDays=" + this.cashSettlementBusinessDays + ", " +
				"fixedRecoveryModel=" + this.fixedRecoveryModel + ", " +
				"fixedSettlement=" + this.fixedSettlement + ", " +
				"accruedInterest=" + this.accruedInterest + ", " +
				"valuationMethod=" + this.valuationMethod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CashSettlementTerms  ***********************/
	class CashSettlementTermsBuilderImpl extends SettlementTerms.SettlementTermsBuilderImpl  implements CashSettlementTerms.CashSettlementTermsBuilder {
	
		protected ValuationDate.ValuationDateBuilder valuationDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder valuationTime;
		protected QuotationRateTypeEnum quotationMethod;
		protected Money.MoneyBuilder quotationAmount;
		protected Money.MoneyBuilder minimumQuotationAmount;
		protected List<String> dealer = new ArrayList<>();
		protected Integer cashSettlementBusinessDays;
		protected FixedRecoveryModel.FixedRecoveryModelBuilder fixedRecoveryModel;
		protected Boolean fixedSettlement;
		protected Boolean accruedInterest;
		protected ValuationMethodEnum valuationMethod;
	
		public CashSettlementTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("valuationDate")
		public ValuationDate.ValuationDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder getOrCreateValuationDate() {
			ValuationDate.ValuationDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = ValuationDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (valuationTime!=null) {
				result = valuationTime;
			}
			else {
				result = valuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationMethod")
		public QuotationRateTypeEnum getQuotationMethod() {
			return quotationMethod;
		}
		
		@Override
		@RosettaAttribute("quotationAmount")
		public Money.MoneyBuilder getQuotationAmount() {
			return quotationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateQuotationAmount() {
			Money.MoneyBuilder result;
			if (quotationAmount!=null) {
				result = quotationAmount;
			}
			else {
				result = quotationAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumQuotationAmount")
		public Money.MoneyBuilder getMinimumQuotationAmount() {
			return minimumQuotationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumQuotationAmount() {
			Money.MoneyBuilder result;
			if (minimumQuotationAmount!=null) {
				result = minimumQuotationAmount;
			}
			else {
				result = minimumQuotationAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealer")
		public List<String> getDealer() {
			return dealer;
		}
		
		@Override
		@RosettaAttribute("cashSettlementBusinessDays")
		public Integer getCashSettlementBusinessDays() {
			return cashSettlementBusinessDays;
		}
		
		@Override
		@RosettaAttribute("fixedRecoveryModel")
		public FixedRecoveryModel.FixedRecoveryModelBuilder getFixedRecoveryModel() {
			return fixedRecoveryModel;
		}
		
		@Override
		public FixedRecoveryModel.FixedRecoveryModelBuilder getOrCreateFixedRecoveryModel() {
			FixedRecoveryModel.FixedRecoveryModelBuilder result;
			if (fixedRecoveryModel!=null) {
				result = fixedRecoveryModel;
			}
			else {
				result = fixedRecoveryModel = FixedRecoveryModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedSettlement")
		public Boolean getFixedSettlement() {
			return fixedSettlement;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		public Boolean getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		public ValuationMethodEnum getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public CashSettlementTerms.CashSettlementTermsBuilder setSettlementCurrency(Currency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CashSettlementTerms.CashSettlementTermsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("valuationDate")
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationDate(ValuationDate valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationTime")
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationTime(BusinessCenterTime valuationTime) {
			this.valuationTime = valuationTime==null?null:valuationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotationMethod")
		public CashSettlementTerms.CashSettlementTermsBuilder setQuotationMethod(QuotationRateTypeEnum quotationMethod) {
			this.quotationMethod = quotationMethod==null?null:quotationMethod;
			return this;
		}
		@Override
		@RosettaAttribute("quotationAmount")
		public CashSettlementTerms.CashSettlementTermsBuilder setQuotationAmount(Money quotationAmount) {
			this.quotationAmount = quotationAmount==null?null:quotationAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("minimumQuotationAmount")
		public CashSettlementTerms.CashSettlementTermsBuilder setMinimumQuotationAmount(Money minimumQuotationAmount) {
			this.minimumQuotationAmount = minimumQuotationAmount==null?null:minimumQuotationAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dealer")
		public CashSettlementTerms.CashSettlementTermsBuilder addDealer(String dealer) {
			if (dealer!=null) this.dealer.add(dealer);
			return this;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder addDealer(String dealer, int _idx) {
			getIndex(this.dealer, _idx, () -> dealer);
			return this;
		}
		@Override 
		public CashSettlementTerms.CashSettlementTermsBuilder addDealer(List<String> dealers) {
			if (dealers != null) {
				for (String toAdd : dealers) {
					this.dealer.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public CashSettlementTerms.CashSettlementTermsBuilder setDealer(List<String> dealers) {
			if (dealers == null)  {
				this.dealer = new ArrayList<>();
			}
			else {
				this.dealer = dealers.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("cashSettlementBusinessDays")
		public CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementBusinessDays(Integer cashSettlementBusinessDays) {
			this.cashSettlementBusinessDays = cashSettlementBusinessDays==null?null:cashSettlementBusinessDays;
			return this;
		}
		@Override
		@RosettaAttribute("fixedRecoveryModel")
		public CashSettlementTerms.CashSettlementTermsBuilder setFixedRecoveryModel(FixedRecoveryModel fixedRecoveryModel) {
			this.fixedRecoveryModel = fixedRecoveryModel==null?null:fixedRecoveryModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedSettlement")
		public CashSettlementTerms.CashSettlementTermsBuilder setFixedSettlement(Boolean fixedSettlement) {
			this.fixedSettlement = fixedSettlement==null?null:fixedSettlement;
			return this;
		}
		@Override
		@RosettaAttribute("accruedInterest")
		public CashSettlementTerms.CashSettlementTermsBuilder setAccruedInterest(Boolean accruedInterest) {
			this.accruedInterest = accruedInterest==null?null:accruedInterest;
			return this;
		}
		@Override
		@RosettaAttribute("valuationMethod")
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationMethod(ValuationMethodEnum valuationMethod) {
			this.valuationMethod = valuationMethod==null?null:valuationMethod;
			return this;
		}
		
		@Override
		public CashSettlementTerms build() {
			return new CashSettlementTerms.CashSettlementTermsImpl(this);
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder prune() {
			super.prune();
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (valuationTime!=null && !valuationTime.prune().hasData()) valuationTime = null;
			if (quotationAmount!=null && !quotationAmount.prune().hasData()) quotationAmount = null;
			if (minimumQuotationAmount!=null && !minimumQuotationAmount.prune().hasData()) minimumQuotationAmount = null;
			if (fixedRecoveryModel!=null && !fixedRecoveryModel.prune().hasData()) fixedRecoveryModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getValuationTime()!=null && getValuationTime().hasData()) return true;
			if (getQuotationMethod()!=null) return true;
			if (getQuotationAmount()!=null && getQuotationAmount().hasData()) return true;
			if (getMinimumQuotationAmount()!=null && getMinimumQuotationAmount().hasData()) return true;
			if (getDealer()!=null && !getDealer().isEmpty()) return true;
			if (getCashSettlementBusinessDays()!=null) return true;
			if (getFixedRecoveryModel()!=null && getFixedRecoveryModel().hasData()) return true;
			if (getFixedSettlement()!=null) return true;
			if (getAccruedInterest()!=null) return true;
			if (getValuationMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CashSettlementTerms.CashSettlementTermsBuilder o = (CashSettlementTerms.CashSettlementTermsBuilder) other;
			
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getValuationTime(), o.getValuationTime(), this::setValuationTime);
			merger.mergeRosetta(getQuotationAmount(), o.getQuotationAmount(), this::setQuotationAmount);
			merger.mergeRosetta(getMinimumQuotationAmount(), o.getMinimumQuotationAmount(), this::setMinimumQuotationAmount);
			merger.mergeRosetta(getFixedRecoveryModel(), o.getFixedRecoveryModel(), this::setFixedRecoveryModel);
			
			merger.mergeBasic(getQuotationMethod(), o.getQuotationMethod(), this::setQuotationMethod);
			merger.mergeBasic(getDealer(), o.getDealer(), (Consumer<String>) this::addDealer);
			merger.mergeBasic(getCashSettlementBusinessDays(), o.getCashSettlementBusinessDays(), this::setCashSettlementBusinessDays);
			merger.mergeBasic(getFixedSettlement(), o.getFixedSettlement(), this::setFixedSettlement);
			merger.mergeBasic(getAccruedInterest(), o.getAccruedInterest(), this::setAccruedInterest);
			merger.mergeBasic(getValuationMethod(), o.getValuationMethod(), this::setValuationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(quotationMethod, _that.getQuotationMethod())) return false;
			if (!Objects.equals(quotationAmount, _that.getQuotationAmount())) return false;
			if (!Objects.equals(minimumQuotationAmount, _that.getMinimumQuotationAmount())) return false;
			if (!ListEquals.listEquals(dealer, _that.getDealer())) return false;
			if (!Objects.equals(cashSettlementBusinessDays, _that.getCashSettlementBusinessDays())) return false;
			if (!Objects.equals(fixedRecoveryModel, _that.getFixedRecoveryModel())) return false;
			if (!Objects.equals(fixedSettlement, _that.getFixedSettlement())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (quotationMethod != null ? quotationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotationAmount != null ? quotationAmount.hashCode() : 0);
			_result = 31 * _result + (minimumQuotationAmount != null ? minimumQuotationAmount.hashCode() : 0);
			_result = 31 * _result + (dealer != null ? dealer.hashCode() : 0);
			_result = 31 * _result + (cashSettlementBusinessDays != null ? cashSettlementBusinessDays.hashCode() : 0);
			_result = 31 * _result + (fixedRecoveryModel != null ? fixedRecoveryModel.hashCode() : 0);
			_result = 31 * _result + (fixedSettlement != null ? fixedSettlement.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementTermsBuilder {" +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"quotationMethod=" + this.quotationMethod + ", " +
				"quotationAmount=" + this.quotationAmount + ", " +
				"minimumQuotationAmount=" + this.minimumQuotationAmount + ", " +
				"dealer=" + this.dealer + ", " +
				"cashSettlementBusinessDays=" + this.cashSettlementBusinessDays + ", " +
				"fixedRecoveryModel=" + this.fixedRecoveryModel + ", " +
				"fixedSettlement=" + this.fixedSettlement + ", " +
				"accruedInterest=" + this.accruedInterest + ", " +
				"valuationMethod=" + this.valuationMethod +
			'}' + " " + super.toString();
		}
	}
}
