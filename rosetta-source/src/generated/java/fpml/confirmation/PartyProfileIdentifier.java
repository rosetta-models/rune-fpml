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
import fpml.confirmation.PartyProfileId;
import fpml.confirmation.PartyProfileIdentifier;
import fpml.confirmation.PartyProfileIdentifier.PartyProfileIdentifierBuilder;
import fpml.confirmation.PartyProfileIdentifier.PartyProfileIdentifierBuilderImpl;
import fpml.confirmation.PartyProfileIdentifier.PartyProfileIdentifierImpl;
import fpml.confirmation.meta.PartyProfileIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that identifies a party profile record.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyProfileIdentifier", builder=PartyProfileIdentifier.PartyProfileIdentifierBuilderImpl.class, version="${project.version}")
public interface PartyProfileIdentifier extends RosettaModelObject {

	PartyProfileIdentifierMeta metaData = new PartyProfileIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	PartyProfileId getPartyProfileId();
	String getId();

	/*********************** Build Methods  ***********************/
	PartyProfileIdentifier build();
	
	PartyProfileIdentifier.PartyProfileIdentifierBuilder toBuilder();
	
	static PartyProfileIdentifier.PartyProfileIdentifierBuilder builder() {
		return new PartyProfileIdentifier.PartyProfileIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfileIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyProfileIdentifier> getType() {
		return PartyProfileIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("partyProfileId"), processor, PartyProfileId.class, getPartyProfileId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileIdentifierBuilder extends PartyProfileIdentifier, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		PartyProfileId.PartyProfileIdBuilder getOrCreatePartyProfileId();
		PartyProfileId.PartyProfileIdBuilder getPartyProfileId();
		PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyProfileId(PartyProfileId partyProfileId);
		PartyProfileIdentifier.PartyProfileIdentifierBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("partyProfileId"), processor, PartyProfileId.PartyProfileIdBuilder.class, getPartyProfileId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PartyProfileIdentifier.PartyProfileIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfileIdentifier  ***********************/
	class PartyProfileIdentifierImpl implements PartyProfileIdentifier {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final PartyProfileId partyProfileId;
		private final String id;
		
		protected PartyProfileIdentifierImpl(PartyProfileIdentifier.PartyProfileIdentifierBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.partyProfileId = ofNullable(builder.getPartyProfileId()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("partyProfileId")
		public PartyProfileId getPartyProfileId() {
			return partyProfileId;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PartyProfileIdentifier build() {
			return this;
		}
		
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder toBuilder() {
			PartyProfileIdentifier.PartyProfileIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfileIdentifier.PartyProfileIdentifierBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getPartyProfileId()).ifPresent(builder::setPartyProfileId);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(partyProfileId, _that.getPartyProfileId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (partyProfileId != null ? partyProfileId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileIdentifier {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"partyProfileId=" + this.partyProfileId + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyProfileIdentifier  ***********************/
	class PartyProfileIdentifierBuilderImpl implements PartyProfileIdentifier.PartyProfileIdentifierBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected PartyProfileId.PartyProfileIdBuilder partyProfileId;
		protected String id;
	
		public PartyProfileIdentifierBuilderImpl() {
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
		@RosettaAttribute("partyProfileId")
		public PartyProfileId.PartyProfileIdBuilder getPartyProfileId() {
			return partyProfileId;
		}
		
		@Override
		public PartyProfileId.PartyProfileIdBuilder getOrCreatePartyProfileId() {
			PartyProfileId.PartyProfileIdBuilder result;
			if (partyProfileId!=null) {
				result = partyProfileId;
			}
			else {
				result = partyProfileId = PartyProfileId.builder();
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
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partyProfileId")
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyProfileId(PartyProfileId partyProfileId) {
			this.partyProfileId = partyProfileId==null?null:partyProfileId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PartyProfileIdentifier build() {
			return new PartyProfileIdentifier.PartyProfileIdentifierImpl(this);
		}
		
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			if (partyProfileId!=null && !partyProfileId.prune().hasData()) partyProfileId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getPartyProfileId()!=null && getPartyProfileId().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyProfileIdentifier.PartyProfileIdentifierBuilder o = (PartyProfileIdentifier.PartyProfileIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getPartyProfileId(), o.getPartyProfileId(), this::setPartyProfileId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(partyProfileId, _that.getPartyProfileId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (partyProfileId != null ? partyProfileId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileIdentifierBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"partyProfileId=" + this.partyProfileId + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
