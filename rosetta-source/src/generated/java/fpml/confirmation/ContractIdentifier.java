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
import fpml.confirmation.ContractId;
import fpml.confirmation.ContractIdentifier;
import fpml.confirmation.ContractIdentifier.ContractIdentifierBuilder;
import fpml.confirmation.ContractIdentifier.ContractIdentifierBuilderImpl;
import fpml.confirmation.ContractIdentifier.ContractIdentifierImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.VersionedContractId;
import fpml.confirmation.meta.ContractIdentifierMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a contract identifier issued by the indicated party.
 * @version ${project.version}
 */
@RosettaDataType(value="ContractIdentifier", builder=ContractIdentifier.ContractIdentifierBuilderImpl.class, version="${project.version}")
public interface ContractIdentifier extends RosettaModelObject {

	ContractIdentifierMeta metaData = new ContractIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has allocated the contract identifier.
	 */
	PartyReference getPartyReference();
	/**
	 * A contract id which is not version aware.
	 */
	List<? extends ContractId> getContractId();
	/**
	 * A contract id which is version aware.
	 */
	List<? extends VersionedContractId> getVersionedContractId();
	String getId();

	/*********************** Build Methods  ***********************/
	ContractIdentifier build();
	
	ContractIdentifier.ContractIdentifierBuilder toBuilder();
	
	static ContractIdentifier.ContractIdentifierBuilder builder() {
		return new ContractIdentifier.ContractIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ContractIdentifier> getType() {
		return ContractIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.class, getVersionedContractId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractIdentifierBuilder extends ContractIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		ContractId.ContractIdBuilder getOrCreateContractId(int _index);
		List<? extends ContractId.ContractIdBuilder> getContractId();
		VersionedContractId.VersionedContractIdBuilder getOrCreateVersionedContractId(int _index);
		List<? extends VersionedContractId.VersionedContractIdBuilder> getVersionedContractId();
		ContractIdentifier.ContractIdentifierBuilder setPartyReference(PartyReference partyReference);
		ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId contractId0);
		ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId contractId1, int _idx);
		ContractIdentifier.ContractIdentifierBuilder addContractId(List<? extends ContractId> contractId2);
		ContractIdentifier.ContractIdentifierBuilder setContractId(List<? extends ContractId> contractId3);
		ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId0);
		ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId1, int _idx);
		ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId2);
		ContractIdentifier.ContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId3);
		ContractIdentifier.ContractIdentifierBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.VersionedContractIdBuilder.class, getVersionedContractId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ContractIdentifier.ContractIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ContractIdentifier  ***********************/
	class ContractIdentifierImpl implements ContractIdentifier {
		private final PartyReference partyReference;
		private final List<? extends ContractId> contractId;
		private final List<? extends VersionedContractId> versionedContractId;
		private final String id;
		
		protected ContractIdentifierImpl(ContractIdentifier.ContractIdentifierBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.contractId = ofNullable(builder.getContractId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.versionedContractId = ofNullable(builder.getVersionedContractId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("contractId")
		public List<? extends ContractId> getContractId() {
			return contractId;
		}
		
		@Override
		@RosettaAttribute("versionedContractId")
		public List<? extends VersionedContractId> getVersionedContractId() {
			return versionedContractId;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ContractIdentifier build() {
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder toBuilder() {
			ContractIdentifier.ContractIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractIdentifier.ContractIdentifierBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getContractId()).ifPresent(builder::setContractId);
			ofNullable(getVersionedContractId()).ifPresent(builder::setVersionedContractId);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(contractId, _that.getContractId())) return false;
			if (!ListEquals.listEquals(versionedContractId, _that.getVersionedContractId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (versionedContractId != null ? versionedContractId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractIdentifier {" +
				"partyReference=" + this.partyReference + ", " +
				"contractId=" + this.contractId + ", " +
				"versionedContractId=" + this.versionedContractId + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractIdentifier  ***********************/
	class ContractIdentifierBuilderImpl implements ContractIdentifier.ContractIdentifierBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<ContractId.ContractIdBuilder> contractId = new ArrayList<>();
		protected List<VersionedContractId.VersionedContractIdBuilder> versionedContractId = new ArrayList<>();
		protected String id;
	
		public ContractIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractId")
		public List<? extends ContractId.ContractIdBuilder> getContractId() {
			return contractId;
		}
		
		public ContractId.ContractIdBuilder getOrCreateContractId(int _index) {
		
			if (contractId==null) {
				this.contractId = new ArrayList<>();
			}
			ContractId.ContractIdBuilder result;
			return getIndex(contractId, _index, () -> {
						ContractId.ContractIdBuilder newContractId = ContractId.builder();
						return newContractId;
					});
		}
		
		@Override
		@RosettaAttribute("versionedContractId")
		public List<? extends VersionedContractId.VersionedContractIdBuilder> getVersionedContractId() {
			return versionedContractId;
		}
		
		public VersionedContractId.VersionedContractIdBuilder getOrCreateVersionedContractId(int _index) {
		
			if (versionedContractId==null) {
				this.versionedContractId = new ArrayList<>();
			}
			VersionedContractId.VersionedContractIdBuilder result;
			return getIndex(versionedContractId, _index, () -> {
						VersionedContractId.VersionedContractIdBuilder newVersionedContractId = VersionedContractId.builder();
						return newVersionedContractId;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public ContractIdentifier.ContractIdentifierBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId contractId) {
			if (contractId!=null) this.contractId.add(contractId.toBuilder());
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId contractId, int _idx) {
			getIndex(this.contractId, _idx, () -> contractId.toBuilder());
			return this;
		}
		@Override 
		public ContractIdentifier.ContractIdentifierBuilder addContractId(List<? extends ContractId> contractIds) {
			if (contractIds != null) {
				for (ContractId toAdd : contractIds) {
					this.contractId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("contractId")
		public ContractIdentifier.ContractIdentifierBuilder setContractId(List<? extends ContractId> contractIds) {
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
		public ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId) {
			if (versionedContractId!=null) this.versionedContractId.add(versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId, int _idx) {
			getIndex(this.versionedContractId, _idx, () -> versionedContractId.toBuilder());
			return this;
		}
		@Override 
		public ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
			if (versionedContractIds != null) {
				for (VersionedContractId toAdd : versionedContractIds) {
					this.versionedContractId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("versionedContractId")
		public ContractIdentifier.ContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public ContractIdentifier.ContractIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ContractIdentifier build() {
			return new ContractIdentifier.ContractIdentifierImpl(this);
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractIdentifier.ContractIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			contractId = contractId.stream().filter(b->b!=null).<ContractId.ContractIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			versionedContractId = versionedContractId.stream().filter(b->b!=null).<VersionedContractId.VersionedContractIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getContractId()!=null && getContractId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getVersionedContractId()!=null && getVersionedContractId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractIdentifier.ContractIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractIdentifier.ContractIdentifierBuilder o = (ContractIdentifier.ContractIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getContractId(), o.getContractId(), this::getOrCreateContractId);
			merger.mergeRosetta(getVersionedContractId(), o.getVersionedContractId(), this::getOrCreateVersionedContractId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(contractId, _that.getContractId())) return false;
			if (!ListEquals.listEquals(versionedContractId, _that.getVersionedContractId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (versionedContractId != null ? versionedContractId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractIdentifierBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"contractId=" + this.contractId + ", " +
				"versionedContractId=" + this.versionedContractId + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
