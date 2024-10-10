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
import fpml.confirmation.GasDeliveryPoint;
import fpml.confirmation.GasDeliveryPoint.GasDeliveryPointBuilder;
import fpml.confirmation.GasDeliveryPoint.GasDeliveryPointBuilderImpl;
import fpml.confirmation.GasDeliveryPoint.GasDeliveryPointImpl;
import fpml.confirmation.meta.GasDeliveryPointMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the types of the Delivery Point for a physically settled gas trade.
 * @version ${project.version}
 */
@RosettaDataType(value="GasDeliveryPoint", builder=GasDeliveryPoint.GasDeliveryPointBuilderImpl.class, version="${project.version}")
public interface GasDeliveryPoint extends RosettaModelObject {

	GasDeliveryPointMeta metaData = new GasDeliveryPointMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeliveryPointScheme();

	/*********************** Build Methods  ***********************/
	GasDeliveryPoint build();
	
	GasDeliveryPoint.GasDeliveryPointBuilder toBuilder();
	
	static GasDeliveryPoint.GasDeliveryPointBuilder builder() {
		return new GasDeliveryPoint.GasDeliveryPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDeliveryPoint> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasDeliveryPoint> getType() {
		return GasDeliveryPoint.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliveryPointBuilder extends GasDeliveryPoint, RosettaModelObjectBuilder {
		GasDeliveryPoint.GasDeliveryPointBuilder setValue(String value);
		GasDeliveryPoint.GasDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
		}
		

		GasDeliveryPoint.GasDeliveryPointBuilder prune();
	}

	/*********************** Immutable Implementation of GasDeliveryPoint  ***********************/
	class GasDeliveryPointImpl implements GasDeliveryPoint {
		private final String value;
		private final String deliveryPointScheme;
		
		protected GasDeliveryPointImpl(GasDeliveryPoint.GasDeliveryPointBuilder builder) {
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
		public GasDeliveryPoint build() {
			return this;
		}
		
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder toBuilder() {
			GasDeliveryPoint.GasDeliveryPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDeliveryPoint.GasDeliveryPointBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryPointScheme()).ifPresent(builder::setDeliveryPointScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliveryPoint _that = getType().cast(o);
		
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
			return "GasDeliveryPoint {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GasDeliveryPoint  ***********************/
	class GasDeliveryPointBuilderImpl implements GasDeliveryPoint.GasDeliveryPointBuilder {
	
		protected String value;
		protected String deliveryPointScheme;
	
		public GasDeliveryPointBuilderImpl() {
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
		public GasDeliveryPoint.GasDeliveryPointBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPointScheme")
		public GasDeliveryPoint.GasDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme) {
			this.deliveryPointScheme = deliveryPointScheme==null?null:deliveryPointScheme;
			return this;
		}
		
		@Override
		public GasDeliveryPoint build() {
			return new GasDeliveryPoint.GasDeliveryPointImpl(this);
		}
		
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder prune() {
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
		public GasDeliveryPoint.GasDeliveryPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasDeliveryPoint.GasDeliveryPointBuilder o = (GasDeliveryPoint.GasDeliveryPointBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryPointScheme(), o.getDeliveryPointScheme(), this::setDeliveryPointScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliveryPoint _that = getType().cast(o);
		
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
			return "GasDeliveryPointBuilder {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}
}
