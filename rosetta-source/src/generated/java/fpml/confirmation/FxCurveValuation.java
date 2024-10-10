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
import fpml.confirmation.FxCurveValuation;
import fpml.confirmation.FxCurveValuation.FxCurveValuationBuilder;
import fpml.confirmation.FxCurveValuation.FxCurveValuationBuilderImpl;
import fpml.confirmation.FxCurveValuation.FxCurveValuationImpl;
import fpml.confirmation.FxRateSet;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.PricingStructureValuation;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilder;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilderImpl;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationImpl;
import fpml.confirmation.TermCurve;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.meta.FxCurveValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A valuation of an FX curve object., which includes pricing inputs and term structures for fx forwards.
 * @version ${project.version}
 */
@RosettaDataType(value="FxCurveValuation", builder=FxCurveValuation.FxCurveValuationBuilderImpl.class, version="${project.version}")
public interface FxCurveValuation extends PricingStructureValuation {

	FxCurveValuationMeta metaData = new FxCurveValuationMeta();

	/*********************** Getter Methods  ***********************/
	PricingStructureReference getSettlementCurrencyYieldCurve();
	PricingStructureReference getForecastCurrencyYieldCurve();
	FxRateSet getSpotRate();
	/**
	 * A curve of fx forward rates.
	 */
	TermCurve getFxForwardCurve();
	/**
	 * A curve of fx forward point spreads.
	 */
	TermCurve getFxForwardPointsCurve();

	/*********************** Build Methods  ***********************/
	FxCurveValuation build();
	
	FxCurveValuation.FxCurveValuationBuilder toBuilder();
	
	static FxCurveValuation.FxCurveValuationBuilder builder() {
		return new FxCurveValuation.FxCurveValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCurveValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCurveValuation> getType() {
		return FxCurveValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.class, getPricingInputDatesModel());
		processRosetta(path.newSubPath("settlementCurrencyYieldCurve"), processor, PricingStructureReference.class, getSettlementCurrencyYieldCurve());
		processRosetta(path.newSubPath("forecastCurrencyYieldCurve"), processor, PricingStructureReference.class, getForecastCurrencyYieldCurve());
		processRosetta(path.newSubPath("spotRate"), processor, FxRateSet.class, getSpotRate());
		processRosetta(path.newSubPath("fxForwardCurve"), processor, TermCurve.class, getFxForwardCurve());
		processRosetta(path.newSubPath("fxForwardPointsCurve"), processor, TermCurve.class, getFxForwardPointsCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCurveValuationBuilder extends FxCurveValuation, PricingStructureValuation.PricingStructureValuationBuilder {
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateSettlementCurrencyYieldCurve();
		PricingStructureReference.PricingStructureReferenceBuilder getSettlementCurrencyYieldCurve();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateForecastCurrencyYieldCurve();
		PricingStructureReference.PricingStructureReferenceBuilder getForecastCurrencyYieldCurve();
		FxRateSet.FxRateSetBuilder getOrCreateSpotRate();
		FxRateSet.FxRateSetBuilder getSpotRate();
		TermCurve.TermCurveBuilder getOrCreateFxForwardCurve();
		TermCurve.TermCurveBuilder getFxForwardCurve();
		TermCurve.TermCurveBuilder getOrCreateFxForwardPointsCurve();
		TermCurve.TermCurveBuilder getFxForwardPointsCurve();
		FxCurveValuation.FxCurveValuationBuilder setObjectReference(AnyAssetReference objectReference);
		FxCurveValuation.FxCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		FxCurveValuation.FxCurveValuationBuilder setId(String id);
		FxCurveValuation.FxCurveValuationBuilder setDefinitionRef(String definitionRef);
		FxCurveValuation.FxCurveValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel);
		FxCurveValuation.FxCurveValuationBuilder setSettlementCurrencyYieldCurve(PricingStructureReference settlementCurrencyYieldCurve);
		FxCurveValuation.FxCurveValuationBuilder setForecastCurrencyYieldCurve(PricingStructureReference forecastCurrencyYieldCurve);
		FxCurveValuation.FxCurveValuationBuilder setSpotRate(FxRateSet spotRate);
		FxCurveValuation.FxCurveValuationBuilder setFxForwardCurve(TermCurve fxForwardCurve);
		FxCurveValuation.FxCurveValuationBuilder setFxForwardPointsCurve(TermCurve fxForwardPointsCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.PricingInputDatesModelBuilder.class, getPricingInputDatesModel());
			processRosetta(path.newSubPath("settlementCurrencyYieldCurve"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getSettlementCurrencyYieldCurve());
			processRosetta(path.newSubPath("forecastCurrencyYieldCurve"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getForecastCurrencyYieldCurve());
			processRosetta(path.newSubPath("spotRate"), processor, FxRateSet.FxRateSetBuilder.class, getSpotRate());
			processRosetta(path.newSubPath("fxForwardCurve"), processor, TermCurve.TermCurveBuilder.class, getFxForwardCurve());
			processRosetta(path.newSubPath("fxForwardPointsCurve"), processor, TermCurve.TermCurveBuilder.class, getFxForwardPointsCurve());
		}
		

		FxCurveValuation.FxCurveValuationBuilder prune();
	}

	/*********************** Immutable Implementation of FxCurveValuation  ***********************/
	class FxCurveValuationImpl extends PricingStructureValuation.PricingStructureValuationImpl implements FxCurveValuation {
		private final PricingStructureReference settlementCurrencyYieldCurve;
		private final PricingStructureReference forecastCurrencyYieldCurve;
		private final FxRateSet spotRate;
		private final TermCurve fxForwardCurve;
		private final TermCurve fxForwardPointsCurve;
		
		protected FxCurveValuationImpl(FxCurveValuation.FxCurveValuationBuilder builder) {
			super(builder);
			this.settlementCurrencyYieldCurve = ofNullable(builder.getSettlementCurrencyYieldCurve()).map(f->f.build()).orElse(null);
			this.forecastCurrencyYieldCurve = ofNullable(builder.getForecastCurrencyYieldCurve()).map(f->f.build()).orElse(null);
			this.spotRate = ofNullable(builder.getSpotRate()).map(f->f.build()).orElse(null);
			this.fxForwardCurve = ofNullable(builder.getFxForwardCurve()).map(f->f.build()).orElse(null);
			this.fxForwardPointsCurve = ofNullable(builder.getFxForwardPointsCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementCurrencyYieldCurve")
		public PricingStructureReference getSettlementCurrencyYieldCurve() {
			return settlementCurrencyYieldCurve;
		}
		
		@Override
		@RosettaAttribute("forecastCurrencyYieldCurve")
		public PricingStructureReference getForecastCurrencyYieldCurve() {
			return forecastCurrencyYieldCurve;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public FxRateSet getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("fxForwardCurve")
		public TermCurve getFxForwardCurve() {
			return fxForwardCurve;
		}
		
		@Override
		@RosettaAttribute("fxForwardPointsCurve")
		public TermCurve getFxForwardPointsCurve() {
			return fxForwardPointsCurve;
		}
		
		@Override
		public FxCurveValuation build() {
			return this;
		}
		
		@Override
		public FxCurveValuation.FxCurveValuationBuilder toBuilder() {
			FxCurveValuation.FxCurveValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCurveValuation.FxCurveValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementCurrencyYieldCurve()).ifPresent(builder::setSettlementCurrencyYieldCurve);
			ofNullable(getForecastCurrencyYieldCurve()).ifPresent(builder::setForecastCurrencyYieldCurve);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getFxForwardCurve()).ifPresent(builder::setFxForwardCurve);
			ofNullable(getFxForwardPointsCurve()).ifPresent(builder::setFxForwardPointsCurve);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrencyYieldCurve, _that.getSettlementCurrencyYieldCurve())) return false;
			if (!Objects.equals(forecastCurrencyYieldCurve, _that.getForecastCurrencyYieldCurve())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxForwardCurve, _that.getFxForwardCurve())) return false;
			if (!Objects.equals(fxForwardPointsCurve, _that.getFxForwardPointsCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementCurrencyYieldCurve != null ? settlementCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (forecastCurrencyYieldCurve != null ? forecastCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxForwardCurve != null ? fxForwardCurve.hashCode() : 0);
			_result = 31 * _result + (fxForwardPointsCurve != null ? fxForwardPointsCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveValuation {" +
				"settlementCurrencyYieldCurve=" + this.settlementCurrencyYieldCurve + ", " +
				"forecastCurrencyYieldCurve=" + this.forecastCurrencyYieldCurve + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxForwardCurve=" + this.fxForwardCurve + ", " +
				"fxForwardPointsCurve=" + this.fxForwardPointsCurve +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxCurveValuation  ***********************/
	class FxCurveValuationBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl  implements FxCurveValuation.FxCurveValuationBuilder {
	
		protected PricingStructureReference.PricingStructureReferenceBuilder settlementCurrencyYieldCurve;
		protected PricingStructureReference.PricingStructureReferenceBuilder forecastCurrencyYieldCurve;
		protected FxRateSet.FxRateSetBuilder spotRate;
		protected TermCurve.TermCurveBuilder fxForwardCurve;
		protected TermCurve.TermCurveBuilder fxForwardPointsCurve;
	
		public FxCurveValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementCurrencyYieldCurve")
		public PricingStructureReference.PricingStructureReferenceBuilder getSettlementCurrencyYieldCurve() {
			return settlementCurrencyYieldCurve;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateSettlementCurrencyYieldCurve() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (settlementCurrencyYieldCurve!=null) {
				result = settlementCurrencyYieldCurve;
			}
			else {
				result = settlementCurrencyYieldCurve = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forecastCurrencyYieldCurve")
		public PricingStructureReference.PricingStructureReferenceBuilder getForecastCurrencyYieldCurve() {
			return forecastCurrencyYieldCurve;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateForecastCurrencyYieldCurve() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (forecastCurrencyYieldCurve!=null) {
				result = forecastCurrencyYieldCurve;
			}
			else {
				result = forecastCurrencyYieldCurve = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public FxRateSet.FxRateSetBuilder getSpotRate() {
			return spotRate;
		}
		
		@Override
		public FxRateSet.FxRateSetBuilder getOrCreateSpotRate() {
			FxRateSet.FxRateSetBuilder result;
			if (spotRate!=null) {
				result = spotRate;
			}
			else {
				result = spotRate = FxRateSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxForwardCurve")
		public TermCurve.TermCurveBuilder getFxForwardCurve() {
			return fxForwardCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateFxForwardCurve() {
			TermCurve.TermCurveBuilder result;
			if (fxForwardCurve!=null) {
				result = fxForwardCurve;
			}
			else {
				result = fxForwardCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxForwardPointsCurve")
		public TermCurve.TermCurveBuilder getFxForwardPointsCurve() {
			return fxForwardPointsCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateFxForwardPointsCurve() {
			TermCurve.TermCurveBuilder result;
			if (fxForwardPointsCurve!=null) {
				result = fxForwardPointsCurve;
			}
			else {
				result = fxForwardPointsCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public FxCurveValuation.FxCurveValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public FxCurveValuation.FxCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxCurveValuation.FxCurveValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public FxCurveValuation.FxCurveValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public FxCurveValuation.FxCurveValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel) {
			this.pricingInputDatesModel = pricingInputDatesModel==null?null:pricingInputDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrencyYieldCurve")
		public FxCurveValuation.FxCurveValuationBuilder setSettlementCurrencyYieldCurve(PricingStructureReference settlementCurrencyYieldCurve) {
			this.settlementCurrencyYieldCurve = settlementCurrencyYieldCurve==null?null:settlementCurrencyYieldCurve.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("forecastCurrencyYieldCurve")
		public FxCurveValuation.FxCurveValuationBuilder setForecastCurrencyYieldCurve(PricingStructureReference forecastCurrencyYieldCurve) {
			this.forecastCurrencyYieldCurve = forecastCurrencyYieldCurve==null?null:forecastCurrencyYieldCurve.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxCurveValuation.FxCurveValuationBuilder setSpotRate(FxRateSet spotRate) {
			this.spotRate = spotRate==null?null:spotRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxForwardCurve")
		public FxCurveValuation.FxCurveValuationBuilder setFxForwardCurve(TermCurve fxForwardCurve) {
			this.fxForwardCurve = fxForwardCurve==null?null:fxForwardCurve.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxForwardPointsCurve")
		public FxCurveValuation.FxCurveValuationBuilder setFxForwardPointsCurve(TermCurve fxForwardPointsCurve) {
			this.fxForwardPointsCurve = fxForwardPointsCurve==null?null:fxForwardPointsCurve.toBuilder();
			return this;
		}
		
		@Override
		public FxCurveValuation build() {
			return new FxCurveValuation.FxCurveValuationImpl(this);
		}
		
		@Override
		public FxCurveValuation.FxCurveValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder prune() {
			super.prune();
			if (settlementCurrencyYieldCurve!=null && !settlementCurrencyYieldCurve.prune().hasData()) settlementCurrencyYieldCurve = null;
			if (forecastCurrencyYieldCurve!=null && !forecastCurrencyYieldCurve.prune().hasData()) forecastCurrencyYieldCurve = null;
			if (spotRate!=null && !spotRate.prune().hasData()) spotRate = null;
			if (fxForwardCurve!=null && !fxForwardCurve.prune().hasData()) fxForwardCurve = null;
			if (fxForwardPointsCurve!=null && !fxForwardPointsCurve.prune().hasData()) fxForwardPointsCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementCurrencyYieldCurve()!=null && getSettlementCurrencyYieldCurve().hasData()) return true;
			if (getForecastCurrencyYieldCurve()!=null && getForecastCurrencyYieldCurve().hasData()) return true;
			if (getSpotRate()!=null && getSpotRate().hasData()) return true;
			if (getFxForwardCurve()!=null && getFxForwardCurve().hasData()) return true;
			if (getFxForwardPointsCurve()!=null && getFxForwardPointsCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxCurveValuation.FxCurveValuationBuilder o = (FxCurveValuation.FxCurveValuationBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrencyYieldCurve(), o.getSettlementCurrencyYieldCurve(), this::setSettlementCurrencyYieldCurve);
			merger.mergeRosetta(getForecastCurrencyYieldCurve(), o.getForecastCurrencyYieldCurve(), this::setForecastCurrencyYieldCurve);
			merger.mergeRosetta(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeRosetta(getFxForwardCurve(), o.getFxForwardCurve(), this::setFxForwardCurve);
			merger.mergeRosetta(getFxForwardPointsCurve(), o.getFxForwardPointsCurve(), this::setFxForwardPointsCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrencyYieldCurve, _that.getSettlementCurrencyYieldCurve())) return false;
			if (!Objects.equals(forecastCurrencyYieldCurve, _that.getForecastCurrencyYieldCurve())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxForwardCurve, _that.getFxForwardCurve())) return false;
			if (!Objects.equals(fxForwardPointsCurve, _that.getFxForwardPointsCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementCurrencyYieldCurve != null ? settlementCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (forecastCurrencyYieldCurve != null ? forecastCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxForwardCurve != null ? fxForwardCurve.hashCode() : 0);
			_result = 31 * _result + (fxForwardPointsCurve != null ? fxForwardPointsCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveValuationBuilder {" +
				"settlementCurrencyYieldCurve=" + this.settlementCurrencyYieldCurve + ", " +
				"forecastCurrencyYieldCurve=" + this.forecastCurrencyYieldCurve + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxForwardCurve=" + this.fxForwardCurve + ", " +
				"fxForwardPointsCurve=" + this.fxForwardPointsCurve +
			'}' + " " + super.toString();
		}
	}
}
