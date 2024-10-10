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
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingStructureValuation;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilder;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilderImpl;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationImpl;
import fpml.confirmation.Valuation;
import fpml.confirmation.Valuation.ValuationBuilder;
import fpml.confirmation.Valuation.ValuationBuilderImpl;
import fpml.confirmation.Valuation.ValuationImpl;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.PricingStructureValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract pricing structure valuation base type. Used as a base for values of pricing structures such as yield curves and volatility matrices. Derived from the &quot;Valuation&quot; type.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingStructureValuation", builder=PricingStructureValuation.PricingStructureValuationBuilderImpl.class, version="${project.version}")
public interface PricingStructureValuation extends Valuation {

	PricingStructureValuationMeta metaData = new PricingStructureValuationMeta();

	/*********************** Getter Methods  ***********************/
	PricingInputDatesModel getPricingInputDatesModel();

	/*********************** Build Methods  ***********************/
	PricingStructureValuation build();
	
	PricingStructureValuation.PricingStructureValuationBuilder toBuilder();
	
	static PricingStructureValuation.PricingStructureValuationBuilder builder() {
		return new PricingStructureValuation.PricingStructureValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructureValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingStructureValuation> getType() {
		return PricingStructureValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.class, getPricingInputDatesModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructureValuationBuilder extends PricingStructureValuation, Valuation.ValuationBuilder {
		PricingInputDatesModel.PricingInputDatesModelBuilder getOrCreatePricingInputDatesModel();
		PricingInputDatesModel.PricingInputDatesModelBuilder getPricingInputDatesModel();
		PricingStructureValuation.PricingStructureValuationBuilder setObjectReference(AnyAssetReference objectReference);
		PricingStructureValuation.PricingStructureValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		PricingStructureValuation.PricingStructureValuationBuilder setId(String id);
		PricingStructureValuation.PricingStructureValuationBuilder setDefinitionRef(String definitionRef);
		PricingStructureValuation.PricingStructureValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.PricingInputDatesModelBuilder.class, getPricingInputDatesModel());
		}
		

		PricingStructureValuation.PricingStructureValuationBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructureValuation  ***********************/
	class PricingStructureValuationImpl extends Valuation.ValuationImpl implements PricingStructureValuation {
		private final PricingInputDatesModel pricingInputDatesModel;
		
		protected PricingStructureValuationImpl(PricingStructureValuation.PricingStructureValuationBuilder builder) {
			super(builder);
			this.pricingInputDatesModel = ofNullable(builder.getPricingInputDatesModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public PricingInputDatesModel getPricingInputDatesModel() {
			return pricingInputDatesModel;
		}
		
		@Override
		public PricingStructureValuation build() {
			return this;
		}
		
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder toBuilder() {
			PricingStructureValuation.PricingStructureValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructureValuation.PricingStructureValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPricingInputDatesModel()).ifPresent(builder::setPricingInputDatesModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingStructureValuation _that = getType().cast(o);
		
			if (!Objects.equals(pricingInputDatesModel, _that.getPricingInputDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (pricingInputDatesModel != null ? pricingInputDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureValuation {" +
				"pricingInputDatesModel=" + this.pricingInputDatesModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PricingStructureValuation  ***********************/
	class PricingStructureValuationBuilderImpl extends Valuation.ValuationBuilderImpl  implements PricingStructureValuation.PricingStructureValuationBuilder {
	
		protected PricingInputDatesModel.PricingInputDatesModelBuilder pricingInputDatesModel;
	
		public PricingStructureValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public PricingInputDatesModel.PricingInputDatesModelBuilder getPricingInputDatesModel() {
			return pricingInputDatesModel;
		}
		
		@Override
		public PricingInputDatesModel.PricingInputDatesModelBuilder getOrCreatePricingInputDatesModel() {
			PricingInputDatesModel.PricingInputDatesModelBuilder result;
			if (pricingInputDatesModel!=null) {
				result = pricingInputDatesModel;
			}
			else {
				result = pricingInputDatesModel = PricingInputDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public PricingStructureValuation.PricingStructureValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public PricingStructureValuation.PricingStructureValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PricingStructureValuation.PricingStructureValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public PricingStructureValuation.PricingStructureValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public PricingStructureValuation.PricingStructureValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel) {
			this.pricingInputDatesModel = pricingInputDatesModel==null?null:pricingInputDatesModel.toBuilder();
			return this;
		}
		
		@Override
		public PricingStructureValuation build() {
			return new PricingStructureValuation.PricingStructureValuationImpl(this);
		}
		
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder prune() {
			super.prune();
			if (pricingInputDatesModel!=null && !pricingInputDatesModel.prune().hasData()) pricingInputDatesModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPricingInputDatesModel()!=null && getPricingInputDatesModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PricingStructureValuation.PricingStructureValuationBuilder o = (PricingStructureValuation.PricingStructureValuationBuilder) other;
			
			merger.mergeRosetta(getPricingInputDatesModel(), o.getPricingInputDatesModel(), this::setPricingInputDatesModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingStructureValuation _that = getType().cast(o);
		
			if (!Objects.equals(pricingInputDatesModel, _that.getPricingInputDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (pricingInputDatesModel != null ? pricingInputDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureValuationBuilder {" +
				"pricingInputDatesModel=" + this.pricingInputDatesModel +
			'}' + " " + super.toString();
		}
	}
}
