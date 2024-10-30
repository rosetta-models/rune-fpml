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
import fpml.confirmation.ForwardRateCurve;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingStructureValuation;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilder;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationBuilderImpl;
import fpml.confirmation.PricingStructureValuation.PricingStructureValuationImpl;
import fpml.confirmation.QuotedAssetSet;
import fpml.confirmation.TermCurve;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.YieldCurveValuation;
import fpml.confirmation.YieldCurveValuation.YieldCurveValuationBuilder;
import fpml.confirmation.YieldCurveValuation.YieldCurveValuationBuilderImpl;
import fpml.confirmation.YieldCurveValuation.YieldCurveValuationImpl;
import fpml.confirmation.ZeroRateCurve;
import fpml.confirmation.meta.YieldCurveValuationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The values of a yield curve, including possibly inputs and outputs (dfs, forwards, zero rates).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="YieldCurveValuation", builder=YieldCurveValuation.YieldCurveValuationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface YieldCurveValuation extends PricingStructureValuation {

	YieldCurveValuationMeta metaData = new YieldCurveValuationMeta();

	/*********************** Getter Methods  ***********************/
	QuotedAssetSet getInputs();
	/**
	 * A curve of zero rates.
	 */
	ZeroRateCurve getZeroCurve();
	/**
	 * A curve of forward rates.
	 */
	List<? extends ForwardRateCurve> getForwardCurve();
	/**
	 * A curve of discount factors.
	 */
	TermCurve getDiscountFactorCurve();

	/*********************** Build Methods  ***********************/
	YieldCurveValuation build();
	
	YieldCurveValuation.YieldCurveValuationBuilder toBuilder();
	
	static YieldCurveValuation.YieldCurveValuationBuilder builder() {
		return new YieldCurveValuation.YieldCurveValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends YieldCurveValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends YieldCurveValuation> getType() {
		return YieldCurveValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.class, getPricingInputDatesModel());
		processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.class, getInputs());
		processRosetta(path.newSubPath("zeroCurve"), processor, ZeroRateCurve.class, getZeroCurve());
		processRosetta(path.newSubPath("forwardCurve"), processor, ForwardRateCurve.class, getForwardCurve());
		processRosetta(path.newSubPath("discountFactorCurve"), processor, TermCurve.class, getDiscountFactorCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface YieldCurveValuationBuilder extends YieldCurveValuation, PricingStructureValuation.PricingStructureValuationBuilder {
		QuotedAssetSet.QuotedAssetSetBuilder getOrCreateInputs();
		QuotedAssetSet.QuotedAssetSetBuilder getInputs();
		ZeroRateCurve.ZeroRateCurveBuilder getOrCreateZeroCurve();
		ZeroRateCurve.ZeroRateCurveBuilder getZeroCurve();
		ForwardRateCurve.ForwardRateCurveBuilder getOrCreateForwardCurve(int _index);
		List<? extends ForwardRateCurve.ForwardRateCurveBuilder> getForwardCurve();
		TermCurve.TermCurveBuilder getOrCreateDiscountFactorCurve();
		TermCurve.TermCurveBuilder getDiscountFactorCurve();
		YieldCurveValuation.YieldCurveValuationBuilder setObjectReference(AnyAssetReference objectReference);
		YieldCurveValuation.YieldCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		YieldCurveValuation.YieldCurveValuationBuilder setId(String id);
		YieldCurveValuation.YieldCurveValuationBuilder setDefinitionRef(String definitionRef);
		YieldCurveValuation.YieldCurveValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel);
		YieldCurveValuation.YieldCurveValuationBuilder setInputs(QuotedAssetSet inputs);
		YieldCurveValuation.YieldCurveValuationBuilder setZeroCurve(ZeroRateCurve zeroCurve);
		YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve forwardCurve0);
		YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve forwardCurve1, int _idx);
		YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(List<? extends ForwardRateCurve> forwardCurve2);
		YieldCurveValuation.YieldCurveValuationBuilder setForwardCurve(List<? extends ForwardRateCurve> forwardCurve3);
		YieldCurveValuation.YieldCurveValuationBuilder setDiscountFactorCurve(TermCurve discountFactorCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("pricingInputDatesModel"), processor, PricingInputDatesModel.PricingInputDatesModelBuilder.class, getPricingInputDatesModel());
			processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.QuotedAssetSetBuilder.class, getInputs());
			processRosetta(path.newSubPath("zeroCurve"), processor, ZeroRateCurve.ZeroRateCurveBuilder.class, getZeroCurve());
			processRosetta(path.newSubPath("forwardCurve"), processor, ForwardRateCurve.ForwardRateCurveBuilder.class, getForwardCurve());
			processRosetta(path.newSubPath("discountFactorCurve"), processor, TermCurve.TermCurveBuilder.class, getDiscountFactorCurve());
		}
		

		YieldCurveValuation.YieldCurveValuationBuilder prune();
	}

	/*********************** Immutable Implementation of YieldCurveValuation  ***********************/
	class YieldCurveValuationImpl extends PricingStructureValuation.PricingStructureValuationImpl implements YieldCurveValuation {
		private final QuotedAssetSet inputs;
		private final ZeroRateCurve zeroCurve;
		private final List<? extends ForwardRateCurve> forwardCurve;
		private final TermCurve discountFactorCurve;
		
		protected YieldCurveValuationImpl(YieldCurveValuation.YieldCurveValuationBuilder builder) {
			super(builder);
			this.inputs = ofNullable(builder.getInputs()).map(f->f.build()).orElse(null);
			this.zeroCurve = ofNullable(builder.getZeroCurve()).map(f->f.build()).orElse(null);
			this.forwardCurve = ofNullable(builder.getForwardCurve()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.discountFactorCurve = ofNullable(builder.getDiscountFactorCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inputs")
		public QuotedAssetSet getInputs() {
			return inputs;
		}
		
		@Override
		@RosettaAttribute("zeroCurve")
		public ZeroRateCurve getZeroCurve() {
			return zeroCurve;
		}
		
		@Override
		@RosettaAttribute("forwardCurve")
		public List<? extends ForwardRateCurve> getForwardCurve() {
			return forwardCurve;
		}
		
		@Override
		@RosettaAttribute("discountFactorCurve")
		public TermCurve getDiscountFactorCurve() {
			return discountFactorCurve;
		}
		
		@Override
		public YieldCurveValuation build() {
			return this;
		}
		
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder toBuilder() {
			YieldCurveValuation.YieldCurveValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(YieldCurveValuation.YieldCurveValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInputs()).ifPresent(builder::setInputs);
			ofNullable(getZeroCurve()).ifPresent(builder::setZeroCurve);
			ofNullable(getForwardCurve()).ifPresent(builder::setForwardCurve);
			ofNullable(getDiscountFactorCurve()).ifPresent(builder::setDiscountFactorCurve);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(zeroCurve, _that.getZeroCurve())) return false;
			if (!ListEquals.listEquals(forwardCurve, _that.getForwardCurve())) return false;
			if (!Objects.equals(discountFactorCurve, _that.getDiscountFactorCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (zeroCurve != null ? zeroCurve.hashCode() : 0);
			_result = 31 * _result + (forwardCurve != null ? forwardCurve.hashCode() : 0);
			_result = 31 * _result + (discountFactorCurve != null ? discountFactorCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveValuation {" +
				"inputs=" + this.inputs + ", " +
				"zeroCurve=" + this.zeroCurve + ", " +
				"forwardCurve=" + this.forwardCurve + ", " +
				"discountFactorCurve=" + this.discountFactorCurve +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of YieldCurveValuation  ***********************/
	class YieldCurveValuationBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl  implements YieldCurveValuation.YieldCurveValuationBuilder {
	
		protected QuotedAssetSet.QuotedAssetSetBuilder inputs;
		protected ZeroRateCurve.ZeroRateCurveBuilder zeroCurve;
		protected List<ForwardRateCurve.ForwardRateCurveBuilder> forwardCurve = new ArrayList<>();
		protected TermCurve.TermCurveBuilder discountFactorCurve;
	
		public YieldCurveValuationBuilderImpl() {
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
		@RosettaAttribute("zeroCurve")
		public ZeroRateCurve.ZeroRateCurveBuilder getZeroCurve() {
			return zeroCurve;
		}
		
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder getOrCreateZeroCurve() {
			ZeroRateCurve.ZeroRateCurveBuilder result;
			if (zeroCurve!=null) {
				result = zeroCurve;
			}
			else {
				result = zeroCurve = ZeroRateCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forwardCurve")
		public List<? extends ForwardRateCurve.ForwardRateCurveBuilder> getForwardCurve() {
			return forwardCurve;
		}
		
		@Override
		public ForwardRateCurve.ForwardRateCurveBuilder getOrCreateForwardCurve(int _index) {
		
			if (forwardCurve==null) {
				this.forwardCurve = new ArrayList<>();
			}
			ForwardRateCurve.ForwardRateCurveBuilder result;
			return getIndex(forwardCurve, _index, () -> {
						ForwardRateCurve.ForwardRateCurveBuilder newForwardCurve = ForwardRateCurve.builder();
						return newForwardCurve;
					});
		}
		
		@Override
		@RosettaAttribute("discountFactorCurve")
		public TermCurve.TermCurveBuilder getDiscountFactorCurve() {
			return discountFactorCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateDiscountFactorCurve() {
			TermCurve.TermCurveBuilder result;
			if (discountFactorCurve!=null) {
				result = discountFactorCurve;
			}
			else {
				result = discountFactorCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		public YieldCurveValuation.YieldCurveValuationBuilder setObjectReference(AnyAssetReference objectReference) {
			this.objectReference = objectReference==null?null:objectReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationScenarioReference")
		public YieldCurveValuation.YieldCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference) {
			this.valuationScenarioReference = valuationScenarioReference==null?null:valuationScenarioReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public YieldCurveValuation.YieldCurveValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("definitionRef")
		public YieldCurveValuation.YieldCurveValuationBuilder setDefinitionRef(String definitionRef) {
			this.definitionRef = definitionRef==null?null:definitionRef;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputDatesModel")
		public YieldCurveValuation.YieldCurveValuationBuilder setPricingInputDatesModel(PricingInputDatesModel pricingInputDatesModel) {
			this.pricingInputDatesModel = pricingInputDatesModel==null?null:pricingInputDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("inputs")
		public YieldCurveValuation.YieldCurveValuationBuilder setInputs(QuotedAssetSet inputs) {
			this.inputs = inputs==null?null:inputs.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("zeroCurve")
		public YieldCurveValuation.YieldCurveValuationBuilder setZeroCurve(ZeroRateCurve zeroCurve) {
			this.zeroCurve = zeroCurve==null?null:zeroCurve.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("forwardCurve")
		public YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve forwardCurve) {
			if (forwardCurve!=null) this.forwardCurve.add(forwardCurve.toBuilder());
			return this;
		}
		
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve forwardCurve, int _idx) {
			getIndex(this.forwardCurve, _idx, () -> forwardCurve.toBuilder());
			return this;
		}
		@Override 
		public YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(List<? extends ForwardRateCurve> forwardCurves) {
			if (forwardCurves != null) {
				for (ForwardRateCurve toAdd : forwardCurves) {
					this.forwardCurve.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public YieldCurveValuation.YieldCurveValuationBuilder setForwardCurve(List<? extends ForwardRateCurve> forwardCurves) {
			if (forwardCurves == null)  {
				this.forwardCurve = new ArrayList<>();
			}
			else {
				this.forwardCurve = forwardCurves.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("discountFactorCurve")
		public YieldCurveValuation.YieldCurveValuationBuilder setDiscountFactorCurve(TermCurve discountFactorCurve) {
			this.discountFactorCurve = discountFactorCurve==null?null:discountFactorCurve.toBuilder();
			return this;
		}
		
		@Override
		public YieldCurveValuation build() {
			return new YieldCurveValuation.YieldCurveValuationImpl(this);
		}
		
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder prune() {
			super.prune();
			if (inputs!=null && !inputs.prune().hasData()) inputs = null;
			if (zeroCurve!=null && !zeroCurve.prune().hasData()) zeroCurve = null;
			forwardCurve = forwardCurve.stream().filter(b->b!=null).<ForwardRateCurve.ForwardRateCurveBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (discountFactorCurve!=null && !discountFactorCurve.prune().hasData()) discountFactorCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInputs()!=null && getInputs().hasData()) return true;
			if (getZeroCurve()!=null && getZeroCurve().hasData()) return true;
			if (getForwardCurve()!=null && getForwardCurve().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDiscountFactorCurve()!=null && getDiscountFactorCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			YieldCurveValuation.YieldCurveValuationBuilder o = (YieldCurveValuation.YieldCurveValuationBuilder) other;
			
			merger.mergeRosetta(getInputs(), o.getInputs(), this::setInputs);
			merger.mergeRosetta(getZeroCurve(), o.getZeroCurve(), this::setZeroCurve);
			merger.mergeRosetta(getForwardCurve(), o.getForwardCurve(), this::getOrCreateForwardCurve);
			merger.mergeRosetta(getDiscountFactorCurve(), o.getDiscountFactorCurve(), this::setDiscountFactorCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(zeroCurve, _that.getZeroCurve())) return false;
			if (!ListEquals.listEquals(forwardCurve, _that.getForwardCurve())) return false;
			if (!Objects.equals(discountFactorCurve, _that.getDiscountFactorCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (zeroCurve != null ? zeroCurve.hashCode() : 0);
			_result = 31 * _result + (forwardCurve != null ? forwardCurve.hashCode() : 0);
			_result = 31 * _result + (discountFactorCurve != null ? discountFactorCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveValuationBuilder {" +
				"inputs=" + this.inputs + ", " +
				"zeroCurve=" + this.zeroCurve + ", " +
				"forwardCurve=" + this.forwardCurve + ", " +
				"discountFactorCurve=" + this.discountFactorCurve +
			'}' + " " + super.toString();
		}
	}
}
