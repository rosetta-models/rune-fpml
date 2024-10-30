package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilderImpl;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseImpl;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Loan.LoanBuilder;
import cdm.base.staticdata.asset.common.Loan.LoanBuilderImpl;
import cdm.base.staticdata.asset.common.Loan.LoanImpl;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.meta.LoanMeta;
import cdm.base.staticdata.party.LegalEntity;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a loan by referencing an asset identifier and through an optional set of attributes.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="Loan", builder=Loan.LoanBuilderImpl.class, version="6.0.0-dev.76")
public interface Loan extends InstrumentBase {

	LoanMeta metaData = new LoanMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the borrower. There can be more than one borrower. It is meant to be used in the event that there is no Bloomberg Id or the Secured List isn&#39;t applicable.
	 */
	List<? extends LegalEntity> getBorrower();
	/**
	 * Specifies the seniority level of the lien.
	 */
	FieldWithMetaString getLien();
	/**
	 * Specifies the type of loan facility (letter of credit, revolving, ...).
	 */
	FieldWithMetaString getFacilityType();
	/**
	 * Specifies the credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlier attribute is used to help identify which of the company&#39;s outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
	 */
	Date getCreditAgreementDate();
	/**
	 * Denotes the loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
	 */
	FieldWithMetaString getTranche();

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
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("borrower"), processor, LegalEntity.class, getBorrower());
		processRosetta(path.newSubPath("lien"), processor, FieldWithMetaString.class, getLien());
		processRosetta(path.newSubPath("facilityType"), processor, FieldWithMetaString.class, getFacilityType());
		processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
		processRosetta(path.newSubPath("tranche"), processor, FieldWithMetaString.class, getTranche());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBuilder extends Loan, InstrumentBase.InstrumentBaseBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateBorrower(int _index);
		List<? extends LegalEntity.LegalEntityBuilder> getBorrower();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateLien();
		FieldWithMetaString.FieldWithMetaStringBuilder getLien();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateFacilityType();
		FieldWithMetaString.FieldWithMetaStringBuilder getFacilityType();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateTranche();
		FieldWithMetaString.FieldWithMetaStringBuilder getTranche();
		Loan.LoanBuilder addIdentifier(AssetIdentifier identifier0);
		Loan.LoanBuilder addIdentifier(AssetIdentifier identifier1, int _idx);
		Loan.LoanBuilder addIdentifier(List<? extends AssetIdentifier> identifier2);
		Loan.LoanBuilder setIdentifier(List<? extends AssetIdentifier> identifier3);
		Loan.LoanBuilder addTaxonomy(Taxonomy taxonomy0);
		Loan.LoanBuilder addTaxonomy(Taxonomy taxonomy1, int _idx);
		Loan.LoanBuilder addTaxonomy(List<? extends Taxonomy> taxonomy2);
		Loan.LoanBuilder setTaxonomy(List<? extends Taxonomy> taxonomy3);
		Loan.LoanBuilder setIsExchangeListed(Boolean isExchangeListed);
		Loan.LoanBuilder setExchange(LegalEntity exchange);
		Loan.LoanBuilder addRelatedExchange(LegalEntity relatedExchange0);
		Loan.LoanBuilder addRelatedExchange(LegalEntity relatedExchange1, int _idx);
		Loan.LoanBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange2);
		Loan.LoanBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange3);
		Loan.LoanBuilder addBorrower(LegalEntity borrower0);
		Loan.LoanBuilder addBorrower(LegalEntity borrower1, int _idx);
		Loan.LoanBuilder addBorrower(List<? extends LegalEntity> borrower2);
		Loan.LoanBuilder setBorrower(List<? extends LegalEntity> borrower3);
		Loan.LoanBuilder setLien(FieldWithMetaString lien0);
		Loan.LoanBuilder setLienValue(String lien1);
		Loan.LoanBuilder setFacilityType(FieldWithMetaString facilityType0);
		Loan.LoanBuilder setFacilityTypeValue(String facilityType1);
		Loan.LoanBuilder setCreditAgreementDate(Date creditAgreementDate);
		Loan.LoanBuilder setTranche(FieldWithMetaString tranche0);
		Loan.LoanBuilder setTrancheValue(String tranche1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("borrower"), processor, LegalEntity.LegalEntityBuilder.class, getBorrower());
			processRosetta(path.newSubPath("lien"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getLien());
			processRosetta(path.newSubPath("facilityType"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getFacilityType());
			processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
			processRosetta(path.newSubPath("tranche"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getTranche());
		}
		

		Loan.LoanBuilder prune();
	}

	/*********************** Immutable Implementation of Loan  ***********************/
	class LoanImpl extends InstrumentBase.InstrumentBaseImpl implements Loan {
		private final List<? extends LegalEntity> borrower;
		private final FieldWithMetaString lien;
		private final FieldWithMetaString facilityType;
		private final Date creditAgreementDate;
		private final FieldWithMetaString tranche;
		
		protected LoanImpl(Loan.LoanBuilder builder) {
			super(builder);
			this.borrower = ofNullable(builder.getBorrower()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lien = ofNullable(builder.getLien()).map(f->f.build()).orElse(null);
			this.facilityType = ofNullable(builder.getFacilityType()).map(f->f.build()).orElse(null);
			this.creditAgreementDate = builder.getCreditAgreementDate();
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("borrower")
		public List<? extends LegalEntity> getBorrower() {
			return borrower;
		}
		
		@Override
		@RosettaAttribute("lien")
		public FieldWithMetaString getLien() {
			return lien;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		public FieldWithMetaString getFacilityType() {
			return facilityType;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public FieldWithMetaString getTranche() {
			return tranche;
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
			ofNullable(getBorrower()).ifPresent(builder::setBorrower);
			ofNullable(getLien()).ifPresent(builder::setLien);
			ofNullable(getFacilityType()).ifPresent(builder::setFacilityType);
			ofNullable(getCreditAgreementDate()).ifPresent(builder::setCreditAgreementDate);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(borrower, _that.getBorrower())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (borrower != null ? borrower.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Loan {" +
				"borrower=" + this.borrower + ", " +
				"lien=" + this.lien + ", " +
				"facilityType=" + this.facilityType + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Loan  ***********************/
	class LoanBuilderImpl extends InstrumentBase.InstrumentBaseBuilderImpl  implements Loan.LoanBuilder {
	
		protected List<LegalEntity.LegalEntityBuilder> borrower = new ArrayList<>();
		protected FieldWithMetaString.FieldWithMetaStringBuilder lien;
		protected FieldWithMetaString.FieldWithMetaStringBuilder facilityType;
		protected Date creditAgreementDate;
		protected FieldWithMetaString.FieldWithMetaStringBuilder tranche;
	
		public LoanBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("borrower")
		public List<? extends LegalEntity.LegalEntityBuilder> getBorrower() {
			return borrower;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateBorrower(int _index) {
		
			if (borrower==null) {
				this.borrower = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(borrower, _index, () -> {
						LegalEntity.LegalEntityBuilder newBorrower = LegalEntity.builder();
						return newBorrower;
					});
		}
		
		@Override
		@RosettaAttribute("lien")
		public FieldWithMetaString.FieldWithMetaStringBuilder getLien() {
			return lien;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateLien() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (lien!=null) {
				result = lien;
			}
			else {
				result = lien = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		public FieldWithMetaString.FieldWithMetaStringBuilder getFacilityType() {
			return facilityType;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateFacilityType() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (facilityType!=null) {
				result = facilityType;
			}
			else {
				result = facilityType = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public FieldWithMetaString.FieldWithMetaStringBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateTranche() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public Loan.LoanBuilder addIdentifier(AssetIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addIdentifier(AssetIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public Loan.LoanBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Loan.LoanBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		@RosettaAttribute("taxonomy")
		public Loan.LoanBuilder addTaxonomy(Taxonomy taxonomy) {
			if (taxonomy!=null) this.taxonomy.add(taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addTaxonomy(Taxonomy taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> taxonomy.toBuilder());
			return this;
		}
		@Override 
		public Loan.LoanBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Loan.LoanBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys == null)  {
				this.taxonomy = new ArrayList<>();
			}
			else {
				this.taxonomy = taxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("isExchangeListed")
		public Loan.LoanBuilder setIsExchangeListed(Boolean isExchangeListed) {
			this.isExchangeListed = isExchangeListed==null?null:isExchangeListed;
			return this;
		}
		@Override
		@RosettaAttribute("exchange")
		public Loan.LoanBuilder setExchange(LegalEntity exchange) {
			this.exchange = exchange==null?null:exchange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedExchange")
		public Loan.LoanBuilder addRelatedExchange(LegalEntity relatedExchange) {
			if (relatedExchange!=null) this.relatedExchange.add(relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> relatedExchange.toBuilder());
			return this;
		}
		@Override 
		public Loan.LoanBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Loan.LoanBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges == null)  {
				this.relatedExchange = new ArrayList<>();
			}
			else {
				this.relatedExchange = relatedExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("borrower")
		public Loan.LoanBuilder addBorrower(LegalEntity borrower) {
			if (borrower!=null) this.borrower.add(borrower.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addBorrower(LegalEntity borrower, int _idx) {
			getIndex(this.borrower, _idx, () -> borrower.toBuilder());
			return this;
		}
		@Override 
		public Loan.LoanBuilder addBorrower(List<? extends LegalEntity> borrowers) {
			if (borrowers != null) {
				for (LegalEntity toAdd : borrowers) {
					this.borrower.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Loan.LoanBuilder setBorrower(List<? extends LegalEntity> borrowers) {
			if (borrowers == null)  {
				this.borrower = new ArrayList<>();
			}
			else {
				this.borrower = borrowers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("lien")
		public Loan.LoanBuilder setLien(FieldWithMetaString lien) {
			this.lien = lien==null?null:lien.toBuilder();
			return this;
		}
		@Override
		public Loan.LoanBuilder setLienValue(String lien) {
			this.getOrCreateLien().setValue(lien);
			return this;
		}
		@Override
		@RosettaAttribute("facilityType")
		public Loan.LoanBuilder setFacilityType(FieldWithMetaString facilityType) {
			this.facilityType = facilityType==null?null:facilityType.toBuilder();
			return this;
		}
		@Override
		public Loan.LoanBuilder setFacilityTypeValue(String facilityType) {
			this.getOrCreateFacilityType().setValue(facilityType);
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
		public Loan.LoanBuilder setTranche(FieldWithMetaString tranche) {
			this.tranche = tranche==null?null:tranche.toBuilder();
			return this;
		}
		@Override
		public Loan.LoanBuilder setTrancheValue(String tranche) {
			this.getOrCreateTranche().setValue(tranche);
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
			borrower = borrower.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lien!=null && !lien.prune().hasData()) lien = null;
			if (facilityType!=null && !facilityType.prune().hasData()) facilityType = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBorrower()!=null && getBorrower().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLien()!=null) return true;
			if (getFacilityType()!=null) return true;
			if (getCreditAgreementDate()!=null) return true;
			if (getTranche()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Loan.LoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Loan.LoanBuilder o = (Loan.LoanBuilder) other;
			
			merger.mergeRosetta(getBorrower(), o.getBorrower(), this::getOrCreateBorrower);
			merger.mergeRosetta(getLien(), o.getLien(), this::setLien);
			merger.mergeRosetta(getFacilityType(), o.getFacilityType(), this::setFacilityType);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			
			merger.mergeBasic(getCreditAgreementDate(), o.getCreditAgreementDate(), this::setCreditAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(borrower, _that.getBorrower())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (borrower != null ? borrower.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBuilder {" +
				"borrower=" + this.borrower + ", " +
				"lien=" + this.lien + ", " +
				"facilityType=" + this.facilityType + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}
}
