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
import fpml.confirmation.MasterConfirmationAnnexType;
import fpml.confirmation.MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder;
import fpml.confirmation.MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilderImpl;
import fpml.confirmation.MasterConfirmationAnnexType.MasterConfirmationAnnexTypeImpl;
import fpml.confirmation.meta.MasterConfirmationAnnexTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MasterConfirmationAnnexType", builder=MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilderImpl.class, version="${project.version}")
public interface MasterConfirmationAnnexType extends RosettaModelObject {

	MasterConfirmationAnnexTypeMeta metaData = new MasterConfirmationAnnexTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMasterConfirmationAnnexTypeScheme();

	/*********************** Build Methods  ***********************/
	MasterConfirmationAnnexType build();
	
	MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder toBuilder();
	
	static MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder builder() {
		return new MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterConfirmationAnnexType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MasterConfirmationAnnexType> getType() {
		return MasterConfirmationAnnexType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("masterConfirmationAnnexTypeScheme"), String.class, getMasterConfirmationAnnexTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterConfirmationAnnexTypeBuilder extends MasterConfirmationAnnexType, RosettaModelObjectBuilder {
		MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder setValue(String value);
		MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder setMasterConfirmationAnnexTypeScheme(String masterConfirmationAnnexTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("masterConfirmationAnnexTypeScheme"), String.class, getMasterConfirmationAnnexTypeScheme(), this);
		}
		

		MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder prune();
	}

	/*********************** Immutable Implementation of MasterConfirmationAnnexType  ***********************/
	class MasterConfirmationAnnexTypeImpl implements MasterConfirmationAnnexType {
		private final String value;
		private final String masterConfirmationAnnexTypeScheme;
		
		protected MasterConfirmationAnnexTypeImpl(MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder builder) {
			this.value = builder.getValue();
			this.masterConfirmationAnnexTypeScheme = builder.getMasterConfirmationAnnexTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexTypeScheme")
		public String getMasterConfirmationAnnexTypeScheme() {
			return masterConfirmationAnnexTypeScheme;
		}
		
		@Override
		public MasterConfirmationAnnexType build() {
			return this;
		}
		
		@Override
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder toBuilder() {
			MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMasterConfirmationAnnexTypeScheme()).ifPresent(builder::setMasterConfirmationAnnexTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmationAnnexType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterConfirmationAnnexTypeScheme, _that.getMasterConfirmationAnnexTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexTypeScheme != null ? masterConfirmationAnnexTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmationAnnexType {" +
				"value=" + this.value + ", " +
				"masterConfirmationAnnexTypeScheme=" + this.masterConfirmationAnnexTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterConfirmationAnnexType  ***********************/
	class MasterConfirmationAnnexTypeBuilderImpl implements MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder {
	
		protected String value;
		protected String masterConfirmationAnnexTypeScheme;
	
		public MasterConfirmationAnnexTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexTypeScheme")
		public String getMasterConfirmationAnnexTypeScheme() {
			return masterConfirmationAnnexTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("masterConfirmationAnnexTypeScheme")
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder setMasterConfirmationAnnexTypeScheme(String masterConfirmationAnnexTypeScheme) {
			this.masterConfirmationAnnexTypeScheme = masterConfirmationAnnexTypeScheme==null?null:masterConfirmationAnnexTypeScheme;
			return this;
		}
		
		@Override
		public MasterConfirmationAnnexType build() {
			return new MasterConfirmationAnnexType.MasterConfirmationAnnexTypeImpl(this);
		}
		
		@Override
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMasterConfirmationAnnexTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder o = (MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMasterConfirmationAnnexTypeScheme(), o.getMasterConfirmationAnnexTypeScheme(), this::setMasterConfirmationAnnexTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmationAnnexType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterConfirmationAnnexTypeScheme, _that.getMasterConfirmationAnnexTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexTypeScheme != null ? masterConfirmationAnnexTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmationAnnexTypeBuilder {" +
				"value=" + this.value + ", " +
				"masterConfirmationAnnexTypeScheme=" + this.masterConfirmationAnnexTypeScheme +
			'}';
		}
	}
}
