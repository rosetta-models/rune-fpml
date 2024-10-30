package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.CoalStandardQuality;
import fpml.confirmation.CoalStandardQualitySchedule;
import fpml.confirmation.CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder;
import fpml.confirmation.CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilderImpl;
import fpml.confirmation.CoalStandardQualitySchedule.CoalStandardQualityScheduleImpl;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.meta.CoalStandardQualityScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The quality attributes of the coal to be delivered, specified on a periodic basis.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CoalStandardQualitySchedule", builder=CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CoalStandardQualitySchedule extends RosettaModelObject {

	CoalStandardQualityScheduleMeta metaData = new CoalStandardQualityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends CoalStandardQuality> getStandardQualityStep();
	CommodityDeliveryPeriodsPointerModel getCommodityDeliveryPeriodsPointerModel();

	/*********************** Build Methods  ***********************/
	CoalStandardQualitySchedule build();
	
	CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder toBuilder();
	
	static CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder() {
		return new CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalStandardQualitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalStandardQualitySchedule> getType() {
		return CoalStandardQualitySchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("standardQualityStep"), processor, CoalStandardQuality.class, getStandardQualityStep());
		processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.class, getCommodityDeliveryPeriodsPointerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalStandardQualityScheduleBuilder extends CoalStandardQualitySchedule, RosettaModelObjectBuilder {
		CoalStandardQuality.CoalStandardQualityBuilder getOrCreateStandardQualityStep(int _index);
		List<? extends CoalStandardQuality.CoalStandardQualityBuilder> getStandardQualityStep();
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getOrCreateCommodityDeliveryPeriodsPointerModel();
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getCommodityDeliveryPeriodsPointerModel();
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality standardQualityStep0);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality standardQualityStep1, int _idx);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(List<? extends CoalStandardQuality> standardQualityStep2);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setStandardQualityStep(List<? extends CoalStandardQuality> standardQualityStep3);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("standardQualityStep"), processor, CoalStandardQuality.CoalStandardQualityBuilder.class, getStandardQualityStep());
			processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder.class, getCommodityDeliveryPeriodsPointerModel());
		}
		

		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CoalStandardQualitySchedule  ***********************/
	class CoalStandardQualityScheduleImpl implements CoalStandardQualitySchedule {
		private final List<? extends CoalStandardQuality> standardQualityStep;
		private final CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel;
		
		protected CoalStandardQualityScheduleImpl(CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder) {
			this.standardQualityStep = ofNullable(builder.getStandardQualityStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityDeliveryPeriodsPointerModel = ofNullable(builder.getCommodityDeliveryPeriodsPointerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("standardQualityStep")
		public List<? extends CoalStandardQuality> getStandardQualityStep() {
			return standardQualityStep;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPeriodsPointerModel")
		public CommodityDeliveryPeriodsPointerModel getCommodityDeliveryPeriodsPointerModel() {
			return commodityDeliveryPeriodsPointerModel;
		}
		
		@Override
		public CoalStandardQualitySchedule build() {
			return this;
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder toBuilder() {
			CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder) {
			ofNullable(getStandardQualityStep()).ifPresent(builder::setStandardQualityStep);
			ofNullable(getCommodityDeliveryPeriodsPointerModel()).ifPresent(builder::setCommodityDeliveryPeriodsPointerModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQualitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(standardQualityStep, _that.getStandardQualityStep())) return false;
			if (!Objects.equals(commodityDeliveryPeriodsPointerModel, _that.getCommodityDeliveryPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardQualityStep != null ? standardQualityStep.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPeriodsPointerModel != null ? commodityDeliveryPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQualitySchedule {" +
				"standardQualityStep=" + this.standardQualityStep + ", " +
				"commodityDeliveryPeriodsPointerModel=" + this.commodityDeliveryPeriodsPointerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalStandardQualitySchedule  ***********************/
	class CoalStandardQualityScheduleBuilderImpl implements CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder {
	
		protected List<CoalStandardQuality.CoalStandardQualityBuilder> standardQualityStep = new ArrayList<>();
		protected CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder commodityDeliveryPeriodsPointerModel;
	
		public CoalStandardQualityScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("standardQualityStep")
		public List<? extends CoalStandardQuality.CoalStandardQualityBuilder> getStandardQualityStep() {
			return standardQualityStep;
		}
		
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder getOrCreateStandardQualityStep(int _index) {
		
			if (standardQualityStep==null) {
				this.standardQualityStep = new ArrayList<>();
			}
			CoalStandardQuality.CoalStandardQualityBuilder result;
			return getIndex(standardQualityStep, _index, () -> {
						CoalStandardQuality.CoalStandardQualityBuilder newStandardQualityStep = CoalStandardQuality.builder();
						return newStandardQualityStep;
					});
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPeriodsPointerModel")
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getCommodityDeliveryPeriodsPointerModel() {
			return commodityDeliveryPeriodsPointerModel;
		}
		
		@Override
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getOrCreateCommodityDeliveryPeriodsPointerModel() {
			CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder result;
			if (commodityDeliveryPeriodsPointerModel!=null) {
				result = commodityDeliveryPeriodsPointerModel;
			}
			else {
				result = commodityDeliveryPeriodsPointerModel = CommodityDeliveryPeriodsPointerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("standardQualityStep")
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality standardQualityStep) {
			if (standardQualityStep!=null) this.standardQualityStep.add(standardQualityStep.toBuilder());
			return this;
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality standardQualityStep, int _idx) {
			getIndex(this.standardQualityStep, _idx, () -> standardQualityStep.toBuilder());
			return this;
		}
		@Override 
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(List<? extends CoalStandardQuality> standardQualitySteps) {
			if (standardQualitySteps != null) {
				for (CoalStandardQuality toAdd : standardQualitySteps) {
					this.standardQualityStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setStandardQualityStep(List<? extends CoalStandardQuality> standardQualitySteps) {
			if (standardQualitySteps == null)  {
				this.standardQualityStep = new ArrayList<>();
			}
			else {
				this.standardQualityStep = standardQualitySteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPeriodsPointerModel")
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
			this.commodityDeliveryPeriodsPointerModel = commodityDeliveryPeriodsPointerModel==null?null:commodityDeliveryPeriodsPointerModel.toBuilder();
			return this;
		}
		
		@Override
		public CoalStandardQualitySchedule build() {
			return new CoalStandardQualitySchedule.CoalStandardQualityScheduleImpl(this);
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder prune() {
			standardQualityStep = standardQualityStep.stream().filter(b->b!=null).<CoalStandardQuality.CoalStandardQualityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityDeliveryPeriodsPointerModel!=null && !commodityDeliveryPeriodsPointerModel.prune().hasData()) commodityDeliveryPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardQualityStep()!=null && getStandardQualityStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityDeliveryPeriodsPointerModel()!=null && getCommodityDeliveryPeriodsPointerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder o = (CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder) other;
			
			merger.mergeRosetta(getStandardQualityStep(), o.getStandardQualityStep(), this::getOrCreateStandardQualityStep);
			merger.mergeRosetta(getCommodityDeliveryPeriodsPointerModel(), o.getCommodityDeliveryPeriodsPointerModel(), this::setCommodityDeliveryPeriodsPointerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQualitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(standardQualityStep, _that.getStandardQualityStep())) return false;
			if (!Objects.equals(commodityDeliveryPeriodsPointerModel, _that.getCommodityDeliveryPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardQualityStep != null ? standardQualityStep.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPeriodsPointerModel != null ? commodityDeliveryPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQualityScheduleBuilder {" +
				"standardQualityStep=" + this.standardQualityStep + ", " +
				"commodityDeliveryPeriodsPointerModel=" + this.commodityDeliveryPeriodsPointerModel +
			'}';
		}
	}
}
