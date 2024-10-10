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
import fpml.confirmation.IndexAnnexSource;
import fpml.confirmation.IndexAnnexSource.IndexAnnexSourceBuilder;
import fpml.confirmation.IndexAnnexSource.IndexAnnexSourceBuilderImpl;
import fpml.confirmation.IndexAnnexSource.IndexAnnexSourceImpl;
import fpml.confirmation.meta.IndexAnnexSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="IndexAnnexSource", builder=IndexAnnexSource.IndexAnnexSourceBuilderImpl.class, version="${project.version}")
public interface IndexAnnexSource extends RosettaModelObject {

	IndexAnnexSourceMeta metaData = new IndexAnnexSourceMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getIndexAnnexSourceScheme();

	/*********************** Build Methods  ***********************/
	IndexAnnexSource build();
	
	IndexAnnexSource.IndexAnnexSourceBuilder toBuilder();
	
	static IndexAnnexSource.IndexAnnexSourceBuilder builder() {
		return new IndexAnnexSource.IndexAnnexSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexAnnexSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexAnnexSource> getType() {
		return IndexAnnexSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("indexAnnexSourceScheme"), String.class, getIndexAnnexSourceScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexAnnexSourceBuilder extends IndexAnnexSource, RosettaModelObjectBuilder {
		IndexAnnexSource.IndexAnnexSourceBuilder setValue(String value);
		IndexAnnexSource.IndexAnnexSourceBuilder setIndexAnnexSourceScheme(String indexAnnexSourceScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("indexAnnexSourceScheme"), String.class, getIndexAnnexSourceScheme(), this);
		}
		

		IndexAnnexSource.IndexAnnexSourceBuilder prune();
	}

	/*********************** Immutable Implementation of IndexAnnexSource  ***********************/
	class IndexAnnexSourceImpl implements IndexAnnexSource {
		private final String value;
		private final String indexAnnexSourceScheme;
		
		protected IndexAnnexSourceImpl(IndexAnnexSource.IndexAnnexSourceBuilder builder) {
			this.value = builder.getValue();
			this.indexAnnexSourceScheme = builder.getIndexAnnexSourceScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSourceScheme")
		public String getIndexAnnexSourceScheme() {
			return indexAnnexSourceScheme;
		}
		
		@Override
		public IndexAnnexSource build() {
			return this;
		}
		
		@Override
		public IndexAnnexSource.IndexAnnexSourceBuilder toBuilder() {
			IndexAnnexSource.IndexAnnexSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexAnnexSource.IndexAnnexSourceBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIndexAnnexSourceScheme()).ifPresent(builder::setIndexAnnexSourceScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAnnexSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexAnnexSourceScheme, _that.getIndexAnnexSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSourceScheme != null ? indexAnnexSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAnnexSource {" +
				"value=" + this.value + ", " +
				"indexAnnexSourceScheme=" + this.indexAnnexSourceScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexAnnexSource  ***********************/
	class IndexAnnexSourceBuilderImpl implements IndexAnnexSource.IndexAnnexSourceBuilder {
	
		protected String value;
		protected String indexAnnexSourceScheme;
	
		public IndexAnnexSourceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSourceScheme")
		public String getIndexAnnexSourceScheme() {
			return indexAnnexSourceScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public IndexAnnexSource.IndexAnnexSourceBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("indexAnnexSourceScheme")
		public IndexAnnexSource.IndexAnnexSourceBuilder setIndexAnnexSourceScheme(String indexAnnexSourceScheme) {
			this.indexAnnexSourceScheme = indexAnnexSourceScheme==null?null:indexAnnexSourceScheme;
			return this;
		}
		
		@Override
		public IndexAnnexSource build() {
			return new IndexAnnexSource.IndexAnnexSourceImpl(this);
		}
		
		@Override
		public IndexAnnexSource.IndexAnnexSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAnnexSource.IndexAnnexSourceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIndexAnnexSourceScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAnnexSource.IndexAnnexSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexAnnexSource.IndexAnnexSourceBuilder o = (IndexAnnexSource.IndexAnnexSourceBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIndexAnnexSourceScheme(), o.getIndexAnnexSourceScheme(), this::setIndexAnnexSourceScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAnnexSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexAnnexSourceScheme, _that.getIndexAnnexSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSourceScheme != null ? indexAnnexSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAnnexSourceBuilder {" +
				"value=" + this.value + ", " +
				"indexAnnexSourceScheme=" + this.indexAnnexSourceScheme +
			'}';
		}
	}
}
