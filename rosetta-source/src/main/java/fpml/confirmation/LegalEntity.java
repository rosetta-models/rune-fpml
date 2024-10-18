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
import fpml.confirmation.EntityId;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntity.LegalEntityBuilder;
import fpml.confirmation.LegalEntity.LegalEntityBuilderImpl;
import fpml.confirmation.LegalEntity.LegalEntityImpl;
import fpml.confirmation.LegalEntitySequence;
import fpml.confirmation.meta.LegalEntityMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a legal entity.
 * @version ${project.version}
 */
@RosettaDataType(value="LegalEntity", builder=LegalEntity.LegalEntityBuilderImpl.class, version="${project.version}")
public interface LegalEntity extends RosettaModelObject {

	LegalEntityMeta metaData = new LegalEntityMeta();

	/*********************** Getter Methods  ***********************/
	LegalEntitySequence getLegalEntitySequence();
	/**
	 * A legal entity identifier (e.g. RED entity code)..
	 */
	List<? extends EntityId> getEntityId();
	String getId();

	/*********************** Build Methods  ***********************/
	LegalEntity build();
	
	LegalEntity.LegalEntityBuilder toBuilder();
	
	static LegalEntity.LegalEntityBuilder builder() {
		return new LegalEntity.LegalEntityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalEntity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LegalEntity> getType() {
		return LegalEntity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("legalEntitySequence"), processor, LegalEntitySequence.class, getLegalEntitySequence());
		processRosetta(path.newSubPath("entityId"), processor, EntityId.class, getEntityId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalEntityBuilder extends LegalEntity, RosettaModelObjectBuilder {
		LegalEntitySequence.LegalEntitySequenceBuilder getOrCreateLegalEntitySequence();
		LegalEntitySequence.LegalEntitySequenceBuilder getLegalEntitySequence();
		EntityId.EntityIdBuilder getOrCreateEntityId(int _index);
		List<? extends EntityId.EntityIdBuilder> getEntityId();
		LegalEntity.LegalEntityBuilder setLegalEntitySequence(LegalEntitySequence legalEntitySequence);
		LegalEntity.LegalEntityBuilder addEntityId(EntityId entityId0);
		LegalEntity.LegalEntityBuilder addEntityId(EntityId entityId1, int _idx);
		LegalEntity.LegalEntityBuilder addEntityId(List<? extends EntityId> entityId2);
		LegalEntity.LegalEntityBuilder setEntityId(List<? extends EntityId> entityId3);
		LegalEntity.LegalEntityBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("legalEntitySequence"), processor, LegalEntitySequence.LegalEntitySequenceBuilder.class, getLegalEntitySequence());
			processRosetta(path.newSubPath("entityId"), processor, EntityId.EntityIdBuilder.class, getEntityId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		LegalEntity.LegalEntityBuilder prune();
	}

	/*********************** Immutable Implementation of LegalEntity  ***********************/
	class LegalEntityImpl implements LegalEntity {
		private final LegalEntitySequence legalEntitySequence;
		private final List<? extends EntityId> entityId;
		private final String id;
		
		protected LegalEntityImpl(LegalEntity.LegalEntityBuilder builder) {
			this.legalEntitySequence = ofNullable(builder.getLegalEntitySequence()).map(f->f.build()).orElse(null);
			this.entityId = ofNullable(builder.getEntityId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("legalEntitySequence")
		public LegalEntitySequence getLegalEntitySequence() {
			return legalEntitySequence;
		}
		
		@Override
		@RosettaAttribute("entityId")
		public List<? extends EntityId> getEntityId() {
			return entityId;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public LegalEntity build() {
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			LegalEntity.LegalEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalEntity.LegalEntityBuilder builder) {
			ofNullable(getLegalEntitySequence()).ifPresent(builder::setLegalEntitySequence);
			ofNullable(getEntityId()).ifPresent(builder::setEntityId);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!Objects.equals(legalEntitySequence, _that.getLegalEntitySequence())) return false;
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legalEntitySequence != null ? legalEntitySequence.hashCode() : 0);
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntity {" +
				"legalEntitySequence=" + this.legalEntitySequence + ", " +
				"entityId=" + this.entityId + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalEntity  ***********************/
	class LegalEntityBuilderImpl implements LegalEntity.LegalEntityBuilder {
	
		protected LegalEntitySequence.LegalEntitySequenceBuilder legalEntitySequence;
		protected List<EntityId.EntityIdBuilder> entityId = new ArrayList<>();
		protected String id;
	
		public LegalEntityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("legalEntitySequence")
		public LegalEntitySequence.LegalEntitySequenceBuilder getLegalEntitySequence() {
			return legalEntitySequence;
		}
		
		@Override
		public LegalEntitySequence.LegalEntitySequenceBuilder getOrCreateLegalEntitySequence() {
			LegalEntitySequence.LegalEntitySequenceBuilder result;
			if (legalEntitySequence!=null) {
				result = legalEntitySequence;
			}
			else {
				result = legalEntitySequence = LegalEntitySequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("entityId")
		public List<? extends EntityId.EntityIdBuilder> getEntityId() {
			return entityId;
		}
		
		@Override
		public EntityId.EntityIdBuilder getOrCreateEntityId(int _index) {
		
			if (entityId==null) {
				this.entityId = new ArrayList<>();
			}
			EntityId.EntityIdBuilder result;
			return getIndex(entityId, _index, () -> {
						EntityId.EntityIdBuilder newEntityId = EntityId.builder();
						return newEntityId;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("legalEntitySequence")
		public LegalEntity.LegalEntityBuilder setLegalEntitySequence(LegalEntitySequence legalEntitySequence) {
			this.legalEntitySequence = legalEntitySequence==null?null:legalEntitySequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("entityId")
		public LegalEntity.LegalEntityBuilder addEntityId(EntityId entityId) {
			if (entityId!=null) this.entityId.add(entityId.toBuilder());
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(EntityId entityId, int _idx) {
			getIndex(this.entityId, _idx, () -> entityId.toBuilder());
			return this;
		}
		@Override 
		public LegalEntity.LegalEntityBuilder addEntityId(List<? extends EntityId> entityIds) {
			if (entityIds != null) {
				for (EntityId toAdd : entityIds) {
					this.entityId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalEntity.LegalEntityBuilder setEntityId(List<? extends EntityId> entityIds) {
			if (entityIds == null)  {
				this.entityId = new ArrayList<>();
			}
			else {
				this.entityId = entityIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public LegalEntity.LegalEntityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public LegalEntity build() {
			return new LegalEntity.LegalEntityImpl(this);
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder prune() {
			if (legalEntitySequence!=null && !legalEntitySequence.prune().hasData()) legalEntitySequence = null;
			entityId = entityId.stream().filter(b->b!=null).<EntityId.EntityIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLegalEntitySequence()!=null && getLegalEntitySequence().hasData()) return true;
			if (getEntityId()!=null && getEntityId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalEntity.LegalEntityBuilder o = (LegalEntity.LegalEntityBuilder) other;
			
			merger.mergeRosetta(getLegalEntitySequence(), o.getLegalEntitySequence(), this::setLegalEntitySequence);
			merger.mergeRosetta(getEntityId(), o.getEntityId(), this::getOrCreateEntityId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!Objects.equals(legalEntitySequence, _that.getLegalEntitySequence())) return false;
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legalEntitySequence != null ? legalEntitySequence.hashCode() : 0);
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntityBuilder {" +
				"legalEntitySequence=" + this.legalEntitySequence + ", " +
				"entityId=" + this.entityId + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
