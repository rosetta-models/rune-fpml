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
import fpml.confirmation.FxExchangedCurrencyModel;
import fpml.confirmation.FxPayoffCap;
import fpml.confirmation.FxStrike;
import fpml.confirmation.FxTargetLeverage;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder;
import fpml.confirmation.FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilderImpl;
import fpml.confirmation.FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionImpl;
import fpml.confirmation.FxTargetPayoffRegion;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionBuilder;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionImpl;
import fpml.confirmation.FxTargetRegionLowerBound;
import fpml.confirmation.FxTargetRegionUpperBound;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.meta.FxTargetLinearPayoffRegionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A fixing region in which the payoff varies linearly with the fixing value.
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetLinearPayoffRegion", builder=FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilderImpl.class, version="${project.version}")
public interface FxTargetLinearPayoffRegion extends FxTargetPayoffRegion {

	FxTargetLinearPayoffRegionMeta metaData = new FxTargetLinearPayoffRegionMeta();

	/*********************** Getter Methods  ***********************/
	FxExchangedCurrencyModel getFxExchangedCurrencyModel();
	/**
	 * Strike price of the Target.
	 */
	FxStrike getStrike();
	/**
	 * The opposite currency amount of the Target.
	 */
	NonNegativeAmountSchedule getCounterCurrencyAmount();
	/**
	 * Defines the lower bound of a payoff region.
	 */
	FxTargetRegionLowerBound getLowerBound();
	/**
	 * Defines the upper bound of a payoff region.
	 */
	FxTargetRegionUpperBound getUpperBound();
	/**
	 * Notional leverage.
	 */
	FxTargetLeverage getLeverage();
	/**
	 * The amount of gain on the client upside or firm upside is limited. If spot settles above the cap, or below the floor, the payout is adjusted to limit the gain. The adjustment may be made by varying the strike, or by maintaining the strike, but varying the payout notionals.
	 */
	List<? extends FxPayoffCap> getPayoffCap();

	/*********************** Build Methods  ***********************/
	FxTargetLinearPayoffRegion build();
	
	FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder toBuilder();
	
	static FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder builder() {
		return new FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetLinearPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetLinearPayoffRegion> getType() {
		return FxTargetLinearPayoffRegion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fxExchangedCurrencyModel"), processor, FxExchangedCurrencyModel.class, getFxExchangedCurrencyModel());
		processRosetta(path.newSubPath("strike"), processor, FxStrike.class, getStrike());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.class, getCounterCurrencyAmount());
		processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.class, getLowerBound());
		processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.class, getUpperBound());
		processRosetta(path.newSubPath("leverage"), processor, FxTargetLeverage.class, getLeverage());
		processRosetta(path.newSubPath("payoffCap"), processor, FxPayoffCap.class, getPayoffCap());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetLinearPayoffRegionBuilder extends FxTargetLinearPayoffRegion, FxTargetPayoffRegion.FxTargetPayoffRegionBuilder {
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getOrCreateFxExchangedCurrencyModel();
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getFxExchangedCurrencyModel();
		FxStrike.FxStrikeBuilder getOrCreateStrike();
		FxStrike.FxStrikeBuilder getStrike();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount();
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getOrCreateLowerBound();
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getLowerBound();
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound();
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound();
		FxTargetLeverage.FxTargetLeverageBuilder getOrCreateLeverage();
		FxTargetLeverage.FxTargetLeverageBuilder getLeverage();
		FxPayoffCap.FxPayoffCapBuilder getOrCreatePayoffCap(int _index);
		List<? extends FxPayoffCap.FxPayoffCapBuilder> getPayoffCap();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setId(String id);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setFxExchangedCurrencyModel(FxExchangedCurrencyModel fxExchangedCurrencyModel);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setStrike(FxStrike strike);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setLowerBound(FxTargetRegionLowerBound lowerBound);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setUpperBound(FxTargetRegionUpperBound upperBound);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setLeverage(FxTargetLeverage leverage);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap0);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap1, int _idx);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder addPayoffCap(List<? extends FxPayoffCap> payoffCap2);
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setPayoffCap(List<? extends FxPayoffCap> payoffCap3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fxExchangedCurrencyModel"), processor, FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder.class, getFxExchangedCurrencyModel());
			processRosetta(path.newSubPath("strike"), processor, FxStrike.FxStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getCounterCurrencyAmount());
			processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder.class, getLowerBound());
			processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder.class, getUpperBound());
			processRosetta(path.newSubPath("leverage"), processor, FxTargetLeverage.FxTargetLeverageBuilder.class, getLeverage());
			processRosetta(path.newSubPath("payoffCap"), processor, FxPayoffCap.FxPayoffCapBuilder.class, getPayoffCap());
		}
		

		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetLinearPayoffRegion  ***********************/
	class FxTargetLinearPayoffRegionImpl extends FxTargetPayoffRegion.FxTargetPayoffRegionImpl implements FxTargetLinearPayoffRegion {
		private final FxExchangedCurrencyModel fxExchangedCurrencyModel;
		private final FxStrike strike;
		private final NonNegativeAmountSchedule counterCurrencyAmount;
		private final FxTargetRegionLowerBound lowerBound;
		private final FxTargetRegionUpperBound upperBound;
		private final FxTargetLeverage leverage;
		private final List<? extends FxPayoffCap> payoffCap;
		
		protected FxTargetLinearPayoffRegionImpl(FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder builder) {
			super(builder);
			this.fxExchangedCurrencyModel = ofNullable(builder.getFxExchangedCurrencyModel()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
			this.leverage = ofNullable(builder.getLeverage()).map(f->f.build()).orElse(null);
			this.payoffCap = ofNullable(builder.getPayoffCap()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxExchangedCurrencyModel getFxExchangedCurrencyModel() {
			return fxExchangedCurrencyModel;
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		public FxTargetRegionLowerBound getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("leverage")
		public FxTargetLeverage getLeverage() {
			return leverage;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		public List<? extends FxPayoffCap> getPayoffCap() {
			return payoffCap;
		}
		
		@Override
		public FxTargetLinearPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder toBuilder() {
			FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFxExchangedCurrencyModel()).ifPresent(builder::setFxExchangedCurrencyModel);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLeverage()).ifPresent(builder::setLeverage);
			ofNullable(getPayoffCap()).ifPresent(builder::setPayoffCap);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetLinearPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxExchangedCurrencyModel, _that.getFxExchangedCurrencyModel())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!ListEquals.listEquals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxExchangedCurrencyModel != null ? fxExchangedCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetLinearPayoffRegion {" +
				"fxExchangedCurrencyModel=" + this.fxExchangedCurrencyModel + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetLinearPayoffRegion  ***********************/
	class FxTargetLinearPayoffRegionBuilderImpl extends FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl  implements FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder {
	
		protected FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder fxExchangedCurrencyModel;
		protected FxStrike.FxStrikeBuilder strike;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder counterCurrencyAmount;
		protected FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder lowerBound;
		protected FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder upperBound;
		protected FxTargetLeverage.FxTargetLeverageBuilder leverage;
		protected List<FxPayoffCap.FxPayoffCapBuilder> payoffCap = new ArrayList<>();
	
		public FxTargetLinearPayoffRegionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getFxExchangedCurrencyModel() {
			return fxExchangedCurrencyModel;
		}
		
		@Override
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getOrCreateFxExchangedCurrencyModel() {
			FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder result;
			if (fxExchangedCurrencyModel!=null) {
				result = fxExchangedCurrencyModel;
			}
			else {
				result = fxExchangedCurrencyModel = FxExchangedCurrencyModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxStrike.FxStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder getOrCreateStrike() {
			FxStrike.FxStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (counterCurrencyAmount!=null) {
				result = counterCurrencyAmount;
			}
			else {
				result = counterCurrencyAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getLowerBound() {
			return lowerBound;
		}
		
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getOrCreateLowerBound() {
			FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder result;
			if (lowerBound!=null) {
				result = lowerBound;
			}
			else {
				result = lowerBound = FxTargetRegionLowerBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound() {
			FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = FxTargetRegionUpperBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("leverage")
		public FxTargetLeverage.FxTargetLeverageBuilder getLeverage() {
			return leverage;
		}
		
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder getOrCreateLeverage() {
			FxTargetLeverage.FxTargetLeverageBuilder result;
			if (leverage!=null) {
				result = leverage;
			}
			else {
				result = leverage = FxTargetLeverage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		public List<? extends FxPayoffCap.FxPayoffCapBuilder> getPayoffCap() {
			return payoffCap;
		}
		
		public FxPayoffCap.FxPayoffCapBuilder getOrCreatePayoffCap(int _index) {
		
			if (payoffCap==null) {
				this.payoffCap = new ArrayList<>();
			}
			FxPayoffCap.FxPayoffCapBuilder result;
			return getIndex(payoffCap, _index, () -> {
						FxPayoffCap.FxPayoffCapBuilder newPayoffCap = FxPayoffCap.builder();
						return newPayoffCap;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setFxExchangedCurrencyModel(FxExchangedCurrencyModel fxExchangedCurrencyModel) {
			this.fxExchangedCurrencyModel = fxExchangedCurrencyModel==null?null:fxExchangedCurrencyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setStrike(FxStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount) {
			this.counterCurrencyAmount = counterCurrencyAmount==null?null:counterCurrencyAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lowerBound")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setLowerBound(FxTargetRegionLowerBound lowerBound) {
			this.lowerBound = lowerBound==null?null:lowerBound.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setUpperBound(FxTargetRegionUpperBound upperBound) {
			this.upperBound = upperBound==null?null:upperBound.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("leverage")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setLeverage(FxTargetLeverage leverage) {
			this.leverage = leverage==null?null:leverage.toBuilder();
			return this;
		}
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap) {
			if (payoffCap!=null) this.payoffCap.add(payoffCap.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap, int _idx) {
			getIndex(this.payoffCap, _idx, () -> payoffCap.toBuilder());
			return this;
		}
		@Override 
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder addPayoffCap(List<? extends FxPayoffCap> payoffCaps) {
			if (payoffCaps != null) {
				for (FxPayoffCap toAdd : payoffCaps) {
					this.payoffCap.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("payoffCap")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder setPayoffCap(List<? extends FxPayoffCap> payoffCaps) {
			if (payoffCaps == null)  {
				this.payoffCap = new ArrayList<>();
			}
			else {
				this.payoffCap = payoffCaps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxTargetLinearPayoffRegion build() {
			return new FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionImpl(this);
		}
		
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder prune() {
			super.prune();
			if (fxExchangedCurrencyModel!=null && !fxExchangedCurrencyModel.prune().hasData()) fxExchangedCurrencyModel = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (counterCurrencyAmount!=null && !counterCurrencyAmount.prune().hasData()) counterCurrencyAmount = null;
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			if (leverage!=null && !leverage.prune().hasData()) leverage = null;
			payoffCap = payoffCap.stream().filter(b->b!=null).<FxPayoffCap.FxPayoffCapBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFxExchangedCurrencyModel()!=null && getFxExchangedCurrencyModel().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().hasData()) return true;
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			if (getLeverage()!=null && getLeverage().hasData()) return true;
			if (getPayoffCap()!=null && getPayoffCap().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder o = (FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder) other;
			
			merger.mergeRosetta(getFxExchangedCurrencyModel(), o.getFxExchangedCurrencyModel(), this::setFxExchangedCurrencyModel);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeRosetta(getLeverage(), o.getLeverage(), this::setLeverage);
			merger.mergeRosetta(getPayoffCap(), o.getPayoffCap(), this::getOrCreatePayoffCap);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetLinearPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxExchangedCurrencyModel, _that.getFxExchangedCurrencyModel())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!ListEquals.listEquals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxExchangedCurrencyModel != null ? fxExchangedCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetLinearPayoffRegionBuilder {" +
				"fxExchangedCurrencyModel=" + this.fxExchangedCurrencyModel + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}' + " " + super.toString();
		}
	}
}
