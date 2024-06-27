package fpml.confirmation.v5.staticgroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
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
@JsonDeserialize(builder = Party.PartyBuilderImpl.class)
@RosettaDataType(value="Party", builder=Party.PartyBuilderImpl.class, version="0.0.0")
public interface Party extends RosettaModelObject {
	/*********************** Getter Methods  ***********************/
	PartyModel getPartyModel();

	/*********************** Build Methods  ***********************/
	Party build();

	@Override
	default RosettaModelObjectBuilder toBuilder() {
		return null;
	}

	static PartyBuilder builder() {
		return new PartyBuilderImpl();
	}

	@Override
	default RosettaMetaData<? extends RosettaModelObject> metaData() {
		return null;
	}

	@Override
	default Class<? extends RosettaModelObject> getType() {
		return null;
	}

	@Override
	default void process(RosettaPath rosettaPath, Processor processor) {

	}

	/*********************** Builder Interface  ***********************/
	interface PartyBuilder extends Party, RosettaModelObjectBuilder {
		PartyBuilder setPartyModel(PartyModel partyModel);
	}

	/*********************** Immutable Implementation of Party  ***********************/
	class PartyImpl implements Party {
		private final PartyModel partyModel;

		protected PartyImpl(PartyBuilder builder) {
			this.partyModel = ofNullable(builder.getPartyModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@JsonUnwrapped
		@RosettaAttribute("partyModel")
		public PartyModel getPartyModel() {
			return partyModel;
		}
		
		@Override
		public Party build() {
			return this;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			PartyImpl party = (PartyImpl) o;
			return Objects.equals(partyModel, party.partyModel);
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(partyModel);
		}

		@Override
		public String toString() {
			return "PartyImpl{" +
					"partyModel=" + partyModel +
					'}';
		}
	}

	/*********************** Builder Implementation of Party  ***********************/
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
	class PartyBuilderImpl implements PartyBuilder {
	
		protected PartyModel.PartyModelBuilder partyModel;

		public PartyBuilderImpl() {
		}
	
		@Override
		@JsonUnwrapped
		@RosettaAttribute("partyModel")
		public PartyBuilder setPartyModel(PartyModel partyModel) {
			this.partyModel = partyModel==null?null:partyModel.toBuilder();
			return this;
		}

		@Override
		public PartyModel.PartyModelBuilder getPartyModel() {
			return this.partyModel;
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
		public void process(RosettaPath rosettaPath, BuilderProcessor builderProcessor) {

		}

		@Override
		public boolean hasData() {
			if (getPartyModel()!=null && getPartyModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			return null;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			PartyBuilderImpl that = (PartyBuilderImpl) o;
			return Objects.equals(partyModel, that.partyModel);
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(partyModel);
		}

		@Override
		public String toString() {
			return "PartyBuilderImpl{" +
					"partyModel=" + partyModel +
					'}';
		}
	}
}
