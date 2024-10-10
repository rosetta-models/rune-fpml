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
import fpml.confirmation.AdditionalEvent;
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.ExecutionAdvice;
import fpml.confirmation.ExecutionAdvice.ExecutionAdviceBuilder;
import fpml.confirmation.ExecutionAdvice.ExecutionAdviceBuilderImpl;
import fpml.confirmation.ExecutionAdvice.ExecutionAdviceImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PaymentDetails;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.ProductType;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ExecutionAdviceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message advising a third party that a trade execution has occurred.
 * @version ${project.version}
 */
@RosettaDataType(value="ExecutionAdvice", builder=ExecutionAdvice.ExecutionAdviceBuilderImpl.class, version="${project.version}")
public interface ExecutionAdvice extends CorrectableRequestMessage {

	ExecutionAdviceMeta metaData = new ExecutionAdviceMeta();

	/*********************** Getter Methods  ***********************/
	ProductType getProductType();
	TradingEventsBaseModel getTradingEventsBaseModel();
	PostTradeEventsBaseModel getPostTradeEventsBaseModel();
	ChangeEventsBaseModel getChangeEventsBaseModel();
	OptionsEventsBaseModel getOptionsEventsBaseModel();
	AdditionalEvent getAdditionalEvent();
	EventValuationModel getEventValuationModel();
	/**
	 * Details of the payments, like amount breakdowns, settlement information.
	 */
	List<? extends PaymentDetails> getPaymentDetails();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ExecutionAdvice build();
	
	ExecutionAdvice.ExecutionAdviceBuilder toBuilder();
	
	static ExecutionAdvice.ExecutionAdviceBuilder builder() {
		return new ExecutionAdvice.ExecutionAdviceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionAdvice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionAdvice> getType() {
		return ExecutionAdvice.class;
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
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.class, getTradingEventsBaseModel());
		processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.class, getPostTradeEventsBaseModel());
		processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.class, getChangeEventsBaseModel());
		processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.class, getOptionsEventsBaseModel());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.class, getEventValuationModel());
		processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.class, getPaymentDetails());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionAdviceBuilder extends ExecutionAdvice, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		ProductType.ProductTypeBuilder getOrCreateProductType();
		ProductType.ProductTypeBuilder getProductType();
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
		EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel();
		EventValuationModel.EventValuationModelBuilder getEventValuationModel();
		PaymentDetails.PaymentDetailsBuilder getOrCreatePaymentDetails(int _index);
		List<? extends PaymentDetails.PaymentDetailsBuilder> getPaymentDetails();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ExecutionAdvice.ExecutionAdviceBuilder setExpectedBuild(Integer expectedBuild);
		ExecutionAdvice.ExecutionAdviceBuilder setActualBuild(Integer actualBuild);
		ExecutionAdvice.ExecutionAdviceBuilder setHeader(RequestMessageHeader header);
		ExecutionAdvice.ExecutionAdviceBuilder setValidationModel(ValidationModel validationModel);
		ExecutionAdvice.ExecutionAdviceBuilder setIsCorrection(Boolean isCorrection);
		ExecutionAdvice.ExecutionAdviceBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		ExecutionAdvice.ExecutionAdviceBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ExecutionAdvice.ExecutionAdviceBuilder setProductType(ProductType productType);
		ExecutionAdvice.ExecutionAdviceBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel);
		ExecutionAdvice.ExecutionAdviceBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel);
		ExecutionAdvice.ExecutionAdviceBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel);
		ExecutionAdvice.ExecutionAdviceBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel);
		ExecutionAdvice.ExecutionAdviceBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		ExecutionAdvice.ExecutionAdviceBuilder setEventValuationModel(EventValuationModel eventValuationModel);
		ExecutionAdvice.ExecutionAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails0);
		ExecutionAdvice.ExecutionAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails1, int _idx);
		ExecutionAdvice.ExecutionAdviceBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetails2);
		ExecutionAdvice.ExecutionAdviceBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetails3);
		ExecutionAdvice.ExecutionAdviceBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("tradingEventsBaseModel"), processor, TradingEventsBaseModel.TradingEventsBaseModelBuilder.class, getTradingEventsBaseModel());
			processRosetta(path.newSubPath("postTradeEventsBaseModel"), processor, PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder.class, getPostTradeEventsBaseModel());
			processRosetta(path.newSubPath("changeEventsBaseModel"), processor, ChangeEventsBaseModel.ChangeEventsBaseModelBuilder.class, getChangeEventsBaseModel());
			processRosetta(path.newSubPath("optionsEventsBaseModel"), processor, OptionsEventsBaseModel.OptionsEventsBaseModelBuilder.class, getOptionsEventsBaseModel());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.EventValuationModelBuilder.class, getEventValuationModel());
			processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.PaymentDetailsBuilder.class, getPaymentDetails());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ExecutionAdvice.ExecutionAdviceBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionAdvice  ***********************/
	class ExecutionAdviceImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements ExecutionAdvice {
		private final ProductType productType;
		private final TradingEventsBaseModel tradingEventsBaseModel;
		private final PostTradeEventsBaseModel postTradeEventsBaseModel;
		private final ChangeEventsBaseModel changeEventsBaseModel;
		private final OptionsEventsBaseModel optionsEventsBaseModel;
		private final AdditionalEvent additionalEvent;
		private final EventValuationModel eventValuationModel;
		private final List<? extends PaymentDetails> paymentDetails;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ExecutionAdviceImpl(ExecutionAdvice.ExecutionAdviceBuilder builder) {
			super(builder);
			this.productType = ofNullable(builder.getProductType()).map(f->f.build()).orElse(null);
			this.tradingEventsBaseModel = ofNullable(builder.getTradingEventsBaseModel()).map(f->f.build()).orElse(null);
			this.postTradeEventsBaseModel = ofNullable(builder.getPostTradeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.changeEventsBaseModel = ofNullable(builder.getChangeEventsBaseModel()).map(f->f.build()).orElse(null);
			this.optionsEventsBaseModel = ofNullable(builder.getOptionsEventsBaseModel()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.eventValuationModel = ofNullable(builder.getEventValuationModel()).map(f->f.build()).orElse(null);
			this.paymentDetails = ofNullable(builder.getPaymentDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("productType")
		public ProductType getProductType() {
			return productType;
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
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		@RosettaAttribute("paymentDetails")
		public List<? extends PaymentDetails> getPaymentDetails() {
			return paymentDetails;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ExecutionAdvice build() {
			return this;
		}
		
		@Override
		public ExecutionAdvice.ExecutionAdviceBuilder toBuilder() {
			ExecutionAdvice.ExecutionAdviceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionAdvice.ExecutionAdviceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getTradingEventsBaseModel()).ifPresent(builder::setTradingEventsBaseModel);
			ofNullable(getPostTradeEventsBaseModel()).ifPresent(builder::setPostTradeEventsBaseModel);
			ofNullable(getChangeEventsBaseModel()).ifPresent(builder::setChangeEventsBaseModel);
			ofNullable(getOptionsEventsBaseModel()).ifPresent(builder::setOptionsEventsBaseModel);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getEventValuationModel()).ifPresent(builder::setEventValuationModel);
			ofNullable(getPaymentDetails()).ifPresent(builder::setPaymentDetails);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExecutionAdvice _that = getType().cast(o);
		
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (changeEventsBaseModel != null ? changeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (optionsEventsBaseModel != null ? optionsEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAdvice {" +
				"productType=" + this.productType + ", " +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExecutionAdvice  ***********************/
	class ExecutionAdviceBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements ExecutionAdvice.ExecutionAdviceBuilder {
	
		protected ProductType.ProductTypeBuilder productType;
		protected TradingEventsBaseModel.TradingEventsBaseModelBuilder tradingEventsBaseModel;
		protected PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder postTradeEventsBaseModel;
		protected ChangeEventsBaseModel.ChangeEventsBaseModelBuilder changeEventsBaseModel;
		protected OptionsEventsBaseModel.OptionsEventsBaseModelBuilder optionsEventsBaseModel;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected EventValuationModel.EventValuationModelBuilder eventValuationModel;
		protected List<PaymentDetails.PaymentDetailsBuilder> paymentDetails = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ExecutionAdviceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("productType")
		public ProductType.ProductTypeBuilder getProductType() {
			return productType;
		}
		
		@Override
		public ProductType.ProductTypeBuilder getOrCreateProductType() {
			ProductType.ProductTypeBuilder result;
			if (productType!=null) {
				result = productType;
			}
			else {
				result = productType = ProductType.builder();
			}
			
			return result;
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
		@RosettaAttribute("paymentDetails")
		public List<? extends PaymentDetails.PaymentDetailsBuilder> getPaymentDetails() {
			return paymentDetails;
		}
		
		public PaymentDetails.PaymentDetailsBuilder getOrCreatePaymentDetails(int _index) {
		
			if (paymentDetails==null) {
				this.paymentDetails = new ArrayList<>();
			}
			PaymentDetails.PaymentDetailsBuilder result;
			return getIndex(paymentDetails, _index, () -> {
						PaymentDetails.PaymentDetailsBuilder newPaymentDetails = PaymentDetails.builder();
						return newPaymentDetails;
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
		public ExecutionAdvice.ExecutionAdviceBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ExecutionAdvice.ExecutionAdviceBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ExecutionAdvice.ExecutionAdviceBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public ExecutionAdvice.ExecutionAdviceBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("productType")
		public ExecutionAdvice.ExecutionAdviceBuilder setProductType(ProductType productType) {
			this.productType = productType==null?null:productType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsBaseModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setTradingEventsBaseModel(TradingEventsBaseModel tradingEventsBaseModel) {
			this.tradingEventsBaseModel = tradingEventsBaseModel==null?null:tradingEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("postTradeEventsBaseModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setPostTradeEventsBaseModel(PostTradeEventsBaseModel postTradeEventsBaseModel) {
			this.postTradeEventsBaseModel = postTradeEventsBaseModel==null?null:postTradeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeEventsBaseModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setChangeEventsBaseModel(ChangeEventsBaseModel changeEventsBaseModel) {
			this.changeEventsBaseModel = changeEventsBaseModel==null?null:changeEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionsEventsBaseModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setOptionsEventsBaseModel(OptionsEventsBaseModel optionsEventsBaseModel) {
			this.optionsEventsBaseModel = optionsEventsBaseModel==null?null:optionsEventsBaseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalEvent")
		public ExecutionAdvice.ExecutionAdviceBuilder setAdditionalEvent(AdditionalEvent additionalEvent) {
			this.additionalEvent = additionalEvent==null?null:additionalEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventValuationModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setEventValuationModel(EventValuationModel eventValuationModel) {
			this.eventValuationModel = eventValuationModel==null?null:eventValuationModel.toBuilder();
			return this;
		}
		@Override
		public ExecutionAdvice.ExecutionAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails) {
			if (paymentDetails!=null) this.paymentDetails.add(paymentDetails.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdvice.ExecutionAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails, int _idx) {
			getIndex(this.paymentDetails, _idx, () -> paymentDetails.toBuilder());
			return this;
		}
		@Override 
		public ExecutionAdvice.ExecutionAdviceBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
			if (paymentDetailss != null) {
				for (PaymentDetails toAdd : paymentDetailss) {
					this.paymentDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("paymentDetails")
		public ExecutionAdvice.ExecutionAdviceBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
			if (paymentDetailss == null)  {
				this.paymentDetails = new ArrayList<>();
			}
			else {
				this.paymentDetails = paymentDetailss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ExecutionAdvice.ExecutionAdviceBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionAdvice build() {
			return new ExecutionAdvice.ExecutionAdviceImpl(this);
		}
		
		@Override
		public ExecutionAdvice.ExecutionAdviceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAdvice.ExecutionAdviceBuilder prune() {
			super.prune();
			if (productType!=null && !productType.prune().hasData()) productType = null;
			if (tradingEventsBaseModel!=null && !tradingEventsBaseModel.prune().hasData()) tradingEventsBaseModel = null;
			if (postTradeEventsBaseModel!=null && !postTradeEventsBaseModel.prune().hasData()) postTradeEventsBaseModel = null;
			if (changeEventsBaseModel!=null && !changeEventsBaseModel.prune().hasData()) changeEventsBaseModel = null;
			if (optionsEventsBaseModel!=null && !optionsEventsBaseModel.prune().hasData()) optionsEventsBaseModel = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			if (eventValuationModel!=null && !eventValuationModel.prune().hasData()) eventValuationModel = null;
			paymentDetails = paymentDetails.stream().filter(b->b!=null).<PaymentDetails.PaymentDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getProductType()!=null && getProductType().hasData()) return true;
			if (getTradingEventsBaseModel()!=null && getTradingEventsBaseModel().hasData()) return true;
			if (getPostTradeEventsBaseModel()!=null && getPostTradeEventsBaseModel().hasData()) return true;
			if (getChangeEventsBaseModel()!=null && getChangeEventsBaseModel().hasData()) return true;
			if (getOptionsEventsBaseModel()!=null && getOptionsEventsBaseModel().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getEventValuationModel()!=null && getEventValuationModel().hasData()) return true;
			if (getPaymentDetails()!=null && getPaymentDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAdvice.ExecutionAdviceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExecutionAdvice.ExecutionAdviceBuilder o = (ExecutionAdvice.ExecutionAdviceBuilder) other;
			
			merger.mergeRosetta(getProductType(), o.getProductType(), this::setProductType);
			merger.mergeRosetta(getTradingEventsBaseModel(), o.getTradingEventsBaseModel(), this::setTradingEventsBaseModel);
			merger.mergeRosetta(getPostTradeEventsBaseModel(), o.getPostTradeEventsBaseModel(), this::setPostTradeEventsBaseModel);
			merger.mergeRosetta(getChangeEventsBaseModel(), o.getChangeEventsBaseModel(), this::setChangeEventsBaseModel);
			merger.mergeRosetta(getOptionsEventsBaseModel(), o.getOptionsEventsBaseModel(), this::setOptionsEventsBaseModel);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getEventValuationModel(), o.getEventValuationModel(), this::setEventValuationModel);
			merger.mergeRosetta(getPaymentDetails(), o.getPaymentDetails(), this::getOrCreatePaymentDetails);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExecutionAdvice _that = getType().cast(o);
		
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(tradingEventsBaseModel, _that.getTradingEventsBaseModel())) return false;
			if (!Objects.equals(postTradeEventsBaseModel, _that.getPostTradeEventsBaseModel())) return false;
			if (!Objects.equals(changeEventsBaseModel, _that.getChangeEventsBaseModel())) return false;
			if (!Objects.equals(optionsEventsBaseModel, _that.getOptionsEventsBaseModel())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (tradingEventsBaseModel != null ? tradingEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModel != null ? postTradeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (changeEventsBaseModel != null ? changeEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (optionsEventsBaseModel != null ? optionsEventsBaseModel.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAdviceBuilder {" +
				"productType=" + this.productType + ", " +
				"tradingEventsBaseModel=" + this.tradingEventsBaseModel + ", " +
				"postTradeEventsBaseModel=" + this.postTradeEventsBaseModel + ", " +
				"changeEventsBaseModel=" + this.changeEventsBaseModel + ", " +
				"optionsEventsBaseModel=" + this.optionsEventsBaseModel + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
