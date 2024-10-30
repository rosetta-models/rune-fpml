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
import fpml.confirmation.CommodityStrikePriceModel;
import fpml.confirmation.CommodityStrikePriceModel.CommodityStrikePriceModelBuilder;
import fpml.confirmation.CommodityStrikePriceModel.CommodityStrikePriceModelBuilderImpl;
import fpml.confirmation.CommodityStrikePriceModel.CommodityStrikePriceModelImpl;
import fpml.confirmation.CommodityStrikeSchedule;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.CommodityStrikePriceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Strike price per unit.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityStrikePriceModel", builder=CommodityStrikePriceModel.CommodityStrikePriceModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityStrikePriceModel extends RosettaModelObject {

	CommodityStrikePriceModelMeta metaData = new CommodityStrikePriceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency amount of the strike price per unit.
	 */
	NonNegativeMoney getStrikePricePerUnit();
	CommodityStrikeSchedule getStrikePricePerUnitSchedule();

	/*********************** Build Methods  ***********************/
	CommodityStrikePriceModel build();
	
	CommodityStrikePriceModel.CommodityStrikePriceModelBuilder toBuilder();
	
	static CommodityStrikePriceModel.CommodityStrikePriceModelBuilder builder() {
		return new CommodityStrikePriceModel.CommodityStrikePriceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityStrikePriceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityStrikePriceModel> getType() {
		return CommodityStrikePriceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("strikePricePerUnit"), processor, NonNegativeMoney.class, getStrikePricePerUnit());
		processRosetta(path.newSubPath("strikePricePerUnitSchedule"), processor, CommodityStrikeSchedule.class, getStrikePricePerUnitSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityStrikePriceModelBuilder extends CommodityStrikePriceModel, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnit();
		NonNegativeMoney.NonNegativeMoneyBuilder getStrikePricePerUnit();
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getOrCreateStrikePricePerUnitSchedule();
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getStrikePricePerUnitSchedule();
		CommodityStrikePriceModel.CommodityStrikePriceModelBuilder setStrikePricePerUnit(NonNegativeMoney strikePricePerUnit);
		CommodityStrikePriceModel.CommodityStrikePriceModelBuilder setStrikePricePerUnitSchedule(CommodityStrikeSchedule strikePricePerUnitSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("strikePricePerUnit"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getStrikePricePerUnit());
			processRosetta(path.newSubPath("strikePricePerUnitSchedule"), processor, CommodityStrikeSchedule.CommodityStrikeScheduleBuilder.class, getStrikePricePerUnitSchedule());
		}
		

		CommodityStrikePriceModel.CommodityStrikePriceModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityStrikePriceModel  ***********************/
	class CommodityStrikePriceModelImpl implements CommodityStrikePriceModel {
		private final NonNegativeMoney strikePricePerUnit;
		private final CommodityStrikeSchedule strikePricePerUnitSchedule;
		
		protected CommodityStrikePriceModelImpl(CommodityStrikePriceModel.CommodityStrikePriceModelBuilder builder) {
			this.strikePricePerUnit = ofNullable(builder.getStrikePricePerUnit()).map(f->f.build()).orElse(null);
			this.strikePricePerUnitSchedule = ofNullable(builder.getStrikePricePerUnitSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnit")
		public NonNegativeMoney getStrikePricePerUnit() {
			return strikePricePerUnit;
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnitSchedule")
		public CommodityStrikeSchedule getStrikePricePerUnitSchedule() {
			return strikePricePerUnitSchedule;
		}
		
		@Override
		public CommodityStrikePriceModel build() {
			return this;
		}
		
		@Override
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder toBuilder() {
			CommodityStrikePriceModel.CommodityStrikePriceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityStrikePriceModel.CommodityStrikePriceModelBuilder builder) {
			ofNullable(getStrikePricePerUnit()).ifPresent(builder::setStrikePricePerUnit);
			ofNullable(getStrikePricePerUnitSchedule()).ifPresent(builder::setStrikePricePerUnitSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStrikePriceModel _that = getType().cast(o);
		
			if (!Objects.equals(strikePricePerUnit, _that.getStrikePricePerUnit())) return false;
			if (!Objects.equals(strikePricePerUnitSchedule, _that.getStrikePricePerUnitSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePricePerUnit != null ? strikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnitSchedule != null ? strikePricePerUnitSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStrikePriceModel {" +
				"strikePricePerUnit=" + this.strikePricePerUnit + ", " +
				"strikePricePerUnitSchedule=" + this.strikePricePerUnitSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityStrikePriceModel  ***********************/
	class CommodityStrikePriceModelBuilderImpl implements CommodityStrikePriceModel.CommodityStrikePriceModelBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder strikePricePerUnit;
		protected CommodityStrikeSchedule.CommodityStrikeScheduleBuilder strikePricePerUnitSchedule;
	
		public CommodityStrikePriceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikePricePerUnit")
		public NonNegativeMoney.NonNegativeMoneyBuilder getStrikePricePerUnit() {
			return strikePricePerUnit;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnit() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (strikePricePerUnit!=null) {
				result = strikePricePerUnit;
			}
			else {
				result = strikePricePerUnit = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnitSchedule")
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getStrikePricePerUnitSchedule() {
			return strikePricePerUnitSchedule;
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getOrCreateStrikePricePerUnitSchedule() {
			CommodityStrikeSchedule.CommodityStrikeScheduleBuilder result;
			if (strikePricePerUnitSchedule!=null) {
				result = strikePricePerUnitSchedule;
			}
			else {
				result = strikePricePerUnitSchedule = CommodityStrikeSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnit")
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder setStrikePricePerUnit(NonNegativeMoney strikePricePerUnit) {
			this.strikePricePerUnit = strikePricePerUnit==null?null:strikePricePerUnit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikePricePerUnitSchedule")
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder setStrikePricePerUnitSchedule(CommodityStrikeSchedule strikePricePerUnitSchedule) {
			this.strikePricePerUnitSchedule = strikePricePerUnitSchedule==null?null:strikePricePerUnitSchedule.toBuilder();
			return this;
		}
		
		@Override
		public CommodityStrikePriceModel build() {
			return new CommodityStrikePriceModel.CommodityStrikePriceModelImpl(this);
		}
		
		@Override
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder prune() {
			if (strikePricePerUnit!=null && !strikePricePerUnit.prune().hasData()) strikePricePerUnit = null;
			if (strikePricePerUnitSchedule!=null && !strikePricePerUnitSchedule.prune().hasData()) strikePricePerUnitSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikePricePerUnit()!=null && getStrikePricePerUnit().hasData()) return true;
			if (getStrikePricePerUnitSchedule()!=null && getStrikePricePerUnitSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityStrikePriceModel.CommodityStrikePriceModelBuilder o = (CommodityStrikePriceModel.CommodityStrikePriceModelBuilder) other;
			
			merger.mergeRosetta(getStrikePricePerUnit(), o.getStrikePricePerUnit(), this::setStrikePricePerUnit);
			merger.mergeRosetta(getStrikePricePerUnitSchedule(), o.getStrikePricePerUnitSchedule(), this::setStrikePricePerUnitSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStrikePriceModel _that = getType().cast(o);
		
			if (!Objects.equals(strikePricePerUnit, _that.getStrikePricePerUnit())) return false;
			if (!Objects.equals(strikePricePerUnitSchedule, _that.getStrikePricePerUnitSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePricePerUnit != null ? strikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnitSchedule != null ? strikePricePerUnitSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStrikePriceModelBuilder {" +
				"strikePricePerUnit=" + this.strikePricePerUnit + ", " +
				"strikePricePerUnitSchedule=" + this.strikePricePerUnitSchedule +
			'}';
		}
	}
}
