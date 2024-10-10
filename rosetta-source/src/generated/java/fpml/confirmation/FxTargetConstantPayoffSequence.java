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
import fpml.confirmation.FxTargetConstantPayoffSequence;
import fpml.confirmation.FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder;
import fpml.confirmation.FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilderImpl;
import fpml.confirmation.FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.meta.FxTargetConstantPayoffSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetConstantPayoffSequence", builder=FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilderImpl.class, version="${project.version}")
public interface FxTargetConstantPayoffSequence extends RosettaModelObject {

	FxTargetConstantPayoffSequenceMeta metaData = new FxTargetConstantPayoffSequenceMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Cash payment.
	 */
	PositiveMoney getPayment();

	/*********************** Build Methods  ***********************/
	FxTargetConstantPayoffSequence build();
	
	FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder toBuilder();
	
	static FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder builder() {
		return new FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetConstantPayoffSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetConstantPayoffSequence> getType() {
		return FxTargetConstantPayoffSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("payment"), processor, PositiveMoney.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetConstantPayoffSequenceBuilder extends FxTargetConstantPayoffSequence, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		PositiveMoney.PositiveMoneyBuilder getOrCreatePayment();
		PositiveMoney.PositiveMoneyBuilder getPayment();
		FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder setPayment(PositiveMoney payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("payment"), processor, PositiveMoney.PositiveMoneyBuilder.class, getPayment());
		}
		

		FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetConstantPayoffSequence  ***********************/
	class FxTargetConstantPayoffSequenceImpl implements FxTargetConstantPayoffSequence {
		private final PayerReceiverModel payerReceiverModel;
		private final PositiveMoney payment;
		
		protected FxTargetConstantPayoffSequenceImpl(FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("payment")
		public PositiveMoney getPayment() {
			return payment;
		}
		
		@Override
		public FxTargetConstantPayoffSequence build() {
			return this;
		}
		
		@Override
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder toBuilder() {
			FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConstantPayoffSequence _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffSequence {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"payment=" + this.payment +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetConstantPayoffSequence  ***********************/
	class FxTargetConstantPayoffSequenceBuilderImpl implements FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected PositiveMoney.PositiveMoneyBuilder payment;
	
		public FxTargetConstantPayoffSequenceBuilderImpl() {
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
		@RosettaAttribute("payment")
		public PositiveMoney.PositiveMoneyBuilder getPayment() {
			return payment;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreatePayment() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder setPayment(PositiveMoney payment) {
			this.payment = payment==null?null:payment.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetConstantPayoffSequence build() {
			return new FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceImpl(this);
		}
		
		@Override
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder o = (FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConstantPayoffSequence _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffSequenceBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"payment=" + this.payment +
			'}';
		}
	}
}
