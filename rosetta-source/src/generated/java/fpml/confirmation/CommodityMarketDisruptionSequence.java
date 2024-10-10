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
import fpml.confirmation.CommodityMarketDisruptionSequence;
import fpml.confirmation.CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder;
import fpml.confirmation.CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilderImpl;
import fpml.confirmation.CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceImpl;
import fpml.confirmation.MarketDisruptionEvent;
import fpml.confirmation.MarketDisruptionEventsEnum;
import fpml.confirmation.meta.CommodityMarketDisruptionSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityMarketDisruptionSequence", builder=CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityMarketDisruptionSequence extends RosettaModelObject {

	CommodityMarketDisruptionSequenceMeta metaData = new CommodityMarketDisruptionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If Market disruption Events are stated to be Applicable then the default Market Disruption Events of Section 7.4(d)(i) of the ISDA Commodity Definitions shall apply unless specific Market Disruption Events are stated hereunder, in which case these shall override the ISDA defaults. If Market Disruption Events are stated to be Not Applicable, Market Disruption Events are not applicable to the trade at all. It is also possible to reference the Market Disruption Events set out in the relevant Master Agreement governing the trade.
	 */
	MarketDisruptionEventsEnum getMarketDisruptionEvents();
	/**
	 * To be used when marketDisruptionEvents is set to &quot;Applicable&quot; and additional market disruption events(s) apply to the default market disruption events of Section 7.4(d)(i) of the ISDA Commodity Definitions.
	 */
	List<? extends MarketDisruptionEvent> getAdditionalMarketDisruptionEvent();

	/*********************** Build Methods  ***********************/
	CommodityMarketDisruptionSequence build();
	
	CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder toBuilder();
	
	static CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder builder() {
		return new CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMarketDisruptionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityMarketDisruptionSequence> getType() {
		return CommodityMarketDisruptionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("marketDisruptionEvents"), MarketDisruptionEventsEnum.class, getMarketDisruptionEvents(), this);
		processRosetta(path.newSubPath("additionalMarketDisruptionEvent"), processor, MarketDisruptionEvent.class, getAdditionalMarketDisruptionEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMarketDisruptionSequenceBuilder extends CommodityMarketDisruptionSequence, RosettaModelObjectBuilder {
		MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateAdditionalMarketDisruptionEvent(int _index);
		List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getAdditionalMarketDisruptionEvent();
		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder setMarketDisruptionEvents(MarketDisruptionEventsEnum marketDisruptionEvents);
		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent additionalMarketDisruptionEvent0);
		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent additionalMarketDisruptionEvent1, int _idx);
		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder addAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvent2);
		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder setAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvent3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("marketDisruptionEvents"), MarketDisruptionEventsEnum.class, getMarketDisruptionEvents(), this);
			processRosetta(path.newSubPath("additionalMarketDisruptionEvent"), processor, MarketDisruptionEvent.MarketDisruptionEventBuilder.class, getAdditionalMarketDisruptionEvent());
		}
		

		CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMarketDisruptionSequence  ***********************/
	class CommodityMarketDisruptionSequenceImpl implements CommodityMarketDisruptionSequence {
		private final MarketDisruptionEventsEnum marketDisruptionEvents;
		private final List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvent;
		
		protected CommodityMarketDisruptionSequenceImpl(CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder builder) {
			this.marketDisruptionEvents = builder.getMarketDisruptionEvents();
			this.additionalMarketDisruptionEvent = ofNullable(builder.getAdditionalMarketDisruptionEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("marketDisruptionEvents")
		public MarketDisruptionEventsEnum getMarketDisruptionEvents() {
			return marketDisruptionEvents;
		}
		
		@Override
		@RosettaAttribute("additionalMarketDisruptionEvent")
		public List<? extends MarketDisruptionEvent> getAdditionalMarketDisruptionEvent() {
			return additionalMarketDisruptionEvent;
		}
		
		@Override
		public CommodityMarketDisruptionSequence build() {
			return this;
		}
		
		@Override
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder toBuilder() {
			CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder builder) {
			ofNullable(getMarketDisruptionEvents()).ifPresent(builder::setMarketDisruptionEvents);
			ofNullable(getAdditionalMarketDisruptionEvent()).ifPresent(builder::setAdditionalMarketDisruptionEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMarketDisruptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(marketDisruptionEvents, _that.getMarketDisruptionEvents())) return false;
			if (!ListEquals.listEquals(additionalMarketDisruptionEvent, _that.getAdditionalMarketDisruptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marketDisruptionEvents != null ? marketDisruptionEvents.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalMarketDisruptionEvent != null ? additionalMarketDisruptionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMarketDisruptionSequence {" +
				"marketDisruptionEvents=" + this.marketDisruptionEvents + ", " +
				"additionalMarketDisruptionEvent=" + this.additionalMarketDisruptionEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMarketDisruptionSequence  ***********************/
	class CommodityMarketDisruptionSequenceBuilderImpl implements CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder {
	
		protected MarketDisruptionEventsEnum marketDisruptionEvents;
		protected List<MarketDisruptionEvent.MarketDisruptionEventBuilder> additionalMarketDisruptionEvent = new ArrayList<>();
	
		public CommodityMarketDisruptionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("marketDisruptionEvents")
		public MarketDisruptionEventsEnum getMarketDisruptionEvents() {
			return marketDisruptionEvents;
		}
		
		@Override
		@RosettaAttribute("additionalMarketDisruptionEvent")
		public List<? extends MarketDisruptionEvent.MarketDisruptionEventBuilder> getAdditionalMarketDisruptionEvent() {
			return additionalMarketDisruptionEvent;
		}
		
		public MarketDisruptionEvent.MarketDisruptionEventBuilder getOrCreateAdditionalMarketDisruptionEvent(int _index) {
		
			if (additionalMarketDisruptionEvent==null) {
				this.additionalMarketDisruptionEvent = new ArrayList<>();
			}
			MarketDisruptionEvent.MarketDisruptionEventBuilder result;
			return getIndex(additionalMarketDisruptionEvent, _index, () -> {
						MarketDisruptionEvent.MarketDisruptionEventBuilder newAdditionalMarketDisruptionEvent = MarketDisruptionEvent.builder();
						return newAdditionalMarketDisruptionEvent;
					});
		}
		
		@Override
		@RosettaAttribute("marketDisruptionEvents")
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder setMarketDisruptionEvents(MarketDisruptionEventsEnum marketDisruptionEvents) {
			this.marketDisruptionEvents = marketDisruptionEvents==null?null:marketDisruptionEvents;
			return this;
		}
		@Override
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent additionalMarketDisruptionEvent) {
			if (additionalMarketDisruptionEvent!=null) this.additionalMarketDisruptionEvent.add(additionalMarketDisruptionEvent.toBuilder());
			return this;
		}
		
		@Override
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder addAdditionalMarketDisruptionEvent(MarketDisruptionEvent additionalMarketDisruptionEvent, int _idx) {
			getIndex(this.additionalMarketDisruptionEvent, _idx, () -> additionalMarketDisruptionEvent.toBuilder());
			return this;
		}
		@Override 
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder addAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvents) {
			if (additionalMarketDisruptionEvents != null) {
				for (MarketDisruptionEvent toAdd : additionalMarketDisruptionEvents) {
					this.additionalMarketDisruptionEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalMarketDisruptionEvent")
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder setAdditionalMarketDisruptionEvent(List<? extends MarketDisruptionEvent> additionalMarketDisruptionEvents) {
			if (additionalMarketDisruptionEvents == null)  {
				this.additionalMarketDisruptionEvent = new ArrayList<>();
			}
			else {
				this.additionalMarketDisruptionEvent = additionalMarketDisruptionEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CommodityMarketDisruptionSequence build() {
			return new CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceImpl(this);
		}
		
		@Override
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder prune() {
			additionalMarketDisruptionEvent = additionalMarketDisruptionEvent.stream().filter(b->b!=null).<MarketDisruptionEvent.MarketDisruptionEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMarketDisruptionEvents()!=null) return true;
			if (getAdditionalMarketDisruptionEvent()!=null && getAdditionalMarketDisruptionEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder o = (CommodityMarketDisruptionSequence.CommodityMarketDisruptionSequenceBuilder) other;
			
			merger.mergeRosetta(getAdditionalMarketDisruptionEvent(), o.getAdditionalMarketDisruptionEvent(), this::getOrCreateAdditionalMarketDisruptionEvent);
			
			merger.mergeBasic(getMarketDisruptionEvents(), o.getMarketDisruptionEvents(), this::setMarketDisruptionEvents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMarketDisruptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(marketDisruptionEvents, _that.getMarketDisruptionEvents())) return false;
			if (!ListEquals.listEquals(additionalMarketDisruptionEvent, _that.getAdditionalMarketDisruptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marketDisruptionEvents != null ? marketDisruptionEvents.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalMarketDisruptionEvent != null ? additionalMarketDisruptionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMarketDisruptionSequenceBuilder {" +
				"marketDisruptionEvents=" + this.marketDisruptionEvents + ", " +
				"additionalMarketDisruptionEvent=" + this.additionalMarketDisruptionEvent +
			'}';
		}
	}
}
