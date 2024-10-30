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
import fpml.confirmation.OtherAgreementType;
import fpml.confirmation.OtherAgreementType.OtherAgreementTypeBuilder;
import fpml.confirmation.OtherAgreementType.OtherAgreementTypeBuilderImpl;
import fpml.confirmation.OtherAgreementType.OtherAgreementTypeImpl;
import fpml.confirmation.meta.OtherAgreementTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OtherAgreementType", builder=OtherAgreementType.OtherAgreementTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OtherAgreementType extends RosettaModelObject {

	OtherAgreementTypeMeta metaData = new OtherAgreementTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAgreementTypeScheme();

	/*********************** Build Methods  ***********************/
	OtherAgreementType build();
	
	OtherAgreementType.OtherAgreementTypeBuilder toBuilder();
	
	static OtherAgreementType.OtherAgreementTypeBuilder builder() {
		return new OtherAgreementType.OtherAgreementTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreementType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OtherAgreementType> getType() {
		return OtherAgreementType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("agreementTypeScheme"), String.class, getAgreementTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementTypeBuilder extends OtherAgreementType, RosettaModelObjectBuilder {
		OtherAgreementType.OtherAgreementTypeBuilder setValue(String value);
		OtherAgreementType.OtherAgreementTypeBuilder setAgreementTypeScheme(String agreementTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("agreementTypeScheme"), String.class, getAgreementTypeScheme(), this);
		}
		

		OtherAgreementType.OtherAgreementTypeBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreementType  ***********************/
	class OtherAgreementTypeImpl implements OtherAgreementType {
		private final String value;
		private final String agreementTypeScheme;
		
		protected OtherAgreementTypeImpl(OtherAgreementType.OtherAgreementTypeBuilder builder) {
			this.value = builder.getValue();
			this.agreementTypeScheme = builder.getAgreementTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementTypeScheme")
		public String getAgreementTypeScheme() {
			return agreementTypeScheme;
		}
		
		@Override
		public OtherAgreementType build() {
			return this;
		}
		
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder toBuilder() {
			OtherAgreementType.OtherAgreementTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreementType.OtherAgreementTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAgreementTypeScheme()).ifPresent(builder::setAgreementTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementTypeScheme, _that.getAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementTypeScheme != null ? agreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementType {" +
				"value=" + this.value + ", " +
				"agreementTypeScheme=" + this.agreementTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreementType  ***********************/
	class OtherAgreementTypeBuilderImpl implements OtherAgreementType.OtherAgreementTypeBuilder {
	
		protected String value;
		protected String agreementTypeScheme;
	
		public OtherAgreementTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementTypeScheme")
		public String getAgreementTypeScheme() {
			return agreementTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OtherAgreementType.OtherAgreementTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("agreementTypeScheme")
		public OtherAgreementType.OtherAgreementTypeBuilder setAgreementTypeScheme(String agreementTypeScheme) {
			this.agreementTypeScheme = agreementTypeScheme==null?null:agreementTypeScheme;
			return this;
		}
		
		@Override
		public OtherAgreementType build() {
			return new OtherAgreementType.OtherAgreementTypeImpl(this);
		}
		
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAgreementTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreementType.OtherAgreementTypeBuilder o = (OtherAgreementType.OtherAgreementTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAgreementTypeScheme(), o.getAgreementTypeScheme(), this::setAgreementTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementTypeScheme, _that.getAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementTypeScheme != null ? agreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementTypeBuilder {" +
				"value=" + this.value + ", " +
				"agreementTypeScheme=" + this.agreementTypeScheme +
			'}';
		}
	}
}
