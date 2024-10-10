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
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.Metal;
import fpml.confirmation.MetalDelivery;
import fpml.confirmation.MetalPhysicalLeg;
import fpml.confirmation.MetalPhysicalLeg.MetalPhysicalLegBuilder;
import fpml.confirmation.MetalPhysicalLeg.MetalPhysicalLegBuilderImpl;
import fpml.confirmation.MetalPhysicalLeg.MetalPhysicalLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalForwardLeg;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegBuilder;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegBuilderImpl;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegImpl;
import fpml.confirmation.meta.MetalPhysicalLegMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Physically settled metal products leg. Physically settled leg of a physically settled Metal transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="MetalPhysicalLeg", builder=MetalPhysicalLeg.MetalPhysicalLegBuilderImpl.class, version="${project.version}")
public interface MetalPhysicalLeg extends PhysicalForwardLeg {

	MetalPhysicalLegMeta metaData = new MetalPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The specification of the Metal Product to be delivered.
	 */
	Metal getMetal();
	/**
	 * The period during which delivery/deliveries of Metal may be scheduled.
	 */
	CommodityDeliveryPeriods getDeliveryPeriods();
	/**
	 * The physical delivery arrangements and requirements for a physically settled non-precious metal transaction.
	 */
	MetalDelivery getDeliveryConditions();
	CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel();
	/**
	 * If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 */
	BigDecimal getConversionFactor();

	/*********************** Build Methods  ***********************/
	MetalPhysicalLeg build();
	
	MetalPhysicalLeg.MetalPhysicalLegBuilder toBuilder();
	
	static MetalPhysicalLeg.MetalPhysicalLegBuilder builder() {
		return new MetalPhysicalLeg.MetalPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MetalPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MetalPhysicalLeg> getType() {
		return MetalPhysicalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("metal"), processor, Metal.class, getMetal());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("deliveryConditions"), processor, MetalDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.class, getCommodityFixedPhysicalQuantityModel());
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MetalPhysicalLegBuilder extends MetalPhysicalLeg, PhysicalForwardLeg.PhysicalForwardLegBuilder {
		Metal.MetalBuilder getOrCreateMetal();
		Metal.MetalBuilder getMetal();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		MetalDelivery.MetalDeliveryBuilder getOrCreateDeliveryConditions();
		MetalDelivery.MetalDeliveryBuilder getDeliveryConditions();
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getOrCreateCommodityFixedPhysicalQuantityModel();
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getCommodityFixedPhysicalQuantityModel();
		MetalPhysicalLeg.MetalPhysicalLegBuilder setId(String id);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setMetal(Metal metal);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryConditions(MetalDelivery deliveryConditions);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setConversionFactor(BigDecimal conversionFactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("metal"), processor, Metal.MetalBuilder.class, getMetal());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("deliveryConditions"), processor, MetalDelivery.MetalDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder.class, getCommodityFixedPhysicalQuantityModel());
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		}
		

		MetalPhysicalLeg.MetalPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of MetalPhysicalLeg  ***********************/
	class MetalPhysicalLegImpl extends PhysicalForwardLeg.PhysicalForwardLegImpl implements MetalPhysicalLeg {
		private final Metal metal;
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final MetalDelivery deliveryConditions;
		private final CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel;
		private final BigDecimal conversionFactor;
		
		protected MetalPhysicalLegImpl(MetalPhysicalLeg.MetalPhysicalLegBuilder builder) {
			super(builder);
			this.metal = ofNullable(builder.getMetal()).map(f->f.build()).orElse(null);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.commodityFixedPhysicalQuantityModel = ofNullable(builder.getCommodityFixedPhysicalQuantityModel()).map(f->f.build()).orElse(null);
			this.conversionFactor = builder.getConversionFactor();
		}
		
		@Override
		@RosettaAttribute("metal")
		public Metal getMetal() {
			return metal;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public MetalDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel() {
			return commodityFixedPhysicalQuantityModel;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		public MetalPhysicalLeg build() {
			return this;
		}
		
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder toBuilder() {
			MetalPhysicalLeg.MetalPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetalPhysicalLeg.MetalPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMetal()).ifPresent(builder::setMetal);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getCommodityFixedPhysicalQuantityModel()).ifPresent(builder::setCommodityFixedPhysicalQuantityModel);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MetalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(metal, _that.getMetal())) return false;
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (metal != null ? metal.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalPhysicalLeg {" +
				"metal=" + this.metal + ", " +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel + ", " +
				"conversionFactor=" + this.conversionFactor +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MetalPhysicalLeg  ***********************/
	class MetalPhysicalLegBuilderImpl extends PhysicalForwardLeg.PhysicalForwardLegBuilderImpl  implements MetalPhysicalLeg.MetalPhysicalLegBuilder {
	
		protected Metal.MetalBuilder metal;
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected MetalDelivery.MetalDeliveryBuilder deliveryConditions;
		protected CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder commodityFixedPhysicalQuantityModel;
		protected BigDecimal conversionFactor;
	
		public MetalPhysicalLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("metal")
		public Metal.MetalBuilder getMetal() {
			return metal;
		}
		
		@Override
		public Metal.MetalBuilder getOrCreateMetal() {
			Metal.MetalBuilder result;
			if (metal!=null) {
				result = metal;
			}
			else {
				result = metal = Metal.builder();
			}
			
			return result;
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
		@RosettaAttribute("deliveryConditions")
		public MetalDelivery.MetalDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public MetalDelivery.MetalDeliveryBuilder getOrCreateDeliveryConditions() {
			MetalDelivery.MetalDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = MetalDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getCommodityFixedPhysicalQuantityModel() {
			return commodityFixedPhysicalQuantityModel;
		}
		
		@Override
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getOrCreateCommodityFixedPhysicalQuantityModel() {
			CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder result;
			if (commodityFixedPhysicalQuantityModel!=null) {
				result = commodityFixedPhysicalQuantityModel;
			}
			else {
				result = commodityFixedPhysicalQuantityModel = CommodityFixedPhysicalQuantityModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("id")
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("metal")
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setMetal(Metal metal) {
			this.metal = metal==null?null:metal.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPeriods")
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods) {
			this.deliveryPeriods = deliveryPeriods==null?null:deliveryPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryConditions")
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryConditions(MetalDelivery deliveryConditions) {
			this.deliveryConditions = deliveryConditions==null?null:deliveryConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel) {
			this.commodityFixedPhysicalQuantityModel = commodityFixedPhysicalQuantityModel==null?null:commodityFixedPhysicalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("conversionFactor")
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setConversionFactor(BigDecimal conversionFactor) {
			this.conversionFactor = conversionFactor==null?null:conversionFactor;
			return this;
		}
		
		@Override
		public MetalPhysicalLeg build() {
			return new MetalPhysicalLeg.MetalPhysicalLegImpl(this);
		}
		
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder prune() {
			super.prune();
			if (metal!=null && !metal.prune().hasData()) metal = null;
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (commodityFixedPhysicalQuantityModel!=null && !commodityFixedPhysicalQuantityModel.prune().hasData()) commodityFixedPhysicalQuantityModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMetal()!=null && getMetal().hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getCommodityFixedPhysicalQuantityModel()!=null && getCommodityFixedPhysicalQuantityModel().hasData()) return true;
			if (getConversionFactor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MetalPhysicalLeg.MetalPhysicalLegBuilder o = (MetalPhysicalLeg.MetalPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getMetal(), o.getMetal(), this::setMetal);
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getCommodityFixedPhysicalQuantityModel(), o.getCommodityFixedPhysicalQuantityModel(), this::setCommodityFixedPhysicalQuantityModel);
			
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MetalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(metal, _that.getMetal())) return false;
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (metal != null ? metal.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalPhysicalLegBuilder {" +
				"metal=" + this.metal + ", " +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel + ", " +
				"conversionFactor=" + this.conversionFactor +
			'}' + " " + super.toString();
		}
	}
}
