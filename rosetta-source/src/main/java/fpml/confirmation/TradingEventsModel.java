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
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.TradingEventsModel.TradingEventsModelBuilder;
import fpml.confirmation.TradingEventsModel.TradingEventsModelBuilderImpl;
import fpml.confirmation.TradingEventsModel.TradingEventsModelImpl;
import fpml.confirmation.meta.TradingEventsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information about a trading event that represent a new trading activity (on a newly-created trade), or in some cases the a representation of the trade&#39;s current state. Also allows the &quot;additionEvent&quot; extension point.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradingEventsModel", builder=TradingEventsModel.TradingEventsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradingEventsModel extends RosettaModelObject {

	TradingEventsModelMeta metaData = new TradingEventsModelMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsBaseModel getTradingEventsBaseModel();
	AdditionalEvent getAdditionalEvent();

	/*********************** Build Methods  ***********************/
	TradingEventsModel build();
	
	TradingEventsModel.TradingEventsModelBuilder toBuilder();
	
	static TradingEventsModel.TradingEventsModelBuilder builder() {
		return new TradingEventsModel.TradingEventsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradingEventsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradingEventsModel> getType() {
		return TradingEventsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.class, getTradingEventsBaseModel());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradingEventsModelBuilder extends TradingEventsModel, RosettaModelObjectBuilder {
		TradingEventsBaseModel.TradingEventsBaseModelBuilder getOrCreateTradingEventsBaseModel();
		TradingEventsBaseModel.TradingEventsBaseModelBuilder getTradingEventsBaseModel();
		AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent();
		AdditionalEvent.AdditionalEventBuilder getAdditionalEvent();
		TradingEventsModel.TradingEventsModelBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel);
		TradingEventsModel.TradingEventsModelBuilder setAdditionalEvent(AdditionalEvent additionalEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.TradingEventsBaseModelBuilder.class, getTradingEventsBaseModel());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
		}
		

		TradingEventsModel.TradingEventsModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradingEventsModel  ***********************/
	class TradingEventsModelImpl implements TradingEventsModel {
		private final TradingEventsBaseModel tradingEventsBaseModel;
		private final AdditionalEvent additionalEvent;
		
		protected TradingEventsModelImpl(TradingEventsModel.TradingEventsModelBuilder builder) {
			this.tradingEventsBaseModel = ofNullable(builder.getTradingEventsBaseModel()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public TradingEventsBaseModel getTradingEventsBaseModel() {
			return tradingEventsBaseModel;
		}
		
		@Override
		@RosettaAttribute("additionalEvent")
		public AdditionalEvent getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		public TradingEventsModel build() {
			return this;
		}
		
		@Override
		public TradingEventsModel.TradingEventsModelBuilder toBuilder() {
			TradingEventsModel.TradingEventsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradingEventsModel.TradingEventsModelBuilder builder) {
			ofNullable(getTradingEventsBaseModel()).ifPresent(builder::setTradingEventsBaseModel);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventsModel {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of TradingEventsModel  ***********************/
	class TradingEventsModelBuilderImpl implements TradingEventsModel.TradingEventsModelBuilder {
	
		protected TradingEventsBaseModel.TradingEventsBaseModelBuilder tradingEventsBaseModel;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
	
		public TradingEventsModelBuilderImpl() {
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
		public TradingEventsModel.TradingEventsModelBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel) {
			this.tradingEventsBaseModel = tradingEventsBaseModel==null?null:tradingEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalEvent")
		public TradingEventsModel.TradingEventsModelBuilder setAdditionalEvent(AdditionalEvent additionalEvent) {
			this.additionalEvent = additionalEvent==null?null:additionalEvent.toBuilder();
			return this;
		}
		
		@Override
		public TradingEventsModel build() {
			return new TradingEventsModel.TradingEventsModelImpl(this);
		}
		
		@Override
		public TradingEventsModel.TradingEventsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventsModel.TradingEventsModelBuilder prune() {
			if (tradingEventsBaseModel!=null && !tradingEventsBaseModel.prune().hasData()) tradingEventsBaseModel = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradingEventsBaseModel()!=null && getTradingEventsBaseModel().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventsModel.TradingEventsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradingEventsModel.TradingEventsModelBuilder o = (TradingEventsModel.TradingEventsModelBuilder) other;
			
			merger.mergeRosetta(getTradingEventsBaseModel(), o.getTradingEventsBaseModel(), this::setTradingEventsBaseModel);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventsModelBuilder {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent +
			'}';
		}
	}
}
