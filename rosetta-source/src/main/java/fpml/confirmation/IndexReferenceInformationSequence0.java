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
import fpml.confirmation.IndexId;
import fpml.confirmation.IndexName;
import fpml.confirmation.IndexReferenceInformationSequence0;
import fpml.confirmation.IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder;
import fpml.confirmation.IndexReferenceInformationSequence0.IndexReferenceInformationSequence0BuilderImpl;
import fpml.confirmation.IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Impl;
import fpml.confirmation.meta.IndexReferenceInformationSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="IndexReferenceInformationSequence0", builder=IndexReferenceInformationSequence0.IndexReferenceInformationSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface IndexReferenceInformationSequence0 extends RosettaModelObject {

	IndexReferenceInformationSequence0Meta metaData = new IndexReferenceInformationSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the index expressed as a free format string. FpML does not define usage rules for this element.
	 */
	IndexName getIndexName();
	/**
	 * A CDS index identifier (e.g. RED pair code).
	 */
	List<? extends IndexId> getIndexId();

	/*********************** Build Methods  ***********************/
	IndexReferenceInformationSequence0 build();
	
	IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder toBuilder();
	
	static IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder builder() {
		return new IndexReferenceInformationSequence0.IndexReferenceInformationSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexReferenceInformationSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexReferenceInformationSequence0> getType() {
		return IndexReferenceInformationSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("indexName"), processor, IndexName.class, getIndexName());
		processRosetta(path.newSubPath("indexId"), processor, IndexId.class, getIndexId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexReferenceInformationSequence0Builder extends IndexReferenceInformationSequence0, RosettaModelObjectBuilder {
		IndexName.IndexNameBuilder getOrCreateIndexName();
		IndexName.IndexNameBuilder getIndexName();
		IndexId.IndexIdBuilder getOrCreateIndexId(int _index);
		List<? extends IndexId.IndexIdBuilder> getIndexId();
		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder setIndexName(IndexName indexName);
		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder addIndexId(IndexId indexId0);
		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder addIndexId(IndexId indexId1, int _idx);
		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder addIndexId(List<? extends IndexId> indexId2);
		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder setIndexId(List<? extends IndexId> indexId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("indexName"), processor, IndexName.IndexNameBuilder.class, getIndexName());
			processRosetta(path.newSubPath("indexId"), processor, IndexId.IndexIdBuilder.class, getIndexId());
		}
		

		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder prune();
	}

	/*********************** Immutable Implementation of IndexReferenceInformationSequence0  ***********************/
	class IndexReferenceInformationSequence0Impl implements IndexReferenceInformationSequence0 {
		private final IndexName indexName;
		private final List<? extends IndexId> indexId;
		
		protected IndexReferenceInformationSequence0Impl(IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder builder) {
			this.indexName = ofNullable(builder.getIndexName()).map(f->f.build()).orElse(null);
			this.indexId = ofNullable(builder.getIndexId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexName")
		public IndexName getIndexName() {
			return indexName;
		}
		
		@Override
		@RosettaAttribute("indexId")
		public List<? extends IndexId> getIndexId() {
			return indexId;
		}
		
		@Override
		public IndexReferenceInformationSequence0 build() {
			return this;
		}
		
		@Override
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder toBuilder() {
			IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder builder) {
			ofNullable(getIndexName()).ifPresent(builder::setIndexName);
			ofNullable(getIndexId()).ifPresent(builder::setIndexId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(indexName, _that.getIndexName())) return false;
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexName != null ? indexName.hashCode() : 0);
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationSequence0 {" +
				"indexName=" + this.indexName + ", " +
				"indexId=" + this.indexId +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexReferenceInformationSequence0  ***********************/
	class IndexReferenceInformationSequence0BuilderImpl implements IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder {
	
		protected IndexName.IndexNameBuilder indexName;
		protected List<IndexId.IndexIdBuilder> indexId = new ArrayList<>();
	
		public IndexReferenceInformationSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("indexName")
		public IndexName.IndexNameBuilder getIndexName() {
			return indexName;
		}
		
		@Override
		public IndexName.IndexNameBuilder getOrCreateIndexName() {
			IndexName.IndexNameBuilder result;
			if (indexName!=null) {
				result = indexName;
			}
			else {
				result = indexName = IndexName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexId")
		public List<? extends IndexId.IndexIdBuilder> getIndexId() {
			return indexId;
		}
		
		@Override
		public IndexId.IndexIdBuilder getOrCreateIndexId(int _index) {
		
			if (indexId==null) {
				this.indexId = new ArrayList<>();
			}
			IndexId.IndexIdBuilder result;
			return getIndex(indexId, _index, () -> {
						IndexId.IndexIdBuilder newIndexId = IndexId.builder();
						return newIndexId;
					});
		}
		
		@Override
		@RosettaAttribute("indexName")
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder setIndexName(IndexName indexName) {
			this.indexName = indexName==null?null:indexName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexId")
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder addIndexId(IndexId indexId) {
			if (indexId!=null) this.indexId.add(indexId.toBuilder());
			return this;
		}
		
		@Override
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder addIndexId(IndexId indexId, int _idx) {
			getIndex(this.indexId, _idx, () -> indexId.toBuilder());
			return this;
		}
		@Override 
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder addIndexId(List<? extends IndexId> indexIds) {
			if (indexIds != null) {
				for (IndexId toAdd : indexIds) {
					this.indexId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder setIndexId(List<? extends IndexId> indexIds) {
			if (indexIds == null)  {
				this.indexId = new ArrayList<>();
			}
			else {
				this.indexId = indexIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public IndexReferenceInformationSequence0 build() {
			return new IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Impl(this);
		}
		
		@Override
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder prune() {
			if (indexName!=null && !indexName.prune().hasData()) indexName = null;
			indexId = indexId.stream().filter(b->b!=null).<IndexId.IndexIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexName()!=null && getIndexName().hasData()) return true;
			if (getIndexId()!=null && getIndexId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder o = (IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder) other;
			
			merger.mergeRosetta(getIndexName(), o.getIndexName(), this::setIndexName);
			merger.mergeRosetta(getIndexId(), o.getIndexId(), this::getOrCreateIndexId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(indexName, _that.getIndexName())) return false;
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexName != null ? indexName.hashCode() : 0);
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationSequence0Builder {" +
				"indexName=" + this.indexName + ", " +
				"indexId=" + this.indexId +
			'}';
		}
	}
}
