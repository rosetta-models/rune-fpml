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
import fpml.confirmation.DigestMethodType;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.ReferenceType.ReferenceTypeBuilder;
import fpml.confirmation.ReferenceType.ReferenceTypeBuilderImpl;
import fpml.confirmation.ReferenceType.ReferenceTypeImpl;
import fpml.confirmation.TransformsType;
import fpml.confirmation.meta.ReferenceTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReferenceType", builder=ReferenceType.ReferenceTypeBuilderImpl.class, version="${project.version}")
public interface ReferenceType extends RosettaModelObject {

	ReferenceTypeMeta metaData = new ReferenceTypeMeta();

	/*********************** Getter Methods  ***********************/
	TransformsType getTransforms();
	DigestMethodType getDigestMethod();
	String getDigestValue();
	String getId();
	String getUri();
	String getType();

	/*********************** Build Methods  ***********************/
	ReferenceType build();
	
	ReferenceType.ReferenceTypeBuilder toBuilder();
	
	static ReferenceType.ReferenceTypeBuilder builder() {
		return new ReferenceType.ReferenceTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceType> getType() {
		return ReferenceType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transforms"), processor, TransformsType.class, getTransforms());
		processRosetta(path.newSubPath("digestMethod"), processor, DigestMethodType.class, getDigestMethod());
		processor.processBasic(path.newSubPath("digestValue"), String.class, getDigestValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
		processor.processBasic(path.newSubPath("type"), String.class, getType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceTypeBuilder extends ReferenceType, RosettaModelObjectBuilder {
		TransformsType.TransformsTypeBuilder getOrCreateTransforms();
		TransformsType.TransformsTypeBuilder getTransforms();
		DigestMethodType.DigestMethodTypeBuilder getOrCreateDigestMethod();
		DigestMethodType.DigestMethodTypeBuilder getDigestMethod();
		ReferenceType.ReferenceTypeBuilder setTransforms(TransformsType transforms);
		ReferenceType.ReferenceTypeBuilder setDigestMethod(DigestMethodType digestMethod);
		ReferenceType.ReferenceTypeBuilder setDigestValue(String digestValue);
		ReferenceType.ReferenceTypeBuilder setId(String id);
		ReferenceType.ReferenceTypeBuilder setUri(String uri);
		ReferenceType.ReferenceTypeBuilder setType(String type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
			processRosetta(path.newSubPath("digestMethod"), processor, DigestMethodType.DigestMethodTypeBuilder.class, getDigestMethod());
			processor.processBasic(path.newSubPath("digestValue"), String.class, getDigestValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("type"), String.class, getType(), this);
		}
		

		ReferenceType.ReferenceTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceType  ***********************/
	class ReferenceTypeImpl implements ReferenceType {
		private final TransformsType transforms;
		private final DigestMethodType digestMethod;
		private final String digestValue;
		private final String id;
		private final String uri;
		private final String type;
		
		protected ReferenceTypeImpl(ReferenceType.ReferenceTypeBuilder builder) {
			this.transforms = ofNullable(builder.getTransforms()).map(f->f.build()).orElse(null);
			this.digestMethod = ofNullable(builder.getDigestMethod()).map(f->f.build()).orElse(null);
			this.digestValue = builder.getDigestValue();
			this.id = builder.getId();
			this.uri = builder.getUri();
			this.type = builder.getType();
		}
		
		@Override
		@RosettaAttribute("transforms")
		public TransformsType getTransforms() {
			return transforms;
		}
		
		@Override
		@RosettaAttribute("digestMethod")
		public DigestMethodType getDigestMethod() {
			return digestMethod;
		}
		
		@Override
		@RosettaAttribute("digestValue")
		public String getDigestValue() {
			return digestValue;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("uri")
		public String getUri() {
			return uri;
		}
		
		@Override
		@RosettaAttribute("type")
		public String getType() {
			return type;
		}
		
		@Override
		public ReferenceType build() {
			return this;
		}
		
		@Override
		public ReferenceType.ReferenceTypeBuilder toBuilder() {
			ReferenceType.ReferenceTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceType.ReferenceTypeBuilder builder) {
			ofNullable(getTransforms()).ifPresent(builder::setTransforms);
			ofNullable(getDigestMethod()).ifPresent(builder::setDigestMethod);
			ofNullable(getDigestValue()).ifPresent(builder::setDigestValue);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getUri()).ifPresent(builder::setUri);
			ofNullable(getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceType _that = getType().cast(o);
		
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			if (!Objects.equals(digestMethod, _that.getDigestMethod())) return false;
			if (!Objects.equals(digestValue, _that.getDigestValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			_result = 31 * _result + (digestMethod != null ? digestMethod.hashCode() : 0);
			_result = 31 * _result + (digestValue != null ? digestValue.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceType {" +
				"transforms=" + this.transforms + ", " +
				"digestMethod=" + this.digestMethod + ", " +
				"digestValue=" + this.digestValue + ", " +
				"id=" + this.id + ", " +
				"uri=" + this.uri + ", " +
				"type=" + this.type +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceType  ***********************/
	class ReferenceTypeBuilderImpl implements ReferenceType.ReferenceTypeBuilder {
	
		protected TransformsType.TransformsTypeBuilder transforms;
		protected DigestMethodType.DigestMethodTypeBuilder digestMethod;
		protected String digestValue;
		protected String id;
		protected String uri;
		protected String type;
	
		public ReferenceTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transforms")
		public TransformsType.TransformsTypeBuilder getTransforms() {
			return transforms;
		}
		
		@Override
		public TransformsType.TransformsTypeBuilder getOrCreateTransforms() {
			TransformsType.TransformsTypeBuilder result;
			if (transforms!=null) {
				result = transforms;
			}
			else {
				result = transforms = TransformsType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("digestMethod")
		public DigestMethodType.DigestMethodTypeBuilder getDigestMethod() {
			return digestMethod;
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder getOrCreateDigestMethod() {
			DigestMethodType.DigestMethodTypeBuilder result;
			if (digestMethod!=null) {
				result = digestMethod;
			}
			else {
				result = digestMethod = DigestMethodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("digestValue")
		public String getDigestValue() {
			return digestValue;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("uri")
		public String getUri() {
			return uri;
		}
		
		@Override
		@RosettaAttribute("type")
		public String getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("transforms")
		public ReferenceType.ReferenceTypeBuilder setTransforms(TransformsType transforms) {
			this.transforms = transforms==null?null:transforms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("digestMethod")
		public ReferenceType.ReferenceTypeBuilder setDigestMethod(DigestMethodType digestMethod) {
			this.digestMethod = digestMethod==null?null:digestMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("digestValue")
		public ReferenceType.ReferenceTypeBuilder setDigestValue(String digestValue) {
			this.digestValue = digestValue==null?null:digestValue;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReferenceType.ReferenceTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("uri")
		public ReferenceType.ReferenceTypeBuilder setUri(String uri) {
			this.uri = uri==null?null:uri;
			return this;
		}
		@Override
		@RosettaAttribute("type")
		public ReferenceType.ReferenceTypeBuilder setType(String type) {
			this.type = type==null?null:type;
			return this;
		}
		
		@Override
		public ReferenceType build() {
			return new ReferenceType.ReferenceTypeImpl(this);
		}
		
		@Override
		public ReferenceType.ReferenceTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceType.ReferenceTypeBuilder prune() {
			if (transforms!=null && !transforms.prune().hasData()) transforms = null;
			if (digestMethod!=null && !digestMethod.prune().hasData()) digestMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransforms()!=null && getTransforms().hasData()) return true;
			if (getDigestMethod()!=null && getDigestMethod().hasData()) return true;
			if (getDigestValue()!=null) return true;
			if (getId()!=null) return true;
			if (getUri()!=null) return true;
			if (getType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceType.ReferenceTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceType.ReferenceTypeBuilder o = (ReferenceType.ReferenceTypeBuilder) other;
			
			merger.mergeRosetta(getTransforms(), o.getTransforms(), this::setTransforms);
			merger.mergeRosetta(getDigestMethod(), o.getDigestMethod(), this::setDigestMethod);
			
			merger.mergeBasic(getDigestValue(), o.getDigestValue(), this::setDigestValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getUri(), o.getUri(), this::setUri);
			merger.mergeBasic(getType(), o.getType(), this::setType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceType _that = getType().cast(o);
		
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			if (!Objects.equals(digestMethod, _that.getDigestMethod())) return false;
			if (!Objects.equals(digestValue, _that.getDigestValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			_result = 31 * _result + (digestMethod != null ? digestMethod.hashCode() : 0);
			_result = 31 * _result + (digestValue != null ? digestValue.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceTypeBuilder {" +
				"transforms=" + this.transforms + ", " +
				"digestMethod=" + this.digestMethod + ", " +
				"digestValue=" + this.digestValue + ", " +
				"id=" + this.id + ", " +
				"uri=" + this.uri + ", " +
				"type=" + this.type +
			'}';
		}
	}
}
