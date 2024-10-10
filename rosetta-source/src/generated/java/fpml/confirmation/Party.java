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
import fpml.confirmation.Party;
import fpml.confirmation.Party.PartyBuilder;
import fpml.confirmation.Party.PartyBuilderImpl;
import fpml.confirmation.Party.PartyImpl;
import fpml.confirmation.PartyModel;
import fpml.confirmation.PartySequence;
import fpml.confirmation.meta.PartyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
 * @version ${project.version}
 */
@RosettaDataType(value="Party", builder=Party.PartyBuilderImpl.class, version="${project.version}")
public interface Party extends RosettaModelObject {

	PartyMeta metaData = new PartyMeta();

	/*********************** Getter Methods  ***********************/
	PartyModel getPartyModel();
	PartySequence getPartySequence();
	/**
	 * The id uniquely identifying the Party within the document.
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	Party build();
	
	Party.PartyBuilder toBuilder();
	
	static Party.PartyBuilder builder() {
		return new Party.PartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Party> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Party> getType() {
		return Party.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyModel"), processor, PartyModel.class, getPartyModel());
		processRosetta(path.newSubPath("partySequence"), processor, PartySequence.class, getPartySequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyBuilder extends Party, RosettaModelObjectBuilder {
		PartyModel.PartyModelBuilder getOrCreatePartyModel();
		PartyModel.PartyModelBuilder getPartyModel();
		PartySequence.PartySequenceBuilder getOrCreatePartySequence();
		PartySequence.PartySequenceBuilder getPartySequence();
		Party.PartyBuilder setPartyModel(PartyModel partyModel);
		Party.PartyBuilder setPartySequence(PartySequence partySequence);
		Party.PartyBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyModel"), processor, PartyModel.PartyModelBuilder.class, getPartyModel());
			processRosetta(path.newSubPath("partySequence"), processor, PartySequence.PartySequenceBuilder.class, getPartySequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Party.PartyBuilder prune();
	}

	/*********************** Immutable Implementation of Party  ***********************/
	class PartyImpl implements Party {
		private final PartyModel partyModel;
		private final PartySequence partySequence;
		private final String id;
		
		protected PartyImpl(Party.PartyBuilder builder) {
			this.partyModel = ofNullable(builder.getPartyModel()).map(f->f.build()).orElse(null);
			this.partySequence = ofNullable(builder.getPartySequence()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyModel")
		public PartyModel getPartyModel() {
			return partyModel;
		}
		
		@Override
		@RosettaAttribute("partySequence")
		public PartySequence getPartySequence() {
			return partySequence;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Party build() {
			return this;
		}
		
		@Override
		public Party.PartyBuilder toBuilder() {
			Party.PartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Party.PartyBuilder builder) {
			ofNullable(getPartyModel()).ifPresent(builder::setPartyModel);
			ofNullable(getPartySequence()).ifPresent(builder::setPartySequence);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(partyModel, _that.getPartyModel())) return false;
			if (!Objects.equals(partySequence, _that.getPartySequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyModel != null ? partyModel.hashCode() : 0);
			_result = 31 * _result + (partySequence != null ? partySequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Party {" +
				"partyModel=" + this.partyModel + ", " +
				"partySequence=" + this.partySequence + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Party  ***********************/
	class PartyBuilderImpl implements Party.PartyBuilder {
	
		protected PartyModel.PartyModelBuilder partyModel;
		protected PartySequence.PartySequenceBuilder partySequence;
		protected String id;
	
		public PartyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyModel")
		public PartyModel.PartyModelBuilder getPartyModel() {
			return partyModel;
		}
		
		@Override
		public PartyModel.PartyModelBuilder getOrCreatePartyModel() {
			PartyModel.PartyModelBuilder result;
			if (partyModel!=null) {
				result = partyModel;
			}
			else {
				result = partyModel = PartyModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partySequence")
		public PartySequence.PartySequenceBuilder getPartySequence() {
			return partySequence;
		}
		
		@Override
		public PartySequence.PartySequenceBuilder getOrCreatePartySequence() {
			PartySequence.PartySequenceBuilder result;
			if (partySequence!=null) {
				result = partySequence;
			}
			else {
				result = partySequence = PartySequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyModel")
		public Party.PartyBuilder setPartyModel(PartyModel partyModel) {
			this.partyModel = partyModel==null?null:partyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partySequence")
		public Party.PartyBuilder setPartySequence(PartySequence partySequence) {
			this.partySequence = partySequence==null?null:partySequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Party.PartyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Party build() {
			return new Party.PartyImpl(this);
		}
		
		@Override
		public Party.PartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Party.PartyBuilder prune() {
			if (partyModel!=null && !partyModel.prune().hasData()) partyModel = null;
			if (partySequence!=null && !partySequence.prune().hasData()) partySequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyModel()!=null && getPartyModel().hasData()) return true;
			if (getPartySequence()!=null && getPartySequence().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Party.PartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Party.PartyBuilder o = (Party.PartyBuilder) other;
			
			merger.mergeRosetta(getPartyModel(), o.getPartyModel(), this::setPartyModel);
			merger.mergeRosetta(getPartySequence(), o.getPartySequence(), this::setPartySequence);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(partyModel, _that.getPartyModel())) return false;
			if (!Objects.equals(partySequence, _that.getPartySequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyModel != null ? partyModel.hashCode() : 0);
			_result = 31 * _result + (partySequence != null ? partySequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyBuilder {" +
				"partyModel=" + this.partyModel + ", " +
				"partySequence=" + this.partySequence + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
