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
import fpml.confirmation.CashSettlementReferenceBanks;
import fpml.confirmation.CrossCurrencyMethod;
import fpml.confirmation.CrossCurrencyMethod.CrossCurrencyMethodBuilder;
import fpml.confirmation.CrossCurrencyMethod.CrossCurrencyMethodBuilderImpl;
import fpml.confirmation.CrossCurrencyMethod.CrossCurrencyMethodImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.QuotationRateTypeEnum;
import fpml.confirmation.meta.CrossCurrencyMethodMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CrossCurrencyMethod", builder=CrossCurrencyMethod.CrossCurrencyMethodBuilderImpl.class, version="${project.version}")
public interface CrossCurrencyMethod extends RosettaModelObject {

	CrossCurrencyMethodMeta metaData = new CrossCurrencyMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A container for a set of reference institutions. These reference institutions may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
	 */
	CashSettlementReferenceBanks getCashSettlementReferenceBanks();
	/**
	 * The currency, or currencies, in which the cash settlement amount(s) will be calculated and settled. While the order in which the currencies are stated is unimportant, the cash settlement currency or currencies must correspond to one or both of the constituent currencies of the swap transaction.
	 */
	List<? extends Currency> getCashSettlementCurrency();
	/**
	 * Which rate quote is to be observed, either Bid, Mid, Offer or Exercising Party Pays. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j)
	 */
	QuotationRateTypeEnum getQuotationRateType();

	/*********************** Build Methods  ***********************/
	CrossCurrencyMethod build();
	
	CrossCurrencyMethod.CrossCurrencyMethodBuilder toBuilder();
	
	static CrossCurrencyMethod.CrossCurrencyMethodBuilder builder() {
		return new CrossCurrencyMethod.CrossCurrencyMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CrossCurrencyMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CrossCurrencyMethod> getType() {
		return CrossCurrencyMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.class, getCashSettlementReferenceBanks());
		processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.class, getCashSettlementCurrency());
		processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CrossCurrencyMethodBuilder extends CrossCurrencyMethod, RosettaModelObjectBuilder {
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks();
		Currency.CurrencyBuilder getOrCreateCashSettlementCurrency(int _index);
		List<? extends Currency.CurrencyBuilder> getCashSettlementCurrency();
		CrossCurrencyMethod.CrossCurrencyMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks);
		CrossCurrencyMethod.CrossCurrencyMethodBuilder addCashSettlementCurrency(Currency cashSettlementCurrency0);
		CrossCurrencyMethod.CrossCurrencyMethodBuilder addCashSettlementCurrency(Currency cashSettlementCurrency1, int _idx);
		CrossCurrencyMethod.CrossCurrencyMethodBuilder addCashSettlementCurrency(List<? extends Currency> cashSettlementCurrency2);
		CrossCurrencyMethod.CrossCurrencyMethodBuilder setCashSettlementCurrency(List<? extends Currency> cashSettlementCurrency3);
		CrossCurrencyMethod.CrossCurrencyMethodBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder.class, getCashSettlementReferenceBanks());
			processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.CurrencyBuilder.class, getCashSettlementCurrency());
			processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
		}
		

		CrossCurrencyMethod.CrossCurrencyMethodBuilder prune();
	}

	/*********************** Immutable Implementation of CrossCurrencyMethod  ***********************/
	class CrossCurrencyMethodImpl implements CrossCurrencyMethod {
		private final CashSettlementReferenceBanks cashSettlementReferenceBanks;
		private final List<? extends Currency> cashSettlementCurrency;
		private final QuotationRateTypeEnum quotationRateType;
		
		protected CrossCurrencyMethodImpl(CrossCurrencyMethod.CrossCurrencyMethodBuilder builder) {
			this.cashSettlementReferenceBanks = ofNullable(builder.getCashSettlementReferenceBanks()).map(f->f.build()).orElse(null);
			this.cashSettlementCurrency = ofNullable(builder.getCashSettlementCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.quotationRateType = builder.getQuotationRateType();
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		public List<? extends Currency> getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		public CrossCurrencyMethod build() {
			return this;
		}
		
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder toBuilder() {
			CrossCurrencyMethod.CrossCurrencyMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CrossCurrencyMethod.CrossCurrencyMethodBuilder builder) {
			ofNullable(getCashSettlementReferenceBanks()).ifPresent(builder::setCashSettlementReferenceBanks);
			ofNullable(getCashSettlementCurrency()).ifPresent(builder::setCashSettlementCurrency);
			ofNullable(getQuotationRateType()).ifPresent(builder::setQuotationRateType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CrossCurrencyMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!ListEquals.listEquals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
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
			return "CrossCurrencyMethod {" +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}

	/*********************** Builder Implementation of CrossCurrencyMethod  ***********************/
	class CrossCurrencyMethodBuilderImpl implements CrossCurrencyMethod.CrossCurrencyMethodBuilder {
	
		protected CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder cashSettlementReferenceBanks;
		protected List<Currency.CurrencyBuilder> cashSettlementCurrency = new ArrayList<>();
		protected QuotationRateTypeEnum quotationRateType;
	
		public CrossCurrencyMethodBuilderImpl() {
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
		public List<? extends Currency.CurrencyBuilder> getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		public Currency.CurrencyBuilder getOrCreateCashSettlementCurrency(int _index) {
		
			if (cashSettlementCurrency==null) {
				this.cashSettlementCurrency = new ArrayList<>();
			}
			Currency.CurrencyBuilder result;
			return getIndex(cashSettlementCurrency, _index, () -> {
						Currency.CurrencyBuilder newCashSettlementCurrency = Currency.builder();
						return newCashSettlementCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks) {
			this.cashSettlementReferenceBanks = cashSettlementReferenceBanks==null?null:cashSettlementReferenceBanks.toBuilder();
			return this;
		}
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder addCashSettlementCurrency(Currency cashSettlementCurrency) {
			if (cashSettlementCurrency!=null) this.cashSettlementCurrency.add(cashSettlementCurrency.toBuilder());
			return this;
		}
		
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder addCashSettlementCurrency(Currency cashSettlementCurrency, int _idx) {
			getIndex(this.cashSettlementCurrency, _idx, () -> cashSettlementCurrency.toBuilder());
			return this;
		}
		@Override 
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder addCashSettlementCurrency(List<? extends Currency> cashSettlementCurrencys) {
			if (cashSettlementCurrencys != null) {
				for (Currency toAdd : cashSettlementCurrencys) {
					this.cashSettlementCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("cashSettlementCurrency")
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder setCashSettlementCurrency(List<? extends Currency> cashSettlementCurrencys) {
			if (cashSettlementCurrencys == null)  {
				this.cashSettlementCurrency = new ArrayList<>();
			}
			else {
				this.cashSettlementCurrency = cashSettlementCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType) {
			this.quotationRateType = quotationRateType==null?null:quotationRateType;
			return this;
		}
		
		@Override
		public CrossCurrencyMethod build() {
			return new CrossCurrencyMethod.CrossCurrencyMethodImpl(this);
		}
		
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder prune() {
			if (cashSettlementReferenceBanks!=null && !cashSettlementReferenceBanks.prune().hasData()) cashSettlementReferenceBanks = null;
			cashSettlementCurrency = cashSettlementCurrency.stream().filter(b->b!=null).<Currency.CurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementReferenceBanks()!=null && getCashSettlementReferenceBanks().hasData()) return true;
			if (getCashSettlementCurrency()!=null && getCashSettlementCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getQuotationRateType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CrossCurrencyMethod.CrossCurrencyMethodBuilder o = (CrossCurrencyMethod.CrossCurrencyMethodBuilder) other;
			
			merger.mergeRosetta(getCashSettlementReferenceBanks(), o.getCashSettlementReferenceBanks(), this::setCashSettlementReferenceBanks);
			merger.mergeRosetta(getCashSettlementCurrency(), o.getCashSettlementCurrency(), this::getOrCreateCashSettlementCurrency);
			
			merger.mergeBasic(getQuotationRateType(), o.getQuotationRateType(), this::setQuotationRateType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CrossCurrencyMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!ListEquals.listEquals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
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
			return "CrossCurrencyMethodBuilder {" +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}
}
