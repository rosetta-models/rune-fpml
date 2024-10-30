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
import fpml.confirmation.Language;
import fpml.confirmation.MimeType;
import fpml.confirmation.Resource;
import fpml.confirmation.Resource.ResourceBuilder;
import fpml.confirmation.Resource.ResourceBuilderImpl;
import fpml.confirmation.Resource.ResourceImpl;
import fpml.confirmation.ResourceId;
import fpml.confirmation.ResourceLength;
import fpml.confirmation.ResourceType;
import fpml.confirmation.meta.ResourceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the resource that contains the media representation of a business event (i.e used for stating the Publicly Available Information). For example, can describe a file or a URL that represents the event. This type is an extended version of a type defined by RIXML (www.rixml.org).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Resource", builder=Resource.ResourceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Resource extends RosettaModelObject {

	ResourceMeta metaData = new ResourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The unique identifier of the resource within the event.
	 */
	ResourceId getResourceId();
	/**
	 * A description of the type of the resource, e.g. a confirmation.
	 */
	ResourceType getResourceType();
	/**
	 * Indicates the language of the resource, described using the ISO 639-2/T Code.
	 */
	Language getLanguage();
	/**
	 * Indicates the size of the resource in bytes. It could be used by the end user to estimate the download time and storage needs.
	 */
	BigDecimal getSizeInBytes();
	/**
	 * Indicates the length of the resource. For example, if the resource were a PDF file, the length would be in pages.
	 */
	ResourceLength getLength();
	/**
	 * Indicates the type of media used to store the content. mimeType is used to determine the software product(s) that can read the content. MIME Types are described in RFC 2046.
	 */
	MimeType getMimeType();
	/**
	 * The name of the resource.
	 */
	String getName();
	/**
	 * Any additional comments that are deemed necessary. For example, which software version is required to open the document? Or, how does this resource relate to the others for this event?
	 */
	String getComments();
	/**
	 * Provides extra information as string. In case the extra information is in XML format, a CDATA section must be placed around the source message to prevent its interpretation as XML content.
	 */
	String getString();
	/**
	 * Provides extra information as binary contents coded in hexadecimal.
	 */
	String getHexadecimalBinary();
	/**
	 * Provides extra information as binary contents coded in base64.
	 */
	String getBase64Binary();
	/**
	 * Indicates where the resource can be found, as a URL that references the information on a web server accessible to the message recipient.
	 */
	String getUrl();

	/*********************** Build Methods  ***********************/
	Resource build();
	
	Resource.ResourceBuilder toBuilder();
	
	static Resource.ResourceBuilder builder() {
		return new Resource.ResourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Resource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Resource> getType() {
		return Resource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("resourceId"), processor, ResourceId.class, getResourceId());
		processRosetta(path.newSubPath("resourceType"), processor, ResourceType.class, getResourceType());
		processRosetta(path.newSubPath("language"), processor, Language.class, getLanguage());
		processor.processBasic(path.newSubPath("sizeInBytes"), BigDecimal.class, getSizeInBytes(), this);
		processRosetta(path.newSubPath("length"), processor, ResourceLength.class, getLength());
		processRosetta(path.newSubPath("mimeType"), processor, MimeType.class, getMimeType());
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processor.processBasic(path.newSubPath("string"), String.class, getString(), this);
		processor.processBasic(path.newSubPath("hexadecimalBinary"), String.class, getHexadecimalBinary(), this);
		processor.processBasic(path.newSubPath("base64Binary"), String.class, getBase64Binary(), this);
		processor.processBasic(path.newSubPath("url"), String.class, getUrl(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResourceBuilder extends Resource, RosettaModelObjectBuilder {
		ResourceId.ResourceIdBuilder getOrCreateResourceId();
		ResourceId.ResourceIdBuilder getResourceId();
		ResourceType.ResourceTypeBuilder getOrCreateResourceType();
		ResourceType.ResourceTypeBuilder getResourceType();
		Language.LanguageBuilder getOrCreateLanguage();
		Language.LanguageBuilder getLanguage();
		ResourceLength.ResourceLengthBuilder getOrCreateLength();
		ResourceLength.ResourceLengthBuilder getLength();
		MimeType.MimeTypeBuilder getOrCreateMimeType();
		MimeType.MimeTypeBuilder getMimeType();
		Resource.ResourceBuilder setResourceId(ResourceId resourceId);
		Resource.ResourceBuilder setResourceType(ResourceType resourceType);
		Resource.ResourceBuilder setLanguage(Language language);
		Resource.ResourceBuilder setSizeInBytes(BigDecimal sizeInBytes);
		Resource.ResourceBuilder setLength(ResourceLength length);
		Resource.ResourceBuilder setMimeType(MimeType mimeType);
		Resource.ResourceBuilder setName(String name);
		Resource.ResourceBuilder setComments(String comments);
		Resource.ResourceBuilder setString(String string);
		Resource.ResourceBuilder setHexadecimalBinary(String hexadecimalBinary);
		Resource.ResourceBuilder setBase64Binary(String base64Binary);
		Resource.ResourceBuilder setUrl(String url);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("resourceId"), processor, ResourceId.ResourceIdBuilder.class, getResourceId());
			processRosetta(path.newSubPath("resourceType"), processor, ResourceType.ResourceTypeBuilder.class, getResourceType());
			processRosetta(path.newSubPath("language"), processor, Language.LanguageBuilder.class, getLanguage());
			processor.processBasic(path.newSubPath("sizeInBytes"), BigDecimal.class, getSizeInBytes(), this);
			processRosetta(path.newSubPath("length"), processor, ResourceLength.ResourceLengthBuilder.class, getLength());
			processRosetta(path.newSubPath("mimeType"), processor, MimeType.MimeTypeBuilder.class, getMimeType());
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processor.processBasic(path.newSubPath("string"), String.class, getString(), this);
			processor.processBasic(path.newSubPath("hexadecimalBinary"), String.class, getHexadecimalBinary(), this);
			processor.processBasic(path.newSubPath("base64Binary"), String.class, getBase64Binary(), this);
			processor.processBasic(path.newSubPath("url"), String.class, getUrl(), this);
		}
		

		Resource.ResourceBuilder prune();
	}

	/*********************** Immutable Implementation of Resource  ***********************/
	class ResourceImpl implements Resource {
		private final ResourceId resourceId;
		private final ResourceType resourceType;
		private final Language language;
		private final BigDecimal sizeInBytes;
		private final ResourceLength length;
		private final MimeType mimeType;
		private final String name;
		private final String comments;
		private final String string;
		private final String hexadecimalBinary;
		private final String base64Binary;
		private final String url;
		
		protected ResourceImpl(Resource.ResourceBuilder builder) {
			this.resourceId = ofNullable(builder.getResourceId()).map(f->f.build()).orElse(null);
			this.resourceType = ofNullable(builder.getResourceType()).map(f->f.build()).orElse(null);
			this.language = ofNullable(builder.getLanguage()).map(f->f.build()).orElse(null);
			this.sizeInBytes = builder.getSizeInBytes();
			this.length = ofNullable(builder.getLength()).map(f->f.build()).orElse(null);
			this.mimeType = ofNullable(builder.getMimeType()).map(f->f.build()).orElse(null);
			this.name = builder.getName();
			this.comments = builder.getComments();
			this.string = builder.getString();
			this.hexadecimalBinary = builder.getHexadecimalBinary();
			this.base64Binary = builder.getBase64Binary();
			this.url = builder.getUrl();
		}
		
		@Override
		@RosettaAttribute("resourceId")
		public ResourceId getResourceId() {
			return resourceId;
		}
		
		@Override
		@RosettaAttribute("resourceType")
		public ResourceType getResourceType() {
			return resourceType;
		}
		
		@Override
		@RosettaAttribute("language")
		public Language getLanguage() {
			return language;
		}
		
		@Override
		@RosettaAttribute("sizeInBytes")
		public BigDecimal getSizeInBytes() {
			return sizeInBytes;
		}
		
		@Override
		@RosettaAttribute("length")
		public ResourceLength getLength() {
			return length;
		}
		
		@Override
		@RosettaAttribute("mimeType")
		public MimeType getMimeType() {
			return mimeType;
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		@RosettaAttribute("string")
		public String getString() {
			return string;
		}
		
		@Override
		@RosettaAttribute("hexadecimalBinary")
		public String getHexadecimalBinary() {
			return hexadecimalBinary;
		}
		
		@Override
		@RosettaAttribute("base64Binary")
		public String getBase64Binary() {
			return base64Binary;
		}
		
		@Override
		@RosettaAttribute("url")
		public String getUrl() {
			return url;
		}
		
		@Override
		public Resource build() {
			return this;
		}
		
		@Override
		public Resource.ResourceBuilder toBuilder() {
			Resource.ResourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Resource.ResourceBuilder builder) {
			ofNullable(getResourceId()).ifPresent(builder::setResourceId);
			ofNullable(getResourceType()).ifPresent(builder::setResourceType);
			ofNullable(getLanguage()).ifPresent(builder::setLanguage);
			ofNullable(getSizeInBytes()).ifPresent(builder::setSizeInBytes);
			ofNullable(getLength()).ifPresent(builder::setLength);
			ofNullable(getMimeType()).ifPresent(builder::setMimeType);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getComments()).ifPresent(builder::setComments);
			ofNullable(getString()).ifPresent(builder::setString);
			ofNullable(getHexadecimalBinary()).ifPresent(builder::setHexadecimalBinary);
			ofNullable(getBase64Binary()).ifPresent(builder::setBase64Binary);
			ofNullable(getUrl()).ifPresent(builder::setUrl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Resource _that = getType().cast(o);
		
			if (!Objects.equals(resourceId, _that.getResourceId())) return false;
			if (!Objects.equals(resourceType, _that.getResourceType())) return false;
			if (!Objects.equals(language, _that.getLanguage())) return false;
			if (!Objects.equals(sizeInBytes, _that.getSizeInBytes())) return false;
			if (!Objects.equals(length, _that.getLength())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(comments, _that.getComments())) return false;
			if (!Objects.equals(string, _that.getString())) return false;
			if (!Objects.equals(hexadecimalBinary, _that.getHexadecimalBinary())) return false;
			if (!Objects.equals(base64Binary, _that.getBase64Binary())) return false;
			if (!Objects.equals(url, _that.getUrl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resourceId != null ? resourceId.hashCode() : 0);
			_result = 31 * _result + (resourceType != null ? resourceType.hashCode() : 0);
			_result = 31 * _result + (language != null ? language.hashCode() : 0);
			_result = 31 * _result + (sizeInBytes != null ? sizeInBytes.hashCode() : 0);
			_result = 31 * _result + (length != null ? length.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			_result = 31 * _result + (string != null ? string.hashCode() : 0);
			_result = 31 * _result + (hexadecimalBinary != null ? hexadecimalBinary.hashCode() : 0);
			_result = 31 * _result + (base64Binary != null ? base64Binary.hashCode() : 0);
			_result = 31 * _result + (url != null ? url.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Resource {" +
				"resourceId=" + this.resourceId + ", " +
				"resourceType=" + this.resourceType + ", " +
				"language=" + this.language + ", " +
				"sizeInBytes=" + this.sizeInBytes + ", " +
				"length=" + this.length + ", " +
				"mimeType=" + this.mimeType + ", " +
				"name=" + this.name + ", " +
				"comments=" + this.comments + ", " +
				"string=" + this.string + ", " +
				"hexadecimalBinary=" + this.hexadecimalBinary + ", " +
				"base64Binary=" + this.base64Binary + ", " +
				"url=" + this.url +
			'}';
		}
	}

	/*********************** Builder Implementation of Resource  ***********************/
	class ResourceBuilderImpl implements Resource.ResourceBuilder {
	
		protected ResourceId.ResourceIdBuilder resourceId;
		protected ResourceType.ResourceTypeBuilder resourceType;
		protected Language.LanguageBuilder language;
		protected BigDecimal sizeInBytes;
		protected ResourceLength.ResourceLengthBuilder length;
		protected MimeType.MimeTypeBuilder mimeType;
		protected String name;
		protected String comments;
		protected String string;
		protected String hexadecimalBinary;
		protected String base64Binary;
		protected String url;
	
		public ResourceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("resourceId")
		public ResourceId.ResourceIdBuilder getResourceId() {
			return resourceId;
		}
		
		@Override
		public ResourceId.ResourceIdBuilder getOrCreateResourceId() {
			ResourceId.ResourceIdBuilder result;
			if (resourceId!=null) {
				result = resourceId;
			}
			else {
				result = resourceId = ResourceId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resourceType")
		public ResourceType.ResourceTypeBuilder getResourceType() {
			return resourceType;
		}
		
		@Override
		public ResourceType.ResourceTypeBuilder getOrCreateResourceType() {
			ResourceType.ResourceTypeBuilder result;
			if (resourceType!=null) {
				result = resourceType;
			}
			else {
				result = resourceType = ResourceType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("language")
		public Language.LanguageBuilder getLanguage() {
			return language;
		}
		
		@Override
		public Language.LanguageBuilder getOrCreateLanguage() {
			Language.LanguageBuilder result;
			if (language!=null) {
				result = language;
			}
			else {
				result = language = Language.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sizeInBytes")
		public BigDecimal getSizeInBytes() {
			return sizeInBytes;
		}
		
		@Override
		@RosettaAttribute("length")
		public ResourceLength.ResourceLengthBuilder getLength() {
			return length;
		}
		
		@Override
		public ResourceLength.ResourceLengthBuilder getOrCreateLength() {
			ResourceLength.ResourceLengthBuilder result;
			if (length!=null) {
				result = length;
			}
			else {
				result = length = ResourceLength.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mimeType")
		public MimeType.MimeTypeBuilder getMimeType() {
			return mimeType;
		}
		
		@Override
		public MimeType.MimeTypeBuilder getOrCreateMimeType() {
			MimeType.MimeTypeBuilder result;
			if (mimeType!=null) {
				result = mimeType;
			}
			else {
				result = mimeType = MimeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		@RosettaAttribute("string")
		public String getString() {
			return string;
		}
		
		@Override
		@RosettaAttribute("hexadecimalBinary")
		public String getHexadecimalBinary() {
			return hexadecimalBinary;
		}
		
		@Override
		@RosettaAttribute("base64Binary")
		public String getBase64Binary() {
			return base64Binary;
		}
		
		@Override
		@RosettaAttribute("url")
		public String getUrl() {
			return url;
		}
		
		@Override
		@RosettaAttribute("resourceId")
		public Resource.ResourceBuilder setResourceId(ResourceId resourceId) {
			this.resourceId = resourceId==null?null:resourceId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("resourceType")
		public Resource.ResourceBuilder setResourceType(ResourceType resourceType) {
			this.resourceType = resourceType==null?null:resourceType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("language")
		public Resource.ResourceBuilder setLanguage(Language language) {
			this.language = language==null?null:language.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sizeInBytes")
		public Resource.ResourceBuilder setSizeInBytes(BigDecimal sizeInBytes) {
			this.sizeInBytes = sizeInBytes==null?null:sizeInBytes;
			return this;
		}
		@Override
		@RosettaAttribute("length")
		public Resource.ResourceBuilder setLength(ResourceLength length) {
			this.length = length==null?null:length.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mimeType")
		public Resource.ResourceBuilder setMimeType(MimeType mimeType) {
			this.mimeType = mimeType==null?null:mimeType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("name")
		public Resource.ResourceBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public Resource.ResourceBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("string")
		public Resource.ResourceBuilder setString(String string) {
			this.string = string==null?null:string;
			return this;
		}
		@Override
		@RosettaAttribute("hexadecimalBinary")
		public Resource.ResourceBuilder setHexadecimalBinary(String hexadecimalBinary) {
			this.hexadecimalBinary = hexadecimalBinary==null?null:hexadecimalBinary;
			return this;
		}
		@Override
		@RosettaAttribute("base64Binary")
		public Resource.ResourceBuilder setBase64Binary(String base64Binary) {
			this.base64Binary = base64Binary==null?null:base64Binary;
			return this;
		}
		@Override
		@RosettaAttribute("url")
		public Resource.ResourceBuilder setUrl(String url) {
			this.url = url==null?null:url;
			return this;
		}
		
		@Override
		public Resource build() {
			return new Resource.ResourceImpl(this);
		}
		
		@Override
		public Resource.ResourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Resource.ResourceBuilder prune() {
			if (resourceId!=null && !resourceId.prune().hasData()) resourceId = null;
			if (resourceType!=null && !resourceType.prune().hasData()) resourceType = null;
			if (language!=null && !language.prune().hasData()) language = null;
			if (length!=null && !length.prune().hasData()) length = null;
			if (mimeType!=null && !mimeType.prune().hasData()) mimeType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getResourceId()!=null && getResourceId().hasData()) return true;
			if (getResourceType()!=null && getResourceType().hasData()) return true;
			if (getLanguage()!=null && getLanguage().hasData()) return true;
			if (getSizeInBytes()!=null) return true;
			if (getLength()!=null && getLength().hasData()) return true;
			if (getMimeType()!=null && getMimeType().hasData()) return true;
			if (getName()!=null) return true;
			if (getComments()!=null) return true;
			if (getString()!=null) return true;
			if (getHexadecimalBinary()!=null) return true;
			if (getBase64Binary()!=null) return true;
			if (getUrl()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Resource.ResourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Resource.ResourceBuilder o = (Resource.ResourceBuilder) other;
			
			merger.mergeRosetta(getResourceId(), o.getResourceId(), this::setResourceId);
			merger.mergeRosetta(getResourceType(), o.getResourceType(), this::setResourceType);
			merger.mergeRosetta(getLanguage(), o.getLanguage(), this::setLanguage);
			merger.mergeRosetta(getLength(), o.getLength(), this::setLength);
			merger.mergeRosetta(getMimeType(), o.getMimeType(), this::setMimeType);
			
			merger.mergeBasic(getSizeInBytes(), o.getSizeInBytes(), this::setSizeInBytes);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getComments(), o.getComments(), this::setComments);
			merger.mergeBasic(getString(), o.getString(), this::setString);
			merger.mergeBasic(getHexadecimalBinary(), o.getHexadecimalBinary(), this::setHexadecimalBinary);
			merger.mergeBasic(getBase64Binary(), o.getBase64Binary(), this::setBase64Binary);
			merger.mergeBasic(getUrl(), o.getUrl(), this::setUrl);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Resource _that = getType().cast(o);
		
			if (!Objects.equals(resourceId, _that.getResourceId())) return false;
			if (!Objects.equals(resourceType, _that.getResourceType())) return false;
			if (!Objects.equals(language, _that.getLanguage())) return false;
			if (!Objects.equals(sizeInBytes, _that.getSizeInBytes())) return false;
			if (!Objects.equals(length, _that.getLength())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(comments, _that.getComments())) return false;
			if (!Objects.equals(string, _that.getString())) return false;
			if (!Objects.equals(hexadecimalBinary, _that.getHexadecimalBinary())) return false;
			if (!Objects.equals(base64Binary, _that.getBase64Binary())) return false;
			if (!Objects.equals(url, _that.getUrl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resourceId != null ? resourceId.hashCode() : 0);
			_result = 31 * _result + (resourceType != null ? resourceType.hashCode() : 0);
			_result = 31 * _result + (language != null ? language.hashCode() : 0);
			_result = 31 * _result + (sizeInBytes != null ? sizeInBytes.hashCode() : 0);
			_result = 31 * _result + (length != null ? length.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			_result = 31 * _result + (string != null ? string.hashCode() : 0);
			_result = 31 * _result + (hexadecimalBinary != null ? hexadecimalBinary.hashCode() : 0);
			_result = 31 * _result + (base64Binary != null ? base64Binary.hashCode() : 0);
			_result = 31 * _result + (url != null ? url.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceBuilder {" +
				"resourceId=" + this.resourceId + ", " +
				"resourceType=" + this.resourceType + ", " +
				"language=" + this.language + ", " +
				"sizeInBytes=" + this.sizeInBytes + ", " +
				"length=" + this.length + ", " +
				"mimeType=" + this.mimeType + ", " +
				"name=" + this.name + ", " +
				"comments=" + this.comments + ", " +
				"string=" + this.string + ", " +
				"hexadecimalBinary=" + this.hexadecimalBinary + ", " +
				"base64Binary=" + this.base64Binary + ", " +
				"url=" + this.url +
			'}';
		}
	}
}
