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
import fpml.confirmation.PeriodOptionalEndModel;
import fpml.confirmation.PeriodRate;
import fpml.confirmation.PeriodRate.PeriodRateBuilder;
import fpml.confirmation.PeriodRate.PeriodRateBuilderImpl;
import fpml.confirmation.PeriodRate.PeriodRateImpl;
import fpml.confirmation.meta.PeriodRateMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents a rate applicable against a well-defined or open-ended period.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PeriodRate", builder=PeriodRate.PeriodRateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PeriodRate extends RosettaModelObject {

	PeriodRateMeta metaData = new PeriodRateMeta();

	/*********************** Getter Methods  ***********************/
	PeriodOptionalEndModel getPeriodOptionalEndModel();
	BigDecimal getRate();

	/*********************** Build Methods  ***********************/
	PeriodRate build();
	
	PeriodRate.PeriodRateBuilder toBuilder();
	
	static PeriodRate.PeriodRateBuilder builder() {
		return new PeriodRate.PeriodRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PeriodRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PeriodRate> getType() {
		return PeriodRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodOptionalEndModel"), processor, PeriodOptionalEndModel.class, getPeriodOptionalEndModel());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodRateBuilder extends PeriodRate, RosettaModelObjectBuilder {
		PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getOrCreatePeriodOptionalEndModel();
		PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getPeriodOptionalEndModel();
		PeriodRate.PeriodRateBuilder setPeriodOptionalEndModel(PeriodOptionalEndModel periodOptionalEndModel);
		PeriodRate.PeriodRateBuilder setRate(BigDecimal rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodOptionalEndModel"), processor, PeriodOptionalEndModel.PeriodOptionalEndModelBuilder.class, getPeriodOptionalEndModel());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		PeriodRate.PeriodRateBuilder prune();
	}

	/*********************** Immutable Implementation of PeriodRate  ***********************/
	class PeriodRateImpl implements PeriodRate {
		private final PeriodOptionalEndModel periodOptionalEndModel;
		private final BigDecimal rate;
		
		protected PeriodRateImpl(PeriodRate.PeriodRateBuilder builder) {
			this.periodOptionalEndModel = ofNullable(builder.getPeriodOptionalEndModel()).map(f->f.build()).orElse(null);
			this.rate = builder.getRate();
		}
		
		@Override
		@RosettaAttribute("periodOptionalEndModel")
		public PeriodOptionalEndModel getPeriodOptionalEndModel() {
			return periodOptionalEndModel;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public PeriodRate build() {
			return this;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder toBuilder() {
			PeriodRate.PeriodRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodRate.PeriodRateBuilder builder) {
			ofNullable(getPeriodOptionalEndModel()).ifPresent(builder::setPeriodOptionalEndModel);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodRate _that = getType().cast(o);
		
			if (!Objects.equals(periodOptionalEndModel, _that.getPeriodOptionalEndModel())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodOptionalEndModel != null ? periodOptionalEndModel.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodRate {" +
				"periodOptionalEndModel=" + this.periodOptionalEndModel + ", " +
				"rate=" + this.rate +
			'}';
		}
	}

	/*********************** Builder Implementation of PeriodRate  ***********************/
	class PeriodRateBuilderImpl implements PeriodRate.PeriodRateBuilder {
	
		protected PeriodOptionalEndModel.PeriodOptionalEndModelBuilder periodOptionalEndModel;
		protected BigDecimal rate;
	
		public PeriodRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodOptionalEndModel")
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getPeriodOptionalEndModel() {
			return periodOptionalEndModel;
		}
		
		@Override
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder getOrCreatePeriodOptionalEndModel() {
			PeriodOptionalEndModel.PeriodOptionalEndModelBuilder result;
			if (periodOptionalEndModel!=null) {
				result = periodOptionalEndModel;
			}
			else {
				result = periodOptionalEndModel = PeriodOptionalEndModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("periodOptionalEndModel")
		public PeriodRate.PeriodRateBuilder setPeriodOptionalEndModel(PeriodOptionalEndModel periodOptionalEndModel) {
			this.periodOptionalEndModel = periodOptionalEndModel==null?null:periodOptionalEndModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public PeriodRate.PeriodRateBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		
		@Override
		public PeriodRate build() {
			return new PeriodRate.PeriodRateImpl(this);
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodRate.PeriodRateBuilder prune() {
			if (periodOptionalEndModel!=null && !periodOptionalEndModel.prune().hasData()) periodOptionalEndModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodOptionalEndModel()!=null && getPeriodOptionalEndModel().hasData()) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodRate.PeriodRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodRate.PeriodRateBuilder o = (PeriodRate.PeriodRateBuilder) other;
			
			merger.mergeRosetta(getPeriodOptionalEndModel(), o.getPeriodOptionalEndModel(), this::setPeriodOptionalEndModel);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodRate _that = getType().cast(o);
		
			if (!Objects.equals(periodOptionalEndModel, _that.getPeriodOptionalEndModel())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodOptionalEndModel != null ? periodOptionalEndModel.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodRateBuilder {" +
				"periodOptionalEndModel=" + this.periodOptionalEndModel + ", " +
				"rate=" + this.rate +
			'}';
		}
	}
}
