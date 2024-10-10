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
import fpml.confirmation.CommodityProductModelSequenceChoice;
import fpml.confirmation.CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder;
import fpml.confirmation.CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilderImpl;
import fpml.confirmation.CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceImpl;
import fpml.confirmation.DeliveryDatesEnum;
import fpml.confirmation.DeliveryNearby;
import fpml.confirmation.meta.CommodityProductModelSequenceChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityProductModelSequenceChoice", builder=CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilderImpl.class, version="${project.version}")
public interface CommodityProductModelSequenceChoice extends RosettaModelObject {

	CommodityProductModelSequenceChoiceMeta metaData = new CommodityProductModelSequenceChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Deprecated: The &#39;deliveryDates&#39; element is applicable for a Commodity Reference Price that references a listed future contract (e.g. The Delivery Date is a NearbyMonth).
	 */
	DeliveryDatesEnum getDeliveryDates();
	/**
	 * A container for the parametric representation of nearby contracts.
	 */
	DeliveryNearby getDeliveryNearby();

	/*********************** Build Methods  ***********************/
	CommodityProductModelSequenceChoice build();
	
	CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder toBuilder();
	
	static CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder builder() {
		return new CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityProductModelSequenceChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityProductModelSequenceChoice> getType() {
		return CommodityProductModelSequenceChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryDates"), DeliveryDatesEnum.class, getDeliveryDates(), this);
		processRosetta(path.newSubPath("deliveryNearby"), processor, DeliveryNearby.class, getDeliveryNearby());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityProductModelSequenceChoiceBuilder extends CommodityProductModelSequenceChoice, RosettaModelObjectBuilder {
		DeliveryNearby.DeliveryNearbyBuilder getOrCreateDeliveryNearby();
		DeliveryNearby.DeliveryNearbyBuilder getDeliveryNearby();
		CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder setDeliveryDates(DeliveryDatesEnum deliveryDates);
		CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder setDeliveryNearby(DeliveryNearby deliveryNearby);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("deliveryDates"), DeliveryDatesEnum.class, getDeliveryDates(), this);
			processRosetta(path.newSubPath("deliveryNearby"), processor, DeliveryNearby.DeliveryNearbyBuilder.class, getDeliveryNearby());
		}
		

		CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityProductModelSequenceChoice  ***********************/
	class CommodityProductModelSequenceChoiceImpl implements CommodityProductModelSequenceChoice {
		private final DeliveryDatesEnum deliveryDates;
		private final DeliveryNearby deliveryNearby;
		
		protected CommodityProductModelSequenceChoiceImpl(CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder builder) {
			this.deliveryDates = builder.getDeliveryDates();
			this.deliveryNearby = ofNullable(builder.getDeliveryNearby()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryDates")
		public DeliveryDatesEnum getDeliveryDates() {
			return deliveryDates;
		}
		
		@Override
		@RosettaAttribute("deliveryNearby")
		public DeliveryNearby getDeliveryNearby() {
			return deliveryNearby;
		}
		
		@Override
		public CommodityProductModelSequenceChoice build() {
			return this;
		}
		
		@Override
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder toBuilder() {
			CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder builder) {
			ofNullable(getDeliveryDates()).ifPresent(builder::setDeliveryDates);
			ofNullable(getDeliveryNearby()).ifPresent(builder::setDeliveryNearby);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductModelSequenceChoice _that = getType().cast(o);
		
			if (!Objects.equals(deliveryDates, _that.getDeliveryDates())) return false;
			if (!Objects.equals(deliveryNearby, _that.getDeliveryNearby())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryDates != null ? deliveryDates.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryNearby != null ? deliveryNearby.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductModelSequenceChoice {" +
				"deliveryDates=" + this.deliveryDates + ", " +
				"deliveryNearby=" + this.deliveryNearby +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityProductModelSequenceChoice  ***********************/
	class CommodityProductModelSequenceChoiceBuilderImpl implements CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder {
	
		protected DeliveryDatesEnum deliveryDates;
		protected DeliveryNearby.DeliveryNearbyBuilder deliveryNearby;
	
		public CommodityProductModelSequenceChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryDates")
		public DeliveryDatesEnum getDeliveryDates() {
			return deliveryDates;
		}
		
		@Override
		@RosettaAttribute("deliveryNearby")
		public DeliveryNearby.DeliveryNearbyBuilder getDeliveryNearby() {
			return deliveryNearby;
		}
		
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder getOrCreateDeliveryNearby() {
			DeliveryNearby.DeliveryNearbyBuilder result;
			if (deliveryNearby!=null) {
				result = deliveryNearby;
			}
			else {
				result = deliveryNearby = DeliveryNearby.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDates")
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder setDeliveryDates(DeliveryDatesEnum deliveryDates) {
			this.deliveryDates = deliveryDates==null?null:deliveryDates;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryNearby")
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder setDeliveryNearby(DeliveryNearby deliveryNearby) {
			this.deliveryNearby = deliveryNearby==null?null:deliveryNearby.toBuilder();
			return this;
		}
		
		@Override
		public CommodityProductModelSequenceChoice build() {
			return new CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceImpl(this);
		}
		
		@Override
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder prune() {
			if (deliveryNearby!=null && !deliveryNearby.prune().hasData()) deliveryNearby = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryDates()!=null) return true;
			if (getDeliveryNearby()!=null && getDeliveryNearby().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder o = (CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder) other;
			
			merger.mergeRosetta(getDeliveryNearby(), o.getDeliveryNearby(), this::setDeliveryNearby);
			
			merger.mergeBasic(getDeliveryDates(), o.getDeliveryDates(), this::setDeliveryDates);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductModelSequenceChoice _that = getType().cast(o);
		
			if (!Objects.equals(deliveryDates, _that.getDeliveryDates())) return false;
			if (!Objects.equals(deliveryNearby, _that.getDeliveryNearby())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryDates != null ? deliveryDates.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryNearby != null ? deliveryNearby.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductModelSequenceChoiceBuilder {" +
				"deliveryDates=" + this.deliveryDates + ", " +
				"deliveryNearby=" + this.deliveryNearby +
			'}';
		}
	}
}
