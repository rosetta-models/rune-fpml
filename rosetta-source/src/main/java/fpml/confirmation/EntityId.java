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
import fpml.confirmation.EntityId;
import fpml.confirmation.EntityId.EntityIdBuilder;
import fpml.confirmation.EntityId.EntityIdBuilderImpl;
import fpml.confirmation.EntityId.EntityIdImpl;
import fpml.confirmation.meta.EntityIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A legal entity identifier (e.g. RED entity code).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EntityId", builder=EntityId.EntityIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EntityId extends RosettaModelObject {

	EntityIdMeta metaData = new EntityIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getEntityIdScheme();

	/*********************** Build Methods  ***********************/
	EntityId build();
	
	EntityId.EntityIdBuilder toBuilder();
	
	static EntityId.EntityIdBuilder builder() {
		return new EntityId.EntityIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EntityId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EntityId> getType() {
		return EntityId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("entityIdScheme"), String.class, getEntityIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EntityIdBuilder extends EntityId, RosettaModelObjectBuilder {
		EntityId.EntityIdBuilder setValue(String value);
		EntityId.EntityIdBuilder setEntityIdScheme(String entityIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("entityIdScheme"), String.class, getEntityIdScheme(), this);
		}
		

		EntityId.EntityIdBuilder prune();
	}

	/*********************** Immutable Implementation of EntityId  ***********************/
	class EntityIdImpl implements EntityId {
		private final String value;
		private final String entityIdScheme;
		
		protected EntityIdImpl(EntityId.EntityIdBuilder builder) {
			this.value = builder.getValue();
			this.entityIdScheme = builder.getEntityIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityIdScheme")
		public String getEntityIdScheme() {
			return entityIdScheme;
		}
		
		@Override
		public EntityId build() {
			return this;
		}
		
		@Override
		public EntityId.EntityIdBuilder toBuilder() {
			EntityId.EntityIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EntityId.EntityIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEntityIdScheme()).ifPresent(builder::setEntityIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityIdScheme, _that.getEntityIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityIdScheme != null ? entityIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityId {" +
				"value=" + this.value + ", " +
				"entityIdScheme=" + this.entityIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EntityId  ***********************/
	class EntityIdBuilderImpl implements EntityId.EntityIdBuilder {
	
		protected String value;
		protected String entityIdScheme;
	
		public EntityIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityIdScheme")
		public String getEntityIdScheme() {
			return entityIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public EntityId.EntityIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("entityIdScheme")
		public EntityId.EntityIdBuilder setEntityIdScheme(String entityIdScheme) {
			this.entityIdScheme = entityIdScheme==null?null:entityIdScheme;
			return this;
		}
		
		@Override
		public EntityId build() {
			return new EntityId.EntityIdImpl(this);
		}
		
		@Override
		public EntityId.EntityIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityId.EntityIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEntityIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityId.EntityIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EntityId.EntityIdBuilder o = (EntityId.EntityIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEntityIdScheme(), o.getEntityIdScheme(), this::setEntityIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityIdScheme, _that.getEntityIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityIdScheme != null ? entityIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityIdBuilder {" +
				"value=" + this.value + ", " +
				"entityIdScheme=" + this.entityIdScheme +
			'}';
		}
	}
}
