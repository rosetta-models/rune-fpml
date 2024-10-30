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
import fpml.confirmation.DataDocument;
import fpml.confirmation.DataDocument.DataDocumentBuilder;
import fpml.confirmation.DataDocument.DataDocumentBuilderImpl;
import fpml.confirmation.DataDocument.DataDocumentImpl;
import fpml.confirmation.Market;
import fpml.confirmation.OnBehalfOf;
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.Portfolio;
import fpml.confirmation.Trade;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.ValuationDocument;
import fpml.confirmation.ValuationDocument.ValuationDocumentBuilder;
import fpml.confirmation.ValuationDocument.ValuationDocumentBuilderImpl;
import fpml.confirmation.ValuationDocument.ValuationDocumentImpl;
import fpml.confirmation.ValuationSet;
import fpml.confirmation.meta.ValuationDocumentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A document that includes trade and/or valuation (pricing and risk) data without expressing any processing intention. A type defining a content model that includes valuation (pricing and risk) data without expressing any processing intention.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ValuationDocument", builder=ValuationDocument.ValuationDocumentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ValuationDocument extends DataDocument {

	ValuationDocumentMeta metaData = new ValuationDocumentMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends Market> getMarket();
	List<? extends ValuationSet> getValuationSet();

	/*********************** Build Methods  ***********************/
	ValuationDocument build();
	
	ValuationDocument.ValuationDocumentBuilder toBuilder();
	
	static ValuationDocument.ValuationDocumentBuilder builder() {
		return new ValuationDocument.ValuationDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationDocument> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationDocument> getType() {
		return ValuationDocument.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("portfolio"), processor, Portfolio.class, getPortfolio());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
		processRosetta(path.newSubPath("market"), processor, Market.class, getMarket());
		processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.class, getValuationSet());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationDocumentBuilder extends ValuationDocument, DataDocument.DataDocumentBuilder {
		Market.MarketBuilder getOrCreateMarket(int _index);
		List<? extends Market.MarketBuilder> getMarket();
		ValuationSet.ValuationSetBuilder getOrCreateValuationSet(int _index);
		List<? extends ValuationSet.ValuationSetBuilder> getValuationSet();
		ValuationDocument.ValuationDocumentBuilder setExpectedBuild(Integer expectedBuild);
		ValuationDocument.ValuationDocumentBuilder setActualBuild(Integer actualBuild);
		ValuationDocument.ValuationDocumentBuilder setValidationModel(ValidationModel validationModel);
		ValuationDocument.ValuationDocumentBuilder setOnBehalfOf(OnBehalfOf onBehalfOf);
		ValuationDocument.ValuationDocumentBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		ValuationDocument.ValuationDocumentBuilder addTrade(Trade trade0);
		ValuationDocument.ValuationDocumentBuilder addTrade(Trade trade1, int _idx);
		ValuationDocument.ValuationDocumentBuilder addTrade(List<? extends Trade> trade2);
		ValuationDocument.ValuationDocumentBuilder setTrade(List<? extends Trade> trade3);
		ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio portfolio0);
		ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio portfolio1, int _idx);
		ValuationDocument.ValuationDocumentBuilder addPortfolio(List<? extends Portfolio> portfolio2);
		ValuationDocument.ValuationDocumentBuilder setPortfolio(List<? extends Portfolio> portfolio3);
		ValuationDocument.ValuationDocumentBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);
		ValuationDocument.ValuationDocumentBuilder addMarket(Market market0);
		ValuationDocument.ValuationDocumentBuilder addMarket(Market market1, int _idx);
		ValuationDocument.ValuationDocumentBuilder addMarket(List<? extends Market> market2);
		ValuationDocument.ValuationDocumentBuilder setMarket(List<? extends Market> market3);
		ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet valuationSet0);
		ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet valuationSet1, int _idx);
		ValuationDocument.ValuationDocumentBuilder addValuationSet(List<? extends ValuationSet> valuationSet2);
		ValuationDocument.ValuationDocumentBuilder setValuationSet(List<? extends ValuationSet> valuationSet3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("portfolio"), processor, Portfolio.PortfolioBuilder.class, getPortfolio());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
			processRosetta(path.newSubPath("market"), processor, Market.MarketBuilder.class, getMarket());
			processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.ValuationSetBuilder.class, getValuationSet());
		}
		

		ValuationDocument.ValuationDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationDocument  ***********************/
	class ValuationDocumentImpl extends DataDocument.DataDocumentImpl implements ValuationDocument {
		private final List<? extends Market> market;
		private final List<? extends ValuationSet> valuationSet;
		
		protected ValuationDocumentImpl(ValuationDocument.ValuationDocumentBuilder builder) {
			super(builder);
			this.market = ofNullable(builder.getMarket()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationSet = ofNullable(builder.getValuationSet()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("market")
		public List<? extends Market> getMarket() {
			return market;
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		public List<? extends ValuationSet> getValuationSet() {
			return valuationSet;
		}
		
		@Override
		public ValuationDocument build() {
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder toBuilder() {
			ValuationDocument.ValuationDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationDocument.ValuationDocumentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMarket()).ifPresent(builder::setMarket);
			ofNullable(getValuationSet()).ifPresent(builder::setValuationSet);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(market, _that.getMarket())) return false;
			if (!ListEquals.listEquals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDocument {" +
				"market=" + this.market + ", " +
				"valuationSet=" + this.valuationSet +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationDocument  ***********************/
	class ValuationDocumentBuilderImpl extends DataDocument.DataDocumentBuilderImpl  implements ValuationDocument.ValuationDocumentBuilder {
	
		protected List<Market.MarketBuilder> market = new ArrayList<>();
		protected List<ValuationSet.ValuationSetBuilder> valuationSet = new ArrayList<>();
	
		public ValuationDocumentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("market")
		public List<? extends Market.MarketBuilder> getMarket() {
			return market;
		}
		
		@Override
		public Market.MarketBuilder getOrCreateMarket(int _index) {
		
			if (market==null) {
				this.market = new ArrayList<>();
			}
			Market.MarketBuilder result;
			return getIndex(market, _index, () -> {
						Market.MarketBuilder newMarket = Market.builder();
						return newMarket;
					});
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		public List<? extends ValuationSet.ValuationSetBuilder> getValuationSet() {
			return valuationSet;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder getOrCreateValuationSet(int _index) {
		
			if (valuationSet==null) {
				this.valuationSet = new ArrayList<>();
			}
			ValuationSet.ValuationSetBuilder result;
			return getIndex(valuationSet, _index, () -> {
						ValuationSet.ValuationSetBuilder newValuationSet = ValuationSet.builder();
						return newValuationSet;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public ValuationDocument.ValuationDocumentBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ValuationDocument.ValuationDocumentBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ValuationDocument.ValuationDocumentBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOf")
		public ValuationDocument.ValuationDocumentBuilder setOnBehalfOf(OnBehalfOf onBehalfOf) {
			this.onBehalfOf = onBehalfOf==null?null:onBehalfOf.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originatingEvent")
		public ValuationDocument.ValuationDocumentBuilder setOriginatingEvent(OriginatingEvent originatingEvent) {
			this.originatingEvent = originatingEvent==null?null:originatingEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public ValuationDocument.ValuationDocumentBuilder addTrade(Trade trade) {
			if (trade!=null) this.trade.add(trade.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addTrade(Trade trade, int _idx) {
			getIndex(this.trade, _idx, () -> trade.toBuilder());
			return this;
		}
		@Override 
		public ValuationDocument.ValuationDocumentBuilder addTrade(List<? extends Trade> trades) {
			if (trades != null) {
				for (Trade toAdd : trades) {
					this.trade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationDocument.ValuationDocumentBuilder setTrade(List<? extends Trade> trades) {
			if (trades == null)  {
				this.trade = new ArrayList<>();
			}
			else {
				this.trade = trades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("portfolio")
		public ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio portfolio) {
			if (portfolio!=null) this.portfolio.add(portfolio.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio portfolio, int _idx) {
			getIndex(this.portfolio, _idx, () -> portfolio.toBuilder());
			return this;
		}
		@Override 
		public ValuationDocument.ValuationDocumentBuilder addPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios != null) {
				for (Portfolio toAdd : portfolios) {
					this.portfolio.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationDocument.ValuationDocumentBuilder setPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios == null)  {
				this.portfolio = new ArrayList<>();
			}
			else {
				this.portfolio = portfolios.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ValuationDocument.ValuationDocumentBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("market")
		public ValuationDocument.ValuationDocumentBuilder addMarket(Market market) {
			if (market!=null) this.market.add(market.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addMarket(Market market, int _idx) {
			getIndex(this.market, _idx, () -> market.toBuilder());
			return this;
		}
		@Override 
		public ValuationDocument.ValuationDocumentBuilder addMarket(List<? extends Market> markets) {
			if (markets != null) {
				for (Market toAdd : markets) {
					this.market.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationDocument.ValuationDocumentBuilder setMarket(List<? extends Market> markets) {
			if (markets == null)  {
				this.market = new ArrayList<>();
			}
			else {
				this.market = markets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		public ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet valuationSet) {
			if (valuationSet!=null) this.valuationSet.add(valuationSet.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet valuationSet, int _idx) {
			getIndex(this.valuationSet, _idx, () -> valuationSet.toBuilder());
			return this;
		}
		@Override 
		public ValuationDocument.ValuationDocumentBuilder addValuationSet(List<? extends ValuationSet> valuationSets) {
			if (valuationSets != null) {
				for (ValuationSet toAdd : valuationSets) {
					this.valuationSet.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValuationDocument.ValuationDocumentBuilder setValuationSet(List<? extends ValuationSet> valuationSets) {
			if (valuationSets == null)  {
				this.valuationSet = new ArrayList<>();
			}
			else {
				this.valuationSet = valuationSets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ValuationDocument build() {
			return new ValuationDocument.ValuationDocumentImpl(this);
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDocument.ValuationDocumentBuilder prune() {
			super.prune();
			market = market.stream().filter(b->b!=null).<Market.MarketBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			valuationSet = valuationSet.stream().filter(b->b!=null).<ValuationSet.ValuationSetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMarket()!=null && getMarket().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationSet()!=null && getValuationSet().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDocument.ValuationDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ValuationDocument.ValuationDocumentBuilder o = (ValuationDocument.ValuationDocumentBuilder) other;
			
			merger.mergeRosetta(getMarket(), o.getMarket(), this::getOrCreateMarket);
			merger.mergeRosetta(getValuationSet(), o.getValuationSet(), this::getOrCreateValuationSet);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(market, _that.getMarket())) return false;
			if (!ListEquals.listEquals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDocumentBuilder {" +
				"market=" + this.market + ", " +
				"valuationSet=" + this.valuationSet +
			'}' + " " + super.toString();
		}
	}
}
