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
import fpml.confirmation.MasterConfirmationType;
import fpml.confirmation.MasterConfirmationType.MasterConfirmationTypeBuilder;
import fpml.confirmation.MasterConfirmationType.MasterConfirmationTypeBuilderImpl;
import fpml.confirmation.MasterConfirmationType.MasterConfirmationTypeImpl;
import fpml.confirmation.meta.MasterConfirmationTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MasterConfirmationType", builder=MasterConfirmationType.MasterConfirmationTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MasterConfirmationType extends RosettaModelObject {

	MasterConfirmationTypeMeta metaData = new MasterConfirmationTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMasterConfirmationTypeScheme();

	/*********************** Build Methods  ***********************/
	MasterConfirmationType build();
	
	MasterConfirmationType.MasterConfirmationTypeBuilder toBuilder();
	
	static MasterConfirmationType.MasterConfirmationTypeBuilder builder() {
		return new MasterConfirmationType.MasterConfirmationTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterConfirmationType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MasterConfirmationType> getType() {
		return MasterConfirmationType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("masterConfirmationTypeScheme"), String.class, getMasterConfirmationTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterConfirmationTypeBuilder extends MasterConfirmationType, RosettaModelObjectBuilder {
		MasterConfirmationType.MasterConfirmationTypeBuilder setValue(String value);
		MasterConfirmationType.MasterConfirmationTypeBuilder setMasterConfirmationTypeScheme(String masterConfirmationTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("masterConfirmationTypeScheme"), String.class, getMasterConfirmationTypeScheme(), this);
		}
		

		MasterConfirmationType.MasterConfirmationTypeBuilder prune();
	}

	/*********************** Immutable Implementation of MasterConfirmationType  ***********************/
	class MasterConfirmationTypeImpl implements MasterConfirmationType {
		private final String value;
		private final String masterConfirmationTypeScheme;
		
		protected MasterConfirmationTypeImpl(MasterConfirmationType.MasterConfirmationTypeBuilder builder) {
			this.value = builder.getValue();
			this.masterConfirmationTypeScheme = builder.getMasterConfirmationTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationTypeScheme")
		public String getMasterConfirmationTypeScheme() {
			return masterConfirmationTypeScheme;
		}
		
		@Override
		public MasterConfirmationType build() {
			return this;
		}
		
		@Override
		public MasterConfirmationType.MasterConfirmationTypeBuilder toBuilder() {
			MasterConfirmationType.MasterConfirmationTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterConfirmationType.MasterConfirmationTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMasterConfirmationTypeScheme()).ifPresent(builder::setMasterConfirmationTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterConfirmationTypeScheme, _that.getMasterConfirmationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationTypeScheme != null ? masterConfirmationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmationType {" +
				"value=" + this.value + ", " +
				"masterConfirmationTypeScheme=" + this.masterConfirmationTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterConfirmationType  ***********************/
	class MasterConfirmationTypeBuilderImpl implements MasterConfirmationType.MasterConfirmationTypeBuilder {
	
		protected String value;
		protected String masterConfirmationTypeScheme;
	
		public MasterConfirmationTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationTypeScheme")
		public String getMasterConfirmationTypeScheme() {
			return masterConfirmationTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MasterConfirmationType.MasterConfirmationTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("masterConfirmationTypeScheme")
		public MasterConfirmationType.MasterConfirmationTypeBuilder setMasterConfirmationTypeScheme(String masterConfirmationTypeScheme) {
			this.masterConfirmationTypeScheme = masterConfirmationTypeScheme==null?null:masterConfirmationTypeScheme;
			return this;
		}
		
		@Override
		public MasterConfirmationType build() {
			return new MasterConfirmationType.MasterConfirmationTypeImpl(this);
		}
		
		@Override
		public MasterConfirmationType.MasterConfirmationTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmationType.MasterConfirmationTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMasterConfirmationTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmationType.MasterConfirmationTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterConfirmationType.MasterConfirmationTypeBuilder o = (MasterConfirmationType.MasterConfirmationTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMasterConfirmationTypeScheme(), o.getMasterConfirmationTypeScheme(), this::setMasterConfirmationTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterConfirmationTypeScheme, _that.getMasterConfirmationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationTypeScheme != null ? masterConfirmationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmationTypeBuilder {" +
				"value=" + this.value + ", " +
				"masterConfirmationTypeScheme=" + this.masterConfirmationTypeScheme +
			'}';
		}
	}
}
