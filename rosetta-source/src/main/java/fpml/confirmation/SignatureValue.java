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
import fpml.confirmation.SignatureValue;
import fpml.confirmation.SignatureValue.SignatureValueBuilder;
import fpml.confirmation.SignatureValue.SignatureValueBuilderImpl;
import fpml.confirmation.SignatureValue.SignatureValueImpl;
import fpml.confirmation.SignatureValueType;
import fpml.confirmation.SignatureValueType.SignatureValueTypeBuilder;
import fpml.confirmation.SignatureValueType.SignatureValueTypeBuilderImpl;
import fpml.confirmation.SignatureValueType.SignatureValueTypeImpl;
import fpml.confirmation.meta.SignatureValueMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignatureValue", builder=SignatureValue.SignatureValueBuilderImpl.class, version="${project.version}")
public interface SignatureValue extends SignatureValueType {

	SignatureValueMeta metaData = new SignatureValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureValue build();
	
	SignatureValue.SignatureValueBuilder toBuilder();
	
	static SignatureValue.SignatureValueBuilder builder() {
		return new SignatureValue.SignatureValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureValue> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignatureValue> getType() {
		return SignatureValue.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureValueBuilder extends SignatureValue, SignatureValueType.SignatureValueTypeBuilder {
		SignatureValue.SignatureValueBuilder setValue(String value);
		SignatureValue.SignatureValueBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignatureValue.SignatureValueBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureValue  ***********************/
	class SignatureValueImpl extends SignatureValueType.SignatureValueTypeImpl implements SignatureValue {
		
		protected SignatureValueImpl(SignatureValue.SignatureValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureValue build() {
			return this;
		}
		
		@Override
		public SignatureValue.SignatureValueBuilder toBuilder() {
			SignatureValue.SignatureValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureValue.SignatureValueBuilder builder) {
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
			return "SignatureValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureValue  ***********************/
	class SignatureValueBuilderImpl extends SignatureValueType.SignatureValueTypeBuilderImpl  implements SignatureValue.SignatureValueBuilder {
	
	
		public SignatureValueBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public SignatureValue.SignatureValueBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SignatureValue.SignatureValueBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignatureValue build() {
			return new SignatureValue.SignatureValueImpl(this);
		}
		
		@Override
		public SignatureValue.SignatureValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureValue.SignatureValueBuilder prune() {
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
		public SignatureValue.SignatureValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SignatureValue.SignatureValueBuilder o = (SignatureValue.SignatureValueBuilder) other;
			
			
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
			return "SignatureValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
