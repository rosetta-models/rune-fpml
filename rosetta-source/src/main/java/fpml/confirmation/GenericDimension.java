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
import fpml.confirmation.GenericDimension;
import fpml.confirmation.GenericDimension.GenericDimensionBuilder;
import fpml.confirmation.GenericDimension.GenericDimensionBuilderImpl;
import fpml.confirmation.GenericDimension.GenericDimensionImpl;
import fpml.confirmation.meta.GenericDimensionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A generic (user defined) dimension, e.g. for use in a correlation surface. e.g. a currency, stock, etc. This would take values like USD, GBP, JPY, or IBM, MSFT, etc.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GenericDimension", builder=GenericDimension.GenericDimensionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GenericDimension extends RosettaModelObject {

	GenericDimensionMeta metaData = new GenericDimensionMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * The name of the dimension. E.g.: &quot;Currency&quot;, &quot;Stock&quot;, &quot;Issuer&quot;, etc.
	 */
	String getName();
	/**
	 * A reference to an instrument (e.g. currency) that this value represents.
	 */
	String getHref();

	/*********************** Build Methods  ***********************/
	GenericDimension build();
	
	GenericDimension.GenericDimensionBuilder toBuilder();
	
	static GenericDimension.GenericDimensionBuilder builder() {
		return new GenericDimension.GenericDimensionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericDimension> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericDimension> getType() {
		return GenericDimension.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericDimensionBuilder extends GenericDimension, RosettaModelObjectBuilder {
		GenericDimension.GenericDimensionBuilder setValue(String value);
		GenericDimension.GenericDimensionBuilder setName(String name);
		GenericDimension.GenericDimensionBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		GenericDimension.GenericDimensionBuilder prune();
	}

	/*********************** Immutable Implementation of GenericDimension  ***********************/
	class GenericDimensionImpl implements GenericDimension {
		private final String value;
		private final String name;
		private final String href;
		
		protected GenericDimensionImpl(GenericDimension.GenericDimensionBuilder builder) {
			this.value = builder.getValue();
			this.name = builder.getName();
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public GenericDimension build() {
			return this;
		}
		
		@Override
		public GenericDimension.GenericDimensionBuilder toBuilder() {
			GenericDimension.GenericDimensionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericDimension.GenericDimensionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericDimension _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericDimension {" +
				"value=" + this.value + ", " +
				"name=" + this.name + ", " +
				"href=" + this.href +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericDimension  ***********************/
	class GenericDimensionBuilderImpl implements GenericDimension.GenericDimensionBuilder {
	
		protected String value;
		protected String name;
		protected String href;
	
		public GenericDimensionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("value")
		public GenericDimension.GenericDimensionBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("name")
		public GenericDimension.GenericDimensionBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("href")
		public GenericDimension.GenericDimensionBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public GenericDimension build() {
			return new GenericDimension.GenericDimensionImpl(this);
		}
		
		@Override
		public GenericDimension.GenericDimensionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericDimension.GenericDimensionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getName()!=null) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericDimension.GenericDimensionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericDimension.GenericDimensionBuilder o = (GenericDimension.GenericDimensionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericDimension _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericDimensionBuilder {" +
				"value=" + this.value + ", " +
				"name=" + this.name + ", " +
				"href=" + this.href +
			'}';
		}
	}
}
