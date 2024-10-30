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
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.Valuation;
import fpml.confirmation.Valuation.ValuationBuilder;
import fpml.confirmation.Valuation.ValuationBuilderImpl;
import fpml.confirmation.Valuation.ValuationImpl;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.ValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A valuation of an valuable object - an asset or a pricing input. This is an abstract type, used as a base for values of pricing structures such as yield curves as well as asset values.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Valuation", builder=Valuation.ValuationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Valuation extends RosettaModelObject {

	ValuationMeta metaData = new ValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the asset or pricing structure that this values.
	 */
	AnyAssetReference getObjectReference();
	/**
	 * A reference to the valuation scenario used to calculate this valuation. If the Valuation occurs within a ValuationSet, this value is optional and is defaulted from the ValuationSet. If this value occurs in both places, the lower level value (i.e. the one here) overrides that in the higher (i.e. ValuationSet).
	 */
	ValuationScenarioReference getValuationScenarioReference();
	String getId();
	/**
	 * An optional reference to the scenario that this valuation applies to.
	 */
	String getDefinitionRef();

	/*********************** Build Methods  ***********************/
	Valuation build();
	
	Valuation.ValuationBuilder toBuilder();
	
	static Valuation.ValuationBuilder builder() {
		return new Valuation.ValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Valuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Valuation> getType() {
		return Valuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationBuilder extends Valuation, RosettaModelObjectBuilder {
		AnyAssetReference.AnyAssetReferenceBuilder getOrCreateObjectReference();
		AnyAssetReference.AnyAssetReferenceBuilder getObjectReference();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference();
		Valuation.ValuationBuilder setObjectReference(AnyAssetReference objectReference);
		Valuation.ValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		Valuation.ValuationBuilder setId(String id);
		Valuation.ValuationBuilder setDefinitionRef(String definitionRef);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		}
		

		Valuation.ValuationBuilder prune();
	}

	/*********************** Immutable Implementation of Valuation  ***********************/
	class ValuationImpl implements Valuation {
		private final AnyAssetReference objectReference;
		private final ValuationScenarioReference valuationScenarioReference;
		private final String id;
		private final String definitionRef;
		
		protected ValuationImpl(Valuation.ValuationBuilder builder) {
			this.objectReference = ofNullable(builder.getObjectReference()).map(f->f.build()).orElse(null);
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
			this.definitionRef = builder.getDefinitionRef();
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public AnyAssetReference getObjectReference() {
			return objectReference;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public ValuationScenarioReference getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("definitionRef")
		public String getDefinitionRef() {
			return definitionRef;
		}
		
		@Override
		public Valuation build() {
			return this;
		}
		
		@Override
		public Valuation.ValuationBuilder toBuilder() {
			Valuation.ValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Valuation.ValuationBuilder builder) {
			ofNullable(getObjectReference()).ifPresent(builder::setObjectReference);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDefinitionRef()).ifPresent(builder::setDefinitionRef);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Valuation _that = getType().cast(o);
		
			if (!Objects.equals(objectReference, _that.getObjectReference())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(definitionRef, _that.getDefinitionRef())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (objectReference != null ? objectReference.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (definitionRef != null ? definitionRef.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Valuation {" +
				"objectReference=" + this.objectReference + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"id=" + this.id + ", " +
				"definitionRef=" + this.definitionRef +
			'}';
		}
	}

	/*********************** Builder Implementation of Valuation  ***********************/
	class ValuationBuilderImpl implements Valuation.ValuationBuilder {
	
		protected AnyAssetReference.AnyAssetReferenceBuilder objectReference;
		protected ValuationScenarioReference.ValuationScenarioReferenceBuilder valuationScenarioReference;
		protected String id;
		protected String definitionRef;
	
		public ValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("objectReference")
		public AnyAssetReference.AnyAssetReferenceBuilder getObjectReference() {
			return objectReference;
		}
		
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder getOrCreateObjectReference() {
			AnyAssetReference.AnyAssetReferenceBuilder result;
			if (objectReference!=null) {
				result = objectReference;
			}
			else {
				result = objectReference = AnyAssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference() {
			ValuationScenarioReference.ValuationScenarioReferenceBuilder result;
			if (valuationScenarioReference!=null) {
				result = valuationScenarioReference;
			}
			else {
				result = valuationScenarioReference = ValuationScenarioReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("definitionRef")
		public String getDefinitionRef() {
			return definitionRef;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public Valuation.ValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public Valuation.ValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Valuation.ValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public Valuation.ValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		
		@Override
		public Valuation build() {
			return new Valuation.ValuationImpl(this);
		}
		
		@Override
		public Valuation.ValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Valuation.ValuationBuilder prune() {
			if (objectReference!=null && !objectReference.prune().hasData()) objectReference = null;
			if (valuationScenarioReference!=null && !valuationScenarioReference.prune().hasData()) valuationScenarioReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObjectReference()!=null && getObjectReference().hasData()) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().hasData()) return true;
			if (getId()!=null) return true;
			if (getDefinitionRef()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Valuation.ValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Valuation.ValuationBuilder o = (Valuation.ValuationBuilder) other;
			
			merger.mergeRosetta(getObjectReference(), o.getObjectReference(), this::setObjectReference);
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::setValuationScenarioReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDefinitionRef(), o.getDefinitionRef(), this::setDefinitionRef);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Valuation _that = getType().cast(o);
		
			if (!Objects.equals(objectReference, _that.getObjectReference())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(definitionRef, _that.getDefinitionRef())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (objectReference != null ? objectReference.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (definitionRef != null ? definitionRef.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationBuilder {" +
				"objectReference=" + this.objectReference + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"id=" + this.id + ", " +
				"definitionRef=" + this.definitionRef +
			'}';
		}
	}
}
