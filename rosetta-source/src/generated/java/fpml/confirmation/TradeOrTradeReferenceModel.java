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
import fpml.confirmation.PartyTradeIdentifiers;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeOrTradeReferenceModel;
import fpml.confirmation.TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder;
import fpml.confirmation.TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilderImpl;
import fpml.confirmation.TradeOrTradeReferenceModel.TradeOrTradeReferenceModelImpl;
import fpml.confirmation.meta.TradeOrTradeReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between identification and representation of trade execution.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeOrTradeReferenceModel", builder=TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilderImpl.class, version="${project.version}")
public interface TradeOrTradeReferenceModel extends RosettaModelObject {

	TradeOrTradeReferenceModelMeta metaData = new TradeOrTradeReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An element that allows the full details of the trade to be used as a mechanism for identifying the trade for which the post-trade event pertains
	 */
	Trade getTrade();
	/**
	 * A container since an individual trade can be referenced by two or more different partyTradeIdentifier elements - each allocated by a different party.
	 */
	PartyTradeIdentifiers getTradeReference();

	/*********************** Build Methods  ***********************/
	TradeOrTradeReferenceModel build();
	
	TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder toBuilder();
	
	static TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder builder() {
		return new TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeOrTradeReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeOrTradeReferenceModel> getType() {
		return TradeOrTradeReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradeReference"), processor, PartyTradeIdentifiers.class, getTradeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeOrTradeReferenceModelBuilder extends TradeOrTradeReferenceModel, RosettaModelObjectBuilder {
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getOrCreateTradeReference();
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getTradeReference();
		TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder setTrade(Trade trade);
		TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder setTradeReference(PartyTradeIdentifiers tradeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradeReference"), processor, PartyTradeIdentifiers.PartyTradeIdentifiersBuilder.class, getTradeReference());
		}
		

		TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeOrTradeReferenceModel  ***********************/
	class TradeOrTradeReferenceModelImpl implements TradeOrTradeReferenceModel {
		private final Trade trade;
		private final PartyTradeIdentifiers tradeReference;
		
		protected TradeOrTradeReferenceModelImpl(TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder builder) {
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradeReference = ofNullable(builder.getTradeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		public PartyTradeIdentifiers getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public TradeOrTradeReferenceModel build() {
			return this;
		}
		
		@Override
		public TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder toBuilder() {
			TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder builder) {
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeOrTradeReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeOrTradeReferenceModel {" +
				"trade=" + this.trade + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeOrTradeReferenceModel  ***********************/
	class TradeOrTradeReferenceModelBuilderImpl implements TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder {
	
		protected Trade.TradeBuilder trade;
		protected PartyTradeIdentifiers.PartyTradeIdentifiersBuilder tradeReference;
	
		public TradeOrTradeReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getOrCreateTradeReference() {
			PartyTradeIdentifiers.PartyTradeIdentifiersBuilder result;
			if (tradeReference!=null) {
				result = tradeReference;
			}
			else {
				result = tradeReference = PartyTradeIdentifiers.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		public TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReference")
		public TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder setTradeReference(PartyTradeIdentifiers tradeReference) {
			this.tradeReference = tradeReference==null?null:tradeReference.toBuilder();
			return this;
		}
		
		@Override
		public TradeOrTradeReferenceModel build() {
			return new TradeOrTradeReferenceModel.TradeOrTradeReferenceModelImpl(this);
		}
		
		@Override
		public TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder prune() {
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (tradeReference!=null && !tradeReference.prune().hasData()) tradeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradeReference()!=null && getTradeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder o = (TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder) other;
			
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::setTradeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeOrTradeReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeOrTradeReferenceModelBuilder {" +
				"trade=" + this.trade + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}
}
