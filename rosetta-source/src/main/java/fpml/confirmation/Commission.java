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
import fpml.confirmation.Commission;
import fpml.confirmation.Commission.CommissionBuilder;
import fpml.confirmation.Commission.CommissionBuilderImpl;
import fpml.confirmation.Commission.CommissionImpl;
import fpml.confirmation.CommissionDenominationEnum;
import fpml.confirmation.Currency;
import fpml.confirmation.FxRate;
import fpml.confirmation.meta.CommissionMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing the commission that will be charged for each of the hedge transactions.
 * @version ${project.version}
 */
@RosettaDataType(value="Commission", builder=Commission.CommissionBuilderImpl.class, version="${project.version}")
public interface Commission extends RosettaModelObject {

	CommissionMeta metaData = new CommissionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of units used to express a commission.
	 */
	CommissionDenominationEnum getCommissionDenomination();
	/**
	 * The commission amount, expressed in the way indicated by the commissionType element.
	 */
	BigDecimal getCommissionAmount();
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();
	/**
	 * The total commission per trade.
	 */
	BigDecimal getCommissionPerTrade();
	/**
	 * FX Rates that have been used to convert commissions to a single currency.
	 */
	List<? extends FxRate> getFxRate();

	/*********************** Build Methods  ***********************/
	Commission build();
	
	Commission.CommissionBuilder toBuilder();
	
	static Commission.CommissionBuilder builder() {
		return new Commission.CommissionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Commission> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Commission> getType() {
		return Commission.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("commissionDenomination"), CommissionDenominationEnum.class, getCommissionDenomination(), this);
		processor.processBasic(path.newSubPath("commissionAmount"), BigDecimal.class, getCommissionAmount(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("commissionPerTrade"), BigDecimal.class, getCommissionPerTrade(), this);
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommissionBuilder extends Commission, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		FxRate.FxRateBuilder getOrCreateFxRate(int _index);
		List<? extends FxRate.FxRateBuilder> getFxRate();
		Commission.CommissionBuilder setCommissionDenomination(CommissionDenominationEnum commissionDenomination);
		Commission.CommissionBuilder setCommissionAmount(BigDecimal commissionAmount);
		Commission.CommissionBuilder setCurrency(Currency currency);
		Commission.CommissionBuilder setCommissionPerTrade(BigDecimal commissionPerTrade);
		Commission.CommissionBuilder addFxRate(FxRate fxRate0);
		Commission.CommissionBuilder addFxRate(FxRate fxRate1, int _idx);
		Commission.CommissionBuilder addFxRate(List<? extends FxRate> fxRate2);
		Commission.CommissionBuilder setFxRate(List<? extends FxRate> fxRate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("commissionDenomination"), CommissionDenominationEnum.class, getCommissionDenomination(), this);
			processor.processBasic(path.newSubPath("commissionAmount"), BigDecimal.class, getCommissionAmount(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("commissionPerTrade"), BigDecimal.class, getCommissionPerTrade(), this);
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
		}
		

		Commission.CommissionBuilder prune();
	}

	/*********************** Immutable Implementation of Commission  ***********************/
	class CommissionImpl implements Commission {
		private final CommissionDenominationEnum commissionDenomination;
		private final BigDecimal commissionAmount;
		private final Currency currency;
		private final BigDecimal commissionPerTrade;
		private final List<? extends FxRate> fxRate;
		
		protected CommissionImpl(Commission.CommissionBuilder builder) {
			this.commissionDenomination = builder.getCommissionDenomination();
			this.commissionAmount = builder.getCommissionAmount();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.commissionPerTrade = builder.getCommissionPerTrade();
			this.fxRate = ofNullable(builder.getFxRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commissionDenomination")
		public CommissionDenominationEnum getCommissionDenomination() {
			return commissionDenomination;
		}
		
		@Override
		@RosettaAttribute("commissionAmount")
		public BigDecimal getCommissionAmount() {
			return commissionAmount;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("commissionPerTrade")
		public BigDecimal getCommissionPerTrade() {
			return commissionPerTrade;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public List<? extends FxRate> getFxRate() {
			return fxRate;
		}
		
		@Override
		public Commission build() {
			return this;
		}
		
		@Override
		public Commission.CommissionBuilder toBuilder() {
			Commission.CommissionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Commission.CommissionBuilder builder) {
			ofNullable(getCommissionDenomination()).ifPresent(builder::setCommissionDenomination);
			ofNullable(getCommissionAmount()).ifPresent(builder::setCommissionAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getCommissionPerTrade()).ifPresent(builder::setCommissionPerTrade);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Commission _that = getType().cast(o);
		
			if (!Objects.equals(commissionDenomination, _that.getCommissionDenomination())) return false;
			if (!Objects.equals(commissionAmount, _that.getCommissionAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(commissionPerTrade, _that.getCommissionPerTrade())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commissionDenomination != null ? commissionDenomination.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commissionAmount != null ? commissionAmount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (commissionPerTrade != null ? commissionPerTrade.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Commission {" +
				"commissionDenomination=" + this.commissionDenomination + ", " +
				"commissionAmount=" + this.commissionAmount + ", " +
				"currency=" + this.currency + ", " +
				"commissionPerTrade=" + this.commissionPerTrade + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}

	/*********************** Builder Implementation of Commission  ***********************/
	class CommissionBuilderImpl implements Commission.CommissionBuilder {
	
		protected CommissionDenominationEnum commissionDenomination;
		protected BigDecimal commissionAmount;
		protected Currency.CurrencyBuilder currency;
		protected BigDecimal commissionPerTrade;
		protected List<FxRate.FxRateBuilder> fxRate = new ArrayList<>();
	
		public CommissionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commissionDenomination")
		public CommissionDenominationEnum getCommissionDenomination() {
			return commissionDenomination;
		}
		
		@Override
		@RosettaAttribute("commissionAmount")
		public BigDecimal getCommissionAmount() {
			return commissionAmount;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commissionPerTrade")
		public BigDecimal getCommissionPerTrade() {
			return commissionPerTrade;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public List<? extends FxRate.FxRateBuilder> getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxRate.FxRateBuilder getOrCreateFxRate(int _index) {
		
			if (fxRate==null) {
				this.fxRate = new ArrayList<>();
			}
			FxRate.FxRateBuilder result;
			return getIndex(fxRate, _index, () -> {
						FxRate.FxRateBuilder newFxRate = FxRate.builder();
						return newFxRate;
					});
		}
		
		@Override
		@RosettaAttribute("commissionDenomination")
		public Commission.CommissionBuilder setCommissionDenomination(CommissionDenominationEnum commissionDenomination) {
			this.commissionDenomination = commissionDenomination==null?null:commissionDenomination;
			return this;
		}
		@Override
		@RosettaAttribute("commissionAmount")
		public Commission.CommissionBuilder setCommissionAmount(BigDecimal commissionAmount) {
			this.commissionAmount = commissionAmount==null?null:commissionAmount;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Commission.CommissionBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commissionPerTrade")
		public Commission.CommissionBuilder setCommissionPerTrade(BigDecimal commissionPerTrade) {
			this.commissionPerTrade = commissionPerTrade==null?null:commissionPerTrade;
			return this;
		}
		@Override
		@RosettaAttribute("fxRate")
		public Commission.CommissionBuilder addFxRate(FxRate fxRate) {
			if (fxRate!=null) this.fxRate.add(fxRate.toBuilder());
			return this;
		}
		
		@Override
		public Commission.CommissionBuilder addFxRate(FxRate fxRate, int _idx) {
			getIndex(this.fxRate, _idx, () -> fxRate.toBuilder());
			return this;
		}
		@Override 
		public Commission.CommissionBuilder addFxRate(List<? extends FxRate> fxRates) {
			if (fxRates != null) {
				for (FxRate toAdd : fxRates) {
					this.fxRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Commission.CommissionBuilder setFxRate(List<? extends FxRate> fxRates) {
			if (fxRates == null)  {
				this.fxRate = new ArrayList<>();
			}
			else {
				this.fxRate = fxRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Commission build() {
			return new Commission.CommissionImpl(this);
		}
		
		@Override
		public Commission.CommissionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commission.CommissionBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			fxRate = fxRate.stream().filter(b->b!=null).<FxRate.FxRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommissionDenomination()!=null) return true;
			if (getCommissionAmount()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getCommissionPerTrade()!=null) return true;
			if (getFxRate()!=null && getFxRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commission.CommissionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Commission.CommissionBuilder o = (Commission.CommissionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::getOrCreateFxRate);
			
			merger.mergeBasic(getCommissionDenomination(), o.getCommissionDenomination(), this::setCommissionDenomination);
			merger.mergeBasic(getCommissionAmount(), o.getCommissionAmount(), this::setCommissionAmount);
			merger.mergeBasic(getCommissionPerTrade(), o.getCommissionPerTrade(), this::setCommissionPerTrade);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Commission _that = getType().cast(o);
		
			if (!Objects.equals(commissionDenomination, _that.getCommissionDenomination())) return false;
			if (!Objects.equals(commissionAmount, _that.getCommissionAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(commissionPerTrade, _that.getCommissionPerTrade())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commissionDenomination != null ? commissionDenomination.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commissionAmount != null ? commissionAmount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (commissionPerTrade != null ? commissionPerTrade.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommissionBuilder {" +
				"commissionDenomination=" + this.commissionDenomination + ", " +
				"commissionAmount=" + this.commissionAmount + ", " +
				"currency=" + this.currency + ", " +
				"commissionPerTrade=" + this.commissionPerTrade + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}
}
