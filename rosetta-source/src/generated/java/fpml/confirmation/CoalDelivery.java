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
import fpml.confirmation.CoalDelivery.CoalDeliveryBuilder;
import fpml.confirmation.CoalDelivery.CoalDeliveryBuilderImpl;
import fpml.confirmation.CoalDelivery.CoalDeliveryImpl;
import fpml.confirmation.CoalDeliveryPoint;
import fpml.confirmation.CommodityUSCoalDeliveryModel;
import fpml.confirmation.meta.CoalDeliveryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery conditions for coal.
 * @version ${project.version}
 */
@RosettaDataType(value="CoalDelivery", builder=CoalDelivery.CoalDeliveryBuilderImpl.class, version="${project.version}")
public interface CoalDelivery extends RosettaModelObject {

	CoalDeliveryMeta metaData = new CoalDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The point at which the Coal Product will be delivered and received.
	 */
	CoalDeliveryPoint getDeliveryPoint();
	/**
	 * The point at which the Coal Product as a reference to the Source of the Coal Product. This should be a reference to the source element within product.
	 */
	Boolean getDeliveryAtSource();
	CommodityUSCoalDeliveryModel getCommodityUSCoalDeliveryModel();

	/*********************** Build Methods  ***********************/
	CoalDelivery build();
	
	CoalDelivery.CoalDeliveryBuilder toBuilder();
	
	static CoalDelivery.CoalDeliveryBuilder builder() {
		return new CoalDelivery.CoalDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalDelivery> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalDelivery> getType() {
		return CoalDelivery.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryPoint"), processor, CoalDeliveryPoint.class, getDeliveryPoint());
		processor.processBasic(path.newSubPath("deliveryAtSource"), Boolean.class, getDeliveryAtSource(), this);
		processRosetta(path.newSubPath("commodityUSCoalDeliveryModel"), processor, CommodityUSCoalDeliveryModel.class, getCommodityUSCoalDeliveryModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalDeliveryBuilder extends CoalDelivery, RosettaModelObjectBuilder {
		CoalDeliveryPoint.CoalDeliveryPointBuilder getOrCreateDeliveryPoint();
		CoalDeliveryPoint.CoalDeliveryPointBuilder getDeliveryPoint();
		CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder getOrCreateCommodityUSCoalDeliveryModel();
		CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder getCommodityUSCoalDeliveryModel();
		CoalDelivery.CoalDeliveryBuilder setDeliveryPoint(CoalDeliveryPoint deliveryPoint);
		CoalDelivery.CoalDeliveryBuilder setDeliveryAtSource(Boolean deliveryAtSource);
		CoalDelivery.CoalDeliveryBuilder setCommodityUSCoalDeliveryModel(CommodityUSCoalDeliveryModel commodityUSCoalDeliveryModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryPoint"), processor, CoalDeliveryPoint.CoalDeliveryPointBuilder.class, getDeliveryPoint());
			processor.processBasic(path.newSubPath("deliveryAtSource"), Boolean.class, getDeliveryAtSource(), this);
			processRosetta(path.newSubPath("commodityUSCoalDeliveryModel"), processor, CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder.class, getCommodityUSCoalDeliveryModel());
		}
		

		CoalDelivery.CoalDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of CoalDelivery  ***********************/
	class CoalDeliveryImpl implements CoalDelivery {
		private final CoalDeliveryPoint deliveryPoint;
		private final Boolean deliveryAtSource;
		private final CommodityUSCoalDeliveryModel commodityUSCoalDeliveryModel;
		
		protected CoalDeliveryImpl(CoalDelivery.CoalDeliveryBuilder builder) {
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).map(f->f.build()).orElse(null);
			this.deliveryAtSource = builder.getDeliveryAtSource();
			this.commodityUSCoalDeliveryModel = ofNullable(builder.getCommodityUSCoalDeliveryModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		public CoalDeliveryPoint getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("deliveryAtSource")
		public Boolean getDeliveryAtSource() {
			return deliveryAtSource;
		}
		
		@Override
		@RosettaAttribute("commodityUSCoalDeliveryModel")
		public CommodityUSCoalDeliveryModel getCommodityUSCoalDeliveryModel() {
			return commodityUSCoalDeliveryModel;
		}
		
		@Override
		public CoalDelivery build() {
			return this;
		}
		
		@Override
		public CoalDelivery.CoalDeliveryBuilder toBuilder() {
			CoalDelivery.CoalDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalDelivery.CoalDeliveryBuilder builder) {
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getDeliveryAtSource()).ifPresent(builder::setDeliveryAtSource);
			ofNullable(getCommodityUSCoalDeliveryModel()).ifPresent(builder::setCommodityUSCoalDeliveryModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryAtSource, _that.getDeliveryAtSource())) return false;
			if (!Objects.equals(commodityUSCoalDeliveryModel, _that.getCommodityUSCoalDeliveryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryAtSource != null ? deliveryAtSource.hashCode() : 0);
			_result = 31 * _result + (commodityUSCoalDeliveryModel != null ? commodityUSCoalDeliveryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalDelivery {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryAtSource=" + this.deliveryAtSource + ", " +
				"commodityUSCoalDeliveryModel=" + this.commodityUSCoalDeliveryModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalDelivery  ***********************/
	class CoalDeliveryBuilderImpl implements CoalDelivery.CoalDeliveryBuilder {
	
		protected CoalDeliveryPoint.CoalDeliveryPointBuilder deliveryPoint;
		protected Boolean deliveryAtSource;
		protected CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder commodityUSCoalDeliveryModel;
	
		public CoalDeliveryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryPoint")
		public CoalDeliveryPoint.CoalDeliveryPointBuilder getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder getOrCreateDeliveryPoint() {
			CoalDeliveryPoint.CoalDeliveryPointBuilder result;
			if (deliveryPoint!=null) {
				result = deliveryPoint;
			}
			else {
				result = deliveryPoint = CoalDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryAtSource")
		public Boolean getDeliveryAtSource() {
			return deliveryAtSource;
		}
		
		@Override
		@RosettaAttribute("commodityUSCoalDeliveryModel")
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder getCommodityUSCoalDeliveryModel() {
			return commodityUSCoalDeliveryModel;
		}
		
		@Override
		public CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder getOrCreateCommodityUSCoalDeliveryModel() {
			CommodityUSCoalDeliveryModel.CommodityUSCoalDeliveryModelBuilder result;
			if (commodityUSCoalDeliveryModel!=null) {
				result = commodityUSCoalDeliveryModel;
			}
			else {
				result = commodityUSCoalDeliveryModel = CommodityUSCoalDeliveryModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		public CoalDelivery.CoalDeliveryBuilder setDeliveryPoint(CoalDeliveryPoint deliveryPoint) {
			this.deliveryPoint = deliveryPoint==null?null:deliveryPoint.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryAtSource")
		public CoalDelivery.CoalDeliveryBuilder setDeliveryAtSource(Boolean deliveryAtSource) {
			this.deliveryAtSource = deliveryAtSource==null?null:deliveryAtSource;
			return this;
		}
		@Override
		@RosettaAttribute("commodityUSCoalDeliveryModel")
		public CoalDelivery.CoalDeliveryBuilder setCommodityUSCoalDeliveryModel(CommodityUSCoalDeliveryModel commodityUSCoalDeliveryModel) {
			this.commodityUSCoalDeliveryModel = commodityUSCoalDeliveryModel==null?null:commodityUSCoalDeliveryModel.toBuilder();
			return this;
		}
		
		@Override
		public CoalDelivery build() {
			return new CoalDelivery.CoalDeliveryImpl(this);
		}
		
		@Override
		public CoalDelivery.CoalDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalDelivery.CoalDeliveryBuilder prune() {
			if (deliveryPoint!=null && !deliveryPoint.prune().hasData()) deliveryPoint = null;
			if (commodityUSCoalDeliveryModel!=null && !commodityUSCoalDeliveryModel.prune().hasData()) commodityUSCoalDeliveryModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryPoint()!=null && getDeliveryPoint().hasData()) return true;
			if (getDeliveryAtSource()!=null) return true;
			if (getCommodityUSCoalDeliveryModel()!=null && getCommodityUSCoalDeliveryModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalDelivery.CoalDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalDelivery.CoalDeliveryBuilder o = (CoalDelivery.CoalDeliveryBuilder) other;
			
			merger.mergeRosetta(getDeliveryPoint(), o.getDeliveryPoint(), this::setDeliveryPoint);
			merger.mergeRosetta(getCommodityUSCoalDeliveryModel(), o.getCommodityUSCoalDeliveryModel(), this::setCommodityUSCoalDeliveryModel);
			
			merger.mergeBasic(getDeliveryAtSource(), o.getDeliveryAtSource(), this::setDeliveryAtSource);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryAtSource, _that.getDeliveryAtSource())) return false;
			if (!Objects.equals(commodityUSCoalDeliveryModel, _that.getCommodityUSCoalDeliveryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryAtSource != null ? deliveryAtSource.hashCode() : 0);
			_result = 31 * _result + (commodityUSCoalDeliveryModel != null ? commodityUSCoalDeliveryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalDeliveryBuilder {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryAtSource=" + this.deliveryAtSource + ", " +
				"commodityUSCoalDeliveryModel=" + this.commodityUSCoalDeliveryModel +
			'}';
		}
	}
}
