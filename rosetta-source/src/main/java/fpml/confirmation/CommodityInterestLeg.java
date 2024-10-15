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
import fpml.confirmation.CommodityFixedInterestCalculation;
import fpml.confirmation.CommodityInterestLeg;
import fpml.confirmation.CommodityInterestLeg.CommodityInterestLegBuilder;
import fpml.confirmation.CommodityInterestLeg.CommodityInterestLegBuilderImpl;
import fpml.confirmation.CommodityInterestLeg.CommodityInterestLegImpl;
import fpml.confirmation.CommodityNotionalAmount;
import fpml.confirmation.CommodityNotionalAmountReference;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.CommodityInterestLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the fixed payments of a commodity performance swap. Sometimes also referred to as the fee. A type describing the interest rate leg (a.k.a fee leg) of the commodity performance swap.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityInterestLeg", builder=CommodityInterestLeg.CommodityInterestLegBuilderImpl.class, version="${project.version}")
public interface CommodityInterestLeg extends CommodityPerformanceSwapLeg {

	CommodityInterestLegMeta metaData = new CommodityInterestLegMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();
	/**
	 * Specifies the notional amount of a commodity performance type swap. It is a currency-denominated value (i.e. price-times-quantity). In confirmations is also referred to as the Notional Quantity (sic, expressed in currency units), Notional Amount, Equity Notional Amount and, in the case of reinvesting swaps, Initial Notional Amount.
	 */
	CommodityNotionalAmount getNotionalAmount();
	/**
	 * A reference to the Return swap notional amount defined in another leg of the return swap.
	 */
	CommodityNotionalAmountReference getNotionalAmountReference();
	/**
	 * Specifies the interest payment amount on a return swap. This amount may be referred to as the interest amount or the fee amount. Used when the interest (a.k.a. &quot;Fee&quot;) is calculated very simply: notional amount * (rate * (number of days in Calculation Period / number of days assumed in the the year)).
	 */
	CommodityFixedInterestCalculation getCommodityFixedInterestCalculation();

	/*********************** Build Methods  ***********************/
	CommodityInterestLeg build();
	
	CommodityInterestLeg.CommodityInterestLegBuilder toBuilder();
	
	static CommodityInterestLeg.CommodityInterestLegBuilder builder() {
		return new CommodityInterestLeg.CommodityInterestLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityInterestLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityInterestLeg> getType() {
		return CommodityInterestLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.class, getCommodityCalculationPeriodsModel());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.class, getNotionalAmount());
		processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.class, getNotionalAmountReference());
		processRosetta(path.newSubPath("commodityFixedInterestCalculation"), processor, CommodityFixedInterestCalculation.class, getCommodityFixedInterestCalculation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityInterestLegBuilder extends CommodityInterestLeg, CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder {
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getOrCreateNotionalAmount();
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getNotionalAmount();
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getOrCreateNotionalAmountReference();
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getNotionalAmountReference();
		CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder getOrCreateCommodityFixedInterestCalculation();
		CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder getCommodityFixedInterestCalculation();
		CommodityInterestLeg.CommodityInterestLegBuilder setId(String id);
		CommodityInterestLeg.CommodityInterestLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		CommodityInterestLeg.CommodityInterestLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		CommodityInterestLeg.CommodityInterestLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);
		CommodityInterestLeg.CommodityInterestLegBuilder setNotionalAmount(CommodityNotionalAmount notionalAmount);
		CommodityInterestLeg.CommodityInterestLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference notionalAmountReference);
		CommodityInterestLeg.CommodityInterestLegBuilder setCommodityFixedInterestCalculation(CommodityFixedInterestCalculation commodityFixedInterestCalculation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder.class, getCommodityCalculationPeriodsModel());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.CommodityNotionalAmountBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder.class, getNotionalAmountReference());
			processRosetta(path.newSubPath("commodityFixedInterestCalculation"), processor, CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder.class, getCommodityFixedInterestCalculation());
		}
		

		CommodityInterestLeg.CommodityInterestLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityInterestLeg  ***********************/
	class CommodityInterestLegImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl implements CommodityInterestLeg {
		private final CommodityCalculationPeriodsModel commodityCalculationPeriodsModel;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		private final CommodityNotionalAmount notionalAmount;
		private final CommodityNotionalAmountReference notionalAmountReference;
		private final CommodityFixedInterestCalculation commodityFixedInterestCalculation;
		
		protected CommodityInterestLegImpl(CommodityInterestLeg.CommodityInterestLegBuilder builder) {
			super(builder);
			this.commodityCalculationPeriodsModel = ofNullable(builder.getCommodityCalculationPeriodsModel()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.notionalAmountReference = ofNullable(builder.getNotionalAmountReference()).map(f->f.build()).orElse(null);
			this.commodityFixedInterestCalculation = ofNullable(builder.getCommodityFixedInterestCalculation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel() {
			return commodityCalculationPeriodsModel;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityNotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		public CommodityNotionalAmountReference getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		@RosettaAttribute("commodityFixedInterestCalculation")
		public CommodityFixedInterestCalculation getCommodityFixedInterestCalculation() {
			return commodityFixedInterestCalculation;
		}
		
		@Override
		public CommodityInterestLeg build() {
			return this;
		}
		
		@Override
		public CommodityInterestLeg.CommodityInterestLegBuilder toBuilder() {
			CommodityInterestLeg.CommodityInterestLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityInterestLeg.CommodityInterestLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityCalculationPeriodsModel()).ifPresent(builder::setCommodityCalculationPeriodsModel);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getNotionalAmountReference()).ifPresent(builder::setNotionalAmountReference);
			ofNullable(getCommodityFixedInterestCalculation()).ifPresent(builder::setCommodityFixedInterestCalculation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityInterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(commodityFixedInterestCalculation, _that.getCommodityFixedInterestCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (commodityFixedInterestCalculation != null ? commodityFixedInterestCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInterestLeg {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"commodityFixedInterestCalculation=" + this.commodityFixedInterestCalculation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityInterestLeg  ***********************/
	class CommodityInterestLegBuilderImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl  implements CommodityInterestLeg.CommodityInterestLegBuilder {
	
		protected CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder commodityCalculationPeriodsModel;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
		protected CommodityNotionalAmount.CommodityNotionalAmountBuilder notionalAmount;
		protected CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder notionalAmountReference;
		protected CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder commodityFixedInterestCalculation;
	
		public CommodityInterestLegBuilderImpl() {
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
		@RosettaAttribute("notionalAmount")
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder getOrCreateNotionalAmount() {
			CommodityNotionalAmount.CommodityNotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = CommodityNotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getOrCreateNotionalAmountReference() {
			CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder result;
			if (notionalAmountReference!=null) {
				result = notionalAmountReference;
			}
			else {
				result = notionalAmountReference = CommodityNotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFixedInterestCalculation")
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder getCommodityFixedInterestCalculation() {
			return commodityFixedInterestCalculation;
		}
		
		@Override
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder getOrCreateCommodityFixedInterestCalculation() {
			CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder result;
			if (commodityFixedInterestCalculation!=null) {
				result = commodityFixedInterestCalculation;
			}
			else {
				result = commodityFixedInterestCalculation = CommodityFixedInterestCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityInterestLeg.CommodityInterestLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public CommodityInterestLeg.CommodityInterestLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityInterestLeg.CommodityInterestLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityInterestLeg.CommodityInterestLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityInterestLeg.CommodityInterestLegBuilder setNotionalAmount(CommodityNotionalAmount notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmountReference")
		public CommodityInterestLeg.CommodityInterestLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference notionalAmountReference) {
			this.notionalAmountReference = notionalAmountReference==null?null:notionalAmountReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedInterestCalculation")
		public CommodityInterestLeg.CommodityInterestLegBuilder setCommodityFixedInterestCalculation(CommodityFixedInterestCalculation commodityFixedInterestCalculation) {
			this.commodityFixedInterestCalculation = commodityFixedInterestCalculation==null?null:commodityFixedInterestCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CommodityInterestLeg build() {
			return new CommodityInterestLeg.CommodityInterestLegImpl(this);
		}
		
		@Override
		public CommodityInterestLeg.CommodityInterestLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInterestLeg.CommodityInterestLegBuilder prune() {
			super.prune();
			if (commodityCalculationPeriodsModel!=null && !commodityCalculationPeriodsModel.prune().hasData()) commodityCalculationPeriodsModel = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (notionalAmountReference!=null && !notionalAmountReference.prune().hasData()) notionalAmountReference = null;
			if (commodityFixedInterestCalculation!=null && !commodityFixedInterestCalculation.prune().hasData()) commodityFixedInterestCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityCalculationPeriodsModel()!=null && getCommodityCalculationPeriodsModel().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getNotionalAmountReference()!=null && getNotionalAmountReference().hasData()) return true;
			if (getCommodityFixedInterestCalculation()!=null && getCommodityFixedInterestCalculation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInterestLeg.CommodityInterestLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityInterestLeg.CommodityInterestLegBuilder o = (CommodityInterestLeg.CommodityInterestLegBuilder) other;
			
			merger.mergeRosetta(getCommodityCalculationPeriodsModel(), o.getCommodityCalculationPeriodsModel(), this::setCommodityCalculationPeriodsModel);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getNotionalAmountReference(), o.getNotionalAmountReference(), this::setNotionalAmountReference);
			merger.mergeRosetta(getCommodityFixedInterestCalculation(), o.getCommodityFixedInterestCalculation(), this::setCommodityFixedInterestCalculation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityInterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(commodityFixedInterestCalculation, _that.getCommodityFixedInterestCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (commodityFixedInterestCalculation != null ? commodityFixedInterestCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInterestLegBuilder {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"commodityFixedInterestCalculation=" + this.commodityFixedInterestCalculation +
			'}' + " " + super.toString();
		}
	}
}
