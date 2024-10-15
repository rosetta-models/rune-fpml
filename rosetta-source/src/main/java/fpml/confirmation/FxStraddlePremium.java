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
import fpml.confirmation.FxStraddlePremium;
import fpml.confirmation.FxStraddlePremium.FxStraddlePremiumBuilder;
import fpml.confirmation.FxStraddlePremium.FxStraddlePremiumBuilderImpl;
import fpml.confirmation.FxStraddlePremium.FxStraddlePremiumImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBaseExtended;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedBuilder;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedBuilderImpl;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedImpl;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.FxStraddlePremiumMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The Currency and Amount to be paid by the Buyer to the Seller. The straddle premium is calculated on the Fixing Date using the Forward Volatility Agreement parameters.
 * @version ${project.version}
 */
@RosettaDataType(value="FxStraddlePremium", builder=FxStraddlePremium.FxStraddlePremiumBuilderImpl.class, version="${project.version}")
public interface FxStraddlePremium extends PaymentBaseExtended {

	FxStraddlePremiumMeta metaData = new FxStraddlePremiumMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Premium Payment Currency.
	 */
	IdentifiedCurrency getPaymentCurrency();
	/**
	 * The Seller details for settling the FxStraddlePremium.
	 */
	SettlementInformation getSettlementInformation();

	/*********************** Build Methods  ***********************/
	FxStraddlePremium build();
	
	FxStraddlePremium.FxStraddlePremiumBuilder toBuilder();
	
	static FxStraddlePremium.FxStraddlePremiumBuilder builder() {
		return new FxStraddlePremium.FxStraddlePremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStraddlePremium> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxStraddlePremium> getType() {
		return FxStraddlePremium.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentCurrency"), processor, IdentifiedCurrency.class, getPaymentCurrency());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStraddlePremiumBuilder extends FxStraddlePremium, PaymentBaseExtended.PaymentBaseExtendedBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreatePaymentCurrency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getPaymentCurrency();
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		FxStraddlePremium.FxStraddlePremiumBuilder setId(String id);
		FxStraddlePremium.FxStraddlePremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FxStraddlePremium.FxStraddlePremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		FxStraddlePremium.FxStraddlePremiumBuilder setPaymentCurrency(IdentifiedCurrency paymentCurrency);
		FxStraddlePremium.FxStraddlePremiumBuilder setSettlementInformation(SettlementInformation settlementInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getPaymentCurrency());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
		}
		

		FxStraddlePremium.FxStraddlePremiumBuilder prune();
	}

	/*********************** Immutable Implementation of FxStraddlePremium  ***********************/
	class FxStraddlePremiumImpl extends PaymentBaseExtended.PaymentBaseExtendedImpl implements FxStraddlePremium {
		private final IdentifiedCurrency paymentCurrency;
		private final SettlementInformation settlementInformation;
		
		protected FxStraddlePremiumImpl(FxStraddlePremium.FxStraddlePremiumBuilder builder) {
			super(builder);
			this.paymentCurrency = ofNullable(builder.getPaymentCurrency()).map(f->f.build()).orElse(null);
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentCurrency")
		public IdentifiedCurrency getPaymentCurrency() {
			return paymentCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public FxStraddlePremium build() {
			return this;
		}
		
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder toBuilder() {
			FxStraddlePremium.FxStraddlePremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStraddlePremium.FxStraddlePremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentCurrency()).ifPresent(builder::setPaymentCurrency);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxStraddlePremium _that = getType().cast(o);
		
			if (!Objects.equals(paymentCurrency, _that.getPaymentCurrency())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentCurrency != null ? paymentCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddlePremium {" +
				"paymentCurrency=" + this.paymentCurrency + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxStraddlePremium  ***********************/
	class FxStraddlePremiumBuilderImpl extends PaymentBaseExtended.PaymentBaseExtendedBuilderImpl  implements FxStraddlePremium.FxStraddlePremiumBuilder {
	
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder paymentCurrency;
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
	
		public FxStraddlePremiumBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentCurrency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getPaymentCurrency() {
			return paymentCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreatePaymentCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (paymentCurrency!=null) {
				result = paymentCurrency;
			}
			else {
				result = paymentCurrency = IdentifiedCurrency.builder();
			}
			
			return result;
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
		@RosettaAttribute("id")
		public FxStraddlePremium.FxStraddlePremiumBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FxStraddlePremium.FxStraddlePremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public FxStraddlePremium.FxStraddlePremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentCurrency")
		public FxStraddlePremium.FxStraddlePremiumBuilder setPaymentCurrency(IdentifiedCurrency paymentCurrency) {
			this.paymentCurrency = paymentCurrency==null?null:paymentCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInformation")
		public FxStraddlePremium.FxStraddlePremiumBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		
		@Override
		public FxStraddlePremium build() {
			return new FxStraddlePremium.FxStraddlePremiumImpl(this);
		}
		
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder prune() {
			super.prune();
			if (paymentCurrency!=null && !paymentCurrency.prune().hasData()) paymentCurrency = null;
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentCurrency()!=null && getPaymentCurrency().hasData()) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxStraddlePremium.FxStraddlePremiumBuilder o = (FxStraddlePremium.FxStraddlePremiumBuilder) other;
			
			merger.mergeRosetta(getPaymentCurrency(), o.getPaymentCurrency(), this::setPaymentCurrency);
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxStraddlePremium _that = getType().cast(o);
		
			if (!Objects.equals(paymentCurrency, _that.getPaymentCurrency())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentCurrency != null ? paymentCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddlePremiumBuilder {" +
				"paymentCurrency=" + this.paymentCurrency + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}
}
