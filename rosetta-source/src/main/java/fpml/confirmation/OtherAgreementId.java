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
import fpml.confirmation.OtherAgreementId;
import fpml.confirmation.OtherAgreementId.OtherAgreementIdBuilder;
import fpml.confirmation.OtherAgreementId.OtherAgreementIdBuilderImpl;
import fpml.confirmation.OtherAgreementId.OtherAgreementIdImpl;
import fpml.confirmation.meta.OtherAgreementIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A agreement identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OtherAgreementId", builder=OtherAgreementId.OtherAgreementIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OtherAgreementId extends RosettaModelObject {

	OtherAgreementIdMeta metaData = new OtherAgreementIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAgreementIdScheme();

	/*********************** Build Methods  ***********************/
	OtherAgreementId build();
	
	OtherAgreementId.OtherAgreementIdBuilder toBuilder();
	
	static OtherAgreementId.OtherAgreementIdBuilder builder() {
		return new OtherAgreementId.OtherAgreementIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreementId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OtherAgreementId> getType() {
		return OtherAgreementId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("agreementIdScheme"), String.class, getAgreementIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementIdBuilder extends OtherAgreementId, RosettaModelObjectBuilder {
		OtherAgreementId.OtherAgreementIdBuilder setValue(String value);
		OtherAgreementId.OtherAgreementIdBuilder setAgreementIdScheme(String agreementIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("agreementIdScheme"), String.class, getAgreementIdScheme(), this);
		}
		

		OtherAgreementId.OtherAgreementIdBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreementId  ***********************/
	class OtherAgreementIdImpl implements OtherAgreementId {
		private final String value;
		private final String agreementIdScheme;
		
		protected OtherAgreementIdImpl(OtherAgreementId.OtherAgreementIdBuilder builder) {
			this.value = builder.getValue();
			this.agreementIdScheme = builder.getAgreementIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementIdScheme")
		public String getAgreementIdScheme() {
			return agreementIdScheme;
		}
		
		@Override
		public OtherAgreementId build() {
			return this;
		}
		
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder toBuilder() {
			OtherAgreementId.OtherAgreementIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreementId.OtherAgreementIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAgreementIdScheme()).ifPresent(builder::setAgreementIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementIdScheme, _that.getAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementIdScheme != null ? agreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementId {" +
				"value=" + this.value + ", " +
				"agreementIdScheme=" + this.agreementIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreementId  ***********************/
	class OtherAgreementIdBuilderImpl implements OtherAgreementId.OtherAgreementIdBuilder {
	
		protected String value;
		protected String agreementIdScheme;
	
		public OtherAgreementIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementIdScheme")
		public String getAgreementIdScheme() {
			return agreementIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OtherAgreementId.OtherAgreementIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("agreementIdScheme")
		public OtherAgreementId.OtherAgreementIdBuilder setAgreementIdScheme(String agreementIdScheme) {
			this.agreementIdScheme = agreementIdScheme==null?null:agreementIdScheme;
			return this;
		}
		
		@Override
		public OtherAgreementId build() {
			return new OtherAgreementId.OtherAgreementIdImpl(this);
		}
		
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAgreementIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreementId.OtherAgreementIdBuilder o = (OtherAgreementId.OtherAgreementIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAgreementIdScheme(), o.getAgreementIdScheme(), this::setAgreementIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementIdScheme, _that.getAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementIdScheme != null ? agreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementIdBuilder {" +
				"value=" + this.value + ", " +
				"agreementIdScheme=" + this.agreementIdScheme +
			'}';
		}
	}
}
