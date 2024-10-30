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
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder;
import fpml.confirmation.CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilderImpl;
import fpml.confirmation.CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelImpl;
import fpml.confirmation.FloatingStrikePrice;
import fpml.confirmation.meta.CommodityFloatingStrikePriceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the average strike price per unit. These options are to specify a single average strike price per unit or to specify a schedule of average strike prices.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityFloatingStrikePriceModel", builder=CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityFloatingStrikePriceModel extends RosettaModelObject {

	CommodityFloatingStrikePriceModelMeta metaData = new CommodityFloatingStrikePriceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency amount of the strike price per unit.
	 */
	FloatingStrikePrice getFloatingStrikePricePerUnit();
	CommodityCalculationPeriodsSchedule getFloatingStrikePricePerUnitSchedule();

	/*********************** Build Methods  ***********************/
	CommodityFloatingStrikePriceModel build();
	
	CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder toBuilder();
	
	static CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder builder() {
		return new CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFloatingStrikePriceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFloatingStrikePriceModel> getType() {
		return CommodityFloatingStrikePriceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingStrikePricePerUnit"), processor, FloatingStrikePrice.class, getFloatingStrikePricePerUnit());
		processRosetta(path.newSubPath("floatingStrikePricePerUnitSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getFloatingStrikePricePerUnitSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFloatingStrikePriceModelBuilder extends CommodityFloatingStrikePriceModel, RosettaModelObjectBuilder {
		FloatingStrikePrice.FloatingStrikePriceBuilder getOrCreateFloatingStrikePricePerUnit();
		FloatingStrikePrice.FloatingStrikePriceBuilder getFloatingStrikePricePerUnit();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateFloatingStrikePricePerUnitSchedule();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getFloatingStrikePricePerUnitSchedule();
		CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder setFloatingStrikePricePerUnit(FloatingStrikePrice floatingStrikePricePerUnit);
		CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder setFloatingStrikePricePerUnitSchedule(CommodityCalculationPeriodsSchedule floatingStrikePricePerUnitSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingStrikePricePerUnit"), processor, FloatingStrikePrice.FloatingStrikePriceBuilder.class, getFloatingStrikePricePerUnit());
			processRosetta(path.newSubPath("floatingStrikePricePerUnitSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getFloatingStrikePricePerUnitSchedule());
		}
		

		CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFloatingStrikePriceModel  ***********************/
	class CommodityFloatingStrikePriceModelImpl implements CommodityFloatingStrikePriceModel {
		private final FloatingStrikePrice floatingStrikePricePerUnit;
		private final CommodityCalculationPeriodsSchedule floatingStrikePricePerUnitSchedule;
		
		protected CommodityFloatingStrikePriceModelImpl(CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder builder) {
			this.floatingStrikePricePerUnit = ofNullable(builder.getFloatingStrikePricePerUnit()).map(f->f.build()).orElse(null);
			this.floatingStrikePricePerUnitSchedule = ofNullable(builder.getFloatingStrikePricePerUnitSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnit")
		public FloatingStrikePrice getFloatingStrikePricePerUnit() {
			return floatingStrikePricePerUnit;
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnitSchedule")
		public CommodityCalculationPeriodsSchedule getFloatingStrikePricePerUnitSchedule() {
			return floatingStrikePricePerUnitSchedule;
		}
		
		@Override
		public CommodityFloatingStrikePriceModel build() {
			return this;
		}
		
		@Override
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder toBuilder() {
			CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder builder) {
			ofNullable(getFloatingStrikePricePerUnit()).ifPresent(builder::setFloatingStrikePricePerUnit);
			ofNullable(getFloatingStrikePricePerUnitSchedule()).ifPresent(builder::setFloatingStrikePricePerUnitSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFloatingStrikePriceModel _that = getType().cast(o);
		
			if (!Objects.equals(floatingStrikePricePerUnit, _that.getFloatingStrikePricePerUnit())) return false;
			if (!Objects.equals(floatingStrikePricePerUnitSchedule, _that.getFloatingStrikePricePerUnitSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingStrikePricePerUnit != null ? floatingStrikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnitSchedule != null ? floatingStrikePricePerUnitSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFloatingStrikePriceModel {" +
				"floatingStrikePricePerUnit=" + this.floatingStrikePricePerUnit + ", " +
				"floatingStrikePricePerUnitSchedule=" + this.floatingStrikePricePerUnitSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFloatingStrikePriceModel  ***********************/
	class CommodityFloatingStrikePriceModelBuilderImpl implements CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder {
	
		protected FloatingStrikePrice.FloatingStrikePriceBuilder floatingStrikePricePerUnit;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder floatingStrikePricePerUnitSchedule;
	
		public CommodityFloatingStrikePriceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingStrikePricePerUnit")
		public FloatingStrikePrice.FloatingStrikePriceBuilder getFloatingStrikePricePerUnit() {
			return floatingStrikePricePerUnit;
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder getOrCreateFloatingStrikePricePerUnit() {
			FloatingStrikePrice.FloatingStrikePriceBuilder result;
			if (floatingStrikePricePerUnit!=null) {
				result = floatingStrikePricePerUnit;
			}
			else {
				result = floatingStrikePricePerUnit = FloatingStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnitSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getFloatingStrikePricePerUnitSchedule() {
			return floatingStrikePricePerUnitSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateFloatingStrikePricePerUnitSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (floatingStrikePricePerUnitSchedule!=null) {
				result = floatingStrikePricePerUnitSchedule;
			}
			else {
				result = floatingStrikePricePerUnitSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnit")
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder setFloatingStrikePricePerUnit(FloatingStrikePrice floatingStrikePricePerUnit) {
			this.floatingStrikePricePerUnit = floatingStrikePricePerUnit==null?null:floatingStrikePricePerUnit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingStrikePricePerUnitSchedule")
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder setFloatingStrikePricePerUnitSchedule(CommodityCalculationPeriodsSchedule floatingStrikePricePerUnitSchedule) {
			this.floatingStrikePricePerUnitSchedule = floatingStrikePricePerUnitSchedule==null?null:floatingStrikePricePerUnitSchedule.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFloatingStrikePriceModel build() {
			return new CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelImpl(this);
		}
		
		@Override
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder prune() {
			if (floatingStrikePricePerUnit!=null && !floatingStrikePricePerUnit.prune().hasData()) floatingStrikePricePerUnit = null;
			if (floatingStrikePricePerUnitSchedule!=null && !floatingStrikePricePerUnitSchedule.prune().hasData()) floatingStrikePricePerUnitSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingStrikePricePerUnit()!=null && getFloatingStrikePricePerUnit().hasData()) return true;
			if (getFloatingStrikePricePerUnitSchedule()!=null && getFloatingStrikePricePerUnitSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder o = (CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder) other;
			
			merger.mergeRosetta(getFloatingStrikePricePerUnit(), o.getFloatingStrikePricePerUnit(), this::setFloatingStrikePricePerUnit);
			merger.mergeRosetta(getFloatingStrikePricePerUnitSchedule(), o.getFloatingStrikePricePerUnitSchedule(), this::setFloatingStrikePricePerUnitSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFloatingStrikePriceModel _that = getType().cast(o);
		
			if (!Objects.equals(floatingStrikePricePerUnit, _that.getFloatingStrikePricePerUnit())) return false;
			if (!Objects.equals(floatingStrikePricePerUnitSchedule, _that.getFloatingStrikePricePerUnitSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingStrikePricePerUnit != null ? floatingStrikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnitSchedule != null ? floatingStrikePricePerUnitSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFloatingStrikePriceModelBuilder {" +
				"floatingStrikePricePerUnit=" + this.floatingStrikePricePerUnit + ", " +
				"floatingStrikePricePerUnitSchedule=" + this.floatingStrikePricePerUnitSchedule +
			'}';
		}
	}
}
