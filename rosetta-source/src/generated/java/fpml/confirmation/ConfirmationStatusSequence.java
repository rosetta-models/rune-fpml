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
import fpml.confirmation.ConfirmationStatusSequence;
import fpml.confirmation.ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder;
import fpml.confirmation.ConfirmationStatusSequence.ConfirmationStatusSequenceBuilderImpl;
import fpml.confirmation.ConfirmationStatusSequence.ConfirmationStatusSequenceImpl;
import fpml.confirmation.EventProposedMatch;
import fpml.confirmation.EventsChoice;
import fpml.confirmation.meta.ConfirmationStatusSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ConfirmationStatusSequence", builder=ConfirmationStatusSequence.ConfirmationStatusSequenceBuilderImpl.class, version="${project.version}")
public interface ConfirmationStatusSequence extends RosettaModelObject {

	ConfirmationStatusSequenceMeta metaData = new ConfirmationStatusSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Event (trade or post-trade event) asserted by one of the parties.
	 */
	EventsChoice getAssertedEvent();
	/**
	 * &quot;Other side&#39;s&quot; event (trade or post-trade event) that meets the minimimum matching criteria and is proposed as match to the event that is being asserted.
	 */
	List<? extends EventProposedMatch> getProposedMatch();

	/*********************** Build Methods  ***********************/
	ConfirmationStatusSequence build();
	
	ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder toBuilder();
	
	static ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder builder() {
		return new ConfirmationStatusSequence.ConfirmationStatusSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationStatusSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConfirmationStatusSequence> getType() {
		return ConfirmationStatusSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("assertedEvent"), processor, EventsChoice.class, getAssertedEvent());
		processRosetta(path.newSubPath("proposedMatch"), processor, EventProposedMatch.class, getProposedMatch());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConfirmationStatusSequenceBuilder extends ConfirmationStatusSequence, RosettaModelObjectBuilder {
		EventsChoice.EventsChoiceBuilder getOrCreateAssertedEvent();
		EventsChoice.EventsChoiceBuilder getAssertedEvent();
		EventProposedMatch.EventProposedMatchBuilder getOrCreateProposedMatch(int _index);
		List<? extends EventProposedMatch.EventProposedMatchBuilder> getProposedMatch();
		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder setAssertedEvent(EventsChoice assertedEvent);
		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder addProposedMatch(EventProposedMatch proposedMatch0);
		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder addProposedMatch(EventProposedMatch proposedMatch1, int _idx);
		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder addProposedMatch(List<? extends EventProposedMatch> proposedMatch2);
		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder setProposedMatch(List<? extends EventProposedMatch> proposedMatch3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("assertedEvent"), processor, EventsChoice.EventsChoiceBuilder.class, getAssertedEvent());
			processRosetta(path.newSubPath("proposedMatch"), processor, EventProposedMatch.EventProposedMatchBuilder.class, getProposedMatch());
		}
		

		ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationStatusSequence  ***********************/
	class ConfirmationStatusSequenceImpl implements ConfirmationStatusSequence {
		private final EventsChoice assertedEvent;
		private final List<? extends EventProposedMatch> proposedMatch;
		
		protected ConfirmationStatusSequenceImpl(ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder builder) {
			this.assertedEvent = ofNullable(builder.getAssertedEvent()).map(f->f.build()).orElse(null);
			this.proposedMatch = ofNullable(builder.getProposedMatch()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("assertedEvent")
		public EventsChoice getAssertedEvent() {
			return assertedEvent;
		}
		
		@Override
		@RosettaAttribute("proposedMatch")
		public List<? extends EventProposedMatch> getProposedMatch() {
			return proposedMatch;
		}
		
		@Override
		public ConfirmationStatusSequence build() {
			return this;
		}
		
		@Override
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder toBuilder() {
			ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder builder) {
			ofNullable(getAssertedEvent()).ifPresent(builder::setAssertedEvent);
			ofNullable(getProposedMatch()).ifPresent(builder::setProposedMatch);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConfirmationStatusSequence _that = getType().cast(o);
		
			if (!Objects.equals(assertedEvent, _that.getAssertedEvent())) return false;
			if (!ListEquals.listEquals(proposedMatch, _that.getProposedMatch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assertedEvent != null ? assertedEvent.hashCode() : 0);
			_result = 31 * _result + (proposedMatch != null ? proposedMatch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationStatusSequence {" +
				"assertedEvent=" + this.assertedEvent + ", " +
				"proposedMatch=" + this.proposedMatch +
			'}';
		}
	}

	/*********************** Builder Implementation of ConfirmationStatusSequence  ***********************/
	class ConfirmationStatusSequenceBuilderImpl implements ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder {
	
		protected EventsChoice.EventsChoiceBuilder assertedEvent;
		protected List<EventProposedMatch.EventProposedMatchBuilder> proposedMatch = new ArrayList<>();
	
		public ConfirmationStatusSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("assertedEvent")
		public EventsChoice.EventsChoiceBuilder getAssertedEvent() {
			return assertedEvent;
		}
		
		@Override
		public EventsChoice.EventsChoiceBuilder getOrCreateAssertedEvent() {
			EventsChoice.EventsChoiceBuilder result;
			if (assertedEvent!=null) {
				result = assertedEvent;
			}
			else {
				result = assertedEvent = EventsChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("proposedMatch")
		public List<? extends EventProposedMatch.EventProposedMatchBuilder> getProposedMatch() {
			return proposedMatch;
		}
		
		public EventProposedMatch.EventProposedMatchBuilder getOrCreateProposedMatch(int _index) {
		
			if (proposedMatch==null) {
				this.proposedMatch = new ArrayList<>();
			}
			EventProposedMatch.EventProposedMatchBuilder result;
			return getIndex(proposedMatch, _index, () -> {
						EventProposedMatch.EventProposedMatchBuilder newProposedMatch = EventProposedMatch.builder();
						return newProposedMatch;
					});
		}
		
		@Override
		@RosettaAttribute("assertedEvent")
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder setAssertedEvent(EventsChoice assertedEvent) {
			this.assertedEvent = assertedEvent==null?null:assertedEvent.toBuilder();
			return this;
		}
		@Override
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder addProposedMatch(EventProposedMatch proposedMatch) {
			if (proposedMatch!=null) this.proposedMatch.add(proposedMatch.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder addProposedMatch(EventProposedMatch proposedMatch, int _idx) {
			getIndex(this.proposedMatch, _idx, () -> proposedMatch.toBuilder());
			return this;
		}
		@Override 
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder addProposedMatch(List<? extends EventProposedMatch> proposedMatchs) {
			if (proposedMatchs != null) {
				for (EventProposedMatch toAdd : proposedMatchs) {
					this.proposedMatch.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("proposedMatch")
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder setProposedMatch(List<? extends EventProposedMatch> proposedMatchs) {
			if (proposedMatchs == null)  {
				this.proposedMatch = new ArrayList<>();
			}
			else {
				this.proposedMatch = proposedMatchs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ConfirmationStatusSequence build() {
			return new ConfirmationStatusSequence.ConfirmationStatusSequenceImpl(this);
		}
		
		@Override
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder prune() {
			if (assertedEvent!=null && !assertedEvent.prune().hasData()) assertedEvent = null;
			proposedMatch = proposedMatch.stream().filter(b->b!=null).<EventProposedMatch.EventProposedMatchBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssertedEvent()!=null && getAssertedEvent().hasData()) return true;
			if (getProposedMatch()!=null && getProposedMatch().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder o = (ConfirmationStatusSequence.ConfirmationStatusSequenceBuilder) other;
			
			merger.mergeRosetta(getAssertedEvent(), o.getAssertedEvent(), this::setAssertedEvent);
			merger.mergeRosetta(getProposedMatch(), o.getProposedMatch(), this::getOrCreateProposedMatch);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConfirmationStatusSequence _that = getType().cast(o);
		
			if (!Objects.equals(assertedEvent, _that.getAssertedEvent())) return false;
			if (!ListEquals.listEquals(proposedMatch, _that.getProposedMatch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assertedEvent != null ? assertedEvent.hashCode() : 0);
			_result = 31 * _result + (proposedMatch != null ? proposedMatch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationStatusSequenceBuilder {" +
				"assertedEvent=" + this.assertedEvent + ", " +
				"proposedMatch=" + this.proposedMatch +
			'}';
		}
	}
}
