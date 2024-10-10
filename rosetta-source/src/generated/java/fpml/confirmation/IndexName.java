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
import fpml.confirmation.IndexName;
import fpml.confirmation.IndexName.IndexNameBuilder;
import fpml.confirmation.IndexName.IndexNameBuilderImpl;
import fpml.confirmation.IndexName.IndexNameImpl;
import fpml.confirmation.meta.IndexNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="IndexName", builder=IndexName.IndexNameBuilderImpl.class, version="${project.version}")
public interface IndexName extends RosettaModelObject {

	IndexNameMeta metaData = new IndexNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getIndexNameScheme();

	/*********************** Build Methods  ***********************/
	IndexName build();
	
	IndexName.IndexNameBuilder toBuilder();
	
	static IndexName.IndexNameBuilder builder() {
		return new IndexName.IndexNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexName> getType() {
		return IndexName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("indexNameScheme"), String.class, getIndexNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexNameBuilder extends IndexName, RosettaModelObjectBuilder {
		IndexName.IndexNameBuilder setValue(String value);
		IndexName.IndexNameBuilder setIndexNameScheme(String indexNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("indexNameScheme"), String.class, getIndexNameScheme(), this);
		}
		

		IndexName.IndexNameBuilder prune();
	}

	/*********************** Immutable Implementation of IndexName  ***********************/
	class IndexNameImpl implements IndexName {
		private final String value;
		private final String indexNameScheme;
		
		protected IndexNameImpl(IndexName.IndexNameBuilder builder) {
			this.value = builder.getValue();
			this.indexNameScheme = builder.getIndexNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("indexNameScheme")
		public String getIndexNameScheme() {
			return indexNameScheme;
		}
		
		@Override
		public IndexName build() {
			return this;
		}
		
		@Override
		public IndexName.IndexNameBuilder toBuilder() {
			IndexName.IndexNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexName.IndexNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIndexNameScheme()).ifPresent(builder::setIndexNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexNameScheme, _that.getIndexNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexNameScheme != null ? indexNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexName {" +
				"value=" + this.value + ", " +
				"indexNameScheme=" + this.indexNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexName  ***********************/
	class IndexNameBuilderImpl implements IndexName.IndexNameBuilder {
	
		protected String value;
		protected String indexNameScheme;
	
		public IndexNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("indexNameScheme")
		public String getIndexNameScheme() {
			return indexNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public IndexName.IndexNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("indexNameScheme")
		public IndexName.IndexNameBuilder setIndexNameScheme(String indexNameScheme) {
			this.indexNameScheme = indexNameScheme==null?null:indexNameScheme;
			return this;
		}
		
		@Override
		public IndexName build() {
			return new IndexName.IndexNameImpl(this);
		}
		
		@Override
		public IndexName.IndexNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexName.IndexNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIndexNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexName.IndexNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexName.IndexNameBuilder o = (IndexName.IndexNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIndexNameScheme(), o.getIndexNameScheme(), this::setIndexNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexNameScheme, _that.getIndexNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexNameScheme != null ? indexNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexNameBuilder {" +
				"value=" + this.value + ", " +
				"indexNameScheme=" + this.indexNameScheme +
			'}';
		}
	}
}
