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
import fpml.confirmation.PartyTradeIdentifierReference;
import fpml.confirmation.ProductReference;
import fpml.confirmation.StrategyComponentIdentification;
import fpml.confirmation.StrategyComponentIdentification.StrategyComponentIdentificationBuilder;
import fpml.confirmation.StrategyComponentIdentification.StrategyComponentIdentificationBuilderImpl;
import fpml.confirmation.StrategyComponentIdentification.StrategyComponentIdentificationImpl;
import fpml.confirmation.meta.StrategyComponentIdentificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Associates trade identifiers with components of a strategy.
 * @version ${project.version}
 */
@RosettaDataType(value="StrategyComponentIdentification", builder=StrategyComponentIdentification.StrategyComponentIdentificationBuilderImpl.class, version="${project.version}")
public interface StrategyComponentIdentification extends RosettaModelObject {

	StrategyComponentIdentificationMeta metaData = new StrategyComponentIdentificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to a party trade ID. If there are multiple trade IDs for a single component (e.g. USI, UTI, party-specific identifier), create a single &quot;strategyComponentIdentifier&quot; with a reference to the component, and multiple tradeIdentifierReferences, one referencing each applicable identifier.
	 */
	List<? extends PartyTradeIdentifierReference> getTradeIdentifierReference();
	/**
	 * A reference to a component of the strategy (typically a product).
	 */
	ProductReference getComponentReference();

	/*********************** Build Methods  ***********************/
	StrategyComponentIdentification build();
	
	StrategyComponentIdentification.StrategyComponentIdentificationBuilder toBuilder();
	
	static StrategyComponentIdentification.StrategyComponentIdentificationBuilder builder() {
		return new StrategyComponentIdentification.StrategyComponentIdentificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StrategyComponentIdentification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StrategyComponentIdentification> getType() {
		return StrategyComponentIdentification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifierReference"), processor, PartyTradeIdentifierReference.class, getTradeIdentifierReference());
		processRosetta(path.newSubPath("componentReference"), processor, ProductReference.class, getComponentReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrategyComponentIdentificationBuilder extends StrategyComponentIdentification, RosettaModelObjectBuilder {
		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreateTradeIdentifierReference(int _index);
		List<? extends PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder> getTradeIdentifierReference();
		ProductReference.ProductReferenceBuilder getOrCreateComponentReference();
		ProductReference.ProductReferenceBuilder getComponentReference();
		StrategyComponentIdentification.StrategyComponentIdentificationBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference0);
		StrategyComponentIdentification.StrategyComponentIdentificationBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference1, int _idx);
		StrategyComponentIdentification.StrategyComponentIdentificationBuilder addTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReference2);
		StrategyComponentIdentification.StrategyComponentIdentificationBuilder setTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReference3);
		StrategyComponentIdentification.StrategyComponentIdentificationBuilder setComponentReference(ProductReference componentReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifierReference"), processor, PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder.class, getTradeIdentifierReference());
			processRosetta(path.newSubPath("componentReference"), processor, ProductReference.ProductReferenceBuilder.class, getComponentReference());
		}
		

		StrategyComponentIdentification.StrategyComponentIdentificationBuilder prune();
	}

	/*********************** Immutable Implementation of StrategyComponentIdentification  ***********************/
	class StrategyComponentIdentificationImpl implements StrategyComponentIdentification {
		private final List<? extends PartyTradeIdentifierReference> tradeIdentifierReference;
		private final ProductReference componentReference;
		
		protected StrategyComponentIdentificationImpl(StrategyComponentIdentification.StrategyComponentIdentificationBuilder builder) {
			this.tradeIdentifierReference = ofNullable(builder.getTradeIdentifierReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.componentReference = ofNullable(builder.getComponentReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifierReference")
		public List<? extends PartyTradeIdentifierReference> getTradeIdentifierReference() {
			return tradeIdentifierReference;
		}
		
		@Override
		@RosettaAttribute("componentReference")
		public ProductReference getComponentReference() {
			return componentReference;
		}
		
		@Override
		public StrategyComponentIdentification build() {
			return this;
		}
		
		@Override
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder toBuilder() {
			StrategyComponentIdentification.StrategyComponentIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrategyComponentIdentification.StrategyComponentIdentificationBuilder builder) {
			ofNullable(getTradeIdentifierReference()).ifPresent(builder::setTradeIdentifierReference);
			ofNullable(getComponentReference()).ifPresent(builder::setComponentReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrategyComponentIdentification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifierReference, _that.getTradeIdentifierReference())) return false;
			if (!Objects.equals(componentReference, _that.getComponentReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifierReference != null ? tradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (componentReference != null ? componentReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrategyComponentIdentification {" +
				"tradeIdentifierReference=" + this.tradeIdentifierReference + ", " +
				"componentReference=" + this.componentReference +
			'}';
		}
	}

	/*********************** Builder Implementation of StrategyComponentIdentification  ***********************/
	class StrategyComponentIdentificationBuilderImpl implements StrategyComponentIdentification.StrategyComponentIdentificationBuilder {
	
		protected List<PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder> tradeIdentifierReference = new ArrayList<>();
		protected ProductReference.ProductReferenceBuilder componentReference;
	
		public StrategyComponentIdentificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifierReference")
		public List<? extends PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder> getTradeIdentifierReference() {
			return tradeIdentifierReference;
		}
		
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreateTradeIdentifierReference(int _index) {
		
			if (tradeIdentifierReference==null) {
				this.tradeIdentifierReference = new ArrayList<>();
			}
			PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder result;
			return getIndex(tradeIdentifierReference, _index, () -> {
						PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder newTradeIdentifierReference = PartyTradeIdentifierReference.builder();
						return newTradeIdentifierReference;
					});
		}
		
		@Override
		@RosettaAttribute("componentReference")
		public ProductReference.ProductReferenceBuilder getComponentReference() {
			return componentReference;
		}
		
		@Override
		public ProductReference.ProductReferenceBuilder getOrCreateComponentReference() {
			ProductReference.ProductReferenceBuilder result;
			if (componentReference!=null) {
				result = componentReference;
			}
			else {
				result = componentReference = ProductReference.builder();
			}
			
			return result;
		}
		
		@Override
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference) {
			if (tradeIdentifierReference!=null) this.tradeIdentifierReference.add(tradeIdentifierReference.toBuilder());
			return this;
		}
		
		@Override
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference, int _idx) {
			getIndex(this.tradeIdentifierReference, _idx, () -> tradeIdentifierReference.toBuilder());
			return this;
		}
		@Override 
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder addTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReferences) {
			if (tradeIdentifierReferences != null) {
				for (PartyTradeIdentifierReference toAdd : tradeIdentifierReferences) {
					this.tradeIdentifierReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeIdentifierReference")
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder setTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReferences) {
			if (tradeIdentifierReferences == null)  {
				this.tradeIdentifierReference = new ArrayList<>();
			}
			else {
				this.tradeIdentifierReference = tradeIdentifierReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("componentReference")
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder setComponentReference(ProductReference componentReference) {
			this.componentReference = componentReference==null?null:componentReference.toBuilder();
			return this;
		}
		
		@Override
		public StrategyComponentIdentification build() {
			return new StrategyComponentIdentification.StrategyComponentIdentificationImpl(this);
		}
		
		@Override
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder prune() {
			tradeIdentifierReference = tradeIdentifierReference.stream().filter(b->b!=null).<PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (componentReference!=null && !componentReference.prune().hasData()) componentReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifierReference()!=null && getTradeIdentifierReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getComponentReference()!=null && getComponentReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrategyComponentIdentification.StrategyComponentIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StrategyComponentIdentification.StrategyComponentIdentificationBuilder o = (StrategyComponentIdentification.StrategyComponentIdentificationBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifierReference(), o.getTradeIdentifierReference(), this::getOrCreateTradeIdentifierReference);
			merger.mergeRosetta(getComponentReference(), o.getComponentReference(), this::setComponentReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrategyComponentIdentification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifierReference, _that.getTradeIdentifierReference())) return false;
			if (!Objects.equals(componentReference, _that.getComponentReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifierReference != null ? tradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (componentReference != null ? componentReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrategyComponentIdentificationBuilder {" +
				"tradeIdentifierReference=" + this.tradeIdentifierReference + ", " +
				"componentReference=" + this.componentReference +
			'}';
		}
	}
}
