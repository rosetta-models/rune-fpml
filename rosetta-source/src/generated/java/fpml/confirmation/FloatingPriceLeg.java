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
import fpml.confirmation.FinancialSwapLeg;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilder;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilderImpl;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegImpl;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.FloatingPriceLeg;
import fpml.confirmation.FloatingPriceLeg.FloatingPriceLegBuilder;
import fpml.confirmation.FloatingPriceLeg.FloatingPriceLegBuilderImpl;
import fpml.confirmation.FloatingPriceLeg.FloatingPriceLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.FloatingPriceLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Floating Price Leg of a Commodity Swap. Each &#39;floatingLeg&#39; defines a series of financial payments for a commodity the value of which is derived from a floating price such as an exchange or an index publication.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingPriceLeg", builder=FloatingPriceLeg.FloatingPriceLegBuilderImpl.class, version="${project.version}")
public interface FloatingPriceLeg extends FinancialSwapLeg {

	FloatingPriceLegMeta metaData = new FloatingPriceLegMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel();
	/**
	 * Specifies the underlying instrument. Only underlyers of type Commodity are supported.
	 */
	Commodity getCommodity();
	CommodityNotionalQuantityModel getCommodityNotionalQuantityModel();
	/**
	 * Defines details relevant to the calculation of the floating price.
	 */
	FloatingLegCalculation getCalculation();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();
	CommodityFreightFlatRateModel getCommodityFreightFlatRateModel();

	/*********************** Build Methods  ***********************/
	FloatingPriceLeg build();
	
	FloatingPriceLeg.FloatingPriceLegBuilder toBuilder();
	
	static FloatingPriceLeg.FloatingPriceLegBuilder builder() {
		return new FloatingPriceLeg.FloatingPriceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingPriceLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingPriceLeg> getType() {
		return FloatingPriceLeg.class;
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
	interface FloatingPriceLegBuilder extends FloatingPriceLeg, FinancialSwapLeg.FinancialSwapLegBuilder {
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel();
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getOrCreateCommodityNotionalQuantityModel();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getCommodityNotionalQuantityModel();
		FloatingLegCalculation.FloatingLegCalculationBuilder getOrCreateCalculation();
		FloatingLegCalculation.FloatingLegCalculationBuilder getCalculation();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder getOrCreateCommodityFreightFlatRateModel();
		CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder getCommodityFreightFlatRateModel();
		FloatingPriceLeg.FloatingPriceLegBuilder setId(String id);
		FloatingPriceLeg.FloatingPriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FloatingPriceLeg.FloatingPriceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		FloatingPriceLeg.FloatingPriceLegBuilder setCommodity(Commodity commodity);
		FloatingPriceLeg.FloatingPriceLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculation(FloatingLegCalculation calculation);
		FloatingPriceLeg.FloatingPriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);
		FloatingPriceLeg.FloatingPriceLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel);

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
		

		FloatingPriceLeg.FloatingPriceLegBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingPriceLeg  ***********************/
	class FloatingPriceLegImpl extends FinancialSwapLeg.FinancialSwapLegImpl implements FloatingPriceLeg {
		private final CommodityCalculationPeriodsModel commodityCalculationPeriodsModel;
		private final Commodity commodity;
		private final CommodityNotionalQuantityModel commodityNotionalQuantityModel;
		private final FloatingLegCalculation calculation;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		private final CommodityFreightFlatRateModel commodityFreightFlatRateModel;
		
		protected FloatingPriceLegImpl(FloatingPriceLeg.FloatingPriceLegBuilder builder) {
			super(builder);
			this.commodityCalculationPeriodsModel = ofNullable(builder.getCommodityCalculationPeriodsModel()).map(f->f.build()).orElse(null);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.commodityNotionalQuantityModel = ofNullable(builder.getCommodityNotionalQuantityModel()).map(f->f.build()).orElse(null);
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
			this.commodityFreightFlatRateModel = ofNullable(builder.getCommodityFreightFlatRateModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel() {
			return commodityCalculationPeriodsModel;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityNotionalQuantityModel getCommodityNotionalQuantityModel() {
			return commodityNotionalQuantityModel;
		}
		
		@Override
		@RosettaAttribute("calculation")
		public FloatingLegCalculation getCalculation() {
			return calculation;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		@RosettaAttribute("commodityFreightFlatRateModel")
		public CommodityFreightFlatRateModel getCommodityFreightFlatRateModel() {
			return commodityFreightFlatRateModel;
		}
		
		@Override
		public FloatingPriceLeg build() {
			return this;
		}
		
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder toBuilder() {
			FloatingPriceLeg.FloatingPriceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingPriceLeg.FloatingPriceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityCalculationPeriodsModel()).ifPresent(builder::setCommodityCalculationPeriodsModel);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getCommodityNotionalQuantityModel()).ifPresent(builder::setCommodityNotionalQuantityModel);
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
			ofNullable(getCommodityFreightFlatRateModel()).ifPresent(builder::setCommodityFreightFlatRateModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityFreightFlatRateModel, _that.getCommodityFreightFlatRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityFreightFlatRateModel != null ? commodityFreightFlatRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingPriceLeg {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodity=" + this.commodity + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel + ", " +
				"calculation=" + this.calculation + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityFreightFlatRateModel=" + this.commodityFreightFlatRateModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingPriceLeg  ***********************/
	class FloatingPriceLegBuilderImpl extends FinancialSwapLeg.FinancialSwapLegBuilderImpl  implements FloatingPriceLeg.FloatingPriceLegBuilder {
	
		protected CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder commodityCalculationPeriodsModel;
		protected Commodity.CommodityBuilder commodity;
		protected CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder commodityNotionalQuantityModel;
		protected FloatingLegCalculation.FloatingLegCalculationBuilder calculation;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
		protected CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder commodityFreightFlatRateModel;
	
		public FloatingPriceLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel() {
			return commodityCalculationPeriodsModel;
		}
		
		@Override
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel() {
			CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder result;
			if (commodityCalculationPeriodsModel!=null) {
				result = commodityCalculationPeriodsModel;
			}
			else {
				result = commodityCalculationPeriodsModel = CommodityCalculationPeriodsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getCommodityNotionalQuantityModel() {
			return commodityNotionalQuantityModel;
		}
		
		@Override
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getOrCreateCommodityNotionalQuantityModel() {
			CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder result;
			if (commodityNotionalQuantityModel!=null) {
				result = commodityNotionalQuantityModel;
			}
			else {
				result = commodityNotionalQuantityModel = CommodityNotionalQuantityModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculation")
		public FloatingLegCalculation.FloatingLegCalculationBuilder getCalculation() {
			return calculation;
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder getOrCreateCalculation() {
			FloatingLegCalculation.FloatingLegCalculationBuilder result;
			if (calculation!=null) {
				result = calculation;
			}
			else {
				result = calculation = FloatingLegCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel() {
			CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder result;
			if (commodityPaymentDatesModel!=null) {
				result = commodityPaymentDatesModel;
			}
			else {
				result = commodityPaymentDatesModel = CommodityPaymentDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFreightFlatRateModel")
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder getCommodityFreightFlatRateModel() {
			return commodityFreightFlatRateModel;
		}
		
		@Override
		public CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder getOrCreateCommodityFreightFlatRateModel() {
			CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder result;
			if (commodityFreightFlatRateModel!=null) {
				result = commodityFreightFlatRateModel;
			}
			else {
				result = commodityFreightFlatRateModel = CommodityFreightFlatRateModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FloatingPriceLeg.FloatingPriceLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FloatingPriceLeg.FloatingPriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public FloatingPriceLeg.FloatingPriceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public FloatingPriceLeg.FloatingPriceLegBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public FloatingPriceLeg.FloatingPriceLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			this.commodityNotionalQuantityModel = commodityNotionalQuantityModel==null?null:commodityNotionalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculation")
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculation(FloatingLegCalculation calculation) {
			this.calculation = calculation==null?null:calculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public FloatingPriceLeg.FloatingPriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFreightFlatRateModel")
		public FloatingPriceLeg.FloatingPriceLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel) {
			this.commodityFreightFlatRateModel = commodityFreightFlatRateModel==null?null:commodityFreightFlatRateModel.toBuilder();
			return this;
		}
		
		@Override
		public FloatingPriceLeg build() {
			return new FloatingPriceLeg.FloatingPriceLegImpl(this);
		}
		
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder prune() {
			super.prune();
			if (commodityCalculationPeriodsModel!=null && !commodityCalculationPeriodsModel.prune().hasData()) commodityCalculationPeriodsModel = null;
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (commodityNotionalQuantityModel!=null && !commodityNotionalQuantityModel.prune().hasData()) commodityNotionalQuantityModel = null;
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			if (commodityFreightFlatRateModel!=null && !commodityFreightFlatRateModel.prune().hasData()) commodityFreightFlatRateModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityCalculationPeriodsModel()!=null && getCommodityCalculationPeriodsModel().hasData()) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getCommodityNotionalQuantityModel()!=null && getCommodityNotionalQuantityModel().hasData()) return true;
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			if (getCommodityFreightFlatRateModel()!=null && getCommodityFreightFlatRateModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingPriceLeg.FloatingPriceLegBuilder o = (FloatingPriceLeg.FloatingPriceLegBuilder) other;
			
			merger.mergeRosetta(getCommodityCalculationPeriodsModel(), o.getCommodityCalculationPeriodsModel(), this::setCommodityCalculationPeriodsModel);
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getCommodityNotionalQuantityModel(), o.getCommodityNotionalQuantityModel(), this::setCommodityNotionalQuantityModel);
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			merger.mergeRosetta(getCommodityFreightFlatRateModel(), o.getCommodityFreightFlatRateModel(), this::setCommodityFreightFlatRateModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityFreightFlatRateModel, _that.getCommodityFreightFlatRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityFreightFlatRateModel != null ? commodityFreightFlatRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingPriceLegBuilder {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodity=" + this.commodity + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel + ", " +
				"calculation=" + this.calculation + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityFreightFlatRateModel=" + this.commodityFreightFlatRateModel +
			'}' + " " + super.toString();
		}
	}
}
