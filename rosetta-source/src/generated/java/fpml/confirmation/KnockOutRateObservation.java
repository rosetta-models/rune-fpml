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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.InformationSource;
import fpml.confirmation.KnockOutRateObservation;
import fpml.confirmation.KnockOutRateObservation.KnockOutRateObservationBuilder;
import fpml.confirmation.KnockOutRateObservation.KnockOutRateObservationBuilderImpl;
import fpml.confirmation.KnockOutRateObservation.KnockOutRateObservationImpl;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.TriggerRateObservation;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationBuilder;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationBuilderImpl;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationImpl;
import fpml.confirmation.TriggerRateObservationSequence0;
import fpml.confirmation.TriggerRateObservationSequence1;
import fpml.confirmation.meta.KnockOutRateObservationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes an observation that caused a barrier knock out to trigger
 * @version ${project.version}
 */
@RosettaDataType(value="KnockOutRateObservation", builder=KnockOutRateObservation.KnockOutRateObservationBuilderImpl.class, version="${project.version}")
public interface KnockOutRateObservation extends TriggerRateObservation {

	KnockOutRateObservationMeta metaData = new KnockOutRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Any rebate payable as a result of the knock out
	 */
	NonNegativePayment getRebatePayment();

	/*********************** Build Methods  ***********************/
	KnockOutRateObservation build();
	
	KnockOutRateObservation.KnockOutRateObservationBuilder toBuilder();
	
	static KnockOutRateObservation.KnockOutRateObservationBuilder builder() {
		return new KnockOutRateObservation.KnockOutRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KnockOutRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends KnockOutRateObservation> getType() {
		return KnockOutRateObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
		processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.class, getObservationTime());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("triggerRateObservationSequence0"), processor, TriggerRateObservationSequence0.class, getTriggerRateObservationSequence0());
		processRosetta(path.newSubPath("triggerRateObservationSequence1"), processor, TriggerRateObservationSequence1.class, getTriggerRateObservationSequence1());
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		processRosetta(path.newSubPath("rebatePayment"), processor, NonNegativePayment.class, getRebatePayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface KnockOutRateObservationBuilder extends KnockOutRateObservation, TriggerRateObservation.TriggerRateObservationBuilder {
		NonNegativePayment.NonNegativePaymentBuilder getOrCreateRebatePayment();
		NonNegativePayment.NonNegativePaymentBuilder getRebatePayment();
		KnockOutRateObservation.KnockOutRateObservationBuilder setObservationDate(Date observationDate);
		KnockOutRateObservation.KnockOutRateObservationBuilder setObservationTime(BusinessCenterTime observationTime);
		KnockOutRateObservation.KnockOutRateObservationBuilder setInformationSource(InformationSource informationSource);
		KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerRateObservationSequence0(TriggerRateObservationSequence0 triggerRateObservationSequence0);
		KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerRateObservationSequence1(TriggerRateObservationSequence1 triggerRateObservationSequence1);
		KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		KnockOutRateObservation.KnockOutRateObservationBuilder setRebatePayment(NonNegativePayment rebatePayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
			processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationTime());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("triggerRateObservationSequence0"), processor, TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder.class, getTriggerRateObservationSequence0());
			processRosetta(path.newSubPath("triggerRateObservationSequence1"), processor, TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder.class, getTriggerRateObservationSequence1());
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
			processRosetta(path.newSubPath("rebatePayment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getRebatePayment());
		}
		

		KnockOutRateObservation.KnockOutRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of KnockOutRateObservation  ***********************/
	class KnockOutRateObservationImpl extends TriggerRateObservation.TriggerRateObservationImpl implements KnockOutRateObservation {
		private final NonNegativePayment rebatePayment;
		
		protected KnockOutRateObservationImpl(KnockOutRateObservation.KnockOutRateObservationBuilder builder) {
			super(builder);
			this.rebatePayment = ofNullable(builder.getRebatePayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rebatePayment")
		public NonNegativePayment getRebatePayment() {
			return rebatePayment;
		}
		
		@Override
		public KnockOutRateObservation build() {
			return this;
		}
		
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder toBuilder() {
			KnockOutRateObservation.KnockOutRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KnockOutRateObservation.KnockOutRateObservationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRebatePayment()).ifPresent(builder::setRebatePayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			KnockOutRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(rebatePayment, _that.getRebatePayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebatePayment != null ? rebatePayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KnockOutRateObservation {" +
				"rebatePayment=" + this.rebatePayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of KnockOutRateObservation  ***********************/
	class KnockOutRateObservationBuilderImpl extends TriggerRateObservation.TriggerRateObservationBuilderImpl  implements KnockOutRateObservation.KnockOutRateObservationBuilder {
	
		protected NonNegativePayment.NonNegativePaymentBuilder rebatePayment;
	
		public KnockOutRateObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rebatePayment")
		public NonNegativePayment.NonNegativePaymentBuilder getRebatePayment() {
			return rebatePayment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreateRebatePayment() {
			NonNegativePayment.NonNegativePaymentBuilder result;
			if (rebatePayment!=null) {
				result = rebatePayment;
			}
			else {
				result = rebatePayment = NonNegativePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationDate")
		public KnockOutRateObservation.KnockOutRateObservationBuilder setObservationDate(Date observationDate) {
			this.observationDate = observationDate==null?null:observationDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationTime")
		public KnockOutRateObservation.KnockOutRateObservationBuilder setObservationTime(BusinessCenterTime observationTime) {
			this.observationTime = observationTime==null?null:observationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public KnockOutRateObservation.KnockOutRateObservationBuilder setInformationSource(InformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRateObservationSequence0")
		public KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerRateObservationSequence0(TriggerRateObservationSequence0 triggerRateObservationSequence0) {
			this.triggerRateObservationSequence0 = triggerRateObservationSequence0==null?null:triggerRateObservationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRateObservationSequence1")
		public KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerRateObservationSequence1(TriggerRateObservationSequence1 triggerRateObservationSequence1) {
			this.triggerRateObservationSequence1 = triggerRateObservationSequence1==null?null:triggerRateObservationSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerCondition")
		public KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition) {
			this.triggerCondition = triggerCondition==null?null:triggerCondition;
			return this;
		}
		@Override
		@RosettaAttribute("rebatePayment")
		public KnockOutRateObservation.KnockOutRateObservationBuilder setRebatePayment(NonNegativePayment rebatePayment) {
			this.rebatePayment = rebatePayment==null?null:rebatePayment.toBuilder();
			return this;
		}
		
		@Override
		public KnockOutRateObservation build() {
			return new KnockOutRateObservation.KnockOutRateObservationImpl(this);
		}
		
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder prune() {
			super.prune();
			if (rebatePayment!=null && !rebatePayment.prune().hasData()) rebatePayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRebatePayment()!=null && getRebatePayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			KnockOutRateObservation.KnockOutRateObservationBuilder o = (KnockOutRateObservation.KnockOutRateObservationBuilder) other;
			
			merger.mergeRosetta(getRebatePayment(), o.getRebatePayment(), this::setRebatePayment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			KnockOutRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(rebatePayment, _that.getRebatePayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebatePayment != null ? rebatePayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KnockOutRateObservationBuilder {" +
				"rebatePayment=" + this.rebatePayment +
			'}' + " " + super.toString();
		}
	}
}
