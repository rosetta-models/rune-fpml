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
import fpml.confirmation.OtherAgreement;
import fpml.confirmation.OtherAgreement.OtherAgreementBuilder;
import fpml.confirmation.OtherAgreement.OtherAgreementBuilderImpl;
import fpml.confirmation.OtherAgreement.OtherAgreementImpl;
import fpml.confirmation.OtherAgreementId;
import fpml.confirmation.OtherAgreementType;
import fpml.confirmation.OtherAgreementVersion;
import fpml.confirmation.meta.OtherAgreementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An entity for defining the an agreement executed between parties.
 * @version ${project.version}
 */
@RosettaDataType(value="OtherAgreement", builder=OtherAgreement.OtherAgreementBuilderImpl.class, version="${project.version}")
public interface OtherAgreement extends RosettaModelObject {

	OtherAgreementMeta metaData = new OtherAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An identifier that has been created to identify the agreement.
	 */
	List<? extends OtherAgreementId> getIdentifier();
	/**
	 * The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 */
	OtherAgreementType getType_();
	/**
	 * The version of the agreement.
	 */
	OtherAgreementVersion getVersion();
	/**
	 * The date on which the agreement was signed.
	 */
	Date getDate();

	/*********************** Build Methods  ***********************/
	OtherAgreement build();
	
	OtherAgreement.OtherAgreementBuilder toBuilder();
	
	static OtherAgreement.OtherAgreementBuilder builder() {
		return new OtherAgreement.OtherAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OtherAgreement> getType() {
		return OtherAgreement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, OtherAgreementId.class, getIdentifier());
		processRosetta(path.newSubPath("type"), processor, OtherAgreementType.class, getType_());
		processRosetta(path.newSubPath("version"), processor, OtherAgreementVersion.class, getVersion());
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementBuilder extends OtherAgreement, RosettaModelObjectBuilder {
		OtherAgreementId.OtherAgreementIdBuilder getOrCreateIdentifier(int _index);
		List<? extends OtherAgreementId.OtherAgreementIdBuilder> getIdentifier();
		OtherAgreementType.OtherAgreementTypeBuilder getOrCreateType();
		OtherAgreementType.OtherAgreementTypeBuilder getType_();
		OtherAgreementVersion.OtherAgreementVersionBuilder getOrCreateVersion();
		OtherAgreementVersion.OtherAgreementVersionBuilder getVersion();
		OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId identifier0);
		OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId identifier1, int _idx);
		OtherAgreement.OtherAgreementBuilder addIdentifier(List<? extends OtherAgreementId> identifier2);
		OtherAgreement.OtherAgreementBuilder setIdentifier(List<? extends OtherAgreementId> identifier3);
		OtherAgreement.OtherAgreementBuilder setType(OtherAgreementType type);
		OtherAgreement.OtherAgreementBuilder setVersion(OtherAgreementVersion version);
		OtherAgreement.OtherAgreementBuilder setDate(Date date);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, OtherAgreementId.OtherAgreementIdBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("type"), processor, OtherAgreementType.OtherAgreementTypeBuilder.class, getType_());
			processRosetta(path.newSubPath("version"), processor, OtherAgreementVersion.OtherAgreementVersionBuilder.class, getVersion());
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		}
		

		OtherAgreement.OtherAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreement  ***********************/
	class OtherAgreementImpl implements OtherAgreement {
		private final List<? extends OtherAgreementId> identifier;
		private final OtherAgreementType type;
		private final OtherAgreementVersion version;
		private final Date date;
		
		protected OtherAgreementImpl(OtherAgreement.OtherAgreementBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.type = ofNullable(builder.getType_()).map(f->f.build()).orElse(null);
			this.version = ofNullable(builder.getVersion()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
		}
		
		@Override
		@RosettaAttribute("identifier")
		public List<? extends OtherAgreementId> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("type")
		public OtherAgreementType getType_() {
			return type;
		}
		
		@Override
		@RosettaAttribute("version")
		public OtherAgreementVersion getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		public OtherAgreement build() {
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder toBuilder() {
			OtherAgreement.OtherAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreement.OtherAgreementBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getType_()).ifPresent(builder::setType);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getDate()).ifPresent(builder::setDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreement {" +
				"identifier=" + this.identifier + ", " +
				"type=" + this.type + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreement  ***********************/
	class OtherAgreementBuilderImpl implements OtherAgreement.OtherAgreementBuilder {
	
		protected List<OtherAgreementId.OtherAgreementIdBuilder> identifier = new ArrayList<>();
		protected OtherAgreementType.OtherAgreementTypeBuilder type;
		protected OtherAgreementVersion.OtherAgreementVersionBuilder version;
		protected Date date;
	
		public OtherAgreementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("identifier")
		public List<? extends OtherAgreementId.OtherAgreementIdBuilder> getIdentifier() {
			return identifier;
		}
		
		public OtherAgreementId.OtherAgreementIdBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			OtherAgreementId.OtherAgreementIdBuilder result;
			return getIndex(identifier, _index, () -> {
						OtherAgreementId.OtherAgreementIdBuilder newIdentifier = OtherAgreementId.builder();
						return newIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("type")
		public OtherAgreementType.OtherAgreementTypeBuilder getType_() {
			return type;
		}
		
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder getOrCreateType() {
			OtherAgreementType.OtherAgreementTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = OtherAgreementType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("version")
		public OtherAgreementVersion.OtherAgreementVersionBuilder getVersion() {
			return version;
		}
		
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder getOrCreateVersion() {
			OtherAgreementVersion.OtherAgreementVersionBuilder result;
			if (version!=null) {
				result = version;
			}
			else {
				result = version = OtherAgreementVersion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public OtherAgreement.OtherAgreementBuilder addIdentifier(List<? extends OtherAgreementId> identifiers) {
			if (identifiers != null) {
				for (OtherAgreementId toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("identifier")
		public OtherAgreement.OtherAgreementBuilder setIdentifier(List<? extends OtherAgreementId> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("type")
		public OtherAgreement.OtherAgreementBuilder setType(OtherAgreementType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("version")
		public OtherAgreement.OtherAgreementBuilder setVersion(OtherAgreementVersion version) {
			this.version = version==null?null:version.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("date")
		public OtherAgreement.OtherAgreementBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		
		@Override
		public OtherAgreement build() {
			return new OtherAgreement.OtherAgreementImpl(this);
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreement.OtherAgreementBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<OtherAgreementId.OtherAgreementIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (type!=null && !type.prune().hasData()) type = null;
			if (version!=null && !version.prune().hasData()) version = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getType_()!=null && getType_().hasData()) return true;
			if (getVersion()!=null && getVersion().hasData()) return true;
			if (getDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreement.OtherAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreement.OtherAgreementBuilder o = (OtherAgreement.OtherAgreementBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getType_(), o.getType_(), this::setType);
			merger.mergeRosetta(getVersion(), o.getVersion(), this::setVersion);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementBuilder {" +
				"identifier=" + this.identifier + ", " +
				"type=" + this.type + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}
}
