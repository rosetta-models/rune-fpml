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
import fpml.confirmation.ResourceType;
import fpml.confirmation.ResourceType.ResourceTypeBuilder;
import fpml.confirmation.ResourceType.ResourceTypeBuilderImpl;
import fpml.confirmation.ResourceType.ResourceTypeImpl;
import fpml.confirmation.meta.ResourceTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for describing the type or purpose of a resource, e.g. &quot;Confirmation&quot;.
 * @version ${project.version}
 */
@RosettaDataType(value="ResourceType", builder=ResourceType.ResourceTypeBuilderImpl.class, version="${project.version}")
public interface ResourceType extends RosettaModelObject {

	ResourceTypeMeta metaData = new ResourceTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getResourceTypeScheme();

	/*********************** Build Methods  ***********************/
	ResourceType build();
	
	ResourceType.ResourceTypeBuilder toBuilder();
	
	static ResourceType.ResourceTypeBuilder builder() {
		return new ResourceType.ResourceTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResourceType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ResourceType> getType() {
		return ResourceType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("resourceTypeScheme"), String.class, getResourceTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResourceTypeBuilder extends ResourceType, RosettaModelObjectBuilder {
		ResourceType.ResourceTypeBuilder setValue(String value);
		ResourceType.ResourceTypeBuilder setResourceTypeScheme(String resourceTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("resourceTypeScheme"), String.class, getResourceTypeScheme(), this);
		}
		

		ResourceType.ResourceTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ResourceType  ***********************/
	class ResourceTypeImpl implements ResourceType {
		private final String value;
		private final String resourceTypeScheme;
		
		protected ResourceTypeImpl(ResourceType.ResourceTypeBuilder builder) {
			this.value = builder.getValue();
			this.resourceTypeScheme = builder.getResourceTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("resourceTypeScheme")
		public String getResourceTypeScheme() {
			return resourceTypeScheme;
		}
		
		@Override
		public ResourceType build() {
			return this;
		}
		
		@Override
		public ResourceType.ResourceTypeBuilder toBuilder() {
			ResourceType.ResourceTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResourceType.ResourceTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getResourceTypeScheme()).ifPresent(builder::setResourceTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResourceType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(resourceTypeScheme, _that.getResourceTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (resourceTypeScheme != null ? resourceTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceType {" +
				"value=" + this.value + ", " +
				"resourceTypeScheme=" + this.resourceTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ResourceType  ***********************/
	class ResourceTypeBuilderImpl implements ResourceType.ResourceTypeBuilder {
	
		protected String value;
		protected String resourceTypeScheme;
	
		public ResourceTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("resourceTypeScheme")
		public String getResourceTypeScheme() {
			return resourceTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ResourceType.ResourceTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("resourceTypeScheme")
		public ResourceType.ResourceTypeBuilder setResourceTypeScheme(String resourceTypeScheme) {
			this.resourceTypeScheme = resourceTypeScheme==null?null:resourceTypeScheme;
			return this;
		}
		
		@Override
		public ResourceType build() {
			return new ResourceType.ResourceTypeImpl(this);
		}
		
		@Override
		public ResourceType.ResourceTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResourceType.ResourceTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getResourceTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResourceType.ResourceTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResourceType.ResourceTypeBuilder o = (ResourceType.ResourceTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getResourceTypeScheme(), o.getResourceTypeScheme(), this::setResourceTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResourceType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(resourceTypeScheme, _that.getResourceTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (resourceTypeScheme != null ? resourceTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceTypeBuilder {" +
				"value=" + this.value + ", " +
				"resourceTypeScheme=" + this.resourceTypeScheme +
			'}';
		}
	}
}
