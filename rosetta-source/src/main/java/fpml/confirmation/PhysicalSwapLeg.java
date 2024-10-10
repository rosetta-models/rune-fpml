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
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalSwapLeg;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilder;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilderImpl;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegImpl;
import fpml.confirmation.meta.PhysicalSwapLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The common components of a physically settled leg of a Commodity Swap. This is an abstract type and should be extended by commodity-specific types.
 * @version ${project.version}
 */
@RosettaDataType(value="PhysicalSwapLeg", builder=PhysicalSwapLeg.PhysicalSwapLegBuilderImpl.class, version="${project.version}")
public interface PhysicalSwapLeg extends CommoditySwapLeg {

	PhysicalSwapLegMeta metaData = new PhysicalSwapLegMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();

	/*********************** Build Methods  ***********************/
	PhysicalSwapLeg build();
	
	PhysicalSwapLeg.PhysicalSwapLegBuilder toBuilder();
	
	static PhysicalSwapLeg.PhysicalSwapLegBuilder builder() {
		return new PhysicalSwapLeg.PhysicalSwapLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PhysicalSwapLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PhysicalSwapLeg> getType() {
		return PhysicalSwapLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PhysicalSwapLegBuilder extends PhysicalSwapLeg, CommoditySwapLeg.CommoditySwapLegBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		PhysicalSwapLeg.PhysicalSwapLegBuilder setId(String id);
		PhysicalSwapLeg.PhysicalSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
		}
		

		PhysicalSwapLeg.PhysicalSwapLegBuilder prune();
	}

	/*********************** Immutable Implementation of PhysicalSwapLeg  ***********************/
	class PhysicalSwapLegImpl extends CommoditySwapLeg.CommoditySwapLegImpl implements PhysicalSwapLeg {
		private final PayerReceiverModel payerReceiverModel;
		
		protected PhysicalSwapLegImpl(PhysicalSwapLeg.PhysicalSwapLegBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PhysicalSwapLeg build() {
			return this;
		}
		
		@Override
		public PhysicalSwapLeg.PhysicalSwapLegBuilder toBuilder() {
			PhysicalSwapLeg.PhysicalSwapLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalSwapLeg.PhysicalSwapLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalSwapLeg _that = getType().cast(o);
		
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
			return "PhysicalSwapLeg {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PhysicalSwapLeg  ***********************/
	class PhysicalSwapLegBuilderImpl extends CommoditySwapLeg.CommoditySwapLegBuilderImpl  implements PhysicalSwapLeg.PhysicalSwapLegBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
	
		public PhysicalSwapLegBuilderImpl() {
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
		public PhysicalSwapLeg.PhysicalSwapLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PhysicalSwapLeg.PhysicalSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		
		@Override
		public PhysicalSwapLeg build() {
			return new PhysicalSwapLeg.PhysicalSwapLegImpl(this);
		}
		
		@Override
		public PhysicalSwapLeg.PhysicalSwapLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSwapLeg.PhysicalSwapLegBuilder prune() {
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
		public PhysicalSwapLeg.PhysicalSwapLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PhysicalSwapLeg.PhysicalSwapLegBuilder o = (PhysicalSwapLeg.PhysicalSwapLegBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalSwapLeg _that = getType().cast(o);
		
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
			return "PhysicalSwapLegBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}
}
