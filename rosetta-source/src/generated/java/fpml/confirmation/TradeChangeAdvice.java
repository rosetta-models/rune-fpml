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
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PaymentDetails;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradeChangeAdvice;
import fpml.confirmation.TradeChangeAdvice.TradeChangeAdviceBuilder;
import fpml.confirmation.TradeChangeAdvice.TradeChangeAdviceBuilderImpl;
import fpml.confirmation.TradeChangeAdvice.TradeChangeAdviceImpl;
import fpml.confirmation.TradeChangeContent;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.TradeChangeAdviceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the structure for a message indicating that a trade is being changed due to a non-negotiated event.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeChangeAdvice", builder=TradeChangeAdvice.TradeChangeAdviceBuilderImpl.class, version="${project.version}")
public interface TradeChangeAdvice extends CorrectableRequestMessage {

	TradeChangeAdviceMeta metaData = new TradeChangeAdviceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes the details of the change.
	 */
	TradeChangeContent getChange();
	EventValuationModel getEventValuationModel();
	/**
	 * Details of the payments, like amount breakdowns, settlement information.
	 */
	List<? extends PaymentDetails> getPaymentDetails();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	TradeChangeAdvice build();
	
	TradeChangeAdvice.TradeChangeAdviceBuilder toBuilder();
	
	static TradeChangeAdvice.TradeChangeAdviceBuilder builder() {
		return new TradeChangeAdvice.TradeChangeAdviceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeAdvice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeChangeAdvice> getType() {
		return TradeChangeAdvice.class;
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
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
		processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.class, getEventValuationModel());
		processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.class, getPaymentDetails());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeAdviceBuilder extends TradeChangeAdvice, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		TradeChangeContent.TradeChangeContentBuilder getOrCreateChange();
		TradeChangeContent.TradeChangeContentBuilder getChange();
		EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel();
		EventValuationModel.EventValuationModelBuilder getEventValuationModel();
		PaymentDetails.PaymentDetailsBuilder getOrCreatePaymentDetails(int _index);
		List<? extends PaymentDetails.PaymentDetailsBuilder> getPaymentDetails();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		TradeChangeAdvice.TradeChangeAdviceBuilder setExpectedBuild(Integer expectedBuild);
		TradeChangeAdvice.TradeChangeAdviceBuilder setActualBuild(Integer actualBuild);
		TradeChangeAdvice.TradeChangeAdviceBuilder setHeader(RequestMessageHeader header);
		TradeChangeAdvice.TradeChangeAdviceBuilder setValidationModel(ValidationModel validationModel);
		TradeChangeAdvice.TradeChangeAdviceBuilder setIsCorrection(Boolean isCorrection);
		TradeChangeAdvice.TradeChangeAdviceBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		TradeChangeAdvice.TradeChangeAdviceBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		TradeChangeAdvice.TradeChangeAdviceBuilder setChange(TradeChangeContent change);
		TradeChangeAdvice.TradeChangeAdviceBuilder setEventValuationModel(EventValuationModel eventValuationModel);
		TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails0);
		TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails1, int _idx);
		TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetails2);
		TradeChangeAdvice.TradeChangeAdviceBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetails3);
		TradeChangeAdvice.TradeChangeAdviceBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
			processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.EventValuationModelBuilder.class, getEventValuationModel());
			processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.PaymentDetailsBuilder.class, getPaymentDetails());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		TradeChangeAdvice.TradeChangeAdviceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeAdvice  ***********************/
	class TradeChangeAdviceImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements TradeChangeAdvice {
		private final TradeChangeContent change;
		private final EventValuationModel eventValuationModel;
		private final List<? extends PaymentDetails> paymentDetails;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected TradeChangeAdviceImpl(TradeChangeAdvice.TradeChangeAdviceBuilder builder) {
			super(builder);
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
			this.eventValuationModel = ofNullable(builder.getEventValuationModel()).map(f->f.build()).orElse(null);
			this.paymentDetails = ofNullable(builder.getPaymentDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("change")
		public TradeChangeContent getChange() {
			return change;
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
		public TradeChangeAdvice build() {
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder toBuilder() {
			TradeChangeAdvice.TradeChangeAdviceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeAdvice.TradeChangeAdviceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getChange()).ifPresent(builder::setChange);
			ofNullable(getEventValuationModel()).ifPresent(builder::setEventValuationModel);
			ofNullable(getPaymentDetails()).ifPresent(builder::setPaymentDetails);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeAdvice _that = getType().cast(o);
		
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdvice {" +
				"change=" + this.change + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeAdvice  ***********************/
	class TradeChangeAdviceBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements TradeChangeAdvice.TradeChangeAdviceBuilder {
	
		protected TradeChangeContent.TradeChangeContentBuilder change;
		protected EventValuationModel.EventValuationModelBuilder eventValuationModel;
		protected List<PaymentDetails.PaymentDetailsBuilder> paymentDetails = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public TradeChangeAdviceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("change")
		public TradeChangeContent.TradeChangeContentBuilder getChange() {
			return change;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder getOrCreateChange() {
			TradeChangeContent.TradeChangeContentBuilder result;
			if (change!=null) {
				result = change;
			}
			else {
				result = change = TradeChangeContent.builder();
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("change")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setChange(TradeChangeContent change) {
			this.change = change==null?null:change.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventValuationModel")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setEventValuationModel(EventValuationModel eventValuationModel) {
			this.eventValuationModel = eventValuationModel==null?null:eventValuationModel.toBuilder();
			return this;
		}
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails) {
			if (paymentDetails!=null) this.paymentDetails.add(paymentDetails.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails, int _idx) {
			getIndex(this.paymentDetails, _idx, () -> paymentDetails.toBuilder());
			return this;
		}
		@Override 
		public TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
			if (paymentDetailss != null) {
				for (PaymentDetails toAdd : paymentDetailss) {
					this.paymentDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("paymentDetails")
		public TradeChangeAdvice.TradeChangeAdviceBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeChangeAdvice build() {
			return new TradeChangeAdvice.TradeChangeAdviceImpl(this);
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder prune() {
			super.prune();
			if (change!=null && !change.prune().hasData()) change = null;
			if (eventValuationModel!=null && !eventValuationModel.prune().hasData()) eventValuationModel = null;
			paymentDetails = paymentDetails.stream().filter(b->b!=null).<PaymentDetails.PaymentDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getChange()!=null && getChange().hasData()) return true;
			if (getEventValuationModel()!=null && getEventValuationModel().hasData()) return true;
			if (getPaymentDetails()!=null && getPaymentDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeChangeAdvice.TradeChangeAdviceBuilder o = (TradeChangeAdvice.TradeChangeAdviceBuilder) other;
			
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
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
		
			TradeChangeAdvice _that = getType().cast(o);
		
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdviceBuilder {" +
				"change=" + this.change + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
