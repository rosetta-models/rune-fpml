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
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxExpirySchedule;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxSettlementSchedule;
import fpml.confirmation.FxTarget;
import fpml.confirmation.FxTargetBarrier;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetKnockoutForward;
import fpml.confirmation.FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder;
import fpml.confirmation.FxTargetKnockoutForward.FxTargetKnockoutForwardBuilderImpl;
import fpml.confirmation.FxTargetKnockoutForward.FxTargetKnockoutForwardImpl;
import fpml.confirmation.FxTargetKnockoutForwardChoice;
import fpml.confirmation.FxTargetKnockoutForwardSequence;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.FxTargetSettlementPeriodSchedule;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.meta.FxTargetKnockoutForwardMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structured forward product which consists of a strip of forwards. Each forward may be settled as an exchange of currencies or cash settled. At each settlement, the amount of gain that one party achieves is measured. The product has a target level of gain. Once the accumulated gain exceeds the target level, the product terminates and there are no further settlements. A structured forward product which consists of a strip of forwards. Each forward may be settled as an exchange of currencies or cash settled. At each settlement, the amount of gain that one party achieves is measured. The product has a target level of gain. Once the accumulated gain exceeds the target level, the product terminates and there are no further settlements.
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetKnockoutForward", builder=FxTargetKnockoutForward.FxTargetKnockoutForwardBuilderImpl.class, version="${project.version}")
public interface FxTargetKnockoutForward extends Product {

	FxTargetKnockoutForwardMeta metaData = new FxTargetKnockoutForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Quoted Currency Pair that is used accross the product.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * Notional amount of the Target.
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 * It defines the target level of gain. Once the accumulated gain exceeds the target level, the product terminates and there are no further settlements.
	 */
	List<? extends FxTarget> getTarget();
	/**
	 * Defines the expiry/observation schedule of the target product.
	 */
	FxExpirySchedule getExpirySchedule();
	/**
	 * Defines the settlement/payment schedule of the target product.
	 */
	FxSettlementSchedule getSettlementSchedule();
	/**
	 * Information source for fixing the exchange rate. It is the same for all fixing periods.
	 */
	FxInformationSource getFixingInformationSource();
	/**
	 * Spot rate
	 */
	BigDecimal getSpotRate();
	FxTargetKnockoutForwardSequence getFxTargetKnockoutForwardSequence();
	/**
	 * It defines a region in which a digital payment occurs.
	 */
	List<? extends FxTargetConstantPayoffRegion> getConstantPayoffRegion();
	/**
	 * A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 */
	FxTargetLinearPayoffRegion getLinearPayoffRegion();
	List<? extends FxTargetKnockoutForwardChoice> getFxTargetKnockoutForwardChoice();
	/**
	 * Generic FxTarget barrier. Element &quot;scope&quot; specifies whether the barrier has effect for the expiry period in which it is observed, or globally for whole product. Optional element &quot;rebate&quot; may be produced in conjunction with a Global Knockout barrier, to specify a rebate payable in the event of knockout.
	 */
	List<? extends FxTargetBarrier> getBarrier();
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
	FxTargetSettlementPeriodSchedule getSettlementPeriodSchedule();

	/*********************** Build Methods  ***********************/
	FxTargetKnockoutForward build();
	
	FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder toBuilder();
	
	static FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder() {
		return new FxTargetKnockoutForward.FxTargetKnockoutForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetKnockoutForward> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetKnockoutForward> getType() {
		return FxTargetKnockoutForward.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("target"), processor, FxTarget.class, getTarget());
		processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.class, getExpirySchedule());
		processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.class, getSettlementSchedule());
		processRosetta(path.newSubPath("fixingInformationSource"), processor, FxInformationSource.class, getFixingInformationSource());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("fxTargetKnockoutForwardSequence"), processor, FxTargetKnockoutForwardSequence.class, getFxTargetKnockoutForwardSequence());
		processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.class, getConstantPayoffRegion());
		processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.class, getLinearPayoffRegion());
		processRosetta(path.newSubPath("fxTargetKnockoutForwardChoice"), processor, FxTargetKnockoutForwardChoice.class, getFxTargetKnockoutForwardChoice());
		processRosetta(path.newSubPath("barrier"), processor, FxTargetBarrier.class, getBarrier());
		processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
		processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxTargetSettlementPeriodSchedule.class, getSettlementPeriodSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetKnockoutForwardBuilder extends FxTargetKnockoutForward, Product.ProductBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxTarget.FxTargetBuilder getOrCreateTarget(int _index);
		List<? extends FxTarget.FxTargetBuilder> getTarget();
		FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule();
		FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule();
		FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule();
		FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule();
		FxInformationSource.FxInformationSourceBuilder getOrCreateFixingInformationSource();
		FxInformationSource.FxInformationSourceBuilder getFixingInformationSource();
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder getOrCreateFxTargetKnockoutForwardSequence();
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder getFxTargetKnockoutForwardSequence();
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion(int _index);
		List<? extends FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> getConstantPayoffRegion();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion();
		FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder getOrCreateFxTargetKnockoutForwardChoice(int _index);
		List<? extends FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder> getFxTargetKnockoutForwardChoice();
		FxTargetBarrier.FxTargetBarrierBuilder getOrCreateBarrier(int _index);
		List<? extends FxTargetBarrier.FxTargetBarrierBuilder> getBarrier();
		SimplePayment.SimplePaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends SimplePayment.SimplePaymentBuilder> getAdditionalPayment();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule();
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getSettlementPeriodSchedule();
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setProductModel(ProductModel productModel);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setId(String id);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget target0);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget target1, int _idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(List<? extends FxTarget> target2);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setTarget(List<? extends FxTarget> target3);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setExpirySchedule(FxExpirySchedule expirySchedule);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFixingInformationSource(FxInformationSource fixingInformationSource);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSpotRate(BigDecimal spotRate);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFxTargetKnockoutForwardSequence(FxTargetKnockoutForwardSequence fxTargetKnockoutForwardSequence);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion0);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion1, int _idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion2);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion3);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion linearPayoffRegion);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice0);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice1, int _idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoice2);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoice3);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier barrier0);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier barrier1, int _idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(List<? extends FxTargetBarrier> barrier2);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setBarrier(List<? extends FxTargetBarrier> barrier3);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment additionalPayment0);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment additionalPayment1, int _idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayment2);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayment3);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementPeriodSchedule(FxTargetSettlementPeriodSchedule settlementPeriodSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("target"), processor, FxTarget.FxTargetBuilder.class, getTarget());
			processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.FxExpiryScheduleBuilder.class, getExpirySchedule());
			processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.FxSettlementScheduleBuilder.class, getSettlementSchedule());
			processRosetta(path.newSubPath("fixingInformationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getFixingInformationSource());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("fxTargetKnockoutForwardSequence"), processor, FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder.class, getFxTargetKnockoutForwardSequence());
			processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder.class, getConstantPayoffRegion());
			processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder.class, getLinearPayoffRegion());
			processRosetta(path.newSubPath("fxTargetKnockoutForwardChoice"), processor, FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder.class, getFxTargetKnockoutForwardChoice());
			processRosetta(path.newSubPath("barrier"), processor, FxTargetBarrier.FxTargetBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.SimplePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder.class, getSettlementPeriodSchedule());
		}
		

		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetKnockoutForward  ***********************/
	class FxTargetKnockoutForwardImpl extends Product.ProductImpl implements FxTargetKnockoutForward {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final NonNegativeAmountSchedule notionalAmount;
		private final List<? extends FxTarget> target;
		private final FxExpirySchedule expirySchedule;
		private final FxSettlementSchedule settlementSchedule;
		private final FxInformationSource fixingInformationSource;
		private final BigDecimal spotRate;
		private final FxTargetKnockoutForwardSequence fxTargetKnockoutForwardSequence;
		private final List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion;
		private final FxTargetLinearPayoffRegion linearPayoffRegion;
		private final List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoice;
		private final List<? extends FxTargetBarrier> barrier;
		private final List<? extends SimplePayment> additionalPayment;
		private final FxCashSettlementSimple cashSettlement;
		private final FxTargetSettlementPeriodSchedule settlementPeriodSchedule;
		
		protected FxTargetKnockoutForwardImpl(FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.target = ofNullable(builder.getTarget()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.expirySchedule = ofNullable(builder.getExpirySchedule()).map(f->f.build()).orElse(null);
			this.settlementSchedule = ofNullable(builder.getSettlementSchedule()).map(f->f.build()).orElse(null);
			this.fixingInformationSource = ofNullable(builder.getFixingInformationSource()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.fxTargetKnockoutForwardSequence = ofNullable(builder.getFxTargetKnockoutForwardSequence()).map(f->f.build()).orElse(null);
			this.constantPayoffRegion = ofNullable(builder.getConstantPayoffRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.linearPayoffRegion = ofNullable(builder.getLinearPayoffRegion()).map(f->f.build()).orElse(null);
			this.fxTargetKnockoutForwardChoice = ofNullable(builder.getFxTargetKnockoutForwardChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.settlementPeriodSchedule = ofNullable(builder.getSettlementPeriodSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("target")
		public List<? extends FxTarget> getTarget() {
			return target;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		public FxExpirySchedule getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		public FxSettlementSchedule getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxInformationSource getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardSequence")
		public FxTargetKnockoutForwardSequence getFxTargetKnockoutForwardSequence() {
			return fxTargetKnockoutForwardSequence;
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public List<? extends FxTargetConstantPayoffRegion> getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardChoice")
		public List<? extends FxTargetKnockoutForwardChoice> getFxTargetKnockoutForwardChoice() {
			return fxTargetKnockoutForwardChoice;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxTargetBarrier> getBarrier() {
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
		public FxTargetSettlementPeriodSchedule getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxTargetKnockoutForward build() {
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder toBuilder() {
			FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getTarget()).ifPresent(builder::setTarget);
			ofNullable(getExpirySchedule()).ifPresent(builder::setExpirySchedule);
			ofNullable(getSettlementSchedule()).ifPresent(builder::setSettlementSchedule);
			ofNullable(getFixingInformationSource()).ifPresent(builder::setFixingInformationSource);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getFxTargetKnockoutForwardSequence()).ifPresent(builder::setFxTargetKnockoutForwardSequence);
			ofNullable(getConstantPayoffRegion()).ifPresent(builder::setConstantPayoffRegion);
			ofNullable(getLinearPayoffRegion()).ifPresent(builder::setLinearPayoffRegion);
			ofNullable(getFxTargetKnockoutForwardChoice()).ifPresent(builder::setFxTargetKnockoutForwardChoice);
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
		
			FxTargetKnockoutForward _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(target, _that.getTarget())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxTargetKnockoutForwardSequence, _that.getFxTargetKnockoutForwardSequence())) return false;
			if (!ListEquals.listEquals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!ListEquals.listEquals(fxTargetKnockoutForwardChoice, _that.getFxTargetKnockoutForwardChoice())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxTargetKnockoutForwardSequence != null ? fxTargetKnockoutForwardSequence.hashCode() : 0);
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (fxTargetKnockoutForwardChoice != null ? fxTargetKnockoutForwardChoice.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForward {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"target=" + this.target + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxTargetKnockoutForwardSequence=" + this.fxTargetKnockoutForwardSequence + ", " +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"fxTargetKnockoutForwardChoice=" + this.fxTargetKnockoutForwardChoice + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetKnockoutForward  ***********************/
	class FxTargetKnockoutForwardBuilderImpl extends Product.ProductBuilderImpl  implements FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected List<FxTarget.FxTargetBuilder> target = new ArrayList<>();
		protected FxExpirySchedule.FxExpiryScheduleBuilder expirySchedule;
		protected FxSettlementSchedule.FxSettlementScheduleBuilder settlementSchedule;
		protected FxInformationSource.FxInformationSourceBuilder fixingInformationSource;
		protected BigDecimal spotRate;
		protected FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder fxTargetKnockoutForwardSequence;
		protected List<FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> constantPayoffRegion = new ArrayList<>();
		protected FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder linearPayoffRegion;
		protected List<FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder> fxTargetKnockoutForwardChoice = new ArrayList<>();
		protected List<FxTargetBarrier.FxTargetBarrierBuilder> barrier = new ArrayList<>();
		protected List<SimplePayment.SimplePaymentBuilder> additionalPayment = new ArrayList<>();
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
		protected FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder settlementPeriodSchedule;
	
		public FxTargetKnockoutForwardBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
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
		@RosettaAttribute("target")
		public List<? extends FxTarget.FxTargetBuilder> getTarget() {
			return target;
		}
		
		@Override
		public FxTarget.FxTargetBuilder getOrCreateTarget(int _index) {
		
			if (target==null) {
				this.target = new ArrayList<>();
			}
			FxTarget.FxTargetBuilder result;
			return getIndex(target, _index, () -> {
						FxTarget.FxTargetBuilder newTarget = FxTarget.builder();
						return newTarget;
					});
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		public FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule() {
			FxExpirySchedule.FxExpiryScheduleBuilder result;
			if (expirySchedule!=null) {
				result = expirySchedule;
			}
			else {
				result = expirySchedule = FxExpirySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		public FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule() {
			FxSettlementSchedule.FxSettlementScheduleBuilder result;
			if (settlementSchedule!=null) {
				result = settlementSchedule;
			}
			else {
				result = settlementSchedule = FxSettlementSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxInformationSource.FxInformationSourceBuilder getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder getOrCreateFixingInformationSource() {
			FxInformationSource.FxInformationSourceBuilder result;
			if (fixingInformationSource!=null) {
				result = fixingInformationSource;
			}
			else {
				result = fixingInformationSource = FxInformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardSequence")
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder getFxTargetKnockoutForwardSequence() {
			return fxTargetKnockoutForwardSequence;
		}
		
		@Override
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder getOrCreateFxTargetKnockoutForwardSequence() {
			FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder result;
			if (fxTargetKnockoutForwardSequence!=null) {
				result = fxTargetKnockoutForwardSequence;
			}
			else {
				result = fxTargetKnockoutForwardSequence = FxTargetKnockoutForwardSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public List<? extends FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion(int _index) {
		
			if (constantPayoffRegion==null) {
				this.constantPayoffRegion = new ArrayList<>();
			}
			FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder result;
			return getIndex(constantPayoffRegion, _index, () -> {
						FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder newConstantPayoffRegion = FxTargetConstantPayoffRegion.builder();
						return newConstantPayoffRegion;
					});
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion() {
			FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder result;
			if (linearPayoffRegion!=null) {
				result = linearPayoffRegion;
			}
			else {
				result = linearPayoffRegion = FxTargetLinearPayoffRegion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardChoice")
		public List<? extends FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder> getFxTargetKnockoutForwardChoice() {
			return fxTargetKnockoutForwardChoice;
		}
		
		@Override
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder getOrCreateFxTargetKnockoutForwardChoice(int _index) {
		
			if (fxTargetKnockoutForwardChoice==null) {
				this.fxTargetKnockoutForwardChoice = new ArrayList<>();
			}
			FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder result;
			return getIndex(fxTargetKnockoutForwardChoice, _index, () -> {
						FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder newFxTargetKnockoutForwardChoice = FxTargetKnockoutForwardChoice.builder();
						return newFxTargetKnockoutForwardChoice;
					});
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxTargetBarrier.FxTargetBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder getOrCreateBarrier(int _index) {
		
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			FxTargetBarrier.FxTargetBarrierBuilder result;
			return getIndex(barrier, _index, () -> {
						FxTargetBarrier.FxTargetBarrierBuilder newBarrier = FxTargetBarrier.builder();
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
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule() {
			FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder result;
			if (settlementPeriodSchedule!=null) {
				result = settlementPeriodSchedule;
			}
			else {
				result = settlementPeriodSchedule = FxTargetSettlementPeriodSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("target")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget target) {
			if (target!=null) this.target.add(target.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget target, int _idx) {
			getIndex(this.target, _idx, () -> target.toBuilder());
			return this;
		}
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(List<? extends FxTarget> targets) {
			if (targets != null) {
				for (FxTarget toAdd : targets) {
					this.target.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setTarget(List<? extends FxTarget> targets) {
			if (targets == null)  {
				this.target = new ArrayList<>();
			}
			else {
				this.target = targets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setExpirySchedule(FxExpirySchedule expirySchedule) {
			this.expirySchedule = expirySchedule==null?null:expirySchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementSchedule")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule) {
			this.settlementSchedule = settlementSchedule==null?null:settlementSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFixingInformationSource(FxInformationSource fixingInformationSource) {
			this.fixingInformationSource = fixingInformationSource==null?null:fixingInformationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardSequence")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFxTargetKnockoutForwardSequence(FxTargetKnockoutForwardSequence fxTargetKnockoutForwardSequence) {
			this.fxTargetKnockoutForwardSequence = fxTargetKnockoutForwardSequence==null?null:fxTargetKnockoutForwardSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion) {
			if (constantPayoffRegion!=null) this.constantPayoffRegion.add(constantPayoffRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion, int _idx) {
			getIndex(this.constantPayoffRegion, _idx, () -> constantPayoffRegion.toBuilder());
			return this;
		}
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegions) {
			if (constantPayoffRegions != null) {
				for (FxTargetConstantPayoffRegion toAdd : constantPayoffRegions) {
					this.constantPayoffRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegions) {
			if (constantPayoffRegions == null)  {
				this.constantPayoffRegion = new ArrayList<>();
			}
			else {
				this.constantPayoffRegion = constantPayoffRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion linearPayoffRegion) {
			this.linearPayoffRegion = linearPayoffRegion==null?null:linearPayoffRegion.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardChoice")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice) {
			if (fxTargetKnockoutForwardChoice!=null) this.fxTargetKnockoutForwardChoice.add(fxTargetKnockoutForwardChoice.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice, int _idx) {
			getIndex(this.fxTargetKnockoutForwardChoice, _idx, () -> fxTargetKnockoutForwardChoice.toBuilder());
			return this;
		}
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoices) {
			if (fxTargetKnockoutForwardChoices != null) {
				for (FxTargetKnockoutForwardChoice toAdd : fxTargetKnockoutForwardChoices) {
					this.fxTargetKnockoutForwardChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoices) {
			if (fxTargetKnockoutForwardChoices == null)  {
				this.fxTargetKnockoutForwardChoice = new ArrayList<>();
			}
			else {
				this.fxTargetKnockoutForwardChoice = fxTargetKnockoutForwardChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(List<? extends FxTargetBarrier> barriers) {
			if (barriers != null) {
				for (FxTargetBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setBarrier(List<? extends FxTargetBarrier> barriers) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (SimplePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setCashSettlement(FxCashSettlementSimple cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementPeriodSchedule(FxTargetSettlementPeriodSchedule settlementPeriodSchedule) {
			this.settlementPeriodSchedule = settlementPeriodSchedule==null?null:settlementPeriodSchedule.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward build() {
			return new FxTargetKnockoutForward.FxTargetKnockoutForwardImpl(this);
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			target = target.stream().filter(b->b!=null).<FxTarget.FxTargetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (expirySchedule!=null && !expirySchedule.prune().hasData()) expirySchedule = null;
			if (settlementSchedule!=null && !settlementSchedule.prune().hasData()) settlementSchedule = null;
			if (fixingInformationSource!=null && !fixingInformationSource.prune().hasData()) fixingInformationSource = null;
			if (fxTargetKnockoutForwardSequence!=null && !fxTargetKnockoutForwardSequence.prune().hasData()) fxTargetKnockoutForwardSequence = null;
			constantPayoffRegion = constantPayoffRegion.stream().filter(b->b!=null).<FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (linearPayoffRegion!=null && !linearPayoffRegion.prune().hasData()) linearPayoffRegion = null;
			fxTargetKnockoutForwardChoice = fxTargetKnockoutForwardChoice.stream().filter(b->b!=null).<FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			barrier = barrier.stream().filter(b->b!=null).<FxTargetBarrier.FxTargetBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<SimplePayment.SimplePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (settlementPeriodSchedule!=null && !settlementPeriodSchedule.prune().hasData()) settlementPeriodSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getTarget()!=null && getTarget().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExpirySchedule()!=null && getExpirySchedule().hasData()) return true;
			if (getSettlementSchedule()!=null && getSettlementSchedule().hasData()) return true;
			if (getFixingInformationSource()!=null && getFixingInformationSource().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getFxTargetKnockoutForwardSequence()!=null && getFxTargetKnockoutForwardSequence().hasData()) return true;
			if (getConstantPayoffRegion()!=null && getConstantPayoffRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLinearPayoffRegion()!=null && getLinearPayoffRegion().hasData()) return true;
			if (getFxTargetKnockoutForwardChoice()!=null && getFxTargetKnockoutForwardChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getSettlementPeriodSchedule()!=null && getSettlementPeriodSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder o = (FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getTarget(), o.getTarget(), this::getOrCreateTarget);
			merger.mergeRosetta(getExpirySchedule(), o.getExpirySchedule(), this::setExpirySchedule);
			merger.mergeRosetta(getSettlementSchedule(), o.getSettlementSchedule(), this::setSettlementSchedule);
			merger.mergeRosetta(getFixingInformationSource(), o.getFixingInformationSource(), this::setFixingInformationSource);
			merger.mergeRosetta(getFxTargetKnockoutForwardSequence(), o.getFxTargetKnockoutForwardSequence(), this::setFxTargetKnockoutForwardSequence);
			merger.mergeRosetta(getConstantPayoffRegion(), o.getConstantPayoffRegion(), this::getOrCreateConstantPayoffRegion);
			merger.mergeRosetta(getLinearPayoffRegion(), o.getLinearPayoffRegion(), this::setLinearPayoffRegion);
			merger.mergeRosetta(getFxTargetKnockoutForwardChoice(), o.getFxTargetKnockoutForwardChoice(), this::getOrCreateFxTargetKnockoutForwardChoice);
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
		
			FxTargetKnockoutForward _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(target, _that.getTarget())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxTargetKnockoutForwardSequence, _that.getFxTargetKnockoutForwardSequence())) return false;
			if (!ListEquals.listEquals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!ListEquals.listEquals(fxTargetKnockoutForwardChoice, _that.getFxTargetKnockoutForwardChoice())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxTargetKnockoutForwardSequence != null ? fxTargetKnockoutForwardSequence.hashCode() : 0);
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (fxTargetKnockoutForwardChoice != null ? fxTargetKnockoutForwardChoice.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForwardBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"target=" + this.target + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxTargetKnockoutForwardSequence=" + this.fxTargetKnockoutForwardSequence + ", " +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"fxTargetKnockoutForwardChoice=" + this.fxTargetKnockoutForwardChoice + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}
}
