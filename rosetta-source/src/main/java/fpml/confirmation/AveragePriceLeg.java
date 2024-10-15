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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AveragePriceLeg;
import fpml.confirmation.AveragePriceLeg.AveragePriceLegBuilder;
import fpml.confirmation.AveragePriceLeg.AveragePriceLegBuilderImpl;
import fpml.confirmation.AveragePriceLeg.AveragePriceLegImpl;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommoditySwapLeg;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilder;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilderImpl;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegImpl;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuantityReference;
import fpml.confirmation.meta.AveragePriceLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The average price leg of an average price commodity bullion or non-precious metal forward transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="AveragePriceLeg", builder=AveragePriceLeg.AveragePriceLegBuilderImpl.class, version="${project.version}")
public interface AveragePriceLeg extends CommoditySwapLeg {

	AveragePriceLegMeta metaData = new AveragePriceLegMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel();
	Commodity getCommodity();
	/**
	 * A pointer to a specification of quantity defined elsewhere.
	 */
	QuantityReference getQuantityReference();
	/**
	 * Defines the Start of the Pricing period. PricingStartDate is optional when discrete pricingDates are supplied and is not recommended to be included. Should they coexist, pricingStartDate is expected to be the same as the earliest pricing date or earlier for a Term deal as the discrete dates will take precedence.
	 */
	AdjustableDate getPricingStartDate();
	/**
	 * Captures details relevant to the calculation of the floating price.
	 */
	FloatingLegCalculation getCalculation();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();

	/*********************** Build Methods  ***********************/
	AveragePriceLeg build();
	
	AveragePriceLeg.AveragePriceLegBuilder toBuilder();
	
	static AveragePriceLeg.AveragePriceLegBuilder builder() {
		return new AveragePriceLeg.AveragePriceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AveragePriceLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AveragePriceLeg> getType() {
		return AveragePriceLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.class, getCommodityCalculationPeriodsModel());
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
		processRosetta(path.newSubPath("pricingStartDate"), processor, AdjustableDate.class, getPricingStartDate());
		processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AveragePriceLegBuilder extends AveragePriceLeg, CommoditySwapLeg.CommoditySwapLegBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel();
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference();
		QuantityReference.QuantityReferenceBuilder getQuantityReference();
		AdjustableDate.AdjustableDateBuilder getOrCreatePricingStartDate();
		AdjustableDate.AdjustableDateBuilder getPricingStartDate();
		FloatingLegCalculation.FloatingLegCalculationBuilder getOrCreateCalculation();
		FloatingLegCalculation.FloatingLegCalculationBuilder getCalculation();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		AveragePriceLeg.AveragePriceLegBuilder setId(String id);
		AveragePriceLeg.AveragePriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		AveragePriceLeg.AveragePriceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		AveragePriceLeg.AveragePriceLegBuilder setCommodity(Commodity commodity);
		AveragePriceLeg.AveragePriceLegBuilder setQuantityReference(QuantityReference quantityReference);
		AveragePriceLeg.AveragePriceLegBuilder setPricingStartDate(AdjustableDate pricingStartDate);
		AveragePriceLeg.AveragePriceLegBuilder setCalculation(FloatingLegCalculation calculation);
		AveragePriceLeg.AveragePriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder.class, getCommodityCalculationPeriodsModel());
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("pricingStartDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPricingStartDate());
			processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.FloatingLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
		}
		

		AveragePriceLeg.AveragePriceLegBuilder prune();
	}

	/*********************** Immutable Implementation of AveragePriceLeg  ***********************/
	class AveragePriceLegImpl extends CommoditySwapLeg.CommoditySwapLegImpl implements AveragePriceLeg {
		private final PayerReceiverModel payerReceiverModel;
		private final CommodityCalculationPeriodsModel commodityCalculationPeriodsModel;
		private final Commodity commodity;
		private final QuantityReference quantityReference;
		private final AdjustableDate pricingStartDate;
		private final FloatingLegCalculation calculation;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		
		protected AveragePriceLegImpl(AveragePriceLeg.AveragePriceLegBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.commodityCalculationPeriodsModel = ofNullable(builder.getCommodityCalculationPeriodsModel()).map(f->f.build()).orElse(null);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
			this.pricingStartDate = ofNullable(builder.getPricingStartDate()).map(f->f.build()).orElse(null);
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
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
		@RosettaAttribute("quantityReference")
		public QuantityReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		@RosettaAttribute("pricingStartDate")
		public AdjustableDate getPricingStartDate() {
			return pricingStartDate;
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
		public AveragePriceLeg build() {
			return this;
		}
		
		@Override
		public AveragePriceLeg.AveragePriceLegBuilder toBuilder() {
			AveragePriceLeg.AveragePriceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AveragePriceLeg.AveragePriceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getCommodityCalculationPeriodsModel()).ifPresent(builder::setCommodityCalculationPeriodsModel);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
			ofNullable(getPricingStartDate()).ifPresent(builder::setPricingStartDate);
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AveragePriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(pricingStartDate, _that.getPricingStartDate())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (pricingStartDate != null ? pricingStartDate.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragePriceLeg {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodity=" + this.commodity + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"pricingStartDate=" + this.pricingStartDate + ", " +
				"calculation=" + this.calculation + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AveragePriceLeg  ***********************/
	class AveragePriceLegBuilderImpl extends CommoditySwapLeg.CommoditySwapLegBuilderImpl  implements AveragePriceLeg.AveragePriceLegBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder commodityCalculationPeriodsModel;
		protected Commodity.CommodityBuilder commodity;
		protected QuantityReference.QuantityReferenceBuilder quantityReference;
		protected AdjustableDate.AdjustableDateBuilder pricingStartDate;
		protected FloatingLegCalculation.FloatingLegCalculationBuilder calculation;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
	
		public AveragePriceLegBuilderImpl() {
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
		@RosettaAttribute("quantityReference")
		public QuantityReference.QuantityReferenceBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference() {
			QuantityReference.QuantityReferenceBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = QuantityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingStartDate")
		public AdjustableDate.AdjustableDateBuilder getPricingStartDate() {
			return pricingStartDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreatePricingStartDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (pricingStartDate!=null) {
				result = pricingStartDate;
			}
			else {
				result = pricingStartDate = AdjustableDate.builder();
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
		@RosettaAttribute("id")
		public AveragePriceLeg.AveragePriceLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public AveragePriceLeg.AveragePriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public AveragePriceLeg.AveragePriceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public AveragePriceLeg.AveragePriceLegBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantityReference")
		public AveragePriceLeg.AveragePriceLegBuilder setQuantityReference(QuantityReference quantityReference) {
			this.quantityReference = quantityReference==null?null:quantityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingStartDate")
		public AveragePriceLeg.AveragePriceLegBuilder setPricingStartDate(AdjustableDate pricingStartDate) {
			this.pricingStartDate = pricingStartDate==null?null:pricingStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculation")
		public AveragePriceLeg.AveragePriceLegBuilder setCalculation(FloatingLegCalculation calculation) {
			this.calculation = calculation==null?null:calculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public AveragePriceLeg.AveragePriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		
		@Override
		public AveragePriceLeg build() {
			return new AveragePriceLeg.AveragePriceLegImpl(this);
		}
		
		@Override
		public AveragePriceLeg.AveragePriceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragePriceLeg.AveragePriceLegBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (commodityCalculationPeriodsModel!=null && !commodityCalculationPeriodsModel.prune().hasData()) commodityCalculationPeriodsModel = null;
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			if (pricingStartDate!=null && !pricingStartDate.prune().hasData()) pricingStartDate = null;
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getCommodityCalculationPeriodsModel()!=null && getCommodityCalculationPeriodsModel().hasData()) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			if (getPricingStartDate()!=null && getPricingStartDate().hasData()) return true;
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragePriceLeg.AveragePriceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AveragePriceLeg.AveragePriceLegBuilder o = (AveragePriceLeg.AveragePriceLegBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getCommodityCalculationPeriodsModel(), o.getCommodityCalculationPeriodsModel(), this::setCommodityCalculationPeriodsModel);
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			merger.mergeRosetta(getPricingStartDate(), o.getPricingStartDate(), this::setPricingStartDate);
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AveragePriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(pricingStartDate, _that.getPricingStartDate())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (pricingStartDate != null ? pricingStartDate.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragePriceLegBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodity=" + this.commodity + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"pricingStartDate=" + this.pricingStartDate + ", " +
				"calculation=" + this.calculation + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}' + " " + super.toString();
		}
	}
}
