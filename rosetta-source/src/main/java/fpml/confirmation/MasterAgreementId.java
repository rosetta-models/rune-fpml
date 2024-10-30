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
import fpml.confirmation.MasterAgreementId;
import fpml.confirmation.MasterAgreementId.MasterAgreementIdBuilder;
import fpml.confirmation.MasterAgreementId.MasterAgreementIdBuilderImpl;
import fpml.confirmation.MasterAgreementId.MasterAgreementIdImpl;
import fpml.confirmation.meta.MasterAgreementIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A master agreement identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MasterAgreementId", builder=MasterAgreementId.MasterAgreementIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MasterAgreementId extends RosettaModelObject {

	MasterAgreementIdMeta metaData = new MasterAgreementIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMasterAgreementIdScheme();

	/*********************** Build Methods  ***********************/
	MasterAgreementId build();
	
	MasterAgreementId.MasterAgreementIdBuilder toBuilder();
	
	static MasterAgreementId.MasterAgreementIdBuilder builder() {
		return new MasterAgreementId.MasterAgreementIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MasterAgreementId> getType() {
		return MasterAgreementId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("masterAgreementIdScheme"), String.class, getMasterAgreementIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementIdBuilder extends MasterAgreementId, RosettaModelObjectBuilder {
		MasterAgreementId.MasterAgreementIdBuilder setValue(String value);
		MasterAgreementId.MasterAgreementIdBuilder setMasterAgreementIdScheme(String masterAgreementIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("masterAgreementIdScheme"), String.class, getMasterAgreementIdScheme(), this);
		}
		

		MasterAgreementId.MasterAgreementIdBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementId  ***********************/
	class MasterAgreementIdImpl implements MasterAgreementId {
		private final String value;
		private final String masterAgreementIdScheme;
		
		protected MasterAgreementIdImpl(MasterAgreementId.MasterAgreementIdBuilder builder) {
			this.value = builder.getValue();
			this.masterAgreementIdScheme = builder.getMasterAgreementIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterAgreementIdScheme")
		public String getMasterAgreementIdScheme() {
			return masterAgreementIdScheme;
		}
		
		@Override
		public MasterAgreementId build() {
			return this;
		}
		
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder toBuilder() {
			MasterAgreementId.MasterAgreementIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementId.MasterAgreementIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMasterAgreementIdScheme()).ifPresent(builder::setMasterAgreementIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementIdScheme, _that.getMasterAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementIdScheme != null ? masterAgreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementId {" +
				"value=" + this.value + ", " +
				"masterAgreementIdScheme=" + this.masterAgreementIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementId  ***********************/
	class MasterAgreementIdBuilderImpl implements MasterAgreementId.MasterAgreementIdBuilder {
	
		protected String value;
		protected String masterAgreementIdScheme;
	
		public MasterAgreementIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterAgreementIdScheme")
		public String getMasterAgreementIdScheme() {
			return masterAgreementIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MasterAgreementId.MasterAgreementIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("masterAgreementIdScheme")
		public MasterAgreementId.MasterAgreementIdBuilder setMasterAgreementIdScheme(String masterAgreementIdScheme) {
			this.masterAgreementIdScheme = masterAgreementIdScheme==null?null:masterAgreementIdScheme;
			return this;
		}
		
		@Override
		public MasterAgreementId build() {
			return new MasterAgreementId.MasterAgreementIdImpl(this);
		}
		
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMasterAgreementIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementId.MasterAgreementIdBuilder o = (MasterAgreementId.MasterAgreementIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMasterAgreementIdScheme(), o.getMasterAgreementIdScheme(), this::setMasterAgreementIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementIdScheme, _that.getMasterAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementIdScheme != null ? masterAgreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementIdBuilder {" +
				"value=" + this.value + ", " +
				"masterAgreementIdScheme=" + this.masterAgreementIdScheme +
			'}';
		}
	}
}
