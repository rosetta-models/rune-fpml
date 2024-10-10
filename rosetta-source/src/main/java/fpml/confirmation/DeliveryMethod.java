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
import fpml.confirmation.DeliveryMethod;
import fpml.confirmation.DeliveryMethod.DeliveryMethodBuilder;
import fpml.confirmation.DeliveryMethod.DeliveryMethodBuilderImpl;
import fpml.confirmation.DeliveryMethod.DeliveryMethodImpl;
import fpml.confirmation.meta.DeliveryMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies delivery methods for securities transactions. This coding-scheme defines the possible delivery methods for securities.
 * @version ${project.version}
 */
@RosettaDataType(value="DeliveryMethod", builder=DeliveryMethod.DeliveryMethodBuilderImpl.class, version="${project.version}")
public interface DeliveryMethod extends RosettaModelObject {

	DeliveryMethodMeta metaData = new DeliveryMethodMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeliveryMethodScheme();

	/*********************** Build Methods  ***********************/
	DeliveryMethod build();
	
	DeliveryMethod.DeliveryMethodBuilder toBuilder();
	
	static DeliveryMethod.DeliveryMethodBuilder builder() {
		return new DeliveryMethod.DeliveryMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeliveryMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DeliveryMethod> getType() {
		return DeliveryMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryMethodScheme"), String.class, getDeliveryMethodScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeliveryMethodBuilder extends DeliveryMethod, RosettaModelObjectBuilder {
		DeliveryMethod.DeliveryMethodBuilder setValue(String value);
		DeliveryMethod.DeliveryMethodBuilder setDeliveryMethodScheme(String deliveryMethodScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryMethodScheme"), String.class, getDeliveryMethodScheme(), this);
		}
		

		DeliveryMethod.DeliveryMethodBuilder prune();
	}

	/*********************** Immutable Implementation of DeliveryMethod  ***********************/
	class DeliveryMethodImpl implements DeliveryMethod {
		private final String value;
		private final String deliveryMethodScheme;
		
		protected DeliveryMethodImpl(DeliveryMethod.DeliveryMethodBuilder builder) {
			this.value = builder.getValue();
			this.deliveryMethodScheme = builder.getDeliveryMethodScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryMethodScheme")
		public String getDeliveryMethodScheme() {
			return deliveryMethodScheme;
		}
		
		@Override
		public DeliveryMethod build() {
			return this;
		}
		
		@Override
		public DeliveryMethod.DeliveryMethodBuilder toBuilder() {
			DeliveryMethod.DeliveryMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeliveryMethod.DeliveryMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryMethodScheme()).ifPresent(builder::setDeliveryMethodScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryMethodScheme, _that.getDeliveryMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryMethodScheme != null ? deliveryMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryMethod {" +
				"value=" + this.value + ", " +
				"deliveryMethodScheme=" + this.deliveryMethodScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DeliveryMethod  ***********************/
	class DeliveryMethodBuilderImpl implements DeliveryMethod.DeliveryMethodBuilder {
	
		protected String value;
		protected String deliveryMethodScheme;
	
		public DeliveryMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryMethodScheme")
		public String getDeliveryMethodScheme() {
			return deliveryMethodScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public DeliveryMethod.DeliveryMethodBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryMethodScheme")
		public DeliveryMethod.DeliveryMethodBuilder setDeliveryMethodScheme(String deliveryMethodScheme) {
			this.deliveryMethodScheme = deliveryMethodScheme==null?null:deliveryMethodScheme;
			return this;
		}
		
		@Override
		public DeliveryMethod build() {
			return new DeliveryMethod.DeliveryMethodImpl(this);
		}
		
		@Override
		public DeliveryMethod.DeliveryMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryMethod.DeliveryMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeliveryMethodScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryMethod.DeliveryMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeliveryMethod.DeliveryMethodBuilder o = (DeliveryMethod.DeliveryMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryMethodScheme(), o.getDeliveryMethodScheme(), this::setDeliveryMethodScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryMethodScheme, _that.getDeliveryMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryMethodScheme != null ? deliveryMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryMethodBuilder {" +
				"value=" + this.value + ", " +
				"deliveryMethodScheme=" + this.deliveryMethodScheme +
			'}';
		}
	}
}
