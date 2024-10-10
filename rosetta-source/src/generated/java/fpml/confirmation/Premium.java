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
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentDiscountingModel;
import fpml.confirmation.Premium;
import fpml.confirmation.Premium.PremiumBuilder;
import fpml.confirmation.Premium.PremiumBuilderImpl;
import fpml.confirmation.Premium.PremiumImpl;
import fpml.confirmation.PremiumModel;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.SimplePayment.SimplePaymentBuilder;
import fpml.confirmation.SimplePayment.SimplePaymentBuilderImpl;
import fpml.confirmation.SimplePayment.SimplePaymentImpl;
import fpml.confirmation.meta.PremiumMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining a premium.
 * @version ${project.version}
 */
@RosettaDataType(value="Premium", builder=Premium.PremiumBuilderImpl.class, version="${project.version}")
public interface Premium extends SimplePayment {

	PremiumMeta metaData = new PremiumMeta();

	/*********************** Getter Methods  ***********************/
	PremiumModel getPremiumModel();
	PaymentDiscountingModel getPaymentDiscountingModel();

	/*********************** Build Methods  ***********************/
	Premium build();
	
	Premium.PremiumBuilder toBuilder();
	
	static Premium.PremiumBuilder builder() {
		return new Premium.PremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Premium> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Premium> getType() {
		return Premium.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("premiumModel"), processor, PremiumModel.class, getPremiumModel());
		processRosetta(path.newSubPath("paymentDiscountingModel"), processor, PaymentDiscountingModel.class, getPaymentDiscountingModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PremiumBuilder extends Premium, SimplePayment.SimplePaymentBuilder {
		PremiumModel.PremiumModelBuilder getOrCreatePremiumModel();
		PremiumModel.PremiumModelBuilder getPremiumModel();
		PaymentDiscountingModel.PaymentDiscountingModelBuilder getOrCreatePaymentDiscountingModel();
		PaymentDiscountingModel.PaymentDiscountingModelBuilder getPaymentDiscountingModel();
		Premium.PremiumBuilder setId(String id);
		Premium.PremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		Premium.PremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		Premium.PremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		Premium.PremiumBuilder setPremiumModel(PremiumModel premiumModel);
		Premium.PremiumBuilder setPaymentDiscountingModel(PaymentDiscountingModel paymentDiscountingModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("premiumModel"), processor, PremiumModel.PremiumModelBuilder.class, getPremiumModel());
			processRosetta(path.newSubPath("paymentDiscountingModel"), processor, PaymentDiscountingModel.PaymentDiscountingModelBuilder.class, getPaymentDiscountingModel());
		}
		

		Premium.PremiumBuilder prune();
	}

	/*********************** Immutable Implementation of Premium  ***********************/
	class PremiumImpl extends SimplePayment.SimplePaymentImpl implements Premium {
		private final PremiumModel premiumModel;
		private final PaymentDiscountingModel paymentDiscountingModel;
		
		protected PremiumImpl(Premium.PremiumBuilder builder) {
			super(builder);
			this.premiumModel = ofNullable(builder.getPremiumModel()).map(f->f.build()).orElse(null);
			this.paymentDiscountingModel = ofNullable(builder.getPaymentDiscountingModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("premiumModel")
		public PremiumModel getPremiumModel() {
			return premiumModel;
		}
		
		@Override
		@RosettaAttribute("paymentDiscountingModel")
		public PaymentDiscountingModel getPaymentDiscountingModel() {
			return paymentDiscountingModel;
		}
		
		@Override
		public Premium build() {
			return this;
		}
		
		@Override
		public Premium.PremiumBuilder toBuilder() {
			Premium.PremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Premium.PremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPremiumModel()).ifPresent(builder::setPremiumModel);
			ofNullable(getPaymentDiscountingModel()).ifPresent(builder::setPaymentDiscountingModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Premium _that = getType().cast(o);
		
			if (!Objects.equals(premiumModel, _that.getPremiumModel())) return false;
			if (!Objects.equals(paymentDiscountingModel, _that.getPaymentDiscountingModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumModel != null ? premiumModel.hashCode() : 0);
			_result = 31 * _result + (paymentDiscountingModel != null ? paymentDiscountingModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Premium {" +
				"premiumModel=" + this.premiumModel + ", " +
				"paymentDiscountingModel=" + this.paymentDiscountingModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Premium  ***********************/
	class PremiumBuilderImpl extends SimplePayment.SimplePaymentBuilderImpl  implements Premium.PremiumBuilder {
	
		protected PremiumModel.PremiumModelBuilder premiumModel;
		protected PaymentDiscountingModel.PaymentDiscountingModelBuilder paymentDiscountingModel;
	
		public PremiumBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("premiumModel")
		public PremiumModel.PremiumModelBuilder getPremiumModel() {
			return premiumModel;
		}
		
		@Override
		public PremiumModel.PremiumModelBuilder getOrCreatePremiumModel() {
			PremiumModel.PremiumModelBuilder result;
			if (premiumModel!=null) {
				result = premiumModel;
			}
			else {
				result = premiumModel = PremiumModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDiscountingModel")
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder getPaymentDiscountingModel() {
			return paymentDiscountingModel;
		}
		
		@Override
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder getOrCreatePaymentDiscountingModel() {
			PaymentDiscountingModel.PaymentDiscountingModelBuilder result;
			if (paymentDiscountingModel!=null) {
				result = paymentDiscountingModel;
			}
			else {
				result = paymentDiscountingModel = PaymentDiscountingModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public Premium.PremiumBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public Premium.PremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public Premium.PremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public Premium.PremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premiumModel")
		public Premium.PremiumBuilder setPremiumModel(PremiumModel premiumModel) {
			this.premiumModel = premiumModel==null?null:premiumModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDiscountingModel")
		public Premium.PremiumBuilder setPaymentDiscountingModel(PaymentDiscountingModel paymentDiscountingModel) {
			this.paymentDiscountingModel = paymentDiscountingModel==null?null:paymentDiscountingModel.toBuilder();
			return this;
		}
		
		@Override
		public Premium build() {
			return new Premium.PremiumImpl(this);
		}
		
		@Override
		public Premium.PremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Premium.PremiumBuilder prune() {
			super.prune();
			if (premiumModel!=null && !premiumModel.prune().hasData()) premiumModel = null;
			if (paymentDiscountingModel!=null && !paymentDiscountingModel.prune().hasData()) paymentDiscountingModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPremiumModel()!=null && getPremiumModel().hasData()) return true;
			if (getPaymentDiscountingModel()!=null && getPaymentDiscountingModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Premium.PremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Premium.PremiumBuilder o = (Premium.PremiumBuilder) other;
			
			merger.mergeRosetta(getPremiumModel(), o.getPremiumModel(), this::setPremiumModel);
			merger.mergeRosetta(getPaymentDiscountingModel(), o.getPaymentDiscountingModel(), this::setPaymentDiscountingModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Premium _that = getType().cast(o);
		
			if (!Objects.equals(premiumModel, _that.getPremiumModel())) return false;
			if (!Objects.equals(paymentDiscountingModel, _that.getPaymentDiscountingModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumModel != null ? premiumModel.hashCode() : 0);
			_result = 31 * _result + (paymentDiscountingModel != null ? paymentDiscountingModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumBuilder {" +
				"premiumModel=" + this.premiumModel + ", " +
				"paymentDiscountingModel=" + this.paymentDiscountingModel +
			'}' + " " + super.toString();
		}
	}
}
