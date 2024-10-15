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
import fpml.confirmation.AdditionalEvent;
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.EventsChoice;
import fpml.confirmation.EventsChoice.EventsChoiceBuilder;
import fpml.confirmation.EventsChoice.EventsChoiceBuilderImpl;
import fpml.confirmation.EventsChoice.EventsChoiceImpl;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.meta.EventsChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="EventsChoice", builder=EventsChoice.EventsChoiceBuilderImpl.class, version="${project.version}")
public interface EventsChoice extends RosettaModelObject {

	EventsChoiceMeta metaData = new EventsChoiceMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsBaseModel getTradingEventsBaseModel();
	PostTradeEventsBaseModel getPostTradeEventsBaseModel();
	ChangeEventsBaseModel getChangeEventsBaseModel();
	OptionsEventsBaseModel getOptionsEventsBaseModel();
	AdditionalEvent getAdditionalEvent();

	/*********************** Build Methods  ***********************/
	EventsChoice build();
	
	EventsChoice.EventsChoiceBuilder toBuilder();
	
	static EventsChoice.EventsChoiceBuilder builder() {
		return new EventsChoice.EventsChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventsChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventsChoice> getType() {
		return EventsChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.class, getTradingEventsBaseModel());
		processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.class, getPostTradeEventsBaseModel());
		processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.class, getChangeEventsBaseModel());
		processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.class, getOptionsEventsBaseModel());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventsChoiceBuilder extends EventsChoice, RosettaModelObjectBuilder {
		TradingEventsBaseModel.TradingEventsBaseModelBuilder getOrCreateTradingEventsBaseModel();
		TradingEventsBaseModel.TradingEventsBaseModelBuilder getTradingEventsBaseModel();
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder getOrCreatePostTradeEventsBaseModel();
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder getPostTradeEventsBaseModel();
		ChangeEventsBaseModel.ChangeEventsBaseModelBuilder getOrCreateChangeEventsBaseModel();
		ChangeEventsBaseModel.ChangeEventsBaseModelBuilder getChangeEventsBaseModel();
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder getOrCreateOptionsEventsBaseModel();
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder getOptionsEventsBaseModel();
		AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent();
		AdditionalEvent.AdditionalEventBuilder getAdditionalEvent();
		EventsChoice.EventsChoiceBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel);
		EventsChoice.EventsChoiceBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel);
		EventsChoice.EventsChoiceBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel);
		EventsChoice.EventsChoiceBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel);
		EventsChoice.EventsChoiceBuilder setAdditionalEvent(AdditionalEvent additionalEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.TradingEventsBaseModelBuilder.class, getTradingEventsBaseModel());
			processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder.class, getPostTradeEventsBaseModel());
			processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.ChangeEventsBaseModelBuilder.class, getChangeEventsBaseModel());
			processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.OptionsEventsBaseModelBuilder.class, getOptionsEventsBaseModel());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
		}
		

		EventsChoice.EventsChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of EventsChoice  ***********************/
	class EventsChoiceImpl implements EventsChoice {
		private final TradingEventsBaseModel tradingEventsBaseModel;
		private final PostTradeEventsBaseModel postTradeEventsBaseModel;
		private final ChangeEventsBaseModel changeEventsBaseModel;
		private final OptionsEventsBaseModel optionsEventsBaseModel;
		private final AdditionalEvent additionalEvent;
		
		protected EventsChoiceImpl(EventsChoice.EventsChoiceBuilder builder) {
			this.tradingEventsBaseModel = ofNullable(builder.getTradingEventsBaseModel()).map(f->f.build()).orElse(null);
			this.postTradeEventsBaseModel = ofNullable(builder.getPostTradeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.changeEventsBaseModel = ofNullable(builder.getChangeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.optionsEventsBaseModel = ofNullable(builder.getOptionsEventsBaseModel()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public TradingEventsBaseModel getTradingEventsBaseModel() {
			return tradingEventsBaseModel;
		}
		
		@Override
		@RosettaAttribute("postTradeEventsBaseModel")
		public PostTradeEventsBaseModel getPostTradeEventsBaseModel() {
			return postTradeEventsBaseModel;
		}
		
		@Override
		@RosettaAttribute("changeEventsBaseModel")
		public ChangeEventsBaseModel getChangeEventsBaseModel() {
			return changeEventsBaseModel;
		}
		
		@Override
		@RosettaAttribute("optionsEventsBaseModel")
		public OptionsEventsBaseModel getOptionsEventsBaseModel() {
			return optionsEventsBaseModel;
		}
		
		@Override
		@RosettaAttribute("additionalEvent")
		public AdditionalEvent getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		public EventsChoice build() {
			return this;
		}
		
		@Override
		public EventsChoice.EventsChoiceBuilder toBuilder() {
			EventsChoice.EventsChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventsChoice.EventsChoiceBuilder builder) {
			ofNullable(getTradingEventsBaseModel()).ifPresent(builder::setTradingEventsBaseModel);
			ofNullable(getPostTradeEventsBaseModel()).ifPresent(builder::setPostTradeEventsBaseModel);
			ofNullable(getChangeEventsBaseModel()).ifPresent(builder::setChangeEventsBaseModel);
			ofNullable(getOptionsEventsBaseModel()).ifPresent(builder::setOptionsEventsBaseModel);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventsChoice _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (changeEventsBaseModel != null ? changeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (optionsEventsBaseModel != null ? optionsEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventsChoice {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of EventsChoice  ***********************/
	class EventsChoiceBuilderImpl implements EventsChoice.EventsChoiceBuilder {
	
		protected TradingEventsBaseModel.TradingEventsBaseModelBuilder tradingEventsBaseModel;
		protected PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder postTradeEventsBaseModel;
		protected ChangeEventsBaseModel.ChangeEventsBaseModelBuilder changeEventsBaseModel;
		protected OptionsEventsBaseModel.OptionsEventsBaseModelBuilder optionsEventsBaseModel;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
	
		public EventsChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder getTradingEventsBaseModel() {
			return tradingEventsBaseModel;
		}
		
		@Override
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder getOrCreateTradingEventsBaseModel() {
			TradingEventsBaseModel.TradingEventsBaseModelBuilder result;
			if (tradingEventsBaseModel!=null) {
				result = tradingEventsBaseModel;
			}
			else {
				result = tradingEventsBaseModel = TradingEventsBaseModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postTradeEventsBaseModel")
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder getPostTradeEventsBaseModel() {
			return postTradeEventsBaseModel;
		}
		
		@Override
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder getOrCreatePostTradeEventsBaseModel() {
			PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder result;
			if (postTradeEventsBaseModel!=null) {
				result = postTradeEventsBaseModel;
			}
			else {
				result = postTradeEventsBaseModel = PostTradeEventsBaseModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeEventsBaseModel")
		public ChangeEventsBaseModel.ChangeEventsBaseModelBuilder getChangeEventsBaseModel() {
			return changeEventsBaseModel;
		}
		
		@Override
		public ChangeEventsBaseModel.ChangeEventsBaseModelBuilder getOrCreateChangeEventsBaseModel() {
			ChangeEventsBaseModel.ChangeEventsBaseModelBuilder result;
			if (changeEventsBaseModel!=null) {
				result = changeEventsBaseModel;
			}
			else {
				result = changeEventsBaseModel = ChangeEventsBaseModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionsEventsBaseModel")
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder getOptionsEventsBaseModel() {
			return optionsEventsBaseModel;
		}
		
		@Override
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder getOrCreateOptionsEventsBaseModel() {
			OptionsEventsBaseModel.OptionsEventsBaseModelBuilder result;
			if (optionsEventsBaseModel!=null) {
				result = optionsEventsBaseModel;
			}
			else {
				result = optionsEventsBaseModel = OptionsEventsBaseModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalEvent")
		public AdditionalEvent.AdditionalEventBuilder getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		public AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent() {
			AdditionalEvent.AdditionalEventBuilder result;
			if (additionalEvent!=null) {
				result = additionalEvent;
			}
			else {
				result = additionalEvent = AdditionalEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public EventsChoice.EventsChoiceBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel) {
			this.tradingEventsBaseModel = tradingEventsBaseModel==null?null:tradingEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("postTradeEventsBaseModel")
		public EventsChoice.EventsChoiceBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel) {
			this.postTradeEventsBaseModel = postTradeEventsBaseModel==null?null:postTradeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeEventsBaseModel")
		public EventsChoice.EventsChoiceBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel) {
			this.changeEventsBaseModel = changeEventsBaseModel==null?null:changeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionsEventsBaseModel")
		public EventsChoice.EventsChoiceBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel) {
			this.optionsEventsBaseModel = optionsEventsBaseModel==null?null:optionsEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalEvent")
		public EventsChoice.EventsChoiceBuilder setAdditionalEvent(AdditionalEvent additionalEvent) {
			this.additionalEvent = additionalEvent==null?null:additionalEvent.toBuilder();
			return this;
		}
		
		@Override
		public EventsChoice build() {
			return new EventsChoice.EventsChoiceImpl(this);
		}
		
		@Override
		public EventsChoice.EventsChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventsChoice.EventsChoiceBuilder prune() {
			if (tradingEventsBaseModel!=null && !tradingEventsBaseModel.prune().hasData()) tradingEventsBaseModel = null;
			if (postTradeEventsBaseModel!=null && !postTradeEventsBaseModel.prune().hasData()) postTradeEventsBaseModel = null;
			if (changeEventsBaseModel!=null && !changeEventsBaseModel.prune().hasData()) changeEventsBaseModel = null;
			if (optionsEventsBaseModel!=null && !optionsEventsBaseModel.prune().hasData()) optionsEventsBaseModel = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradingEventsBaseModel()!=null && getTradingEventsBaseModel().hasData()) return true;
			if (getPostTradeEventsBaseModel()!=null && getPostTradeEventsBaseModel().hasData()) return true;
			if (getChangeEventsBaseModel()!=null && getChangeEventsBaseModel().hasData()) return true;
			if (getOptionsEventsBaseModel()!=null && getOptionsEventsBaseModel().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventsChoice.EventsChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventsChoice.EventsChoiceBuilder o = (EventsChoice.EventsChoiceBuilder) other;
			
			merger.mergeRosetta(getTradingEventsBaseModel(), o.getTradingEventsBaseModel(), this::setTradingEventsBaseModel);
			merger.mergeRosetta(getPostTradeEventsBaseModel(), o.getPostTradeEventsBaseModel(), this::setPostTradeEventsBaseModel);
			merger.mergeRosetta(getChangeEventsBaseModel(), o.getChangeEventsBaseModel(), this::setChangeEventsBaseModel);
			merger.mergeRosetta(getOptionsEventsBaseModel(), o.getOptionsEventsBaseModel(), this::setOptionsEventsBaseModel);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventsChoice _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (changeEventsBaseModel != null ? changeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (optionsEventsBaseModel != null ? optionsEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventsChoiceBuilder {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent +
			'}';
		}
	}
}
