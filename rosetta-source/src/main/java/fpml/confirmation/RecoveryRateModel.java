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
import fpml.confirmation.RecoveryRateModel;
import fpml.confirmation.RecoveryRateModel.RecoveryRateModelBuilder;
import fpml.confirmation.RecoveryRateModel.RecoveryRateModelBuilderImpl;
import fpml.confirmation.RecoveryRateModel.RecoveryRateModelImpl;
import fpml.confirmation.TermCurve;
import fpml.confirmation.meta.RecoveryRateModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The model of the recovery rate (single value or curve).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RecoveryRateModel", builder=RecoveryRateModel.RecoveryRateModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RecoveryRateModel extends RosettaModelObject {

	RecoveryRateModelMeta metaData = new RecoveryRateModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A single recovery rate, to be used for all terms.
	 */
	BigDecimal getRecoveryRate();
	/**
	 * A curve of recovery rates, allowing different terms to have different recovery rates.
	 */
	TermCurve getRecoveryRateCurve();

	/*********************** Build Methods  ***********************/
	RecoveryRateModel build();
	
	RecoveryRateModel.RecoveryRateModelBuilder toBuilder();
	
	static RecoveryRateModel.RecoveryRateModelBuilder builder() {
		return new RecoveryRateModel.RecoveryRateModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RecoveryRateModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RecoveryRateModel> getType() {
		return RecoveryRateModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("recoveryRate"), BigDecimal.class, getRecoveryRate(), this);
		processRosetta(path.newSubPath("recoveryRateCurve"), processor, TermCurve.class, getRecoveryRateCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RecoveryRateModelBuilder extends RecoveryRateModel, RosettaModelObjectBuilder {
		TermCurve.TermCurveBuilder getOrCreateRecoveryRateCurve();
		TermCurve.TermCurveBuilder getRecoveryRateCurve();
		RecoveryRateModel.RecoveryRateModelBuilder setRecoveryRate(BigDecimal recoveryRate);
		RecoveryRateModel.RecoveryRateModelBuilder setRecoveryRateCurve(TermCurve recoveryRateCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("recoveryRate"), BigDecimal.class, getRecoveryRate(), this);
			processRosetta(path.newSubPath("recoveryRateCurve"), processor, TermCurve.TermCurveBuilder.class, getRecoveryRateCurve());
		}
		

		RecoveryRateModel.RecoveryRateModelBuilder prune();
	}

	/*********************** Immutable Implementation of RecoveryRateModel  ***********************/
	class RecoveryRateModelImpl implements RecoveryRateModel {
		private final BigDecimal recoveryRate;
		private final TermCurve recoveryRateCurve;
		
		protected RecoveryRateModelImpl(RecoveryRateModel.RecoveryRateModelBuilder builder) {
			this.recoveryRate = builder.getRecoveryRate();
			this.recoveryRateCurve = ofNullable(builder.getRecoveryRateCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("recoveryRate")
		public BigDecimal getRecoveryRate() {
			return recoveryRate;
		}
		
		@Override
		@RosettaAttribute("recoveryRateCurve")
		public TermCurve getRecoveryRateCurve() {
			return recoveryRateCurve;
		}
		
		@Override
		public RecoveryRateModel build() {
			return this;
		}
		
		@Override
		public RecoveryRateModel.RecoveryRateModelBuilder toBuilder() {
			RecoveryRateModel.RecoveryRateModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RecoveryRateModel.RecoveryRateModelBuilder builder) {
			ofNullable(getRecoveryRate()).ifPresent(builder::setRecoveryRate);
			ofNullable(getRecoveryRateCurve()).ifPresent(builder::setRecoveryRateCurve);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecoveryRateModel _that = getType().cast(o);
		
			if (!Objects.equals(recoveryRate, _that.getRecoveryRate())) return false;
			if (!Objects.equals(recoveryRateCurve, _that.getRecoveryRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (recoveryRate != null ? recoveryRate.hashCode() : 0);
			_result = 31 * _result + (recoveryRateCurve != null ? recoveryRateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RecoveryRateModel {" +
				"recoveryRate=" + this.recoveryRate + ", " +
				"recoveryRateCurve=" + this.recoveryRateCurve +
			'}';
		}
	}

	/*********************** Builder Implementation of RecoveryRateModel  ***********************/
	class RecoveryRateModelBuilderImpl implements RecoveryRateModel.RecoveryRateModelBuilder {
	
		protected BigDecimal recoveryRate;
		protected TermCurve.TermCurveBuilder recoveryRateCurve;
	
		public RecoveryRateModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("recoveryRate")
		public BigDecimal getRecoveryRate() {
			return recoveryRate;
		}
		
		@Override
		@RosettaAttribute("recoveryRateCurve")
		public TermCurve.TermCurveBuilder getRecoveryRateCurve() {
			return recoveryRateCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateRecoveryRateCurve() {
			TermCurve.TermCurveBuilder result;
			if (recoveryRateCurve!=null) {
				result = recoveryRateCurve;
			}
			else {
				result = recoveryRateCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("recoveryRate")
		public RecoveryRateModel.RecoveryRateModelBuilder setRecoveryRate(BigDecimal recoveryRate) {
			this.recoveryRate = recoveryRate==null?null:recoveryRate;
			return this;
		}
		@Override
		@RosettaAttribute("recoveryRateCurve")
		public RecoveryRateModel.RecoveryRateModelBuilder setRecoveryRateCurve(TermCurve recoveryRateCurve) {
			this.recoveryRateCurve = recoveryRateCurve==null?null:recoveryRateCurve.toBuilder();
			return this;
		}
		
		@Override
		public RecoveryRateModel build() {
			return new RecoveryRateModel.RecoveryRateModelImpl(this);
		}
		
		@Override
		public RecoveryRateModel.RecoveryRateModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecoveryRateModel.RecoveryRateModelBuilder prune() {
			if (recoveryRateCurve!=null && !recoveryRateCurve.prune().hasData()) recoveryRateCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRecoveryRate()!=null) return true;
			if (getRecoveryRateCurve()!=null && getRecoveryRateCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecoveryRateModel.RecoveryRateModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RecoveryRateModel.RecoveryRateModelBuilder o = (RecoveryRateModel.RecoveryRateModelBuilder) other;
			
			merger.mergeRosetta(getRecoveryRateCurve(), o.getRecoveryRateCurve(), this::setRecoveryRateCurve);
			
			merger.mergeBasic(getRecoveryRate(), o.getRecoveryRate(), this::setRecoveryRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecoveryRateModel _that = getType().cast(o);
		
			if (!Objects.equals(recoveryRate, _that.getRecoveryRate())) return false;
			if (!Objects.equals(recoveryRateCurve, _that.getRecoveryRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (recoveryRate != null ? recoveryRate.hashCode() : 0);
			_result = 31 * _result + (recoveryRateCurve != null ? recoveryRateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RecoveryRateModelBuilder {" +
				"recoveryRate=" + this.recoveryRate + ", " +
				"recoveryRateCurve=" + this.recoveryRateCurve +
			'}';
		}
	}
}
