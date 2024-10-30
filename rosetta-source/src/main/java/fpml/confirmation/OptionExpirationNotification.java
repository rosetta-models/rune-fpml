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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.ExecutionNotification;
import fpml.confirmation.ExecutionNotification.ExecutionNotificationBuilder;
import fpml.confirmation.ExecutionNotification.ExecutionNotificationBuilderImpl;
import fpml.confirmation.ExecutionNotification.ExecutionNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionExpirationNotification;
import fpml.confirmation.OptionExpirationNotification.OptionExpirationNotificationBuilder;
import fpml.confirmation.OptionExpirationNotification.OptionExpirationNotificationBuilderImpl;
import fpml.confirmation.OptionExpirationNotification.OptionExpirationNotificationImpl;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradeAmendmentContent;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.OptionExpirationNotificationMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionExpirationNotification", builder=OptionExpirationNotification.OptionExpirationNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionExpirationNotification extends ExecutionNotification {

	OptionExpirationNotificationMeta metaData = new OptionExpirationNotificationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	OptionExpirationNotification build();
	
	OptionExpirationNotification.OptionExpirationNotificationBuilder toBuilder();
	
	static OptionExpirationNotification.OptionExpirationNotificationBuilder builder() {
		return new OptionExpirationNotification.OptionExpirationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExpirationNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExpirationNotification> getType() {
		return OptionExpirationNotification.class;
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
		processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.class, getTradingEventsBaseModel());
		processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.class, getAmendment());
		processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.class, getOptionsEventsBaseModel());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.class, getEventValuationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExpirationNotificationBuilder extends OptionExpirationNotification, ExecutionNotification.ExecutionNotificationBuilder {
		OptionExpirationNotification.OptionExpirationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setActualBuild(Integer actualBuild);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setHeader(RequestMessageHeader header);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setValidationModel(ValidationModel validationModel);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setIsCorrection(Boolean isCorrection);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setAmendment(TradeAmendmentContent amendment);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setEventValuationModel(EventValuationModel eventValuationModel);
		OptionExpirationNotification.OptionExpirationNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.TradingEventsBaseModelBuilder.class, getTradingEventsBaseModel());
			processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.TradeAmendmentContentBuilder.class, getAmendment());
			processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.OptionsEventsBaseModelBuilder.class, getOptionsEventsBaseModel());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.EventValuationModelBuilder.class, getEventValuationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		OptionExpirationNotification.OptionExpirationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExpirationNotification  ***********************/
	class OptionExpirationNotificationImpl extends ExecutionNotification.ExecutionNotificationImpl implements OptionExpirationNotification {
		
		protected OptionExpirationNotificationImpl(OptionExpirationNotification.OptionExpirationNotificationBuilder builder) {
			super(builder);
		}
		
		@Override
		public OptionExpirationNotification build() {
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder toBuilder() {
			OptionExpirationNotification.OptionExpirationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExpirationNotification.OptionExpirationNotificationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpirationNotification {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionExpirationNotification  ***********************/
	class OptionExpirationNotificationBuilderImpl extends ExecutionNotification.ExecutionNotificationBuilderImpl  implements OptionExpirationNotification.OptionExpirationNotificationBuilder {
	
	
		public OptionExpirationNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel) {
			this.tradingEventsBaseModel = tradingEventsBaseModel==null?null:tradingEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amendment")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setAmendment(TradeAmendmentContent amendment) {
			this.amendment = amendment==null?null:amendment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionsEventsBaseModel")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel) {
			this.optionsEventsBaseModel = optionsEventsBaseModel==null?null:optionsEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalEvent")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setAdditionalEvent(AdditionalEvent additionalEvent) {
			this.additionalEvent = additionalEvent==null?null:additionalEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventValuationModel")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setEventValuationModel(EventValuationModel eventValuationModel) {
			this.eventValuationModel = eventValuationModel==null?null:eventValuationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public OptionExpirationNotification build() {
			return new OptionExpirationNotification.OptionExpirationNotificationImpl(this);
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionExpirationNotification.OptionExpirationNotificationBuilder o = (OptionExpirationNotification.OptionExpirationNotificationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpirationNotificationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
