package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.ObjectType;
import fpml.confirmation.ObjectType.ObjectTypeBuilder;
import fpml.confirmation.ObjectType.ObjectTypeBuilderImpl;
import fpml.confirmation.ObjectType.ObjectTypeImpl;
import fpml.confirmation.ObjectTypeSequence;
import fpml.confirmation.meta.ObjectTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ObjectType", builder=ObjectType.ObjectTypeBuilderImpl.class, version="${project.version}")
public interface ObjectType extends RosettaModelObject {

	ObjectTypeMeta metaData = new ObjectTypeMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends ObjectTypeSequence> getObjectTypeSequence();
	String getId();
	String getMimeType();
	String getEncoding();

	/*********************** Build Methods  ***********************/
	ObjectType build();
	
	ObjectType.ObjectTypeBuilder toBuilder();
	
	static ObjectType.ObjectTypeBuilder builder() {
		return new ObjectType.ObjectTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObjectType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObjectType> getType() {
		return ObjectType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.class, getObjectTypeSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
		processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObjectTypeBuilder extends ObjectType, RosettaModelObjectBuilder {
		ObjectTypeSequence.ObjectTypeSequenceBuilder getOrCreateObjectTypeSequence(int _index);
		List<? extends ObjectTypeSequence.ObjectTypeSequenceBuilder> getObjectTypeSequence();
		ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence0);
		ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence1, int _idx);
		ObjectType.ObjectTypeBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence2);
		ObjectType.ObjectTypeBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence3);
		ObjectType.ObjectTypeBuilder setId(String id);
		ObjectType.ObjectTypeBuilder setMimeType(String mimeType);
		ObjectType.ObjectTypeBuilder setEncoding(String encoding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.ObjectTypeSequenceBuilder.class, getObjectTypeSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
			processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
		}
		

		ObjectType.ObjectTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ObjectType  ***********************/
	class ObjectTypeImpl implements ObjectType {
		private final List<? extends ObjectTypeSequence> objectTypeSequence;
		private final String id;
		private final String mimeType;
		private final String encoding;
		
		protected ObjectTypeImpl(ObjectType.ObjectTypeBuilder builder) {
			this.objectTypeSequence = ofNullable(builder.getObjectTypeSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
			this.mimeType = builder.getMimeType();
			this.encoding = builder.getEncoding();
		}
		
		@Override
		@RosettaAttribute("objectTypeSequence")
		public List<? extends ObjectTypeSequence> getObjectTypeSequence() {
			return objectTypeSequence;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mimeType")
		public String getMimeType() {
			return mimeType;
		}
		
		@Override
		@RosettaAttribute("encoding")
		public String getEncoding() {
			return encoding;
		}
		
		@Override
		public ObjectType build() {
			return this;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder toBuilder() {
			ObjectType.ObjectTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObjectType.ObjectTypeBuilder builder) {
			ofNullable(getObjectTypeSequence()).ifPresent(builder::setObjectTypeSequence);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getMimeType()).ifPresent(builder::setMimeType);
			ofNullable(getEncoding()).ifPresent(builder::setEncoding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObjectType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(objectTypeSequence, _that.getObjectTypeSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(encoding, _that.getEncoding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (objectTypeSequence != null ? objectTypeSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (encoding != null ? encoding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectType {" +
				"objectTypeSequence=" + this.objectTypeSequence + ", " +
				"id=" + this.id + ", " +
				"mimeType=" + this.mimeType + ", " +
				"encoding=" + this.encoding +
			'}';
		}
	}

	/*********************** Builder Implementation of ObjectType  ***********************/
	class ObjectTypeBuilderImpl implements ObjectType.ObjectTypeBuilder {
	
		protected List<ObjectTypeSequence.ObjectTypeSequenceBuilder> objectTypeSequence = new ArrayList<>();
		protected String id;
		protected String mimeType;
		protected String encoding;
	
		public ObjectTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("objectTypeSequence")
		public List<? extends ObjectTypeSequence.ObjectTypeSequenceBuilder> getObjectTypeSequence() {
			return objectTypeSequence;
		}
		
		public ObjectTypeSequence.ObjectTypeSequenceBuilder getOrCreateObjectTypeSequence(int _index) {
		
			if (objectTypeSequence==null) {
				this.objectTypeSequence = new ArrayList<>();
			}
			ObjectTypeSequence.ObjectTypeSequenceBuilder result;
			return getIndex(objectTypeSequence, _index, () -> {
						ObjectTypeSequence.ObjectTypeSequenceBuilder newObjectTypeSequence = ObjectTypeSequence.builder();
						return newObjectTypeSequence;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mimeType")
		public String getMimeType() {
			return mimeType;
		}
		
		@Override
		@RosettaAttribute("encoding")
		public String getEncoding() {
			return encoding;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence) {
			if (objectTypeSequence!=null) this.objectTypeSequence.add(objectTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence, int _idx) {
			getIndex(this.objectTypeSequence, _idx, () -> objectTypeSequence.toBuilder());
			return this;
		}
		@Override 
		public ObjectType.ObjectTypeBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
			if (objectTypeSequences != null) {
				for (ObjectTypeSequence toAdd : objectTypeSequences) {
					this.objectTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("objectTypeSequence")
		public ObjectType.ObjectTypeBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
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
		public ObjectType.ObjectTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("mimeType")
		public ObjectType.ObjectTypeBuilder setMimeType(String mimeType) {
			this.mimeType = mimeType==null?null:mimeType;
			return this;
		}
		@Override
		@RosettaAttribute("encoding")
		public ObjectType.ObjectTypeBuilder setEncoding(String encoding) {
			this.encoding = encoding==null?null:encoding;
			return this;
		}
		
		@Override
		public ObjectType build() {
			return new ObjectType.ObjectTypeImpl(this);
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectType.ObjectTypeBuilder prune() {
			objectTypeSequence = objectTypeSequence.stream().filter(b->b!=null).<ObjectTypeSequence.ObjectTypeSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObjectTypeSequence()!=null && getObjectTypeSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			if (getMimeType()!=null) return true;
			if (getEncoding()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectType.ObjectTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObjectType.ObjectTypeBuilder o = (ObjectType.ObjectTypeBuilder) other;
			
			merger.mergeRosetta(getObjectTypeSequence(), o.getObjectTypeSequence(), this::getOrCreateObjectTypeSequence);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getMimeType(), o.getMimeType(), this::setMimeType);
			merger.mergeBasic(getEncoding(), o.getEncoding(), this::setEncoding);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObjectType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(objectTypeSequence, _that.getObjectTypeSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(encoding, _that.getEncoding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (objectTypeSequence != null ? objectTypeSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (encoding != null ? encoding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectTypeBuilder {" +
				"objectTypeSequence=" + this.objectTypeSequence + ", " +
				"id=" + this.id + ", " +
				"mimeType=" + this.mimeType + ", " +
				"encoding=" + this.encoding +
			'}';
		}
	}
}
