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
import fpml.confirmation.OldTradeModel;
import fpml.confirmation.OldTradeModel.OldTradeModelBuilder;
import fpml.confirmation.OldTradeModel.OldTradeModelBuilderImpl;
import fpml.confirmation.OldTradeModel.OldTradeModelImpl;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import fpml.confirmation.meta.OldTradeModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OldTradeModel", builder=OldTradeModel.OldTradeModelBuilderImpl.class, version="${project.version}")
public interface OldTradeModel extends RosettaModelObject {

	OldTradeModelMeta metaData = new OldTradeModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates a reference to the original trade between the transferor and the remaining party.
	 */
	List<? extends PartyTradeIdentifier> getOldTradeIdentifier();
	/**
	 * Indicates the original trade between the transferor and the remaining party.
	 */
	Trade getOldTrade();

	/*********************** Build Methods  ***********************/
	OldTradeModel build();
	
	OldTradeModel.OldTradeModelBuilder toBuilder();
	
	static OldTradeModel.OldTradeModelBuilder builder() {
		return new OldTradeModel.OldTradeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OldTradeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OldTradeModel> getType() {
		return OldTradeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.class, getOldTradeIdentifier());
		processRosetta(path.newSubPath("oldTrade"), processor, Trade.class, getOldTrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OldTradeModelBuilder extends OldTradeModel, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getOldTradeIdentifier();
		Trade.TradeBuilder getOrCreateOldTrade();
		Trade.TradeBuilder getOldTrade();
		OldTradeModel.OldTradeModelBuilder addOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier0);
		OldTradeModel.OldTradeModelBuilder addOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier1, int _idx);
		OldTradeModel.OldTradeModelBuilder addOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifier2);
		OldTradeModel.OldTradeModelBuilder setOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifier3);
		OldTradeModel.OldTradeModelBuilder setOldTrade(Trade oldTrade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getOldTradeIdentifier());
			processRosetta(path.newSubPath("oldTrade"), processor, Trade.TradeBuilder.class, getOldTrade());
		}
		

		OldTradeModel.OldTradeModelBuilder prune();
	}

	/*********************** Immutable Implementation of OldTradeModel  ***********************/
	class OldTradeModelImpl implements OldTradeModel {
		private final List<? extends PartyTradeIdentifier> oldTradeIdentifier;
		private final Trade oldTrade;
		
		protected OldTradeModelImpl(OldTradeModel.OldTradeModelBuilder builder) {
			this.oldTradeIdentifier = ofNullable(builder.getOldTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.oldTrade = ofNullable(builder.getOldTrade()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		public Trade getOldTrade() {
			return oldTrade;
		}
		
		@Override
		public OldTradeModel build() {
			return this;
		}
		
		@Override
		public OldTradeModel.OldTradeModelBuilder toBuilder() {
			OldTradeModel.OldTradeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OldTradeModel.OldTradeModelBuilder builder) {
			ofNullable(getOldTradeIdentifier()).ifPresent(builder::setOldTradeIdentifier);
			ofNullable(getOldTrade()).ifPresent(builder::setOldTrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OldTradeModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OldTradeModel {" +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade +
			'}';
		}
	}

	/*********************** Builder Implementation of OldTradeModel  ***********************/
	class OldTradeModelBuilderImpl implements OldTradeModel.OldTradeModelBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> oldTradeIdentifier = new ArrayList<>();
		protected Trade.TradeBuilder oldTrade;
	
		public OldTradeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier(int _index) {
		
			if (oldTradeIdentifier==null) {
				this.oldTradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(oldTradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newOldTradeIdentifier = PartyTradeIdentifier.builder();
						return newOldTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		public Trade.TradeBuilder getOldTrade() {
			return oldTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOldTrade() {
			Trade.TradeBuilder result;
			if (oldTrade!=null) {
				result = oldTrade;
			}
			else {
				result = oldTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		public OldTradeModel.OldTradeModelBuilder addOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier) {
			if (oldTradeIdentifier!=null) this.oldTradeIdentifier.add(oldTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OldTradeModel.OldTradeModelBuilder addOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier, int _idx) {
			getIndex(this.oldTradeIdentifier, _idx, () -> oldTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OldTradeModel.OldTradeModelBuilder addOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifiers) {
			if (oldTradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : oldTradeIdentifiers) {
					this.oldTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OldTradeModel.OldTradeModelBuilder setOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifiers) {
			if (oldTradeIdentifiers == null)  {
				this.oldTradeIdentifier = new ArrayList<>();
			}
			else {
				this.oldTradeIdentifier = oldTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		public OldTradeModel.OldTradeModelBuilder setOldTrade(Trade oldTrade) {
			this.oldTrade = oldTrade==null?null:oldTrade.toBuilder();
			return this;
		}
		
		@Override
		public OldTradeModel build() {
			return new OldTradeModel.OldTradeModelImpl(this);
		}
		
		@Override
		public OldTradeModel.OldTradeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OldTradeModel.OldTradeModelBuilder prune() {
			oldTradeIdentifier = oldTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (oldTrade!=null && !oldTrade.prune().hasData()) oldTrade = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOldTradeIdentifier()!=null && getOldTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOldTrade()!=null && getOldTrade().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OldTradeModel.OldTradeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OldTradeModel.OldTradeModelBuilder o = (OldTradeModel.OldTradeModelBuilder) other;
			
			merger.mergeRosetta(getOldTradeIdentifier(), o.getOldTradeIdentifier(), this::getOrCreateOldTradeIdentifier);
			merger.mergeRosetta(getOldTrade(), o.getOldTrade(), this::setOldTrade);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OldTradeModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OldTradeModelBuilder {" +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade +
			'}';
		}
	}
}
