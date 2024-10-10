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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder;
import fpml.confirmation.CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilderImpl;
import fpml.confirmation.CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelImpl;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.meta.CommodityCalculationPeriodsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Calculation Periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityCalculationPeriodsModel", builder=CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilderImpl.class, version="${project.version}")
public interface CommodityCalculationPeriodsModel extends RosettaModelObject {

	CommodityCalculationPeriodsModelMeta metaData = new CommodityCalculationPeriodsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Calculation Period dates for this leg of the trade where the Calculation Periods are all one day long. Only dates explicitly included determine the Calculation Periods and there is a Calculation Period for each date specified. As such one-day Calculation Period are typical a physically-settled emissions or metals trades it is expected that this element will not be used in performance swaps.
	 */
	AdjustableDates getCalculationDates();
	/**
	 * The Calculation Period start dates for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 */
	AdjustableDates getCalculationPeriods();
	/**
	 * The Calculation Periods for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on the other leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 */
	CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();

	/*********************** Build Methods  ***********************/
	CommodityCalculationPeriodsModel build();
	
	CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder toBuilder();
	
	static CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder builder() {
		return new CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityCalculationPeriodsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityCalculationPeriodsModel> getType() {
		return CommodityCalculationPeriodsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableDates.class, getCalculationDates());
		processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.class, getCalculationPeriods());
		processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getCalculationPeriodsSchedule());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityCalculationPeriodsModelBuilder extends CommodityCalculationPeriodsModel, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationDates();
		AdjustableDates.AdjustableDatesBuilder getCalculationDates();
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods();
		AdjustableDates.AdjustableDatesBuilder getCalculationPeriods();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCalculationDates(AdjustableDates calculationDates);
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationPeriods());
			processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getCalculationPeriodsSchedule());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
		}
		

		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityCalculationPeriodsModel  ***********************/
	class CommodityCalculationPeriodsModelImpl implements CommodityCalculationPeriodsModel {
		private final AdjustableDates calculationDates;
		private final AdjustableDates calculationPeriods;
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		
		protected CommodityCalculationPeriodsModelImpl(CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder builder) {
			this.calculationDates = ofNullable(builder.getCalculationDates()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public AdjustableDates getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		public AdjustableDates getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityCalculationPeriodsModel build() {
			return this;
		}
		
		@Override
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder toBuilder() {
			CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder builder) {
			ofNullable(getCalculationDates()).ifPresent(builder::setCalculationDates);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCalculationPeriodsModel _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCalculationPeriodsModel {" +
				"calculationDates=" + this.calculationDates + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityCalculationPeriodsModel  ***********************/
	class CommodityCalculationPeriodsModelBuilderImpl implements CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder calculationDates;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
	
		public CommodityCalculationPeriodsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationDates")
		public AdjustableDates.AdjustableDatesBuilder getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationDates!=null) {
				result = calculationDates;
			}
			else {
				result = calculationDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		public AdjustableDates.AdjustableDatesBuilder getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationPeriods!=null) {
				result = calculationPeriods;
			}
			else {
				result = calculationPeriods = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (calculationPeriodsSchedule!=null) {
				result = calculationPeriodsSchedule;
			}
			else {
				result = calculationPeriodsSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel() {
			CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder result;
			if (commodityCalculationPeriodsPointerModel!=null) {
				result = commodityCalculationPeriodsPointerModel;
			}
			else {
				result = commodityCalculationPeriodsPointerModel = CommodityCalculationPeriodsPointerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCalculationDates(AdjustableDates calculationDates) {
			this.calculationDates = calculationDates==null?null:calculationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriods")
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCalculationPeriods(AdjustableDates calculationPeriods) {
			this.calculationPeriods = calculationPeriods==null?null:calculationPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = calculationPeriodsSchedule==null?null:calculationPeriodsSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityCalculationPeriodsModel build() {
			return new CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelImpl(this);
		}
		
		@Override
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder prune() {
			if (calculationDates!=null && !calculationDates.prune().hasData()) calculationDates = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationDates()!=null && getCalculationDates().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder o = (CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder) other;
			
			merger.mergeRosetta(getCalculationDates(), o.getCalculationDates(), this::setCalculationDates);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCalculationPeriodsModel _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCalculationPeriodsModelBuilder {" +
				"calculationDates=" + this.calculationDates + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}
}
