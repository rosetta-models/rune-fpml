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
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleImpl;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.ElectricityPhysicalDeliveryQuantityScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ElectricityPhysicalDeliveryQuantitySchedule", builder=ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ElectricityPhysicalDeliveryQuantitySchedule extends CommodityPhysicalQuantitySchedule {

	ElectricityPhysicalDeliveryQuantityScheduleMeta metaData = new ElectricityPhysicalDeliveryQuantityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the range(s) of Settlement Periods to which this quantity applies.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	ElectricityPhysicalDeliveryQuantitySchedule build();
	
	ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder toBuilder();
	
	static ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder() {
		return new ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityPhysicalDeliveryQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityPhysicalDeliveryQuantitySchedule> getType() {
		return ElectricityPhysicalDeliveryQuantitySchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.class, getQuantityStep());
		processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.class, getCommodityDeliveryPeriodsPointerModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityPhysicalDeliveryQuantityScheduleBuilder extends ElectricityPhysicalDeliveryQuantitySchedule, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep0);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep1, int _idx);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep2);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep3);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setId(String id);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getQuantityStep());
			processRosetta(path.newSubPath("commodityDeliveryPeriodsPointerModel"), processor, CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder.class, getCommodityDeliveryPeriodsPointerModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityPhysicalDeliveryQuantitySchedule  ***********************/
	class ElectricityPhysicalDeliveryQuantityScheduleImpl extends CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleImpl implements ElectricityPhysicalDeliveryQuantitySchedule {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected ElectricityPhysicalDeliveryQuantityScheduleImpl(ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder) {
			super(builder);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule build() {
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder toBuilder() {
			ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalDeliveryQuantitySchedule {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ElectricityPhysicalDeliveryQuantitySchedule  ***********************/
	class ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl extends CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl  implements ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder {
	
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index) {
		
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			SettlementPeriodsReference.SettlementPeriodsReferenceBuilder result;
			return getIndex(settlementPeriodsReference, _index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@Override
		@RosettaAttribute("quantityStep")
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep) {
			if (quantityStep!=null) this.quantityStep.add(quantityStep.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep, int _idx) {
			getIndex(this.quantityStep, _idx, () -> quantityStep.toBuilder());
			return this;
		}
		@Override 
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
			if (quantitySteps != null) {
				for (CommodityNotionalQuantity toAdd : quantitySteps) {
					this.quantityStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
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
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setCommodityDeliveryPeriodsPointerModel(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
			this.commodityDeliveryPeriodsPointerModel = commodityDeliveryPeriodsPointerModel==null?null:commodityDeliveryPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null)  {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule build() {
			return new ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleImpl(this);
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder prune() {
			super.prune();
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder o = (ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalDeliveryQuantityScheduleBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}
}
