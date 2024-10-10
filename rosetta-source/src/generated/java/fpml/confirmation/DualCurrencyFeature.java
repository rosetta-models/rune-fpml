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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.Currency;
import fpml.confirmation.DualCurrencyFeature;
import fpml.confirmation.DualCurrencyFeature.DualCurrencyFeatureBuilder;
import fpml.confirmation.DualCurrencyFeature.DualCurrencyFeatureBuilderImpl;
import fpml.confirmation.DualCurrencyFeature.DualCurrencyFeatureImpl;
import fpml.confirmation.DualCurrencyStrikePrice;
import fpml.confirmation.meta.DualCurrencyFeatureMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the parameters for a dual currency option transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="DualCurrencyFeature", builder=DualCurrencyFeature.DualCurrencyFeatureBuilderImpl.class, version="${project.version}")
public interface DualCurrencyFeature extends RosettaModelObject {

	DualCurrencyFeatureMeta metaData = new DualCurrencyFeatureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Alternate currency i.e. the currency in which the deposit will be redeemed in the event that the spot rate fixes below the strike rate at the specified fixing date and time.
	 */
	Currency getCurrency();
	/**
	 * The date on which the fx spot rate is compared against the strike rate, in order to determine the delivery currency. This is the expiry date of a put option on the Deposit/Alternate currency couple. Also known as &quot;valuation date&quot; or &quot;reference date&quot;.
	 */
	Date getFixingDate();
	/**
	 * The time at which the fx spot rate observation is made i.e. the option cut off time on the expiry date. Also known as &quot;valuation time&quot;.
	 */
	BusinessCenterTime getFixingTime();
	/**
	 * The rate at which the deposit will be converted to the Alternate currency, in the event that the spot rate is strictly lower than the strike rate at the specified fixing date and time.
	 */
	DualCurrencyStrikePrice getStrike();
	/**
	 * The spot rate at the time the trade was agreed.
	 */
	BigDecimal getSpotRate();
	/**
	 * Specifies whether the interest component of the redemption amount is subject to conversion to the Alternate currency, in the event that the spot rate is strictly lower than the strike rate at the specified fixing date and time.
	 */
	Boolean getInterestAtRisk();

	/*********************** Build Methods  ***********************/
	DualCurrencyFeature build();
	
	DualCurrencyFeature.DualCurrencyFeatureBuilder toBuilder();
	
	static DualCurrencyFeature.DualCurrencyFeatureBuilder builder() {
		return new DualCurrencyFeature.DualCurrencyFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DualCurrencyFeature> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DualCurrencyFeature> getType() {
		return DualCurrencyFeature.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processRosetta(path.newSubPath("strike"), processor, DualCurrencyStrikePrice.class, getStrike());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processor.processBasic(path.newSubPath("interestAtRisk"), Boolean.class, getInterestAtRisk(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DualCurrencyFeatureBuilder extends DualCurrencyFeature, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getOrCreateStrike();
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getStrike();
		DualCurrencyFeature.DualCurrencyFeatureBuilder setCurrency(Currency currency);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingDate(Date fixingDate);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingTime(BusinessCenterTime fixingTime);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setStrike(DualCurrencyStrikePrice strike);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setSpotRate(BigDecimal spotRate);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setInterestAtRisk(Boolean interestAtRisk);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("strike"), processor, DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder.class, getStrike());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processor.processBasic(path.newSubPath("interestAtRisk"), Boolean.class, getInterestAtRisk(), this);
		}
		

		DualCurrencyFeature.DualCurrencyFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of DualCurrencyFeature  ***********************/
	class DualCurrencyFeatureImpl implements DualCurrencyFeature {
		private final Currency currency;
		private final Date fixingDate;
		private final BusinessCenterTime fixingTime;
		private final DualCurrencyStrikePrice strike;
		private final BigDecimal spotRate;
		private final Boolean interestAtRisk;
		
		protected DualCurrencyFeatureImpl(DualCurrencyFeature.DualCurrencyFeatureBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.fixingDate = builder.getFixingDate();
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.interestAtRisk = builder.getInterestAtRisk();
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("strike")
		public DualCurrencyStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("interestAtRisk")
		public Boolean getInterestAtRisk() {
			return interestAtRisk;
		}
		
		@Override
		public DualCurrencyFeature build() {
			return this;
		}
		
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder toBuilder() {
			DualCurrencyFeature.DualCurrencyFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DualCurrencyFeature.DualCurrencyFeatureBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getInterestAtRisk()).ifPresent(builder::setInterestAtRisk);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyFeature _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(interestAtRisk, _that.getInterestAtRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (interestAtRisk != null ? interestAtRisk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualCurrencyFeature {" +
				"currency=" + this.currency + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"interestAtRisk=" + this.interestAtRisk +
			'}';
		}
	}

	/*********************** Builder Implementation of DualCurrencyFeature  ***********************/
	class DualCurrencyFeatureBuilderImpl implements DualCurrencyFeature.DualCurrencyFeatureBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected Date fixingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder strike;
		protected BigDecimal spotRate;
		protected Boolean interestAtRisk;
	
		public DualCurrencyFeatureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getOrCreateStrike() {
			DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = DualCurrencyStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("interestAtRisk")
		public Boolean getInterestAtRisk() {
			return interestAtRisk;
		}
		
		@Override
		@RosettaAttribute("currency")
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingDate(Date fixingDate) {
			this.fixingDate = fixingDate==null?null:fixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("fixingTime")
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setStrike(DualCurrencyStrikePrice strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("interestAtRisk")
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setInterestAtRisk(Boolean interestAtRisk) {
			this.interestAtRisk = interestAtRisk==null?null:interestAtRisk;
			return this;
		}
		
		@Override
		public DualCurrencyFeature build() {
			return new DualCurrencyFeature.DualCurrencyFeatureImpl(this);
		}
		
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getInterestAtRisk()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DualCurrencyFeature.DualCurrencyFeatureBuilder o = (DualCurrencyFeature.DualCurrencyFeatureBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeBasic(getInterestAtRisk(), o.getInterestAtRisk(), this::setInterestAtRisk);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyFeature _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(interestAtRisk, _that.getInterestAtRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (interestAtRisk != null ? interestAtRisk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualCurrencyFeatureBuilder {" +
				"currency=" + this.currency + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"interestAtRisk=" + this.interestAtRisk +
			'}';
		}
	}
}
