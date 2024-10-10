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
import fpml.confirmation.CommodityDigital;
import fpml.confirmation.CommodityDigital.CommodityDigitalBuilder;
import fpml.confirmation.CommodityDigital.CommodityDigitalBuilderImpl;
import fpml.confirmation.CommodityDigital.CommodityDigitalImpl;
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.meta.CommodityDigitalMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defined the conditions under which the digital option can triggers and, if triggered, what payment results.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDigital", builder=CommodityDigital.CommodityDigitalBuilderImpl.class, version="${project.version}")
public interface CommodityDigital extends RosettaModelObject {

	CommodityDigitalMeta metaData = new CommodityDigitalMeta();

	/*********************** Getter Methods  ***********************/
	CommodityTrigger getTrigger();
	/**
	 * The cash payment that is made when the digital barrier is breached.
	 */
	PositiveMoney getFeaturePaymentAmount();

	/*********************** Build Methods  ***********************/
	CommodityDigital build();
	
	CommodityDigital.CommodityDigitalBuilder toBuilder();
	
	static CommodityDigital.CommodityDigitalBuilder builder() {
		return new CommodityDigital.CommodityDigitalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDigital> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDigital> getType() {
		return CommodityDigital.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.class, getTrigger());
		processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.class, getFeaturePaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDigitalBuilder extends CommodityDigital, RosettaModelObjectBuilder {
		CommodityTrigger.CommodityTriggerBuilder getOrCreateTrigger();
		CommodityTrigger.CommodityTriggerBuilder getTrigger();
		PositiveMoney.PositiveMoneyBuilder getOrCreateFeaturePaymentAmount();
		PositiveMoney.PositiveMoneyBuilder getFeaturePaymentAmount();
		CommodityDigital.CommodityDigitalBuilder setTrigger(CommodityTrigger trigger);
		CommodityDigital.CommodityDigitalBuilder setFeaturePaymentAmount(PositiveMoney featurePaymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.CommodityTriggerBuilder.class, getTrigger());
			processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getFeaturePaymentAmount());
		}
		

		CommodityDigital.CommodityDigitalBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDigital  ***********************/
	class CommodityDigitalImpl implements CommodityDigital {
		private final CommodityTrigger trigger;
		private final PositiveMoney featurePaymentAmount;
		
		protected CommodityDigitalImpl(CommodityDigital.CommodityDigitalBuilder builder) {
			this.trigger = ofNullable(builder.getTrigger()).map(f->f.build()).orElse(null);
			this.featurePaymentAmount = ofNullable(builder.getFeaturePaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trigger")
		public CommodityTrigger getTrigger() {
			return trigger;
		}
		
		@Override
		@RosettaAttribute("featurePaymentAmount")
		public PositiveMoney getFeaturePaymentAmount() {
			return featurePaymentAmount;
		}
		
		@Override
		public CommodityDigital build() {
			return this;
		}
		
		@Override
		public CommodityDigital.CommodityDigitalBuilder toBuilder() {
			CommodityDigital.CommodityDigitalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDigital.CommodityDigitalBuilder builder) {
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
			ofNullable(getFeaturePaymentAmount()).ifPresent(builder::setFeaturePaymentAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigital _that = getType().cast(o);
		
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigital {" +
				"trigger=" + this.trigger + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDigital  ***********************/
	class CommodityDigitalBuilderImpl implements CommodityDigital.CommodityDigitalBuilder {
	
		protected CommodityTrigger.CommodityTriggerBuilder trigger;
		protected PositiveMoney.PositiveMoneyBuilder featurePaymentAmount;
	
		public CommodityDigitalBuilderImpl() {
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
		public CommodityDigital.CommodityDigitalBuilder setTrigger(CommodityTrigger trigger) {
			this.trigger = trigger==null?null:trigger.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featurePaymentAmount")
		public CommodityDigital.CommodityDigitalBuilder setFeaturePaymentAmount(PositiveMoney featurePaymentAmount) {
			this.featurePaymentAmount = featurePaymentAmount==null?null:featurePaymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDigital build() {
			return new CommodityDigital.CommodityDigitalImpl(this);
		}
		
		@Override
		public CommodityDigital.CommodityDigitalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigital.CommodityDigitalBuilder prune() {
			if (trigger!=null && !trigger.prune().hasData()) trigger = null;
			if (featurePaymentAmount!=null && !featurePaymentAmount.prune().hasData()) featurePaymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrigger()!=null && getTrigger().hasData()) return true;
			if (getFeaturePaymentAmount()!=null && getFeaturePaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigital.CommodityDigitalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDigital.CommodityDigitalBuilder o = (CommodityDigital.CommodityDigitalBuilder) other;
			
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::setTrigger);
			merger.mergeRosetta(getFeaturePaymentAmount(), o.getFeaturePaymentAmount(), this::setFeaturePaymentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigital _that = getType().cast(o);
		
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalBuilder {" +
				"trigger=" + this.trigger + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount +
			'}';
		}
	}
}
