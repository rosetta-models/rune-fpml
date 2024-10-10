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
import fpml.confirmation.CoalProductType;
import fpml.confirmation.CoalProductType.CoalProductTypeBuilder;
import fpml.confirmation.CoalProductType.CoalProductTypeBuilderImpl;
import fpml.confirmation.CoalProductType.CoalProductTypeImpl;
import fpml.confirmation.meta.CoalProductTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the types of coal for a physically settled coal trade.
 * @version ${project.version}
 */
@RosettaDataType(value="CoalProductType", builder=CoalProductType.CoalProductTypeBuilderImpl.class, version="${project.version}")
public interface CoalProductType extends RosettaModelObject {

	CoalProductTypeMeta metaData = new CoalProductTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityCoalProductTypeScheme();

	/*********************** Build Methods  ***********************/
	CoalProductType build();
	
	CoalProductType.CoalProductTypeBuilder toBuilder();
	
	static CoalProductType.CoalProductTypeBuilder builder() {
		return new CoalProductType.CoalProductTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalProductType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalProductType> getType() {
		return CoalProductType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityCoalProductTypeScheme"), String.class, getCommodityCoalProductTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalProductTypeBuilder extends CoalProductType, RosettaModelObjectBuilder {
		CoalProductType.CoalProductTypeBuilder setValue(String value);
		CoalProductType.CoalProductTypeBuilder setCommodityCoalProductTypeScheme(String commodityCoalProductTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityCoalProductTypeScheme"), String.class, getCommodityCoalProductTypeScheme(), this);
		}
		

		CoalProductType.CoalProductTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CoalProductType  ***********************/
	class CoalProductTypeImpl implements CoalProductType {
		private final String value;
		private final String commodityCoalProductTypeScheme;
		
		protected CoalProductTypeImpl(CoalProductType.CoalProductTypeBuilder builder) {
			this.value = builder.getValue();
			this.commodityCoalProductTypeScheme = builder.getCommodityCoalProductTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalProductTypeScheme")
		public String getCommodityCoalProductTypeScheme() {
			return commodityCoalProductTypeScheme;
		}
		
		@Override
		public CoalProductType build() {
			return this;
		}
		
		@Override
		public CoalProductType.CoalProductTypeBuilder toBuilder() {
			CoalProductType.CoalProductTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalProductType.CoalProductTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityCoalProductTypeScheme()).ifPresent(builder::setCommodityCoalProductTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProductType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalProductTypeScheme, _that.getCommodityCoalProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalProductTypeScheme != null ? commodityCoalProductTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductType {" +
				"value=" + this.value + ", " +
				"commodityCoalProductTypeScheme=" + this.commodityCoalProductTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalProductType  ***********************/
	class CoalProductTypeBuilderImpl implements CoalProductType.CoalProductTypeBuilder {
	
		protected String value;
		protected String commodityCoalProductTypeScheme;
	
		public CoalProductTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalProductTypeScheme")
		public String getCommodityCoalProductTypeScheme() {
			return commodityCoalProductTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CoalProductType.CoalProductTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityCoalProductTypeScheme")
		public CoalProductType.CoalProductTypeBuilder setCommodityCoalProductTypeScheme(String commodityCoalProductTypeScheme) {
			this.commodityCoalProductTypeScheme = commodityCoalProductTypeScheme==null?null:commodityCoalProductTypeScheme;
			return this;
		}
		
		@Override
		public CoalProductType build() {
			return new CoalProductType.CoalProductTypeImpl(this);
		}
		
		@Override
		public CoalProductType.CoalProductTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProductType.CoalProductTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityCoalProductTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProductType.CoalProductTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalProductType.CoalProductTypeBuilder o = (CoalProductType.CoalProductTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityCoalProductTypeScheme(), o.getCommodityCoalProductTypeScheme(), this::setCommodityCoalProductTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProductType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalProductTypeScheme, _that.getCommodityCoalProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalProductTypeScheme != null ? commodityCoalProductTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductTypeBuilder {" +
				"value=" + this.value + ", " +
				"commodityCoalProductTypeScheme=" + this.commodityCoalProductTypeScheme +
			'}';
		}
	}
}
