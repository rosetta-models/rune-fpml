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
import fpml.confirmation.Document;
import fpml.confirmation.Document.DocumentBuilder;
import fpml.confirmation.Document.DocumentBuilderImpl;
import fpml.confirmation.Document.DocumentImpl;
import fpml.confirmation.OnBehalfOf;
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.Portfolio;
import fpml.confirmation.Trade;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.DataDocumentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A document containing trade and/or portfolio and/or party data without expressing any processing intention. A type defining a content model that is backwards compatible with older FpML releases and which can be used to contain sets of data without expressing any processing intention.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DataDocument", builder=DataDocument.DataDocumentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DataDocument extends Document {

	DataDocumentMeta metaData = new DataDocumentMeta();

	/*********************** Getter Methods  ***********************/
	ValidationModel getValidationModel();
	/**
	 * Indicates which party (and accounts) a trade is being processed for.
	 */
	OnBehalfOf getOnBehalfOf();
	OriginatingEvent getOriginatingEvent();
	/**
	 * The root element in an FpML trade document.
	 */
	List<? extends Trade> getTrade();
	/**
	 * An arbitary grouping of trade references (and possibly other portfolios).
	 */
	List<? extends Portfolio> getPortfolio();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	DataDocument build();
	
	DataDocument.DataDocumentBuilder toBuilder();
	
	static DataDocument.DataDocumentBuilder builder() {
		return new DataDocument.DataDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DataDocument> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DataDocument> getType() {
		return DataDocument.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface DataDocumentBuilder extends DataDocument, Document.DocumentBuilder {
		ValidationModel.ValidationModelBuilder getOrCreateValidationModel();
		ValidationModel.ValidationModelBuilder getValidationModel();
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf();
		OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf();
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade(int _index);
		List<? extends Trade.TradeBuilder> getTrade();
		Portfolio.PortfolioBuilder getOrCreatePortfolio(int _index);
		List<? extends Portfolio.PortfolioBuilder> getPortfolio();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		DataDocument.DataDocumentBuilder setExpectedBuild(Integer expectedBuild);
		DataDocument.DataDocumentBuilder setActualBuild(Integer actualBuild);
		DataDocument.DataDocumentBuilder setValidationModel(ValidationModel validationModel);
		DataDocument.DataDocumentBuilder setOnBehalfOf(OnBehalfOf onBehalfOf);
		DataDocument.DataDocumentBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		DataDocument.DataDocumentBuilder addTrade(Trade trade0);
		DataDocument.DataDocumentBuilder addTrade(Trade trade1, int _idx);
		DataDocument.DataDocumentBuilder addTrade(List<? extends Trade> trade2);
		DataDocument.DataDocumentBuilder setTrade(List<? extends Trade> trade3);
		DataDocument.DataDocumentBuilder addPortfolio(Portfolio portfolio0);
		DataDocument.DataDocumentBuilder addPortfolio(Portfolio portfolio1, int _idx);
		DataDocument.DataDocumentBuilder addPortfolio(List<? extends Portfolio> portfolio2);
		DataDocument.DataDocumentBuilder setPortfolio(List<? extends Portfolio> portfolio3);
		DataDocument.DataDocumentBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		}
		

		DataDocument.DataDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of DataDocument  ***********************/
	class DataDocumentImpl extends Document.DocumentImpl implements DataDocument {
		private final ValidationModel validationModel;
		private final OnBehalfOf onBehalfOf;
		private final OriginatingEvent originatingEvent;
		private final List<? extends Trade> trade;
		private final List<? extends Portfolio> portfolio;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected DataDocumentImpl(DataDocument.DataDocumentBuilder builder) {
			super(builder);
			this.validationModel = ofNullable(builder.getValidationModel()).map(f->f.build()).orElse(null);
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).map(f->f.build()).orElse(null);
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.portfolio = ofNullable(builder.getPortfolio()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("validationModel")
		public ValidationModel getValidationModel() {
			return validationModel;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		public OnBehalfOf getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("trade")
		public List<? extends Trade> getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("portfolio")
		public List<? extends Portfolio> getPortfolio() {
			return portfolio;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public DataDocument build() {
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder toBuilder() {
			DataDocument.DataDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DataDocument.DataDocumentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValidationModel()).ifPresent(builder::setValidationModel);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getPortfolio()).ifPresent(builder::setPortfolio);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DataDocument _that = getType().cast(o);
		
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataDocument {" +
				"validationModel=" + this.validationModel + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"portfolio=" + this.portfolio + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DataDocument  ***********************/
	class DataDocumentBuilderImpl extends Document.DocumentBuilderImpl  implements DataDocument.DataDocumentBuilder {
	
		protected ValidationModel.ValidationModelBuilder validationModel;
		protected OnBehalfOf.OnBehalfOfBuilder onBehalfOf;
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected List<Trade.TradeBuilder> trade = new ArrayList<>();
		protected List<Portfolio.PortfolioBuilder> portfolio = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public DataDocumentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("validationModel")
		public ValidationModel.ValidationModelBuilder getValidationModel() {
			return validationModel;
		}
		
		@Override
		public ValidationModel.ValidationModelBuilder getOrCreateValidationModel() {
			ValidationModel.ValidationModelBuilder result;
			if (validationModel!=null) {
				result = validationModel;
			}
			else {
				result = validationModel = ValidationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		public OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf() {
			OnBehalfOf.OnBehalfOfBuilder result;
			if (onBehalfOf!=null) {
				result = onBehalfOf;
			}
			else {
				result = onBehalfOf = OnBehalfOf.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		public List<? extends Trade.TradeBuilder> getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade(int _index) {
		
			if (trade==null) {
				this.trade = new ArrayList<>();
			}
			Trade.TradeBuilder result;
			return getIndex(trade, _index, () -> {
						Trade.TradeBuilder newTrade = Trade.builder();
						return newTrade;
					});
		}
		
		@Override
		@RosettaAttribute("portfolio")
		public List<? extends Portfolio.PortfolioBuilder> getPortfolio() {
			return portfolio;
		}
		
		@Override
		public Portfolio.PortfolioBuilder getOrCreatePortfolio(int _index) {
		
			if (portfolio==null) {
				this.portfolio = new ArrayList<>();
			}
			Portfolio.PortfolioBuilder result;
			return getIndex(portfolio, _index, () -> {
						Portfolio.PortfolioBuilder newPortfolio = Portfolio.builder();
						return newPortfolio;
					});
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder result;
			if (partiesAndAccountsModel!=null) {
				result = partiesAndAccountsModel;
			}
			else {
				result = partiesAndAccountsModel = PartiesAndAccountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public DataDocument.DataDocumentBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public DataDocument.DataDocumentBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public DataDocument.DataDocumentBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOf")
		public DataDocument.DataDocumentBuilder setOnBehalfOf(OnBehalfOf onBehalfOf) {
			this.onBehalfOf = onBehalfOf==null?null:onBehalfOf.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originatingEvent")
		public DataDocument.DataDocumentBuilder setOriginatingEvent(OriginatingEvent originatingEvent) {
			this.originatingEvent = originatingEvent==null?null:originatingEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public DataDocument.DataDocumentBuilder addTrade(Trade trade) {
			if (trade!=null) this.trade.add(trade.toBuilder());
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addTrade(Trade trade, int _idx) {
			getIndex(this.trade, _idx, () -> trade.toBuilder());
			return this;
		}
		@Override 
		public DataDocument.DataDocumentBuilder addTrade(List<? extends Trade> trades) {
			if (trades != null) {
				for (Trade toAdd : trades) {
					this.trade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DataDocument.DataDocumentBuilder setTrade(List<? extends Trade> trades) {
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
		public DataDocument.DataDocumentBuilder addPortfolio(Portfolio portfolio) {
			if (portfolio!=null) this.portfolio.add(portfolio.toBuilder());
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addPortfolio(Portfolio portfolio, int _idx) {
			getIndex(this.portfolio, _idx, () -> portfolio.toBuilder());
			return this;
		}
		@Override 
		public DataDocument.DataDocumentBuilder addPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios != null) {
				for (Portfolio toAdd : portfolios) {
					this.portfolio.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DataDocument.DataDocumentBuilder setPortfolio(List<? extends Portfolio> portfolios) {
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
		public DataDocument.DataDocumentBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public DataDocument build() {
			return new DataDocument.DataDocumentImpl(this);
		}
		
		@Override
		public DataDocument.DataDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataDocument.DataDocumentBuilder prune() {
			super.prune();
			if (validationModel!=null && !validationModel.prune().hasData()) validationModel = null;
			if (onBehalfOf!=null && !onBehalfOf.prune().hasData()) onBehalfOf = null;
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			trade = trade.stream().filter(b->b!=null).<Trade.TradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			portfolio = portfolio.stream().filter(b->b!=null).<Portfolio.PortfolioBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValidationModel()!=null && getValidationModel().hasData()) return true;
			if (getOnBehalfOf()!=null && getOnBehalfOf().hasData()) return true;
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPortfolio()!=null && getPortfolio().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataDocument.DataDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DataDocument.DataDocumentBuilder o = (DataDocument.DataDocumentBuilder) other;
			
			merger.mergeRosetta(getValidationModel(), o.getValidationModel(), this::setValidationModel);
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::setOnBehalfOf);
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::getOrCreateTrade);
			merger.mergeRosetta(getPortfolio(), o.getPortfolio(), this::getOrCreatePortfolio);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DataDocument _that = getType().cast(o);
		
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataDocumentBuilder {" +
				"validationModel=" + this.validationModel + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"portfolio=" + this.portfolio + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
