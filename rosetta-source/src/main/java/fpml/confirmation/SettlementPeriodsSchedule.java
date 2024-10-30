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
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.SettlementPeriodsSchedule;
import fpml.confirmation.SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder;
import fpml.confirmation.SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilderImpl;
import fpml.confirmation.SettlementPeriodsSchedule.SettlementPeriodsScheduleImpl;
import fpml.confirmation.SettlementPeriodsStep;
import fpml.confirmation.meta.SettlementPeriodsScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The specification of the Settlement Periods in which the electricity will be delivered for a &quot;shaped&quot; trade i.e. where different Settlement Period ranges will apply to different periods of the trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SettlementPeriodsSchedule", builder=SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SettlementPeriodsSchedule extends RosettaModelObject {

	SettlementPeriodsScheduleMeta metaData = new SettlementPeriodsScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The range of Settlement Periods per Calculation Period. There must be a range of Settlement Periods specified for each Calculation Period, regardless of whether the range of Settlement Periods changes or stays the same between periods.
	 */
	List<? extends SettlementPeriodsStep> getSettlementPeriodsStep();
	CommodityDeliveryPeriodsPointerModel getCommodityDeliveryPeriodsPointerModel();

	/*********************** Build Methods  ***********************/
	SettlementPeriodsSchedule build();
	
	SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder toBuilder();
	
	static SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder() {
		return new SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodsSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriodsSchedule> getType() {
		return SettlementPeriodsSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriodsStep"), processor, SettlementPeriodsStep.class, getSettlementPeriodsStep());
		processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.class, getCommodityDeliveryPeriodsPointerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsScheduleBuilder extends SettlementPeriodsSchedule, RosettaModelObjectBuilder {
		SettlementPeriodsStep.SettlementPeriodsStepBuilder getOrCreateSettlementPeriodsStep(int _index);
		List<? extends SettlementPeriodsStep.SettlementPeriodsStepBuilder> getSettlementPeriodsStep();
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getOrCreateCommodityDeliveryPeriodsPointerModel();
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getCommodityDeliveryPeriodsPointerModel();
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep settlementPeriodsStep0);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep settlementPeriodsStep1, int _idx);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsStep2);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsStep3);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriodsStep"), processor, SettlementPeriodsStep.SettlementPeriodsStepBuilder.class, getSettlementPeriodsStep());
			processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder.class, getCommodityDeliveryPeriodsPointerModel());
		}
		

		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodsSchedule  ***********************/
	class SettlementPeriodsScheduleImpl implements SettlementPeriodsSchedule {
		private final List<? extends SettlementPeriodsStep> settlementPeriodsStep;
		private final CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel;
		
		protected SettlementPeriodsScheduleImpl(SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder) {
			this.settlementPeriodsStep = ofNullable(builder.getSettlementPeriodsStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityDeliveryPeriodsPointerModel = ofNullable(builder.getCommodityDeliveryPeriodsPointerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsStep")
		public List<? extends SettlementPeriodsStep> getSettlementPeriodsStep() {
			return settlementPeriodsStep;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPeriodsPointerModel")
		public CommodityDeliveryPeriodsPointerModel getCommodityDeliveryPeriodsPointerModel() {
			return commodityDeliveryPeriodsPointerModel;
		}
		
		@Override
		public SettlementPeriodsSchedule build() {
			return this;
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder toBuilder() {
			SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder) {
			ofNullable(getSettlementPeriodsStep()).ifPresent(builder::setSettlementPeriodsStep);
			ofNullable(getCommodityDeliveryPeriodsPointerModel()).ifPresent(builder::setCommodityDeliveryPeriodsPointerModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodsSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsStep, _that.getSettlementPeriodsStep())) return false;
			if (!Objects.equals(commodityDeliveryPeriodsPointerModel, _that.getCommodityDeliveryPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsStep != null ? settlementPeriodsStep.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPeriodsPointerModel != null ? commodityDeliveryPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsSchedule {" +
				"settlementPeriodsStep=" + this.settlementPeriodsStep + ", " +
				"commodityDeliveryPeriodsPointerModel=" + this.commodityDeliveryPeriodsPointerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodsSchedule  ***********************/
	class SettlementPeriodsScheduleBuilderImpl implements SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder {
	
		protected List<SettlementPeriodsStep.SettlementPeriodsStepBuilder> settlementPeriodsStep = new ArrayList<>();
		protected CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder commodityDeliveryPeriodsPointerModel;
	
		public SettlementPeriodsScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriodsStep")
		public List<? extends SettlementPeriodsStep.SettlementPeriodsStepBuilder> getSettlementPeriodsStep() {
			return settlementPeriodsStep;
		}
		
		@Override
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder getOrCreateSettlementPeriodsStep(int _index) {
		
			if (settlementPeriodsStep==null) {
				this.settlementPeriodsStep = new ArrayList<>();
			}
			SettlementPeriodsStep.SettlementPeriodsStepBuilder result;
			return getIndex(settlementPeriodsStep, _index, () -> {
						SettlementPeriodsStep.SettlementPeriodsStepBuilder newSettlementPeriodsStep = SettlementPeriodsStep.builder();
						return newSettlementPeriodsStep;
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
		@RosettaAttribute("settlementPeriodsStep")
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep settlementPeriodsStep) {
			if (settlementPeriodsStep!=null) this.settlementPeriodsStep.add(settlementPeriodsStep.toBuilder());
			return this;
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep settlementPeriodsStep, int _idx) {
			getIndex(this.settlementPeriodsStep, _idx, () -> settlementPeriodsStep.toBuilder());
			return this;
		}
		@Override 
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsSteps) {
			if (settlementPeriodsSteps != null) {
				for (SettlementPeriodsStep toAdd : settlementPeriodsSteps) {
					this.settlementPeriodsStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsSteps) {
			if (settlementPeriodsSteps == null)  {
				this.settlementPeriodsStep = new ArrayList<>();
			}
			else {
				this.settlementPeriodsStep = settlementPeriodsSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPeriodsPointerModel")
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
			this.commodityDeliveryPeriodsPointerModel = commodityDeliveryPeriodsPointerModel==null?null:commodityDeliveryPeriodsPointerModel.toBuilder();
			return this;
		}
		
		@Override
		public SettlementPeriodsSchedule build() {
			return new SettlementPeriodsSchedule.SettlementPeriodsScheduleImpl(this);
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder prune() {
			settlementPeriodsStep = settlementPeriodsStep.stream().filter(b->b!=null).<SettlementPeriodsStep.SettlementPeriodsStepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityDeliveryPeriodsPointerModel!=null && !commodityDeliveryPeriodsPointerModel.prune().hasData()) commodityDeliveryPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriodsStep()!=null && getSettlementPeriodsStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityDeliveryPeriodsPointerModel()!=null && getCommodityDeliveryPeriodsPointerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder o = (SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsStep(), o.getSettlementPeriodsStep(), this::getOrCreateSettlementPeriodsStep);
			merger.mergeRosetta(getCommodityDeliveryPeriodsPointerModel(), o.getCommodityDeliveryPeriodsPointerModel(), this::setCommodityDeliveryPeriodsPointerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodsSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsStep, _that.getSettlementPeriodsStep())) return false;
			if (!Objects.equals(commodityDeliveryPeriodsPointerModel, _that.getCommodityDeliveryPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsStep != null ? settlementPeriodsStep.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPeriodsPointerModel != null ? commodityDeliveryPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsScheduleBuilder {" +
				"settlementPeriodsStep=" + this.settlementPeriodsStep + ", " +
				"commodityDeliveryPeriodsPointerModel=" + this.commodityDeliveryPeriodsPointerModel +
			'}';
		}
	}
}
