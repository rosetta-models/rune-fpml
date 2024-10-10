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
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.CommodityDeliveryRisk.CommodityDeliveryRiskBuilder;
import fpml.confirmation.CommodityDeliveryRisk.CommodityDeliveryRiskBuilderImpl;
import fpml.confirmation.CommodityDeliveryRisk.CommodityDeliveryRiskImpl;
import fpml.confirmation.meta.CommodityDeliveryRiskMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying how the parties to the trade aportion responsibility for the delivery of the commodity product (for example Free On Board, Cost, Insurance, Freight)
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDeliveryRisk", builder=CommodityDeliveryRisk.CommodityDeliveryRiskBuilderImpl.class, version="${project.version}")
public interface CommodityDeliveryRisk extends RosettaModelObject {

	CommodityDeliveryRiskMeta metaData = new CommodityDeliveryRiskMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeliveryRiskScheme();

	/*********************** Build Methods  ***********************/
	CommodityDeliveryRisk build();
	
	CommodityDeliveryRisk.CommodityDeliveryRiskBuilder toBuilder();
	
	static CommodityDeliveryRisk.CommodityDeliveryRiskBuilder builder() {
		return new CommodityDeliveryRisk.CommodityDeliveryRiskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDeliveryRisk> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDeliveryRisk> getType() {
		return CommodityDeliveryRisk.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryRiskScheme"), String.class, getDeliveryRiskScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDeliveryRiskBuilder extends CommodityDeliveryRisk, RosettaModelObjectBuilder {
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder setValue(String value);
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder setDeliveryRiskScheme(String deliveryRiskScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryRiskScheme"), String.class, getDeliveryRiskScheme(), this);
		}
		

		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDeliveryRisk  ***********************/
	class CommodityDeliveryRiskImpl implements CommodityDeliveryRisk {
		private final String value;
		private final String deliveryRiskScheme;
		
		protected CommodityDeliveryRiskImpl(CommodityDeliveryRisk.CommodityDeliveryRiskBuilder builder) {
			this.value = builder.getValue();
			this.deliveryRiskScheme = builder.getDeliveryRiskScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryRiskScheme")
		public String getDeliveryRiskScheme() {
			return deliveryRiskScheme;
		}
		
		@Override
		public CommodityDeliveryRisk build() {
			return this;
		}
		
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder toBuilder() {
			CommodityDeliveryRisk.CommodityDeliveryRiskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDeliveryRisk.CommodityDeliveryRiskBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryRiskScheme()).ifPresent(builder::setDeliveryRiskScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryRisk _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryRiskScheme, _that.getDeliveryRiskScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryRiskScheme != null ? deliveryRiskScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryRisk {" +
				"value=" + this.value + ", " +
				"deliveryRiskScheme=" + this.deliveryRiskScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDeliveryRisk  ***********************/
	class CommodityDeliveryRiskBuilderImpl implements CommodityDeliveryRisk.CommodityDeliveryRiskBuilder {
	
		protected String value;
		protected String deliveryRiskScheme;
	
		public CommodityDeliveryRiskBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryRiskScheme")
		public String getDeliveryRiskScheme() {
			return deliveryRiskScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryRiskScheme")
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder setDeliveryRiskScheme(String deliveryRiskScheme) {
			this.deliveryRiskScheme = deliveryRiskScheme==null?null:deliveryRiskScheme;
			return this;
		}
		
		@Override
		public CommodityDeliveryRisk build() {
			return new CommodityDeliveryRisk.CommodityDeliveryRiskImpl(this);
		}
		
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeliveryRiskScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDeliveryRisk.CommodityDeliveryRiskBuilder o = (CommodityDeliveryRisk.CommodityDeliveryRiskBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryRiskScheme(), o.getDeliveryRiskScheme(), this::setDeliveryRiskScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryRisk _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryRiskScheme, _that.getDeliveryRiskScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryRiskScheme != null ? deliveryRiskScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryRiskBuilder {" +
				"value=" + this.value + ", " +
				"deliveryRiskScheme=" + this.deliveryRiskScheme +
			'}';
		}
	}
}
