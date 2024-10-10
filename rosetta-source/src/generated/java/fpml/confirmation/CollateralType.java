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
import fpml.confirmation.CollateralType;
import fpml.confirmation.CollateralType.CollateralTypeBuilder;
import fpml.confirmation.CollateralType.CollateralTypeBuilderImpl;
import fpml.confirmation.CollateralType.CollateralTypeImpl;
import fpml.confirmation.meta.CollateralTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralType", builder=CollateralType.CollateralTypeBuilderImpl.class, version="${project.version}")
public interface CollateralType extends RosettaModelObject {

	CollateralTypeMeta metaData = new CollateralTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCollateralTypeScheme();

	/*********************** Build Methods  ***********************/
	CollateralType build();
	
	CollateralType.CollateralTypeBuilder toBuilder();
	
	static CollateralType.CollateralTypeBuilder builder() {
		return new CollateralType.CollateralTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralType> getType() {
		return CollateralType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralTypeScheme"), String.class, getCollateralTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralTypeBuilder extends CollateralType, RosettaModelObjectBuilder {
		CollateralType.CollateralTypeBuilder setValue(String value);
		CollateralType.CollateralTypeBuilder setCollateralTypeScheme(String collateralTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralTypeScheme"), String.class, getCollateralTypeScheme(), this);
		}
		

		CollateralType.CollateralTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralType  ***********************/
	class CollateralTypeImpl implements CollateralType {
		private final String value;
		private final String collateralTypeScheme;
		
		protected CollateralTypeImpl(CollateralType.CollateralTypeBuilder builder) {
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
		public CollateralType build() {
			return this;
		}
		
		@Override
		public CollateralType.CollateralTypeBuilder toBuilder() {
			CollateralType.CollateralTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralType.CollateralTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralTypeScheme()).ifPresent(builder::setCollateralTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralType _that = getType().cast(o);
		
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
			return "CollateralType {" +
				"value=" + this.value + ", " +
				"collateralTypeScheme=" + this.collateralTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralType  ***********************/
	class CollateralTypeBuilderImpl implements CollateralType.CollateralTypeBuilder {
	
		protected String value;
		protected String collateralTypeScheme;
	
		public CollateralTypeBuilderImpl() {
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
		public CollateralType.CollateralTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("collateralTypeScheme")
		public CollateralType.CollateralTypeBuilder setCollateralTypeScheme(String collateralTypeScheme) {
			this.collateralTypeScheme = collateralTypeScheme==null?null:collateralTypeScheme;
			return this;
		}
		
		@Override
		public CollateralType build() {
			return new CollateralType.CollateralTypeImpl(this);
		}
		
		@Override
		public CollateralType.CollateralTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralType.CollateralTypeBuilder prune() {
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
		public CollateralType.CollateralTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralType.CollateralTypeBuilder o = (CollateralType.CollateralTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralTypeScheme(), o.getCollateralTypeScheme(), this::setCollateralTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralType _that = getType().cast(o);
		
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
			return "CollateralTypeBuilder {" +
				"value=" + this.value + ", " +
				"collateralTypeScheme=" + this.collateralTypeScheme +
			'}';
		}
	}
}
