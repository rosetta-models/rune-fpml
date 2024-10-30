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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.FxPerformanceFixedLeg;
import fpml.confirmation.FxPerformanceFloatingLeg;
import fpml.confirmation.FxPerformanceSwap;
import fpml.confirmation.FxPerformanceSwap.FxPerformanceSwapBuilder;
import fpml.confirmation.FxPerformanceSwap.FxPerformanceSwapBuilderImpl;
import fpml.confirmation.FxPerformanceSwap.FxPerformanceSwapImpl;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.FxValuationDateOffset;
import fpml.confirmation.FxVarianceSwap;
import fpml.confirmation.FxVarianceSwap.FxVarianceSwapBuilder;
import fpml.confirmation.FxVarianceSwap.FxVarianceSwapBuilderImpl;
import fpml.confirmation.FxVarianceSwap.FxVarianceSwapImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Payment;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxVarianceSwapMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An FX variance swap transaction definition.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxVarianceSwap", builder=FxVarianceSwap.FxVarianceSwapBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxVarianceSwap extends FxPerformanceSwap {

	FxVarianceSwapMeta metaData = new FxVarianceSwapMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxVarianceSwap build();
	
	FxVarianceSwap.FxVarianceSwapBuilder toBuilder();
	
	static FxVarianceSwap.FxVarianceSwapBuilder builder() {
		return new FxVarianceSwap.FxVarianceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxVarianceSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxVarianceSwap> getType() {
		return FxVarianceSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.class, getVegaNotional());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.class, getFixedLeg());
		processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.class, getFloatingLeg());
		processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.class, getFixingInformationSource());
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("valuationDate"), Date.class, getValuationDate(), this);
		processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.class, getValuationDateOffset());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.class, getSettlementDate());
		processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
		processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
		processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxVarianceSwapBuilder extends FxVarianceSwap, FxPerformanceSwap.FxPerformanceSwapBuilder {
		FxVarianceSwap.FxVarianceSwapBuilder setProductModel(ProductModel productModel);
		FxVarianceSwap.FxVarianceSwapBuilder setId(String id);
		FxVarianceSwap.FxVarianceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxVarianceSwap.FxVarianceSwapBuilder setVegaNotional(NonNegativeMoney vegaNotional);
		FxVarianceSwap.FxVarianceSwapBuilder setNotional(NonNegativeMoney notional);
		FxVarianceSwap.FxVarianceSwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg);
		FxVarianceSwap.FxVarianceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg);
		FxVarianceSwap.FxVarianceSwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource);
		FxVarianceSwap.FxVarianceSwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule);
		FxVarianceSwap.FxVarianceSwapBuilder setValuationDate(Date valuationDate);
		FxVarianceSwap.FxVarianceSwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset);
		FxVarianceSwap.FxVarianceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate);
		FxVarianceSwap.FxVarianceSwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor);
		FxVarianceSwap.FxVarianceSwapBuilder setMeanAdjustment(Boolean meanAdjustment);
		FxVarianceSwap.FxVarianceSwapBuilder setNumberOfReturns(Integer numberOfReturns);
		FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment additionalPayment0);
		FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		FxVarianceSwap.FxVarianceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);
		FxVarianceSwap.FxVarianceSwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getVegaNotional());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder.class, getFixedLeg());
			processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder.class, getFloatingLeg());
			processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFixingInformationSource());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("valuationDate"), Date.class, getValuationDate(), this);
			processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.FxValuationDateOffsetBuilder.class, getValuationDateOffset());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getSettlementDate());
			processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
			processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
			processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
		}
		

		FxVarianceSwap.FxVarianceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of FxVarianceSwap  ***********************/
	class FxVarianceSwapImpl extends FxPerformanceSwap.FxPerformanceSwapImpl implements FxVarianceSwap {
		
		protected FxVarianceSwapImpl(FxVarianceSwap.FxVarianceSwapBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxVarianceSwap build() {
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder toBuilder() {
			FxVarianceSwap.FxVarianceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxVarianceSwap.FxVarianceSwapBuilder builder) {
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
			return "FxVarianceSwap {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxVarianceSwap  ***********************/
	class FxVarianceSwapBuilderImpl extends FxPerformanceSwap.FxPerformanceSwapBuilderImpl  implements FxVarianceSwap.FxVarianceSwapBuilder {
	
	
		public FxVarianceSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("productModel")
		public FxVarianceSwap.FxVarianceSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxVarianceSwap.FxVarianceSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxVarianceSwap.FxVarianceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("vegaNotional")
		public FxVarianceSwap.FxVarianceSwapBuilder setVegaNotional(NonNegativeMoney vegaNotional) {
			this.vegaNotional = vegaNotional==null?null:vegaNotional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public FxVarianceSwap.FxVarianceSwapBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedLeg")
		public FxVarianceSwap.FxVarianceSwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg) {
			this.fixedLeg = fixedLeg==null?null:fixedLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingLeg")
		public FxVarianceSwap.FxVarianceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg) {
			this.floatingLeg = floatingLeg==null?null:floatingLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxVarianceSwap.FxVarianceSwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource) {
			this.fixingInformationSource = fixingInformationSource==null?null:fixingInformationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxVarianceSwap.FxVarianceSwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule) {
			this.fixingSchedule = fixingSchedule==null?null:fixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDate")
		public FxVarianceSwap.FxVarianceSwapBuilder setValuationDate(Date valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate;
			return this;
		}
		@Override
		@RosettaAttribute("valuationDateOffset")
		public FxVarianceSwap.FxVarianceSwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset) {
			this.valuationDateOffset = valuationDateOffset==null?null:valuationDateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public FxVarianceSwap.FxVarianceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("annualizationFactor")
		public FxVarianceSwap.FxVarianceSwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor) {
			this.annualizationFactor = annualizationFactor==null?null:annualizationFactor;
			return this;
		}
		@Override
		@RosettaAttribute("meanAdjustment")
		public FxVarianceSwap.FxVarianceSwapBuilder setMeanAdjustment(Boolean meanAdjustment) {
			this.meanAdjustment = meanAdjustment==null?null:meanAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfReturns")
		public FxVarianceSwap.FxVarianceSwapBuilder setNumberOfReturns(Integer numberOfReturns) {
			this.numberOfReturns = numberOfReturns==null?null:numberOfReturns;
			return this;
		}
		@Override
		@RosettaAttribute("additionalPayment")
		public FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxVarianceSwap.FxVarianceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments == null)  {
				this.additionalPayment = new ArrayList<>();
			}
			else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxVarianceSwap.FxVarianceSwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxVarianceSwap build() {
			return new FxVarianceSwap.FxVarianceSwapImpl(this);
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder prune() {
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
		public FxVarianceSwap.FxVarianceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxVarianceSwap.FxVarianceSwapBuilder o = (FxVarianceSwap.FxVarianceSwapBuilder) other;
			
			
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
			return "FxVarianceSwapBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
