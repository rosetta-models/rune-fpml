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
import fpml.confirmation.FxTriggerBase;
import fpml.confirmation.FxTriggerBase.FxTriggerBaseBuilder;
import fpml.confirmation.FxTriggerBase.FxTriggerBaseBuilderImpl;
import fpml.confirmation.FxTriggerBase.FxTriggerBaseImpl;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.meta.FxTriggerBaseMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes a european trigger applied to an FX digtal option.
 * @version ${project.version}
 */
@RosettaDataType(value="FxTriggerBase", builder=FxTriggerBase.FxTriggerBaseBuilderImpl.class, version="${project.version}")
public interface FxTriggerBase extends RosettaModelObject {

	FxTriggerBaseMeta metaData = new FxTriggerBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The condition that applies to a european trigger applied to an FX digital option. It determines where the rate at expiry date and time at must be relative to the triggerRate for the option to be exercisable. The allowed values are &quot;AtOrAbove&quot; and &quot;AtOrBelow&quot;. DEPRECATE: Values &quot;Above&quot; and &quot;Below&quot; are deprecated.
	 */
	TriggerConditionEnum getTriggerCondition();
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a barrier event is deemed to have occurred.
	 */
	BigDecimal getTriggerRate();
	/**
	 * An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the market rate needs to move &quot;up&quot; or &quot;down&quot; to trigger a barrier event.
	 */
	BigDecimal getSpotRate();

	/*********************** Build Methods  ***********************/
	FxTriggerBase build();
	
	FxTriggerBase.FxTriggerBaseBuilder toBuilder();
	
	static FxTriggerBase.FxTriggerBaseBuilder builder() {
		return new FxTriggerBase.FxTriggerBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTriggerBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTriggerBase> getType() {
		return FxTriggerBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTriggerBaseBuilder extends FxTriggerBase, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxTriggerBase.FxTriggerBaseBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		FxTriggerBase.FxTriggerBaseBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxTriggerBase.FxTriggerBaseBuilder setTriggerRate(BigDecimal triggerRate);
		FxTriggerBase.FxTriggerBaseBuilder setSpotRate(BigDecimal spotRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		}
		

		FxTriggerBase.FxTriggerBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FxTriggerBase  ***********************/
	class FxTriggerBaseImpl implements FxTriggerBase {
		private final TriggerConditionEnum triggerCondition;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal triggerRate;
		private final BigDecimal spotRate;
		
		protected FxTriggerBaseImpl(FxTriggerBase.FxTriggerBaseBuilder builder) {
			this.triggerCondition = builder.getTriggerCondition();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
			this.spotRate = builder.getSpotRate();
		}
		
		@Override
		@RosettaAttribute("triggerCondition")
		public TriggerConditionEnum getTriggerCondition() {
			return triggerCondition;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		public FxTriggerBase build() {
			return this;
		}
		
		@Override
		public FxTriggerBase.FxTriggerBaseBuilder toBuilder() {
			FxTriggerBase.FxTriggerBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTriggerBase.FxTriggerBaseBuilder builder) {
			ofNullable(getTriggerCondition()).ifPresent(builder::setTriggerCondition);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTriggerBase _that = getType().cast(o);
		
			if (!Objects.equals(triggerCondition, _that.getTriggerCondition())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerCondition != null ? triggerCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTriggerBase {" +
				"triggerCondition=" + this.triggerCondition + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"spotRate=" + this.spotRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTriggerBase  ***********************/
	class FxTriggerBaseBuilderImpl implements FxTriggerBase.FxTriggerBaseBuilder {
	
		protected TriggerConditionEnum triggerCondition;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal triggerRate;
		protected BigDecimal spotRate;
	
		public FxTriggerBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("triggerCondition")
		public TriggerConditionEnum getTriggerCondition() {
			return triggerCondition;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("triggerCondition")
		public FxTriggerBase.FxTriggerBaseBuilder setTriggerCondition(TriggerConditionEnum triggerCondition) {
			this.triggerCondition = triggerCondition==null?null:triggerCondition;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxTriggerBase.FxTriggerBaseBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxTriggerBase.FxTriggerBaseBuilder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxTriggerBase.FxTriggerBaseBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		
		@Override
		public FxTriggerBase build() {
			return new FxTriggerBase.FxTriggerBaseImpl(this);
		}
		
		@Override
		public FxTriggerBase.FxTriggerBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTriggerBase.FxTriggerBaseBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerCondition()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getTriggerRate()!=null) return true;
			if (getSpotRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTriggerBase.FxTriggerBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTriggerBase.FxTriggerBaseBuilder o = (FxTriggerBase.FxTriggerBaseBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			
			merger.mergeBasic(getTriggerCondition(), o.getTriggerCondition(), this::setTriggerCondition);
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTriggerBase _that = getType().cast(o);
		
			if (!Objects.equals(triggerCondition, _that.getTriggerCondition())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerCondition != null ? triggerCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTriggerBaseBuilder {" +
				"triggerCondition=" + this.triggerCondition + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"spotRate=" + this.spotRate +
			'}';
		}
	}
}
