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
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.DealRolesModel.DealRolesModelBuilder;
import fpml.confirmation.DealRolesModel.DealRolesModelBuilderImpl;
import fpml.confirmation.DealRolesModel.DealRolesModelImpl;
import fpml.confirmation.DealRolesModelSequence;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.DealRolesModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model that defines all parties playing various roles within a given deal.
 * @version ${project.version}
 */
@RosettaDataType(value="DealRolesModel", builder=DealRolesModel.DealRolesModelBuilderImpl.class, version="${project.version}")
public interface DealRolesModel extends RosettaModelObject {

	DealRolesModelMeta metaData = new DealRolesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A party reference to the (main) issuer of the deal.
	 */
	PartyReference getIssuerPartyReference();
	/**
	 * Party references to the guarantors associated with the (main) issuer of the deal.
	 */
	List<? extends PartyReference> getGuarantorPartyReference();
	/**
	 * A party reference to the agent bank associated with the deal.
	 */
	PartyReference getAgentPartyReference();
	DealRolesModelSequence getDealRolesModelSequence();

	/*********************** Build Methods  ***********************/
	DealRolesModel build();
	
	DealRolesModel.DealRolesModelBuilder toBuilder();
	
	static DealRolesModel.DealRolesModelBuilder builder() {
		return new DealRolesModel.DealRolesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealRolesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DealRolesModel> getType() {
		return DealRolesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.class, getIssuerPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("dealRolesModelSequence"), processor, DealRolesModelSequence.class, getDealRolesModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealRolesModelBuilder extends DealRolesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference();
		PartyReference.PartyReferenceBuilder getIssuerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference();
		PartyReference.PartyReferenceBuilder getAgentPartyReference();
		DealRolesModelSequence.DealRolesModelSequenceBuilder getOrCreateDealRolesModelSequence();
		DealRolesModelSequence.DealRolesModelSequenceBuilder getDealRolesModelSequence();
		DealRolesModel.DealRolesModelBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		DealRolesModel.DealRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference0);
		DealRolesModel.DealRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference1, int _idx);
		DealRolesModel.DealRolesModelBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference2);
		DealRolesModel.DealRolesModelBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference3);
		DealRolesModel.DealRolesModelBuilder setAgentPartyReference(PartyReference agentPartyReference);
		DealRolesModel.DealRolesModelBuilder setDealRolesModelSequence(DealRolesModelSequence dealRolesModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuerPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("dealRolesModelSequence"), processor, DealRolesModelSequence.DealRolesModelSequenceBuilder.class, getDealRolesModelSequence());
		}
		

		DealRolesModel.DealRolesModelBuilder prune();
	}

	/*********************** Immutable Implementation of DealRolesModel  ***********************/
	class DealRolesModelImpl implements DealRolesModel {
		private final PartyReference issuerPartyReference;
		private final List<? extends PartyReference> guarantorPartyReference;
		private final PartyReference agentPartyReference;
		private final DealRolesModelSequence dealRolesModelSequence;
		
		protected DealRolesModelImpl(DealRolesModel.DealRolesModelBuilder builder) {
			this.issuerPartyReference = ofNullable(builder.getIssuerPartyReference()).map(f->f.build()).orElse(null);
			this.guarantorPartyReference = ofNullable(builder.getGuarantorPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.agentPartyReference = ofNullable(builder.getAgentPartyReference()).map(f->f.build()).orElse(null);
			this.dealRolesModelSequence = ofNullable(builder.getDealRolesModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		public PartyReference getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public List<? extends PartyReference> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		public PartyReference getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		@RosettaAttribute("dealRolesModelSequence")
		public DealRolesModelSequence getDealRolesModelSequence() {
			return dealRolesModelSequence;
		}
		
		@Override
		public DealRolesModel build() {
			return this;
		}
		
		@Override
		public DealRolesModel.DealRolesModelBuilder toBuilder() {
			DealRolesModel.DealRolesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealRolesModel.DealRolesModelBuilder builder) {
			ofNullable(getIssuerPartyReference()).ifPresent(builder::setIssuerPartyReference);
			ofNullable(getGuarantorPartyReference()).ifPresent(builder::setGuarantorPartyReference);
			ofNullable(getAgentPartyReference()).ifPresent(builder::setAgentPartyReference);
			ofNullable(getDealRolesModelSequence()).ifPresent(builder::setDealRolesModelSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(dealRolesModelSequence, _that.getDealRolesModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (dealRolesModelSequence != null ? dealRolesModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealRolesModel {" +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"dealRolesModelSequence=" + this.dealRolesModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of DealRolesModel  ***********************/
	class DealRolesModelBuilderImpl implements DealRolesModel.DealRolesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder issuerPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> guarantorPartyReference = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder agentPartyReference;
		protected DealRolesModelSequence.DealRolesModelSequenceBuilder dealRolesModelSequence;
	
		public DealRolesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("issuerPartyReference")
		public PartyReference.PartyReferenceBuilder getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (issuerPartyReference!=null) {
				result = issuerPartyReference;
			}
			else {
				result = issuerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		public PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference(int _index) {
		
			if (guarantorPartyReference==null) {
				this.guarantorPartyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(guarantorPartyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newGuarantorPartyReference = PartyReference.builder();
						return newGuarantorPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		public PartyReference.PartyReferenceBuilder getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (agentPartyReference!=null) {
				result = agentPartyReference;
			}
			else {
				result = agentPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealRolesModelSequence")
		public DealRolesModelSequence.DealRolesModelSequenceBuilder getDealRolesModelSequence() {
			return dealRolesModelSequence;
		}
		
		@Override
		public DealRolesModelSequence.DealRolesModelSequenceBuilder getOrCreateDealRolesModelSequence() {
			DealRolesModelSequence.DealRolesModelSequenceBuilder result;
			if (dealRolesModelSequence!=null) {
				result = dealRolesModelSequence;
			}
			else {
				result = dealRolesModelSequence = DealRolesModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		public DealRolesModel.DealRolesModelBuilder setIssuerPartyReference(PartyReference issuerPartyReference) {
			this.issuerPartyReference = issuerPartyReference==null?null:issuerPartyReference.toBuilder();
			return this;
		}
		@Override
		public DealRolesModel.DealRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference) {
			if (guarantorPartyReference!=null) this.guarantorPartyReference.add(guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public DealRolesModel.DealRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int _idx) {
			getIndex(this.guarantorPartyReference, _idx, () -> guarantorPartyReference.toBuilder());
			return this;
		}
		@Override 
		public DealRolesModel.DealRolesModelBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences != null) {
				for (PartyReference toAdd : guarantorPartyReferences) {
					this.guarantorPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("guarantorPartyReference")
		public DealRolesModel.DealRolesModelBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences == null)  {
				this.guarantorPartyReference = new ArrayList<>();
			}
			else {
				this.guarantorPartyReference = guarantorPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		public DealRolesModel.DealRolesModelBuilder setAgentPartyReference(PartyReference agentPartyReference) {
			this.agentPartyReference = agentPartyReference==null?null:agentPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dealRolesModelSequence")
		public DealRolesModel.DealRolesModelBuilder setDealRolesModelSequence(DealRolesModelSequence dealRolesModelSequence) {
			this.dealRolesModelSequence = dealRolesModelSequence==null?null:dealRolesModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public DealRolesModel build() {
			return new DealRolesModel.DealRolesModelImpl(this);
		}
		
		@Override
		public DealRolesModel.DealRolesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealRolesModel.DealRolesModelBuilder prune() {
			if (issuerPartyReference!=null && !issuerPartyReference.prune().hasData()) issuerPartyReference = null;
			guarantorPartyReference = guarantorPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (agentPartyReference!=null && !agentPartyReference.prune().hasData()) agentPartyReference = null;
			if (dealRolesModelSequence!=null && !dealRolesModelSequence.prune().hasData()) dealRolesModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuerPartyReference()!=null && getIssuerPartyReference().hasData()) return true;
			if (getGuarantorPartyReference()!=null && getGuarantorPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAgentPartyReference()!=null && getAgentPartyReference().hasData()) return true;
			if (getDealRolesModelSequence()!=null && getDealRolesModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealRolesModel.DealRolesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DealRolesModel.DealRolesModelBuilder o = (DealRolesModel.DealRolesModelBuilder) other;
			
			merger.mergeRosetta(getIssuerPartyReference(), o.getIssuerPartyReference(), this::setIssuerPartyReference);
			merger.mergeRosetta(getGuarantorPartyReference(), o.getGuarantorPartyReference(), this::getOrCreateGuarantorPartyReference);
			merger.mergeRosetta(getAgentPartyReference(), o.getAgentPartyReference(), this::setAgentPartyReference);
			merger.mergeRosetta(getDealRolesModelSequence(), o.getDealRolesModelSequence(), this::setDealRolesModelSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(dealRolesModelSequence, _that.getDealRolesModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (dealRolesModelSequence != null ? dealRolesModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealRolesModelBuilder {" +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"dealRolesModelSequence=" + this.dealRolesModelSequence +
			'}';
		}
	}
}
