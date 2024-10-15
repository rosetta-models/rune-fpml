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
import fpml.confirmation.OilProductType;
import fpml.confirmation.OilProductType.OilProductTypeBuilder;
import fpml.confirmation.OilProductType.OilProductTypeBuilderImpl;
import fpml.confirmation.OilProductType.OilProductTypeImpl;
import fpml.confirmation.meta.OilProductTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The type of physical commodity product to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="OilProductType", builder=OilProductType.OilProductTypeBuilderImpl.class, version="${project.version}")
public interface OilProductType extends RosettaModelObject {

	OilProductTypeMeta metaData = new OilProductTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityOilProductTypeScheme();

	/*********************** Build Methods  ***********************/
	OilProductType build();
	
	OilProductType.OilProductTypeBuilder toBuilder();
	
	static OilProductType.OilProductTypeBuilder builder() {
		return new OilProductType.OilProductTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilProductType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OilProductType> getType() {
		return OilProductType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityOilProductTypeScheme"), String.class, getCommodityOilProductTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilProductTypeBuilder extends OilProductType, RosettaModelObjectBuilder {
		OilProductType.OilProductTypeBuilder setValue(String value);
		OilProductType.OilProductTypeBuilder setCommodityOilProductTypeScheme(String commodityOilProductTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityOilProductTypeScheme"), String.class, getCommodityOilProductTypeScheme(), this);
		}
		

		OilProductType.OilProductTypeBuilder prune();
	}

	/*********************** Immutable Implementation of OilProductType  ***********************/
	class OilProductTypeImpl implements OilProductType {
		private final String value;
		private final String commodityOilProductTypeScheme;
		
		protected OilProductTypeImpl(OilProductType.OilProductTypeBuilder builder) {
			this.value = builder.getValue();
			this.commodityOilProductTypeScheme = builder.getCommodityOilProductTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityOilProductTypeScheme")
		public String getCommodityOilProductTypeScheme() {
			return commodityOilProductTypeScheme;
		}
		
		@Override
		public OilProductType build() {
			return this;
		}
		
		@Override
		public OilProductType.OilProductTypeBuilder toBuilder() {
			OilProductType.OilProductTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilProductType.OilProductTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityOilProductTypeScheme()).ifPresent(builder::setCommodityOilProductTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilProductType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityOilProductTypeScheme, _that.getCommodityOilProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityOilProductTypeScheme != null ? commodityOilProductTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilProductType {" +
				"value=" + this.value + ", " +
				"commodityOilProductTypeScheme=" + this.commodityOilProductTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OilProductType  ***********************/
	class OilProductTypeBuilderImpl implements OilProductType.OilProductTypeBuilder {
	
		protected String value;
		protected String commodityOilProductTypeScheme;
	
		public OilProductTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityOilProductTypeScheme")
		public String getCommodityOilProductTypeScheme() {
			return commodityOilProductTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OilProductType.OilProductTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityOilProductTypeScheme")
		public OilProductType.OilProductTypeBuilder setCommodityOilProductTypeScheme(String commodityOilProductTypeScheme) {
			this.commodityOilProductTypeScheme = commodityOilProductTypeScheme==null?null:commodityOilProductTypeScheme;
			return this;
		}
		
		@Override
		public OilProductType build() {
			return new OilProductType.OilProductTypeImpl(this);
		}
		
		@Override
		public OilProductType.OilProductTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilProductType.OilProductTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityOilProductTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilProductType.OilProductTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilProductType.OilProductTypeBuilder o = (OilProductType.OilProductTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityOilProductTypeScheme(), o.getCommodityOilProductTypeScheme(), this::setCommodityOilProductTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilProductType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityOilProductTypeScheme, _that.getCommodityOilProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityOilProductTypeScheme != null ? commodityOilProductTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilProductTypeBuilder {" +
				"value=" + this.value + ", " +
				"commodityOilProductTypeScheme=" + this.commodityOilProductTypeScheme +
			'}';
		}
	}
}
