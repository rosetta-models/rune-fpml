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
import fpml.confirmation.SignaturePropertiesType;
import fpml.confirmation.SignaturePropertiesType.SignaturePropertiesTypeBuilder;
import fpml.confirmation.SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl;
import fpml.confirmation.SignaturePropertiesType.SignaturePropertiesTypeImpl;
import fpml.confirmation.SignaturePropertyType;
import fpml.confirmation.meta.SignaturePropertiesTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignaturePropertiesType", builder=SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl.class, version="${project.version}")
public interface SignaturePropertiesType extends RosettaModelObject {

	SignaturePropertiesTypeMeta metaData = new SignaturePropertiesTypeMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends SignaturePropertyType> getSignatureProperty();
	String getId();

	/*********************** Build Methods  ***********************/
	SignaturePropertiesType build();
	
	SignaturePropertiesType.SignaturePropertiesTypeBuilder toBuilder();
	
	static SignaturePropertiesType.SignaturePropertiesTypeBuilder builder() {
		return new SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignaturePropertiesType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignaturePropertiesType> getType() {
		return SignaturePropertiesType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.class, getSignatureProperty());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertiesTypeBuilder extends SignaturePropertiesType, RosettaModelObjectBuilder {
		SignaturePropertyType.SignaturePropertyTypeBuilder getOrCreateSignatureProperty(int _index);
		List<? extends SignaturePropertyType.SignaturePropertyTypeBuilder> getSignatureProperty();
		SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType signatureProperty0);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType signatureProperty1, int _idx);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(List<? extends SignaturePropertyType> signatureProperty2);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder setSignatureProperty(List<? extends SignaturePropertyType> signatureProperty3);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.SignaturePropertyTypeBuilder.class, getSignatureProperty());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignaturePropertiesType.SignaturePropertiesTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignaturePropertiesType  ***********************/
	class SignaturePropertiesTypeImpl implements SignaturePropertiesType {
		private final List<? extends SignaturePropertyType> signatureProperty;
		private final String id;
		
		protected SignaturePropertiesTypeImpl(SignaturePropertiesType.SignaturePropertiesTypeBuilder builder) {
			this.signatureProperty = ofNullable(builder.getSignatureProperty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("signatureProperty")
		public List<? extends SignaturePropertyType> getSignatureProperty() {
			return signatureProperty;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SignaturePropertiesType build() {
			return this;
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder toBuilder() {
			SignaturePropertiesType.SignaturePropertiesTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignaturePropertiesType.SignaturePropertiesTypeBuilder builder) {
			ofNullable(getSignatureProperty()).ifPresent(builder::setSignatureProperty);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertiesType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(signatureProperty, _that.getSignatureProperty())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (signatureProperty != null ? signatureProperty.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertiesType {" +
				"signatureProperty=" + this.signatureProperty + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SignaturePropertiesType  ***********************/
	class SignaturePropertiesTypeBuilderImpl implements SignaturePropertiesType.SignaturePropertiesTypeBuilder {
	
		protected List<SignaturePropertyType.SignaturePropertyTypeBuilder> signatureProperty = new ArrayList<>();
		protected String id;
	
		public SignaturePropertiesTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("signatureProperty")
		public List<? extends SignaturePropertyType.SignaturePropertyTypeBuilder> getSignatureProperty() {
			return signatureProperty;
		}
		
		public SignaturePropertyType.SignaturePropertyTypeBuilder getOrCreateSignatureProperty(int _index) {
		
			if (signatureProperty==null) {
				this.signatureProperty = new ArrayList<>();
			}
			SignaturePropertyType.SignaturePropertyTypeBuilder result;
			return getIndex(signatureProperty, _index, () -> {
						SignaturePropertyType.SignaturePropertyTypeBuilder newSignatureProperty = SignaturePropertyType.builder();
						return newSignatureProperty;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType signatureProperty) {
			if (signatureProperty!=null) this.signatureProperty.add(signatureProperty.toBuilder());
			return this;
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType signatureProperty, int _idx) {
			getIndex(this.signatureProperty, _idx, () -> signatureProperty.toBuilder());
			return this;
		}
		@Override 
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
			if (signaturePropertys != null) {
				for (SignaturePropertyType toAdd : signaturePropertys) {
					this.signatureProperty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("signatureProperty")
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder setSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
			if (signaturePropertys == null)  {
				this.signatureProperty = new ArrayList<>();
			}
			else {
				this.signatureProperty = signaturePropertys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignaturePropertiesType build() {
			return new SignaturePropertiesType.SignaturePropertiesTypeImpl(this);
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder prune() {
			signatureProperty = signatureProperty.stream().filter(b->b!=null).<SignaturePropertyType.SignaturePropertyTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSignatureProperty()!=null && getSignatureProperty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignaturePropertiesType.SignaturePropertiesTypeBuilder o = (SignaturePropertiesType.SignaturePropertiesTypeBuilder) other;
			
			merger.mergeRosetta(getSignatureProperty(), o.getSignatureProperty(), this::getOrCreateSignatureProperty);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertiesType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(signatureProperty, _that.getSignatureProperty())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (signatureProperty != null ? signatureProperty.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertiesTypeBuilder {" +
				"signatureProperty=" + this.signatureProperty + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
