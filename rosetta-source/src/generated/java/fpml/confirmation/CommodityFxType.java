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
import fpml.confirmation.CommodityFxType;
import fpml.confirmation.CommodityFxType.CommodityFxTypeBuilder;
import fpml.confirmation.CommodityFxType.CommodityFxTypeBuilderImpl;
import fpml.confirmation.CommodityFxType.CommodityFxTypeImpl;
import fpml.confirmation.meta.CommodityFxTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifes how the FX rate will be applied. This is intended to differentiate between the various methods for applying FX to the floating price such as a daily calculation, or averaging the FX and applying the average at the end of each CalculationPeriod.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFxType", builder=CommodityFxType.CommodityFxTypeBuilderImpl.class, version="${project.version}")
public interface CommodityFxType extends RosettaModelObject {

	CommodityFxTypeMeta metaData = new CommodityFxTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityFxTypeScheme();

	/*********************** Build Methods  ***********************/
	CommodityFxType build();
	
	CommodityFxType.CommodityFxTypeBuilder toBuilder();
	
	static CommodityFxType.CommodityFxTypeBuilder builder() {
		return new CommodityFxType.CommodityFxTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFxType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFxType> getType() {
		return CommodityFxType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityFxTypeScheme"), String.class, getCommodityFxTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFxTypeBuilder extends CommodityFxType, RosettaModelObjectBuilder {
		CommodityFxType.CommodityFxTypeBuilder setValue(String value);
		CommodityFxType.CommodityFxTypeBuilder setCommodityFxTypeScheme(String commodityFxTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityFxTypeScheme"), String.class, getCommodityFxTypeScheme(), this);
		}
		

		CommodityFxType.CommodityFxTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFxType  ***********************/
	class CommodityFxTypeImpl implements CommodityFxType {
		private final String value;
		private final String commodityFxTypeScheme;
		
		protected CommodityFxTypeImpl(CommodityFxType.CommodityFxTypeBuilder builder) {
			this.value = builder.getValue();
			this.commodityFxTypeScheme = builder.getCommodityFxTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityFxTypeScheme")
		public String getCommodityFxTypeScheme() {
			return commodityFxTypeScheme;
		}
		
		@Override
		public CommodityFxType build() {
			return this;
		}
		
		@Override
		public CommodityFxType.CommodityFxTypeBuilder toBuilder() {
			CommodityFxType.CommodityFxTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFxType.CommodityFxTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityFxTypeScheme()).ifPresent(builder::setCommodityFxTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFxTypeScheme, _that.getCommodityFxTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFxTypeScheme != null ? commodityFxTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxType {" +
				"value=" + this.value + ", " +
				"commodityFxTypeScheme=" + this.commodityFxTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFxType  ***********************/
	class CommodityFxTypeBuilderImpl implements CommodityFxType.CommodityFxTypeBuilder {
	
		protected String value;
		protected String commodityFxTypeScheme;
	
		public CommodityFxTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityFxTypeScheme")
		public String getCommodityFxTypeScheme() {
			return commodityFxTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityFxType.CommodityFxTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityFxTypeScheme")
		public CommodityFxType.CommodityFxTypeBuilder setCommodityFxTypeScheme(String commodityFxTypeScheme) {
			this.commodityFxTypeScheme = commodityFxTypeScheme==null?null:commodityFxTypeScheme;
			return this;
		}
		
		@Override
		public CommodityFxType build() {
			return new CommodityFxType.CommodityFxTypeImpl(this);
		}
		
		@Override
		public CommodityFxType.CommodityFxTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxType.CommodityFxTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityFxTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxType.CommodityFxTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFxType.CommodityFxTypeBuilder o = (CommodityFxType.CommodityFxTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityFxTypeScheme(), o.getCommodityFxTypeScheme(), this::setCommodityFxTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFxTypeScheme, _that.getCommodityFxTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFxTypeScheme != null ? commodityFxTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxTypeBuilder {" +
				"value=" + this.value + ", " +
				"commodityFxTypeScheme=" + this.commodityFxTypeScheme +
			'}';
		}
	}
}
