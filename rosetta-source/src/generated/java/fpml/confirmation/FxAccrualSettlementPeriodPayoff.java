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
import fpml.confirmation.FxAccrualPayoffRegionReference;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilderImpl;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffImpl;
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence;
import fpml.confirmation.SettlementPeriodFixingDates;
import fpml.confirmation.SettlementPeriodLeverage;
import fpml.confirmation.meta.FxAccrualSettlementPeriodPayoffMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Payoff region
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualSettlementPeriodPayoff", builder=FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilderImpl.class, version="${project.version}")
public interface FxAccrualSettlementPeriodPayoff extends RosettaModelObject {

	FxAccrualSettlementPeriodPayoffMeta metaData = new FxAccrualSettlementPeriodPayoffMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Optional reference to the Payoff Region in the parametric representation of the product.
	 */
	FxAccrualPayoffRegionReference getPayoffRegionReference();
	FxAccrualSettlementPeriodPayoffSequence getFxAccrualSettlementPeriodPayoffSequence();
	/**
	 * Average Strike Fixing Dates.
	 */
	SettlementPeriodFixingDates getAverageStrikeFixingDates();
	/**
	 * Average Rate Fixing Dates.
	 */
	SettlementPeriodFixingDates getAverageRateFixingDates();
	/**
	 * Lower bound to the region.
	 */
	BigDecimal getLowerBound();
	/**
	 * Upper bound to the region.
	 */
	BigDecimal getUpperBound();
	/**
	 * Leverage within the period expressed as either an amount or ratio.
	 */
	SettlementPeriodLeverage getLeverage();
	/**
	 * The amount of gain on the client upside or firm upside is limited. If spot settles above the cap, or below the floor, the payout is adjusted to limit the gain. The adjustment may be made by varying the strike, or by maintaining the strike, but varying the payout notionals.
	 */
	BigDecimal getPayoffCap();

	/*********************** Build Methods  ***********************/
	FxAccrualSettlementPeriodPayoff build();
	
	FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder toBuilder();
	
	static FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder() {
		return new FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualSettlementPeriodPayoff> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualSettlementPeriodPayoff> getType() {
		return FxAccrualSettlementPeriodPayoff.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payoffRegionReference"), processor, FxAccrualPayoffRegionReference.class, getPayoffRegionReference());
		processRosetta(path.newSubPath("fxAccrualSettlementPeriodPayoffSequence"), processor, FxAccrualSettlementPeriodPayoffSequence.class, getFxAccrualSettlementPeriodPayoffSequence());
		processRosetta(path.newSubPath("averageStrikeFixingDates"), processor, SettlementPeriodFixingDates.class, getAverageStrikeFixingDates());
		processRosetta(path.newSubPath("averageRateFixingDates"), processor, SettlementPeriodFixingDates.class, getAverageRateFixingDates());
		processor.processBasic(path.newSubPath("lowerBound"), BigDecimal.class, getLowerBound(), this);
		processor.processBasic(path.newSubPath("upperBound"), BigDecimal.class, getUpperBound(), this);
		processRosetta(path.newSubPath("leverage"), processor, SettlementPeriodLeverage.class, getLeverage());
		processor.processBasic(path.newSubPath("payoffCap"), BigDecimal.class, getPayoffCap(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualSettlementPeriodPayoffBuilder extends FxAccrualSettlementPeriodPayoff, RosettaModelObjectBuilder {
		FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getOrCreatePayoffRegionReference();
		FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getPayoffRegionReference();
		FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder getOrCreateFxAccrualSettlementPeriodPayoffSequence();
		FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder getFxAccrualSettlementPeriodPayoffSequence();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageStrikeFixingDates();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageStrikeFixingDates();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageRateFixingDates();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageRateFixingDates();
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getOrCreateLeverage();
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getLeverage();
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffRegionReference(FxAccrualPayoffRegionReference payoffRegionReference);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setFxAccrualSettlementPeriodPayoffSequence(FxAccrualSettlementPeriodPayoffSequence fxAccrualSettlementPeriodPayoffSequence);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageStrikeFixingDates(SettlementPeriodFixingDates averageStrikeFixingDates);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageRateFixingDates(SettlementPeriodFixingDates averageRateFixingDates);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLowerBound(BigDecimal lowerBound);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setUpperBound(BigDecimal upperBound);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLeverage(SettlementPeriodLeverage leverage);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffCap(BigDecimal payoffCap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payoffRegionReference"), processor, FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder.class, getPayoffRegionReference());
			processRosetta(path.newSubPath("fxAccrualSettlementPeriodPayoffSequence"), processor, FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder.class, getFxAccrualSettlementPeriodPayoffSequence());
			processRosetta(path.newSubPath("averageStrikeFixingDates"), processor, SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder.class, getAverageStrikeFixingDates());
			processRosetta(path.newSubPath("averageRateFixingDates"), processor, SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder.class, getAverageRateFixingDates());
			processor.processBasic(path.newSubPath("lowerBound"), BigDecimal.class, getLowerBound(), this);
			processor.processBasic(path.newSubPath("upperBound"), BigDecimal.class, getUpperBound(), this);
			processRosetta(path.newSubPath("leverage"), processor, SettlementPeriodLeverage.SettlementPeriodLeverageBuilder.class, getLeverage());
			processor.processBasic(path.newSubPath("payoffCap"), BigDecimal.class, getPayoffCap(), this);
		}
		

		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualSettlementPeriodPayoff  ***********************/
	class FxAccrualSettlementPeriodPayoffImpl implements FxAccrualSettlementPeriodPayoff {
		private final FxAccrualPayoffRegionReference payoffRegionReference;
		private final FxAccrualSettlementPeriodPayoffSequence fxAccrualSettlementPeriodPayoffSequence;
		private final SettlementPeriodFixingDates averageStrikeFixingDates;
		private final SettlementPeriodFixingDates averageRateFixingDates;
		private final BigDecimal lowerBound;
		private final BigDecimal upperBound;
		private final SettlementPeriodLeverage leverage;
		private final BigDecimal payoffCap;
		
		protected FxAccrualSettlementPeriodPayoffImpl(FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder) {
			this.payoffRegionReference = ofNullable(builder.getPayoffRegionReference()).map(f->f.build()).orElse(null);
			this.fxAccrualSettlementPeriodPayoffSequence = ofNullable(builder.getFxAccrualSettlementPeriodPayoffSequence()).map(f->f.build()).orElse(null);
			this.averageStrikeFixingDates = ofNullable(builder.getAverageStrikeFixingDates()).map(f->f.build()).orElse(null);
			this.averageRateFixingDates = ofNullable(builder.getAverageRateFixingDates()).map(f->f.build()).orElse(null);
			this.lowerBound = builder.getLowerBound();
			this.upperBound = builder.getUpperBound();
			this.leverage = ofNullable(builder.getLeverage()).map(f->f.build()).orElse(null);
			this.payoffCap = builder.getPayoffCap();
		}
		
		@Override
		@RosettaAttribute("payoffRegionReference")
		public FxAccrualPayoffRegionReference getPayoffRegionReference() {
			return payoffRegionReference;
		}
		
		@Override
		@RosettaAttribute("fxAccrualSettlementPeriodPayoffSequence")
		public FxAccrualSettlementPeriodPayoffSequence getFxAccrualSettlementPeriodPayoffSequence() {
			return fxAccrualSettlementPeriodPayoffSequence;
		}
		
		@Override
		@RosettaAttribute("averageStrikeFixingDates")
		public SettlementPeriodFixingDates getAverageStrikeFixingDates() {
			return averageStrikeFixingDates;
		}
		
		@Override
		@RosettaAttribute("averageRateFixingDates")
		public SettlementPeriodFixingDates getAverageRateFixingDates() {
			return averageRateFixingDates;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		public BigDecimal getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public BigDecimal getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("leverage")
		public SettlementPeriodLeverage getLeverage() {
			return leverage;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		public BigDecimal getPayoffCap() {
			return payoffCap;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff build() {
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder toBuilder() {
			FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder) {
			ofNullable(getPayoffRegionReference()).ifPresent(builder::setPayoffRegionReference);
			ofNullable(getFxAccrualSettlementPeriodPayoffSequence()).ifPresent(builder::setFxAccrualSettlementPeriodPayoffSequence);
			ofNullable(getAverageStrikeFixingDates()).ifPresent(builder::setAverageStrikeFixingDates);
			ofNullable(getAverageRateFixingDates()).ifPresent(builder::setAverageRateFixingDates);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLeverage()).ifPresent(builder::setLeverage);
			ofNullable(getPayoffCap()).ifPresent(builder::setPayoffCap);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payoffRegionReference, _that.getPayoffRegionReference())) return false;
			if (!Objects.equals(fxAccrualSettlementPeriodPayoffSequence, _that.getFxAccrualSettlementPeriodPayoffSequence())) return false;
			if (!Objects.equals(averageStrikeFixingDates, _that.getAverageStrikeFixingDates())) return false;
			if (!Objects.equals(averageRateFixingDates, _that.getAverageRateFixingDates())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!Objects.equals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payoffRegionReference != null ? payoffRegionReference.hashCode() : 0);
			_result = 31 * _result + (fxAccrualSettlementPeriodPayoffSequence != null ? fxAccrualSettlementPeriodPayoffSequence.hashCode() : 0);
			_result = 31 * _result + (averageStrikeFixingDates != null ? averageStrikeFixingDates.hashCode() : 0);
			_result = 31 * _result + (averageRateFixingDates != null ? averageRateFixingDates.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodPayoff {" +
				"payoffRegionReference=" + this.payoffRegionReference + ", " +
				"fxAccrualSettlementPeriodPayoffSequence=" + this.fxAccrualSettlementPeriodPayoffSequence + ", " +
				"averageStrikeFixingDates=" + this.averageStrikeFixingDates + ", " +
				"averageRateFixingDates=" + this.averageRateFixingDates + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualSettlementPeriodPayoff  ***********************/
	class FxAccrualSettlementPeriodPayoffBuilderImpl implements FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder {
	
		protected FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder payoffRegionReference;
		protected FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder fxAccrualSettlementPeriodPayoffSequence;
		protected SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder averageStrikeFixingDates;
		protected SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder averageRateFixingDates;
		protected BigDecimal lowerBound;
		protected BigDecimal upperBound;
		protected SettlementPeriodLeverage.SettlementPeriodLeverageBuilder leverage;
		protected BigDecimal payoffCap;
	
		public FxAccrualSettlementPeriodPayoffBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payoffRegionReference")
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getPayoffRegionReference() {
			return payoffRegionReference;
		}
		
		@Override
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getOrCreatePayoffRegionReference() {
			FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder result;
			if (payoffRegionReference!=null) {
				result = payoffRegionReference;
			}
			else {
				result = payoffRegionReference = FxAccrualPayoffRegionReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualSettlementPeriodPayoffSequence")
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder getFxAccrualSettlementPeriodPayoffSequence() {
			return fxAccrualSettlementPeriodPayoffSequence;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder getOrCreateFxAccrualSettlementPeriodPayoffSequence() {
			FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder result;
			if (fxAccrualSettlementPeriodPayoffSequence!=null) {
				result = fxAccrualSettlementPeriodPayoffSequence;
			}
			else {
				result = fxAccrualSettlementPeriodPayoffSequence = FxAccrualSettlementPeriodPayoffSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageStrikeFixingDates")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageStrikeFixingDates() {
			return averageStrikeFixingDates;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageStrikeFixingDates() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder result;
			if (averageStrikeFixingDates!=null) {
				result = averageStrikeFixingDates;
			}
			else {
				result = averageStrikeFixingDates = SettlementPeriodFixingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageRateFixingDates")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageRateFixingDates() {
			return averageRateFixingDates;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageRateFixingDates() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder result;
			if (averageRateFixingDates!=null) {
				result = averageRateFixingDates;
			}
			else {
				result = averageRateFixingDates = SettlementPeriodFixingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		public BigDecimal getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public BigDecimal getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("leverage")
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getLeverage() {
			return leverage;
		}
		
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getOrCreateLeverage() {
			SettlementPeriodLeverage.SettlementPeriodLeverageBuilder result;
			if (leverage!=null) {
				result = leverage;
			}
			else {
				result = leverage = SettlementPeriodLeverage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		public BigDecimal getPayoffCap() {
			return payoffCap;
		}
		
		@Override
		@RosettaAttribute("payoffRegionReference")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffRegionReference(FxAccrualPayoffRegionReference payoffRegionReference) {
			this.payoffRegionReference = payoffRegionReference==null?null:payoffRegionReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualSettlementPeriodPayoffSequence")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setFxAccrualSettlementPeriodPayoffSequence(FxAccrualSettlementPeriodPayoffSequence fxAccrualSettlementPeriodPayoffSequence) {
			this.fxAccrualSettlementPeriodPayoffSequence = fxAccrualSettlementPeriodPayoffSequence==null?null:fxAccrualSettlementPeriodPayoffSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averageStrikeFixingDates")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageStrikeFixingDates(SettlementPeriodFixingDates averageStrikeFixingDates) {
			this.averageStrikeFixingDates = averageStrikeFixingDates==null?null:averageStrikeFixingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averageRateFixingDates")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageRateFixingDates(SettlementPeriodFixingDates averageRateFixingDates) {
			this.averageRateFixingDates = averageRateFixingDates==null?null:averageRateFixingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lowerBound")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLowerBound(BigDecimal lowerBound) {
			this.lowerBound = lowerBound==null?null:lowerBound;
			return this;
		}
		@Override
		@RosettaAttribute("upperBound")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setUpperBound(BigDecimal upperBound) {
			this.upperBound = upperBound==null?null:upperBound;
			return this;
		}
		@Override
		@RosettaAttribute("leverage")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLeverage(SettlementPeriodLeverage leverage) {
			this.leverage = leverage==null?null:leverage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payoffCap")
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffCap(BigDecimal payoffCap) {
			this.payoffCap = payoffCap==null?null:payoffCap;
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff build() {
			return new FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffImpl(this);
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder prune() {
			if (payoffRegionReference!=null && !payoffRegionReference.prune().hasData()) payoffRegionReference = null;
			if (fxAccrualSettlementPeriodPayoffSequence!=null && !fxAccrualSettlementPeriodPayoffSequence.prune().hasData()) fxAccrualSettlementPeriodPayoffSequence = null;
			if (averageStrikeFixingDates!=null && !averageStrikeFixingDates.prune().hasData()) averageStrikeFixingDates = null;
			if (averageRateFixingDates!=null && !averageRateFixingDates.prune().hasData()) averageRateFixingDates = null;
			if (leverage!=null && !leverage.prune().hasData()) leverage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayoffRegionReference()!=null && getPayoffRegionReference().hasData()) return true;
			if (getFxAccrualSettlementPeriodPayoffSequence()!=null && getFxAccrualSettlementPeriodPayoffSequence().hasData()) return true;
			if (getAverageStrikeFixingDates()!=null && getAverageStrikeFixingDates().hasData()) return true;
			if (getAverageRateFixingDates()!=null && getAverageRateFixingDates().hasData()) return true;
			if (getLowerBound()!=null) return true;
			if (getUpperBound()!=null) return true;
			if (getLeverage()!=null && getLeverage().hasData()) return true;
			if (getPayoffCap()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder o = (FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder) other;
			
			merger.mergeRosetta(getPayoffRegionReference(), o.getPayoffRegionReference(), this::setPayoffRegionReference);
			merger.mergeRosetta(getFxAccrualSettlementPeriodPayoffSequence(), o.getFxAccrualSettlementPeriodPayoffSequence(), this::setFxAccrualSettlementPeriodPayoffSequence);
			merger.mergeRosetta(getAverageStrikeFixingDates(), o.getAverageStrikeFixingDates(), this::setAverageStrikeFixingDates);
			merger.mergeRosetta(getAverageRateFixingDates(), o.getAverageRateFixingDates(), this::setAverageRateFixingDates);
			merger.mergeRosetta(getLeverage(), o.getLeverage(), this::setLeverage);
			
			merger.mergeBasic(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeBasic(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeBasic(getPayoffCap(), o.getPayoffCap(), this::setPayoffCap);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payoffRegionReference, _that.getPayoffRegionReference())) return false;
			if (!Objects.equals(fxAccrualSettlementPeriodPayoffSequence, _that.getFxAccrualSettlementPeriodPayoffSequence())) return false;
			if (!Objects.equals(averageStrikeFixingDates, _that.getAverageStrikeFixingDates())) return false;
			if (!Objects.equals(averageRateFixingDates, _that.getAverageRateFixingDates())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!Objects.equals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payoffRegionReference != null ? payoffRegionReference.hashCode() : 0);
			_result = 31 * _result + (fxAccrualSettlementPeriodPayoffSequence != null ? fxAccrualSettlementPeriodPayoffSequence.hashCode() : 0);
			_result = 31 * _result + (averageStrikeFixingDates != null ? averageStrikeFixingDates.hashCode() : 0);
			_result = 31 * _result + (averageRateFixingDates != null ? averageRateFixingDates.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodPayoffBuilder {" +
				"payoffRegionReference=" + this.payoffRegionReference + ", " +
				"fxAccrualSettlementPeriodPayoffSequence=" + this.fxAccrualSettlementPeriodPayoffSequence + ", " +
				"averageStrikeFixingDates=" + this.averageStrikeFixingDates + ", " +
				"averageRateFixingDates=" + this.averageRateFixingDates + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}';
		}
	}
}
