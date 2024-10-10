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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.IndexAnnexSource;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.IndexReferenceInformation.IndexReferenceInformationBuilder;
import fpml.confirmation.IndexReferenceInformation.IndexReferenceInformationBuilderImpl;
import fpml.confirmation.IndexReferenceInformation.IndexReferenceInformationImpl;
import fpml.confirmation.IndexReferenceInformationSequence0;
import fpml.confirmation.IndexReferenceInformationSequence1;
import fpml.confirmation.IndexReferenceInformationSequence2;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.SettledEntityMatrix;
import fpml.confirmation.Tranche;
import fpml.confirmation.meta.IndexReferenceInformationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a Credit Default Swap Index.
 * @version ${project.version}
 */
@RosettaDataType(value="IndexReferenceInformation", builder=IndexReferenceInformation.IndexReferenceInformationBuilderImpl.class, version="${project.version}")
public interface IndexReferenceInformation extends RosettaModelObject {

	IndexReferenceInformationMeta metaData = new IndexReferenceInformationMeta();

	/*********************** Getter Methods  ***********************/
	IndexReferenceInformationSequence0 getIndexReferenceInformationSequence0();
	IndexReferenceInformationSequence1 getIndexReferenceInformationSequence1();
	/**
	 * A CDS index series identifier, e.g. 1, 2, 3 etc.
	 */
	Integer getIndexSeries();
	/**
	 * A CDS index series version identifier, e.g. 1, 2, 3 etc.
	 */
	Integer getIndexAnnexVersion();
	/**
	 * A CDS index series annex date.
	 */
	Date getIndexAnnexDate();
	/**
	 * A CDS index series annex source.
	 */
	IndexAnnexSource getIndexAnnexSource();
	/**
	 * Excluded reference entity.
	 */
	List<? extends LegalEntity> getExcludedReferenceEntity();
	/**
	 * This element contains CDS tranche terms.
	 */
	Tranche getTranche();
	/**
	 * Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
	 */
	SettledEntityMatrix getSettledEntityMatrix();
	IndexReferenceInformationSequence2 getIndexReferenceInformationSequence2();
	String getId();

	/*********************** Build Methods  ***********************/
	IndexReferenceInformation build();
	
	IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder();
	
	static IndexReferenceInformation.IndexReferenceInformationBuilder builder() {
		return new IndexReferenceInformation.IndexReferenceInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexReferenceInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexReferenceInformation> getType() {
		return IndexReferenceInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("indexReferenceInformationSequence0"), processor, IndexReferenceInformationSequence0.class, getIndexReferenceInformationSequence0());
		processRosetta(path.newSubPath("indexReferenceInformationSequence1"), processor, IndexReferenceInformationSequence1.class, getIndexReferenceInformationSequence1());
		processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
		processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
		processor.processBasic(path.newSubPath("indexAnnexDate"), Date.class, getIndexAnnexDate(), this);
		processRosetta(path.newSubPath("indexAnnexSource"), processor, IndexAnnexSource.class, getIndexAnnexSource());
		processRosetta(path.newSubPath("excludedReferenceEntity"), processor, LegalEntity.class, getExcludedReferenceEntity());
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
		processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.class, getSettledEntityMatrix());
		processRosetta(path.newSubPath("indexReferenceInformationSequence2"), processor, IndexReferenceInformationSequence2.class, getIndexReferenceInformationSequence2());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexReferenceInformationBuilder extends IndexReferenceInformation, RosettaModelObjectBuilder {
		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder getOrCreateIndexReferenceInformationSequence0();
		IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder getIndexReferenceInformationSequence0();
		IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder getOrCreateIndexReferenceInformationSequence1();
		IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder getIndexReferenceInformationSequence1();
		IndexAnnexSource.IndexAnnexSourceBuilder getOrCreateIndexAnnexSource();
		IndexAnnexSource.IndexAnnexSourceBuilder getIndexAnnexSource();
		LegalEntity.LegalEntityBuilder getOrCreateExcludedReferenceEntity(int _index);
		List<? extends LegalEntity.LegalEntityBuilder> getExcludedReferenceEntity();
		Tranche.TrancheBuilder getOrCreateTranche();
		Tranche.TrancheBuilder getTranche();
		SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix();
		SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix();
		IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder getOrCreateIndexReferenceInformationSequence2();
		IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder getIndexReferenceInformationSequence2();
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexReferenceInformationSequence0(IndexReferenceInformationSequence0 indexReferenceInformationSequence0);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexReferenceInformationSequence1(IndexReferenceInformationSequence1 indexReferenceInformationSequence1);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexSeries(Integer indexSeries);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexVersion(Integer indexAnnexVersion);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexDate(Date indexAnnexDate);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSource(IndexAnnexSource indexAnnexSource);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity0);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity1, int _idx);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntity2);
		IndexReferenceInformation.IndexReferenceInformationBuilder setExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntity3);
		IndexReferenceInformation.IndexReferenceInformationBuilder setTranche(Tranche tranche);
		IndexReferenceInformation.IndexReferenceInformationBuilder setSettledEntityMatrix(SettledEntityMatrix settledEntityMatrix);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexReferenceInformationSequence2(IndexReferenceInformationSequence2 indexReferenceInformationSequence2);
		IndexReferenceInformation.IndexReferenceInformationBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("indexReferenceInformationSequence0"), processor, IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder.class, getIndexReferenceInformationSequence0());
			processRosetta(path.newSubPath("indexReferenceInformationSequence1"), processor, IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder.class, getIndexReferenceInformationSequence1());
			processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
			processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
			processor.processBasic(path.newSubPath("indexAnnexDate"), Date.class, getIndexAnnexDate(), this);
			processRosetta(path.newSubPath("indexAnnexSource"), processor, IndexAnnexSource.IndexAnnexSourceBuilder.class, getIndexAnnexSource());
			processRosetta(path.newSubPath("excludedReferenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getExcludedReferenceEntity());
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
			processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.SettledEntityMatrixBuilder.class, getSettledEntityMatrix());
			processRosetta(path.newSubPath("indexReferenceInformationSequence2"), processor, IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder.class, getIndexReferenceInformationSequence2());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		IndexReferenceInformation.IndexReferenceInformationBuilder prune();
	}

	/*********************** Immutable Implementation of IndexReferenceInformation  ***********************/
	class IndexReferenceInformationImpl implements IndexReferenceInformation {
		private final IndexReferenceInformationSequence0 indexReferenceInformationSequence0;
		private final IndexReferenceInformationSequence1 indexReferenceInformationSequence1;
		private final Integer indexSeries;
		private final Integer indexAnnexVersion;
		private final Date indexAnnexDate;
		private final IndexAnnexSource indexAnnexSource;
		private final List<? extends LegalEntity> excludedReferenceEntity;
		private final Tranche tranche;
		private final SettledEntityMatrix settledEntityMatrix;
		private final IndexReferenceInformationSequence2 indexReferenceInformationSequence2;
		private final String id;
		
		protected IndexReferenceInformationImpl(IndexReferenceInformation.IndexReferenceInformationBuilder builder) {
			this.indexReferenceInformationSequence0 = ofNullable(builder.getIndexReferenceInformationSequence0()).map(f->f.build()).orElse(null);
			this.indexReferenceInformationSequence1 = ofNullable(builder.getIndexReferenceInformationSequence1()).map(f->f.build()).orElse(null);
			this.indexSeries = builder.getIndexSeries();
			this.indexAnnexVersion = builder.getIndexAnnexVersion();
			this.indexAnnexDate = builder.getIndexAnnexDate();
			this.indexAnnexSource = ofNullable(builder.getIndexAnnexSource()).map(f->f.build()).orElse(null);
			this.excludedReferenceEntity = ofNullable(builder.getExcludedReferenceEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
			this.settledEntityMatrix = ofNullable(builder.getSettledEntityMatrix()).map(f->f.build()).orElse(null);
			this.indexReferenceInformationSequence2 = ofNullable(builder.getIndexReferenceInformationSequence2()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformationSequence0")
		public IndexReferenceInformationSequence0 getIndexReferenceInformationSequence0() {
			return indexReferenceInformationSequence0;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformationSequence1")
		public IndexReferenceInformationSequence1 getIndexReferenceInformationSequence1() {
			return indexReferenceInformationSequence1;
		}
		
		@Override
		@RosettaAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("indexAnnexDate")
		public Date getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSource")
		public IndexAnnexSource getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		public List<? extends LegalEntity> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrix")
		public SettledEntityMatrix getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformationSequence2")
		public IndexReferenceInformationSequence2 getIndexReferenceInformationSequence2() {
			return indexReferenceInformationSequence2;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public IndexReferenceInformation build() {
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder() {
			IndexReferenceInformation.IndexReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexReferenceInformation.IndexReferenceInformationBuilder builder) {
			ofNullable(getIndexReferenceInformationSequence0()).ifPresent(builder::setIndexReferenceInformationSequence0);
			ofNullable(getIndexReferenceInformationSequence1()).ifPresent(builder::setIndexReferenceInformationSequence1);
			ofNullable(getIndexSeries()).ifPresent(builder::setIndexSeries);
			ofNullable(getIndexAnnexVersion()).ifPresent(builder::setIndexAnnexVersion);
			ofNullable(getIndexAnnexDate()).ifPresent(builder::setIndexAnnexDate);
			ofNullable(getIndexAnnexSource()).ifPresent(builder::setIndexAnnexSource);
			ofNullable(getExcludedReferenceEntity()).ifPresent(builder::setExcludedReferenceEntity);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
			ofNullable(getSettledEntityMatrix()).ifPresent(builder::setSettledEntityMatrix);
			ofNullable(getIndexReferenceInformationSequence2()).ifPresent(builder::setIndexReferenceInformationSequence2);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(indexReferenceInformationSequence0, _that.getIndexReferenceInformationSequence0())) return false;
			if (!Objects.equals(indexReferenceInformationSequence1, _that.getIndexReferenceInformationSequence1())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(indexReferenceInformationSequence2, _that.getIndexReferenceInformationSequence2())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexReferenceInformationSequence0 != null ? indexReferenceInformationSequence0.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformationSequence1 != null ? indexReferenceInformationSequence1.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformationSequence2 != null ? indexReferenceInformationSequence2.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformation {" +
				"indexReferenceInformationSequence0=" + this.indexReferenceInformationSequence0 + ", " +
				"indexReferenceInformationSequence1=" + this.indexReferenceInformationSequence1 + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"tranche=" + this.tranche + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"indexReferenceInformationSequence2=" + this.indexReferenceInformationSequence2 + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexReferenceInformation  ***********************/
	class IndexReferenceInformationBuilderImpl implements IndexReferenceInformation.IndexReferenceInformationBuilder {
	
		protected IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder indexReferenceInformationSequence0;
		protected IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder indexReferenceInformationSequence1;
		protected Integer indexSeries;
		protected Integer indexAnnexVersion;
		protected Date indexAnnexDate;
		protected IndexAnnexSource.IndexAnnexSourceBuilder indexAnnexSource;
		protected List<LegalEntity.LegalEntityBuilder> excludedReferenceEntity = new ArrayList<>();
		protected Tranche.TrancheBuilder tranche;
		protected SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix;
		protected IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder indexReferenceInformationSequence2;
		protected String id;
	
		public IndexReferenceInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("indexReferenceInformationSequence0")
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder getIndexReferenceInformationSequence0() {
			return indexReferenceInformationSequence0;
		}
		
		@Override
		public IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder getOrCreateIndexReferenceInformationSequence0() {
			IndexReferenceInformationSequence0.IndexReferenceInformationSequence0Builder result;
			if (indexReferenceInformationSequence0!=null) {
				result = indexReferenceInformationSequence0;
			}
			else {
				result = indexReferenceInformationSequence0 = IndexReferenceInformationSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformationSequence1")
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder getIndexReferenceInformationSequence1() {
			return indexReferenceInformationSequence1;
		}
		
		@Override
		public IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder getOrCreateIndexReferenceInformationSequence1() {
			IndexReferenceInformationSequence1.IndexReferenceInformationSequence1Builder result;
			if (indexReferenceInformationSequence1!=null) {
				result = indexReferenceInformationSequence1;
			}
			else {
				result = indexReferenceInformationSequence1 = IndexReferenceInformationSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("indexAnnexDate")
		public Date getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSource")
		public IndexAnnexSource.IndexAnnexSourceBuilder getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		public IndexAnnexSource.IndexAnnexSourceBuilder getOrCreateIndexAnnexSource() {
			IndexAnnexSource.IndexAnnexSourceBuilder result;
			if (indexAnnexSource!=null) {
				result = indexAnnexSource;
			}
			else {
				result = indexAnnexSource = IndexAnnexSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		public List<? extends LegalEntity.LegalEntityBuilder> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		public LegalEntity.LegalEntityBuilder getOrCreateExcludedReferenceEntity(int _index) {
		
			if (excludedReferenceEntity==null) {
				this.excludedReferenceEntity = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(excludedReferenceEntity, _index, () -> {
						LegalEntity.LegalEntityBuilder newExcludedReferenceEntity = LegalEntity.builder();
						return newExcludedReferenceEntity;
					});
		}
		
		@Override
		@RosettaAttribute("tranche")
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrix")
		public SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix() {
			SettledEntityMatrix.SettledEntityMatrixBuilder result;
			if (settledEntityMatrix!=null) {
				result = settledEntityMatrix;
			}
			else {
				result = settledEntityMatrix = SettledEntityMatrix.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformationSequence2")
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder getIndexReferenceInformationSequence2() {
			return indexReferenceInformationSequence2;
		}
		
		@Override
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder getOrCreateIndexReferenceInformationSequence2() {
			IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder result;
			if (indexReferenceInformationSequence2!=null) {
				result = indexReferenceInformationSequence2;
			}
			else {
				result = indexReferenceInformationSequence2 = IndexReferenceInformationSequence2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformationSequence0")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexReferenceInformationSequence0(IndexReferenceInformationSequence0 indexReferenceInformationSequence0) {
			this.indexReferenceInformationSequence0 = indexReferenceInformationSequence0==null?null:indexReferenceInformationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexReferenceInformationSequence1")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexReferenceInformationSequence1(IndexReferenceInformationSequence1 indexReferenceInformationSequence1) {
			this.indexReferenceInformationSequence1 = indexReferenceInformationSequence1==null?null:indexReferenceInformationSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexSeries")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexSeries(Integer indexSeries) {
			this.indexSeries = indexSeries==null?null:indexSeries;
			return this;
		}
		@Override
		@RosettaAttribute("indexAnnexVersion")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexVersion(Integer indexAnnexVersion) {
			this.indexAnnexVersion = indexAnnexVersion==null?null:indexAnnexVersion;
			return this;
		}
		@Override
		@RosettaAttribute("indexAnnexDate")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexDate(Date indexAnnexDate) {
			this.indexAnnexDate = indexAnnexDate==null?null:indexAnnexDate;
			return this;
		}
		@Override
		@RosettaAttribute("indexAnnexSource")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSource(IndexAnnexSource indexAnnexSource) {
			this.indexAnnexSource = indexAnnexSource==null?null:indexAnnexSource.toBuilder();
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity) {
			if (excludedReferenceEntity!=null) this.excludedReferenceEntity.add(excludedReferenceEntity.toBuilder());
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity, int _idx) {
			getIndex(this.excludedReferenceEntity, _idx, () -> excludedReferenceEntity.toBuilder());
			return this;
		}
		@Override 
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntitys) {
			if (excludedReferenceEntitys != null) {
				for (LegalEntity toAdd : excludedReferenceEntitys) {
					this.excludedReferenceEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("excludedReferenceEntity")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntitys) {
			if (excludedReferenceEntitys == null)  {
				this.excludedReferenceEntity = new ArrayList<>();
			}
			else {
				this.excludedReferenceEntity = excludedReferenceEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setTranche(Tranche tranche) {
			this.tranche = tranche==null?null:tranche.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settledEntityMatrix")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setSettledEntityMatrix(SettledEntityMatrix settledEntityMatrix) {
			this.settledEntityMatrix = settledEntityMatrix==null?null:settledEntityMatrix.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexReferenceInformationSequence2")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexReferenceInformationSequence2(IndexReferenceInformationSequence2 indexReferenceInformationSequence2) {
			this.indexReferenceInformationSequence2 = indexReferenceInformationSequence2==null?null:indexReferenceInformationSequence2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public IndexReferenceInformation.IndexReferenceInformationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public IndexReferenceInformation build() {
			return new IndexReferenceInformation.IndexReferenceInformationImpl(this);
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder prune() {
			if (indexReferenceInformationSequence0!=null && !indexReferenceInformationSequence0.prune().hasData()) indexReferenceInformationSequence0 = null;
			if (indexReferenceInformationSequence1!=null && !indexReferenceInformationSequence1.prune().hasData()) indexReferenceInformationSequence1 = null;
			if (indexAnnexSource!=null && !indexAnnexSource.prune().hasData()) indexAnnexSource = null;
			excludedReferenceEntity = excludedReferenceEntity.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			if (settledEntityMatrix!=null && !settledEntityMatrix.prune().hasData()) settledEntityMatrix = null;
			if (indexReferenceInformationSequence2!=null && !indexReferenceInformationSequence2.prune().hasData()) indexReferenceInformationSequence2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexReferenceInformationSequence0()!=null && getIndexReferenceInformationSequence0().hasData()) return true;
			if (getIndexReferenceInformationSequence1()!=null && getIndexReferenceInformationSequence1().hasData()) return true;
			if (getIndexSeries()!=null) return true;
			if (getIndexAnnexVersion()!=null) return true;
			if (getIndexAnnexDate()!=null) return true;
			if (getIndexAnnexSource()!=null && getIndexAnnexSource().hasData()) return true;
			if (getExcludedReferenceEntity()!=null && getExcludedReferenceEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			if (getSettledEntityMatrix()!=null && getSettledEntityMatrix().hasData()) return true;
			if (getIndexReferenceInformationSequence2()!=null && getIndexReferenceInformationSequence2().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexReferenceInformation.IndexReferenceInformationBuilder o = (IndexReferenceInformation.IndexReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getIndexReferenceInformationSequence0(), o.getIndexReferenceInformationSequence0(), this::setIndexReferenceInformationSequence0);
			merger.mergeRosetta(getIndexReferenceInformationSequence1(), o.getIndexReferenceInformationSequence1(), this::setIndexReferenceInformationSequence1);
			merger.mergeRosetta(getIndexAnnexSource(), o.getIndexAnnexSource(), this::setIndexAnnexSource);
			merger.mergeRosetta(getExcludedReferenceEntity(), o.getExcludedReferenceEntity(), this::getOrCreateExcludedReferenceEntity);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			merger.mergeRosetta(getSettledEntityMatrix(), o.getSettledEntityMatrix(), this::setSettledEntityMatrix);
			merger.mergeRosetta(getIndexReferenceInformationSequence2(), o.getIndexReferenceInformationSequence2(), this::setIndexReferenceInformationSequence2);
			
			merger.mergeBasic(getIndexSeries(), o.getIndexSeries(), this::setIndexSeries);
			merger.mergeBasic(getIndexAnnexVersion(), o.getIndexAnnexVersion(), this::setIndexAnnexVersion);
			merger.mergeBasic(getIndexAnnexDate(), o.getIndexAnnexDate(), this::setIndexAnnexDate);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(indexReferenceInformationSequence0, _that.getIndexReferenceInformationSequence0())) return false;
			if (!Objects.equals(indexReferenceInformationSequence1, _that.getIndexReferenceInformationSequence1())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(indexReferenceInformationSequence2, _that.getIndexReferenceInformationSequence2())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexReferenceInformationSequence0 != null ? indexReferenceInformationSequence0.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformationSequence1 != null ? indexReferenceInformationSequence1.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformationSequence2 != null ? indexReferenceInformationSequence2.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationBuilder {" +
				"indexReferenceInformationSequence0=" + this.indexReferenceInformationSequence0 + ", " +
				"indexReferenceInformationSequence1=" + this.indexReferenceInformationSequence1 + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"tranche=" + this.tranche + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"indexReferenceInformationSequence2=" + this.indexReferenceInformationSequence2 + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
