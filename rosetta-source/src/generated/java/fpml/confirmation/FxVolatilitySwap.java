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
import fpml.confirmation.FxVolatilitySwap;
import fpml.confirmation.FxVolatilitySwap.FxVolatilitySwapBuilder;
import fpml.confirmation.FxVolatilitySwap.FxVolatilitySwapBuilderImpl;
import fpml.confirmation.FxVolatilitySwap.FxVolatilitySwapImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Payment;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxVolatilitySwapMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An FX volatility swap transaction definition.
 * @version ${project.version}
 */
@RosettaDataType(value="FxVolatilitySwap", builder=FxVolatilitySwap.FxVolatilitySwapBuilderImpl.class, version="${project.version}")
public interface FxVolatilitySwap extends FxPerformanceSwap {

	FxVolatilitySwapMeta metaData = new FxVolatilitySwapMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxVolatilitySwap build();
	
	FxVolatilitySwap.FxVolatilitySwapBuilder toBuilder();
	
	static FxVolatilitySwap.FxVolatilitySwapBuilder builder() {
		return new FxVolatilitySwap.FxVolatilitySwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxVolatilitySwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxVolatilitySwap> getType() {
		return FxVolatilitySwap.class;
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
	interface FxVolatilitySwapBuilder extends FxVolatilitySwap, FxPerformanceSwap.FxPerformanceSwapBuilder {
		FxVolatilitySwap.FxVolatilitySwapBuilder setProductModel(ProductModel productModel);
		FxVolatilitySwap.FxVolatilitySwapBuilder setId(String id);
		FxVolatilitySwap.FxVolatilitySwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxVolatilitySwap.FxVolatilitySwapBuilder setVegaNotional(NonNegativeMoney vegaNotional);
		FxVolatilitySwap.FxVolatilitySwapBuilder setNotional(NonNegativeMoney notional);
		FxVolatilitySwap.FxVolatilitySwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg);
		FxVolatilitySwap.FxVolatilitySwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg);
		FxVolatilitySwap.FxVolatilitySwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource);
		FxVolatilitySwap.FxVolatilitySwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule);
		FxVolatilitySwap.FxVolatilitySwapBuilder setValuationDate(Date valuationDate);
		FxVolatilitySwap.FxVolatilitySwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset);
		FxVolatilitySwap.FxVolatilitySwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate);
		FxVolatilitySwap.FxVolatilitySwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor);
		FxVolatilitySwap.FxVolatilitySwapBuilder setMeanAdjustment(Boolean meanAdjustment);
		FxVolatilitySwap.FxVolatilitySwapBuilder setNumberOfReturns(Integer numberOfReturns);
		FxVolatilitySwap.FxVolatilitySwapBuilder addAdditionalPayment(Payment additionalPayment0);
		FxVolatilitySwap.FxVolatilitySwapBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		FxVolatilitySwap.FxVolatilitySwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		FxVolatilitySwap.FxVolatilitySwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);
		FxVolatilitySwap.FxVolatilitySwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);

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
		

		FxVolatilitySwap.FxVolatilitySwapBuilder prune();
	}

	/*********************** Immutable Implementation of FxVolatilitySwap  ***********************/
	class FxVolatilitySwapImpl extends FxPerformanceSwap.FxPerformanceSwapImpl implements FxVolatilitySwap {
		
		protected FxVolatilitySwapImpl(FxVolatilitySwap.FxVolatilitySwapBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxVolatilitySwap build() {
			return this;
		}
		
		@Override
		public FxVolatilitySwap.FxVolatilitySwapBuilder toBuilder() {
			FxVolatilitySwap.FxVolatilitySwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxVolatilitySwap.FxVolatilitySwapBuilder builder) {
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
			return "FxVolatilitySwap {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxVolatilitySwap  ***********************/
	class FxVolatilitySwapBuilderImpl extends FxPerformanceSwap.FxPerformanceSwapBuilderImpl  implements FxVolatilitySwap.FxVolatilitySwapBuilder {
	
	
		public FxVolatilitySwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("productModel")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("vegaNotional")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setVegaNotional(NonNegativeMoney vegaNotional) {
			this.vegaNotional = vegaNotional==null?null:vegaNotional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedLeg")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg) {
			this.fixedLeg = fixedLeg==null?null:fixedLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingLeg")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg) {
			this.floatingLeg = floatingLeg==null?null:floatingLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource) {
			this.fixingInformationSource = fixingInformationSource==null?null:fixingInformationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule) {
			this.fixingSchedule = fixingSchedule==null?null:fixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDate")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setValuationDate(Date valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate;
			return this;
		}
		@Override
		@RosettaAttribute("valuationDateOffset")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset) {
			this.valuationDateOffset = valuationDateOffset==null?null:valuationDateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("annualizationFactor")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor) {
			this.annualizationFactor = annualizationFactor==null?null:annualizationFactor;
			return this;
		}
		@Override
		@RosettaAttribute("meanAdjustment")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setMeanAdjustment(Boolean meanAdjustment) {
			this.meanAdjustment = meanAdjustment==null?null:meanAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfReturns")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setNumberOfReturns(Integer numberOfReturns) {
			this.numberOfReturns = numberOfReturns==null?null:numberOfReturns;
			return this;
		}
		@Override
		public FxVolatilitySwap.FxVolatilitySwapBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxVolatilitySwap.FxVolatilitySwapBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public FxVolatilitySwap.FxVolatilitySwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public FxVolatilitySwap.FxVolatilitySwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public FxVolatilitySwap.FxVolatilitySwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxVolatilitySwap build() {
			return new FxVolatilitySwap.FxVolatilitySwapImpl(this);
		}
		
		@Override
		public FxVolatilitySwap.FxVolatilitySwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxVolatilitySwap.FxVolatilitySwapBuilder prune() {
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
		public FxVolatilitySwap.FxVolatilitySwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxVolatilitySwap.FxVolatilitySwapBuilder o = (FxVolatilitySwap.FxVolatilitySwapBuilder) other;
			
			
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
			return "FxVolatilitySwapBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
