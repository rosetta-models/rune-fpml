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
import fpml.confirmation.Document;
import fpml.confirmation.Document.DocumentBuilder;
import fpml.confirmation.Document.DocumentBuilderImpl;
import fpml.confirmation.Document.DocumentImpl;
import fpml.confirmation.meta.DocumentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The abstract base type from which all FpML compliant messages and documents must be derived.
 * @version ${project.version}
 */
@RosettaDataType(value="Document", builder=Document.DocumentBuilderImpl.class, version="${project.version}")
public interface Document extends RosettaModelObject {

	DocumentMeta metaData = new DocumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This optional attribute can be supplied by a message creator in an FpML instance to specify which build number of the schema was used to define the message when it was generated.
	 */
	Integer getExpectedBuild();
	/**
	 * The specific build number of this schema version. This attribute is not included in an instance document. Instead, it is supplied by the XML parser when the document is validated against the FpML schema and indicates the build number of the schema file. Every time FpML publishes a change to the schema, validation rules, or examples within a version (e.g., version 4.2) the actual build number is incremented. If no changes have been made between releases within a version (i.e. from Trial Recommendation to Recommendation) the actual build number stays the same.
	 */
	Integer getActualBuild();

	/*********************** Build Methods  ***********************/
	Document build();
	
	Document.DocumentBuilder toBuilder();
	
	static Document.DocumentBuilder builder() {
		return new Document.DocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Document> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Document> getType() {
		return Document.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentBuilder extends Document, RosettaModelObjectBuilder {
		Document.DocumentBuilder setExpectedBuild(Integer expectedBuild);
		Document.DocumentBuilder setActualBuild(Integer actualBuild);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		}
		

		Document.DocumentBuilder prune();
	}

	/*********************** Immutable Implementation of Document  ***********************/
	class DocumentImpl implements Document {
		private final Integer expectedBuild;
		private final Integer actualBuild;
		
		protected DocumentImpl(Document.DocumentBuilder builder) {
			this.expectedBuild = builder.getExpectedBuild();
			this.actualBuild = builder.getActualBuild();
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public Integer getExpectedBuild() {
			return expectedBuild;
		}
		
		@Override
		@RosettaAttribute("actualBuild")
		public Integer getActualBuild() {
			return actualBuild;
		}
		
		@Override
		public Document build() {
			return this;
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			Document.DocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Document.DocumentBuilder builder) {
			ofNullable(getExpectedBuild()).ifPresent(builder::setExpectedBuild);
			ofNullable(getActualBuild()).ifPresent(builder::setActualBuild);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(expectedBuild, _that.getExpectedBuild())) return false;
			if (!Objects.equals(actualBuild, _that.getActualBuild())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expectedBuild != null ? expectedBuild.hashCode() : 0);
			_result = 31 * _result + (actualBuild != null ? actualBuild.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Document {" +
				"expectedBuild=" + this.expectedBuild + ", " +
				"actualBuild=" + this.actualBuild +
			'}';
		}
	}

	/*********************** Builder Implementation of Document  ***********************/
	class DocumentBuilderImpl implements Document.DocumentBuilder {
	
		protected Integer expectedBuild;
		protected Integer actualBuild;
	
		public DocumentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public Integer getExpectedBuild() {
			return expectedBuild;
		}
		
		@Override
		@RosettaAttribute("actualBuild")
		public Integer getActualBuild() {
			return actualBuild;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public Document.DocumentBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public Document.DocumentBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		
		@Override
		public Document build() {
			return new Document.DocumentImpl(this);
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExpectedBuild()!=null) return true;
			if (getActualBuild()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Document.DocumentBuilder o = (Document.DocumentBuilder) other;
			
			
			merger.mergeBasic(getExpectedBuild(), o.getExpectedBuild(), this::setExpectedBuild);
			merger.mergeBasic(getActualBuild(), o.getActualBuild(), this::setActualBuild);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(expectedBuild, _that.getExpectedBuild())) return false;
			if (!Objects.equals(actualBuild, _that.getActualBuild())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expectedBuild != null ? expectedBuild.hashCode() : 0);
			_result = 31 * _result + (actualBuild != null ? actualBuild.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentBuilder {" +
				"expectedBuild=" + this.expectedBuild + ", " +
				"actualBuild=" + this.actualBuild +
			'}';
		}
	}
}
