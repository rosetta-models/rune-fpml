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
import fpml.confirmation.NewTradeModel;
import fpml.confirmation.NewTradeModel.NewTradeModelBuilder;
import fpml.confirmation.NewTradeModel.NewTradeModelBuilderImpl;
import fpml.confirmation.NewTradeModel.NewTradeModelImpl;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import fpml.confirmation.meta.NewTradeModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NewTradeModel", builder=NewTradeModel.NewTradeModelBuilderImpl.class, version="${project.version}")
public interface NewTradeModel extends RosettaModelObject {

	NewTradeModelMeta metaData = new NewTradeModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates a reference to the new trade between the transferee and the remaining party.
	 */
	List<? extends PartyTradeIdentifier> getNewTradeIdentifier();
	/**
	 * Indicates the new trade between the transferee and the remaining party.
	 */
	Trade getNewTrade();

	/*********************** Build Methods  ***********************/
	NewTradeModel build();
	
	NewTradeModel.NewTradeModelBuilder toBuilder();
	
	static NewTradeModel.NewTradeModelBuilder builder() {
		return new NewTradeModel.NewTradeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NewTradeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NewTradeModel> getType() {
		return NewTradeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("newTradeIdentifier"), processor, PartyTradeIdentifier.class, getNewTradeIdentifier());
		processRosetta(path.newSubPath("newTrade"), processor, Trade.class, getNewTrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NewTradeModelBuilder extends NewTradeModel, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateNewTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getNewTradeIdentifier();
		Trade.TradeBuilder getOrCreateNewTrade();
		Trade.TradeBuilder getNewTrade();
		NewTradeModel.NewTradeModelBuilder addNewTradeIdentifier(PartyTradeIdentifier newTradeIdentifier0);
		NewTradeModel.NewTradeModelBuilder addNewTradeIdentifier(PartyTradeIdentifier newTradeIdentifier1, int _idx);
		NewTradeModel.NewTradeModelBuilder addNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifier2);
		NewTradeModel.NewTradeModelBuilder setNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifier3);
		NewTradeModel.NewTradeModelBuilder setNewTrade(Trade newTrade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("newTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getNewTradeIdentifier());
			processRosetta(path.newSubPath("newTrade"), processor, Trade.TradeBuilder.class, getNewTrade());
		}
		

		NewTradeModel.NewTradeModelBuilder prune();
	}

	/*********************** Immutable Implementation of NewTradeModel  ***********************/
	class NewTradeModelImpl implements NewTradeModel {
		private final List<? extends PartyTradeIdentifier> newTradeIdentifier;
		private final Trade newTrade;
		
		protected NewTradeModelImpl(NewTradeModel.NewTradeModelBuilder builder) {
			this.newTradeIdentifier = ofNullable(builder.getNewTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.newTrade = ofNullable(builder.getNewTrade()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("newTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getNewTradeIdentifier() {
			return newTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("newTrade")
		public Trade getNewTrade() {
			return newTrade;
		}
		
		@Override
		public NewTradeModel build() {
			return this;
		}
		
		@Override
		public NewTradeModel.NewTradeModelBuilder toBuilder() {
			NewTradeModel.NewTradeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NewTradeModel.NewTradeModelBuilder builder) {
			ofNullable(getNewTradeIdentifier()).ifPresent(builder::setNewTradeIdentifier);
			ofNullable(getNewTrade()).ifPresent(builder::setNewTrade);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NewTradeModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(newTradeIdentifier, _that.getNewTradeIdentifier())) return false;
			if (!Objects.equals(newTrade, _that.getNewTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (newTradeIdentifier != null ? newTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (newTrade != null ? newTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NewTradeModel {" +
				"newTradeIdentifier=" + this.newTradeIdentifier + ", " +
				"newTrade=" + this.newTrade +
			'}';
		}
	}

	/*********************** Builder Implementation of NewTradeModel  ***********************/
	class NewTradeModelBuilderImpl implements NewTradeModel.NewTradeModelBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> newTradeIdentifier = new ArrayList<>();
		protected Trade.TradeBuilder newTrade;
	
		public NewTradeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("newTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getNewTradeIdentifier() {
			return newTradeIdentifier;
		}
		
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateNewTradeIdentifier(int _index) {
		
			if (newTradeIdentifier==null) {
				this.newTradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(newTradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newNewTradeIdentifier = PartyTradeIdentifier.builder();
						return newNewTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("newTrade")
		public Trade.TradeBuilder getNewTrade() {
			return newTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateNewTrade() {
			Trade.TradeBuilder result;
			if (newTrade!=null) {
				result = newTrade;
			}
			else {
				result = newTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		public NewTradeModel.NewTradeModelBuilder addNewTradeIdentifier(PartyTradeIdentifier newTradeIdentifier) {
			if (newTradeIdentifier!=null) this.newTradeIdentifier.add(newTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public NewTradeModel.NewTradeModelBuilder addNewTradeIdentifier(PartyTradeIdentifier newTradeIdentifier, int _idx) {
			getIndex(this.newTradeIdentifier, _idx, () -> newTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public NewTradeModel.NewTradeModelBuilder addNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifiers) {
			if (newTradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : newTradeIdentifiers) {
					this.newTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("newTradeIdentifier")
		public NewTradeModel.NewTradeModelBuilder setNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifiers) {
			if (newTradeIdentifiers == null)  {
				this.newTradeIdentifier = new ArrayList<>();
			}
			else {
				this.newTradeIdentifier = newTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("newTrade")
		public NewTradeModel.NewTradeModelBuilder setNewTrade(Trade newTrade) {
			this.newTrade = newTrade==null?null:newTrade.toBuilder();
			return this;
		}
		
		@Override
		public NewTradeModel build() {
			return new NewTradeModel.NewTradeModelImpl(this);
		}
		
		@Override
		public NewTradeModel.NewTradeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NewTradeModel.NewTradeModelBuilder prune() {
			newTradeIdentifier = newTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (newTrade!=null && !newTrade.prune().hasData()) newTrade = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNewTradeIdentifier()!=null && getNewTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNewTrade()!=null && getNewTrade().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NewTradeModel.NewTradeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NewTradeModel.NewTradeModelBuilder o = (NewTradeModel.NewTradeModelBuilder) other;
			
			merger.mergeRosetta(getNewTradeIdentifier(), o.getNewTradeIdentifier(), this::getOrCreateNewTradeIdentifier);
			merger.mergeRosetta(getNewTrade(), o.getNewTrade(), this::setNewTrade);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NewTradeModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(newTradeIdentifier, _that.getNewTradeIdentifier())) return false;
			if (!Objects.equals(newTrade, _that.getNewTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (newTradeIdentifier != null ? newTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (newTrade != null ? newTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NewTradeModelBuilder {" +
				"newTradeIdentifier=" + this.newTradeIdentifier + ", " +
				"newTrade=" + this.newTrade +
			'}';
		}
	}
}
