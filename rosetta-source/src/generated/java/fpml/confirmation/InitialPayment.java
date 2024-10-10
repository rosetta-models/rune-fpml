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
import fpml.confirmation.InitialPayment;
import fpml.confirmation.InitialPayment.InitialPaymentBuilder;
import fpml.confirmation.InitialPayment.InitialPaymentBuilderImpl;
import fpml.confirmation.InitialPayment.InitialPaymentImpl;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.meta.InitialPaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InitialPayment", builder=InitialPayment.InitialPaymentBuilderImpl.class, version="${project.version}")
public interface InitialPayment extends PaymentBase {

	InitialPaymentMeta metaData = new InitialPaymentMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * A fixed payment date that shall be subject to adjustment in accordance with the applicable business day convention if it would otherwise fall on a day that is not a business day. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component.
	 */
	Date getAdjustablePaymentDate();
	/**
	 * The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
	 */
	Date getAdjustedPaymentDate();
	/**
	 * A fixed payment amount.
	 */
	Money getPaymentAmount();

	/*********************** Build Methods  ***********************/
	InitialPayment build();
	
	InitialPayment.InitialPaymentBuilder toBuilder();
	
	static InitialPayment.InitialPaymentBuilder builder() {
		return new InitialPayment.InitialPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InitialPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InitialPayment> getType() {
		return InitialPayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processor.processBasic(path.newSubPath("adjustablePaymentDate"), Date.class, getAdjustablePaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InitialPaymentBuilder extends InitialPayment, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		Money.MoneyBuilder getOrCreatePaymentAmount();
		Money.MoneyBuilder getPaymentAmount();
		InitialPayment.InitialPaymentBuilder setId(String id);
		InitialPayment.InitialPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		InitialPayment.InitialPaymentBuilder setAdjustablePaymentDate(Date adjustablePaymentDate);
		InitialPayment.InitialPaymentBuilder setAdjustedPaymentDate(Date adjustedPaymentDate);
		InitialPayment.InitialPaymentBuilder setPaymentAmount(Money paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processor.processBasic(path.newSubPath("adjustablePaymentDate"), Date.class, getAdjustablePaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
		}
		

		InitialPayment.InitialPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of InitialPayment  ***********************/
	class InitialPaymentImpl extends PaymentBase.PaymentBaseImpl implements InitialPayment {
		private final PayerReceiverModel payerReceiverModel;
		private final Date adjustablePaymentDate;
		private final Date adjustedPaymentDate;
		private final Money paymentAmount;
		
		protected InitialPaymentImpl(InitialPayment.InitialPaymentBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.adjustablePaymentDate = builder.getAdjustablePaymentDate();
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("adjustablePaymentDate")
		public Date getAdjustablePaymentDate() {
			return adjustablePaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public InitialPayment build() {
			return this;
		}
		
		@Override
		public InitialPayment.InitialPaymentBuilder toBuilder() {
			InitialPayment.InitialPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InitialPayment.InitialPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getAdjustablePaymentDate()).ifPresent(builder::setAdjustablePaymentDate);
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InitialPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialPayment {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InitialPayment  ***********************/
	class InitialPaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements InitialPayment.InitialPaymentBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected Date adjustablePaymentDate;
		protected Date adjustedPaymentDate;
		protected Money.MoneyBuilder paymentAmount;
	
		public InitialPaymentBuilderImpl() {
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
		@RosettaAttribute("adjustablePaymentDate")
		public Date getAdjustablePaymentDate() {
			return adjustablePaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
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
		@RosettaAttribute("id")
		public InitialPayment.InitialPaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public InitialPayment.InitialPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustablePaymentDate")
		public InitialPayment.InitialPaymentBuilder setAdjustablePaymentDate(Date adjustablePaymentDate) {
			this.adjustablePaymentDate = adjustablePaymentDate==null?null:adjustablePaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public InitialPayment.InitialPaymentBuilder setAdjustedPaymentDate(Date adjustedPaymentDate) {
			this.adjustedPaymentDate = adjustedPaymentDate==null?null:adjustedPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public InitialPayment.InitialPaymentBuilder setPaymentAmount(Money paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public InitialPayment build() {
			return new InitialPayment.InitialPaymentImpl(this);
		}
		
		@Override
		public InitialPayment.InitialPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialPayment.InitialPaymentBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getAdjustablePaymentDate()!=null) return true;
			if (getAdjustedPaymentDate()!=null) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialPayment.InitialPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InitialPayment.InitialPaymentBuilder o = (InitialPayment.InitialPaymentBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			merger.mergeBasic(getAdjustablePaymentDate(), o.getAdjustablePaymentDate(), this::setAdjustablePaymentDate);
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InitialPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialPaymentBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}
}
