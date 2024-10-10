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
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.Trade;
import fpml.confirmation.TradingEventsBaseModelSequence;
import fpml.confirmation.TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder;
import fpml.confirmation.TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilderImpl;
import fpml.confirmation.TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceImpl;
import fpml.confirmation.meta.TradingEventsBaseModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradingEventsBaseModelSequence", builder=TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilderImpl.class, version="${project.version}")
public interface TradingEventsBaseModelSequence extends RosettaModelObject {

	TradingEventsBaseModelSequenceMeta metaData = new TradingEventsBaseModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	OriginatingEvent getOriginatingEvent();
	Trade getTrade();

	/*********************** Build Methods  ***********************/
	TradingEventsBaseModelSequence build();
	
	TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder toBuilder();
	
	static TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder builder() {
		return new TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradingEventsBaseModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradingEventsBaseModelSequence> getType() {
		return TradingEventsBaseModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradingEventsBaseModelSequenceBuilder extends TradingEventsBaseModelSequence, RosettaModelObjectBuilder {
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder setTrade(Trade trade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
		}
		

		TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of TradingEventsBaseModelSequence  ***********************/
	class TradingEventsBaseModelSequenceImpl implements TradingEventsBaseModelSequence {
		private final OriginatingEvent originatingEvent;
		private final Trade trade;
		
		protected TradingEventsBaseModelSequenceImpl(TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder builder) {
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		public TradingEventsBaseModelSequence build() {
			return this;
		}
		
		@Override
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder toBuilder() {
			TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder builder) {
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventsBaseModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventsBaseModelSequence {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade +
			'}';
		}
	}

	/*********************** Builder Implementation of TradingEventsBaseModelSequence  ***********************/
	class TradingEventsBaseModelSequenceBuilderImpl implements TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder {
	
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected Trade.TradeBuilder trade;
	
		public TradingEventsBaseModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder setOriginatingEvent(OriginatingEvent originatingEvent) {
			this.originatingEvent = originatingEvent==null?null:originatingEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		
		@Override
		public TradingEventsBaseModelSequence build() {
			return new TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceImpl(this);
		}
		
		@Override
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder prune() {
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder o = (TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder) other;
			
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventsBaseModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventsBaseModelSequenceBuilder {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade +
			'}';
		}
	}
}
