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
import fpml.confirmation.FxPerformanceFixedLeg;
import fpml.confirmation.FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder;
import fpml.confirmation.FxPerformanceFixedLeg.FxPerformanceFixedLegBuilderImpl;
import fpml.confirmation.FxPerformanceFixedLeg.FxPerformanceFixedLegImpl;
import fpml.confirmation.FxPerformanceLeg;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegBuilder;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegBuilderImpl;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegImpl;
import fpml.confirmation.PayerModel;
import fpml.confirmation.ReceiverModel;
import fpml.confirmation.meta.FxPerformanceFixedLegMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * FX Performance Fixed Leg describes Fixed FX Rate Payer and Fixed Rate.
 * @version ${project.version}
 */
@RosettaDataType(value="FxPerformanceFixedLeg", builder=FxPerformanceFixedLeg.FxPerformanceFixedLegBuilderImpl.class, version="${project.version}")
public interface FxPerformanceFixedLeg extends FxPerformanceLeg {

	FxPerformanceFixedLegMeta metaData = new FxPerformanceFixedLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Fixed Rate means a rate, expressed as a decimal, equal to the per annum rate specified as such in the Confirmation for the Non-Deliverable Swap FX Transaction or that party (i.e., a per annum rate of 15.10% as specified in a Confirmation shall be expressed as 0.1510 for calculation purposes).
	 */
	BigDecimal getFixedRate();

	/*********************** Build Methods  ***********************/
	FxPerformanceFixedLeg build();
	
	FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder toBuilder();
	
	static FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder() {
		return new FxPerformanceFixedLeg.FxPerformanceFixedLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPerformanceFixedLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxPerformanceFixedLeg> getType() {
		return FxPerformanceFixedLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerModel"), processor, PayerModel.class, getPayerModel());
		processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.class, getReceiverModel());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPerformanceFixedLegBuilder extends FxPerformanceFixedLeg, FxPerformanceLeg.FxPerformanceLegBuilder {
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setPayerModel(PayerModel payerModel);
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setReceiverModel(ReceiverModel receiverModel);
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setFixedRate(BigDecimal fixedRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerModel"), processor, PayerModel.PayerModelBuilder.class, getPayerModel());
			processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.ReceiverModelBuilder.class, getReceiverModel());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		}
		

		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxPerformanceFixedLeg  ***********************/
	class FxPerformanceFixedLegImpl extends FxPerformanceLeg.FxPerformanceLegImpl implements FxPerformanceFixedLeg {
		private final BigDecimal fixedRate;
		
		protected FxPerformanceFixedLegImpl(FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder) {
			super(builder);
			this.fixedRate = builder.getFixedRate();
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public FxPerformanceFixedLeg build() {
			return this;
		}
		
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder toBuilder() {
			FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceFixedLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceFixedLeg {" +
				"fixedRate=" + this.fixedRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPerformanceFixedLeg  ***********************/
	class FxPerformanceFixedLegBuilderImpl extends FxPerformanceLeg.FxPerformanceLegBuilderImpl  implements FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder {
	
		protected BigDecimal fixedRate;
	
		public FxPerformanceFixedLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("payerModel")
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setPayerModel(PayerModel payerModel) {
			this.payerModel = payerModel==null?null:payerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("receiverModel")
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setReceiverModel(ReceiverModel receiverModel) {
			this.receiverModel = receiverModel==null?null:receiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setFixedRate(BigDecimal fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate;
			return this;
		}
		
		@Override
		public FxPerformanceFixedLeg build() {
			return new FxPerformanceFixedLeg.FxPerformanceFixedLegImpl(this);
		}
		
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder o = (FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder) other;
			
			
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceFixedLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceFixedLegBuilder {" +
				"fixedRate=" + this.fixedRate +
			'}' + " " + super.toString();
		}
	}
}
