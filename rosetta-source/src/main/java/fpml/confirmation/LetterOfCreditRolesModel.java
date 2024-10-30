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
import fpml.confirmation.LetterOfCreditRolesModel;
import fpml.confirmation.LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder;
import fpml.confirmation.LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilderImpl;
import fpml.confirmation.LetterOfCreditRolesModel.LetterOfCreditRolesModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.LetterOfCreditRolesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes the various roles played by parties within a given letter of credit.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LetterOfCreditRolesModel", builder=LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LetterOfCreditRolesModel extends RosettaModelObject {

	LetterOfCreditRolesModelMeta metaData = new LetterOfCreditRolesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Main borrower.
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 * Party references to any guarantors associated with the facility borrower.
	 */
	PartyReference getIssuingBankPartyReference();
	/**
	 * A party reference of the beneficiary.
	 */
	PartyReference getBeneficiaryPartyReference();

	/*********************** Build Methods  ***********************/
	LetterOfCreditRolesModel build();
	
	LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder toBuilder();
	
	static LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder builder() {
		return new LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditRolesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LetterOfCreditRolesModel> getType() {
		return LetterOfCreditRolesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("issuingBankPartyReference"), processor, PartyReference.class, getIssuingBankPartyReference());
		processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.class, getBeneficiaryPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditRolesModelBuilder extends LetterOfCreditRolesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateIssuingBankPartyReference();
		PartyReference.PartyReferenceBuilder getIssuingBankPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference();
		PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference();
		LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder setIssuingBankPartyReference(PartyReference issuingBankPartyReference);
		LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("issuingBankPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuingBankPartyReference());
			processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBeneficiaryPartyReference());
		}
		

		LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditRolesModel  ***********************/
	class LetterOfCreditRolesModelImpl implements LetterOfCreditRolesModel {
		private final PartyReference borrowerPartyReference;
		private final PartyReference issuingBankPartyReference;
		private final PartyReference beneficiaryPartyReference;
		
		protected LetterOfCreditRolesModelImpl(LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder builder) {
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.issuingBankPartyReference = ofNullable(builder.getIssuingBankPartyReference()).map(f->f.build()).orElse(null);
			this.beneficiaryPartyReference = ofNullable(builder.getBeneficiaryPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("issuingBankPartyReference")
		public PartyReference getIssuingBankPartyReference() {
			return issuingBankPartyReference;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		public PartyReference getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public LetterOfCreditRolesModel build() {
			return this;
		}
		
		@Override
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder toBuilder() {
			LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder builder) {
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getIssuingBankPartyReference()).ifPresent(builder::setIssuingBankPartyReference);
			ofNullable(getBeneficiaryPartyReference()).ifPresent(builder::setBeneficiaryPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(issuingBankPartyReference, _that.getIssuingBankPartyReference())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (issuingBankPartyReference != null ? issuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditRolesModel {" +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"issuingBankPartyReference=" + this.issuingBankPartyReference + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LetterOfCreditRolesModel  ***********************/
	class LetterOfCreditRolesModelBuilderImpl implements LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected PartyReference.PartyReferenceBuilder issuingBankPartyReference;
		protected PartyReference.PartyReferenceBuilder beneficiaryPartyReference;
	
		public LetterOfCreditRolesModelBuilderImpl() {
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
		@RosettaAttribute("issuingBankPartyReference")
		public PartyReference.PartyReferenceBuilder getIssuingBankPartyReference() {
			return issuingBankPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIssuingBankPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (issuingBankPartyReference!=null) {
				result = issuingBankPartyReference;
			}
			else {
				result = issuingBankPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		public PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (beneficiaryPartyReference!=null) {
				result = beneficiaryPartyReference;
			}
			else {
				result = beneficiaryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference) {
			this.borrowerPartyReference = borrowerPartyReference==null?null:borrowerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("issuingBankPartyReference")
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder setIssuingBankPartyReference(PartyReference issuingBankPartyReference) {
			this.issuingBankPartyReference = issuingBankPartyReference==null?null:issuingBankPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference) {
			this.beneficiaryPartyReference = beneficiaryPartyReference==null?null:beneficiaryPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCreditRolesModel build() {
			return new LetterOfCreditRolesModel.LetterOfCreditRolesModelImpl(this);
		}
		
		@Override
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder prune() {
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			if (issuingBankPartyReference!=null && !issuingBankPartyReference.prune().hasData()) issuingBankPartyReference = null;
			if (beneficiaryPartyReference!=null && !beneficiaryPartyReference.prune().hasData()) beneficiaryPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getIssuingBankPartyReference()!=null && getIssuingBankPartyReference().hasData()) return true;
			if (getBeneficiaryPartyReference()!=null && getBeneficiaryPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder o = (LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder) other;
			
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getIssuingBankPartyReference(), o.getIssuingBankPartyReference(), this::setIssuingBankPartyReference);
			merger.mergeRosetta(getBeneficiaryPartyReference(), o.getBeneficiaryPartyReference(), this::setBeneficiaryPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(issuingBankPartyReference, _that.getIssuingBankPartyReference())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (issuingBankPartyReference != null ? issuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditRolesModelBuilder {" +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"issuingBankPartyReference=" + this.issuingBankPartyReference + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference +
			'}';
		}
	}
}
