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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.EquityPremium.EquityPremiumBuilder;
import fpml.confirmation.EquityPremium.EquityPremiumBuilderImpl;
import fpml.confirmation.EquityPremium.EquityPremiumImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.PremiumTypeEnum;
import fpml.confirmation.meta.EquityPremiumMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type used to describe the amount paid for an equity option.
 * @version ${project.version}
 */
@RosettaDataType(value="EquityPremium", builder=EquityPremium.EquityPremiumBuilderImpl.class, version="${project.version}")
public interface EquityPremium extends PaymentBase {

	EquityPremiumMeta metaData = new EquityPremiumMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Forward start Premium type
	 */
	PremiumTypeEnum getPremiumType();
	/**
	 * The currency amount of the payment.
	 */
	NonNegativeMoney getPaymentAmount();
	/**
	 * The payment date. This date is subject to adjustment in accordance with any applicable business day convention.
	 */
	AdjustableDate getPaymentDate();
	/**
	 * Specifies whether or not the premium is to be paid in the style of payments under an interest rate swap contract.
	 */
	Boolean getSwapPremium();
	/**
	 * The amount of premium to be paid expressed as a function of the number of options.
	 */
	NonNegativeMoney getPricePerOption();
	/**
	 * The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
	 */
	BigDecimal getPercentageOfNotional();

	/*********************** Build Methods  ***********************/
	EquityPremium build();
	
	EquityPremium.EquityPremiumBuilder toBuilder();
	
	static EquityPremium.EquityPremiumBuilder builder() {
		return new EquityPremium.EquityPremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityPremium> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityPremium> getType() {
		return EquityPremium.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processor.processBasic(path.newSubPath("swapPremium"), Boolean.class, getSwapPremium(), this);
		processRosetta(path.newSubPath("pricePerOption"), processor, NonNegativeMoney.class, getPricePerOption());
		processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityPremiumBuilder extends EquityPremium, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate();
		AdjustableDate.AdjustableDateBuilder getPaymentDate();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePricePerOption();
		NonNegativeMoney.NonNegativeMoneyBuilder getPricePerOption();
		EquityPremium.EquityPremiumBuilder setId(String id);
		EquityPremium.EquityPremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		EquityPremium.EquityPremiumBuilder setPremiumType(PremiumTypeEnum premiumType);
		EquityPremium.EquityPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		EquityPremium.EquityPremiumBuilder setPaymentDate(AdjustableDate paymentDate);
		EquityPremium.EquityPremiumBuilder setSwapPremium(Boolean swapPremium);
		EquityPremium.EquityPremiumBuilder setPricePerOption(NonNegativeMoney pricePerOption);
		EquityPremium.EquityPremiumBuilder setPercentageOfNotional(BigDecimal percentageOfNotional);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processor.processBasic(path.newSubPath("swapPremium"), Boolean.class, getSwapPremium(), this);
			processRosetta(path.newSubPath("pricePerOption"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPricePerOption());
			processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
		}
		

		EquityPremium.EquityPremiumBuilder prune();
	}

	/*********************** Immutable Implementation of EquityPremium  ***********************/
	class EquityPremiumImpl extends PaymentBase.PaymentBaseImpl implements EquityPremium {
		private final PayerReceiverModel payerReceiverModel;
		private final PremiumTypeEnum premiumType;
		private final NonNegativeMoney paymentAmount;
		private final AdjustableDate paymentDate;
		private final Boolean swapPremium;
		private final NonNegativeMoney pricePerOption;
		private final BigDecimal percentageOfNotional;
		
		protected EquityPremiumImpl(EquityPremium.EquityPremiumBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.premiumType = builder.getPremiumType();
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.swapPremium = builder.getSwapPremium();
			this.pricePerOption = ofNullable(builder.getPricePerOption()).map(f->f.build()).orElse(null);
			this.percentageOfNotional = builder.getPercentageOfNotional();
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("swapPremium")
		public Boolean getSwapPremium() {
			return swapPremium;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		public NonNegativeMoney getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		@RosettaAttribute("percentageOfNotional")
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@Override
		public EquityPremium build() {
			return this;
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder toBuilder() {
			EquityPremium.EquityPremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityPremium.EquityPremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getPremiumType()).ifPresent(builder::setPremiumType);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getSwapPremium()).ifPresent(builder::setSwapPremium);
			ofNullable(getPricePerOption()).ifPresent(builder::setPricePerOption);
			ofNullable(getPercentageOfNotional()).ifPresent(builder::setPercentageOfNotional);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityPremium _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(swapPremium, _that.getSwapPremium())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (swapPremium != null ? swapPremium.hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPremium {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"premiumType=" + this.premiumType + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"swapPremium=" + this.swapPremium + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityPremium  ***********************/
	class EquityPremiumBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements EquityPremium.EquityPremiumBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected PremiumTypeEnum premiumType;
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		protected AdjustableDate.AdjustableDateBuilder paymentDate;
		protected Boolean swapPremium;
		protected NonNegativeMoney.NonNegativeMoneyBuilder pricePerOption;
		protected BigDecimal percentageOfNotional;
	
		public EquityPremiumBuilderImpl() {
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
		@RosettaAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
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
		public AdjustableDate.AdjustableDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swapPremium")
		public Boolean getSwapPremium() {
			return swapPremium;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePricePerOption() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (pricePerOption!=null) {
				result = pricePerOption;
			}
			else {
				result = pricePerOption = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("percentageOfNotional")
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@Override
		@RosettaAttribute("id")
		public EquityPremium.EquityPremiumBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public EquityPremium.EquityPremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premiumType")
		public EquityPremium.EquityPremiumBuilder setPremiumType(PremiumTypeEnum premiumType) {
			this.premiumType = premiumType==null?null:premiumType;
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public EquityPremium.EquityPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public EquityPremium.EquityPremiumBuilder setPaymentDate(AdjustableDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("swapPremium")
		public EquityPremium.EquityPremiumBuilder setSwapPremium(Boolean swapPremium) {
			this.swapPremium = swapPremium==null?null:swapPremium;
			return this;
		}
		@Override
		@RosettaAttribute("pricePerOption")
		public EquityPremium.EquityPremiumBuilder setPricePerOption(NonNegativeMoney pricePerOption) {
			this.pricePerOption = pricePerOption==null?null:pricePerOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("percentageOfNotional")
		public EquityPremium.EquityPremiumBuilder setPercentageOfNotional(BigDecimal percentageOfNotional) {
			this.percentageOfNotional = percentageOfNotional==null?null:percentageOfNotional;
			return this;
		}
		
		@Override
		public EquityPremium build() {
			return new EquityPremium.EquityPremiumImpl(this);
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPremium.EquityPremiumBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (pricePerOption!=null && !pricePerOption.prune().hasData()) pricePerOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getPremiumType()!=null) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getSwapPremium()!=null) return true;
			if (getPricePerOption()!=null && getPricePerOption().hasData()) return true;
			if (getPercentageOfNotional()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPremium.EquityPremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityPremium.EquityPremiumBuilder o = (EquityPremium.EquityPremiumBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPricePerOption(), o.getPricePerOption(), this::setPricePerOption);
			
			merger.mergeBasic(getPremiumType(), o.getPremiumType(), this::setPremiumType);
			merger.mergeBasic(getSwapPremium(), o.getSwapPremium(), this::setSwapPremium);
			merger.mergeBasic(getPercentageOfNotional(), o.getPercentageOfNotional(), this::setPercentageOfNotional);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityPremium _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(swapPremium, _that.getSwapPremium())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (swapPremium != null ? swapPremium.hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPremiumBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"premiumType=" + this.premiumType + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"swapPremium=" + this.swapPremium + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional +
			'}' + " " + super.toString();
		}
	}
}
