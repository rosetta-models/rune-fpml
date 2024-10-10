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
import fpml.confirmation.AbstractApplicablePartyProfileObjects;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder;
import fpml.confirmation.ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilderImpl;
import fpml.confirmation.ApplicableCommunicationDetails.ApplicableCommunicationDetailsImpl;
import fpml.confirmation.ApplicablePurpose;
import fpml.confirmation.ApplicableTransactionType;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.BusinessUnitReference;
import fpml.confirmation.PersonReference;
import fpml.confirmation.meta.ApplicableCommunicationDetailsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines the assets (or type of assets) that a particular set of communication details may be associated with.
 * @version ${project.version}
 */
@RosettaDataType(value="ApplicableCommunicationDetails", builder=ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilderImpl.class, version="${project.version}")
public interface ApplicableCommunicationDetails extends AbstractApplicablePartyProfileObjects {

	ApplicableCommunicationDetailsMeta metaData = new ApplicableCommunicationDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A scheme to describe the purpose of a person or business unit in relation to an asset or assets.
	 */
	ApplicablePurpose getPurpose();
	/**
	 * A reference to the business unit element of a party block.
	 */
	BusinessUnitReference getBusinessUnitReference();
	/**
	 * A reference to a person element of a party block.
	 */
	PersonReference getPersonReference();

	/*********************** Build Methods  ***********************/
	ApplicableCommunicationDetails build();
	
	ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder toBuilder();
	
	static ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder() {
		return new ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableCommunicationDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ApplicableCommunicationDetails> getType() {
		return ApplicableCommunicationDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.class, getApplicableAssets());
		processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactionType.class, getApplicableTransactions());
		processRosetta(path.newSubPath("purpose"), processor, ApplicablePurpose.class, getPurpose());
		processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.class, getBusinessUnitReference());
		processRosetta(path.newSubPath("personReference"), processor, PersonReference.class, getPersonReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableCommunicationDetailsBuilder extends ApplicableCommunicationDetails, AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder {
		ApplicablePurpose.ApplicablePurposeBuilder getOrCreatePurpose();
		ApplicablePurpose.ApplicablePurposeBuilder getPurpose();
		BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference();
		BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference();
		PersonReference.PersonReferenceBuilder getOrCreatePersonReference();
		PersonReference.PersonReferenceBuilder getPersonReference();
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setIdentifier(AssociationToAssetIdentifier identifier);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableAssets(ApplicableAssets applicableAssets);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions0);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions1, int _idx);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactions2);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactions3);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setPurpose(ApplicablePurpose purpose);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setBusinessUnitReference(BusinessUnitReference businessUnitReference);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setPersonReference(PersonReference personReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.ApplicableAssetsBuilder.class, getApplicableAssets());
			processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactionType.ApplicableTransactionTypeBuilder.class, getApplicableTransactions());
			processRosetta(path.newSubPath("purpose"), processor, ApplicablePurpose.ApplicablePurposeBuilder.class, getPurpose());
			processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.BusinessUnitReferenceBuilder.class, getBusinessUnitReference());
			processRosetta(path.newSubPath("personReference"), processor, PersonReference.PersonReferenceBuilder.class, getPersonReference());
		}
		

		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableCommunicationDetails  ***********************/
	class ApplicableCommunicationDetailsImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl implements ApplicableCommunicationDetails {
		private final ApplicablePurpose purpose;
		private final BusinessUnitReference businessUnitReference;
		private final PersonReference personReference;
		
		protected ApplicableCommunicationDetailsImpl(ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder) {
			super(builder);
			this.purpose = ofNullable(builder.getPurpose()).map(f->f.build()).orElse(null);
			this.businessUnitReference = ofNullable(builder.getBusinessUnitReference()).map(f->f.build()).orElse(null);
			this.personReference = ofNullable(builder.getPersonReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("purpose")
		public ApplicablePurpose getPurpose() {
			return purpose;
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		public BusinessUnitReference getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		@RosettaAttribute("personReference")
		public PersonReference getPersonReference() {
			return personReference;
		}
		
		@Override
		public ApplicableCommunicationDetails build() {
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder toBuilder() {
			ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPurpose()).ifPresent(builder::setPurpose);
			ofNullable(getBusinessUnitReference()).ifPresent(builder::setBusinessUnitReference);
			ofNullable(getPersonReference()).ifPresent(builder::setPersonReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableCommunicationDetails _that = getType().cast(o);
		
			if (!Objects.equals(purpose, _that.getPurpose())) return false;
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(personReference, _that.getPersonReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (purpose != null ? purpose.hashCode() : 0);
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (personReference != null ? personReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableCommunicationDetails {" +
				"purpose=" + this.purpose + ", " +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"personReference=" + this.personReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ApplicableCommunicationDetails  ***********************/
	class ApplicableCommunicationDetailsBuilderImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl  implements ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder {
	
		protected ApplicablePurpose.ApplicablePurposeBuilder purpose;
		protected BusinessUnitReference.BusinessUnitReferenceBuilder businessUnitReference;
		protected PersonReference.PersonReferenceBuilder personReference;
	
		public ApplicableCommunicationDetailsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("purpose")
		public ApplicablePurpose.ApplicablePurposeBuilder getPurpose() {
			return purpose;
		}
		
		@Override
		public ApplicablePurpose.ApplicablePurposeBuilder getOrCreatePurpose() {
			ApplicablePurpose.ApplicablePurposeBuilder result;
			if (purpose!=null) {
				result = purpose;
			}
			else {
				result = purpose = ApplicablePurpose.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		public BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		public BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference() {
			BusinessUnitReference.BusinessUnitReferenceBuilder result;
			if (businessUnitReference!=null) {
				result = businessUnitReference;
			}
			else {
				result = businessUnitReference = BusinessUnitReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("personReference")
		public PersonReference.PersonReferenceBuilder getPersonReference() {
			return personReference;
		}
		
		@Override
		public PersonReference.PersonReferenceBuilder getOrCreatePersonReference() {
			PersonReference.PersonReferenceBuilder result;
			if (personReference!=null) {
				result = personReference;
			}
			else {
				result = personReference = PersonReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setIdentifier(AssociationToAssetIdentifier identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("applicableAssets")
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableAssets(ApplicableAssets applicableAssets) {
			this.applicableAssets = applicableAssets==null?null:applicableAssets.toBuilder();
			return this;
		}
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions) {
			if (applicableTransactions!=null) this.applicableTransactions.add(applicableTransactions.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions, int _idx) {
			getIndex(this.applicableTransactions, _idx, () -> applicableTransactions.toBuilder());
			return this;
		}
		@Override 
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactionss) {
			if (applicableTransactionss != null) {
				for (ApplicableTransactionType toAdd : applicableTransactionss) {
					this.applicableTransactions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("applicableTransactions")
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactionss) {
			if (applicableTransactionss == null)  {
				this.applicableTransactions = new ArrayList<>();
			}
			else {
				this.applicableTransactions = applicableTransactionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("purpose")
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setPurpose(ApplicablePurpose purpose) {
			this.purpose = purpose==null?null:purpose.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessUnitReference")
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setBusinessUnitReference(BusinessUnitReference businessUnitReference) {
			this.businessUnitReference = businessUnitReference==null?null:businessUnitReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("personReference")
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setPersonReference(PersonReference personReference) {
			this.personReference = personReference==null?null:personReference.toBuilder();
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetails build() {
			return new ApplicableCommunicationDetails.ApplicableCommunicationDetailsImpl(this);
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder prune() {
			super.prune();
			if (purpose!=null && !purpose.prune().hasData()) purpose = null;
			if (businessUnitReference!=null && !businessUnitReference.prune().hasData()) businessUnitReference = null;
			if (personReference!=null && !personReference.prune().hasData()) personReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPurpose()!=null && getPurpose().hasData()) return true;
			if (getBusinessUnitReference()!=null && getBusinessUnitReference().hasData()) return true;
			if (getPersonReference()!=null && getPersonReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder o = (ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder) other;
			
			merger.mergeRosetta(getPurpose(), o.getPurpose(), this::setPurpose);
			merger.mergeRosetta(getBusinessUnitReference(), o.getBusinessUnitReference(), this::setBusinessUnitReference);
			merger.mergeRosetta(getPersonReference(), o.getPersonReference(), this::setPersonReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableCommunicationDetails _that = getType().cast(o);
		
			if (!Objects.equals(purpose, _that.getPurpose())) return false;
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(personReference, _that.getPersonReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (purpose != null ? purpose.hashCode() : 0);
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (personReference != null ? personReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableCommunicationDetailsBuilder {" +
				"purpose=" + this.purpose + ", " +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"personReference=" + this.personReference +
			'}' + " " + super.toString();
		}
	}
}
