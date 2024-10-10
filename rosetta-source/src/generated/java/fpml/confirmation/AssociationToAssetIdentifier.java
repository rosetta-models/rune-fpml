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
import fpml.confirmation.AssociationToAssetId;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder;
import fpml.confirmation.AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilderImpl;
import fpml.confirmation.AssociationToAssetIdentifier.AssociationToAssetIdentifierImpl;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.meta.AssociationToAssetIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining an association between party or settlement information with an asset or assets
 * @version ${project.version}
 */
@RosettaDataType(value="AssociationToAssetIdentifier", builder=AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilderImpl.class, version="${project.version}")
public interface AssociationToAssetIdentifier extends RosettaModelObject {

	AssociationToAssetIdentifierMeta metaData = new AssociationToAssetIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	AssociationToAssetId getAssociationtId();
	String getId();

	/*********************** Build Methods  ***********************/
	AssociationToAssetIdentifier build();
	
	AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder toBuilder();
	
	static AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder() {
		return new AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssociationToAssetIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AssociationToAssetIdentifier> getType() {
		return AssociationToAssetIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("associationtId"), processor, AssociationToAssetId.class, getAssociationtId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssociationToAssetIdentifierBuilder extends AssociationToAssetIdentifier, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		AssociationToAssetId.AssociationToAssetIdBuilder getOrCreateAssociationtId();
		AssociationToAssetId.AssociationToAssetIdBuilder getAssociationtId();
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setAssociationtId(AssociationToAssetId associationtId);
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("associationtId"), processor, AssociationToAssetId.AssociationToAssetIdBuilder.class, getAssociationtId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of AssociationToAssetIdentifier  ***********************/
	class AssociationToAssetIdentifierImpl implements AssociationToAssetIdentifier {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final AssociationToAssetId associationtId;
		private final String id;
		
		protected AssociationToAssetIdentifierImpl(AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.associationtId = ofNullable(builder.getAssociationtId()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("associationtId")
		public AssociationToAssetId getAssociationtId() {
			return associationtId;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AssociationToAssetIdentifier build() {
			return this;
		}
		
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder toBuilder() {
			AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getAssociationtId()).ifPresent(builder::setAssociationtId);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(associationtId, _that.getAssociationtId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (associationtId != null ? associationtId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetIdentifier {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"associationtId=" + this.associationtId + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AssociationToAssetIdentifier  ***********************/
	class AssociationToAssetIdentifierBuilderImpl implements AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected AssociationToAssetId.AssociationToAssetIdBuilder associationtId;
		protected String id;
	
		public AssociationToAssetIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel() {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder result;
			if (partyAndAccountReferencesModel!=null) {
				result = partyAndAccountReferencesModel;
			}
			else {
				result = partyAndAccountReferencesModel = PartyAndAccountReferencesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("associationtId")
		public AssociationToAssetId.AssociationToAssetIdBuilder getAssociationtId() {
			return associationtId;
		}
		
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder getOrCreateAssociationtId() {
			AssociationToAssetId.AssociationToAssetIdBuilder result;
			if (associationtId!=null) {
				result = associationtId;
			}
			else {
				result = associationtId = AssociationToAssetId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("associationtId")
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setAssociationtId(AssociationToAssetId associationtId) {
			this.associationtId = associationtId==null?null:associationtId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AssociationToAssetIdentifier build() {
			return new AssociationToAssetIdentifier.AssociationToAssetIdentifierImpl(this);
		}
		
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			if (associationtId!=null && !associationtId.prune().hasData()) associationtId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getAssociationtId()!=null && getAssociationtId().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder o = (AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getAssociationtId(), o.getAssociationtId(), this::setAssociationtId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(associationtId, _that.getAssociationtId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (associationtId != null ? associationtId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetIdentifierBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"associationtId=" + this.associationtId + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
