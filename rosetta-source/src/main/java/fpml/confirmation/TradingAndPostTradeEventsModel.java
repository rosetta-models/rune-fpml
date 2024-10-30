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
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder;
import fpml.confirmation.TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilderImpl;
import fpml.confirmation.TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelImpl;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.meta.TradingAndPostTradeEventsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between a trading, a post-trade event, and the extension point additional event
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradingAndPostTradeEventsModel", builder=TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradingAndPostTradeEventsModel extends RosettaModelObject {

	TradingAndPostTradeEventsModelMeta metaData = new TradingAndPostTradeEventsModelMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsBaseModel getTradingEventsBaseModel();
	PostTradeEventsBaseModel getPostTradeEventsBaseModel();
	AdditionalEvent getAdditionalEvent();

	/*********************** Build Methods  ***********************/
	TradingAndPostTradeEventsModel build();
	
	TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder toBuilder();
	
	static TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder builder() {
		return new TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradingAndPostTradeEventsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradingAndPostTradeEventsModel> getType() {
		return TradingAndPostTradeEventsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.class, getTradingEventsBaseModel());
		processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.class, getPostTradeEventsBaseModel());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradingAndPostTradeEventsModelBuilder extends TradingAndPostTradeEventsModel, RosettaModelObjectBuilder {
		TradingEventsBaseModel.TradingEventsBaseModelBuilder getOrCreateTradingEventsBaseModel();
		TradingEventsBaseModel.TradingEventsBaseModelBuilder getTradingEventsBaseModel();
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder getOrCreatePostTradeEventsBaseModel();
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder getPostTradeEventsBaseModel();
		AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent();
		AdditionalEvent.AdditionalEventBuilder getAdditionalEvent();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel);
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel);
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder setAdditionalEvent(AdditionalEvent additionalEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.TradingEventsBaseModelBuilder.class, getTradingEventsBaseModel());
			processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder.class, getPostTradeEventsBaseModel());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
		}
		

		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradingAndPostTradeEventsModel  ***********************/
	class TradingAndPostTradeEventsModelImpl implements TradingAndPostTradeEventsModel {
		private final TradingEventsBaseModel tradingEventsBaseModel;
		private final PostTradeEventsBaseModel postTradeEventsBaseModel;
		private final AdditionalEvent additionalEvent;
		
		protected TradingAndPostTradeEventsModelImpl(TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder builder) {
			this.tradingEventsBaseModel = ofNullable(builder.getTradingEventsBaseModel()).map(f->f.build()).orElse(null);
			this.postTradeEventsBaseModel = ofNullable(builder.getPostTradeEventsBaseModel()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("additionalEvent")
		public AdditionalEvent getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		public TradingAndPostTradeEventsModel build() {
			return this;
		}
		
		@Override
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder toBuilder() {
			TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder builder) {
			ofNullable(getTradingEventsBaseModel()).ifPresent(builder::setTradingEventsBaseModel);
			ofNullable(getPostTradeEventsBaseModel()).ifPresent(builder::setPostTradeEventsBaseModel);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingAndPostTradeEventsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingAndPostTradeEventsModel {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of TradingAndPostTradeEventsModel  ***********************/
	class TradingAndPostTradeEventsModelBuilderImpl implements TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder {
	
		protected TradingEventsBaseModel.TradingEventsBaseModelBuilder tradingEventsBaseModel;
		protected PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder postTradeEventsBaseModel;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
	
		public TradingAndPostTradeEventsModelBuilderImpl() {
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
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel) {
			this.tradingEventsBaseModel = tradingEventsBaseModel==null?null:tradingEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("postTradeEventsBaseModel")
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel) {
			this.postTradeEventsBaseModel = postTradeEventsBaseModel==null?null:postTradeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalEvent")
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder setAdditionalEvent(AdditionalEvent additionalEvent) {
			this.additionalEvent = additionalEvent==null?null:additionalEvent.toBuilder();
			return this;
		}
		
		@Override
		public TradingAndPostTradeEventsModel build() {
			return new TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelImpl(this);
		}
		
		@Override
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder prune() {
			if (tradingEventsBaseModel!=null && !tradingEventsBaseModel.prune().hasData()) tradingEventsBaseModel = null;
			if (postTradeEventsBaseModel!=null && !postTradeEventsBaseModel.prune().hasData()) postTradeEventsBaseModel = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradingEventsBaseModel()!=null && getTradingEventsBaseModel().hasData()) return true;
			if (getPostTradeEventsBaseModel()!=null && getPostTradeEventsBaseModel().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder o = (TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder) other;
			
			merger.mergeRosetta(getTradingEventsBaseModel(), o.getTradingEventsBaseModel(), this::setTradingEventsBaseModel);
			merger.mergeRosetta(getPostTradeEventsBaseModel(), o.getPostTradeEventsBaseModel(), this::setPostTradeEventsBaseModel);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingAndPostTradeEventsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingAndPostTradeEventsModelBuilder {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent +
			'}';
		}
	}
}
