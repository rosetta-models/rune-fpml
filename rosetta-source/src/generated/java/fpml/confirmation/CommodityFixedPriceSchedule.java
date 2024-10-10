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
import fpml.confirmation.CommodityFixedPriceSchedule;
import fpml.confirmation.CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder;
import fpml.confirmation.CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilderImpl;
import fpml.confirmation.CommodityFixedPriceSchedule.CommodityFixedPriceScheduleImpl;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.CommodityFixedPriceScheduleMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The Fixed Price for a given Calculation Period during the life of the trade. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFixedPriceSchedule", builder=CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilderImpl.class, version="${project.version}")
public interface CommodityFixedPriceSchedule extends RosettaModelObject {

	CommodityFixedPriceScheduleMeta metaData = new CommodityFixedPriceScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Fixed Price for a given Calculation Period during the life of the trade. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
	 */
	List<? extends FixedPrice> getFixedPriceStep();
	/**
	 * For a Wet Voyager Charter Freight Swap, the number of Worldscale Points for purposes of the calculation of a Fixed Amount for a given Calculation Period during the life of the trade. There must be Worldscale Rate Step specified for each Calculation Period, regardless of whether the Worldscale Rate Step changes or remains the same between periods.
	 */
	List<BigDecimal> getWorldscaleRateStep();
	/**
	 * For a DRY Voyage Charter or Time Charter Freight Swap, the price per relevant unit for pruposes of the calculation of a Fixed Amount for a given Calculation Period during the life of the trade. There must be Worldscale Rate Step specified for each Calculation Period, regardless of whether the Worldscale Rate Step changes or remains the same between periods.
	 */
	List<? extends NonNegativeMoney> getContractRateStep();
	/**
	 * For an electricity transaction, the fixed price schedule for one or more groups of Settlement Periods on which fixed payments are based. if the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 */
	List<? extends CommoditySettlementPeriodsPriceSchedule> getSettlementPeriodsPriceSchedule();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();

	/*********************** Build Methods  ***********************/
	CommodityFixedPriceSchedule build();
	
	CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder toBuilder();
	
	static CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder() {
		return new CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFixedPriceSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFixedPriceSchedule> getType() {
		return CommodityFixedPriceSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedPriceStep"), processor, FixedPrice.class, getFixedPriceStep());
		processor.processBasic(path.newSubPath("worldscaleRateStep"), BigDecimal.class, getWorldscaleRateStep(), this);
		processRosetta(path.newSubPath("contractRateStep"), processor, NonNegativeMoney.class, getContractRateStep());
		processRosetta(path.newSubPath("settlementPeriodsPriceSchedule"), processor, CommoditySettlementPeriodsPriceSchedule.class, getSettlementPeriodsPriceSchedule());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFixedPriceScheduleBuilder extends CommodityFixedPriceSchedule, RosettaModelObjectBuilder {
		FixedPrice.FixedPriceBuilder getOrCreateFixedPriceStep(int _index);
		List<? extends FixedPrice.FixedPriceBuilder> getFixedPriceStep();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateContractRateStep(int _index);
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getContractRateStep();
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder getOrCreateSettlementPeriodsPriceSchedule(int _index);
		List<? extends CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder> getSettlementPeriodsPriceSchedule();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(FixedPrice fixedPriceStep0);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(FixedPrice fixedPriceStep1, int _idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(List<? extends FixedPrice> fixedPriceStep2);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setFixedPriceStep(List<? extends FixedPrice> fixedPriceStep3);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal worldscaleRateStep0);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal worldscaleRateStep1, int _idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(List<BigDecimal> worldscaleRateStep2);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setWorldscaleRateStep(List<BigDecimal> worldscaleRateStep3);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney contractRateStep0);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney contractRateStep1, int _idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(List<? extends NonNegativeMoney> contractRateStep2);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setContractRateStep(List<? extends NonNegativeMoney> contractRateStep3);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule settlementPeriodsPriceSchedule0);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule settlementPeriodsPriceSchedule1, int _idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedule2);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedule3);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedPriceStep"), processor, FixedPrice.FixedPriceBuilder.class, getFixedPriceStep());
			processor.processBasic(path.newSubPath("worldscaleRateStep"), BigDecimal.class, getWorldscaleRateStep(), this);
			processRosetta(path.newSubPath("contractRateStep"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getContractRateStep());
			processRosetta(path.newSubPath("settlementPeriodsPriceSchedule"), processor, CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder.class, getSettlementPeriodsPriceSchedule());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
		}
		

		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFixedPriceSchedule  ***********************/
	class CommodityFixedPriceScheduleImpl implements CommodityFixedPriceSchedule {
		private final List<? extends FixedPrice> fixedPriceStep;
		private final List<BigDecimal> worldscaleRateStep;
		private final List<? extends NonNegativeMoney> contractRateStep;
		private final List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedule;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		
		protected CommodityFixedPriceScheduleImpl(CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder) {
			this.fixedPriceStep = ofNullable(builder.getFixedPriceStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.worldscaleRateStep = ofNullable(builder.getWorldscaleRateStep()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.contractRateStep = ofNullable(builder.getContractRateStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsPriceSchedule = ofNullable(builder.getSettlementPeriodsPriceSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedPriceStep")
		public List<? extends FixedPrice> getFixedPriceStep() {
			return fixedPriceStep;
		}
		
		@Override
		@RosettaAttribute("worldscaleRateStep")
		public List<BigDecimal> getWorldscaleRateStep() {
			return worldscaleRateStep;
		}
		
		@Override
		@RosettaAttribute("contractRateStep")
		public List<? extends NonNegativeMoney> getContractRateStep() {
			return contractRateStep;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceSchedule")
		public List<? extends CommoditySettlementPeriodsPriceSchedule> getSettlementPeriodsPriceSchedule() {
			return settlementPeriodsPriceSchedule;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityFixedPriceSchedule build() {
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder toBuilder() {
			CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder) {
			ofNullable(getFixedPriceStep()).ifPresent(builder::setFixedPriceStep);
			ofNullable(getWorldscaleRateStep()).ifPresent(builder::setWorldscaleRateStep);
			ofNullable(getContractRateStep()).ifPresent(builder::setContractRateStep);
			ofNullable(getSettlementPeriodsPriceSchedule()).ifPresent(builder::setSettlementPeriodsPriceSchedule);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPriceStep, _that.getFixedPriceStep())) return false;
			if (!ListEquals.listEquals(worldscaleRateStep, _that.getWorldscaleRateStep())) return false;
			if (!ListEquals.listEquals(contractRateStep, _that.getContractRateStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsPriceSchedule, _that.getSettlementPeriodsPriceSchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPriceStep != null ? fixedPriceStep.hashCode() : 0);
			_result = 31 * _result + (worldscaleRateStep != null ? worldscaleRateStep.hashCode() : 0);
			_result = 31 * _result + (contractRateStep != null ? contractRateStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsPriceSchedule != null ? settlementPeriodsPriceSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceSchedule {" +
				"fixedPriceStep=" + this.fixedPriceStep + ", " +
				"worldscaleRateStep=" + this.worldscaleRateStep + ", " +
				"contractRateStep=" + this.contractRateStep + ", " +
				"settlementPeriodsPriceSchedule=" + this.settlementPeriodsPriceSchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFixedPriceSchedule  ***********************/
	class CommodityFixedPriceScheduleBuilderImpl implements CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder {
	
		protected List<FixedPrice.FixedPriceBuilder> fixedPriceStep = new ArrayList<>();
		protected List<BigDecimal> worldscaleRateStep = new ArrayList<>();
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> contractRateStep = new ArrayList<>();
		protected List<CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder> settlementPeriodsPriceSchedule = new ArrayList<>();
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
	
		public CommodityFixedPriceScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedPriceStep")
		public List<? extends FixedPrice.FixedPriceBuilder> getFixedPriceStep() {
			return fixedPriceStep;
		}
		
		public FixedPrice.FixedPriceBuilder getOrCreateFixedPriceStep(int _index) {
		
			if (fixedPriceStep==null) {
				this.fixedPriceStep = new ArrayList<>();
			}
			FixedPrice.FixedPriceBuilder result;
			return getIndex(fixedPriceStep, _index, () -> {
						FixedPrice.FixedPriceBuilder newFixedPriceStep = FixedPrice.builder();
						return newFixedPriceStep;
					});
		}
		
		@Override
		@RosettaAttribute("worldscaleRateStep")
		public List<BigDecimal> getWorldscaleRateStep() {
			return worldscaleRateStep;
		}
		
		@Override
		@RosettaAttribute("contractRateStep")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getContractRateStep() {
			return contractRateStep;
		}
		
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateContractRateStep(int _index) {
		
			if (contractRateStep==null) {
				this.contractRateStep = new ArrayList<>();
			}
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			return getIndex(contractRateStep, _index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newContractRateStep = NonNegativeMoney.builder();
						return newContractRateStep;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceSchedule")
		public List<? extends CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder> getSettlementPeriodsPriceSchedule() {
			return settlementPeriodsPriceSchedule;
		}
		
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder getOrCreateSettlementPeriodsPriceSchedule(int _index) {
		
			if (settlementPeriodsPriceSchedule==null) {
				this.settlementPeriodsPriceSchedule = new ArrayList<>();
			}
			CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder result;
			return getIndex(settlementPeriodsPriceSchedule, _index, () -> {
						CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder newSettlementPeriodsPriceSchedule = CommoditySettlementPeriodsPriceSchedule.builder();
						return newSettlementPeriodsPriceSchedule;
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
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(FixedPrice fixedPriceStep) {
			if (fixedPriceStep!=null) this.fixedPriceStep.add(fixedPriceStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(FixedPrice fixedPriceStep, int _idx) {
			getIndex(this.fixedPriceStep, _idx, () -> fixedPriceStep.toBuilder());
			return this;
		}
		@Override 
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(List<? extends FixedPrice> fixedPriceSteps) {
			if (fixedPriceSteps != null) {
				for (FixedPrice toAdd : fixedPriceSteps) {
					this.fixedPriceStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fixedPriceStep")
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setFixedPriceStep(List<? extends FixedPrice> fixedPriceSteps) {
			if (fixedPriceSteps == null)  {
				this.fixedPriceStep = new ArrayList<>();
			}
			else {
				this.fixedPriceStep = fixedPriceSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal worldscaleRateStep) {
			if (worldscaleRateStep!=null) this.worldscaleRateStep.add(worldscaleRateStep);
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal worldscaleRateStep, int _idx) {
			getIndex(this.worldscaleRateStep, _idx, () -> worldscaleRateStep);
			return this;
		}
		@Override 
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(List<BigDecimal> worldscaleRateSteps) {
			if (worldscaleRateSteps != null) {
				for (BigDecimal toAdd : worldscaleRateSteps) {
					this.worldscaleRateStep.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("worldscaleRateStep")
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setWorldscaleRateStep(List<BigDecimal> worldscaleRateSteps) {
			if (worldscaleRateSteps == null)  {
				this.worldscaleRateStep = new ArrayList<>();
			}
			else {
				this.worldscaleRateStep = worldscaleRateSteps.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney contractRateStep) {
			if (contractRateStep!=null) this.contractRateStep.add(contractRateStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney contractRateStep, int _idx) {
			getIndex(this.contractRateStep, _idx, () -> contractRateStep.toBuilder());
			return this;
		}
		@Override 
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(List<? extends NonNegativeMoney> contractRateSteps) {
			if (contractRateSteps != null) {
				for (NonNegativeMoney toAdd : contractRateSteps) {
					this.contractRateStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("contractRateStep")
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setContractRateStep(List<? extends NonNegativeMoney> contractRateSteps) {
			if (contractRateSteps == null)  {
				this.contractRateStep = new ArrayList<>();
			}
			else {
				this.contractRateStep = contractRateSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule settlementPeriodsPriceSchedule) {
			if (settlementPeriodsPriceSchedule!=null) this.settlementPeriodsPriceSchedule.add(settlementPeriodsPriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule settlementPeriodsPriceSchedule, int _idx) {
			getIndex(this.settlementPeriodsPriceSchedule, _idx, () -> settlementPeriodsPriceSchedule.toBuilder());
			return this;
		}
		@Override 
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedules) {
			if (settlementPeriodsPriceSchedules != null) {
				for (CommoditySettlementPeriodsPriceSchedule toAdd : settlementPeriodsPriceSchedules) {
					this.settlementPeriodsPriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsPriceSchedule")
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedules) {
			if (settlementPeriodsPriceSchedules == null)  {
				this.settlementPeriodsPriceSchedule = new ArrayList<>();
			}
			else {
				this.settlementPeriodsPriceSchedule = settlementPeriodsPriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule build() {
			return new CommodityFixedPriceSchedule.CommodityFixedPriceScheduleImpl(this);
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder prune() {
			fixedPriceStep = fixedPriceStep.stream().filter(b->b!=null).<FixedPrice.FixedPriceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractRateStep = contractRateStep.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsPriceSchedule = settlementPeriodsPriceSchedule.stream().filter(b->b!=null).<CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedPriceStep()!=null && getFixedPriceStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWorldscaleRateStep()!=null && !getWorldscaleRateStep().isEmpty()) return true;
			if (getContractRateStep()!=null && getContractRateStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsPriceSchedule()!=null && getSettlementPeriodsPriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder o = (CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder) other;
			
			merger.mergeRosetta(getFixedPriceStep(), o.getFixedPriceStep(), this::getOrCreateFixedPriceStep);
			merger.mergeRosetta(getContractRateStep(), o.getContractRateStep(), this::getOrCreateContractRateStep);
			merger.mergeRosetta(getSettlementPeriodsPriceSchedule(), o.getSettlementPeriodsPriceSchedule(), this::getOrCreateSettlementPeriodsPriceSchedule);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			
			merger.mergeBasic(getWorldscaleRateStep(), o.getWorldscaleRateStep(), (Consumer<BigDecimal>) this::addWorldscaleRateStep);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPriceStep, _that.getFixedPriceStep())) return false;
			if (!ListEquals.listEquals(worldscaleRateStep, _that.getWorldscaleRateStep())) return false;
			if (!ListEquals.listEquals(contractRateStep, _that.getContractRateStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsPriceSchedule, _that.getSettlementPeriodsPriceSchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPriceStep != null ? fixedPriceStep.hashCode() : 0);
			_result = 31 * _result + (worldscaleRateStep != null ? worldscaleRateStep.hashCode() : 0);
			_result = 31 * _result + (contractRateStep != null ? contractRateStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsPriceSchedule != null ? settlementPeriodsPriceSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceScheduleBuilder {" +
				"fixedPriceStep=" + this.fixedPriceStep + ", " +
				"worldscaleRateStep=" + this.worldscaleRateStep + ", " +
				"contractRateStep=" + this.contractRateStep + ", " +
				"settlementPeriodsPriceSchedule=" + this.settlementPeriodsPriceSchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}
}
