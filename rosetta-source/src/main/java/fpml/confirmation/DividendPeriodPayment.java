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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.DividendPeriod;
import fpml.confirmation.DividendPeriod.DividendPeriodBuilder;
import fpml.confirmation.DividendPeriod.DividendPeriodBuilderImpl;
import fpml.confirmation.DividendPeriod.DividendPeriodImpl;
import fpml.confirmation.DividendPeriodPayment;
import fpml.confirmation.DividendPeriodPayment.DividendPeriodPaymentBuilder;
import fpml.confirmation.DividendPeriodPayment.DividendPeriodPaymentBuilderImpl;
import fpml.confirmation.DividendPeriodPayment.DividendPeriodPaymentImpl;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.meta.DividendPeriodPaymentMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A time bounded dividend period, with fixed strike and a dividend payment date per period.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DividendPeriodPayment", builder=DividendPeriodPayment.DividendPeriodPaymentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DividendPeriodPayment extends DividendPeriod {

	DividendPeriodPaymentMeta metaData = new DividendPeriodPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Fixed strike.
	 */
	BigDecimal getFixedStrike();
	/**
	 * Dividend period amount payment date.
	 */
	AdjustableOrRelativeDate getPaymentDate();
	/**
	 * Dividend period amount valuation date.
	 */
	AdjustableOrRelativeDate getValuationDate();

	/*********************** Build Methods  ***********************/
	DividendPeriodPayment build();
	
	DividendPeriodPayment.DividendPeriodPaymentBuilder toBuilder();
	
	static DividendPeriodPayment.DividendPeriodPaymentBuilder builder() {
		return new DividendPeriodPayment.DividendPeriodPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPeriodPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendPeriodPayment> getType() {
		return DividendPeriodPayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.class, getUnadjustedStartDate());
		processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.class, getUnadjustedEndDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("fixedStrike"), BigDecimal.class, getFixedStrike(), this);
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("valuationDate"), processor, AdjustableOrRelativeDate.class, getValuationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPeriodPaymentBuilder extends DividendPeriodPayment, DividendPeriod.DividendPeriodBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValuationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValuationDate();
		DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setUnderlyerReference(AssetReference underlyerReference);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setId(String id);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setFixedStrike(BigDecimal fixedStrike);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setValuationDate(AdjustableOrRelativeDate valuationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedStartDate());
			processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedEndDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("fixedStrike"), BigDecimal.class, getFixedStrike(), this);
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("valuationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getValuationDate());
		}
		

		DividendPeriodPayment.DividendPeriodPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPeriodPayment  ***********************/
	class DividendPeriodPaymentImpl extends DividendPeriod.DividendPeriodImpl implements DividendPeriodPayment {
		private final BigDecimal fixedStrike;
		private final AdjustableOrRelativeDate paymentDate;
		private final AdjustableOrRelativeDate valuationDate;
		
		protected DividendPeriodPaymentImpl(DividendPeriodPayment.DividendPeriodPaymentBuilder builder) {
			super(builder);
			this.fixedStrike = builder.getFixedStrike();
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedStrike")
		public BigDecimal getFixedStrike() {
			return fixedStrike;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public AdjustableOrRelativeDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public DividendPeriodPayment build() {
			return this;
		}
		
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder toBuilder() {
			DividendPeriodPayment.DividendPeriodPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPeriodPayment.DividendPeriodPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedStrike()).ifPresent(builder::setFixedStrike);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodPayment _that = getType().cast(o);
		
			if (!Objects.equals(fixedStrike, _that.getFixedStrike())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedStrike != null ? fixedStrike.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodPayment {" +
				"fixedStrike=" + this.fixedStrike + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"valuationDate=" + this.valuationDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendPeriodPayment  ***********************/
	class DividendPeriodPaymentBuilderImpl extends DividendPeriod.DividendPeriodBuilderImpl  implements DividendPeriodPayment.DividendPeriodPaymentBuilder {
	
		protected BigDecimal fixedStrike;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder valuationDate;
	
		public DividendPeriodPaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedStrike")
		public BigDecimal getFixedStrike() {
			return fixedStrike;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValuationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate) {
			this.unadjustedStartDate = unadjustedStartDate==null?null:unadjustedStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("unadjustedEndDate")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate) {
			this.unadjustedEndDate = unadjustedEndDate==null?null:unadjustedEndDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerReference")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setUnderlyerReference(AssetReference underlyerReference) {
			this.underlyerReference = underlyerReference==null?null:underlyerReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fixedStrike")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setFixedStrike(BigDecimal fixedStrike) {
			this.fixedStrike = fixedStrike==null?null:fixedStrike;
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDate")
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setValuationDate(AdjustableOrRelativeDate valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate.toBuilder();
			return this;
		}
		
		@Override
		public DividendPeriodPayment build() {
			return new DividendPeriodPayment.DividendPeriodPaymentImpl(this);
		}
		
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder prune() {
			super.prune();
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedStrike()!=null) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DividendPeriodPayment.DividendPeriodPaymentBuilder o = (DividendPeriodPayment.DividendPeriodPaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			
			merger.mergeBasic(getFixedStrike(), o.getFixedStrike(), this::setFixedStrike);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodPayment _that = getType().cast(o);
		
			if (!Objects.equals(fixedStrike, _that.getFixedStrike())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedStrike != null ? fixedStrike.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodPaymentBuilder {" +
				"fixedStrike=" + this.fixedStrike + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"valuationDate=" + this.valuationDate +
			'}' + " " + super.toString();
		}
	}
}
