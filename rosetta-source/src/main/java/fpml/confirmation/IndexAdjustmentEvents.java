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
import fpml.confirmation.IndexAdjustmentEvents;
import fpml.confirmation.IndexAdjustmentEvents.IndexAdjustmentEventsBuilder;
import fpml.confirmation.IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl;
import fpml.confirmation.IndexAdjustmentEvents.IndexAdjustmentEventsImpl;
import fpml.confirmation.IndexEventConsequenceEnum;
import fpml.confirmation.meta.IndexAdjustmentEventsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the specification of the consequences of Index Events as defined by the 2002 ISDA Equity Derivatives Definitions.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="IndexAdjustmentEvents", builder=IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface IndexAdjustmentEvents extends RosettaModelObject {

	IndexAdjustmentEventsMeta metaData = new IndexAdjustmentEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Consequence of index modification.
	 */
	IndexEventConsequenceEnum getIndexModification();
	/**
	 * Consequence of index cancellation.
	 */
	IndexEventConsequenceEnum getIndexCancellation();
	/**
	 * Consequence of index disruption.
	 */
	IndexEventConsequenceEnum getIndexDisruption();

	/*********************** Build Methods  ***********************/
	IndexAdjustmentEvents build();
	
	IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder();
	
	static IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder() {
		return new IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexAdjustmentEvents> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexAdjustmentEvents> getType() {
		return IndexAdjustmentEvents.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("indexModification"), IndexEventConsequenceEnum.class, getIndexModification(), this);
		processor.processBasic(path.newSubPath("indexCancellation"), IndexEventConsequenceEnum.class, getIndexCancellation(), this);
		processor.processBasic(path.newSubPath("indexDisruption"), IndexEventConsequenceEnum.class, getIndexDisruption(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexAdjustmentEventsBuilder extends IndexAdjustmentEvents, RosettaModelObjectBuilder {
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexModification(IndexEventConsequenceEnum indexModification);
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexCancellation(IndexEventConsequenceEnum indexCancellation);
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexDisruption(IndexEventConsequenceEnum indexDisruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("indexModification"), IndexEventConsequenceEnum.class, getIndexModification(), this);
			processor.processBasic(path.newSubPath("indexCancellation"), IndexEventConsequenceEnum.class, getIndexCancellation(), this);
			processor.processBasic(path.newSubPath("indexDisruption"), IndexEventConsequenceEnum.class, getIndexDisruption(), this);
		}
		

		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder prune();
	}

	/*********************** Immutable Implementation of IndexAdjustmentEvents  ***********************/
	class IndexAdjustmentEventsImpl implements IndexAdjustmentEvents {
		private final IndexEventConsequenceEnum indexModification;
		private final IndexEventConsequenceEnum indexCancellation;
		private final IndexEventConsequenceEnum indexDisruption;
		
		protected IndexAdjustmentEventsImpl(IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder) {
			this.indexModification = builder.getIndexModification();
			this.indexCancellation = builder.getIndexCancellation();
			this.indexDisruption = builder.getIndexDisruption();
		}
		
		@Override
		@RosettaAttribute("indexModification")
		public IndexEventConsequenceEnum getIndexModification() {
			return indexModification;
		}
		
		@Override
		@RosettaAttribute("indexCancellation")
		public IndexEventConsequenceEnum getIndexCancellation() {
			return indexCancellation;
		}
		
		@Override
		@RosettaAttribute("indexDisruption")
		public IndexEventConsequenceEnum getIndexDisruption() {
			return indexDisruption;
		}
		
		@Override
		public IndexAdjustmentEvents build() {
			return this;
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder() {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder) {
			ofNullable(getIndexModification()).ifPresent(builder::setIndexModification);
			ofNullable(getIndexCancellation()).ifPresent(builder::setIndexCancellation);
			ofNullable(getIndexDisruption()).ifPresent(builder::setIndexDisruption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAdjustmentEvents _that = getType().cast(o);
		
			if (!Objects.equals(indexModification, _that.getIndexModification())) return false;
			if (!Objects.equals(indexCancellation, _that.getIndexCancellation())) return false;
			if (!Objects.equals(indexDisruption, _that.getIndexDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexModification != null ? indexModification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexCancellation != null ? indexCancellation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexDisruption != null ? indexDisruption.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAdjustmentEvents {" +
				"indexModification=" + this.indexModification + ", " +
				"indexCancellation=" + this.indexCancellation + ", " +
				"indexDisruption=" + this.indexDisruption +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexAdjustmentEvents  ***********************/
	class IndexAdjustmentEventsBuilderImpl implements IndexAdjustmentEvents.IndexAdjustmentEventsBuilder {
	
		protected IndexEventConsequenceEnum indexModification;
		protected IndexEventConsequenceEnum indexCancellation;
		protected IndexEventConsequenceEnum indexDisruption;
	
		public IndexAdjustmentEventsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("indexModification")
		public IndexEventConsequenceEnum getIndexModification() {
			return indexModification;
		}
		
		@Override
		@RosettaAttribute("indexCancellation")
		public IndexEventConsequenceEnum getIndexCancellation() {
			return indexCancellation;
		}
		
		@Override
		@RosettaAttribute("indexDisruption")
		public IndexEventConsequenceEnum getIndexDisruption() {
			return indexDisruption;
		}
		
		@Override
		@RosettaAttribute("indexModification")
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexModification(IndexEventConsequenceEnum indexModification) {
			this.indexModification = indexModification==null?null:indexModification;
			return this;
		}
		@Override
		@RosettaAttribute("indexCancellation")
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexCancellation(IndexEventConsequenceEnum indexCancellation) {
			this.indexCancellation = indexCancellation==null?null:indexCancellation;
			return this;
		}
		@Override
		@RosettaAttribute("indexDisruption")
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexDisruption(IndexEventConsequenceEnum indexDisruption) {
			this.indexDisruption = indexDisruption==null?null:indexDisruption;
			return this;
		}
		
		@Override
		public IndexAdjustmentEvents build() {
			return new IndexAdjustmentEvents.IndexAdjustmentEventsImpl(this);
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexModification()!=null) return true;
			if (getIndexCancellation()!=null) return true;
			if (getIndexDisruption()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder o = (IndexAdjustmentEvents.IndexAdjustmentEventsBuilder) other;
			
			
			merger.mergeBasic(getIndexModification(), o.getIndexModification(), this::setIndexModification);
			merger.mergeBasic(getIndexCancellation(), o.getIndexCancellation(), this::setIndexCancellation);
			merger.mergeBasic(getIndexDisruption(), o.getIndexDisruption(), this::setIndexDisruption);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAdjustmentEvents _that = getType().cast(o);
		
			if (!Objects.equals(indexModification, _that.getIndexModification())) return false;
			if (!Objects.equals(indexCancellation, _that.getIndexCancellation())) return false;
			if (!Objects.equals(indexDisruption, _that.getIndexDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexModification != null ? indexModification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexCancellation != null ? indexCancellation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexDisruption != null ? indexDisruption.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAdjustmentEventsBuilder {" +
				"indexModification=" + this.indexModification + ", " +
				"indexCancellation=" + this.indexCancellation + ", " +
				"indexDisruption=" + this.indexDisruption +
			'}';
		}
	}
}
