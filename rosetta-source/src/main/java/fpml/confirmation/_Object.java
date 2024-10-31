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
import fpml.confirmation.ObjectType;
import fpml.confirmation.ObjectType.ObjectTypeBuilder;
import fpml.confirmation.ObjectType.ObjectTypeBuilderImpl;
import fpml.confirmation.ObjectType.ObjectTypeImpl;
import fpml.confirmation.ObjectTypeSequence;
import fpml.confirmation._Object;
import fpml.confirmation._Object._ObjectBuilder;
import fpml.confirmation._Object._ObjectBuilderImpl;
import fpml.confirmation._Object._ObjectImpl;
import fpml.confirmation.meta._ObjectMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="_Object", builder=_Object._ObjectBuilderImpl.class, version="${project.version}")
public interface _Object extends ObjectType {

	_ObjectMeta metaData = new _ObjectMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	_Object build();
	
	_Object._ObjectBuilder toBuilder();
	
	static _Object._ObjectBuilder builder() {
		return new _Object._ObjectBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends _Object> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends _Object> getType() {
		return _Object.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.class, getObjectTypeSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
		processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface _ObjectBuilder extends _Object, ObjectType.ObjectTypeBuilder {
		_Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence0);
		_Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence1, int _idx);
		_Object._ObjectBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence2);
		_Object._ObjectBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence3);
		_Object._ObjectBuilder setId(String id);
		_Object._ObjectBuilder setMimeType(String mimeType);
		_Object._ObjectBuilder setEncoding(String encoding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.ObjectTypeSequenceBuilder.class, getObjectTypeSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
			processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
		}
		

		_Object._ObjectBuilder prune();
	}

	/*********************** Immutable Implementation of _Object  ***********************/
	class _ObjectImpl extends ObjectType.ObjectTypeImpl implements _Object {
		
		protected _ObjectImpl(_Object._ObjectBuilder builder) {
			super(builder);
		}
		
		@Override
		public _Object build() {
			return this;
		}
		
		@Override
		public _Object._ObjectBuilder toBuilder() {
			_Object._ObjectBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(_Object._ObjectBuilder builder) {
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
			return "_Object {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of _Object  ***********************/
	class _ObjectBuilderImpl extends ObjectType.ObjectTypeBuilderImpl  implements _Object._ObjectBuilder {
	
	
		public _ObjectBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("objectTypeSequence")
		public _Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence) {
			if (objectTypeSequence!=null) this.objectTypeSequence.add(objectTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public _Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence, int _idx) {
			getIndex(this.objectTypeSequence, _idx, () -> objectTypeSequence.toBuilder());
			return this;
		}
		@Override 
		public _Object._ObjectBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
			if (objectTypeSequences != null) {
				for (ObjectTypeSequence toAdd : objectTypeSequences) {
					this.objectTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public _Object._ObjectBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
			if (objectTypeSequences == null)  {
				this.objectTypeSequence = new ArrayList<>();
			}
			else {
				this.objectTypeSequence = objectTypeSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public _Object._ObjectBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("mimeType")
		public _Object._ObjectBuilder setMimeType(String mimeType) {
			this.mimeType = mimeType==null?null:mimeType;
			return this;
		}
		@Override
		@RosettaAttribute("encoding")
		public _Object._ObjectBuilder setEncoding(String encoding) {
			this.encoding = encoding==null?null:encoding;
			return this;
		}
		
		@Override
		public _Object build() {
			return new _Object._ObjectImpl(this);
		}
		
		@Override
		public _Object._ObjectBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public _Object._ObjectBuilder prune() {
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
		public _Object._ObjectBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			_Object._ObjectBuilder o = (_Object._ObjectBuilder) other;
			
			
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
			return "_ObjectBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
