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
import fpml.confirmation.CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder;
import fpml.confirmation.CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilderImpl;
import fpml.confirmation.CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleImpl;
import fpml.confirmation.Frequency;
import fpml.confirmation.Frequency.FrequencyBuilder;
import fpml.confirmation.Frequency.FrequencyBuilderImpl;
import fpml.confirmation.Frequency.FrequencyImpl;
import fpml.confirmation.PeriodExtendedEnum;
import fpml.confirmation.meta.CommodityCalculationPeriodsScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A parametric representation of the Calculation Periods for on Asian option or a leg of a swap. In case the calculation frequency is of value T (term), the period is defined by the commoditySwap\effectiveDate and the commoditySwap\terminationDate.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityCalculationPeriodsSchedule", builder=CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityCalculationPeriodsSchedule extends Frequency {

	CommodityCalculationPeriodsScheduleMeta metaData = new CommodityCalculationPeriodsScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, indicates that that the first Calculation Period should run from the Effective Date to the end of the calendar period in which the Effective Date falls, e.g. Jan 15 - Jan 31 if the calculation periods are one month long and Effective Date is Jan 15. If false, the first Calculation Period should run from the Effective Date for one whole period, e.g. Jan 15 to Feb 14 if the calculation periods are one month long and Effective Date is Jan 15.
	 */
	Boolean getBalanceOfFirstPeriod();

	/*********************** Build Methods  ***********************/
	CommodityCalculationPeriodsSchedule build();
	
	CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder toBuilder();
	
	static CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder() {
		return new CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityCalculationPeriodsSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityCalculationPeriodsSchedule> getType() {
		return CommodityCalculationPeriodsSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("balanceOfFirstPeriod"), Boolean.class, getBalanceOfFirstPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityCalculationPeriodsScheduleBuilder extends CommodityCalculationPeriodsSchedule, Frequency.FrequencyBuilder {
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriodMultiplier(Integer periodMultiplier);
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriod(PeriodExtendedEnum period);
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setId(String id);
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setBalanceOfFirstPeriod(Boolean balanceOfFirstPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("balanceOfFirstPeriod"), Boolean.class, getBalanceOfFirstPeriod(), this);
		}
		

		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityCalculationPeriodsSchedule  ***********************/
	class CommodityCalculationPeriodsScheduleImpl extends Frequency.FrequencyImpl implements CommodityCalculationPeriodsSchedule {
		private final Boolean balanceOfFirstPeriod;
		
		protected CommodityCalculationPeriodsScheduleImpl(CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder) {
			super(builder);
			this.balanceOfFirstPeriod = builder.getBalanceOfFirstPeriod();
		}
		
		@Override
		@RosettaAttribute("balanceOfFirstPeriod")
		public Boolean getBalanceOfFirstPeriod() {
			return balanceOfFirstPeriod;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule build() {
			return this;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder toBuilder() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBalanceOfFirstPeriod()).ifPresent(builder::setBalanceOfFirstPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityCalculationPeriodsSchedule _that = getType().cast(o);
		
			if (!Objects.equals(balanceOfFirstPeriod, _that.getBalanceOfFirstPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (balanceOfFirstPeriod != null ? balanceOfFirstPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCalculationPeriodsSchedule {" +
				"balanceOfFirstPeriod=" + this.balanceOfFirstPeriod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityCalculationPeriodsSchedule  ***********************/
	class CommodityCalculationPeriodsScheduleBuilderImpl extends Frequency.FrequencyBuilderImpl  implements CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder {
	
		protected Boolean balanceOfFirstPeriod;
	
		public CommodityCalculationPeriodsScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("balanceOfFirstPeriod")
		public Boolean getBalanceOfFirstPeriod() {
			return balanceOfFirstPeriod;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("balanceOfFirstPeriod")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setBalanceOfFirstPeriod(Boolean balanceOfFirstPeriod) {
			this.balanceOfFirstPeriod = balanceOfFirstPeriod==null?null:balanceOfFirstPeriod;
			return this;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule build() {
			return new CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleImpl(this);
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBalanceOfFirstPeriod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder o = (CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder) other;
			
			
			merger.mergeBasic(getBalanceOfFirstPeriod(), o.getBalanceOfFirstPeriod(), this::setBalanceOfFirstPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityCalculationPeriodsSchedule _that = getType().cast(o);
		
			if (!Objects.equals(balanceOfFirstPeriod, _that.getBalanceOfFirstPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (balanceOfFirstPeriod != null ? balanceOfFirstPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCalculationPeriodsScheduleBuilder {" +
				"balanceOfFirstPeriod=" + this.balanceOfFirstPeriod +
			'}' + " " + super.toString();
		}
	}
}
