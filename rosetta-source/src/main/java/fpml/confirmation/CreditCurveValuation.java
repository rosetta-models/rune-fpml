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
import fpml.confirmation.CreditCurveValuation;
import fpml.confirmation.CreditCurveValuation.CreditCurveValuationBuilder;
import fpml.confirmation.CreditCurveValuation.CreditCurveValuationBuilderImpl;
import fpml.confirmation.CreditCurveValuation.CreditCurveValuationImpl;
import fpml.confirmation.DefaultProbabilityCurve;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingStructureValuation;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilder;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilderImpl;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationImpl;
import fpml.confirmation.QuotedAssetSet;
import fpml.confirmation.RecoveryRateModel;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.CreditCurveValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A set of credit curve values, which can include pricing inputs (which are typically credit spreads), default probabilities, and recovery rates.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditCurveValuation", builder=CreditCurveValuation.CreditCurveValuationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditCurveValuation extends PricingStructureValuation {

	CreditCurveValuationMeta metaData = new CreditCurveValuationMeta();

	/*********************** Getter Methods  ***********************/
	QuotedAssetSet getInputs();
	/**
	 * A curve of default probabilities.
	 */
	DefaultProbabilityCurve getDefaultProbabilityCurve();
	RecoveryRateModel getRecoveryRateModel();

	/*********************** Build Methods  ***********************/
	CreditCurveValuation build();
	
	CreditCurveValuation.CreditCurveValuationBuilder toBuilder();
	
	static CreditCurveValuation.CreditCurveValuationBuilder builder() {
		return new CreditCurveValuation.CreditCurveValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditCurveValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditCurveValuation> getType() {
		return CreditCurveValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.class, getPricingInputDatesModel());
		processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.class, getInputs());
		processRosetta(path.newSubPath("defaultProbabilityCurve"), processor, DefaultProbabilityCurve.class, getDefaultProbabilityCurve());
		processRosetta(path.newSubPath("recoveryRateModel"), processor, RecoveryRateModel.class, getRecoveryRateModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditCurveValuationBuilder extends CreditCurveValuation, PricingStructureValuation.PricingStructureValuationBuilder {
		QuotedAssetSet.QuotedAssetSetBuilder getOrCreateInputs();
		QuotedAssetSet.QuotedAssetSetBuilder getInputs();
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getOrCreateDefaultProbabilityCurve();
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getDefaultProbabilityCurve();
		RecoveryRateModel.RecoveryRateModelBuilder getOrCreateRecoveryRateModel();
		RecoveryRateModel.RecoveryRateModelBuilder getRecoveryRateModel();
		CreditCurveValuation.CreditCurveValuationBuilder setObjectReference(AnyAssetReference objectReference);
		CreditCurveValuation.CreditCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		CreditCurveValuation.CreditCurveValuationBuilder setId(String id);
		CreditCurveValuation.CreditCurveValuationBuilder setDefinitionRef(String definitionRef);
		CreditCurveValuation.CreditCurveValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel);
		CreditCurveValuation.CreditCurveValuationBuilder setInputs(QuotedAssetSet inputs);
		CreditCurveValuation.CreditCurveValuationBuilder setDefaultProbabilityCurve(DefaultProbabilityCurve defaultProbabilityCurve);
		CreditCurveValuation.CreditCurveValuationBuilder setRecoveryRateModel(RecoveryRateModel recoveryRateModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.PricingInputDatesModelBuilder.class, getPricingInputDatesModel());
			processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.QuotedAssetSetBuilder.class, getInputs());
			processRosetta(path.newSubPath("defaultProbabilityCurve"), processor, DefaultProbabilityCurve.DefaultProbabilityCurveBuilder.class, getDefaultProbabilityCurve());
			processRosetta(path.newSubPath("recoveryRateModel"), processor, RecoveryRateModel.RecoveryRateModelBuilder.class, getRecoveryRateModel());
		}
		

		CreditCurveValuation.CreditCurveValuationBuilder prune();
	}

	/*********************** Immutable Implementation of CreditCurveValuation  ***********************/
	class CreditCurveValuationImpl extends PricingStructureValuation.PricingStructureValuationImpl implements CreditCurveValuation {
		private final QuotedAssetSet inputs;
		private final DefaultProbabilityCurve defaultProbabilityCurve;
		private final RecoveryRateModel recoveryRateModel;
		
		protected CreditCurveValuationImpl(CreditCurveValuation.CreditCurveValuationBuilder builder) {
			super(builder);
			this.inputs = ofNullable(builder.getInputs()).map(f->f.build()).orElse(null);
			this.defaultProbabilityCurve = ofNullable(builder.getDefaultProbabilityCurve()).map(f->f.build()).orElse(null);
			this.recoveryRateModel = ofNullable(builder.getRecoveryRateModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inputs")
		public QuotedAssetSet getInputs() {
			return inputs;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilityCurve")
		public DefaultProbabilityCurve getDefaultProbabilityCurve() {
			return defaultProbabilityCurve;
		}
		
		@Override
		@RosettaAttribute("recoveryRateModel")
		public RecoveryRateModel getRecoveryRateModel() {
			return recoveryRateModel;
		}
		
		@Override
		public CreditCurveValuation build() {
			return this;
		}
		
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder toBuilder() {
			CreditCurveValuation.CreditCurveValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditCurveValuation.CreditCurveValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInputs()).ifPresent(builder::setInputs);
			ofNullable(getDefaultProbabilityCurve()).ifPresent(builder::setDefaultProbabilityCurve);
			ofNullable(getRecoveryRateModel()).ifPresent(builder::setRecoveryRateModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(defaultProbabilityCurve, _that.getDefaultProbabilityCurve())) return false;
			if (!Objects.equals(recoveryRateModel, _that.getRecoveryRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilityCurve != null ? defaultProbabilityCurve.hashCode() : 0);
			_result = 31 * _result + (recoveryRateModel != null ? recoveryRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveValuation {" +
				"inputs=" + this.inputs + ", " +
				"defaultProbabilityCurve=" + this.defaultProbabilityCurve + ", " +
				"recoveryRateModel=" + this.recoveryRateModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditCurveValuation  ***********************/
	class CreditCurveValuationBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl  implements CreditCurveValuation.CreditCurveValuationBuilder {
	
		protected QuotedAssetSet.QuotedAssetSetBuilder inputs;
		protected DefaultProbabilityCurve.DefaultProbabilityCurveBuilder defaultProbabilityCurve;
		protected RecoveryRateModel.RecoveryRateModelBuilder recoveryRateModel;
	
		public CreditCurveValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("inputs")
		public QuotedAssetSet.QuotedAssetSetBuilder getInputs() {
			return inputs;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder getOrCreateInputs() {
			QuotedAssetSet.QuotedAssetSetBuilder result;
			if (inputs!=null) {
				result = inputs;
			}
			else {
				result = inputs = QuotedAssetSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilityCurve")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getDefaultProbabilityCurve() {
			return defaultProbabilityCurve;
		}
		
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getOrCreateDefaultProbabilityCurve() {
			DefaultProbabilityCurve.DefaultProbabilityCurveBuilder result;
			if (defaultProbabilityCurve!=null) {
				result = defaultProbabilityCurve;
			}
			else {
				result = defaultProbabilityCurve = DefaultProbabilityCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("recoveryRateModel")
		public RecoveryRateModel.RecoveryRateModelBuilder getRecoveryRateModel() {
			return recoveryRateModel;
		}
		
		@Override
		public RecoveryRateModel.RecoveryRateModelBuilder getOrCreateRecoveryRateModel() {
			RecoveryRateModel.RecoveryRateModelBuilder result;
			if (recoveryRateModel!=null) {
				result = recoveryRateModel;
			}
			else {
				result = recoveryRateModel = RecoveryRateModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public CreditCurveValuation.CreditCurveValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public CreditCurveValuation.CreditCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CreditCurveValuation.CreditCurveValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public CreditCurveValuation.CreditCurveValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public CreditCurveValuation.CreditCurveValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel) {
			this.pricingInputDatesModel = pricingInputDatesModel==null?null:pricingInputDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("inputs")
		public CreditCurveValuation.CreditCurveValuationBuilder setInputs(QuotedAssetSet inputs) {
			this.inputs = inputs==null?null:inputs.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("defaultProbabilityCurve")
		public CreditCurveValuation.CreditCurveValuationBuilder setDefaultProbabilityCurve(DefaultProbabilityCurve defaultProbabilityCurve) {
			this.defaultProbabilityCurve = defaultProbabilityCurve==null?null:defaultProbabilityCurve.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("recoveryRateModel")
		public CreditCurveValuation.CreditCurveValuationBuilder setRecoveryRateModel(RecoveryRateModel recoveryRateModel) {
			this.recoveryRateModel = recoveryRateModel==null?null:recoveryRateModel.toBuilder();
			return this;
		}
		
		@Override
		public CreditCurveValuation build() {
			return new CreditCurveValuation.CreditCurveValuationImpl(this);
		}
		
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder prune() {
			super.prune();
			if (inputs!=null && !inputs.prune().hasData()) inputs = null;
			if (defaultProbabilityCurve!=null && !defaultProbabilityCurve.prune().hasData()) defaultProbabilityCurve = null;
			if (recoveryRateModel!=null && !recoveryRateModel.prune().hasData()) recoveryRateModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInputs()!=null && getInputs().hasData()) return true;
			if (getDefaultProbabilityCurve()!=null && getDefaultProbabilityCurve().hasData()) return true;
			if (getRecoveryRateModel()!=null && getRecoveryRateModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditCurveValuation.CreditCurveValuationBuilder o = (CreditCurveValuation.CreditCurveValuationBuilder) other;
			
			merger.mergeRosetta(getInputs(), o.getInputs(), this::setInputs);
			merger.mergeRosetta(getDefaultProbabilityCurve(), o.getDefaultProbabilityCurve(), this::setDefaultProbabilityCurve);
			merger.mergeRosetta(getRecoveryRateModel(), o.getRecoveryRateModel(), this::setRecoveryRateModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(defaultProbabilityCurve, _that.getDefaultProbabilityCurve())) return false;
			if (!Objects.equals(recoveryRateModel, _that.getRecoveryRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilityCurve != null ? defaultProbabilityCurve.hashCode() : 0);
			_result = 31 * _result + (recoveryRateModel != null ? recoveryRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveValuationBuilder {" +
				"inputs=" + this.inputs + ", " +
				"defaultProbabilityCurve=" + this.defaultProbabilityCurve + ", " +
				"recoveryRateModel=" + this.recoveryRateModel +
			'}' + " " + super.toString();
		}
	}
}
