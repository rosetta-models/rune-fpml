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
import fpml.confirmation.CashPriceMethod;
import fpml.confirmation.CashPriceMethod.CashPriceMethodBuilder;
import fpml.confirmation.CashPriceMethod.CashPriceMethodBuilderImpl;
import fpml.confirmation.CashPriceMethod.CashPriceMethodImpl;
import fpml.confirmation.CashSettlementReferenceBanks;
import fpml.confirmation.Currency;
import fpml.confirmation.QuotationRateTypeEnum;
import fpml.confirmation.meta.CashPriceMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the parameters necessary for each of the ISDA cash price methods for cash settlement.
 * @version ${project.version}
 */
@RosettaDataType(value="CashPriceMethod", builder=CashPriceMethod.CashPriceMethodBuilderImpl.class, version="${project.version}")
public interface CashPriceMethod extends RosettaModelObject {

	CashPriceMethodMeta metaData = new CashPriceMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A container for a set of reference institutions. These reference institutions may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
	 */
	CashSettlementReferenceBanks getCashSettlementReferenceBanks();
	/**
	 * The currency in which the cash settlement amount will be calculated and settled.
	 */
	Currency getCashSettlementCurrency();
	/**
	 * Which rate quote is to be observed, either Bid, Mid, Offer or Exercising Party Pays. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j)
	 */
	QuotationRateTypeEnum getQuotationRateType();

	/*********************** Build Methods  ***********************/
	CashPriceMethod build();
	
	CashPriceMethod.CashPriceMethodBuilder toBuilder();
	
	static CashPriceMethod.CashPriceMethodBuilder builder() {
		return new CashPriceMethod.CashPriceMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashPriceMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashPriceMethod> getType() {
		return CashPriceMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.class, getCashSettlementReferenceBanks());
		processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.class, getCashSettlementCurrency());
		processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashPriceMethodBuilder extends CashPriceMethod, RosettaModelObjectBuilder {
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks();
		Currency.CurrencyBuilder getOrCreateCashSettlementCurrency();
		Currency.CurrencyBuilder getCashSettlementCurrency();
		CashPriceMethod.CashPriceMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks);
		CashPriceMethod.CashPriceMethodBuilder setCashSettlementCurrency(Currency cashSettlementCurrency);
		CashPriceMethod.CashPriceMethodBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder.class, getCashSettlementReferenceBanks());
			processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.CurrencyBuilder.class, getCashSettlementCurrency());
			processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
		}
		

		CashPriceMethod.CashPriceMethodBuilder prune();
	}

	/*********************** Immutable Implementation of CashPriceMethod  ***********************/
	class CashPriceMethodImpl implements CashPriceMethod {
		private final CashSettlementReferenceBanks cashSettlementReferenceBanks;
		private final Currency cashSettlementCurrency;
		private final QuotationRateTypeEnum quotationRateType;
		
		protected CashPriceMethodImpl(CashPriceMethod.CashPriceMethodBuilder builder) {
			this.cashSettlementReferenceBanks = ofNullable(builder.getCashSettlementReferenceBanks()).map(f->f.build()).orElse(null);
			this.cashSettlementCurrency = ofNullable(builder.getCashSettlementCurrency()).map(f->f.build()).orElse(null);
			this.quotationRateType = builder.getQuotationRateType();
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		public Currency getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		public CashPriceMethod build() {
			return this;
		}
		
		@Override
		public CashPriceMethod.CashPriceMethodBuilder toBuilder() {
			CashPriceMethod.CashPriceMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashPriceMethod.CashPriceMethodBuilder builder) {
			ofNullable(getCashSettlementReferenceBanks()).ifPresent(builder::setCashSettlementReferenceBanks);
			ofNullable(getCashSettlementCurrency()).ifPresent(builder::setCashSettlementCurrency);
			ofNullable(getQuotationRateType()).ifPresent(builder::setQuotationRateType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashPriceMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!Objects.equals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashPriceMethod {" +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}

	/*********************** Builder Implementation of CashPriceMethod  ***********************/
	class CashPriceMethodBuilderImpl implements CashPriceMethod.CashPriceMethodBuilder {
	
		protected CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder cashSettlementReferenceBanks;
		protected Currency.CurrencyBuilder cashSettlementCurrency;
		protected QuotationRateTypeEnum quotationRateType;
	
		public CashPriceMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks() {
			CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder result;
			if (cashSettlementReferenceBanks!=null) {
				result = cashSettlementReferenceBanks;
			}
			else {
				result = cashSettlementReferenceBanks = CashSettlementReferenceBanks.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		public Currency.CurrencyBuilder getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCashSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (cashSettlementCurrency!=null) {
				result = cashSettlementCurrency;
			}
			else {
				result = cashSettlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public CashPriceMethod.CashPriceMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks) {
			this.cashSettlementReferenceBanks = cashSettlementReferenceBanks==null?null:cashSettlementReferenceBanks.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		public CashPriceMethod.CashPriceMethodBuilder setCashSettlementCurrency(Currency cashSettlementCurrency) {
			this.cashSettlementCurrency = cashSettlementCurrency==null?null:cashSettlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotationRateType")
		public CashPriceMethod.CashPriceMethodBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType) {
			this.quotationRateType = quotationRateType==null?null:quotationRateType;
			return this;
		}
		
		@Override
		public CashPriceMethod build() {
			return new CashPriceMethod.CashPriceMethodImpl(this);
		}
		
		@Override
		public CashPriceMethod.CashPriceMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashPriceMethod.CashPriceMethodBuilder prune() {
			if (cashSettlementReferenceBanks!=null && !cashSettlementReferenceBanks.prune().hasData()) cashSettlementReferenceBanks = null;
			if (cashSettlementCurrency!=null && !cashSettlementCurrency.prune().hasData()) cashSettlementCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementReferenceBanks()!=null && getCashSettlementReferenceBanks().hasData()) return true;
			if (getCashSettlementCurrency()!=null && getCashSettlementCurrency().hasData()) return true;
			if (getQuotationRateType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashPriceMethod.CashPriceMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashPriceMethod.CashPriceMethodBuilder o = (CashPriceMethod.CashPriceMethodBuilder) other;
			
			merger.mergeRosetta(getCashSettlementReferenceBanks(), o.getCashSettlementReferenceBanks(), this::setCashSettlementReferenceBanks);
			merger.mergeRosetta(getCashSettlementCurrency(), o.getCashSettlementCurrency(), this::setCashSettlementCurrency);
			
			merger.mergeBasic(getQuotationRateType(), o.getQuotationRateType(), this::setQuotationRateType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashPriceMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!Objects.equals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashPriceMethodBuilder {" +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}
}
