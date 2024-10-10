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
import fpml.confirmation.FxTerms;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.OutstandingsPosition;
import fpml.confirmation.OutstandingsPosition.OutstandingsPositionBuilder;
import fpml.confirmation.OutstandingsPosition.OutstandingsPositionBuilderImpl;
import fpml.confirmation.OutstandingsPosition.OutstandingsPositionImpl;
import fpml.confirmation.meta.OutstandingsPositionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents outstanding loan contracts or outstanding letter of credit position. Both the global and lender position (current and prior) levels can be represented.
 * @version ${project.version}
 */
@RosettaDataType(value="OutstandingsPosition", builder=OutstandingsPosition.OutstandingsPositionBuilderImpl.class, version="${project.version}")
public interface OutstandingsPosition extends RosettaModelObject {

	OutstandingsPositionMeta metaData = new OutstandingsPositionMeta();

	/*********************** Getter Methods  ***********************/
	LoanContractReference getLoanContractReference();
	LetterOfCreditReference getLetterOfCreditReference();
	/**
	 * The global and share amounts against the associated instrument. This is after any referenced business events have taken place.
	 */
	MoneyWithParticipantShare getAmount();
	/**
	 * The global and share amounts against the associated instrument. This is prior to any referenced business events.
	 */
	MoneyWithParticipantShare getPriorAmount();
	/**
	 * Defines a single (current) FX rate used to calculate utilization in the facility currency. Used in the case where the loan contract currency is different to the facility currency.
	 */
	FxTerms getFacilityFxRate();

	/*********************** Build Methods  ***********************/
	OutstandingsPosition build();
	
	OutstandingsPosition.OutstandingsPositionBuilder toBuilder();
	
	static OutstandingsPosition.OutstandingsPositionBuilder builder() {
		return new OutstandingsPosition.OutstandingsPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OutstandingsPosition> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OutstandingsPosition> getType() {
		return OutstandingsPosition.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("priorAmount"), processor, MoneyWithParticipantShare.class, getPriorAmount());
		processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.class, getFacilityFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OutstandingsPositionBuilder extends OutstandingsPosition, RosettaModelObjectBuilder {
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference();
		LoanContractReference.LoanContractReferenceBuilder getLoanContractReference();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreatePriorAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getPriorAmount();
		FxTerms.FxTermsBuilder getOrCreateFacilityFxRate();
		FxTerms.FxTermsBuilder getFacilityFxRate();
		OutstandingsPosition.OutstandingsPositionBuilder setLoanContractReference(LoanContractReference loanContractReference);
		OutstandingsPosition.OutstandingsPositionBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		OutstandingsPosition.OutstandingsPositionBuilder setAmount(MoneyWithParticipantShare amount);
		OutstandingsPosition.OutstandingsPositionBuilder setPriorAmount(MoneyWithParticipantShare priorAmount);
		OutstandingsPosition.OutstandingsPositionBuilder setFacilityFxRate(FxTerms facilityFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("priorAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getPriorAmount());
			processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.FxTermsBuilder.class, getFacilityFxRate());
		}
		

		OutstandingsPosition.OutstandingsPositionBuilder prune();
	}

	/*********************** Immutable Implementation of OutstandingsPosition  ***********************/
	class OutstandingsPositionImpl implements OutstandingsPosition {
		private final LoanContractReference loanContractReference;
		private final LetterOfCreditReference letterOfCreditReference;
		private final MoneyWithParticipantShare amount;
		private final MoneyWithParticipantShare priorAmount;
		private final FxTerms facilityFxRate;
		
		protected OutstandingsPositionImpl(OutstandingsPosition.OutstandingsPositionBuilder builder) {
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).map(f->f.build()).orElse(null);
			this.letterOfCreditReference = ofNullable(builder.getLetterOfCreditReference()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.priorAmount = ofNullable(builder.getPriorAmount()).map(f->f.build()).orElse(null);
			this.facilityFxRate = ofNullable(builder.getFacilityFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractReference getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LetterOfCreditReference getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("priorAmount")
		public MoneyWithParticipantShare getPriorAmount() {
			return priorAmount;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		public FxTerms getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public OutstandingsPosition build() {
			return this;
		}
		
		@Override
		public OutstandingsPosition.OutstandingsPositionBuilder toBuilder() {
			OutstandingsPosition.OutstandingsPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OutstandingsPosition.OutstandingsPositionBuilder builder) {
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
			ofNullable(getLetterOfCreditReference()).ifPresent(builder::setLetterOfCreditReference);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPriorAmount()).ifPresent(builder::setPriorAmount);
			ofNullable(getFacilityFxRate()).ifPresent(builder::setFacilityFxRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OutstandingsPosition _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(priorAmount, _that.getPriorAmount())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (priorAmount != null ? priorAmount.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingsPosition {" +
				"loanContractReference=" + this.loanContractReference + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference + ", " +
				"amount=" + this.amount + ", " +
				"priorAmount=" + this.priorAmount + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}';
		}
	}

	/*********************** Builder Implementation of OutstandingsPosition  ***********************/
	class OutstandingsPositionBuilderImpl implements OutstandingsPosition.OutstandingsPositionBuilder {
	
		protected LoanContractReference.LoanContractReferenceBuilder loanContractReference;
		protected LetterOfCreditReference.LetterOfCreditReferenceBuilder letterOfCreditReference;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder priorAmount;
		protected FxTerms.FxTermsBuilder facilityFxRate;
	
		public OutstandingsPositionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractReference.LoanContractReferenceBuilder getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference() {
			LoanContractReference.LoanContractReferenceBuilder result;
			if (loanContractReference!=null) {
				result = loanContractReference;
			}
			else {
				result = loanContractReference = LoanContractReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference() {
			LetterOfCreditReference.LetterOfCreditReferenceBuilder result;
			if (letterOfCreditReference!=null) {
				result = letterOfCreditReference;
			}
			else {
				result = letterOfCreditReference = LetterOfCreditReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priorAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getPriorAmount() {
			return priorAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreatePriorAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (priorAmount!=null) {
				result = priorAmount;
			}
			else {
				result = priorAmount = MoneyWithParticipantShare.builder();
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
		@RosettaAttribute("loanContractReference")
		public OutstandingsPosition.OutstandingsPositionBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public OutstandingsPosition.OutstandingsPositionBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public OutstandingsPosition.OutstandingsPositionBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("priorAmount")
		public OutstandingsPosition.OutstandingsPositionBuilder setPriorAmount(MoneyWithParticipantShare priorAmount) {
			this.priorAmount = priorAmount==null?null:priorAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFxRate")
		public OutstandingsPosition.OutstandingsPositionBuilder setFacilityFxRate(FxTerms facilityFxRate) {
			this.facilityFxRate = facilityFxRate==null?null:facilityFxRate.toBuilder();
			return this;
		}
		
		@Override
		public OutstandingsPosition build() {
			return new OutstandingsPosition.OutstandingsPositionImpl(this);
		}
		
		@Override
		public OutstandingsPosition.OutstandingsPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingsPosition.OutstandingsPositionBuilder prune() {
			if (loanContractReference!=null && !loanContractReference.prune().hasData()) loanContractReference = null;
			if (letterOfCreditReference!=null && !letterOfCreditReference.prune().hasData()) letterOfCreditReference = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (priorAmount!=null && !priorAmount.prune().hasData()) priorAmount = null;
			if (facilityFxRate!=null && !facilityFxRate.prune().hasData()) facilityFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanContractReference()!=null && getLoanContractReference().hasData()) return true;
			if (getLetterOfCreditReference()!=null && getLetterOfCreditReference().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getPriorAmount()!=null && getPriorAmount().hasData()) return true;
			if (getFacilityFxRate()!=null && getFacilityFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingsPosition.OutstandingsPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OutstandingsPosition.OutstandingsPositionBuilder o = (OutstandingsPosition.OutstandingsPositionBuilder) other;
			
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::setLoanContractReference);
			merger.mergeRosetta(getLetterOfCreditReference(), o.getLetterOfCreditReference(), this::setLetterOfCreditReference);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getPriorAmount(), o.getPriorAmount(), this::setPriorAmount);
			merger.mergeRosetta(getFacilityFxRate(), o.getFacilityFxRate(), this::setFacilityFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OutstandingsPosition _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(priorAmount, _that.getPriorAmount())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (priorAmount != null ? priorAmount.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingsPositionBuilder {" +
				"loanContractReference=" + this.loanContractReference + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference + ", " +
				"amount=" + this.amount + ", " +
				"priorAmount=" + this.priorAmount + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}';
		}
	}
}
