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
import fpml.confirmation.PostTradeEventsBaseModelSequence;
import fpml.confirmation.PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder;
import fpml.confirmation.PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilderImpl;
import fpml.confirmation.PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceImpl;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.meta.PostTradeEventsBaseModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PostTradeEventsBaseModelSequence", builder=PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PostTradeEventsBaseModelSequence extends RosettaModelObject {

	PostTradeEventsBaseModelSequenceMeta metaData = new PostTradeEventsBaseModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This may be used to describe why a trade was terminated.
	 */
	TerminatingEvent getTerminatingEvent();
	TradeNotionalChange getTermination();

	/*********************** Build Methods  ***********************/
	PostTradeEventsBaseModelSequence build();
	
	PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder toBuilder();
	
	static PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder builder() {
		return new PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostTradeEventsBaseModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PostTradeEventsBaseModelSequence> getType() {
		return PostTradeEventsBaseModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.class, getTerminatingEvent());
		processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.class, getTermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostTradeEventsBaseModelSequenceBuilder extends PostTradeEventsBaseModelSequence, RosettaModelObjectBuilder {
		TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent();
		TerminatingEvent.TerminatingEventBuilder getTerminatingEvent();
		TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateTermination();
		TradeNotionalChange.TradeNotionalChangeBuilder getTermination();
		PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder setTermination(TradeNotionalChange termination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.TerminatingEventBuilder.class, getTerminatingEvent());
			processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getTermination());
		}
		

		PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of PostTradeEventsBaseModelSequence  ***********************/
	class PostTradeEventsBaseModelSequenceImpl implements PostTradeEventsBaseModelSequence {
		private final TerminatingEvent terminatingEvent;
		private final TradeNotionalChange termination;
		
		protected PostTradeEventsBaseModelSequenceImpl(PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder builder) {
			this.terminatingEvent = ofNullable(builder.getTerminatingEvent()).map(f->f.build()).orElse(null);
			this.termination = ofNullable(builder.getTermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		public TerminatingEvent getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		@RosettaAttribute("termination")
		public TradeNotionalChange getTermination() {
			return termination;
		}
		
		@Override
		public PostTradeEventsBaseModelSequence build() {
			return this;
		}
		
		@Override
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder toBuilder() {
			PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder builder) {
			ofNullable(getTerminatingEvent()).ifPresent(builder::setTerminatingEvent);
			ofNullable(getTermination()).ifPresent(builder::setTermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostTradeEventsBaseModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostTradeEventsBaseModelSequence {" +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination +
			'}';
		}
	}

	/*********************** Builder Implementation of PostTradeEventsBaseModelSequence  ***********************/
	class PostTradeEventsBaseModelSequenceBuilderImpl implements PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder {
	
		protected TerminatingEvent.TerminatingEventBuilder terminatingEvent;
		protected TradeNotionalChange.TradeNotionalChangeBuilder termination;
	
		public PostTradeEventsBaseModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("terminatingEvent")
		public TerminatingEvent.TerminatingEventBuilder getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent() {
			TerminatingEvent.TerminatingEventBuilder result;
			if (terminatingEvent!=null) {
				result = terminatingEvent;
			}
			else {
				result = terminatingEvent = TerminatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termination")
		public TradeNotionalChange.TradeNotionalChangeBuilder getTermination() {
			return termination;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateTermination() {
			TradeNotionalChange.TradeNotionalChangeBuilder result;
			if (termination!=null) {
				result = termination;
			}
			else {
				result = termination = TradeNotionalChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder setTerminatingEvent(TerminatingEvent terminatingEvent) {
			this.terminatingEvent = terminatingEvent==null?null:terminatingEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("termination")
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder setTermination(TradeNotionalChange termination) {
			this.termination = termination==null?null:termination.toBuilder();
			return this;
		}
		
		@Override
		public PostTradeEventsBaseModelSequence build() {
			return new PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceImpl(this);
		}
		
		@Override
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder prune() {
			if (terminatingEvent!=null && !terminatingEvent.prune().hasData()) terminatingEvent = null;
			if (termination!=null && !termination.prune().hasData()) termination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTerminatingEvent()!=null && getTerminatingEvent().hasData()) return true;
			if (getTermination()!=null && getTermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder o = (PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder) other;
			
			merger.mergeRosetta(getTerminatingEvent(), o.getTerminatingEvent(), this::setTerminatingEvent);
			merger.mergeRosetta(getTermination(), o.getTermination(), this::setTermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostTradeEventsBaseModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostTradeEventsBaseModelSequenceBuilder {" +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination +
			'}';
		}
	}
}
