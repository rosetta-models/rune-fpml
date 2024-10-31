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
import fpml.confirmation.SignatureProperties;
import fpml.confirmation.SignatureProperties.SignaturePropertiesBuilder;
import fpml.confirmation.SignatureProperties.SignaturePropertiesBuilderImpl;
import fpml.confirmation.SignatureProperties.SignaturePropertiesImpl;
import fpml.confirmation.SignaturePropertiesType;
import fpml.confirmation.SignaturePropertiesType.SignaturePropertiesTypeBuilder;
import fpml.confirmation.SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl;
import fpml.confirmation.SignaturePropertiesType.SignaturePropertiesTypeImpl;
import fpml.confirmation.SignaturePropertyType;
import fpml.confirmation.meta.SignaturePropertiesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignatureProperties", builder=SignatureProperties.SignaturePropertiesBuilderImpl.class, version="${project.version}")
public interface SignatureProperties extends SignaturePropertiesType {

	SignaturePropertiesMeta metaData = new SignaturePropertiesMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureProperties build();
	
	SignatureProperties.SignaturePropertiesBuilder toBuilder();
	
	static SignatureProperties.SignaturePropertiesBuilder builder() {
		return new SignatureProperties.SignaturePropertiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureProperties> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignatureProperties> getType() {
		return SignatureProperties.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.class, getSignatureProperty());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertiesBuilder extends SignatureProperties, SignaturePropertiesType.SignaturePropertiesTypeBuilder {
		SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType signatureProperty0);
		SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType signatureProperty1, int _idx);
		SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(List<? extends SignaturePropertyType> signatureProperty2);
		SignatureProperties.SignaturePropertiesBuilder setSignatureProperty(List<? extends SignaturePropertyType> signatureProperty3);
		SignatureProperties.SignaturePropertiesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.SignaturePropertyTypeBuilder.class, getSignatureProperty());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignatureProperties.SignaturePropertiesBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureProperties  ***********************/
	class SignaturePropertiesImpl extends SignaturePropertiesType.SignaturePropertiesTypeImpl implements SignatureProperties {
		
		protected SignaturePropertiesImpl(SignatureProperties.SignaturePropertiesBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureProperties build() {
			return this;
		}
		
		@Override
		public SignatureProperties.SignaturePropertiesBuilder toBuilder() {
			SignatureProperties.SignaturePropertiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureProperties.SignaturePropertiesBuilder builder) {
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
			return "SignatureProperties {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureProperties  ***********************/
	class SignaturePropertiesBuilderImpl extends SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl  implements SignatureProperties.SignaturePropertiesBuilder {
	
	
		public SignaturePropertiesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("signatureProperty")
		public SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType signatureProperty) {
			if (signatureProperty!=null) this.signatureProperty.add(signatureProperty.toBuilder());
			return this;
		}
		
		@Override
		public SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType signatureProperty, int _idx) {
			getIndex(this.signatureProperty, _idx, () -> signatureProperty.toBuilder());
			return this;
		}
		@Override 
		public SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
			if (signaturePropertys != null) {
				for (SignaturePropertyType toAdd : signaturePropertys) {
					this.signatureProperty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SignatureProperties.SignaturePropertiesBuilder setSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
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
		public SignatureProperties.SignaturePropertiesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignatureProperties build() {
			return new SignatureProperties.SignaturePropertiesImpl(this);
		}
		
		@Override
		public SignatureProperties.SignaturePropertiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureProperties.SignaturePropertiesBuilder prune() {
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
		public SignatureProperties.SignaturePropertiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SignatureProperties.SignaturePropertiesBuilder o = (SignatureProperties.SignaturePropertiesBuilder) other;
			
			
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
			return "SignaturePropertiesBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
