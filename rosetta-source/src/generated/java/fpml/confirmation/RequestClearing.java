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
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.RequestClearing;
import fpml.confirmation.RequestClearing.RequestClearingBuilder;
import fpml.confirmation.RequestClearing.RequestClearingBuilderImpl;
import fpml.confirmation.RequestClearing.RequestClearingImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestClearingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message requesting that a trade be cleared by a clearing service.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestClearing", builder=RequestClearing.RequestClearingBuilderImpl.class, version="${project.version}")
public interface RequestClearing extends CorrectableRequestMessage {

	RequestClearingMeta metaData = new RequestClearingMeta();

	/*********************** Getter Methods  ***********************/
	PortfolioReferenceModel getPortfolioReferenceModel();
	TradingEventsModel getTradingEventsModel();
	/**
	 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 */
	DeClear getDeClear();
	EventValuationModel getEventValuationModel();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestClearing build();
	
	RequestClearing.RequestClearingBuilder toBuilder();
	
	static RequestClearing.RequestClearingBuilder builder() {
		return new RequestClearing.RequestClearingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestClearing> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestClearing> getType() {
		return RequestClearing.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("portfolioReferenceModel"), processor, PortfolioReferenceModel.class, getPortfolioReferenceModel());
		processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.class, getTradingEventsModel());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.class, getEventValuationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestClearingBuilder extends RequestClearing, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		PortfolioReferenceModel.PortfolioReferenceModelBuilder getOrCreatePortfolioReferenceModel();
		PortfolioReferenceModel.PortfolioReferenceModelBuilder getPortfolioReferenceModel();
		TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel();
		TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel();
		DeClear.DeClearBuilder getOrCreateDeClear();
		DeClear.DeClearBuilder getDeClear();
		EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel();
		EventValuationModel.EventValuationModelBuilder getEventValuationModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestClearing.RequestClearingBuilder setExpectedBuild(Integer expectedBuild);
		RequestClearing.RequestClearingBuilder setActualBuild(Integer actualBuild);
		RequestClearing.RequestClearingBuilder setHeader(RequestMessageHeader header);
		RequestClearing.RequestClearingBuilder setValidationModel(ValidationModel validationModel);
		RequestClearing.RequestClearingBuilder setIsCorrection(Boolean isCorrection);
		RequestClearing.RequestClearingBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestClearing.RequestClearingBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestClearing.RequestClearingBuilder setPortfolioReferenceModel(PortfolioReferenceModel portfolioReferenceModel);
		RequestClearing.RequestClearingBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel);
		RequestClearing.RequestClearingBuilder setDeClear(DeClear deClear);
		RequestClearing.RequestClearingBuilder setEventValuationModel(EventValuationModel eventValuationModel);
		RequestClearing.RequestClearingBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("portfolioReferenceModel"), processor, PortfolioReferenceModel.PortfolioReferenceModelBuilder.class, getPortfolioReferenceModel());
			processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.TradingEventsModelBuilder.class, getTradingEventsModel());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.EventValuationModelBuilder.class, getEventValuationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestClearing.RequestClearingBuilder prune();
	}

	/*********************** Immutable Implementation of RequestClearing  ***********************/
	class RequestClearingImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestClearing {
		private final PortfolioReferenceModel portfolioReferenceModel;
		private final TradingEventsModel tradingEventsModel;
		private final DeClear deClear;
		private final EventValuationModel eventValuationModel;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestClearingImpl(RequestClearing.RequestClearingBuilder builder) {
			super(builder);
			this.portfolioReferenceModel = ofNullable(builder.getPortfolioReferenceModel()).map(f->f.build()).orElse(null);
			this.tradingEventsModel = ofNullable(builder.getTradingEventsModel()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.eventValuationModel = ofNullable(builder.getEventValuationModel()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public PortfolioReferenceModel getPortfolioReferenceModel() {
			return portfolioReferenceModel;
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
		}
		
		@Override
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestClearing build() {
			return this;
		}
		
		@Override
		public RequestClearing.RequestClearingBuilder toBuilder() {
			RequestClearing.RequestClearingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestClearing.RequestClearingBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPortfolioReferenceModel()).ifPresent(builder::setPortfolioReferenceModel);
			ofNullable(getTradingEventsModel()).ifPresent(builder::setTradingEventsModel);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getEventValuationModel()).ifPresent(builder::setEventValuationModel);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestClearing _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReferenceModel, _that.getPortfolioReferenceModel())) return false;
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (portfolioReferenceModel != null ? portfolioReferenceModel.hashCode() : 0);
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestClearing {" +
				"portfolioReferenceModel=" + this.portfolioReferenceModel + ", " +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestClearing  ***********************/
	class RequestClearingBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestClearing.RequestClearingBuilder {
	
		protected PortfolioReferenceModel.PortfolioReferenceModelBuilder portfolioReferenceModel;
		protected TradingEventsModel.TradingEventsModelBuilder tradingEventsModel;
		protected DeClear.DeClearBuilder deClear;
		protected EventValuationModel.EventValuationModelBuilder eventValuationModel;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestClearingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder getPortfolioReferenceModel() {
			return portfolioReferenceModel;
		}
		
		@Override
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder getOrCreatePortfolioReferenceModel() {
			PortfolioReferenceModel.PortfolioReferenceModelBuilder result;
			if (portfolioReferenceModel!=null) {
				result = portfolioReferenceModel;
			}
			else {
				result = portfolioReferenceModel = PortfolioReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		public TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel() {
			TradingEventsModel.TradingEventsModelBuilder result;
			if (tradingEventsModel!=null) {
				result = tradingEventsModel;
			}
			else {
				result = tradingEventsModel = TradingEventsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear.DeClearBuilder getDeClear() {
			return deClear;
		}
		
		@Override
		public DeClear.DeClearBuilder getOrCreateDeClear() {
			DeClear.DeClearBuilder result;
			if (deClear!=null) {
				result = deClear;
			}
			else {
				result = deClear = DeClear.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel.EventValuationModelBuilder getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		public EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel() {
			EventValuationModel.EventValuationModelBuilder result;
			if (eventValuationModel!=null) {
				result = eventValuationModel;
			}
			else {
				result = eventValuationModel = EventValuationModel.builder();
			}
			
			return result;
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
		public RequestClearing.RequestClearingBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestClearing.RequestClearingBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestClearing.RequestClearingBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestClearing.RequestClearingBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestClearing.RequestClearingBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestClearing.RequestClearingBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestClearing.RequestClearingBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public RequestClearing.RequestClearingBuilder setPortfolioReferenceModel(PortfolioReferenceModel portfolioReferenceModel) {
			this.portfolioReferenceModel = portfolioReferenceModel==null?null:portfolioReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsModel")
		public RequestClearing.RequestClearingBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel) {
			this.tradingEventsModel = tradingEventsModel==null?null:tradingEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deClear")
		public RequestClearing.RequestClearingBuilder setDeClear(DeClear deClear) {
			this.deClear = deClear==null?null:deClear.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventValuationModel")
		public RequestClearing.RequestClearingBuilder setEventValuationModel(EventValuationModel eventValuationModel) {
			this.eventValuationModel = eventValuationModel==null?null:eventValuationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestClearing.RequestClearingBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestClearing build() {
			return new RequestClearing.RequestClearingImpl(this);
		}
		
		@Override
		public RequestClearing.RequestClearingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestClearing.RequestClearingBuilder prune() {
			super.prune();
			if (portfolioReferenceModel!=null && !portfolioReferenceModel.prune().hasData()) portfolioReferenceModel = null;
			if (tradingEventsModel!=null && !tradingEventsModel.prune().hasData()) tradingEventsModel = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (eventValuationModel!=null && !eventValuationModel.prune().hasData()) eventValuationModel = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPortfolioReferenceModel()!=null && getPortfolioReferenceModel().hasData()) return true;
			if (getTradingEventsModel()!=null && getTradingEventsModel().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getEventValuationModel()!=null && getEventValuationModel().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestClearing.RequestClearingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestClearing.RequestClearingBuilder o = (RequestClearing.RequestClearingBuilder) other;
			
			merger.mergeRosetta(getPortfolioReferenceModel(), o.getPortfolioReferenceModel(), this::setPortfolioReferenceModel);
			merger.mergeRosetta(getTradingEventsModel(), o.getTradingEventsModel(), this::setTradingEventsModel);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getEventValuationModel(), o.getEventValuationModel(), this::setEventValuationModel);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestClearing _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReferenceModel, _that.getPortfolioReferenceModel())) return false;
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (portfolioReferenceModel != null ? portfolioReferenceModel.hashCode() : 0);
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestClearingBuilder {" +
				"portfolioReferenceModel=" + this.portfolioReferenceModel + ", " +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
