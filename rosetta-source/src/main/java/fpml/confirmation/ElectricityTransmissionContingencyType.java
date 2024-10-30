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
import fpml.confirmation.ElectricityTransmissionContingencyType;
import fpml.confirmation.ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder;
import fpml.confirmation.ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilderImpl;
import fpml.confirmation.ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeImpl;
import fpml.confirmation.meta.ElectricityTransmissionContingencyTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The type of transmission contingency, i.e. what portion of the transmission the delivery obligations are applicable.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ElectricityTransmissionContingencyType", builder=ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ElectricityTransmissionContingencyType extends RosettaModelObject {

	ElectricityTransmissionContingencyTypeMeta metaData = new ElectricityTransmissionContingencyTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getElectricityTransmissionContingencyScheme();

	/*********************** Build Methods  ***********************/
	ElectricityTransmissionContingencyType build();
	
	ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder toBuilder();
	
	static ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder() {
		return new ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityTransmissionContingencyType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityTransmissionContingencyType> getType() {
		return ElectricityTransmissionContingencyType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("electricityTransmissionContingencyScheme"), String.class, getElectricityTransmissionContingencyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityTransmissionContingencyTypeBuilder extends ElectricityTransmissionContingencyType, RosettaModelObjectBuilder {
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setValue(String value);
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setElectricityTransmissionContingencyScheme(String electricityTransmissionContingencyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("electricityTransmissionContingencyScheme"), String.class, getElectricityTransmissionContingencyScheme(), this);
		}
		

		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityTransmissionContingencyType  ***********************/
	class ElectricityTransmissionContingencyTypeImpl implements ElectricityTransmissionContingencyType {
		private final String value;
		private final String electricityTransmissionContingencyScheme;
		
		protected ElectricityTransmissionContingencyTypeImpl(ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder) {
			this.value = builder.getValue();
			this.electricityTransmissionContingencyScheme = builder.getElectricityTransmissionContingencyScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("electricityTransmissionContingencyScheme")
		public String getElectricityTransmissionContingencyScheme() {
			return electricityTransmissionContingencyScheme;
		}
		
		@Override
		public ElectricityTransmissionContingencyType build() {
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder toBuilder() {
			ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getElectricityTransmissionContingencyScheme()).ifPresent(builder::setElectricityTransmissionContingencyScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(electricityTransmissionContingencyScheme, _that.getElectricityTransmissionContingencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (electricityTransmissionContingencyScheme != null ? electricityTransmissionContingencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingencyType {" +
				"value=" + this.value + ", " +
				"electricityTransmissionContingencyScheme=" + this.electricityTransmissionContingencyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityTransmissionContingencyType  ***********************/
	class ElectricityTransmissionContingencyTypeBuilderImpl implements ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder {
	
		protected String value;
		protected String electricityTransmissionContingencyScheme;
	
		public ElectricityTransmissionContingencyTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("electricityTransmissionContingencyScheme")
		public String getElectricityTransmissionContingencyScheme() {
			return electricityTransmissionContingencyScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("electricityTransmissionContingencyScheme")
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setElectricityTransmissionContingencyScheme(String electricityTransmissionContingencyScheme) {
			this.electricityTransmissionContingencyScheme = electricityTransmissionContingencyScheme==null?null:electricityTransmissionContingencyScheme;
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingencyType build() {
			return new ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeImpl(this);
		}
		
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getElectricityTransmissionContingencyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder o = (ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getElectricityTransmissionContingencyScheme(), o.getElectricityTransmissionContingencyScheme(), this::setElectricityTransmissionContingencyScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(electricityTransmissionContingencyScheme, _that.getElectricityTransmissionContingencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (electricityTransmissionContingencyScheme != null ? electricityTransmissionContingencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingencyTypeBuilder {" +
				"value=" + this.value + ", " +
				"electricityTransmissionContingencyScheme=" + this.electricityTransmissionContingencyScheme +
			'}';
		}
	}
}
