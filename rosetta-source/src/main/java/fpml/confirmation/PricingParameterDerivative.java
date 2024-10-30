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
import fpml.confirmation.AssetOrTermPointOrPricingStructureReference;
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.PricingParameterDerivative;
import fpml.confirmation.PricingParameterDerivative.PricingParameterDerivativeBuilder;
import fpml.confirmation.PricingParameterDerivative.PricingParameterDerivativeBuilderImpl;
import fpml.confirmation.PricingParameterDerivative.PricingParameterDerivativeImpl;
import fpml.confirmation.ValuationReference;
import fpml.confirmation.meta.PricingParameterDerivativeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A definition of the mathematical derivative with respect to a specific pricing parameter.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PricingParameterDerivative", builder=PricingParameterDerivative.PricingParameterDerivativeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PricingParameterDerivative extends RosettaModelObject {

	PricingParameterDerivativeMeta metaData = new PricingParameterDerivativeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A description, if needed, of how the derivative is computed.
	 */
	String getDescription();
	/**
	 * A reference to the pricing input parameter to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 */
	AssetOrTermPointOrPricingStructureReference getParameterReference();
	/**
	 * Reference(s) to the pricing input dates that are shifted when the sensitivity is computed. Depending on the time advance method used, this list could vary. Used for describing time-advance derivatives (theta, carry, etc.)
	 */
	List<? extends ValuationReference> getInputDateReference();
	/**
	 * The method by which a derivative is computed, e.g. analytic, numerical model, perturbation, etc., and the corresponding parameters
	 */
	DerivativeCalculationProcedure getCalculationProcedure();
	String getId();

	/*********************** Build Methods  ***********************/
	PricingParameterDerivative build();
	
	PricingParameterDerivative.PricingParameterDerivativeBuilder toBuilder();
	
	static PricingParameterDerivative.PricingParameterDerivativeBuilder builder() {
		return new PricingParameterDerivative.PricingParameterDerivativeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingParameterDerivative> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingParameterDerivative> getType() {
		return PricingParameterDerivative.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.class, getParameterReference());
		processRosetta(path.newSubPath("inputDateReference"), processor, ValuationReference.class, getInputDateReference());
		processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.class, getCalculationProcedure());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingParameterDerivativeBuilder extends PricingParameterDerivative, RosettaModelObjectBuilder {
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference();
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference();
		ValuationReference.ValuationReferenceBuilder getOrCreateInputDateReference(int _index);
		List<? extends ValuationReference.ValuationReferenceBuilder> getInputDateReference();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getOrCreateCalculationProcedure();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getCalculationProcedure();
		PricingParameterDerivative.PricingParameterDerivativeBuilder setDescription(String description);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference parameterReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference inputDateReference0);
		PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference inputDateReference1, int _idx);
		PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(List<? extends ValuationReference> inputDateReference2);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setInputDateReference(List<? extends ValuationReference> inputDateReference3);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setCalculationProcedure(DerivativeCalculationProcedure calculationProcedure);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder.class, getParameterReference());
			processRosetta(path.newSubPath("inputDateReference"), processor, ValuationReference.ValuationReferenceBuilder.class, getInputDateReference());
			processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder.class, getCalculationProcedure());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PricingParameterDerivative.PricingParameterDerivativeBuilder prune();
	}

	/*********************** Immutable Implementation of PricingParameterDerivative  ***********************/
	class PricingParameterDerivativeImpl implements PricingParameterDerivative {
		private final String description;
		private final AssetOrTermPointOrPricingStructureReference parameterReference;
		private final List<? extends ValuationReference> inputDateReference;
		private final DerivativeCalculationProcedure calculationProcedure;
		private final String id;
		
		protected PricingParameterDerivativeImpl(PricingParameterDerivative.PricingParameterDerivativeBuilder builder) {
			this.description = builder.getDescription();
			this.parameterReference = ofNullable(builder.getParameterReference()).map(f->f.build()).orElse(null);
			this.inputDateReference = ofNullable(builder.getInputDateReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationProcedure = ofNullable(builder.getCalculationProcedure()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference getParameterReference() {
			return parameterReference;
		}
		
		@Override
		@RosettaAttribute("inputDateReference")
		public List<? extends ValuationReference> getInputDateReference() {
			return inputDateReference;
		}
		
		@Override
		@RosettaAttribute("calculationProcedure")
		public DerivativeCalculationProcedure getCalculationProcedure() {
			return calculationProcedure;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PricingParameterDerivative build() {
			return this;
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder toBuilder() {
			PricingParameterDerivative.PricingParameterDerivativeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingParameterDerivative.PricingParameterDerivativeBuilder builder) {
			ofNullable(getDescription()).ifPresent(builder::setDescription);
			ofNullable(getParameterReference()).ifPresent(builder::setParameterReference);
			ofNullable(getInputDateReference()).ifPresent(builder::setInputDateReference);
			ofNullable(getCalculationProcedure()).ifPresent(builder::setCalculationProcedure);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterDerivative _that = getType().cast(o);
		
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!ListEquals.listEquals(inputDateReference, _that.getInputDateReference())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (inputDateReference != null ? inputDateReference.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterDerivative {" +
				"description=" + this.description + ", " +
				"parameterReference=" + this.parameterReference + ", " +
				"inputDateReference=" + this.inputDateReference + ", " +
				"calculationProcedure=" + this.calculationProcedure + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingParameterDerivative  ***********************/
	class PricingParameterDerivativeBuilderImpl implements PricingParameterDerivative.PricingParameterDerivativeBuilder {
	
		protected String description;
		protected AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder parameterReference;
		protected List<ValuationReference.ValuationReferenceBuilder> inputDateReference = new ArrayList<>();
		protected DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder calculationProcedure;
		protected String id;
	
		public PricingParameterDerivativeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference() {
			return parameterReference;
		}
		
		@Override
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference() {
			AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder result;
			if (parameterReference!=null) {
				result = parameterReference;
			}
			else {
				result = parameterReference = AssetOrTermPointOrPricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("inputDateReference")
		public List<? extends ValuationReference.ValuationReferenceBuilder> getInputDateReference() {
			return inputDateReference;
		}
		
		@Override
		public ValuationReference.ValuationReferenceBuilder getOrCreateInputDateReference(int _index) {
		
			if (inputDateReference==null) {
				this.inputDateReference = new ArrayList<>();
			}
			ValuationReference.ValuationReferenceBuilder result;
			return getIndex(inputDateReference, _index, () -> {
						ValuationReference.ValuationReferenceBuilder newInputDateReference = ValuationReference.builder();
						return newInputDateReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculationProcedure")
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getCalculationProcedure() {
			return calculationProcedure;
		}
		
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getOrCreateCalculationProcedure() {
			DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder result;
			if (calculationProcedure!=null) {
				result = calculationProcedure;
			}
			else {
				result = calculationProcedure = DerivativeCalculationProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("description")
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("parameterReference")
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference parameterReference) {
			this.parameterReference = parameterReference==null?null:parameterReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("inputDateReference")
		public PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference inputDateReference) {
			if (inputDateReference!=null) this.inputDateReference.add(inputDateReference.toBuilder());
			return this;
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference inputDateReference, int _idx) {
			getIndex(this.inputDateReference, _idx, () -> inputDateReference.toBuilder());
			return this;
		}
		@Override 
		public PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(List<? extends ValuationReference> inputDateReferences) {
			if (inputDateReferences != null) {
				for (ValuationReference toAdd : inputDateReferences) {
					this.inputDateReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setInputDateReference(List<? extends ValuationReference> inputDateReferences) {
			if (inputDateReferences == null)  {
				this.inputDateReference = new ArrayList<>();
			}
			else {
				this.inputDateReference = inputDateReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationProcedure")
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setCalculationProcedure(DerivativeCalculationProcedure calculationProcedure) {
			this.calculationProcedure = calculationProcedure==null?null:calculationProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PricingParameterDerivative build() {
			return new PricingParameterDerivative.PricingParameterDerivativeImpl(this);
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder prune() {
			if (parameterReference!=null && !parameterReference.prune().hasData()) parameterReference = null;
			inputDateReference = inputDateReference.stream().filter(b->b!=null).<ValuationReference.ValuationReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationProcedure!=null && !calculationProcedure.prune().hasData()) calculationProcedure = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDescription()!=null) return true;
			if (getParameterReference()!=null && getParameterReference().hasData()) return true;
			if (getInputDateReference()!=null && getInputDateReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationProcedure()!=null && getCalculationProcedure().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingParameterDerivative.PricingParameterDerivativeBuilder o = (PricingParameterDerivative.PricingParameterDerivativeBuilder) other;
			
			merger.mergeRosetta(getParameterReference(), o.getParameterReference(), this::setParameterReference);
			merger.mergeRosetta(getInputDateReference(), o.getInputDateReference(), this::getOrCreateInputDateReference);
			merger.mergeRosetta(getCalculationProcedure(), o.getCalculationProcedure(), this::setCalculationProcedure);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterDerivative _that = getType().cast(o);
		
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!ListEquals.listEquals(inputDateReference, _that.getInputDateReference())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (inputDateReference != null ? inputDateReference.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterDerivativeBuilder {" +
				"description=" + this.description + ", " +
				"parameterReference=" + this.parameterReference + ", " +
				"inputDateReference=" + this.inputDateReference + ", " +
				"calculationProcedure=" + this.calculationProcedure + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
