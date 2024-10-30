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
import fpml.confirmation.FacilityType;
import fpml.confirmation.FacilityType.FacilityTypeBuilder;
import fpml.confirmation.FacilityType.FacilityTypeBuilderImpl;
import fpml.confirmation.FacilityType.FacilityTypeImpl;
import fpml.confirmation.meta.FacilityTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the type of loan facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FacilityType", builder=FacilityType.FacilityTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FacilityType extends RosettaModelObject {

	FacilityTypeMeta metaData = new FacilityTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getFacilityTypeScheme();

	/*********************** Build Methods  ***********************/
	FacilityType build();
	
	FacilityType.FacilityTypeBuilder toBuilder();
	
	static FacilityType.FacilityTypeBuilder builder() {
		return new FacilityType.FacilityTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityType> getType() {
		return FacilityType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("facilityTypeScheme"), String.class, getFacilityTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityTypeBuilder extends FacilityType, RosettaModelObjectBuilder {
		FacilityType.FacilityTypeBuilder setValue(String value);
		FacilityType.FacilityTypeBuilder setFacilityTypeScheme(String facilityTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("facilityTypeScheme"), String.class, getFacilityTypeScheme(), this);
		}
		

		FacilityType.FacilityTypeBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityType  ***********************/
	class FacilityTypeImpl implements FacilityType {
		private final String value;
		private final String facilityTypeScheme;
		
		protected FacilityTypeImpl(FacilityType.FacilityTypeBuilder builder) {
			this.value = builder.getValue();
			this.facilityTypeScheme = builder.getFacilityTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("facilityTypeScheme")
		public String getFacilityTypeScheme() {
			return facilityTypeScheme;
		}
		
		@Override
		public FacilityType build() {
			return this;
		}
		
		@Override
		public FacilityType.FacilityTypeBuilder toBuilder() {
			FacilityType.FacilityTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityType.FacilityTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFacilityTypeScheme()).ifPresent(builder::setFacilityTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(facilityTypeScheme, _that.getFacilityTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (facilityTypeScheme != null ? facilityTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityType {" +
				"value=" + this.value + ", " +
				"facilityTypeScheme=" + this.facilityTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityType  ***********************/
	class FacilityTypeBuilderImpl implements FacilityType.FacilityTypeBuilder {
	
		protected String value;
		protected String facilityTypeScheme;
	
		public FacilityTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("facilityTypeScheme")
		public String getFacilityTypeScheme() {
			return facilityTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public FacilityType.FacilityTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("facilityTypeScheme")
		public FacilityType.FacilityTypeBuilder setFacilityTypeScheme(String facilityTypeScheme) {
			this.facilityTypeScheme = facilityTypeScheme==null?null:facilityTypeScheme;
			return this;
		}
		
		@Override
		public FacilityType build() {
			return new FacilityType.FacilityTypeImpl(this);
		}
		
		@Override
		public FacilityType.FacilityTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityType.FacilityTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFacilityTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityType.FacilityTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityType.FacilityTypeBuilder o = (FacilityType.FacilityTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFacilityTypeScheme(), o.getFacilityTypeScheme(), this::setFacilityTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(facilityTypeScheme, _that.getFacilityTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (facilityTypeScheme != null ? facilityTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityTypeBuilder {" +
				"value=" + this.value + ", " +
				"facilityTypeScheme=" + this.facilityTypeScheme +
			'}';
		}
	}
}
