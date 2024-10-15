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
import fpml.confirmation.FxComplexBarrierBaseReference;
import fpml.confirmation.FxSettlementPeriodBarrier;
import fpml.confirmation.FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder;
import fpml.confirmation.FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilderImpl;
import fpml.confirmation.FxSettlementPeriodBarrier.FxSettlementPeriodBarrierImpl;
import fpml.confirmation.meta.FxSettlementPeriodBarrierMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxSettlementPeriodBarrier", builder=FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilderImpl.class, version="${project.version}")
public interface FxSettlementPeriodBarrier extends RosettaModelObject {

	FxSettlementPeriodBarrierMeta metaData = new FxSettlementPeriodBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the barrier structure within the parametric representation of the product.
	 */
	FxComplexBarrierBaseReference getBarrierReference();
	/**
	 * Barrier trigger rate.
	 */
	BigDecimal getTriggerRate();

	/*********************** Build Methods  ***********************/
	FxSettlementPeriodBarrier build();
	
	FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder toBuilder();
	
	static FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder() {
		return new FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSettlementPeriodBarrier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSettlementPeriodBarrier> getType() {
		return FxSettlementPeriodBarrier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.class, getBarrierReference());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSettlementPeriodBarrierBuilder extends FxSettlementPeriodBarrier, RosettaModelObjectBuilder {
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference();
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference();
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setBarrierReference(FxComplexBarrierBaseReference barrierReference);
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setTriggerRate(BigDecimal triggerRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder.class, getBarrierReference());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		}
		

		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of FxSettlementPeriodBarrier  ***********************/
	class FxSettlementPeriodBarrierImpl implements FxSettlementPeriodBarrier {
		private final FxComplexBarrierBaseReference barrierReference;
		private final BigDecimal triggerRate;
		
		protected FxSettlementPeriodBarrierImpl(FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder) {
			this.barrierReference = ofNullable(builder.getBarrierReference()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
		}
		
		@Override
		@RosettaAttribute("barrierReference")
		public FxComplexBarrierBaseReference getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		public FxSettlementPeriodBarrier build() {
			return this;
		}
		
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder toBuilder() {
			FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder) {
			ofNullable(getBarrierReference()).ifPresent(builder::setBarrierReference);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementPeriodBarrier _that = getType().cast(o);
		
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementPeriodBarrier {" +
				"barrierReference=" + this.barrierReference + ", " +
				"triggerRate=" + this.triggerRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxSettlementPeriodBarrier  ***********************/
	class FxSettlementPeriodBarrierBuilderImpl implements FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder {
	
		protected FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder barrierReference;
		protected BigDecimal triggerRate;
	
		public FxSettlementPeriodBarrierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("barrierReference")
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference() {
			FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder result;
			if (barrierReference!=null) {
				result = barrierReference;
			}
			else {
				result = barrierReference = FxComplexBarrierBaseReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("barrierReference")
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setBarrierReference(FxComplexBarrierBaseReference barrierReference) {
			this.barrierReference = barrierReference==null?null:barrierReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		
		@Override
		public FxSettlementPeriodBarrier build() {
			return new FxSettlementPeriodBarrier.FxSettlementPeriodBarrierImpl(this);
		}
		
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder prune() {
			if (barrierReference!=null && !barrierReference.prune().hasData()) barrierReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBarrierReference()!=null && getBarrierReference().hasData()) return true;
			if (getTriggerRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder o = (FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder) other;
			
			merger.mergeRosetta(getBarrierReference(), o.getBarrierReference(), this::setBarrierReference);
			
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementPeriodBarrier _that = getType().cast(o);
		
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementPeriodBarrierBuilder {" +
				"barrierReference=" + this.barrierReference + ", " +
				"triggerRate=" + this.triggerRate +
			'}';
		}
	}
}
