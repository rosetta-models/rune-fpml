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
import fpml.confirmation.Prepayment.PrepaymentBuilderImpl;
import fpml.confirmation.meta.PrePaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining PrePayment.
 * @version ${project.version}
 */
@RosettaDataType(value="PrePayment", builder= PrepaymentBuilderImpl.class, version="${project.version}")
public interface Prepayment extends PaymentBase {

	PrePaymentMeta metaData = new PrePaymentMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	Boolean getPrePayment();
	NonNegativeMoney getPrePaymentAmount();
	AdjustableDate getPrePaymentDate();

	/*********************** Build Methods  ***********************/
	Prepayment build();
	
	PrepaymentBuilder toBuilder();
	
	static PrepaymentBuilder builder() {
		return new PrepaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Prepayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Prepayment> getType() {
		return Prepayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processor.processBasic(path.newSubPath("prePayment"), Boolean.class, getPrePayment(), this);
		processRosetta(path.newSubPath("prePaymentAmount"), processor, NonNegativeMoney.class, getPrePaymentAmount());
		processRosetta(path.newSubPath("prePaymentDate"), processor, AdjustableDate.class, getPrePaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrepaymentBuilder extends Prepayment, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrePaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPrePaymentAmount();
		AdjustableDate.AdjustableDateBuilder getOrCreatePrePaymentDate();
		AdjustableDate.AdjustableDateBuilder getPrePaymentDate();
		PrepaymentBuilder setId(String id);
		PrepaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		PrepaymentBuilder setPrePayment(Boolean prePayment);
		PrepaymentBuilder setPrePaymentAmount(NonNegativeMoney prePaymentAmount);
		PrepaymentBuilder setPrePaymentDate(AdjustableDate prePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processor.processBasic(path.newSubPath("prePayment"), Boolean.class, getPrePayment(), this);
			processRosetta(path.newSubPath("prePaymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPrePaymentAmount());
			processRosetta(path.newSubPath("prePaymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPrePaymentDate());
		}
		

		PrepaymentBuilder prune();
	}

	/*********************** Immutable Implementation of PrePayment  ***********************/
	class PrepaymentImpl extends PaymentBase.PaymentBaseImpl implements Prepayment {
		private final PayerReceiverModel payerReceiverModel;
		private final Boolean prePayment;
		private final NonNegativeMoney prePaymentAmount;
		private final AdjustableDate prePaymentDate;
		
		protected PrepaymentImpl(PrepaymentBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.prePayment = builder.getPrePayment();
			this.prePaymentAmount = ofNullable(builder.getPrePaymentAmount()).map(f->f.build()).orElse(null);
			this.prePaymentDate = ofNullable(builder.getPrePaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("prePayment")
		public Boolean getPrePayment() {
			return prePayment;
		}
		
		@Override
		@RosettaAttribute("prePaymentAmount")
		public NonNegativeMoney getPrePaymentAmount() {
			return prePaymentAmount;
		}
		
		@Override
		@RosettaAttribute("prePaymentDate")
		public AdjustableDate getPrePaymentDate() {
			return prePaymentDate;
		}
		
		@Override
		public Prepayment build() {
			return this;
		}
		
		@Override
		public PrepaymentBuilder toBuilder() {
			PrepaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrepaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getPrePayment()).ifPresent(builder::setPrePayment);
			ofNullable(getPrePaymentAmount()).ifPresent(builder::setPrePaymentAmount);
			ofNullable(getPrePaymentDate()).ifPresent(builder::setPrePaymentDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Prepayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(prePaymentAmount, _that.getPrePaymentAmount())) return false;
			if (!Objects.equals(prePaymentDate, _that.getPrePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (prePaymentAmount != null ? prePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (prePaymentDate != null ? prePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrePayment {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"prePayment=" + this.prePayment + ", " +
				"prePaymentAmount=" + this.prePaymentAmount + ", " +
				"prePaymentDate=" + this.prePaymentDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PrePayment  ***********************/
	class PrepaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements PrepaymentBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected Boolean prePayment;
		protected NonNegativeMoney.NonNegativeMoneyBuilder prePaymentAmount;
		protected AdjustableDate.AdjustableDateBuilder prePaymentDate;
	
		public PrepaymentBuilderImpl() {
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
		@RosettaAttribute("prePayment")
		public Boolean getPrePayment() {
			return prePayment;
		}
		
		@Override
		@RosettaAttribute("prePaymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPrePaymentAmount() {
			return prePaymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrePaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (prePaymentAmount!=null) {
				result = prePaymentAmount;
			}
			else {
				result = prePaymentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prePaymentDate")
		public AdjustableDate.AdjustableDateBuilder getPrePaymentDate() {
			return prePaymentDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreatePrePaymentDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (prePaymentDate!=null) {
				result = prePaymentDate;
			}
			else {
				result = prePaymentDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public PrepaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PrepaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("prePayment")
		public PrepaymentBuilder setPrePayment(Boolean prePayment) {
			this.prePayment = prePayment==null?null:prePayment;
			return this;
		}
		@Override
		@RosettaAttribute("prePaymentAmount")
		public PrepaymentBuilder setPrePaymentAmount(NonNegativeMoney prePaymentAmount) {
			this.prePaymentAmount = prePaymentAmount==null?null:prePaymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("prePaymentDate")
		public PrepaymentBuilder setPrePaymentDate(AdjustableDate prePaymentDate) {
			this.prePaymentDate = prePaymentDate==null?null:prePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public Prepayment build() {
			return new PrepaymentImpl(this);
		}
		
		@Override
		public PrepaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrepaymentBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (prePaymentAmount!=null && !prePaymentAmount.prune().hasData()) prePaymentAmount = null;
			if (prePaymentDate!=null && !prePaymentDate.prune().hasData()) prePaymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getPrePayment()!=null) return true;
			if (getPrePaymentAmount()!=null && getPrePaymentAmount().hasData()) return true;
			if (getPrePaymentDate()!=null && getPrePaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrepaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PrepaymentBuilder o = (PrepaymentBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPrePaymentAmount(), o.getPrePaymentAmount(), this::setPrePaymentAmount);
			merger.mergeRosetta(getPrePaymentDate(), o.getPrePaymentDate(), this::setPrePaymentDate);
			
			merger.mergeBasic(getPrePayment(), o.getPrePayment(), this::setPrePayment);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Prepayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(prePaymentAmount, _that.getPrePaymentAmount())) return false;
			if (!Objects.equals(prePaymentDate, _that.getPrePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (prePaymentAmount != null ? prePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (prePaymentDate != null ? prePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrePaymentBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"prePayment=" + this.prePayment + ", " +
				"prePaymentAmount=" + this.prePaymentAmount + ", " +
				"prePaymentDate=" + this.prePaymentDate +
			'}' + " " + super.toString();
		}
	}
}
