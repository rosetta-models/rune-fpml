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
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.CommodityFinancialOptionModel;
import fpml.confirmation.CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder;
import fpml.confirmation.CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilderImpl;
import fpml.confirmation.CommodityFinancialOptionModel.CommodityFinancialOptionModelImpl;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityOptionFeaturesModel;
import fpml.confirmation.CommodityStrikePriceModel;
import fpml.confirmation.meta.CommodityFinancialOptionModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items specific to financially-settled commodity options.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFinancialOptionModel", builder=CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilderImpl.class, version="${project.version}")
public interface CommodityFinancialOptionModel extends RosettaModelObject {

	CommodityFinancialOptionModelMeta metaData = new CommodityFinancialOptionModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the underlying instrument. Usual content is an ISDA Commodity Reference Price Name. The &#39;commodity&#39; underlyer component is specified using a reference to the &#39;commodity&#39; asset (see description above at the Commodity Underlyer section).
	 */
	Commodity getCommodity();
	CommodityOptionFeaturesModel getCommodityOptionFeaturesModel();
	CommodityNotionalQuantityModel getCommodityNotionalQuantityModel();
	/**
	 * The parameters for defining how the commodity option can be exercised and how it is settled.
	 */
	CommodityExercise getExercise();
	CommodityStrikePriceModel getCommodityStrikePriceModel();
	CommodityFloatingStrikePriceModel getCommodityFloatingStrikePriceModel();

	/*********************** Build Methods  ***********************/
	CommodityFinancialOptionModel build();
	
	CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder toBuilder();
	
	static CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder builder() {
		return new CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFinancialOptionModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFinancialOptionModel> getType() {
		return CommodityFinancialOptionModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("commodityOptionFeaturesModel"), processor, CommodityOptionFeaturesModel.class, getCommodityOptionFeaturesModel());
		processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.class, getCommodityNotionalQuantityModel());
		processRosetta(path.newSubPath("exercise"), processor, CommodityExercise.class, getExercise());
		processRosetta(path.newSubPath("commodityStrikePriceModel"), processor, CommodityStrikePriceModel.class, getCommodityStrikePriceModel());
		processRosetta(path.newSubPath("commodityFloatingStrikePriceModel"), processor, CommodityFloatingStrikePriceModel.class, getCommodityFloatingStrikePriceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFinancialOptionModelBuilder extends CommodityFinancialOptionModel, RosettaModelObjectBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder getOrCreateCommodityOptionFeaturesModel();
		CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder getCommodityOptionFeaturesModel();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getOrCreateCommodityNotionalQuantityModel();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getCommodityNotionalQuantityModel();
		CommodityExercise.CommodityExerciseBuilder getOrCreateExercise();
		CommodityExercise.CommodityExerciseBuilder getExercise();
		CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getOrCreateCommodityStrikePriceModel();
		CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getCommodityStrikePriceModel();
		CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getOrCreateCommodityFloatingStrikePriceModel();
		CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getCommodityFloatingStrikePriceModel();
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodity(Commodity commodity);
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityOptionFeaturesModel(CommodityOptionFeaturesModel commodityOptionFeaturesModel);
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel);
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setExercise(CommodityExercise exercise);
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityStrikePriceModel(CommodityStrikePriceModel commodityStrikePriceModel);
		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityFloatingStrikePriceModel(CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("commodityOptionFeaturesModel"), processor, CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder.class, getCommodityOptionFeaturesModel());
			processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder.class, getCommodityNotionalQuantityModel());
			processRosetta(path.newSubPath("exercise"), processor, CommodityExercise.CommodityExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("commodityStrikePriceModel"), processor, CommodityStrikePriceModel.CommodityStrikePriceModelBuilder.class, getCommodityStrikePriceModel());
			processRosetta(path.newSubPath("commodityFloatingStrikePriceModel"), processor, CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder.class, getCommodityFloatingStrikePriceModel());
		}
		

		CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFinancialOptionModel  ***********************/
	class CommodityFinancialOptionModelImpl implements CommodityFinancialOptionModel {
		private final Commodity commodity;
		private final CommodityOptionFeaturesModel commodityOptionFeaturesModel;
		private final CommodityNotionalQuantityModel commodityNotionalQuantityModel;
		private final CommodityExercise exercise;
		private final CommodityStrikePriceModel commodityStrikePriceModel;
		private final CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel;
		
		protected CommodityFinancialOptionModelImpl(CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder builder) {
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.commodityOptionFeaturesModel = ofNullable(builder.getCommodityOptionFeaturesModel()).map(f->f.build()).orElse(null);
			this.commodityNotionalQuantityModel = ofNullable(builder.getCommodityNotionalQuantityModel()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.commodityStrikePriceModel = ofNullable(builder.getCommodityStrikePriceModel()).map(f->f.build()).orElse(null);
			this.commodityFloatingStrikePriceModel = ofNullable(builder.getCommodityFloatingStrikePriceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("commodityOptionFeaturesModel")
		public CommodityOptionFeaturesModel getCommodityOptionFeaturesModel() {
			return commodityOptionFeaturesModel;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityNotionalQuantityModel getCommodityNotionalQuantityModel() {
			return commodityNotionalQuantityModel;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public CommodityExercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("commodityStrikePriceModel")
		public CommodityStrikePriceModel getCommodityStrikePriceModel() {
			return commodityStrikePriceModel;
		}
		
		@Override
		@RosettaAttribute("commodityFloatingStrikePriceModel")
		public CommodityFloatingStrikePriceModel getCommodityFloatingStrikePriceModel() {
			return commodityFloatingStrikePriceModel;
		}
		
		@Override
		public CommodityFinancialOptionModel build() {
			return this;
		}
		
		@Override
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder toBuilder() {
			CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder builder) {
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getCommodityOptionFeaturesModel()).ifPresent(builder::setCommodityOptionFeaturesModel);
			ofNullable(getCommodityNotionalQuantityModel()).ifPresent(builder::setCommodityNotionalQuantityModel);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getCommodityStrikePriceModel()).ifPresent(builder::setCommodityStrikePriceModel);
			ofNullable(getCommodityFloatingStrikePriceModel()).ifPresent(builder::setCommodityFloatingStrikePriceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFinancialOptionModel _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityOptionFeaturesModel, _that.getCommodityOptionFeaturesModel())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(commodityStrikePriceModel, _that.getCommodityStrikePriceModel())) return false;
			if (!Objects.equals(commodityFloatingStrikePriceModel, _that.getCommodityFloatingStrikePriceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityOptionFeaturesModel != null ? commodityOptionFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (commodityStrikePriceModel != null ? commodityStrikePriceModel.hashCode() : 0);
			_result = 31 * _result + (commodityFloatingStrikePriceModel != null ? commodityFloatingStrikePriceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFinancialOptionModel {" +
				"commodity=" + this.commodity + ", " +
				"commodityOptionFeaturesModel=" + this.commodityOptionFeaturesModel + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel + ", " +
				"exercise=" + this.exercise + ", " +
				"commodityStrikePriceModel=" + this.commodityStrikePriceModel + ", " +
				"commodityFloatingStrikePriceModel=" + this.commodityFloatingStrikePriceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFinancialOptionModel  ***********************/
	class CommodityFinancialOptionModelBuilderImpl implements CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder {
	
		protected Commodity.CommodityBuilder commodity;
		protected CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder commodityOptionFeaturesModel;
		protected CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder commodityNotionalQuantityModel;
		protected CommodityExercise.CommodityExerciseBuilder exercise;
		protected CommodityStrikePriceModel.CommodityStrikePriceModelBuilder commodityStrikePriceModel;
		protected CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder commodityFloatingStrikePriceModel;
	
		public CommodityFinancialOptionModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityOptionFeaturesModel")
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder getCommodityOptionFeaturesModel() {
			return commodityOptionFeaturesModel;
		}
		
		@Override
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder getOrCreateCommodityOptionFeaturesModel() {
			CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder result;
			if (commodityOptionFeaturesModel!=null) {
				result = commodityOptionFeaturesModel;
			}
			else {
				result = commodityOptionFeaturesModel = CommodityOptionFeaturesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getCommodityNotionalQuantityModel() {
			return commodityNotionalQuantityModel;
		}
		
		@Override
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getOrCreateCommodityNotionalQuantityModel() {
			CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder result;
			if (commodityNotionalQuantityModel!=null) {
				result = commodityNotionalQuantityModel;
			}
			else {
				result = commodityNotionalQuantityModel = CommodityNotionalQuantityModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public CommodityExercise.CommodityExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public CommodityExercise.CommodityExerciseBuilder getOrCreateExercise() {
			CommodityExercise.CommodityExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = CommodityExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityStrikePriceModel")
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getCommodityStrikePriceModel() {
			return commodityStrikePriceModel;
		}
		
		@Override
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getOrCreateCommodityStrikePriceModel() {
			CommodityStrikePriceModel.CommodityStrikePriceModelBuilder result;
			if (commodityStrikePriceModel!=null) {
				result = commodityStrikePriceModel;
			}
			else {
				result = commodityStrikePriceModel = CommodityStrikePriceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFloatingStrikePriceModel")
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getCommodityFloatingStrikePriceModel() {
			return commodityFloatingStrikePriceModel;
		}
		
		@Override
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getOrCreateCommodityFloatingStrikePriceModel() {
			CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder result;
			if (commodityFloatingStrikePriceModel!=null) {
				result = commodityFloatingStrikePriceModel;
			}
			else {
				result = commodityFloatingStrikePriceModel = CommodityFloatingStrikePriceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityOptionFeaturesModel")
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityOptionFeaturesModel(CommodityOptionFeaturesModel commodityOptionFeaturesModel) {
			this.commodityOptionFeaturesModel = commodityOptionFeaturesModel==null?null:commodityOptionFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			this.commodityNotionalQuantityModel = commodityNotionalQuantityModel==null?null:commodityNotionalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setExercise(CommodityExercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityStrikePriceModel")
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityStrikePriceModel(CommodityStrikePriceModel commodityStrikePriceModel) {
			this.commodityStrikePriceModel = commodityStrikePriceModel==null?null:commodityStrikePriceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFloatingStrikePriceModel")
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder setCommodityFloatingStrikePriceModel(CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel) {
			this.commodityFloatingStrikePriceModel = commodityFloatingStrikePriceModel==null?null:commodityFloatingStrikePriceModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFinancialOptionModel build() {
			return new CommodityFinancialOptionModel.CommodityFinancialOptionModelImpl(this);
		}
		
		@Override
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder prune() {
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (commodityOptionFeaturesModel!=null && !commodityOptionFeaturesModel.prune().hasData()) commodityOptionFeaturesModel = null;
			if (commodityNotionalQuantityModel!=null && !commodityNotionalQuantityModel.prune().hasData()) commodityNotionalQuantityModel = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (commodityStrikePriceModel!=null && !commodityStrikePriceModel.prune().hasData()) commodityStrikePriceModel = null;
			if (commodityFloatingStrikePriceModel!=null && !commodityFloatingStrikePriceModel.prune().hasData()) commodityFloatingStrikePriceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getCommodityOptionFeaturesModel()!=null && getCommodityOptionFeaturesModel().hasData()) return true;
			if (getCommodityNotionalQuantityModel()!=null && getCommodityNotionalQuantityModel().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getCommodityStrikePriceModel()!=null && getCommodityStrikePriceModel().hasData()) return true;
			if (getCommodityFloatingStrikePriceModel()!=null && getCommodityFloatingStrikePriceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder o = (CommodityFinancialOptionModel.CommodityFinancialOptionModelBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getCommodityOptionFeaturesModel(), o.getCommodityOptionFeaturesModel(), this::setCommodityOptionFeaturesModel);
			merger.mergeRosetta(getCommodityNotionalQuantityModel(), o.getCommodityNotionalQuantityModel(), this::setCommodityNotionalQuantityModel);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getCommodityStrikePriceModel(), o.getCommodityStrikePriceModel(), this::setCommodityStrikePriceModel);
			merger.mergeRosetta(getCommodityFloatingStrikePriceModel(), o.getCommodityFloatingStrikePriceModel(), this::setCommodityFloatingStrikePriceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFinancialOptionModel _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityOptionFeaturesModel, _that.getCommodityOptionFeaturesModel())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(commodityStrikePriceModel, _that.getCommodityStrikePriceModel())) return false;
			if (!Objects.equals(commodityFloatingStrikePriceModel, _that.getCommodityFloatingStrikePriceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityOptionFeaturesModel != null ? commodityOptionFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (commodityStrikePriceModel != null ? commodityStrikePriceModel.hashCode() : 0);
			_result = 31 * _result + (commodityFloatingStrikePriceModel != null ? commodityFloatingStrikePriceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFinancialOptionModelBuilder {" +
				"commodity=" + this.commodity + ", " +
				"commodityOptionFeaturesModel=" + this.commodityOptionFeaturesModel + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel + ", " +
				"exercise=" + this.exercise + ", " +
				"commodityStrikePriceModel=" + this.commodityStrikePriceModel + ", " +
				"commodityFloatingStrikePriceModel=" + this.commodityFloatingStrikePriceModel +
			'}';
		}
	}
}
