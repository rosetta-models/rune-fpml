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
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.LoanContractSummary;
import fpml.confirmation.LoanContractSummary.LoanContractSummaryBuilder;
import fpml.confirmation.LoanContractSummary.LoanContractSummaryBuilderImpl;
import fpml.confirmation.LoanContractSummary.LoanContractSummaryImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.LoanContractSummaryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A short form of a loan contract.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractSummary", builder=LoanContractSummary.LoanContractSummaryBuilderImpl.class, version="${project.version}")
public interface LoanContractSummary extends RosettaModelObject {

	LoanContractSummaryMeta metaData = new LoanContractSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique identifier for a loan contract.
	 */
	List<? extends FacilityContractIdentifier> getIdentifier();
	/**
	 * The effective date of the loan contract. This is the date on which the funds are passed to the borrower. It is an actual (adjusted) date.
	 */
	Date getEffectiveDate();
	/**
	 * A reference to the borrower against a loan contract.
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 * Party references to any guarantors associated with the facility borrower.
	 */
	PartyReference getGuarantorPartyReference();
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	LoanContractSummary build();
	
	LoanContractSummary.LoanContractSummaryBuilder toBuilder();
	
	static LoanContractSummary.LoanContractSummaryBuilder builder() {
		return new LoanContractSummary.LoanContractSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractSummary> getType() {
		return LoanContractSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.class, getIdentifier());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractSummaryBuilder extends LoanContractSummary, RosettaModelObjectBuilder {
		FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateIdentifier(int _index);
		List<? extends FacilityContractIdentifier.FacilityContractIdentifierBuilder> getIdentifier();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference();
		PartyReference.PartyReferenceBuilder getGuarantorPartyReference();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		LoanContractSummary.LoanContractSummaryBuilder addIdentifier(FacilityContractIdentifier identifier0);
		LoanContractSummary.LoanContractSummaryBuilder addIdentifier(FacilityContractIdentifier identifier1, int _idx);
		LoanContractSummary.LoanContractSummaryBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifier2);
		LoanContractSummary.LoanContractSummaryBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifier3);
		LoanContractSummary.LoanContractSummaryBuilder setEffectiveDate(Date effectiveDate);
		LoanContractSummary.LoanContractSummaryBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		LoanContractSummary.LoanContractSummaryBuilder setGuarantorPartyReference(PartyReference guarantorPartyReference);
		LoanContractSummary.LoanContractSummaryBuilder setAmount(MoneyWithParticipantShare amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.FacilityContractIdentifierBuilder.class, getIdentifier());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		LoanContractSummary.LoanContractSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractSummary  ***********************/
	class LoanContractSummaryImpl implements LoanContractSummary {
		private final List<? extends FacilityContractIdentifier> identifier;
		private final Date effectiveDate;
		private final PartyReference borrowerPartyReference;
		private final PartyReference guarantorPartyReference;
		private final MoneyWithParticipantShare amount;
		
		protected LoanContractSummaryImpl(LoanContractSummary.LoanContractSummaryBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.guarantorPartyReference = ofNullable(builder.getGuarantorPartyReference()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		public List<? extends FacilityContractIdentifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public PartyReference getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public LoanContractSummary build() {
			return this;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder toBuilder() {
			LoanContractSummary.LoanContractSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractSummary.LoanContractSummaryBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getGuarantorPartyReference()).ifPresent(builder::setGuarantorPartyReference);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractSummary _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractSummary {" +
				"identifier=" + this.identifier + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"amount=" + this.amount +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanContractSummary  ***********************/
	class LoanContractSummaryBuilderImpl implements LoanContractSummary.LoanContractSummaryBuilder {
	
		protected List<FacilityContractIdentifier.FacilityContractIdentifierBuilder> identifier = new ArrayList<>();
		protected Date effectiveDate;
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected PartyReference.PartyReferenceBuilder guarantorPartyReference;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
	
		public LoanContractSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("identifier")
		public List<? extends FacilityContractIdentifier.FacilityContractIdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			FacilityContractIdentifier.FacilityContractIdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						FacilityContractIdentifier.FacilityContractIdentifierBuilder newIdentifier = FacilityContractIdentifier.builder();
						return newIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public PartyReference.PartyReferenceBuilder getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (borrowerPartyReference!=null) {
				result = borrowerPartyReference;
			}
			else {
				result = borrowerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public PartyReference.PartyReferenceBuilder getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (guarantorPartyReference!=null) {
				result = guarantorPartyReference;
			}
			else {
				result = guarantorPartyReference = PartyReference.builder();
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
		@RosettaAttribute("identifier")
		public LoanContractSummary.LoanContractSummaryBuilder addIdentifier(FacilityContractIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder addIdentifier(FacilityContractIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public LoanContractSummary.LoanContractSummaryBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
			if (identifiers != null) {
				for (FacilityContractIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanContractSummary.LoanContractSummaryBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
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
		public LoanContractSummary.LoanContractSummaryBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public LoanContractSummary.LoanContractSummaryBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference) {
			this.borrowerPartyReference = borrowerPartyReference==null?null:borrowerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public LoanContractSummary.LoanContractSummaryBuilder setGuarantorPartyReference(PartyReference guarantorPartyReference) {
			this.guarantorPartyReference = guarantorPartyReference==null?null:guarantorPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanContractSummary.LoanContractSummaryBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public LoanContractSummary build() {
			return new LoanContractSummary.LoanContractSummaryImpl(this);
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<FacilityContractIdentifier.FacilityContractIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			if (guarantorPartyReference!=null && !guarantorPartyReference.prune().hasData()) guarantorPartyReference = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEffectiveDate()!=null) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getGuarantorPartyReference()!=null && getGuarantorPartyReference().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanContractSummary.LoanContractSummaryBuilder o = (LoanContractSummary.LoanContractSummaryBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getGuarantorPartyReference(), o.getGuarantorPartyReference(), this::setGuarantorPartyReference);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractSummary _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractSummaryBuilder {" +
				"identifier=" + this.identifier + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"amount=" + this.amount +
			'}';
		}
	}
}
