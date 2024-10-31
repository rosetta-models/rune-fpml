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
import fpml.confirmation.EntityName;
import fpml.confirmation.LegalEntitySequence;
import fpml.confirmation.LegalEntitySequence.LegalEntitySequenceBuilder;
import fpml.confirmation.LegalEntitySequence.LegalEntitySequenceBuilderImpl;
import fpml.confirmation.LegalEntitySequence.LegalEntitySequenceImpl;
import fpml.confirmation.meta.LegalEntitySequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LegalEntitySequence", builder=LegalEntitySequence.LegalEntitySequenceBuilderImpl.class, version="${project.version}")
public interface LegalEntitySequence extends RosettaModelObject {

	LegalEntitySequenceMeta metaData = new LegalEntitySequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the reference entity. A free format string. FpML does not define usage rules for this element.
	 */
	EntityName getEntityName();
	/**
	 * A legal entity identifier (e.g. RED entity code).
	 */
	List<? extends EntityId> getEntityId();

	/*********************** Build Methods  ***********************/
	LegalEntitySequence build();
	
	LegalEntitySequence.LegalEntitySequenceBuilder toBuilder();
	
	static LegalEntitySequence.LegalEntitySequenceBuilder builder() {
		return new LegalEntitySequence.LegalEntitySequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalEntitySequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LegalEntitySequence> getType() {
		return LegalEntitySequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("entityName"), processor, EntityName.class, getEntityName());
		processRosetta(path.newSubPath("entityId"), processor, EntityId.class, getEntityId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalEntitySequenceBuilder extends LegalEntitySequence, RosettaModelObjectBuilder {
		EntityName.EntityNameBuilder getOrCreateEntityName();
		EntityName.EntityNameBuilder getEntityName();
		EntityId.EntityIdBuilder getOrCreateEntityId(int _index);
		List<? extends EntityId.EntityIdBuilder> getEntityId();
		LegalEntitySequence.LegalEntitySequenceBuilder setEntityName(EntityName entityName);
		LegalEntitySequence.LegalEntitySequenceBuilder addEntityId(EntityId entityId0);
		LegalEntitySequence.LegalEntitySequenceBuilder addEntityId(EntityId entityId1, int _idx);
		LegalEntitySequence.LegalEntitySequenceBuilder addEntityId(List<? extends EntityId> entityId2);
		LegalEntitySequence.LegalEntitySequenceBuilder setEntityId(List<? extends EntityId> entityId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("entityName"), processor, EntityName.EntityNameBuilder.class, getEntityName());
			processRosetta(path.newSubPath("entityId"), processor, EntityId.EntityIdBuilder.class, getEntityId());
		}
		

		LegalEntitySequence.LegalEntitySequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LegalEntitySequence  ***********************/
	class LegalEntitySequenceImpl implements LegalEntitySequence {
		private final EntityName entityName;
		private final List<? extends EntityId> entityId;
		
		protected LegalEntitySequenceImpl(LegalEntitySequence.LegalEntitySequenceBuilder builder) {
			this.entityName = ofNullable(builder.getEntityName()).map(f->f.build()).orElse(null);
			this.entityId = ofNullable(builder.getEntityId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("entityName")
		public EntityName getEntityName() {
			return entityName;
		}
		
		@Override
		@RosettaAttribute("entityId")
		public List<? extends EntityId> getEntityId() {
			return entityId;
		}
		
		@Override
		public LegalEntitySequence build() {
			return this;
		}
		
		@Override
		public LegalEntitySequence.LegalEntitySequenceBuilder toBuilder() {
			LegalEntitySequence.LegalEntitySequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalEntitySequence.LegalEntitySequenceBuilder builder) {
			ofNullable(getEntityName()).ifPresent(builder::setEntityName);
			ofNullable(getEntityId()).ifPresent(builder::setEntityId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntitySequence _that = getType().cast(o);
		
			if (!Objects.equals(entityName, _that.getEntityName())) return false;
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityName != null ? entityName.hashCode() : 0);
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntitySequence {" +
				"entityName=" + this.entityName + ", " +
				"entityId=" + this.entityId +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalEntitySequence  ***********************/
	class LegalEntitySequenceBuilderImpl implements LegalEntitySequence.LegalEntitySequenceBuilder {
	
		protected EntityName.EntityNameBuilder entityName;
		protected List<EntityId.EntityIdBuilder> entityId = new ArrayList<>();
	
		public LegalEntitySequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("entityName")
		public EntityName.EntityNameBuilder getEntityName() {
			return entityName;
		}
		
		@Override
		public EntityName.EntityNameBuilder getOrCreateEntityName() {
			EntityName.EntityNameBuilder result;
			if (entityName!=null) {
				result = entityName;
			}
			else {
				result = entityName = EntityName.builder();
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
		@RosettaAttribute("entityName")
		public LegalEntitySequence.LegalEntitySequenceBuilder setEntityName(EntityName entityName) {
			this.entityName = entityName==null?null:entityName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("entityId")
		public LegalEntitySequence.LegalEntitySequenceBuilder addEntityId(EntityId entityId) {
			if (entityId!=null) this.entityId.add(entityId.toBuilder());
			return this;
		}
		
		@Override
		public LegalEntitySequence.LegalEntitySequenceBuilder addEntityId(EntityId entityId, int _idx) {
			getIndex(this.entityId, _idx, () -> entityId.toBuilder());
			return this;
		}
		@Override 
		public LegalEntitySequence.LegalEntitySequenceBuilder addEntityId(List<? extends EntityId> entityIds) {
			if (entityIds != null) {
				for (EntityId toAdd : entityIds) {
					this.entityId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalEntitySequence.LegalEntitySequenceBuilder setEntityId(List<? extends EntityId> entityIds) {
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
		public LegalEntitySequence build() {
			return new LegalEntitySequence.LegalEntitySequenceImpl(this);
		}
		
		@Override
		public LegalEntitySequence.LegalEntitySequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntitySequence.LegalEntitySequenceBuilder prune() {
			if (entityName!=null && !entityName.prune().hasData()) entityName = null;
			entityId = entityId.stream().filter(b->b!=null).<EntityId.EntityIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEntityName()!=null && getEntityName().hasData()) return true;
			if (getEntityId()!=null && getEntityId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntitySequence.LegalEntitySequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalEntitySequence.LegalEntitySequenceBuilder o = (LegalEntitySequence.LegalEntitySequenceBuilder) other;
			
			merger.mergeRosetta(getEntityName(), o.getEntityName(), this::setEntityName);
			merger.mergeRosetta(getEntityId(), o.getEntityId(), this::getOrCreateEntityId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntitySequence _that = getType().cast(o);
		
			if (!Objects.equals(entityName, _that.getEntityName())) return false;
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityName != null ? entityName.hashCode() : 0);
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntitySequenceBuilder {" +
				"entityName=" + this.entityName + ", " +
				"entityId=" + this.entityId +
			'}';
		}
	}
}
