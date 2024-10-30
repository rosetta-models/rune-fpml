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
import fpml.confirmation.ApprovalStatusNotification;
import fpml.confirmation.ApprovalStatusNotification.ApprovalStatusNotificationBuilder;
import fpml.confirmation.ApprovalStatusNotification.ApprovalStatusNotificationBuilderImpl;
import fpml.confirmation.ApprovalStatusNotification.ApprovalStatusNotificationImpl;
import fpml.confirmation.Approvals;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.NotificationMessage;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilder;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilderImpl;
import fpml.confirmation.NotificationMessage.NotificationMessageImpl;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ApprovalStatusNotificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message describing the approvals currently applied to the trade and their status (e.g. pending, approved, refused).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ApprovalStatusNotification", builder=ApprovalStatusNotification.ApprovalStatusNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ApprovalStatusNotification extends NotificationMessage {

	ApprovalStatusNotificationMeta metaData = new ApprovalStatusNotificationMeta();

	/*********************** Getter Methods  ***********************/
	Trade getTrade();
	TradeIdentifier getTradeIdentifier();
	/**
	 * All of the approvals for a specific trade.
	 */
	Approvals getApprovals();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ApprovalStatusNotification build();
	
	ApprovalStatusNotification.ApprovalStatusNotificationBuilder toBuilder();
	
	static ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder() {
		return new ApprovalStatusNotification.ApprovalStatusNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalStatusNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ApprovalStatusNotification> getType() {
		return ApprovalStatusNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalStatusNotificationBuilder extends ApprovalStatusNotification, NotificationMessage.NotificationMessageBuilder {
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		Approvals.ApprovalsBuilder getApprovals();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setExpectedBuild(Integer expectedBuild);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setActualBuild(Integer actualBuild);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setHeader(NotificationMessageHeader header);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setValidationModel(ValidationModel validationModel);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTrade(Trade trade);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setApprovals(Approvals approvals);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ApprovalStatusNotification.ApprovalStatusNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalStatusNotification  ***********************/
	class ApprovalStatusNotificationImpl extends NotificationMessage.NotificationMessageImpl implements ApprovalStatusNotification {
		private final Trade trade;
		private final TradeIdentifier tradeIdentifier;
		private final Approvals approvals;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ApprovalStatusNotificationImpl(ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder) {
			super(builder);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ApprovalStatusNotification build() {
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder toBuilder() {
			ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApprovalStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalStatusNotification {" +
				"trade=" + this.trade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ApprovalStatusNotification  ***********************/
	class ApprovalStatusNotificationBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl  implements ApprovalStatusNotification.ApprovalStatusNotificationBuilder {
	
		protected Trade.TradeBuilder trade;
		protected TradeIdentifier.TradeIdentifierBuilder tradeIdentifier;
		protected Approvals.ApprovalsBuilder approvals;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ApprovalStatusNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setHeader(NotificationMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifier")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier) {
			this.tradeIdentifier = tradeIdentifier==null?null:tradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvals")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setApprovals(Approvals approvals) {
			this.approvals = approvals==null?null:approvals.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ApprovalStatusNotification build() {
			return new ApprovalStatusNotification.ApprovalStatusNotificationImpl(this);
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder prune() {
			super.prune();
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ApprovalStatusNotification.ApprovalStatusNotificationBuilder o = (ApprovalStatusNotification.ApprovalStatusNotificationBuilder) other;
			
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApprovalStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalStatusNotificationBuilder {" +
				"trade=" + this.trade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
