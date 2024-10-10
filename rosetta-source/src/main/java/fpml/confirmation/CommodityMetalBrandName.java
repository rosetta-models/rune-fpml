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
import fpml.confirmation.CommodityMetalBrandName;
import fpml.confirmation.CommodityMetalBrandName.CommodityMetalBrandNameBuilder;
import fpml.confirmation.CommodityMetalBrandName.CommodityMetalBrandNameBuilderImpl;
import fpml.confirmation.CommodityMetalBrandName.CommodityMetalBrandNameImpl;
import fpml.confirmation.meta.CommodityMetalBrandNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The name of the entity that issues the brand
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityMetalBrandName", builder=CommodityMetalBrandName.CommodityMetalBrandNameBuilderImpl.class, version="${project.version}")
public interface CommodityMetalBrandName extends RosettaModelObject {

	CommodityMetalBrandNameMeta metaData = new CommodityMetalBrandNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityMetalBrandNameScheme();

	/*********************** Build Methods  ***********************/
	CommodityMetalBrandName build();
	
	CommodityMetalBrandName.CommodityMetalBrandNameBuilder toBuilder();
	
	static CommodityMetalBrandName.CommodityMetalBrandNameBuilder builder() {
		return new CommodityMetalBrandName.CommodityMetalBrandNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMetalBrandName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityMetalBrandName> getType() {
		return CommodityMetalBrandName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMetalBrandNameScheme"), String.class, getCommodityMetalBrandNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMetalBrandNameBuilder extends CommodityMetalBrandName, RosettaModelObjectBuilder {
		CommodityMetalBrandName.CommodityMetalBrandNameBuilder setValue(String value);
		CommodityMetalBrandName.CommodityMetalBrandNameBuilder setCommodityMetalBrandNameScheme(String commodityMetalBrandNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMetalBrandNameScheme"), String.class, getCommodityMetalBrandNameScheme(), this);
		}
		

		CommodityMetalBrandName.CommodityMetalBrandNameBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMetalBrandName  ***********************/
	class CommodityMetalBrandNameImpl implements CommodityMetalBrandName {
		private final String value;
		private final String commodityMetalBrandNameScheme;
		
		protected CommodityMetalBrandNameImpl(CommodityMetalBrandName.CommodityMetalBrandNameBuilder builder) {
			this.value = builder.getValue();
			this.commodityMetalBrandNameScheme = builder.getCommodityMetalBrandNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalBrandNameScheme")
		public String getCommodityMetalBrandNameScheme() {
			return commodityMetalBrandNameScheme;
		}
		
		@Override
		public CommodityMetalBrandName build() {
			return this;
		}
		
		@Override
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder toBuilder() {
			CommodityMetalBrandName.CommodityMetalBrandNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMetalBrandName.CommodityMetalBrandNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMetalBrandNameScheme()).ifPresent(builder::setCommodityMetalBrandNameScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalBrandName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalBrandNameScheme, _that.getCommodityMetalBrandNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalBrandNameScheme != null ? commodityMetalBrandNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalBrandName {" +
				"value=" + this.value + ", " +
				"commodityMetalBrandNameScheme=" + this.commodityMetalBrandNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMetalBrandName  ***********************/
	class CommodityMetalBrandNameBuilderImpl implements CommodityMetalBrandName.CommodityMetalBrandNameBuilder {
	
		protected String value;
		protected String commodityMetalBrandNameScheme;
	
		public CommodityMetalBrandNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalBrandNameScheme")
		public String getCommodityMetalBrandNameScheme() {
			return commodityMetalBrandNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityMetalBrandNameScheme")
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder setCommodityMetalBrandNameScheme(String commodityMetalBrandNameScheme) {
			this.commodityMetalBrandNameScheme = commodityMetalBrandNameScheme==null?null:commodityMetalBrandNameScheme;
			return this;
		}
		
		@Override
		public CommodityMetalBrandName build() {
			return new CommodityMetalBrandName.CommodityMetalBrandNameImpl(this);
		}
		
		@Override
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMetalBrandNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMetalBrandName.CommodityMetalBrandNameBuilder o = (CommodityMetalBrandName.CommodityMetalBrandNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMetalBrandNameScheme(), o.getCommodityMetalBrandNameScheme(), this::setCommodityMetalBrandNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalBrandName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalBrandNameScheme, _that.getCommodityMetalBrandNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalBrandNameScheme != null ? commodityMetalBrandNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalBrandNameBuilder {" +
				"value=" + this.value + ", " +
				"commodityMetalBrandNameScheme=" + this.commodityMetalBrandNameScheme +
			'}';
		}
	}
}
