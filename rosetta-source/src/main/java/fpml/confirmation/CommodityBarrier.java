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
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.CommodityBarrier.CommodityBarrierBuilder;
import fpml.confirmation.CommodityBarrier.CommodityBarrierBuilderImpl;
import fpml.confirmation.CommodityBarrier.CommodityBarrierImpl;
import fpml.confirmation.CommodityKnockEnum;
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.meta.CommodityBarrierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The specification of how a barrier option will trigger (that is, knock-in or knock-out) or expire based on the position of the spot rate relative to trigger level.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityBarrier", builder=CommodityBarrier.CommodityBarrierBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityBarrier extends RosettaModelObject {

	CommodityBarrierMeta metaData = new CommodityBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The knock feature of a commodity barrier option.
	 */
	CommodityKnockEnum getKnock();
	/**
	 * In the case of barrier options where the option automatically expires and the barrier is breached in such a way to to result in a &quot;knock-out&quot; vent, this amount is paid to the the option holder so as to refund or rebate a portion of any premium paid.
	 */
	PositiveMoney getFeaturePaymentAmount();
	CommodityTrigger getTrigger();

	/*********************** Build Methods  ***********************/
	CommodityBarrier build();
	
	CommodityBarrier.CommodityBarrierBuilder toBuilder();
	
	static CommodityBarrier.CommodityBarrierBuilder builder() {
		return new CommodityBarrier.CommodityBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBarrier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBarrier> getType() {
		return CommodityBarrier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("knock"), CommodityKnockEnum.class, getKnock(), this);
		processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.class, getFeaturePaymentAmount());
		processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.class, getTrigger());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBarrierBuilder extends CommodityBarrier, RosettaModelObjectBuilder {
		PositiveMoney.PositiveMoneyBuilder getOrCreateFeaturePaymentAmount();
		PositiveMoney.PositiveMoneyBuilder getFeaturePaymentAmount();
		CommodityTrigger.CommodityTriggerBuilder getOrCreateTrigger();
		CommodityTrigger.CommodityTriggerBuilder getTrigger();
		CommodityBarrier.CommodityBarrierBuilder setKnock(CommodityKnockEnum knock);
		CommodityBarrier.CommodityBarrierBuilder setFeaturePaymentAmount(PositiveMoney featurePaymentAmount);
		CommodityBarrier.CommodityBarrierBuilder setTrigger(CommodityTrigger trigger);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("knock"), CommodityKnockEnum.class, getKnock(), this);
			processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getFeaturePaymentAmount());
			processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.CommodityTriggerBuilder.class, getTrigger());
		}
		

		CommodityBarrier.CommodityBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBarrier  ***********************/
	class CommodityBarrierImpl implements CommodityBarrier {
		private final CommodityKnockEnum knock;
		private final PositiveMoney featurePaymentAmount;
		private final CommodityTrigger trigger;
		
		protected CommodityBarrierImpl(CommodityBarrier.CommodityBarrierBuilder builder) {
			this.knock = builder.getKnock();
			this.featurePaymentAmount = ofNullable(builder.getFeaturePaymentAmount()).map(f->f.build()).orElse(null);
			this.trigger = ofNullable(builder.getTrigger()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("knock")
		public CommodityKnockEnum getKnock() {
			return knock;
		}
		
		@Override
		@RosettaAttribute("featurePaymentAmount")
		public PositiveMoney getFeaturePaymentAmount() {
			return featurePaymentAmount;
		}
		
		@Override
		@RosettaAttribute("trigger")
		public CommodityTrigger getTrigger() {
			return trigger;
		}
		
		@Override
		public CommodityBarrier build() {
			return this;
		}
		
		@Override
		public CommodityBarrier.CommodityBarrierBuilder toBuilder() {
			CommodityBarrier.CommodityBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBarrier.CommodityBarrierBuilder builder) {
			ofNullable(getKnock()).ifPresent(builder::setKnock);
			ofNullable(getFeaturePaymentAmount()).ifPresent(builder::setFeaturePaymentAmount);
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBarrier _that = getType().cast(o);
		
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knock != null ? knock.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBarrier {" +
				"knock=" + this.knock + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount + ", " +
				"trigger=" + this.trigger +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBarrier  ***********************/
	class CommodityBarrierBuilderImpl implements CommodityBarrier.CommodityBarrierBuilder {
	
		protected CommodityKnockEnum knock;
		protected PositiveMoney.PositiveMoneyBuilder featurePaymentAmount;
		protected CommodityTrigger.CommodityTriggerBuilder trigger;
	
		public CommodityBarrierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("knock")
		public CommodityKnockEnum getKnock() {
			return knock;
		}
		
		@Override
		@RosettaAttribute("featurePaymentAmount")
		public PositiveMoney.PositiveMoneyBuilder getFeaturePaymentAmount() {
			return featurePaymentAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateFeaturePaymentAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (featurePaymentAmount!=null) {
				result = featurePaymentAmount;
			}
			else {
				result = featurePaymentAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trigger")
		public CommodityTrigger.CommodityTriggerBuilder getTrigger() {
			return trigger;
		}
		
		@Override
		public CommodityTrigger.CommodityTriggerBuilder getOrCreateTrigger() {
			CommodityTrigger.CommodityTriggerBuilder result;
			if (trigger!=null) {
				result = trigger;
			}
			else {
				result = trigger = CommodityTrigger.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knock")
		public CommodityBarrier.CommodityBarrierBuilder setKnock(CommodityKnockEnum knock) {
			this.knock = knock==null?null:knock;
			return this;
		}
		@Override
		@RosettaAttribute("featurePaymentAmount")
		public CommodityBarrier.CommodityBarrierBuilder setFeaturePaymentAmount(PositiveMoney featurePaymentAmount) {
			this.featurePaymentAmount = featurePaymentAmount==null?null:featurePaymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trigger")
		public CommodityBarrier.CommodityBarrierBuilder setTrigger(CommodityTrigger trigger) {
			this.trigger = trigger==null?null:trigger.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBarrier build() {
			return new CommodityBarrier.CommodityBarrierImpl(this);
		}
		
		@Override
		public CommodityBarrier.CommodityBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBarrier.CommodityBarrierBuilder prune() {
			if (featurePaymentAmount!=null && !featurePaymentAmount.prune().hasData()) featurePaymentAmount = null;
			if (trigger!=null && !trigger.prune().hasData()) trigger = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getKnock()!=null) return true;
			if (getFeaturePaymentAmount()!=null && getFeaturePaymentAmount().hasData()) return true;
			if (getTrigger()!=null && getTrigger().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBarrier.CommodityBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBarrier.CommodityBarrierBuilder o = (CommodityBarrier.CommodityBarrierBuilder) other;
			
			merger.mergeRosetta(getFeaturePaymentAmount(), o.getFeaturePaymentAmount(), this::setFeaturePaymentAmount);
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::setTrigger);
			
			merger.mergeBasic(getKnock(), o.getKnock(), this::setKnock);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBarrier _that = getType().cast(o);
		
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knock != null ? knock.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBarrierBuilder {" +
				"knock=" + this.knock + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount + ", " +
				"trigger=" + this.trigger +
			'}';
		}
	}
}
