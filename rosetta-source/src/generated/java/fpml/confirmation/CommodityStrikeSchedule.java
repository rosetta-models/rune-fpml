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
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityStrikeSchedule;
import fpml.confirmation.CommodityStrikeSchedule.CommodityStrikeScheduleBuilder;
import fpml.confirmation.CommodityStrikeSchedule.CommodityStrikeScheduleBuilderImpl;
import fpml.confirmation.CommodityStrikeSchedule.CommodityStrikeScheduleImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.CommodityStrikeScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The Strike Price per Unit per Calculation Period. There must be a Strike Price per Unit step specified for each Calculation Period, regardless of whether the Strike changes or remains the same between periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityStrikeSchedule", builder=CommodityStrikeSchedule.CommodityStrikeScheduleBuilderImpl.class, version="${project.version}")
public interface CommodityStrikeSchedule extends RosettaModelObject {

	CommodityStrikeScheduleMeta metaData = new CommodityStrikeScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The strike price per unit per Calculation Period. There must be a strike price per unit specified for each Calculation Period, regardless of whether the price changes or remains the same between periods.
	 */
	List<? extends NonNegativeMoney> getStrikePricePerUnitStep();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();

	/*********************** Build Methods  ***********************/
	CommodityStrikeSchedule build();
	
	CommodityStrikeSchedule.CommodityStrikeScheduleBuilder toBuilder();
	
	static CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder() {
		return new CommodityStrikeSchedule.CommodityStrikeScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityStrikeSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityStrikeSchedule> getType() {
		return CommodityStrikeSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("strikePricePerUnitStep"), processor, NonNegativeMoney.class, getStrikePricePerUnitStep());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityStrikeScheduleBuilder extends CommodityStrikeSchedule, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnitStep(int _index);
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getStrikePricePerUnitStep();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney strikePricePerUnitStep0);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney strikePricePerUnitStep1, int _idx);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitStep2);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitStep3);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("strikePricePerUnitStep"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getStrikePricePerUnitStep());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
		}
		

		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityStrikeSchedule  ***********************/
	class CommodityStrikeScheduleImpl implements CommodityStrikeSchedule {
		private final List<? extends NonNegativeMoney> strikePricePerUnitStep;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		
		protected CommodityStrikeScheduleImpl(CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder) {
			this.strikePricePerUnitStep = ofNullable(builder.getStrikePricePerUnitStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnitStep")
		public List<? extends NonNegativeMoney> getStrikePricePerUnitStep() {
			return strikePricePerUnitStep;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityStrikeSchedule build() {
			return this;
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder toBuilder() {
			CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder) {
			ofNullable(getStrikePricePerUnitStep()).ifPresent(builder::setStrikePricePerUnitStep);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStrikeSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strikePricePerUnitStep, _that.getStrikePricePerUnitStep())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePricePerUnitStep != null ? strikePricePerUnitStep.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStrikeSchedule {" +
				"strikePricePerUnitStep=" + this.strikePricePerUnitStep + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityStrikeSchedule  ***********************/
	class CommodityStrikeScheduleBuilderImpl implements CommodityStrikeSchedule.CommodityStrikeScheduleBuilder {
	
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> strikePricePerUnitStep = new ArrayList<>();
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
	
		public CommodityStrikeScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikePricePerUnitStep")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getStrikePricePerUnitStep() {
			return strikePricePerUnitStep;
		}
		
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnitStep(int _index) {
		
			if (strikePricePerUnitStep==null) {
				this.strikePricePerUnitStep = new ArrayList<>();
			}
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			return getIndex(strikePricePerUnitStep, _index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newStrikePricePerUnitStep = NonNegativeMoney.builder();
						return newStrikePricePerUnitStep;
					});
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
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney strikePricePerUnitStep) {
			if (strikePricePerUnitStep!=null) this.strikePricePerUnitStep.add(strikePricePerUnitStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney strikePricePerUnitStep, int _idx) {
			getIndex(this.strikePricePerUnitStep, _idx, () -> strikePricePerUnitStep.toBuilder());
			return this;
		}
		@Override 
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitSteps) {
			if (strikePricePerUnitSteps != null) {
				for (NonNegativeMoney toAdd : strikePricePerUnitSteps) {
					this.strikePricePerUnitStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("strikePricePerUnitStep")
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitSteps) {
			if (strikePricePerUnitSteps == null)  {
				this.strikePricePerUnitStep = new ArrayList<>();
			}
			else {
				this.strikePricePerUnitStep = strikePricePerUnitSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityStrikeSchedule build() {
			return new CommodityStrikeSchedule.CommodityStrikeScheduleImpl(this);
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder prune() {
			strikePricePerUnitStep = strikePricePerUnitStep.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikePricePerUnitStep()!=null && getStrikePricePerUnitStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityStrikeSchedule.CommodityStrikeScheduleBuilder o = (CommodityStrikeSchedule.CommodityStrikeScheduleBuilder) other;
			
			merger.mergeRosetta(getStrikePricePerUnitStep(), o.getStrikePricePerUnitStep(), this::getOrCreateStrikePricePerUnitStep);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStrikeSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strikePricePerUnitStep, _that.getStrikePricePerUnitStep())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePricePerUnitStep != null ? strikePricePerUnitStep.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStrikeScheduleBuilder {" +
				"strikePricePerUnitStep=" + this.strikePricePerUnitStep + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}
}
