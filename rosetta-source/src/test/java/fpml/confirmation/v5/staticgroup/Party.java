package fpml.confirmation.v5.staticgroup;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.v5.staticgroup.meta.PartyMeta;

import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
 * @version 0.0.0
 */
@RosettaDataType(value="Party", builder=Party.PartyBuilderImpl.class, version="0.0.0")
public interface Party extends RosettaModelObject {

	PartyMeta metaData = new PartyMeta();

	/*********************** Getter Methods  ***********************/
	PartyModel getPartyModel();
	/**
	 * The id uniquely identifying the Party within the document.
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	Party build();
	
	PartyBuilder toBuilder();
	
	static PartyBuilder builder() {
		return new PartyBuilderImpl();
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
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyBuilder extends Party, RosettaModelObjectBuilder {
		PartyModel.PartyModelBuilder getOrCreatePartyModel();
		PartyModel.PartyModelBuilder getPartyModel();
		PartyBuilder setPartyModel(PartyModel partyModel);
		PartyBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyModel"), processor, PartyModel.PartyModelBuilder.class, getPartyModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PartyBuilder prune();
	}

	/*********************** Immutable Implementation of Party  ***********************/
	class PartyImpl implements Party {
		private final PartyModel partyModel;
		private final String id;
		
		protected PartyImpl(PartyBuilder builder) {
			this.partyModel = ofNullable(builder.getPartyModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyModel")
		public PartyModel getPartyModel() {
			return partyModel;
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
		public PartyBuilder toBuilder() {
			PartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyBuilder builder) {
			ofNullable(getPartyModel()).ifPresent(builder::setPartyModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(partyModel, _that.getPartyModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyModel != null ? partyModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Party {" +
				"partyModel=" + this.partyModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Party  ***********************/
	class PartyBuilderImpl implements PartyBuilder {
	
		protected PartyModel.PartyModelBuilder partyModel;
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
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyModel")
		public PartyBuilder setPartyModel(PartyModel partyModel) {
			this.partyModel = partyModel==null?null:partyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PartyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Party build() {
			return new PartyImpl(this);
		}
		
		@Override
		public PartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyBuilder prune() {
			if (partyModel!=null && !partyModel.prune().hasData()) partyModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyModel()!=null && getPartyModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyBuilder o = (PartyBuilder) other;
			
			merger.mergeRosetta(getPartyModel(), o.getPartyModel(), this::setPartyModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(partyModel, _that.getPartyModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyModel != null ? partyModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyBuilder {" +
				"partyModel=" + this.partyModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
