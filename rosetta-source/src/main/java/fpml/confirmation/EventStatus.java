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
import fpml.confirmation.EventStatus;
import fpml.confirmation.EventStatus.EventStatusBuilder;
import fpml.confirmation.EventStatus.EventStatusBuilderImpl;
import fpml.confirmation.EventStatus.EventStatusImpl;
import fpml.confirmation.meta.EventStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A coding scheme used to describe the matching/confirmation status of a trade, post-trade event, position, or cash flows.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventStatus", builder=EventStatus.EventStatusBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventStatus extends RosettaModelObject {

	EventStatusMeta metaData = new EventStatusMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getEventStatusScheme();

	/*********************** Build Methods  ***********************/
	EventStatus build();
	
	EventStatus.EventStatusBuilder toBuilder();
	
	static EventStatus.EventStatusBuilder builder() {
		return new EventStatus.EventStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventStatus> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventStatus> getType() {
		return EventStatus.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("eventStatusScheme"), String.class, getEventStatusScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventStatusBuilder extends EventStatus, RosettaModelObjectBuilder {
		EventStatus.EventStatusBuilder setValue(String value);
		EventStatus.EventStatusBuilder setEventStatusScheme(String eventStatusScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("eventStatusScheme"), String.class, getEventStatusScheme(), this);
		}
		

		EventStatus.EventStatusBuilder prune();
	}

	/*********************** Immutable Implementation of EventStatus  ***********************/
	class EventStatusImpl implements EventStatus {
		private final String value;
		private final String eventStatusScheme;
		
		protected EventStatusImpl(EventStatus.EventStatusBuilder builder) {
			this.value = builder.getValue();
			this.eventStatusScheme = builder.getEventStatusScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("eventStatusScheme")
		public String getEventStatusScheme() {
			return eventStatusScheme;
		}
		
		@Override
		public EventStatus build() {
			return this;
		}
		
		@Override
		public EventStatus.EventStatusBuilder toBuilder() {
			EventStatus.EventStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventStatus.EventStatusBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEventStatusScheme()).ifPresent(builder::setEventStatusScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventStatusScheme, _that.getEventStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventStatusScheme != null ? eventStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventStatus {" +
				"value=" + this.value + ", " +
				"eventStatusScheme=" + this.eventStatusScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EventStatus  ***********************/
	class EventStatusBuilderImpl implements EventStatus.EventStatusBuilder {
	
		protected String value;
		protected String eventStatusScheme;
	
		public EventStatusBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("eventStatusScheme")
		public String getEventStatusScheme() {
			return eventStatusScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public EventStatus.EventStatusBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("eventStatusScheme")
		public EventStatus.EventStatusBuilder setEventStatusScheme(String eventStatusScheme) {
			this.eventStatusScheme = eventStatusScheme==null?null:eventStatusScheme;
			return this;
		}
		
		@Override
		public EventStatus build() {
			return new EventStatus.EventStatusImpl(this);
		}
		
		@Override
		public EventStatus.EventStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventStatus.EventStatusBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEventStatusScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventStatus.EventStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventStatus.EventStatusBuilder o = (EventStatus.EventStatusBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEventStatusScheme(), o.getEventStatusScheme(), this::setEventStatusScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventStatusScheme, _that.getEventStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventStatusScheme != null ? eventStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventStatusBuilder {" +
				"value=" + this.value + ", " +
				"eventStatusScheme=" + this.eventStatusScheme +
			'}';
		}
	}
}
