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
import fpml.confirmation.CollateralizationType;
import fpml.confirmation.CollateralizationType.CollateralizationTypeBuilder;
import fpml.confirmation.CollateralizationType.CollateralizationTypeBuilderImpl;
import fpml.confirmation.CollateralizationType.CollateralizationTypeImpl;
import fpml.confirmation.meta.CollateralizationTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Code that describes what type of collateral is posted by a party to a transaction. Options include Uncollateralized, Partial, Full, One-Way.
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralizationType", builder=CollateralizationType.CollateralizationTypeBuilderImpl.class, version="${project.version}")
public interface CollateralizationType extends RosettaModelObject {

	CollateralizationTypeMeta metaData = new CollateralizationTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCollateralTypeScheme();

	/*********************** Build Methods  ***********************/
	CollateralizationType build();
	
	CollateralizationType.CollateralizationTypeBuilder toBuilder();
	
	static CollateralizationType.CollateralizationTypeBuilder builder() {
		return new CollateralizationType.CollateralizationTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralizationType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralizationType> getType() {
		return CollateralizationType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralTypeScheme"), String.class, getCollateralTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralizationTypeBuilder extends CollateralizationType, RosettaModelObjectBuilder {
		CollateralizationType.CollateralizationTypeBuilder setValue(String value);
		CollateralizationType.CollateralizationTypeBuilder setCollateralTypeScheme(String collateralTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralTypeScheme"), String.class, getCollateralTypeScheme(), this);
		}
		

		CollateralizationType.CollateralizationTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralizationType  ***********************/
	class CollateralizationTypeImpl implements CollateralizationType {
		private final String value;
		private final String collateralTypeScheme;
		
		protected CollateralizationTypeImpl(CollateralizationType.CollateralizationTypeBuilder builder) {
			this.value = builder.getValue();
			this.collateralTypeScheme = builder.getCollateralTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralTypeScheme")
		public String getCollateralTypeScheme() {
			return collateralTypeScheme;
		}
		
		@Override
		public CollateralizationType build() {
			return this;
		}
		
		@Override
		public CollateralizationType.CollateralizationTypeBuilder toBuilder() {
			CollateralizationType.CollateralizationTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralizationType.CollateralizationTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralTypeScheme()).ifPresent(builder::setCollateralTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralizationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralTypeScheme, _that.getCollateralTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralTypeScheme != null ? collateralTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralizationType {" +
				"value=" + this.value + ", " +
				"collateralTypeScheme=" + this.collateralTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralizationType  ***********************/
	class CollateralizationTypeBuilderImpl implements CollateralizationType.CollateralizationTypeBuilder {
	
		protected String value;
		protected String collateralTypeScheme;
	
		public CollateralizationTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralTypeScheme")
		public String getCollateralTypeScheme() {
			return collateralTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CollateralizationType.CollateralizationTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("collateralTypeScheme")
		public CollateralizationType.CollateralizationTypeBuilder setCollateralTypeScheme(String collateralTypeScheme) {
			this.collateralTypeScheme = collateralTypeScheme==null?null:collateralTypeScheme;
			return this;
		}
		
		@Override
		public CollateralizationType build() {
			return new CollateralizationType.CollateralizationTypeImpl(this);
		}
		
		@Override
		public CollateralizationType.CollateralizationTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralizationType.CollateralizationTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCollateralTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralizationType.CollateralizationTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralizationType.CollateralizationTypeBuilder o = (CollateralizationType.CollateralizationTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralTypeScheme(), o.getCollateralTypeScheme(), this::setCollateralTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralizationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralTypeScheme, _that.getCollateralTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralTypeScheme != null ? collateralTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralizationTypeBuilder {" +
				"value=" + this.value + ", " +
				"collateralTypeScheme=" + this.collateralTypeScheme +
			'}';
		}
	}
}
