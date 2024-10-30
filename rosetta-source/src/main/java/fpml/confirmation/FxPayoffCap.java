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
import fpml.confirmation.ConditionEnum;
import fpml.confirmation.FxPayoffCap;
import fpml.confirmation.FxPayoffCap.FxPayoffCapBuilder;
import fpml.confirmation.FxPayoffCap.FxPayoffCapBuilderImpl;
import fpml.confirmation.FxPayoffCap.FxPayoffCapImpl;
import fpml.confirmation.FxSettlementAdjustmentMethodEnum;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.FxPayoffCapMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The amount of gain on the client upside or firm upside is limited. If spot settles above the cap, or below the floor, the payout is adjusted to limit the gain. The adjustment may be made by varying the strike, or by maintaining the strike, but varying the payout notionals.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxPayoffCap", builder=FxPayoffCap.FxPayoffCapBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxPayoffCap extends RosettaModelObject {

	FxPayoffCapMeta metaData = new FxPayoffCapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Condition in which Cap or Floor applies.
	 */
	ConditionEnum getCondition();
	/**
	 * Cap/Floor rate.
	 */
	Schedule getRate();
	/**
	 * The Settlement Adjustment Style can be VariedStrike or VariedNotional.
	 */
	FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle();

	/*********************** Build Methods  ***********************/
	FxPayoffCap build();
	
	FxPayoffCap.FxPayoffCapBuilder toBuilder();
	
	static FxPayoffCap.FxPayoffCapBuilder builder() {
		return new FxPayoffCap.FxPayoffCapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPayoffCap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxPayoffCap> getType() {
		return FxPayoffCap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("rate"), processor, Schedule.class, getRate());
		processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPayoffCapBuilder extends FxPayoffCap, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateRate();
		Schedule.ScheduleBuilder getRate();
		FxPayoffCap.FxPayoffCapBuilder setCondition(ConditionEnum condition);
		FxPayoffCap.FxPayoffCapBuilder setRate(Schedule rate);
		FxPayoffCap.FxPayoffCapBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("rate"), processor, Schedule.ScheduleBuilder.class, getRate());
			processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
		}
		

		FxPayoffCap.FxPayoffCapBuilder prune();
	}

	/*********************** Immutable Implementation of FxPayoffCap  ***********************/
	class FxPayoffCapImpl implements FxPayoffCap {
		private final ConditionEnum condition;
		private final Schedule rate;
		private final FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		
		protected FxPayoffCapImpl(FxPayoffCap.FxPayoffCapBuilder builder) {
			this.condition = builder.getCondition();
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
			this.settlementAdjustmentStyle = builder.getSettlementAdjustmentStyle();
		}
		
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("rate")
		public Schedule getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		public FxPayoffCap build() {
			return this;
		}
		
		@Override
		public FxPayoffCap.FxPayoffCapBuilder toBuilder() {
			FxPayoffCap.FxPayoffCapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPayoffCap.FxPayoffCapBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getSettlementAdjustmentStyle()).ifPresent(builder::setSettlementAdjustmentStyle);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPayoffCap _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPayoffCap {" +
				"condition=" + this.condition + ", " +
				"rate=" + this.rate + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}

	/*********************** Builder Implementation of FxPayoffCap  ***********************/
	class FxPayoffCapBuilderImpl implements FxPayoffCap.FxPayoffCapBuilder {
	
		protected ConditionEnum condition;
		protected Schedule.ScheduleBuilder rate;
		protected FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
	
		public FxPayoffCapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("rate")
		public Schedule.ScheduleBuilder getRate() {
			return rate;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateRate() {
			Schedule.ScheduleBuilder result;
			if (rate!=null) {
				result = rate;
			}
			else {
				result = rate = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		@RosettaAttribute("condition")
		public FxPayoffCap.FxPayoffCapBuilder setCondition(ConditionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public FxPayoffCap.FxPayoffCapBuilder setRate(Schedule rate) {
			this.rate = rate==null?null:rate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxPayoffCap.FxPayoffCapBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle) {
			this.settlementAdjustmentStyle = settlementAdjustmentStyle==null?null:settlementAdjustmentStyle;
			return this;
		}
		
		@Override
		public FxPayoffCap build() {
			return new FxPayoffCap.FxPayoffCapImpl(this);
		}
		
		@Override
		public FxPayoffCap.FxPayoffCapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPayoffCap.FxPayoffCapBuilder prune() {
			if (rate!=null && !rate.prune().hasData()) rate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getRate()!=null && getRate().hasData()) return true;
			if (getSettlementAdjustmentStyle()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPayoffCap.FxPayoffCapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxPayoffCap.FxPayoffCapBuilder o = (FxPayoffCap.FxPayoffCapBuilder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getSettlementAdjustmentStyle(), o.getSettlementAdjustmentStyle(), this::setSettlementAdjustmentStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPayoffCap _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPayoffCapBuilder {" +
				"condition=" + this.condition + ", " +
				"rate=" + this.rate + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}
}
