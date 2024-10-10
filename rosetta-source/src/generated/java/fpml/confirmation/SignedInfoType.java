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
import fpml.confirmation.CanonicalizationMethodType;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.SignatureMethodType;
import fpml.confirmation.SignedInfoType;
import fpml.confirmation.SignedInfoType.SignedInfoTypeBuilder;
import fpml.confirmation.SignedInfoType.SignedInfoTypeBuilderImpl;
import fpml.confirmation.SignedInfoType.SignedInfoTypeImpl;
import fpml.confirmation.meta.SignedInfoTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignedInfoType", builder=SignedInfoType.SignedInfoTypeBuilderImpl.class, version="${project.version}")
public interface SignedInfoType extends RosettaModelObject {

	SignedInfoTypeMeta metaData = new SignedInfoTypeMeta();

	/*********************** Getter Methods  ***********************/
	CanonicalizationMethodType getCanonicalizationMethod();
	SignatureMethodType getSignatureMethod();
	List<? extends ReferenceType> getReference();
	String getId();

	/*********************** Build Methods  ***********************/
	SignedInfoType build();
	
	SignedInfoType.SignedInfoTypeBuilder toBuilder();
	
	static SignedInfoType.SignedInfoTypeBuilder builder() {
		return new SignedInfoType.SignedInfoTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignedInfoType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignedInfoType> getType() {
		return SignedInfoType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.class, getCanonicalizationMethod());
		processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.class, getSignatureMethod());
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignedInfoTypeBuilder extends SignedInfoType, RosettaModelObjectBuilder {
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getOrCreateCanonicalizationMethod();
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getCanonicalizationMethod();
		SignatureMethodType.SignatureMethodTypeBuilder getOrCreateSignatureMethod();
		SignatureMethodType.SignatureMethodTypeBuilder getSignatureMethod();
		ReferenceType.ReferenceTypeBuilder getOrCreateReference(int _index);
		List<? extends ReferenceType.ReferenceTypeBuilder> getReference();
		SignedInfoType.SignedInfoTypeBuilder setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethod);
		SignedInfoType.SignedInfoTypeBuilder setSignatureMethod(SignatureMethodType signatureMethod);
		SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType reference0);
		SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType reference1, int _idx);
		SignedInfoType.SignedInfoTypeBuilder addReference(List<? extends ReferenceType> reference2);
		SignedInfoType.SignedInfoTypeBuilder setReference(List<? extends ReferenceType> reference3);
		SignedInfoType.SignedInfoTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.CanonicalizationMethodTypeBuilder.class, getCanonicalizationMethod());
			processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.SignatureMethodTypeBuilder.class, getSignatureMethod());
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignedInfoType.SignedInfoTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignedInfoType  ***********************/
	class SignedInfoTypeImpl implements SignedInfoType {
		private final CanonicalizationMethodType canonicalizationMethod;
		private final SignatureMethodType signatureMethod;
		private final List<? extends ReferenceType> reference;
		private final String id;
		
		protected SignedInfoTypeImpl(SignedInfoType.SignedInfoTypeBuilder builder) {
			this.canonicalizationMethod = ofNullable(builder.getCanonicalizationMethod()).map(f->f.build()).orElse(null);
			this.signatureMethod = ofNullable(builder.getSignatureMethod()).map(f->f.build()).orElse(null);
			this.reference = ofNullable(builder.getReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("canonicalizationMethod")
		public CanonicalizationMethodType getCanonicalizationMethod() {
			return canonicalizationMethod;
		}
		
		@Override
		@RosettaAttribute("signatureMethod")
		public SignatureMethodType getSignatureMethod() {
			return signatureMethod;
		}
		
		@Override
		@RosettaAttribute("reference")
		public List<? extends ReferenceType> getReference() {
			return reference;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SignedInfoType build() {
			return this;
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder toBuilder() {
			SignedInfoType.SignedInfoTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignedInfoType.SignedInfoTypeBuilder builder) {
			ofNullable(getCanonicalizationMethod()).ifPresent(builder::setCanonicalizationMethod);
			ofNullable(getSignatureMethod()).ifPresent(builder::setSignatureMethod);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignedInfoType _that = getType().cast(o);
		
			if (!Objects.equals(canonicalizationMethod, _that.getCanonicalizationMethod())) return false;
			if (!Objects.equals(signatureMethod, _that.getSignatureMethod())) return false;
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (canonicalizationMethod != null ? canonicalizationMethod.hashCode() : 0);
			_result = 31 * _result + (signatureMethod != null ? signatureMethod.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignedInfoType {" +
				"canonicalizationMethod=" + this.canonicalizationMethod + ", " +
				"signatureMethod=" + this.signatureMethod + ", " +
				"reference=" + this.reference + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SignedInfoType  ***********************/
	class SignedInfoTypeBuilderImpl implements SignedInfoType.SignedInfoTypeBuilder {
	
		protected CanonicalizationMethodType.CanonicalizationMethodTypeBuilder canonicalizationMethod;
		protected SignatureMethodType.SignatureMethodTypeBuilder signatureMethod;
		protected List<ReferenceType.ReferenceTypeBuilder> reference = new ArrayList<>();
		protected String id;
	
		public SignedInfoTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("canonicalizationMethod")
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getCanonicalizationMethod() {
			return canonicalizationMethod;
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getOrCreateCanonicalizationMethod() {
			CanonicalizationMethodType.CanonicalizationMethodTypeBuilder result;
			if (canonicalizationMethod!=null) {
				result = canonicalizationMethod;
			}
			else {
				result = canonicalizationMethod = CanonicalizationMethodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("signatureMethod")
		public SignatureMethodType.SignatureMethodTypeBuilder getSignatureMethod() {
			return signatureMethod;
		}
		
		@Override
		public SignatureMethodType.SignatureMethodTypeBuilder getOrCreateSignatureMethod() {
			SignatureMethodType.SignatureMethodTypeBuilder result;
			if (signatureMethod!=null) {
				result = signatureMethod;
			}
			else {
				result = signatureMethod = SignatureMethodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reference")
		public List<? extends ReferenceType.ReferenceTypeBuilder> getReference() {
			return reference;
		}
		
		public ReferenceType.ReferenceTypeBuilder getOrCreateReference(int _index) {
		
			if (reference==null) {
				this.reference = new ArrayList<>();
			}
			ReferenceType.ReferenceTypeBuilder result;
			return getIndex(reference, _index, () -> {
						ReferenceType.ReferenceTypeBuilder newReference = ReferenceType.builder();
						return newReference;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("canonicalizationMethod")
		public SignedInfoType.SignedInfoTypeBuilder setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethod) {
			this.canonicalizationMethod = canonicalizationMethod==null?null:canonicalizationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("signatureMethod")
		public SignedInfoType.SignedInfoTypeBuilder setSignatureMethod(SignatureMethodType signatureMethod) {
			this.signatureMethod = signatureMethod==null?null:signatureMethod.toBuilder();
			return this;
		}
		@Override
		public SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType reference) {
			if (reference!=null) this.reference.add(reference.toBuilder());
			return this;
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType reference, int _idx) {
			getIndex(this.reference, _idx, () -> reference.toBuilder());
			return this;
		}
		@Override 
		public SignedInfoType.SignedInfoTypeBuilder addReference(List<? extends ReferenceType> references) {
			if (references != null) {
				for (ReferenceType toAdd : references) {
					this.reference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reference")
		public SignedInfoType.SignedInfoTypeBuilder setReference(List<? extends ReferenceType> references) {
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
		public SignedInfoType.SignedInfoTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignedInfoType build() {
			return new SignedInfoType.SignedInfoTypeImpl(this);
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder prune() {
			if (canonicalizationMethod!=null && !canonicalizationMethod.prune().hasData()) canonicalizationMethod = null;
			if (signatureMethod!=null && !signatureMethod.prune().hasData()) signatureMethod = null;
			reference = reference.stream().filter(b->b!=null).<ReferenceType.ReferenceTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCanonicalizationMethod()!=null && getCanonicalizationMethod().hasData()) return true;
			if (getSignatureMethod()!=null && getSignatureMethod().hasData()) return true;
			if (getReference()!=null && getReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignedInfoType.SignedInfoTypeBuilder o = (SignedInfoType.SignedInfoTypeBuilder) other;
			
			merger.mergeRosetta(getCanonicalizationMethod(), o.getCanonicalizationMethod(), this::setCanonicalizationMethod);
			merger.mergeRosetta(getSignatureMethod(), o.getSignatureMethod(), this::setSignatureMethod);
			merger.mergeRosetta(getReference(), o.getReference(), this::getOrCreateReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignedInfoType _that = getType().cast(o);
		
			if (!Objects.equals(canonicalizationMethod, _that.getCanonicalizationMethod())) return false;
			if (!Objects.equals(signatureMethod, _that.getSignatureMethod())) return false;
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (canonicalizationMethod != null ? canonicalizationMethod.hashCode() : 0);
			_result = 31 * _result + (signatureMethod != null ? signatureMethod.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignedInfoTypeBuilder {" +
				"canonicalizationMethod=" + this.canonicalizationMethod + ", " +
				"signatureMethod=" + this.signatureMethod + ", " +
				"reference=" + this.reference + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
