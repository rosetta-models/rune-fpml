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
import fpml.confirmation.CommodityMarketDisruption;
import fpml.confirmation.CommodityMarketDisruption.CommodityMarketDisruptionBuilder;
import fpml.confirmation.CommodityMarketDisruption.CommodityMarketDisruptionBuilderImpl;
import fpml.confirmation.CommodityMarketDisruption.CommodityMarketDisruptionImpl;
import fpml.confirmation.CommodityMarketDisruptionSequence;
import fpml.confirmation.DisruptionFallbacksEnum;
import fpml.confirmation.MarketDisruptionEvent;
import fpml.confirmation.SequencedDisruptionFallback;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.CommodityMarketDisruptionMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * ISDA 1993 or 2005 commodity market disruption elements.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityMarketDisruption", builder=CommodityMarketDisruption.CommodityMarketDisruptionBuilderImpl.class, version="${project.version}")
public interface CommodityMarketDisruption extends RosettaModelObject {

	CommodityMarketDisruptionMeta metaData = new CommodityMarketDisruptionMeta();

	/*********************** Getter Methods  ***********************/
	CommodityMarketDisruptionSequence getCommodityMarketDisruptionSequence();
	/**
	 * Market disruption event(s) that apply. Note that these should only be specified if the default market disruption events of Section 7.4(d)(i) of the ISDA Commodity Definitions are to be overridden.
	 */
	List<? extends MarketDisruptionEvent> getMarketDisruptionEvent();
	/**
	 * To be used where disruption fallbacks are set out in the relevant Master Agreement governing the trade.
	 */
	DisruptionFallbacksEnum getDisruptionFallbacks();
	List<? extends SequencedDisruptionFallback> getDisruptionFallback();
	/**
	 * A fallback commodity reference price for use when relying on Disruption Fallbacks in Section 7.5(d)(i) of the ISDA Commodity Definitions or have selected &quot;Fallback Reference Price&quot; as a disruptionFallback.
	 */
	Underlyer getFallbackReferencePrice();
	/**
	 * 2005 Commodity Definitions only. If omitted , the number of days specified in Section 7.6(a) of the Definitions will apply.
	 */
	Integer getMaximumNumberOfDaysOfDisruption();
	/**
	 * 2005 Commodity Definitions only. To be used where a price materiality percentage applies to the &quot;Price Source Disruption&quot; event and this event has been specified by setting marketDisruption to true or including it in additionalMarketDisruptionEvent
	 */
	BigDecimal getPriceMaterialityPercentage();
	/**
	 * 1993 Commodity Definitions only. Specifies the Mimum Futures Contracts level that dictates whether or not a &quot;De Minimis Trading&quot; event has occurred. Only relevant if &#39;De Minimis Trading&#39; has been specified in marketDisruptionEvent or additionalMarketDisruptionEvent.
	 */
	Integer getMinimumFuturesContracts();

	/*********************** Build Methods  ***********************/
	CommodityMarketDisruption build();
	
	CommodityMarketDisruption.CommodityMarketDisruptionBuilder toBuilder();
	
	static CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder() {
		return new CommodityMarketDisruption.CommodityMarketDisruptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMarketDisruption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityMarketDisruption> getType() {
		return CommodityMarketDisruption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityMarketDisruptionSequence"), processor, CommodityMarketDisruptionSequence.class, getCommodityMarketDisruptionSequence());
		processRosetta(path.newSubPath("marketDisruptionEvent"), processor, MarketDisruptionEvent.class, getMarketDisruptionEvent());
		processor.processBasic(path.newSubPath("disruptionFallbacks"), DisruptionFallbacksEnum.class, getDisruptionFallbacks(), this);
		processRosetta(path.newSubPath("disruptionFallback"), processor, SequencedDisruptionFallback.class, getDisruptionFallback());
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, Underlyer.class, getFallbackReferencePrice());
		processor.processBasic(path.newSubPath("maximumNumberOfDaysOfDisruption"), Integer.class, getMaximumNumberOfDaysOfDisruption(), this);
		processor.processBasic(path.newSubPath("priceMaterialityPercentage"), BigDecimal.class, getPriceMaterialityPercentage(), this);
		processor.processBasic(path.newSubPath("minimumFuturesContracts"), Integer.class, getMinimumFuturesContracts(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMarketDisruptionBuilder extends CommodityMarketDisruption, RosettaModelObjectBuilder {
		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder getOrCreateCommodityMarketDisruptionSequence();
		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder getCommodityMarketDisruptionSequence();
		MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateMarketDisruptionEvent(int _index);
		List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getMarketDisruptionEvent();
		SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder getOrCreateDisruptionFallback(int _index);
		List<? extends SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder> getDisruptionFallback();
		Underlyer.UnderlyerBuilder getOrCreateFallbackReferencePrice();
		Underlyer.UnderlyerBuilder getFallbackReferencePrice();
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setCommodityMarketDisruptionSequence(CommodityMarketDisruptionSequence commodityMarketDisruptionSequence);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent marketDisruptionEvent0);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent marketDisruptionEvent1, int _idx);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(List<? extends MarketDisruptionEvent> marketDisruptionEvent2);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMarketDisruptionEvent(List<? extends MarketDisruptionEvent> marketDisruptionEvent3);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallbacks(DisruptionFallbacksEnum disruptionFallbacks);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback disruptionFallback0);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback disruptionFallback1, int _idx);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(List<? extends SequencedDisruptionFallback> disruptionFallback2);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallback(List<? extends SequencedDisruptionFallback> disruptionFallback3);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setFallbackReferencePrice(Underlyer fallbackReferencePrice);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMaximumNumberOfDaysOfDisruption(Integer maximumNumberOfDaysOfDisruption);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setPriceMaterialityPercentage(BigDecimal priceMaterialityPercentage);
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMinimumFuturesContracts(Integer minimumFuturesContracts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityMarketDisruptionSequence"), processor, CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder.class, getCommodityMarketDisruptionSequence());
			processRosetta(path.newSubPath("marketDisruptionEvent"), processor, MarketDisruptionEvent.MarketDisruptionEventBuilder.class, getMarketDisruptionEvent());
			processor.processBasic(path.newSubPath("disruptionFallbacks"), DisruptionFallbacksEnum.class, getDisruptionFallbacks(), this);
			processRosetta(path.newSubPath("disruptionFallback"), processor, SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder.class, getDisruptionFallback());
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, Underlyer.UnderlyerBuilder.class, getFallbackReferencePrice());
			processor.processBasic(path.newSubPath("maximumNumberOfDaysOfDisruption"), Integer.class, getMaximumNumberOfDaysOfDisruption(), this);
			processor.processBasic(path.newSubPath("priceMaterialityPercentage"), BigDecimal.class, getPriceMaterialityPercentage(), this);
			processor.processBasic(path.newSubPath("minimumFuturesContracts"), Integer.class, getMinimumFuturesContracts(), this);
		}
		

		CommodityMarketDisruption.CommodityMarketDisruptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMarketDisruption  ***********************/
	class CommodityMarketDisruptionImpl implements CommodityMarketDisruption {
		private final CommodityMarketDisruptionSequence commodityMarketDisruptionSequence;
		private final List<? extends MarketDisruptionEvent> marketDisruptionEvent;
		private final DisruptionFallbacksEnum disruptionFallbacks;
		private final List<? extends SequencedDisruptionFallback> disruptionFallback;
		private final Underlyer fallbackReferencePrice;
		private final Integer maximumNumberOfDaysOfDisruption;
		private final BigDecimal priceMaterialityPercentage;
		private final Integer minimumFuturesContracts;
		
		protected CommodityMarketDisruptionImpl(CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder) {
			this.commodityMarketDisruptionSequence = ofNullable(builder.getCommodityMarketDisruptionSequence()).map(f->f.build()).orElse(null);
			this.marketDisruptionEvent = ofNullable(builder.getMarketDisruptionEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.disruptionFallbacks = builder.getDisruptionFallbacks();
			this.disruptionFallback = ofNullable(builder.getDisruptionFallback()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
			this.maximumNumberOfDaysOfDisruption = builder.getMaximumNumberOfDaysOfDisruption();
			this.priceMaterialityPercentage = builder.getPriceMaterialityPercentage();
			this.minimumFuturesContracts = builder.getMinimumFuturesContracts();
		}
		
		@Override
		@RosettaAttribute("commodityMarketDisruptionSequence")
		public CommodityMarketDisruptionSequence getCommodityMarketDisruptionSequence() {
			return commodityMarketDisruptionSequence;
		}
		
		@Override
		@RosettaAttribute("marketDisruptionEvent")
		public List<? extends MarketDisruptionEvent> getMarketDisruptionEvent() {
			return marketDisruptionEvent;
		}
		
		@Override
		@RosettaAttribute("disruptionFallbacks")
		public DisruptionFallbacksEnum getDisruptionFallbacks() {
			return disruptionFallbacks;
		}
		
		@Override
		@RosettaAttribute("disruptionFallback")
		public List<? extends SequencedDisruptionFallback> getDisruptionFallback() {
			return disruptionFallback;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		public Underlyer getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfDaysOfDisruption")
		public Integer getMaximumNumberOfDaysOfDisruption() {
			return maximumNumberOfDaysOfDisruption;
		}
		
		@Override
		@RosettaAttribute("priceMaterialityPercentage")
		public BigDecimal getPriceMaterialityPercentage() {
			return priceMaterialityPercentage;
		}
		
		@Override
		@RosettaAttribute("minimumFuturesContracts")
		public Integer getMinimumFuturesContracts() {
			return minimumFuturesContracts;
		}
		
		@Override
		public CommodityMarketDisruption build() {
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder toBuilder() {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMarketDisruption.CommodityMarketDisruptionBuilder builder) {
			ofNullable(getCommodityMarketDisruptionSequence()).ifPresent(builder::setCommodityMarketDisruptionSequence);
			ofNullable(getMarketDisruptionEvent()).ifPresent(builder::setMarketDisruptionEvent);
			ofNullable(getDisruptionFallbacks()).ifPresent(builder::setDisruptionFallbacks);
			ofNullable(getDisruptionFallback()).ifPresent(builder::setDisruptionFallback);
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
			ofNullable(getMaximumNumberOfDaysOfDisruption()).ifPresent(builder::setMaximumNumberOfDaysOfDisruption);
			ofNullable(getPriceMaterialityPercentage()).ifPresent(builder::setPriceMaterialityPercentage);
			ofNullable(getMinimumFuturesContracts()).ifPresent(builder::setMinimumFuturesContracts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMarketDisruption _that = getType().cast(o);
		
			if (!Objects.equals(commodityMarketDisruptionSequence, _that.getCommodityMarketDisruptionSequence())) return false;
			if (!ListEquals.listEquals(marketDisruptionEvent, _that.getMarketDisruptionEvent())) return false;
			if (!Objects.equals(disruptionFallbacks, _that.getDisruptionFallbacks())) return false;
			if (!ListEquals.listEquals(disruptionFallback, _that.getDisruptionFallback())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(maximumNumberOfDaysOfDisruption, _that.getMaximumNumberOfDaysOfDisruption())) return false;
			if (!Objects.equals(priceMaterialityPercentage, _that.getPriceMaterialityPercentage())) return false;
			if (!Objects.equals(minimumFuturesContracts, _that.getMinimumFuturesContracts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityMarketDisruptionSequence != null ? commodityMarketDisruptionSequence.hashCode() : 0);
			_result = 31 * _result + (marketDisruptionEvent != null ? marketDisruptionEvent.hashCode() : 0);
			_result = 31 * _result + (disruptionFallbacks != null ? disruptionFallbacks.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (disruptionFallback != null ? disruptionFallback.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfDaysOfDisruption != null ? maximumNumberOfDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (priceMaterialityPercentage != null ? priceMaterialityPercentage.hashCode() : 0);
			_result = 31 * _result + (minimumFuturesContracts != null ? minimumFuturesContracts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMarketDisruption {" +
				"commodityMarketDisruptionSequence=" + this.commodityMarketDisruptionSequence + ", " +
				"marketDisruptionEvent=" + this.marketDisruptionEvent + ", " +
				"disruptionFallbacks=" + this.disruptionFallbacks + ", " +
				"disruptionFallback=" + this.disruptionFallback + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"maximumNumberOfDaysOfDisruption=" + this.maximumNumberOfDaysOfDisruption + ", " +
				"priceMaterialityPercentage=" + this.priceMaterialityPercentage + ", " +
				"minimumFuturesContracts=" + this.minimumFuturesContracts +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMarketDisruption  ***********************/
	class CommodityMarketDisruptionBuilderImpl implements CommodityMarketDisruption.CommodityMarketDisruptionBuilder {
	
		protected CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder commodityMarketDisruptionSequence;
		protected List<MarketDisruptionEvent.MarketDisruptionEventBuilder> marketDisruptionEvent = new ArrayList<>();
		protected DisruptionFallbacksEnum disruptionFallbacks;
		protected List<SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder> disruptionFallback = new ArrayList<>();
		protected Underlyer.UnderlyerBuilder fallbackReferencePrice;
		protected Integer maximumNumberOfDaysOfDisruption;
		protected BigDecimal priceMaterialityPercentage;
		protected Integer minimumFuturesContracts;
	
		public CommodityMarketDisruptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityMarketDisruptionSequence")
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder getCommodityMarketDisruptionSequence() {
			return commodityMarketDisruptionSequence;
		}
		
		@Override
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder getOrCreateCommodityMarketDisruptionSequence() {
			CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder result;
			if (commodityMarketDisruptionSequence!=null) {
				result = commodityMarketDisruptionSequence;
			}
			else {
				result = commodityMarketDisruptionSequence = CommodityMarketDisruptionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("marketDisruptionEvent")
		public List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getMarketDisruptionEvent() {
			return marketDisruptionEvent;
		}
		
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateMarketDisruptionEvent(int _index) {
		
			if (marketDisruptionEvent==null) {
				this.marketDisruptionEvent = new ArrayList<>();
			}
			MarketDisruptionEvent.MarketDisruptionEventBuilder result;
			return getIndex(marketDisruptionEvent, _index, () -> {
						MarketDisruptionEvent.MarketDisruptionEventBuilder newMarketDisruptionEvent = MarketDisruptionEvent.builder();
						return newMarketDisruptionEvent;
					});
		}
		
		@Override
		@RosettaAttribute("disruptionFallbacks")
		public DisruptionFallbacksEnum getDisruptionFallbacks() {
			return disruptionFallbacks;
		}
		
		@Override
		@RosettaAttribute("disruptionFallback")
		public List<? extends SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder> getDisruptionFallback() {
			return disruptionFallback;
		}
		
		@Override
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder getOrCreateDisruptionFallback(int _index) {
		
			if (disruptionFallback==null) {
				this.disruptionFallback = new ArrayList<>();
			}
			SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder result;
			return getIndex(disruptionFallback, _index, () -> {
						SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder newDisruptionFallback = SequencedDisruptionFallback.builder();
						return newDisruptionFallback;
					});
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		public Underlyer.UnderlyerBuilder getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder getOrCreateFallbackReferencePrice() {
			Underlyer.UnderlyerBuilder result;
			if (fallbackReferencePrice!=null) {
				result = fallbackReferencePrice;
			}
			else {
				result = fallbackReferencePrice = Underlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfDaysOfDisruption")
		public Integer getMaximumNumberOfDaysOfDisruption() {
			return maximumNumberOfDaysOfDisruption;
		}
		
		@Override
		@RosettaAttribute("priceMaterialityPercentage")
		public BigDecimal getPriceMaterialityPercentage() {
			return priceMaterialityPercentage;
		}
		
		@Override
		@RosettaAttribute("minimumFuturesContracts")
		public Integer getMinimumFuturesContracts() {
			return minimumFuturesContracts;
		}
		
		@Override
		@RosettaAttribute("commodityMarketDisruptionSequence")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setCommodityMarketDisruptionSequence(CommodityMarketDisruptionSequence commodityMarketDisruptionSequence) {
			this.commodityMarketDisruptionSequence = commodityMarketDisruptionSequence==null?null:commodityMarketDisruptionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("marketDisruptionEvent")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent marketDisruptionEvent) {
			if (marketDisruptionEvent!=null) this.marketDisruptionEvent.add(marketDisruptionEvent.toBuilder());
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(MarketDisruptionEvent marketDisruptionEvent, int _idx) {
			getIndex(this.marketDisruptionEvent, _idx, () -> marketDisruptionEvent.toBuilder());
			return this;
		}
		@Override 
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addMarketDisruptionEvent(List<? extends MarketDisruptionEvent> marketDisruptionEvents) {
			if (marketDisruptionEvents != null) {
				for (MarketDisruptionEvent toAdd : marketDisruptionEvents) {
					this.marketDisruptionEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMarketDisruptionEvent(List<? extends MarketDisruptionEvent> marketDisruptionEvents) {
			if (marketDisruptionEvents == null)  {
				this.marketDisruptionEvent = new ArrayList<>();
			}
			else {
				this.marketDisruptionEvent = marketDisruptionEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("disruptionFallbacks")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallbacks(DisruptionFallbacksEnum disruptionFallbacks) {
			this.disruptionFallbacks = disruptionFallbacks==null?null:disruptionFallbacks;
			return this;
		}
		@Override
		@RosettaAttribute("disruptionFallback")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback disruptionFallback) {
			if (disruptionFallback!=null) this.disruptionFallback.add(disruptionFallback.toBuilder());
			return this;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(SequencedDisruptionFallback disruptionFallback, int _idx) {
			getIndex(this.disruptionFallback, _idx, () -> disruptionFallback.toBuilder());
			return this;
		}
		@Override 
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder addDisruptionFallback(List<? extends SequencedDisruptionFallback> disruptionFallbacks) {
			if (disruptionFallbacks != null) {
				for (SequencedDisruptionFallback toAdd : disruptionFallbacks) {
					this.disruptionFallback.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setDisruptionFallback(List<? extends SequencedDisruptionFallback> disruptionFallbacks) {
			if (disruptionFallbacks == null)  {
				this.disruptionFallback = new ArrayList<>();
			}
			else {
				this.disruptionFallback = disruptionFallbacks.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setFallbackReferencePrice(Underlyer fallbackReferencePrice) {
			this.fallbackReferencePrice = fallbackReferencePrice==null?null:fallbackReferencePrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maximumNumberOfDaysOfDisruption")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMaximumNumberOfDaysOfDisruption(Integer maximumNumberOfDaysOfDisruption) {
			this.maximumNumberOfDaysOfDisruption = maximumNumberOfDaysOfDisruption==null?null:maximumNumberOfDaysOfDisruption;
			return this;
		}
		@Override
		@RosettaAttribute("priceMaterialityPercentage")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setPriceMaterialityPercentage(BigDecimal priceMaterialityPercentage) {
			this.priceMaterialityPercentage = priceMaterialityPercentage==null?null:priceMaterialityPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("minimumFuturesContracts")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder setMinimumFuturesContracts(Integer minimumFuturesContracts) {
			this.minimumFuturesContracts = minimumFuturesContracts==null?null:minimumFuturesContracts;
			return this;
		}
		
		@Override
		public CommodityMarketDisruption build() {
			return new CommodityMarketDisruption.CommodityMarketDisruptionImpl(this);
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder prune() {
			if (commodityMarketDisruptionSequence!=null && !commodityMarketDisruptionSequence.prune().hasData()) commodityMarketDisruptionSequence = null;
			marketDisruptionEvent = marketDisruptionEvent.stream().filter(b->b!=null).<MarketDisruptionEvent.MarketDisruptionEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			disruptionFallback = disruptionFallback.stream().filter(b->b!=null).<SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityMarketDisruptionSequence()!=null && getCommodityMarketDisruptionSequence().hasData()) return true;
			if (getMarketDisruptionEvent()!=null && getMarketDisruptionEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDisruptionFallbacks()!=null) return true;
			if (getDisruptionFallback()!=null && getDisruptionFallback().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			if (getMaximumNumberOfDaysOfDisruption()!=null) return true;
			if (getPriceMaterialityPercentage()!=null) return true;
			if (getMinimumFuturesContracts()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder o = (CommodityMarketDisruption.CommodityMarketDisruptionBuilder) other;
			
			merger.mergeRosetta(getCommodityMarketDisruptionSequence(), o.getCommodityMarketDisruptionSequence(), this::setCommodityMarketDisruptionSequence);
			merger.mergeRosetta(getMarketDisruptionEvent(), o.getMarketDisruptionEvent(), this::getOrCreateMarketDisruptionEvent);
			merger.mergeRosetta(getDisruptionFallback(), o.getDisruptionFallback(), this::getOrCreateDisruptionFallback);
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			
			merger.mergeBasic(getDisruptionFallbacks(), o.getDisruptionFallbacks(), this::setDisruptionFallbacks);
			merger.mergeBasic(getMaximumNumberOfDaysOfDisruption(), o.getMaximumNumberOfDaysOfDisruption(), this::setMaximumNumberOfDaysOfDisruption);
			merger.mergeBasic(getPriceMaterialityPercentage(), o.getPriceMaterialityPercentage(), this::setPriceMaterialityPercentage);
			merger.mergeBasic(getMinimumFuturesContracts(), o.getMinimumFuturesContracts(), this::setMinimumFuturesContracts);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMarketDisruption _that = getType().cast(o);
		
			if (!Objects.equals(commodityMarketDisruptionSequence, _that.getCommodityMarketDisruptionSequence())) return false;
			if (!ListEquals.listEquals(marketDisruptionEvent, _that.getMarketDisruptionEvent())) return false;
			if (!Objects.equals(disruptionFallbacks, _that.getDisruptionFallbacks())) return false;
			if (!ListEquals.listEquals(disruptionFallback, _that.getDisruptionFallback())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(maximumNumberOfDaysOfDisruption, _that.getMaximumNumberOfDaysOfDisruption())) return false;
			if (!Objects.equals(priceMaterialityPercentage, _that.getPriceMaterialityPercentage())) return false;
			if (!Objects.equals(minimumFuturesContracts, _that.getMinimumFuturesContracts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityMarketDisruptionSequence != null ? commodityMarketDisruptionSequence.hashCode() : 0);
			_result = 31 * _result + (marketDisruptionEvent != null ? marketDisruptionEvent.hashCode() : 0);
			_result = 31 * _result + (disruptionFallbacks != null ? disruptionFallbacks.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (disruptionFallback != null ? disruptionFallback.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfDaysOfDisruption != null ? maximumNumberOfDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (priceMaterialityPercentage != null ? priceMaterialityPercentage.hashCode() : 0);
			_result = 31 * _result + (minimumFuturesContracts != null ? minimumFuturesContracts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMarketDisruptionBuilder {" +
				"commodityMarketDisruptionSequence=" + this.commodityMarketDisruptionSequence + ", " +
				"marketDisruptionEvent=" + this.marketDisruptionEvent + ", " +
				"disruptionFallbacks=" + this.disruptionFallbacks + ", " +
				"disruptionFallback=" + this.disruptionFallback + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"maximumNumberOfDaysOfDisruption=" + this.maximumNumberOfDaysOfDisruption + ", " +
				"priceMaterialityPercentage=" + this.priceMaterialityPercentage + ", " +
				"minimumFuturesContracts=" + this.minimumFuturesContracts +
			'}';
		}
	}
}
