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
import fpml.confirmation.CommodityNotionalAmount;
import fpml.confirmation.CommodityNotionalAmountReference;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl;
import fpml.confirmation.CommodityReturnCalculation;
import fpml.confirmation.CommodityReturnLeg;
import fpml.confirmation.CommodityReturnLeg.CommodityReturnLegBuilder;
import fpml.confirmation.CommodityReturnLeg.CommodityReturnLegBuilderImpl;
import fpml.confirmation.CommodityReturnLeg.CommodityReturnLegImpl;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.CommodityReturnLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the return payments of a commodity return swap. There can be one or two return legs. In simple return swaps there is a return leg and an interest (a.k.a. &#39;fee&#39;) leg. In the case of a outperformance swap there are two return legs: the return performance of two commodity underlyers are swapped. In the case of a fully-funded return swap there is no financing component and, therefore, only a single return leg is specified. A type describing the return leg of a commodity return swap.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityReturnLeg", builder=CommodityReturnLeg.CommodityReturnLegBuilderImpl.class, version="${project.version}")
public interface CommodityReturnLeg extends CommodityPerformanceSwapLeg {

	CommodityReturnLegMeta metaData = new CommodityReturnLegMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();
	CommodityUnderlyerChoiceModel getCommodityUnderlyerChoiceModel();
	/**
	 * Specifies the notional amount of a commodity performance type swap. It is a currency-denominated value (i.e. price-times-quantity). In confirmations is also referred to as the Notional Quantity (sic, expressed in currency units), Notional Amount, Equity Notional Amount and, in the case of reinvesting swaps, Initial Notional Amount.
	 */
	CommodityNotionalAmount getNotionalAmount();
	/**
	 * A reference to the Return swap notional amount defined in another leg of the return swap.
	 */
	CommodityNotionalAmountReference getNotionalAmountReference();
	/**
	 * Specifies, in relation to each Payment Date, the return percentage which, when multiplied times the notional amount is the amount to which the Payment Date relates.
	 */
	CommodityReturnCalculation getCommodityReturnCalculation();

	/*********************** Build Methods  ***********************/
	CommodityReturnLeg build();
	
	CommodityReturnLeg.CommodityReturnLegBuilder toBuilder();
	
	static CommodityReturnLeg.CommodityReturnLegBuilder builder() {
		return new CommodityReturnLeg.CommodityReturnLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityReturnLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityReturnLeg> getType() {
		return CommodityReturnLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.class, getCommodityCalculationPeriodsModel());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
		processRosetta(path.newSubPath("commodityUnderlyerChoiceModel"), processor, CommodityUnderlyerChoiceModel.class, getCommodityUnderlyerChoiceModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.class, getNotionalAmount());
		processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.class, getNotionalAmountReference());
		processRosetta(path.newSubPath("commodityReturnCalculation"), processor, CommodityReturnCalculation.class, getCommodityReturnCalculation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityReturnLegBuilder extends CommodityReturnLeg, CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder {
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getOrCreateCommodityUnderlyerChoiceModel();
		CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getCommodityUnderlyerChoiceModel();
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getOrCreateNotionalAmount();
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getNotionalAmount();
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getOrCreateNotionalAmountReference();
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getNotionalAmountReference();
		CommodityReturnCalculation.CommodityReturnCalculationBuilder getOrCreateCommodityReturnCalculation();
		CommodityReturnCalculation.CommodityReturnCalculationBuilder getCommodityReturnCalculation();
		CommodityReturnLeg.CommodityReturnLegBuilder setId(String id);
		CommodityReturnLeg.CommodityReturnLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		CommodityReturnLeg.CommodityReturnLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		CommodityReturnLeg.CommodityReturnLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);
		CommodityReturnLeg.CommodityReturnLegBuilder setCommodityUnderlyerChoiceModel(CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel);
		CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmount(CommodityNotionalAmount notionalAmount);
		CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference notionalAmountReference);
		CommodityReturnLeg.CommodityReturnLegBuilder setCommodityReturnCalculation(CommodityReturnCalculation commodityReturnCalculation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder.class, getCommodityCalculationPeriodsModel());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
			processRosetta(path.newSubPath("commodityUnderlyerChoiceModel"), processor, CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder.class, getCommodityUnderlyerChoiceModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.CommodityNotionalAmountBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder.class, getNotionalAmountReference());
			processRosetta(path.newSubPath("commodityReturnCalculation"), processor, CommodityReturnCalculation.CommodityReturnCalculationBuilder.class, getCommodityReturnCalculation());
		}
		

		CommodityReturnLeg.CommodityReturnLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityReturnLeg  ***********************/
	class CommodityReturnLegImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl implements CommodityReturnLeg {
		private final CommodityCalculationPeriodsModel commodityCalculationPeriodsModel;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		private final CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel;
		private final CommodityNotionalAmount notionalAmount;
		private final CommodityNotionalAmountReference notionalAmountReference;
		private final CommodityReturnCalculation commodityReturnCalculation;
		
		protected CommodityReturnLegImpl(CommodityReturnLeg.CommodityReturnLegBuilder builder) {
			super(builder);
			this.commodityCalculationPeriodsModel = ofNullable(builder.getCommodityCalculationPeriodsModel()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
			this.commodityUnderlyerChoiceModel = ofNullable(builder.getCommodityUnderlyerChoiceModel()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.notionalAmountReference = ofNullable(builder.getNotionalAmountReference()).map(f->f.build()).orElse(null);
			this.commodityReturnCalculation = ofNullable(builder.getCommodityReturnCalculation()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("commodityUnderlyerChoiceModel")
		public CommodityUnderlyerChoiceModel getCommodityUnderlyerChoiceModel() {
			return commodityUnderlyerChoiceModel;
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
		@RosettaAttribute("commodityReturnCalculation")
		public CommodityReturnCalculation getCommodityReturnCalculation() {
			return commodityReturnCalculation;
		}
		
		@Override
		public CommodityReturnLeg build() {
			return this;
		}
		
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder toBuilder() {
			CommodityReturnLeg.CommodityReturnLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityReturnLeg.CommodityReturnLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityCalculationPeriodsModel()).ifPresent(builder::setCommodityCalculationPeriodsModel);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
			ofNullable(getCommodityUnderlyerChoiceModel()).ifPresent(builder::setCommodityUnderlyerChoiceModel);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getNotionalAmountReference()).ifPresent(builder::setNotionalAmountReference);
			ofNullable(getCommodityReturnCalculation()).ifPresent(builder::setCommodityReturnCalculation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityUnderlyerChoiceModel, _that.getCommodityUnderlyerChoiceModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(commodityReturnCalculation, _that.getCommodityReturnCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityUnderlyerChoiceModel != null ? commodityUnderlyerChoiceModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (commodityReturnCalculation != null ? commodityReturnCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnLeg {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityUnderlyerChoiceModel=" + this.commodityUnderlyerChoiceModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"commodityReturnCalculation=" + this.commodityReturnCalculation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityReturnLeg  ***********************/
	class CommodityReturnLegBuilderImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl  implements CommodityReturnLeg.CommodityReturnLegBuilder {
	
		protected CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder commodityCalculationPeriodsModel;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
		protected CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder commodityUnderlyerChoiceModel;
		protected CommodityNotionalAmount.CommodityNotionalAmountBuilder notionalAmount;
		protected CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder notionalAmountReference;
		protected CommodityReturnCalculation.CommodityReturnCalculationBuilder commodityReturnCalculation;
	
		public CommodityReturnLegBuilderImpl() {
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
		@RosettaAttribute("commodityUnderlyerChoiceModel")
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getCommodityUnderlyerChoiceModel() {
			return commodityUnderlyerChoiceModel;
		}
		
		@Override
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getOrCreateCommodityUnderlyerChoiceModel() {
			CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder result;
			if (commodityUnderlyerChoiceModel!=null) {
				result = commodityUnderlyerChoiceModel;
			}
			else {
				result = commodityUnderlyerChoiceModel = CommodityUnderlyerChoiceModel.builder();
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
		@RosettaAttribute("commodityReturnCalculation")
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder getCommodityReturnCalculation() {
			return commodityReturnCalculation;
		}
		
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder getOrCreateCommodityReturnCalculation() {
			CommodityReturnCalculation.CommodityReturnCalculationBuilder result;
			if (commodityReturnCalculation!=null) {
				result = commodityReturnCalculation;
			}
			else {
				result = commodityReturnCalculation = CommodityReturnCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityReturnLeg.CommodityReturnLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public CommodityReturnLeg.CommodityReturnLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityReturnLeg.CommodityReturnLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityReturnLeg.CommodityReturnLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityUnderlyerChoiceModel")
		public CommodityReturnLeg.CommodityReturnLegBuilder setCommodityUnderlyerChoiceModel(CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel) {
			this.commodityUnderlyerChoiceModel = commodityUnderlyerChoiceModel==null?null:commodityUnderlyerChoiceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmount(CommodityNotionalAmount notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmountReference")
		public CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference notionalAmountReference) {
			this.notionalAmountReference = notionalAmountReference==null?null:notionalAmountReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityReturnCalculation")
		public CommodityReturnLeg.CommodityReturnLegBuilder setCommodityReturnCalculation(CommodityReturnCalculation commodityReturnCalculation) {
			this.commodityReturnCalculation = commodityReturnCalculation==null?null:commodityReturnCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CommodityReturnLeg build() {
			return new CommodityReturnLeg.CommodityReturnLegImpl(this);
		}
		
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder prune() {
			super.prune();
			if (commodityCalculationPeriodsModel!=null && !commodityCalculationPeriodsModel.prune().hasData()) commodityCalculationPeriodsModel = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			if (commodityUnderlyerChoiceModel!=null && !commodityUnderlyerChoiceModel.prune().hasData()) commodityUnderlyerChoiceModel = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (notionalAmountReference!=null && !notionalAmountReference.prune().hasData()) notionalAmountReference = null;
			if (commodityReturnCalculation!=null && !commodityReturnCalculation.prune().hasData()) commodityReturnCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityCalculationPeriodsModel()!=null && getCommodityCalculationPeriodsModel().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			if (getCommodityUnderlyerChoiceModel()!=null && getCommodityUnderlyerChoiceModel().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getNotionalAmountReference()!=null && getNotionalAmountReference().hasData()) return true;
			if (getCommodityReturnCalculation()!=null && getCommodityReturnCalculation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityReturnLeg.CommodityReturnLegBuilder o = (CommodityReturnLeg.CommodityReturnLegBuilder) other;
			
			merger.mergeRosetta(getCommodityCalculationPeriodsModel(), o.getCommodityCalculationPeriodsModel(), this::setCommodityCalculationPeriodsModel);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			merger.mergeRosetta(getCommodityUnderlyerChoiceModel(), o.getCommodityUnderlyerChoiceModel(), this::setCommodityUnderlyerChoiceModel);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getNotionalAmountReference(), o.getNotionalAmountReference(), this::setNotionalAmountReference);
			merger.mergeRosetta(getCommodityReturnCalculation(), o.getCommodityReturnCalculation(), this::setCommodityReturnCalculation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityUnderlyerChoiceModel, _that.getCommodityUnderlyerChoiceModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(commodityReturnCalculation, _that.getCommodityReturnCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityUnderlyerChoiceModel != null ? commodityUnderlyerChoiceModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (commodityReturnCalculation != null ? commodityReturnCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnLegBuilder {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityUnderlyerChoiceModel=" + this.commodityUnderlyerChoiceModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"commodityReturnCalculation=" + this.commodityReturnCalculation +
			'}' + " " + super.toString();
		}
	}
}
