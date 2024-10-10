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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.Money;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.PendingPayment.PendingPaymentBuilder;
import fpml.confirmation.PendingPayment.PendingPaymentBuilderImpl;
import fpml.confirmation.PendingPayment.PendingPaymentImpl;
import fpml.confirmation.meta.PendingPaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure representing a pending dividend or coupon payment.
 * @version ${project.version}
 */
@RosettaDataType(value="PendingPayment", builder=PendingPayment.PendingPaymentBuilderImpl.class, version="${project.version}")
public interface PendingPayment extends PaymentBase {

	PendingPaymentMeta metaData = new PendingPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date that the dividend or coupon is due.
	 */
	Date getPaymentDate();
	/**
	 * The amount of the dividend or coupon payment. Value of dividends or coupon between ex and pay date. Stock: if we are between ex-date and pay-date and the dividend is payable under the swap, then this should be the ex-div amount * # of securities. Bond: regardless of where we are vis-a-vis resets: (coupon % * face of bonds on swap * (bond day count fraction using days last coupon pay date of the bond through today).
	 */
	Money getAmount();
	/**
	 * Accrued interest on the dividend or coupon payment. When the TRS is structured to pay a dividend or coupon on reset after payable date, you may earn interest on these amounts. This field indicates the interest accrued on dividend/coupon from pay date to statement date. This will only apply to a handful of agreements where dividendss are held to the next reset AND you receive/pay interest on unpaid amounts.
	 */
	Money getAccruedInterest();

	/*********************** Build Methods  ***********************/
	PendingPayment build();
	
	PendingPayment.PendingPaymentBuilder toBuilder();
	
	static PendingPayment.PendingPaymentBuilder builder() {
		return new PendingPayment.PendingPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PendingPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PendingPayment> getType() {
		return PendingPayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("paymentDate"), Date.class, getPaymentDate(), this);
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("accruedInterest"), processor, Money.class, getAccruedInterest());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PendingPaymentBuilder extends PendingPayment, PaymentBase.PaymentBaseBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		Money.MoneyBuilder getOrCreateAccruedInterest();
		Money.MoneyBuilder getAccruedInterest();
		PendingPayment.PendingPaymentBuilder setId(String id);
		PendingPayment.PendingPaymentBuilder setPaymentDate(Date paymentDate);
		PendingPayment.PendingPaymentBuilder setAmount(Money amount);
		PendingPayment.PendingPaymentBuilder setAccruedInterest(Money accruedInterest);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("paymentDate"), Date.class, getPaymentDate(), this);
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accruedInterest"), processor, Money.MoneyBuilder.class, getAccruedInterest());
		}
		

		PendingPayment.PendingPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of PendingPayment  ***********************/
	class PendingPaymentImpl extends PaymentBase.PaymentBaseImpl implements PendingPayment {
		private final Date paymentDate;
		private final Money amount;
		private final Money accruedInterest;
		
		protected PendingPaymentImpl(PendingPayment.PendingPaymentBuilder builder) {
			super(builder);
			this.paymentDate = builder.getPaymentDate();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accruedInterest = ofNullable(builder.getAccruedInterest()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public Date getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		public Money getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		public PendingPayment build() {
			return this;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder toBuilder() {
			PendingPayment.PendingPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PendingPayment.PendingPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccruedInterest()).ifPresent(builder::setAccruedInterest);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PendingPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PendingPayment {" +
				"paymentDate=" + this.paymentDate + ", " +
				"amount=" + this.amount + ", " +
				"accruedInterest=" + this.accruedInterest +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PendingPayment  ***********************/
	class PendingPaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements PendingPayment.PendingPaymentBuilder {
	
		protected Date paymentDate;
		protected Money.MoneyBuilder amount;
		protected Money.MoneyBuilder accruedInterest;
	
		public PendingPaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentDate")
		public Date getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		public Money.MoneyBuilder getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAccruedInterest() {
			Money.MoneyBuilder result;
			if (accruedInterest!=null) {
				result = accruedInterest;
			}
			else {
				result = accruedInterest = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public PendingPayment.PendingPaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public PendingPayment.PendingPaymentBuilder setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public PendingPayment.PendingPaymentBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruedInterest")
		public PendingPayment.PendingPaymentBuilder setAccruedInterest(Money accruedInterest) {
			this.accruedInterest = accruedInterest==null?null:accruedInterest.toBuilder();
			return this;
		}
		
		@Override
		public PendingPayment build() {
			return new PendingPayment.PendingPaymentImpl(this);
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PendingPayment.PendingPaymentBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (accruedInterest!=null && !accruedInterest.prune().hasData()) accruedInterest = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentDate()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccruedInterest()!=null && getAccruedInterest().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PendingPayment.PendingPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PendingPayment.PendingPaymentBuilder o = (PendingPayment.PendingPaymentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccruedInterest(), o.getAccruedInterest(), this::setAccruedInterest);
			
			merger.mergeBasic(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PendingPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PendingPaymentBuilder {" +
				"paymentDate=" + this.paymentDate + ", " +
				"amount=" + this.amount + ", " +
				"accruedInterest=" + this.accruedInterest +
			'}' + " " + super.toString();
		}
	}
}
