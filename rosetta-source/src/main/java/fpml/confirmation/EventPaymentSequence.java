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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.EventPaymentSequence;
import fpml.confirmation.EventPaymentSequence.EventPaymentSequenceBuilder;
import fpml.confirmation.EventPaymentSequence.EventPaymentSequenceBuilderImpl;
import fpml.confirmation.EventPaymentSequence.EventPaymentSequenceImpl;
import fpml.confirmation.meta.EventPaymentSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventPaymentSequence", builder=EventPaymentSequence.EventPaymentSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventPaymentSequence extends RosettaModelObject {

	EventPaymentSequenceMeta metaData = new EventPaymentSequenceMeta();

	/*********************** Getter Methods  ***********************/
	BusinessEventIdentifier getEventIdentifier();

	/*********************** Build Methods  ***********************/
	EventPaymentSequence build();
	
	EventPaymentSequence.EventPaymentSequenceBuilder toBuilder();
	
	static EventPaymentSequence.EventPaymentSequenceBuilder builder() {
		return new EventPaymentSequence.EventPaymentSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventPaymentSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventPaymentSequence> getType() {
		return EventPaymentSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventPaymentSequenceBuilder extends EventPaymentSequence, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		EventPaymentSequence.EventPaymentSequenceBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		EventPaymentSequence.EventPaymentSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of EventPaymentSequence  ***********************/
	class EventPaymentSequenceImpl implements EventPaymentSequence {
		private final BusinessEventIdentifier eventIdentifier;
		
		protected EventPaymentSequenceImpl(EventPaymentSequence.EventPaymentSequenceBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public BusinessEventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public EventPaymentSequence build() {
			return this;
		}
		
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder toBuilder() {
			EventPaymentSequence.EventPaymentSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventPaymentSequence.EventPaymentSequenceBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventPaymentSequence _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPaymentSequence {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of EventPaymentSequence  ***********************/
	class EventPaymentSequenceBuilderImpl implements EventPaymentSequence.EventPaymentSequenceBuilder {
	
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
	
		public EventPaymentSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public EventPaymentSequence.EventPaymentSequenceBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			this.eventIdentifier = eventIdentifier==null?null:eventIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public EventPaymentSequence build() {
			return new EventPaymentSequence.EventPaymentSequenceImpl(this);
		}
		
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder prune() {
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventPaymentSequence.EventPaymentSequenceBuilder o = (EventPaymentSequence.EventPaymentSequenceBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventPaymentSequence _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPaymentSequenceBuilder {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}
}
