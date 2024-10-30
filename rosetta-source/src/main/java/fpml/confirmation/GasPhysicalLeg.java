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
import fpml.confirmation.GasDelivery;
import fpml.confirmation.GasDeliveryPeriods;
import fpml.confirmation.GasPhysicalLeg;
import fpml.confirmation.GasPhysicalLeg.GasPhysicalLegBuilder;
import fpml.confirmation.GasPhysicalLeg.GasPhysicalLegBuilderImpl;
import fpml.confirmation.GasPhysicalLeg.GasPhysicalLegImpl;
import fpml.confirmation.GasPhysicalQuantity;
import fpml.confirmation.GasProduct;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalSwapLeg;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilder;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilderImpl;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegImpl;
import fpml.confirmation.meta.GasPhysicalLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Physically settled natural gas leg. Physically settled leg of a physically settled gas transaction.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GasPhysicalLeg", builder=GasPhysicalLeg.GasPhysicalLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GasPhysicalLeg extends PhysicalSwapLeg {

	GasPhysicalLegMeta metaData = new GasPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The different options for specifying the Delivery or Supply Periods. Unless the quantity or price is to vary periodically during the trade or physical delivery occurs on a periodic basis, periodsSchedule should be used and set to 1T.
	 */
	GasDeliveryPeriods getDeliveryPeriods();
	/**
	 * The specification of the gas to be delivered.
	 */
	GasProduct getGas();
	/**
	 * The physical delivery conditions for the transaction.
	 */
	GasDelivery getDeliveryConditions();
	/**
	 * The different options for specifying the quantity. For Fixed trades where the quantity is known at the time of confirmation, a single quantity or a quantity per Delivery Period may be specified. For Variable trades minimum and maximum trades may be specified.
	 */
	GasPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	GasPhysicalLeg build();
	
	GasPhysicalLeg.GasPhysicalLegBuilder toBuilder();
	
	static GasPhysicalLeg.GasPhysicalLegBuilder builder() {
		return new GasPhysicalLeg.GasPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasPhysicalLeg> getType() {
		return GasPhysicalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, GasDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("gas"), processor, GasProduct.class, getGas());
		processRosetta(path.newSubPath("deliveryConditions"), processor, GasDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, GasPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasPhysicalLegBuilder extends GasPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder getDeliveryPeriods();
		GasProduct.GasProductBuilder getOrCreateGas();
		GasProduct.GasProductBuilder getGas();
		GasDelivery.GasDeliveryBuilder getOrCreateDeliveryConditions();
		GasDelivery.GasDeliveryBuilder getDeliveryConditions();
		GasPhysicalQuantity.GasPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		GasPhysicalQuantity.GasPhysicalQuantityBuilder getDeliveryQuantity();
		GasPhysicalLeg.GasPhysicalLegBuilder setId(String id);
		GasPhysicalLeg.GasPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryPeriods(GasDeliveryPeriods deliveryPeriods);
		GasPhysicalLeg.GasPhysicalLegBuilder setGas(GasProduct gas);
		GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryConditions(GasDelivery deliveryConditions);
		GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryQuantity(GasPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, GasDeliveryPeriods.GasDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("gas"), processor, GasProduct.GasProductBuilder.class, getGas());
			processRosetta(path.newSubPath("deliveryConditions"), processor, GasDelivery.GasDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, GasPhysicalQuantity.GasPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		GasPhysicalLeg.GasPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of GasPhysicalLeg  ***********************/
	class GasPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements GasPhysicalLeg {
		private final GasDeliveryPeriods deliveryPeriods;
		private final GasProduct gas;
		private final GasDelivery deliveryConditions;
		private final GasPhysicalQuantity deliveryQuantity;
		
		protected GasPhysicalLegImpl(GasPhysicalLeg.GasPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.gas = ofNullable(builder.getGas()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.deliveryQuantity = ofNullable(builder.getDeliveryQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		public GasDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("gas")
		public GasProduct getGas() {
			return gas;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public GasDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		public GasPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public GasPhysicalLeg build() {
			return this;
		}
		
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder toBuilder() {
			GasPhysicalLeg.GasPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasPhysicalLeg.GasPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getGas()).ifPresent(builder::setGas);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(gas, _that.getGas())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (gas != null ? gas.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"gas=" + this.gas + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GasPhysicalLeg  ***********************/
	class GasPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl  implements GasPhysicalLeg.GasPhysicalLegBuilder {
	
		protected GasDeliveryPeriods.GasDeliveryPeriodsBuilder deliveryPeriods;
		protected GasProduct.GasProductBuilder gas;
		protected GasDelivery.GasDeliveryBuilder deliveryConditions;
		protected GasPhysicalQuantity.GasPhysicalQuantityBuilder deliveryQuantity;
	
		public GasPhysicalLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryPeriods")
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder getOrCreateDeliveryPeriods() {
			GasDeliveryPeriods.GasDeliveryPeriodsBuilder result;
			if (deliveryPeriods!=null) {
				result = deliveryPeriods;
			}
			else {
				result = deliveryPeriods = GasDeliveryPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("gas")
		public GasProduct.GasProductBuilder getGas() {
			return gas;
		}
		
		@Override
		public GasProduct.GasProductBuilder getOrCreateGas() {
			GasProduct.GasProductBuilder result;
			if (gas!=null) {
				result = gas;
			}
			else {
				result = gas = GasProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public GasDelivery.GasDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public GasDelivery.GasDeliveryBuilder getOrCreateDeliveryConditions() {
			GasDelivery.GasDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = GasDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder getOrCreateDeliveryQuantity() {
			GasPhysicalQuantity.GasPhysicalQuantityBuilder result;
			if (deliveryQuantity!=null) {
				result = deliveryQuantity;
			}
			else {
				result = deliveryQuantity = GasPhysicalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public GasPhysicalLeg.GasPhysicalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public GasPhysicalLeg.GasPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPeriods")
		public GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryPeriods(GasDeliveryPeriods deliveryPeriods) {
			this.deliveryPeriods = deliveryPeriods==null?null:deliveryPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("gas")
		public GasPhysicalLeg.GasPhysicalLegBuilder setGas(GasProduct gas) {
			this.gas = gas==null?null:gas.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryConditions")
		public GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryConditions(GasDelivery deliveryConditions) {
			this.deliveryConditions = deliveryConditions==null?null:deliveryConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryQuantity")
		public GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryQuantity(GasPhysicalQuantity deliveryQuantity) {
			this.deliveryQuantity = deliveryQuantity==null?null:deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public GasPhysicalLeg build() {
			return new GasPhysicalLeg.GasPhysicalLegImpl(this);
		}
		
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (gas!=null && !gas.prune().hasData()) gas = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getGas()!=null && getGas().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			GasPhysicalLeg.GasPhysicalLegBuilder o = (GasPhysicalLeg.GasPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getGas(), o.getGas(), this::setGas);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(gas, _that.getGas())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (gas != null ? gas.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"gas=" + this.gas + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
