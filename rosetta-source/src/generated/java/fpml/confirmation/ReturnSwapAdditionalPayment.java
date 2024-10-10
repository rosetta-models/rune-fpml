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
import fpml.confirmation.AdditionalPaymentAmount;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.PaymentType;
import fpml.confirmation.ReturnSwapAdditionalPayment;
import fpml.confirmation.ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder;
import fpml.confirmation.ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilderImpl;
import fpml.confirmation.ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentImpl;
import fpml.confirmation.meta.ReturnSwapAdditionalPaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the additional payment(s) between the principal parties to the trade. This component extends some of the features of the additionalPayment component previously developed in FpML. Appropriate discussions will determine whether it would be appropriate to extend the shared component in order to meet the further requirements of equity swaps.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnSwapAdditionalPayment", builder=ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilderImpl.class, version="${project.version}")
public interface ReturnSwapAdditionalPayment extends PaymentBase {

	ReturnSwapAdditionalPaymentMeta metaData = new ReturnSwapAdditionalPaymentMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Specifies the amount of the fee along with, when applicable, the formula that supports its determination.
	 */
	AdditionalPaymentAmount getAdditionalPaymentAmount();
	/**
	 * Specifies the value date of the fee payment/receipt.
	 */
	AdjustableOrRelativeDate getAdditionalPaymentDate();
	/**
	 * Classification of the payment.
	 */
	PaymentType getPaymentType();

	/*********************** Build Methods  ***********************/
	ReturnSwapAdditionalPayment build();
	
	ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder toBuilder();
	
	static ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder() {
		return new ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapAdditionalPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapAdditionalPayment> getType() {
		return ReturnSwapAdditionalPayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("additionalPaymentAmount"), processor, AdditionalPaymentAmount.class, getAdditionalPaymentAmount());
		processRosetta(path.newSubPath("additionalPaymentDate"), processor, AdjustableOrRelativeDate.class, getAdditionalPaymentDate());
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapAdditionalPaymentBuilder extends ReturnSwapAdditionalPayment, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getOrCreateAdditionalPaymentAmount();
		AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getAdditionalPaymentAmount();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateAdditionalPaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getAdditionalPaymentDate();
		PaymentType.PaymentTypeBuilder getOrCreatePaymentType();
		PaymentType.PaymentTypeBuilder getPaymentType();
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setId(String id);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentAmount(AdditionalPaymentAmount additionalPaymentAmount);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentDate(AdjustableOrRelativeDate additionalPaymentDate);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPaymentType(PaymentType paymentType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("additionalPaymentAmount"), processor, AdditionalPaymentAmount.AdditionalPaymentAmountBuilder.class, getAdditionalPaymentAmount());
			processRosetta(path.newSubPath("additionalPaymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getAdditionalPaymentDate());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
		}
		

		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapAdditionalPayment  ***********************/
	class ReturnSwapAdditionalPaymentImpl extends PaymentBase.PaymentBaseImpl implements ReturnSwapAdditionalPayment {
		private final PayerReceiverModel payerReceiverModel;
		private final AdditionalPaymentAmount additionalPaymentAmount;
		private final AdjustableOrRelativeDate additionalPaymentDate;
		private final PaymentType paymentType;
		
		protected ReturnSwapAdditionalPaymentImpl(ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.additionalPaymentAmount = ofNullable(builder.getAdditionalPaymentAmount()).map(f->f.build()).orElse(null);
			this.additionalPaymentDate = ofNullable(builder.getAdditionalPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentType = ofNullable(builder.getPaymentType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("additionalPaymentAmount")
		public AdditionalPaymentAmount getAdditionalPaymentAmount() {
			return additionalPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("additionalPaymentDate")
		public AdjustableOrRelativeDate getAdditionalPaymentDate() {
			return additionalPaymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentType")
		public PaymentType getPaymentType() {
			return paymentType;
		}
		
		@Override
		public ReturnSwapAdditionalPayment build() {
			return this;
		}
		
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder toBuilder() {
			ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getAdditionalPaymentAmount()).ifPresent(builder::setAdditionalPaymentAmount);
			ofNullable(getAdditionalPaymentDate()).ifPresent(builder::setAdditionalPaymentDate);
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAdditionalPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(additionalPaymentAmount, _that.getAdditionalPaymentAmount())) return false;
			if (!Objects.equals(additionalPaymentDate, _that.getAdditionalPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentAmount != null ? additionalPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentDate != null ? additionalPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAdditionalPayment {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"additionalPaymentAmount=" + this.additionalPaymentAmount + ", " +
				"additionalPaymentDate=" + this.additionalPaymentDate + ", " +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapAdditionalPayment  ***********************/
	class ReturnSwapAdditionalPaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected AdditionalPaymentAmount.AdditionalPaymentAmountBuilder additionalPaymentAmount;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder additionalPaymentDate;
		protected PaymentType.PaymentTypeBuilder paymentType;
	
		public ReturnSwapAdditionalPaymentBuilderImpl() {
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
		@RosettaAttribute("additionalPaymentAmount")
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getAdditionalPaymentAmount() {
			return additionalPaymentAmount;
		}
		
		@Override
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getOrCreateAdditionalPaymentAmount() {
			AdditionalPaymentAmount.AdditionalPaymentAmountBuilder result;
			if (additionalPaymentAmount!=null) {
				result = additionalPaymentAmount;
			}
			else {
				result = additionalPaymentAmount = AdditionalPaymentAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPaymentDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getAdditionalPaymentDate() {
			return additionalPaymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateAdditionalPaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (additionalPaymentDate!=null) {
				result = additionalPaymentDate;
			}
			else {
				result = additionalPaymentDate = AdjustableOrRelativeDate.builder();
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
		@RosettaAttribute("id")
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalPaymentAmount")
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentAmount(AdditionalPaymentAmount additionalPaymentAmount) {
			this.additionalPaymentAmount = additionalPaymentAmount==null?null:additionalPaymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalPaymentDate")
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentDate(AdjustableOrRelativeDate additionalPaymentDate) {
			this.additionalPaymentDate = additionalPaymentDate==null?null:additionalPaymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentType")
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPaymentType(PaymentType paymentType) {
			this.paymentType = paymentType==null?null:paymentType.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapAdditionalPayment build() {
			return new ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentImpl(this);
		}
		
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (additionalPaymentAmount!=null && !additionalPaymentAmount.prune().hasData()) additionalPaymentAmount = null;
			if (additionalPaymentDate!=null && !additionalPaymentDate.prune().hasData()) additionalPaymentDate = null;
			if (paymentType!=null && !paymentType.prune().hasData()) paymentType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getAdditionalPaymentAmount()!=null && getAdditionalPaymentAmount().hasData()) return true;
			if (getAdditionalPaymentDate()!=null && getAdditionalPaymentDate().hasData()) return true;
			if (getPaymentType()!=null && getPaymentType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder o = (ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getAdditionalPaymentAmount(), o.getAdditionalPaymentAmount(), this::setAdditionalPaymentAmount);
			merger.mergeRosetta(getAdditionalPaymentDate(), o.getAdditionalPaymentDate(), this::setAdditionalPaymentDate);
			merger.mergeRosetta(getPaymentType(), o.getPaymentType(), this::setPaymentType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAdditionalPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(additionalPaymentAmount, _that.getAdditionalPaymentAmount())) return false;
			if (!Objects.equals(additionalPaymentDate, _that.getAdditionalPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentAmount != null ? additionalPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentDate != null ? additionalPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAdditionalPaymentBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"additionalPaymentAmount=" + this.additionalPaymentAmount + ", " +
				"additionalPaymentDate=" + this.additionalPaymentDate + ", " +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}
}
