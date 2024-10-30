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
import fpml.confirmation.FacilityFeature;
import fpml.confirmation.FacilityFeature.FacilityFeatureBuilder;
import fpml.confirmation.FacilityFeature.FacilityFeatureBuilderImpl;
import fpml.confirmation.FacilityFeature.FacilityFeatureImpl;
import fpml.confirmation.meta.FacilityFeatureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A list of facility features.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FacilityFeature", builder=FacilityFeature.FacilityFeatureBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FacilityFeature extends RosettaModelObject {

	FacilityFeatureMeta metaData = new FacilityFeatureMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getFacilityFeatureScheme();

	/*********************** Build Methods  ***********************/
	FacilityFeature build();
	
	FacilityFeature.FacilityFeatureBuilder toBuilder();
	
	static FacilityFeature.FacilityFeatureBuilder builder() {
		return new FacilityFeature.FacilityFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityFeature> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityFeature> getType() {
		return FacilityFeature.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("facilityFeatureScheme"), String.class, getFacilityFeatureScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityFeatureBuilder extends FacilityFeature, RosettaModelObjectBuilder {
		FacilityFeature.FacilityFeatureBuilder setValue(String value);
		FacilityFeature.FacilityFeatureBuilder setFacilityFeatureScheme(String facilityFeatureScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("facilityFeatureScheme"), String.class, getFacilityFeatureScheme(), this);
		}
		

		FacilityFeature.FacilityFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityFeature  ***********************/
	class FacilityFeatureImpl implements FacilityFeature {
		private final String value;
		private final String facilityFeatureScheme;
		
		protected FacilityFeatureImpl(FacilityFeature.FacilityFeatureBuilder builder) {
			this.value = builder.getValue();
			this.facilityFeatureScheme = builder.getFacilityFeatureScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("facilityFeatureScheme")
		public String getFacilityFeatureScheme() {
			return facilityFeatureScheme;
		}
		
		@Override
		public FacilityFeature build() {
			return this;
		}
		
		@Override
		public FacilityFeature.FacilityFeatureBuilder toBuilder() {
			FacilityFeature.FacilityFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityFeature.FacilityFeatureBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFacilityFeatureScheme()).ifPresent(builder::setFacilityFeatureScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityFeature _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(facilityFeatureScheme, _that.getFacilityFeatureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (facilityFeatureScheme != null ? facilityFeatureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityFeature {" +
				"value=" + this.value + ", " +
				"facilityFeatureScheme=" + this.facilityFeatureScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityFeature  ***********************/
	class FacilityFeatureBuilderImpl implements FacilityFeature.FacilityFeatureBuilder {
	
		protected String value;
		protected String facilityFeatureScheme;
	
		public FacilityFeatureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("facilityFeatureScheme")
		public String getFacilityFeatureScheme() {
			return facilityFeatureScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public FacilityFeature.FacilityFeatureBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("facilityFeatureScheme")
		public FacilityFeature.FacilityFeatureBuilder setFacilityFeatureScheme(String facilityFeatureScheme) {
			this.facilityFeatureScheme = facilityFeatureScheme==null?null:facilityFeatureScheme;
			return this;
		}
		
		@Override
		public FacilityFeature build() {
			return new FacilityFeature.FacilityFeatureImpl(this);
		}
		
		@Override
		public FacilityFeature.FacilityFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityFeature.FacilityFeatureBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFacilityFeatureScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityFeature.FacilityFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityFeature.FacilityFeatureBuilder o = (FacilityFeature.FacilityFeatureBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFacilityFeatureScheme(), o.getFacilityFeatureScheme(), this::setFacilityFeatureScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityFeature _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(facilityFeatureScheme, _that.getFacilityFeatureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (facilityFeatureScheme != null ? facilityFeatureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityFeatureBuilder {" +
				"value=" + this.value + ", " +
				"facilityFeatureScheme=" + this.facilityFeatureScheme +
			'}';
		}
	}
}
