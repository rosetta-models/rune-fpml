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
import fpml.confirmation.CommoditySwapLeg;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilder;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilderImpl;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegImpl;
import fpml.confirmation.FinancialSwapLeg;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilder;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilderImpl;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.FinancialSwapLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The common components of a financially settled leg of a Commodity Swap. This is an abstract type and should be extended by commodity-specific types.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FinancialSwapLeg", builder=FinancialSwapLeg.FinancialSwapLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FinancialSwapLeg extends CommoditySwapLeg {

	FinancialSwapLegMeta metaData = new FinancialSwapLegMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();

	/*********************** Build Methods  ***********************/
	FinancialSwapLeg build();
	
	FinancialSwapLeg.FinancialSwapLegBuilder toBuilder();
	
	static FinancialSwapLeg.FinancialSwapLegBuilder builder() {
		return new FinancialSwapLeg.FinancialSwapLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinancialSwapLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FinancialSwapLeg> getType() {
		return FinancialSwapLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinancialSwapLegBuilder extends FinancialSwapLeg, CommoditySwapLeg.CommoditySwapLegBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		FinancialSwapLeg.FinancialSwapLegBuilder setId(String id);
		FinancialSwapLeg.FinancialSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
		}
		

		FinancialSwapLeg.FinancialSwapLegBuilder prune();
	}

	/*********************** Immutable Implementation of FinancialSwapLeg  ***********************/
	class FinancialSwapLegImpl extends CommoditySwapLeg.CommoditySwapLegImpl implements FinancialSwapLeg {
		private final PayerReceiverModel payerReceiverModel;
		
		protected FinancialSwapLegImpl(FinancialSwapLeg.FinancialSwapLegBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public FinancialSwapLeg build() {
			return this;
		}
		
		@Override
		public FinancialSwapLeg.FinancialSwapLegBuilder toBuilder() {
			FinancialSwapLeg.FinancialSwapLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinancialSwapLeg.FinancialSwapLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FinancialSwapLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialSwapLeg {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FinancialSwapLeg  ***********************/
	class FinancialSwapLegBuilderImpl extends CommoditySwapLeg.CommoditySwapLegBuilderImpl  implements FinancialSwapLeg.FinancialSwapLegBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
	
		public FinancialSwapLegBuilderImpl() {
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
		@RosettaAttribute("id")
		public FinancialSwapLeg.FinancialSwapLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FinancialSwapLeg.FinancialSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		
		@Override
		public FinancialSwapLeg build() {
			return new FinancialSwapLeg.FinancialSwapLegImpl(this);
		}
		
		@Override
		public FinancialSwapLeg.FinancialSwapLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialSwapLeg.FinancialSwapLegBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialSwapLeg.FinancialSwapLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FinancialSwapLeg.FinancialSwapLegBuilder o = (FinancialSwapLeg.FinancialSwapLegBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FinancialSwapLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialSwapLegBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}
}
