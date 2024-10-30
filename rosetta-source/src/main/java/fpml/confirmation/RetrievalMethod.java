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
import fpml.confirmation.RetrievalMethod;
import fpml.confirmation.RetrievalMethod.RetrievalMethodBuilder;
import fpml.confirmation.RetrievalMethod.RetrievalMethodBuilderImpl;
import fpml.confirmation.RetrievalMethod.RetrievalMethodImpl;
import fpml.confirmation.RetrievalMethodType;
import fpml.confirmation.RetrievalMethodType.RetrievalMethodTypeBuilder;
import fpml.confirmation.RetrievalMethodType.RetrievalMethodTypeBuilderImpl;
import fpml.confirmation.RetrievalMethodType.RetrievalMethodTypeImpl;
import fpml.confirmation.TransformsType;
import fpml.confirmation.meta.RetrievalMethodMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RetrievalMethod", builder=RetrievalMethod.RetrievalMethodBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RetrievalMethod extends RetrievalMethodType {

	RetrievalMethodMeta metaData = new RetrievalMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RetrievalMethod build();
	
	RetrievalMethod.RetrievalMethodBuilder toBuilder();
	
	static RetrievalMethod.RetrievalMethodBuilder builder() {
		return new RetrievalMethod.RetrievalMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RetrievalMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RetrievalMethod> getType() {
		return RetrievalMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transforms"), processor, TransformsType.class, getTransforms());
		processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
		processor.processBasic(path.newSubPath("_type"), String.class, get_type(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RetrievalMethodBuilder extends RetrievalMethod, RetrievalMethodType.RetrievalMethodTypeBuilder {
		RetrievalMethod.RetrievalMethodBuilder setTransforms(TransformsType transforms);
		RetrievalMethod.RetrievalMethodBuilder setUri(String uri);
		RetrievalMethod.RetrievalMethodBuilder set_type(String _type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("_type"), String.class, get_type(), this);
		}
		

		RetrievalMethod.RetrievalMethodBuilder prune();
	}

	/*********************** Immutable Implementation of RetrievalMethod  ***********************/
	class RetrievalMethodImpl extends RetrievalMethodType.RetrievalMethodTypeImpl implements RetrievalMethod {
		
		protected RetrievalMethodImpl(RetrievalMethod.RetrievalMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public RetrievalMethod build() {
			return this;
		}
		
		@Override
		public RetrievalMethod.RetrievalMethodBuilder toBuilder() {
			RetrievalMethod.RetrievalMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RetrievalMethod.RetrievalMethodBuilder builder) {
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
			return "RetrievalMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RetrievalMethod  ***********************/
	class RetrievalMethodBuilderImpl extends RetrievalMethodType.RetrievalMethodTypeBuilderImpl  implements RetrievalMethod.RetrievalMethodBuilder {
	
	
		public RetrievalMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transforms")
		public RetrievalMethod.RetrievalMethodBuilder setTransforms(TransformsType transforms) {
			this.transforms = transforms==null?null:transforms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("uri")
		public RetrievalMethod.RetrievalMethodBuilder setUri(String uri) {
			this.uri = uri==null?null:uri;
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public RetrievalMethod.RetrievalMethodBuilder set_type(String _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		
		@Override
		public RetrievalMethod build() {
			return new RetrievalMethod.RetrievalMethodImpl(this);
		}
		
		@Override
		public RetrievalMethod.RetrievalMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrievalMethod.RetrievalMethodBuilder prune() {
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
		public RetrievalMethod.RetrievalMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RetrievalMethod.RetrievalMethodBuilder o = (RetrievalMethod.RetrievalMethodBuilder) other;
			
			
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
			return "RetrievalMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
