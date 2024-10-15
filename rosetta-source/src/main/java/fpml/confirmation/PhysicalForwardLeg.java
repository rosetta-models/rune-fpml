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
import fpml.confirmation.CommodityForwardLeg;
import fpml.confirmation.CommodityForwardLeg.CommodityForwardLegBuilder;
import fpml.confirmation.CommodityForwardLeg.CommodityForwardLegBuilderImpl;
import fpml.confirmation.CommodityForwardLeg.CommodityForwardLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalForwardLeg;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegBuilder;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegBuilderImpl;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegImpl;
import fpml.confirmation.meta.PhysicalForwardLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The common components of a physically settled leg of a Commodity Forward. This is an abstract type and should be extended by commodity-specific types.
 * @version ${project.version}
 */
@RosettaDataType(value="PhysicalForwardLeg", builder=PhysicalForwardLeg.PhysicalForwardLegBuilderImpl.class, version="${project.version}")
public interface PhysicalForwardLeg extends CommodityForwardLeg {

	PhysicalForwardLegMeta metaData = new PhysicalForwardLegMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();

	/*********************** Build Methods  ***********************/
	PhysicalForwardLeg build();
	
	PhysicalForwardLeg.PhysicalForwardLegBuilder toBuilder();
	
	static PhysicalForwardLeg.PhysicalForwardLegBuilder builder() {
		return new PhysicalForwardLeg.PhysicalForwardLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PhysicalForwardLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PhysicalForwardLeg> getType() {
		return PhysicalForwardLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PhysicalForwardLegBuilder extends PhysicalForwardLeg, CommodityForwardLeg.CommodityForwardLegBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		PhysicalForwardLeg.PhysicalForwardLegBuilder setId(String id);
		PhysicalForwardLeg.PhysicalForwardLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
		}
		

		PhysicalForwardLeg.PhysicalForwardLegBuilder prune();
	}

	/*********************** Immutable Implementation of PhysicalForwardLeg  ***********************/
	class PhysicalForwardLegImpl extends CommodityForwardLeg.CommodityForwardLegImpl implements PhysicalForwardLeg {
		private final PayerReceiverModel payerReceiverModel;
		
		protected PhysicalForwardLegImpl(PhysicalForwardLeg.PhysicalForwardLegBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PhysicalForwardLeg build() {
			return this;
		}
		
		@Override
		public PhysicalForwardLeg.PhysicalForwardLegBuilder toBuilder() {
			PhysicalForwardLeg.PhysicalForwardLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalForwardLeg.PhysicalForwardLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalForwardLeg _that = getType().cast(o);
		
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
			return "PhysicalForwardLeg {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PhysicalForwardLeg  ***********************/
	class PhysicalForwardLegBuilderImpl extends CommodityForwardLeg.CommodityForwardLegBuilderImpl  implements PhysicalForwardLeg.PhysicalForwardLegBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
	
		public PhysicalForwardLegBuilderImpl() {
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
		public PhysicalForwardLeg.PhysicalForwardLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PhysicalForwardLeg.PhysicalForwardLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		
		@Override
		public PhysicalForwardLeg build() {
			return new PhysicalForwardLeg.PhysicalForwardLegImpl(this);
		}
		
		@Override
		public PhysicalForwardLeg.PhysicalForwardLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalForwardLeg.PhysicalForwardLegBuilder prune() {
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
		public PhysicalForwardLeg.PhysicalForwardLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PhysicalForwardLeg.PhysicalForwardLegBuilder o = (PhysicalForwardLeg.PhysicalForwardLegBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalForwardLeg _that = getType().cast(o);
		
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
			return "PhysicalForwardLegBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}
}
