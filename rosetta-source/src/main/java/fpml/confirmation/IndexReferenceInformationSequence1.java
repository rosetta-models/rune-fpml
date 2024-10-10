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
import fpml.confirmation.IndexReferenceInformationSequence1;
import fpml.confirmation.IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder;
import fpml.confirmation.IndexReferenceInformationSequence1.IndexReferenceInformationSequence1BuilderImpl;
import fpml.confirmation.IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Impl;
import fpml.confirmation.meta.IndexReferenceInformationSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="IndexReferenceInformationSequence1", builder=IndexReferenceInformationSequence1.IndexReferenceInformationSequence1BuilderImpl.class, version="${project.version}")
public interface IndexReferenceInformationSequence1 extends RosettaModelObject {

	IndexReferenceInformationSequence1Meta metaData = new IndexReferenceInformationSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A CDS index identifier (e.g. RED pair code).
	 */
	List<? extends IndexId> getIndexId();

	/*********************** Build Methods  ***********************/
	IndexReferenceInformationSequence1 build();
	
	IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder toBuilder();
	
	static IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder builder() {
		return new IndexReferenceInformationSequence1.IndexReferenceInformationSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexReferenceInformationSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexReferenceInformationSequence1> getType() {
		return IndexReferenceInformationSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("indexId"), processor, IndexId.class, getIndexId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexReferenceInformationSequence1Builder extends IndexReferenceInformationSequence1, RosettaModelObjectBuilder {
		IndexId.IndexIdBuilder getOrCreateIndexId(int _index);
		List<? extends IndexId.IndexIdBuilder> getIndexId();
		IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder addIndexId(IndexId indexId0);
		IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder addIndexId(IndexId indexId1, int _idx);
		IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder addIndexId(List<? extends IndexId> indexId2);
		IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder setIndexId(List<? extends IndexId> indexId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("indexId"), processor, IndexId.IndexIdBuilder.class, getIndexId());
		}
		

		IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder prune();
	}

	/*********************** Immutable Implementation of IndexReferenceInformationSequence1  ***********************/
	class IndexReferenceInformationSequence1Impl implements IndexReferenceInformationSequence1 {
		private final List<? extends IndexId> indexId;
		
		protected IndexReferenceInformationSequence1Impl(IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder builder) {
			this.indexId = ofNullable(builder.getIndexId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexId")
		public List<? extends IndexId> getIndexId() {
			return indexId;
		}
		
		@Override
		public IndexReferenceInformationSequence1 build() {
			return this;
		}
		
		@Override
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder toBuilder() {
			IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder builder) {
			ofNullable(getIndexId()).ifPresent(builder::setIndexId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformationSequence1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationSequence1 {" +
				"indexId=" + this.indexId +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexReferenceInformationSequence1  ***********************/
	class IndexReferenceInformationSequence1BuilderImpl implements IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder {
	
		protected List<IndexId.IndexIdBuilder> indexId = new ArrayList<>();
	
		public IndexReferenceInformationSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("indexId")
		public List<? extends IndexId.IndexIdBuilder> getIndexId() {
			return indexId;
		}
		
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
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder addIndexId(IndexId indexId) {
			if (indexId!=null) this.indexId.add(indexId.toBuilder());
			return this;
		}
		
		@Override
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder addIndexId(IndexId indexId, int _idx) {
			getIndex(this.indexId, _idx, () -> indexId.toBuilder());
			return this;
		}
		@Override 
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder addIndexId(List<? extends IndexId> indexIds) {
			if (indexIds != null) {
				for (IndexId toAdd : indexIds) {
					this.indexId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("indexId")
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder setIndexId(List<? extends IndexId> indexIds) {
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
		public IndexReferenceInformationSequence1 build() {
			return new IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Impl(this);
		}
		
		@Override
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder prune() {
			indexId = indexId.stream().filter(b->b!=null).<IndexId.IndexIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexId()!=null && getIndexId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder o = (IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder) other;
			
			merger.mergeRosetta(getIndexId(), o.getIndexId(), this::getOrCreateIndexId);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformationSequence1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationSequence1Builder {" +
				"indexId=" + this.indexId +
			'}';
		}
	}
}
