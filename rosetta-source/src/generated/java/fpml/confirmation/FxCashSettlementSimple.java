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
import fpml.confirmation.Currency;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxCashSettlementSimple.FxCashSettlementSimpleBuilder;
import fpml.confirmation.FxCashSettlementSimple.FxCashSettlementSimpleBuilderImpl;
import fpml.confirmation.FxCashSettlementSimple.FxCashSettlementSimpleImpl;
import fpml.confirmation.FxFixing;
import fpml.confirmation.FxRateSourceFixing;
import fpml.confirmation.meta.FxCashSettlementSimpleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that is used for describing cash settlement of a variance or volatility swap option. It includes the settlement currency together with the spot currency exchange required to calculate the settlement currency amount.
 * @version ${project.version}
 */
@RosettaDataType(value="FxCashSettlementSimple", builder=FxCashSettlementSimple.FxCashSettlementSimpleBuilderImpl.class, version="${project.version}")
public interface FxCashSettlementSimple extends RosettaModelObject {

	FxCashSettlementSimpleMeta metaData = new FxCashSettlementSimpleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which cash settlement occurs.
	 */
	Currency getSettlementCurrency();
	/**
	 * Reference Currency.
	 */
	Currency getReferenceCurrency();
	/**
	 * Quoted currency pair.
	 */
	List<? extends FxFixing> getFixing();
	/**
	 * Settlement Rate Source and Fixing Date.
	 */
	List<? extends FxRateSourceFixing> getRateSourceFixing();

	/*********************** Build Methods  ***********************/
	FxCashSettlementSimple build();
	
	FxCashSettlementSimple.FxCashSettlementSimpleBuilder toBuilder();
	
	static FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder() {
		return new FxCashSettlementSimple.FxCashSettlementSimpleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCashSettlementSimple> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCashSettlementSimple> getType() {
		return FxCashSettlementSimple.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.class, getReferenceCurrency());
		processRosetta(path.newSubPath("fixing"), processor, FxFixing.class, getFixing());
		processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.class, getRateSourceFixing());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCashSettlementSimpleBuilder extends FxCashSettlementSimple, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		Currency.CurrencyBuilder getSettlementCurrency();
		Currency.CurrencyBuilder getOrCreateReferenceCurrency();
		Currency.CurrencyBuilder getReferenceCurrency();
		FxFixing.FxFixingBuilder getOrCreateFixing(int _index);
		List<? extends FxFixing.FxFixingBuilder> getFixing();
		FxRateSourceFixing.FxRateSourceFixingBuilder getOrCreateRateSourceFixing(int _index);
		List<? extends FxRateSourceFixing.FxRateSourceFixingBuilder> getRateSourceFixing();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setSettlementCurrency(Currency settlementCurrency);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setReferenceCurrency(Currency referenceCurrency);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing fixing0);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing fixing1, int _idx);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(List<? extends FxFixing> fixing2);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setFixing(List<? extends FxFixing> fixing3);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing0);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing1, int _idx);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing2);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.CurrencyBuilder.class, getReferenceCurrency());
			processRosetta(path.newSubPath("fixing"), processor, FxFixing.FxFixingBuilder.class, getFixing());
			processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.FxRateSourceFixingBuilder.class, getRateSourceFixing());
		}
		

		FxCashSettlementSimple.FxCashSettlementSimpleBuilder prune();
	}

	/*********************** Immutable Implementation of FxCashSettlementSimple  ***********************/
	class FxCashSettlementSimpleImpl implements FxCashSettlementSimple {
		private final Currency settlementCurrency;
		private final Currency referenceCurrency;
		private final List<? extends FxFixing> fixing;
		private final List<? extends FxRateSourceFixing> rateSourceFixing;
		
		protected FxCashSettlementSimpleImpl(FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder) {
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
			this.fixing = ofNullable(builder.getFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateSourceFixing = ofNullable(builder.getRateSourceFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public FxCashSettlementSimple build() {
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder toBuilder() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder) {
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
			ofNullable(getFixing()).ifPresent(builder::setFixing);
			ofNullable(getRateSourceFixing()).ifPresent(builder::setRateSourceFixing);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlementSimple _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlementSimple {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCashSettlementSimple  ***********************/
	class FxCashSettlementSimpleBuilderImpl implements FxCashSettlementSimple.FxCashSettlementSimpleBuilder {
	
		protected Currency.CurrencyBuilder settlementCurrency;
		protected Currency.CurrencyBuilder referenceCurrency;
		protected List<FxFixing.FxFixingBuilder> fixing = new ArrayList<>();
		protected List<FxRateSourceFixing.FxRateSourceFixingBuilder> rateSourceFixing = new ArrayList<>();
	
		public FxCashSettlementSimpleBuilderImpl() {
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
		@RosettaAttribute("settlementCurrency")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setSettlementCurrency(Currency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceCurrency")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setReferenceCurrency(Currency referenceCurrency) {
			this.referenceCurrency = referenceCurrency==null?null:referenceCurrency.toBuilder();
			return this;
		}
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing fixing) {
			if (fixing!=null) this.fixing.add(fixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing fixing, int _idx) {
			getIndex(this.fixing, _idx, () -> fixing.toBuilder());
			return this;
		}
		@Override 
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(List<? extends FxFixing> fixings) {
			if (fixings != null) {
				for (FxFixing toAdd : fixings) {
					this.fixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fixing")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setFixing(List<? extends FxFixing> fixings) {
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
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing) {
			if (rateSourceFixing!=null) this.rateSourceFixing.add(rateSourceFixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing, int _idx) {
			getIndex(this.rateSourceFixing, _idx, () -> rateSourceFixing.toBuilder());
			return this;
		}
		@Override 
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
			if (rateSourceFixings != null) {
				for (FxRateSourceFixing toAdd : rateSourceFixings) {
					this.rateSourceFixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("rateSourceFixing")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
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
		public FxCashSettlementSimple build() {
			return new FxCashSettlementSimple.FxCashSettlementSimpleImpl(this);
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			fixing = fixing.stream().filter(b->b!=null).<FxFixing.FxFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			rateSourceFixing = rateSourceFixing.stream().filter(b->b!=null).<FxRateSourceFixing.FxRateSourceFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getReferenceCurrency()!=null && getReferenceCurrency().hasData()) return true;
			if (getFixing()!=null && getFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateSourceFixing()!=null && getRateSourceFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder o = (FxCashSettlementSimple.FxCashSettlementSimpleBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			merger.mergeRosetta(getFixing(), o.getFixing(), this::getOrCreateFixing);
			merger.mergeRosetta(getRateSourceFixing(), o.getRateSourceFixing(), this::getOrCreateRateSourceFixing);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlementSimple _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlementSimpleBuilder {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing +
			'}';
		}
	}
}
