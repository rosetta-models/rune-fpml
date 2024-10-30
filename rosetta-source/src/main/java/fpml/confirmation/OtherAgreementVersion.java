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
import fpml.confirmation.OtherAgreementVersion;
import fpml.confirmation.OtherAgreementVersion.OtherAgreementVersionBuilder;
import fpml.confirmation.OtherAgreementVersion.OtherAgreementVersionBuilderImpl;
import fpml.confirmation.OtherAgreementVersion.OtherAgreementVersionImpl;
import fpml.confirmation.meta.OtherAgreementVersionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OtherAgreementVersion", builder=OtherAgreementVersion.OtherAgreementVersionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OtherAgreementVersion extends RosettaModelObject {

	OtherAgreementVersionMeta metaData = new OtherAgreementVersionMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAgreementVersionScheme();

	/*********************** Build Methods  ***********************/
	OtherAgreementVersion build();
	
	OtherAgreementVersion.OtherAgreementVersionBuilder toBuilder();
	
	static OtherAgreementVersion.OtherAgreementVersionBuilder builder() {
		return new OtherAgreementVersion.OtherAgreementVersionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreementVersion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OtherAgreementVersion> getType() {
		return OtherAgreementVersion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("agreementVersionScheme"), String.class, getAgreementVersionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementVersionBuilder extends OtherAgreementVersion, RosettaModelObjectBuilder {
		OtherAgreementVersion.OtherAgreementVersionBuilder setValue(String value);
		OtherAgreementVersion.OtherAgreementVersionBuilder setAgreementVersionScheme(String agreementVersionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("agreementVersionScheme"), String.class, getAgreementVersionScheme(), this);
		}
		

		OtherAgreementVersion.OtherAgreementVersionBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreementVersion  ***********************/
	class OtherAgreementVersionImpl implements OtherAgreementVersion {
		private final String value;
		private final String agreementVersionScheme;
		
		protected OtherAgreementVersionImpl(OtherAgreementVersion.OtherAgreementVersionBuilder builder) {
			this.value = builder.getValue();
			this.agreementVersionScheme = builder.getAgreementVersionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementVersionScheme")
		public String getAgreementVersionScheme() {
			return agreementVersionScheme;
		}
		
		@Override
		public OtherAgreementVersion build() {
			return this;
		}
		
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder toBuilder() {
			OtherAgreementVersion.OtherAgreementVersionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreementVersion.OtherAgreementVersionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAgreementVersionScheme()).ifPresent(builder::setAgreementVersionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementVersionScheme, _that.getAgreementVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementVersionScheme != null ? agreementVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementVersion {" +
				"value=" + this.value + ", " +
				"agreementVersionScheme=" + this.agreementVersionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreementVersion  ***********************/
	class OtherAgreementVersionBuilderImpl implements OtherAgreementVersion.OtherAgreementVersionBuilder {
	
		protected String value;
		protected String agreementVersionScheme;
	
		public OtherAgreementVersionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementVersionScheme")
		public String getAgreementVersionScheme() {
			return agreementVersionScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OtherAgreementVersion.OtherAgreementVersionBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("agreementVersionScheme")
		public OtherAgreementVersion.OtherAgreementVersionBuilder setAgreementVersionScheme(String agreementVersionScheme) {
			this.agreementVersionScheme = agreementVersionScheme==null?null:agreementVersionScheme;
			return this;
		}
		
		@Override
		public OtherAgreementVersion build() {
			return new OtherAgreementVersion.OtherAgreementVersionImpl(this);
		}
		
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAgreementVersionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreementVersion.OtherAgreementVersionBuilder o = (OtherAgreementVersion.OtherAgreementVersionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAgreementVersionScheme(), o.getAgreementVersionScheme(), this::setAgreementVersionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementVersionScheme, _that.getAgreementVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementVersionScheme != null ? agreementVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementVersionBuilder {" +
				"value=" + this.value + ", " +
				"agreementVersionScheme=" + this.agreementVersionScheme +
			'}';
		}
	}
}
