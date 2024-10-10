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
import fpml.confirmation.IndexId;
import fpml.confirmation.IndexId.IndexIdBuilder;
import fpml.confirmation.IndexId.IndexIdBuilderImpl;
import fpml.confirmation.IndexId.IndexIdImpl;
import fpml.confirmation.meta.IndexIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="IndexId", builder=IndexId.IndexIdBuilderImpl.class, version="${project.version}")
public interface IndexId extends RosettaModelObject {

	IndexIdMeta metaData = new IndexIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getIndexIdScheme();

	/*********************** Build Methods  ***********************/
	IndexId build();
	
	IndexId.IndexIdBuilder toBuilder();
	
	static IndexId.IndexIdBuilder builder() {
		return new IndexId.IndexIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexId> getType() {
		return IndexId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("indexIdScheme"), String.class, getIndexIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexIdBuilder extends IndexId, RosettaModelObjectBuilder {
		IndexId.IndexIdBuilder setValue(String value);
		IndexId.IndexIdBuilder setIndexIdScheme(String indexIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("indexIdScheme"), String.class, getIndexIdScheme(), this);
		}
		

		IndexId.IndexIdBuilder prune();
	}

	/*********************** Immutable Implementation of IndexId  ***********************/
	class IndexIdImpl implements IndexId {
		private final String value;
		private final String indexIdScheme;
		
		protected IndexIdImpl(IndexId.IndexIdBuilder builder) {
			this.value = builder.getValue();
			this.indexIdScheme = builder.getIndexIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("indexIdScheme")
		public String getIndexIdScheme() {
			return indexIdScheme;
		}
		
		@Override
		public IndexId build() {
			return this;
		}
		
		@Override
		public IndexId.IndexIdBuilder toBuilder() {
			IndexId.IndexIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexId.IndexIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIndexIdScheme()).ifPresent(builder::setIndexIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexIdScheme, _that.getIndexIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexIdScheme != null ? indexIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexId {" +
				"value=" + this.value + ", " +
				"indexIdScheme=" + this.indexIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexId  ***********************/
	class IndexIdBuilderImpl implements IndexId.IndexIdBuilder {
	
		protected String value;
		protected String indexIdScheme;
	
		public IndexIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("indexIdScheme")
		public String getIndexIdScheme() {
			return indexIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public IndexId.IndexIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("indexIdScheme")
		public IndexId.IndexIdBuilder setIndexIdScheme(String indexIdScheme) {
			this.indexIdScheme = indexIdScheme==null?null:indexIdScheme;
			return this;
		}
		
		@Override
		public IndexId build() {
			return new IndexId.IndexIdImpl(this);
		}
		
		@Override
		public IndexId.IndexIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexId.IndexIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIndexIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexId.IndexIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexId.IndexIdBuilder o = (IndexId.IndexIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIndexIdScheme(), o.getIndexIdScheme(), this::setIndexIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexIdScheme, _that.getIndexIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexIdScheme != null ? indexIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexIdBuilder {" +
				"value=" + this.value + ", " +
				"indexIdScheme=" + this.indexIdScheme +
			'}';
		}
	}
}
