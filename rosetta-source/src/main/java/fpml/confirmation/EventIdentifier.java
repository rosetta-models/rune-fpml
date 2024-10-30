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
import fpml.confirmation.EventIdentifier;
import fpml.confirmation.EventIdentifier.EventIdentifierBuilder;
import fpml.confirmation.EventIdentifier.EventIdentifierBuilderImpl;
import fpml.confirmation.EventIdentifier.EventIdentifierImpl;
import fpml.confirmation.EventIdentifierSequence;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.EventIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identification of a business event, for example through its correlation id or a business identifier.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventIdentifier", builder=EventIdentifier.EventIdentifierBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventIdentifier extends RosettaModelObject {

	EventIdentifierMeta metaData = new EventIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	EventIdentifierSequence getEventIdentifierSequence();
	TradeIdentifier getTradeIdentifier();

	/*********************** Build Methods  ***********************/
	EventIdentifier build();
	
	EventIdentifier.EventIdentifierBuilder toBuilder();
	
	static EventIdentifier.EventIdentifierBuilder builder() {
		return new EventIdentifier.EventIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventIdentifier> getType() {
		return EventIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifierSequence"), processor, EventIdentifierSequence.class, getEventIdentifierSequence());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventIdentifierBuilder extends EventIdentifier, RosettaModelObjectBuilder {
		EventIdentifierSequence.EventIdentifierSequenceBuilder getOrCreateEventIdentifierSequence();
		EventIdentifierSequence.EventIdentifierSequenceBuilder getEventIdentifierSequence();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier();
		EventIdentifier.EventIdentifierBuilder setEventIdentifierSequence(EventIdentifierSequence eventIdentifierSequence);
		EventIdentifier.EventIdentifierBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifierSequence"), processor, EventIdentifierSequence.EventIdentifierSequenceBuilder.class, getEventIdentifierSequence());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
		}
		

		EventIdentifier.EventIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of EventIdentifier  ***********************/
	class EventIdentifierImpl implements EventIdentifier {
		private final EventIdentifierSequence eventIdentifierSequence;
		private final TradeIdentifier tradeIdentifier;
		
		protected EventIdentifierImpl(EventIdentifier.EventIdentifierBuilder builder) {
			this.eventIdentifierSequence = ofNullable(builder.getEventIdentifierSequence()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifierSequence")
		public EventIdentifierSequence getEventIdentifierSequence() {
			return eventIdentifierSequence;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public EventIdentifier build() {
			return this;
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder toBuilder() {
			EventIdentifier.EventIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventIdentifier.EventIdentifierBuilder builder) {
			ofNullable(getEventIdentifierSequence()).ifPresent(builder::setEventIdentifierSequence);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifierSequence, _that.getEventIdentifierSequence())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifierSequence != null ? eventIdentifierSequence.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifier {" +
				"eventIdentifierSequence=" + this.eventIdentifierSequence + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of EventIdentifier  ***********************/
	class EventIdentifierBuilderImpl implements EventIdentifier.EventIdentifierBuilder {
	
		protected EventIdentifierSequence.EventIdentifierSequenceBuilder eventIdentifierSequence;
		protected TradeIdentifier.TradeIdentifierBuilder tradeIdentifier;
	
		public EventIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifierSequence")
		public EventIdentifierSequence.EventIdentifierSequenceBuilder getEventIdentifierSequence() {
			return eventIdentifierSequence;
		}
		
		@Override
		public EventIdentifierSequence.EventIdentifierSequenceBuilder getOrCreateEventIdentifierSequence() {
			EventIdentifierSequence.EventIdentifierSequenceBuilder result;
			if (eventIdentifierSequence!=null) {
				result = eventIdentifierSequence;
			}
			else {
				result = eventIdentifierSequence = EventIdentifierSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifierSequence")
		public EventIdentifier.EventIdentifierBuilder setEventIdentifierSequence(EventIdentifierSequence eventIdentifierSequence) {
			this.eventIdentifierSequence = eventIdentifierSequence==null?null:eventIdentifierSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifier")
		public EventIdentifier.EventIdentifierBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier) {
			this.tradeIdentifier = tradeIdentifier==null?null:tradeIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public EventIdentifier build() {
			return new EventIdentifier.EventIdentifierImpl(this);
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier.EventIdentifierBuilder prune() {
			if (eventIdentifierSequence!=null && !eventIdentifierSequence.prune().hasData()) eventIdentifierSequence = null;
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifierSequence()!=null && getEventIdentifierSequence().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier.EventIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventIdentifier.EventIdentifierBuilder o = (EventIdentifier.EventIdentifierBuilder) other;
			
			merger.mergeRosetta(getEventIdentifierSequence(), o.getEventIdentifierSequence(), this::setEventIdentifierSequence);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifierSequence, _that.getEventIdentifierSequence())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifierSequence != null ? eventIdentifierSequence.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifierBuilder {" +
				"eventIdentifierSequence=" + this.eventIdentifierSequence + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}
}
