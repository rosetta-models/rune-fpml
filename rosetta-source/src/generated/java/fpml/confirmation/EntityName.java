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
import fpml.confirmation.EntityName;
import fpml.confirmation.EntityName.EntityNameBuilder;
import fpml.confirmation.EntityName.EntityNameBuilderImpl;
import fpml.confirmation.EntityName.EntityNameImpl;
import fpml.confirmation.meta.EntityNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The name of the reference entity. A free format string. FpML does not define usage rules for this element.
 * @version ${project.version}
 */
@RosettaDataType(value="EntityName", builder=EntityName.EntityNameBuilderImpl.class, version="${project.version}")
public interface EntityName extends RosettaModelObject {

	EntityNameMeta metaData = new EntityNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getEntityNameScheme();

	/*********************** Build Methods  ***********************/
	EntityName build();
	
	EntityName.EntityNameBuilder toBuilder();
	
	static EntityName.EntityNameBuilder builder() {
		return new EntityName.EntityNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EntityName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EntityName> getType() {
		return EntityName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("entityNameScheme"), String.class, getEntityNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EntityNameBuilder extends EntityName, RosettaModelObjectBuilder {
		EntityName.EntityNameBuilder setValue(String value);
		EntityName.EntityNameBuilder setEntityNameScheme(String entityNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("entityNameScheme"), String.class, getEntityNameScheme(), this);
		}
		

		EntityName.EntityNameBuilder prune();
	}

	/*********************** Immutable Implementation of EntityName  ***********************/
	class EntityNameImpl implements EntityName {
		private final String value;
		private final String entityNameScheme;
		
		protected EntityNameImpl(EntityName.EntityNameBuilder builder) {
			this.value = builder.getValue();
			this.entityNameScheme = builder.getEntityNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityNameScheme")
		public String getEntityNameScheme() {
			return entityNameScheme;
		}
		
		@Override
		public EntityName build() {
			return this;
		}
		
		@Override
		public EntityName.EntityNameBuilder toBuilder() {
			EntityName.EntityNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EntityName.EntityNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEntityNameScheme()).ifPresent(builder::setEntityNameScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityNameScheme, _that.getEntityNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityNameScheme != null ? entityNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityName {" +
				"value=" + this.value + ", " +
				"entityNameScheme=" + this.entityNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EntityName  ***********************/
	class EntityNameBuilderImpl implements EntityName.EntityNameBuilder {
	
		protected String value;
		protected String entityNameScheme;
	
		public EntityNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityNameScheme")
		public String getEntityNameScheme() {
			return entityNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public EntityName.EntityNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("entityNameScheme")
		public EntityName.EntityNameBuilder setEntityNameScheme(String entityNameScheme) {
			this.entityNameScheme = entityNameScheme==null?null:entityNameScheme;
			return this;
		}
		
		@Override
		public EntityName build() {
			return new EntityName.EntityNameImpl(this);
		}
		
		@Override
		public EntityName.EntityNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityName.EntityNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEntityNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityName.EntityNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EntityName.EntityNameBuilder o = (EntityName.EntityNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEntityNameScheme(), o.getEntityNameScheme(), this::setEntityNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityNameScheme, _that.getEntityNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityNameScheme != null ? entityNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityNameBuilder {" +
				"value=" + this.value + ", " +
				"entityNameScheme=" + this.entityNameScheme +
			'}';
		}
	}
}
