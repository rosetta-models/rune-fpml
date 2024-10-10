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
import fpml.confirmation.ClearingResultsModelSequence;
import fpml.confirmation.ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder;
import fpml.confirmation.ClearingResultsModelSequence.ClearingResultsModelSequenceBuilderImpl;
import fpml.confirmation.ClearingResultsModelSequence.ClearingResultsModelSequenceImpl;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.meta.ClearingResultsModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingResultsModelSequence", builder=ClearingResultsModelSequence.ClearingResultsModelSequenceBuilderImpl.class, version="${project.version}")
public interface ClearingResultsModelSequence extends RosettaModelObject {

	ClearingResultsModelSequenceMeta metaData = new ClearingResultsModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This may be used to describe why a trade was terminated.
	 */
	TerminatingEvent getTerminatingEvent();
	TradeNotionalChange getTermination();

	/*********************** Build Methods  ***********************/
	ClearingResultsModelSequence build();
	
	ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder toBuilder();
	
	static ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder builder() {
		return new ClearingResultsModelSequence.ClearingResultsModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingResultsModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingResultsModelSequence> getType() {
		return ClearingResultsModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.class, getTerminatingEvent());
		processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.class, getTermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingResultsModelSequenceBuilder extends ClearingResultsModelSequence, RosettaModelObjectBuilder {
		TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent();
		TerminatingEvent.TerminatingEventBuilder getTerminatingEvent();
		TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateTermination();
		TradeNotionalChange.TradeNotionalChangeBuilder getTermination();
		ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder setTermination(TradeNotionalChange termination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.TerminatingEventBuilder.class, getTerminatingEvent());
			processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getTermination());
		}
		

		ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingResultsModelSequence  ***********************/
	class ClearingResultsModelSequenceImpl implements ClearingResultsModelSequence {
		private final TerminatingEvent terminatingEvent;
		private final TradeNotionalChange termination;
		
		protected ClearingResultsModelSequenceImpl(ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder builder) {
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
		public ClearingResultsModelSequence build() {
			return this;
		}
		
		@Override
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder toBuilder() {
			ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder builder) {
			ofNullable(getTerminatingEvent()).ifPresent(builder::setTerminatingEvent);
			ofNullable(getTermination()).ifPresent(builder::setTermination);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingResultsModelSequence _that = getType().cast(o);
		
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
			return "ClearingResultsModelSequence {" +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingResultsModelSequence  ***********************/
	class ClearingResultsModelSequenceBuilderImpl implements ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder {
	
		protected TerminatingEvent.TerminatingEventBuilder terminatingEvent;
		protected TradeNotionalChange.TradeNotionalChangeBuilder termination;
	
		public ClearingResultsModelSequenceBuilderImpl() {
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
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder setTerminatingEvent(TerminatingEvent terminatingEvent) {
			this.terminatingEvent = terminatingEvent==null?null:terminatingEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("termination")
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder setTermination(TradeNotionalChange termination) {
			this.termination = termination==null?null:termination.toBuilder();
			return this;
		}
		
		@Override
		public ClearingResultsModelSequence build() {
			return new ClearingResultsModelSequence.ClearingResultsModelSequenceImpl(this);
		}
		
		@Override
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder prune() {
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
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder o = (ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder) other;
			
			merger.mergeRosetta(getTerminatingEvent(), o.getTerminatingEvent(), this::setTerminatingEvent);
			merger.mergeRosetta(getTermination(), o.getTermination(), this::setTermination);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingResultsModelSequence _that = getType().cast(o);
		
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
			return "ClearingResultsModelSequenceBuilder {" +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination +
			'}';
		}
	}
}
