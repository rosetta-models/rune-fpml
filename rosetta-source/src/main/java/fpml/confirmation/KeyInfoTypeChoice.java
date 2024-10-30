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
import fpml.confirmation.KeyInfoTypeChoice;
import fpml.confirmation.KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder;
import fpml.confirmation.KeyInfoTypeChoice.KeyInfoTypeChoiceBuilderImpl;
import fpml.confirmation.KeyInfoTypeChoice.KeyInfoTypeChoiceImpl;
import fpml.confirmation.KeyValueType;
import fpml.confirmation.PGPDataType;
import fpml.confirmation.RetrievalMethodType;
import fpml.confirmation.SPKIDataType;
import fpml.confirmation.X509DataType;
import fpml.confirmation.meta.KeyInfoTypeChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="KeyInfoTypeChoice", builder=KeyInfoTypeChoice.KeyInfoTypeChoiceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface KeyInfoTypeChoice extends RosettaModelObject {

	KeyInfoTypeChoiceMeta metaData = new KeyInfoTypeChoiceMeta();

	/*********************** Getter Methods  ***********************/
	String getKeyName();
	KeyValueType getKeyValue();
	RetrievalMethodType getRetrievalMethod();
	X509DataType getX509Data();
	PGPDataType getPgpData();
	SPKIDataType getSpkiData();
	String getMgmtData();

	/*********************** Build Methods  ***********************/
	KeyInfoTypeChoice build();
	
	KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder toBuilder();
	
	static KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder builder() {
		return new KeyInfoTypeChoice.KeyInfoTypeChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyInfoTypeChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends KeyInfoTypeChoice> getType() {
		return KeyInfoTypeChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("keyName"), String.class, getKeyName(), this);
		processRosetta(path.newSubPath("keyValue"), processor, KeyValueType.class, getKeyValue());
		processRosetta(path.newSubPath("retrievalMethod"), processor, RetrievalMethodType.class, getRetrievalMethod());
		processRosetta(path.newSubPath("x509Data"), processor, X509DataType.class, getX509Data());
		processRosetta(path.newSubPath("pgpData"), processor, PGPDataType.class, getPgpData());
		processRosetta(path.newSubPath("spkiData"), processor, SPKIDataType.class, getSpkiData());
		processor.processBasic(path.newSubPath("mgmtData"), String.class, getMgmtData(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyInfoTypeChoiceBuilder extends KeyInfoTypeChoice, RosettaModelObjectBuilder {
		KeyValueType.KeyValueTypeBuilder getOrCreateKeyValue();
		KeyValueType.KeyValueTypeBuilder getKeyValue();
		RetrievalMethodType.RetrievalMethodTypeBuilder getOrCreateRetrievalMethod();
		RetrievalMethodType.RetrievalMethodTypeBuilder getRetrievalMethod();
		X509DataType.X509DataTypeBuilder getOrCreateX509Data();
		X509DataType.X509DataTypeBuilder getX509Data();
		PGPDataType.PGPDataTypeBuilder getOrCreatePgpData();
		PGPDataType.PGPDataTypeBuilder getPgpData();
		SPKIDataType.SPKIDataTypeBuilder getOrCreateSpkiData();
		SPKIDataType.SPKIDataTypeBuilder getSpkiData();
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setKeyName(String keyName);
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setKeyValue(KeyValueType keyValue);
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setRetrievalMethod(RetrievalMethodType retrievalMethod);
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setX509Data(X509DataType x509Data);
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setPgpData(PGPDataType pgpData);
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setSpkiData(SPKIDataType spkiData);
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setMgmtData(String mgmtData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("keyName"), String.class, getKeyName(), this);
			processRosetta(path.newSubPath("keyValue"), processor, KeyValueType.KeyValueTypeBuilder.class, getKeyValue());
			processRosetta(path.newSubPath("retrievalMethod"), processor, RetrievalMethodType.RetrievalMethodTypeBuilder.class, getRetrievalMethod());
			processRosetta(path.newSubPath("x509Data"), processor, X509DataType.X509DataTypeBuilder.class, getX509Data());
			processRosetta(path.newSubPath("pgpData"), processor, PGPDataType.PGPDataTypeBuilder.class, getPgpData());
			processRosetta(path.newSubPath("spkiData"), processor, SPKIDataType.SPKIDataTypeBuilder.class, getSpkiData());
			processor.processBasic(path.newSubPath("mgmtData"), String.class, getMgmtData(), this);
		}
		

		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of KeyInfoTypeChoice  ***********************/
	class KeyInfoTypeChoiceImpl implements KeyInfoTypeChoice {
		private final String keyName;
		private final KeyValueType keyValue;
		private final RetrievalMethodType retrievalMethod;
		private final X509DataType x509Data;
		private final PGPDataType pgpData;
		private final SPKIDataType spkiData;
		private final String mgmtData;
		
		protected KeyInfoTypeChoiceImpl(KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder builder) {
			this.keyName = builder.getKeyName();
			this.keyValue = ofNullable(builder.getKeyValue()).map(f->f.build()).orElse(null);
			this.retrievalMethod = ofNullable(builder.getRetrievalMethod()).map(f->f.build()).orElse(null);
			this.x509Data = ofNullable(builder.getX509Data()).map(f->f.build()).orElse(null);
			this.pgpData = ofNullable(builder.getPgpData()).map(f->f.build()).orElse(null);
			this.spkiData = ofNullable(builder.getSpkiData()).map(f->f.build()).orElse(null);
			this.mgmtData = builder.getMgmtData();
		}
		
		@Override
		@RosettaAttribute("keyName")
		public String getKeyName() {
			return keyName;
		}
		
		@Override
		@RosettaAttribute("keyValue")
		public KeyValueType getKeyValue() {
			return keyValue;
		}
		
		@Override
		@RosettaAttribute("retrievalMethod")
		public RetrievalMethodType getRetrievalMethod() {
			return retrievalMethod;
		}
		
		@Override
		@RosettaAttribute("x509Data")
		public X509DataType getX509Data() {
			return x509Data;
		}
		
		@Override
		@RosettaAttribute("pgpData")
		public PGPDataType getPgpData() {
			return pgpData;
		}
		
		@Override
		@RosettaAttribute("spkiData")
		public SPKIDataType getSpkiData() {
			return spkiData;
		}
		
		@Override
		@RosettaAttribute("mgmtData")
		public String getMgmtData() {
			return mgmtData;
		}
		
		@Override
		public KeyInfoTypeChoice build() {
			return this;
		}
		
		@Override
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder toBuilder() {
			KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder builder) {
			ofNullable(getKeyName()).ifPresent(builder::setKeyName);
			ofNullable(getKeyValue()).ifPresent(builder::setKeyValue);
			ofNullable(getRetrievalMethod()).ifPresent(builder::setRetrievalMethod);
			ofNullable(getX509Data()).ifPresent(builder::setX509Data);
			ofNullable(getPgpData()).ifPresent(builder::setPgpData);
			ofNullable(getSpkiData()).ifPresent(builder::setSpkiData);
			ofNullable(getMgmtData()).ifPresent(builder::setMgmtData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyInfoTypeChoice _that = getType().cast(o);
		
			if (!Objects.equals(keyName, _that.getKeyName())) return false;
			if (!Objects.equals(keyValue, _that.getKeyValue())) return false;
			if (!Objects.equals(retrievalMethod, _that.getRetrievalMethod())) return false;
			if (!Objects.equals(x509Data, _that.getX509Data())) return false;
			if (!Objects.equals(pgpData, _that.getPgpData())) return false;
			if (!Objects.equals(spkiData, _that.getSpkiData())) return false;
			if (!Objects.equals(mgmtData, _that.getMgmtData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (keyName != null ? keyName.hashCode() : 0);
			_result = 31 * _result + (keyValue != null ? keyValue.hashCode() : 0);
			_result = 31 * _result + (retrievalMethod != null ? retrievalMethod.hashCode() : 0);
			_result = 31 * _result + (x509Data != null ? x509Data.hashCode() : 0);
			_result = 31 * _result + (pgpData != null ? pgpData.hashCode() : 0);
			_result = 31 * _result + (spkiData != null ? spkiData.hashCode() : 0);
			_result = 31 * _result + (mgmtData != null ? mgmtData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfoTypeChoice {" +
				"keyName=" + this.keyName + ", " +
				"keyValue=" + this.keyValue + ", " +
				"retrievalMethod=" + this.retrievalMethod + ", " +
				"x509Data=" + this.x509Data + ", " +
				"pgpData=" + this.pgpData + ", " +
				"spkiData=" + this.spkiData + ", " +
				"mgmtData=" + this.mgmtData +
			'}';
		}
	}

	/*********************** Builder Implementation of KeyInfoTypeChoice  ***********************/
	class KeyInfoTypeChoiceBuilderImpl implements KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder {
	
		protected String keyName;
		protected KeyValueType.KeyValueTypeBuilder keyValue;
		protected RetrievalMethodType.RetrievalMethodTypeBuilder retrievalMethod;
		protected X509DataType.X509DataTypeBuilder x509Data;
		protected PGPDataType.PGPDataTypeBuilder pgpData;
		protected SPKIDataType.SPKIDataTypeBuilder spkiData;
		protected String mgmtData;
	
		public KeyInfoTypeChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("keyName")
		public String getKeyName() {
			return keyName;
		}
		
		@Override
		@RosettaAttribute("keyValue")
		public KeyValueType.KeyValueTypeBuilder getKeyValue() {
			return keyValue;
		}
		
		@Override
		public KeyValueType.KeyValueTypeBuilder getOrCreateKeyValue() {
			KeyValueType.KeyValueTypeBuilder result;
			if (keyValue!=null) {
				result = keyValue;
			}
			else {
				result = keyValue = KeyValueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("retrievalMethod")
		public RetrievalMethodType.RetrievalMethodTypeBuilder getRetrievalMethod() {
			return retrievalMethod;
		}
		
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder getOrCreateRetrievalMethod() {
			RetrievalMethodType.RetrievalMethodTypeBuilder result;
			if (retrievalMethod!=null) {
				result = retrievalMethod;
			}
			else {
				result = retrievalMethod = RetrievalMethodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("x509Data")
		public X509DataType.X509DataTypeBuilder getX509Data() {
			return x509Data;
		}
		
		@Override
		public X509DataType.X509DataTypeBuilder getOrCreateX509Data() {
			X509DataType.X509DataTypeBuilder result;
			if (x509Data!=null) {
				result = x509Data;
			}
			else {
				result = x509Data = X509DataType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pgpData")
		public PGPDataType.PGPDataTypeBuilder getPgpData() {
			return pgpData;
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder getOrCreatePgpData() {
			PGPDataType.PGPDataTypeBuilder result;
			if (pgpData!=null) {
				result = pgpData;
			}
			else {
				result = pgpData = PGPDataType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spkiData")
		public SPKIDataType.SPKIDataTypeBuilder getSpkiData() {
			return spkiData;
		}
		
		@Override
		public SPKIDataType.SPKIDataTypeBuilder getOrCreateSpkiData() {
			SPKIDataType.SPKIDataTypeBuilder result;
			if (spkiData!=null) {
				result = spkiData;
			}
			else {
				result = spkiData = SPKIDataType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mgmtData")
		public String getMgmtData() {
			return mgmtData;
		}
		
		@Override
		@RosettaAttribute("keyName")
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setKeyName(String keyName) {
			this.keyName = keyName==null?null:keyName;
			return this;
		}
		@Override
		@RosettaAttribute("keyValue")
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setKeyValue(KeyValueType keyValue) {
			this.keyValue = keyValue==null?null:keyValue.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("retrievalMethod")
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setRetrievalMethod(RetrievalMethodType retrievalMethod) {
			this.retrievalMethod = retrievalMethod==null?null:retrievalMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("x509Data")
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setX509Data(X509DataType x509Data) {
			this.x509Data = x509Data==null?null:x509Data.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pgpData")
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setPgpData(PGPDataType pgpData) {
			this.pgpData = pgpData==null?null:pgpData.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spkiData")
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setSpkiData(SPKIDataType spkiData) {
			this.spkiData = spkiData==null?null:spkiData.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mgmtData")
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder setMgmtData(String mgmtData) {
			this.mgmtData = mgmtData==null?null:mgmtData;
			return this;
		}
		
		@Override
		public KeyInfoTypeChoice build() {
			return new KeyInfoTypeChoice.KeyInfoTypeChoiceImpl(this);
		}
		
		@Override
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder prune() {
			if (keyValue!=null && !keyValue.prune().hasData()) keyValue = null;
			if (retrievalMethod!=null && !retrievalMethod.prune().hasData()) retrievalMethod = null;
			if (x509Data!=null && !x509Data.prune().hasData()) x509Data = null;
			if (pgpData!=null && !pgpData.prune().hasData()) pgpData = null;
			if (spkiData!=null && !spkiData.prune().hasData()) spkiData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getKeyName()!=null) return true;
			if (getKeyValue()!=null && getKeyValue().hasData()) return true;
			if (getRetrievalMethod()!=null && getRetrievalMethod().hasData()) return true;
			if (getX509Data()!=null && getX509Data().hasData()) return true;
			if (getPgpData()!=null && getPgpData().hasData()) return true;
			if (getSpkiData()!=null && getSpkiData().hasData()) return true;
			if (getMgmtData()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder o = (KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder) other;
			
			merger.mergeRosetta(getKeyValue(), o.getKeyValue(), this::setKeyValue);
			merger.mergeRosetta(getRetrievalMethod(), o.getRetrievalMethod(), this::setRetrievalMethod);
			merger.mergeRosetta(getX509Data(), o.getX509Data(), this::setX509Data);
			merger.mergeRosetta(getPgpData(), o.getPgpData(), this::setPgpData);
			merger.mergeRosetta(getSpkiData(), o.getSpkiData(), this::setSpkiData);
			
			merger.mergeBasic(getKeyName(), o.getKeyName(), this::setKeyName);
			merger.mergeBasic(getMgmtData(), o.getMgmtData(), this::setMgmtData);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyInfoTypeChoice _that = getType().cast(o);
		
			if (!Objects.equals(keyName, _that.getKeyName())) return false;
			if (!Objects.equals(keyValue, _that.getKeyValue())) return false;
			if (!Objects.equals(retrievalMethod, _that.getRetrievalMethod())) return false;
			if (!Objects.equals(x509Data, _that.getX509Data())) return false;
			if (!Objects.equals(pgpData, _that.getPgpData())) return false;
			if (!Objects.equals(spkiData, _that.getSpkiData())) return false;
			if (!Objects.equals(mgmtData, _that.getMgmtData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (keyName != null ? keyName.hashCode() : 0);
			_result = 31 * _result + (keyValue != null ? keyValue.hashCode() : 0);
			_result = 31 * _result + (retrievalMethod != null ? retrievalMethod.hashCode() : 0);
			_result = 31 * _result + (x509Data != null ? x509Data.hashCode() : 0);
			_result = 31 * _result + (pgpData != null ? pgpData.hashCode() : 0);
			_result = 31 * _result + (spkiData != null ? spkiData.hashCode() : 0);
			_result = 31 * _result + (mgmtData != null ? mgmtData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfoTypeChoiceBuilder {" +
				"keyName=" + this.keyName + ", " +
				"keyValue=" + this.keyValue + ", " +
				"retrievalMethod=" + this.retrievalMethod + ", " +
				"x509Data=" + this.x509Data + ", " +
				"pgpData=" + this.pgpData + ", " +
				"spkiData=" + this.spkiData + ", " +
				"mgmtData=" + this.mgmtData +
			'}';
		}
	}
}
