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
import fpml.confirmation.AbstractEventRequireId;
import fpml.confirmation.AbstractEventRequireId.AbstractEventRequireIdBuilder;
import fpml.confirmation.AbstractEventRequireId.AbstractEventRequireIdBuilderImpl;
import fpml.confirmation.AbstractEventRequireId.AbstractEventRequireIdImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.meta.AbstractEventRequireIdMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type for all loan business events.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AbstractEventRequireId", builder=AbstractEventRequireId.AbstractEventRequireIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AbstractEventRequireId extends RosettaModelObject {

	AbstractEventRequireIdMeta metaData = new AbstractEventRequireIdMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends BusinessEventIdentifier> getEventIdentifier();

	/*********************** Build Methods  ***********************/
	AbstractEventRequireId build();
	
	AbstractEventRequireId.AbstractEventRequireIdBuilder toBuilder();
	
	static AbstractEventRequireId.AbstractEventRequireIdBuilder builder() {
		return new AbstractEventRequireId.AbstractEventRequireIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractEventRequireId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractEventRequireId> getType() {
		return AbstractEventRequireId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractEventRequireIdBuilder extends AbstractEventRequireId, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int _index);
		List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier();
		AbstractEventRequireId.AbstractEventRequireIdBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractEventRequireId.AbstractEventRequireIdBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractEventRequireId.AbstractEventRequireIdBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractEventRequireId.AbstractEventRequireIdBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		AbstractEventRequireId.AbstractEventRequireIdBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractEventRequireId  ***********************/
	class AbstractEventRequireIdImpl implements AbstractEventRequireId {
		private final List<? extends BusinessEventIdentifier> eventIdentifier;
		
		protected AbstractEventRequireIdImpl(AbstractEventRequireId.AbstractEventRequireIdBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public AbstractEventRequireId build() {
			return this;
		}
		
		@Override
		public AbstractEventRequireId.AbstractEventRequireIdBuilder toBuilder() {
			AbstractEventRequireId.AbstractEventRequireIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractEventRequireId.AbstractEventRequireIdBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractEventRequireId _that = getType().cast(o);
		
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
			return "AbstractEventRequireId {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractEventRequireId  ***********************/
	class AbstractEventRequireIdBuilderImpl implements AbstractEventRequireId.AbstractEventRequireIdBuilder {
	
		protected List<BusinessEventIdentifier.BusinessEventIdentifierBuilder> eventIdentifier = new ArrayList<>();
	
		public AbstractEventRequireIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
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
		@RosettaAttribute("eventIdentifier")
		public AbstractEventRequireId.AbstractEventRequireIdBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractEventRequireId.AbstractEventRequireIdBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractEventRequireId.AbstractEventRequireIdBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractEventRequireId.AbstractEventRequireIdBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractEventRequireId build() {
			return new AbstractEventRequireId.AbstractEventRequireIdImpl(this);
		}
		
		@Override
		public AbstractEventRequireId.AbstractEventRequireIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractEventRequireId.AbstractEventRequireIdBuilder prune() {
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
		public AbstractEventRequireId.AbstractEventRequireIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractEventRequireId.AbstractEventRequireIdBuilder o = (AbstractEventRequireId.AbstractEventRequireIdBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractEventRequireId _that = getType().cast(o);
		
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
			return "AbstractEventRequireIdBuilder {" +
				"eventIdentifier=" + this.eventIdentifier +
			'}';
		}
	}
}
