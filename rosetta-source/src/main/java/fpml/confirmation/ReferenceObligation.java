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
import com.rosetta.util.ListEquals;
import fpml.confirmation.Bond;
import fpml.confirmation.ConvertibleBond;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.Loan;
import fpml.confirmation.Mortgage;
import fpml.confirmation.ReferenceObligation;
import fpml.confirmation.ReferenceObligation.ReferenceObligationBuilder;
import fpml.confirmation.ReferenceObligation.ReferenceObligationBuilderImpl;
import fpml.confirmation.ReferenceObligation.ReferenceObligationImpl;
import fpml.confirmation.ReferenceObligationChoice;
import fpml.confirmation.meta.ReferenceObligationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReferenceObligation", builder=ReferenceObligation.ReferenceObligationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReferenceObligation extends RosettaModelObject {

	ReferenceObligationMeta metaData = new ReferenceObligationMeta();

	/*********************** Getter Methods  ***********************/
	Bond getBond();
	ConvertibleBond getConvertibleBond();
	Mortgage getMortgage();
	Loan getLoan();
	/**
	 * The entity primarily responsible for repaying debt to a creditor as a result of borrowing or issuing bonds. ISDA 2003 Term: Primary Obligor
	 */
	LegalEntity getPrimaryObligor();
	/**
	 * A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the primary obligor.
	 */
	LegalEntityReference getPrimaryObligorReference();
	List<? extends ReferenceObligationChoice> getReferenceObligationChoice();
	/**
	 * Indicates if the reference obligation is a Standard Reference Obligation. ISDA 2014 Term: Standard Reference Obligation.
	 */
	Boolean getStandardReferenceObligation();

	/*********************** Build Methods  ***********************/
	ReferenceObligation build();
	
	ReferenceObligation.ReferenceObligationBuilder toBuilder();
	
	static ReferenceObligation.ReferenceObligationBuilder builder() {
		return new ReferenceObligation.ReferenceObligationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceObligation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceObligation> getType() {
		return ReferenceObligation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bond"), processor, Bond.class, getBond());
		processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.class, getConvertibleBond());
		processRosetta(path.newSubPath("mortgage"), processor, Mortgage.class, getMortgage());
		processRosetta(path.newSubPath("loan"), processor, Loan.class, getLoan());
		processRosetta(path.newSubPath("primaryObligor"), processor, LegalEntity.class, getPrimaryObligor());
		processRosetta(path.newSubPath("primaryObligorReference"), processor, LegalEntityReference.class, getPrimaryObligorReference());
		processRosetta(path.newSubPath("referenceObligationChoice"), processor, ReferenceObligationChoice.class, getReferenceObligationChoice());
		processor.processBasic(path.newSubPath("standardReferenceObligation"), Boolean.class, getStandardReferenceObligation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceObligationBuilder extends ReferenceObligation, RosettaModelObjectBuilder {
		Bond.BondBuilder getOrCreateBond();
		Bond.BondBuilder getBond();
		ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond();
		ConvertibleBond.ConvertibleBondBuilder getConvertibleBond();
		Mortgage.MortgageBuilder getOrCreateMortgage();
		Mortgage.MortgageBuilder getMortgage();
		Loan.LoanBuilder getOrCreateLoan();
		Loan.LoanBuilder getLoan();
		LegalEntity.LegalEntityBuilder getOrCreatePrimaryObligor();
		LegalEntity.LegalEntityBuilder getPrimaryObligor();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreatePrimaryObligorReference();
		LegalEntityReference.LegalEntityReferenceBuilder getPrimaryObligorReference();
		ReferenceObligationChoice.ReferenceObligationChoiceBuilder getOrCreateReferenceObligationChoice(int _index);
		List<? extends ReferenceObligationChoice.ReferenceObligationChoiceBuilder> getReferenceObligationChoice();
		ReferenceObligation.ReferenceObligationBuilder setBond(Bond bond);
		ReferenceObligation.ReferenceObligationBuilder setConvertibleBond(ConvertibleBond convertibleBond);
		ReferenceObligation.ReferenceObligationBuilder setMortgage(Mortgage mortgage);
		ReferenceObligation.ReferenceObligationBuilder setLoan(Loan loan);
		ReferenceObligation.ReferenceObligationBuilder setPrimaryObligor(LegalEntity primaryObligor);
		ReferenceObligation.ReferenceObligationBuilder setPrimaryObligorReference(LegalEntityReference primaryObligorReference);
		ReferenceObligation.ReferenceObligationBuilder addReferenceObligationChoice(ReferenceObligationChoice referenceObligationChoice0);
		ReferenceObligation.ReferenceObligationBuilder addReferenceObligationChoice(ReferenceObligationChoice referenceObligationChoice1, int _idx);
		ReferenceObligation.ReferenceObligationBuilder addReferenceObligationChoice(List<? extends ReferenceObligationChoice> referenceObligationChoice2);
		ReferenceObligation.ReferenceObligationBuilder setReferenceObligationChoice(List<? extends ReferenceObligationChoice> referenceObligationChoice3);
		ReferenceObligation.ReferenceObligationBuilder setStandardReferenceObligation(Boolean standardReferenceObligation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bond"), processor, Bond.BondBuilder.class, getBond());
			processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.ConvertibleBondBuilder.class, getConvertibleBond());
			processRosetta(path.newSubPath("mortgage"), processor, Mortgage.MortgageBuilder.class, getMortgage());
			processRosetta(path.newSubPath("loan"), processor, Loan.LoanBuilder.class, getLoan());
			processRosetta(path.newSubPath("primaryObligor"), processor, LegalEntity.LegalEntityBuilder.class, getPrimaryObligor());
			processRosetta(path.newSubPath("primaryObligorReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getPrimaryObligorReference());
			processRosetta(path.newSubPath("referenceObligationChoice"), processor, ReferenceObligationChoice.ReferenceObligationChoiceBuilder.class, getReferenceObligationChoice());
			processor.processBasic(path.newSubPath("standardReferenceObligation"), Boolean.class, getStandardReferenceObligation(), this);
		}
		

		ReferenceObligation.ReferenceObligationBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceObligation  ***********************/
	class ReferenceObligationImpl implements ReferenceObligation {
		private final Bond bond;
		private final ConvertibleBond convertibleBond;
		private final Mortgage mortgage;
		private final Loan loan;
		private final LegalEntity primaryObligor;
		private final LegalEntityReference primaryObligorReference;
		private final List<? extends ReferenceObligationChoice> referenceObligationChoice;
		private final Boolean standardReferenceObligation;
		
		protected ReferenceObligationImpl(ReferenceObligation.ReferenceObligationBuilder builder) {
			this.bond = ofNullable(builder.getBond()).map(f->f.build()).orElse(null);
			this.convertibleBond = ofNullable(builder.getConvertibleBond()).map(f->f.build()).orElse(null);
			this.mortgage = ofNullable(builder.getMortgage()).map(f->f.build()).orElse(null);
			this.loan = ofNullable(builder.getLoan()).map(f->f.build()).orElse(null);
			this.primaryObligor = ofNullable(builder.getPrimaryObligor()).map(f->f.build()).orElse(null);
			this.primaryObligorReference = ofNullable(builder.getPrimaryObligorReference()).map(f->f.build()).orElse(null);
			this.referenceObligationChoice = ofNullable(builder.getReferenceObligationChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.standardReferenceObligation = builder.getStandardReferenceObligation();
		}
		
		@Override
		@RosettaAttribute("bond")
		public Bond getBond() {
			return bond;
		}
		
		@Override
		@RosettaAttribute("convertibleBond")
		public ConvertibleBond getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		@RosettaAttribute("mortgage")
		public Mortgage getMortgage() {
			return mortgage;
		}
		
		@Override
		@RosettaAttribute("loan")
		public Loan getLoan() {
			return loan;
		}
		
		@Override
		@RosettaAttribute("primaryObligor")
		public LegalEntity getPrimaryObligor() {
			return primaryObligor;
		}
		
		@Override
		@RosettaAttribute("primaryObligorReference")
		public LegalEntityReference getPrimaryObligorReference() {
			return primaryObligorReference;
		}
		
		@Override
		@RosettaAttribute("referenceObligationChoice")
		public List<? extends ReferenceObligationChoice> getReferenceObligationChoice() {
			return referenceObligationChoice;
		}
		
		@Override
		@RosettaAttribute("standardReferenceObligation")
		public Boolean getStandardReferenceObligation() {
			return standardReferenceObligation;
		}
		
		@Override
		public ReferenceObligation build() {
			return this;
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder toBuilder() {
			ReferenceObligation.ReferenceObligationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceObligation.ReferenceObligationBuilder builder) {
			ofNullable(getBond()).ifPresent(builder::setBond);
			ofNullable(getConvertibleBond()).ifPresent(builder::setConvertibleBond);
			ofNullable(getMortgage()).ifPresent(builder::setMortgage);
			ofNullable(getLoan()).ifPresent(builder::setLoan);
			ofNullable(getPrimaryObligor()).ifPresent(builder::setPrimaryObligor);
			ofNullable(getPrimaryObligorReference()).ifPresent(builder::setPrimaryObligorReference);
			ofNullable(getReferenceObligationChoice()).ifPresent(builder::setReferenceObligationChoice);
			ofNullable(getStandardReferenceObligation()).ifPresent(builder::setStandardReferenceObligation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceObligation _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			if (!Objects.equals(mortgage, _that.getMortgage())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(primaryObligor, _that.getPrimaryObligor())) return false;
			if (!Objects.equals(primaryObligorReference, _that.getPrimaryObligorReference())) return false;
			if (!ListEquals.listEquals(referenceObligationChoice, _that.getReferenceObligationChoice())) return false;
			if (!Objects.equals(standardReferenceObligation, _that.getStandardReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			_result = 31 * _result + (mortgage != null ? mortgage.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (primaryObligor != null ? primaryObligor.hashCode() : 0);
			_result = 31 * _result + (primaryObligorReference != null ? primaryObligorReference.hashCode() : 0);
			_result = 31 * _result + (referenceObligationChoice != null ? referenceObligationChoice.hashCode() : 0);
			_result = 31 * _result + (standardReferenceObligation != null ? standardReferenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceObligation {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond + ", " +
				"mortgage=" + this.mortgage + ", " +
				"loan=" + this.loan + ", " +
				"primaryObligor=" + this.primaryObligor + ", " +
				"primaryObligorReference=" + this.primaryObligorReference + ", " +
				"referenceObligationChoice=" + this.referenceObligationChoice + ", " +
				"standardReferenceObligation=" + this.standardReferenceObligation +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceObligation  ***********************/
	class ReferenceObligationBuilderImpl implements ReferenceObligation.ReferenceObligationBuilder {
	
		protected Bond.BondBuilder bond;
		protected ConvertibleBond.ConvertibleBondBuilder convertibleBond;
		protected Mortgage.MortgageBuilder mortgage;
		protected Loan.LoanBuilder loan;
		protected LegalEntity.LegalEntityBuilder primaryObligor;
		protected LegalEntityReference.LegalEntityReferenceBuilder primaryObligorReference;
		protected List<ReferenceObligationChoice.ReferenceObligationChoiceBuilder> referenceObligationChoice = new ArrayList<>();
		protected Boolean standardReferenceObligation;
	
		public ReferenceObligationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bond")
		public Bond.BondBuilder getBond() {
			return bond;
		}
		
		@Override
		public Bond.BondBuilder getOrCreateBond() {
			Bond.BondBuilder result;
			if (bond!=null) {
				result = bond;
			}
			else {
				result = bond = Bond.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("convertibleBond")
		public ConvertibleBond.ConvertibleBondBuilder getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond() {
			ConvertibleBond.ConvertibleBondBuilder result;
			if (convertibleBond!=null) {
				result = convertibleBond;
			}
			else {
				result = convertibleBond = ConvertibleBond.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mortgage")
		public Mortgage.MortgageBuilder getMortgage() {
			return mortgage;
		}
		
		@Override
		public Mortgage.MortgageBuilder getOrCreateMortgage() {
			Mortgage.MortgageBuilder result;
			if (mortgage!=null) {
				result = mortgage;
			}
			else {
				result = mortgage = Mortgage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loan")
		public Loan.LoanBuilder getLoan() {
			return loan;
		}
		
		@Override
		public Loan.LoanBuilder getOrCreateLoan() {
			Loan.LoanBuilder result;
			if (loan!=null) {
				result = loan;
			}
			else {
				result = loan = Loan.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("primaryObligor")
		public LegalEntity.LegalEntityBuilder getPrimaryObligor() {
			return primaryObligor;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreatePrimaryObligor() {
			LegalEntity.LegalEntityBuilder result;
			if (primaryObligor!=null) {
				result = primaryObligor;
			}
			else {
				result = primaryObligor = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("primaryObligorReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getPrimaryObligorReference() {
			return primaryObligorReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreatePrimaryObligorReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (primaryObligorReference!=null) {
				result = primaryObligorReference;
			}
			else {
				result = primaryObligorReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceObligationChoice")
		public List<? extends ReferenceObligationChoice.ReferenceObligationChoiceBuilder> getReferenceObligationChoice() {
			return referenceObligationChoice;
		}
		
		@Override
		public ReferenceObligationChoice.ReferenceObligationChoiceBuilder getOrCreateReferenceObligationChoice(int _index) {
		
			if (referenceObligationChoice==null) {
				this.referenceObligationChoice = new ArrayList<>();
			}
			ReferenceObligationChoice.ReferenceObligationChoiceBuilder result;
			return getIndex(referenceObligationChoice, _index, () -> {
						ReferenceObligationChoice.ReferenceObligationChoiceBuilder newReferenceObligationChoice = ReferenceObligationChoice.builder();
						return newReferenceObligationChoice;
					});
		}
		
		@Override
		@RosettaAttribute("standardReferenceObligation")
		public Boolean getStandardReferenceObligation() {
			return standardReferenceObligation;
		}
		
		@Override
		@RosettaAttribute("bond")
		public ReferenceObligation.ReferenceObligationBuilder setBond(Bond bond) {
			this.bond = bond==null?null:bond.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("convertibleBond")
		public ReferenceObligation.ReferenceObligationBuilder setConvertibleBond(ConvertibleBond convertibleBond) {
			this.convertibleBond = convertibleBond==null?null:convertibleBond.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mortgage")
		public ReferenceObligation.ReferenceObligationBuilder setMortgage(Mortgage mortgage) {
			this.mortgage = mortgage==null?null:mortgage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loan")
		public ReferenceObligation.ReferenceObligationBuilder setLoan(Loan loan) {
			this.loan = loan==null?null:loan.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("primaryObligor")
		public ReferenceObligation.ReferenceObligationBuilder setPrimaryObligor(LegalEntity primaryObligor) {
			this.primaryObligor = primaryObligor==null?null:primaryObligor.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("primaryObligorReference")
		public ReferenceObligation.ReferenceObligationBuilder setPrimaryObligorReference(LegalEntityReference primaryObligorReference) {
			this.primaryObligorReference = primaryObligorReference==null?null:primaryObligorReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceObligationChoice")
		public ReferenceObligation.ReferenceObligationBuilder addReferenceObligationChoice(ReferenceObligationChoice referenceObligationChoice) {
			if (referenceObligationChoice!=null) this.referenceObligationChoice.add(referenceObligationChoice.toBuilder());
			return this;
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder addReferenceObligationChoice(ReferenceObligationChoice referenceObligationChoice, int _idx) {
			getIndex(this.referenceObligationChoice, _idx, () -> referenceObligationChoice.toBuilder());
			return this;
		}
		@Override 
		public ReferenceObligation.ReferenceObligationBuilder addReferenceObligationChoice(List<? extends ReferenceObligationChoice> referenceObligationChoices) {
			if (referenceObligationChoices != null) {
				for (ReferenceObligationChoice toAdd : referenceObligationChoices) {
					this.referenceObligationChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReferenceObligation.ReferenceObligationBuilder setReferenceObligationChoice(List<? extends ReferenceObligationChoice> referenceObligationChoices) {
			if (referenceObligationChoices == null)  {
				this.referenceObligationChoice = new ArrayList<>();
			}
			else {
				this.referenceObligationChoice = referenceObligationChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("standardReferenceObligation")
		public ReferenceObligation.ReferenceObligationBuilder setStandardReferenceObligation(Boolean standardReferenceObligation) {
			this.standardReferenceObligation = standardReferenceObligation==null?null:standardReferenceObligation;
			return this;
		}
		
		@Override
		public ReferenceObligation build() {
			return new ReferenceObligation.ReferenceObligationImpl(this);
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceObligation.ReferenceObligationBuilder prune() {
			if (bond!=null && !bond.prune().hasData()) bond = null;
			if (convertibleBond!=null && !convertibleBond.prune().hasData()) convertibleBond = null;
			if (mortgage!=null && !mortgage.prune().hasData()) mortgage = null;
			if (loan!=null && !loan.prune().hasData()) loan = null;
			if (primaryObligor!=null && !primaryObligor.prune().hasData()) primaryObligor = null;
			if (primaryObligorReference!=null && !primaryObligorReference.prune().hasData()) primaryObligorReference = null;
			referenceObligationChoice = referenceObligationChoice.stream().filter(b->b!=null).<ReferenceObligationChoice.ReferenceObligationChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBond()!=null && getBond().hasData()) return true;
			if (getConvertibleBond()!=null && getConvertibleBond().hasData()) return true;
			if (getMortgage()!=null && getMortgage().hasData()) return true;
			if (getLoan()!=null && getLoan().hasData()) return true;
			if (getPrimaryObligor()!=null && getPrimaryObligor().hasData()) return true;
			if (getPrimaryObligorReference()!=null && getPrimaryObligorReference().hasData()) return true;
			if (getReferenceObligationChoice()!=null && getReferenceObligationChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStandardReferenceObligation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceObligation.ReferenceObligationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceObligation.ReferenceObligationBuilder o = (ReferenceObligation.ReferenceObligationBuilder) other;
			
			merger.mergeRosetta(getBond(), o.getBond(), this::setBond);
			merger.mergeRosetta(getConvertibleBond(), o.getConvertibleBond(), this::setConvertibleBond);
			merger.mergeRosetta(getMortgage(), o.getMortgage(), this::setMortgage);
			merger.mergeRosetta(getLoan(), o.getLoan(), this::setLoan);
			merger.mergeRosetta(getPrimaryObligor(), o.getPrimaryObligor(), this::setPrimaryObligor);
			merger.mergeRosetta(getPrimaryObligorReference(), o.getPrimaryObligorReference(), this::setPrimaryObligorReference);
			merger.mergeRosetta(getReferenceObligationChoice(), o.getReferenceObligationChoice(), this::getOrCreateReferenceObligationChoice);
			
			merger.mergeBasic(getStandardReferenceObligation(), o.getStandardReferenceObligation(), this::setStandardReferenceObligation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceObligation _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			if (!Objects.equals(mortgage, _that.getMortgage())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(primaryObligor, _that.getPrimaryObligor())) return false;
			if (!Objects.equals(primaryObligorReference, _that.getPrimaryObligorReference())) return false;
			if (!ListEquals.listEquals(referenceObligationChoice, _that.getReferenceObligationChoice())) return false;
			if (!Objects.equals(standardReferenceObligation, _that.getStandardReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			_result = 31 * _result + (mortgage != null ? mortgage.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (primaryObligor != null ? primaryObligor.hashCode() : 0);
			_result = 31 * _result + (primaryObligorReference != null ? primaryObligorReference.hashCode() : 0);
			_result = 31 * _result + (referenceObligationChoice != null ? referenceObligationChoice.hashCode() : 0);
			_result = 31 * _result + (standardReferenceObligation != null ? standardReferenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceObligationBuilder {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond + ", " +
				"mortgage=" + this.mortgage + ", " +
				"loan=" + this.loan + ", " +
				"primaryObligor=" + this.primaryObligor + ", " +
				"primaryObligorReference=" + this.primaryObligorReference + ", " +
				"referenceObligationChoice=" + this.referenceObligationChoice + ", " +
				"standardReferenceObligation=" + this.standardReferenceObligation +
			'}';
		}
	}
}
