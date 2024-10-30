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
import fpml.confirmation.Asset;
import fpml.confirmation.AverageDailyTradingVolumeLimit;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.SingleUnderlyer;
import fpml.confirmation.SingleUnderlyer.SingleUnderlyerBuilder;
import fpml.confirmation.SingleUnderlyer.SingleUnderlyerBuilderImpl;
import fpml.confirmation.SingleUnderlyer.SingleUnderlyerImpl;
import fpml.confirmation.meta.SingleUnderlyerMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing a single underlyer
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SingleUnderlyer", builder=SingleUnderlyer.SingleUnderlyerBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SingleUnderlyer extends RosettaModelObject {

	SingleUnderlyerMeta metaData = new SingleUnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	Asset getUnderlyingAsset();
	/**
	 * The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 */
	BigDecimal getOpenUnits();
	/**
	 * Specifies the dividend payout ratio associated with an equity underlyer. A basket swap can have different payout ratios across the various underlying constituents. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified. Users should note that FpML makes a distinction between the derivative contract and the underlyer of the contract. It would be better if the agreed dividend payout on a derivative contract was modelled at the level of the derivative contract, an approach which may be adopted in the next major version of FpML.
	 */
	DividendPayout getDividendPayout();
	/**
	 * The next upcoming coupon payment.
	 */
	PendingPayment getCouponPayment();
	/**
	 * The average amount of individual securities traded in a day or over a specified amount of time.
	 */
	AverageDailyTradingVolumeLimit getAverageDailyTradingVolume();
	/**
	 * A Depository Receipt is a negotiable certificate issued by a trust company or security depository. This element is used to represent whether a Depository Receipt is applicable or not to the underlyer.
	 */
	Boolean getDepositoryReceipt();

	/*********************** Build Methods  ***********************/
	SingleUnderlyer build();
	
	SingleUnderlyer.SingleUnderlyerBuilder toBuilder();
	
	static SingleUnderlyer.SingleUnderlyerBuilder builder() {
		return new SingleUnderlyer.SingleUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SingleUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SingleUnderlyer> getType() {
		return SingleUnderlyer.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
		processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.class, getDividendPayout());
		processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.class, getCouponPayment());
		processRosetta(path.newSubPath("averageDailyTradingVolume"), processor, AverageDailyTradingVolumeLimit.class, getAverageDailyTradingVolume());
		processor.processBasic(path.newSubPath("depositoryReceipt"), Boolean.class, getDepositoryReceipt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SingleUnderlyerBuilder extends SingleUnderlyer, RosettaModelObjectBuilder {
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		Asset.AssetBuilder getUnderlyingAsset();
		DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout();
		DividendPayout.DividendPayoutBuilder getDividendPayout();
		PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment();
		PendingPayment.PendingPaymentBuilder getCouponPayment();
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getOrCreateAverageDailyTradingVolume();
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getAverageDailyTradingVolume();
		SingleUnderlyer.SingleUnderlyerBuilder setUnderlyingAsset(Asset underlyingAsset);
		SingleUnderlyer.SingleUnderlyerBuilder setOpenUnits(BigDecimal openUnits);
		SingleUnderlyer.SingleUnderlyerBuilder setDividendPayout(DividendPayout dividendPayout);
		SingleUnderlyer.SingleUnderlyerBuilder setCouponPayment(PendingPayment couponPayment);
		SingleUnderlyer.SingleUnderlyerBuilder setAverageDailyTradingVolume(AverageDailyTradingVolumeLimit averageDailyTradingVolume);
		SingleUnderlyer.SingleUnderlyerBuilder setDepositoryReceipt(Boolean depositoryReceipt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
			processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.DividendPayoutBuilder.class, getDividendPayout());
			processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.PendingPaymentBuilder.class, getCouponPayment());
			processRosetta(path.newSubPath("averageDailyTradingVolume"), processor, AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder.class, getAverageDailyTradingVolume());
			processor.processBasic(path.newSubPath("depositoryReceipt"), Boolean.class, getDepositoryReceipt(), this);
		}
		

		SingleUnderlyer.SingleUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of SingleUnderlyer  ***********************/
	class SingleUnderlyerImpl implements SingleUnderlyer {
		private final Asset underlyingAsset;
		private final BigDecimal openUnits;
		private final DividendPayout dividendPayout;
		private final PendingPayment couponPayment;
		private final AverageDailyTradingVolumeLimit averageDailyTradingVolume;
		private final Boolean depositoryReceipt;
		
		protected SingleUnderlyerImpl(SingleUnderlyer.SingleUnderlyerBuilder builder) {
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.openUnits = builder.getOpenUnits();
			this.dividendPayout = ofNullable(builder.getDividendPayout()).map(f->f.build()).orElse(null);
			this.couponPayment = ofNullable(builder.getCouponPayment()).map(f->f.build()).orElse(null);
			this.averageDailyTradingVolume = ofNullable(builder.getAverageDailyTradingVolume()).map(f->f.build()).orElse(null);
			this.depositoryReceipt = builder.getDepositoryReceipt();
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		public DividendPayout getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		public PendingPayment getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		@RosettaAttribute("averageDailyTradingVolume")
		public AverageDailyTradingVolumeLimit getAverageDailyTradingVolume() {
			return averageDailyTradingVolume;
		}
		
		@Override
		@RosettaAttribute("depositoryReceipt")
		public Boolean getDepositoryReceipt() {
			return depositoryReceipt;
		}
		
		@Override
		public SingleUnderlyer build() {
			return this;
		}
		
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder toBuilder() {
			SingleUnderlyer.SingleUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SingleUnderlyer.SingleUnderlyerBuilder builder) {
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getOpenUnits()).ifPresent(builder::setOpenUnits);
			ofNullable(getDividendPayout()).ifPresent(builder::setDividendPayout);
			ofNullable(getCouponPayment()).ifPresent(builder::setCouponPayment);
			ofNullable(getAverageDailyTradingVolume()).ifPresent(builder::setAverageDailyTradingVolume);
			ofNullable(getDepositoryReceipt()).ifPresent(builder::setDepositoryReceipt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			if (!Objects.equals(averageDailyTradingVolume, _that.getAverageDailyTradingVolume())) return false;
			if (!Objects.equals(depositoryReceipt, _that.getDepositoryReceipt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			_result = 31 * _result + (averageDailyTradingVolume != null ? averageDailyTradingVolume.hashCode() : 0);
			_result = 31 * _result + (depositoryReceipt != null ? depositoryReceipt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleUnderlyer {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"openUnits=" + this.openUnits + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"couponPayment=" + this.couponPayment + ", " +
				"averageDailyTradingVolume=" + this.averageDailyTradingVolume + ", " +
				"depositoryReceipt=" + this.depositoryReceipt +
			'}';
		}
	}

	/*********************** Builder Implementation of SingleUnderlyer  ***********************/
	class SingleUnderlyerBuilderImpl implements SingleUnderlyer.SingleUnderlyerBuilder {
	
		protected Asset.AssetBuilder underlyingAsset;
		protected BigDecimal openUnits;
		protected DividendPayout.DividendPayoutBuilder dividendPayout;
		protected PendingPayment.PendingPaymentBuilder couponPayment;
		protected AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder averageDailyTradingVolume;
		protected Boolean depositoryReceipt;
	
		public SingleUnderlyerBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		public DividendPayout.DividendPayoutBuilder getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout() {
			DividendPayout.DividendPayoutBuilder result;
			if (dividendPayout!=null) {
				result = dividendPayout;
			}
			else {
				result = dividendPayout = DividendPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		public PendingPayment.PendingPaymentBuilder getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment() {
			PendingPayment.PendingPaymentBuilder result;
			if (couponPayment!=null) {
				result = couponPayment;
			}
			else {
				result = couponPayment = PendingPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageDailyTradingVolume")
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getAverageDailyTradingVolume() {
			return averageDailyTradingVolume;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getOrCreateAverageDailyTradingVolume() {
			AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder result;
			if (averageDailyTradingVolume!=null) {
				result = averageDailyTradingVolume;
			}
			else {
				result = averageDailyTradingVolume = AverageDailyTradingVolumeLimit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("depositoryReceipt")
		public Boolean getDepositoryReceipt() {
			return depositoryReceipt;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public SingleUnderlyer.SingleUnderlyerBuilder setUnderlyingAsset(Asset underlyingAsset) {
			this.underlyingAsset = underlyingAsset==null?null:underlyingAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("openUnits")
		public SingleUnderlyer.SingleUnderlyerBuilder setOpenUnits(BigDecimal openUnits) {
			this.openUnits = openUnits==null?null:openUnits;
			return this;
		}
		@Override
		@RosettaAttribute("dividendPayout")
		public SingleUnderlyer.SingleUnderlyerBuilder setDividendPayout(DividendPayout dividendPayout) {
			this.dividendPayout = dividendPayout==null?null:dividendPayout.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("couponPayment")
		public SingleUnderlyer.SingleUnderlyerBuilder setCouponPayment(PendingPayment couponPayment) {
			this.couponPayment = couponPayment==null?null:couponPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averageDailyTradingVolume")
		public SingleUnderlyer.SingleUnderlyerBuilder setAverageDailyTradingVolume(AverageDailyTradingVolumeLimit averageDailyTradingVolume) {
			this.averageDailyTradingVolume = averageDailyTradingVolume==null?null:averageDailyTradingVolume.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("depositoryReceipt")
		public SingleUnderlyer.SingleUnderlyerBuilder setDepositoryReceipt(Boolean depositoryReceipt) {
			this.depositoryReceipt = depositoryReceipt==null?null:depositoryReceipt;
			return this;
		}
		
		@Override
		public SingleUnderlyer build() {
			return new SingleUnderlyer.SingleUnderlyerImpl(this);
		}
		
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder prune() {
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (dividendPayout!=null && !dividendPayout.prune().hasData()) dividendPayout = null;
			if (couponPayment!=null && !couponPayment.prune().hasData()) couponPayment = null;
			if (averageDailyTradingVolume!=null && !averageDailyTradingVolume.prune().hasData()) averageDailyTradingVolume = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getOpenUnits()!=null) return true;
			if (getDividendPayout()!=null && getDividendPayout().hasData()) return true;
			if (getCouponPayment()!=null && getCouponPayment().hasData()) return true;
			if (getAverageDailyTradingVolume()!=null && getAverageDailyTradingVolume().hasData()) return true;
			if (getDepositoryReceipt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SingleUnderlyer.SingleUnderlyerBuilder o = (SingleUnderlyer.SingleUnderlyerBuilder) other;
			
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getDividendPayout(), o.getDividendPayout(), this::setDividendPayout);
			merger.mergeRosetta(getCouponPayment(), o.getCouponPayment(), this::setCouponPayment);
			merger.mergeRosetta(getAverageDailyTradingVolume(), o.getAverageDailyTradingVolume(), this::setAverageDailyTradingVolume);
			
			merger.mergeBasic(getOpenUnits(), o.getOpenUnits(), this::setOpenUnits);
			merger.mergeBasic(getDepositoryReceipt(), o.getDepositoryReceipt(), this::setDepositoryReceipt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			if (!Objects.equals(averageDailyTradingVolume, _that.getAverageDailyTradingVolume())) return false;
			if (!Objects.equals(depositoryReceipt, _that.getDepositoryReceipt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			_result = 31 * _result + (averageDailyTradingVolume != null ? averageDailyTradingVolume.hashCode() : 0);
			_result = 31 * _result + (depositoryReceipt != null ? depositoryReceipt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleUnderlyerBuilder {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"openUnits=" + this.openUnits + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"couponPayment=" + this.couponPayment + ", " +
				"averageDailyTradingVolume=" + this.averageDailyTradingVolume + ", " +
				"depositoryReceipt=" + this.depositoryReceipt +
			'}';
		}
	}
}
