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
import fpml.confirmation.FxAccrualLeverage;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import fpml.confirmation.FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder;
import fpml.confirmation.FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilderImpl;
import fpml.confirmation.FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionImpl;
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence;
import fpml.confirmation.FxAccrualPayoffRegion;
import fpml.confirmation.FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder;
import fpml.confirmation.FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilderImpl;
import fpml.confirmation.FxAccrualPayoffRegion.FxAccrualPayoffRegionImpl;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxExchangedCurrencyModel;
import fpml.confirmation.FxPayoffCap;
import fpml.confirmation.meta.FxAccrualLinearPayoffRegionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A fixing region in which the payoff varies linearly with the fixing value.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualLinearPayoffRegion", builder=FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualLinearPayoffRegion extends FxAccrualPayoffRegion {

	FxAccrualLinearPayoffRegionMeta metaData = new FxAccrualLinearPayoffRegionMeta();

	/*********************** Getter Methods  ***********************/
	FxExchangedCurrencyModel getFxExchangedCurrencyModel();
	FxAccrualLinearPayoffRegionSequence getFxAccrualLinearPayoffRegionSequence();
	/**
	 * Average Strike Forward: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 */
	FxAverageStrike getAverageStrike();
	FxAccrualRegionBoundModel getFxAccrualRegionBoundModel();
	/**
	 * These structures define a leverage multiplier to the payoff amounts at settlement points.
	 */
	FxAccrualLeverage getLeverage();
	/**
	 * The amount of gain on the client upside or firm upside is limited. If spot settles above the cap, or below the floor, the payout is adjusted to limit the gain. The adjustment may be made by varying the strike, or by maintaining the strike, but varying the payout notionals.
	 */
	List<? extends FxPayoffCap> getPayoffCap();

	/*********************** Build Methods  ***********************/
	FxAccrualLinearPayoffRegion build();
	
	FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder toBuilder();
	
	static FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder() {
		return new FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualLinearPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualLinearPayoffRegion> getType() {
		return FxAccrualLinearPayoffRegion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fxExchangedCurrencyModel"), processor, FxExchangedCurrencyModel.class, getFxExchangedCurrencyModel());
		processRosetta(path.newSubPath("fxAccrualLinearPayoffRegionSequence"), processor, FxAccrualLinearPayoffRegionSequence.class, getFxAccrualLinearPayoffRegionSequence());
		processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.class, getAverageStrike());
		processRosetta(path.newSubPath("fxAccrualRegionBoundModel"), processor, FxAccrualRegionBoundModel.class, getFxAccrualRegionBoundModel());
		processRosetta(path.newSubPath("leverage"), processor, FxAccrualLeverage.class, getLeverage());
		processRosetta(path.newSubPath("payoffCap"), processor, FxPayoffCap.class, getPayoffCap());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualLinearPayoffRegionBuilder extends FxAccrualLinearPayoffRegion, FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder {
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getOrCreateFxExchangedCurrencyModel();
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getFxExchangedCurrencyModel();
		FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder getOrCreateFxAccrualLinearPayoffRegionSequence();
		FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder getFxAccrualLinearPayoffRegionSequence();
		FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike();
		FxAverageStrike.FxAverageStrikeBuilder getAverageStrike();
		FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getOrCreateFxAccrualRegionBoundModel();
		FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getFxAccrualRegionBoundModel();
		FxAccrualLeverage.FxAccrualLeverageBuilder getOrCreateLeverage();
		FxAccrualLeverage.FxAccrualLeverageBuilder getLeverage();
		FxPayoffCap.FxPayoffCapBuilder getOrCreatePayoffCap(int _index);
		List<? extends FxPayoffCap.FxPayoffCapBuilder> getPayoffCap();
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setId(String id);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setFxExchangedCurrencyModel(FxExchangedCurrencyModel fxExchangedCurrencyModel);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setFxAccrualLinearPayoffRegionSequence(FxAccrualLinearPayoffRegionSequence fxAccrualLinearPayoffRegionSequence);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setAverageStrike(FxAverageStrike averageStrike);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setFxAccrualRegionBoundModel(FxAccrualRegionBoundModel fxAccrualRegionBoundModel);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setLeverage(FxAccrualLeverage leverage);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap0);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap1, int _idx);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(List<? extends FxPayoffCap> payoffCap2);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setPayoffCap(List<? extends FxPayoffCap> payoffCap3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fxExchangedCurrencyModel"), processor, FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder.class, getFxExchangedCurrencyModel());
			processRosetta(path.newSubPath("fxAccrualLinearPayoffRegionSequence"), processor, FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder.class, getFxAccrualLinearPayoffRegionSequence());
			processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.FxAverageStrikeBuilder.class, getAverageStrike());
			processRosetta(path.newSubPath("fxAccrualRegionBoundModel"), processor, FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder.class, getFxAccrualRegionBoundModel());
			processRosetta(path.newSubPath("leverage"), processor, FxAccrualLeverage.FxAccrualLeverageBuilder.class, getLeverage());
			processRosetta(path.newSubPath("payoffCap"), processor, FxPayoffCap.FxPayoffCapBuilder.class, getPayoffCap());
		}
		

		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualLinearPayoffRegion  ***********************/
	class FxAccrualLinearPayoffRegionImpl extends FxAccrualPayoffRegion.FxAccrualPayoffRegionImpl implements FxAccrualLinearPayoffRegion {
		private final FxExchangedCurrencyModel fxExchangedCurrencyModel;
		private final FxAccrualLinearPayoffRegionSequence fxAccrualLinearPayoffRegionSequence;
		private final FxAverageStrike averageStrike;
		private final FxAccrualRegionBoundModel fxAccrualRegionBoundModel;
		private final FxAccrualLeverage leverage;
		private final List<? extends FxPayoffCap> payoffCap;
		
		protected FxAccrualLinearPayoffRegionImpl(FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder) {
			super(builder);
			this.fxExchangedCurrencyModel = ofNullable(builder.getFxExchangedCurrencyModel()).map(f->f.build()).orElse(null);
			this.fxAccrualLinearPayoffRegionSequence = ofNullable(builder.getFxAccrualLinearPayoffRegionSequence()).map(f->f.build()).orElse(null);
			this.averageStrike = ofNullable(builder.getAverageStrike()).map(f->f.build()).orElse(null);
			this.fxAccrualRegionBoundModel = ofNullable(builder.getFxAccrualRegionBoundModel()).map(f->f.build()).orElse(null);
			this.leverage = ofNullable(builder.getLeverage()).map(f->f.build()).orElse(null);
			this.payoffCap = ofNullable(builder.getPayoffCap()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxExchangedCurrencyModel getFxExchangedCurrencyModel() {
			return fxExchangedCurrencyModel;
		}
		
		@Override
		@RosettaAttribute("fxAccrualLinearPayoffRegionSequence")
		public FxAccrualLinearPayoffRegionSequence getFxAccrualLinearPayoffRegionSequence() {
			return fxAccrualLinearPayoffRegionSequence;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		public FxAverageStrike getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModel")
		public FxAccrualRegionBoundModel getFxAccrualRegionBoundModel() {
			return fxAccrualRegionBoundModel;
		}
		
		@Override
		@RosettaAttribute("leverage")
		public FxAccrualLeverage getLeverage() {
			return leverage;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		public List<? extends FxPayoffCap> getPayoffCap() {
			return payoffCap;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder toBuilder() {
			FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFxExchangedCurrencyModel()).ifPresent(builder::setFxExchangedCurrencyModel);
			ofNullable(getFxAccrualLinearPayoffRegionSequence()).ifPresent(builder::setFxAccrualLinearPayoffRegionSequence);
			ofNullable(getAverageStrike()).ifPresent(builder::setAverageStrike);
			ofNullable(getFxAccrualRegionBoundModel()).ifPresent(builder::setFxAccrualRegionBoundModel);
			ofNullable(getLeverage()).ifPresent(builder::setLeverage);
			ofNullable(getPayoffCap()).ifPresent(builder::setPayoffCap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualLinearPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxExchangedCurrencyModel, _that.getFxExchangedCurrencyModel())) return false;
			if (!Objects.equals(fxAccrualLinearPayoffRegionSequence, _that.getFxAccrualLinearPayoffRegionSequence())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(fxAccrualRegionBoundModel, _that.getFxAccrualRegionBoundModel())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!ListEquals.listEquals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxExchangedCurrencyModel != null ? fxExchangedCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (fxAccrualLinearPayoffRegionSequence != null ? fxAccrualLinearPayoffRegionSequence.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionBoundModel != null ? fxAccrualRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLinearPayoffRegion {" +
				"fxExchangedCurrencyModel=" + this.fxExchangedCurrencyModel + ", " +
				"fxAccrualLinearPayoffRegionSequence=" + this.fxAccrualLinearPayoffRegionSequence + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"fxAccrualRegionBoundModel=" + this.fxAccrualRegionBoundModel + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualLinearPayoffRegion  ***********************/
	class FxAccrualLinearPayoffRegionBuilderImpl extends FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilderImpl  implements FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder {
	
		protected FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder fxExchangedCurrencyModel;
		protected FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder fxAccrualLinearPayoffRegionSequence;
		protected FxAverageStrike.FxAverageStrikeBuilder averageStrike;
		protected FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder fxAccrualRegionBoundModel;
		protected FxAccrualLeverage.FxAccrualLeverageBuilder leverage;
		protected List<FxPayoffCap.FxPayoffCapBuilder> payoffCap = new ArrayList<>();
	
		public FxAccrualLinearPayoffRegionBuilderImpl() {
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
		@RosettaAttribute("fxAccrualLinearPayoffRegionSequence")
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder getFxAccrualLinearPayoffRegionSequence() {
			return fxAccrualLinearPayoffRegionSequence;
		}
		
		@Override
		public FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder getOrCreateFxAccrualLinearPayoffRegionSequence() {
			FxAccrualLinearPayoffRegionSequence.FxAccrualLinearPayoffRegionSequenceBuilder result;
			if (fxAccrualLinearPayoffRegionSequence!=null) {
				result = fxAccrualLinearPayoffRegionSequence;
			}
			else {
				result = fxAccrualLinearPayoffRegionSequence = FxAccrualLinearPayoffRegionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		public FxAverageStrike.FxAverageStrikeBuilder getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike() {
			FxAverageStrike.FxAverageStrikeBuilder result;
			if (averageStrike!=null) {
				result = averageStrike;
			}
			else {
				result = averageStrike = FxAverageStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModel")
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getFxAccrualRegionBoundModel() {
			return fxAccrualRegionBoundModel;
		}
		
		@Override
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder getOrCreateFxAccrualRegionBoundModel() {
			FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder result;
			if (fxAccrualRegionBoundModel!=null) {
				result = fxAccrualRegionBoundModel;
			}
			else {
				result = fxAccrualRegionBoundModel = FxAccrualRegionBoundModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("leverage")
		public FxAccrualLeverage.FxAccrualLeverageBuilder getLeverage() {
			return leverage;
		}
		
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder getOrCreateLeverage() {
			FxAccrualLeverage.FxAccrualLeverageBuilder result;
			if (leverage!=null) {
				result = leverage;
			}
			else {
				result = leverage = FxAccrualLeverage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		public List<? extends FxPayoffCap.FxPayoffCapBuilder> getPayoffCap() {
			return payoffCap;
		}
		
		@Override
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
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setFxExchangedCurrencyModel(FxExchangedCurrencyModel fxExchangedCurrencyModel) {
			this.fxExchangedCurrencyModel = fxExchangedCurrencyModel==null?null:fxExchangedCurrencyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualLinearPayoffRegionSequence")
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setFxAccrualLinearPayoffRegionSequence(FxAccrualLinearPayoffRegionSequence fxAccrualLinearPayoffRegionSequence) {
			this.fxAccrualLinearPayoffRegionSequence = fxAccrualLinearPayoffRegionSequence==null?null:fxAccrualLinearPayoffRegionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averageStrike")
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setAverageStrike(FxAverageStrike averageStrike) {
			this.averageStrike = averageStrike==null?null:averageStrike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModel")
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setFxAccrualRegionBoundModel(FxAccrualRegionBoundModel fxAccrualRegionBoundModel) {
			this.fxAccrualRegionBoundModel = fxAccrualRegionBoundModel==null?null:fxAccrualRegionBoundModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("leverage")
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setLeverage(FxAccrualLeverage leverage) {
			this.leverage = leverage==null?null:leverage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payoffCap")
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap) {
			if (payoffCap!=null) this.payoffCap.add(payoffCap.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap, int _idx) {
			getIndex(this.payoffCap, _idx, () -> payoffCap.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(List<? extends FxPayoffCap> payoffCaps) {
			if (payoffCaps != null) {
				for (FxPayoffCap toAdd : payoffCaps) {
					this.payoffCap.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setPayoffCap(List<? extends FxPayoffCap> payoffCaps) {
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
		public FxAccrualLinearPayoffRegion build() {
			return new FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionImpl(this);
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder prune() {
			super.prune();
			if (fxExchangedCurrencyModel!=null && !fxExchangedCurrencyModel.prune().hasData()) fxExchangedCurrencyModel = null;
			if (fxAccrualLinearPayoffRegionSequence!=null && !fxAccrualLinearPayoffRegionSequence.prune().hasData()) fxAccrualLinearPayoffRegionSequence = null;
			if (averageStrike!=null && !averageStrike.prune().hasData()) averageStrike = null;
			if (fxAccrualRegionBoundModel!=null && !fxAccrualRegionBoundModel.prune().hasData()) fxAccrualRegionBoundModel = null;
			if (leverage!=null && !leverage.prune().hasData()) leverage = null;
			payoffCap = payoffCap.stream().filter(b->b!=null).<FxPayoffCap.FxPayoffCapBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFxExchangedCurrencyModel()!=null && getFxExchangedCurrencyModel().hasData()) return true;
			if (getFxAccrualLinearPayoffRegionSequence()!=null && getFxAccrualLinearPayoffRegionSequence().hasData()) return true;
			if (getAverageStrike()!=null && getAverageStrike().hasData()) return true;
			if (getFxAccrualRegionBoundModel()!=null && getFxAccrualRegionBoundModel().hasData()) return true;
			if (getLeverage()!=null && getLeverage().hasData()) return true;
			if (getPayoffCap()!=null && getPayoffCap().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder o = (FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder) other;
			
			merger.mergeRosetta(getFxExchangedCurrencyModel(), o.getFxExchangedCurrencyModel(), this::setFxExchangedCurrencyModel);
			merger.mergeRosetta(getFxAccrualLinearPayoffRegionSequence(), o.getFxAccrualLinearPayoffRegionSequence(), this::setFxAccrualLinearPayoffRegionSequence);
			merger.mergeRosetta(getAverageStrike(), o.getAverageStrike(), this::setAverageStrike);
			merger.mergeRosetta(getFxAccrualRegionBoundModel(), o.getFxAccrualRegionBoundModel(), this::setFxAccrualRegionBoundModel);
			merger.mergeRosetta(getLeverage(), o.getLeverage(), this::setLeverage);
			merger.mergeRosetta(getPayoffCap(), o.getPayoffCap(), this::getOrCreatePayoffCap);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualLinearPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxExchangedCurrencyModel, _that.getFxExchangedCurrencyModel())) return false;
			if (!Objects.equals(fxAccrualLinearPayoffRegionSequence, _that.getFxAccrualLinearPayoffRegionSequence())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(fxAccrualRegionBoundModel, _that.getFxAccrualRegionBoundModel())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!ListEquals.listEquals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxExchangedCurrencyModel != null ? fxExchangedCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (fxAccrualLinearPayoffRegionSequence != null ? fxAccrualLinearPayoffRegionSequence.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionBoundModel != null ? fxAccrualRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLinearPayoffRegionBuilder {" +
				"fxExchangedCurrencyModel=" + this.fxExchangedCurrencyModel + ", " +
				"fxAccrualLinearPayoffRegionSequence=" + this.fxAccrualLinearPayoffRegionSequence + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"fxAccrualRegionBoundModel=" + this.fxAccrualRegionBoundModel + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}' + " " + super.toString();
		}
	}
}
