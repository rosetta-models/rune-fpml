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
import fpml.confirmation.FacilityRatesModel;
import fpml.confirmation.FacilityRatesModel.FacilityRatesModelBuilder;
import fpml.confirmation.FacilityRatesModel.FacilityRatesModelBuilderImpl;
import fpml.confirmation.FacilityRatesModel.FacilityRatesModelImpl;
import fpml.confirmation.PeriodRate;
import fpml.confirmation.meta.FacilityRatesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes various facility rate details.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityRatesModel", builder=FacilityRatesModel.FacilityRatesModelBuilderImpl.class, version="${project.version}")
public interface FacilityRatesModel extends RosettaModelObject {

	FacilityRatesModelMeta metaData = new FacilityRatesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This represents a default rate that may apply in addition to a regular margin rate (on outstanding loan contracts). This rate applied at the discretion of the agent bank, if the borrower is deemed to be in default.
	 */
	PeriodRate getDefaultRate();
	/**
	 * The mandatory cost rate currently applied to the interest rate period.
	 */
	PeriodRate getMandatoryCostRate();
	/**
	 * This represents a penalty rate that may apply in addition to the regular margin rate (on outstanding loan contracts). This rate is applied at the discretion of the agent bank, if the borrower has broken terms stated within the credit agreement.
	 */
	PeriodRate getPenaltyRate();

	/*********************** Build Methods  ***********************/
	FacilityRatesModel build();
	
	FacilityRatesModel.FacilityRatesModelBuilder toBuilder();
	
	static FacilityRatesModel.FacilityRatesModelBuilder builder() {
		return new FacilityRatesModel.FacilityRatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityRatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityRatesModel> getType() {
		return FacilityRatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.class, getDefaultRate());
		processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.class, getMandatoryCostRate());
		processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.class, getPenaltyRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityRatesModelBuilder extends FacilityRatesModel, RosettaModelObjectBuilder {
		PeriodRate.PeriodRateBuilder getOrCreateDefaultRate();
		PeriodRate.PeriodRateBuilder getDefaultRate();
		PeriodRate.PeriodRateBuilder getOrCreateMandatoryCostRate();
		PeriodRate.PeriodRateBuilder getMandatoryCostRate();
		PeriodRate.PeriodRateBuilder getOrCreatePenaltyRate();
		PeriodRate.PeriodRateBuilder getPenaltyRate();
		FacilityRatesModel.FacilityRatesModelBuilder setDefaultRate(PeriodRate defaultRate);
		FacilityRatesModel.FacilityRatesModelBuilder setMandatoryCostRate(PeriodRate mandatoryCostRate);
		FacilityRatesModel.FacilityRatesModelBuilder setPenaltyRate(PeriodRate penaltyRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.PeriodRateBuilder.class, getDefaultRate());
			processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.PeriodRateBuilder.class, getMandatoryCostRate());
			processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.PeriodRateBuilder.class, getPenaltyRate());
		}
		

		FacilityRatesModel.FacilityRatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityRatesModel  ***********************/
	class FacilityRatesModelImpl implements FacilityRatesModel {
		private final PeriodRate defaultRate;
		private final PeriodRate mandatoryCostRate;
		private final PeriodRate penaltyRate;
		
		protected FacilityRatesModelImpl(FacilityRatesModel.FacilityRatesModelBuilder builder) {
			this.defaultRate = ofNullable(builder.getDefaultRate()).map(f->f.build()).orElse(null);
			this.mandatoryCostRate = ofNullable(builder.getMandatoryCostRate()).map(f->f.build()).orElse(null);
			this.penaltyRate = ofNullable(builder.getPenaltyRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("defaultRate")
		public PeriodRate getDefaultRate() {
			return defaultRate;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		public PeriodRate getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		@RosettaAttribute("penaltyRate")
		public PeriodRate getPenaltyRate() {
			return penaltyRate;
		}
		
		@Override
		public FacilityRatesModel build() {
			return this;
		}
		
		@Override
		public FacilityRatesModel.FacilityRatesModelBuilder toBuilder() {
			FacilityRatesModel.FacilityRatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityRatesModel.FacilityRatesModelBuilder builder) {
			ofNullable(getDefaultRate()).ifPresent(builder::setDefaultRate);
			ofNullable(getMandatoryCostRate()).ifPresent(builder::setMandatoryCostRate);
			ofNullable(getPenaltyRate()).ifPresent(builder::setPenaltyRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityRatesModel _that = getType().cast(o);
		
			if (!Objects.equals(defaultRate, _that.getDefaultRate())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(penaltyRate, _that.getPenaltyRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (defaultRate != null ? defaultRate.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (penaltyRate != null ? penaltyRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRatesModel {" +
				"defaultRate=" + this.defaultRate + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"penaltyRate=" + this.penaltyRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityRatesModel  ***********************/
	class FacilityRatesModelBuilderImpl implements FacilityRatesModel.FacilityRatesModelBuilder {
	
		protected PeriodRate.PeriodRateBuilder defaultRate;
		protected PeriodRate.PeriodRateBuilder mandatoryCostRate;
		protected PeriodRate.PeriodRateBuilder penaltyRate;
	
		public FacilityRatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("defaultRate")
		public PeriodRate.PeriodRateBuilder getDefaultRate() {
			return defaultRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateDefaultRate() {
			PeriodRate.PeriodRateBuilder result;
			if (defaultRate!=null) {
				result = defaultRate;
			}
			else {
				result = defaultRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		public PeriodRate.PeriodRateBuilder getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateMandatoryCostRate() {
			PeriodRate.PeriodRateBuilder result;
			if (mandatoryCostRate!=null) {
				result = mandatoryCostRate;
			}
			else {
				result = mandatoryCostRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("penaltyRate")
		public PeriodRate.PeriodRateBuilder getPenaltyRate() {
			return penaltyRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreatePenaltyRate() {
			PeriodRate.PeriodRateBuilder result;
			if (penaltyRate!=null) {
				result = penaltyRate;
			}
			else {
				result = penaltyRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("defaultRate")
		public FacilityRatesModel.FacilityRatesModelBuilder setDefaultRate(PeriodRate defaultRate) {
			this.defaultRate = defaultRate==null?null:defaultRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryCostRate")
		public FacilityRatesModel.FacilityRatesModelBuilder setMandatoryCostRate(PeriodRate mandatoryCostRate) {
			this.mandatoryCostRate = mandatoryCostRate==null?null:mandatoryCostRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("penaltyRate")
		public FacilityRatesModel.FacilityRatesModelBuilder setPenaltyRate(PeriodRate penaltyRate) {
			this.penaltyRate = penaltyRate==null?null:penaltyRate.toBuilder();
			return this;
		}
		
		@Override
		public FacilityRatesModel build() {
			return new FacilityRatesModel.FacilityRatesModelImpl(this);
		}
		
		@Override
		public FacilityRatesModel.FacilityRatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRatesModel.FacilityRatesModelBuilder prune() {
			if (defaultRate!=null && !defaultRate.prune().hasData()) defaultRate = null;
			if (mandatoryCostRate!=null && !mandatoryCostRate.prune().hasData()) mandatoryCostRate = null;
			if (penaltyRate!=null && !penaltyRate.prune().hasData()) penaltyRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDefaultRate()!=null && getDefaultRate().hasData()) return true;
			if (getMandatoryCostRate()!=null && getMandatoryCostRate().hasData()) return true;
			if (getPenaltyRate()!=null && getPenaltyRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRatesModel.FacilityRatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityRatesModel.FacilityRatesModelBuilder o = (FacilityRatesModel.FacilityRatesModelBuilder) other;
			
			merger.mergeRosetta(getDefaultRate(), o.getDefaultRate(), this::setDefaultRate);
			merger.mergeRosetta(getMandatoryCostRate(), o.getMandatoryCostRate(), this::setMandatoryCostRate);
			merger.mergeRosetta(getPenaltyRate(), o.getPenaltyRate(), this::setPenaltyRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityRatesModel _that = getType().cast(o);
		
			if (!Objects.equals(defaultRate, _that.getDefaultRate())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(penaltyRate, _that.getPenaltyRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (defaultRate != null ? defaultRate.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (penaltyRate != null ? penaltyRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRatesModelBuilder {" +
				"defaultRate=" + this.defaultRate + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"penaltyRate=" + this.penaltyRate +
			'}';
		}
	}
}
