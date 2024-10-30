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
import fpml.confirmation.AssetReference;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.DividendPeriod;
import fpml.confirmation.DividendPeriod.DividendPeriodBuilder;
import fpml.confirmation.DividendPeriod.DividendPeriodBuilderImpl;
import fpml.confirmation.DividendPeriod.DividendPeriodImpl;
import fpml.confirmation.DividendPeriodDividend;
import fpml.confirmation.DividendPeriodDividend.DividendPeriodDividendBuilder;
import fpml.confirmation.DividendPeriodDividend.DividendPeriodDividendBuilderImpl;
import fpml.confirmation.DividendPeriodDividend.DividendPeriodDividendImpl;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.DividendPeriodDividendMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A time bounded dividend period, with an expected dividend for each period.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DividendPeriodDividend", builder=DividendPeriodDividend.DividendPeriodDividendBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DividendPeriodDividend extends DividendPeriod {

	DividendPeriodDividendMeta metaData = new DividendPeriodDividendMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Expected dividend in this period.
	 */
	NonNegativeMoney getDividend();
	/**
	 * Multiplier is a percentage value which is used to produce Deviation by multiplying the difference between Expected Dividend and Actual Dividend Deviation = Multiplier * (Expected Dividend — Actual Dividend).
	 */
	BigDecimal getMultiplier();

	/*********************** Build Methods  ***********************/
	DividendPeriodDividend build();
	
	DividendPeriodDividend.DividendPeriodDividendBuilder toBuilder();
	
	static DividendPeriodDividend.DividendPeriodDividendBuilder builder() {
		return new DividendPeriodDividend.DividendPeriodDividendBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPeriodDividend> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendPeriodDividend> getType() {
		return DividendPeriodDividend.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.class, getUnadjustedStartDate());
		processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.class, getUnadjustedEndDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("dividend"), processor, NonNegativeMoney.class, getDividend());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPeriodDividendBuilder extends DividendPeriodDividend, DividendPeriod.DividendPeriodBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateDividend();
		NonNegativeMoney.NonNegativeMoneyBuilder getDividend();
		DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate);
		DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate);
		DividendPeriodDividend.DividendPeriodDividendBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		DividendPeriodDividend.DividendPeriodDividendBuilder setUnderlyerReference(AssetReference underlyerReference);
		DividendPeriodDividend.DividendPeriodDividendBuilder setId(String id);
		DividendPeriodDividend.DividendPeriodDividendBuilder setDividend(NonNegativeMoney dividend);
		DividendPeriodDividend.DividendPeriodDividendBuilder setMultiplier(BigDecimal multiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedStartDate());
			processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedEndDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("dividend"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getDividend());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		}
		

		DividendPeriodDividend.DividendPeriodDividendBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPeriodDividend  ***********************/
	class DividendPeriodDividendImpl extends DividendPeriod.DividendPeriodImpl implements DividendPeriodDividend {
		private final NonNegativeMoney dividend;
		private final BigDecimal multiplier;
		
		protected DividendPeriodDividendImpl(DividendPeriodDividend.DividendPeriodDividendBuilder builder) {
			super(builder);
			this.dividend = ofNullable(builder.getDividend()).map(f->f.build()).orElse(null);
			this.multiplier = builder.getMultiplier();
		}
		
		@Override
		@RosettaAttribute("dividend")
		public NonNegativeMoney getDividend() {
			return dividend;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public DividendPeriodDividend build() {
			return this;
		}
		
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder toBuilder() {
			DividendPeriodDividend.DividendPeriodDividendBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPeriodDividend.DividendPeriodDividendBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDividend()).ifPresent(builder::setDividend);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodDividend _that = getType().cast(o);
		
			if (!Objects.equals(dividend, _that.getDividend())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividend != null ? dividend.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodDividend {" +
				"dividend=" + this.dividend + ", " +
				"multiplier=" + this.multiplier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendPeriodDividend  ***********************/
	class DividendPeriodDividendBuilderImpl extends DividendPeriod.DividendPeriodBuilderImpl  implements DividendPeriodDividend.DividendPeriodDividendBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder dividend;
		protected BigDecimal multiplier;
	
		public DividendPeriodDividendBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividend")
		public NonNegativeMoney.NonNegativeMoneyBuilder getDividend() {
			return dividend;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateDividend() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (dividend!=null) {
				result = dividend;
			}
			else {
				result = dividend = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		public DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate) {
			this.unadjustedStartDate = unadjustedStartDate==null?null:unadjustedStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("unadjustedEndDate")
		public DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate) {
			this.unadjustedEndDate = unadjustedEndDate==null?null:unadjustedEndDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public DividendPeriodDividend.DividendPeriodDividendBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerReference")
		public DividendPeriodDividend.DividendPeriodDividendBuilder setUnderlyerReference(AssetReference underlyerReference) {
			this.underlyerReference = underlyerReference==null?null:underlyerReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DividendPeriodDividend.DividendPeriodDividendBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dividend")
		public DividendPeriodDividend.DividendPeriodDividendBuilder setDividend(NonNegativeMoney dividend) {
			this.dividend = dividend==null?null:dividend.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public DividendPeriodDividend.DividendPeriodDividendBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		
		@Override
		public DividendPeriodDividend build() {
			return new DividendPeriodDividend.DividendPeriodDividendImpl(this);
		}
		
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder prune() {
			super.prune();
			if (dividend!=null && !dividend.prune().hasData()) dividend = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDividend()!=null && getDividend().hasData()) return true;
			if (getMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DividendPeriodDividend.DividendPeriodDividendBuilder o = (DividendPeriodDividend.DividendPeriodDividendBuilder) other;
			
			merger.mergeRosetta(getDividend(), o.getDividend(), this::setDividend);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodDividend _that = getType().cast(o);
		
			if (!Objects.equals(dividend, _that.getDividend())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividend != null ? dividend.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodDividendBuilder {" +
				"dividend=" + this.dividend + ", " +
				"multiplier=" + this.multiplier +
			'}' + " " + super.toString();
		}
	}
}
