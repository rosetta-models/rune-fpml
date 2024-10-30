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
import fpml.confirmation.MasterAgreementType;
import fpml.confirmation.MasterAgreementType.MasterAgreementTypeBuilder;
import fpml.confirmation.MasterAgreementType.MasterAgreementTypeBuilderImpl;
import fpml.confirmation.MasterAgreementType.MasterAgreementTypeImpl;
import fpml.confirmation.meta.MasterAgreementTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MasterAgreementType", builder=MasterAgreementType.MasterAgreementTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MasterAgreementType extends RosettaModelObject {

	MasterAgreementTypeMeta metaData = new MasterAgreementTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMasterAgreementTypeScheme();

	/*********************** Build Methods  ***********************/
	MasterAgreementType build();
	
	MasterAgreementType.MasterAgreementTypeBuilder toBuilder();
	
	static MasterAgreementType.MasterAgreementTypeBuilder builder() {
		return new MasterAgreementType.MasterAgreementTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MasterAgreementType> getType() {
		return MasterAgreementType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("masterAgreementTypeScheme"), String.class, getMasterAgreementTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementTypeBuilder extends MasterAgreementType, RosettaModelObjectBuilder {
		MasterAgreementType.MasterAgreementTypeBuilder setValue(String value);
		MasterAgreementType.MasterAgreementTypeBuilder setMasterAgreementTypeScheme(String masterAgreementTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("masterAgreementTypeScheme"), String.class, getMasterAgreementTypeScheme(), this);
		}
		

		MasterAgreementType.MasterAgreementTypeBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementType  ***********************/
	class MasterAgreementTypeImpl implements MasterAgreementType {
		private final String value;
		private final String masterAgreementTypeScheme;
		
		protected MasterAgreementTypeImpl(MasterAgreementType.MasterAgreementTypeBuilder builder) {
			this.value = builder.getValue();
			this.masterAgreementTypeScheme = builder.getMasterAgreementTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterAgreementTypeScheme")
		public String getMasterAgreementTypeScheme() {
			return masterAgreementTypeScheme;
		}
		
		@Override
		public MasterAgreementType build() {
			return this;
		}
		
		@Override
		public MasterAgreementType.MasterAgreementTypeBuilder toBuilder() {
			MasterAgreementType.MasterAgreementTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementType.MasterAgreementTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMasterAgreementTypeScheme()).ifPresent(builder::setMasterAgreementTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementTypeScheme, _that.getMasterAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementTypeScheme != null ? masterAgreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementType {" +
				"value=" + this.value + ", " +
				"masterAgreementTypeScheme=" + this.masterAgreementTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementType  ***********************/
	class MasterAgreementTypeBuilderImpl implements MasterAgreementType.MasterAgreementTypeBuilder {
	
		protected String value;
		protected String masterAgreementTypeScheme;
	
		public MasterAgreementTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterAgreementTypeScheme")
		public String getMasterAgreementTypeScheme() {
			return masterAgreementTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MasterAgreementType.MasterAgreementTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("masterAgreementTypeScheme")
		public MasterAgreementType.MasterAgreementTypeBuilder setMasterAgreementTypeScheme(String masterAgreementTypeScheme) {
			this.masterAgreementTypeScheme = masterAgreementTypeScheme==null?null:masterAgreementTypeScheme;
			return this;
		}
		
		@Override
		public MasterAgreementType build() {
			return new MasterAgreementType.MasterAgreementTypeImpl(this);
		}
		
		@Override
		public MasterAgreementType.MasterAgreementTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementType.MasterAgreementTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMasterAgreementTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementType.MasterAgreementTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementType.MasterAgreementTypeBuilder o = (MasterAgreementType.MasterAgreementTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMasterAgreementTypeScheme(), o.getMasterAgreementTypeScheme(), this::setMasterAgreementTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementTypeScheme, _that.getMasterAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementTypeScheme != null ? masterAgreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementTypeBuilder {" +
				"value=" + this.value + ", " +
				"masterAgreementTypeScheme=" + this.masterAgreementTypeScheme +
			'}';
		}
	}
}
