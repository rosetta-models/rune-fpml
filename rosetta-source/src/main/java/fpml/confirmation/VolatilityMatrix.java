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
import fpml.confirmation.MultiDimensionalPricingData;
import fpml.confirmation.ParametricAdjustment;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingStructureValuation;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilder;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilderImpl;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationImpl;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.VolatilityMatrix;
import fpml.confirmation.VolatilityMatrix.VolatilityMatrixBuilder;
import fpml.confirmation.VolatilityMatrix.VolatilityMatrixBuilderImpl;
import fpml.confirmation.VolatilityMatrix.VolatilityMatrixImpl;
import fpml.confirmation.meta.VolatilityMatrixMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A matrix of volatilities with dimension 0-3.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="VolatilityMatrix", builder=VolatilityMatrix.VolatilityMatrixBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface VolatilityMatrix extends PricingStructureValuation {

	VolatilityMatrixMeta metaData = new VolatilityMatrixMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The raw volatility matrix data, expressed as a multi-dimensional array.
	 */
	MultiDimensionalPricingData getDataPoints();
	/**
	 * An adjustment factor, such as for vol smile/skew.
	 */
	List<? extends ParametricAdjustment> getAdjustment();

	/*********************** Build Methods  ***********************/
	VolatilityMatrix build();
	
	VolatilityMatrix.VolatilityMatrixBuilder toBuilder();
	
	static VolatilityMatrix.VolatilityMatrixBuilder builder() {
		return new VolatilityMatrix.VolatilityMatrixBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityMatrix> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilityMatrix> getType() {
		return VolatilityMatrix.class;
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
	interface VolatilityMatrixBuilder extends VolatilityMatrix, PricingStructureValuation.PricingStructureValuationBuilder {
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getOrCreateDataPoints();
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getDataPoints();
		ParametricAdjustment.ParametricAdjustmentBuilder getOrCreateAdjustment(int _index);
		List<? extends ParametricAdjustment.ParametricAdjustmentBuilder> getAdjustment();
		VolatilityMatrix.VolatilityMatrixBuilder setObjectReference(AnyAssetReference objectReference);
		VolatilityMatrix.VolatilityMatrixBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		VolatilityMatrix.VolatilityMatrixBuilder setId(String id);
		VolatilityMatrix.VolatilityMatrixBuilder setDefinitionRef(String definitionRef);
		VolatilityMatrix.VolatilityMatrixBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel);
		VolatilityMatrix.VolatilityMatrixBuilder setDataPoints(MultiDimensionalPricingData dataPoints);
		VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment adjustment0);
		VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment adjustment1, int _idx);
		VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(List<? extends ParametricAdjustment> adjustment2);
		VolatilityMatrix.VolatilityMatrixBuilder setAdjustment(List<? extends ParametricAdjustment> adjustment3);

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
		

		VolatilityMatrix.VolatilityMatrixBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityMatrix  ***********************/
	class VolatilityMatrixImpl extends PricingStructureValuation.PricingStructureValuationImpl implements VolatilityMatrix {
		private final MultiDimensionalPricingData dataPoints;
		private final List<? extends ParametricAdjustment> adjustment;
		
		protected VolatilityMatrixImpl(VolatilityMatrix.VolatilityMatrixBuilder builder) {
			super(builder);
			this.dataPoints = ofNullable(builder.getDataPoints()).map(f->f.build()).orElse(null);
			this.adjustment = ofNullable(builder.getAdjustment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dataPoints")
		public MultiDimensionalPricingData getDataPoints() {
			return dataPoints;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public List<? extends ParametricAdjustment> getAdjustment() {
			return adjustment;
		}
		
		@Override
		public VolatilityMatrix build() {
			return this;
		}
		
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder toBuilder() {
			VolatilityMatrix.VolatilityMatrixBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityMatrix.VolatilityMatrixBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDataPoints()).ifPresent(builder::setDataPoints);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(dataPoints, _that.getDataPoints())) return false;
			if (!ListEquals.listEquals(adjustment, _that.getAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dataPoints != null ? dataPoints.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrix {" +
				"dataPoints=" + this.dataPoints + ", " +
				"adjustment=" + this.adjustment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityMatrix  ***********************/
	class VolatilityMatrixBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl  implements VolatilityMatrix.VolatilityMatrixBuilder {
	
		protected MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder dataPoints;
		protected List<ParametricAdjustment.ParametricAdjustmentBuilder> adjustment = new ArrayList<>();
	
		public VolatilityMatrixBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dataPoints")
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getDataPoints() {
			return dataPoints;
		}
		
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getOrCreateDataPoints() {
			MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder result;
			if (dataPoints!=null) {
				result = dataPoints;
			}
			else {
				result = dataPoints = MultiDimensionalPricingData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public List<? extends ParametricAdjustment.ParametricAdjustmentBuilder> getAdjustment() {
			return adjustment;
		}
		
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder getOrCreateAdjustment(int _index) {
		
			if (adjustment==null) {
				this.adjustment = new ArrayList<>();
			}
			ParametricAdjustment.ParametricAdjustmentBuilder result;
			return getIndex(adjustment, _index, () -> {
						ParametricAdjustment.ParametricAdjustmentBuilder newAdjustment = ParametricAdjustment.builder();
						return newAdjustment;
					});
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public VolatilityMatrix.VolatilityMatrixBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public VolatilityMatrix.VolatilityMatrixBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VolatilityMatrix.VolatilityMatrixBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public VolatilityMatrix.VolatilityMatrixBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public VolatilityMatrix.VolatilityMatrixBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel) {
			this.pricingInputDatesModel = pricingInputDatesModel==null?null:pricingInputDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dataPoints")
		public VolatilityMatrix.VolatilityMatrixBuilder setDataPoints(MultiDimensionalPricingData dataPoints) {
			this.dataPoints = dataPoints==null?null:dataPoints.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustment")
		public VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment adjustment) {
			if (adjustment!=null) this.adjustment.add(adjustment.toBuilder());
			return this;
		}
		
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment adjustment, int _idx) {
			getIndex(this.adjustment, _idx, () -> adjustment.toBuilder());
			return this;
		}
		@Override 
		public VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(List<? extends ParametricAdjustment> adjustments) {
			if (adjustments != null) {
				for (ParametricAdjustment toAdd : adjustments) {
					this.adjustment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public VolatilityMatrix.VolatilityMatrixBuilder setAdjustment(List<? extends ParametricAdjustment> adjustments) {
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
		public VolatilityMatrix build() {
			return new VolatilityMatrix.VolatilityMatrixImpl(this);
		}
		
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder prune() {
			super.prune();
			if (dataPoints!=null && !dataPoints.prune().hasData()) dataPoints = null;
			adjustment = adjustment.stream().filter(b->b!=null).<ParametricAdjustment.ParametricAdjustmentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDataPoints()!=null && getDataPoints().hasData()) return true;
			if (getAdjustment()!=null && getAdjustment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VolatilityMatrix.VolatilityMatrixBuilder o = (VolatilityMatrix.VolatilityMatrixBuilder) other;
			
			merger.mergeRosetta(getDataPoints(), o.getDataPoints(), this::setDataPoints);
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::getOrCreateAdjustment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(dataPoints, _that.getDataPoints())) return false;
			if (!ListEquals.listEquals(adjustment, _that.getAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dataPoints != null ? dataPoints.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrixBuilder {" +
				"dataPoints=" + this.dataPoints + ", " +
				"adjustment=" + this.adjustment +
			'}' + " " + super.toString();
		}
	}
}
