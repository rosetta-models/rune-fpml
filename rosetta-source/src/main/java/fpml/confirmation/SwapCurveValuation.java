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
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.QuotationSideEnum;
import fpml.confirmation.SwapCurveValuation;
import fpml.confirmation.SwapCurveValuation.SwapCurveValuationBuilder;
import fpml.confirmation.SwapCurveValuation.SwapCurveValuationBuilderImpl;
import fpml.confirmation.SwapCurveValuation.SwapCurveValuationImpl;
import fpml.confirmation.meta.SwapCurveValuationMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A complex type to specify a valuation swap curve, which is used as part of the strike construct for the bond and convertible bond options.
 * @version ${project.version}
 */
@RosettaDataType(value="SwapCurveValuation", builder=SwapCurveValuation.SwapCurveValuationBuilderImpl.class, version="${project.version}")
public interface SwapCurveValuation extends RosettaModelObject {

	SwapCurveValuationMeta metaData = new SwapCurveValuationMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndexModel getFloatingRateIndexModel();
	/**
	 * Spread in basis points over the floating rate index.
	 */
	BigDecimal getSpread();
	/**
	 * The side (bid/mid/ask) of the measure.
	 */
	QuotationSideEnum getSide();

	/*********************** Build Methods  ***********************/
	SwapCurveValuation build();
	
	SwapCurveValuation.SwapCurveValuationBuilder toBuilder();
	
	static SwapCurveValuation.SwapCurveValuationBuilder builder() {
		return new SwapCurveValuation.SwapCurveValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SwapCurveValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SwapCurveValuation> getType() {
		return SwapCurveValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.class, getFloatingRateIndexModel());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwapCurveValuationBuilder extends SwapCurveValuation, RosettaModelObjectBuilder {
		FloatingRateIndexModel.FloatingRateIndexModelBuilder getOrCreateFloatingRateIndexModel();
		FloatingRateIndexModel.FloatingRateIndexModelBuilder getFloatingRateIndexModel();
		SwapCurveValuation.SwapCurveValuationBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel);
		SwapCurveValuation.SwapCurveValuationBuilder setSpread(BigDecimal spread);
		SwapCurveValuation.SwapCurveValuationBuilder setSide(QuotationSideEnum side);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.FloatingRateIndexModelBuilder.class, getFloatingRateIndexModel());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
		}
		

		SwapCurveValuation.SwapCurveValuationBuilder prune();
	}

	/*********************** Immutable Implementation of SwapCurveValuation  ***********************/
	class SwapCurveValuationImpl implements SwapCurveValuation {
		private final FloatingRateIndexModel floatingRateIndexModel;
		private final BigDecimal spread;
		private final QuotationSideEnum side;
		
		protected SwapCurveValuationImpl(SwapCurveValuation.SwapCurveValuationBuilder builder) {
			this.floatingRateIndexModel = ofNullable(builder.getFloatingRateIndexModel()).map(f->f.build()).orElse(null);
			this.spread = builder.getSpread();
			this.side = builder.getSide();
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRateIndexModel getFloatingRateIndexModel() {
			return floatingRateIndexModel;
		}
		
		@Override
		@RosettaAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("side")
		public QuotationSideEnum getSide() {
			return side;
		}
		
		@Override
		public SwapCurveValuation build() {
			return this;
		}
		
		@Override
		public SwapCurveValuation.SwapCurveValuationBuilder toBuilder() {
			SwapCurveValuation.SwapCurveValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SwapCurveValuation.SwapCurveValuationBuilder builder) {
			ofNullable(getFloatingRateIndexModel()).ifPresent(builder::setFloatingRateIndexModel);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getSide()).ifPresent(builder::setSide);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwapCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexModel, _that.getFloatingRateIndexModel())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndexModel != null ? floatingRateIndexModel.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapCurveValuation {" +
				"floatingRateIndexModel=" + this.floatingRateIndexModel + ", " +
				"spread=" + this.spread + ", " +
				"side=" + this.side +
			'}';
		}
	}

	/*********************** Builder Implementation of SwapCurveValuation  ***********************/
	class SwapCurveValuationBuilderImpl implements SwapCurveValuation.SwapCurveValuationBuilder {
	
		protected FloatingRateIndexModel.FloatingRateIndexModelBuilder floatingRateIndexModel;
		protected BigDecimal spread;
		protected QuotationSideEnum side;
	
		public SwapCurveValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder getFloatingRateIndexModel() {
			return floatingRateIndexModel;
		}
		
		@Override
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder getOrCreateFloatingRateIndexModel() {
			FloatingRateIndexModel.FloatingRateIndexModelBuilder result;
			if (floatingRateIndexModel!=null) {
				result = floatingRateIndexModel;
			}
			else {
				result = floatingRateIndexModel = FloatingRateIndexModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("side")
		public QuotationSideEnum getSide() {
			return side;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public SwapCurveValuation.SwapCurveValuationBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel) {
			this.floatingRateIndexModel = floatingRateIndexModel==null?null:floatingRateIndexModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spread")
		public SwapCurveValuation.SwapCurveValuationBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		@Override
		@RosettaAttribute("side")
		public SwapCurveValuation.SwapCurveValuationBuilder setSide(QuotationSideEnum side) {
			this.side = side==null?null:side;
			return this;
		}
		
		@Override
		public SwapCurveValuation build() {
			return new SwapCurveValuation.SwapCurveValuationImpl(this);
		}
		
		@Override
		public SwapCurveValuation.SwapCurveValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwapCurveValuation.SwapCurveValuationBuilder prune() {
			if (floatingRateIndexModel!=null && !floatingRateIndexModel.prune().hasData()) floatingRateIndexModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndexModel()!=null && getFloatingRateIndexModel().hasData()) return true;
			if (getSpread()!=null) return true;
			if (getSide()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwapCurveValuation.SwapCurveValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SwapCurveValuation.SwapCurveValuationBuilder o = (SwapCurveValuation.SwapCurveValuationBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndexModel(), o.getFloatingRateIndexModel(), this::setFloatingRateIndexModel);
			
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			merger.mergeBasic(getSide(), o.getSide(), this::setSide);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwapCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexModel, _that.getFloatingRateIndexModel())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndexModel != null ? floatingRateIndexModel.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapCurveValuationBuilder {" +
				"floatingRateIndexModel=" + this.floatingRateIndexModel + ", " +
				"spread=" + this.spread + ", " +
				"side=" + this.side +
			'}';
		}
	}
}
