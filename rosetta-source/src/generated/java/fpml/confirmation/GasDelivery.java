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
import fpml.confirmation.CommodityDeliveryPointsModel;
import fpml.confirmation.DeliveryTypeEnum;
import fpml.confirmation.GasDelivery;
import fpml.confirmation.GasDelivery.GasDeliveryBuilder;
import fpml.confirmation.GasDelivery.GasDeliveryBuilderImpl;
import fpml.confirmation.GasDelivery.GasDeliveryImpl;
import fpml.confirmation.GasDeliverySequence;
import fpml.confirmation.InterconnectionPoint;
import fpml.confirmation.meta.GasDeliveryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The specification of the gas to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="GasDelivery", builder=GasDelivery.GasDeliveryBuilderImpl.class, version="${project.version}")
public interface GasDelivery extends RosettaModelObject {

	GasDeliveryMeta metaData = new GasDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	CommodityDeliveryPointsModel getCommodityDeliveryPointsModel();
	/**
	 * Indicates whether the buyer and seller are contractually obliged to consume and supply the specified quantities of the commodity.
	 */
	DeliveryTypeEnum getDeliveryType();
	/**
	 * Identification of the border(s) or border point(s) of a transportation contract.
	 */
	InterconnectionPoint getInterconnectionPoint();
	GasDeliverySequence getGasDeliverySequence();

	/*********************** Build Methods  ***********************/
	GasDelivery build();
	
	GasDelivery.GasDeliveryBuilder toBuilder();
	
	static GasDelivery.GasDeliveryBuilder builder() {
		return new GasDelivery.GasDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDelivery> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasDelivery> getType() {
		return GasDelivery.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityDeliveryPointsModel"), processor, CommodityDeliveryPointsModel.class, getCommodityDeliveryPointsModel());
		processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
		processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.class, getInterconnectionPoint());
		processRosetta(path.newSubPath("gasDeliverySequence"), processor, GasDeliverySequence.class, getGasDeliverySequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliveryBuilder extends GasDelivery, RosettaModelObjectBuilder {
		CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder getOrCreateCommodityDeliveryPointsModel();
		CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder getCommodityDeliveryPointsModel();
		InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint();
		InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint();
		GasDeliverySequence.GasDeliverySequenceBuilder getOrCreateGasDeliverySequence();
		GasDeliverySequence.GasDeliverySequenceBuilder getGasDeliverySequence();
		GasDelivery.GasDeliveryBuilder setCommodityDeliveryPointsModel(CommodityDeliveryPointsModel commodityDeliveryPointsModel);
		GasDelivery.GasDeliveryBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		GasDelivery.GasDeliveryBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint);
		GasDelivery.GasDeliveryBuilder setGasDeliverySequence(GasDeliverySequence gasDeliverySequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityDeliveryPointsModel"), processor, CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder.class, getCommodityDeliveryPointsModel());
			processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
			processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.InterconnectionPointBuilder.class, getInterconnectionPoint());
			processRosetta(path.newSubPath("gasDeliverySequence"), processor, GasDeliverySequence.GasDeliverySequenceBuilder.class, getGasDeliverySequence());
		}
		

		GasDelivery.GasDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of GasDelivery  ***********************/
	class GasDeliveryImpl implements GasDelivery {
		private final CommodityDeliveryPointsModel commodityDeliveryPointsModel;
		private final DeliveryTypeEnum deliveryType;
		private final InterconnectionPoint interconnectionPoint;
		private final GasDeliverySequence gasDeliverySequence;
		
		protected GasDeliveryImpl(GasDelivery.GasDeliveryBuilder builder) {
			this.commodityDeliveryPointsModel = ofNullable(builder.getCommodityDeliveryPointsModel()).map(f->f.build()).orElse(null);
			this.deliveryType = builder.getDeliveryType();
			this.interconnectionPoint = ofNullable(builder.getInterconnectionPoint()).map(f->f.build()).orElse(null);
			this.gasDeliverySequence = ofNullable(builder.getGasDeliverySequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPointsModel")
		public CommodityDeliveryPointsModel getCommodityDeliveryPointsModel() {
			return commodityDeliveryPointsModel;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		public InterconnectionPoint getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		@RosettaAttribute("gasDeliverySequence")
		public GasDeliverySequence getGasDeliverySequence() {
			return gasDeliverySequence;
		}
		
		@Override
		public GasDelivery build() {
			return this;
		}
		
		@Override
		public GasDelivery.GasDeliveryBuilder toBuilder() {
			GasDelivery.GasDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDelivery.GasDeliveryBuilder builder) {
			ofNullable(getCommodityDeliveryPointsModel()).ifPresent(builder::setCommodityDeliveryPointsModel);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
			ofNullable(getGasDeliverySequence()).ifPresent(builder::setGasDeliverySequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDelivery _that = getType().cast(o);
		
			if (!Objects.equals(commodityDeliveryPointsModel, _that.getCommodityDeliveryPointsModel())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(gasDeliverySequence, _that.getGasDeliverySequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityDeliveryPointsModel != null ? commodityDeliveryPointsModel.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (gasDeliverySequence != null ? gasDeliverySequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDelivery {" +
				"commodityDeliveryPointsModel=" + this.commodityDeliveryPointsModel + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"gasDeliverySequence=" + this.gasDeliverySequence +
			'}';
		}
	}

	/*********************** Builder Implementation of GasDelivery  ***********************/
	class GasDeliveryBuilderImpl implements GasDelivery.GasDeliveryBuilder {
	
		protected CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder commodityDeliveryPointsModel;
		protected DeliveryTypeEnum deliveryType;
		protected InterconnectionPoint.InterconnectionPointBuilder interconnectionPoint;
		protected GasDeliverySequence.GasDeliverySequenceBuilder gasDeliverySequence;
	
		public GasDeliveryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityDeliveryPointsModel")
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder getCommodityDeliveryPointsModel() {
			return commodityDeliveryPointsModel;
		}
		
		@Override
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder getOrCreateCommodityDeliveryPointsModel() {
			CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder result;
			if (commodityDeliveryPointsModel!=null) {
				result = commodityDeliveryPointsModel;
			}
			else {
				result = commodityDeliveryPointsModel = CommodityDeliveryPointsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		public InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint() {
			InterconnectionPoint.InterconnectionPointBuilder result;
			if (interconnectionPoint!=null) {
				result = interconnectionPoint;
			}
			else {
				result = interconnectionPoint = InterconnectionPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("gasDeliverySequence")
		public GasDeliverySequence.GasDeliverySequenceBuilder getGasDeliverySequence() {
			return gasDeliverySequence;
		}
		
		@Override
		public GasDeliverySequence.GasDeliverySequenceBuilder getOrCreateGasDeliverySequence() {
			GasDeliverySequence.GasDeliverySequenceBuilder result;
			if (gasDeliverySequence!=null) {
				result = gasDeliverySequence;
			}
			else {
				result = gasDeliverySequence = GasDeliverySequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPointsModel")
		public GasDelivery.GasDeliveryBuilder setCommodityDeliveryPointsModel(CommodityDeliveryPointsModel commodityDeliveryPointsModel) {
			this.commodityDeliveryPointsModel = commodityDeliveryPointsModel==null?null:commodityDeliveryPointsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryType")
		public GasDelivery.GasDeliveryBuilder setDeliveryType(DeliveryTypeEnum deliveryType) {
			this.deliveryType = deliveryType==null?null:deliveryType;
			return this;
		}
		@Override
		@RosettaAttribute("interconnectionPoint")
		public GasDelivery.GasDeliveryBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint) {
			this.interconnectionPoint = interconnectionPoint==null?null:interconnectionPoint.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("gasDeliverySequence")
		public GasDelivery.GasDeliveryBuilder setGasDeliverySequence(GasDeliverySequence gasDeliverySequence) {
			this.gasDeliverySequence = gasDeliverySequence==null?null:gasDeliverySequence.toBuilder();
			return this;
		}
		
		@Override
		public GasDelivery build() {
			return new GasDelivery.GasDeliveryImpl(this);
		}
		
		@Override
		public GasDelivery.GasDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDelivery.GasDeliveryBuilder prune() {
			if (commodityDeliveryPointsModel!=null && !commodityDeliveryPointsModel.prune().hasData()) commodityDeliveryPointsModel = null;
			if (interconnectionPoint!=null && !interconnectionPoint.prune().hasData()) interconnectionPoint = null;
			if (gasDeliverySequence!=null && !gasDeliverySequence.prune().hasData()) gasDeliverySequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityDeliveryPointsModel()!=null && getCommodityDeliveryPointsModel().hasData()) return true;
			if (getDeliveryType()!=null) return true;
			if (getInterconnectionPoint()!=null && getInterconnectionPoint().hasData()) return true;
			if (getGasDeliverySequence()!=null && getGasDeliverySequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDelivery.GasDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasDelivery.GasDeliveryBuilder o = (GasDelivery.GasDeliveryBuilder) other;
			
			merger.mergeRosetta(getCommodityDeliveryPointsModel(), o.getCommodityDeliveryPointsModel(), this::setCommodityDeliveryPointsModel);
			merger.mergeRosetta(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			merger.mergeRosetta(getGasDeliverySequence(), o.getGasDeliverySequence(), this::setGasDeliverySequence);
			
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDelivery _that = getType().cast(o);
		
			if (!Objects.equals(commodityDeliveryPointsModel, _that.getCommodityDeliveryPointsModel())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(gasDeliverySequence, _that.getGasDeliverySequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityDeliveryPointsModel != null ? commodityDeliveryPointsModel.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (gasDeliverySequence != null ? gasDeliverySequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryBuilder {" +
				"commodityDeliveryPointsModel=" + this.commodityDeliveryPointsModel + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"gasDeliverySequence=" + this.gasDeliverySequence +
			'}';
		}
	}
}
