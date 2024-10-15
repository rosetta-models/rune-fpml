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
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.CommodityPhysicalQuantity;
import fpml.confirmation.OilDelivery;
import fpml.confirmation.OilPhysicalLeg;
import fpml.confirmation.OilPhysicalLeg.OilPhysicalLegBuilder;
import fpml.confirmation.OilPhysicalLeg.OilPhysicalLegBuilderImpl;
import fpml.confirmation.OilPhysicalLeg.OilPhysicalLegImpl;
import fpml.confirmation.OilProduct;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalSwapLeg;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilder;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilderImpl;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegImpl;
import fpml.confirmation.meta.OilPhysicalLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Physically settled oil or refined products leg. Physically settled leg of a physically settled oil product transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="OilPhysicalLeg", builder=OilPhysicalLeg.OilPhysicalLegBuilderImpl.class, version="${project.version}")
public interface OilPhysicalLeg extends PhysicalSwapLeg {

	OilPhysicalLegMeta metaData = new OilPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The different options for specifying the Delivery or Supply Periods. Unless the quantity or price is to vary periodically during the trade or physical delivery occurs on a periodic basis, periodsSchedule should be used and set to 1T.
	 */
	CommodityDeliveryPeriods getDeliveryPeriods();
	/**
	 * The specification of the oil product to be delivered.
	 */
	OilProduct getOil();
	/**
	 * The physical delivery conditions for the transaction.
	 */
	OilDelivery getDeliveryConditions();
	/**
	 * The different options for specifying the quantity.
	 */
	CommodityPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	OilPhysicalLeg build();
	
	OilPhysicalLeg.OilPhysicalLegBuilder toBuilder();
	
	static OilPhysicalLeg.OilPhysicalLegBuilder builder() {
		return new OilPhysicalLeg.OilPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OilPhysicalLeg> getType() {
		return OilPhysicalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("oil"), processor, OilProduct.class, getOil());
		processRosetta(path.newSubPath("deliveryConditions"), processor, OilDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilPhysicalLegBuilder extends OilPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		OilProduct.OilProductBuilder getOrCreateOil();
		OilProduct.OilProductBuilder getOil();
		OilDelivery.OilDeliveryBuilder getOrCreateDeliveryConditions();
		OilDelivery.OilDeliveryBuilder getDeliveryConditions();
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getDeliveryQuantity();
		OilPhysicalLeg.OilPhysicalLegBuilder setId(String id);
		OilPhysicalLeg.OilPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		OilPhysicalLeg.OilPhysicalLegBuilder setOil(OilProduct oil);
		OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryConditions(OilDelivery deliveryConditions);
		OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("oil"), processor, OilProduct.OilProductBuilder.class, getOil());
			processRosetta(path.newSubPath("deliveryConditions"), processor, OilDelivery.OilDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		OilPhysicalLeg.OilPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of OilPhysicalLeg  ***********************/
	class OilPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements OilPhysicalLeg {
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final OilProduct oil;
		private final OilDelivery deliveryConditions;
		private final CommodityPhysicalQuantity deliveryQuantity;
		
		protected OilPhysicalLegImpl(OilPhysicalLeg.OilPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.oil = ofNullable(builder.getOil()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.deliveryQuantity = ofNullable(builder.getDeliveryQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("oil")
		public OilProduct getOil() {
			return oil;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public OilDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		public CommodityPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public OilPhysicalLeg build() {
			return this;
		}
		
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder toBuilder() {
			OilPhysicalLeg.OilPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilPhysicalLeg.OilPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getOil()).ifPresent(builder::setOil);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OilPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"oil=" + this.oil + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OilPhysicalLeg  ***********************/
	class OilPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl  implements OilPhysicalLeg.OilPhysicalLegBuilder {
	
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected OilProduct.OilProductBuilder oil;
		protected OilDelivery.OilDeliveryBuilder deliveryConditions;
		protected CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder deliveryQuantity;
	
		public OilPhysicalLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods() {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder result;
			if (deliveryPeriods!=null) {
				result = deliveryPeriods;
			}
			else {
				result = deliveryPeriods = CommodityDeliveryPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oil")
		public OilProduct.OilProductBuilder getOil() {
			return oil;
		}
		
		@Override
		public OilProduct.OilProductBuilder getOrCreateOil() {
			OilProduct.OilProductBuilder result;
			if (oil!=null) {
				result = oil;
			}
			else {
				result = oil = OilProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public OilDelivery.OilDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public OilDelivery.OilDeliveryBuilder getOrCreateDeliveryConditions() {
			OilDelivery.OilDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = OilDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getOrCreateDeliveryQuantity() {
			CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder result;
			if (deliveryQuantity!=null) {
				result = deliveryQuantity;
			}
			else {
				result = deliveryQuantity = CommodityPhysicalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public OilPhysicalLeg.OilPhysicalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public OilPhysicalLeg.OilPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPeriods")
		public OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods) {
			this.deliveryPeriods = deliveryPeriods==null?null:deliveryPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("oil")
		public OilPhysicalLeg.OilPhysicalLegBuilder setOil(OilProduct oil) {
			this.oil = oil==null?null:oil.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryConditions")
		public OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryConditions(OilDelivery deliveryConditions) {
			this.deliveryConditions = deliveryConditions==null?null:deliveryConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryQuantity")
		public OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity deliveryQuantity) {
			this.deliveryQuantity = deliveryQuantity==null?null:deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public OilPhysicalLeg build() {
			return new OilPhysicalLeg.OilPhysicalLegImpl(this);
		}
		
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (oil!=null && !oil.prune().hasData()) oil = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getOil()!=null && getOil().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OilPhysicalLeg.OilPhysicalLegBuilder o = (OilPhysicalLeg.OilPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getOil(), o.getOil(), this::setOil);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OilPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"oil=" + this.oil + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
