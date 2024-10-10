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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PaymentDetails;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradeChangeAdviceRetracted;
import fpml.confirmation.TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder;
import fpml.confirmation.TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilderImpl;
import fpml.confirmation.TradeChangeAdviceRetracted.TradeChangeAdviceRetractedImpl;
import fpml.confirmation.TradeChangeContent;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.TradeChangeAdviceRetractedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the structure for a message retracting a prior change advice.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeChangeAdviceRetracted", builder=TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilderImpl.class, version="${project.version}")
public interface TradeChangeAdviceRetracted extends NonCorrectableRequestMessage {

	TradeChangeAdviceRetractedMeta metaData = new TradeChangeAdviceRetractedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The qualified identifiers of the subject trade.
	 */
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	/**
	 * Describes the details of the change being retracted.
	 */
	TradeChangeContent getChange();
	/**
	 * Details of the payments, like amount breakdowns, settlement information.
	 */
	List<? extends PaymentDetails> getPaymentDetails();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	TradeChangeAdviceRetracted build();
	
	TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder toBuilder();
	
	static TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder() {
		return new TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeAdviceRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeChangeAdviceRetracted> getType() {
		return TradeChangeAdviceRetracted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
		processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.class, getPaymentDetails());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeAdviceRetractedBuilder extends TradeChangeAdviceRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		TradeChangeContent.TradeChangeContentBuilder getOrCreateChange();
		TradeChangeContent.TradeChangeContentBuilder getChange();
		PaymentDetails.PaymentDetailsBuilder getOrCreatePaymentDetails(int _index);
		List<? extends PaymentDetails.PaymentDetailsBuilder> getPaymentDetails();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setExpectedBuild(Integer expectedBuild);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setActualBuild(Integer actualBuild);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setHeader(RequestMessageHeader header);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setValidationModel(ValidationModel validationModel);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setChange(TradeChangeContent change);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails0);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails1, int _idx);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetails2);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetails3);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
			processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.PaymentDetailsBuilder.class, getPaymentDetails());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeAdviceRetracted  ***********************/
	class TradeChangeAdviceRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements TradeChangeAdviceRetracted {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final TradeChangeContent change;
		private final List<? extends PaymentDetails> paymentDetails;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected TradeChangeAdviceRetractedImpl(TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder) {
			super(builder);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
			this.paymentDetails = ofNullable(builder.getPaymentDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("change")
		public TradeChangeContent getChange() {
			return change;
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
		public TradeChangeAdviceRetracted build() {
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder toBuilder() {
			TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getChange()).ifPresent(builder::setChange);
			ofNullable(getPaymentDetails()).ifPresent(builder::setPaymentDetails);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeAdviceRetracted _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdviceRetracted {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"change=" + this.change + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeAdviceRetracted  ***********************/
	class TradeChangeAdviceRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected TradeChangeContent.TradeChangeContentBuilder change;
		protected List<PaymentDetails.PaymentDetailsBuilder> paymentDetails = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public TradeChangeAdviceRetractedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeIdentifier")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("change")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setChange(TradeChangeContent change) {
			this.change = change==null?null:change.toBuilder();
			return this;
		}
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails) {
			if (paymentDetails!=null) this.paymentDetails.add(paymentDetails.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails, int _idx) {
			getIndex(this.paymentDetails, _idx, () -> paymentDetails.toBuilder());
			return this;
		}
		@Override 
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
			if (paymentDetailss != null) {
				for (PaymentDetails toAdd : paymentDetailss) {
					this.paymentDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("paymentDetails")
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted build() {
			return new TradeChangeAdviceRetracted.TradeChangeAdviceRetractedImpl(this);
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder prune() {
			super.prune();
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (change!=null && !change.prune().hasData()) change = null;
			paymentDetails = paymentDetails.stream().filter(b->b!=null).<PaymentDetails.PaymentDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChange()!=null && getChange().hasData()) return true;
			if (getPaymentDetails()!=null && getPaymentDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder o = (TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
			merger.mergeRosetta(getPaymentDetails(), o.getPaymentDetails(), this::getOrCreatePaymentDetails);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeAdviceRetracted _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdviceRetractedBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"change=" + this.change + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
