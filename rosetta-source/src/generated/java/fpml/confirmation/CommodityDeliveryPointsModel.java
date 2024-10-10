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
import fpml.confirmation.CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder;
import fpml.confirmation.CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilderImpl;
import fpml.confirmation.CommodityDeliveryPointsModel.CommodityDeliveryPointsModelImpl;
import fpml.confirmation.CommodityDeliveryPointsModelSequence;
import fpml.confirmation.GasDeliveryPoint;
import fpml.confirmation.meta.CommodityDeliveryPointsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A Delivery Point, applicable to physically settled commodity transactions.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDeliveryPointsModel", builder=CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilderImpl.class, version="${project.version}")
public interface CommodityDeliveryPointsModel extends RosettaModelObject {

	CommodityDeliveryPointsModelMeta metaData = new CommodityDeliveryPointsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The physical or virtual point at which the commodity will be delivered.
	 */
	GasDeliveryPoint getDeliveryPoint();
	CommodityDeliveryPointsModelSequence getCommodityDeliveryPointsModelSequence();

	/*********************** Build Methods  ***********************/
	CommodityDeliveryPointsModel build();
	
	CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder toBuilder();
	
	static CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder builder() {
		return new CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDeliveryPointsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDeliveryPointsModel> getType() {
		return CommodityDeliveryPointsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryPoint"), processor, GasDeliveryPoint.class, getDeliveryPoint());
		processRosetta(path.newSubPath("commodityDeliveryPointsModelSequence"), processor, CommodityDeliveryPointsModelSequence.class, getCommodityDeliveryPointsModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDeliveryPointsModelBuilder extends CommodityDeliveryPointsModel, RosettaModelObjectBuilder {
		GasDeliveryPoint.GasDeliveryPointBuilder getOrCreateDeliveryPoint();
		GasDeliveryPoint.GasDeliveryPointBuilder getDeliveryPoint();
		CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder getOrCreateCommodityDeliveryPointsModelSequence();
		CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder getCommodityDeliveryPointsModelSequence();
		CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder setDeliveryPoint(GasDeliveryPoint deliveryPoint);
		CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder setCommodityDeliveryPointsModelSequence(CommodityDeliveryPointsModelSequence commodityDeliveryPointsModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryPoint"), processor, GasDeliveryPoint.GasDeliveryPointBuilder.class, getDeliveryPoint());
			processRosetta(path.newSubPath("commodityDeliveryPointsModelSequence"), processor, CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder.class, getCommodityDeliveryPointsModelSequence());
		}
		

		CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDeliveryPointsModel  ***********************/
	class CommodityDeliveryPointsModelImpl implements CommodityDeliveryPointsModel {
		private final GasDeliveryPoint deliveryPoint;
		private final CommodityDeliveryPointsModelSequence commodityDeliveryPointsModelSequence;
		
		protected CommodityDeliveryPointsModelImpl(CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder builder) {
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).map(f->f.build()).orElse(null);
			this.commodityDeliveryPointsModelSequence = ofNullable(builder.getCommodityDeliveryPointsModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		public GasDeliveryPoint getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPointsModelSequence")
		public CommodityDeliveryPointsModelSequence getCommodityDeliveryPointsModelSequence() {
			return commodityDeliveryPointsModelSequence;
		}
		
		@Override
		public CommodityDeliveryPointsModel build() {
			return this;
		}
		
		@Override
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder toBuilder() {
			CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder builder) {
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getCommodityDeliveryPointsModelSequence()).ifPresent(builder::setCommodityDeliveryPointsModelSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPointsModel _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(commodityDeliveryPointsModelSequence, _that.getCommodityDeliveryPointsModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPointsModelSequence != null ? commodityDeliveryPointsModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPointsModel {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"commodityDeliveryPointsModelSequence=" + this.commodityDeliveryPointsModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDeliveryPointsModel  ***********************/
	class CommodityDeliveryPointsModelBuilderImpl implements CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder {
	
		protected GasDeliveryPoint.GasDeliveryPointBuilder deliveryPoint;
		protected CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder commodityDeliveryPointsModelSequence;
	
		public CommodityDeliveryPointsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryPoint")
		public GasDeliveryPoint.GasDeliveryPointBuilder getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder getOrCreateDeliveryPoint() {
			GasDeliveryPoint.GasDeliveryPointBuilder result;
			if (deliveryPoint!=null) {
				result = deliveryPoint;
			}
			else {
				result = deliveryPoint = GasDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPointsModelSequence")
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder getCommodityDeliveryPointsModelSequence() {
			return commodityDeliveryPointsModelSequence;
		}
		
		@Override
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder getOrCreateCommodityDeliveryPointsModelSequence() {
			CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder result;
			if (commodityDeliveryPointsModelSequence!=null) {
				result = commodityDeliveryPointsModelSequence;
			}
			else {
				result = commodityDeliveryPointsModelSequence = CommodityDeliveryPointsModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder setDeliveryPoint(GasDeliveryPoint deliveryPoint) {
			this.deliveryPoint = deliveryPoint==null?null:deliveryPoint.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityDeliveryPointsModelSequence")
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder setCommodityDeliveryPointsModelSequence(CommodityDeliveryPointsModelSequence commodityDeliveryPointsModelSequence) {
			this.commodityDeliveryPointsModelSequence = commodityDeliveryPointsModelSequence==null?null:commodityDeliveryPointsModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDeliveryPointsModel build() {
			return new CommodityDeliveryPointsModel.CommodityDeliveryPointsModelImpl(this);
		}
		
		@Override
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder prune() {
			if (deliveryPoint!=null && !deliveryPoint.prune().hasData()) deliveryPoint = null;
			if (commodityDeliveryPointsModelSequence!=null && !commodityDeliveryPointsModelSequence.prune().hasData()) commodityDeliveryPointsModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryPoint()!=null && getDeliveryPoint().hasData()) return true;
			if (getCommodityDeliveryPointsModelSequence()!=null && getCommodityDeliveryPointsModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder o = (CommodityDeliveryPointsModel.CommodityDeliveryPointsModelBuilder) other;
			
			merger.mergeRosetta(getDeliveryPoint(), o.getDeliveryPoint(), this::setDeliveryPoint);
			merger.mergeRosetta(getCommodityDeliveryPointsModelSequence(), o.getCommodityDeliveryPointsModelSequence(), this::setCommodityDeliveryPointsModelSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPointsModel _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(commodityDeliveryPointsModelSequence, _that.getCommodityDeliveryPointsModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPointsModelSequence != null ? commodityDeliveryPointsModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPointsModelBuilder {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"commodityDeliveryPointsModelSequence=" + this.commodityDeliveryPointsModelSequence +
			'}';
		}
	}
}
