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
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.FinalCalculationPeriodDateAdjustment;
import fpml.confirmation.FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder;
import fpml.confirmation.FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl;
import fpml.confirmation.FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentImpl;
import fpml.confirmation.InterestRateStreamReference;
import fpml.confirmation.RelevantUnderlyingDateReference;
import fpml.confirmation.meta.FinalCalculationPeriodDateAdjustmentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define business date convention adjustment to final payment period per leg.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FinalCalculationPeriodDateAdjustment", builder=FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FinalCalculationPeriodDateAdjustment extends RosettaModelObject {

	FinalCalculationPeriodDateAdjustmentMeta metaData = new FinalCalculationPeriodDateAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the unadjusted cancellation effective dates.
	 */
	RelevantUnderlyingDateReference getRelevantUnderlyingDateReference();
	/**
	 * Reference to the leg, where date adjustments may apply.
	 */
	InterestRateStreamReference getSwapStreamReference();
	/**
	 * Override business date convention. This takes precedence over leg level information.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();

	/*********************** Build Methods  ***********************/
	FinalCalculationPeriodDateAdjustment build();
	
	FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder();
	
	static FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder() {
		return new FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinalCalculationPeriodDateAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FinalCalculationPeriodDateAdjustment> getType() {
		return FinalCalculationPeriodDateAdjustment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relevantUnderlyingDateReference"), processor, RelevantUnderlyingDateReference.class, getRelevantUnderlyingDateReference());
		processRosetta(path.newSubPath("swapStreamReference"), processor, InterestRateStreamReference.class, getSwapStreamReference());
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinalCalculationPeriodDateAdjustmentBuilder extends FinalCalculationPeriodDateAdjustment, RosettaModelObjectBuilder {
		RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder getOrCreateRelevantUnderlyingDateReference();
		RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder getRelevantUnderlyingDateReference();
		InterestRateStreamReference.InterestRateStreamReferenceBuilder getOrCreateSwapStreamReference();
		InterestRateStreamReference.InterestRateStreamReferenceBuilder getSwapStreamReference();
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReference(RelevantUnderlyingDateReference relevantUnderlyingDateReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReference(InterestRateStreamReference swapStreamReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relevantUnderlyingDateReference"), processor, RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder.class, getRelevantUnderlyingDateReference());
			processRosetta(path.newSubPath("swapStreamReference"), processor, InterestRateStreamReference.InterestRateStreamReferenceBuilder.class, getSwapStreamReference());
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		}
		

		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of FinalCalculationPeriodDateAdjustment  ***********************/
	class FinalCalculationPeriodDateAdjustmentImpl implements FinalCalculationPeriodDateAdjustment {
		private final RelevantUnderlyingDateReference relevantUnderlyingDateReference;
		private final InterestRateStreamReference swapStreamReference;
		private final BusinessDayConventionEnum businessDayConvention;
		
		protected FinalCalculationPeriodDateAdjustmentImpl(FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder) {
			this.relevantUnderlyingDateReference = ofNullable(builder.getRelevantUnderlyingDateReference()).map(f->f.build()).orElse(null);
			this.swapStreamReference = ofNullable(builder.getSwapStreamReference()).map(f->f.build()).orElse(null);
			this.businessDayConvention = builder.getBusinessDayConvention();
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDateReference")
		public RelevantUnderlyingDateReference getRelevantUnderlyingDateReference() {
			return relevantUnderlyingDateReference;
		}
		
		@Override
		@RosettaAttribute("swapStreamReference")
		public InterestRateStreamReference getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment build() {
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder() {
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder) {
			ofNullable(getRelevantUnderlyingDateReference()).ifPresent(builder::setRelevantUnderlyingDateReference);
			ofNullable(getSwapStreamReference()).ifPresent(builder::setSwapStreamReference);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalCalculationPeriodDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(relevantUnderlyingDateReference, _that.getRelevantUnderlyingDateReference())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relevantUnderlyingDateReference != null ? relevantUnderlyingDateReference.hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalCalculationPeriodDateAdjustment {" +
				"relevantUnderlyingDateReference=" + this.relevantUnderlyingDateReference + ", " +
				"swapStreamReference=" + this.swapStreamReference + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}';
		}
	}

	/*********************** Builder Implementation of FinalCalculationPeriodDateAdjustment  ***********************/
	class FinalCalculationPeriodDateAdjustmentBuilderImpl implements FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder {
	
		protected RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder relevantUnderlyingDateReference;
		protected InterestRateStreamReference.InterestRateStreamReferenceBuilder swapStreamReference;
		protected BusinessDayConventionEnum businessDayConvention;
	
		public FinalCalculationPeriodDateAdjustmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("relevantUnderlyingDateReference")
		public RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder getRelevantUnderlyingDateReference() {
			return relevantUnderlyingDateReference;
		}
		
		@Override
		public RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder getOrCreateRelevantUnderlyingDateReference() {
			RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder result;
			if (relevantUnderlyingDateReference!=null) {
				result = relevantUnderlyingDateReference;
			}
			else {
				result = relevantUnderlyingDateReference = RelevantUnderlyingDateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swapStreamReference")
		public InterestRateStreamReference.InterestRateStreamReferenceBuilder getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		public InterestRateStreamReference.InterestRateStreamReferenceBuilder getOrCreateSwapStreamReference() {
			InterestRateStreamReference.InterestRateStreamReferenceBuilder result;
			if (swapStreamReference!=null) {
				result = swapStreamReference;
			}
			else {
				result = swapStreamReference = InterestRateStreamReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDateReference")
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReference(RelevantUnderlyingDateReference relevantUnderlyingDateReference) {
			this.relevantUnderlyingDateReference = relevantUnderlyingDateReference==null?null:relevantUnderlyingDateReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("swapStreamReference")
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReference(InterestRateStreamReference swapStreamReference) {
			this.swapStreamReference = swapStreamReference==null?null:swapStreamReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment build() {
			return new FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentImpl(this);
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder prune() {
			if (relevantUnderlyingDateReference!=null && !relevantUnderlyingDateReference.prune().hasData()) relevantUnderlyingDateReference = null;
			if (swapStreamReference!=null && !swapStreamReference.prune().hasData()) swapStreamReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelevantUnderlyingDateReference()!=null && getRelevantUnderlyingDateReference().hasData()) return true;
			if (getSwapStreamReference()!=null && getSwapStreamReference().hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder o = (FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder) other;
			
			merger.mergeRosetta(getRelevantUnderlyingDateReference(), o.getRelevantUnderlyingDateReference(), this::setRelevantUnderlyingDateReference);
			merger.mergeRosetta(getSwapStreamReference(), o.getSwapStreamReference(), this::setSwapStreamReference);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalCalculationPeriodDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(relevantUnderlyingDateReference, _that.getRelevantUnderlyingDateReference())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relevantUnderlyingDateReference != null ? relevantUnderlyingDateReference.hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalCalculationPeriodDateAdjustmentBuilder {" +
				"relevantUnderlyingDateReference=" + this.relevantUnderlyingDateReference + ", " +
				"swapStreamReference=" + this.swapStreamReference + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}';
		}
	}
}
