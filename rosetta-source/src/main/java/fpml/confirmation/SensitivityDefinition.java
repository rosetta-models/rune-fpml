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
import fpml.confirmation.ComputedDerivativeModel;
import fpml.confirmation.SensitivityDefinition;
import fpml.confirmation.SensitivityDefinition.SensitivityDefinitionBuilder;
import fpml.confirmation.SensitivityDefinition.SensitivityDefinitionBuilderImpl;
import fpml.confirmation.SensitivityDefinition.SensitivityDefinitionImpl;
import fpml.confirmation.SensitivityDescriptionModel;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.SensitivityDefinitionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A set of characteristics describing a sensitivity.
 * @version ${project.version}
 */
@RosettaDataType(value="SensitivityDefinition", builder=SensitivityDefinition.SensitivityDefinitionBuilderImpl.class, version="${project.version}")
public interface SensitivityDefinition extends RosettaModelObject {

	SensitivityDefinitionMeta metaData = new SensitivityDefinitionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the derivative, e.g. first derivative, Hessian, etc. Typically not required, but may be used to explain more complex derivative calculations.
	 */
	String getName();
	/**
	 * Reference to the valuation scenario to which this sensitivity definition applies. If the SensitivityDefinition occurs within a SensitivitySetDefinition, this is not required and normally not used. In this case, if it is supplied it overrides the valuationScenarioReference in the SensitivitySetDefinition.
	 */
	ValuationScenarioReference getValuationScenarioReference();
	ComputedDerivativeModel getComputedDerivativeModel();
	SensitivityDescriptionModel getSensitivityDescriptionModel();
	String getId();

	/*********************** Build Methods  ***********************/
	SensitivityDefinition build();
	
	SensitivityDefinition.SensitivityDefinitionBuilder toBuilder();
	
	static SensitivityDefinition.SensitivityDefinitionBuilder builder() {
		return new SensitivityDefinition.SensitivityDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivityDefinition> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SensitivityDefinition> getType() {
		return SensitivityDefinition.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("computedDerivativeModel"), processor, ComputedDerivativeModel.class, getComputedDerivativeModel());
		processRosetta(path.newSubPath("sensitivityDescriptionModel"), processor, SensitivityDescriptionModel.class, getSensitivityDescriptionModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivityDefinitionBuilder extends SensitivityDefinition, RosettaModelObjectBuilder {
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference();
		ComputedDerivativeModel.ComputedDerivativeModelBuilder getOrCreateComputedDerivativeModel();
		ComputedDerivativeModel.ComputedDerivativeModelBuilder getComputedDerivativeModel();
		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder getOrCreateSensitivityDescriptionModel();
		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder getSensitivityDescriptionModel();
		SensitivityDefinition.SensitivityDefinitionBuilder setName(String name);
		SensitivityDefinition.SensitivityDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		SensitivityDefinition.SensitivityDefinitionBuilder setComputedDerivativeModel(ComputedDerivativeModel computedDerivativeModel);
		SensitivityDefinition.SensitivityDefinitionBuilder setSensitivityDescriptionModel(SensitivityDescriptionModel sensitivityDescriptionModel);
		SensitivityDefinition.SensitivityDefinitionBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("computedDerivativeModel"), processor, ComputedDerivativeModel.ComputedDerivativeModelBuilder.class, getComputedDerivativeModel());
			processRosetta(path.newSubPath("sensitivityDescriptionModel"), processor, SensitivityDescriptionModel.SensitivityDescriptionModelBuilder.class, getSensitivityDescriptionModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SensitivityDefinition.SensitivityDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivityDefinition  ***********************/
	class SensitivityDefinitionImpl implements SensitivityDefinition {
		private final String name;
		private final ValuationScenarioReference valuationScenarioReference;
		private final ComputedDerivativeModel computedDerivativeModel;
		private final SensitivityDescriptionModel sensitivityDescriptionModel;
		private final String id;
		
		protected SensitivityDefinitionImpl(SensitivityDefinition.SensitivityDefinitionBuilder builder) {
			this.name = builder.getName();
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).map(f->f.build()).orElse(null);
			this.computedDerivativeModel = ofNullable(builder.getComputedDerivativeModel()).map(f->f.build()).orElse(null);
			this.sensitivityDescriptionModel = ofNullable(builder.getSensitivityDescriptionModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public ValuationScenarioReference getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		@RosettaAttribute("computedDerivativeModel")
		public ComputedDerivativeModel getComputedDerivativeModel() {
			return computedDerivativeModel;
		}
		
		@Override
		@RosettaAttribute("sensitivityDescriptionModel")
		public SensitivityDescriptionModel getSensitivityDescriptionModel() {
			return sensitivityDescriptionModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SensitivityDefinition build() {
			return this;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder toBuilder() {
			SensitivityDefinition.SensitivityDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityDefinition.SensitivityDefinitionBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
			ofNullable(getComputedDerivativeModel()).ifPresent(builder::setComputedDerivativeModel);
			ofNullable(getSensitivityDescriptionModel()).ifPresent(builder::setSensitivityDescriptionModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDefinition _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(computedDerivativeModel, _that.getComputedDerivativeModel())) return false;
			if (!Objects.equals(sensitivityDescriptionModel, _that.getSensitivityDescriptionModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (computedDerivativeModel != null ? computedDerivativeModel.hashCode() : 0);
			_result = 31 * _result + (sensitivityDescriptionModel != null ? sensitivityDescriptionModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityDefinition {" +
				"name=" + this.name + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"computedDerivativeModel=" + this.computedDerivativeModel + ", " +
				"sensitivityDescriptionModel=" + this.sensitivityDescriptionModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivityDefinition  ***********************/
	class SensitivityDefinitionBuilderImpl implements SensitivityDefinition.SensitivityDefinitionBuilder {
	
		protected String name;
		protected ValuationScenarioReference.ValuationScenarioReferenceBuilder valuationScenarioReference;
		protected ComputedDerivativeModel.ComputedDerivativeModelBuilder computedDerivativeModel;
		protected SensitivityDescriptionModel.SensitivityDescriptionModelBuilder sensitivityDescriptionModel;
		protected String id;
	
		public SensitivityDefinitionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
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
		@RosettaAttribute("computedDerivativeModel")
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder getComputedDerivativeModel() {
			return computedDerivativeModel;
		}
		
		@Override
		public ComputedDerivativeModel.ComputedDerivativeModelBuilder getOrCreateComputedDerivativeModel() {
			ComputedDerivativeModel.ComputedDerivativeModelBuilder result;
			if (computedDerivativeModel!=null) {
				result = computedDerivativeModel;
			}
			else {
				result = computedDerivativeModel = ComputedDerivativeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sensitivityDescriptionModel")
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder getSensitivityDescriptionModel() {
			return sensitivityDescriptionModel;
		}
		
		@Override
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder getOrCreateSensitivityDescriptionModel() {
			SensitivityDescriptionModel.SensitivityDescriptionModelBuilder result;
			if (sensitivityDescriptionModel!=null) {
				result = sensitivityDescriptionModel;
			}
			else {
				result = sensitivityDescriptionModel = SensitivityDescriptionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		public SensitivityDefinition.SensitivityDefinitionBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public SensitivityDefinition.SensitivityDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("computedDerivativeModel")
		public SensitivityDefinition.SensitivityDefinitionBuilder setComputedDerivativeModel(ComputedDerivativeModel computedDerivativeModel) {
			this.computedDerivativeModel = computedDerivativeModel==null?null:computedDerivativeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sensitivityDescriptionModel")
		public SensitivityDefinition.SensitivityDefinitionBuilder setSensitivityDescriptionModel(SensitivityDescriptionModel sensitivityDescriptionModel) {
			this.sensitivityDescriptionModel = sensitivityDescriptionModel==null?null:sensitivityDescriptionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SensitivityDefinition.SensitivityDefinitionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SensitivityDefinition build() {
			return new SensitivityDefinition.SensitivityDefinitionImpl(this);
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder prune() {
			if (valuationScenarioReference!=null && !valuationScenarioReference.prune().hasData()) valuationScenarioReference = null;
			if (computedDerivativeModel!=null && !computedDerivativeModel.prune().hasData()) computedDerivativeModel = null;
			if (sensitivityDescriptionModel!=null && !sensitivityDescriptionModel.prune().hasData()) sensitivityDescriptionModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().hasData()) return true;
			if (getComputedDerivativeModel()!=null && getComputedDerivativeModel().hasData()) return true;
			if (getSensitivityDescriptionModel()!=null && getSensitivityDescriptionModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityDefinition.SensitivityDefinitionBuilder o = (SensitivityDefinition.SensitivityDefinitionBuilder) other;
			
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::setValuationScenarioReference);
			merger.mergeRosetta(getComputedDerivativeModel(), o.getComputedDerivativeModel(), this::setComputedDerivativeModel);
			merger.mergeRosetta(getSensitivityDescriptionModel(), o.getSensitivityDescriptionModel(), this::setSensitivityDescriptionModel);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDefinition _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(computedDerivativeModel, _that.getComputedDerivativeModel())) return false;
			if (!Objects.equals(sensitivityDescriptionModel, _that.getSensitivityDescriptionModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (computedDerivativeModel != null ? computedDerivativeModel.hashCode() : 0);
			_result = 31 * _result + (sensitivityDescriptionModel != null ? sensitivityDescriptionModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityDefinitionBuilder {" +
				"name=" + this.name + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"computedDerivativeModel=" + this.computedDerivativeModel + ", " +
				"sensitivityDescriptionModel=" + this.sensitivityDescriptionModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
