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
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityFixedPriceModel;
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FixedLeg;
import fpml.confirmation.FixedLeg.FixedLegBuilder;
import fpml.confirmation.FixedLeg.FixedLegBuilderImpl;
import fpml.confirmation.FixedLeg.FixedLegImpl;
import fpml.confirmation.FixedPriceLeg;
import fpml.confirmation.FixedPriceLeg.FixedPriceLegBuilder;
import fpml.confirmation.FixedPriceLeg.FixedPriceLegBuilderImpl;
import fpml.confirmation.FixedPriceLeg.FixedPriceLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.FixedLegMeta;


/**
 * Fixed Price Leg.
 * @version ${project.version}
 */
@RosettaDataType(value="FixedLeg", builder=FixedLeg.FixedLegBuilderImpl.class, version="${project.version}")
public interface FixedLeg extends FixedPriceLeg {

	FixedLegMeta metaData = new FixedLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FixedLeg build();
	
	FixedLeg.FixedLegBuilder toBuilder();
	
	static FixedLeg.FixedLegBuilder builder() {
		return new FixedLeg.FixedLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedLeg> getType() {
		return FixedLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.class, getCommodityCalculationPeriodsModel());
		processRosetta(path.newSubPath("commodityFixedPriceModel"), processor, CommodityFixedPriceModel.class, getCommodityFixedPriceModel());
		processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.class, getCommodityNotionalQuantityModel());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
		processRosetta(path.newSubPath("commodityFreightFlatRateModel"), processor, CommodityFreightFlatRateModel.class, getCommodityFreightFlatRateModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedLegBuilder extends FixedLeg, FixedPriceLeg.FixedPriceLegBuilder {
		FixedLeg.FixedLegBuilder setId(String id);
		FixedLeg.FixedLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FixedLeg.FixedLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		FixedLeg.FixedLegBuilder setCommodityFixedPriceModel(CommodityFixedPriceModel commodityFixedPriceModel);
		FixedLeg.FixedLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel);
		FixedLeg.FixedLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);
		FixedLeg.FixedLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder.class, getCommodityCalculationPeriodsModel());
			processRosetta(path.newSubPath("commodityFixedPriceModel"), processor, CommodityFixedPriceModel.CommodityFixedPriceModelBuilder.class, getCommodityFixedPriceModel());
			processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder.class, getCommodityNotionalQuantityModel());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
			processRosetta(path.newSubPath("commodityFreightFlatRateModel"), processor, CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder.class, getCommodityFreightFlatRateModel());
		}
		

		FixedLeg.FixedLegBuilder prune();
	}

	/*********************** Immutable Implementation of FixedLeg  ***********************/
	class FixedLegImpl extends FixedPriceLeg.FixedPriceLegImpl implements FixedLeg {
		
		protected FixedLegImpl(FixedLeg.FixedLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public FixedLeg build() {
			return this;
		}
		
		@Override
		public FixedLeg.FixedLegBuilder toBuilder() {
			FixedLeg.FixedLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedLeg.FixedLegBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedLeg  ***********************/
	class FixedLegBuilderImpl extends FixedPriceLeg.FixedPriceLegBuilderImpl  implements FixedLeg.FixedLegBuilder {
	
	
		public FixedLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public FixedLeg.FixedLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FixedLeg.FixedLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public FixedLeg.FixedLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedPriceModel")
		public FixedLeg.FixedLegBuilder setCommodityFixedPriceModel(CommodityFixedPriceModel commodityFixedPriceModel) {
			this.commodityFixedPriceModel = commodityFixedPriceModel==null?null:commodityFixedPriceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public FixedLeg.FixedLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			this.commodityNotionalQuantityModel = commodityNotionalQuantityModel==null?null:commodityNotionalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public FixedLeg.FixedLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFreightFlatRateModel")
		public FixedLeg.FixedLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel) {
			this.commodityFreightFlatRateModel = commodityFreightFlatRateModel==null?null:commodityFreightFlatRateModel.toBuilder();
			return this;
		}
		
		@Override
		public FixedLeg build() {
			return new FixedLeg.FixedLegImpl(this);
		}
		
		@Override
		public FixedLeg.FixedLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedLeg.FixedLegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedLeg.FixedLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FixedLeg.FixedLegBuilder o = (FixedLeg.FixedLegBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
