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
import fpml.confirmation.EntityType;
import fpml.confirmation.EntityType.EntityTypeBuilder;
import fpml.confirmation.EntityType.EntityTypeBuilderImpl;
import fpml.confirmation.EntityType.EntityTypeImpl;
import fpml.confirmation.meta.EntityTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a coding scheme of the entity types defined in the ISDA First to Default documentation.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EntityType", builder=EntityType.EntityTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EntityType extends RosettaModelObject {

	EntityTypeMeta metaData = new EntityTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getEntityTypeScheme();

	/*********************** Build Methods  ***********************/
	EntityType build();
	
	EntityType.EntityTypeBuilder toBuilder();
	
	static EntityType.EntityTypeBuilder builder() {
		return new EntityType.EntityTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EntityType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EntityType> getType() {
		return EntityType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("entityTypeScheme"), String.class, getEntityTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EntityTypeBuilder extends EntityType, RosettaModelObjectBuilder {
		EntityType.EntityTypeBuilder setValue(String value);
		EntityType.EntityTypeBuilder setEntityTypeScheme(String entityTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("entityTypeScheme"), String.class, getEntityTypeScheme(), this);
		}
		

		EntityType.EntityTypeBuilder prune();
	}

	/*********************** Immutable Implementation of EntityType  ***********************/
	class EntityTypeImpl implements EntityType {
		private final String value;
		private final String entityTypeScheme;
		
		protected EntityTypeImpl(EntityType.EntityTypeBuilder builder) {
			this.value = builder.getValue();
			this.entityTypeScheme = builder.getEntityTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityTypeScheme")
		public String getEntityTypeScheme() {
			return entityTypeScheme;
		}
		
		@Override
		public EntityType build() {
			return this;
		}
		
		@Override
		public EntityType.EntityTypeBuilder toBuilder() {
			EntityType.EntityTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EntityType.EntityTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEntityTypeScheme()).ifPresent(builder::setEntityTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityTypeScheme, _that.getEntityTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityTypeScheme != null ? entityTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityType {" +
				"value=" + this.value + ", " +
				"entityTypeScheme=" + this.entityTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EntityType  ***********************/
	class EntityTypeBuilderImpl implements EntityType.EntityTypeBuilder {
	
		protected String value;
		protected String entityTypeScheme;
	
		public EntityTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityTypeScheme")
		public String getEntityTypeScheme() {
			return entityTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public EntityType.EntityTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("entityTypeScheme")
		public EntityType.EntityTypeBuilder setEntityTypeScheme(String entityTypeScheme) {
			this.entityTypeScheme = entityTypeScheme==null?null:entityTypeScheme;
			return this;
		}
		
		@Override
		public EntityType build() {
			return new EntityType.EntityTypeImpl(this);
		}
		
		@Override
		public EntityType.EntityTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityType.EntityTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEntityTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityType.EntityTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EntityType.EntityTypeBuilder o = (EntityType.EntityTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEntityTypeScheme(), o.getEntityTypeScheme(), this::setEntityTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityTypeScheme, _that.getEntityTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityTypeScheme != null ? entityTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityTypeBuilder {" +
				"value=" + this.value + ", " +
				"entityTypeScheme=" + this.entityTypeScheme +
			'}';
		}
	}
}
