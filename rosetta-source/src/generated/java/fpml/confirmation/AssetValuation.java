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
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.AssetValuation;
import fpml.confirmation.AssetValuation.AssetValuationBuilder;
import fpml.confirmation.AssetValuation.AssetValuationBuilderImpl;
import fpml.confirmation.AssetValuation.AssetValuationImpl;
import fpml.confirmation.FxRate;
import fpml.confirmation.Quotation;
import fpml.confirmation.Valuation;
import fpml.confirmation.Valuation.ValuationBuilder;
import fpml.confirmation.Valuation.ValuationBuilderImpl;
import fpml.confirmation.Valuation.ValuationImpl;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.AssetValuationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that holds a set of measures about an asset, including possibly their sensitivities.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetValuation", builder=AssetValuation.AssetValuationBuilderImpl.class, version="${project.version}")
public interface AssetValuation extends Valuation {

	AssetValuationMeta metaData = new AssetValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * One or more numerical measures relating to the asset, possibly together with sensitivities of that measure to pricing inputs.
	 */
	List<? extends Quotation> getQuote();
	/**
	 * Indicates the rate of a currency conversion that may have been used to compute valuations.
	 */
	List<? extends FxRate> getFxRate();

	/*********************** Build Methods  ***********************/
	AssetValuation build();
	
	AssetValuation.AssetValuationBuilder toBuilder();
	
	static AssetValuation.AssetValuationBuilder builder() {
		return new AssetValuation.AssetValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AssetValuation> getType() {
		return AssetValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("quote"), processor, Quotation.class, getQuote());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetValuationBuilder extends AssetValuation, Valuation.ValuationBuilder {
		Quotation.QuotationBuilder getOrCreateQuote(int _index);
		List<? extends Quotation.QuotationBuilder> getQuote();
		FxRate.FxRateBuilder getOrCreateFxRate(int _index);
		List<? extends FxRate.FxRateBuilder> getFxRate();
		AssetValuation.AssetValuationBuilder setObjectReference(AnyAssetReference objectReference);
		AssetValuation.AssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		AssetValuation.AssetValuationBuilder setId(String id);
		AssetValuation.AssetValuationBuilder setDefinitionRef(String definitionRef);
		AssetValuation.AssetValuationBuilder addQuote(Quotation quote0);
		AssetValuation.AssetValuationBuilder addQuote(Quotation quote1, int _idx);
		AssetValuation.AssetValuationBuilder addQuote(List<? extends Quotation> quote2);
		AssetValuation.AssetValuationBuilder setQuote(List<? extends Quotation> quote3);
		AssetValuation.AssetValuationBuilder addFxRate(FxRate fxRate0);
		AssetValuation.AssetValuationBuilder addFxRate(FxRate fxRate1, int _idx);
		AssetValuation.AssetValuationBuilder addFxRate(List<? extends FxRate> fxRate2);
		AssetValuation.AssetValuationBuilder setFxRate(List<? extends FxRate> fxRate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("quote"), processor, Quotation.QuotationBuilder.class, getQuote());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
		}
		

		AssetValuation.AssetValuationBuilder prune();
	}

	/*********************** Immutable Implementation of AssetValuation  ***********************/
	class AssetValuationImpl extends Valuation.ValuationImpl implements AssetValuation {
		private final List<? extends Quotation> quote;
		private final List<? extends FxRate> fxRate;
		
		protected AssetValuationImpl(AssetValuation.AssetValuationBuilder builder) {
			super(builder);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quote")
		public List<? extends Quotation> getQuote() {
			return quote;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public List<? extends FxRate> getFxRate() {
			return fxRate;
		}
		
		@Override
		public AssetValuation build() {
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder toBuilder() {
			AssetValuation.AssetValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetValuation.AssetValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetValuation {" +
				"quote=" + this.quote + ", " +
				"fxRate=" + this.fxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AssetValuation  ***********************/
	class AssetValuationBuilderImpl extends Valuation.ValuationBuilderImpl  implements AssetValuation.AssetValuationBuilder {
	
		protected List<Quotation.QuotationBuilder> quote = new ArrayList<>();
		protected List<FxRate.FxRateBuilder> fxRate = new ArrayList<>();
	
		public AssetValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quote")
		public List<? extends Quotation.QuotationBuilder> getQuote() {
			return quote;
		}
		
		public Quotation.QuotationBuilder getOrCreateQuote(int _index) {
		
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			Quotation.QuotationBuilder result;
			return getIndex(quote, _index, () -> {
						Quotation.QuotationBuilder newQuote = Quotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public List<? extends FxRate.FxRateBuilder> getFxRate() {
			return fxRate;
		}
		
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
		@RosettaAttribute("objectReference")
		public AssetValuation.AssetValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public AssetValuation.AssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AssetValuation.AssetValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public AssetValuation.AssetValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		public AssetValuation.AssetValuationBuilder addQuote(Quotation quote) {
			if (quote!=null) this.quote.add(quote.toBuilder());
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder addQuote(Quotation quote, int _idx) {
			getIndex(this.quote, _idx, () -> quote.toBuilder());
			return this;
		}
		@Override 
		public AssetValuation.AssetValuationBuilder addQuote(List<? extends Quotation> quotes) {
			if (quotes != null) {
				for (Quotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("quote")
		public AssetValuation.AssetValuationBuilder setQuote(List<? extends Quotation> quotes) {
			if (quotes == null)  {
				this.quote = new ArrayList<>();
			}
			else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder addFxRate(FxRate fxRate) {
			if (fxRate!=null) this.fxRate.add(fxRate.toBuilder());
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder addFxRate(FxRate fxRate, int _idx) {
			getIndex(this.fxRate, _idx, () -> fxRate.toBuilder());
			return this;
		}
		@Override 
		public AssetValuation.AssetValuationBuilder addFxRate(List<? extends FxRate> fxRates) {
			if (fxRates != null) {
				for (FxRate toAdd : fxRates) {
					this.fxRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fxRate")
		public AssetValuation.AssetValuationBuilder setFxRate(List<? extends FxRate> fxRates) {
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
		public AssetValuation build() {
			return new AssetValuation.AssetValuationImpl(this);
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetValuation.AssetValuationBuilder prune() {
			super.prune();
			quote = quote.stream().filter(b->b!=null).<Quotation.QuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			fxRate = fxRate.stream().filter(b->b!=null).<FxRate.FxRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFxRate()!=null && getFxRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetValuation.AssetValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AssetValuation.AssetValuationBuilder o = (AssetValuation.AssetValuationBuilder) other;
			
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::getOrCreateFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetValuationBuilder {" +
				"quote=" + this.quote + ", " +
				"fxRate=" + this.fxRate +
			'}' + " " + super.toString();
		}
	}
}
