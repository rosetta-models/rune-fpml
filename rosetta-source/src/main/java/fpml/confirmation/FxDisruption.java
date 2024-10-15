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
import fpml.confirmation.FxDisruption;
import fpml.confirmation.FxDisruption.FxDisruptionBuilder;
import fpml.confirmation.FxDisruption.FxDisruptionBuilderImpl;
import fpml.confirmation.FxDisruption.FxDisruptionImpl;
import fpml.confirmation.FxDisruptionProvisions;
import fpml.confirmation.meta.FxDisruptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing how disruption for a specified currency pair should be handled
 * @version ${project.version}
 */
@RosettaDataType(value="FxDisruption", builder=FxDisruption.FxDisruptionBuilderImpl.class, version="${project.version}")
public interface FxDisruption extends RosettaModelObject {

	FxDisruptionMeta metaData = new FxDisruptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The base currency in the exchange rate monitored for disruption events. Typically this will be the settlement currency, but coud be an intermediate currency, in the case where disruption provisions are defined for components of a cross rate.
	 */
	Currency getBaseCurrency();
	/**
	 * The reference currency in the exchange rate being monitored for disruption events.
	 */
	Currency getReferenceCurrency();
	/**
	 * One or more provisions describiing disruption events and how they will be handled.
	 */
	List<? extends FxDisruptionProvisions> getProvisions();

	/*********************** Build Methods  ***********************/
	FxDisruption build();
	
	FxDisruption.FxDisruptionBuilder toBuilder();
	
	static FxDisruption.FxDisruptionBuilder builder() {
		return new FxDisruption.FxDisruptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDisruption> getType() {
		return FxDisruption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("baseCurrency"), processor, Currency.class, getBaseCurrency());
		processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.class, getReferenceCurrency());
		processRosetta(path.newSubPath("provisions"), processor, FxDisruptionProvisions.class, getProvisions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionBuilder extends FxDisruption, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateBaseCurrency();
		Currency.CurrencyBuilder getBaseCurrency();
		Currency.CurrencyBuilder getOrCreateReferenceCurrency();
		Currency.CurrencyBuilder getReferenceCurrency();
		FxDisruptionProvisions.FxDisruptionProvisionsBuilder getOrCreateProvisions(int _index);
		List<? extends FxDisruptionProvisions.FxDisruptionProvisionsBuilder> getProvisions();
		FxDisruption.FxDisruptionBuilder setBaseCurrency(Currency baseCurrency);
		FxDisruption.FxDisruptionBuilder setReferenceCurrency(Currency referenceCurrency);
		FxDisruption.FxDisruptionBuilder addProvisions(FxDisruptionProvisions provisions0);
		FxDisruption.FxDisruptionBuilder addProvisions(FxDisruptionProvisions provisions1, int _idx);
		FxDisruption.FxDisruptionBuilder addProvisions(List<? extends FxDisruptionProvisions> provisions2);
		FxDisruption.FxDisruptionBuilder setProvisions(List<? extends FxDisruptionProvisions> provisions3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("baseCurrency"), processor, Currency.CurrencyBuilder.class, getBaseCurrency());
			processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.CurrencyBuilder.class, getReferenceCurrency());
			processRosetta(path.newSubPath("provisions"), processor, FxDisruptionProvisions.FxDisruptionProvisionsBuilder.class, getProvisions());
		}
		

		FxDisruption.FxDisruptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruption  ***********************/
	class FxDisruptionImpl implements FxDisruption {
		private final Currency baseCurrency;
		private final Currency referenceCurrency;
		private final List<? extends FxDisruptionProvisions> provisions;
		
		protected FxDisruptionImpl(FxDisruption.FxDisruptionBuilder builder) {
			this.baseCurrency = ofNullable(builder.getBaseCurrency()).map(f->f.build()).orElse(null);
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
			this.provisions = ofNullable(builder.getProvisions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("baseCurrency")
		public Currency getBaseCurrency() {
			return baseCurrency;
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		public Currency getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		@RosettaAttribute("provisions")
		public List<? extends FxDisruptionProvisions> getProvisions() {
			return provisions;
		}
		
		@Override
		public FxDisruption build() {
			return this;
		}
		
		@Override
		public FxDisruption.FxDisruptionBuilder toBuilder() {
			FxDisruption.FxDisruptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruption.FxDisruptionBuilder builder) {
			ofNullable(getBaseCurrency()).ifPresent(builder::setBaseCurrency);
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
			ofNullable(getProvisions()).ifPresent(builder::setProvisions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruption _that = getType().cast(o);
		
			if (!Objects.equals(baseCurrency, _that.getBaseCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!ListEquals.listEquals(provisions, _that.getProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCurrency != null ? baseCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (provisions != null ? provisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruption {" +
				"baseCurrency=" + this.baseCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"provisions=" + this.provisions +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruption  ***********************/
	class FxDisruptionBuilderImpl implements FxDisruption.FxDisruptionBuilder {
	
		protected Currency.CurrencyBuilder baseCurrency;
		protected Currency.CurrencyBuilder referenceCurrency;
		protected List<FxDisruptionProvisions.FxDisruptionProvisionsBuilder> provisions = new ArrayList<>();
	
		public FxDisruptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("baseCurrency")
		public Currency.CurrencyBuilder getBaseCurrency() {
			return baseCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateBaseCurrency() {
			Currency.CurrencyBuilder result;
			if (baseCurrency!=null) {
				result = baseCurrency;
			}
			else {
				result = baseCurrency = Currency.builder();
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
		@RosettaAttribute("provisions")
		public List<? extends FxDisruptionProvisions.FxDisruptionProvisionsBuilder> getProvisions() {
			return provisions;
		}
		
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder getOrCreateProvisions(int _index) {
		
			if (provisions==null) {
				this.provisions = new ArrayList<>();
			}
			FxDisruptionProvisions.FxDisruptionProvisionsBuilder result;
			return getIndex(provisions, _index, () -> {
						FxDisruptionProvisions.FxDisruptionProvisionsBuilder newProvisions = FxDisruptionProvisions.builder();
						return newProvisions;
					});
		}
		
		@Override
		@RosettaAttribute("baseCurrency")
		public FxDisruption.FxDisruptionBuilder setBaseCurrency(Currency baseCurrency) {
			this.baseCurrency = baseCurrency==null?null:baseCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceCurrency")
		public FxDisruption.FxDisruptionBuilder setReferenceCurrency(Currency referenceCurrency) {
			this.referenceCurrency = referenceCurrency==null?null:referenceCurrency.toBuilder();
			return this;
		}
		@Override
		public FxDisruption.FxDisruptionBuilder addProvisions(FxDisruptionProvisions provisions) {
			if (provisions!=null) this.provisions.add(provisions.toBuilder());
			return this;
		}
		
		@Override
		public FxDisruption.FxDisruptionBuilder addProvisions(FxDisruptionProvisions provisions, int _idx) {
			getIndex(this.provisions, _idx, () -> provisions.toBuilder());
			return this;
		}
		@Override 
		public FxDisruption.FxDisruptionBuilder addProvisions(List<? extends FxDisruptionProvisions> provisionss) {
			if (provisionss != null) {
				for (FxDisruptionProvisions toAdd : provisionss) {
					this.provisions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("provisions")
		public FxDisruption.FxDisruptionBuilder setProvisions(List<? extends FxDisruptionProvisions> provisionss) {
			if (provisionss == null)  {
				this.provisions = new ArrayList<>();
			}
			else {
				this.provisions = provisionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxDisruption build() {
			return new FxDisruption.FxDisruptionImpl(this);
		}
		
		@Override
		public FxDisruption.FxDisruptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruption.FxDisruptionBuilder prune() {
			if (baseCurrency!=null && !baseCurrency.prune().hasData()) baseCurrency = null;
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			provisions = provisions.stream().filter(b->b!=null).<FxDisruptionProvisions.FxDisruptionProvisionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBaseCurrency()!=null && getBaseCurrency().hasData()) return true;
			if (getReferenceCurrency()!=null && getReferenceCurrency().hasData()) return true;
			if (getProvisions()!=null && getProvisions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruption.FxDisruptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruption.FxDisruptionBuilder o = (FxDisruption.FxDisruptionBuilder) other;
			
			merger.mergeRosetta(getBaseCurrency(), o.getBaseCurrency(), this::setBaseCurrency);
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			merger.mergeRosetta(getProvisions(), o.getProvisions(), this::getOrCreateProvisions);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruption _that = getType().cast(o);
		
			if (!Objects.equals(baseCurrency, _that.getBaseCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!ListEquals.listEquals(provisions, _that.getProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCurrency != null ? baseCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (provisions != null ? provisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionBuilder {" +
				"baseCurrency=" + this.baseCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"provisions=" + this.provisions +
			'}';
		}
	}
}
