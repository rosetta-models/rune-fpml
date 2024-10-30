package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxAccrualForward;
import fpml.confirmation.FxAccrualForward.FxAccrualForwardBuilder;
import fpml.confirmation.FxAccrualForward.FxAccrualForwardBuilderImpl;
import fpml.confirmation.FxAccrualForward.FxAccrualForwardImpl;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.meta.FxAccrualForwardMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structured forward product consisting of a single forward or a strip of forwards. For each forward, a fixed proportion of Notional is accumulated for each occasion that spot fixes within pre-defined limits (the &#39;accrual region&#39;) - the proportion determined by the number of fixings, which may occur every business day or with some other defined frequency. The Notional does not accumulate during any period where fixings fall outside the accrual region, but resumes accruing when spot returns within the limits. At expiry, the accrued Notional is bought at the pre-agreed hedge rate (the &#39;strike&#39; rate). The trade allows for a hedge rate that is better than the forward rate, however the notional amount hedged is uncertain, and can be zero in the worst case. The product defines a schedule of expiry and delivery dates which specify settlement periods. The product further defines a schedule of fixing (or observation) dates and defines regions of spot where the product settlement amounts will accrue. There are n total fixings. One accumulates a fixed proportion of Notional (1/n) for every observation date that spot fixes within the pre-defined limits of the accrual regions. If spot breaks the limits, the Notional stops accumulating during the fixings outside the limits, but continues accruing once spot comes back to the accruing region. At expiry, one buys the accrued Notional at the pre-agreed hedge rate. Payout can be cash or physical. The variation of this product include: Accrual Forward (European and American), Double Accrual Forward (DAF), Boosted Accrual Forward, Fading Forward, Leveraged Accrual Forward, Accrual Forward with Collars, etc.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualForward", builder=FxAccrualForward.FxAccrualForwardBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualForward extends Product {

	FxAccrualForwardMeta metaData = new FxAccrualForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Notional amount Schedule. The notional value of the product per settlement period. The notional amount may differ for each settlement period. This number divided by the total number of fixings in the settlement period is the amount that is accrued at each fixing if the accrual factor is one.
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 * Describes accrual features within the product.
	 */
	FxAccrual getAccrual();
	FxExpiryDateOrScheduleModel getFxExpiryDateOrScheduleModel();
	FxSettlementDateOrScheduleModel getFxSettlementDateOrScheduleModel();
	/**
	 * An optional element used for FX forwards and certain types of FX OTC options. For deals consummated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move &quot;up&quot; or &quot;down&quot; to be triggered.
	 */
	BigDecimal getSpotRate();
	/**
	 * A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 */
	List<? extends FxAccrualLinearPayoffRegion> getLinearPayoffRegion();
	/**
	 * Average Rate Forward: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 */
	FxAverageRate getAverageRate();
	/**
	 * Defines a FX Accrual barrier conditions. Element barrier/scope specifies whether the barrier applies to the expiry period in which it is observed, or globally for whole product.
	 */
	List<? extends FxAccrualBarrier> getBarrier();
	/**
	 * It supports the representation of premiums, fees, etc.
	 */
	List<? extends SimplePayment> getAdditionalPayment();
	/**
	 * Cash settlement currency.
	 */
	FxCashSettlementSimple getCashSettlement();
	/**
	 * It supports the representation of a matrix/tabular approach of the product by defining a set of settlement periods.
	 */
	FxAccrualSettlementPeriodSchedule getSettlementPeriodSchedule();

	/*********************** Build Methods  ***********************/
	FxAccrualForward build();
	
	FxAccrualForward.FxAccrualForwardBuilder toBuilder();
	
	static FxAccrualForward.FxAccrualForwardBuilder builder() {
		return new FxAccrualForward.FxAccrualForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualForward> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualForward> getType() {
		return FxAccrualForward.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.class, getFxExpiryDateOrScheduleModel());
		processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.class, getFxSettlementDateOrScheduleModel());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxAccrualLinearPayoffRegion.class, getLinearPayoffRegion());
		processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.class, getAverageRate());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
		processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxAccrualSettlementPeriodSchedule.class, getSettlementPeriodSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualForwardBuilder extends FxAccrualForward, Product.ProductBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxAccrual.FxAccrualBuilder getOrCreateAccrual();
		FxAccrual.FxAccrualBuilder getAccrual();
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getOrCreateFxExpiryDateOrScheduleModel();
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getFxExpiryDateOrScheduleModel();
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getOrCreateFxSettlementDateOrScheduleModel();
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getFxSettlementDateOrScheduleModel();
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion(int _index);
		List<? extends FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder> getLinearPayoffRegion();
		FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate();
		FxAverageRate.FxAverageRateBuilder getAverageRate();
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int _index);
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		SimplePayment.SimplePaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends SimplePayment.SimplePaymentBuilder> getAdditionalPayment();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule();
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getSettlementPeriodSchedule();
		FxAccrualForward.FxAccrualForwardBuilder setProductModel(ProductModel productModel);
		FxAccrualForward.FxAccrualForwardBuilder setId(String id);
		FxAccrualForward.FxAccrualForwardBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualForward.FxAccrualForwardBuilder setAccrual(FxAccrual accrual);
		FxAccrualForward.FxAccrualForwardBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel);
		FxAccrualForward.FxAccrualForwardBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel);
		FxAccrualForward.FxAccrualForwardBuilder setSpotRate(BigDecimal spotRate);
		FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion linearPayoffRegion0);
		FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion linearPayoffRegion1, int _idx);
		FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegion2);
		FxAccrualForward.FxAccrualForwardBuilder setLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegion3);
		FxAccrualForward.FxAccrualForwardBuilder setAverageRate(FxAverageRate averageRate);
		FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier barrier0);
		FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier barrier1, int _idx);
		FxAccrualForward.FxAccrualForwardBuilder addBarrier(List<? extends FxAccrualBarrier> barrier2);
		FxAccrualForward.FxAccrualForwardBuilder setBarrier(List<? extends FxAccrualBarrier> barrier3);
		FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment additionalPayment0);
		FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment additionalPayment1, int _idx);
		FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayment2);
		FxAccrualForward.FxAccrualForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayment3);
		FxAccrualForward.FxAccrualForwardBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);
		FxAccrualForward.FxAccrualForwardBuilder setSettlementPeriodSchedule(FxAccrualSettlementPeriodSchedule settlementPeriodSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("fxExpiryDateOrScheduleModel"), processor, FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder.class, getFxExpiryDateOrScheduleModel());
			processRosetta(path.newSubPath("fxSettlementDateOrScheduleModel"), processor, FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder.class, getFxSettlementDateOrScheduleModel());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder.class, getLinearPayoffRegion());
			processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.FxAverageRateBuilder.class, getAverageRate());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.SimplePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder.class, getSettlementPeriodSchedule());
		}
		

		FxAccrualForward.FxAccrualForwardBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualForward  ***********************/
	class FxAccrualForwardImpl extends Product.ProductImpl implements FxAccrualForward {
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel;
		private final FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel;
		private final BigDecimal spotRate;
		private final List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegion;
		private final FxAverageRate averageRate;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends SimplePayment> additionalPayment;
		private final FxCashSettlementSimple cashSettlement;
		private final FxAccrualSettlementPeriodSchedule settlementPeriodSchedule;
		
		protected FxAccrualForwardImpl(FxAccrualForward.FxAccrualForwardBuilder builder) {
			super(builder);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.fxExpiryDateOrScheduleModel = ofNullable(builder.getFxExpiryDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.fxSettlementDateOrScheduleModel = ofNullable(builder.getFxSettlementDateOrScheduleModel()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.linearPayoffRegion = ofNullable(builder.getLinearPayoffRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.averageRate = ofNullable(builder.getAverageRate()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.settlementPeriodSchedule = ofNullable(builder.getSettlementPeriodSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("accrual")
		public FxAccrual getAccrual() {
			return accrual;
		}
		
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxExpiryDateOrScheduleModel getFxExpiryDateOrScheduleModel() {
			return fxExpiryDateOrScheduleModel;
		}
		
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxSettlementDateOrScheduleModel getFxSettlementDateOrScheduleModel() {
			return fxSettlementDateOrScheduleModel;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public List<? extends FxAccrualLinearPayoffRegion> getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("averageRate")
		public FxAverageRate getAverageRate() {
			return averageRate;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxAccrualBarrier> getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends SimplePayment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxCashSettlementSimple getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		public FxAccrualSettlementPeriodSchedule getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxAccrualForward build() {
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder toBuilder() {
			FxAccrualForward.FxAccrualForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualForward.FxAccrualForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getFxExpiryDateOrScheduleModel()).ifPresent(builder::setFxExpiryDateOrScheduleModel);
			ofNullable(getFxSettlementDateOrScheduleModel()).ifPresent(builder::setFxSettlementDateOrScheduleModel);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getLinearPayoffRegion()).ifPresent(builder::setLinearPayoffRegion);
			ofNullable(getAverageRate()).ifPresent(builder::setAverageRate);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getSettlementPeriodSchedule()).ifPresent(builder::setSettlementPeriodSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualForward _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualForward {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"spotRate=" + this.spotRate + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualForward  ***********************/
	class FxAccrualForwardBuilderImpl extends Product.ProductBuilderImpl  implements FxAccrualForward.FxAccrualForwardBuilder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder fxExpiryDateOrScheduleModel;
		protected FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder fxSettlementDateOrScheduleModel;
		protected BigDecimal spotRate;
		protected List<FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder> linearPayoffRegion = new ArrayList<>();
		protected FxAverageRate.FxAverageRateBuilder averageRate;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<SimplePayment.SimplePaymentBuilder> additionalPayment = new ArrayList<>();
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
		protected FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder settlementPeriodSchedule;
	
		public FxAccrualForwardBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrual")
		public FxAccrual.FxAccrualBuilder getAccrual() {
			return accrual;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder getOrCreateAccrual() {
			FxAccrual.FxAccrualBuilder result;
			if (accrual!=null) {
				result = accrual;
			}
			else {
				result = accrual = FxAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getFxExpiryDateOrScheduleModel() {
			return fxExpiryDateOrScheduleModel;
		}
		
		@Override
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder getOrCreateFxExpiryDateOrScheduleModel() {
			FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder result;
			if (fxExpiryDateOrScheduleModel!=null) {
				result = fxExpiryDateOrScheduleModel;
			}
			else {
				result = fxExpiryDateOrScheduleModel = FxExpiryDateOrScheduleModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getFxSettlementDateOrScheduleModel() {
			return fxSettlementDateOrScheduleModel;
		}
		
		@Override
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder getOrCreateFxSettlementDateOrScheduleModel() {
			FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder result;
			if (fxSettlementDateOrScheduleModel!=null) {
				result = fxSettlementDateOrScheduleModel;
			}
			else {
				result = fxSettlementDateOrScheduleModel = FxSettlementDateOrScheduleModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public List<? extends FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder> getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion(int _index) {
		
			if (linearPayoffRegion==null) {
				this.linearPayoffRegion = new ArrayList<>();
			}
			FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder result;
			return getIndex(linearPayoffRegion, _index, () -> {
						FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder newLinearPayoffRegion = FxAccrualLinearPayoffRegion.builder();
						return newLinearPayoffRegion;
					});
		}
		
		@Override
		@RosettaAttribute("averageRate")
		public FxAverageRate.FxAverageRateBuilder getAverageRate() {
			return averageRate;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate() {
			FxAverageRate.FxAverageRateBuilder result;
			if (averageRate!=null) {
				result = averageRate;
			}
			else {
				result = averageRate = FxAverageRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int _index) {
		
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			FxAccrualBarrier.FxAccrualBarrierBuilder result;
			return getIndex(barrier, _index, () -> {
						FxAccrualBarrier.FxAccrualBarrierBuilder newBarrier = FxAccrualBarrier.builder();
						return newBarrier;
					});
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends SimplePayment.SimplePaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateAdditionalPayment(int _index) {
		
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			SimplePayment.SimplePaymentBuilder result;
			return getIndex(additionalPayment, _index, () -> {
						SimplePayment.SimplePaymentBuilder newAdditionalPayment = SimplePayment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlementSimple.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule() {
			FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder result;
			if (settlementPeriodSchedule!=null) {
				result = settlementPeriodSchedule;
			}
			else {
				result = settlementPeriodSchedule = FxAccrualSettlementPeriodSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxAccrualForward.FxAccrualForwardBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxAccrualForward.FxAccrualForwardBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxAccrualForward.FxAccrualForwardBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrual")
		public FxAccrualForward.FxAccrualForwardBuilder setAccrual(FxAccrual accrual) {
			this.accrual = accrual==null?null:accrual.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxExpiryDateOrScheduleModel")
		public FxAccrualForward.FxAccrualForwardBuilder setFxExpiryDateOrScheduleModel(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
			this.fxExpiryDateOrScheduleModel = fxExpiryDateOrScheduleModel==null?null:fxExpiryDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxSettlementDateOrScheduleModel")
		public FxAccrualForward.FxAccrualForwardBuilder setFxSettlementDateOrScheduleModel(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel) {
			this.fxSettlementDateOrScheduleModel = fxSettlementDateOrScheduleModel==null?null:fxSettlementDateOrScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxAccrualForward.FxAccrualForwardBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion linearPayoffRegion) {
			if (linearPayoffRegion!=null) this.linearPayoffRegion.add(linearPayoffRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion linearPayoffRegion, int _idx) {
			getIndex(this.linearPayoffRegion, _idx, () -> linearPayoffRegion.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegions) {
			if (linearPayoffRegions != null) {
				for (FxAccrualLinearPayoffRegion toAdd : linearPayoffRegions) {
					this.linearPayoffRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualForward.FxAccrualForwardBuilder setLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegions) {
			if (linearPayoffRegions == null)  {
				this.linearPayoffRegion = new ArrayList<>();
			}
			else {
				this.linearPayoffRegion = linearPayoffRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("averageRate")
		public FxAccrualForward.FxAccrualForwardBuilder setAverageRate(FxAverageRate averageRate) {
			this.averageRate = averageRate==null?null:averageRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualForward.FxAccrualForwardBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers != null) {
				for (FxAccrualBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualForward.FxAccrualForwardBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers == null)  {
				this.barrier = new ArrayList<>();
			}
			else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (SimplePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualForward.FxAccrualForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
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
		public FxAccrualForward.FxAccrualForwardBuilder setCashSettlement(FxCashSettlementSimple cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		public FxAccrualForward.FxAccrualForwardBuilder setSettlementPeriodSchedule(FxAccrualSettlementPeriodSchedule settlementPeriodSchedule) {
			this.settlementPeriodSchedule = settlementPeriodSchedule==null?null:settlementPeriodSchedule.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualForward build() {
			return new FxAccrualForward.FxAccrualForwardImpl(this);
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder prune() {
			super.prune();
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (fxExpiryDateOrScheduleModel!=null && !fxExpiryDateOrScheduleModel.prune().hasData()) fxExpiryDateOrScheduleModel = null;
			if (fxSettlementDateOrScheduleModel!=null && !fxSettlementDateOrScheduleModel.prune().hasData()) fxSettlementDateOrScheduleModel = null;
			linearPayoffRegion = linearPayoffRegion.stream().filter(b->b!=null).<FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (averageRate!=null && !averageRate.prune().hasData()) averageRate = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<SimplePayment.SimplePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (settlementPeriodSchedule!=null && !settlementPeriodSchedule.prune().hasData()) settlementPeriodSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			if (getFxExpiryDateOrScheduleModel()!=null && getFxExpiryDateOrScheduleModel().hasData()) return true;
			if (getFxSettlementDateOrScheduleModel()!=null && getFxSettlementDateOrScheduleModel().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getLinearPayoffRegion()!=null && getLinearPayoffRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAverageRate()!=null && getAverageRate().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getSettlementPeriodSchedule()!=null && getSettlementPeriodSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualForward.FxAccrualForwardBuilder o = (FxAccrualForward.FxAccrualForwardBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getFxExpiryDateOrScheduleModel(), o.getFxExpiryDateOrScheduleModel(), this::setFxExpiryDateOrScheduleModel);
			merger.mergeRosetta(getFxSettlementDateOrScheduleModel(), o.getFxSettlementDateOrScheduleModel(), this::setFxSettlementDateOrScheduleModel);
			merger.mergeRosetta(getLinearPayoffRegion(), o.getLinearPayoffRegion(), this::getOrCreateLinearPayoffRegion);
			merger.mergeRosetta(getAverageRate(), o.getAverageRate(), this::setAverageRate);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getSettlementPeriodSchedule(), o.getSettlementPeriodSchedule(), this::setSettlementPeriodSchedule);
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualForward _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(fxExpiryDateOrScheduleModel, _that.getFxExpiryDateOrScheduleModel())) return false;
			if (!Objects.equals(fxSettlementDateOrScheduleModel, _that.getFxSettlementDateOrScheduleModel())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (fxExpiryDateOrScheduleModel != null ? fxExpiryDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (fxSettlementDateOrScheduleModel != null ? fxSettlementDateOrScheduleModel.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualForwardBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"fxExpiryDateOrScheduleModel=" + this.fxExpiryDateOrScheduleModel + ", " +
				"fxSettlementDateOrScheduleModel=" + this.fxSettlementDateOrScheduleModel + ", " +
				"spotRate=" + this.spotRate + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}
}
