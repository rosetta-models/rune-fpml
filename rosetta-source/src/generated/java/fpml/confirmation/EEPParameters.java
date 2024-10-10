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
import fpml.confirmation.EEPParameters;
import fpml.confirmation.EEPParameters.EEPParametersBuilder;
import fpml.confirmation.EEPParameters.EEPParametersBuilderImpl;
import fpml.confirmation.EEPParameters.EEPParametersImpl;
import fpml.confirmation.EEPRiskPeriod;
import fpml.confirmation.meta.EEPParametersMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Excess Emission Penalty related parameters.
 * @version ${project.version}
 */
@RosettaDataType(value="EEPParameters", builder=EEPParameters.EEPParametersBuilderImpl.class, version="${project.version}")
public interface EEPParameters extends RosettaModelObject {

	EEPParametersMeta metaData = new EEPParametersMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If Excess Emission Penalty is specified to be applicable in the Confirmation then the Excess Emission Penalty will be determined in the manner specified in the Confirmation (see other EEP parameters)
	 */
	Boolean getEEPApplicable();
	/**
	 * Used to determine how provisions in Part [7] Page 7 (B) Failure to Deliver Not Remedied are to be applied.
	 */
	EEPRiskPeriod getRiskPeriod();
	/**
	 * When &quot;true&quot; the EEP Equivalent is applicable. See Part [7] definition of EEP Equivalent.
	 */
	Boolean getEquivalentApplicable();
	/**
	 * When &quot;true&quot; the Excess Emissions Penalty is applicable. See Part [7] definition of Excess Emissions Penalty.
	 */
	Boolean getPenaltyApplicable();

	/*********************** Build Methods  ***********************/
	EEPParameters build();
	
	EEPParameters.EEPParametersBuilder toBuilder();
	
	static EEPParameters.EEPParametersBuilder builder() {
		return new EEPParameters.EEPParametersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EEPParameters> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EEPParameters> getType() {
		return EEPParameters.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("eEPApplicable"), Boolean.class, getEEPApplicable(), this);
		processRosetta(path.newSubPath("riskPeriod"), processor, EEPRiskPeriod.class, getRiskPeriod());
		processor.processBasic(path.newSubPath("equivalentApplicable"), Boolean.class, getEquivalentApplicable(), this);
		processor.processBasic(path.newSubPath("penaltyApplicable"), Boolean.class, getPenaltyApplicable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EEPParametersBuilder extends EEPParameters, RosettaModelObjectBuilder {
		EEPRiskPeriod.EEPRiskPeriodBuilder getOrCreateRiskPeriod();
		EEPRiskPeriod.EEPRiskPeriodBuilder getRiskPeriod();
		EEPParameters.EEPParametersBuilder setEEPApplicable(Boolean eEPApplicable);
		EEPParameters.EEPParametersBuilder setRiskPeriod(EEPRiskPeriod riskPeriod);
		EEPParameters.EEPParametersBuilder setEquivalentApplicable(Boolean equivalentApplicable);
		EEPParameters.EEPParametersBuilder setPenaltyApplicable(Boolean penaltyApplicable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("eEPApplicable"), Boolean.class, getEEPApplicable(), this);
			processRosetta(path.newSubPath("riskPeriod"), processor, EEPRiskPeriod.EEPRiskPeriodBuilder.class, getRiskPeriod());
			processor.processBasic(path.newSubPath("equivalentApplicable"), Boolean.class, getEquivalentApplicable(), this);
			processor.processBasic(path.newSubPath("penaltyApplicable"), Boolean.class, getPenaltyApplicable(), this);
		}
		

		EEPParameters.EEPParametersBuilder prune();
	}

	/*********************** Immutable Implementation of EEPParameters  ***********************/
	class EEPParametersImpl implements EEPParameters {
		private final Boolean eEPApplicable;
		private final EEPRiskPeriod riskPeriod;
		private final Boolean equivalentApplicable;
		private final Boolean penaltyApplicable;
		
		protected EEPParametersImpl(EEPParameters.EEPParametersBuilder builder) {
			this.eEPApplicable = builder.getEEPApplicable();
			this.riskPeriod = ofNullable(builder.getRiskPeriod()).map(f->f.build()).orElse(null);
			this.equivalentApplicable = builder.getEquivalentApplicable();
			this.penaltyApplicable = builder.getPenaltyApplicable();
		}
		
		@Override
		@RosettaAttribute("eEPApplicable")
		public Boolean getEEPApplicable() {
			return eEPApplicable;
		}
		
		@Override
		@RosettaAttribute("riskPeriod")
		public EEPRiskPeriod getRiskPeriod() {
			return riskPeriod;
		}
		
		@Override
		@RosettaAttribute("equivalentApplicable")
		public Boolean getEquivalentApplicable() {
			return equivalentApplicable;
		}
		
		@Override
		@RosettaAttribute("penaltyApplicable")
		public Boolean getPenaltyApplicable() {
			return penaltyApplicable;
		}
		
		@Override
		public EEPParameters build() {
			return this;
		}
		
		@Override
		public EEPParameters.EEPParametersBuilder toBuilder() {
			EEPParameters.EEPParametersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EEPParameters.EEPParametersBuilder builder) {
			ofNullable(getEEPApplicable()).ifPresent(builder::setEEPApplicable);
			ofNullable(getRiskPeriod()).ifPresent(builder::setRiskPeriod);
			ofNullable(getEquivalentApplicable()).ifPresent(builder::setEquivalentApplicable);
			ofNullable(getPenaltyApplicable()).ifPresent(builder::setPenaltyApplicable);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EEPParameters _that = getType().cast(o);
		
			if (!Objects.equals(eEPApplicable, _that.getEEPApplicable())) return false;
			if (!Objects.equals(riskPeriod, _that.getRiskPeriod())) return false;
			if (!Objects.equals(equivalentApplicable, _that.getEquivalentApplicable())) return false;
			if (!Objects.equals(penaltyApplicable, _that.getPenaltyApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eEPApplicable != null ? eEPApplicable.hashCode() : 0);
			_result = 31 * _result + (riskPeriod != null ? riskPeriod.hashCode() : 0);
			_result = 31 * _result + (equivalentApplicable != null ? equivalentApplicable.hashCode() : 0);
			_result = 31 * _result + (penaltyApplicable != null ? penaltyApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EEPParameters {" +
				"eEPApplicable=" + this.eEPApplicable + ", " +
				"riskPeriod=" + this.riskPeriod + ", " +
				"equivalentApplicable=" + this.equivalentApplicable + ", " +
				"penaltyApplicable=" + this.penaltyApplicable +
			'}';
		}
	}

	/*********************** Builder Implementation of EEPParameters  ***********************/
	class EEPParametersBuilderImpl implements EEPParameters.EEPParametersBuilder {
	
		protected Boolean eEPApplicable;
		protected EEPRiskPeriod.EEPRiskPeriodBuilder riskPeriod;
		protected Boolean equivalentApplicable;
		protected Boolean penaltyApplicable;
	
		public EEPParametersBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eEPApplicable")
		public Boolean getEEPApplicable() {
			return eEPApplicable;
		}
		
		@Override
		@RosettaAttribute("riskPeriod")
		public EEPRiskPeriod.EEPRiskPeriodBuilder getRiskPeriod() {
			return riskPeriod;
		}
		
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder getOrCreateRiskPeriod() {
			EEPRiskPeriod.EEPRiskPeriodBuilder result;
			if (riskPeriod!=null) {
				result = riskPeriod;
			}
			else {
				result = riskPeriod = EEPRiskPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equivalentApplicable")
		public Boolean getEquivalentApplicable() {
			return equivalentApplicable;
		}
		
		@Override
		@RosettaAttribute("penaltyApplicable")
		public Boolean getPenaltyApplicable() {
			return penaltyApplicable;
		}
		
		@Override
		@RosettaAttribute("eEPApplicable")
		public EEPParameters.EEPParametersBuilder setEEPApplicable(Boolean eEPApplicable) {
			this.eEPApplicable = eEPApplicable==null?null:eEPApplicable;
			return this;
		}
		@Override
		@RosettaAttribute("riskPeriod")
		public EEPParameters.EEPParametersBuilder setRiskPeriod(EEPRiskPeriod riskPeriod) {
			this.riskPeriod = riskPeriod==null?null:riskPeriod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equivalentApplicable")
		public EEPParameters.EEPParametersBuilder setEquivalentApplicable(Boolean equivalentApplicable) {
			this.equivalentApplicable = equivalentApplicable==null?null:equivalentApplicable;
			return this;
		}
		@Override
		@RosettaAttribute("penaltyApplicable")
		public EEPParameters.EEPParametersBuilder setPenaltyApplicable(Boolean penaltyApplicable) {
			this.penaltyApplicable = penaltyApplicable==null?null:penaltyApplicable;
			return this;
		}
		
		@Override
		public EEPParameters build() {
			return new EEPParameters.EEPParametersImpl(this);
		}
		
		@Override
		public EEPParameters.EEPParametersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EEPParameters.EEPParametersBuilder prune() {
			if (riskPeriod!=null && !riskPeriod.prune().hasData()) riskPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEEPApplicable()!=null) return true;
			if (getRiskPeriod()!=null && getRiskPeriod().hasData()) return true;
			if (getEquivalentApplicable()!=null) return true;
			if (getPenaltyApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EEPParameters.EEPParametersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EEPParameters.EEPParametersBuilder o = (EEPParameters.EEPParametersBuilder) other;
			
			merger.mergeRosetta(getRiskPeriod(), o.getRiskPeriod(), this::setRiskPeriod);
			
			merger.mergeBasic(getEEPApplicable(), o.getEEPApplicable(), this::setEEPApplicable);
			merger.mergeBasic(getEquivalentApplicable(), o.getEquivalentApplicable(), this::setEquivalentApplicable);
			merger.mergeBasic(getPenaltyApplicable(), o.getPenaltyApplicable(), this::setPenaltyApplicable);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EEPParameters _that = getType().cast(o);
		
			if (!Objects.equals(eEPApplicable, _that.getEEPApplicable())) return false;
			if (!Objects.equals(riskPeriod, _that.getRiskPeriod())) return false;
			if (!Objects.equals(equivalentApplicable, _that.getEquivalentApplicable())) return false;
			if (!Objects.equals(penaltyApplicable, _that.getPenaltyApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eEPApplicable != null ? eEPApplicable.hashCode() : 0);
			_result = 31 * _result + (riskPeriod != null ? riskPeriod.hashCode() : 0);
			_result = 31 * _result + (equivalentApplicable != null ? equivalentApplicable.hashCode() : 0);
			_result = 31 * _result + (penaltyApplicable != null ? penaltyApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EEPParametersBuilder {" +
				"eEPApplicable=" + this.eEPApplicable + ", " +
				"riskPeriod=" + this.riskPeriod + ", " +
				"equivalentApplicable=" + this.equivalentApplicable + ", " +
				"penaltyApplicable=" + this.penaltyApplicable +
			'}';
		}
	}
}
