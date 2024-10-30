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
import fpml.confirmation.CorrelationIdModel;
import fpml.confirmation.EventIdentifierSequence;
import fpml.confirmation.EventIdentifierSequence.EventIdentifierSequenceBuilder;
import fpml.confirmation.EventIdentifierSequence.EventIdentifierSequenceBuilderImpl;
import fpml.confirmation.EventIdentifierSequence.EventIdentifierSequenceImpl;
import fpml.confirmation.SequenceModel;
import fpml.confirmation.meta.EventIdentifierSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventIdentifierSequence", builder=EventIdentifierSequence.EventIdentifierSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventIdentifierSequence extends RosettaModelObject {

	EventIdentifierSequenceMeta metaData = new EventIdentifierSequenceMeta();

	/*********************** Getter Methods  ***********************/
	CorrelationIdModel getCorrelationIdModel();
	SequenceModel getSequenceModel();

	/*********************** Build Methods  ***********************/
	EventIdentifierSequence build();
	
	EventIdentifierSequence.EventIdentifierSequenceBuilder toBuilder();
	
	static EventIdentifierSequence.EventIdentifierSequenceBuilder builder() {
		return new EventIdentifierSequence.EventIdentifierSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventIdentifierSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventIdentifierSequence> getType() {
		return EventIdentifierSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("correlationIdModel"), processor, CorrelationIdModel.class, getCorrelationIdModel());
		processRosetta(path.newSubPath("sequenceModel"), processor, SequenceModel.class, getSequenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventIdentifierSequenceBuilder extends EventIdentifierSequence, RosettaModelObjectBuilder {
		CorrelationIdModel.CorrelationIdModelBuilder getOrCreateCorrelationIdModel();
		CorrelationIdModel.CorrelationIdModelBuilder getCorrelationIdModel();
		SequenceModel.SequenceModelBuilder getOrCreateSequenceModel();
		SequenceModel.SequenceModelBuilder getSequenceModel();
		EventIdentifierSequence.EventIdentifierSequenceBuilder setCorrelationIdModel(CorrelationIdModel correlationIdModel);
		EventIdentifierSequence.EventIdentifierSequenceBuilder setSequenceModel(SequenceModel sequenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("correlationIdModel"), processor, CorrelationIdModel.CorrelationIdModelBuilder.class, getCorrelationIdModel());
			processRosetta(path.newSubPath("sequenceModel"), processor, SequenceModel.SequenceModelBuilder.class, getSequenceModel());
		}
		

		EventIdentifierSequence.EventIdentifierSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of EventIdentifierSequence  ***********************/
	class EventIdentifierSequenceImpl implements EventIdentifierSequence {
		private final CorrelationIdModel correlationIdModel;
		private final SequenceModel sequenceModel;
		
		protected EventIdentifierSequenceImpl(EventIdentifierSequence.EventIdentifierSequenceBuilder builder) {
			this.correlationIdModel = ofNullable(builder.getCorrelationIdModel()).map(f->f.build()).orElse(null);
			this.sequenceModel = ofNullable(builder.getSequenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlationIdModel")
		public CorrelationIdModel getCorrelationIdModel() {
			return correlationIdModel;
		}
		
		@Override
		@RosettaAttribute("sequenceModel")
		public SequenceModel getSequenceModel() {
			return sequenceModel;
		}
		
		@Override
		public EventIdentifierSequence build() {
			return this;
		}
		
		@Override
		public EventIdentifierSequence.EventIdentifierSequenceBuilder toBuilder() {
			EventIdentifierSequence.EventIdentifierSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventIdentifierSequence.EventIdentifierSequenceBuilder builder) {
			ofNullable(getCorrelationIdModel()).ifPresent(builder::setCorrelationIdModel);
			ofNullable(getSequenceModel()).ifPresent(builder::setSequenceModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifierSequence _that = getType().cast(o);
		
			if (!Objects.equals(correlationIdModel, _that.getCorrelationIdModel())) return false;
			if (!Objects.equals(sequenceModel, _that.getSequenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationIdModel != null ? correlationIdModel.hashCode() : 0);
			_result = 31 * _result + (sequenceModel != null ? sequenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifierSequence {" +
				"correlationIdModel=" + this.correlationIdModel + ", " +
				"sequenceModel=" + this.sequenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of EventIdentifierSequence  ***********************/
	class EventIdentifierSequenceBuilderImpl implements EventIdentifierSequence.EventIdentifierSequenceBuilder {
	
		protected CorrelationIdModel.CorrelationIdModelBuilder correlationIdModel;
		protected SequenceModel.SequenceModelBuilder sequenceModel;
	
		public EventIdentifierSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("correlationIdModel")
		public CorrelationIdModel.CorrelationIdModelBuilder getCorrelationIdModel() {
			return correlationIdModel;
		}
		
		@Override
		public CorrelationIdModel.CorrelationIdModelBuilder getOrCreateCorrelationIdModel() {
			CorrelationIdModel.CorrelationIdModelBuilder result;
			if (correlationIdModel!=null) {
				result = correlationIdModel;
			}
			else {
				result = correlationIdModel = CorrelationIdModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sequenceModel")
		public SequenceModel.SequenceModelBuilder getSequenceModel() {
			return sequenceModel;
		}
		
		@Override
		public SequenceModel.SequenceModelBuilder getOrCreateSequenceModel() {
			SequenceModel.SequenceModelBuilder result;
			if (sequenceModel!=null) {
				result = sequenceModel;
			}
			else {
				result = sequenceModel = SequenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationIdModel")
		public EventIdentifierSequence.EventIdentifierSequenceBuilder setCorrelationIdModel(CorrelationIdModel correlationIdModel) {
			this.correlationIdModel = correlationIdModel==null?null:correlationIdModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sequenceModel")
		public EventIdentifierSequence.EventIdentifierSequenceBuilder setSequenceModel(SequenceModel sequenceModel) {
			this.sequenceModel = sequenceModel==null?null:sequenceModel.toBuilder();
			return this;
		}
		
		@Override
		public EventIdentifierSequence build() {
			return new EventIdentifierSequence.EventIdentifierSequenceImpl(this);
		}
		
		@Override
		public EventIdentifierSequence.EventIdentifierSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifierSequence.EventIdentifierSequenceBuilder prune() {
			if (correlationIdModel!=null && !correlationIdModel.prune().hasData()) correlationIdModel = null;
			if (sequenceModel!=null && !sequenceModel.prune().hasData()) sequenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCorrelationIdModel()!=null && getCorrelationIdModel().hasData()) return true;
			if (getSequenceModel()!=null && getSequenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifierSequence.EventIdentifierSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventIdentifierSequence.EventIdentifierSequenceBuilder o = (EventIdentifierSequence.EventIdentifierSequenceBuilder) other;
			
			merger.mergeRosetta(getCorrelationIdModel(), o.getCorrelationIdModel(), this::setCorrelationIdModel);
			merger.mergeRosetta(getSequenceModel(), o.getSequenceModel(), this::setSequenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifierSequence _that = getType().cast(o);
		
			if (!Objects.equals(correlationIdModel, _that.getCorrelationIdModel())) return false;
			if (!Objects.equals(sequenceModel, _that.getSequenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationIdModel != null ? correlationIdModel.hashCode() : 0);
			_result = 31 * _result + (sequenceModel != null ? sequenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifierSequenceBuilder {" +
				"correlationIdModel=" + this.correlationIdModel + ", " +
				"sequenceModel=" + this.sequenceModel +
			'}';
		}
	}
}
