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
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.CommoditySpreadSchedule;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.FloatingLegCalculation.FloatingLegCalculationBuilder;
import fpml.confirmation.FloatingLegCalculation.FloatingLegCalculationBuilderImpl;
import fpml.confirmation.FloatingLegCalculation.FloatingLegCalculationImpl;
import fpml.confirmation.FloatingStrikePrice;
import fpml.confirmation.FloatingStrikePrice.FloatingStrikePriceBuilder;
import fpml.confirmation.FloatingStrikePrice.FloatingStrikePriceBuilderImpl;
import fpml.confirmation.FloatingStrikePrice.FloatingStrikePriceImpl;
import fpml.confirmation.Rounding;
import fpml.confirmation.meta.FloatingStrikePriceMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingStrikePrice", builder=FloatingStrikePrice.FloatingStrikePriceBuilderImpl.class, version="${project.version}")
public interface FloatingStrikePrice extends FloatingLegCalculation {

	FloatingStrikePriceMeta metaData = new FloatingStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	Commodity getCommodity();

	/*********************** Build Methods  ***********************/
	FloatingStrikePrice build();
	
	FloatingStrikePrice.FloatingStrikePriceBuilder toBuilder();
	
	static FloatingStrikePrice.FloatingStrikePriceBuilder builder() {
		return new FloatingStrikePrice.FloatingStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingStrikePrice> getType() {
		return FloatingStrikePrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
		processRosetta(path.newSubPath("spread"), processor, CommoditySpread.class, getSpread());
		processRosetta(path.newSubPath("spreadSchedule"), processor, CommoditySpreadSchedule.class, getSpreadSchedule());
		processor.processBasic(path.newSubPath("spreadPercentage"), BigDecimal.class, getSpreadPercentage(), this);
		processRosetta(path.newSubPath("fx"), processor, CommodityFx.class, getFx());
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingStrikePriceBuilder extends FloatingStrikePrice, FloatingLegCalculation.FloatingLegCalculationBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		FloatingStrikePrice.FloatingStrikePriceBuilder setPricingDates(CommodityPricingDates pricingDates);
		FloatingStrikePrice.FloatingStrikePriceBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		FloatingStrikePrice.FloatingStrikePriceBuilder setConversionFactor(BigDecimal conversionFactor);
		FloatingStrikePrice.FloatingStrikePriceBuilder setRounding(Rounding rounding);
		FloatingStrikePrice.FloatingStrikePriceBuilder setSpread(CommoditySpread spread);
		FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule0);
		FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule1, int _idx);
		FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule2);
		FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule3);
		FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadPercentage(BigDecimal spreadPercentage);
		FloatingStrikePrice.FloatingStrikePriceBuilder setFx(CommodityFx fx);
		FloatingStrikePrice.FloatingStrikePriceBuilder setCommodity(Commodity commodity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
			processRosetta(path.newSubPath("spread"), processor, CommoditySpread.CommoditySpreadBuilder.class, getSpread());
			processRosetta(path.newSubPath("spreadSchedule"), processor, CommoditySpreadSchedule.CommoditySpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("spreadPercentage"), BigDecimal.class, getSpreadPercentage(), this);
			processRosetta(path.newSubPath("fx"), processor, CommodityFx.CommodityFxBuilder.class, getFx());
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
		}
		

		FloatingStrikePrice.FloatingStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingStrikePrice  ***********************/
	class FloatingStrikePriceImpl extends FloatingLegCalculation.FloatingLegCalculationImpl implements FloatingStrikePrice {
		private final Commodity commodity;
		
		protected FloatingStrikePriceImpl(FloatingStrikePrice.FloatingStrikePriceBuilder builder) {
			super(builder);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		public FloatingStrikePrice build() {
			return this;
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder toBuilder() {
			FloatingStrikePrice.FloatingStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingStrikePrice.FloatingStrikePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingStrikePrice {" +
				"commodity=" + this.commodity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingStrikePrice  ***********************/
	class FloatingStrikePriceBuilderImpl extends FloatingLegCalculation.FloatingLegCalculationBuilderImpl  implements FloatingStrikePrice.FloatingStrikePriceBuilder {
	
		protected Commodity.CommodityBuilder commodity;
	
		public FloatingStrikePriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("conversionFactor")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setConversionFactor(BigDecimal conversionFactor) {
			this.conversionFactor = conversionFactor==null?null:conversionFactor;
			return this;
		}
		@Override
		@RosettaAttribute("rounding")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setRounding(Rounding rounding) {
			this.rounding = rounding==null?null:rounding.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spread")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setSpread(CommoditySpread spread) {
			this.spread = spread==null?null:spread.toBuilder();
			return this;
		}
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (CommoditySpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("spreadSchedule")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null)  {
				this.spreadSchedule = new ArrayList<>();
			}
			else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("spreadPercentage")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadPercentage(BigDecimal spreadPercentage) {
			this.spreadPercentage = spreadPercentage==null?null:spreadPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("fx")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setFx(CommodityFx fx) {
			this.fx = fx==null?null:fx.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public FloatingStrikePrice.FloatingStrikePriceBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		
		@Override
		public FloatingStrikePrice build() {
			return new FloatingStrikePrice.FloatingStrikePriceImpl(this);
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder prune() {
			super.prune();
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingStrikePrice.FloatingStrikePriceBuilder o = (FloatingStrikePrice.FloatingStrikePriceBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingStrikePriceBuilder {" +
				"commodity=" + this.commodity +
			'}' + " " + super.toString();
		}
	}
}
