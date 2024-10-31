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
import fpml.confirmation.KeyInfoType;
import fpml.confirmation.ObjectType;
import fpml.confirmation.SignatureType;
import fpml.confirmation.SignatureType.SignatureTypeBuilder;
import fpml.confirmation.SignatureType.SignatureTypeBuilderImpl;
import fpml.confirmation.SignatureType.SignatureTypeImpl;
import fpml.confirmation.SignatureValueType;
import fpml.confirmation.SignedInfoType;
import fpml.confirmation.meta.SignatureTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignatureType", builder=SignatureType.SignatureTypeBuilderImpl.class, version="${project.version}")
public interface SignatureType extends RosettaModelObject {

	SignatureTypeMeta metaData = new SignatureTypeMeta();

	/*********************** Getter Methods  ***********************/
	SignedInfoType getSignedInfo();
	SignatureValueType getSignatureValue();
	KeyInfoType getKeyInfo();
	List<? extends ObjectType> getObject();
	String getId();

	/*********************** Build Methods  ***********************/
	SignatureType build();
	
	SignatureType.SignatureTypeBuilder toBuilder();
	
	static SignatureType.SignatureTypeBuilder builder() {
		return new SignatureType.SignatureTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignatureType> getType() {
		return SignatureType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("signedInfo"), processor, SignedInfoType.class, getSignedInfo());
		processRosetta(path.newSubPath("signatureValue"), processor, SignatureValueType.class, getSignatureValue());
		processRosetta(path.newSubPath("keyInfo"), processor, KeyInfoType.class, getKeyInfo());
		processRosetta(path.newSubPath("object"), processor, ObjectType.class, getObject());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureTypeBuilder extends SignatureType, RosettaModelObjectBuilder {
		SignedInfoType.SignedInfoTypeBuilder getOrCreateSignedInfo();
		SignedInfoType.SignedInfoTypeBuilder getSignedInfo();
		SignatureValueType.SignatureValueTypeBuilder getOrCreateSignatureValue();
		SignatureValueType.SignatureValueTypeBuilder getSignatureValue();
		KeyInfoType.KeyInfoTypeBuilder getOrCreateKeyInfo();
		KeyInfoType.KeyInfoTypeBuilder getKeyInfo();
		ObjectType.ObjectTypeBuilder getOrCreateObject(int _index);
		List<? extends ObjectType.ObjectTypeBuilder> getObject();
		SignatureType.SignatureTypeBuilder setSignedInfo(SignedInfoType signedInfo);
		SignatureType.SignatureTypeBuilder setSignatureValue(SignatureValueType signatureValue);
		SignatureType.SignatureTypeBuilder setKeyInfo(KeyInfoType keyInfo);
		SignatureType.SignatureTypeBuilder addObject(ObjectType object0);
		SignatureType.SignatureTypeBuilder addObject(ObjectType object1, int _idx);
		SignatureType.SignatureTypeBuilder addObject(List<? extends ObjectType> object2);
		SignatureType.SignatureTypeBuilder setObject(List<? extends ObjectType> object3);
		SignatureType.SignatureTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("signedInfo"), processor, SignedInfoType.SignedInfoTypeBuilder.class, getSignedInfo());
			processRosetta(path.newSubPath("signatureValue"), processor, SignatureValueType.SignatureValueTypeBuilder.class, getSignatureValue());
			processRosetta(path.newSubPath("keyInfo"), processor, KeyInfoType.KeyInfoTypeBuilder.class, getKeyInfo());
			processRosetta(path.newSubPath("object"), processor, ObjectType.ObjectTypeBuilder.class, getObject());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignatureType.SignatureTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureType  ***********************/
	class SignatureTypeImpl implements SignatureType {
		private final SignedInfoType signedInfo;
		private final SignatureValueType signatureValue;
		private final KeyInfoType keyInfo;
		private final List<? extends ObjectType> object;
		private final String id;
		
		protected SignatureTypeImpl(SignatureType.SignatureTypeBuilder builder) {
			this.signedInfo = ofNullable(builder.getSignedInfo()).map(f->f.build()).orElse(null);
			this.signatureValue = ofNullable(builder.getSignatureValue()).map(f->f.build()).orElse(null);
			this.keyInfo = ofNullable(builder.getKeyInfo()).map(f->f.build()).orElse(null);
			this.object = ofNullable(builder.getObject()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("signedInfo")
		public SignedInfoType getSignedInfo() {
			return signedInfo;
		}
		
		@Override
		@RosettaAttribute("signatureValue")
		public SignatureValueType getSignatureValue() {
			return signatureValue;
		}
		
		@Override
		@RosettaAttribute("keyInfo")
		public KeyInfoType getKeyInfo() {
			return keyInfo;
		}
		
		@Override
		@RosettaAttribute("object")
		public List<? extends ObjectType> getObject() {
			return object;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SignatureType build() {
			return this;
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder toBuilder() {
			SignatureType.SignatureTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureType.SignatureTypeBuilder builder) {
			ofNullable(getSignedInfo()).ifPresent(builder::setSignedInfo);
			ofNullable(getSignatureValue()).ifPresent(builder::setSignatureValue);
			ofNullable(getKeyInfo()).ifPresent(builder::setKeyInfo);
			ofNullable(getObject()).ifPresent(builder::setObject);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureType _that = getType().cast(o);
		
			if (!Objects.equals(signedInfo, _that.getSignedInfo())) return false;
			if (!Objects.equals(signatureValue, _that.getSignatureValue())) return false;
			if (!Objects.equals(keyInfo, _that.getKeyInfo())) return false;
			if (!ListEquals.listEquals(object, _that.getObject())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (signedInfo != null ? signedInfo.hashCode() : 0);
			_result = 31 * _result + (signatureValue != null ? signatureValue.hashCode() : 0);
			_result = 31 * _result + (keyInfo != null ? keyInfo.hashCode() : 0);
			_result = 31 * _result + (object != null ? object.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureType {" +
				"signedInfo=" + this.signedInfo + ", " +
				"signatureValue=" + this.signatureValue + ", " +
				"keyInfo=" + this.keyInfo + ", " +
				"object=" + this.object + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SignatureType  ***********************/
	class SignatureTypeBuilderImpl implements SignatureType.SignatureTypeBuilder {
	
		protected SignedInfoType.SignedInfoTypeBuilder signedInfo;
		protected SignatureValueType.SignatureValueTypeBuilder signatureValue;
		protected KeyInfoType.KeyInfoTypeBuilder keyInfo;
		protected List<ObjectType.ObjectTypeBuilder> object = new ArrayList<>();
		protected String id;
	
		public SignatureTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("signedInfo")
		public SignedInfoType.SignedInfoTypeBuilder getSignedInfo() {
			return signedInfo;
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder getOrCreateSignedInfo() {
			SignedInfoType.SignedInfoTypeBuilder result;
			if (signedInfo!=null) {
				result = signedInfo;
			}
			else {
				result = signedInfo = SignedInfoType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("signatureValue")
		public SignatureValueType.SignatureValueTypeBuilder getSignatureValue() {
			return signatureValue;
		}
		
		@Override
		public SignatureValueType.SignatureValueTypeBuilder getOrCreateSignatureValue() {
			SignatureValueType.SignatureValueTypeBuilder result;
			if (signatureValue!=null) {
				result = signatureValue;
			}
			else {
				result = signatureValue = SignatureValueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("keyInfo")
		public KeyInfoType.KeyInfoTypeBuilder getKeyInfo() {
			return keyInfo;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder getOrCreateKeyInfo() {
			KeyInfoType.KeyInfoTypeBuilder result;
			if (keyInfo!=null) {
				result = keyInfo;
			}
			else {
				result = keyInfo = KeyInfoType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("object")
		public List<? extends ObjectType.ObjectTypeBuilder> getObject() {
			return object;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder getOrCreateObject(int _index) {
		
			if (object==null) {
				this.object = new ArrayList<>();
			}
			ObjectType.ObjectTypeBuilder result;
			return getIndex(object, _index, () -> {
						ObjectType.ObjectTypeBuilder newObject = ObjectType.builder();
						return newObject;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("signedInfo")
		public SignatureType.SignatureTypeBuilder setSignedInfo(SignedInfoType signedInfo) {
			this.signedInfo = signedInfo==null?null:signedInfo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("signatureValue")
		public SignatureType.SignatureTypeBuilder setSignatureValue(SignatureValueType signatureValue) {
			this.signatureValue = signatureValue==null?null:signatureValue.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("keyInfo")
		public SignatureType.SignatureTypeBuilder setKeyInfo(KeyInfoType keyInfo) {
			this.keyInfo = keyInfo==null?null:keyInfo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("object")
		public SignatureType.SignatureTypeBuilder addObject(ObjectType object) {
			if (object!=null) this.object.add(object.toBuilder());
			return this;
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder addObject(ObjectType object, int _idx) {
			getIndex(this.object, _idx, () -> object.toBuilder());
			return this;
		}
		@Override 
		public SignatureType.SignatureTypeBuilder addObject(List<? extends ObjectType> objects) {
			if (objects != null) {
				for (ObjectType toAdd : objects) {
					this.object.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SignatureType.SignatureTypeBuilder setObject(List<? extends ObjectType> objects) {
			if (objects == null)  {
				this.object = new ArrayList<>();
			}
			else {
				this.object = objects.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public SignatureType.SignatureTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignatureType build() {
			return new SignatureType.SignatureTypeImpl(this);
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureType.SignatureTypeBuilder prune() {
			if (signedInfo!=null && !signedInfo.prune().hasData()) signedInfo = null;
			if (signatureValue!=null && !signatureValue.prune().hasData()) signatureValue = null;
			if (keyInfo!=null && !keyInfo.prune().hasData()) keyInfo = null;
			object = object.stream().filter(b->b!=null).<ObjectType.ObjectTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSignedInfo()!=null && getSignedInfo().hasData()) return true;
			if (getSignatureValue()!=null && getSignatureValue().hasData()) return true;
			if (getKeyInfo()!=null && getKeyInfo().hasData()) return true;
			if (getObject()!=null && getObject().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureType.SignatureTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignatureType.SignatureTypeBuilder o = (SignatureType.SignatureTypeBuilder) other;
			
			merger.mergeRosetta(getSignedInfo(), o.getSignedInfo(), this::setSignedInfo);
			merger.mergeRosetta(getSignatureValue(), o.getSignatureValue(), this::setSignatureValue);
			merger.mergeRosetta(getKeyInfo(), o.getKeyInfo(), this::setKeyInfo);
			merger.mergeRosetta(getObject(), o.getObject(), this::getOrCreateObject);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureType _that = getType().cast(o);
		
			if (!Objects.equals(signedInfo, _that.getSignedInfo())) return false;
			if (!Objects.equals(signatureValue, _that.getSignatureValue())) return false;
			if (!Objects.equals(keyInfo, _that.getKeyInfo())) return false;
			if (!ListEquals.listEquals(object, _that.getObject())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (signedInfo != null ? signedInfo.hashCode() : 0);
			_result = 31 * _result + (signatureValue != null ? signatureValue.hashCode() : 0);
			_result = 31 * _result + (keyInfo != null ? keyInfo.hashCode() : 0);
			_result = 31 * _result + (object != null ? object.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureTypeBuilder {" +
				"signedInfo=" + this.signedInfo + ", " +
				"signatureValue=" + this.signatureValue + ", " +
				"keyInfo=" + this.keyInfo + ", " +
				"object=" + this.object + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
