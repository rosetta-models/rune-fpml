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
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.PartyRole;
import fpml.confirmation.PartyRoleType;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.RelatedParty.RelatedPartyBuilder;
import fpml.confirmation.RelatedParty.RelatedPartyBuilderImpl;
import fpml.confirmation.RelatedParty.RelatedPartyImpl;
import fpml.confirmation.meta.RelatedPartyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RelatedParty", builder=RelatedParty.RelatedPartyBuilderImpl.class, version="${project.version}")
public interface RelatedParty extends RosettaModelObject {

	RelatedPartyMeta metaData = new RelatedPartyMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	/**
	 * The category of the relationship. The related party performs the role specified in this field for the base party. For example, if the role is &quot;Guarantor&quot;, the related party acts as a guarantor for the base party.
	 */
	PartyRole getRole();
	/**
	 * Additional definition refining the type of relationship. For example, if the &quot;role&quot; is Guarantor, this element may be used to specify whether all positions are guaranteed, or only a subset of them.
	 */
	PartyRoleType getType_();

	/*********************** Build Methods  ***********************/
	RelatedParty build();
	
	RelatedParty.RelatedPartyBuilder toBuilder();
	
	static RelatedParty.RelatedPartyBuilder builder() {
		return new RelatedParty.RelatedPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelatedParty> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RelatedParty> getType() {
		return RelatedParty.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("role"), processor, PartyRole.class, getRole());
		processRosetta(path.newSubPath("type"), processor, PartyRoleType.class, getType_());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelatedPartyBuilder extends RelatedParty, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		PartyRole.PartyRoleBuilder getOrCreateRole();
		PartyRole.PartyRoleBuilder getRole();
		PartyRoleType.PartyRoleTypeBuilder getOrCreateType();
		PartyRoleType.PartyRoleTypeBuilder getType_();
		RelatedParty.RelatedPartyBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		RelatedParty.RelatedPartyBuilder setRole(PartyRole role);
		RelatedParty.RelatedPartyBuilder setType(PartyRoleType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("role"), processor, PartyRole.PartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("type"), processor, PartyRoleType.PartyRoleTypeBuilder.class, getType_());
		}
		

		RelatedParty.RelatedPartyBuilder prune();
	}

	/*********************** Immutable Implementation of RelatedParty  ***********************/
	class RelatedPartyImpl implements RelatedParty {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final PartyRole role;
		private final PartyRoleType type;
		
		protected RelatedPartyImpl(RelatedParty.RelatedPartyBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder.getType_()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("role")
		public PartyRole getRole() {
			return role;
		}
		
		@Override
		@RosettaAttribute("type")
		public PartyRoleType getType_() {
			return type;
		}
		
		@Override
		public RelatedParty build() {
			return this;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder toBuilder() {
			RelatedParty.RelatedPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelatedParty.RelatedPartyBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getRole()).ifPresent(builder::setRole);
			ofNullable(getType_()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedParty _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedParty {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"role=" + this.role + ", " +
				"type=" + this.type +
			'}';
		}
	}

	/*********************** Builder Implementation of RelatedParty  ***********************/
	class RelatedPartyBuilderImpl implements RelatedParty.RelatedPartyBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected PartyRole.PartyRoleBuilder role;
		protected PartyRoleType.PartyRoleTypeBuilder type;
	
		public RelatedPartyBuilderImpl() {
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
		@RosettaAttribute("role")
		public PartyRole.PartyRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder getOrCreateRole() {
			PartyRole.PartyRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = PartyRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		public PartyRoleType.PartyRoleTypeBuilder getType_() {
			return type;
		}
		
		@Override
		public PartyRoleType.PartyRoleTypeBuilder getOrCreateType() {
			PartyRoleType.PartyRoleTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = PartyRoleType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public RelatedParty.RelatedPartyBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public RelatedParty.RelatedPartyBuilder setRole(PartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("type")
		public RelatedParty.RelatedPartyBuilder setType(PartyRoleType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		
		@Override
		public RelatedParty build() {
			return new RelatedParty.RelatedPartyImpl(this);
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedParty.RelatedPartyBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			if (role!=null && !role.prune().hasData()) role = null;
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			if (getType_()!=null && getType_().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedParty.RelatedPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelatedParty.RelatedPartyBuilder o = (RelatedParty.RelatedPartyBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			merger.mergeRosetta(getType_(), o.getType_(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedParty _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedPartyBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"role=" + this.role + ", " +
				"type=" + this.type +
			'}';
		}
	}
}
