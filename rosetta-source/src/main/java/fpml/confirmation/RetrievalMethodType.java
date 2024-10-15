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
import fpml.confirmation.RetrievalMethodType;
import fpml.confirmation.RetrievalMethodType.RetrievalMethodTypeBuilder;
import fpml.confirmation.RetrievalMethodType.RetrievalMethodTypeBuilderImpl;
import fpml.confirmation.RetrievalMethodType.RetrievalMethodTypeImpl;
import fpml.confirmation.TransformsType;
import fpml.confirmation.meta.RetrievalMethodTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RetrievalMethodType", builder=RetrievalMethodType.RetrievalMethodTypeBuilderImpl.class, version="${project.version}")
public interface RetrievalMethodType extends RosettaModelObject {

	RetrievalMethodTypeMeta metaData = new RetrievalMethodTypeMeta();

	/*********************** Getter Methods  ***********************/
	TransformsType getTransforms();
	String getUri();
	String get_type();

	/*********************** Build Methods  ***********************/
	RetrievalMethodType build();
	
	RetrievalMethodType.RetrievalMethodTypeBuilder toBuilder();
	
	static RetrievalMethodType.RetrievalMethodTypeBuilder builder() {
		return new RetrievalMethodType.RetrievalMethodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RetrievalMethodType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RetrievalMethodType> getType() {
		return RetrievalMethodType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transforms"), processor, TransformsType.class, getTransforms());
		processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
		processor.processBasic(path.newSubPath("_type"), String.class, get_type(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RetrievalMethodTypeBuilder extends RetrievalMethodType, RosettaModelObjectBuilder {
		TransformsType.TransformsTypeBuilder getOrCreateTransforms();
		TransformsType.TransformsTypeBuilder getTransforms();
		RetrievalMethodType.RetrievalMethodTypeBuilder setTransforms(TransformsType transforms);
		RetrievalMethodType.RetrievalMethodTypeBuilder setUri(String uri);
		RetrievalMethodType.RetrievalMethodTypeBuilder set_type(String _type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("_type"), String.class, get_type(), this);
		}
		

		RetrievalMethodType.RetrievalMethodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of RetrievalMethodType  ***********************/
	class RetrievalMethodTypeImpl implements RetrievalMethodType {
		private final TransformsType transforms;
		private final String uri;
		private final String _type;
		
		protected RetrievalMethodTypeImpl(RetrievalMethodType.RetrievalMethodTypeBuilder builder) {
			this.transforms = ofNullable(builder.getTransforms()).map(f->f.build()).orElse(null);
			this.uri = builder.getUri();
			this._type = builder.get_type();
		}
		
		@Override
		@RosettaAttribute("transforms")
		public TransformsType getTransforms() {
			return transforms;
		}
		
		@Override
		@RosettaAttribute("uri")
		public String getUri() {
			return uri;
		}
		
		@Override
		@RosettaAttribute("_type")
		public String get_type() {
			return _type;
		}
		
		@Override
		public RetrievalMethodType build() {
			return this;
		}
		
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder toBuilder() {
			RetrievalMethodType.RetrievalMethodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RetrievalMethodType.RetrievalMethodTypeBuilder builder) {
			ofNullable(getTransforms()).ifPresent(builder::setTransforms);
			ofNullable(getUri()).ifPresent(builder::setUri);
			ofNullable(get_type()).ifPresent(builder::set_type);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrievalMethodType _that = getType().cast(o);
		
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrievalMethodType {" +
				"transforms=" + this.transforms + ", " +
				"uri=" + this.uri + ", " +
				"_type=" + this._type +
			'}';
		}
	}

	/*********************** Builder Implementation of RetrievalMethodType  ***********************/
	class RetrievalMethodTypeBuilderImpl implements RetrievalMethodType.RetrievalMethodTypeBuilder {
	
		protected TransformsType.TransformsTypeBuilder transforms;
		protected String uri;
		protected String _type;
	
		public RetrievalMethodTypeBuilderImpl() {
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
		@RosettaAttribute("uri")
		public String getUri() {
			return uri;
		}
		
		@Override
		@RosettaAttribute("_type")
		public String get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("transforms")
		public RetrievalMethodType.RetrievalMethodTypeBuilder setTransforms(TransformsType transforms) {
			this.transforms = transforms==null?null:transforms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("uri")
		public RetrievalMethodType.RetrievalMethodTypeBuilder setUri(String uri) {
			this.uri = uri==null?null:uri;
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public RetrievalMethodType.RetrievalMethodTypeBuilder set_type(String _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		
		@Override
		public RetrievalMethodType build() {
			return new RetrievalMethodType.RetrievalMethodTypeImpl(this);
		}
		
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder prune() {
			if (transforms!=null && !transforms.prune().hasData()) transforms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransforms()!=null && getTransforms().hasData()) return true;
			if (getUri()!=null) return true;
			if (get_type()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RetrievalMethodType.RetrievalMethodTypeBuilder o = (RetrievalMethodType.RetrievalMethodTypeBuilder) other;
			
			merger.mergeRosetta(getTransforms(), o.getTransforms(), this::setTransforms);
			
			merger.mergeBasic(getUri(), o.getUri(), this::setUri);
			merger.mergeBasic(get_type(), o.get_type(), this::set_type);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrievalMethodType _that = getType().cast(o);
		
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrievalMethodTypeBuilder {" +
				"transforms=" + this.transforms + ", " +
				"uri=" + this.uri + ", " +
				"_type=" + this._type +
			'}';
		}
	}
}
