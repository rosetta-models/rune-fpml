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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommoditySwapDetailsModel;
import fpml.confirmation.CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder;
import fpml.confirmation.CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilderImpl;
import fpml.confirmation.CommoditySwapDetailsModel.CommoditySwapDetailsModelImpl;
import fpml.confirmation.CommoditySwapLeg;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.WeatherLeg;
import fpml.confirmation.meta.CommoditySwapDetailsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommoditySwapDetailsModel", builder=CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilderImpl.class, version="${project.version}")
public interface CommoditySwapDetailsModel extends RosettaModelObject {

	CommoditySwapDetailsModelMeta metaData = new CommoditySwapDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the effective date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the effective date of the other leg of the swap.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * Specifies the termination date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the termination date of the other leg of the swap.
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 * The currency into which the Commodity Swap Transaction will settle. If this is not the same as the currency in which the Commodity Reference Price is quoted on a given floating leg of the Commodity Swap Transaction, then an FX rate should also be specified for that leg.
	 */
	IdentifiedCurrency getSettlementCurrency();
	List<? extends CommoditySwapLeg> getCommoditySwapLeg();
	/**
	 * A weather leg element of a Commodity Swap defines Weather Index Swap transactions. Weather Index Swap transactions are OTC derivative transactions which settle financially based on an index calculated from observations of temperature, precipitation and other weather-related measurements at weather stations throughout the world. Sub-Annex C of the 2005 ISDA Commodity Definitions provides definitions and terms for a number of types of weather indices. These indices include: HDD (heating degree days), CDD (cooling degree days), CPD (critical precipitation days). Weather Index Swap transactions result in a cash flow to one of the two counterparties each Calculation Period depending on the relationship between the Settlement Level and the Weather Index Level. A Weather Index swap transaction always consists of a commodity swap element as a parent to two weatherLeg elements.
	 */
	List<? extends WeatherLeg> getWeatherLeg();
	CommodityContentModel getCommodityContentModel();

	/*********************** Build Methods  ***********************/
	CommoditySwapDetailsModel build();
	
	CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder toBuilder();
	
	static CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder builder() {
		return new CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwapDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySwapDetailsModel> getType() {
		return CommoditySwapDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("commoditySwapLeg"), processor, CommoditySwapLeg.class, getCommoditySwapLeg());
		processRosetta(path.newSubPath("weatherLeg"), processor, WeatherLeg.class, getWeatherLeg());
		processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.class, getCommodityContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySwapDetailsModelBuilder extends CommoditySwapDetailsModel, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency();
		CommoditySwapLeg.CommoditySwapLegBuilder getOrCreateCommoditySwapLeg(int _index);
		List<? extends CommoditySwapLeg.CommoditySwapLegBuilder> getCommoditySwapLeg();
		WeatherLeg.WeatherLegBuilder getOrCreateWeatherLeg(int _index);
		List<? extends WeatherLeg.WeatherLegBuilder> getWeatherLeg();
		CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel();
		CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel();
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addCommoditySwapLeg(CommoditySwapLeg commoditySwapLeg0);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addCommoditySwapLeg(CommoditySwapLeg commoditySwapLeg1, int _idx);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addCommoditySwapLeg(List<? extends CommoditySwapLeg> commoditySwapLeg2);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setCommoditySwapLeg(List<? extends CommoditySwapLeg> commoditySwapLeg3);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addWeatherLeg(WeatherLeg weatherLeg0);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addWeatherLeg(WeatherLeg weatherLeg1, int _idx);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addWeatherLeg(List<? extends WeatherLeg> weatherLeg2);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setWeatherLeg(List<? extends WeatherLeg> weatherLeg3);
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("commoditySwapLeg"), processor, CommoditySwapLeg.CommoditySwapLegBuilder.class, getCommoditySwapLeg());
			processRosetta(path.newSubPath("weatherLeg"), processor, WeatherLeg.WeatherLegBuilder.class, getWeatherLeg());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
		}
		

		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwapDetailsModel  ***********************/
	class CommoditySwapDetailsModelImpl implements CommoditySwapDetailsModel {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final IdentifiedCurrency settlementCurrency;
		private final List<? extends CommoditySwapLeg> commoditySwapLeg;
		private final List<? extends WeatherLeg> weatherLeg;
		private final CommodityContentModel commodityContentModel;
		
		protected CommoditySwapDetailsModelImpl(CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.commoditySwapLeg = ofNullable(builder.getCommoditySwapLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.weatherLeg = ofNullable(builder.getWeatherLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityContentModel = ofNullable(builder.getCommodityContentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public IdentifiedCurrency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("commoditySwapLeg")
		public List<? extends CommoditySwapLeg> getCommoditySwapLeg() {
			return commoditySwapLeg;
		}
		
		@Override
		@RosettaAttribute("weatherLeg")
		public List<? extends WeatherLeg> getWeatherLeg() {
			return weatherLeg;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommoditySwapDetailsModel build() {
			return this;
		}
		
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder toBuilder() {
			CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getCommoditySwapLeg()).ifPresent(builder::setCommoditySwapLeg);
			ofNullable(getWeatherLeg()).ifPresent(builder::setWeatherLeg);
			ofNullable(getCommodityContentModel()).ifPresent(builder::setCommodityContentModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySwapDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!ListEquals.listEquals(commoditySwapLeg, _that.getCommoditySwapLeg())) return false;
			if (!ListEquals.listEquals(weatherLeg, _that.getWeatherLeg())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commoditySwapLeg != null ? commoditySwapLeg.hashCode() : 0);
			_result = 31 * _result + (weatherLeg != null ? weatherLeg.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwapDetailsModel {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commoditySwapLeg=" + this.commoditySwapLeg + ", " +
				"weatherLeg=" + this.weatherLeg + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySwapDetailsModel  ***********************/
	class CommoditySwapDetailsModelBuilderImpl implements CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder settlementCurrency;
		protected List<CommoditySwapLeg.CommoditySwapLegBuilder> commoditySwapLeg = new ArrayList<>();
		protected List<WeatherLeg.WeatherLegBuilder> weatherLeg = new ArrayList<>();
		protected CommodityContentModel.CommodityContentModelBuilder commodityContentModel;
	
		public CommoditySwapDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commoditySwapLeg")
		public List<? extends CommoditySwapLeg.CommoditySwapLegBuilder> getCommoditySwapLeg() {
			return commoditySwapLeg;
		}
		
		public CommoditySwapLeg.CommoditySwapLegBuilder getOrCreateCommoditySwapLeg(int _index) {
		
			if (commoditySwapLeg==null) {
				this.commoditySwapLeg = new ArrayList<>();
			}
			CommoditySwapLeg.CommoditySwapLegBuilder result;
			return getIndex(commoditySwapLeg, _index, () -> {
						CommoditySwapLeg.CommoditySwapLegBuilder newCommoditySwapLeg = CommoditySwapLeg.builder();
						return newCommoditySwapLeg;
					});
		}
		
		@Override
		@RosettaAttribute("weatherLeg")
		public List<? extends WeatherLeg.WeatherLegBuilder> getWeatherLeg() {
			return weatherLeg;
		}
		
		public WeatherLeg.WeatherLegBuilder getOrCreateWeatherLeg(int _index) {
		
			if (weatherLeg==null) {
				this.weatherLeg = new ArrayList<>();
			}
			WeatherLeg.WeatherLegBuilder result;
			return getIndex(weatherLeg, _index, () -> {
						WeatherLeg.WeatherLegBuilder newWeatherLeg = WeatherLeg.builder();
						return newWeatherLeg;
					});
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel() {
			CommodityContentModel.CommodityContentModelBuilder result;
			if (commodityContentModel!=null) {
				result = commodityContentModel;
			}
			else {
				result = commodityContentModel = CommodityContentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrency")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addCommoditySwapLeg(CommoditySwapLeg commoditySwapLeg) {
			if (commoditySwapLeg!=null) this.commoditySwapLeg.add(commoditySwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addCommoditySwapLeg(CommoditySwapLeg commoditySwapLeg, int _idx) {
			getIndex(this.commoditySwapLeg, _idx, () -> commoditySwapLeg.toBuilder());
			return this;
		}
		@Override 
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addCommoditySwapLeg(List<? extends CommoditySwapLeg> commoditySwapLegs) {
			if (commoditySwapLegs != null) {
				for (CommoditySwapLeg toAdd : commoditySwapLegs) {
					this.commoditySwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("commoditySwapLeg")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setCommoditySwapLeg(List<? extends CommoditySwapLeg> commoditySwapLegs) {
			if (commoditySwapLegs == null)  {
				this.commoditySwapLeg = new ArrayList<>();
			}
			else {
				this.commoditySwapLeg = commoditySwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addWeatherLeg(WeatherLeg weatherLeg) {
			if (weatherLeg!=null) this.weatherLeg.add(weatherLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addWeatherLeg(WeatherLeg weatherLeg, int _idx) {
			getIndex(this.weatherLeg, _idx, () -> weatherLeg.toBuilder());
			return this;
		}
		@Override 
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder addWeatherLeg(List<? extends WeatherLeg> weatherLegs) {
			if (weatherLegs != null) {
				for (WeatherLeg toAdd : weatherLegs) {
					this.weatherLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("weatherLeg")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setWeatherLeg(List<? extends WeatherLeg> weatherLegs) {
			if (weatherLegs == null)  {
				this.weatherLeg = new ArrayList<>();
			}
			else {
				this.weatherLeg = weatherLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySwapDetailsModel build() {
			return new CommoditySwapDetailsModel.CommoditySwapDetailsModelImpl(this);
		}
		
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			commoditySwapLeg = commoditySwapLeg.stream().filter(b->b!=null).<CommoditySwapLeg.CommoditySwapLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			weatherLeg = weatherLeg.stream().filter(b->b!=null).<WeatherLeg.WeatherLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityContentModel!=null && !commodityContentModel.prune().hasData()) commodityContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getCommoditySwapLeg()!=null && getCommoditySwapLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWeatherLeg()!=null && getWeatherLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityContentModel()!=null && getCommodityContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder o = (CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getCommoditySwapLeg(), o.getCommoditySwapLeg(), this::getOrCreateCommoditySwapLeg);
			merger.mergeRosetta(getWeatherLeg(), o.getWeatherLeg(), this::getOrCreateWeatherLeg);
			merger.mergeRosetta(getCommodityContentModel(), o.getCommodityContentModel(), this::setCommodityContentModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySwapDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!ListEquals.listEquals(commoditySwapLeg, _that.getCommoditySwapLeg())) return false;
			if (!ListEquals.listEquals(weatherLeg, _that.getWeatherLeg())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commoditySwapLeg != null ? commoditySwapLeg.hashCode() : 0);
			_result = 31 * _result + (weatherLeg != null ? weatherLeg.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwapDetailsModelBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commoditySwapLeg=" + this.commoditySwapLeg + ", " +
				"weatherLeg=" + this.weatherLeg + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}';
		}
	}
}
