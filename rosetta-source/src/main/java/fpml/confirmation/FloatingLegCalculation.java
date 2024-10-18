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
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.CommoditySpreadSchedule;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.FloatingLegCalculation.FloatingLegCalculationBuilder;
import fpml.confirmation.FloatingLegCalculation.FloatingLegCalculationBuilderImpl;
import fpml.confirmation.FloatingLegCalculation.FloatingLegCalculationImpl;
import fpml.confirmation.Rounding;
import fpml.confirmation.meta.FloatingLegCalculationMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type to capture details relevant to the calculation of the floating price.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingLegCalculation", builder=FloatingLegCalculation.FloatingLegCalculationBuilderImpl.class, version="${project.version}")
public interface FloatingLegCalculation extends RosettaModelObject {

	FloatingLegCalculationMeta metaData = new FloatingLegCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Commodity Pricing Dates.
	 */
	CommodityPricingDates getPricingDates();
	/**
	 * The parties may specify a Method of Averaging where more than one pricing Dates is being specified as being applicable.
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 * If the Notional Quantity is specified in units that do not match the units in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price units into the Notional Quantity units should be stated here. If there is no conversion, this element is not intended to be used.
	 */
	BigDecimal getConversionFactor();
	/**
	 * Rounding direction and precision for price values.
	 */
	Rounding getRounding();
	/**
	 * The spread over or under the Commodity Reference Price for this leg of the trade.
	 */
	CommoditySpread getSpread();
	/**
	 * The spread over or under the Commodity Reference Price for this leg of the trade for each Calculation Period.
	 */
	List<? extends CommoditySpreadSchedule> getSpreadSchedule();
	/**
	 * The spread percentage over or under the Commodity Reference Price for this leg of the trade.
	 */
	BigDecimal getSpreadPercentage();
	/**
	 * Defines how observations of FX prices are to be used to calculate a factor with which to convert the observed Commodity Reference Price to the Settlement Currency.
	 */
	CommodityFx getFx();

	/*********************** Build Methods  ***********************/
	FloatingLegCalculation build();
	
	FloatingLegCalculation.FloatingLegCalculationBuilder toBuilder();
	
	static FloatingLegCalculation.FloatingLegCalculationBuilder builder() {
		return new FloatingLegCalculation.FloatingLegCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingLegCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingLegCalculation> getType() {
		return FloatingLegCalculation.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingLegCalculationBuilder extends FloatingLegCalculation, RosettaModelObjectBuilder {
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		Rounding.RoundingBuilder getOrCreateRounding();
		Rounding.RoundingBuilder getRounding();
		CommoditySpread.CommoditySpreadBuilder getOrCreateSpread();
		CommoditySpread.CommoditySpreadBuilder getSpread();
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder getOrCreateSpreadSchedule(int _index);
		List<? extends CommoditySpreadSchedule.CommoditySpreadScheduleBuilder> getSpreadSchedule();
		CommodityFx.CommodityFxBuilder getOrCreateFx();
		CommodityFx.CommodityFxBuilder getFx();
		FloatingLegCalculation.FloatingLegCalculationBuilder setPricingDates(CommodityPricingDates pricingDates);
		FloatingLegCalculation.FloatingLegCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		FloatingLegCalculation.FloatingLegCalculationBuilder setConversionFactor(BigDecimal conversionFactor);
		FloatingLegCalculation.FloatingLegCalculationBuilder setRounding(Rounding rounding);
		FloatingLegCalculation.FloatingLegCalculationBuilder setSpread(CommoditySpread spread);
		FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule0);
		FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule1, int _idx);
		FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule2);
		FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule3);
		FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadPercentage(BigDecimal spreadPercentage);
		FloatingLegCalculation.FloatingLegCalculationBuilder setFx(CommodityFx fx);

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
		}
		

		FloatingLegCalculation.FloatingLegCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingLegCalculation  ***********************/
	class FloatingLegCalculationImpl implements FloatingLegCalculation {
		private final CommodityPricingDates pricingDates;
		private final AveragingMethodEnum averagingMethod;
		private final BigDecimal conversionFactor;
		private final Rounding rounding;
		private final CommoditySpread spread;
		private final List<? extends CommoditySpreadSchedule> spreadSchedule;
		private final BigDecimal spreadPercentage;
		private final CommodityFx fx;
		
		protected FloatingLegCalculationImpl(FloatingLegCalculation.FloatingLegCalculationBuilder builder) {
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.conversionFactor = builder.getConversionFactor();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
			this.spread = ofNullable(builder.getSpread()).map(f->f.build()).orElse(null);
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.spreadPercentage = builder.getSpreadPercentage();
			this.fx = ofNullable(builder.getFx()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		@RosettaAttribute("spread")
		public CommoditySpread getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		public List<? extends CommoditySpreadSchedule> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		@RosettaAttribute("spreadPercentage")
		public BigDecimal getSpreadPercentage() {
			return spreadPercentage;
		}
		
		@Override
		@RosettaAttribute("fx")
		public CommodityFx getFx() {
			return fx;
		}
		
		@Override
		public FloatingLegCalculation build() {
			return this;
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder toBuilder() {
			FloatingLegCalculation.FloatingLegCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingLegCalculation.FloatingLegCalculationBuilder builder) {
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
			ofNullable(getSpreadPercentage()).ifPresent(builder::setSpreadPercentage);
			ofNullable(getFx()).ifPresent(builder::setFx);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingLegCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(spreadPercentage, _that.getSpreadPercentage())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadPercentage != null ? spreadPercentage.hashCode() : 0);
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingLegCalculation {" +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"rounding=" + this.rounding + ", " +
				"spread=" + this.spread + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"spreadPercentage=" + this.spreadPercentage + ", " +
				"fx=" + this.fx +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingLegCalculation  ***********************/
	class FloatingLegCalculationBuilderImpl implements FloatingLegCalculation.FloatingLegCalculationBuilder {
	
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected AveragingMethodEnum averagingMethod;
		protected BigDecimal conversionFactor;
		protected Rounding.RoundingBuilder rounding;
		protected CommoditySpread.CommoditySpreadBuilder spread;
		protected List<CommoditySpreadSchedule.CommoditySpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
		protected BigDecimal spreadPercentage;
		protected CommodityFx.CommodityFxBuilder fx;
	
		public FloatingLegCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates() {
			CommodityPricingDates.CommodityPricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = CommodityPricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spread")
		public CommoditySpread.CommoditySpreadBuilder getSpread() {
			return spread;
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder getOrCreateSpread() {
			CommoditySpread.CommoditySpreadBuilder result;
			if (spread!=null) {
				result = spread;
			}
			else {
				result = spread = CommoditySpread.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		public List<? extends CommoditySpreadSchedule.CommoditySpreadScheduleBuilder> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder getOrCreateSpreadSchedule(int _index) {
		
			if (spreadSchedule==null) {
				this.spreadSchedule = new ArrayList<>();
			}
			CommoditySpreadSchedule.CommoditySpreadScheduleBuilder result;
			return getIndex(spreadSchedule, _index, () -> {
						CommoditySpreadSchedule.CommoditySpreadScheduleBuilder newSpreadSchedule = CommoditySpreadSchedule.builder();
						return newSpreadSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("spreadPercentage")
		public BigDecimal getSpreadPercentage() {
			return spreadPercentage;
		}
		
		@Override
		@RosettaAttribute("fx")
		public CommodityFx.CommodityFxBuilder getFx() {
			return fx;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder getOrCreateFx() {
			CommodityFx.CommodityFxBuilder result;
			if (fx!=null) {
				result = fx;
			}
			else {
				result = fx = CommodityFx.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public FloatingLegCalculation.FloatingLegCalculationBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public FloatingLegCalculation.FloatingLegCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("conversionFactor")
		public FloatingLegCalculation.FloatingLegCalculationBuilder setConversionFactor(BigDecimal conversionFactor) {
			this.conversionFactor = conversionFactor==null?null:conversionFactor;
			return this;
		}
		@Override
		@RosettaAttribute("rounding")
		public FloatingLegCalculation.FloatingLegCalculationBuilder setRounding(Rounding rounding) {
			this.rounding = rounding==null?null:rounding.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spread")
		public FloatingLegCalculation.FloatingLegCalculationBuilder setSpread(CommoditySpread spread) {
			this.spread = spread==null?null:spread.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spreadSchedule")
		public FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (CommoditySpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
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
		public FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadPercentage(BigDecimal spreadPercentage) {
			this.spreadPercentage = spreadPercentage==null?null:spreadPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("fx")
		public FloatingLegCalculation.FloatingLegCalculationBuilder setFx(CommodityFx fx) {
			this.fx = fx==null?null:fx.toBuilder();
			return this;
		}
		
		@Override
		public FloatingLegCalculation build() {
			return new FloatingLegCalculation.FloatingLegCalculationImpl(this);
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder prune() {
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			if (spread!=null && !spread.prune().hasData()) spread = null;
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<CommoditySpreadSchedule.CommoditySpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fx!=null && !fx.prune().hasData()) fx = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getConversionFactor()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			if (getSpread()!=null && getSpread().hasData()) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpreadPercentage()!=null) return true;
			if (getFx()!=null && getFx().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingLegCalculation.FloatingLegCalculationBuilder o = (FloatingLegCalculation.FloatingLegCalculationBuilder) other;
			
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			merger.mergeRosetta(getSpread(), o.getSpread(), this::setSpread);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			merger.mergeRosetta(getFx(), o.getFx(), this::setFx);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			merger.mergeBasic(getSpreadPercentage(), o.getSpreadPercentage(), this::setSpreadPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingLegCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(spreadPercentage, _that.getSpreadPercentage())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadPercentage != null ? spreadPercentage.hashCode() : 0);
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingLegCalculationBuilder {" +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"rounding=" + this.rounding + ", " +
				"spread=" + this.spread + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"spreadPercentage=" + this.spreadPercentage + ", " +
				"fx=" + this.fx +
			'}';
		}
	}
}
