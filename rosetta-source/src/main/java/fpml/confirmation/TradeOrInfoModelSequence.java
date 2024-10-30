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
import fpml.confirmation.TradeOrInfoModelSequence;
import fpml.confirmation.TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder;
import fpml.confirmation.TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilderImpl;
import fpml.confirmation.TradeOrInfoModelSequence.TradeOrInfoModelSequenceImpl;
import fpml.confirmation.meta.TradeOrInfoModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradeOrInfoModelSequence", builder=TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradeOrInfoModelSequence extends RosettaModelObject {

	TradeOrInfoModelSequenceMeta metaData = new TradeOrInfoModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This may be used to describe why a trade was created. This can be used to provide context for a newly created trade that is not part of a post-trade event. For example, it can report that the trade was created as a result of netting activity, or due to a transfer, an allocation process, etc. Omitting this implies that the trade record was created as a result of a negotiated new trade.
	 */
	OriginatingEvent getOriginatingEvent();
	Trade getTrade();

	/*********************** Build Methods  ***********************/
	TradeOrInfoModelSequence build();
	
	TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder toBuilder();
	
	static TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder builder() {
		return new TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeOrInfoModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeOrInfoModelSequence> getType() {
		return TradeOrInfoModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeOrInfoModelSequenceBuilder extends TradeOrInfoModelSequence, RosettaModelObjectBuilder {
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder setTrade(Trade trade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
		}
		

		TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeOrInfoModelSequence  ***********************/
	class TradeOrInfoModelSequenceImpl implements TradeOrInfoModelSequence {
		private final OriginatingEvent originatingEvent;
		private final Trade trade;
		
		protected TradeOrInfoModelSequenceImpl(TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder builder) {
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
		public TradeOrInfoModelSequence build() {
			return this;
		}
		
		@Override
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder toBuilder() {
			TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder builder) {
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeOrInfoModelSequence _that = getType().cast(o);
		
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
			return "TradeOrInfoModelSequence {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeOrInfoModelSequence  ***********************/
	class TradeOrInfoModelSequenceBuilderImpl implements TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder {
	
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected Trade.TradeBuilder trade;
	
		public TradeOrInfoModelSequenceBuilderImpl() {
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
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder setOriginatingEvent(OriginatingEvent originatingEvent) {
			this.originatingEvent = originatingEvent==null?null:originatingEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		
		@Override
		public TradeOrInfoModelSequence build() {
			return new TradeOrInfoModelSequence.TradeOrInfoModelSequenceImpl(this);
		}
		
		@Override
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder prune() {
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
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder o = (TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder) other;
			
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeOrInfoModelSequence _that = getType().cast(o);
		
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
			return "TradeOrInfoModelSequenceBuilder {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade +
			'}';
		}
	}
}
