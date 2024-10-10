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
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder;
import fpml.confirmation.CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl;
import fpml.confirmation.CommodityDeliveryPeriods.CommodityDeliveryPeriodsImpl;
import fpml.confirmation.meta.CommodityDeliveryPeriodsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Delivery Periods of a physical leg.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDeliveryPeriods", builder=CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl.class, version="${project.version}")
public interface CommodityDeliveryPeriods extends RosettaModelObject {

	CommodityDeliveryPeriodsMeta metaData = new CommodityDeliveryPeriodsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Delivery Periods for this leg of the swap. This type is only intended to be used if the Delivery Periods differ from the Calculation Periods on the fixed or floating leg. If DeliveryPeriods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 */
	AdjustableDates getPeriods();
	/**
	 * The Delivery Periods for this leg of the swap. This type is only intended to be used if the Delivery Periods differ from the Calculation Periods on the fixed or floating leg. If DeliveryPeriods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 */
	CommodityCalculationPeriodsSchedule getPeriodsSchedule();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityDeliveryPeriods build();
	
	CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder toBuilder();
	
	static CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder() {
		return new CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDeliveryPeriods> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDeliveryPeriods> getType() {
		return CommodityDeliveryPeriods.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periods"), processor, AdjustableDates.class, getPeriods());
		processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getPeriodsSchedule());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDeliveryPeriodsBuilder extends CommodityDeliveryPeriods, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreatePeriods();
		AdjustableDates.AdjustableDatesBuilder getPeriods();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreatePeriodsSchedule();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getPeriodsSchedule();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriods(AdjustableDates periods);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule periodsSchedule);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getPeriods());
			processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getPeriodsSchedule());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDeliveryPeriods  ***********************/
	class CommodityDeliveryPeriodsImpl implements CommodityDeliveryPeriods {
		private final AdjustableDates periods;
		private final CommodityCalculationPeriodsSchedule periodsSchedule;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		private final String id;
		
		protected CommodityDeliveryPeriodsImpl(CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder) {
			this.periods = ofNullable(builder.getPeriods()).map(f->f.build()).orElse(null);
			this.periodsSchedule = ofNullable(builder.getPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("periods")
		public AdjustableDates getPeriods() {
			return periods;
		}
		
		@Override
		@RosettaAttribute("periodsSchedule")
		public CommodityCalculationPeriodsSchedule getPeriodsSchedule() {
			return periodsSchedule;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityDeliveryPeriods build() {
			return this;
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder toBuilder() {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder) {
			ofNullable(getPeriods()).ifPresent(builder::setPeriods);
			ofNullable(getPeriodsSchedule()).ifPresent(builder::setPeriodsSchedule);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(periods, _that.getPeriods())) return false;
			if (!Objects.equals(periodsSchedule, _that.getPeriodsSchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periods != null ? periods.hashCode() : 0);
			_result = 31 * _result + (periodsSchedule != null ? periodsSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPeriods {" +
				"periods=" + this.periods + ", " +
				"periodsSchedule=" + this.periodsSchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDeliveryPeriods  ***********************/
	class CommodityDeliveryPeriodsBuilderImpl implements CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder periods;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder periodsSchedule;
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
		protected String id;
	
		public CommodityDeliveryPeriodsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periods")
		public AdjustableDates.AdjustableDatesBuilder getPeriods() {
			return periods;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreatePeriods() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (periods!=null) {
				result = periods;
			}
			else {
				result = periods = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodsSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getPeriodsSchedule() {
			return periodsSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreatePeriodsSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (periodsSchedule!=null) {
				result = periodsSchedule;
			}
			else {
				result = periodsSchedule = CommodityCalculationPeriodsSchedule.builder();
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
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("periods")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriods(AdjustableDates periods) {
			this.periods = periods==null?null:periods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodsSchedule")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule periodsSchedule) {
			this.periodsSchedule = periodsSchedule==null?null:periodsSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityDeliveryPeriods build() {
			return new CommodityDeliveryPeriods.CommodityDeliveryPeriodsImpl(this);
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder prune() {
			if (periods!=null && !periods.prune().hasData()) periods = null;
			if (periodsSchedule!=null && !periodsSchedule.prune().hasData()) periodsSchedule = null;
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriods()!=null && getPeriods().hasData()) return true;
			if (getPeriodsSchedule()!=null && getPeriodsSchedule().hasData()) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder o = (CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder) other;
			
			merger.mergeRosetta(getPeriods(), o.getPeriods(), this::setPeriods);
			merger.mergeRosetta(getPeriodsSchedule(), o.getPeriodsSchedule(), this::setPeriodsSchedule);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(periods, _that.getPeriods())) return false;
			if (!Objects.equals(periodsSchedule, _that.getPeriodsSchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periods != null ? periods.hashCode() : 0);
			_result = 31 * _result + (periodsSchedule != null ? periodsSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPeriodsBuilder {" +
				"periods=" + this.periods + ", " +
				"periodsSchedule=" + this.periodsSchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
