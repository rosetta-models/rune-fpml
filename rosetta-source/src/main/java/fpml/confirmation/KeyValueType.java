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
import fpml.confirmation.KeyValueType;
import fpml.confirmation.KeyValueType.KeyValueTypeBuilder;
import fpml.confirmation.KeyValueType.KeyValueTypeBuilderImpl;
import fpml.confirmation.KeyValueType.KeyValueTypeImpl;
import fpml.confirmation.RSAKeyValueType;
import fpml.confirmation.meta.KeyValueTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="KeyValueType", builder=KeyValueType.KeyValueTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface KeyValueType extends RosettaModelObject {

	KeyValueTypeMeta metaData = new KeyValueTypeMeta();

	/*********************** Getter Methods  ***********************/
	DSAKeyValueType getDsaKeyValue();
	RSAKeyValueType getRsaKeyValue();

	/*********************** Build Methods  ***********************/
	KeyValueType build();
	
	KeyValueType.KeyValueTypeBuilder toBuilder();
	
	static KeyValueType.KeyValueTypeBuilder builder() {
		return new KeyValueType.KeyValueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyValueType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends KeyValueType> getType() {
		return KeyValueType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.class, getDsaKeyValue());
		processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.class, getRsaKeyValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyValueTypeBuilder extends KeyValueType, RosettaModelObjectBuilder {
		DSAKeyValueType.DSAKeyValueTypeBuilder getOrCreateDsaKeyValue();
		DSAKeyValueType.DSAKeyValueTypeBuilder getDsaKeyValue();
		RSAKeyValueType.RSAKeyValueTypeBuilder getOrCreateRsaKeyValue();
		RSAKeyValueType.RSAKeyValueTypeBuilder getRsaKeyValue();
		KeyValueType.KeyValueTypeBuilder setDsaKeyValue(DSAKeyValueType dsaKeyValue);
		KeyValueType.KeyValueTypeBuilder setRsaKeyValue(RSAKeyValueType rsaKeyValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.DSAKeyValueTypeBuilder.class, getDsaKeyValue());
			processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.RSAKeyValueTypeBuilder.class, getRsaKeyValue());
		}
		

		KeyValueType.KeyValueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of KeyValueType  ***********************/
	class KeyValueTypeImpl implements KeyValueType {
		private final DSAKeyValueType dsaKeyValue;
		private final RSAKeyValueType rsaKeyValue;
		
		protected KeyValueTypeImpl(KeyValueType.KeyValueTypeBuilder builder) {
			this.dsaKeyValue = ofNullable(builder.getDsaKeyValue()).map(f->f.build()).orElse(null);
			this.rsaKeyValue = ofNullable(builder.getRsaKeyValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dsaKeyValue")
		public DSAKeyValueType getDsaKeyValue() {
			return dsaKeyValue;
		}
		
		@Override
		@RosettaAttribute("rsaKeyValue")
		public RSAKeyValueType getRsaKeyValue() {
			return rsaKeyValue;
		}
		
		@Override
		public KeyValueType build() {
			return this;
		}
		
		@Override
		public KeyValueType.KeyValueTypeBuilder toBuilder() {
			KeyValueType.KeyValueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyValueType.KeyValueTypeBuilder builder) {
			ofNullable(getDsaKeyValue()).ifPresent(builder::setDsaKeyValue);
			ofNullable(getRsaKeyValue()).ifPresent(builder::setRsaKeyValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(dsaKeyValue, _that.getDsaKeyValue())) return false;
			if (!Objects.equals(rsaKeyValue, _that.getRsaKeyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dsaKeyValue != null ? dsaKeyValue.hashCode() : 0);
			_result = 31 * _result + (rsaKeyValue != null ? rsaKeyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyValueType {" +
				"dsaKeyValue=" + this.dsaKeyValue + ", " +
				"rsaKeyValue=" + this.rsaKeyValue +
			'}';
		}
	}

	/*********************** Builder Implementation of KeyValueType  ***********************/
	class KeyValueTypeBuilderImpl implements KeyValueType.KeyValueTypeBuilder {
	
		protected DSAKeyValueType.DSAKeyValueTypeBuilder dsaKeyValue;
		protected RSAKeyValueType.RSAKeyValueTypeBuilder rsaKeyValue;
	
		public KeyValueTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dsaKeyValue")
		public DSAKeyValueType.DSAKeyValueTypeBuilder getDsaKeyValue() {
			return dsaKeyValue;
		}
		
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder getOrCreateDsaKeyValue() {
			DSAKeyValueType.DSAKeyValueTypeBuilder result;
			if (dsaKeyValue!=null) {
				result = dsaKeyValue;
			}
			else {
				result = dsaKeyValue = DSAKeyValueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rsaKeyValue")
		public RSAKeyValueType.RSAKeyValueTypeBuilder getRsaKeyValue() {
			return rsaKeyValue;
		}
		
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder getOrCreateRsaKeyValue() {
			RSAKeyValueType.RSAKeyValueTypeBuilder result;
			if (rsaKeyValue!=null) {
				result = rsaKeyValue;
			}
			else {
				result = rsaKeyValue = RSAKeyValueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dsaKeyValue")
		public KeyValueType.KeyValueTypeBuilder setDsaKeyValue(DSAKeyValueType dsaKeyValue) {
			this.dsaKeyValue = dsaKeyValue==null?null:dsaKeyValue.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rsaKeyValue")
		public KeyValueType.KeyValueTypeBuilder setRsaKeyValue(RSAKeyValueType rsaKeyValue) {
			this.rsaKeyValue = rsaKeyValue==null?null:rsaKeyValue.toBuilder();
			return this;
		}
		
		@Override
		public KeyValueType build() {
			return new KeyValueType.KeyValueTypeImpl(this);
		}
		
		@Override
		public KeyValueType.KeyValueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyValueType.KeyValueTypeBuilder prune() {
			if (dsaKeyValue!=null && !dsaKeyValue.prune().hasData()) dsaKeyValue = null;
			if (rsaKeyValue!=null && !rsaKeyValue.prune().hasData()) rsaKeyValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDsaKeyValue()!=null && getDsaKeyValue().hasData()) return true;
			if (getRsaKeyValue()!=null && getRsaKeyValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyValueType.KeyValueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			KeyValueType.KeyValueTypeBuilder o = (KeyValueType.KeyValueTypeBuilder) other;
			
			merger.mergeRosetta(getDsaKeyValue(), o.getDsaKeyValue(), this::setDsaKeyValue);
			merger.mergeRosetta(getRsaKeyValue(), o.getRsaKeyValue(), this::setRsaKeyValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(dsaKeyValue, _that.getDsaKeyValue())) return false;
			if (!Objects.equals(rsaKeyValue, _that.getRsaKeyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dsaKeyValue != null ? dsaKeyValue.hashCode() : 0);
			_result = 31 * _result + (rsaKeyValue != null ? rsaKeyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyValueTypeBuilder {" +
				"dsaKeyValue=" + this.dsaKeyValue + ", " +
				"rsaKeyValue=" + this.rsaKeyValue +
			'}';
		}
	}
}
