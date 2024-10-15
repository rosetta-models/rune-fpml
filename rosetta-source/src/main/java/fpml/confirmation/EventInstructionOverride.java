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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.EventInstructionOverride;
import fpml.confirmation.EventInstructionOverride.EventInstructionOverrideBuilder;
import fpml.confirmation.EventInstructionOverride.EventInstructionOverrideBuilderImpl;
import fpml.confirmation.EventInstructionOverride.EventInstructionOverrideImpl;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.meta.EventInstructionOverrideMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that identifies a party profile record.
 * @version ${project.version}
 */
@RosettaDataType(value="EventInstructionOverride", builder=EventInstructionOverride.EventInstructionOverrideBuilderImpl.class, version="${project.version}")
public interface EventInstructionOverride extends RosettaModelObject {

	EventInstructionOverrideMeta metaData = new EventInstructionOverrideMeta();

	/*********************** Getter Methods  ***********************/
	OverrideIdentifier getOverrideIdentifier();
	/**
	 * The event for which the (currency-specific) settlement instructions should be applied.
	 */
	BusinessEventIdentifier getEventIdentifier();
	/**
	 * Settlement account details to describe the acount to which cash should be sent, for payments received by the party sending the Lender Event Settlement Notification.
	 */
	List<? extends SettlementDetails> getSettlementDetails();

	/*********************** Build Methods  ***********************/
	EventInstructionOverride build();
	
	EventInstructionOverride.EventInstructionOverrideBuilder toBuilder();
	
	static EventInstructionOverride.EventInstructionOverrideBuilder builder() {
		return new EventInstructionOverride.EventInstructionOverrideBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventInstructionOverride> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventInstructionOverride> getType() {
		return EventInstructionOverride.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("overrideIdentifier"), processor, OverrideIdentifier.class, getOverrideIdentifier());
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.class, getSettlementDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventInstructionOverrideBuilder extends EventInstructionOverride, RosettaModelObjectBuilder {
		OverrideIdentifier.OverrideIdentifierBuilder getOrCreateOverrideIdentifier();
		OverrideIdentifier.OverrideIdentifierBuilder getOverrideIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		SettlementDetails.SettlementDetailsBuilder getOrCreateSettlementDetails(int _index);
		List<? extends SettlementDetails.SettlementDetailsBuilder> getSettlementDetails();
		EventInstructionOverride.EventInstructionOverrideBuilder setOverrideIdentifier(OverrideIdentifier overrideIdentifier);
		EventInstructionOverride.EventInstructionOverrideBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);
		EventInstructionOverride.EventInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails0);
		EventInstructionOverride.EventInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails1, int _idx);
		EventInstructionOverride.EventInstructionOverrideBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetails2);
		EventInstructionOverride.EventInstructionOverrideBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetails3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("overrideIdentifier"), processor, OverrideIdentifier.OverrideIdentifierBuilder.class, getOverrideIdentifier());
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.SettlementDetailsBuilder.class, getSettlementDetails());
		}
		

		EventInstructionOverride.EventInstructionOverrideBuilder prune();
	}

	/*********************** Immutable Implementation of EventInstructionOverride  ***********************/
	class EventInstructionOverrideImpl implements EventInstructionOverride {
		private final OverrideIdentifier overrideIdentifier;
		private final BusinessEventIdentifier eventIdentifier;
		private final List<? extends SettlementDetails> settlementDetails;
		
		protected EventInstructionOverrideImpl(EventInstructionOverride.EventInstructionOverrideBuilder builder) {
			this.overrideIdentifier = ofNullable(builder.getOverrideIdentifier()).map(f->f.build()).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.settlementDetails = ofNullable(builder.getSettlementDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("overrideIdentifier")
		public OverrideIdentifier getOverrideIdentifier() {
			return overrideIdentifier;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public BusinessEventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("settlementDetails")
		public List<? extends SettlementDetails> getSettlementDetails() {
			return settlementDetails;
		}
		
		@Override
		public EventInstructionOverride build() {
			return this;
		}
		
		@Override
		public EventInstructionOverride.EventInstructionOverrideBuilder toBuilder() {
			EventInstructionOverride.EventInstructionOverrideBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventInstructionOverride.EventInstructionOverrideBuilder builder) {
			ofNullable(getOverrideIdentifier()).ifPresent(builder::setOverrideIdentifier);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getSettlementDetails()).ifPresent(builder::setSettlementDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventInstructionOverride _that = getType().cast(o);
		
			if (!Objects.equals(overrideIdentifier, _that.getOverrideIdentifier())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (overrideIdentifier != null ? overrideIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventInstructionOverride {" +
				"overrideIdentifier=" + this.overrideIdentifier + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"settlementDetails=" + this.settlementDetails +
			'}';
		}
	}

	/*********************** Builder Implementation of EventInstructionOverride  ***********************/
	class EventInstructionOverrideBuilderImpl implements EventInstructionOverride.EventInstructionOverrideBuilder {
	
		protected OverrideIdentifier.OverrideIdentifierBuilder overrideIdentifier;
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		protected List<SettlementDetails.SettlementDetailsBuilder> settlementDetails = new ArrayList<>();
	
		public EventInstructionOverrideBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("overrideIdentifier")
		public OverrideIdentifier.OverrideIdentifierBuilder getOverrideIdentifier() {
			return overrideIdentifier;
		}
		
		@Override
		public OverrideIdentifier.OverrideIdentifierBuilder getOrCreateOverrideIdentifier() {
			OverrideIdentifier.OverrideIdentifierBuilder result;
			if (overrideIdentifier!=null) {
				result = overrideIdentifier;
			}
			else {
				result = overrideIdentifier = OverrideIdentifier.builder();
			}
			
			return result;
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
		@RosettaAttribute("settlementDetails")
		public List<? extends SettlementDetails.SettlementDetailsBuilder> getSettlementDetails() {
			return settlementDetails;
		}
		
		public SettlementDetails.SettlementDetailsBuilder getOrCreateSettlementDetails(int _index) {
		
			if (settlementDetails==null) {
				this.settlementDetails = new ArrayList<>();
			}
			SettlementDetails.SettlementDetailsBuilder result;
			return getIndex(settlementDetails, _index, () -> {
						SettlementDetails.SettlementDetailsBuilder newSettlementDetails = SettlementDetails.builder();
						return newSettlementDetails;
					});
		}
		
		@Override
		@RosettaAttribute("overrideIdentifier")
		public EventInstructionOverride.EventInstructionOverrideBuilder setOverrideIdentifier(OverrideIdentifier overrideIdentifier) {
			this.overrideIdentifier = overrideIdentifier==null?null:overrideIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventIdentifier")
		public EventInstructionOverride.EventInstructionOverrideBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			this.eventIdentifier = eventIdentifier==null?null:eventIdentifier.toBuilder();
			return this;
		}
		@Override
		public EventInstructionOverride.EventInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails) {
			if (settlementDetails!=null) this.settlementDetails.add(settlementDetails.toBuilder());
			return this;
		}
		
		@Override
		public EventInstructionOverride.EventInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails, int _idx) {
			getIndex(this.settlementDetails, _idx, () -> settlementDetails.toBuilder());
			return this;
		}
		@Override 
		public EventInstructionOverride.EventInstructionOverrideBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
			if (settlementDetailss != null) {
				for (SettlementDetails toAdd : settlementDetailss) {
					this.settlementDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementDetails")
		public EventInstructionOverride.EventInstructionOverrideBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
			if (settlementDetailss == null)  {
				this.settlementDetails = new ArrayList<>();
			}
			else {
				this.settlementDetails = settlementDetailss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public EventInstructionOverride build() {
			return new EventInstructionOverride.EventInstructionOverrideImpl(this);
		}
		
		@Override
		public EventInstructionOverride.EventInstructionOverrideBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventInstructionOverride.EventInstructionOverrideBuilder prune() {
			if (overrideIdentifier!=null && !overrideIdentifier.prune().hasData()) overrideIdentifier = null;
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			settlementDetails = settlementDetails.stream().filter(b->b!=null).<SettlementDetails.SettlementDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOverrideIdentifier()!=null && getOverrideIdentifier().hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getSettlementDetails()!=null && getSettlementDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventInstructionOverride.EventInstructionOverrideBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventInstructionOverride.EventInstructionOverrideBuilder o = (EventInstructionOverride.EventInstructionOverrideBuilder) other;
			
			merger.mergeRosetta(getOverrideIdentifier(), o.getOverrideIdentifier(), this::setOverrideIdentifier);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getSettlementDetails(), o.getSettlementDetails(), this::getOrCreateSettlementDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventInstructionOverride _that = getType().cast(o);
		
			if (!Objects.equals(overrideIdentifier, _that.getOverrideIdentifier())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (overrideIdentifier != null ? overrideIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventInstructionOverrideBuilder {" +
				"overrideIdentifier=" + this.overrideIdentifier + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"settlementDetails=" + this.settlementDetails +
			'}';
		}
	}
}
