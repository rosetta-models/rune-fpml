package fpml.confirmation;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FacilityType;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Lien;
import fpml.confirmation.Loan;
import fpml.confirmation.Loan.LoanBuilder;
import fpml.confirmation.Loan.LoanBuilderImpl;
import fpml.confirmation.Loan.LoanImpl;
import fpml.confirmation.LoanChoice;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetTranche;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.LoanMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a simple underlying asset that is a loan. A type describing a loan underlying asset.
 * @version ${project.version}
 */
@RosettaDataType(value="Loan", builder=Loan.LoanBuilderImpl.class, version="${project.version}")
public interface Loan extends UnderlyingAssetType {

	LoanMeta metaData = new LoanMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends LoanChoice> getLoanChoice();
	/**
	 * Specifies the seniority level of the lien.
	 */
	Lien getLien();
	/**
	 * The type of loan facility (letter of credit, revolving, ...).
	 */
	FacilityType getFacilityType();
	/**
	 * The date when the principal amount of the loan becomes due and payable.
	 */
	Date getMaturity();
	/**
	 * The credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlyer attribute is used to help identify which of the company&#39;s outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
	 */
	Date getCreditAgreementDate();
	/**
	 * The loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
	 */
	UnderlyingAssetTranche getTranche();
	/**
	 * The seniority. E.g. senior, senior secured etc.
	 */
	CreditSeniority getSeniority();

	/*********************** Build Methods  ***********************/
	Loan build();
	
	Loan.LoanBuilder toBuilder();
	
	static Loan.LoanBuilder builder() {
		return new Loan.LoanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Loan> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Loan> getType() {
		return Loan.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("loanChoice"), processor, LoanChoice.class, getLoanChoice());
		processRosetta(path.newSubPath("lien"), processor, Lien.class, getLien());
		processRosetta(path.newSubPath("facilityType"), processor, FacilityType.class, getFacilityType());
		processor.processBasic(path.newSubPath("maturity"), Date.class, getMaturity(), this);
		processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
		processRosetta(path.newSubPath("tranche"), processor, UnderlyingAssetTranche.class, getTranche());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBuilder extends Loan, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		LoanChoice.LoanChoiceBuilder getOrCreateLoanChoice(int _index);
		List<? extends LoanChoice.LoanChoiceBuilder> getLoanChoice();
		Lien.LienBuilder getOrCreateLien();
		Lien.LienBuilder getLien();
		FacilityType.FacilityTypeBuilder getOrCreateFacilityType();
		FacilityType.FacilityTypeBuilder getFacilityType();
		UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getOrCreateTranche();
		UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getTranche();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		Loan.LoanBuilder setId(String id);
		Loan.LoanBuilder addInstrumentId(InstrumentId instrumentId0);
		Loan.LoanBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Loan.LoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Loan.LoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Loan.LoanBuilder setDescription(String description);
		Loan.LoanBuilder setCurrency(IdentifiedCurrency currency);
		Loan.LoanBuilder setExchangeId(ExchangeId exchangeId);
		Loan.LoanBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Loan.LoanBuilder setDefinition(ProductReference definition);
		Loan.LoanBuilder addLoanChoice(LoanChoice loanChoice0);
		Loan.LoanBuilder addLoanChoice(LoanChoice loanChoice1, int _idx);
		Loan.LoanBuilder addLoanChoice(List<? extends LoanChoice> loanChoice2);
		Loan.LoanBuilder setLoanChoice(List<? extends LoanChoice> loanChoice3);
		Loan.LoanBuilder setLien(Lien lien);
		Loan.LoanBuilder setFacilityType(FacilityType facilityType);
		Loan.LoanBuilder setMaturity(Date maturity);
		Loan.LoanBuilder setCreditAgreementDate(Date creditAgreementDate);
		Loan.LoanBuilder setTranche(UnderlyingAssetTranche tranche);
		Loan.LoanBuilder setSeniority(CreditSeniority seniority);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("loanChoice"), processor, LoanChoice.LoanChoiceBuilder.class, getLoanChoice());
			processRosetta(path.newSubPath("lien"), processor, Lien.LienBuilder.class, getLien());
			processRosetta(path.newSubPath("facilityType"), processor, FacilityType.FacilityTypeBuilder.class, getFacilityType());
			processor.processBasic(path.newSubPath("maturity"), Date.class, getMaturity(), this);
			processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
			processRosetta(path.newSubPath("tranche"), processor, UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder.class, getTranche());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
		}
		

		Loan.LoanBuilder prune();
	}

	/*********************** Immutable Implementation of Loan  ***********************/
	class LoanImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements Loan {
		private final List<? extends LoanChoice> loanChoice;
		private final Lien lien;
		private final FacilityType facilityType;
		private final Date maturity;
		private final Date creditAgreementDate;
		private final UnderlyingAssetTranche tranche;
		private final CreditSeniority seniority;
		
		protected LoanImpl(Loan.LoanBuilder builder) {
			super(builder);
			this.loanChoice = ofNullable(builder.getLoanChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lien = ofNullable(builder.getLien()).map(f->f.build()).orElse(null);
			this.facilityType = ofNullable(builder.getFacilityType()).map(f->f.build()).orElse(null);
			this.maturity = builder.getMaturity();
			this.creditAgreementDate = builder.getCreditAgreementDate();
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanChoice")
		public List<? extends LoanChoice> getLoanChoice() {
			return loanChoice;
		}
		
		@Override
		@RosettaAttribute("lien")
		public Lien getLien() {
			return lien;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		public FacilityType getFacilityType() {
			return facilityType;
		}
		
		@Override
		@RosettaAttribute("maturity")
		public Date getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public UnderlyingAssetTranche getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		public Loan build() {
			return this;
		}
		
		@Override
		public Loan.LoanBuilder toBuilder() {
			Loan.LoanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Loan.LoanBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanChoice()).ifPresent(builder::setLoanChoice);
			ofNullable(getLien()).ifPresent(builder::setLien);
			ofNullable(getFacilityType()).ifPresent(builder::setFacilityType);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
			ofNullable(getCreditAgreementDate()).ifPresent(builder::setCreditAgreementDate);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanChoice, _that.getLoanChoice())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanChoice != null ? loanChoice.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Loan {" +
				"loanChoice=" + this.loanChoice + ", " +
				"lien=" + this.lien + ", " +
				"facilityType=" + this.facilityType + ", " +
				"maturity=" + this.maturity + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"tranche=" + this.tranche + ", " +
				"seniority=" + this.seniority +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Loan  ***********************/
	class LoanBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements Loan.LoanBuilder {
	
		protected List<LoanChoice.LoanChoiceBuilder> loanChoice = new ArrayList<>();
		protected Lien.LienBuilder lien;
		protected FacilityType.FacilityTypeBuilder facilityType;
		protected Date maturity;
		protected Date creditAgreementDate;
		protected UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder tranche;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
	
		public LoanBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanChoice")
		public List<? extends LoanChoice.LoanChoiceBuilder> getLoanChoice() {
			return loanChoice;
		}
		
		public LoanChoice.LoanChoiceBuilder getOrCreateLoanChoice(int _index) {
		
			if (loanChoice==null) {
				this.loanChoice = new ArrayList<>();
			}
			LoanChoice.LoanChoiceBuilder result;
			return getIndex(loanChoice, _index, () -> {
						LoanChoice.LoanChoiceBuilder newLoanChoice = LoanChoice.builder();
						return newLoanChoice;
					});
		}
		
		@Override
		@RosettaAttribute("lien")
		public Lien.LienBuilder getLien() {
			return lien;
		}
		
		@Override
		public Lien.LienBuilder getOrCreateLien() {
			Lien.LienBuilder result;
			if (lien!=null) {
				result = lien;
			}
			else {
				result = lien = Lien.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		public FacilityType.FacilityTypeBuilder getFacilityType() {
			return facilityType;
		}
		
		@Override
		public FacilityType.FacilityTypeBuilder getOrCreateFacilityType() {
			FacilityType.FacilityTypeBuilder result;
			if (facilityType!=null) {
				result = facilityType;
			}
			else {
				result = facilityType = FacilityType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maturity")
		public Date getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getOrCreateTranche() {
			UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = UnderlyingAssetTranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public Loan.LoanBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Loan.LoanBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Loan.LoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public Loan.LoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public Loan.LoanBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Loan.LoanBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Loan.LoanBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Loan.LoanBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Loan.LoanBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		public Loan.LoanBuilder addLoanChoice(LoanChoice loanChoice) {
			if (loanChoice!=null) this.loanChoice.add(loanChoice.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addLoanChoice(LoanChoice loanChoice, int _idx) {
			getIndex(this.loanChoice, _idx, () -> loanChoice.toBuilder());
			return this;
		}
		@Override 
		public Loan.LoanBuilder addLoanChoice(List<? extends LoanChoice> loanChoices) {
			if (loanChoices != null) {
				for (LoanChoice toAdd : loanChoices) {
					this.loanChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanChoice")
		public Loan.LoanBuilder setLoanChoice(List<? extends LoanChoice> loanChoices) {
			if (loanChoices == null)  {
				this.loanChoice = new ArrayList<>();
			}
			else {
				this.loanChoice = loanChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("lien")
		public Loan.LoanBuilder setLien(Lien lien) {
			this.lien = lien==null?null:lien.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityType")
		public Loan.LoanBuilder setFacilityType(FacilityType facilityType) {
			this.facilityType = facilityType==null?null:facilityType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maturity")
		public Loan.LoanBuilder setMaturity(Date maturity) {
			this.maturity = maturity==null?null:maturity;
			return this;
		}
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Loan.LoanBuilder setCreditAgreementDate(Date creditAgreementDate) {
			this.creditAgreementDate = creditAgreementDate==null?null:creditAgreementDate;
			return this;
		}
		@Override
		@RosettaAttribute("tranche")
		public Loan.LoanBuilder setTranche(UnderlyingAssetTranche tranche) {
			this.tranche = tranche==null?null:tranche.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("seniority")
		public Loan.LoanBuilder setSeniority(CreditSeniority seniority) {
			this.seniority = seniority==null?null:seniority.toBuilder();
			return this;
		}
		
		@Override
		public Loan build() {
			return new Loan.LoanImpl(this);
		}
		
		@Override
		public Loan.LoanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Loan.LoanBuilder prune() {
			super.prune();
			loanChoice = loanChoice.stream().filter(b->b!=null).<LoanChoice.LoanChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lien!=null && !lien.prune().hasData()) lien = null;
			if (facilityType!=null && !facilityType.prune().hasData()) facilityType = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanChoice()!=null && getLoanChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLien()!=null && getLien().hasData()) return true;
			if (getFacilityType()!=null && getFacilityType().hasData()) return true;
			if (getMaturity()!=null) return true;
			if (getCreditAgreementDate()!=null) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Loan.LoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Loan.LoanBuilder o = (Loan.LoanBuilder) other;
			
			merger.mergeRosetta(getLoanChoice(), o.getLoanChoice(), this::getOrCreateLoanChoice);
			merger.mergeRosetta(getLien(), o.getLien(), this::setLien);
			merger.mergeRosetta(getFacilityType(), o.getFacilityType(), this::setFacilityType);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			merger.mergeBasic(getCreditAgreementDate(), o.getCreditAgreementDate(), this::setCreditAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanChoice, _that.getLoanChoice())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanChoice != null ? loanChoice.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBuilder {" +
				"loanChoice=" + this.loanChoice + ", " +
				"lien=" + this.lien + ", " +
				"facilityType=" + this.facilityType + ", " +
				"maturity=" + this.maturity + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"tranche=" + this.tranche + ", " +
				"seniority=" + this.seniority +
			'}' + " " + super.toString();
		}
	}
}
