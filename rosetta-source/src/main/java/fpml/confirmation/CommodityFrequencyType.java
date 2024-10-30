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
import fpml.confirmation.CommodityFrequencyType;
import fpml.confirmation.CommodityFrequencyType.CommodityFrequencyTypeBuilder;
import fpml.confirmation.CommodityFrequencyType.CommodityFrequencyTypeBuilderImpl;
import fpml.confirmation.CommodityFrequencyType.CommodityFrequencyTypeImpl;
import fpml.confirmation.meta.CommodityFrequencyTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Frequency Type for use in Pricing Date specifications.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityFrequencyType", builder=CommodityFrequencyType.CommodityFrequencyTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityFrequencyType extends RosettaModelObject {

	CommodityFrequencyTypeMeta metaData = new CommodityFrequencyTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityFrequencyTypeScheme();

	/*********************** Build Methods  ***********************/
	CommodityFrequencyType build();
	
	CommodityFrequencyType.CommodityFrequencyTypeBuilder toBuilder();
	
	static CommodityFrequencyType.CommodityFrequencyTypeBuilder builder() {
		return new CommodityFrequencyType.CommodityFrequencyTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFrequencyType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFrequencyType> getType() {
		return CommodityFrequencyType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityFrequencyTypeScheme"), String.class, getCommodityFrequencyTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFrequencyTypeBuilder extends CommodityFrequencyType, RosettaModelObjectBuilder {
		CommodityFrequencyType.CommodityFrequencyTypeBuilder setValue(String value);
		CommodityFrequencyType.CommodityFrequencyTypeBuilder setCommodityFrequencyTypeScheme(String commodityFrequencyTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityFrequencyTypeScheme"), String.class, getCommodityFrequencyTypeScheme(), this);
		}
		

		CommodityFrequencyType.CommodityFrequencyTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFrequencyType  ***********************/
	class CommodityFrequencyTypeImpl implements CommodityFrequencyType {
		private final String value;
		private final String commodityFrequencyTypeScheme;
		
		protected CommodityFrequencyTypeImpl(CommodityFrequencyType.CommodityFrequencyTypeBuilder builder) {
			this.value = builder.getValue();
			this.commodityFrequencyTypeScheme = builder.getCommodityFrequencyTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityFrequencyTypeScheme")
		public String getCommodityFrequencyTypeScheme() {
			return commodityFrequencyTypeScheme;
		}
		
		@Override
		public CommodityFrequencyType build() {
			return this;
		}
		
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder toBuilder() {
			CommodityFrequencyType.CommodityFrequencyTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFrequencyType.CommodityFrequencyTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityFrequencyTypeScheme()).ifPresent(builder::setCommodityFrequencyTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFrequencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFrequencyTypeScheme, _that.getCommodityFrequencyTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFrequencyTypeScheme != null ? commodityFrequencyTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFrequencyType {" +
				"value=" + this.value + ", " +
				"commodityFrequencyTypeScheme=" + this.commodityFrequencyTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFrequencyType  ***********************/
	class CommodityFrequencyTypeBuilderImpl implements CommodityFrequencyType.CommodityFrequencyTypeBuilder {
	
		protected String value;
		protected String commodityFrequencyTypeScheme;
	
		public CommodityFrequencyTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityFrequencyTypeScheme")
		public String getCommodityFrequencyTypeScheme() {
			return commodityFrequencyTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityFrequencyTypeScheme")
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder setCommodityFrequencyTypeScheme(String commodityFrequencyTypeScheme) {
			this.commodityFrequencyTypeScheme = commodityFrequencyTypeScheme==null?null:commodityFrequencyTypeScheme;
			return this;
		}
		
		@Override
		public CommodityFrequencyType build() {
			return new CommodityFrequencyType.CommodityFrequencyTypeImpl(this);
		}
		
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityFrequencyTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFrequencyType.CommodityFrequencyTypeBuilder o = (CommodityFrequencyType.CommodityFrequencyTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityFrequencyTypeScheme(), o.getCommodityFrequencyTypeScheme(), this::setCommodityFrequencyTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFrequencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFrequencyTypeScheme, _that.getCommodityFrequencyTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFrequencyTypeScheme != null ? commodityFrequencyTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFrequencyTypeBuilder {" +
				"value=" + this.value + ", " +
				"commodityFrequencyTypeScheme=" + this.commodityFrequencyTypeScheme +
			'}';
		}
	}
}
