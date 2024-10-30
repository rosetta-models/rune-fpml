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
import fpml.confirmation.ReferenceElement;
import fpml.confirmation.ReferenceElement.ReferenceElementBuilder;
import fpml.confirmation.ReferenceElement.ReferenceElementBuilderImpl;
import fpml.confirmation.ReferenceElement.ReferenceElementImpl;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.ReferenceType.ReferenceTypeBuilder;
import fpml.confirmation.ReferenceType.ReferenceTypeBuilderImpl;
import fpml.confirmation.ReferenceType.ReferenceTypeImpl;
import fpml.confirmation.TransformsType;
import fpml.confirmation.meta.ReferenceElementMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReferenceElement", builder=ReferenceElement.ReferenceElementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReferenceElement extends ReferenceType {

	ReferenceElementMeta metaData = new ReferenceElementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ReferenceElement build();
	
	ReferenceElement.ReferenceElementBuilder toBuilder();
	
	static ReferenceElement.ReferenceElementBuilder builder() {
		return new ReferenceElement.ReferenceElementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceElement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceElement> getType() {
		return ReferenceElement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transforms"), processor, TransformsType.class, getTransforms());
		processRosetta(path.newSubPath("digestMethod"), processor, DigestMethodType.class, getDigestMethod());
		processor.processBasic(path.newSubPath("digestValue"), String.class, getDigestValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
		processor.processBasic(path.newSubPath("_type"), String.class, get_type(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceElementBuilder extends ReferenceElement, ReferenceType.ReferenceTypeBuilder {
		ReferenceElement.ReferenceElementBuilder setTransforms(TransformsType transforms);
		ReferenceElement.ReferenceElementBuilder setDigestMethod(DigestMethodType digestMethod);
		ReferenceElement.ReferenceElementBuilder setDigestValue(String digestValue);
		ReferenceElement.ReferenceElementBuilder setId(String id);
		ReferenceElement.ReferenceElementBuilder setUri(String uri);
		ReferenceElement.ReferenceElementBuilder set_type(String _type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
			processRosetta(path.newSubPath("digestMethod"), processor, DigestMethodType.DigestMethodTypeBuilder.class, getDigestMethod());
			processor.processBasic(path.newSubPath("digestValue"), String.class, getDigestValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("_type"), String.class, get_type(), this);
		}
		

		ReferenceElement.ReferenceElementBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceElement  ***********************/
	class ReferenceElementImpl extends ReferenceType.ReferenceTypeImpl implements ReferenceElement {
		
		protected ReferenceElementImpl(ReferenceElement.ReferenceElementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ReferenceElement build() {
			return this;
		}
		
		@Override
		public ReferenceElement.ReferenceElementBuilder toBuilder() {
			ReferenceElement.ReferenceElementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceElement.ReferenceElementBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceElement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReferenceElement  ***********************/
	class ReferenceElementBuilderImpl extends ReferenceType.ReferenceTypeBuilderImpl  implements ReferenceElement.ReferenceElementBuilder {
	
	
		public ReferenceElementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transforms")
		public ReferenceElement.ReferenceElementBuilder setTransforms(TransformsType transforms) {
			this.transforms = transforms==null?null:transforms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("digestMethod")
		public ReferenceElement.ReferenceElementBuilder setDigestMethod(DigestMethodType digestMethod) {
			this.digestMethod = digestMethod==null?null:digestMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("digestValue")
		public ReferenceElement.ReferenceElementBuilder setDigestValue(String digestValue) {
			this.digestValue = digestValue==null?null:digestValue;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReferenceElement.ReferenceElementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("uri")
		public ReferenceElement.ReferenceElementBuilder setUri(String uri) {
			this.uri = uri==null?null:uri;
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public ReferenceElement.ReferenceElementBuilder set_type(String _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		
		@Override
		public ReferenceElement build() {
			return new ReferenceElement.ReferenceElementImpl(this);
		}
		
		@Override
		public ReferenceElement.ReferenceElementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceElement.ReferenceElementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceElement.ReferenceElementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReferenceElement.ReferenceElementBuilder o = (ReferenceElement.ReferenceElementBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceElementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
