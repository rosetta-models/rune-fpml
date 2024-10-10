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
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl;
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.CommodityPerformanceSwapLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A placeholder within &#39;commodityPerformanceSwap&#39; structure for the actual commodity swap legs (e.g. &#39;commodityReturnLeg&#39; and &#39;commodityInterestLeg&#39;). Abstract base class for all commodity performance swap legs.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPerformanceSwapLeg", builder=CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl.class, version="${project.version}")
public interface CommodityPerformanceSwapLeg extends Leg {

	CommodityPerformanceSwapLegMeta metaData = new CommodityPerformanceSwapLegMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();

	/*********************** Build Methods  ***********************/
	CommodityPerformanceSwapLeg build();
	
	CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder toBuilder();
	
	static CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder builder() {
		return new CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPerformanceSwapLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPerformanceSwapLeg> getType() {
		return CommodityPerformanceSwapLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPerformanceSwapLegBuilder extends CommodityPerformanceSwapLeg, Leg.LegBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder setId(String id);
		CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
		}
		

		CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPerformanceSwapLeg  ***********************/
	class CommodityPerformanceSwapLegImpl extends Leg.LegImpl implements CommodityPerformanceSwapLeg {
		private final PayerReceiverModel payerReceiverModel;
		
		protected CommodityPerformanceSwapLegImpl(CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public CommodityPerformanceSwapLeg build() {
			return this;
		}
		
		@Override
		public CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder toBuilder() {
			CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwapLeg _that = getType().cast(o);
		
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
			return "CommodityPerformanceSwapLeg {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPerformanceSwapLeg  ***********************/
	class CommodityPerformanceSwapLegBuilderImpl extends Leg.LegBuilderImpl  implements CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
	
		public CommodityPerformanceSwapLegBuilderImpl() {
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
		public CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPerformanceSwapLeg build() {
			return new CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl(this);
		}
		
		@Override
		public CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder prune() {
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
		public CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder o = (CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwapLeg _that = getType().cast(o);
		
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
			return "CommodityPerformanceSwapLegBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel +
			'}' + " " + super.toString();
		}
	}
}
