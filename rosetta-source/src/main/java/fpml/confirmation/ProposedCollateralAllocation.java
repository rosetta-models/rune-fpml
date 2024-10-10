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
import fpml.confirmation.CollateralPartyAndAccountReferencesModel;
import fpml.confirmation.ProposedCollateralAllocation;
import fpml.confirmation.ProposedCollateralAllocation.ProposedCollateralAllocationBuilder;
import fpml.confirmation.ProposedCollateralAllocation.ProposedCollateralAllocationBuilderImpl;
import fpml.confirmation.ProposedCollateralAllocation.ProposedCollateralAllocationImpl;
import fpml.confirmation.ProposedCollateralAllocationChoice;
import fpml.confirmation.meta.ProposedCollateralAllocationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The proposed collateral allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="ProposedCollateralAllocation", builder=ProposedCollateralAllocation.ProposedCollateralAllocationBuilderImpl.class, version="${project.version}")
public interface ProposedCollateralAllocation extends RosettaModelObject {

	ProposedCollateralAllocationMeta metaData = new ProposedCollateralAllocationMeta();

	/*********************** Getter Methods  ***********************/
	CollateralPartyAndAccountReferencesModel getCollateralPartyAndAccountReferencesModel();
	List<? extends ProposedCollateralAllocationChoice> getProposedCollateralAllocationChoice();

	/*********************** Build Methods  ***********************/
	ProposedCollateralAllocation build();
	
	ProposedCollateralAllocation.ProposedCollateralAllocationBuilder toBuilder();
	
	static ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder() {
		return new ProposedCollateralAllocation.ProposedCollateralAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProposedCollateralAllocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProposedCollateralAllocation> getType() {
		return ProposedCollateralAllocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralPartyAndAccountReferencesModel"), processor, CollateralPartyAndAccountReferencesModel.class, getCollateralPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("proposedCollateralAllocationChoice"), processor, ProposedCollateralAllocationChoice.class, getProposedCollateralAllocationChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProposedCollateralAllocationBuilder extends ProposedCollateralAllocation, RosettaModelObjectBuilder {
		CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder getOrCreateCollateralPartyAndAccountReferencesModel();
		CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder getCollateralPartyAndAccountReferencesModel();
		ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder getOrCreateProposedCollateralAllocationChoice(int _index);
		List<? extends ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder> getProposedCollateralAllocationChoice();
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setCollateralPartyAndAccountReferencesModel(CollateralPartyAndAccountReferencesModel collateralPartyAndAccountReferencesModel);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice proposedCollateralAllocationChoice0);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice proposedCollateralAllocationChoice1, int _idx);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoice2);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoice3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralPartyAndAccountReferencesModel"), processor, CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder.class, getCollateralPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("proposedCollateralAllocationChoice"), processor, ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder.class, getProposedCollateralAllocationChoice());
		}
		

		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of ProposedCollateralAllocation  ***********************/
	class ProposedCollateralAllocationImpl implements ProposedCollateralAllocation {
		private final CollateralPartyAndAccountReferencesModel collateralPartyAndAccountReferencesModel;
		private final List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoice;
		
		protected ProposedCollateralAllocationImpl(ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder) {
			this.collateralPartyAndAccountReferencesModel = ofNullable(builder.getCollateralPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.proposedCollateralAllocationChoice = ofNullable(builder.getProposedCollateralAllocationChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("collateralPartyAndAccountReferencesModel")
		public CollateralPartyAndAccountReferencesModel getCollateralPartyAndAccountReferencesModel() {
			return collateralPartyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("proposedCollateralAllocationChoice")
		public List<? extends ProposedCollateralAllocationChoice> getProposedCollateralAllocationChoice() {
			return proposedCollateralAllocationChoice;
		}
		
		@Override
		public ProposedCollateralAllocation build() {
			return this;
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder toBuilder() {
			ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder) {
			ofNullable(getCollateralPartyAndAccountReferencesModel()).ifPresent(builder::setCollateralPartyAndAccountReferencesModel);
			ofNullable(getProposedCollateralAllocationChoice()).ifPresent(builder::setProposedCollateralAllocationChoice);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(collateralPartyAndAccountReferencesModel, _that.getCollateralPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(proposedCollateralAllocationChoice, _that.getProposedCollateralAllocationChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralPartyAndAccountReferencesModel != null ? collateralPartyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (proposedCollateralAllocationChoice != null ? proposedCollateralAllocationChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedCollateralAllocation {" +
				"collateralPartyAndAccountReferencesModel=" + this.collateralPartyAndAccountReferencesModel + ", " +
				"proposedCollateralAllocationChoice=" + this.proposedCollateralAllocationChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of ProposedCollateralAllocation  ***********************/
	class ProposedCollateralAllocationBuilderImpl implements ProposedCollateralAllocation.ProposedCollateralAllocationBuilder {
	
		protected CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder collateralPartyAndAccountReferencesModel;
		protected List<ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder> proposedCollateralAllocationChoice = new ArrayList<>();
	
		public ProposedCollateralAllocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("collateralPartyAndAccountReferencesModel")
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder getCollateralPartyAndAccountReferencesModel() {
			return collateralPartyAndAccountReferencesModel;
		}
		
		@Override
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder getOrCreateCollateralPartyAndAccountReferencesModel() {
			CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder result;
			if (collateralPartyAndAccountReferencesModel!=null) {
				result = collateralPartyAndAccountReferencesModel;
			}
			else {
				result = collateralPartyAndAccountReferencesModel = CollateralPartyAndAccountReferencesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("proposedCollateralAllocationChoice")
		public List<? extends ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder> getProposedCollateralAllocationChoice() {
			return proposedCollateralAllocationChoice;
		}
		
		public ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder getOrCreateProposedCollateralAllocationChoice(int _index) {
		
			if (proposedCollateralAllocationChoice==null) {
				this.proposedCollateralAllocationChoice = new ArrayList<>();
			}
			ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder result;
			return getIndex(proposedCollateralAllocationChoice, _index, () -> {
						ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder newProposedCollateralAllocationChoice = ProposedCollateralAllocationChoice.builder();
						return newProposedCollateralAllocationChoice;
					});
		}
		
		@Override
		@RosettaAttribute("collateralPartyAndAccountReferencesModel")
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setCollateralPartyAndAccountReferencesModel(CollateralPartyAndAccountReferencesModel collateralPartyAndAccountReferencesModel) {
			this.collateralPartyAndAccountReferencesModel = collateralPartyAndAccountReferencesModel==null?null:collateralPartyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice proposedCollateralAllocationChoice) {
			if (proposedCollateralAllocationChoice!=null) this.proposedCollateralAllocationChoice.add(proposedCollateralAllocationChoice.toBuilder());
			return this;
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice proposedCollateralAllocationChoice, int _idx) {
			getIndex(this.proposedCollateralAllocationChoice, _idx, () -> proposedCollateralAllocationChoice.toBuilder());
			return this;
		}
		@Override 
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoices) {
			if (proposedCollateralAllocationChoices != null) {
				for (ProposedCollateralAllocationChoice toAdd : proposedCollateralAllocationChoices) {
					this.proposedCollateralAllocationChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("proposedCollateralAllocationChoice")
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoices) {
			if (proposedCollateralAllocationChoices == null)  {
				this.proposedCollateralAllocationChoice = new ArrayList<>();
			}
			else {
				this.proposedCollateralAllocationChoice = proposedCollateralAllocationChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ProposedCollateralAllocation build() {
			return new ProposedCollateralAllocation.ProposedCollateralAllocationImpl(this);
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder prune() {
			if (collateralPartyAndAccountReferencesModel!=null && !collateralPartyAndAccountReferencesModel.prune().hasData()) collateralPartyAndAccountReferencesModel = null;
			proposedCollateralAllocationChoice = proposedCollateralAllocationChoice.stream().filter(b->b!=null).<ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralPartyAndAccountReferencesModel()!=null && getCollateralPartyAndAccountReferencesModel().hasData()) return true;
			if (getProposedCollateralAllocationChoice()!=null && getProposedCollateralAllocationChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProposedCollateralAllocation.ProposedCollateralAllocationBuilder o = (ProposedCollateralAllocation.ProposedCollateralAllocationBuilder) other;
			
			merger.mergeRosetta(getCollateralPartyAndAccountReferencesModel(), o.getCollateralPartyAndAccountReferencesModel(), this::setCollateralPartyAndAccountReferencesModel);
			merger.mergeRosetta(getProposedCollateralAllocationChoice(), o.getProposedCollateralAllocationChoice(), this::getOrCreateProposedCollateralAllocationChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(collateralPartyAndAccountReferencesModel, _that.getCollateralPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(proposedCollateralAllocationChoice, _that.getProposedCollateralAllocationChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralPartyAndAccountReferencesModel != null ? collateralPartyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (proposedCollateralAllocationChoice != null ? proposedCollateralAllocationChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedCollateralAllocationBuilder {" +
				"collateralPartyAndAccountReferencesModel=" + this.collateralPartyAndAccountReferencesModel + ", " +
				"proposedCollateralAllocationChoice=" + this.proposedCollateralAllocationChoice +
			'}';
		}
	}
}
