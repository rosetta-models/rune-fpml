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
import fpml.confirmation.ImplementationSpecificationVersion;
import fpml.confirmation.ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder;
import fpml.confirmation.ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilderImpl;
import fpml.confirmation.ImplementationSpecificationVersion.ImplementationSpecificationVersionImpl;
import fpml.confirmation.meta.ImplementationSpecificationVersionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ImplementationSpecificationVersion", builder=ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilderImpl.class, version="${project.version}")
public interface ImplementationSpecificationVersion extends RosettaModelObject {

	ImplementationSpecificationVersionMeta metaData = new ImplementationSpecificationVersionMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getImplementationSpecificationVersionScheme();

	/*********************** Build Methods  ***********************/
	ImplementationSpecificationVersion build();
	
	ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder toBuilder();
	
	static ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder builder() {
		return new ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ImplementationSpecificationVersion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ImplementationSpecificationVersion> getType() {
		return ImplementationSpecificationVersion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("implementationSpecificationVersionScheme"), String.class, getImplementationSpecificationVersionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ImplementationSpecificationVersionBuilder extends ImplementationSpecificationVersion, RosettaModelObjectBuilder {
		ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder setValue(String value);
		ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder setImplementationSpecificationVersionScheme(String implementationSpecificationVersionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("implementationSpecificationVersionScheme"), String.class, getImplementationSpecificationVersionScheme(), this);
		}
		

		ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder prune();
	}

	/*********************** Immutable Implementation of ImplementationSpecificationVersion  ***********************/
	class ImplementationSpecificationVersionImpl implements ImplementationSpecificationVersion {
		private final String value;
		private final String implementationSpecificationVersionScheme;
		
		protected ImplementationSpecificationVersionImpl(ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder builder) {
			this.value = builder.getValue();
			this.implementationSpecificationVersionScheme = builder.getImplementationSpecificationVersionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("implementationSpecificationVersionScheme")
		public String getImplementationSpecificationVersionScheme() {
			return implementationSpecificationVersionScheme;
		}
		
		@Override
		public ImplementationSpecificationVersion build() {
			return this;
		}
		
		@Override
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder toBuilder() {
			ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getImplementationSpecificationVersionScheme()).ifPresent(builder::setImplementationSpecificationVersionScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ImplementationSpecificationVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(implementationSpecificationVersionScheme, _that.getImplementationSpecificationVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (implementationSpecificationVersionScheme != null ? implementationSpecificationVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ImplementationSpecificationVersion {" +
				"value=" + this.value + ", " +
				"implementationSpecificationVersionScheme=" + this.implementationSpecificationVersionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ImplementationSpecificationVersion  ***********************/
	class ImplementationSpecificationVersionBuilderImpl implements ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder {
	
		protected String value;
		protected String implementationSpecificationVersionScheme;
	
		public ImplementationSpecificationVersionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("implementationSpecificationVersionScheme")
		public String getImplementationSpecificationVersionScheme() {
			return implementationSpecificationVersionScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("implementationSpecificationVersionScheme")
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder setImplementationSpecificationVersionScheme(String implementationSpecificationVersionScheme) {
			this.implementationSpecificationVersionScheme = implementationSpecificationVersionScheme==null?null:implementationSpecificationVersionScheme;
			return this;
		}
		
		@Override
		public ImplementationSpecificationVersion build() {
			return new ImplementationSpecificationVersion.ImplementationSpecificationVersionImpl(this);
		}
		
		@Override
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getImplementationSpecificationVersionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder o = (ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getImplementationSpecificationVersionScheme(), o.getImplementationSpecificationVersionScheme(), this::setImplementationSpecificationVersionScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ImplementationSpecificationVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(implementationSpecificationVersionScheme, _that.getImplementationSpecificationVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (implementationSpecificationVersionScheme != null ? implementationSpecificationVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ImplementationSpecificationVersionBuilder {" +
				"value=" + this.value + ", " +
				"implementationSpecificationVersionScheme=" + this.implementationSpecificationVersionScheme +
			'}';
		}
	}
}
