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
import fpml.confirmation.DefaultProbabilityCurve;
import fpml.confirmation.DefaultProbabilityCurve.DefaultProbabilityCurveBuilder;
import fpml.confirmation.DefaultProbabilityCurve.DefaultProbabilityCurveBuilderImpl;
import fpml.confirmation.DefaultProbabilityCurve.DefaultProbabilityCurveImpl;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.PricingStructureValuation;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilder;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilderImpl;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationImpl;
import fpml.confirmation.TermCurve;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.DefaultProbabilityCurveMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A set of default probabilities.
 * @version ${project.version}
 */
@RosettaDataType(value="DefaultProbabilityCurve", builder=DefaultProbabilityCurve.DefaultProbabilityCurveBuilderImpl.class, version="${project.version}")
public interface DefaultProbabilityCurve extends PricingStructureValuation {

	DefaultProbabilityCurveMeta metaData = new DefaultProbabilityCurveMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the yield curve values used as a basis for this credit curve valuation.
	 */
	PricingStructureReference getBaseYieldCurve();
	/**
	 * A collection of default probabilities.
	 */
	TermCurve getDefaultProbabilities();

	/*********************** Build Methods  ***********************/
	DefaultProbabilityCurve build();
	
	DefaultProbabilityCurve.DefaultProbabilityCurveBuilder toBuilder();
	
	static DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder() {
		return new DefaultProbabilityCurve.DefaultProbabilityCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DefaultProbabilityCurve> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DefaultProbabilityCurve> getType() {
		return DefaultProbabilityCurve.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.class, getPricingInputDatesModel());
		processRosetta(path.newSubPath("baseYieldCurve"), processor, PricingStructureReference.class, getBaseYieldCurve());
		processRosetta(path.newSubPath("defaultProbabilities"), processor, TermCurve.class, getDefaultProbabilities());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DefaultProbabilityCurveBuilder extends DefaultProbabilityCurve, PricingStructureValuation.PricingStructureValuationBuilder {
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateBaseYieldCurve();
		PricingStructureReference.PricingStructureReferenceBuilder getBaseYieldCurve();
		TermCurve.TermCurveBuilder getOrCreateDefaultProbabilities();
		TermCurve.TermCurveBuilder getDefaultProbabilities();
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setObjectReference(AnyAssetReference objectReference);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setId(String id);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefinitionRef(String definitionRef);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBaseYieldCurve(PricingStructureReference baseYieldCurve);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefaultProbabilities(TermCurve defaultProbabilities);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.PricingInputDatesModelBuilder.class, getPricingInputDatesModel());
			processRosetta(path.newSubPath("baseYieldCurve"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getBaseYieldCurve());
			processRosetta(path.newSubPath("defaultProbabilities"), processor, TermCurve.TermCurveBuilder.class, getDefaultProbabilities());
		}
		

		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder prune();
	}

	/*********************** Immutable Implementation of DefaultProbabilityCurve  ***********************/
	class DefaultProbabilityCurveImpl extends PricingStructureValuation.PricingStructureValuationImpl implements DefaultProbabilityCurve {
		private final PricingStructureReference baseYieldCurve;
		private final TermCurve defaultProbabilities;
		
		protected DefaultProbabilityCurveImpl(DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder) {
			super(builder);
			this.baseYieldCurve = ofNullable(builder.getBaseYieldCurve()).map(f->f.build()).orElse(null);
			this.defaultProbabilities = ofNullable(builder.getDefaultProbabilities()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("baseYieldCurve")
		public PricingStructureReference getBaseYieldCurve() {
			return baseYieldCurve;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilities")
		public TermCurve getDefaultProbabilities() {
			return defaultProbabilities;
		}
		
		@Override
		public DefaultProbabilityCurve build() {
			return this;
		}
		
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder toBuilder() {
			DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBaseYieldCurve()).ifPresent(builder::setBaseYieldCurve);
			ofNullable(getDefaultProbabilities()).ifPresent(builder::setDefaultProbabilities);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DefaultProbabilityCurve _that = getType().cast(o);
		
			if (!Objects.equals(baseYieldCurve, _that.getBaseYieldCurve())) return false;
			if (!Objects.equals(defaultProbabilities, _that.getDefaultProbabilities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (baseYieldCurve != null ? baseYieldCurve.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilities != null ? defaultProbabilities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DefaultProbabilityCurve {" +
				"baseYieldCurve=" + this.baseYieldCurve + ", " +
				"defaultProbabilities=" + this.defaultProbabilities +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DefaultProbabilityCurve  ***********************/
	class DefaultProbabilityCurveBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl  implements DefaultProbabilityCurve.DefaultProbabilityCurveBuilder {
	
		protected PricingStructureReference.PricingStructureReferenceBuilder baseYieldCurve;
		protected TermCurve.TermCurveBuilder defaultProbabilities;
	
		public DefaultProbabilityCurveBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("baseYieldCurve")
		public PricingStructureReference.PricingStructureReferenceBuilder getBaseYieldCurve() {
			return baseYieldCurve;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateBaseYieldCurve() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (baseYieldCurve!=null) {
				result = baseYieldCurve;
			}
			else {
				result = baseYieldCurve = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilities")
		public TermCurve.TermCurveBuilder getDefaultProbabilities() {
			return defaultProbabilities;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateDefaultProbabilities() {
			TermCurve.TermCurveBuilder result;
			if (defaultProbabilities!=null) {
				result = defaultProbabilities;
			}
			else {
				result = defaultProbabilities = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel) {
			this.pricingInputDatesModel = pricingInputDatesModel==null?null:pricingInputDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("baseYieldCurve")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBaseYieldCurve(PricingStructureReference baseYieldCurve) {
			this.baseYieldCurve = baseYieldCurve==null?null:baseYieldCurve.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("defaultProbabilities")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefaultProbabilities(TermCurve defaultProbabilities) {
			this.defaultProbabilities = defaultProbabilities==null?null:defaultProbabilities.toBuilder();
			return this;
		}
		
		@Override
		public DefaultProbabilityCurve build() {
			return new DefaultProbabilityCurve.DefaultProbabilityCurveImpl(this);
		}
		
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder prune() {
			super.prune();
			if (baseYieldCurve!=null && !baseYieldCurve.prune().hasData()) baseYieldCurve = null;
			if (defaultProbabilities!=null && !defaultProbabilities.prune().hasData()) defaultProbabilities = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBaseYieldCurve()!=null && getBaseYieldCurve().hasData()) return true;
			if (getDefaultProbabilities()!=null && getDefaultProbabilities().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DefaultProbabilityCurve.DefaultProbabilityCurveBuilder o = (DefaultProbabilityCurve.DefaultProbabilityCurveBuilder) other;
			
			merger.mergeRosetta(getBaseYieldCurve(), o.getBaseYieldCurve(), this::setBaseYieldCurve);
			merger.mergeRosetta(getDefaultProbabilities(), o.getDefaultProbabilities(), this::setDefaultProbabilities);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DefaultProbabilityCurve _that = getType().cast(o);
		
			if (!Objects.equals(baseYieldCurve, _that.getBaseYieldCurve())) return false;
			if (!Objects.equals(defaultProbabilities, _that.getDefaultProbabilities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (baseYieldCurve != null ? baseYieldCurve.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilities != null ? defaultProbabilities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DefaultProbabilityCurveBuilder {" +
				"baseYieldCurve=" + this.baseYieldCurve + ", " +
				"defaultProbabilities=" + this.defaultProbabilities +
			'}' + " " + super.toString();
		}
	}
}
