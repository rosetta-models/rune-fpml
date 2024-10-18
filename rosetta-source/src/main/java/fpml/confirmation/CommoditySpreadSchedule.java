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
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.CommoditySpreadSchedule;
import fpml.confirmation.CommoditySpreadSchedule.CommoditySpreadScheduleBuilder;
import fpml.confirmation.CommoditySpreadSchedule.CommoditySpreadScheduleBuilderImpl;
import fpml.confirmation.CommoditySpreadSchedule.CommoditySpreadScheduleImpl;
import fpml.confirmation.meta.CommoditySpreadScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The Spread per Calculation Period. There must be a Spread specified for each Calculation Period, regardless of whether the Spread changes or remains the same between periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommoditySpreadSchedule", builder=CommoditySpreadSchedule.CommoditySpreadScheduleBuilderImpl.class, version="${project.version}")
public interface CommoditySpreadSchedule extends RosettaModelObject {

	CommoditySpreadScheduleMeta metaData = new CommoditySpreadScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The spread per Calculation Period. There must be a spread step specified for each Calculation Period, regardless of whether the spread changes or remains the same between periods.
	 */
	List<? extends CommoditySpread> getSpreadStep();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();

	/*********************** Build Methods  ***********************/
	CommoditySpreadSchedule build();
	
	CommoditySpreadSchedule.CommoditySpreadScheduleBuilder toBuilder();
	
	static CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder() {
		return new CommoditySpreadSchedule.CommoditySpreadScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySpreadSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySpreadSchedule> getType() {
		return CommoditySpreadSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("spreadStep"), processor, CommoditySpread.class, getSpreadStep());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySpreadScheduleBuilder extends CommoditySpreadSchedule, RosettaModelObjectBuilder {
		CommoditySpread.CommoditySpreadBuilder getOrCreateSpreadStep(int _index);
		List<? extends CommoditySpread.CommoditySpreadBuilder> getSpreadStep();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread spreadStep0);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread spreadStep1, int _idx);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(List<? extends CommoditySpread> spreadStep2);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setSpreadStep(List<? extends CommoditySpread> spreadStep3);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("spreadStep"), processor, CommoditySpread.CommoditySpreadBuilder.class, getSpreadStep());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
		}
		

		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySpreadSchedule  ***********************/
	class CommoditySpreadScheduleImpl implements CommoditySpreadSchedule {
		private final List<? extends CommoditySpread> spreadStep;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		
		protected CommoditySpreadScheduleImpl(CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder) {
			this.spreadStep = ofNullable(builder.getSpreadStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spreadStep")
		public List<? extends CommoditySpread> getSpreadStep() {
			return spreadStep;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommoditySpreadSchedule build() {
			return this;
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder toBuilder() {
			CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder) {
			ofNullable(getSpreadStep()).ifPresent(builder::setSpreadStep);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySpreadSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(spreadStep, _that.getSpreadStep())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spreadStep != null ? spreadStep.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpreadSchedule {" +
				"spreadStep=" + this.spreadStep + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySpreadSchedule  ***********************/
	class CommoditySpreadScheduleBuilderImpl implements CommoditySpreadSchedule.CommoditySpreadScheduleBuilder {
	
		protected List<CommoditySpread.CommoditySpreadBuilder> spreadStep = new ArrayList<>();
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
	
		public CommoditySpreadScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("spreadStep")
		public List<? extends CommoditySpread.CommoditySpreadBuilder> getSpreadStep() {
			return spreadStep;
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder getOrCreateSpreadStep(int _index) {
		
			if (spreadStep==null) {
				this.spreadStep = new ArrayList<>();
			}
			CommoditySpread.CommoditySpreadBuilder result;
			return getIndex(spreadStep, _index, () -> {
						CommoditySpread.CommoditySpreadBuilder newSpreadStep = CommoditySpread.builder();
						return newSpreadStep;
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
		@RosettaAttribute("spreadStep")
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread spreadStep) {
			if (spreadStep!=null) this.spreadStep.add(spreadStep.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread spreadStep, int _idx) {
			getIndex(this.spreadStep, _idx, () -> spreadStep.toBuilder());
			return this;
		}
		@Override 
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(List<? extends CommoditySpread> spreadSteps) {
			if (spreadSteps != null) {
				for (CommoditySpread toAdd : spreadSteps) {
					this.spreadStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setSpreadStep(List<? extends CommoditySpread> spreadSteps) {
			if (spreadSteps == null)  {
				this.spreadStep = new ArrayList<>();
			}
			else {
				this.spreadStep = spreadSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySpreadSchedule build() {
			return new CommoditySpreadSchedule.CommoditySpreadScheduleImpl(this);
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder prune() {
			spreadStep = spreadStep.stream().filter(b->b!=null).<CommoditySpread.CommoditySpreadBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpreadStep()!=null && getSpreadStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySpreadSchedule.CommoditySpreadScheduleBuilder o = (CommoditySpreadSchedule.CommoditySpreadScheduleBuilder) other;
			
			merger.mergeRosetta(getSpreadStep(), o.getSpreadStep(), this::getOrCreateSpreadStep);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySpreadSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(spreadStep, _that.getSpreadStep())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spreadStep != null ? spreadStep.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpreadScheduleBuilder {" +
				"spreadStep=" + this.spreadStep + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}
}
