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
import fpml.confirmation.BasicAssetValuation;
import fpml.confirmation.BasicAssetValuation.BasicAssetValuationBuilder;
import fpml.confirmation.BasicAssetValuation.BasicAssetValuationBuilderImpl;
import fpml.confirmation.BasicAssetValuation.BasicAssetValuationImpl;
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.Valuation;
import fpml.confirmation.Valuation.ValuationBuilder;
import fpml.confirmation.Valuation.ValuationBuilderImpl;
import fpml.confirmation.Valuation.ValuationImpl;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.BasicAssetValuationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that holds a set of measures about an asset.
 * @version ${project.version}
 */
@RosettaDataType(value="BasicAssetValuation", builder=BasicAssetValuation.BasicAssetValuationBuilderImpl.class, version="${project.version}")
public interface BasicAssetValuation extends Valuation {

	BasicAssetValuationMeta metaData = new BasicAssetValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * One or more numerical measures relating to the asset, possibly together with sensitivities of that measure to pricing inputs
	 */
	List<? extends BasicQuotation> getQuote();

	/*********************** Build Methods  ***********************/
	BasicAssetValuation build();
	
	BasicAssetValuation.BasicAssetValuationBuilder toBuilder();
	
	static BasicAssetValuation.BasicAssetValuationBuilder builder() {
		return new BasicAssetValuation.BasicAssetValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasicAssetValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasicAssetValuation> getType() {
		return BasicAssetValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasicAssetValuationBuilder extends BasicAssetValuation, Valuation.ValuationBuilder {
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index);
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		BasicAssetValuation.BasicAssetValuationBuilder setObjectReference(AnyAssetReference objectReference);
		BasicAssetValuation.BasicAssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		BasicAssetValuation.BasicAssetValuationBuilder setId(String id);
		BasicAssetValuation.BasicAssetValuationBuilder setDefinitionRef(String definitionRef);
		BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation quote0);
		BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation quote1, int _idx);
		BasicAssetValuation.BasicAssetValuationBuilder addQuote(List<? extends BasicQuotation> quote2);
		BasicAssetValuation.BasicAssetValuationBuilder setQuote(List<? extends BasicQuotation> quote3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
		}
		

		BasicAssetValuation.BasicAssetValuationBuilder prune();
	}

	/*********************** Immutable Implementation of BasicAssetValuation  ***********************/
	class BasicAssetValuationImpl extends Valuation.ValuationImpl implements BasicAssetValuation {
		private final List<? extends BasicQuotation> quote;
		
		protected BasicAssetValuationImpl(BasicAssetValuation.BasicAssetValuationBuilder builder) {
			super(builder);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		public BasicAssetValuation build() {
			return this;
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder toBuilder() {
			BasicAssetValuation.BasicAssetValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasicAssetValuation.BasicAssetValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BasicAssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasicAssetValuation {" +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BasicAssetValuation  ***********************/
	class BasicAssetValuationBuilderImpl extends Valuation.ValuationBuilderImpl  implements BasicAssetValuation.BasicAssetValuationBuilder {
	
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
	
		public BasicAssetValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index) {
		
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			BasicQuotation.BasicQuotationBuilder result;
			return getIndex(quote, _index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public BasicAssetValuation.BasicAssetValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public BasicAssetValuation.BasicAssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BasicAssetValuation.BasicAssetValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public BasicAssetValuation.BasicAssetValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation quote) {
			if (quote!=null) this.quote.add(quote.toBuilder());
			return this;
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation quote, int _idx) {
			getIndex(this.quote, _idx, () -> quote.toBuilder());
			return this;
		}
		@Override 
		public BasicAssetValuation.BasicAssetValuationBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("quote")
		public BasicAssetValuation.BasicAssetValuationBuilder setQuote(List<? extends BasicQuotation> quotes) {
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
		public BasicAssetValuation build() {
			return new BasicAssetValuation.BasicAssetValuationImpl(this);
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder prune() {
			super.prune();
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BasicAssetValuation.BasicAssetValuationBuilder o = (BasicAssetValuation.BasicAssetValuationBuilder) other;
			
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BasicAssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasicAssetValuationBuilder {" +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}
}
