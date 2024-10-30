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
import fpml.confirmation.CollateralProfile;
import fpml.confirmation.CollateralProfile.CollateralProfileBuilder;
import fpml.confirmation.CollateralProfile.CollateralProfileBuilderImpl;
import fpml.confirmation.CollateralProfile.CollateralProfileImpl;
import fpml.confirmation.meta.CollateralProfileMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CollateralProfile", builder=CollateralProfile.CollateralProfileBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CollateralProfile extends RosettaModelObject {

	CollateralProfileMeta metaData = new CollateralProfileMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCollateralProfileScheme();

	/*********************** Build Methods  ***********************/
	CollateralProfile build();
	
	CollateralProfile.CollateralProfileBuilder toBuilder();
	
	static CollateralProfile.CollateralProfileBuilder builder() {
		return new CollateralProfile.CollateralProfileBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralProfile> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralProfile> getType() {
		return CollateralProfile.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralProfileScheme"), String.class, getCollateralProfileScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralProfileBuilder extends CollateralProfile, RosettaModelObjectBuilder {
		CollateralProfile.CollateralProfileBuilder setValue(String value);
		CollateralProfile.CollateralProfileBuilder setCollateralProfileScheme(String collateralProfileScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralProfileScheme"), String.class, getCollateralProfileScheme(), this);
		}
		

		CollateralProfile.CollateralProfileBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralProfile  ***********************/
	class CollateralProfileImpl implements CollateralProfile {
		private final String value;
		private final String collateralProfileScheme;
		
		protected CollateralProfileImpl(CollateralProfile.CollateralProfileBuilder builder) {
			this.value = builder.getValue();
			this.collateralProfileScheme = builder.getCollateralProfileScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralProfileScheme")
		public String getCollateralProfileScheme() {
			return collateralProfileScheme;
		}
		
		@Override
		public CollateralProfile build() {
			return this;
		}
		
		@Override
		public CollateralProfile.CollateralProfileBuilder toBuilder() {
			CollateralProfile.CollateralProfileBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralProfile.CollateralProfileBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralProfileScheme()).ifPresent(builder::setCollateralProfileScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralProfile _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralProfileScheme, _that.getCollateralProfileScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralProfileScheme != null ? collateralProfileScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralProfile {" +
				"value=" + this.value + ", " +
				"collateralProfileScheme=" + this.collateralProfileScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralProfile  ***********************/
	class CollateralProfileBuilderImpl implements CollateralProfile.CollateralProfileBuilder {
	
		protected String value;
		protected String collateralProfileScheme;
	
		public CollateralProfileBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralProfileScheme")
		public String getCollateralProfileScheme() {
			return collateralProfileScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CollateralProfile.CollateralProfileBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("collateralProfileScheme")
		public CollateralProfile.CollateralProfileBuilder setCollateralProfileScheme(String collateralProfileScheme) {
			this.collateralProfileScheme = collateralProfileScheme==null?null:collateralProfileScheme;
			return this;
		}
		
		@Override
		public CollateralProfile build() {
			return new CollateralProfile.CollateralProfileImpl(this);
		}
		
		@Override
		public CollateralProfile.CollateralProfileBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralProfile.CollateralProfileBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCollateralProfileScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralProfile.CollateralProfileBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralProfile.CollateralProfileBuilder o = (CollateralProfile.CollateralProfileBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralProfileScheme(), o.getCollateralProfileScheme(), this::setCollateralProfileScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralProfile _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralProfileScheme, _that.getCollateralProfileScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralProfileScheme != null ? collateralProfileScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralProfileBuilder {" +
				"value=" + this.value + ", " +
				"collateralProfileScheme=" + this.collateralProfileScheme +
			'}';
		}
	}
}
