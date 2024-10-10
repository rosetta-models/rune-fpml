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
import fpml.confirmation.Object;
import fpml.confirmation.Object.ObjectBuilder;
import fpml.confirmation.Object.ObjectBuilderImpl;
import fpml.confirmation.Object.ObjectImpl;
import fpml.confirmation.ObjectType;
import fpml.confirmation.ObjectType.ObjectTypeBuilder;
import fpml.confirmation.ObjectType.ObjectTypeBuilderImpl;
import fpml.confirmation.ObjectType.ObjectTypeImpl;
import fpml.confirmation.ObjectTypeSequence;
import fpml.confirmation.meta.ObjectMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="Object", builder=Object.ObjectBuilderImpl.class, version="${project.version}")
public interface Object extends ObjectType {

	ObjectMeta metaData = new ObjectMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Object build();
	
	Object.ObjectBuilder toBuilder();
	
	static Object.ObjectBuilder builder() {
		return new Object.ObjectBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Object> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Object> getType() {
		return Object.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.class, getObjectTypeSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
		processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObjectBuilder extends Object, ObjectType.ObjectTypeBuilder {
		Object.ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence0);
		Object.ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence1, int _idx);
		Object.ObjectBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence2);
		Object.ObjectBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence3);
		Object.ObjectBuilder setId(String id);
		Object.ObjectBuilder setMimeType(String mimeType);
		Object.ObjectBuilder setEncoding(String encoding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.ObjectTypeSequenceBuilder.class, getObjectTypeSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
			processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
		}
		

		Object.ObjectBuilder prune();
	}

	/*********************** Immutable Implementation of Object  ***********************/
	class ObjectImpl extends ObjectType.ObjectTypeImpl implements Object {
		
		protected ObjectImpl(Object.ObjectBuilder builder) {
			super(builder);
		}
		
		@Override
		public Object build() {
			return this;
		}
		
		@Override
		public Object.ObjectBuilder toBuilder() {
			Object.ObjectBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Object.ObjectBuilder builder) {
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
			return "Object {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Object  ***********************/
	class ObjectBuilderImpl extends ObjectType.ObjectTypeBuilderImpl  implements Object.ObjectBuilder {
	
	
		public ObjectBuilderImpl() {
		}
	
		@Override
		public Object.ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence) {
			if (objectTypeSequence!=null) this.objectTypeSequence.add(objectTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public Object.ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence, int _idx) {
			getIndex(this.objectTypeSequence, _idx, () -> objectTypeSequence.toBuilder());
			return this;
		}
		@Override 
		public Object.ObjectBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
			if (objectTypeSequences != null) {
				for (ObjectTypeSequence toAdd : objectTypeSequences) {
					this.objectTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("objectTypeSequence")
		public Object.ObjectBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
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
		public Object.ObjectBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("mimeType")
		public Object.ObjectBuilder setMimeType(String mimeType) {
			this.mimeType = mimeType==null?null:mimeType;
			return this;
		}
		@Override
		@RosettaAttribute("encoding")
		public Object.ObjectBuilder setEncoding(String encoding) {
			this.encoding = encoding==null?null:encoding;
			return this;
		}
		
		@Override
		public Object build() {
			return new Object.ObjectImpl(this);
		}
		
		@Override
		public Object.ObjectBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Object.ObjectBuilder prune() {
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
		public Object.ObjectBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Object.ObjectBuilder o = (Object.ObjectBuilder) other;
			
			
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
			return "ObjectBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
