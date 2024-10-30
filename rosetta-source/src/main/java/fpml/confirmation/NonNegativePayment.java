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
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilder;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilderImpl;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBaseExtended;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedBuilder;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedBuilderImpl;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedImpl;
import fpml.confirmation.meta.NonNegativePaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A complex type to specify non negative payments.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NonNegativePayment", builder=NonNegativePayment.NonNegativePaymentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NonNegativePayment extends PaymentBaseExtended {

	NonNegativePaymentMeta metaData = new NonNegativePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Non negative payment amount.
	 */
	NonNegativeMoney getPaymentAmount();

	/*********************** Build Methods  ***********************/
	NonNegativePayment build();
	
	NonNegativePayment.NonNegativePaymentBuilder toBuilder();
	
	static NonNegativePayment.NonNegativePaymentBuilder builder() {
		return new NonNegativePayment.NonNegativePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonNegativePayment> getType() {
		return NonNegativePayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativePaymentBuilder extends NonNegativePayment, PaymentBaseExtended.PaymentBaseExtendedBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		NonNegativePayment.NonNegativePaymentBuilder setId(String id);
		NonNegativePayment.NonNegativePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		NonNegativePayment.NonNegativePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		NonNegativePayment.NonNegativePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
		}
		

		NonNegativePayment.NonNegativePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativePayment  ***********************/
	class NonNegativePaymentImpl extends PaymentBaseExtended.PaymentBaseExtendedImpl implements NonNegativePayment {
		private final NonNegativeMoney paymentAmount;
		
		protected NonNegativePaymentImpl(NonNegativePayment.NonNegativePaymentBuilder builder) {
			super(builder);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public NonNegativePayment build() {
			return this;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder toBuilder() {
			NonNegativePayment.NonNegativePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativePayment.NonNegativePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativePayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativePayment {" +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativePayment  ***********************/
	class NonNegativePaymentBuilderImpl extends PaymentBaseExtended.PaymentBaseExtendedBuilderImpl  implements NonNegativePayment.NonNegativePaymentBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
	
		public NonNegativePaymentBuilderImpl() {
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
		@RosettaAttribute("id")
		public NonNegativePayment.NonNegativePaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public NonNegativePayment.NonNegativePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public NonNegativePayment.NonNegativePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public NonNegativePayment.NonNegativePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativePayment build() {
			return new NonNegativePayment.NonNegativePaymentImpl(this);
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder prune() {
			super.prune();
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonNegativePayment.NonNegativePaymentBuilder o = (NonNegativePayment.NonNegativePaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativePayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativePaymentBuilder {" +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}
}
