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
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.PricingInputType;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.SensitivityDefinition;
import fpml.confirmation.SensitivitySetDefinition;
import fpml.confirmation.SensitivitySetDefinition.SensitivitySetDefinitionBuilder;
import fpml.confirmation.SensitivitySetDefinition.SensitivitySetDefinitionBuilderImpl;
import fpml.confirmation.SensitivitySetDefinition.SensitivitySetDefinitionImpl;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.SensitivitySetDefinitionMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A sensitivity report definition, consisting of a collection of sensitivity definitions.
 * @version ${project.version}
 */
@RosettaDataType(value="SensitivitySetDefinition", builder=SensitivitySetDefinition.SensitivitySetDefinitionBuilderImpl.class, version="${project.version}")
public interface SensitivitySetDefinition extends RosettaModelObject {

	SensitivitySetDefinitionMeta metaData = new SensitivitySetDefinitionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the sensitivity set definition, e.g. &quot;USDLIBOR curve sensitivities&quot;.
	 */
	String getName();
	/**
	 * The default characteristics of the quotation, e.g. type, units, etc.
	 */
	QuotationCharacteristics getSensitivityCharacteristics();
	/**
	 * Reference to the valuation scenario to which this sensitivity definition applies, e.g. a reference to the EOD valuation scenario. If not supplied, this sensitivity set definition is generic to a variety of valuation scenarios.
	 */
	ValuationScenarioReference getValuationScenarioReference();
	/**
	 * The type of the pricing input to which the sensitivity is shown, e.g. a yield curve or volatility matrix.
	 */
	PricingInputType getPricingInputType();
	/**
	 * A reference to the pricing input to which the sensitivity is shown, e.g. a reference to a USDLIBOR yield curve.
	 */
	PricingStructureReference getPricingInputReference();
	/**
	 * The size of the denominator, e.g. 0.0001 = 1 bp. For derivatives with respect to time, the default period is 1 day.
	 */
	BigDecimal getScale();
	/**
	 * A set of sensitivity definitions. Either one per point reported, or one generic definition that applies to all points.
	 */
	List<? extends SensitivityDefinition> getSensitivityDefinition();
	/**
	 * The method by which each derivative is computed, e.g. analytic, numerical model, perturbation, etc., and the corresponding parameters (eg. shift amounts).
	 */
	DerivativeCalculationProcedure getCalculationProcedure();
	String getId();

	/*********************** Build Methods  ***********************/
	SensitivitySetDefinition build();
	
	SensitivitySetDefinition.SensitivitySetDefinitionBuilder toBuilder();
	
	static SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder() {
		return new SensitivitySetDefinition.SensitivitySetDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivitySetDefinition> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SensitivitySetDefinition> getType() {
		return SensitivitySetDefinition.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("sensitivityCharacteristics"), processor, QuotationCharacteristics.class, getSensitivityCharacteristics());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("pricingInputType"), processor, PricingInputType.class, getPricingInputType());
		processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.class, getPricingInputReference());
		processor.processBasic(path.newSubPath("scale"), BigDecimal.class, getScale(), this);
		processRosetta(path.newSubPath("sensitivityDefinition"), processor, SensitivityDefinition.class, getSensitivityDefinition());
		processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.class, getCalculationProcedure());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivitySetDefinitionBuilder extends SensitivitySetDefinition, RosettaModelObjectBuilder {
		QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateSensitivityCharacteristics();
		QuotationCharacteristics.QuotationCharacteristicsBuilder getSensitivityCharacteristics();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference();
		PricingInputType.PricingInputTypeBuilder getOrCreatePricingInputType();
		PricingInputType.PricingInputTypeBuilder getPricingInputType();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference();
		PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference();
		SensitivityDefinition.SensitivityDefinitionBuilder getOrCreateSensitivityDefinition(int _index);
		List<? extends SensitivityDefinition.SensitivityDefinitionBuilder> getSensitivityDefinition();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getOrCreateCalculationProcedure();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getCalculationProcedure();
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setName(String name);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityCharacteristics(QuotationCharacteristics sensitivityCharacteristics);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputType(PricingInputType pricingInputType);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputReference(PricingStructureReference pricingInputReference);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setScale(BigDecimal scale);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition sensitivityDefinition0);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition sensitivityDefinition1, int _idx);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinition2);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinition3);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setCalculationProcedure(DerivativeCalculationProcedure calculationProcedure);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("sensitivityCharacteristics"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getSensitivityCharacteristics());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("pricingInputType"), processor, PricingInputType.PricingInputTypeBuilder.class, getPricingInputType());
			processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getPricingInputReference());
			processor.processBasic(path.newSubPath("scale"), BigDecimal.class, getScale(), this);
			processRosetta(path.newSubPath("sensitivityDefinition"), processor, SensitivityDefinition.SensitivityDefinitionBuilder.class, getSensitivityDefinition());
			processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder.class, getCalculationProcedure());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SensitivitySetDefinition.SensitivitySetDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivitySetDefinition  ***********************/
	class SensitivitySetDefinitionImpl implements SensitivitySetDefinition {
		private final String name;
		private final QuotationCharacteristics sensitivityCharacteristics;
		private final ValuationScenarioReference valuationScenarioReference;
		private final PricingInputType pricingInputType;
		private final PricingStructureReference pricingInputReference;
		private final BigDecimal scale;
		private final List<? extends SensitivityDefinition> sensitivityDefinition;
		private final DerivativeCalculationProcedure calculationProcedure;
		private final String id;
		
		protected SensitivitySetDefinitionImpl(SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder) {
			this.name = builder.getName();
			this.sensitivityCharacteristics = ofNullable(builder.getSensitivityCharacteristics()).map(f->f.build()).orElse(null);
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).map(f->f.build()).orElse(null);
			this.pricingInputType = ofNullable(builder.getPricingInputType()).map(f->f.build()).orElse(null);
			this.pricingInputReference = ofNullable(builder.getPricingInputReference()).map(f->f.build()).orElse(null);
			this.scale = builder.getScale();
			this.sensitivityDefinition = ofNullable(builder.getSensitivityDefinition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationProcedure = ofNullable(builder.getCalculationProcedure()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("sensitivityCharacteristics")
		public QuotationCharacteristics getSensitivityCharacteristics() {
			return sensitivityCharacteristics;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public ValuationScenarioReference getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		@RosettaAttribute("pricingInputType")
		public PricingInputType getPricingInputType() {
			return pricingInputType;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		public PricingStructureReference getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		@RosettaAttribute("scale")
		public BigDecimal getScale() {
			return scale;
		}
		
		@Override
		@RosettaAttribute("sensitivityDefinition")
		public List<? extends SensitivityDefinition> getSensitivityDefinition() {
			return sensitivityDefinition;
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
		public SensitivitySetDefinition build() {
			return this;
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder toBuilder() {
			SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getSensitivityCharacteristics()).ifPresent(builder::setSensitivityCharacteristics);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
			ofNullable(getPricingInputType()).ifPresent(builder::setPricingInputType);
			ofNullable(getPricingInputReference()).ifPresent(builder::setPricingInputReference);
			ofNullable(getScale()).ifPresent(builder::setScale);
			ofNullable(getSensitivityDefinition()).ifPresent(builder::setSensitivityDefinition);
			ofNullable(getCalculationProcedure()).ifPresent(builder::setCalculationProcedure);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySetDefinition _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(sensitivityCharacteristics, _that.getSensitivityCharacteristics())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(pricingInputType, _that.getPricingInputType())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			if (!Objects.equals(scale, _that.getScale())) return false;
			if (!ListEquals.listEquals(sensitivityDefinition, _that.getSensitivityDefinition())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (sensitivityCharacteristics != null ? sensitivityCharacteristics.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputType != null ? pricingInputType.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			_result = 31 * _result + (scale != null ? scale.hashCode() : 0);
			_result = 31 * _result + (sensitivityDefinition != null ? sensitivityDefinition.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySetDefinition {" +
				"name=" + this.name + ", " +
				"sensitivityCharacteristics=" + this.sensitivityCharacteristics + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"pricingInputType=" + this.pricingInputType + ", " +
				"pricingInputReference=" + this.pricingInputReference + ", " +
				"scale=" + this.scale + ", " +
				"sensitivityDefinition=" + this.sensitivityDefinition + ", " +
				"calculationProcedure=" + this.calculationProcedure + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivitySetDefinition  ***********************/
	class SensitivitySetDefinitionBuilderImpl implements SensitivitySetDefinition.SensitivitySetDefinitionBuilder {
	
		protected String name;
		protected QuotationCharacteristics.QuotationCharacteristicsBuilder sensitivityCharacteristics;
		protected ValuationScenarioReference.ValuationScenarioReferenceBuilder valuationScenarioReference;
		protected PricingInputType.PricingInputTypeBuilder pricingInputType;
		protected PricingStructureReference.PricingStructureReferenceBuilder pricingInputReference;
		protected BigDecimal scale;
		protected List<SensitivityDefinition.SensitivityDefinitionBuilder> sensitivityDefinition = new ArrayList<>();
		protected DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder calculationProcedure;
		protected String id;
	
		public SensitivitySetDefinitionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("sensitivityCharacteristics")
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getSensitivityCharacteristics() {
			return sensitivityCharacteristics;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateSensitivityCharacteristics() {
			QuotationCharacteristics.QuotationCharacteristicsBuilder result;
			if (sensitivityCharacteristics!=null) {
				result = sensitivityCharacteristics;
			}
			else {
				result = sensitivityCharacteristics = QuotationCharacteristics.builder();
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
		@RosettaAttribute("pricingInputType")
		public PricingInputType.PricingInputTypeBuilder getPricingInputType() {
			return pricingInputType;
		}
		
		@Override
		public PricingInputType.PricingInputTypeBuilder getOrCreatePricingInputType() {
			PricingInputType.PricingInputTypeBuilder result;
			if (pricingInputType!=null) {
				result = pricingInputType;
			}
			else {
				result = pricingInputType = PricingInputType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (pricingInputReference!=null) {
				result = pricingInputReference;
			}
			else {
				result = pricingInputReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scale")
		public BigDecimal getScale() {
			return scale;
		}
		
		@Override
		@RosettaAttribute("sensitivityDefinition")
		public List<? extends SensitivityDefinition.SensitivityDefinitionBuilder> getSensitivityDefinition() {
			return sensitivityDefinition;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder getOrCreateSensitivityDefinition(int _index) {
		
			if (sensitivityDefinition==null) {
				this.sensitivityDefinition = new ArrayList<>();
			}
			SensitivityDefinition.SensitivityDefinitionBuilder result;
			return getIndex(sensitivityDefinition, _index, () -> {
						SensitivityDefinition.SensitivityDefinitionBuilder newSensitivityDefinition = SensitivityDefinition.builder();
						return newSensitivityDefinition;
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
		@RosettaAttribute("name")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("sensitivityCharacteristics")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityCharacteristics(QuotationCharacteristics sensitivityCharacteristics) {
			this.sensitivityCharacteristics = sensitivityCharacteristics==null?null:sensitivityCharacteristics.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputType")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputType(PricingInputType pricingInputType) {
			this.pricingInputType = pricingInputType==null?null:pricingInputType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputReference")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputReference(PricingStructureReference pricingInputReference) {
			this.pricingInputReference = pricingInputReference==null?null:pricingInputReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("scale")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setScale(BigDecimal scale) {
			this.scale = scale==null?null:scale;
			return this;
		}
		@Override
		@RosettaAttribute("sensitivityDefinition")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition sensitivityDefinition) {
			if (sensitivityDefinition!=null) this.sensitivityDefinition.add(sensitivityDefinition.toBuilder());
			return this;
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition sensitivityDefinition, int _idx) {
			getIndex(this.sensitivityDefinition, _idx, () -> sensitivityDefinition.toBuilder());
			return this;
		}
		@Override 
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinitions) {
			if (sensitivityDefinitions != null) {
				for (SensitivityDefinition toAdd : sensitivityDefinitions) {
					this.sensitivityDefinition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinitions) {
			if (sensitivityDefinitions == null)  {
				this.sensitivityDefinition = new ArrayList<>();
			}
			else {
				this.sensitivityDefinition = sensitivityDefinitions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationProcedure")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setCalculationProcedure(DerivativeCalculationProcedure calculationProcedure) {
			this.calculationProcedure = calculationProcedure==null?null:calculationProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SensitivitySetDefinition build() {
			return new SensitivitySetDefinition.SensitivitySetDefinitionImpl(this);
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder prune() {
			if (sensitivityCharacteristics!=null && !sensitivityCharacteristics.prune().hasData()) sensitivityCharacteristics = null;
			if (valuationScenarioReference!=null && !valuationScenarioReference.prune().hasData()) valuationScenarioReference = null;
			if (pricingInputType!=null && !pricingInputType.prune().hasData()) pricingInputType = null;
			if (pricingInputReference!=null && !pricingInputReference.prune().hasData()) pricingInputReference = null;
			sensitivityDefinition = sensitivityDefinition.stream().filter(b->b!=null).<SensitivityDefinition.SensitivityDefinitionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationProcedure!=null && !calculationProcedure.prune().hasData()) calculationProcedure = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getSensitivityCharacteristics()!=null && getSensitivityCharacteristics().hasData()) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().hasData()) return true;
			if (getPricingInputType()!=null && getPricingInputType().hasData()) return true;
			if (getPricingInputReference()!=null && getPricingInputReference().hasData()) return true;
			if (getScale()!=null) return true;
			if (getSensitivityDefinition()!=null && getSensitivityDefinition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationProcedure()!=null && getCalculationProcedure().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivitySetDefinition.SensitivitySetDefinitionBuilder o = (SensitivitySetDefinition.SensitivitySetDefinitionBuilder) other;
			
			merger.mergeRosetta(getSensitivityCharacteristics(), o.getSensitivityCharacteristics(), this::setSensitivityCharacteristics);
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::setValuationScenarioReference);
			merger.mergeRosetta(getPricingInputType(), o.getPricingInputType(), this::setPricingInputType);
			merger.mergeRosetta(getPricingInputReference(), o.getPricingInputReference(), this::setPricingInputReference);
			merger.mergeRosetta(getSensitivityDefinition(), o.getSensitivityDefinition(), this::getOrCreateSensitivityDefinition);
			merger.mergeRosetta(getCalculationProcedure(), o.getCalculationProcedure(), this::setCalculationProcedure);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getScale(), o.getScale(), this::setScale);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySetDefinition _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(sensitivityCharacteristics, _that.getSensitivityCharacteristics())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(pricingInputType, _that.getPricingInputType())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			if (!Objects.equals(scale, _that.getScale())) return false;
			if (!ListEquals.listEquals(sensitivityDefinition, _that.getSensitivityDefinition())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (sensitivityCharacteristics != null ? sensitivityCharacteristics.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputType != null ? pricingInputType.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			_result = 31 * _result + (scale != null ? scale.hashCode() : 0);
			_result = 31 * _result + (sensitivityDefinition != null ? sensitivityDefinition.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySetDefinitionBuilder {" +
				"name=" + this.name + ", " +
				"sensitivityCharacteristics=" + this.sensitivityCharacteristics + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"pricingInputType=" + this.pricingInputType + ", " +
				"pricingInputReference=" + this.pricingInputReference + ", " +
				"scale=" + this.scale + ", " +
				"sensitivityDefinition=" + this.sensitivityDefinition + ", " +
				"calculationProcedure=" + this.calculationProcedure + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
