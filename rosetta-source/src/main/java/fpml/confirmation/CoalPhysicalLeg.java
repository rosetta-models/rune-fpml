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
import fpml.confirmation.CoalDelivery;
import fpml.confirmation.CoalPhysicalLeg;
import fpml.confirmation.CoalPhysicalLeg.CoalPhysicalLegBuilder;
import fpml.confirmation.CoalPhysicalLeg.CoalPhysicalLegBuilderImpl;
import fpml.confirmation.CoalPhysicalLeg.CoalPhysicalLegImpl;
import fpml.confirmation.CoalProduct;
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.CommodityPhysicalQuantity;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalSwapLeg;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilder;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilderImpl;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegImpl;
import fpml.confirmation.meta.CoalPhysicalLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Physically settled coal leg. Physically settled leg of a physically settled coal transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="CoalPhysicalLeg", builder=CoalPhysicalLeg.CoalPhysicalLegBuilderImpl.class, version="${project.version}")
public interface CoalPhysicalLeg extends PhysicalSwapLeg {

	CoalPhysicalLegMeta metaData = new CoalPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The period during which delivery/deliveries of Coal Products may be scheduled. Equivalent to Nomination Period(s) for US Coal.
	 */
	CommodityDeliveryPeriods getDeliveryPeriods();
	/**
	 * The specification of the Coal Product to be delivered.
	 */
	CoalProduct getCoal();
	/**
	 * The physical delivery conditions for the transaction.
	 */
	CoalDelivery getDeliveryConditions();
	/**
	 * The different options for specifying the quantity.
	 */
	CommodityPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	CoalPhysicalLeg build();
	
	CoalPhysicalLeg.CoalPhysicalLegBuilder toBuilder();
	
	static CoalPhysicalLeg.CoalPhysicalLegBuilder builder() {
		return new CoalPhysicalLeg.CoalPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalPhysicalLeg> getType() {
		return CoalPhysicalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("coal"), processor, CoalProduct.class, getCoal());
		processRosetta(path.newSubPath("deliveryConditions"), processor, CoalDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalPhysicalLegBuilder extends CoalPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		CoalProduct.CoalProductBuilder getOrCreateCoal();
		CoalProduct.CoalProductBuilder getCoal();
		CoalDelivery.CoalDeliveryBuilder getOrCreateDeliveryConditions();
		CoalDelivery.CoalDeliveryBuilder getDeliveryConditions();
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getDeliveryQuantity();
		CoalPhysicalLeg.CoalPhysicalLegBuilder setId(String id);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setCoal(CoalProduct coal);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryConditions(CoalDelivery deliveryConditions);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("coal"), processor, CoalProduct.CoalProductBuilder.class, getCoal());
			processRosetta(path.newSubPath("deliveryConditions"), processor, CoalDelivery.CoalDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		CoalPhysicalLeg.CoalPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of CoalPhysicalLeg  ***********************/
	class CoalPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements CoalPhysicalLeg {
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final CoalProduct coal;
		private final CoalDelivery deliveryConditions;
		private final CommodityPhysicalQuantity deliveryQuantity;
		
		protected CoalPhysicalLegImpl(CoalPhysicalLeg.CoalPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.coal = ofNullable(builder.getCoal()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.deliveryQuantity = ofNullable(builder.getDeliveryQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("coal")
		public CoalProduct getCoal() {
			return coal;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public CoalDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		public CommodityPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public CoalPhysicalLeg build() {
			return this;
		}
		
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder toBuilder() {
			CoalPhysicalLeg.CoalPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalPhysicalLeg.CoalPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getCoal()).ifPresent(builder::setCoal);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CoalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"coal=" + this.coal + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CoalPhysicalLeg  ***********************/
	class CoalPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl  implements CoalPhysicalLeg.CoalPhysicalLegBuilder {
	
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected CoalProduct.CoalProductBuilder coal;
		protected CoalDelivery.CoalDeliveryBuilder deliveryConditions;
		protected CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder deliveryQuantity;
	
		public CoalPhysicalLegBuilderImpl() {
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
		@RosettaAttribute("coal")
		public CoalProduct.CoalProductBuilder getCoal() {
			return coal;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder getOrCreateCoal() {
			CoalProduct.CoalProductBuilder result;
			if (coal!=null) {
				result = coal;
			}
			else {
				result = coal = CoalProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public CoalDelivery.CoalDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public CoalDelivery.CoalDeliveryBuilder getOrCreateDeliveryConditions() {
			CoalDelivery.CoalDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = CoalDelivery.builder();
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
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPeriods")
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods) {
			this.deliveryPeriods = deliveryPeriods==null?null:deliveryPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("coal")
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setCoal(CoalProduct coal) {
			this.coal = coal==null?null:coal.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryConditions")
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryConditions(CoalDelivery deliveryConditions) {
			this.deliveryConditions = deliveryConditions==null?null:deliveryConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryQuantity")
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity deliveryQuantity) {
			this.deliveryQuantity = deliveryQuantity==null?null:deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public CoalPhysicalLeg build() {
			return new CoalPhysicalLeg.CoalPhysicalLegImpl(this);
		}
		
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (coal!=null && !coal.prune().hasData()) coal = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getCoal()!=null && getCoal().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CoalPhysicalLeg.CoalPhysicalLegBuilder o = (CoalPhysicalLeg.CoalPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getCoal(), o.getCoal(), this::setCoal);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CoalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"coal=" + this.coal + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
