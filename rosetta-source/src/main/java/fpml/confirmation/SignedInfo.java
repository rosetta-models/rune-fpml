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
import fpml.confirmation.CanonicalizationMethodType;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.SignatureMethodType;
import fpml.confirmation.SignedInfo;
import fpml.confirmation.SignedInfo.SignedInfoBuilder;
import fpml.confirmation.SignedInfo.SignedInfoBuilderImpl;
import fpml.confirmation.SignedInfo.SignedInfoImpl;
import fpml.confirmation.SignedInfoType;
import fpml.confirmation.SignedInfoType.SignedInfoTypeBuilder;
import fpml.confirmation.SignedInfoType.SignedInfoTypeBuilderImpl;
import fpml.confirmation.SignedInfoType.SignedInfoTypeImpl;
import fpml.confirmation.meta.SignedInfoMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SignedInfo", builder=SignedInfo.SignedInfoBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SignedInfo extends SignedInfoType {

	SignedInfoMeta metaData = new SignedInfoMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignedInfo build();
	
	SignedInfo.SignedInfoBuilder toBuilder();
	
	static SignedInfo.SignedInfoBuilder builder() {
		return new SignedInfo.SignedInfoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignedInfo> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignedInfo> getType() {
		return SignedInfo.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.class, getCanonicalizationMethod());
		processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.class, getSignatureMethod());
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignedInfoBuilder extends SignedInfo, SignedInfoType.SignedInfoTypeBuilder {
		SignedInfo.SignedInfoBuilder setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethod);
		SignedInfo.SignedInfoBuilder setSignatureMethod(SignatureMethodType signatureMethod);
		SignedInfo.SignedInfoBuilder addReference(ReferenceType reference0);
		SignedInfo.SignedInfoBuilder addReference(ReferenceType reference1, int _idx);
		SignedInfo.SignedInfoBuilder addReference(List<? extends ReferenceType> reference2);
		SignedInfo.SignedInfoBuilder setReference(List<? extends ReferenceType> reference3);
		SignedInfo.SignedInfoBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.CanonicalizationMethodTypeBuilder.class, getCanonicalizationMethod());
			processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.SignatureMethodTypeBuilder.class, getSignatureMethod());
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignedInfo.SignedInfoBuilder prune();
	}

	/*********************** Immutable Implementation of SignedInfo  ***********************/
	class SignedInfoImpl extends SignedInfoType.SignedInfoTypeImpl implements SignedInfo {
		
		protected SignedInfoImpl(SignedInfo.SignedInfoBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignedInfo build() {
			return this;
		}
		
		@Override
		public SignedInfo.SignedInfoBuilder toBuilder() {
			SignedInfo.SignedInfoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignedInfo.SignedInfoBuilder builder) {
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
			return "SignedInfo {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignedInfo  ***********************/
	class SignedInfoBuilderImpl extends SignedInfoType.SignedInfoTypeBuilderImpl  implements SignedInfo.SignedInfoBuilder {
	
	
		public SignedInfoBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("canonicalizationMethod")
		public SignedInfo.SignedInfoBuilder setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethod) {
			this.canonicalizationMethod = canonicalizationMethod==null?null:canonicalizationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("signatureMethod")
		public SignedInfo.SignedInfoBuilder setSignatureMethod(SignatureMethodType signatureMethod) {
			this.signatureMethod = signatureMethod==null?null:signatureMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("reference")
		public SignedInfo.SignedInfoBuilder addReference(ReferenceType reference) {
			if (reference!=null) this.reference.add(reference.toBuilder());
			return this;
		}
		
		@Override
		public SignedInfo.SignedInfoBuilder addReference(ReferenceType reference, int _idx) {
			getIndex(this.reference, _idx, () -> reference.toBuilder());
			return this;
		}
		@Override 
		public SignedInfo.SignedInfoBuilder addReference(List<? extends ReferenceType> references) {
			if (references != null) {
				for (ReferenceType toAdd : references) {
					this.reference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SignedInfo.SignedInfoBuilder setReference(List<? extends ReferenceType> references) {
			if (references == null)  {
				this.reference = new ArrayList<>();
			}
			else {
				this.reference = references.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public SignedInfo.SignedInfoBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignedInfo build() {
			return new SignedInfo.SignedInfoImpl(this);
		}
		
		@Override
		public SignedInfo.SignedInfoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignedInfo.SignedInfoBuilder prune() {
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
		public SignedInfo.SignedInfoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SignedInfo.SignedInfoBuilder o = (SignedInfo.SignedInfoBuilder) other;
			
			
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
			return "SignedInfoBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
