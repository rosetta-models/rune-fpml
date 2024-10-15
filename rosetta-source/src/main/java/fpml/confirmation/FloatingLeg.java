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
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FloatingLeg;
import fpml.confirmation.FloatingLeg.FloatingLegBuilder;
import fpml.confirmation.FloatingLeg.FloatingLegBuilderImpl;
import fpml.confirmation.FloatingLeg.FloatingLegImpl;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.FloatingPriceLeg;
import fpml.confirmation.FloatingPriceLeg.FloatingPriceLegBuilder;
import fpml.confirmation.FloatingPriceLeg.FloatingPriceLegBuilderImpl;
import fpml.confirmation.FloatingPriceLeg.FloatingPriceLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.FloatingLegMeta;


/**
 * Floating Price leg.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingLeg", builder=FloatingLeg.FloatingLegBuilderImpl.class, version="${project.version}")
public interface FloatingLeg extends FloatingPriceLeg {

	FloatingLegMeta metaData = new FloatingLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FloatingLeg build();
	
	FloatingLeg.FloatingLegBuilder toBuilder();
	
	static FloatingLeg.FloatingLegBuilder builder() {
		return new FloatingLeg.FloatingLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingLeg> getType() {
		return FloatingLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.class, getCommodityCalculationPeriodsModel());
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.class, getCommodityNotionalQuantityModel());
		processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
		processRosetta(path.newSubPath("commodityFreightFlatRateModel"), processor, CommodityFreightFlatRateModel.class, getCommodityFreightFlatRateModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingLegBuilder extends FloatingLeg, FloatingPriceLeg.FloatingPriceLegBuilder {
		FloatingLeg.FloatingLegBuilder setId(String id);
		FloatingLeg.FloatingLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FloatingLeg.FloatingLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		FloatingLeg.FloatingLegBuilder setCommodity(Commodity commodity);
		FloatingLeg.FloatingLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel);
		FloatingLeg.FloatingLegBuilder setCalculation(FloatingLegCalculation calculation);
		FloatingLeg.FloatingLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);
		FloatingLeg.FloatingLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder.class, getCommodityCalculationPeriodsModel());
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder.class, getCommodityNotionalQuantityModel());
			processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.FloatingLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
			processRosetta(path.newSubPath("commodityFreightFlatRateModel"), processor, CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder.class, getCommodityFreightFlatRateModel());
		}
		

		FloatingLeg.FloatingLegBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingLeg  ***********************/
	class FloatingLegImpl extends FloatingPriceLeg.FloatingPriceLegImpl implements FloatingLeg {
		
		protected FloatingLegImpl(FloatingLeg.FloatingLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public FloatingLeg build() {
			return this;
		}
		
		@Override
		public FloatingLeg.FloatingLegBuilder toBuilder() {
			FloatingLeg.FloatingLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingLeg.FloatingLegBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
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
			return "FloatingLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingLeg  ***********************/
	class FloatingLegBuilderImpl extends FloatingPriceLeg.FloatingPriceLegBuilderImpl  implements FloatingLeg.FloatingLegBuilder {
	
	
		public FloatingLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public FloatingLeg.FloatingLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FloatingLeg.FloatingLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public FloatingLeg.FloatingLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public FloatingLeg.FloatingLegBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public FloatingLeg.FloatingLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			this.commodityNotionalQuantityModel = commodityNotionalQuantityModel==null?null:commodityNotionalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculation")
		public FloatingLeg.FloatingLegBuilder setCalculation(FloatingLegCalculation calculation) {
			this.calculation = calculation==null?null:calculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public FloatingLeg.FloatingLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFreightFlatRateModel")
		public FloatingLeg.FloatingLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel) {
			this.commodityFreightFlatRateModel = commodityFreightFlatRateModel==null?null:commodityFreightFlatRateModel.toBuilder();
			return this;
		}
		
		@Override
		public FloatingLeg build() {
			return new FloatingLeg.FloatingLegImpl(this);
		}
		
		@Override
		public FloatingLeg.FloatingLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingLeg.FloatingLegBuilder prune() {
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
		public FloatingLeg.FloatingLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingLeg.FloatingLegBuilder o = (FloatingLeg.FloatingLegBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
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
			return "FloatingLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
