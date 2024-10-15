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
import fpml.confirmation.CommodityBase;
import fpml.confirmation.CommodityBase.CommodityBaseBuilder;
import fpml.confirmation.CommodityBase.CommodityBaseBuilderImpl;
import fpml.confirmation.CommodityBase.CommodityBaseImpl;
import fpml.confirmation.meta.CommodityBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBase", builder=CommodityBase.CommodityBaseBuilderImpl.class, version="${project.version}")
public interface CommodityBase extends RosettaModelObject {

	CommodityBaseMeta metaData = new CommodityBaseMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityBaseScheme();

	/*********************** Build Methods  ***********************/
	CommodityBase build();
	
	CommodityBase.CommodityBaseBuilder toBuilder();
	
	static CommodityBase.CommodityBaseBuilder builder() {
		return new CommodityBase.CommodityBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBase> getType() {
		return CommodityBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityBaseScheme"), String.class, getCommodityBaseScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBaseBuilder extends CommodityBase, RosettaModelObjectBuilder {
		CommodityBase.CommodityBaseBuilder setValue(String value);
		CommodityBase.CommodityBaseBuilder setCommodityBaseScheme(String commodityBaseScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityBaseScheme"), String.class, getCommodityBaseScheme(), this);
		}
		

		CommodityBase.CommodityBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBase  ***********************/
	class CommodityBaseImpl implements CommodityBase {
		private final String value;
		private final String commodityBaseScheme;
		
		protected CommodityBaseImpl(CommodityBase.CommodityBaseBuilder builder) {
			this.value = builder.getValue();
			this.commodityBaseScheme = builder.getCommodityBaseScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityBaseScheme")
		public String getCommodityBaseScheme() {
			return commodityBaseScheme;
		}
		
		@Override
		public CommodityBase build() {
			return this;
		}
		
		@Override
		public CommodityBase.CommodityBaseBuilder toBuilder() {
			CommodityBase.CommodityBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBase.CommodityBaseBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityBaseScheme()).ifPresent(builder::setCommodityBaseScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBase _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityBaseScheme, _that.getCommodityBaseScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityBaseScheme != null ? commodityBaseScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBase {" +
				"value=" + this.value + ", " +
				"commodityBaseScheme=" + this.commodityBaseScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBase  ***********************/
	class CommodityBaseBuilderImpl implements CommodityBase.CommodityBaseBuilder {
	
		protected String value;
		protected String commodityBaseScheme;
	
		public CommodityBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityBaseScheme")
		public String getCommodityBaseScheme() {
			return commodityBaseScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityBase.CommodityBaseBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityBaseScheme")
		public CommodityBase.CommodityBaseBuilder setCommodityBaseScheme(String commodityBaseScheme) {
			this.commodityBaseScheme = commodityBaseScheme==null?null:commodityBaseScheme;
			return this;
		}
		
		@Override
		public CommodityBase build() {
			return new CommodityBase.CommodityBaseImpl(this);
		}
		
		@Override
		public CommodityBase.CommodityBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBase.CommodityBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityBaseScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBase.CommodityBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBase.CommodityBaseBuilder o = (CommodityBase.CommodityBaseBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityBaseScheme(), o.getCommodityBaseScheme(), this::setCommodityBaseScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBase _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityBaseScheme, _that.getCommodityBaseScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityBaseScheme != null ? commodityBaseScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBaseBuilder {" +
				"value=" + this.value + ", " +
				"commodityBaseScheme=" + this.commodityBaseScheme +
			'}';
		}
	}
}
