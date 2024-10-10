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
import fpml.confirmation.PayerModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PayerReceiverModel.PayerReceiverModelBuilder;
import fpml.confirmation.PayerReceiverModel.PayerReceiverModelBuilderImpl;
import fpml.confirmation.PayerReceiverModel.PayerReceiverModelImpl;
import fpml.confirmation.ReceiverModel;
import fpml.confirmation.meta.PayerReceiverModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PayerReceiverModel", builder=PayerReceiverModel.PayerReceiverModelBuilderImpl.class, version="${project.version}")
public interface PayerReceiverModel extends RosettaModelObject {

	PayerReceiverModelMeta metaData = new PayerReceiverModelMeta();

	/*********************** Getter Methods  ***********************/
	PayerModel getPayerModel();
	ReceiverModel getReceiverModel();

	/*********************** Build Methods  ***********************/
	PayerReceiverModel build();
	
	PayerReceiverModel.PayerReceiverModelBuilder toBuilder();
	
	static PayerReceiverModel.PayerReceiverModelBuilder builder() {
		return new PayerReceiverModel.PayerReceiverModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PayerReceiverModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PayerReceiverModel> getType() {
		return PayerReceiverModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerModel"), processor, PayerModel.class, getPayerModel());
		processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.class, getReceiverModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PayerReceiverModelBuilder extends PayerReceiverModel, RosettaModelObjectBuilder {
		PayerModel.PayerModelBuilder getOrCreatePayerModel();
		PayerModel.PayerModelBuilder getPayerModel();
		ReceiverModel.ReceiverModelBuilder getOrCreateReceiverModel();
		ReceiverModel.ReceiverModelBuilder getReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder setPayerModel(PayerModel payerModel);
		PayerReceiverModel.PayerReceiverModelBuilder setReceiverModel(ReceiverModel receiverModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerModel"), processor, PayerModel.PayerModelBuilder.class, getPayerModel());
			processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.ReceiverModelBuilder.class, getReceiverModel());
		}
		

		PayerReceiverModel.PayerReceiverModelBuilder prune();
	}

	/*********************** Immutable Implementation of PayerReceiverModel  ***********************/
	class PayerReceiverModelImpl implements PayerReceiverModel {
		private final PayerModel payerModel;
		private final ReceiverModel receiverModel;
		
		protected PayerReceiverModelImpl(PayerReceiverModel.PayerReceiverModelBuilder builder) {
			this.payerModel = ofNullable(builder.getPayerModel()).map(f->f.build()).orElse(null);
			this.receiverModel = ofNullable(builder.getReceiverModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerModel")
		public PayerModel getPayerModel() {
			return payerModel;
		}
		
		@Override
		@RosettaAttribute("receiverModel")
		public ReceiverModel getReceiverModel() {
			return receiverModel;
		}
		
		@Override
		public PayerReceiverModel build() {
			return this;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder toBuilder() {
			PayerReceiverModel.PayerReceiverModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PayerReceiverModel.PayerReceiverModelBuilder builder) {
			ofNullable(getPayerModel()).ifPresent(builder::setPayerModel);
			ofNullable(getReceiverModel()).ifPresent(builder::setReceiverModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayerReceiverModel _that = getType().cast(o);
		
			if (!Objects.equals(payerModel, _that.getPayerModel())) return false;
			if (!Objects.equals(receiverModel, _that.getReceiverModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerModel != null ? payerModel.hashCode() : 0);
			_result = 31 * _result + (receiverModel != null ? receiverModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayerReceiverModel {" +
				"payerModel=" + this.payerModel + ", " +
				"receiverModel=" + this.receiverModel +
			'}';
		}
	}

	/*********************** Builder Implementation of PayerReceiverModel  ***********************/
	class PayerReceiverModelBuilderImpl implements PayerReceiverModel.PayerReceiverModelBuilder {
	
		protected PayerModel.PayerModelBuilder payerModel;
		protected ReceiverModel.ReceiverModelBuilder receiverModel;
	
		public PayerReceiverModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerModel")
		public PayerModel.PayerModelBuilder getPayerModel() {
			return payerModel;
		}
		
		@Override
		public PayerModel.PayerModelBuilder getOrCreatePayerModel() {
			PayerModel.PayerModelBuilder result;
			if (payerModel!=null) {
				result = payerModel;
			}
			else {
				result = payerModel = PayerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverModel")
		public ReceiverModel.ReceiverModelBuilder getReceiverModel() {
			return receiverModel;
		}
		
		@Override
		public ReceiverModel.ReceiverModelBuilder getOrCreateReceiverModel() {
			ReceiverModel.ReceiverModelBuilder result;
			if (receiverModel!=null) {
				result = receiverModel;
			}
			else {
				result = receiverModel = ReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerModel")
		public PayerReceiverModel.PayerReceiverModelBuilder setPayerModel(PayerModel payerModel) {
			this.payerModel = payerModel==null?null:payerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("receiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder setReceiverModel(ReceiverModel receiverModel) {
			this.receiverModel = receiverModel==null?null:receiverModel.toBuilder();
			return this;
		}
		
		@Override
		public PayerReceiverModel build() {
			return new PayerReceiverModel.PayerReceiverModelImpl(this);
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder prune() {
			if (payerModel!=null && !payerModel.prune().hasData()) payerModel = null;
			if (receiverModel!=null && !receiverModel.prune().hasData()) receiverModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerModel()!=null && getPayerModel().hasData()) return true;
			if (getReceiverModel()!=null && getReceiverModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PayerReceiverModel.PayerReceiverModelBuilder o = (PayerReceiverModel.PayerReceiverModelBuilder) other;
			
			merger.mergeRosetta(getPayerModel(), o.getPayerModel(), this::setPayerModel);
			merger.mergeRosetta(getReceiverModel(), o.getReceiverModel(), this::setReceiverModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayerReceiverModel _that = getType().cast(o);
		
			if (!Objects.equals(payerModel, _that.getPayerModel())) return false;
			if (!Objects.equals(receiverModel, _that.getReceiverModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerModel != null ? payerModel.hashCode() : 0);
			_result = 31 * _result + (receiverModel != null ? receiverModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayerReceiverModelBuilder {" +
				"payerModel=" + this.payerModel + ", " +
				"receiverModel=" + this.receiverModel +
			'}';
		}
	}
}
