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
import fpml.confirmation.Market;
import fpml.confirmation.Market.MarketBuilder;
import fpml.confirmation.Market.MarketBuilderImpl;
import fpml.confirmation.Market.MarketImpl;
import fpml.confirmation.PricingMethod;
import fpml.confirmation.PricingStructure;
import fpml.confirmation.PricingStructureValuation;
import fpml.confirmation.QuotedAssetSet;
import fpml.confirmation.meta.MarketMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * This is a global element used for creating global types. It holds Market information, e.g. curves, surfaces, quotes, etc. A collection of pricing inputs.
 * @version ${project.version}
 */
@RosettaDataType(value="Market", builder=Market.MarketBuilderImpl.class, version="${project.version}")
public interface Market extends RosettaModelObject {

	MarketMeta metaData = new MarketMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the market, e.g. the USDLIBOR market. Used for description and understandability.
	 */
	String getName();
	/**
	 * A collection of benchmark instruments and quotes used as inputs to the pricing models.
	 */
	QuotedAssetSet getBenchmarkQuotes();
	List<? extends PricingStructure> getPricingStructure();
	List<? extends PricingStructureValuation> getPricingStructureValuation();
	/**
	 * The pricing structure used to quote a benchmark instrument.
	 */
	List<? extends PricingMethod> getBenchmarkPricingMethod();
	String getId();

	/*********************** Build Methods  ***********************/
	Market build();
	
	Market.MarketBuilder toBuilder();
	
	static Market.MarketBuilder builder() {
		return new Market.MarketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Market> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Market> getType() {
		return Market.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("benchmarkQuotes"), processor, QuotedAssetSet.class, getBenchmarkQuotes());
		processRosetta(path.newSubPath("pricingStructure"), processor, PricingStructure.class, getPricingStructure());
		processRosetta(path.newSubPath("pricingStructureValuation"), processor, PricingStructureValuation.class, getPricingStructureValuation());
		processRosetta(path.newSubPath("benchmarkPricingMethod"), processor, PricingMethod.class, getBenchmarkPricingMethod());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarketBuilder extends Market, RosettaModelObjectBuilder {
		QuotedAssetSet.QuotedAssetSetBuilder getOrCreateBenchmarkQuotes();
		QuotedAssetSet.QuotedAssetSetBuilder getBenchmarkQuotes();
		PricingStructure.PricingStructureBuilder getOrCreatePricingStructure(int _index);
		List<? extends PricingStructure.PricingStructureBuilder> getPricingStructure();
		PricingStructureValuation.PricingStructureValuationBuilder getOrCreatePricingStructureValuation(int _index);
		List<? extends PricingStructureValuation.PricingStructureValuationBuilder> getPricingStructureValuation();
		PricingMethod.PricingMethodBuilder getOrCreateBenchmarkPricingMethod(int _index);
		List<? extends PricingMethod.PricingMethodBuilder> getBenchmarkPricingMethod();
		Market.MarketBuilder setName(String name);
		Market.MarketBuilder setBenchmarkQuotes(QuotedAssetSet benchmarkQuotes);
		Market.MarketBuilder addPricingStructure(PricingStructure pricingStructure0);
		Market.MarketBuilder addPricingStructure(PricingStructure pricingStructure1, int _idx);
		Market.MarketBuilder addPricingStructure(List<? extends PricingStructure> pricingStructure2);
		Market.MarketBuilder setPricingStructure(List<? extends PricingStructure> pricingStructure3);
		Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation pricingStructureValuation0);
		Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation pricingStructureValuation1, int _idx);
		Market.MarketBuilder addPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuation2);
		Market.MarketBuilder setPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuation3);
		Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod benchmarkPricingMethod0);
		Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod benchmarkPricingMethod1, int _idx);
		Market.MarketBuilder addBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethod2);
		Market.MarketBuilder setBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethod3);
		Market.MarketBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("benchmarkQuotes"), processor, QuotedAssetSet.QuotedAssetSetBuilder.class, getBenchmarkQuotes());
			processRosetta(path.newSubPath("pricingStructure"), processor, PricingStructure.PricingStructureBuilder.class, getPricingStructure());
			processRosetta(path.newSubPath("pricingStructureValuation"), processor, PricingStructureValuation.PricingStructureValuationBuilder.class, getPricingStructureValuation());
			processRosetta(path.newSubPath("benchmarkPricingMethod"), processor, PricingMethod.PricingMethodBuilder.class, getBenchmarkPricingMethod());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Market.MarketBuilder prune();
	}

	/*********************** Immutable Implementation of Market  ***********************/
	class MarketImpl implements Market {
		private final String name;
		private final QuotedAssetSet benchmarkQuotes;
		private final List<? extends PricingStructure> pricingStructure;
		private final List<? extends PricingStructureValuation> pricingStructureValuation;
		private final List<? extends PricingMethod> benchmarkPricingMethod;
		private final String id;
		
		protected MarketImpl(Market.MarketBuilder builder) {
			this.name = builder.getName();
			this.benchmarkQuotes = ofNullable(builder.getBenchmarkQuotes()).map(f->f.build()).orElse(null);
			this.pricingStructure = ofNullable(builder.getPricingStructure()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.pricingStructureValuation = ofNullable(builder.getPricingStructureValuation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.benchmarkPricingMethod = ofNullable(builder.getBenchmarkPricingMethod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("benchmarkQuotes")
		public QuotedAssetSet getBenchmarkQuotes() {
			return benchmarkQuotes;
		}
		
		@Override
		@RosettaAttribute("pricingStructure")
		public List<? extends PricingStructure> getPricingStructure() {
			return pricingStructure;
		}
		
		@Override
		@RosettaAttribute("pricingStructureValuation")
		public List<? extends PricingStructureValuation> getPricingStructureValuation() {
			return pricingStructureValuation;
		}
		
		@Override
		@RosettaAttribute("benchmarkPricingMethod")
		public List<? extends PricingMethod> getBenchmarkPricingMethod() {
			return benchmarkPricingMethod;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Market build() {
			return this;
		}
		
		@Override
		public Market.MarketBuilder toBuilder() {
			Market.MarketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Market.MarketBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getBenchmarkQuotes()).ifPresent(builder::setBenchmarkQuotes);
			ofNullable(getPricingStructure()).ifPresent(builder::setPricingStructure);
			ofNullable(getPricingStructureValuation()).ifPresent(builder::setPricingStructureValuation);
			ofNullable(getBenchmarkPricingMethod()).ifPresent(builder::setBenchmarkPricingMethod);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Market _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(benchmarkQuotes, _that.getBenchmarkQuotes())) return false;
			if (!ListEquals.listEquals(pricingStructure, _that.getPricingStructure())) return false;
			if (!ListEquals.listEquals(pricingStructureValuation, _that.getPricingStructureValuation())) return false;
			if (!ListEquals.listEquals(benchmarkPricingMethod, _that.getBenchmarkPricingMethod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (benchmarkQuotes != null ? benchmarkQuotes.hashCode() : 0);
			_result = 31 * _result + (pricingStructure != null ? pricingStructure.hashCode() : 0);
			_result = 31 * _result + (pricingStructureValuation != null ? pricingStructureValuation.hashCode() : 0);
			_result = 31 * _result + (benchmarkPricingMethod != null ? benchmarkPricingMethod.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Market {" +
				"name=" + this.name + ", " +
				"benchmarkQuotes=" + this.benchmarkQuotes + ", " +
				"pricingStructure=" + this.pricingStructure + ", " +
				"pricingStructureValuation=" + this.pricingStructureValuation + ", " +
				"benchmarkPricingMethod=" + this.benchmarkPricingMethod + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Market  ***********************/
	class MarketBuilderImpl implements Market.MarketBuilder {
	
		protected String name;
		protected QuotedAssetSet.QuotedAssetSetBuilder benchmarkQuotes;
		protected List<PricingStructure.PricingStructureBuilder> pricingStructure = new ArrayList<>();
		protected List<PricingStructureValuation.PricingStructureValuationBuilder> pricingStructureValuation = new ArrayList<>();
		protected List<PricingMethod.PricingMethodBuilder> benchmarkPricingMethod = new ArrayList<>();
		protected String id;
	
		public MarketBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("benchmarkQuotes")
		public QuotedAssetSet.QuotedAssetSetBuilder getBenchmarkQuotes() {
			return benchmarkQuotes;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder getOrCreateBenchmarkQuotes() {
			QuotedAssetSet.QuotedAssetSetBuilder result;
			if (benchmarkQuotes!=null) {
				result = benchmarkQuotes;
			}
			else {
				result = benchmarkQuotes = QuotedAssetSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingStructure")
		public List<? extends PricingStructure.PricingStructureBuilder> getPricingStructure() {
			return pricingStructure;
		}
		
		public PricingStructure.PricingStructureBuilder getOrCreatePricingStructure(int _index) {
		
			if (pricingStructure==null) {
				this.pricingStructure = new ArrayList<>();
			}
			PricingStructure.PricingStructureBuilder result;
			return getIndex(pricingStructure, _index, () -> {
						PricingStructure.PricingStructureBuilder newPricingStructure = PricingStructure.builder();
						return newPricingStructure;
					});
		}
		
		@Override
		@RosettaAttribute("pricingStructureValuation")
		public List<? extends PricingStructureValuation.PricingStructureValuationBuilder> getPricingStructureValuation() {
			return pricingStructureValuation;
		}
		
		public PricingStructureValuation.PricingStructureValuationBuilder getOrCreatePricingStructureValuation(int _index) {
		
			if (pricingStructureValuation==null) {
				this.pricingStructureValuation = new ArrayList<>();
			}
			PricingStructureValuation.PricingStructureValuationBuilder result;
			return getIndex(pricingStructureValuation, _index, () -> {
						PricingStructureValuation.PricingStructureValuationBuilder newPricingStructureValuation = PricingStructureValuation.builder();
						return newPricingStructureValuation;
					});
		}
		
		@Override
		@RosettaAttribute("benchmarkPricingMethod")
		public List<? extends PricingMethod.PricingMethodBuilder> getBenchmarkPricingMethod() {
			return benchmarkPricingMethod;
		}
		
		public PricingMethod.PricingMethodBuilder getOrCreateBenchmarkPricingMethod(int _index) {
		
			if (benchmarkPricingMethod==null) {
				this.benchmarkPricingMethod = new ArrayList<>();
			}
			PricingMethod.PricingMethodBuilder result;
			return getIndex(benchmarkPricingMethod, _index, () -> {
						PricingMethod.PricingMethodBuilder newBenchmarkPricingMethod = PricingMethod.builder();
						return newBenchmarkPricingMethod;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		public Market.MarketBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("benchmarkQuotes")
		public Market.MarketBuilder setBenchmarkQuotes(QuotedAssetSet benchmarkQuotes) {
			this.benchmarkQuotes = benchmarkQuotes==null?null:benchmarkQuotes.toBuilder();
			return this;
		}
		@Override
		public Market.MarketBuilder addPricingStructure(PricingStructure pricingStructure) {
			if (pricingStructure!=null) this.pricingStructure.add(pricingStructure.toBuilder());
			return this;
		}
		
		@Override
		public Market.MarketBuilder addPricingStructure(PricingStructure pricingStructure, int _idx) {
			getIndex(this.pricingStructure, _idx, () -> pricingStructure.toBuilder());
			return this;
		}
		@Override 
		public Market.MarketBuilder addPricingStructure(List<? extends PricingStructure> pricingStructures) {
			if (pricingStructures != null) {
				for (PricingStructure toAdd : pricingStructures) {
					this.pricingStructure.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("pricingStructure")
		public Market.MarketBuilder setPricingStructure(List<? extends PricingStructure> pricingStructures) {
			if (pricingStructures == null)  {
				this.pricingStructure = new ArrayList<>();
			}
			else {
				this.pricingStructure = pricingStructures.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation pricingStructureValuation) {
			if (pricingStructureValuation!=null) this.pricingStructureValuation.add(pricingStructureValuation.toBuilder());
			return this;
		}
		
		@Override
		public Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation pricingStructureValuation, int _idx) {
			getIndex(this.pricingStructureValuation, _idx, () -> pricingStructureValuation.toBuilder());
			return this;
		}
		@Override 
		public Market.MarketBuilder addPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuations) {
			if (pricingStructureValuations != null) {
				for (PricingStructureValuation toAdd : pricingStructureValuations) {
					this.pricingStructureValuation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("pricingStructureValuation")
		public Market.MarketBuilder setPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuations) {
			if (pricingStructureValuations == null)  {
				this.pricingStructureValuation = new ArrayList<>();
			}
			else {
				this.pricingStructureValuation = pricingStructureValuations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod benchmarkPricingMethod) {
			if (benchmarkPricingMethod!=null) this.benchmarkPricingMethod.add(benchmarkPricingMethod.toBuilder());
			return this;
		}
		
		@Override
		public Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod benchmarkPricingMethod, int _idx) {
			getIndex(this.benchmarkPricingMethod, _idx, () -> benchmarkPricingMethod.toBuilder());
			return this;
		}
		@Override 
		public Market.MarketBuilder addBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethods) {
			if (benchmarkPricingMethods != null) {
				for (PricingMethod toAdd : benchmarkPricingMethods) {
					this.benchmarkPricingMethod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("benchmarkPricingMethod")
		public Market.MarketBuilder setBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethods) {
			if (benchmarkPricingMethods == null)  {
				this.benchmarkPricingMethod = new ArrayList<>();
			}
			else {
				this.benchmarkPricingMethod = benchmarkPricingMethods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public Market.MarketBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Market build() {
			return new Market.MarketImpl(this);
		}
		
		@Override
		public Market.MarketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Market.MarketBuilder prune() {
			if (benchmarkQuotes!=null && !benchmarkQuotes.prune().hasData()) benchmarkQuotes = null;
			pricingStructure = pricingStructure.stream().filter(b->b!=null).<PricingStructure.PricingStructureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			pricingStructureValuation = pricingStructureValuation.stream().filter(b->b!=null).<PricingStructureValuation.PricingStructureValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			benchmarkPricingMethod = benchmarkPricingMethod.stream().filter(b->b!=null).<PricingMethod.PricingMethodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getBenchmarkQuotes()!=null && getBenchmarkQuotes().hasData()) return true;
			if (getPricingStructure()!=null && getPricingStructure().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPricingStructureValuation()!=null && getPricingStructureValuation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBenchmarkPricingMethod()!=null && getBenchmarkPricingMethod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Market.MarketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Market.MarketBuilder o = (Market.MarketBuilder) other;
			
			merger.mergeRosetta(getBenchmarkQuotes(), o.getBenchmarkQuotes(), this::setBenchmarkQuotes);
			merger.mergeRosetta(getPricingStructure(), o.getPricingStructure(), this::getOrCreatePricingStructure);
			merger.mergeRosetta(getPricingStructureValuation(), o.getPricingStructureValuation(), this::getOrCreatePricingStructureValuation);
			merger.mergeRosetta(getBenchmarkPricingMethod(), o.getBenchmarkPricingMethod(), this::getOrCreateBenchmarkPricingMethod);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Market _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(benchmarkQuotes, _that.getBenchmarkQuotes())) return false;
			if (!ListEquals.listEquals(pricingStructure, _that.getPricingStructure())) return false;
			if (!ListEquals.listEquals(pricingStructureValuation, _that.getPricingStructureValuation())) return false;
			if (!ListEquals.listEquals(benchmarkPricingMethod, _that.getBenchmarkPricingMethod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (benchmarkQuotes != null ? benchmarkQuotes.hashCode() : 0);
			_result = 31 * _result + (pricingStructure != null ? pricingStructure.hashCode() : 0);
			_result = 31 * _result + (pricingStructureValuation != null ? pricingStructureValuation.hashCode() : 0);
			_result = 31 * _result + (benchmarkPricingMethod != null ? benchmarkPricingMethod.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketBuilder {" +
				"name=" + this.name + ", " +
				"benchmarkQuotes=" + this.benchmarkQuotes + ", " +
				"pricingStructure=" + this.pricingStructure + ", " +
				"pricingStructureValuation=" + this.pricingStructureValuation + ", " +
				"benchmarkPricingMethod=" + this.benchmarkPricingMethod + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
