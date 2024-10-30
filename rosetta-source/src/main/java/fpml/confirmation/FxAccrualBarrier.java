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
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxAccrualBarrier.FxAccrualBarrierBuilder;
import fpml.confirmation.FxAccrualBarrier.FxAccrualBarrierBuilderImpl;
import fpml.confirmation.FxAccrualBarrier.FxAccrualBarrierImpl;
import fpml.confirmation.FxAccrualBarrierSequence;
import fpml.confirmation.FxAccrualKnockoutBarrierRetentionEnum;
import fpml.confirmation.FxBarrierScopeEnum;
import fpml.confirmation.FxBarrierStyleEnum;
import fpml.confirmation.FxBarrierTypeSimpleEnum;
import fpml.confirmation.FxComplexBarrierBase;
import fpml.confirmation.FxComplexBarrierBase.FxComplexBarrierBaseBuilder;
import fpml.confirmation.FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl;
import fpml.confirmation.FxComplexBarrierBase.FxComplexBarrierBaseImpl;
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import fpml.confirmation.FxComplexBarrierBaseSequence1;
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.Schedule;
import fpml.confirmation.meta.FxAccrualBarrierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualBarrier", builder=FxAccrualBarrier.FxAccrualBarrierBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualBarrier extends FxComplexBarrierBase {

	FxAccrualBarrierMeta metaData = new FxAccrualBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the behavior with respect to settlement rights for the accrual period in which a global knockout event occurs (the &quot;knockout period&quot;). &quot;Keep&quot; means that the parties retain settlement rights at the end of the knckout period, fixed at the prevailing accrued notional, and settlement rights for all future accrual periods are extinguished. &quot;Lose&quot; means that settlement rights for the knockout period and all future accrual periods are extinguished, and the product is effectively extinguished. This element should be produced in case of a global knockout barrier (barrierType= &quot;Knockout&quot;, scope=&quot;Global&quot;), and omitted otherwise.
	 */
	FxAccrualKnockoutBarrierRetentionEnum getAccrualRetention();
	/**
	 * Reference to an &#39;FxRateObservable&#39; structure.
	 */
	FxRateObservableReference getObservableReference();
	FxAccrualBarrierSequence getFxAccrualBarrierSequence();

	/*********************** Build Methods  ***********************/
	FxAccrualBarrier build();
	
	FxAccrualBarrier.FxAccrualBarrierBuilder toBuilder();
	
	static FxAccrualBarrier.FxAccrualBarrierBuilder builder() {
		return new FxAccrualBarrier.FxAccrualBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualBarrier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualBarrier> getType() {
		return FxAccrualBarrier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
		processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
		processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("triggerRate"), processor, Schedule.class, getTriggerRate());
		processRosetta(path.newSubPath("fxComplexBarrierBaseSequence0"), processor, FxComplexBarrierBaseSequence0.class, getFxComplexBarrierBaseSequence0());
		processRosetta(path.newSubPath("fxComplexBarrierBaseSequence1"), processor, FxComplexBarrierBaseSequence1.class, getFxComplexBarrierBaseSequence1());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("accrualRetention"), FxAccrualKnockoutBarrierRetentionEnum.class, getAccrualRetention(), this);
		processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.class, getObservableReference());
		processRosetta(path.newSubPath("fxAccrualBarrierSequence"), processor, FxAccrualBarrierSequence.class, getFxAccrualBarrierSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualBarrierBuilder extends FxAccrualBarrier, FxComplexBarrierBase.FxComplexBarrierBaseBuilder {
		FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference();
		FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference();
		FxAccrualBarrierSequence.FxAccrualBarrierSequenceBuilder getOrCreateFxAccrualBarrierSequence();
		FxAccrualBarrierSequence.FxAccrualBarrierSequenceBuilder getFxAccrualBarrierSequence();
		FxAccrualBarrier.FxAccrualBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType);
		FxAccrualBarrier.FxAccrualBarrierBuilder setStyle(FxBarrierStyleEnum style);
		FxAccrualBarrier.FxAccrualBarrierBuilder setScope(FxBarrierScopeEnum scope);
		FxAccrualBarrier.FxAccrualBarrierBuilder setCondition(ConditionEnum condition);
		FxAccrualBarrier.FxAccrualBarrierBuilder setTriggerRate(Schedule triggerRate);
		FxAccrualBarrier.FxAccrualBarrierBuilder setFxComplexBarrierBaseSequence0(FxComplexBarrierBaseSequence0 fxComplexBarrierBaseSequence0);
		FxAccrualBarrier.FxAccrualBarrierBuilder setFxComplexBarrierBaseSequence1(FxComplexBarrierBaseSequence1 fxComplexBarrierBaseSequence1);
		FxAccrualBarrier.FxAccrualBarrierBuilder setId(String id);
		FxAccrualBarrier.FxAccrualBarrierBuilder setAccrualRetention(FxAccrualKnockoutBarrierRetentionEnum accrualRetention);
		FxAccrualBarrier.FxAccrualBarrierBuilder setObservableReference(FxRateObservableReference observableReference);
		FxAccrualBarrier.FxAccrualBarrierBuilder setFxAccrualBarrierSequence(FxAccrualBarrierSequence fxAccrualBarrierSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
			processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
			processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("triggerRate"), processor, Schedule.ScheduleBuilder.class, getTriggerRate());
			processRosetta(path.newSubPath("fxComplexBarrierBaseSequence0"), processor, FxComplexBarrierBaseSequence0.FxComplexBarrierBaseSequence0Builder.class, getFxComplexBarrierBaseSequence0());
			processRosetta(path.newSubPath("fxComplexBarrierBaseSequence1"), processor, FxComplexBarrierBaseSequence1.FxComplexBarrierBaseSequence1Builder.class, getFxComplexBarrierBaseSequence1());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("accrualRetention"), FxAccrualKnockoutBarrierRetentionEnum.class, getAccrualRetention(), this);
			processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.FxRateObservableReferenceBuilder.class, getObservableReference());
			processRosetta(path.newSubPath("fxAccrualBarrierSequence"), processor, FxAccrualBarrierSequence.FxAccrualBarrierSequenceBuilder.class, getFxAccrualBarrierSequence());
		}
		

		FxAccrualBarrier.FxAccrualBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualBarrier  ***********************/
	class FxAccrualBarrierImpl extends FxComplexBarrierBase.FxComplexBarrierBaseImpl implements FxAccrualBarrier {
		private final FxAccrualKnockoutBarrierRetentionEnum accrualRetention;
		private final FxRateObservableReference observableReference;
		private final FxAccrualBarrierSequence fxAccrualBarrierSequence;
		
		protected FxAccrualBarrierImpl(FxAccrualBarrier.FxAccrualBarrierBuilder builder) {
			super(builder);
			this.accrualRetention = builder.getAccrualRetention();
			this.observableReference = ofNullable(builder.getObservableReference()).map(f->f.build()).orElse(null);
			this.fxAccrualBarrierSequence = ofNullable(builder.getFxAccrualBarrierSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accrualRetention")
		public FxAccrualKnockoutBarrierRetentionEnum getAccrualRetention() {
			return accrualRetention;
		}
		
		@Override
		@RosettaAttribute("observableReference")
		public FxRateObservableReference getObservableReference() {
			return observableReference;
		}
		
		@Override
		@RosettaAttribute("fxAccrualBarrierSequence")
		public FxAccrualBarrierSequence getFxAccrualBarrierSequence() {
			return fxAccrualBarrierSequence;
		}
		
		@Override
		public FxAccrualBarrier build() {
			return this;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder toBuilder() {
			FxAccrualBarrier.FxAccrualBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualBarrier.FxAccrualBarrierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccrualRetention()).ifPresent(builder::setAccrualRetention);
			ofNullable(getObservableReference()).ifPresent(builder::setObservableReference);
			ofNullable(getFxAccrualBarrierSequence()).ifPresent(builder::setFxAccrualBarrierSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualBarrier _that = getType().cast(o);
		
			if (!Objects.equals(accrualRetention, _that.getAccrualRetention())) return false;
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(fxAccrualBarrierSequence, _that.getFxAccrualBarrierSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualRetention != null ? accrualRetention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (fxAccrualBarrierSequence != null ? fxAccrualBarrierSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualBarrier {" +
				"accrualRetention=" + this.accrualRetention + ", " +
				"observableReference=" + this.observableReference + ", " +
				"fxAccrualBarrierSequence=" + this.fxAccrualBarrierSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualBarrier  ***********************/
	class FxAccrualBarrierBuilderImpl extends FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl  implements FxAccrualBarrier.FxAccrualBarrierBuilder {
	
		protected FxAccrualKnockoutBarrierRetentionEnum accrualRetention;
		protected FxRateObservableReference.FxRateObservableReferenceBuilder observableReference;
		protected FxAccrualBarrierSequence.FxAccrualBarrierSequenceBuilder fxAccrualBarrierSequence;
	
		public FxAccrualBarrierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accrualRetention")
		public FxAccrualKnockoutBarrierRetentionEnum getAccrualRetention() {
			return accrualRetention;
		}
		
		@Override
		@RosettaAttribute("observableReference")
		public FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference() {
			return observableReference;
		}
		
		@Override
		public FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference() {
			FxRateObservableReference.FxRateObservableReferenceBuilder result;
			if (observableReference!=null) {
				result = observableReference;
			}
			else {
				result = observableReference = FxRateObservableReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualBarrierSequence")
		public FxAccrualBarrierSequence.FxAccrualBarrierSequenceBuilder getFxAccrualBarrierSequence() {
			return fxAccrualBarrierSequence;
		}
		
		@Override
		public FxAccrualBarrierSequence.FxAccrualBarrierSequenceBuilder getOrCreateFxAccrualBarrierSequence() {
			FxAccrualBarrierSequence.FxAccrualBarrierSequenceBuilder result;
			if (fxAccrualBarrierSequence!=null) {
				result = fxAccrualBarrierSequence;
			}
			else {
				result = fxAccrualBarrierSequence = FxAccrualBarrierSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrierType")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType) {
			this.barrierType = barrierType==null?null:barrierType;
			return this;
		}
		@Override
		@RosettaAttribute("style")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setStyle(FxBarrierStyleEnum style) {
			this.style = style==null?null:style;
			return this;
		}
		@Override
		@RosettaAttribute("scope")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setScope(FxBarrierScopeEnum scope) {
			this.scope = scope==null?null:scope;
			return this;
		}
		@Override
		@RosettaAttribute("condition")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setCondition(ConditionEnum condition) {
			this.condition = condition==null?null:condition;
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setTriggerRate(Schedule triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence0")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setFxComplexBarrierBaseSequence0(FxComplexBarrierBaseSequence0 fxComplexBarrierBaseSequence0) {
			this.fxComplexBarrierBaseSequence0 = fxComplexBarrierBaseSequence0==null?null:fxComplexBarrierBaseSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxComplexBarrierBaseSequence1")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setFxComplexBarrierBaseSequence1(FxComplexBarrierBaseSequence1 fxComplexBarrierBaseSequence1) {
			this.fxComplexBarrierBaseSequence1 = fxComplexBarrierBaseSequence1==null?null:fxComplexBarrierBaseSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("accrualRetention")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setAccrualRetention(FxAccrualKnockoutBarrierRetentionEnum accrualRetention) {
			this.accrualRetention = accrualRetention==null?null:accrualRetention;
			return this;
		}
		@Override
		@RosettaAttribute("observableReference")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setObservableReference(FxRateObservableReference observableReference) {
			this.observableReference = observableReference==null?null:observableReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualBarrierSequence")
		public FxAccrualBarrier.FxAccrualBarrierBuilder setFxAccrualBarrierSequence(FxAccrualBarrierSequence fxAccrualBarrierSequence) {
			this.fxAccrualBarrierSequence = fxAccrualBarrierSequence==null?null:fxAccrualBarrierSequence.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualBarrier build() {
			return new FxAccrualBarrier.FxAccrualBarrierImpl(this);
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder prune() {
			super.prune();
			if (observableReference!=null && !observableReference.prune().hasData()) observableReference = null;
			if (fxAccrualBarrierSequence!=null && !fxAccrualBarrierSequence.prune().hasData()) fxAccrualBarrierSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccrualRetention()!=null) return true;
			if (getObservableReference()!=null && getObservableReference().hasData()) return true;
			if (getFxAccrualBarrierSequence()!=null && getFxAccrualBarrierSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualBarrier.FxAccrualBarrierBuilder o = (FxAccrualBarrier.FxAccrualBarrierBuilder) other;
			
			merger.mergeRosetta(getObservableReference(), o.getObservableReference(), this::setObservableReference);
			merger.mergeRosetta(getFxAccrualBarrierSequence(), o.getFxAccrualBarrierSequence(), this::setFxAccrualBarrierSequence);
			
			merger.mergeBasic(getAccrualRetention(), o.getAccrualRetention(), this::setAccrualRetention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualBarrier _that = getType().cast(o);
		
			if (!Objects.equals(accrualRetention, _that.getAccrualRetention())) return false;
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(fxAccrualBarrierSequence, _that.getFxAccrualBarrierSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualRetention != null ? accrualRetention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (fxAccrualBarrierSequence != null ? fxAccrualBarrierSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualBarrierBuilder {" +
				"accrualRetention=" + this.accrualRetention + ", " +
				"observableReference=" + this.observableReference + ", " +
				"fxAccrualBarrierSequence=" + this.fxAccrualBarrierSequence +
			'}' + " " + super.toString();
		}
	}
}
