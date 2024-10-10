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
import fpml.confirmation.ElectricityDeliveryPoint;
import fpml.confirmation.ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder;
import fpml.confirmation.ElectricityDeliveryPoint.ElectricityDeliveryPointBuilderImpl;
import fpml.confirmation.ElectricityDeliveryPoint.ElectricityDeliveryPointImpl;
import fpml.confirmation.meta.ElectricityDeliveryPointMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the types of the Delivery Point for a physically settled electricity trade.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityDeliveryPoint", builder=ElectricityDeliveryPoint.ElectricityDeliveryPointBuilderImpl.class, version="${project.version}")
public interface ElectricityDeliveryPoint extends RosettaModelObject {

	ElectricityDeliveryPointMeta metaData = new ElectricityDeliveryPointMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeliveryPointScheme();

	/*********************** Build Methods  ***********************/
	ElectricityDeliveryPoint build();
	
	ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder toBuilder();
	
	static ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder builder() {
		return new ElectricityDeliveryPoint.ElectricityDeliveryPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliveryPoint> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityDeliveryPoint> getType() {
		return ElectricityDeliveryPoint.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliveryPointBuilder extends ElectricityDeliveryPoint, RosettaModelObjectBuilder {
		ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder setValue(String value);
		ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
		}
		

		ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliveryPoint  ***********************/
	class ElectricityDeliveryPointImpl implements ElectricityDeliveryPoint {
		private final String value;
		private final String deliveryPointScheme;
		
		protected ElectricityDeliveryPointImpl(ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder builder) {
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
		public ElectricityDeliveryPoint build() {
			return this;
		}
		
		@Override
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder toBuilder() {
			ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryPointScheme()).ifPresent(builder::setDeliveryPointScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryPoint _that = getType().cast(o);
		
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
			return "ElectricityDeliveryPoint {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliveryPoint  ***********************/
	class ElectricityDeliveryPointBuilderImpl implements ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder {
	
		protected String value;
		protected String deliveryPointScheme;
	
		public ElectricityDeliveryPointBuilderImpl() {
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
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPointScheme")
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme) {
			this.deliveryPointScheme = deliveryPointScheme==null?null:deliveryPointScheme;
			return this;
		}
		
		@Override
		public ElectricityDeliveryPoint build() {
			return new ElectricityDeliveryPoint.ElectricityDeliveryPointImpl(this);
		}
		
		@Override
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder prune() {
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
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder o = (ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryPointScheme(), o.getDeliveryPointScheme(), this::setDeliveryPointScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryPoint _that = getType().cast(o);
		
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
			return "ElectricityDeliveryPointBuilder {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}
}
