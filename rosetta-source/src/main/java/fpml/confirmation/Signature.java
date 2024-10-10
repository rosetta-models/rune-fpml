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
import fpml.confirmation.KeyInfoType;
import fpml.confirmation.ObjectType;
import fpml.confirmation.Signature;
import fpml.confirmation.Signature.SignatureBuilder;
import fpml.confirmation.Signature.SignatureBuilderImpl;
import fpml.confirmation.Signature.SignatureImpl;
import fpml.confirmation.SignatureType;
import fpml.confirmation.SignatureType.SignatureTypeBuilder;
import fpml.confirmation.SignatureType.SignatureTypeBuilderImpl;
import fpml.confirmation.SignatureType.SignatureTypeImpl;
import fpml.confirmation.SignatureValueType;
import fpml.confirmation.SignedInfoType;
import fpml.confirmation.meta.SignatureMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="Signature", builder=Signature.SignatureBuilderImpl.class, version="${project.version}")
public interface Signature extends SignatureType {

	SignatureMeta metaData = new SignatureMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Signature build();
	
	Signature.SignatureBuilder toBuilder();
	
	static Signature.SignatureBuilder builder() {
		return new Signature.SignatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Signature> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Signature> getType() {
		return Signature.class;
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
	interface SignatureBuilder extends Signature, SignatureType.SignatureTypeBuilder {
		Signature.SignatureBuilder setSignedInfo(SignedInfoType signedInfo);
		Signature.SignatureBuilder setSignatureValue(SignatureValueType signatureValue);
		Signature.SignatureBuilder setKeyInfo(KeyInfoType keyInfo);
		Signature.SignatureBuilder addObject(ObjectType object0);
		Signature.SignatureBuilder addObject(ObjectType object1, int _idx);
		Signature.SignatureBuilder addObject(List<? extends ObjectType> object2);
		Signature.SignatureBuilder setObject(List<? extends ObjectType> object3);
		Signature.SignatureBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("signedInfo"), processor, SignedInfoType.SignedInfoTypeBuilder.class, getSignedInfo());
			processRosetta(path.newSubPath("signatureValue"), processor, SignatureValueType.SignatureValueTypeBuilder.class, getSignatureValue());
			processRosetta(path.newSubPath("keyInfo"), processor, KeyInfoType.KeyInfoTypeBuilder.class, getKeyInfo());
			processRosetta(path.newSubPath("object"), processor, ObjectType.ObjectTypeBuilder.class, getObject());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Signature.SignatureBuilder prune();
	}

	/*********************** Immutable Implementation of Signature  ***********************/
	class SignatureImpl extends SignatureType.SignatureTypeImpl implements Signature {
		
		protected SignatureImpl(Signature.SignatureBuilder builder) {
			super(builder);
		}
		
		@Override
		public Signature build() {
			return this;
		}
		
		@Override
		public Signature.SignatureBuilder toBuilder() {
			Signature.SignatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Signature.SignatureBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "Signature {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Signature  ***********************/
	class SignatureBuilderImpl extends SignatureType.SignatureTypeBuilderImpl  implements Signature.SignatureBuilder {
	
	
		public SignatureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("signedInfo")
		public Signature.SignatureBuilder setSignedInfo(SignedInfoType signedInfo) {
			this.signedInfo = signedInfo==null?null:signedInfo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("signatureValue")
		public Signature.SignatureBuilder setSignatureValue(SignatureValueType signatureValue) {
			this.signatureValue = signatureValue==null?null:signatureValue.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("keyInfo")
		public Signature.SignatureBuilder setKeyInfo(KeyInfoType keyInfo) {
			this.keyInfo = keyInfo==null?null:keyInfo.toBuilder();
			return this;
		}
		@Override
		public Signature.SignatureBuilder addObject(ObjectType object) {
			if (object!=null) this.object.add(object.toBuilder());
			return this;
		}
		
		@Override
		public Signature.SignatureBuilder addObject(ObjectType object, int _idx) {
			getIndex(this.object, _idx, () -> object.toBuilder());
			return this;
		}
		@Override 
		public Signature.SignatureBuilder addObject(List<? extends ObjectType> objects) {
			if (objects != null) {
				for (ObjectType toAdd : objects) {
					this.object.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("object")
		public Signature.SignatureBuilder setObject(List<? extends ObjectType> objects) {
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
		public Signature.SignatureBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Signature build() {
			return new Signature.SignatureImpl(this);
		}
		
		@Override
		public Signature.SignatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Signature.SignatureBuilder prune() {
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
		public Signature.SignatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Signature.SignatureBuilder o = (Signature.SignatureBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "SignatureBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
