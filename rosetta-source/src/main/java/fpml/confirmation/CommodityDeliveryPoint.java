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
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.CommodityDeliveryPoint.CommodityDeliveryPointBuilder;
import fpml.confirmation.CommodityDeliveryPoint.CommodityDeliveryPointBuilderImpl;
import fpml.confirmation.CommodityDeliveryPoint.CommodityDeliveryPointImpl;
import fpml.confirmation.meta.CommodityDeliveryPointMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the types of the Delivery Point for a physically settled commodity trade.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDeliveryPoint", builder=CommodityDeliveryPoint.CommodityDeliveryPointBuilderImpl.class, version="${project.version}")
public interface CommodityDeliveryPoint extends RosettaModelObject {

	CommodityDeliveryPointMeta metaData = new CommodityDeliveryPointMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeliveryPointScheme();

	/*********************** Build Methods  ***********************/
	CommodityDeliveryPoint build();
	
	CommodityDeliveryPoint.CommodityDeliveryPointBuilder toBuilder();
	
	static CommodityDeliveryPoint.CommodityDeliveryPointBuilder builder() {
		return new CommodityDeliveryPoint.CommodityDeliveryPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDeliveryPoint> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDeliveryPoint> getType() {
		return CommodityDeliveryPoint.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDeliveryPointBuilder extends CommodityDeliveryPoint, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder setValue(String value);
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
		}
		

		CommodityDeliveryPoint.CommodityDeliveryPointBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDeliveryPoint  ***********************/
	class CommodityDeliveryPointImpl implements CommodityDeliveryPoint {
		private final String value;
		private final String deliveryPointScheme;
		
		protected CommodityDeliveryPointImpl(CommodityDeliveryPoint.CommodityDeliveryPointBuilder builder) {
			this.value = builder.getValue();
			this.deliveryPointScheme = builder.getDeliveryPointScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryPointScheme")
		public String getDeliveryPointScheme() {
			return deliveryPointScheme;
		}
		
		@Override
		public CommodityDeliveryPoint build() {
			return this;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder toBuilder() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDeliveryPoint.CommodityDeliveryPointBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryPointScheme()).ifPresent(builder::setDeliveryPointScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPoint _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryPointScheme, _that.getDeliveryPointScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryPointScheme != null ? deliveryPointScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPoint {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDeliveryPoint  ***********************/
	class CommodityDeliveryPointBuilderImpl implements CommodityDeliveryPoint.CommodityDeliveryPointBuilder {
	
		protected String value;
		protected String deliveryPointScheme;
	
		public CommodityDeliveryPointBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryPointScheme")
		public String getDeliveryPointScheme() {
			return deliveryPointScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPointScheme")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme) {
			this.deliveryPointScheme = deliveryPointScheme==null?null:deliveryPointScheme;
			return this;
		}
		
		@Override
		public CommodityDeliveryPoint build() {
			return new CommodityDeliveryPoint.CommodityDeliveryPointImpl(this);
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeliveryPointScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder o = (CommodityDeliveryPoint.CommodityDeliveryPointBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryPointScheme(), o.getDeliveryPointScheme(), this::setDeliveryPointScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPoint _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryPointScheme, _that.getDeliveryPointScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryPointScheme != null ? deliveryPointScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPointBuilder {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}
}
