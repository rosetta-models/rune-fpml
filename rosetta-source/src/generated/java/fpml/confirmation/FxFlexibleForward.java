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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxFlexibleForward;
import fpml.confirmation.FxFlexibleForward.FxFlexibleForwardBuilder;
import fpml.confirmation.FxFlexibleForward.FxFlexibleForwardBuilderImpl;
import fpml.confirmation.FxFlexibleForward.FxFlexibleForwardImpl;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod;
import fpml.confirmation.FxFlexibleForwardRate;
import fpml.confirmation.FxFlexibleForwardSequence;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Payment;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallCurrencyModel;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.meta.FxFlexibleForwardMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A flexible term fx forward product definition. Product model for a flexible-term fx forward (also known as callable forward, window forward). This is a term forward transaction over a specific period, allowing the client full flexibility on the timing of the transactional flow(s). The product allows for (full or partial) execution at a predetermined forward rate, at any time between the start date and the expiry date. Although, the product is an outright, it has some option-like characteristics, leading to the use of option components in the model: (i) the BuyerSeller model expresses the roles of the parties in the overall transaction - the client &quot;buys&quot; the product (ii) the PutCallCurrency model expresses the buyer&#39;s perspective on the exchanged currencies i.e. the client may buy (call) or sell (put) the notional currency for the alternative currency.
 * @version ${project.version}
 */
@RosettaDataType(value="FxFlexibleForward", builder=FxFlexibleForward.FxFlexibleForwardBuilderImpl.class, version="${project.version}")
public interface FxFlexibleForward extends Product {

	FxFlexibleForwardMeta metaData = new FxFlexibleForwardMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	PutCallCurrencyModel getPutCallCurrencyModel();
	/**
	 * The aggregate notional amount which will be exchanged, possibly as multiple partial executions, during the course of the execution period. Any residual notional which remains unexchanged at the expiry date will automatically be executed at the applicable exchange rate (strike).
	 */
	PositiveMoney getNotionalAmount();
	/**
	 * The minimum notional amount which must be executed in any single transaction.
	 */
	PositiveMoney getMinimumExecutionAmount();
	/**
	 * The total amount of settlement currency that will be paid over the life of the trade if calculable. The Settlement Amount element is a synonym for Contra Amount.
	 */
	NonNegativeMoney getSettlementAmount();
	/**
	 * The period during which the client has the right to execute a transaction, on any business day defined by reference to the specified business centers, subject to the constraints of the minimum execution amount and aggregate total notional amount. * Period dates are inclusive i.e. the expiry date is the final date on which execution may occur.
	 */
	FxFlexibleForwardExecutionPeriod getExecutionPeriodDates();
	FxFlexibleForwardSequence getFxFlexibleForwardSequence();
	/**
	 * The date on which delivery of the transacted currency amounts will occur, expressed as an offset from the execution date. * This property is optional in the schema, allowing it to be omitted by systems which do not support it; however this information would be expected in contractual documentation (e.g. termsheet, confirmation).
	 */
	RelativeDateOffset getSettlementDateOffset();
	/**
	 * The final date for settlement. This is the date on which any residual exchange amount will be delivered. * This is an adjusted date i.e. a good business day for delivery in the location(s) specified in executionPeriodDates /businessCenters
	 */
	Date getFinalSettlementDate();
	/**
	 * Definition of the forward exchange rate for transactions executed during the execution period.
	 */
	FxFlexibleForwardRate getForwardRate();
	/**
	 * Fee paid by the client at inception (analagous to an option premium).
	 */
	Payment getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	FxFlexibleForward build();
	
	FxFlexibleForward.FxFlexibleForwardBuilder toBuilder();
	
	static FxFlexibleForward.FxFlexibleForwardBuilder builder() {
		return new FxFlexibleForward.FxFlexibleForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFlexibleForward> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFlexibleForward> getType() {
		return FxFlexibleForward.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("putCallCurrencyModel"), processor, PutCallCurrencyModel.class, getPutCallCurrencyModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, PositiveMoney.class, getNotionalAmount());
		processRosetta(path.newSubPath("minimumExecutionAmount"), processor, PositiveMoney.class, getMinimumExecutionAmount());
		processRosetta(path.newSubPath("settlementAmount"), processor, NonNegativeMoney.class, getSettlementAmount());
		processRosetta(path.newSubPath("executionPeriodDates"), processor, FxFlexibleForwardExecutionPeriod.class, getExecutionPeriodDates());
		processRosetta(path.newSubPath("fxFlexibleForwardSequence"), processor, FxFlexibleForwardSequence.class, getFxFlexibleForwardSequence());
		processRosetta(path.newSubPath("settlementDateOffset"), processor, RelativeDateOffset.class, getSettlementDateOffset());
		processor.processBasic(path.newSubPath("finalSettlementDate"), Date.class, getFinalSettlementDate(), this);
		processRosetta(path.newSubPath("forwardRate"), processor, FxFlexibleForwardRate.class, getForwardRate());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFlexibleForwardBuilder extends FxFlexibleForward, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		PutCallCurrencyModel.PutCallCurrencyModelBuilder getOrCreatePutCallCurrencyModel();
		PutCallCurrencyModel.PutCallCurrencyModelBuilder getPutCallCurrencyModel();
		PositiveMoney.PositiveMoneyBuilder getOrCreateNotionalAmount();
		PositiveMoney.PositiveMoneyBuilder getNotionalAmount();
		PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumExecutionAmount();
		PositiveMoney.PositiveMoneyBuilder getMinimumExecutionAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSettlementAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getSettlementAmount();
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getOrCreateExecutionPeriodDates();
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getExecutionPeriodDates();
		FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder getOrCreateFxFlexibleForwardSequence();
		FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder getFxFlexibleForwardSequence();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateSettlementDateOffset();
		RelativeDateOffset.RelativeDateOffsetBuilder getSettlementDateOffset();
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getOrCreateForwardRate();
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getForwardRate();
		Payment.PaymentBuilder getOrCreateAdditionalPayment();
		Payment.PaymentBuilder getAdditionalPayment();
		FxFlexibleForward.FxFlexibleForwardBuilder setProductModel(ProductModel productModel);
		FxFlexibleForward.FxFlexibleForwardBuilder setId(String id);
		FxFlexibleForward.FxFlexibleForwardBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		FxFlexibleForward.FxFlexibleForwardBuilder setPutCallCurrencyModel(PutCallCurrencyModel putCallCurrencyModel);
		FxFlexibleForward.FxFlexibleForwardBuilder setNotionalAmount(PositiveMoney notionalAmount);
		FxFlexibleForward.FxFlexibleForwardBuilder setMinimumExecutionAmount(PositiveMoney minimumExecutionAmount);
		FxFlexibleForward.FxFlexibleForwardBuilder setSettlementAmount(NonNegativeMoney settlementAmount);
		FxFlexibleForward.FxFlexibleForwardBuilder setExecutionPeriodDates(FxFlexibleForwardExecutionPeriod executionPeriodDates);
		FxFlexibleForward.FxFlexibleForwardBuilder setFxFlexibleForwardSequence(FxFlexibleForwardSequence fxFlexibleForwardSequence);
		FxFlexibleForward.FxFlexibleForwardBuilder setSettlementDateOffset(RelativeDateOffset settlementDateOffset);
		FxFlexibleForward.FxFlexibleForwardBuilder setFinalSettlementDate(Date finalSettlementDate);
		FxFlexibleForward.FxFlexibleForwardBuilder setForwardRate(FxFlexibleForwardRate forwardRate);
		FxFlexibleForward.FxFlexibleForwardBuilder setAdditionalPayment(Payment additionalPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("putCallCurrencyModel"), processor, PutCallCurrencyModel.PutCallCurrencyModelBuilder.class, getPutCallCurrencyModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("minimumExecutionAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getMinimumExecutionAmount());
			processRosetta(path.newSubPath("settlementAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("executionPeriodDates"), processor, FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder.class, getExecutionPeriodDates());
			processRosetta(path.newSubPath("fxFlexibleForwardSequence"), processor, FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder.class, getFxFlexibleForwardSequence());
			processRosetta(path.newSubPath("settlementDateOffset"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getSettlementDateOffset());
			processor.processBasic(path.newSubPath("finalSettlementDate"), Date.class, getFinalSettlementDate(), this);
			processRosetta(path.newSubPath("forwardRate"), processor, FxFlexibleForwardRate.FxFlexibleForwardRateBuilder.class, getForwardRate());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		FxFlexibleForward.FxFlexibleForwardBuilder prune();
	}

	/*********************** Immutable Implementation of FxFlexibleForward  ***********************/
	class FxFlexibleForwardImpl extends Product.ProductImpl implements FxFlexibleForward {
		private final BuyerSellerModel buyerSellerModel;
		private final PutCallCurrencyModel putCallCurrencyModel;
		private final PositiveMoney notionalAmount;
		private final PositiveMoney minimumExecutionAmount;
		private final NonNegativeMoney settlementAmount;
		private final FxFlexibleForwardExecutionPeriod executionPeriodDates;
		private final FxFlexibleForwardSequence fxFlexibleForwardSequence;
		private final RelativeDateOffset settlementDateOffset;
		private final Date finalSettlementDate;
		private final FxFlexibleForwardRate forwardRate;
		private final Payment additionalPayment;
		
		protected FxFlexibleForwardImpl(FxFlexibleForward.FxFlexibleForwardBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.putCallCurrencyModel = ofNullable(builder.getPutCallCurrencyModel()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.minimumExecutionAmount = ofNullable(builder.getMinimumExecutionAmount()).map(f->f.build()).orElse(null);
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.executionPeriodDates = ofNullable(builder.getExecutionPeriodDates()).map(f->f.build()).orElse(null);
			this.fxFlexibleForwardSequence = ofNullable(builder.getFxFlexibleForwardSequence()).map(f->f.build()).orElse(null);
			this.settlementDateOffset = ofNullable(builder.getSettlementDateOffset()).map(f->f.build()).orElse(null);
			this.finalSettlementDate = builder.getFinalSettlementDate();
			this.forwardRate = ofNullable(builder.getForwardRate()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("putCallCurrencyModel")
		public PutCallCurrencyModel getPutCallCurrencyModel() {
			return putCallCurrencyModel;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public PositiveMoney getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("minimumExecutionAmount")
		public PositiveMoney getMinimumExecutionAmount() {
			return minimumExecutionAmount;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		public NonNegativeMoney getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		@RosettaAttribute("executionPeriodDates")
		public FxFlexibleForwardExecutionPeriod getExecutionPeriodDates() {
			return executionPeriodDates;
		}
		
		@Override
		@RosettaAttribute("fxFlexibleForwardSequence")
		public FxFlexibleForwardSequence getFxFlexibleForwardSequence() {
			return fxFlexibleForwardSequence;
		}
		
		@Override
		@RosettaAttribute("settlementDateOffset")
		public RelativeDateOffset getSettlementDateOffset() {
			return settlementDateOffset;
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		public Date getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("forwardRate")
		public FxFlexibleForwardRate getForwardRate() {
			return forwardRate;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public Payment getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public FxFlexibleForward build() {
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder toBuilder() {
			FxFlexibleForward.FxFlexibleForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFlexibleForward.FxFlexibleForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getPutCallCurrencyModel()).ifPresent(builder::setPutCallCurrencyModel);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getMinimumExecutionAmount()).ifPresent(builder::setMinimumExecutionAmount);
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getExecutionPeriodDates()).ifPresent(builder::setExecutionPeriodDates);
			ofNullable(getFxFlexibleForwardSequence()).ifPresent(builder::setFxFlexibleForwardSequence);
			ofNullable(getSettlementDateOffset()).ifPresent(builder::setSettlementDateOffset);
			ofNullable(getFinalSettlementDate()).ifPresent(builder::setFinalSettlementDate);
			ofNullable(getForwardRate()).ifPresent(builder::setForwardRate);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForward _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(putCallCurrencyModel, _that.getPutCallCurrencyModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(minimumExecutionAmount, _that.getMinimumExecutionAmount())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(executionPeriodDates, _that.getExecutionPeriodDates())) return false;
			if (!Objects.equals(fxFlexibleForwardSequence, _that.getFxFlexibleForwardSequence())) return false;
			if (!Objects.equals(settlementDateOffset, _that.getSettlementDateOffset())) return false;
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(forwardRate, _that.getForwardRate())) return false;
			if (!Objects.equals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (putCallCurrencyModel != null ? putCallCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumExecutionAmount != null ? minimumExecutionAmount.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (executionPeriodDates != null ? executionPeriodDates.hashCode() : 0);
			_result = 31 * _result + (fxFlexibleForwardSequence != null ? fxFlexibleForwardSequence.hashCode() : 0);
			_result = 31 * _result + (settlementDateOffset != null ? settlementDateOffset.hashCode() : 0);
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (forwardRate != null ? forwardRate.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForward {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"putCallCurrencyModel=" + this.putCallCurrencyModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"minimumExecutionAmount=" + this.minimumExecutionAmount + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"executionPeriodDates=" + this.executionPeriodDates + ", " +
				"fxFlexibleForwardSequence=" + this.fxFlexibleForwardSequence + ", " +
				"settlementDateOffset=" + this.settlementDateOffset + ", " +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"forwardRate=" + this.forwardRate + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFlexibleForward  ***********************/
	class FxFlexibleForwardBuilderImpl extends Product.ProductBuilderImpl  implements FxFlexibleForward.FxFlexibleForwardBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected PutCallCurrencyModel.PutCallCurrencyModelBuilder putCallCurrencyModel;
		protected PositiveMoney.PositiveMoneyBuilder notionalAmount;
		protected PositiveMoney.PositiveMoneyBuilder minimumExecutionAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder settlementAmount;
		protected FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder executionPeriodDates;
		protected FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder fxFlexibleForwardSequence;
		protected RelativeDateOffset.RelativeDateOffsetBuilder settlementDateOffset;
		protected Date finalSettlementDate;
		protected FxFlexibleForwardRate.FxFlexibleForwardRateBuilder forwardRate;
		protected Payment.PaymentBuilder additionalPayment;
	
		public FxFlexibleForwardBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("putCallCurrencyModel")
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder getPutCallCurrencyModel() {
			return putCallCurrencyModel;
		}
		
		@Override
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder getOrCreatePutCallCurrencyModel() {
			PutCallCurrencyModel.PutCallCurrencyModelBuilder result;
			if (putCallCurrencyModel!=null) {
				result = putCallCurrencyModel;
			}
			else {
				result = putCallCurrencyModel = PutCallCurrencyModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public PositiveMoney.PositiveMoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateNotionalAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumExecutionAmount")
		public PositiveMoney.PositiveMoneyBuilder getMinimumExecutionAmount() {
			return minimumExecutionAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumExecutionAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (minimumExecutionAmount!=null) {
				result = minimumExecutionAmount;
			}
			else {
				result = minimumExecutionAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSettlementAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (settlementAmount!=null) {
				result = settlementAmount;
			}
			else {
				result = settlementAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionPeriodDates")
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getExecutionPeriodDates() {
			return executionPeriodDates;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getOrCreateExecutionPeriodDates() {
			FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder result;
			if (executionPeriodDates!=null) {
				result = executionPeriodDates;
			}
			else {
				result = executionPeriodDates = FxFlexibleForwardExecutionPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFlexibleForwardSequence")
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder getFxFlexibleForwardSequence() {
			return fxFlexibleForwardSequence;
		}
		
		@Override
		public FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder getOrCreateFxFlexibleForwardSequence() {
			FxFlexibleForwardSequence.FxFlexibleForwardSequenceBuilder result;
			if (fxFlexibleForwardSequence!=null) {
				result = fxFlexibleForwardSequence;
			}
			else {
				result = fxFlexibleForwardSequence = FxFlexibleForwardSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDateOffset")
		public RelativeDateOffset.RelativeDateOffsetBuilder getSettlementDateOffset() {
			return settlementDateOffset;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateSettlementDateOffset() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (settlementDateOffset!=null) {
				result = settlementDateOffset;
			}
			else {
				result = settlementDateOffset = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		public Date getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("forwardRate")
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getForwardRate() {
			return forwardRate;
		}
		
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getOrCreateForwardRate() {
			FxFlexibleForwardRate.FxFlexibleForwardRateBuilder result;
			if (forwardRate!=null) {
				result = forwardRate;
			}
			else {
				result = forwardRate = FxFlexibleForwardRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public Payment.PaymentBuilder getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateAdditionalPayment() {
			Payment.PaymentBuilder result;
			if (additionalPayment!=null) {
				result = additionalPayment;
			}
			else {
				result = additionalPayment = Payment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxFlexibleForward.FxFlexibleForwardBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxFlexibleForward.FxFlexibleForwardBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public FxFlexibleForward.FxFlexibleForwardBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("putCallCurrencyModel")
		public FxFlexibleForward.FxFlexibleForwardBuilder setPutCallCurrencyModel(PutCallCurrencyModel putCallCurrencyModel) {
			this.putCallCurrencyModel = putCallCurrencyModel==null?null:putCallCurrencyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxFlexibleForward.FxFlexibleForwardBuilder setNotionalAmount(PositiveMoney notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("minimumExecutionAmount")
		public FxFlexibleForward.FxFlexibleForwardBuilder setMinimumExecutionAmount(PositiveMoney minimumExecutionAmount) {
			this.minimumExecutionAmount = minimumExecutionAmount==null?null:minimumExecutionAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementAmount")
		public FxFlexibleForward.FxFlexibleForwardBuilder setSettlementAmount(NonNegativeMoney settlementAmount) {
			this.settlementAmount = settlementAmount==null?null:settlementAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("executionPeriodDates")
		public FxFlexibleForward.FxFlexibleForwardBuilder setExecutionPeriodDates(FxFlexibleForwardExecutionPeriod executionPeriodDates) {
			this.executionPeriodDates = executionPeriodDates==null?null:executionPeriodDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFlexibleForwardSequence")
		public FxFlexibleForward.FxFlexibleForwardBuilder setFxFlexibleForwardSequence(FxFlexibleForwardSequence fxFlexibleForwardSequence) {
			this.fxFlexibleForwardSequence = fxFlexibleForwardSequence==null?null:fxFlexibleForwardSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDateOffset")
		public FxFlexibleForward.FxFlexibleForwardBuilder setSettlementDateOffset(RelativeDateOffset settlementDateOffset) {
			this.settlementDateOffset = settlementDateOffset==null?null:settlementDateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finalSettlementDate")
		public FxFlexibleForward.FxFlexibleForwardBuilder setFinalSettlementDate(Date finalSettlementDate) {
			this.finalSettlementDate = finalSettlementDate==null?null:finalSettlementDate;
			return this;
		}
		@Override
		@RosettaAttribute("forwardRate")
		public FxFlexibleForward.FxFlexibleForwardBuilder setForwardRate(FxFlexibleForwardRate forwardRate) {
			this.forwardRate = forwardRate==null?null:forwardRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalPayment")
		public FxFlexibleForward.FxFlexibleForwardBuilder setAdditionalPayment(Payment additionalPayment) {
			this.additionalPayment = additionalPayment==null?null:additionalPayment.toBuilder();
			return this;
		}
		
		@Override
		public FxFlexibleForward build() {
			return new FxFlexibleForward.FxFlexibleForwardImpl(this);
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (putCallCurrencyModel!=null && !putCallCurrencyModel.prune().hasData()) putCallCurrencyModel = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (minimumExecutionAmount!=null && !minimumExecutionAmount.prune().hasData()) minimumExecutionAmount = null;
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
			if (executionPeriodDates!=null && !executionPeriodDates.prune().hasData()) executionPeriodDates = null;
			if (fxFlexibleForwardSequence!=null && !fxFlexibleForwardSequence.prune().hasData()) fxFlexibleForwardSequence = null;
			if (settlementDateOffset!=null && !settlementDateOffset.prune().hasData()) settlementDateOffset = null;
			if (forwardRate!=null && !forwardRate.prune().hasData()) forwardRate = null;
			if (additionalPayment!=null && !additionalPayment.prune().hasData()) additionalPayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getPutCallCurrencyModel()!=null && getPutCallCurrencyModel().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getMinimumExecutionAmount()!=null && getMinimumExecutionAmount().hasData()) return true;
			if (getSettlementAmount()!=null && getSettlementAmount().hasData()) return true;
			if (getExecutionPeriodDates()!=null && getExecutionPeriodDates().hasData()) return true;
			if (getFxFlexibleForwardSequence()!=null && getFxFlexibleForwardSequence().hasData()) return true;
			if (getSettlementDateOffset()!=null && getSettlementDateOffset().hasData()) return true;
			if (getFinalSettlementDate()!=null) return true;
			if (getForwardRate()!=null && getForwardRate().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxFlexibleForward.FxFlexibleForwardBuilder o = (FxFlexibleForward.FxFlexibleForwardBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getPutCallCurrencyModel(), o.getPutCallCurrencyModel(), this::setPutCallCurrencyModel);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getMinimumExecutionAmount(), o.getMinimumExecutionAmount(), this::setMinimumExecutionAmount);
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getExecutionPeriodDates(), o.getExecutionPeriodDates(), this::setExecutionPeriodDates);
			merger.mergeRosetta(getFxFlexibleForwardSequence(), o.getFxFlexibleForwardSequence(), this::setFxFlexibleForwardSequence);
			merger.mergeRosetta(getSettlementDateOffset(), o.getSettlementDateOffset(), this::setSettlementDateOffset);
			merger.mergeRosetta(getForwardRate(), o.getForwardRate(), this::setForwardRate);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::setAdditionalPayment);
			
			merger.mergeBasic(getFinalSettlementDate(), o.getFinalSettlementDate(), this::setFinalSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForward _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(putCallCurrencyModel, _that.getPutCallCurrencyModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(minimumExecutionAmount, _that.getMinimumExecutionAmount())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(executionPeriodDates, _that.getExecutionPeriodDates())) return false;
			if (!Objects.equals(fxFlexibleForwardSequence, _that.getFxFlexibleForwardSequence())) return false;
			if (!Objects.equals(settlementDateOffset, _that.getSettlementDateOffset())) return false;
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(forwardRate, _that.getForwardRate())) return false;
			if (!Objects.equals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (putCallCurrencyModel != null ? putCallCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumExecutionAmount != null ? minimumExecutionAmount.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (executionPeriodDates != null ? executionPeriodDates.hashCode() : 0);
			_result = 31 * _result + (fxFlexibleForwardSequence != null ? fxFlexibleForwardSequence.hashCode() : 0);
			_result = 31 * _result + (settlementDateOffset != null ? settlementDateOffset.hashCode() : 0);
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (forwardRate != null ? forwardRate.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"putCallCurrencyModel=" + this.putCallCurrencyModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"minimumExecutionAmount=" + this.minimumExecutionAmount + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"executionPeriodDates=" + this.executionPeriodDates + ", " +
				"fxFlexibleForwardSequence=" + this.fxFlexibleForwardSequence + ", " +
				"settlementDateOffset=" + this.settlementDateOffset + ", " +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"forwardRate=" + this.forwardRate + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
