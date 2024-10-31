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
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.TradeIdentifierSequence.TradeIdentifierSequenceBuilder;
import fpml.confirmation.TradeIdentifierSequence.TradeIdentifierSequenceBuilderImpl;
import fpml.confirmation.TradeIdentifierSequence.TradeIdentifierSequenceImpl;
import fpml.confirmation.TradeIdentifierSequenceChoice;
import fpml.confirmation.meta.TradeIdentifierSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeIdentifierSequence", builder=TradeIdentifierSequence.TradeIdentifierSequenceBuilderImpl.class, version="${project.version}")
public interface TradeIdentifierSequence extends RosettaModelObject {

	TradeIdentifierSequenceMeta metaData = new TradeIdentifierSequenceMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	List<? extends TradeIdentifierSequenceChoice> getTradeIdentifierSequenceChoice();

	/*********************** Build Methods  ***********************/
	TradeIdentifierSequence build();
	
	TradeIdentifierSequence.TradeIdentifierSequenceBuilder toBuilder();
	
	static TradeIdentifierSequence.TradeIdentifierSequenceBuilder builder() {
		return new TradeIdentifierSequence.TradeIdentifierSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeIdentifierSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeIdentifierSequence> getType() {
		return TradeIdentifierSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("tradeIdentifierSequenceChoice"), processor, TradeIdentifierSequenceChoice.class, getTradeIdentifierSequenceChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdentifierSequenceBuilder extends TradeIdentifierSequence, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder getOrCreateTradeIdentifierSequenceChoice(int _index);
		List<? extends TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder> getTradeIdentifierSequenceChoice();
		TradeIdentifierSequence.TradeIdentifierSequenceBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		TradeIdentifierSequence.TradeIdentifierSequenceBuilder addTradeIdentifierSequenceChoice(TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice0);
		TradeIdentifierSequence.TradeIdentifierSequenceBuilder addTradeIdentifierSequenceChoice(TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice1, int _idx);
		TradeIdentifierSequence.TradeIdentifierSequenceBuilder addTradeIdentifierSequenceChoice(List<? extends TradeIdentifierSequenceChoice> tradeIdentifierSequenceChoice2);
		TradeIdentifierSequence.TradeIdentifierSequenceBuilder setTradeIdentifierSequenceChoice(List<? extends TradeIdentifierSequenceChoice> tradeIdentifierSequenceChoice3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("tradeIdentifierSequenceChoice"), processor, TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder.class, getTradeIdentifierSequenceChoice());
		}
		

		TradeIdentifierSequence.TradeIdentifierSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeIdentifierSequence  ***********************/
	class TradeIdentifierSequenceImpl implements TradeIdentifierSequence {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final List<? extends TradeIdentifierSequenceChoice> tradeIdentifierSequenceChoice;
		
		protected TradeIdentifierSequenceImpl(TradeIdentifierSequence.TradeIdentifierSequenceBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.tradeIdentifierSequenceChoice = ofNullable(builder.getTradeIdentifierSequenceChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifierSequenceChoice")
		public List<? extends TradeIdentifierSequenceChoice> getTradeIdentifierSequenceChoice() {
			return tradeIdentifierSequenceChoice;
		}
		
		@Override
		public TradeIdentifierSequence build() {
			return this;
		}
		
		@Override
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder toBuilder() {
			TradeIdentifierSequence.TradeIdentifierSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeIdentifierSequence.TradeIdentifierSequenceBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getTradeIdentifierSequenceChoice()).ifPresent(builder::setTradeIdentifierSequenceChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifierSequence _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(tradeIdentifierSequenceChoice, _that.getTradeIdentifierSequenceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifierSequenceChoice != null ? tradeIdentifierSequenceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierSequence {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"tradeIdentifierSequenceChoice=" + this.tradeIdentifierSequenceChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeIdentifierSequence  ***********************/
	class TradeIdentifierSequenceBuilderImpl implements TradeIdentifierSequence.TradeIdentifierSequenceBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected List<TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder> tradeIdentifierSequenceChoice = new ArrayList<>();
	
		public TradeIdentifierSequenceBuilderImpl() {
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
		@RosettaAttribute("tradeIdentifierSequenceChoice")
		public List<? extends TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder> getTradeIdentifierSequenceChoice() {
			return tradeIdentifierSequenceChoice;
		}
		
		@Override
		public TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder getOrCreateTradeIdentifierSequenceChoice(int _index) {
		
			if (tradeIdentifierSequenceChoice==null) {
				this.tradeIdentifierSequenceChoice = new ArrayList<>();
			}
			TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder result;
			return getIndex(tradeIdentifierSequenceChoice, _index, () -> {
						TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder newTradeIdentifierSequenceChoice = TradeIdentifierSequenceChoice.builder();
						return newTradeIdentifierSequenceChoice;
					});
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifierSequenceChoice")
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder addTradeIdentifierSequenceChoice(TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice) {
			if (tradeIdentifierSequenceChoice!=null) this.tradeIdentifierSequenceChoice.add(tradeIdentifierSequenceChoice.toBuilder());
			return this;
		}
		
		@Override
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder addTradeIdentifierSequenceChoice(TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice, int _idx) {
			getIndex(this.tradeIdentifierSequenceChoice, _idx, () -> tradeIdentifierSequenceChoice.toBuilder());
			return this;
		}
		@Override 
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder addTradeIdentifierSequenceChoice(List<? extends TradeIdentifierSequenceChoice> tradeIdentifierSequenceChoices) {
			if (tradeIdentifierSequenceChoices != null) {
				for (TradeIdentifierSequenceChoice toAdd : tradeIdentifierSequenceChoices) {
					this.tradeIdentifierSequenceChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder setTradeIdentifierSequenceChoice(List<? extends TradeIdentifierSequenceChoice> tradeIdentifierSequenceChoices) {
			if (tradeIdentifierSequenceChoices == null)  {
				this.tradeIdentifierSequenceChoice = new ArrayList<>();
			}
			else {
				this.tradeIdentifierSequenceChoice = tradeIdentifierSequenceChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TradeIdentifierSequence build() {
			return new TradeIdentifierSequence.TradeIdentifierSequenceImpl(this);
		}
		
		@Override
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			tradeIdentifierSequenceChoice = tradeIdentifierSequenceChoice.stream().filter(b->b!=null).<TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getTradeIdentifierSequenceChoice()!=null && getTradeIdentifierSequenceChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeIdentifierSequence.TradeIdentifierSequenceBuilder o = (TradeIdentifierSequence.TradeIdentifierSequenceBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getTradeIdentifierSequenceChoice(), o.getTradeIdentifierSequenceChoice(), this::getOrCreateTradeIdentifierSequenceChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifierSequence _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(tradeIdentifierSequenceChoice, _that.getTradeIdentifierSequenceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifierSequenceChoice != null ? tradeIdentifierSequenceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierSequenceBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"tradeIdentifierSequenceChoice=" + this.tradeIdentifierSequenceChoice +
			'}';
		}
	}
}
