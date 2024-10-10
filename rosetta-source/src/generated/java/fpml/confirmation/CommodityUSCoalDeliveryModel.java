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
import fpml.confirmation.CoalTransportationEquipment;
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.CommodityUSCoalDeliveryModel;
import fpml.confirmation.CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder;
import fpml.confirmation.CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilderImpl;
import fpml.confirmation.CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelImpl;
import fpml.confirmation.meta.CommodityUSCoalDeliveryModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items specific to the definition of the delivery of a US Coal Product.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityUSCoalDeliveryModel", builder=CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilderImpl.class, version="${project.version}")
public interface CommodityUSCoalDeliveryModel extends RosettaModelObject {

	CommodityUSCoalDeliveryModelMeta metaData = new CommodityUSCoalDeliveryModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, indicates that QVA is applicable. If false, indicates that QVA is inapplicable.
	 */
	Boolean getQuantityVariationAdjustment();
	/**
	 * The transportation equipment with which the Coal Product will be delivered and received.
	 */
	CoalTransportationEquipment getTransportationEquipment();
	/**
	 * Specifies how the risk associated with the delivery is assigned.
	 */
	CommodityDeliveryRisk getRisk();

	/*********************** Build Methods  ***********************/
	CommodityUSCoalDeliveryModel build();
	
	CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder toBuilder();
	
	static CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder builder() {
		return new CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityUSCoalDeliveryModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityUSCoalDeliveryModel> getType() {
		return CommodityUSCoalDeliveryModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("quantityVariationAdjustment"), Boolean.class, getQuantityVariationAdjustment(), this);
		processRosetta(path.newSubPath("transportationEquipment"), processor, CoalTransportationEquipment.class, getTransportationEquipment());
		processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.class, getRisk());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityUSCoalDeliveryModelBuilder extends CommodityUSCoalDeliveryModel, RosettaModelObjectBuilder {
		CoalTransportationEquipment.CoalTransportationEquipmentBuilder getOrCreateTransportationEquipment();
		CoalTransportationEquipment.CoalTransportationEquipmentBuilder getTransportationEquipment();
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk();
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk();
		CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder setQuantityVariationAdjustment(Boolean quantityVariationAdjustment);
		CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder setTransportationEquipment(CoalTransportationEquipment transportationEquipment);
		CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder setRisk(CommodityDeliveryRisk risk);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("quantityVariationAdjustment"), Boolean.class, getQuantityVariationAdjustment(), this);
			processRosetta(path.newSubPath("transportationEquipment"), processor, CoalTransportationEquipment.CoalTransportationEquipmentBuilder.class, getTransportationEquipment());
			processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.CommodityDeliveryRiskBuilder.class, getRisk());
		}
		

		CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityUSCoalDeliveryModel  ***********************/
	class CommodityUSCoalDeliveryModelImpl implements CommodityUSCoalDeliveryModel {
		private final Boolean quantityVariationAdjustment;
		private final CoalTransportationEquipment transportationEquipment;
		private final CommodityDeliveryRisk risk;
		
		protected CommodityUSCoalDeliveryModelImpl(CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder builder) {
			this.quantityVariationAdjustment = builder.getQuantityVariationAdjustment();
			this.transportationEquipment = ofNullable(builder.getTransportationEquipment()).map(f->f.build()).orElse(null);
			this.risk = ofNullable(builder.getRisk()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quantityVariationAdjustment")
		public Boolean getQuantityVariationAdjustment() {
			return quantityVariationAdjustment;
		}
		
		@Override
		@RosettaAttribute("transportationEquipment")
		public CoalTransportationEquipment getTransportationEquipment() {
			return transportationEquipment;
		}
		
		@Override
		@RosettaAttribute("risk")
		public CommodityDeliveryRisk getRisk() {
			return risk;
		}
		
		@Override
		public CommodityUSCoalDeliveryModel build() {
			return this;
		}
		
		@Override
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder toBuilder() {
			CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder builder) {
			ofNullable(getQuantityVariationAdjustment()).ifPresent(builder::setQuantityVariationAdjustment);
			ofNullable(getTransportationEquipment()).ifPresent(builder::setTransportationEquipment);
			ofNullable(getRisk()).ifPresent(builder::setRisk);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityUSCoalDeliveryModel _that = getType().cast(o);
		
			if (!Objects.equals(quantityVariationAdjustment, _that.getQuantityVariationAdjustment())) return false;
			if (!Objects.equals(transportationEquipment, _that.getTransportationEquipment())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityVariationAdjustment != null ? quantityVariationAdjustment.hashCode() : 0);
			_result = 31 * _result + (transportationEquipment != null ? transportationEquipment.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityUSCoalDeliveryModel {" +
				"quantityVariationAdjustment=" + this.quantityVariationAdjustment + ", " +
				"transportationEquipment=" + this.transportationEquipment + ", " +
				"risk=" + this.risk +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityUSCoalDeliveryModel  ***********************/
	class CommodityUSCoalDeliveryModelBuilderImpl implements CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder {
	
		protected Boolean quantityVariationAdjustment;
		protected CoalTransportationEquipment.CoalTransportationEquipmentBuilder transportationEquipment;
		protected CommodityDeliveryRisk.CommodityDeliveryRiskBuilder risk;
	
		public CommodityUSCoalDeliveryModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quantityVariationAdjustment")
		public Boolean getQuantityVariationAdjustment() {
			return quantityVariationAdjustment;
		}
		
		@Override
		@RosettaAttribute("transportationEquipment")
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder getTransportationEquipment() {
			return transportationEquipment;
		}
		
		@Override
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder getOrCreateTransportationEquipment() {
			CoalTransportationEquipment.CoalTransportationEquipmentBuilder result;
			if (transportationEquipment!=null) {
				result = transportationEquipment;
			}
			else {
				result = transportationEquipment = CoalTransportationEquipment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("risk")
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk() {
			return risk;
		}
		
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk() {
			CommodityDeliveryRisk.CommodityDeliveryRiskBuilder result;
			if (risk!=null) {
				result = risk;
			}
			else {
				result = risk = CommodityDeliveryRisk.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantityVariationAdjustment")
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder setQuantityVariationAdjustment(Boolean quantityVariationAdjustment) {
			this.quantityVariationAdjustment = quantityVariationAdjustment==null?null:quantityVariationAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("transportationEquipment")
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder setTransportationEquipment(CoalTransportationEquipment transportationEquipment) {
			this.transportationEquipment = transportationEquipment==null?null:transportationEquipment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("risk")
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder setRisk(CommodityDeliveryRisk risk) {
			this.risk = risk==null?null:risk.toBuilder();
			return this;
		}
		
		@Override
		public CommodityUSCoalDeliveryModel build() {
			return new CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelImpl(this);
		}
		
		@Override
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder prune() {
			if (transportationEquipment!=null && !transportationEquipment.prune().hasData()) transportationEquipment = null;
			if (risk!=null && !risk.prune().hasData()) risk = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantityVariationAdjustment()!=null) return true;
			if (getTransportationEquipment()!=null && getTransportationEquipment().hasData()) return true;
			if (getRisk()!=null && getRisk().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder o = (CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder) other;
			
			merger.mergeRosetta(getTransportationEquipment(), o.getTransportationEquipment(), this::setTransportationEquipment);
			merger.mergeRosetta(getRisk(), o.getRisk(), this::setRisk);
			
			merger.mergeBasic(getQuantityVariationAdjustment(), o.getQuantityVariationAdjustment(), this::setQuantityVariationAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityUSCoalDeliveryModel _that = getType().cast(o);
		
			if (!Objects.equals(quantityVariationAdjustment, _that.getQuantityVariationAdjustment())) return false;
			if (!Objects.equals(transportationEquipment, _that.getTransportationEquipment())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityVariationAdjustment != null ? quantityVariationAdjustment.hashCode() : 0);
			_result = 31 * _result + (transportationEquipment != null ? transportationEquipment.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityUSCoalDeliveryModelBuilder {" +
				"quantityVariationAdjustment=" + this.quantityVariationAdjustment + ", " +
				"transportationEquipment=" + this.transportationEquipment + ", " +
				"risk=" + this.risk +
			'}';
		}
	}
}
