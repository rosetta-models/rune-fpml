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
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.EventsOrInfoModel.EventsOrInfoModelBuilder;
import fpml.confirmation.EventsOrInfoModel.EventsOrInfoModelBuilderImpl;
import fpml.confirmation.EventsOrInfoModel.EventsOrInfoModelImpl;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.meta.EventsOrInfoModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows either details of an event or information about a trade to be provided. Typically this will be used in a response to a request.
 * @version ${project.version}
 */
@RosettaDataType(value="EventsOrInfoModel", builder=EventsOrInfoModel.EventsOrInfoModelBuilderImpl.class, version="${project.version}")
public interface EventsOrInfoModel extends RosettaModelObject {

	EventsOrInfoModelMeta metaData = new EventsOrInfoModelMeta();

	/*********************** Getter Methods  ***********************/
	TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel();
	TradeReferenceInformationModel getTradeReferenceInformationModel();

	/*********************** Build Methods  ***********************/
	EventsOrInfoModel build();
	
	EventsOrInfoModel.EventsOrInfoModelBuilder toBuilder();
	
	static EventsOrInfoModel.EventsOrInfoModelBuilder builder() {
		return new EventsOrInfoModel.EventsOrInfoModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventsOrInfoModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventsOrInfoModel> getType() {
		return EventsOrInfoModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.class, getTradingAndPostTradeEventsModel());
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventsOrInfoModelBuilder extends EventsOrInfoModel, RosettaModelObjectBuilder {
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel();
		EventsOrInfoModel.EventsOrInfoModelBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel);
		EventsOrInfoModel.EventsOrInfoModelBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder.class, getTradingAndPostTradeEventsModel());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
		}
		

		EventsOrInfoModel.EventsOrInfoModelBuilder prune();
	}

	/*********************** Immutable Implementation of EventsOrInfoModel  ***********************/
	class EventsOrInfoModelImpl implements EventsOrInfoModel {
		private final TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel;
		private final TradeReferenceInformationModel tradeReferenceInformationModel;
		
		protected EventsOrInfoModelImpl(EventsOrInfoModel.EventsOrInfoModelBuilder builder) {
			this.tradingAndPostTradeEventsModel = ofNullable(builder.getTradingAndPostTradeEventsModel()).map(f->f.build()).orElse(null);
			this.tradeReferenceInformationModel = ofNullable(builder.getTradeReferenceInformationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel() {
			return tradingAndPostTradeEventsModel;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		public EventsOrInfoModel build() {
			return this;
		}
		
		@Override
		public EventsOrInfoModel.EventsOrInfoModelBuilder toBuilder() {
			EventsOrInfoModel.EventsOrInfoModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventsOrInfoModel.EventsOrInfoModelBuilder builder) {
			ofNullable(getTradingAndPostTradeEventsModel()).ifPresent(builder::setTradingAndPostTradeEventsModel);
			ofNullable(getTradeReferenceInformationModel()).ifPresent(builder::setTradeReferenceInformationModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventsOrInfoModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventsOrInfoModel {" +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel +
			'}';
		}
	}

	/*********************** Builder Implementation of EventsOrInfoModel  ***********************/
	class EventsOrInfoModelBuilderImpl implements EventsOrInfoModel.EventsOrInfoModelBuilder {
	
		protected TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder tradingAndPostTradeEventsModel;
		protected TradeReferenceInformationModel.TradeReferenceInformationModelBuilder tradeReferenceInformationModel;
	
		public EventsOrInfoModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel() {
			return tradingAndPostTradeEventsModel;
		}
		
		@Override
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel() {
			TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder result;
			if (tradingAndPostTradeEventsModel!=null) {
				result = tradingAndPostTradeEventsModel;
			}
			else {
				result = tradingAndPostTradeEventsModel = TradingAndPostTradeEventsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel() {
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder result;
			if (tradeReferenceInformationModel!=null) {
				result = tradeReferenceInformationModel;
			}
			else {
				result = tradeReferenceInformationModel = TradeReferenceInformationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public EventsOrInfoModel.EventsOrInfoModelBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			this.tradingAndPostTradeEventsModel = tradingAndPostTradeEventsModel==null?null:tradingAndPostTradeEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public EventsOrInfoModel.EventsOrInfoModelBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		
		@Override
		public EventsOrInfoModel build() {
			return new EventsOrInfoModel.EventsOrInfoModelImpl(this);
		}
		
		@Override
		public EventsOrInfoModel.EventsOrInfoModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventsOrInfoModel.EventsOrInfoModelBuilder prune() {
			if (tradingAndPostTradeEventsModel!=null && !tradingAndPostTradeEventsModel.prune().hasData()) tradingAndPostTradeEventsModel = null;
			if (tradeReferenceInformationModel!=null && !tradeReferenceInformationModel.prune().hasData()) tradeReferenceInformationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradingAndPostTradeEventsModel()!=null && getTradingAndPostTradeEventsModel().hasData()) return true;
			if (getTradeReferenceInformationModel()!=null && getTradeReferenceInformationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventsOrInfoModel.EventsOrInfoModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventsOrInfoModel.EventsOrInfoModelBuilder o = (EventsOrInfoModel.EventsOrInfoModelBuilder) other;
			
			merger.mergeRosetta(getTradingAndPostTradeEventsModel(), o.getTradingAndPostTradeEventsModel(), this::setTradingAndPostTradeEventsModel);
			merger.mergeRosetta(getTradeReferenceInformationModel(), o.getTradeReferenceInformationModel(), this::setTradeReferenceInformationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventsOrInfoModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventsOrInfoModelBuilder {" +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel +
			'}';
		}
	}
}
