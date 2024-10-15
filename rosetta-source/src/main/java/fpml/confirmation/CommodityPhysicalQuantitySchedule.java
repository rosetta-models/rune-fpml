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
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityPhysicalQuantitySchedule;
import fpml.confirmation.CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder;
import fpml.confirmation.CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl;
import fpml.confirmation.CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleImpl;
import fpml.confirmation.meta.CommodityPhysicalQuantityScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The Quantity per Delivery Period. There must be a Quantity step specified for each Delivery Period, regardless of whether the Quantity changes or remains the same between periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPhysicalQuantitySchedule", builder=CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl.class, version="${project.version}")
public interface CommodityPhysicalQuantitySchedule extends RosettaModelObject {

	CommodityPhysicalQuantityScheduleMeta metaData = new CommodityPhysicalQuantityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The quantity per Calculation Period. There must be a quantity specified for each Calculation Period, regardless of whether the quantity changes or remains the same between periods.
	 */
	List<? extends CommodityNotionalQuantity> getQuantityStep();
	CommodityDeliveryPeriodsPointerModel getCommodityDeliveryPeriodsPointerModel();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalQuantitySchedule build();
	
	CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder toBuilder();
	
	static CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder() {
		return new CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalQuantitySchedule> getType() {
		return CommodityPhysicalQuantitySchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.class, getQuantityStep());
		processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.class, getCommodityDeliveryPeriodsPointerModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalQuantityScheduleBuilder extends CommodityPhysicalQuantitySchedule, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateQuantityStep(int _index);
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getQuantityStep();
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getOrCreateCommodityDeliveryPeriodsPointerModel();
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder getCommodityDeliveryPeriodsPointerModel();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep0);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep1, int _idx);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep2);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep3);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getQuantityStep());
			processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder.class, getCommodityDeliveryPeriodsPointerModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalQuantitySchedule  ***********************/
	class CommodityPhysicalQuantityScheduleImpl implements CommodityPhysicalQuantitySchedule {
		private final List<? extends CommodityNotionalQuantity> quantityStep;
		private final CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel;
		private final String id;
		
		protected CommodityPhysicalQuantityScheduleImpl(CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder) {
			this.quantityStep = ofNullable(builder.getQuantityStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityDeliveryPeriodsPointerModel = ofNullable(builder.getCommodityDeliveryPeriodsPointerModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("quantityStep")
		public List<? extends CommodityNotionalQuantity> getQuantityStep() {
			return quantityStep;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPeriodsPointerModel")
		public CommodityDeliveryPeriodsPointerModel getCommodityDeliveryPeriodsPointerModel() {
			return commodityDeliveryPeriodsPointerModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder toBuilder() {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder) {
			ofNullable(getQuantityStep()).ifPresent(builder::setQuantityStep);
			ofNullable(getCommodityDeliveryPeriodsPointerModel()).ifPresent(builder::setCommodityDeliveryPeriodsPointerModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantityStep, _that.getQuantityStep())) return false;
			if (!Objects.equals(commodityDeliveryPeriodsPointerModel, _that.getCommodityDeliveryPeriodsPointerModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityStep != null ? quantityStep.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPeriodsPointerModel != null ? commodityDeliveryPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantitySchedule {" +
				"quantityStep=" + this.quantityStep + ", " +
				"commodityDeliveryPeriodsPointerModel=" + this.commodityDeliveryPeriodsPointerModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalQuantitySchedule  ***********************/
	class CommodityPhysicalQuantityScheduleBuilderImpl implements CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder {
	
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> quantityStep = new ArrayList<>();
		protected CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder commodityDeliveryPeriodsPointerModel;
		protected String id;
	
		public CommodityPhysicalQuantityScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quantityStep")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getQuantityStep() {
			return quantityStep;
		}
		
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateQuantityStep(int _index) {
		
			if (quantityStep==null) {
				this.quantityStep = new ArrayList<>();
			}
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			return getIndex(quantityStep, _index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newQuantityStep = CommodityNotionalQuantity.builder();
						return newQuantityStep;
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
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep) {
			if (quantityStep!=null) this.quantityStep.add(quantityStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep, int _idx) {
			getIndex(this.quantityStep, _idx, () -> quantityStep.toBuilder());
			return this;
		}
		@Override 
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
			if (quantitySteps != null) {
				for (CommodityNotionalQuantity toAdd : quantitySteps) {
					this.quantityStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("quantityStep")
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
			if (quantitySteps == null)  {
				this.quantityStep = new ArrayList<>();
			}
			else {
				this.quantityStep = quantitySteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityDeliveryPeriodsPointerModel")
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
			this.commodityDeliveryPeriodsPointerModel = commodityDeliveryPeriodsPointerModel==null?null:commodityDeliveryPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule build() {
			return new CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleImpl(this);
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder prune() {
			quantityStep = quantityStep.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityDeliveryPeriodsPointerModel!=null && !commodityDeliveryPeriodsPointerModel.prune().hasData()) commodityDeliveryPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantityStep()!=null && getQuantityStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityDeliveryPeriodsPointerModel()!=null && getCommodityDeliveryPeriodsPointerModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder o = (CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getQuantityStep(), o.getQuantityStep(), this::getOrCreateQuantityStep);
			merger.mergeRosetta(getCommodityDeliveryPeriodsPointerModel(), o.getCommodityDeliveryPeriodsPointerModel(), this::setCommodityDeliveryPeriodsPointerModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantityStep, _that.getQuantityStep())) return false;
			if (!Objects.equals(commodityDeliveryPeriodsPointerModel, _that.getCommodityDeliveryPeriodsPointerModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityStep != null ? quantityStep.hashCode() : 0);
			_result = 31 * _result + (commodityDeliveryPeriodsPointerModel != null ? commodityDeliveryPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantityScheduleBuilder {" +
				"quantityStep=" + this.quantityStep + ", " +
				"commodityDeliveryPeriodsPointerModel=" + this.commodityDeliveryPeriodsPointerModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
