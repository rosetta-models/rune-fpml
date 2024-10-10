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
import fpml.confirmation.FinancialSwapLeg;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilder;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegBuilderImpl;
import fpml.confirmation.FinancialSwapLeg.FinancialSwapLegImpl;
import fpml.confirmation.FixedPriceLeg;
import fpml.confirmation.FixedPriceLeg.FixedPriceLegBuilder;
import fpml.confirmation.FixedPriceLeg.FixedPriceLegBuilderImpl;
import fpml.confirmation.FixedPriceLeg.FixedPriceLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.FixedPriceLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Fixed Price Leg of a Commodity Swap. It defines schedule of fixed payments associated with a commodity swap.
 * @version ${project.version}
 */
@RosettaDataType(value="FixedPriceLeg", builder=FixedPriceLeg.FixedPriceLegBuilderImpl.class, version="${project.version}")
public interface FixedPriceLeg extends FinancialSwapLeg {

	FixedPriceLegMeta metaData = new FixedPriceLegMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel();
	CommodityFixedPriceModel getCommodityFixedPriceModel();
	CommodityNotionalQuantityModel getCommodityNotionalQuantityModel();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();
	CommodityFreightFlatRateModel getCommodityFreightFlatRateModel();

	/*********************** Build Methods  ***********************/
	FixedPriceLeg build();
	
	FixedPriceLeg.FixedPriceLegBuilder toBuilder();
	
	static FixedPriceLeg.FixedPriceLegBuilder builder() {
		return new FixedPriceLeg.FixedPriceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedPriceLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedPriceLeg> getType() {
		return FixedPriceLeg.class;
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
	interface FixedPriceLegBuilder extends FixedPriceLeg, FinancialSwapLeg.FinancialSwapLegBuilder {
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel();
		CommodityFixedPriceModel.CommodityFixedPriceModelBuilder getOrCreateCommodityFixedPriceModel();
		CommodityFixedPriceModel.CommodityFixedPriceModelBuilder getCommodityFixedPriceModel();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getOrCreateCommodityNotionalQuantityModel();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getCommodityNotionalQuantityModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder getOrCreateCommodityFreightFlatRateModel();
		CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder getCommodityFreightFlatRateModel();
		FixedPriceLeg.FixedPriceLegBuilder setId(String id);
		FixedPriceLeg.FixedPriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FixedPriceLeg.FixedPriceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		FixedPriceLeg.FixedPriceLegBuilder setCommodityFixedPriceModel(CommodityFixedPriceModel commodityFixedPriceModel);
		FixedPriceLeg.FixedPriceLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel);
		FixedPriceLeg.FixedPriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);
		FixedPriceLeg.FixedPriceLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel);

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
		

		FixedPriceLeg.FixedPriceLegBuilder prune();
	}

	/*********************** Immutable Implementation of FixedPriceLeg  ***********************/
	class FixedPriceLegImpl extends FinancialSwapLeg.FinancialSwapLegImpl implements FixedPriceLeg {
		private final CommodityCalculationPeriodsModel commodityCalculationPeriodsModel;
		private final CommodityFixedPriceModel commodityFixedPriceModel;
		private final CommodityNotionalQuantityModel commodityNotionalQuantityModel;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		private final CommodityFreightFlatRateModel commodityFreightFlatRateModel;
		
		protected FixedPriceLegImpl(FixedPriceLeg.FixedPriceLegBuilder builder) {
			super(builder);
			this.commodityCalculationPeriodsModel = ofNullable(builder.getCommodityCalculationPeriodsModel()).map(f->f.build()).orElse(null);
			this.commodityFixedPriceModel = ofNullable(builder.getCommodityFixedPriceModel()).map(f->f.build()).orElse(null);
			this.commodityNotionalQuantityModel = ofNullable(builder.getCommodityNotionalQuantityModel()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
			this.commodityFreightFlatRateModel = ofNullable(builder.getCommodityFreightFlatRateModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel() {
			return commodityCalculationPeriodsModel;
		}
		
		@Override
		@RosettaAttribute("commodityFixedPriceModel")
		public CommodityFixedPriceModel getCommodityFixedPriceModel() {
			return commodityFixedPriceModel;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityNotionalQuantityModel getCommodityNotionalQuantityModel() {
			return commodityNotionalQuantityModel;
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
		public FixedPriceLeg build() {
			return this;
		}
		
		@Override
		public FixedPriceLeg.FixedPriceLegBuilder toBuilder() {
			FixedPriceLeg.FixedPriceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedPriceLeg.FixedPriceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityCalculationPeriodsModel()).ifPresent(builder::setCommodityCalculationPeriodsModel);
			ofNullable(getCommodityFixedPriceModel()).ifPresent(builder::setCommodityFixedPriceModel);
			ofNullable(getCommodityNotionalQuantityModel()).ifPresent(builder::setCommodityNotionalQuantityModel);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
			ofNullable(getCommodityFreightFlatRateModel()).ifPresent(builder::setCommodityFreightFlatRateModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityFixedPriceModel, _that.getCommodityFixedPriceModel())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityFreightFlatRateModel, _that.getCommodityFreightFlatRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPriceModel != null ? commodityFixedPriceModel.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityFreightFlatRateModel != null ? commodityFreightFlatRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPriceLeg {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityFixedPriceModel=" + this.commodityFixedPriceModel + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityFreightFlatRateModel=" + this.commodityFreightFlatRateModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedPriceLeg  ***********************/
	class FixedPriceLegBuilderImpl extends FinancialSwapLeg.FinancialSwapLegBuilderImpl  implements FixedPriceLeg.FixedPriceLegBuilder {
	
		protected CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder commodityCalculationPeriodsModel;
		protected CommodityFixedPriceModel.CommodityFixedPriceModelBuilder commodityFixedPriceModel;
		protected CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder commodityNotionalQuantityModel;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
		protected CommodityFreightFlatRateModel.CommodityFreightFlatRateModelBuilder commodityFreightFlatRateModel;
	
		public FixedPriceLegBuilderImpl() {
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
		@RosettaAttribute("commodityFixedPriceModel")
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder getCommodityFixedPriceModel() {
			return commodityFixedPriceModel;
		}
		
		@Override
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder getOrCreateCommodityFixedPriceModel() {
			CommodityFixedPriceModel.CommodityFixedPriceModelBuilder result;
			if (commodityFixedPriceModel!=null) {
				result = commodityFixedPriceModel;
			}
			else {
				result = commodityFixedPriceModel = CommodityFixedPriceModel.builder();
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
		public FixedPriceLeg.FixedPriceLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FixedPriceLeg.FixedPriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public FixedPriceLeg.FixedPriceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedPriceModel")
		public FixedPriceLeg.FixedPriceLegBuilder setCommodityFixedPriceModel(CommodityFixedPriceModel commodityFixedPriceModel) {
			this.commodityFixedPriceModel = commodityFixedPriceModel==null?null:commodityFixedPriceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public FixedPriceLeg.FixedPriceLegBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			this.commodityNotionalQuantityModel = commodityNotionalQuantityModel==null?null:commodityNotionalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public FixedPriceLeg.FixedPriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFreightFlatRateModel")
		public FixedPriceLeg.FixedPriceLegBuilder setCommodityFreightFlatRateModel(CommodityFreightFlatRateModel commodityFreightFlatRateModel) {
			this.commodityFreightFlatRateModel = commodityFreightFlatRateModel==null?null:commodityFreightFlatRateModel.toBuilder();
			return this;
		}
		
		@Override
		public FixedPriceLeg build() {
			return new FixedPriceLeg.FixedPriceLegImpl(this);
		}
		
		@Override
		public FixedPriceLeg.FixedPriceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPriceLeg.FixedPriceLegBuilder prune() {
			super.prune();
			if (commodityCalculationPeriodsModel!=null && !commodityCalculationPeriodsModel.prune().hasData()) commodityCalculationPeriodsModel = null;
			if (commodityFixedPriceModel!=null && !commodityFixedPriceModel.prune().hasData()) commodityFixedPriceModel = null;
			if (commodityNotionalQuantityModel!=null && !commodityNotionalQuantityModel.prune().hasData()) commodityNotionalQuantityModel = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			if (commodityFreightFlatRateModel!=null && !commodityFreightFlatRateModel.prune().hasData()) commodityFreightFlatRateModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityCalculationPeriodsModel()!=null && getCommodityCalculationPeriodsModel().hasData()) return true;
			if (getCommodityFixedPriceModel()!=null && getCommodityFixedPriceModel().hasData()) return true;
			if (getCommodityNotionalQuantityModel()!=null && getCommodityNotionalQuantityModel().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			if (getCommodityFreightFlatRateModel()!=null && getCommodityFreightFlatRateModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPriceLeg.FixedPriceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FixedPriceLeg.FixedPriceLegBuilder o = (FixedPriceLeg.FixedPriceLegBuilder) other;
			
			merger.mergeRosetta(getCommodityCalculationPeriodsModel(), o.getCommodityCalculationPeriodsModel(), this::setCommodityCalculationPeriodsModel);
			merger.mergeRosetta(getCommodityFixedPriceModel(), o.getCommodityFixedPriceModel(), this::setCommodityFixedPriceModel);
			merger.mergeRosetta(getCommodityNotionalQuantityModel(), o.getCommodityNotionalQuantityModel(), this::setCommodityNotionalQuantityModel);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			merger.mergeRosetta(getCommodityFreightFlatRateModel(), o.getCommodityFreightFlatRateModel(), this::setCommodityFreightFlatRateModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityFixedPriceModel, _that.getCommodityFixedPriceModel())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityFreightFlatRateModel, _that.getCommodityFreightFlatRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPriceModel != null ? commodityFixedPriceModel.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityFreightFlatRateModel != null ? commodityFreightFlatRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPriceLegBuilder {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityFixedPriceModel=" + this.commodityFixedPriceModel + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityFreightFlatRateModel=" + this.commodityFreightFlatRateModel +
			'}' + " " + super.toString();
		}
	}
}
