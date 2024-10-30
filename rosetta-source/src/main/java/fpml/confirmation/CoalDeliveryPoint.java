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
import fpml.confirmation.CoalDeliveryPoint;
import fpml.confirmation.CoalDeliveryPoint.CoalDeliveryPointBuilder;
import fpml.confirmation.CoalDeliveryPoint.CoalDeliveryPointBuilderImpl;
import fpml.confirmation.CoalDeliveryPoint.CoalDeliveryPointImpl;
import fpml.confirmation.meta.CoalDeliveryPointMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the types of the Delivery Point for a physically settled coal trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CoalDeliveryPoint", builder=CoalDeliveryPoint.CoalDeliveryPointBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CoalDeliveryPoint extends RosettaModelObject {

	CoalDeliveryPointMeta metaData = new CoalDeliveryPointMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeliveryPointScheme();

	/*********************** Build Methods  ***********************/
	CoalDeliveryPoint build();
	
	CoalDeliveryPoint.CoalDeliveryPointBuilder toBuilder();
	
	static CoalDeliveryPoint.CoalDeliveryPointBuilder builder() {
		return new CoalDeliveryPoint.CoalDeliveryPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalDeliveryPoint> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalDeliveryPoint> getType() {
		return CoalDeliveryPoint.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalDeliveryPointBuilder extends CoalDeliveryPoint, RosettaModelObjectBuilder {
		CoalDeliveryPoint.CoalDeliveryPointBuilder setValue(String value);
		CoalDeliveryPoint.CoalDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
		}
		

		CoalDeliveryPoint.CoalDeliveryPointBuilder prune();
	}

	/*********************** Immutable Implementation of CoalDeliveryPoint  ***********************/
	class CoalDeliveryPointImpl implements CoalDeliveryPoint {
		private final String value;
		private final String deliveryPointScheme;
		
		protected CoalDeliveryPointImpl(CoalDeliveryPoint.CoalDeliveryPointBuilder builder) {
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
		public CoalDeliveryPoint build() {
			return this;
		}
		
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder toBuilder() {
			CoalDeliveryPoint.CoalDeliveryPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalDeliveryPoint.CoalDeliveryPointBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryPointScheme()).ifPresent(builder::setDeliveryPointScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDeliveryPoint _that = getType().cast(o);
		
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
			return "CoalDeliveryPoint {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalDeliveryPoint  ***********************/
	class CoalDeliveryPointBuilderImpl implements CoalDeliveryPoint.CoalDeliveryPointBuilder {
	
		protected String value;
		protected String deliveryPointScheme;
	
		public CoalDeliveryPointBuilderImpl() {
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
		public CoalDeliveryPoint.CoalDeliveryPointBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPointScheme")
		public CoalDeliveryPoint.CoalDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme) {
			this.deliveryPointScheme = deliveryPointScheme==null?null:deliveryPointScheme;
			return this;
		}
		
		@Override
		public CoalDeliveryPoint build() {
			return new CoalDeliveryPoint.CoalDeliveryPointImpl(this);
		}
		
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder prune() {
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
		public CoalDeliveryPoint.CoalDeliveryPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalDeliveryPoint.CoalDeliveryPointBuilder o = (CoalDeliveryPoint.CoalDeliveryPointBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryPointScheme(), o.getDeliveryPointScheme(), this::setDeliveryPointScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDeliveryPoint _that = getType().cast(o);
		
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
			return "CoalDeliveryPointBuilder {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}
}
