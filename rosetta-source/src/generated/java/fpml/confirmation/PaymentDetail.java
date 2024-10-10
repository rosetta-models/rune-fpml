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
import fpml.confirmation.Money;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.PaymentDetail;
import fpml.confirmation.PaymentDetail.PaymentDetailBuilder;
import fpml.confirmation.PaymentDetail.PaymentDetailBuilderImpl;
import fpml.confirmation.PaymentDetail.PaymentDetailImpl;
import fpml.confirmation.PaymentDetailSequence;
import fpml.confirmation.meta.PaymentDetailMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentDetail", builder=PaymentDetail.PaymentDetailBuilderImpl.class, version="${project.version}")
public interface PaymentDetail extends PaymentBase {

	PaymentDetailMeta metaData = new PaymentDetailMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Payment date.
	 */
	AdjustableOrRelativeDate getPaymentDate();
	/**
	 * A fixed payment amount.
	 */
	Money getPaymentAmount();
	PaymentDetailSequence getPaymentDetailSequence();

	/*********************** Build Methods  ***********************/
	PaymentDetail build();
	
	PaymentDetail.PaymentDetailBuilder toBuilder();
	
	static PaymentDetail.PaymentDetailBuilder builder() {
		return new PaymentDetail.PaymentDetailBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDetail> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentDetail> getType() {
		return PaymentDetail.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDetailSequence"), processor, PaymentDetailSequence.class, getPaymentDetailSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDetailBuilder extends PaymentDetail, PaymentBase.PaymentBaseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		Money.MoneyBuilder getOrCreatePaymentAmount();
		Money.MoneyBuilder getPaymentAmount();
		PaymentDetailSequence.PaymentDetailSequenceBuilder getOrCreatePaymentDetailSequence();
		PaymentDetailSequence.PaymentDetailSequenceBuilder getPaymentDetailSequence();
		PaymentDetail.PaymentDetailBuilder setId(String id);
		PaymentDetail.PaymentDetailBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		PaymentDetail.PaymentDetailBuilder setPaymentAmount(Money paymentAmount);
		PaymentDetail.PaymentDetailBuilder setPaymentDetailSequence(PaymentDetailSequence paymentDetailSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDetailSequence"), processor, PaymentDetailSequence.PaymentDetailSequenceBuilder.class, getPaymentDetailSequence());
		}
		

		PaymentDetail.PaymentDetailBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDetail  ***********************/
	class PaymentDetailImpl extends PaymentBase.PaymentBaseImpl implements PaymentDetail {
		private final AdjustableOrRelativeDate paymentDate;
		private final Money paymentAmount;
		private final PaymentDetailSequence paymentDetailSequence;
		
		protected PaymentDetailImpl(PaymentDetail.PaymentDetailBuilder builder) {
			super(builder);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDetailSequence = ofNullable(builder.getPaymentDetailSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		@RosettaAttribute("paymentDetailSequence")
		public PaymentDetailSequence getPaymentDetailSequence() {
			return paymentDetailSequence;
		}
		
		@Override
		public PaymentDetail build() {
			return this;
		}
		
		@Override
		public PaymentDetail.PaymentDetailBuilder toBuilder() {
			PaymentDetail.PaymentDetailBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDetail.PaymentDetailBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDetailSequence()).ifPresent(builder::setPaymentDetailSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentDetail _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDetailSequence, _that.getPaymentDetailSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDetailSequence != null ? paymentDetailSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetail {" +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDetailSequence=" + this.paymentDetailSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PaymentDetail  ***********************/
	class PaymentDetailBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements PaymentDetail.PaymentDetailBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
		protected Money.MoneyBuilder paymentAmount;
		protected PaymentDetailSequence.PaymentDetailSequenceBuilder paymentDetailSequence;
	
		public PaymentDetailBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrRelativeDate.builder();
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
		@RosettaAttribute("paymentDetailSequence")
		public PaymentDetailSequence.PaymentDetailSequenceBuilder getPaymentDetailSequence() {
			return paymentDetailSequence;
		}
		
		@Override
		public PaymentDetailSequence.PaymentDetailSequenceBuilder getOrCreatePaymentDetailSequence() {
			PaymentDetailSequence.PaymentDetailSequenceBuilder result;
			if (paymentDetailSequence!=null) {
				result = paymentDetailSequence;
			}
			else {
				result = paymentDetailSequence = PaymentDetailSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public PaymentDetail.PaymentDetailBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public PaymentDetail.PaymentDetailBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public PaymentDetail.PaymentDetailBuilder setPaymentAmount(Money paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDetailSequence")
		public PaymentDetail.PaymentDetailBuilder setPaymentDetailSequence(PaymentDetailSequence paymentDetailSequence) {
			this.paymentDetailSequence = paymentDetailSequence==null?null:paymentDetailSequence.toBuilder();
			return this;
		}
		
		@Override
		public PaymentDetail build() {
			return new PaymentDetail.PaymentDetailImpl(this);
		}
		
		@Override
		public PaymentDetail.PaymentDetailBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetail.PaymentDetailBuilder prune() {
			super.prune();
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDetailSequence!=null && !paymentDetailSequence.prune().hasData()) paymentDetailSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDetailSequence()!=null && getPaymentDetailSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetail.PaymentDetailBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PaymentDetail.PaymentDetailBuilder o = (PaymentDetail.PaymentDetailBuilder) other;
			
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDetailSequence(), o.getPaymentDetailSequence(), this::setPaymentDetailSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentDetail _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDetailSequence, _that.getPaymentDetailSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDetailSequence != null ? paymentDetailSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetailBuilder {" +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDetailSequence=" + this.paymentDetailSequence +
			'}' + " " + super.toString();
		}
	}
}
