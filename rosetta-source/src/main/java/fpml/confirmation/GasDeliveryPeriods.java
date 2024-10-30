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
import fpml.confirmation.GasDeliveryPeriods;
import fpml.confirmation.GasDeliveryPeriods.GasDeliveryPeriodsBuilder;
import fpml.confirmation.GasDeliveryPeriods.GasDeliveryPeriodsBuilderImpl;
import fpml.confirmation.GasDeliveryPeriods.GasDeliveryPeriodsImpl;
import fpml.confirmation.GasDeliveryPeriodsSequence;
import fpml.confirmation.meta.GasDeliveryPeriodsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Delivery Periods for a physically settled gas trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GasDeliveryPeriods", builder=GasDeliveryPeriods.GasDeliveryPeriodsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GasDeliveryPeriods extends CommodityDeliveryPeriods {

	GasDeliveryPeriodsMeta metaData = new GasDeliveryPeriodsMeta();

	/*********************** Getter Methods  ***********************/
	GasDeliveryPeriodsSequence getGasDeliveryPeriodsSequence();

	/*********************** Build Methods  ***********************/
	GasDeliveryPeriods build();
	
	GasDeliveryPeriods.GasDeliveryPeriodsBuilder toBuilder();
	
	static GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder() {
		return new GasDeliveryPeriods.GasDeliveryPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDeliveryPeriods> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasDeliveryPeriods> getType() {
		return GasDeliveryPeriods.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periods"), processor, AdjustableDates.class, getPeriods());
		processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getPeriodsSchedule());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("gasDeliveryPeriodsSequence"), processor, GasDeliveryPeriodsSequence.class, getGasDeliveryPeriodsSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliveryPeriodsBuilder extends GasDeliveryPeriods, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder {
		GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder getOrCreateGasDeliveryPeriodsSequence();
		GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder getGasDeliveryPeriodsSequence();
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriods(AdjustableDates periods);
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule periodsSchedule);
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setId(String id);
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setGasDeliveryPeriodsSequence(GasDeliveryPeriodsSequence gasDeliveryPeriodsSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getPeriods());
			processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getPeriodsSchedule());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("gasDeliveryPeriodsSequence"), processor, GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder.class, getGasDeliveryPeriodsSequence());
		}
		

		GasDeliveryPeriods.GasDeliveryPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of GasDeliveryPeriods  ***********************/
	class GasDeliveryPeriodsImpl extends CommodityDeliveryPeriods.CommodityDeliveryPeriodsImpl implements GasDeliveryPeriods {
		private final GasDeliveryPeriodsSequence gasDeliveryPeriodsSequence;
		
		protected GasDeliveryPeriodsImpl(GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder) {
			super(builder);
			this.gasDeliveryPeriodsSequence = ofNullable(builder.getGasDeliveryPeriodsSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("gasDeliveryPeriodsSequence")
		public GasDeliveryPeriodsSequence getGasDeliveryPeriodsSequence() {
			return gasDeliveryPeriodsSequence;
		}
		
		@Override
		public GasDeliveryPeriods build() {
			return this;
		}
		
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder toBuilder() {
			GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getGasDeliveryPeriodsSequence()).ifPresent(builder::setGasDeliveryPeriodsSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(gasDeliveryPeriodsSequence, _that.getGasDeliveryPeriodsSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (gasDeliveryPeriodsSequence != null ? gasDeliveryPeriodsSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryPeriods {" +
				"gasDeliveryPeriodsSequence=" + this.gasDeliveryPeriodsSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GasDeliveryPeriods  ***********************/
	class GasDeliveryPeriodsBuilderImpl extends CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl  implements GasDeliveryPeriods.GasDeliveryPeriodsBuilder {
	
		protected GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder gasDeliveryPeriodsSequence;
	
		public GasDeliveryPeriodsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("gasDeliveryPeriodsSequence")
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder getGasDeliveryPeriodsSequence() {
			return gasDeliveryPeriodsSequence;
		}
		
		@Override
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder getOrCreateGasDeliveryPeriodsSequence() {
			GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder result;
			if (gasDeliveryPeriodsSequence!=null) {
				result = gasDeliveryPeriodsSequence;
			}
			else {
				result = gasDeliveryPeriodsSequence = GasDeliveryPeriodsSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periods")
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriods(AdjustableDates periods) {
			this.periods = periods==null?null:periods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodsSchedule")
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule periodsSchedule) {
			this.periodsSchedule = periodsSchedule==null?null:periodsSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("gasDeliveryPeriodsSequence")
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setGasDeliveryPeriodsSequence(GasDeliveryPeriodsSequence gasDeliveryPeriodsSequence) {
			this.gasDeliveryPeriodsSequence = gasDeliveryPeriodsSequence==null?null:gasDeliveryPeriodsSequence.toBuilder();
			return this;
		}
		
		@Override
		public GasDeliveryPeriods build() {
			return new GasDeliveryPeriods.GasDeliveryPeriodsImpl(this);
		}
		
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder prune() {
			super.prune();
			if (gasDeliveryPeriodsSequence!=null && !gasDeliveryPeriodsSequence.prune().hasData()) gasDeliveryPeriodsSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getGasDeliveryPeriodsSequence()!=null && getGasDeliveryPeriodsSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			GasDeliveryPeriods.GasDeliveryPeriodsBuilder o = (GasDeliveryPeriods.GasDeliveryPeriodsBuilder) other;
			
			merger.mergeRosetta(getGasDeliveryPeriodsSequence(), o.getGasDeliveryPeriodsSequence(), this::setGasDeliveryPeriodsSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(gasDeliveryPeriodsSequence, _that.getGasDeliveryPeriodsSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (gasDeliveryPeriodsSequence != null ? gasDeliveryPeriodsSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryPeriodsBuilder {" +
				"gasDeliveryPeriodsSequence=" + this.gasDeliveryPeriodsSequence +
			'}' + " " + super.toString();
		}
	}
}
