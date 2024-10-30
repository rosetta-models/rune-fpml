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
import fpml.confirmation.Currency;
import fpml.confirmation.FeaturePayment;
import fpml.confirmation.FeaturePayment.FeaturePaymentBuilder;
import fpml.confirmation.FeaturePayment.FeaturePaymentBuilderImpl;
import fpml.confirmation.FeaturePayment.FeaturePaymentImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.TimeTypeEnum;
import fpml.confirmation.meta.FeaturePaymentMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Payment made following trigger occurence.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FeaturePayment", builder=FeaturePayment.FeaturePaymentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FeaturePayment extends PaymentBase {

	FeaturePaymentMeta metaData = new FeaturePaymentMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * The trigger level percentage.
	 */
	BigDecimal getLevelPercentage();
	/**
	 * The monetary quantity in currency units.
	 */
	BigDecimal getAmount();
	/**
	 * The feature payment time.
	 */
	TimeTypeEnum getTime();
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();
	/**
	 * The feature payment date.
	 */
	AdjustableOrRelativeDate getFeaturePaymentDate();

	/*********************** Build Methods  ***********************/
	FeaturePayment build();
	
	FeaturePayment.FeaturePaymentBuilder toBuilder();
	
	static FeaturePayment.FeaturePaymentBuilder builder() {
		return new FeaturePayment.FeaturePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeaturePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeaturePayment> getType() {
		return FeaturePayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("time"), TimeTypeEnum.class, getTime(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("featurePaymentDate"), processor, AdjustableOrRelativeDate.class, getFeaturePaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeaturePaymentBuilder extends FeaturePayment, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFeaturePaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFeaturePaymentDate();
		FeaturePayment.FeaturePaymentBuilder setId(String id);
		FeaturePayment.FeaturePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FeaturePayment.FeaturePaymentBuilder setLevelPercentage(BigDecimal levelPercentage);
		FeaturePayment.FeaturePaymentBuilder setAmount(BigDecimal amount);
		FeaturePayment.FeaturePaymentBuilder setTime(TimeTypeEnum time);
		FeaturePayment.FeaturePaymentBuilder setCurrency(Currency currency);
		FeaturePayment.FeaturePaymentBuilder setFeaturePaymentDate(AdjustableOrRelativeDate featurePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("time"), TimeTypeEnum.class, getTime(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("featurePaymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getFeaturePaymentDate());
		}
		

		FeaturePayment.FeaturePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of FeaturePayment  ***********************/
	class FeaturePaymentImpl extends PaymentBase.PaymentBaseImpl implements FeaturePayment {
		private final PayerReceiverModel payerReceiverModel;
		private final BigDecimal levelPercentage;
		private final BigDecimal amount;
		private final TimeTypeEnum time;
		private final Currency currency;
		private final AdjustableOrRelativeDate featurePaymentDate;
		
		protected FeaturePaymentImpl(FeaturePayment.FeaturePaymentBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.levelPercentage = builder.getLevelPercentage();
			this.amount = builder.getAmount();
			this.time = builder.getTime();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.featurePaymentDate = ofNullable(builder.getFeaturePaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("time")
		public TimeTypeEnum getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("featurePaymentDate")
		public AdjustableOrRelativeDate getFeaturePaymentDate() {
			return featurePaymentDate;
		}
		
		@Override
		public FeaturePayment build() {
			return this;
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder toBuilder() {
			FeaturePayment.FeaturePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeaturePayment.FeaturePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getFeaturePaymentDate()).ifPresent(builder::setFeaturePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeaturePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(featurePaymentDate, _that.getFeaturePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (featurePaymentDate != null ? featurePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeaturePayment {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"amount=" + this.amount + ", " +
				"time=" + this.time + ", " +
				"currency=" + this.currency + ", " +
				"featurePaymentDate=" + this.featurePaymentDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FeaturePayment  ***********************/
	class FeaturePaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements FeaturePayment.FeaturePaymentBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected BigDecimal levelPercentage;
		protected BigDecimal amount;
		protected TimeTypeEnum time;
		protected Currency.CurrencyBuilder currency;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder featurePaymentDate;
	
		public FeaturePaymentBuilderImpl() {
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
		@RosettaAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("time")
		public TimeTypeEnum getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("featurePaymentDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFeaturePaymentDate() {
			return featurePaymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFeaturePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (featurePaymentDate!=null) {
				result = featurePaymentDate;
			}
			else {
				result = featurePaymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FeaturePayment.FeaturePaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FeaturePayment.FeaturePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("levelPercentage")
		public FeaturePayment.FeaturePaymentBuilder setLevelPercentage(BigDecimal levelPercentage) {
			this.levelPercentage = levelPercentage==null?null:levelPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public FeaturePayment.FeaturePaymentBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("time")
		public FeaturePayment.FeaturePaymentBuilder setTime(TimeTypeEnum time) {
			this.time = time==null?null:time;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public FeaturePayment.FeaturePaymentBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("featurePaymentDate")
		public FeaturePayment.FeaturePaymentBuilder setFeaturePaymentDate(AdjustableOrRelativeDate featurePaymentDate) {
			this.featurePaymentDate = featurePaymentDate==null?null:featurePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public FeaturePayment build() {
			return new FeaturePayment.FeaturePaymentImpl(this);
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeaturePayment.FeaturePaymentBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (featurePaymentDate!=null && !featurePaymentDate.prune().hasData()) featurePaymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getLevelPercentage()!=null) return true;
			if (getAmount()!=null) return true;
			if (getTime()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getFeaturePaymentDate()!=null && getFeaturePaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeaturePayment.FeaturePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FeaturePayment.FeaturePaymentBuilder o = (FeaturePayment.FeaturePaymentBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getFeaturePaymentDate(), o.getFeaturePaymentDate(), this::setFeaturePaymentDate);
			
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeaturePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(featurePaymentDate, _that.getFeaturePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (featurePaymentDate != null ? featurePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeaturePaymentBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"amount=" + this.amount + ", " +
				"time=" + this.time + ", " +
				"currency=" + this.currency + ", " +
				"featurePaymentDate=" + this.featurePaymentDate +
			'}' + " " + super.toString();
		}
	}
}
