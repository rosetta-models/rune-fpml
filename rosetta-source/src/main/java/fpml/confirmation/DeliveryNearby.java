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
import fpml.confirmation.DeliveryNearby;
import fpml.confirmation.DeliveryNearby.DeliveryNearbyBuilder;
import fpml.confirmation.DeliveryNearby.DeliveryNearbyBuilderImpl;
import fpml.confirmation.DeliveryNearby.DeliveryNearbyImpl;
import fpml.confirmation.DeliveryNearbyTypeEnum;
import fpml.confirmation.meta.DeliveryNearbyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defines nearest Delivery Date of the underlying Commodity of expiration of the futures contract.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DeliveryNearby", builder=DeliveryNearby.DeliveryNearbyBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DeliveryNearby extends RosettaModelObject {

	DeliveryNearbyMeta metaData = new DeliveryNearbyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A time multiplier, e.g. 1, 2 or 3 etc. used in defining Delivery Nearby date.
	 */
	Integer getDeliveryNearbyMultiplier();
	/**
	 * Defines a type of the delivery nearby qualifier, expect to be used in conjunction with a delivery nearby multiplier, e.g. 1NearByMonth, 1NearbyWeek, etc. If &#39;CalculationPeriod&#39; is used, the delivery nearby multiplier is expected to be &#39;0&#39;. To represent &#39;Spot&#39;, the value of the delivery nearby type should be &#39;NearbyMonth&#39; and the delivery period multiplier should be set to &#39;0&#39; (zero).
	 */
	DeliveryNearbyTypeEnum getDeliveryNearbyType();
	String getId();

	/*********************** Build Methods  ***********************/
	DeliveryNearby build();
	
	DeliveryNearby.DeliveryNearbyBuilder toBuilder();
	
	static DeliveryNearby.DeliveryNearbyBuilder builder() {
		return new DeliveryNearby.DeliveryNearbyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeliveryNearby> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DeliveryNearby> getType() {
		return DeliveryNearby.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryNearbyMultiplier"), Integer.class, getDeliveryNearbyMultiplier(), this);
		processor.processBasic(path.newSubPath("deliveryNearbyType"), DeliveryNearbyTypeEnum.class, getDeliveryNearbyType(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeliveryNearbyBuilder extends DeliveryNearby, RosettaModelObjectBuilder {
		DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyMultiplier(Integer deliveryNearbyMultiplier);
		DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyType(DeliveryNearbyTypeEnum deliveryNearbyType);
		DeliveryNearby.DeliveryNearbyBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("deliveryNearbyMultiplier"), Integer.class, getDeliveryNearbyMultiplier(), this);
			processor.processBasic(path.newSubPath("deliveryNearbyType"), DeliveryNearbyTypeEnum.class, getDeliveryNearbyType(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		DeliveryNearby.DeliveryNearbyBuilder prune();
	}

	/*********************** Immutable Implementation of DeliveryNearby  ***********************/
	class DeliveryNearbyImpl implements DeliveryNearby {
		private final Integer deliveryNearbyMultiplier;
		private final DeliveryNearbyTypeEnum deliveryNearbyType;
		private final String id;
		
		protected DeliveryNearbyImpl(DeliveryNearby.DeliveryNearbyBuilder builder) {
			this.deliveryNearbyMultiplier = builder.getDeliveryNearbyMultiplier();
			this.deliveryNearbyType = builder.getDeliveryNearbyType();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyMultiplier")
		public Integer getDeliveryNearbyMultiplier() {
			return deliveryNearbyMultiplier;
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyType")
		public DeliveryNearbyTypeEnum getDeliveryNearbyType() {
			return deliveryNearbyType;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public DeliveryNearby build() {
			return this;
		}
		
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder toBuilder() {
			DeliveryNearby.DeliveryNearbyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeliveryNearby.DeliveryNearbyBuilder builder) {
			ofNullable(getDeliveryNearbyMultiplier()).ifPresent(builder::setDeliveryNearbyMultiplier);
			ofNullable(getDeliveryNearbyType()).ifPresent(builder::setDeliveryNearbyType);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryNearby _that = getType().cast(o);
		
			if (!Objects.equals(deliveryNearbyMultiplier, _that.getDeliveryNearbyMultiplier())) return false;
			if (!Objects.equals(deliveryNearbyType, _that.getDeliveryNearbyType())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryNearbyMultiplier != null ? deliveryNearbyMultiplier.hashCode() : 0);
			_result = 31 * _result + (deliveryNearbyType != null ? deliveryNearbyType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryNearby {" +
				"deliveryNearbyMultiplier=" + this.deliveryNearbyMultiplier + ", " +
				"deliveryNearbyType=" + this.deliveryNearbyType + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of DeliveryNearby  ***********************/
	class DeliveryNearbyBuilderImpl implements DeliveryNearby.DeliveryNearbyBuilder {
	
		protected Integer deliveryNearbyMultiplier;
		protected DeliveryNearbyTypeEnum deliveryNearbyType;
		protected String id;
	
		public DeliveryNearbyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryNearbyMultiplier")
		public Integer getDeliveryNearbyMultiplier() {
			return deliveryNearbyMultiplier;
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyType")
		public DeliveryNearbyTypeEnum getDeliveryNearbyType() {
			return deliveryNearbyType;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyMultiplier")
		public DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyMultiplier(Integer deliveryNearbyMultiplier) {
			this.deliveryNearbyMultiplier = deliveryNearbyMultiplier==null?null:deliveryNearbyMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryNearbyType")
		public DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyType(DeliveryNearbyTypeEnum deliveryNearbyType) {
			this.deliveryNearbyType = deliveryNearbyType==null?null:deliveryNearbyType;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DeliveryNearby.DeliveryNearbyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public DeliveryNearby build() {
			return new DeliveryNearby.DeliveryNearbyImpl(this);
		}
		
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryNearbyMultiplier()!=null) return true;
			if (getDeliveryNearbyType()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeliveryNearby.DeliveryNearbyBuilder o = (DeliveryNearby.DeliveryNearbyBuilder) other;
			
			
			merger.mergeBasic(getDeliveryNearbyMultiplier(), o.getDeliveryNearbyMultiplier(), this::setDeliveryNearbyMultiplier);
			merger.mergeBasic(getDeliveryNearbyType(), o.getDeliveryNearbyType(), this::setDeliveryNearbyType);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryNearby _that = getType().cast(o);
		
			if (!Objects.equals(deliveryNearbyMultiplier, _that.getDeliveryNearbyMultiplier())) return false;
			if (!Objects.equals(deliveryNearbyType, _that.getDeliveryNearbyType())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryNearbyMultiplier != null ? deliveryNearbyMultiplier.hashCode() : 0);
			_result = 31 * _result + (deliveryNearbyType != null ? deliveryNearbyType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryNearbyBuilder {" +
				"deliveryNearbyMultiplier=" + this.deliveryNearbyMultiplier + ", " +
				"deliveryNearbyType=" + this.deliveryNearbyType + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
