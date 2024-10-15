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
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityNotionalQuantitySchedule;
import fpml.confirmation.CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder;
import fpml.confirmation.CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilderImpl;
import fpml.confirmation.CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleImpl;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule;
import fpml.confirmation.meta.CommodityNotionalQuantityScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The Notional Quantity per Calculation Period. There must be a Notional Quantity step specified for each Calculation Period, regardless of whether the Notional Quantity changes or remains the same between periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityNotionalQuantitySchedule", builder=CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilderImpl.class, version="${project.version}")
public interface CommodityNotionalQuantitySchedule extends RosettaModelObject {

	CommodityNotionalQuantityScheduleMeta metaData = new CommodityNotionalQuantityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Notional Quantity per Calculation Period. There must be a Notional Quantity specified for each Calculation Period, regardless of whether the quantity changes or remains the same between periods.
	 */
	List<? extends CommodityNotionalQuantity> getNotionalStep();
	/**
	 * For an electricity transaction, the Notional Quantity schedule for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 */
	List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> getSettlementPeriodsNotionalQuantitySchedule();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityNotionalQuantitySchedule build();
	
	CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder toBuilder();
	
	static CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder() {
		return new CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityNotionalQuantitySchedule> getType() {
		return CommodityNotionalQuantitySchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalStep"), processor, CommodityNotionalQuantity.class, getNotionalStep());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantitySchedule"), processor, CommoditySettlementPeriodsNotionalQuantitySchedule.class, getSettlementPeriodsNotionalQuantitySchedule());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalQuantityScheduleBuilder extends CommodityNotionalQuantitySchedule, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalStep(int _index);
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getNotionalStep();
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder getOrCreateSettlementPeriodsNotionalQuantitySchedule(int _index);
		List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder> getSettlementPeriodsNotionalQuantitySchedule();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity notionalStep0);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity notionalStep1, int _idx);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(List<? extends CommodityNotionalQuantity> notionalStep2);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setNotionalStep(List<? extends CommodityNotionalQuantity> notionalStep3);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule settlementPeriodsNotionalQuantitySchedule0);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule settlementPeriodsNotionalQuantitySchedule1, int _idx);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedule2);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedule3);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalStep"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalStep());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantitySchedule"), processor, CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder.class, getSettlementPeriodsNotionalQuantitySchedule());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalQuantitySchedule  ***********************/
	class CommodityNotionalQuantityScheduleImpl implements CommodityNotionalQuantitySchedule {
		private final List<? extends CommodityNotionalQuantity> notionalStep;
		private final List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedule;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		private final String id;
		
		protected CommodityNotionalQuantityScheduleImpl(CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder) {
			this.notionalStep = ofNullable(builder.getNotionalStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsNotionalQuantitySchedule = ofNullable(builder.getSettlementPeriodsNotionalQuantitySchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("notionalStep")
		public List<? extends CommodityNotionalQuantity> getNotionalStep() {
			return notionalStep;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantitySchedule")
		public List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> getSettlementPeriodsNotionalQuantitySchedule() {
			return settlementPeriodsNotionalQuantitySchedule;
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
		public CommodityNotionalQuantitySchedule build() {
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder toBuilder() {
			CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder) {
			ofNullable(getNotionalStep()).ifPresent(builder::setNotionalStep);
			ofNullable(getSettlementPeriodsNotionalQuantitySchedule()).ifPresent(builder::setSettlementPeriodsNotionalQuantitySchedule);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalStep, _that.getNotionalStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantitySchedule, _that.getSettlementPeriodsNotionalQuantitySchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalStep != null ? notionalStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantitySchedule != null ? settlementPeriodsNotionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantitySchedule {" +
				"notionalStep=" + this.notionalStep + ", " +
				"settlementPeriodsNotionalQuantitySchedule=" + this.settlementPeriodsNotionalQuantitySchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityNotionalQuantitySchedule  ***********************/
	class CommodityNotionalQuantityScheduleBuilderImpl implements CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder {
	
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> notionalStep = new ArrayList<>();
		protected List<CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder> settlementPeriodsNotionalQuantitySchedule = new ArrayList<>();
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
		protected String id;
	
		public CommodityNotionalQuantityScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalStep")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getNotionalStep() {
			return notionalStep;
		}
		
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalStep(int _index) {
		
			if (notionalStep==null) {
				this.notionalStep = new ArrayList<>();
			}
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			return getIndex(notionalStep, _index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newNotionalStep = CommodityNotionalQuantity.builder();
						return newNotionalStep;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantitySchedule")
		public List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder> getSettlementPeriodsNotionalQuantitySchedule() {
			return settlementPeriodsNotionalQuantitySchedule;
		}
		
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder getOrCreateSettlementPeriodsNotionalQuantitySchedule(int _index) {
		
			if (settlementPeriodsNotionalQuantitySchedule==null) {
				this.settlementPeriodsNotionalQuantitySchedule = new ArrayList<>();
			}
			CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder result;
			return getIndex(settlementPeriodsNotionalQuantitySchedule, _index, () -> {
						CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder newSettlementPeriodsNotionalQuantitySchedule = CommoditySettlementPeriodsNotionalQuantitySchedule.builder();
						return newSettlementPeriodsNotionalQuantitySchedule;
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
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity notionalStep) {
			if (notionalStep!=null) this.notionalStep.add(notionalStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity notionalStep, int _idx) {
			getIndex(this.notionalStep, _idx, () -> notionalStep.toBuilder());
			return this;
		}
		@Override 
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(List<? extends CommodityNotionalQuantity> notionalSteps) {
			if (notionalSteps != null) {
				for (CommodityNotionalQuantity toAdd : notionalSteps) {
					this.notionalStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("notionalStep")
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setNotionalStep(List<? extends CommodityNotionalQuantity> notionalSteps) {
			if (notionalSteps == null)  {
				this.notionalStep = new ArrayList<>();
			}
			else {
				this.notionalStep = notionalSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule settlementPeriodsNotionalQuantitySchedule) {
			if (settlementPeriodsNotionalQuantitySchedule!=null) this.settlementPeriodsNotionalQuantitySchedule.add(settlementPeriodsNotionalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule settlementPeriodsNotionalQuantitySchedule, int _idx) {
			getIndex(this.settlementPeriodsNotionalQuantitySchedule, _idx, () -> settlementPeriodsNotionalQuantitySchedule.toBuilder());
			return this;
		}
		@Override 
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedules) {
			if (settlementPeriodsNotionalQuantitySchedules != null) {
				for (CommoditySettlementPeriodsNotionalQuantitySchedule toAdd : settlementPeriodsNotionalQuantitySchedules) {
					this.settlementPeriodsNotionalQuantitySchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsNotionalQuantitySchedule")
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedules) {
			if (settlementPeriodsNotionalQuantitySchedules == null)  {
				this.settlementPeriodsNotionalQuantitySchedule = new ArrayList<>();
			}
			else {
				this.settlementPeriodsNotionalQuantitySchedule = settlementPeriodsNotionalQuantitySchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule build() {
			return new CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleImpl(this);
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder prune() {
			notionalStep = notionalStep.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsNotionalQuantitySchedule = settlementPeriodsNotionalQuantitySchedule.stream().filter(b->b!=null).<CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalStep()!=null && getNotionalStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsNotionalQuantitySchedule()!=null && getSettlementPeriodsNotionalQuantitySchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder o = (CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getNotionalStep(), o.getNotionalStep(), this::getOrCreateNotionalStep);
			merger.mergeRosetta(getSettlementPeriodsNotionalQuantitySchedule(), o.getSettlementPeriodsNotionalQuantitySchedule(), this::getOrCreateSettlementPeriodsNotionalQuantitySchedule);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalStep, _that.getNotionalStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantitySchedule, _that.getSettlementPeriodsNotionalQuantitySchedule())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalStep != null ? notionalStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantitySchedule != null ? settlementPeriodsNotionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityScheduleBuilder {" +
				"notionalStep=" + this.notionalStep + ", " +
				"settlementPeriodsNotionalQuantitySchedule=" + this.settlementPeriodsNotionalQuantitySchedule + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
