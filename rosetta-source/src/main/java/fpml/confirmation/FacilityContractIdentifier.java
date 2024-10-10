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
import fpml.confirmation.ContractId;
import fpml.confirmation.ContractIdentifier;
import fpml.confirmation.ContractIdentifier.ContractIdentifierBuilder;
import fpml.confirmation.ContractIdentifier.ContractIdentifierBuilderImpl;
import fpml.confirmation.ContractIdentifier.ContractIdentifierImpl;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FacilityContractIdentifier.FacilityContractIdentifierBuilder;
import fpml.confirmation.FacilityContractIdentifier.FacilityContractIdentifierBuilderImpl;
import fpml.confirmation.FacilityContractIdentifier.FacilityContractIdentifierImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.PartyReference;
import fpml.confirmation.VersionedContractId;
import fpml.confirmation.meta.FacilityContractIdentifierMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A unique identifier for outstanding contracts.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityContractIdentifier", builder=FacilityContractIdentifier.FacilityContractIdentifierBuilderImpl.class, version="${project.version}")
public interface FacilityContractIdentifier extends ContractIdentifier {

	FacilityContractIdentifierMeta metaData = new FacilityContractIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	FacilityReference getFacilityReference();

	/*********************** Build Methods  ***********************/
	FacilityContractIdentifier build();
	
	FacilityContractIdentifier.FacilityContractIdentifierBuilder toBuilder();
	
	static FacilityContractIdentifier.FacilityContractIdentifierBuilder builder() {
		return new FacilityContractIdentifier.FacilityContractIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityContractIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityContractIdentifier> getType() {
		return FacilityContractIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.class, getVersionedContractId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityContractIdentifierBuilder extends FacilityContractIdentifier, ContractIdentifier.ContractIdentifierBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		FacilityContractIdentifier.FacilityContractIdentifierBuilder setPartyReference(PartyReference partyReference);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder addContractId(ContractId contractId0);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder addContractId(ContractId contractId1, int _idx);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder addContractId(List<? extends ContractId> contractId2);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder setContractId(List<? extends ContractId> contractId3);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId0);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId1, int _idx);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId2);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId3);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder setId(String id);
		FacilityContractIdentifier.FacilityContractIdentifierBuilder setFacilityReference(FacilityReference facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.VersionedContractIdBuilder.class, getVersionedContractId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		FacilityContractIdentifier.FacilityContractIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityContractIdentifier  ***********************/
	class FacilityContractIdentifierImpl extends ContractIdentifier.ContractIdentifierImpl implements FacilityContractIdentifier {
		private final FacilityReference facilityReference;
		
		protected FacilityContractIdentifierImpl(FacilityContractIdentifier.FacilityContractIdentifierBuilder builder) {
			super(builder);
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityContractIdentifier build() {
			return this;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder toBuilder() {
			FacilityContractIdentifier.FacilityContractIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityContractIdentifier.FacilityContractIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityContractIdentifier {" +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityContractIdentifier  ***********************/
	class FacilityContractIdentifierBuilderImpl extends ContractIdentifier.ContractIdentifierBuilderImpl  implements FacilityContractIdentifier.FacilityContractIdentifierBuilder {
	
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
	
		public FacilityContractIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder addContractId(ContractId contractId) {
			if (contractId!=null) this.contractId.add(contractId.toBuilder());
			return this;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder addContractId(ContractId contractId, int _idx) {
			getIndex(this.contractId, _idx, () -> contractId.toBuilder());
			return this;
		}
		@Override 
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder addContractId(List<? extends ContractId> contractIds) {
			if (contractIds != null) {
				for (ContractId toAdd : contractIds) {
					this.contractId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("contractId")
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder setContractId(List<? extends ContractId> contractIds) {
			if (contractIds == null)  {
				this.contractId = new ArrayList<>();
			}
			else {
				this.contractId = contractIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId) {
			if (versionedContractId!=null) this.versionedContractId.add(versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId, int _idx) {
			getIndex(this.versionedContractId, _idx, () -> versionedContractId.toBuilder());
			return this;
		}
		@Override 
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
			if (versionedContractIds != null) {
				for (VersionedContractId toAdd : versionedContractIds) {
					this.versionedContractId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("versionedContractId")
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
			if (versionedContractIds == null)  {
				this.versionedContractId = new ArrayList<>();
			}
			else {
				this.versionedContractId = versionedContractIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		
		@Override
		public FacilityContractIdentifier build() {
			return new FacilityContractIdentifier.FacilityContractIdentifierImpl(this);
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder prune() {
			super.prune();
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityContractIdentifier.FacilityContractIdentifierBuilder o = (FacilityContractIdentifier.FacilityContractIdentifierBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityContractIdentifierBuilder {" +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}
}
