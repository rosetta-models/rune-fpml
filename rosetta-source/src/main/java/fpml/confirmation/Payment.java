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
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Payment;
import fpml.confirmation.Payment.PaymentBuilder;
import fpml.confirmation.Payment.PaymentBuilderImpl;
import fpml.confirmation.Payment.PaymentImpl;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.PaymentType;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.PaymentMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining payments. In Transparency view, normally the payer and receiver party references are not used; however they may be provided if necessary for administrative activities such as Reporting Party Determination in FX.
 * @version ${project.version}
 */
@RosettaDataType(value="Payment", builder=Payment.PaymentBuilderImpl.class, version="${project.version}")
public interface Payment extends PaymentBase {

	PaymentMeta metaData = new PaymentMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * The currency amount of the payment.
	 */
	NonNegativeMoney getPaymentAmount();
	/**
	 * The payment date. This date is subject to adjustment in accordance with any applicable business day convention.
	 */
	AdjustableOrAdjustedDate getPaymentDate();
	/**
	 * A classification of the type of fee or additional payment, e.g. brokerage, upfront fee etc. FpML does not define domain values for this element.
	 */
	PaymentType getPaymentType();
	/**
	 * The information required to settle a currency payment that results from a trade.
	 */
	SettlementInformation getSettlementInformation();
	/**
	 * The value representing the discount factor used to calculate the present value of the cash flow.
	 */
	BigDecimal getDiscountFactor();
	/**
	 * The amount representing the present value of the forecast payment.
	 */
	Money getPresentValueAmount();
	/**
	 * Can be used to reference the yield curve used to estimate the discount factor.
	 */
	String getHref();

	/*********************** Build Methods  ***********************/
	Payment build();
	
	Payment.PaymentBuilder toBuilder();
	
	static Payment.PaymentBuilder builder() {
		return new Payment.PaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Payment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Payment> getType() {
		return Payment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrAdjustedDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentBuilder extends Payment, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreatePaymentDate();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getPaymentDate();
		PaymentType.PaymentTypeBuilder getOrCreatePaymentType();
		PaymentType.PaymentTypeBuilder getPaymentType();
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		Money.MoneyBuilder getPresentValueAmount();
		Payment.PaymentBuilder setId(String id);
		Payment.PaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		Payment.PaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		Payment.PaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate);
		Payment.PaymentBuilder setPaymentType(PaymentType paymentType);
		Payment.PaymentBuilder setSettlementInformation(SettlementInformation settlementInformation);
		Payment.PaymentBuilder setDiscountFactor(BigDecimal discountFactor);
		Payment.PaymentBuilder setPresentValueAmount(Money presentValueAmount);
		Payment.PaymentBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		Payment.PaymentBuilder prune();
	}

	/*********************** Immutable Implementation of Payment  ***********************/
	class PaymentImpl extends PaymentBase.PaymentBaseImpl implements Payment {
		private final PayerReceiverModel payerReceiverModel;
		private final NonNegativeMoney paymentAmount;
		private final AdjustableOrAdjustedDate paymentDate;
		private final PaymentType paymentType;
		private final SettlementInformation settlementInformation;
		private final BigDecimal discountFactor;
		private final Money presentValueAmount;
		private final String href;
		
		protected PaymentImpl(Payment.PaymentBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentType = ofNullable(builder.getPaymentType()).map(f->f.build()).orElse(null);
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
			this.discountFactor = builder.getDiscountFactor();
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableOrAdjustedDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentType")
		public PaymentType getPaymentType() {
			return paymentType;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		public Money getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public Payment build() {
			return this;
		}
		
		@Override
		public Payment.PaymentBuilder toBuilder() {
			Payment.PaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Payment.PaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Payment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Payment {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentType=" + this.paymentType + ", " +
				"settlementInformation=" + this.settlementInformation + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Payment  ***********************/
	class PaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements Payment.PaymentBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder paymentDate;
		protected PaymentType.PaymentTypeBuilder paymentType;
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder presentValueAmount;
		protected String href;
	
		public PaymentBuilderImpl() {
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
		@RosettaAttribute("paymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreatePaymentDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentType")
		public PaymentType.PaymentTypeBuilder getPaymentType() {
			return paymentType;
		}
		
		@Override
		public PaymentType.PaymentTypeBuilder getOrCreatePaymentType() {
			PaymentType.PaymentTypeBuilder result;
			if (paymentType!=null) {
				result = paymentType;
			}
			else {
				result = paymentType = PaymentType.builder();
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
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		public Money.MoneyBuilder getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValueAmount() {
			Money.MoneyBuilder result;
			if (presentValueAmount!=null) {
				result = presentValueAmount;
			}
			else {
				result = presentValueAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("id")
		public Payment.PaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public Payment.PaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public Payment.PaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public Payment.PaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentType")
		public Payment.PaymentBuilder setPaymentType(PaymentType paymentType) {
			this.paymentType = paymentType==null?null:paymentType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInformation")
		public Payment.PaymentBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("discountFactor")
		public Payment.PaymentBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		@RosettaAttribute("presentValueAmount")
		public Payment.PaymentBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("href")
		public Payment.PaymentBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public Payment build() {
			return new Payment.PaymentImpl(this);
		}
		
		@Override
		public Payment.PaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payment.PaymentBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (paymentType!=null && !paymentType.prune().hasData()) paymentType = null;
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getPaymentType()!=null && getPaymentType().hasData()) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			if (getDiscountFactor()!=null) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payment.PaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Payment.PaymentBuilder o = (Payment.PaymentBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPaymentType(), o.getPaymentType(), this::setPaymentType);
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Payment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentType=" + this.paymentType + ", " +
				"settlementInformation=" + this.settlementInformation + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
