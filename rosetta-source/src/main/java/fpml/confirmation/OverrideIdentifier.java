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
import fpml.confirmation.OverrideId;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.OverrideIdentifier.OverrideIdentifierBuilder;
import fpml.confirmation.OverrideIdentifier.OverrideIdentifierBuilderImpl;
import fpml.confirmation.OverrideIdentifier.OverrideIdentifierImpl;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.meta.OverrideIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that identifies an override record.
 * @version ${project.version}
 */
@RosettaDataType(value="OverrideIdentifier", builder=OverrideIdentifier.OverrideIdentifierBuilderImpl.class, version="${project.version}")
public interface OverrideIdentifier extends RosettaModelObject {

	OverrideIdentifierMeta metaData = new OverrideIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	OverrideId getOverrideId();
	String getId();

	/*********************** Build Methods  ***********************/
	OverrideIdentifier build();
	
	OverrideIdentifier.OverrideIdentifierBuilder toBuilder();
	
	static OverrideIdentifier.OverrideIdentifierBuilder builder() {
		return new OverrideIdentifier.OverrideIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OverrideIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OverrideIdentifier> getType() {
		return OverrideIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("overrideId"), processor, OverrideId.class, getOverrideId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OverrideIdentifierBuilder extends OverrideIdentifier, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		OverrideId.OverrideIdBuilder getOrCreateOverrideId();
		OverrideId.OverrideIdBuilder getOverrideId();
		OverrideIdentifier.OverrideIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		OverrideIdentifier.OverrideIdentifierBuilder setOverrideId(OverrideId overrideId);
		OverrideIdentifier.OverrideIdentifierBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("overrideId"), processor, OverrideId.OverrideIdBuilder.class, getOverrideId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		OverrideIdentifier.OverrideIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of OverrideIdentifier  ***********************/
	class OverrideIdentifierImpl implements OverrideIdentifier {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final OverrideId overrideId;
		private final String id;
		
		protected OverrideIdentifierImpl(OverrideIdentifier.OverrideIdentifierBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.overrideId = ofNullable(builder.getOverrideId()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("overrideId")
		public OverrideId getOverrideId() {
			return overrideId;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public OverrideIdentifier build() {
			return this;
		}
		
		@Override
		public OverrideIdentifier.OverrideIdentifierBuilder toBuilder() {
			OverrideIdentifier.OverrideIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OverrideIdentifier.OverrideIdentifierBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getOverrideId()).ifPresent(builder::setOverrideId);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OverrideIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(overrideId, _that.getOverrideId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (overrideId != null ? overrideId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OverrideIdentifier {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"overrideId=" + this.overrideId + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of OverrideIdentifier  ***********************/
	class OverrideIdentifierBuilderImpl implements OverrideIdentifier.OverrideIdentifierBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected OverrideId.OverrideIdBuilder overrideId;
		protected String id;
	
		public OverrideIdentifierBuilderImpl() {
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
		@RosettaAttribute("overrideId")
		public OverrideId.OverrideIdBuilder getOverrideId() {
			return overrideId;
		}
		
		@Override
		public OverrideId.OverrideIdBuilder getOrCreateOverrideId() {
			OverrideId.OverrideIdBuilder result;
			if (overrideId!=null) {
				result = overrideId;
			}
			else {
				result = overrideId = OverrideId.builder();
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
		public OverrideIdentifier.OverrideIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("overrideId")
		public OverrideIdentifier.OverrideIdentifierBuilder setOverrideId(OverrideId overrideId) {
			this.overrideId = overrideId==null?null:overrideId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public OverrideIdentifier.OverrideIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public OverrideIdentifier build() {
			return new OverrideIdentifier.OverrideIdentifierImpl(this);
		}
		
		@Override
		public OverrideIdentifier.OverrideIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OverrideIdentifier.OverrideIdentifierBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			if (overrideId!=null && !overrideId.prune().hasData()) overrideId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getOverrideId()!=null && getOverrideId().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OverrideIdentifier.OverrideIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OverrideIdentifier.OverrideIdentifierBuilder o = (OverrideIdentifier.OverrideIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getOverrideId(), o.getOverrideId(), this::setOverrideId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OverrideIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(overrideId, _that.getOverrideId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (overrideId != null ? overrideId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OverrideIdentifierBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"overrideId=" + this.overrideId + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
