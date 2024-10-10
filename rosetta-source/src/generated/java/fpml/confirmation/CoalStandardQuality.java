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
import fpml.confirmation.CoalStandardQuality;
import fpml.confirmation.CoalStandardQuality.CoalStandardQualityBuilder;
import fpml.confirmation.CoalStandardQuality.CoalStandardQualityBuilderImpl;
import fpml.confirmation.CoalStandardQuality.CoalStandardQualityImpl;
import fpml.confirmation.CommodityCoalCompositionModel;
import fpml.confirmation.CommodityCoalPropertiesModel;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel;
import fpml.confirmation.meta.CoalStandardQualityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The quality attributes of the coal to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="CoalStandardQuality", builder=CoalStandardQuality.CoalStandardQualityBuilderImpl.class, version="${project.version}")
public interface CoalStandardQuality extends RosettaModelObject {

	CoalStandardQualityMeta metaData = new CoalStandardQualityMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCoalCompositionModel getCommodityCoalCompositionModel();
	CommodityCoalPropertiesModel getCommodityCoalPropertiesModel();
	CommodityCoalReducingAtmosphereModel getCommodityCoalReducingAtmosphereModel();

	/*********************** Build Methods  ***********************/
	CoalStandardQuality build();
	
	CoalStandardQuality.CoalStandardQualityBuilder toBuilder();
	
	static CoalStandardQuality.CoalStandardQualityBuilder builder() {
		return new CoalStandardQuality.CoalStandardQualityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalStandardQuality> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalStandardQuality> getType() {
		return CoalStandardQuality.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityCoalCompositionModel"), processor, CommodityCoalCompositionModel.class, getCommodityCoalCompositionModel());
		processRosetta(path.newSubPath("commodityCoalPropertiesModel"), processor, CommodityCoalPropertiesModel.class, getCommodityCoalPropertiesModel());
		processRosetta(path.newSubPath("commodityCoalReducingAtmosphereModel"), processor, CommodityCoalReducingAtmosphereModel.class, getCommodityCoalReducingAtmosphereModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalStandardQualityBuilder extends CoalStandardQuality, RosettaModelObjectBuilder {
		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder getOrCreateCommodityCoalCompositionModel();
		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder getCommodityCoalCompositionModel();
		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder getOrCreateCommodityCoalPropertiesModel();
		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder getCommodityCoalPropertiesModel();
		CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder getOrCreateCommodityCoalReducingAtmosphereModel();
		CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder getCommodityCoalReducingAtmosphereModel();
		CoalStandardQuality.CoalStandardQualityBuilder setCommodityCoalCompositionModel(CommodityCoalCompositionModel commodityCoalCompositionModel);
		CoalStandardQuality.CoalStandardQualityBuilder setCommodityCoalPropertiesModel(CommodityCoalPropertiesModel commodityCoalPropertiesModel);
		CoalStandardQuality.CoalStandardQualityBuilder setCommodityCoalReducingAtmosphereModel(CommodityCoalReducingAtmosphereModel commodityCoalReducingAtmosphereModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityCoalCompositionModel"), processor, CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder.class, getCommodityCoalCompositionModel());
			processRosetta(path.newSubPath("commodityCoalPropertiesModel"), processor, CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder.class, getCommodityCoalPropertiesModel());
			processRosetta(path.newSubPath("commodityCoalReducingAtmosphereModel"), processor, CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder.class, getCommodityCoalReducingAtmosphereModel());
		}
		

		CoalStandardQuality.CoalStandardQualityBuilder prune();
	}

	/*********************** Immutable Implementation of CoalStandardQuality  ***********************/
	class CoalStandardQualityImpl implements CoalStandardQuality {
		private final CommodityCoalCompositionModel commodityCoalCompositionModel;
		private final CommodityCoalPropertiesModel commodityCoalPropertiesModel;
		private final CommodityCoalReducingAtmosphereModel commodityCoalReducingAtmosphereModel;
		
		protected CoalStandardQualityImpl(CoalStandardQuality.CoalStandardQualityBuilder builder) {
			this.commodityCoalCompositionModel = ofNullable(builder.getCommodityCoalCompositionModel()).map(f->f.build()).orElse(null);
			this.commodityCoalPropertiesModel = ofNullable(builder.getCommodityCoalPropertiesModel()).map(f->f.build()).orElse(null);
			this.commodityCoalReducingAtmosphereModel = ofNullable(builder.getCommodityCoalReducingAtmosphereModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityCoalCompositionModel")
		public CommodityCoalCompositionModel getCommodityCoalCompositionModel() {
			return commodityCoalCompositionModel;
		}
		
		@Override
		@RosettaAttribute("commodityCoalPropertiesModel")
		public CommodityCoalPropertiesModel getCommodityCoalPropertiesModel() {
			return commodityCoalPropertiesModel;
		}
		
		@Override
		@RosettaAttribute("commodityCoalReducingAtmosphereModel")
		public CommodityCoalReducingAtmosphereModel getCommodityCoalReducingAtmosphereModel() {
			return commodityCoalReducingAtmosphereModel;
		}
		
		@Override
		public CoalStandardQuality build() {
			return this;
		}
		
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder toBuilder() {
			CoalStandardQuality.CoalStandardQualityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalStandardQuality.CoalStandardQualityBuilder builder) {
			ofNullable(getCommodityCoalCompositionModel()).ifPresent(builder::setCommodityCoalCompositionModel);
			ofNullable(getCommodityCoalPropertiesModel()).ifPresent(builder::setCommodityCoalPropertiesModel);
			ofNullable(getCommodityCoalReducingAtmosphereModel()).ifPresent(builder::setCommodityCoalReducingAtmosphereModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQuality _that = getType().cast(o);
		
			if (!Objects.equals(commodityCoalCompositionModel, _that.getCommodityCoalCompositionModel())) return false;
			if (!Objects.equals(commodityCoalPropertiesModel, _that.getCommodityCoalPropertiesModel())) return false;
			if (!Objects.equals(commodityCoalReducingAtmosphereModel, _that.getCommodityCoalReducingAtmosphereModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCoalCompositionModel != null ? commodityCoalCompositionModel.hashCode() : 0);
			_result = 31 * _result + (commodityCoalPropertiesModel != null ? commodityCoalPropertiesModel.hashCode() : 0);
			_result = 31 * _result + (commodityCoalReducingAtmosphereModel != null ? commodityCoalReducingAtmosphereModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQuality {" +
				"commodityCoalCompositionModel=" + this.commodityCoalCompositionModel + ", " +
				"commodityCoalPropertiesModel=" + this.commodityCoalPropertiesModel + ", " +
				"commodityCoalReducingAtmosphereModel=" + this.commodityCoalReducingAtmosphereModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalStandardQuality  ***********************/
	class CoalStandardQualityBuilderImpl implements CoalStandardQuality.CoalStandardQualityBuilder {
	
		protected CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder commodityCoalCompositionModel;
		protected CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder commodityCoalPropertiesModel;
		protected CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder commodityCoalReducingAtmosphereModel;
	
		public CoalStandardQualityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityCoalCompositionModel")
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder getCommodityCoalCompositionModel() {
			return commodityCoalCompositionModel;
		}
		
		@Override
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder getOrCreateCommodityCoalCompositionModel() {
			CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder result;
			if (commodityCoalCompositionModel!=null) {
				result = commodityCoalCompositionModel;
			}
			else {
				result = commodityCoalCompositionModel = CommodityCoalCompositionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityCoalPropertiesModel")
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder getCommodityCoalPropertiesModel() {
			return commodityCoalPropertiesModel;
		}
		
		@Override
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder getOrCreateCommodityCoalPropertiesModel() {
			CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder result;
			if (commodityCoalPropertiesModel!=null) {
				result = commodityCoalPropertiesModel;
			}
			else {
				result = commodityCoalPropertiesModel = CommodityCoalPropertiesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityCoalReducingAtmosphereModel")
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder getCommodityCoalReducingAtmosphereModel() {
			return commodityCoalReducingAtmosphereModel;
		}
		
		@Override
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder getOrCreateCommodityCoalReducingAtmosphereModel() {
			CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder result;
			if (commodityCoalReducingAtmosphereModel!=null) {
				result = commodityCoalReducingAtmosphereModel;
			}
			else {
				result = commodityCoalReducingAtmosphereModel = CommodityCoalReducingAtmosphereModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityCoalCompositionModel")
		public CoalStandardQuality.CoalStandardQualityBuilder setCommodityCoalCompositionModel(CommodityCoalCompositionModel commodityCoalCompositionModel) {
			this.commodityCoalCompositionModel = commodityCoalCompositionModel==null?null:commodityCoalCompositionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCoalPropertiesModel")
		public CoalStandardQuality.CoalStandardQualityBuilder setCommodityCoalPropertiesModel(CommodityCoalPropertiesModel commodityCoalPropertiesModel) {
			this.commodityCoalPropertiesModel = commodityCoalPropertiesModel==null?null:commodityCoalPropertiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCoalReducingAtmosphereModel")
		public CoalStandardQuality.CoalStandardQualityBuilder setCommodityCoalReducingAtmosphereModel(CommodityCoalReducingAtmosphereModel commodityCoalReducingAtmosphereModel) {
			this.commodityCoalReducingAtmosphereModel = commodityCoalReducingAtmosphereModel==null?null:commodityCoalReducingAtmosphereModel.toBuilder();
			return this;
		}
		
		@Override
		public CoalStandardQuality build() {
			return new CoalStandardQuality.CoalStandardQualityImpl(this);
		}
		
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder prune() {
			if (commodityCoalCompositionModel!=null && !commodityCoalCompositionModel.prune().hasData()) commodityCoalCompositionModel = null;
			if (commodityCoalPropertiesModel!=null && !commodityCoalPropertiesModel.prune().hasData()) commodityCoalPropertiesModel = null;
			if (commodityCoalReducingAtmosphereModel!=null && !commodityCoalReducingAtmosphereModel.prune().hasData()) commodityCoalReducingAtmosphereModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityCoalCompositionModel()!=null && getCommodityCoalCompositionModel().hasData()) return true;
			if (getCommodityCoalPropertiesModel()!=null && getCommodityCoalPropertiesModel().hasData()) return true;
			if (getCommodityCoalReducingAtmosphereModel()!=null && getCommodityCoalReducingAtmosphereModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalStandardQuality.CoalStandardQualityBuilder o = (CoalStandardQuality.CoalStandardQualityBuilder) other;
			
			merger.mergeRosetta(getCommodityCoalCompositionModel(), o.getCommodityCoalCompositionModel(), this::setCommodityCoalCompositionModel);
			merger.mergeRosetta(getCommodityCoalPropertiesModel(), o.getCommodityCoalPropertiesModel(), this::setCommodityCoalPropertiesModel);
			merger.mergeRosetta(getCommodityCoalReducingAtmosphereModel(), o.getCommodityCoalReducingAtmosphereModel(), this::setCommodityCoalReducingAtmosphereModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQuality _that = getType().cast(o);
		
			if (!Objects.equals(commodityCoalCompositionModel, _that.getCommodityCoalCompositionModel())) return false;
			if (!Objects.equals(commodityCoalPropertiesModel, _that.getCommodityCoalPropertiesModel())) return false;
			if (!Objects.equals(commodityCoalReducingAtmosphereModel, _that.getCommodityCoalReducingAtmosphereModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCoalCompositionModel != null ? commodityCoalCompositionModel.hashCode() : 0);
			_result = 31 * _result + (commodityCoalPropertiesModel != null ? commodityCoalPropertiesModel.hashCode() : 0);
			_result = 31 * _result + (commodityCoalReducingAtmosphereModel != null ? commodityCoalReducingAtmosphereModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQualityBuilder {" +
				"commodityCoalCompositionModel=" + this.commodityCoalCompositionModel + ", " +
				"commodityCoalPropertiesModel=" + this.commodityCoalPropertiesModel + ", " +
				"commodityCoalReducingAtmosphereModel=" + this.commodityCoalReducingAtmosphereModel +
			'}';
		}
	}
}
