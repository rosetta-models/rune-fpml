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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.Currency;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.FxCashSettlement.FxCashSettlementBuilder;
import fpml.confirmation.FxCashSettlement.FxCashSettlementBuilderImpl;
import fpml.confirmation.FxCashSettlement.FxCashSettlementImpl;
import fpml.confirmation.FxFixing;
import fpml.confirmation.FxRateSourceFixing;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.meta.FxCashSettlementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that is used for describing cash settlement of an option / non deliverable forward. It includes the currency to settle into together with the fixings required to calculate the currency amount.
 * @version ${project.version}
 */
@RosettaDataType(value="FxCashSettlement", builder=FxCashSettlement.FxCashSettlementBuilderImpl.class, version="${project.version}")
public interface FxCashSettlement extends RosettaModelObject {

	FxCashSettlementMeta metaData = new FxCashSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which cash settlement occurs for non-deliverable forwards and cash-settled options (non-deliverable or otherwise).
	 */
	Currency getSettlementCurrency();
	Currency getReferenceCurrency();
	/**
	 * The amount of money that the settlement will be derived from.
	 */
	PositiveMoney getNotionalAmount();
	/**
	 * Specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate. This element is optional, permitting it to be omitted where fixing details are unavailable at the point of message creation. It has multiple occurrence to support the case where fixing details must be specified for more than one currency pair e.g. on an option settled into a third currency (that is not one of the option currencies).
	 */
	List<? extends FxFixing> getFixing();
	/**
	 * Specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate. This element is optional, permitting it to be omitted where fixing details are unavailable at the point of message creation. It has multiple occurrence to support the case where fixing details must be specified for more than one currency pair e.g. on an option settled into a third currency (that is not one of the option currencies).
	 */
	List<? extends FxRateSourceFixing> getRateSourceFixing();
	/**
	 * The date on which settlement is scheduled to occur
	 */
	AdjustableDate getSettlementDate();

	/*********************** Build Methods  ***********************/
	FxCashSettlement build();
	
	FxCashSettlement.FxCashSettlementBuilder toBuilder();
	
	static FxCashSettlement.FxCashSettlementBuilder builder() {
		return new FxCashSettlement.FxCashSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCashSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCashSettlement> getType() {
		return FxCashSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.class, getReferenceCurrency());
		processRosetta(path.newSubPath("notionalAmount"), processor, PositiveMoney.class, getNotionalAmount());
		processRosetta(path.newSubPath("fixing"), processor, FxFixing.class, getFixing());
		processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.class, getRateSourceFixing());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableDate.class, getSettlementDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCashSettlementBuilder extends FxCashSettlement, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		Currency.CurrencyBuilder getSettlementCurrency();
		Currency.CurrencyBuilder getOrCreateReferenceCurrency();
		Currency.CurrencyBuilder getReferenceCurrency();
		PositiveMoney.PositiveMoneyBuilder getOrCreateNotionalAmount();
		PositiveMoney.PositiveMoneyBuilder getNotionalAmount();
		FxFixing.FxFixingBuilder getOrCreateFixing(int _index);
		List<? extends FxFixing.FxFixingBuilder> getFixing();
		FxRateSourceFixing.FxRateSourceFixingBuilder getOrCreateRateSourceFixing(int _index);
		List<? extends FxRateSourceFixing.FxRateSourceFixingBuilder> getRateSourceFixing();
		AdjustableDate.AdjustableDateBuilder getOrCreateSettlementDate();
		AdjustableDate.AdjustableDateBuilder getSettlementDate();
		FxCashSettlement.FxCashSettlementBuilder setSettlementCurrency(Currency settlementCurrency);
		FxCashSettlement.FxCashSettlementBuilder setReferenceCurrency(Currency referenceCurrency);
		FxCashSettlement.FxCashSettlementBuilder setNotionalAmount(PositiveMoney notionalAmount);
		FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing fixing0);
		FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing fixing1, int _idx);
		FxCashSettlement.FxCashSettlementBuilder addFixing(List<? extends FxFixing> fixing2);
		FxCashSettlement.FxCashSettlementBuilder setFixing(List<? extends FxFixing> fixing3);
		FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing0);
		FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing1, int _idx);
		FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing2);
		FxCashSettlement.FxCashSettlementBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing3);
		FxCashSettlement.FxCashSettlementBuilder setSettlementDate(AdjustableDate settlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.CurrencyBuilder.class, getReferenceCurrency());
			processRosetta(path.newSubPath("notionalAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("fixing"), processor, FxFixing.FxFixingBuilder.class, getFixing());
			processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.FxRateSourceFixingBuilder.class, getRateSourceFixing());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getSettlementDate());
		}
		

		FxCashSettlement.FxCashSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of FxCashSettlement  ***********************/
	class FxCashSettlementImpl implements FxCashSettlement {
		private final Currency settlementCurrency;
		private final Currency referenceCurrency;
		private final PositiveMoney notionalAmount;
		private final List<? extends FxFixing> fixing;
		private final List<? extends FxRateSourceFixing> rateSourceFixing;
		private final AdjustableDate settlementDate;
		
		protected FxCashSettlementImpl(FxCashSettlement.FxCashSettlementBuilder builder) {
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.fixing = ofNullable(builder.getFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateSourceFixing = ofNullable(builder.getRateSourceFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		public Currency getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public PositiveMoney getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("fixing")
		public List<? extends FxFixing> getFixing() {
			return fixing;
		}
		
		@Override
		@RosettaAttribute("rateSourceFixing")
		public List<? extends FxRateSourceFixing> getRateSourceFixing() {
			return rateSourceFixing;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public FxCashSettlement build() {
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder toBuilder() {
			FxCashSettlement.FxCashSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCashSettlement.FxCashSettlementBuilder builder) {
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getFixing()).ifPresent(builder::setFixing);
			ofNullable(getRateSourceFixing()).ifPresent(builder::setRateSourceFixing);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlement {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCashSettlement  ***********************/
	class FxCashSettlementBuilderImpl implements FxCashSettlement.FxCashSettlementBuilder {
	
		protected Currency.CurrencyBuilder settlementCurrency;
		protected Currency.CurrencyBuilder referenceCurrency;
		protected PositiveMoney.PositiveMoneyBuilder notionalAmount;
		protected List<FxFixing.FxFixingBuilder> fixing = new ArrayList<>();
		protected List<FxRateSourceFixing.FxRateSourceFixingBuilder> rateSourceFixing = new ArrayList<>();
		protected AdjustableDate.AdjustableDateBuilder settlementDate;
	
		public FxCashSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		public Currency.CurrencyBuilder getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateReferenceCurrency() {
			Currency.CurrencyBuilder result;
			if (referenceCurrency!=null) {
				result = referenceCurrency;
			}
			else {
				result = referenceCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public PositiveMoney.PositiveMoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateNotionalAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixing")
		public List<? extends FxFixing.FxFixingBuilder> getFixing() {
			return fixing;
		}
		
		public FxFixing.FxFixingBuilder getOrCreateFixing(int _index) {
		
			if (fixing==null) {
				this.fixing = new ArrayList<>();
			}
			FxFixing.FxFixingBuilder result;
			return getIndex(fixing, _index, () -> {
						FxFixing.FxFixingBuilder newFixing = FxFixing.builder();
						return newFixing;
					});
		}
		
		@Override
		@RosettaAttribute("rateSourceFixing")
		public List<? extends FxRateSourceFixing.FxRateSourceFixingBuilder> getRateSourceFixing() {
			return rateSourceFixing;
		}
		
		public FxRateSourceFixing.FxRateSourceFixingBuilder getOrCreateRateSourceFixing(int _index) {
		
			if (rateSourceFixing==null) {
				this.rateSourceFixing = new ArrayList<>();
			}
			FxRateSourceFixing.FxRateSourceFixingBuilder result;
			return getIndex(rateSourceFixing, _index, () -> {
						FxRateSourceFixing.FxRateSourceFixingBuilder newRateSourceFixing = FxRateSourceFixing.builder();
						return newRateSourceFixing;
					});
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableDate.AdjustableDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateSettlementDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public FxCashSettlement.FxCashSettlementBuilder setSettlementCurrency(Currency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceCurrency")
		public FxCashSettlement.FxCashSettlementBuilder setReferenceCurrency(Currency referenceCurrency) {
			this.referenceCurrency = referenceCurrency==null?null:referenceCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxCashSettlement.FxCashSettlementBuilder setNotionalAmount(PositiveMoney notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing fixing) {
			if (fixing!=null) this.fixing.add(fixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing fixing, int _idx) {
			getIndex(this.fixing, _idx, () -> fixing.toBuilder());
			return this;
		}
		@Override 
		public FxCashSettlement.FxCashSettlementBuilder addFixing(List<? extends FxFixing> fixings) {
			if (fixings != null) {
				for (FxFixing toAdd : fixings) {
					this.fixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fixing")
		public FxCashSettlement.FxCashSettlementBuilder setFixing(List<? extends FxFixing> fixings) {
			if (fixings == null)  {
				this.fixing = new ArrayList<>();
			}
			else {
				this.fixing = fixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing) {
			if (rateSourceFixing!=null) this.rateSourceFixing.add(rateSourceFixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing, int _idx) {
			getIndex(this.rateSourceFixing, _idx, () -> rateSourceFixing.toBuilder());
			return this;
		}
		@Override 
		public FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
			if (rateSourceFixings != null) {
				for (FxRateSourceFixing toAdd : rateSourceFixings) {
					this.rateSourceFixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("rateSourceFixing")
		public FxCashSettlement.FxCashSettlementBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
			if (rateSourceFixings == null)  {
				this.rateSourceFixing = new ArrayList<>();
			}
			else {
				this.rateSourceFixing = rateSourceFixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public FxCashSettlement.FxCashSettlementBuilder setSettlementDate(AdjustableDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		
		@Override
		public FxCashSettlement build() {
			return new FxCashSettlement.FxCashSettlementImpl(this);
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			fixing = fixing.stream().filter(b->b!=null).<FxFixing.FxFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			rateSourceFixing = rateSourceFixing.stream().filter(b->b!=null).<FxRateSourceFixing.FxRateSourceFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getReferenceCurrency()!=null && getReferenceCurrency().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getFixing()!=null && getFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateSourceFixing()!=null && getRateSourceFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCashSettlement.FxCashSettlementBuilder o = (FxCashSettlement.FxCashSettlementBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getFixing(), o.getFixing(), this::getOrCreateFixing);
			merger.mergeRosetta(getRateSourceFixing(), o.getRateSourceFixing(), this::getOrCreateRateSourceFixing);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlementBuilder {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}
}
