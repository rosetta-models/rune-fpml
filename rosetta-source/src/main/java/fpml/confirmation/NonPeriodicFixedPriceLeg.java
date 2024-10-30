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
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommoditySwapLeg;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilder;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilderImpl;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegImpl;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import fpml.confirmation.NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder;
import fpml.confirmation.NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilderImpl;
import fpml.confirmation.NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuantityReference;
import fpml.confirmation.meta.NonPeriodicFixedPriceLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The details of a fixed payment. Can be used for a forward transaction or as the base for a more complex fixed leg component such as the fixed leg of a swap.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NonPeriodicFixedPriceLeg", builder=NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NonPeriodicFixedPriceLeg extends CommoditySwapLeg {

	NonPeriodicFixedPriceLegMeta metaData = new NonPeriodicFixedPriceLegMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Fixed price on which fixed payments are based.
	 */
	FixedPrice getFixedPrice();
	/**
	 * The total amount of the fixed payment for all units of the underlying commodity.
	 */
	NonNegativeMoney getTotalPrice();
	/**
	 * A pointer style reference to a quantity defined on another leg.
	 */
	QuantityReference getQuantityReference();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();

	/*********************** Build Methods  ***********************/
	NonPeriodicFixedPriceLeg build();
	
	NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder toBuilder();
	
	static NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder() {
		return new NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonPeriodicFixedPriceLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonPeriodicFixedPriceLeg> getType() {
		return NonPeriodicFixedPriceLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("fixedPrice"), processor, FixedPrice.class, getFixedPrice());
		processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.class, getTotalPrice());
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonPeriodicFixedPriceLegBuilder extends NonPeriodicFixedPriceLeg, CommoditySwapLeg.CommoditySwapLegBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		FixedPrice.FixedPriceBuilder getOrCreateFixedPrice();
		FixedPrice.FixedPriceBuilder getFixedPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getTotalPrice();
		QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference();
		QuantityReference.QuantityReferenceBuilder getQuantityReference();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setId(String id);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setFixedPrice(FixedPrice fixedPrice);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setTotalPrice(NonNegativeMoney totalPrice);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setQuantityReference(QuantityReference quantityReference);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("fixedPrice"), processor, FixedPrice.FixedPriceBuilder.class, getFixedPrice());
			processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getTotalPrice());
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
		}
		

		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder prune();
	}

	/*********************** Immutable Implementation of NonPeriodicFixedPriceLeg  ***********************/
	class NonPeriodicFixedPriceLegImpl extends CommoditySwapLeg.CommoditySwapLegImpl implements NonPeriodicFixedPriceLeg {
		private final PayerReceiverModel payerReceiverModel;
		private final FixedPrice fixedPrice;
		private final NonNegativeMoney totalPrice;
		private final QuantityReference quantityReference;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		
		protected NonPeriodicFixedPriceLegImpl(NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.fixedPrice = ofNullable(builder.getFixedPrice()).map(f->f.build()).orElse(null);
			this.totalPrice = ofNullable(builder.getTotalPrice()).map(f->f.build()).orElse(null);
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		public FixedPrice getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		@RosettaAttribute("totalPrice")
		public NonNegativeMoney getTotalPrice() {
			return totalPrice;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		public QuantityReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg build() {
			return this;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder toBuilder() {
			NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getFixedPrice()).ifPresent(builder::setFixedPrice);
			ofNullable(getTotalPrice()).ifPresent(builder::setTotalPrice);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonPeriodicFixedPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(totalPrice, _that.getTotalPrice())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (totalPrice != null ? totalPrice.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonPeriodicFixedPriceLeg {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"totalPrice=" + this.totalPrice + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonPeriodicFixedPriceLeg  ***********************/
	class NonPeriodicFixedPriceLegBuilderImpl extends CommoditySwapLeg.CommoditySwapLegBuilderImpl  implements NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected FixedPrice.FixedPriceBuilder fixedPrice;
		protected NonNegativeMoney.NonNegativeMoneyBuilder totalPrice;
		protected QuantityReference.QuantityReferenceBuilder quantityReference;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
	
		public NonPeriodicFixedPriceLegBuilderImpl() {
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
		@RosettaAttribute("fixedPrice")
		public FixedPrice.FixedPriceBuilder getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		public FixedPrice.FixedPriceBuilder getOrCreateFixedPrice() {
			FixedPrice.FixedPriceBuilder result;
			if (fixedPrice!=null) {
				result = fixedPrice;
			}
			else {
				result = fixedPrice = FixedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getTotalPrice() {
			return totalPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (totalPrice!=null) {
				result = totalPrice;
			}
			else {
				result = totalPrice = NonNegativeMoney.builder();
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
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedPrice")
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setFixedPrice(FixedPrice fixedPrice) {
			this.fixedPrice = fixedPrice==null?null:fixedPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("totalPrice")
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setTotalPrice(NonNegativeMoney totalPrice) {
			this.totalPrice = totalPrice==null?null:totalPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantityReference")
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setQuantityReference(QuantityReference quantityReference) {
			this.quantityReference = quantityReference==null?null:quantityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg build() {
			return new NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegImpl(this);
		}
		
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (fixedPrice!=null && !fixedPrice.prune().hasData()) fixedPrice = null;
			if (totalPrice!=null && !totalPrice.prune().hasData()) totalPrice = null;
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getFixedPrice()!=null && getFixedPrice().hasData()) return true;
			if (getTotalPrice()!=null && getTotalPrice().hasData()) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder o = (NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getFixedPrice(), o.getFixedPrice(), this::setFixedPrice);
			merger.mergeRosetta(getTotalPrice(), o.getTotalPrice(), this::setTotalPrice);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonPeriodicFixedPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(totalPrice, _that.getTotalPrice())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (totalPrice != null ? totalPrice.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonPeriodicFixedPriceLegBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"totalPrice=" + this.totalPrice + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}' + " " + super.toString();
		}
	}
}
