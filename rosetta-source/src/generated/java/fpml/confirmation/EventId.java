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
import fpml.confirmation.EventId;
import fpml.confirmation.EventId.EventIdBuilder;
import fpml.confirmation.EventId.EventIdBuilderImpl;
import fpml.confirmation.EventId.EventIdImpl;
import fpml.confirmation.meta.EventIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A post-trade event reference identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 * @version ${project.version}
 */
@RosettaDataType(value="EventId", builder=EventId.EventIdBuilderImpl.class, version="${project.version}")
public interface EventId extends RosettaModelObject {

	EventIdMeta metaData = new EventIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getEventIdScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	EventId build();
	
	EventId.EventIdBuilder toBuilder();
	
	static EventId.EventIdBuilder builder() {
		return new EventId.EventIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventId> getType() {
		return EventId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("eventIdScheme"), String.class, getEventIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventIdBuilder extends EventId, RosettaModelObjectBuilder {
		EventId.EventIdBuilder setValue(String value);
		EventId.EventIdBuilder setEventIdScheme(String eventIdScheme);
		EventId.EventIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("eventIdScheme"), String.class, getEventIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		EventId.EventIdBuilder prune();
	}

	/*********************** Immutable Implementation of EventId  ***********************/
	class EventIdImpl implements EventId {
		private final String value;
		private final String eventIdScheme;
		private final String id;
		
		protected EventIdImpl(EventId.EventIdBuilder builder) {
			this.value = builder.getValue();
			this.eventIdScheme = builder.getEventIdScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("eventIdScheme")
		public String getEventIdScheme() {
			return eventIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public EventId build() {
			return this;
		}
		
		@Override
		public EventId.EventIdBuilder toBuilder() {
			EventId.EventIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventId.EventIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEventIdScheme()).ifPresent(builder::setEventIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventIdScheme, _that.getEventIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventIdScheme != null ? eventIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventId {" +
				"value=" + this.value + ", " +
				"eventIdScheme=" + this.eventIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of EventId  ***********************/
	class EventIdBuilderImpl implements EventId.EventIdBuilder {
	
		protected String value;
		protected String eventIdScheme;
		protected String id;
	
		public EventIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("eventIdScheme")
		public String getEventIdScheme() {
			return eventIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public EventId.EventIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("eventIdScheme")
		public EventId.EventIdBuilder setEventIdScheme(String eventIdScheme) {
			this.eventIdScheme = eventIdScheme==null?null:eventIdScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EventId.EventIdBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public EventId build() {
			return new EventId.EventIdImpl(this);
		}
		
		@Override
		public EventId.EventIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventId.EventIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEventIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventId.EventIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventId.EventIdBuilder o = (EventId.EventIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEventIdScheme(), o.getEventIdScheme(), this::setEventIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(eventIdScheme, _that.getEventIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (eventIdScheme != null ? eventIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdBuilder {" +
				"value=" + this.value + ", " +
				"eventIdScheme=" + this.eventIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
