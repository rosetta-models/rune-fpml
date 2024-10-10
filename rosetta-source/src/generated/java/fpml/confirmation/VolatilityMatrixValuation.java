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
import fpml.confirmation.MultiDimensionalPricingData;
import fpml.confirmation.ParametricAdjustment;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.VolatilityMatrix;
import fpml.confirmation.VolatilityMatrix.VolatilityMatrixBuilder;
import fpml.confirmation.VolatilityMatrix.VolatilityMatrixBuilderImpl;
import fpml.confirmation.VolatilityMatrix.VolatilityMatrixImpl;
import fpml.confirmation.VolatilityMatrixValuation;
import fpml.confirmation.VolatilityMatrixValuation.VolatilityMatrixValuationBuilder;
import fpml.confirmation.VolatilityMatrixValuation.VolatilityMatrixValuationBuilderImpl;
import fpml.confirmation.VolatilityMatrixValuation.VolatilityMatrixValuationImpl;
import fpml.confirmation.meta.VolatilityMatrixValuationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="VolatilityMatrixValuation", builder=VolatilityMatrixValuation.VolatilityMatrixValuationBuilderImpl.class, version="${project.version}")
public interface VolatilityMatrixValuation extends VolatilityMatrix {

	VolatilityMatrixValuationMeta metaData = new VolatilityMatrixValuationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	VolatilityMatrixValuation build();
	
	VolatilityMatrixValuation.VolatilityMatrixValuationBuilder toBuilder();
	
	static VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder() {
		return new VolatilityMatrixValuation.VolatilityMatrixValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityMatrixValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilityMatrixValuation> getType() {
		return VolatilityMatrixValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.class, getPricingInputDatesModel());
		processRosetta(path.newSubPath("dataPoints"), processor, MultiDimensionalPricingData.class, getDataPoints());
		processRosetta(path.newSubPath("adjustment"), processor, ParametricAdjustment.class, getAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityMatrixValuationBuilder extends VolatilityMatrixValuation, VolatilityMatrix.VolatilityMatrixBuilder {
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setObjectReference(AnyAssetReference objectReference);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setId(String id);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDefinitionRef(String definitionRef);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDataPoints(MultiDimensionalPricingData dataPoints);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment adjustment0);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment adjustment1, int _idx);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(List<? extends ParametricAdjustment> adjustment2);
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setAdjustment(List<? extends ParametricAdjustment> adjustment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.PricingInputDatesModelBuilder.class, getPricingInputDatesModel());
			processRosetta(path.newSubPath("dataPoints"), processor, MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder.class, getDataPoints());
			processRosetta(path.newSubPath("adjustment"), processor, ParametricAdjustment.ParametricAdjustmentBuilder.class, getAdjustment());
		}
		

		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityMatrixValuation  ***********************/
	class VolatilityMatrixValuationImpl extends VolatilityMatrix.VolatilityMatrixImpl implements VolatilityMatrixValuation {
		
		protected VolatilityMatrixValuationImpl(VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder) {
			super(builder);
		}
		
		@Override
		public VolatilityMatrixValuation build() {
			return this;
		}
		
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder toBuilder() {
			VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrixValuation {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityMatrixValuation  ***********************/
	class VolatilityMatrixValuationBuilderImpl extends VolatilityMatrix.VolatilityMatrixBuilderImpl  implements VolatilityMatrixValuation.VolatilityMatrixValuationBuilder {
	
	
		public VolatilityMatrixValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("objectReference")
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel) {
			this.pricingInputDatesModel = pricingInputDatesModel==null?null:pricingInputDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dataPoints")
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDataPoints(MultiDimensionalPricingData dataPoints) {
			this.dataPoints = dataPoints==null?null:dataPoints.toBuilder();
			return this;
		}
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment adjustment) {
			if (adjustment!=null) this.adjustment.add(adjustment.toBuilder());
			return this;
		}
		
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment adjustment, int _idx) {
			getIndex(this.adjustment, _idx, () -> adjustment.toBuilder());
			return this;
		}
		@Override 
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(List<? extends ParametricAdjustment> adjustments) {
			if (adjustments != null) {
				for (ParametricAdjustment toAdd : adjustments) {
					this.adjustment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("adjustment")
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setAdjustment(List<? extends ParametricAdjustment> adjustments) {
			if (adjustments == null)  {
				this.adjustment = new ArrayList<>();
			}
			else {
				this.adjustment = adjustments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public VolatilityMatrixValuation build() {
			return new VolatilityMatrixValuation.VolatilityMatrixValuationImpl(this);
		}
		
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VolatilityMatrixValuation.VolatilityMatrixValuationBuilder o = (VolatilityMatrixValuation.VolatilityMatrixValuationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrixValuationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
