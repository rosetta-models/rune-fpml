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
import fpml.confirmation.EventProposedMatch;
import fpml.confirmation.EventProposedMatch.EventProposedMatchBuilder;
import fpml.confirmation.EventProposedMatch.EventProposedMatchBuilderImpl;
import fpml.confirmation.EventProposedMatch.EventProposedMatchImpl;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.ProposedMatchModel;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.meta.EventProposedMatchMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that describes a proposed match between trades or post-trade event reports.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventProposedMatch", builder=EventProposedMatch.EventProposedMatchBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventProposedMatch extends RosettaModelObject {

	EventProposedMatchMeta metaData = new EventProposedMatchMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsBaseModel getTradingEventsBaseModel();
	PostTradeEventsBaseModel getPostTradeEventsBaseModel();
	ChangeEventsBaseModel getChangeEventsBaseModel();
	OptionsEventsBaseModel getOptionsEventsBaseModel();
	AdditionalEvent getAdditionalEvent();
	ProposedMatchModel getProposedMatchModel();

	/*********************** Build Methods  ***********************/
	EventProposedMatch build();
	
	EventProposedMatch.EventProposedMatchBuilder toBuilder();
	
	static EventProposedMatch.EventProposedMatchBuilder builder() {
		return new EventProposedMatch.EventProposedMatchBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventProposedMatch> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventProposedMatch> getType() {
		return EventProposedMatch.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.class, getTradingEventsBaseModel());
		processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.class, getPostTradeEventsBaseModel());
		processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.class, getChangeEventsBaseModel());
		processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.class, getOptionsEventsBaseModel());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("proposedMatchModel"), processor, ProposedMatchModel.class, getProposedMatchModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventProposedMatchBuilder extends EventProposedMatch, RosettaModelObjectBuilder {
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
		ProposedMatchModel.ProposedMatchModelBuilder getOrCreateProposedMatchModel();
		ProposedMatchModel.ProposedMatchModelBuilder getProposedMatchModel();
		EventProposedMatch.EventProposedMatchBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel);
		EventProposedMatch.EventProposedMatchBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel);
		EventProposedMatch.EventProposedMatchBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel);
		EventProposedMatch.EventProposedMatchBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel);
		EventProposedMatch.EventProposedMatchBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		EventProposedMatch.EventProposedMatchBuilder setProposedMatchModel(ProposedMatchModel proposedMatchModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.TradingEventsBaseModelBuilder.class, getTradingEventsBaseModel());
			processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder.class, getPostTradeEventsBaseModel());
			processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.ChangeEventsBaseModelBuilder.class, getChangeEventsBaseModel());
			processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.OptionsEventsBaseModelBuilder.class, getOptionsEventsBaseModel());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("proposedMatchModel"), processor, ProposedMatchModel.ProposedMatchModelBuilder.class, getProposedMatchModel());
		}
		

		EventProposedMatch.EventProposedMatchBuilder prune();
	}

	/*********************** Immutable Implementation of EventProposedMatch  ***********************/
	class EventProposedMatchImpl implements EventProposedMatch {
		private final TradingEventsBaseModel tradingEventsBaseModel;
		private final PostTradeEventsBaseModel postTradeEventsBaseModel;
		private final ChangeEventsBaseModel changeEventsBaseModel;
		private final OptionsEventsBaseModel optionsEventsBaseModel;
		private final AdditionalEvent additionalEvent;
		private final ProposedMatchModel proposedMatchModel;
		
		protected EventProposedMatchImpl(EventProposedMatch.EventProposedMatchBuilder builder) {
			this.tradingEventsBaseModel = ofNullable(builder.getTradingEventsBaseModel()).map(f->f.build()).orElse(null);
			this.postTradeEventsBaseModel = ofNullable(builder.getPostTradeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.changeEventsBaseModel = ofNullable(builder.getChangeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.optionsEventsBaseModel = ofNullable(builder.getOptionsEventsBaseModel()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.proposedMatchModel = ofNullable(builder.getProposedMatchModel()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("proposedMatchModel")
		public ProposedMatchModel getProposedMatchModel() {
			return proposedMatchModel;
		}
		
		@Override
		public EventProposedMatch build() {
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder toBuilder() {
			EventProposedMatch.EventProposedMatchBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventProposedMatch.EventProposedMatchBuilder builder) {
			ofNullable(getTradingEventsBaseModel()).ifPresent(builder::setTradingEventsBaseModel);
			ofNullable(getPostTradeEventsBaseModel()).ifPresent(builder::setPostTradeEventsBaseModel);
			ofNullable(getChangeEventsBaseModel()).ifPresent(builder::setChangeEventsBaseModel);
			ofNullable(getOptionsEventsBaseModel()).ifPresent(builder::setOptionsEventsBaseModel);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getProposedMatchModel()).ifPresent(builder::setProposedMatchModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventProposedMatch _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(proposedMatchModel, _that.getProposedMatchModel())) return false;
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
			_result = 31 * _result + (proposedMatchModel != null ? proposedMatchModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventProposedMatch {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"proposedMatchModel=" + this.proposedMatchModel +
			'}';
		}
	}

	/*********************** Builder Implementation of EventProposedMatch  ***********************/
	class EventProposedMatchBuilderImpl implements EventProposedMatch.EventProposedMatchBuilder {
	
		protected TradingEventsBaseModel.TradingEventsBaseModelBuilder tradingEventsBaseModel;
		protected PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder postTradeEventsBaseModel;
		protected ChangeEventsBaseModel.ChangeEventsBaseModelBuilder changeEventsBaseModel;
		protected OptionsEventsBaseModel.OptionsEventsBaseModelBuilder optionsEventsBaseModel;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected ProposedMatchModel.ProposedMatchModelBuilder proposedMatchModel;
	
		public EventProposedMatchBuilderImpl() {
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
		@RosettaAttribute("proposedMatchModel")
		public ProposedMatchModel.ProposedMatchModelBuilder getProposedMatchModel() {
			return proposedMatchModel;
		}
		
		@Override
		public ProposedMatchModel.ProposedMatchModelBuilder getOrCreateProposedMatchModel() {
			ProposedMatchModel.ProposedMatchModelBuilder result;
			if (proposedMatchModel!=null) {
				result = proposedMatchModel;
			}
			else {
				result = proposedMatchModel = ProposedMatchModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public EventProposedMatch.EventProposedMatchBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel) {
			this.tradingEventsBaseModel = tradingEventsBaseModel==null?null:tradingEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("postTradeEventsBaseModel")
		public EventProposedMatch.EventProposedMatchBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel) {
			this.postTradeEventsBaseModel = postTradeEventsBaseModel==null?null:postTradeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeEventsBaseModel")
		public EventProposedMatch.EventProposedMatchBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel) {
			this.changeEventsBaseModel = changeEventsBaseModel==null?null:changeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionsEventsBaseModel")
		public EventProposedMatch.EventProposedMatchBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel) {
			this.optionsEventsBaseModel = optionsEventsBaseModel==null?null:optionsEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalEvent")
		public EventProposedMatch.EventProposedMatchBuilder setAdditionalEvent(AdditionalEvent additionalEvent) {
			this.additionalEvent = additionalEvent==null?null:additionalEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("proposedMatchModel")
		public EventProposedMatch.EventProposedMatchBuilder setProposedMatchModel(ProposedMatchModel proposedMatchModel) {
			this.proposedMatchModel = proposedMatchModel==null?null:proposedMatchModel.toBuilder();
			return this;
		}
		
		@Override
		public EventProposedMatch build() {
			return new EventProposedMatch.EventProposedMatchImpl(this);
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder prune() {
			if (tradingEventsBaseModel!=null && !tradingEventsBaseModel.prune().hasData()) tradingEventsBaseModel = null;
			if (postTradeEventsBaseModel!=null && !postTradeEventsBaseModel.prune().hasData()) postTradeEventsBaseModel = null;
			if (changeEventsBaseModel!=null && !changeEventsBaseModel.prune().hasData()) changeEventsBaseModel = null;
			if (optionsEventsBaseModel!=null && !optionsEventsBaseModel.prune().hasData()) optionsEventsBaseModel = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			if (proposedMatchModel!=null && !proposedMatchModel.prune().hasData()) proposedMatchModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradingEventsBaseModel()!=null && getTradingEventsBaseModel().hasData()) return true;
			if (getPostTradeEventsBaseModel()!=null && getPostTradeEventsBaseModel().hasData()) return true;
			if (getChangeEventsBaseModel()!=null && getChangeEventsBaseModel().hasData()) return true;
			if (getOptionsEventsBaseModel()!=null && getOptionsEventsBaseModel().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getProposedMatchModel()!=null && getProposedMatchModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventProposedMatch.EventProposedMatchBuilder o = (EventProposedMatch.EventProposedMatchBuilder) other;
			
			merger.mergeRosetta(getTradingEventsBaseModel(), o.getTradingEventsBaseModel(), this::setTradingEventsBaseModel);
			merger.mergeRosetta(getPostTradeEventsBaseModel(), o.getPostTradeEventsBaseModel(), this::setPostTradeEventsBaseModel);
			merger.mergeRosetta(getChangeEventsBaseModel(), o.getChangeEventsBaseModel(), this::setChangeEventsBaseModel);
			merger.mergeRosetta(getOptionsEventsBaseModel(), o.getOptionsEventsBaseModel(), this::setOptionsEventsBaseModel);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getProposedMatchModel(), o.getProposedMatchModel(), this::setProposedMatchModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventProposedMatch _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(proposedMatchModel, _that.getProposedMatchModel())) return false;
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
			_result = 31 * _result + (proposedMatchModel != null ? proposedMatchModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventProposedMatchBuilder {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"proposedMatchModel=" + this.proposedMatchModel +
			'}';
		}
	}
}
