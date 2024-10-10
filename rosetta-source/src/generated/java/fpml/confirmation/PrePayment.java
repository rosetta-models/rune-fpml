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
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.PrePayment;
import fpml.confirmation.PrePayment.PrePaymentBuilder;
import fpml.confirmation.PrePayment.PrePaymentBuilderImpl;
import fpml.confirmation.PrePayment.PrePaymentImpl;
import fpml.confirmation.meta.PrePaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining PrePayment.
 * @version ${project.version}
 */
@RosettaDataType(value="PrePayment", builder=PrePayment.PrePaymentBuilderImpl.class, version="${project.version}")
public interface PrePayment extends PaymentBase {

	PrePaymentMeta metaData = new PrePaymentMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	Boolean getPrePayment();
	NonNegativeMoney getPrePaymentAmount();
	AdjustableDate getPrePaymentDate();

	/*********************** Build Methods  ***********************/
	PrePayment build();
	
	PrePayment.PrePaymentBuilder toBuilder();
	
	static PrePayment.PrePaymentBuilder builder() {
		return new PrePayment.PrePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrePayment> getType() {
		return PrePayment.class;
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
	interface PrePaymentBuilder extends PrePayment, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrePaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPrePaymentAmount();
		AdjustableDate.AdjustableDateBuilder getOrCreatePrePaymentDate();
		AdjustableDate.AdjustableDateBuilder getPrePaymentDate();
		PrePayment.PrePaymentBuilder setId(String id);
		PrePayment.PrePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		PrePayment.PrePaymentBuilder setPrePayment(Boolean prePayment);
		PrePayment.PrePaymentBuilder setPrePaymentAmount(NonNegativeMoney prePaymentAmount);
		PrePayment.PrePaymentBuilder setPrePaymentDate(AdjustableDate prePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processor.processBasic(path.newSubPath("prePayment"), Boolean.class, getPrePayment(), this);
			processRosetta(path.newSubPath("prePaymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPrePaymentAmount());
			processRosetta(path.newSubPath("prePaymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPrePaymentDate());
		}
		

		PrePayment.PrePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of PrePayment  ***********************/
	class PrePaymentImpl extends PaymentBase.PaymentBaseImpl implements PrePayment {
		private final PayerReceiverModel payerReceiverModel;
		private final Boolean prePayment;
		private final NonNegativeMoney prePaymentAmount;
		private final AdjustableDate prePaymentDate;
		
		protected PrePaymentImpl(PrePayment.PrePaymentBuilder builder) {
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
		public PrePayment build() {
			return this;
		}
		
		@Override
		public PrePayment.PrePaymentBuilder toBuilder() {
			PrePayment.PrePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrePayment.PrePaymentBuilder builder) {
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
		
			PrePayment _that = getType().cast(o);
		
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
	class PrePaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements PrePayment.PrePaymentBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected Boolean prePayment;
		protected NonNegativeMoney.NonNegativeMoneyBuilder prePaymentAmount;
		protected AdjustableDate.AdjustableDateBuilder prePaymentDate;
	
		public PrePaymentBuilderImpl() {
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
		public PrePayment.PrePaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PrePayment.PrePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("prePayment")
		public PrePayment.PrePaymentBuilder setPrePayment(Boolean prePayment) {
			this.prePayment = prePayment==null?null:prePayment;
			return this;
		}
		@Override
		@RosettaAttribute("prePaymentAmount")
		public PrePayment.PrePaymentBuilder setPrePaymentAmount(NonNegativeMoney prePaymentAmount) {
			this.prePaymentAmount = prePaymentAmount==null?null:prePaymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("prePaymentDate")
		public PrePayment.PrePaymentBuilder setPrePaymentDate(AdjustableDate prePaymentDate) {
			this.prePaymentDate = prePaymentDate==null?null:prePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public PrePayment build() {
			return new PrePayment.PrePaymentImpl(this);
		}
		
		@Override
		public PrePayment.PrePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrePayment.PrePaymentBuilder prune() {
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
		public PrePayment.PrePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PrePayment.PrePaymentBuilder o = (PrePayment.PrePaymentBuilder) other;
			
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
		
			PrePayment _that = getType().cast(o);
		
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
