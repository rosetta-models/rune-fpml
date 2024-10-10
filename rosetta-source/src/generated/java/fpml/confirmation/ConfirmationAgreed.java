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
import fpml.confirmation.ConfirmationAgreed;
import fpml.confirmation.ConfirmationAgreed.ConfirmationAgreedBuilder;
import fpml.confirmation.ConfirmationAgreed.ConfirmationAgreedBuilderImpl;
import fpml.confirmation.ConfirmationAgreed.ConfirmationAgreedImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ConfirmationAgreedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The confirmationAgreed message is sent when the matching process returns a proposed match (trade or event) and the Confirmation Requester agrees with it. A message indicating that a confirmation has been agreed by a counterparty.
 * @version ${project.version}
 */
@RosettaDataType(value="ConfirmationAgreed", builder=ConfirmationAgreed.ConfirmationAgreedBuilderImpl.class, version="${project.version}")
public interface ConfirmationAgreed extends ResponseMessage {

	ConfirmationAgreedMeta metaData = new ConfirmationAgreedMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsBaseModel getTradingEventsBaseModel();
	PostTradeEventsBaseModel getPostTradeEventsBaseModel();
	ChangeEventsBaseModel getChangeEventsBaseModel();
	OptionsEventsBaseModel getOptionsEventsBaseModel();
	AdditionalEvent getAdditionalEvent();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ConfirmationAgreed build();
	
	ConfirmationAgreed.ConfirmationAgreedBuilder toBuilder();
	
	static ConfirmationAgreed.ConfirmationAgreedBuilder builder() {
		return new ConfirmationAgreed.ConfirmationAgreedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationAgreed> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConfirmationAgreed> getType() {
		return ConfirmationAgreed.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.class, getTradingEventsBaseModel());
		processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.class, getPostTradeEventsBaseModel());
		processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.class, getChangeEventsBaseModel());
		processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.class, getOptionsEventsBaseModel());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConfirmationAgreedBuilder extends ConfirmationAgreed, ResponseMessage.ResponseMessageBuilder {
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
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ConfirmationAgreed.ConfirmationAgreedBuilder setExpectedBuild(Integer expectedBuild);
		ConfirmationAgreed.ConfirmationAgreedBuilder setActualBuild(Integer actualBuild);
		ConfirmationAgreed.ConfirmationAgreedBuilder setHeader(ResponseMessageHeader header);
		ConfirmationAgreed.ConfirmationAgreedBuilder setValidationModel(ValidationModel validationModel);
		ConfirmationAgreed.ConfirmationAgreedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ConfirmationAgreed.ConfirmationAgreedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ConfirmationAgreed.ConfirmationAgreedBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel);
		ConfirmationAgreed.ConfirmationAgreedBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel);
		ConfirmationAgreed.ConfirmationAgreedBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel);
		ConfirmationAgreed.ConfirmationAgreedBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel);
		ConfirmationAgreed.ConfirmationAgreedBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		ConfirmationAgreed.ConfirmationAgreedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.TradingEventsBaseModelBuilder.class, getTradingEventsBaseModel());
			processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder.class, getPostTradeEventsBaseModel());
			processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.ChangeEventsBaseModelBuilder.class, getChangeEventsBaseModel());
			processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.OptionsEventsBaseModelBuilder.class, getOptionsEventsBaseModel());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ConfirmationAgreed.ConfirmationAgreedBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationAgreed  ***********************/
	class ConfirmationAgreedImpl extends ResponseMessage.ResponseMessageImpl implements ConfirmationAgreed {
		private final TradingEventsBaseModel tradingEventsBaseModel;
		private final PostTradeEventsBaseModel postTradeEventsBaseModel;
		private final ChangeEventsBaseModel changeEventsBaseModel;
		private final OptionsEventsBaseModel optionsEventsBaseModel;
		private final AdditionalEvent additionalEvent;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ConfirmationAgreedImpl(ConfirmationAgreed.ConfirmationAgreedBuilder builder) {
			super(builder);
			this.tradingEventsBaseModel = ofNullable(builder.getTradingEventsBaseModel()).map(f->f.build()).orElse(null);
			this.postTradeEventsBaseModel = ofNullable(builder.getPostTradeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.changeEventsBaseModel = ofNullable(builder.getChangeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.optionsEventsBaseModel = ofNullable(builder.getOptionsEventsBaseModel()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ConfirmationAgreed build() {
			return this;
		}
		
		@Override
		public ConfirmationAgreed.ConfirmationAgreedBuilder toBuilder() {
			ConfirmationAgreed.ConfirmationAgreedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationAgreed.ConfirmationAgreedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradingEventsBaseModel()).ifPresent(builder::setTradingEventsBaseModel);
			ofNullable(getPostTradeEventsBaseModel()).ifPresent(builder::setPostTradeEventsBaseModel);
			ofNullable(getChangeEventsBaseModel()).ifPresent(builder::setChangeEventsBaseModel);
			ofNullable(getOptionsEventsBaseModel()).ifPresent(builder::setOptionsEventsBaseModel);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationAgreed _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (changeEventsBaseModel != null ? changeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (optionsEventsBaseModel != null ? optionsEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationAgreed {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConfirmationAgreed  ***********************/
	class ConfirmationAgreedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements ConfirmationAgreed.ConfirmationAgreedBuilder {
	
		protected TradingEventsBaseModel.TradingEventsBaseModelBuilder tradingEventsBaseModel;
		protected PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder postTradeEventsBaseModel;
		protected ChangeEventsBaseModel.ChangeEventsBaseModelBuilder changeEventsBaseModel;
		protected OptionsEventsBaseModel.OptionsEventsBaseModelBuilder optionsEventsBaseModel;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ConfirmationAgreedBuilderImpl() {
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
		public ConfirmationAgreed.ConfirmationAgreedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel) {
			this.tradingEventsBaseModel = tradingEventsBaseModel==null?null:tradingEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("postTradeEventsBaseModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel) {
			this.postTradeEventsBaseModel = postTradeEventsBaseModel==null?null:postTradeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeEventsBaseModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel) {
			this.changeEventsBaseModel = changeEventsBaseModel==null?null:changeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionsEventsBaseModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel) {
			this.optionsEventsBaseModel = optionsEventsBaseModel==null?null:optionsEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalEvent")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setAdditionalEvent(AdditionalEvent additionalEvent) {
			this.additionalEvent = additionalEvent==null?null:additionalEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ConfirmationAgreed.ConfirmationAgreedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ConfirmationAgreed build() {
			return new ConfirmationAgreed.ConfirmationAgreedImpl(this);
		}
		
		@Override
		public ConfirmationAgreed.ConfirmationAgreedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationAgreed.ConfirmationAgreedBuilder prune() {
			super.prune();
			if (tradingEventsBaseModel!=null && !tradingEventsBaseModel.prune().hasData()) tradingEventsBaseModel = null;
			if (postTradeEventsBaseModel!=null && !postTradeEventsBaseModel.prune().hasData()) postTradeEventsBaseModel = null;
			if (changeEventsBaseModel!=null && !changeEventsBaseModel.prune().hasData()) changeEventsBaseModel = null;
			if (optionsEventsBaseModel!=null && !optionsEventsBaseModel.prune().hasData()) optionsEventsBaseModel = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradingEventsBaseModel()!=null && getTradingEventsBaseModel().hasData()) return true;
			if (getPostTradeEventsBaseModel()!=null && getPostTradeEventsBaseModel().hasData()) return true;
			if (getChangeEventsBaseModel()!=null && getChangeEventsBaseModel().hasData()) return true;
			if (getOptionsEventsBaseModel()!=null && getOptionsEventsBaseModel().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationAgreed.ConfirmationAgreedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConfirmationAgreed.ConfirmationAgreedBuilder o = (ConfirmationAgreed.ConfirmationAgreedBuilder) other;
			
			merger.mergeRosetta(getTradingEventsBaseModel(), o.getTradingEventsBaseModel(), this::setTradingEventsBaseModel);
			merger.mergeRosetta(getPostTradeEventsBaseModel(), o.getPostTradeEventsBaseModel(), this::setPostTradeEventsBaseModel);
			merger.mergeRosetta(getChangeEventsBaseModel(), o.getChangeEventsBaseModel(), this::setChangeEventsBaseModel);
			merger.mergeRosetta(getOptionsEventsBaseModel(), o.getOptionsEventsBaseModel(), this::setOptionsEventsBaseModel);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationAgreed _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (changeEventsBaseModel != null ? changeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (optionsEventsBaseModel != null ? optionsEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationAgreedBuilder {" +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
