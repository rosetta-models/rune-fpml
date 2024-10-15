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
import fpml.confirmation.CashflowId;
import fpml.confirmation.GrossCashflowSequence;
import fpml.confirmation.GrossCashflowSequence.GrossCashflowSequenceBuilder;
import fpml.confirmation.GrossCashflowSequence.GrossCashflowSequenceBuilderImpl;
import fpml.confirmation.GrossCashflowSequence.GrossCashflowSequenceImpl;
import fpml.confirmation.Money;
import fpml.confirmation.PartyTradeIdentifierReference;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.GrossCashflowSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GrossCashflowSequence", builder=GrossCashflowSequence.GrossCashflowSequenceBuilderImpl.class, version="${project.version}")
public interface GrossCashflowSequence extends RosettaModelObject {

	GrossCashflowSequenceMeta metaData = new GrossCashflowSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique identifier for a cash flow.
	 */
	CashflowId getCashflowId();
	/**
	 * Pointer-style reference to the partyTradeIdentifier block within the tradeIdentifyingItems collection, which identifies the parent trade for this cashflow.
	 */
	PartyTradeIdentifierReference getPartyTradeIdentifierReference();
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Cash flow amount in a given currency to be paid/received.
	 */
	Money getCashflowAmount();

	/*********************** Build Methods  ***********************/
	GrossCashflowSequence build();
	
	GrossCashflowSequence.GrossCashflowSequenceBuilder toBuilder();
	
	static GrossCashflowSequence.GrossCashflowSequenceBuilder builder() {
		return new GrossCashflowSequence.GrossCashflowSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GrossCashflowSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GrossCashflowSequence> getType() {
		return GrossCashflowSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashflowId"), processor, CashflowId.class, getCashflowId());
		processRosetta(path.newSubPath("partyTradeIdentifierReference"), processor, PartyTradeIdentifierReference.class, getPartyTradeIdentifierReference());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("cashflowAmount"), processor, Money.class, getCashflowAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GrossCashflowSequenceBuilder extends GrossCashflowSequence, RosettaModelObjectBuilder {
		CashflowId.CashflowIdBuilder getOrCreateCashflowId();
		CashflowId.CashflowIdBuilder getCashflowId();
		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreatePartyTradeIdentifierReference();
		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getPartyTradeIdentifierReference();
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		Money.MoneyBuilder getOrCreateCashflowAmount();
		Money.MoneyBuilder getCashflowAmount();
		GrossCashflowSequence.GrossCashflowSequenceBuilder setCashflowId(CashflowId cashflowId);
		GrossCashflowSequence.GrossCashflowSequenceBuilder setPartyTradeIdentifierReference(PartyTradeIdentifierReference partyTradeIdentifierReference);
		GrossCashflowSequence.GrossCashflowSequenceBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		GrossCashflowSequence.GrossCashflowSequenceBuilder setCashflowAmount(Money cashflowAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashflowId"), processor, CashflowId.CashflowIdBuilder.class, getCashflowId());
			processRosetta(path.newSubPath("partyTradeIdentifierReference"), processor, PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder.class, getPartyTradeIdentifierReference());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("cashflowAmount"), processor, Money.MoneyBuilder.class, getCashflowAmount());
		}
		

		GrossCashflowSequence.GrossCashflowSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of GrossCashflowSequence  ***********************/
	class GrossCashflowSequenceImpl implements GrossCashflowSequence {
		private final CashflowId cashflowId;
		private final PartyTradeIdentifierReference partyTradeIdentifierReference;
		private final PayerReceiverModel payerReceiverModel;
		private final Money cashflowAmount;
		
		protected GrossCashflowSequenceImpl(GrossCashflowSequence.GrossCashflowSequenceBuilder builder) {
			this.cashflowId = ofNullable(builder.getCashflowId()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifierReference = ofNullable(builder.getPartyTradeIdentifierReference()).map(f->f.build()).orElse(null);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.cashflowAmount = ofNullable(builder.getCashflowAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashflowId")
		public CashflowId getCashflowId() {
			return cashflowId;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifierReference")
		public PartyTradeIdentifierReference getPartyTradeIdentifierReference() {
			return partyTradeIdentifierReference;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("cashflowAmount")
		public Money getCashflowAmount() {
			return cashflowAmount;
		}
		
		@Override
		public GrossCashflowSequence build() {
			return this;
		}
		
		@Override
		public GrossCashflowSequence.GrossCashflowSequenceBuilder toBuilder() {
			GrossCashflowSequence.GrossCashflowSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GrossCashflowSequence.GrossCashflowSequenceBuilder builder) {
			ofNullable(getCashflowId()).ifPresent(builder::setCashflowId);
			ofNullable(getPartyTradeIdentifierReference()).ifPresent(builder::setPartyTradeIdentifierReference);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getCashflowAmount()).ifPresent(builder::setCashflowAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GrossCashflowSequence _that = getType().cast(o);
		
			if (!Objects.equals(cashflowId, _that.getCashflowId())) return false;
			if (!Objects.equals(partyTradeIdentifierReference, _that.getPartyTradeIdentifierReference())) return false;
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(cashflowAmount, _that.getCashflowAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowId != null ? cashflowId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifierReference != null ? partyTradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (cashflowAmount != null ? cashflowAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GrossCashflowSequence {" +
				"cashflowId=" + this.cashflowId + ", " +
				"partyTradeIdentifierReference=" + this.partyTradeIdentifierReference + ", " +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"cashflowAmount=" + this.cashflowAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of GrossCashflowSequence  ***********************/
	class GrossCashflowSequenceBuilderImpl implements GrossCashflowSequence.GrossCashflowSequenceBuilder {
	
		protected CashflowId.CashflowIdBuilder cashflowId;
		protected PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder partyTradeIdentifierReference;
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected Money.MoneyBuilder cashflowAmount;
	
		public GrossCashflowSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cashflowId")
		public CashflowId.CashflowIdBuilder getCashflowId() {
			return cashflowId;
		}
		
		@Override
		public CashflowId.CashflowIdBuilder getOrCreateCashflowId() {
			CashflowId.CashflowIdBuilder result;
			if (cashflowId!=null) {
				result = cashflowId;
			}
			else {
				result = cashflowId = CashflowId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifierReference")
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getPartyTradeIdentifierReference() {
			return partyTradeIdentifierReference;
		}
		
		@Override
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreatePartyTradeIdentifierReference() {
			PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder result;
			if (partyTradeIdentifierReference!=null) {
				result = partyTradeIdentifierReference;
			}
			else {
				result = partyTradeIdentifierReference = PartyTradeIdentifierReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflowAmount")
		public Money.MoneyBuilder getCashflowAmount() {
			return cashflowAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashflowAmount() {
			Money.MoneyBuilder result;
			if (cashflowAmount!=null) {
				result = cashflowAmount;
			}
			else {
				result = cashflowAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflowId")
		public GrossCashflowSequence.GrossCashflowSequenceBuilder setCashflowId(CashflowId cashflowId) {
			this.cashflowId = cashflowId==null?null:cashflowId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partyTradeIdentifierReference")
		public GrossCashflowSequence.GrossCashflowSequenceBuilder setPartyTradeIdentifierReference(PartyTradeIdentifierReference partyTradeIdentifierReference) {
			this.partyTradeIdentifierReference = partyTradeIdentifierReference==null?null:partyTradeIdentifierReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public GrossCashflowSequence.GrossCashflowSequenceBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashflowAmount")
		public GrossCashflowSequence.GrossCashflowSequenceBuilder setCashflowAmount(Money cashflowAmount) {
			this.cashflowAmount = cashflowAmount==null?null:cashflowAmount.toBuilder();
			return this;
		}
		
		@Override
		public GrossCashflowSequence build() {
			return new GrossCashflowSequence.GrossCashflowSequenceImpl(this);
		}
		
		@Override
		public GrossCashflowSequence.GrossCashflowSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GrossCashflowSequence.GrossCashflowSequenceBuilder prune() {
			if (cashflowId!=null && !cashflowId.prune().hasData()) cashflowId = null;
			if (partyTradeIdentifierReference!=null && !partyTradeIdentifierReference.prune().hasData()) partyTradeIdentifierReference = null;
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (cashflowAmount!=null && !cashflowAmount.prune().hasData()) cashflowAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashflowId()!=null && getCashflowId().hasData()) return true;
			if (getPartyTradeIdentifierReference()!=null && getPartyTradeIdentifierReference().hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getCashflowAmount()!=null && getCashflowAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GrossCashflowSequence.GrossCashflowSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GrossCashflowSequence.GrossCashflowSequenceBuilder o = (GrossCashflowSequence.GrossCashflowSequenceBuilder) other;
			
			merger.mergeRosetta(getCashflowId(), o.getCashflowId(), this::setCashflowId);
			merger.mergeRosetta(getPartyTradeIdentifierReference(), o.getPartyTradeIdentifierReference(), this::setPartyTradeIdentifierReference);
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getCashflowAmount(), o.getCashflowAmount(), this::setCashflowAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GrossCashflowSequence _that = getType().cast(o);
		
			if (!Objects.equals(cashflowId, _that.getCashflowId())) return false;
			if (!Objects.equals(partyTradeIdentifierReference, _that.getPartyTradeIdentifierReference())) return false;
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(cashflowAmount, _that.getCashflowAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowId != null ? cashflowId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifierReference != null ? partyTradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (cashflowAmount != null ? cashflowAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GrossCashflowSequenceBuilder {" +
				"cashflowId=" + this.cashflowId + ", " +
				"partyTradeIdentifierReference=" + this.partyTradeIdentifierReference + ", " +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"cashflowAmount=" + this.cashflowAmount +
			'}';
		}
	}
}
