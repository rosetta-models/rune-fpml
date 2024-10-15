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
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.AbstractEvent.AbstractEventBuilder;
import fpml.confirmation.AbstractEvent.AbstractEventBuilderImpl;
import fpml.confirmation.AbstractEvent.AbstractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.meta.AbstractEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Abstract base type for all events.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractEvent", builder=AbstractEvent.AbstractEventBuilderImpl.class, version="${project.version}")
public interface AbstractEvent extends RosettaModelObject {

	AbstractEventMeta metaData = new AbstractEventMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends BusinessEventIdentifier> getEventIdentifier();

	/*********************** Build Methods  ***********************/
	AbstractEvent build();
	
	AbstractEvent.AbstractEventBuilder toBuilder();
	
	static AbstractEvent.AbstractEventBuilder builder() {
		return new AbstractEvent.AbstractEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractEvent> getType() {
		return AbstractEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractEventBuilder extends AbstractEvent, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int _index);
		List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier();
		AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractEvent.AbstractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractEvent.AbstractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		AbstractEvent.AbstractEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractEvent  ***********************/
	class AbstractEventImpl implements AbstractEvent {
		private final List<? extends BusinessEventIdentifier> eventIdentifier;
		
		protected AbstractEventImpl(AbstractEvent.AbstractEventBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public AbstractEvent build() {
			return this;
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder toBuilder() {
			AbstractEvent.AbstractEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractEvent.AbstractEventBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
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
			return "AbstractEvent {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractEvent  ***********************/
	class AbstractEventBuilderImpl implements AbstractEvent.AbstractEventBuilder {
	
		protected List<BusinessEventIdentifier.BusinessEventIdentifierBuilder> eventIdentifier = new ArrayList<>();
	
		public AbstractEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int _index) {
		
			if (eventIdentifier==null) {
				this.eventIdentifier = new ArrayList<>();
			}
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			return getIndex(eventIdentifier, _index, () -> {
						BusinessEventIdentifier.BusinessEventIdentifierBuilder newEventIdentifier = BusinessEventIdentifier.builder();
						return newEventIdentifier;
					});
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractEvent.AbstractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AbstractEvent.AbstractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractEvent build() {
			return new AbstractEvent.AbstractEventImpl(this);
		}
		
		@Override
		public AbstractEvent.AbstractEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractEvent.AbstractEventBuilder prune() {
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<BusinessEventIdentifier.BusinessEventIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractEvent.AbstractEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractEvent.AbstractEventBuilder o = (AbstractEvent.AbstractEventBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
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
			return "AbstractEventBuilder {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}
}
