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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventIdentifier.BusinessEventIdentifierBuilder;
import fpml.confirmation.BusinessEventIdentifier.BusinessEventIdentifierBuilderImpl;
import fpml.confirmation.BusinessEventIdentifier.BusinessEventIdentifierImpl;
import fpml.confirmation.EventId;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.meta.BusinessEventIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining an event identifier issued by the indicated party.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessEventIdentifier", builder=BusinessEventIdentifier.BusinessEventIdentifierBuilderImpl.class, version="${project.version}")
public interface BusinessEventIdentifier extends RosettaModelObject {

	BusinessEventIdentifierMeta metaData = new BusinessEventIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	EventId getEventId();
	String getId();

	/*********************** Build Methods  ***********************/
	BusinessEventIdentifier build();
	
	BusinessEventIdentifier.BusinessEventIdentifierBuilder toBuilder();
	
	static BusinessEventIdentifier.BusinessEventIdentifierBuilder builder() {
		return new BusinessEventIdentifier.BusinessEventIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessEventIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessEventIdentifier> getType() {
		return BusinessEventIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("eventId"), processor, EventId.class, getEventId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessEventIdentifierBuilder extends BusinessEventIdentifier, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		EventId.EventIdBuilder getOrCreateEventId();
		EventId.EventIdBuilder getEventId();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		BusinessEventIdentifier.BusinessEventIdentifierBuilder setEventId(EventId eventId);
		BusinessEventIdentifier.BusinessEventIdentifierBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("eventId"), processor, EventId.EventIdBuilder.class, getEventId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BusinessEventIdentifier.BusinessEventIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessEventIdentifier  ***********************/
	class BusinessEventIdentifierImpl implements BusinessEventIdentifier {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final EventId eventId;
		private final String id;
		
		protected BusinessEventIdentifierImpl(BusinessEventIdentifier.BusinessEventIdentifierBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.eventId = ofNullable(builder.getEventId()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("eventId")
		public EventId getEventId() {
			return eventId;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BusinessEventIdentifier build() {
			return this;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder toBuilder() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessEventIdentifier.BusinessEventIdentifierBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getEventId()).ifPresent(builder::setEventId);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEventIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(eventId, _that.getEventId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (eventId != null ? eventId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventIdentifier {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"eventId=" + this.eventId + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessEventIdentifier  ***********************/
	class BusinessEventIdentifierBuilderImpl implements BusinessEventIdentifier.BusinessEventIdentifierBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected EventId.EventIdBuilder eventId;
		protected String id;
	
		public BusinessEventIdentifierBuilderImpl() {
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
		@RosettaAttribute("eventId")
		public EventId.EventIdBuilder getEventId() {
			return eventId;
		}
		
		@Override
		public EventId.EventIdBuilder getOrCreateEventId() {
			EventId.EventIdBuilder result;
			if (eventId!=null) {
				result = eventId;
			}
			else {
				result = eventId = EventId.builder();
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
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventId")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder setEventId(EventId eventId) {
			this.eventId = eventId==null?null:eventId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public BusinessEventIdentifier build() {
			return new BusinessEventIdentifier.BusinessEventIdentifierImpl(this);
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			if (eventId!=null && !eventId.prune().hasData()) eventId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getEventId()!=null && getEventId().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder o = (BusinessEventIdentifier.BusinessEventIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getEventId(), o.getEventId(), this::setEventId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEventIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(eventId, _that.getEventId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (eventId != null ? eventId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventIdentifierBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"eventId=" + this.eventId + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
