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
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.FacilityRolesModel.FacilityRolesModelBuilder;
import fpml.confirmation.FacilityRolesModel.FacilityRolesModelBuilderImpl;
import fpml.confirmation.FacilityRolesModel.FacilityRolesModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.FacilityRolesModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model that describes the various roles played by parties within a given facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityRolesModel", builder=FacilityRolesModel.FacilityRolesModelBuilderImpl.class, version="${project.version}")
public interface FacilityRolesModel extends RosettaModelObject {

	FacilityRolesModelMeta metaData = new FacilityRolesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A party reference to the (main) borrower. This may be different to the issuer defined at the deal-level.
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 * Party references to co-borrowers as listed on the credit agreement.
	 */
	List<? extends PartyReference> getCoBorrowerPartyReference();
	/**
	 * A party reference to the agent bank. Each facility (within a single deal) can have specific/different agent banks, especially if there are jurisdictional boundaries being crossed.
	 */
	PartyReference getAgentPartyReference();
	/**
	 * Party references to any guarantors associated with the facility borrower.
	 */
	List<? extends PartyReference> getLcIssuingBankPartyReference();
	/**
	 * Party references to any guarantors associated with the facility borrower.
	 */
	List<? extends PartyReference> getGuarantorPartyReference();

	/*********************** Build Methods  ***********************/
	FacilityRolesModel build();
	
	FacilityRolesModel.FacilityRolesModelBuilder toBuilder();
	
	static FacilityRolesModel.FacilityRolesModelBuilder builder() {
		return new FacilityRolesModel.FacilityRolesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityRolesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityRolesModel> getType() {
		return FacilityRolesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.class, getCoBorrowerPartyReference());
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.class, getLcIssuingBankPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityRolesModelBuilder extends FacilityRolesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateCoBorrowerPartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getCoBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference();
		PartyReference.PartyReferenceBuilder getAgentPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateLcIssuingBankPartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getLcIssuingBankPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference();
		FacilityRolesModel.FacilityRolesModelBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		FacilityRolesModel.FacilityRolesModelBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference0);
		FacilityRolesModel.FacilityRolesModelBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference1, int _idx);
		FacilityRolesModel.FacilityRolesModelBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference2);
		FacilityRolesModel.FacilityRolesModelBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference3);
		FacilityRolesModel.FacilityRolesModelBuilder setAgentPartyReference(PartyReference agentPartyReference);
		FacilityRolesModel.FacilityRolesModelBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference0);
		FacilityRolesModel.FacilityRolesModelBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference1, int _idx);
		FacilityRolesModel.FacilityRolesModelBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference2);
		FacilityRolesModel.FacilityRolesModelBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference3);
		FacilityRolesModel.FacilityRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference0);
		FacilityRolesModel.FacilityRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference1, int _idx);
		FacilityRolesModel.FacilityRolesModelBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference2);
		FacilityRolesModel.FacilityRolesModelBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCoBorrowerPartyReference());
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLcIssuingBankPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
		}
		

		FacilityRolesModel.FacilityRolesModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityRolesModel  ***********************/
	class FacilityRolesModelImpl implements FacilityRolesModel {
		private final PartyReference borrowerPartyReference;
		private final List<? extends PartyReference> coBorrowerPartyReference;
		private final PartyReference agentPartyReference;
		private final List<? extends PartyReference> lcIssuingBankPartyReference;
		private final List<? extends PartyReference> guarantorPartyReference;
		
		protected FacilityRolesModelImpl(FacilityRolesModel.FacilityRolesModelBuilder builder) {
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.coBorrowerPartyReference = ofNullable(builder.getCoBorrowerPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.agentPartyReference = ofNullable(builder.getAgentPartyReference()).map(f->f.build()).orElse(null);
			this.lcIssuingBankPartyReference = ofNullable(builder.getLcIssuingBankPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.guarantorPartyReference = ofNullable(builder.getGuarantorPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("coBorrowerPartyReference")
		public List<? extends PartyReference> getCoBorrowerPartyReference() {
			return coBorrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		public PartyReference getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		@RosettaAttribute("lcIssuingBankPartyReference")
		public List<? extends PartyReference> getLcIssuingBankPartyReference() {
			return lcIssuingBankPartyReference;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public List<? extends PartyReference> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		public FacilityRolesModel build() {
			return this;
		}
		
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder toBuilder() {
			FacilityRolesModel.FacilityRolesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityRolesModel.FacilityRolesModelBuilder builder) {
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getCoBorrowerPartyReference()).ifPresent(builder::setCoBorrowerPartyReference);
			ofNullable(getAgentPartyReference()).ifPresent(builder::setAgentPartyReference);
			ofNullable(getLcIssuingBankPartyReference()).ifPresent(builder::setLcIssuingBankPartyReference);
			ofNullable(getGuarantorPartyReference()).ifPresent(builder::setGuarantorPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!ListEquals.listEquals(coBorrowerPartyReference, _that.getCoBorrowerPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!ListEquals.listEquals(lcIssuingBankPartyReference, _that.getLcIssuingBankPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (coBorrowerPartyReference != null ? coBorrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (lcIssuingBankPartyReference != null ? lcIssuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRolesModel {" +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"coBorrowerPartyReference=" + this.coBorrowerPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"lcIssuingBankPartyReference=" + this.lcIssuingBankPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityRolesModel  ***********************/
	class FacilityRolesModelBuilderImpl implements FacilityRolesModel.FacilityRolesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> coBorrowerPartyReference = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder agentPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> lcIssuingBankPartyReference = new ArrayList<>();
		protected List<PartyReference.PartyReferenceBuilder> guarantorPartyReference = new ArrayList<>();
	
		public FacilityRolesModelBuilderImpl() {
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
		@RosettaAttribute("coBorrowerPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getCoBorrowerPartyReference() {
			return coBorrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCoBorrowerPartyReference(int _index) {
		
			if (coBorrowerPartyReference==null) {
				this.coBorrowerPartyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(coBorrowerPartyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newCoBorrowerPartyReference = PartyReference.builder();
						return newCoBorrowerPartyReference;
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
		@RosettaAttribute("lcIssuingBankPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getLcIssuingBankPartyReference() {
			return lcIssuingBankPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateLcIssuingBankPartyReference(int _index) {
		
			if (lcIssuingBankPartyReference==null) {
				this.lcIssuingBankPartyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(lcIssuingBankPartyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newLcIssuingBankPartyReference = PartyReference.builder();
						return newLcIssuingBankPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
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
		@RosettaAttribute("borrowerPartyReference")
		public FacilityRolesModel.FacilityRolesModelBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference) {
			this.borrowerPartyReference = borrowerPartyReference==null?null:borrowerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("coBorrowerPartyReference")
		public FacilityRolesModel.FacilityRolesModelBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference) {
			if (coBorrowerPartyReference!=null) this.coBorrowerPartyReference.add(coBorrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference, int _idx) {
			getIndex(this.coBorrowerPartyReference, _idx, () -> coBorrowerPartyReference.toBuilder());
			return this;
		}
		@Override 
		public FacilityRolesModel.FacilityRolesModelBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences != null) {
				for (PartyReference toAdd : coBorrowerPartyReferences) {
					this.coBorrowerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityRolesModel.FacilityRolesModelBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences == null)  {
				this.coBorrowerPartyReference = new ArrayList<>();
			}
			else {
				this.coBorrowerPartyReference = coBorrowerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		public FacilityRolesModel.FacilityRolesModelBuilder setAgentPartyReference(PartyReference agentPartyReference) {
			this.agentPartyReference = agentPartyReference==null?null:agentPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lcIssuingBankPartyReference")
		public FacilityRolesModel.FacilityRolesModelBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference) {
			if (lcIssuingBankPartyReference!=null) this.lcIssuingBankPartyReference.add(lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference, int _idx) {
			getIndex(this.lcIssuingBankPartyReference, _idx, () -> lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		@Override 
		public FacilityRolesModel.FacilityRolesModelBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences != null) {
				for (PartyReference toAdd : lcIssuingBankPartyReferences) {
					this.lcIssuingBankPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityRolesModel.FacilityRolesModelBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences == null)  {
				this.lcIssuingBankPartyReference = new ArrayList<>();
			}
			else {
				this.lcIssuingBankPartyReference = lcIssuingBankPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		public FacilityRolesModel.FacilityRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference) {
			if (guarantorPartyReference!=null) this.guarantorPartyReference.add(guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int _idx) {
			getIndex(this.guarantorPartyReference, _idx, () -> guarantorPartyReference.toBuilder());
			return this;
		}
		@Override 
		public FacilityRolesModel.FacilityRolesModelBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences != null) {
				for (PartyReference toAdd : guarantorPartyReferences) {
					this.guarantorPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityRolesModel.FacilityRolesModelBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public FacilityRolesModel build() {
			return new FacilityRolesModel.FacilityRolesModelImpl(this);
		}
		
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder prune() {
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			coBorrowerPartyReference = coBorrowerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (agentPartyReference!=null && !agentPartyReference.prune().hasData()) agentPartyReference = null;
			lcIssuingBankPartyReference = lcIssuingBankPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			guarantorPartyReference = guarantorPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getCoBorrowerPartyReference()!=null && getCoBorrowerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAgentPartyReference()!=null && getAgentPartyReference().hasData()) return true;
			if (getLcIssuingBankPartyReference()!=null && getLcIssuingBankPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGuarantorPartyReference()!=null && getGuarantorPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityRolesModel.FacilityRolesModelBuilder o = (FacilityRolesModel.FacilityRolesModelBuilder) other;
			
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getCoBorrowerPartyReference(), o.getCoBorrowerPartyReference(), this::getOrCreateCoBorrowerPartyReference);
			merger.mergeRosetta(getAgentPartyReference(), o.getAgentPartyReference(), this::setAgentPartyReference);
			merger.mergeRosetta(getLcIssuingBankPartyReference(), o.getLcIssuingBankPartyReference(), this::getOrCreateLcIssuingBankPartyReference);
			merger.mergeRosetta(getGuarantorPartyReference(), o.getGuarantorPartyReference(), this::getOrCreateGuarantorPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!ListEquals.listEquals(coBorrowerPartyReference, _that.getCoBorrowerPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!ListEquals.listEquals(lcIssuingBankPartyReference, _that.getLcIssuingBankPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (coBorrowerPartyReference != null ? coBorrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (lcIssuingBankPartyReference != null ? lcIssuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRolesModelBuilder {" +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"coBorrowerPartyReference=" + this.coBorrowerPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"lcIssuingBankPartyReference=" + this.lcIssuingBankPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference +
			'}';
		}
	}
}
