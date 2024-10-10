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
import fpml.confirmation.RSAKeyValue;
import fpml.confirmation.RSAKeyValue.RSAKeyValueBuilder;
import fpml.confirmation.RSAKeyValue.RSAKeyValueBuilderImpl;
import fpml.confirmation.RSAKeyValue.RSAKeyValueImpl;
import fpml.confirmation.RSAKeyValueType;
import fpml.confirmation.RSAKeyValueType.RSAKeyValueTypeBuilder;
import fpml.confirmation.RSAKeyValueType.RSAKeyValueTypeBuilderImpl;
import fpml.confirmation.RSAKeyValueType.RSAKeyValueTypeImpl;
import fpml.confirmation.meta.RSAKeyValueMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="RSAKeyValue", builder=RSAKeyValue.RSAKeyValueBuilderImpl.class, version="${project.version}")
public interface RSAKeyValue extends RSAKeyValueType {

	RSAKeyValueMeta metaData = new RSAKeyValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RSAKeyValue build();
	
	RSAKeyValue.RSAKeyValueBuilder toBuilder();
	
	static RSAKeyValue.RSAKeyValueBuilder builder() {
		return new RSAKeyValue.RSAKeyValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RSAKeyValue> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RSAKeyValue> getType() {
		return RSAKeyValue.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("modulus"), String.class, getModulus(), this);
		processor.processBasic(path.newSubPath("exponent"), String.class, getExponent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RSAKeyValueBuilder extends RSAKeyValue, RSAKeyValueType.RSAKeyValueTypeBuilder {
		RSAKeyValue.RSAKeyValueBuilder setModulus(String modulus);
		RSAKeyValue.RSAKeyValueBuilder setExponent(String exponent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("modulus"), String.class, getModulus(), this);
			processor.processBasic(path.newSubPath("exponent"), String.class, getExponent(), this);
		}
		

		RSAKeyValue.RSAKeyValueBuilder prune();
	}

	/*********************** Immutable Implementation of RSAKeyValue  ***********************/
	class RSAKeyValueImpl extends RSAKeyValueType.RSAKeyValueTypeImpl implements RSAKeyValue {
		
		protected RSAKeyValueImpl(RSAKeyValue.RSAKeyValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public RSAKeyValue build() {
			return this;
		}
		
		@Override
		public RSAKeyValue.RSAKeyValueBuilder toBuilder() {
			RSAKeyValue.RSAKeyValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RSAKeyValue.RSAKeyValueBuilder builder) {
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
			return "RSAKeyValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RSAKeyValue  ***********************/
	class RSAKeyValueBuilderImpl extends RSAKeyValueType.RSAKeyValueTypeBuilderImpl  implements RSAKeyValue.RSAKeyValueBuilder {
	
	
		public RSAKeyValueBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("modulus")
		public RSAKeyValue.RSAKeyValueBuilder setModulus(String modulus) {
			this.modulus = modulus==null?null:modulus;
			return this;
		}
		@Override
		@RosettaAttribute("exponent")
		public RSAKeyValue.RSAKeyValueBuilder setExponent(String exponent) {
			this.exponent = exponent==null?null:exponent;
			return this;
		}
		
		@Override
		public RSAKeyValue build() {
			return new RSAKeyValue.RSAKeyValueImpl(this);
		}
		
		@Override
		public RSAKeyValue.RSAKeyValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RSAKeyValue.RSAKeyValueBuilder prune() {
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
		public RSAKeyValue.RSAKeyValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RSAKeyValue.RSAKeyValueBuilder o = (RSAKeyValue.RSAKeyValueBuilder) other;
			
			
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
			return "RSAKeyValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
