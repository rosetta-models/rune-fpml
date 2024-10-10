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
import fpml.confirmation.MasterAgreement;
import fpml.confirmation.MasterAgreement.MasterAgreementBuilder;
import fpml.confirmation.MasterAgreement.MasterAgreementBuilderImpl;
import fpml.confirmation.MasterAgreement.MasterAgreementImpl;
import fpml.confirmation.MasterAgreementId;
import fpml.confirmation.MasterAgreementType;
import fpml.confirmation.MasterAgreementVersion;
import fpml.confirmation.meta.MasterAgreementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An entity for defining the agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
 * @version ${project.version}
 */
@RosettaDataType(value="MasterAgreement", builder=MasterAgreement.MasterAgreementBuilderImpl.class, version="${project.version}")
public interface MasterAgreement extends RosettaModelObject {

	MasterAgreementMeta metaData = new MasterAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An identifier that has been created to identify the master agreement.
	 */
	List<? extends MasterAgreementId> getMasterAgreementId();
	/**
	 * The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 */
	MasterAgreementType getMasterAgreementType();
	/**
	 * The version of the master agreement.
	 */
	MasterAgreementVersion getMasterAgreementVersion();
	/**
	 * The date on which the master agreement was signed.
	 */
	Date getMasterAgreementDate();

	/*********************** Build Methods  ***********************/
	MasterAgreement build();
	
	MasterAgreement.MasterAgreementBuilder toBuilder();
	
	static MasterAgreement.MasterAgreementBuilder builder() {
		return new MasterAgreement.MasterAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MasterAgreement> getType() {
		return MasterAgreement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("masterAgreementId"), processor, MasterAgreementId.class, getMasterAgreementId());
		processRosetta(path.newSubPath("masterAgreementType"), processor, MasterAgreementType.class, getMasterAgreementType());
		processRosetta(path.newSubPath("masterAgreementVersion"), processor, MasterAgreementVersion.class, getMasterAgreementVersion());
		processor.processBasic(path.newSubPath("masterAgreementDate"), Date.class, getMasterAgreementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementBuilder extends MasterAgreement, RosettaModelObjectBuilder {
		MasterAgreementId.MasterAgreementIdBuilder getOrCreateMasterAgreementId(int _index);
		List<? extends MasterAgreementId.MasterAgreementIdBuilder> getMasterAgreementId();
		MasterAgreementType.MasterAgreementTypeBuilder getOrCreateMasterAgreementType();
		MasterAgreementType.MasterAgreementTypeBuilder getMasterAgreementType();
		MasterAgreementVersion.MasterAgreementVersionBuilder getOrCreateMasterAgreementVersion();
		MasterAgreementVersion.MasterAgreementVersionBuilder getMasterAgreementVersion();
		MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId masterAgreementId0);
		MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId masterAgreementId1, int _idx);
		MasterAgreement.MasterAgreementBuilder addMasterAgreementId(List<? extends MasterAgreementId> masterAgreementId2);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementId(List<? extends MasterAgreementId> masterAgreementId3);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementType(MasterAgreementType masterAgreementType);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementVersion(MasterAgreementVersion masterAgreementVersion);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementDate(Date masterAgreementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("masterAgreementId"), processor, MasterAgreementId.MasterAgreementIdBuilder.class, getMasterAgreementId());
			processRosetta(path.newSubPath("masterAgreementType"), processor, MasterAgreementType.MasterAgreementTypeBuilder.class, getMasterAgreementType());
			processRosetta(path.newSubPath("masterAgreementVersion"), processor, MasterAgreementVersion.MasterAgreementVersionBuilder.class, getMasterAgreementVersion());
			processor.processBasic(path.newSubPath("masterAgreementDate"), Date.class, getMasterAgreementDate(), this);
		}
		

		MasterAgreement.MasterAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreement  ***********************/
	class MasterAgreementImpl implements MasterAgreement {
		private final List<? extends MasterAgreementId> masterAgreementId;
		private final MasterAgreementType masterAgreementType;
		private final MasterAgreementVersion masterAgreementVersion;
		private final Date masterAgreementDate;
		
		protected MasterAgreementImpl(MasterAgreement.MasterAgreementBuilder builder) {
			this.masterAgreementId = ofNullable(builder.getMasterAgreementId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.masterAgreementType = ofNullable(builder.getMasterAgreementType()).map(f->f.build()).orElse(null);
			this.masterAgreementVersion = ofNullable(builder.getMasterAgreementVersion()).map(f->f.build()).orElse(null);
			this.masterAgreementDate = builder.getMasterAgreementDate();
		}
		
		@Override
		@RosettaAttribute("masterAgreementId")
		public List<? extends MasterAgreementId> getMasterAgreementId() {
			return masterAgreementId;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		public MasterAgreementType getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		@RosettaAttribute("masterAgreementVersion")
		public MasterAgreementVersion getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		@RosettaAttribute("masterAgreementDate")
		public Date getMasterAgreementDate() {
			return masterAgreementDate;
		}
		
		@Override
		public MasterAgreement build() {
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			MasterAgreement.MasterAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreement.MasterAgreementBuilder builder) {
			ofNullable(getMasterAgreementId()).ifPresent(builder::setMasterAgreementId);
			ofNullable(getMasterAgreementType()).ifPresent(builder::setMasterAgreementType);
			ofNullable(getMasterAgreementVersion()).ifPresent(builder::setMasterAgreementVersion);
			ofNullable(getMasterAgreementDate()).ifPresent(builder::setMasterAgreementDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(masterAgreementId, _that.getMasterAgreementId())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			if (!Objects.equals(masterAgreementDate, _that.getMasterAgreementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreementId != null ? masterAgreementId.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			_result = 31 * _result + (masterAgreementDate != null ? masterAgreementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreement {" +
				"masterAgreementId=" + this.masterAgreementId + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion + ", " +
				"masterAgreementDate=" + this.masterAgreementDate +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreement  ***********************/
	class MasterAgreementBuilderImpl implements MasterAgreement.MasterAgreementBuilder {
	
		protected List<MasterAgreementId.MasterAgreementIdBuilder> masterAgreementId = new ArrayList<>();
		protected MasterAgreementType.MasterAgreementTypeBuilder masterAgreementType;
		protected MasterAgreementVersion.MasterAgreementVersionBuilder masterAgreementVersion;
		protected Date masterAgreementDate;
	
		public MasterAgreementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("masterAgreementId")
		public List<? extends MasterAgreementId.MasterAgreementIdBuilder> getMasterAgreementId() {
			return masterAgreementId;
		}
		
		public MasterAgreementId.MasterAgreementIdBuilder getOrCreateMasterAgreementId(int _index) {
		
			if (masterAgreementId==null) {
				this.masterAgreementId = new ArrayList<>();
			}
			MasterAgreementId.MasterAgreementIdBuilder result;
			return getIndex(masterAgreementId, _index, () -> {
						MasterAgreementId.MasterAgreementIdBuilder newMasterAgreementId = MasterAgreementId.builder();
						return newMasterAgreementId;
					});
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		public MasterAgreementType.MasterAgreementTypeBuilder getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		public MasterAgreementType.MasterAgreementTypeBuilder getOrCreateMasterAgreementType() {
			MasterAgreementType.MasterAgreementTypeBuilder result;
			if (masterAgreementType!=null) {
				result = masterAgreementType;
			}
			else {
				result = masterAgreementType = MasterAgreementType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementVersion")
		public MasterAgreementVersion.MasterAgreementVersionBuilder getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder getOrCreateMasterAgreementVersion() {
			MasterAgreementVersion.MasterAgreementVersionBuilder result;
			if (masterAgreementVersion!=null) {
				result = masterAgreementVersion;
			}
			else {
				result = masterAgreementVersion = MasterAgreementVersion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementDate")
		public Date getMasterAgreementDate() {
			return masterAgreementDate;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId masterAgreementId) {
			if (masterAgreementId!=null) this.masterAgreementId.add(masterAgreementId.toBuilder());
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId masterAgreementId, int _idx) {
			getIndex(this.masterAgreementId, _idx, () -> masterAgreementId.toBuilder());
			return this;
		}
		@Override 
		public MasterAgreement.MasterAgreementBuilder addMasterAgreementId(List<? extends MasterAgreementId> masterAgreementIds) {
			if (masterAgreementIds != null) {
				for (MasterAgreementId toAdd : masterAgreementIds) {
					this.masterAgreementId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("masterAgreementId")
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementId(List<? extends MasterAgreementId> masterAgreementIds) {
			if (masterAgreementIds == null)  {
				this.masterAgreementId = new ArrayList<>();
			}
			else {
				this.masterAgreementId = masterAgreementIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementType(MasterAgreementType masterAgreementType) {
			this.masterAgreementType = masterAgreementType==null?null:masterAgreementType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("masterAgreementVersion")
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementVersion(MasterAgreementVersion masterAgreementVersion) {
			this.masterAgreementVersion = masterAgreementVersion==null?null:masterAgreementVersion.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("masterAgreementDate")
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementDate(Date masterAgreementDate) {
			this.masterAgreementDate = masterAgreementDate==null?null:masterAgreementDate;
			return this;
		}
		
		@Override
		public MasterAgreement build() {
			return new MasterAgreement.MasterAgreementImpl(this);
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder prune() {
			masterAgreementId = masterAgreementId.stream().filter(b->b!=null).<MasterAgreementId.MasterAgreementIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (masterAgreementType!=null && !masterAgreementType.prune().hasData()) masterAgreementType = null;
			if (masterAgreementVersion!=null && !masterAgreementVersion.prune().hasData()) masterAgreementVersion = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterAgreementId()!=null && getMasterAgreementId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMasterAgreementType()!=null && getMasterAgreementType().hasData()) return true;
			if (getMasterAgreementVersion()!=null && getMasterAgreementVersion().hasData()) return true;
			if (getMasterAgreementDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreement.MasterAgreementBuilder o = (MasterAgreement.MasterAgreementBuilder) other;
			
			merger.mergeRosetta(getMasterAgreementId(), o.getMasterAgreementId(), this::getOrCreateMasterAgreementId);
			merger.mergeRosetta(getMasterAgreementType(), o.getMasterAgreementType(), this::setMasterAgreementType);
			merger.mergeRosetta(getMasterAgreementVersion(), o.getMasterAgreementVersion(), this::setMasterAgreementVersion);
			
			merger.mergeBasic(getMasterAgreementDate(), o.getMasterAgreementDate(), this::setMasterAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(masterAgreementId, _that.getMasterAgreementId())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			if (!Objects.equals(masterAgreementDate, _that.getMasterAgreementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreementId != null ? masterAgreementId.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			_result = 31 * _result + (masterAgreementDate != null ? masterAgreementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementBuilder {" +
				"masterAgreementId=" + this.masterAgreementId + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion + ", " +
				"masterAgreementDate=" + this.masterAgreementDate +
			'}';
		}
	}
}
