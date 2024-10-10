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
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.PaymentBaseExtended;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedBuilder;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedBuilderImpl;
import fpml.confirmation.PaymentBaseExtended.PaymentBaseExtendedImpl;
import fpml.confirmation.meta.PaymentBaseExtendedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Base type for payments.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentBaseExtended", builder=PaymentBaseExtended.PaymentBaseExtendedBuilderImpl.class, version="${project.version}")
public interface PaymentBaseExtended extends PaymentBase {

	PaymentBaseExtendedMeta metaData = new PaymentBaseExtendedMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * The payment date, which can be expressed as either an adjustable or relative date.
	 */
	AdjustableOrRelativeDate getPaymentDate();

	/*********************** Build Methods  ***********************/
	PaymentBaseExtended build();
	
	PaymentBaseExtended.PaymentBaseExtendedBuilder toBuilder();
	
	static PaymentBaseExtended.PaymentBaseExtendedBuilder builder() {
		return new PaymentBaseExtended.PaymentBaseExtendedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentBaseExtended> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentBaseExtended> getType() {
		return PaymentBaseExtended.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentBaseExtendedBuilder extends PaymentBaseExtended, PaymentBase.PaymentBaseBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		PaymentBaseExtended.PaymentBaseExtendedBuilder setId(String id);
		PaymentBaseExtended.PaymentBaseExtendedBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		PaymentBaseExtended.PaymentBaseExtendedBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
		}
		

		PaymentBaseExtended.PaymentBaseExtendedBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentBaseExtended  ***********************/
	class PaymentBaseExtendedImpl extends PaymentBase.PaymentBaseImpl implements PaymentBaseExtended {
		private final PayerReceiverModel payerReceiverModel;
		private final AdjustableOrRelativeDate paymentDate;
		
		protected PaymentBaseExtendedImpl(PaymentBaseExtended.PaymentBaseExtendedBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public PaymentBaseExtended build() {
			return this;
		}
		
		@Override
		public PaymentBaseExtended.PaymentBaseExtendedBuilder toBuilder() {
			PaymentBaseExtended.PaymentBaseExtendedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentBaseExtended.PaymentBaseExtendedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentBaseExtended _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentBaseExtended {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PaymentBaseExtended  ***********************/
	class PaymentBaseExtendedBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements PaymentBaseExtended.PaymentBaseExtendedBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
	
		public PaymentBaseExtendedBuilderImpl() {
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
		@RosettaAttribute("id")
		public PaymentBaseExtended.PaymentBaseExtendedBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PaymentBaseExtended.PaymentBaseExtendedBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public PaymentBaseExtended.PaymentBaseExtendedBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		
		@Override
		public PaymentBaseExtended build() {
			return new PaymentBaseExtended.PaymentBaseExtendedImpl(this);
		}
		
		@Override
		public PaymentBaseExtended.PaymentBaseExtendedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentBaseExtended.PaymentBaseExtendedBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentBaseExtended.PaymentBaseExtendedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PaymentBaseExtended.PaymentBaseExtendedBuilder o = (PaymentBaseExtended.PaymentBaseExtendedBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentBaseExtended _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentBaseExtendedBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}
}
