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
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.ElectricityDelivery;
import fpml.confirmation.ElectricityPhysicalLeg;
import fpml.confirmation.ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder;
import fpml.confirmation.ElectricityPhysicalLeg.ElectricityPhysicalLegBuilderImpl;
import fpml.confirmation.ElectricityPhysicalLeg.ElectricityPhysicalLegImpl;
import fpml.confirmation.ElectricityPhysicalQuantity;
import fpml.confirmation.ElectricityProduct;
import fpml.confirmation.LoadTypeEnum;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalSwapLeg;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilder;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilderImpl;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegImpl;
import fpml.confirmation.SettlementPeriods;
import fpml.confirmation.SettlementPeriodsSchedule;
import fpml.confirmation.meta.ElectricityPhysicalLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Physically settled electricity leg. Physically settled leg of a physically settled electricity transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityPhysicalLeg", builder=ElectricityPhysicalLeg.ElectricityPhysicalLegBuilderImpl.class, version="${project.version}")
public interface ElectricityPhysicalLeg extends PhysicalSwapLeg {

	ElectricityPhysicalLegMeta metaData = new ElectricityPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The different options for specifying the Delivery or Supply Periods. Unless the quantity or price is to vary periodically during the trade or physical delivery occurs on a periodic basis, periodsSchedule should be used and set to 1T.
	 */
	CommodityDeliveryPeriods getDeliveryPeriods();
	/**
	 * The specification of the Settlement Periods in which the electricity will be delivered. The Settlement Periods will apply from and including the Effective Date up to and including the Termination Date. If more than one settlementPeriods element is present this indicates multiple ranges of Settlement Periods apply to the entire trade - for example off-peak weekdays and all day weekends. Settlement Period ranges should not overlap.
	 */
	List<? extends SettlementPeriods> getSettlementPeriods();
	/**
	 * The specification of the Settlement Periods in which the electricity will be delivered for a &quot;shaped&quot; trade i.e. where different Settlement Period ranges will apply to different periods of the trade.
	 */
	SettlementPeriodsSchedule getSettlementPeriodsSchedule();
	/**
	 * LoadType is a summary of the full description of the settlement periods with respect to the region. Used for describing Electricity delivery schedules (e.g. Base, Peak, Off-Peak, Custom).
	 */
	LoadTypeEnum getLoadType();
	/**
	 * The specification of the electricity to be delivered.
	 */
	ElectricityProduct getElectricity();
	/**
	 * The physical delivery conditions for the transaction.
	 */
	ElectricityDelivery getDeliveryConditions();
	/**
	 * The different options for specifying the quantity.
	 */
	ElectricityPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	ElectricityPhysicalLeg build();
	
	ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder toBuilder();
	
	static ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder() {
		return new ElectricityPhysicalLeg.ElectricityPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityPhysicalLeg> getType() {
		return ElectricityPhysicalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.class, getSettlementPeriods());
		processRosetta(path.newSubPath("settlementPeriodsSchedule"), processor, SettlementPeriodsSchedule.class, getSettlementPeriodsSchedule());
		processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
		processRosetta(path.newSubPath("electricity"), processor, ElectricityProduct.class, getElectricity());
		processRosetta(path.newSubPath("deliveryConditions"), processor, ElectricityDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, ElectricityPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityPhysicalLegBuilder extends ElectricityPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int _index);
		List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods();
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getOrCreateSettlementPeriodsSchedule();
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getSettlementPeriodsSchedule();
		ElectricityProduct.ElectricityProductBuilder getOrCreateElectricity();
		ElectricityProduct.ElectricityProductBuilder getElectricity();
		ElectricityDelivery.ElectricityDeliveryBuilder getOrCreateDeliveryConditions();
		ElectricityDelivery.ElectricityDeliveryBuilder getDeliveryConditions();
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getDeliveryQuantity();
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setId(String id);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods settlementPeriods0);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods settlementPeriods1, int _idx);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods2);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods3);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriodsSchedule(SettlementPeriodsSchedule settlementPeriodsSchedule);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setLoadType(LoadTypeEnum loadType);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setElectricity(ElectricityProduct electricity);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryConditions(ElectricityDelivery deliveryConditions);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryQuantity(ElectricityPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.SettlementPeriodsBuilder.class, getSettlementPeriods());
			processRosetta(path.newSubPath("settlementPeriodsSchedule"), processor, SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder.class, getSettlementPeriodsSchedule());
			processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
			processRosetta(path.newSubPath("electricity"), processor, ElectricityProduct.ElectricityProductBuilder.class, getElectricity());
			processRosetta(path.newSubPath("deliveryConditions"), processor, ElectricityDelivery.ElectricityDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityPhysicalLeg  ***********************/
	class ElectricityPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements ElectricityPhysicalLeg {
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final List<? extends SettlementPeriods> settlementPeriods;
		private final SettlementPeriodsSchedule settlementPeriodsSchedule;
		private final LoadTypeEnum loadType;
		private final ElectricityProduct electricity;
		private final ElectricityDelivery deliveryConditions;
		private final ElectricityPhysicalQuantity deliveryQuantity;
		
		protected ElectricityPhysicalLegImpl(ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsSchedule = ofNullable(builder.getSettlementPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.loadType = builder.getLoadType();
			this.electricity = ofNullable(builder.getElectricity()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.deliveryQuantity = ofNullable(builder.getDeliveryQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public List<? extends SettlementPeriods> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsSchedule")
		public SettlementPeriodsSchedule getSettlementPeriodsSchedule() {
			return settlementPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("electricity")
		public ElectricityProduct getElectricity() {
			return electricity;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public ElectricityDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		public ElectricityPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public ElectricityPhysicalLeg build() {
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder toBuilder() {
			ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getSettlementPeriodsSchedule()).ifPresent(builder::setSettlementPeriodsSchedule);
			ofNullable(getLoadType()).ifPresent(builder::setLoadType);
			ofNullable(getElectricity()).ifPresent(builder::setElectricity);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(settlementPeriodsSchedule, _that.getSettlementPeriodsSchedule())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(electricity, _that.getElectricity())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsSchedule != null ? settlementPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (electricity != null ? electricity.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsSchedule=" + this.settlementPeriodsSchedule + ", " +
				"loadType=" + this.loadType + ", " +
				"electricity=" + this.electricity + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ElectricityPhysicalLeg  ***********************/
	class ElectricityPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl  implements ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder {
	
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected List<SettlementPeriods.SettlementPeriodsBuilder> settlementPeriods = new ArrayList<>();
		protected SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder settlementPeriodsSchedule;
		protected LoadTypeEnum loadType;
		protected ElectricityProduct.ElectricityProductBuilder electricity;
		protected ElectricityDelivery.ElectricityDeliveryBuilder deliveryConditions;
		protected ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder deliveryQuantity;
	
		public ElectricityPhysicalLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods() {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder result;
			if (deliveryPeriods!=null) {
				result = deliveryPeriods;
			}
			else {
				result = deliveryPeriods = CommodityDeliveryPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int _index) {
		
			if (settlementPeriods==null) {
				this.settlementPeriods = new ArrayList<>();
			}
			SettlementPeriods.SettlementPeriodsBuilder result;
			return getIndex(settlementPeriods, _index, () -> {
						SettlementPeriods.SettlementPeriodsBuilder newSettlementPeriods = SettlementPeriods.builder();
						return newSettlementPeriods;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsSchedule")
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getSettlementPeriodsSchedule() {
			return settlementPeriodsSchedule;
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getOrCreateSettlementPeriodsSchedule() {
			SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder result;
			if (settlementPeriodsSchedule!=null) {
				result = settlementPeriodsSchedule;
			}
			else {
				result = settlementPeriodsSchedule = SettlementPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("electricity")
		public ElectricityProduct.ElectricityProductBuilder getElectricity() {
			return electricity;
		}
		
		@Override
		public ElectricityProduct.ElectricityProductBuilder getOrCreateElectricity() {
			ElectricityProduct.ElectricityProductBuilder result;
			if (electricity!=null) {
				result = electricity;
			}
			else {
				result = electricity = ElectricityProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		public ElectricityDelivery.ElectricityDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder getOrCreateDeliveryConditions() {
			ElectricityDelivery.ElectricityDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = ElectricityDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getOrCreateDeliveryQuantity() {
			ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder result;
			if (deliveryQuantity!=null) {
				result = deliveryQuantity;
			}
			else {
				result = deliveryQuantity = ElectricityPhysicalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPeriods")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods) {
			this.deliveryPeriods = deliveryPeriods==null?null:deliveryPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriods")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods settlementPeriods) {
			if (settlementPeriods!=null) this.settlementPeriods.add(settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods settlementPeriods, int _idx) {
			getIndex(this.settlementPeriods, _idx, () -> settlementPeriods.toBuilder());
			return this;
		}
		@Override 
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (SettlementPeriods toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss == null)  {
				this.settlementPeriods = new ArrayList<>();
			}
			else {
				this.settlementPeriods = settlementPeriodss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsSchedule")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriodsSchedule(SettlementPeriodsSchedule settlementPeriodsSchedule) {
			this.settlementPeriodsSchedule = settlementPeriodsSchedule==null?null:settlementPeriodsSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loadType")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setLoadType(LoadTypeEnum loadType) {
			this.loadType = loadType==null?null:loadType;
			return this;
		}
		@Override
		@RosettaAttribute("electricity")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setElectricity(ElectricityProduct electricity) {
			this.electricity = electricity==null?null:electricity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryConditions")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryConditions(ElectricityDelivery deliveryConditions) {
			this.deliveryConditions = deliveryConditions==null?null:deliveryConditions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryQuantity")
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryQuantity(ElectricityPhysicalQuantity deliveryQuantity) {
			this.deliveryQuantity = deliveryQuantity==null?null:deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg build() {
			return new ElectricityPhysicalLeg.ElectricityPhysicalLegImpl(this);
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<SettlementPeriods.SettlementPeriodsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementPeriodsSchedule!=null && !settlementPeriodsSchedule.prune().hasData()) settlementPeriodsSchedule = null;
			if (electricity!=null && !electricity.prune().hasData()) electricity = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsSchedule()!=null && getSettlementPeriodsSchedule().hasData()) return true;
			if (getLoadType()!=null) return true;
			if (getElectricity()!=null && getElectricity().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder o = (ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getSettlementPeriodsSchedule(), o.getSettlementPeriodsSchedule(), this::setSettlementPeriodsSchedule);
			merger.mergeRosetta(getElectricity(), o.getElectricity(), this::setElectricity);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			merger.mergeBasic(getLoadType(), o.getLoadType(), this::setLoadType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(settlementPeriodsSchedule, _that.getSettlementPeriodsSchedule())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(electricity, _that.getElectricity())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsSchedule != null ? settlementPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (electricity != null ? electricity.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsSchedule=" + this.settlementPeriodsSchedule + ", " +
				"loadType=" + this.loadType + ", " +
				"electricity=" + this.electricity + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
