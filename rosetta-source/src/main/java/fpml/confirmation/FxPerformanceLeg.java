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
import fpml.confirmation.FxPerformanceLeg;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegBuilder;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegBuilderImpl;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegImpl;
import fpml.confirmation.PayerModel;
import fpml.confirmation.ReceiverModel;
import fpml.confirmation.meta.FxPerformanceLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Floating FX Rate describes Fixed FX Rate Payer and Fixed Rate
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxPerformanceLeg", builder=FxPerformanceLeg.FxPerformanceLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxPerformanceLeg extends RosettaModelObject {

	FxPerformanceLegMeta metaData = new FxPerformanceLegMeta();

	/*********************** Getter Methods  ***********************/
	PayerModel getPayerModel();
	ReceiverModel getReceiverModel();

	/*********************** Build Methods  ***********************/
	FxPerformanceLeg build();
	
	FxPerformanceLeg.FxPerformanceLegBuilder toBuilder();
	
	static FxPerformanceLeg.FxPerformanceLegBuilder builder() {
		return new FxPerformanceLeg.FxPerformanceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPerformanceLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxPerformanceLeg> getType() {
		return FxPerformanceLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerModel"), processor, PayerModel.class, getPayerModel());
		processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.class, getReceiverModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPerformanceLegBuilder extends FxPerformanceLeg, RosettaModelObjectBuilder {
		PayerModel.PayerModelBuilder getOrCreatePayerModel();
		PayerModel.PayerModelBuilder getPayerModel();
		ReceiverModel.ReceiverModelBuilder getOrCreateReceiverModel();
		ReceiverModel.ReceiverModelBuilder getReceiverModel();
		FxPerformanceLeg.FxPerformanceLegBuilder setPayerModel(PayerModel payerModel);
		FxPerformanceLeg.FxPerformanceLegBuilder setReceiverModel(ReceiverModel receiverModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerModel"), processor, PayerModel.PayerModelBuilder.class, getPayerModel());
			processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.ReceiverModelBuilder.class, getReceiverModel());
		}
		

		FxPerformanceLeg.FxPerformanceLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxPerformanceLeg  ***********************/
	class FxPerformanceLegImpl implements FxPerformanceLeg {
		private final PayerModel payerModel;
		private final ReceiverModel receiverModel;
		
		protected FxPerformanceLegImpl(FxPerformanceLeg.FxPerformanceLegBuilder builder) {
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
		public FxPerformanceLeg build() {
			return this;
		}
		
		@Override
		public FxPerformanceLeg.FxPerformanceLegBuilder toBuilder() {
			FxPerformanceLeg.FxPerformanceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPerformanceLeg.FxPerformanceLegBuilder builder) {
			ofNullable(getPayerModel()).ifPresent(builder::setPayerModel);
			ofNullable(getReceiverModel()).ifPresent(builder::setReceiverModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPerformanceLeg _that = getType().cast(o);
		
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
			return "FxPerformanceLeg {" +
				"payerModel=" + this.payerModel + ", " +
				"receiverModel=" + this.receiverModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FxPerformanceLeg  ***********************/
	class FxPerformanceLegBuilderImpl implements FxPerformanceLeg.FxPerformanceLegBuilder {
	
		protected PayerModel.PayerModelBuilder payerModel;
		protected ReceiverModel.ReceiverModelBuilder receiverModel;
	
		public FxPerformanceLegBuilderImpl() {
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
		public FxPerformanceLeg.FxPerformanceLegBuilder setPayerModel(PayerModel payerModel) {
			this.payerModel = payerModel==null?null:payerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("receiverModel")
		public FxPerformanceLeg.FxPerformanceLegBuilder setReceiverModel(ReceiverModel receiverModel) {
			this.receiverModel = receiverModel==null?null:receiverModel.toBuilder();
			return this;
		}
		
		@Override
		public FxPerformanceLeg build() {
			return new FxPerformanceLeg.FxPerformanceLegImpl(this);
		}
		
		@Override
		public FxPerformanceLeg.FxPerformanceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceLeg.FxPerformanceLegBuilder prune() {
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
		public FxPerformanceLeg.FxPerformanceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxPerformanceLeg.FxPerformanceLegBuilder o = (FxPerformanceLeg.FxPerformanceLegBuilder) other;
			
			merger.mergeRosetta(getPayerModel(), o.getPayerModel(), this::setPayerModel);
			merger.mergeRosetta(getReceiverModel(), o.getReceiverModel(), this::setReceiverModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPerformanceLeg _that = getType().cast(o);
		
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
			return "FxPerformanceLegBuilder {" +
				"payerModel=" + this.payerModel + ", " +
				"receiverModel=" + this.receiverModel +
			'}';
		}
	}
}
