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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxOptionPremium.FxOptionPremiumBuilder;
import fpml.confirmation.FxOptionPremium.FxOptionPremiumBuilderImpl;
import fpml.confirmation.FxOptionPremium.FxOptionPremiumImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilder;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilderImpl;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PremiumQuote;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.FxOptionPremiumMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that specifies the premium exchanged for a single option trade or option strategy.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxOptionPremium", builder=FxOptionPremium.FxOptionPremiumBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxOptionPremium extends NonNegativePayment {

	FxOptionPremiumMeta metaData = new FxOptionPremiumMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The information required to settle a currency payment that results from a trade.
	 */
	SettlementInformation getSettlementInformation();
	/**
	 * This is the option premium as quoted. It is expected to be consistent with the premiumAmount and is for information only.
	 */
	PremiumQuote getQuote();

	/*********************** Build Methods  ***********************/
	FxOptionPremium build();
	
	FxOptionPremium.FxOptionPremiumBuilder toBuilder();
	
	static FxOptionPremium.FxOptionPremiumBuilder builder() {
		return new FxOptionPremium.FxOptionPremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionPremium> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxOptionPremium> getType() {
		return FxOptionPremium.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
		processRosetta(path.newSubPath("quote"), processor, PremiumQuote.class, getQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionPremiumBuilder extends FxOptionPremium, NonNegativePayment.NonNegativePaymentBuilder {
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		PremiumQuote.PremiumQuoteBuilder getOrCreateQuote();
		PremiumQuote.PremiumQuoteBuilder getQuote();
		FxOptionPremium.FxOptionPremiumBuilder setId(String id);
		FxOptionPremium.FxOptionPremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FxOptionPremium.FxOptionPremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		FxOptionPremium.FxOptionPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		FxOptionPremium.FxOptionPremiumBuilder setSettlementInformation(SettlementInformation settlementInformation);
		FxOptionPremium.FxOptionPremiumBuilder setQuote(PremiumQuote quote);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
			processRosetta(path.newSubPath("quote"), processor, PremiumQuote.PremiumQuoteBuilder.class, getQuote());
		}
		

		FxOptionPremium.FxOptionPremiumBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionPremium  ***********************/
	class FxOptionPremiumImpl extends NonNegativePayment.NonNegativePaymentImpl implements FxOptionPremium {
		private final SettlementInformation settlementInformation;
		private final PremiumQuote quote;
		
		protected FxOptionPremiumImpl(FxOptionPremium.FxOptionPremiumBuilder builder) {
			super(builder);
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		@RosettaAttribute("quote")
		public PremiumQuote getQuote() {
			return quote;
		}
		
		@Override
		public FxOptionPremium build() {
			return this;
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder toBuilder() {
			FxOptionPremium.FxOptionPremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionPremium.FxOptionPremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPremium _that = getType().cast(o);
		
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPremium {" +
				"settlementInformation=" + this.settlementInformation + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOptionPremium  ***********************/
	class FxOptionPremiumBuilderImpl extends NonNegativePayment.NonNegativePaymentBuilderImpl  implements FxOptionPremium.FxOptionPremiumBuilder {
	
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
		protected PremiumQuote.PremiumQuoteBuilder quote;
	
		public FxOptionPremiumBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation.SettlementInformationBuilder getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation() {
			SettlementInformation.SettlementInformationBuilder result;
			if (settlementInformation!=null) {
				result = settlementInformation;
			}
			else {
				result = settlementInformation = SettlementInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quote")
		public PremiumQuote.PremiumQuoteBuilder getQuote() {
			return quote;
		}
		
		@Override
		public PremiumQuote.PremiumQuoteBuilder getOrCreateQuote() {
			PremiumQuote.PremiumQuoteBuilder result;
			if (quote!=null) {
				result = quote;
			}
			else {
				result = quote = PremiumQuote.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxOptionPremium.FxOptionPremiumBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FxOptionPremium.FxOptionPremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public FxOptionPremium.FxOptionPremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public FxOptionPremium.FxOptionPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInformation")
		public FxOptionPremium.FxOptionPremiumBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quote")
		public FxOptionPremium.FxOptionPremiumBuilder setQuote(PremiumQuote quote) {
			this.quote = quote==null?null:quote.toBuilder();
			return this;
		}
		
		@Override
		public FxOptionPremium build() {
			return new FxOptionPremium.FxOptionPremiumImpl(this);
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder prune() {
			super.prune();
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			if (quote!=null && !quote.prune().hasData()) quote = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			if (getQuote()!=null && getQuote().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxOptionPremium.FxOptionPremiumBuilder o = (FxOptionPremium.FxOptionPremiumBuilder) other;
			
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::setQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPremium _that = getType().cast(o);
		
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPremiumBuilder {" +
				"settlementInformation=" + this.settlementInformation + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}
}
