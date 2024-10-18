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
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FixedRateAccrual;
import fpml.confirmation.FloatingRateAccrual;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LoanContract;
import fpml.confirmation.LoanContract.LoanContractBuilder;
import fpml.confirmation.LoanContract.LoanContractBuilderImpl;
import fpml.confirmation.LoanContract.LoanContractImpl;
import fpml.confirmation.LoanContractSummary;
import fpml.confirmation.LoanContractSummary.LoanContractSummaryBuilder;
import fpml.confirmation.LoanContractSummary.LoanContractSummaryBuilderImpl;
import fpml.confirmation.LoanContractSummary.LoanContractSummaryImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.LoanContractMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A funded borrowing instrument which utilizes a portion of an available under a single facility (line of credit) within a bank deal (credit agreement).
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContract", builder=LoanContract.LoanContractBuilderImpl.class, version="${project.version}")
public interface LoanContract extends LoanContractSummary {

	LoanContractMeta metaData = new LoanContractMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The maturity date of the loan contract. In the case of a PRIME-based loan, this field should be set to the maturity date of the facility.
	 */
	Date getRepricingDate();
	/**
	 * The maturity date of the loan contract. In the case of a PRIME-based loan, this field should be set to the maturity date of the facility.
	 */
	Date getMaturityDate();
	/**
	 * Defines the base rate and additional charges associated with the loan contract.
	 */
	FixedRateAccrual getFixedRateAccrual();
	/**
	 * Defines the base rate and additional charges associated with the loan contract.
	 */
	FloatingRateAccrual getFloatingRateAccrual();
	/**
	 * Defines a single (current) FX rate used to calculate utilization in the facility currency. Used in the case where the loan contract currency is different to the facility currency.
	 */
	FxTerms getFacilityFxRate();

	/*********************** Build Methods  ***********************/
	LoanContract build();
	
	LoanContract.LoanContractBuilder toBuilder();
	
	static LoanContract.LoanContractBuilder builder() {
		return new LoanContract.LoanContractBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContract> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContract> getType() {
		return LoanContract.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.class, getIdentifier());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("repricingDate"), Date.class, getRepricingDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
		processRosetta(path.newSubPath("fixedRateAccrual"), processor, FixedRateAccrual.class, getFixedRateAccrual());
		processRosetta(path.newSubPath("floatingRateAccrual"), processor, FloatingRateAccrual.class, getFloatingRateAccrual());
		processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.class, getFacilityFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractBuilder extends LoanContract, LoanContractSummary.LoanContractSummaryBuilder {
		FixedRateAccrual.FixedRateAccrualBuilder getOrCreateFixedRateAccrual();
		FixedRateAccrual.FixedRateAccrualBuilder getFixedRateAccrual();
		FloatingRateAccrual.FloatingRateAccrualBuilder getOrCreateFloatingRateAccrual();
		FloatingRateAccrual.FloatingRateAccrualBuilder getFloatingRateAccrual();
		FxTerms.FxTermsBuilder getOrCreateFacilityFxRate();
		FxTerms.FxTermsBuilder getFacilityFxRate();
		LoanContract.LoanContractBuilder addIdentifier(FacilityContractIdentifier identifier0);
		LoanContract.LoanContractBuilder addIdentifier(FacilityContractIdentifier identifier1, int _idx);
		LoanContract.LoanContractBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifier2);
		LoanContract.LoanContractBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifier3);
		LoanContract.LoanContractBuilder setEffectiveDate(Date effectiveDate);
		LoanContract.LoanContractBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		LoanContract.LoanContractBuilder setGuarantorPartyReference(PartyReference guarantorPartyReference);
		LoanContract.LoanContractBuilder setAmount(MoneyWithParticipantShare amount);
		LoanContract.LoanContractBuilder setRepricingDate(Date repricingDate);
		LoanContract.LoanContractBuilder setMaturityDate(Date maturityDate);
		LoanContract.LoanContractBuilder setFixedRateAccrual(FixedRateAccrual fixedRateAccrual);
		LoanContract.LoanContractBuilder setFloatingRateAccrual(FloatingRateAccrual floatingRateAccrual);
		LoanContract.LoanContractBuilder setFacilityFxRate(FxTerms facilityFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.FacilityContractIdentifierBuilder.class, getIdentifier());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("repricingDate"), Date.class, getRepricingDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
			processRosetta(path.newSubPath("fixedRateAccrual"), processor, FixedRateAccrual.FixedRateAccrualBuilder.class, getFixedRateAccrual());
			processRosetta(path.newSubPath("floatingRateAccrual"), processor, FloatingRateAccrual.FloatingRateAccrualBuilder.class, getFloatingRateAccrual());
			processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.FxTermsBuilder.class, getFacilityFxRate());
		}
		

		LoanContract.LoanContractBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContract  ***********************/
	class LoanContractImpl extends LoanContractSummary.LoanContractSummaryImpl implements LoanContract {
		private final Date repricingDate;
		private final Date maturityDate;
		private final FixedRateAccrual fixedRateAccrual;
		private final FloatingRateAccrual floatingRateAccrual;
		private final FxTerms facilityFxRate;
		
		protected LoanContractImpl(LoanContract.LoanContractBuilder builder) {
			super(builder);
			this.repricingDate = builder.getRepricingDate();
			this.maturityDate = builder.getMaturityDate();
			this.fixedRateAccrual = ofNullable(builder.getFixedRateAccrual()).map(f->f.build()).orElse(null);
			this.floatingRateAccrual = ofNullable(builder.getFloatingRateAccrual()).map(f->f.build()).orElse(null);
			this.facilityFxRate = ofNullable(builder.getFacilityFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("repricingDate")
		public Date getRepricingDate() {
			return repricingDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("fixedRateAccrual")
		public FixedRateAccrual getFixedRateAccrual() {
			return fixedRateAccrual;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrual")
		public FloatingRateAccrual getFloatingRateAccrual() {
			return floatingRateAccrual;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		public FxTerms getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public LoanContract build() {
			return this;
		}
		
		@Override
		public LoanContract.LoanContractBuilder toBuilder() {
			LoanContract.LoanContractBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContract.LoanContractBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRepricingDate()).ifPresent(builder::setRepricingDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
			ofNullable(getFixedRateAccrual()).ifPresent(builder::setFixedRateAccrual);
			ofNullable(getFloatingRateAccrual()).ifPresent(builder::setFloatingRateAccrual);
			ofNullable(getFacilityFxRate()).ifPresent(builder::setFacilityFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContract _that = getType().cast(o);
		
			if (!Objects.equals(repricingDate, _that.getRepricingDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(fixedRateAccrual, _that.getFixedRateAccrual())) return false;
			if (!Objects.equals(floatingRateAccrual, _that.getFloatingRateAccrual())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (repricingDate != null ? repricingDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (fixedRateAccrual != null ? fixedRateAccrual.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrual != null ? floatingRateAccrual.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContract {" +
				"repricingDate=" + this.repricingDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"fixedRateAccrual=" + this.fixedRateAccrual + ", " +
				"floatingRateAccrual=" + this.floatingRateAccrual + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContract  ***********************/
	class LoanContractBuilderImpl extends LoanContractSummary.LoanContractSummaryBuilderImpl  implements LoanContract.LoanContractBuilder {
	
		protected Date repricingDate;
		protected Date maturityDate;
		protected FixedRateAccrual.FixedRateAccrualBuilder fixedRateAccrual;
		protected FloatingRateAccrual.FloatingRateAccrualBuilder floatingRateAccrual;
		protected FxTerms.FxTermsBuilder facilityFxRate;
	
		public LoanContractBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("repricingDate")
		public Date getRepricingDate() {
			return repricingDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("fixedRateAccrual")
		public FixedRateAccrual.FixedRateAccrualBuilder getFixedRateAccrual() {
			return fixedRateAccrual;
		}
		
		@Override
		public FixedRateAccrual.FixedRateAccrualBuilder getOrCreateFixedRateAccrual() {
			FixedRateAccrual.FixedRateAccrualBuilder result;
			if (fixedRateAccrual!=null) {
				result = fixedRateAccrual;
			}
			else {
				result = fixedRateAccrual = FixedRateAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrual")
		public FloatingRateAccrual.FloatingRateAccrualBuilder getFloatingRateAccrual() {
			return floatingRateAccrual;
		}
		
		@Override
		public FloatingRateAccrual.FloatingRateAccrualBuilder getOrCreateFloatingRateAccrual() {
			FloatingRateAccrual.FloatingRateAccrualBuilder result;
			if (floatingRateAccrual!=null) {
				result = floatingRateAccrual;
			}
			else {
				result = floatingRateAccrual = FloatingRateAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		public FxTerms.FxTermsBuilder getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateFacilityFxRate() {
			FxTerms.FxTermsBuilder result;
			if (facilityFxRate!=null) {
				result = facilityFxRate;
			}
			else {
				result = facilityFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public LoanContract.LoanContractBuilder addIdentifier(FacilityContractIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContract.LoanContractBuilder addIdentifier(FacilityContractIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public LoanContract.LoanContractBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
			if (identifiers != null) {
				for (FacilityContractIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanContract.LoanContractBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public LoanContract.LoanContractBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public LoanContract.LoanContractBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference) {
			this.borrowerPartyReference = borrowerPartyReference==null?null:borrowerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public LoanContract.LoanContractBuilder setGuarantorPartyReference(PartyReference guarantorPartyReference) {
			this.guarantorPartyReference = guarantorPartyReference==null?null:guarantorPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanContract.LoanContractBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("repricingDate")
		public LoanContract.LoanContractBuilder setRepricingDate(Date repricingDate) {
			this.repricingDate = repricingDate==null?null:repricingDate;
			return this;
		}
		@Override
		@RosettaAttribute("maturityDate")
		public LoanContract.LoanContractBuilder setMaturityDate(Date maturityDate) {
			this.maturityDate = maturityDate==null?null:maturityDate;
			return this;
		}
		@Override
		@RosettaAttribute("fixedRateAccrual")
		public LoanContract.LoanContractBuilder setFixedRateAccrual(FixedRateAccrual fixedRateAccrual) {
			this.fixedRateAccrual = fixedRateAccrual==null?null:fixedRateAccrual.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateAccrual")
		public LoanContract.LoanContractBuilder setFloatingRateAccrual(FloatingRateAccrual floatingRateAccrual) {
			this.floatingRateAccrual = floatingRateAccrual==null?null:floatingRateAccrual.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFxRate")
		public LoanContract.LoanContractBuilder setFacilityFxRate(FxTerms facilityFxRate) {
			this.facilityFxRate = facilityFxRate==null?null:facilityFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LoanContract build() {
			return new LoanContract.LoanContractImpl(this);
		}
		
		@Override
		public LoanContract.LoanContractBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContract.LoanContractBuilder prune() {
			super.prune();
			if (fixedRateAccrual!=null && !fixedRateAccrual.prune().hasData()) fixedRateAccrual = null;
			if (floatingRateAccrual!=null && !floatingRateAccrual.prune().hasData()) floatingRateAccrual = null;
			if (facilityFxRate!=null && !facilityFxRate.prune().hasData()) facilityFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRepricingDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			if (getFixedRateAccrual()!=null && getFixedRateAccrual().hasData()) return true;
			if (getFloatingRateAccrual()!=null && getFloatingRateAccrual().hasData()) return true;
			if (getFacilityFxRate()!=null && getFacilityFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContract.LoanContractBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanContract.LoanContractBuilder o = (LoanContract.LoanContractBuilder) other;
			
			merger.mergeRosetta(getFixedRateAccrual(), o.getFixedRateAccrual(), this::setFixedRateAccrual);
			merger.mergeRosetta(getFloatingRateAccrual(), o.getFloatingRateAccrual(), this::setFloatingRateAccrual);
			merger.mergeRosetta(getFacilityFxRate(), o.getFacilityFxRate(), this::setFacilityFxRate);
			
			merger.mergeBasic(getRepricingDate(), o.getRepricingDate(), this::setRepricingDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContract _that = getType().cast(o);
		
			if (!Objects.equals(repricingDate, _that.getRepricingDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(fixedRateAccrual, _that.getFixedRateAccrual())) return false;
			if (!Objects.equals(floatingRateAccrual, _that.getFloatingRateAccrual())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (repricingDate != null ? repricingDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (fixedRateAccrual != null ? fixedRateAccrual.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrual != null ? floatingRateAccrual.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractBuilder {" +
				"repricingDate=" + this.repricingDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"fixedRateAccrual=" + this.fixedRateAccrual + ", " +
				"floatingRateAccrual=" + this.floatingRateAccrual + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}
}
