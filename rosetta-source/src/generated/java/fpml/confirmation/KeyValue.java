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
import fpml.confirmation.DSAKeyValueType;
import fpml.confirmation.KeyValue;
import fpml.confirmation.KeyValue.KeyValueBuilder;
import fpml.confirmation.KeyValue.KeyValueBuilderImpl;
import fpml.confirmation.KeyValue.KeyValueImpl;
import fpml.confirmation.KeyValueType;
import fpml.confirmation.KeyValueType.KeyValueTypeBuilder;
import fpml.confirmation.KeyValueType.KeyValueTypeBuilderImpl;
import fpml.confirmation.KeyValueType.KeyValueTypeImpl;
import fpml.confirmation.RSAKeyValueType;
import fpml.confirmation.meta.KeyValueMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="KeyValue", builder=KeyValue.KeyValueBuilderImpl.class, version="${project.version}")
public interface KeyValue extends KeyValueType {

	KeyValueMeta metaData = new KeyValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	KeyValue build();
	
	KeyValue.KeyValueBuilder toBuilder();
	
	static KeyValue.KeyValueBuilder builder() {
		return new KeyValue.KeyValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyValue> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends KeyValue> getType() {
		return KeyValue.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.class, getDsaKeyValue());
		processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.class, getRsaKeyValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyValueBuilder extends KeyValue, KeyValueType.KeyValueTypeBuilder {
		KeyValue.KeyValueBuilder setDsaKeyValue(DSAKeyValueType dsaKeyValue);
		KeyValue.KeyValueBuilder setRsaKeyValue(RSAKeyValueType rsaKeyValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.DSAKeyValueTypeBuilder.class, getDsaKeyValue());
			processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.RSAKeyValueTypeBuilder.class, getRsaKeyValue());
		}
		

		KeyValue.KeyValueBuilder prune();
	}

	/*********************** Immutable Implementation of KeyValue  ***********************/
	class KeyValueImpl extends KeyValueType.KeyValueTypeImpl implements KeyValue {
		
		protected KeyValueImpl(KeyValue.KeyValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public KeyValue build() {
			return this;
		}
		
		@Override
		public KeyValue.KeyValueBuilder toBuilder() {
			KeyValue.KeyValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyValue.KeyValueBuilder builder) {
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
			return "KeyValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of KeyValue  ***********************/
	class KeyValueBuilderImpl extends KeyValueType.KeyValueTypeBuilderImpl  implements KeyValue.KeyValueBuilder {
	
	
		public KeyValueBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dsaKeyValue")
		public KeyValue.KeyValueBuilder setDsaKeyValue(DSAKeyValueType dsaKeyValue) {
			this.dsaKeyValue = dsaKeyValue==null?null:dsaKeyValue.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rsaKeyValue")
		public KeyValue.KeyValueBuilder setRsaKeyValue(RSAKeyValueType rsaKeyValue) {
			this.rsaKeyValue = rsaKeyValue==null?null:rsaKeyValue.toBuilder();
			return this;
		}
		
		@Override
		public KeyValue build() {
			return new KeyValue.KeyValueImpl(this);
		}
		
		@Override
		public KeyValue.KeyValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyValue.KeyValueBuilder prune() {
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
		public KeyValue.KeyValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			KeyValue.KeyValueBuilder o = (KeyValue.KeyValueBuilder) other;
			
			
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
			return "KeyValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
