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
import fpml.confirmation.Money;
import fpml.confirmation.PaymentDetailSequence;
import fpml.confirmation.PaymentDetailSequence.PaymentDetailSequenceBuilder;
import fpml.confirmation.PaymentDetailSequence.PaymentDetailSequenceBuilderImpl;
import fpml.confirmation.PaymentDetailSequence.PaymentDetailSequenceImpl;
import fpml.confirmation.PaymentRule;
import fpml.confirmation.meta.PaymentDetailSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentDetailSequence", builder=PaymentDetailSequence.PaymentDetailSequenceBuilderImpl.class, version="${project.version}")
public interface PaymentDetailSequence extends RosettaModelObject {

	PaymentDetailSequenceMeta metaData = new PaymentDetailSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A type defining the calculation rule.
	 */
	PaymentRule getPaymentRule();
	/**
	 * A fixed payment amount.
	 */
	Money getPaymentAmount();

	/*********************** Build Methods  ***********************/
	PaymentDetailSequence build();
	
	PaymentDetailSequence.PaymentDetailSequenceBuilder toBuilder();
	
	static PaymentDetailSequence.PaymentDetailSequenceBuilder builder() {
		return new PaymentDetailSequence.PaymentDetailSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDetailSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentDetailSequence> getType() {
		return PaymentDetailSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentRule"), processor, PaymentRule.class, getPaymentRule());
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDetailSequenceBuilder extends PaymentDetailSequence, RosettaModelObjectBuilder {
		PaymentRule.PaymentRuleBuilder getOrCreatePaymentRule();
		PaymentRule.PaymentRuleBuilder getPaymentRule();
		Money.MoneyBuilder getOrCreatePaymentAmount();
		Money.MoneyBuilder getPaymentAmount();
		PaymentDetailSequence.PaymentDetailSequenceBuilder setPaymentRule(PaymentRule paymentRule);
		PaymentDetailSequence.PaymentDetailSequenceBuilder setPaymentAmount(Money paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentRule"), processor, PaymentRule.PaymentRuleBuilder.class, getPaymentRule());
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
		}
		

		PaymentDetailSequence.PaymentDetailSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDetailSequence  ***********************/
	class PaymentDetailSequenceImpl implements PaymentDetailSequence {
		private final PaymentRule paymentRule;
		private final Money paymentAmount;
		
		protected PaymentDetailSequenceImpl(PaymentDetailSequence.PaymentDetailSequenceBuilder builder) {
			this.paymentRule = ofNullable(builder.getPaymentRule()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentRule")
		public PaymentRule getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public PaymentDetailSequence build() {
			return this;
		}
		
		@Override
		public PaymentDetailSequence.PaymentDetailSequenceBuilder toBuilder() {
			PaymentDetailSequence.PaymentDetailSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDetailSequence.PaymentDetailSequenceBuilder builder) {
			ofNullable(getPaymentRule()).ifPresent(builder::setPaymentRule);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDetailSequence _that = getType().cast(o);
		
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentRule != null ? paymentRule.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetailSequence {" +
				"paymentRule=" + this.paymentRule + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentDetailSequence  ***********************/
	class PaymentDetailSequenceBuilderImpl implements PaymentDetailSequence.PaymentDetailSequenceBuilder {
	
		protected PaymentRule.PaymentRuleBuilder paymentRule;
		protected Money.MoneyBuilder paymentAmount;
	
		public PaymentDetailSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentRule")
		public PaymentRule.PaymentRuleBuilder getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder getOrCreatePaymentRule() {
			PaymentRule.PaymentRuleBuilder result;
			if (paymentRule!=null) {
				result = paymentRule;
			}
			else {
				result = paymentRule = PaymentRule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public Money.MoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePaymentAmount() {
			Money.MoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentRule")
		public PaymentDetailSequence.PaymentDetailSequenceBuilder setPaymentRule(PaymentRule paymentRule) {
			this.paymentRule = paymentRule==null?null:paymentRule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public PaymentDetailSequence.PaymentDetailSequenceBuilder setPaymentAmount(Money paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public PaymentDetailSequence build() {
			return new PaymentDetailSequence.PaymentDetailSequenceImpl(this);
		}
		
		@Override
		public PaymentDetailSequence.PaymentDetailSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetailSequence.PaymentDetailSequenceBuilder prune() {
			if (paymentRule!=null && !paymentRule.prune().hasData()) paymentRule = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentRule()!=null && getPaymentRule().hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetailSequence.PaymentDetailSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentDetailSequence.PaymentDetailSequenceBuilder o = (PaymentDetailSequence.PaymentDetailSequenceBuilder) other;
			
			merger.mergeRosetta(getPaymentRule(), o.getPaymentRule(), this::setPaymentRule);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDetailSequence _that = getType().cast(o);
		
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentRule != null ? paymentRule.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetailSequenceBuilder {" +
				"paymentRule=" + this.paymentRule + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}';
		}
	}
}
