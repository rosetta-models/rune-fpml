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
import fpml.confirmation.CommodityMetalShape;
import fpml.confirmation.CommodityMetalShape.CommodityMetalShapeBuilder;
import fpml.confirmation.CommodityMetalShape.CommodityMetalShapeBuilderImpl;
import fpml.confirmation.CommodityMetalShape.CommodityMetalShapeImpl;
import fpml.confirmation.meta.CommodityMetalShapeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityMetalShape", builder=CommodityMetalShape.CommodityMetalShapeBuilderImpl.class, version="${project.version}")
public interface CommodityMetalShape extends RosettaModelObject {

	CommodityMetalShapeMeta metaData = new CommodityMetalShapeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityMetalShapeScheme();

	/*********************** Build Methods  ***********************/
	CommodityMetalShape build();
	
	CommodityMetalShape.CommodityMetalShapeBuilder toBuilder();
	
	static CommodityMetalShape.CommodityMetalShapeBuilder builder() {
		return new CommodityMetalShape.CommodityMetalShapeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMetalShape> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityMetalShape> getType() {
		return CommodityMetalShape.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMetalShapeScheme"), String.class, getCommodityMetalShapeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMetalShapeBuilder extends CommodityMetalShape, RosettaModelObjectBuilder {
		CommodityMetalShape.CommodityMetalShapeBuilder setValue(String value);
		CommodityMetalShape.CommodityMetalShapeBuilder setCommodityMetalShapeScheme(String commodityMetalShapeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMetalShapeScheme"), String.class, getCommodityMetalShapeScheme(), this);
		}
		

		CommodityMetalShape.CommodityMetalShapeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMetalShape  ***********************/
	class CommodityMetalShapeImpl implements CommodityMetalShape {
		private final String value;
		private final String commodityMetalShapeScheme;
		
		protected CommodityMetalShapeImpl(CommodityMetalShape.CommodityMetalShapeBuilder builder) {
			this.value = builder.getValue();
			this.commodityMetalShapeScheme = builder.getCommodityMetalShapeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalShapeScheme")
		public String getCommodityMetalShapeScheme() {
			return commodityMetalShapeScheme;
		}
		
		@Override
		public CommodityMetalShape build() {
			return this;
		}
		
		@Override
		public CommodityMetalShape.CommodityMetalShapeBuilder toBuilder() {
			CommodityMetalShape.CommodityMetalShapeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMetalShape.CommodityMetalShapeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMetalShapeScheme()).ifPresent(builder::setCommodityMetalShapeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalShape _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalShapeScheme, _that.getCommodityMetalShapeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalShapeScheme != null ? commodityMetalShapeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalShape {" +
				"value=" + this.value + ", " +
				"commodityMetalShapeScheme=" + this.commodityMetalShapeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMetalShape  ***********************/
	class CommodityMetalShapeBuilderImpl implements CommodityMetalShape.CommodityMetalShapeBuilder {
	
		protected String value;
		protected String commodityMetalShapeScheme;
	
		public CommodityMetalShapeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalShapeScheme")
		public String getCommodityMetalShapeScheme() {
			return commodityMetalShapeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityMetalShape.CommodityMetalShapeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityMetalShapeScheme")
		public CommodityMetalShape.CommodityMetalShapeBuilder setCommodityMetalShapeScheme(String commodityMetalShapeScheme) {
			this.commodityMetalShapeScheme = commodityMetalShapeScheme==null?null:commodityMetalShapeScheme;
			return this;
		}
		
		@Override
		public CommodityMetalShape build() {
			return new CommodityMetalShape.CommodityMetalShapeImpl(this);
		}
		
		@Override
		public CommodityMetalShape.CommodityMetalShapeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalShape.CommodityMetalShapeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMetalShapeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalShape.CommodityMetalShapeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMetalShape.CommodityMetalShapeBuilder o = (CommodityMetalShape.CommodityMetalShapeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMetalShapeScheme(), o.getCommodityMetalShapeScheme(), this::setCommodityMetalShapeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalShape _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalShapeScheme, _that.getCommodityMetalShapeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalShapeScheme != null ? commodityMetalShapeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalShapeBuilder {" +
				"value=" + this.value + ", " +
				"commodityMetalShapeScheme=" + this.commodityMetalShapeScheme +
			'}';
		}
	}
}
