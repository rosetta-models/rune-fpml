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
import fpml.confirmation.ResourceId;
import fpml.confirmation.ResourceId.ResourceIdBuilder;
import fpml.confirmation.ResourceId.ResourceIdBuilderImpl;
import fpml.confirmation.ResourceId.ResourceIdImpl;
import fpml.confirmation.meta.ResourceIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for resource identifiers.
 * @version ${project.version}
 */
@RosettaDataType(value="ResourceId", builder=ResourceId.ResourceIdBuilderImpl.class, version="${project.version}")
public interface ResourceId extends RosettaModelObject {

	ResourceIdMeta metaData = new ResourceIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getResourceIdScheme();

	/*********************** Build Methods  ***********************/
	ResourceId build();
	
	ResourceId.ResourceIdBuilder toBuilder();
	
	static ResourceId.ResourceIdBuilder builder() {
		return new ResourceId.ResourceIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResourceId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ResourceId> getType() {
		return ResourceId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("resourceIdScheme"), String.class, getResourceIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResourceIdBuilder extends ResourceId, RosettaModelObjectBuilder {
		ResourceId.ResourceIdBuilder setValue(String value);
		ResourceId.ResourceIdBuilder setResourceIdScheme(String resourceIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("resourceIdScheme"), String.class, getResourceIdScheme(), this);
		}
		

		ResourceId.ResourceIdBuilder prune();
	}

	/*********************** Immutable Implementation of ResourceId  ***********************/
	class ResourceIdImpl implements ResourceId {
		private final String value;
		private final String resourceIdScheme;
		
		protected ResourceIdImpl(ResourceId.ResourceIdBuilder builder) {
			this.value = builder.getValue();
			this.resourceIdScheme = builder.getResourceIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("resourceIdScheme")
		public String getResourceIdScheme() {
			return resourceIdScheme;
		}
		
		@Override
		public ResourceId build() {
			return this;
		}
		
		@Override
		public ResourceId.ResourceIdBuilder toBuilder() {
			ResourceId.ResourceIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResourceId.ResourceIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getResourceIdScheme()).ifPresent(builder::setResourceIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResourceId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(resourceIdScheme, _that.getResourceIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (resourceIdScheme != null ? resourceIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceId {" +
				"value=" + this.value + ", " +
				"resourceIdScheme=" + this.resourceIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ResourceId  ***********************/
	class ResourceIdBuilderImpl implements ResourceId.ResourceIdBuilder {
	
		protected String value;
		protected String resourceIdScheme;
	
		public ResourceIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("resourceIdScheme")
		public String getResourceIdScheme() {
			return resourceIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ResourceId.ResourceIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("resourceIdScheme")
		public ResourceId.ResourceIdBuilder setResourceIdScheme(String resourceIdScheme) {
			this.resourceIdScheme = resourceIdScheme==null?null:resourceIdScheme;
			return this;
		}
		
		@Override
		public ResourceId build() {
			return new ResourceId.ResourceIdImpl(this);
		}
		
		@Override
		public ResourceId.ResourceIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResourceId.ResourceIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getResourceIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResourceId.ResourceIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResourceId.ResourceIdBuilder o = (ResourceId.ResourceIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getResourceIdScheme(), o.getResourceIdScheme(), this::setResourceIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResourceId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(resourceIdScheme, _that.getResourceIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (resourceIdScheme != null ? resourceIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceIdBuilder {" +
				"value=" + this.value + ", " +
				"resourceIdScheme=" + this.resourceIdScheme +
			'}';
		}
	}
}
