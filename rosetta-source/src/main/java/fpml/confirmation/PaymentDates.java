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
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.Frequency;
import fpml.confirmation.Offset;
import fpml.confirmation.PayRelativeToEnum;
import fpml.confirmation.PaymentDates;
import fpml.confirmation.PaymentDates.PaymentDatesBuilder;
import fpml.confirmation.PaymentDates.PaymentDatesBuilderImpl;
import fpml.confirmation.PaymentDates.PaymentDatesImpl;
import fpml.confirmation.ResetDatesReference;
import fpml.confirmation.ValuationDatesReference;
import fpml.confirmation.meta.PaymentDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining parameters used to generate the payment dates schedule, including the specification of early or delayed payments. Payment dates are determined relative to the calculation period dates or the reset dates.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentDates", builder=PaymentDates.PaymentDatesBuilderImpl.class, version="${project.version}")
public interface PaymentDates extends RosettaModelObject {

	PaymentDatesMeta metaData = new PaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 */
	CalculationPeriodDatesReference getCalculationPeriodDatesReference();
	/**
	 * A pointer style reference to the associated reset dates component defined elsewhere in the document.
	 */
	ResetDatesReference getResetDatesReference();
	/**
	 * A pointer style reference to the associated valuation dates component defined elsewhere in the document. Implemented for Brazilian-CDI Swaps where it will refer to the settlemementProvision/nonDeliverableSettlement/fxFixingDate structure.
	 */
	ValuationDatesReference getValuationDatesReference();
	/**
	 * The frequency at which regular payment dates occur. If the payment frequency is equal to the frequency defined in the calculation period dates component then one calculation period contributes to each payment amount. If the payment frequency is less frequent than the frequency defined in the calculation period dates component then more than one calculation period will contribute to the payment amount. A payment frequency more frequent than the calculation period frequency or one that is not a multiple of the calculation period frequency is invalid. If the payment frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
	 */
	Frequency getPaymentFrequency();
	/**
	 * The first unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is an initial stub. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual first payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
	 */
	Date getFirstPaymentDate();
	/**
	 * The last regular unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is a final stub. All calculation periods after this date contribute to the final payment. The final payment is made relative to the final set of calculation periods or the final reset date as the case may be. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual last regular payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
	 */
	Date getLastRegularPaymentDate();
	/**
	 * Specifies whether the payments occur relative to each adjusted calculation period start date, adjusted calculation period end date or each reset date. The reset date is applicable in the case of certain euro (former French Franc) floating rate indices. Calculation period start date means relative to the start of the first calculation period contributing to a given payment. Similarly, calculation period end date means the end of the last calculation period contributing to a given payment.The valuation date is applicable for Brazilian-CDI swaps.
	 */
	PayRelativeToEnum getPayRelativeTo();
	/**
	 * If early payment or delayed payment is required, specifies the number of days offset that the payment occurs relative to what would otherwise be the unadjusted payment date. The offset can be specified in terms of either calendar or business days. Even in the case of a calendar days offset, the resulting payment date, adjusted for the specified calendar days offset, will still be adjusted in accordance with the specified payment dates adjustments. This element should only be included if early or delayed payment is applicable, i.e. if the periodMultiplier element value is not equal to zero. An early payment would be indicated by a negative periodMultiplier element value and a delayed payment (or payment lag) would be indicated by a positive periodMultiplier element value.
	 */
	Offset getPaymentDaysOffset();
	/**
	 * The business day convention to apply to each payment date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 */
	BusinessDayAdjustments getPaymentDatesAdjustments();
	String getId();

	/*********************** Build Methods  ***********************/
	PaymentDates build();
	
	PaymentDates.PaymentDatesBuilder toBuilder();
	
	static PaymentDates.PaymentDatesBuilder builder() {
		return new PaymentDates.PaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentDates> getType() {
		return PaymentDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.class, getCalculationPeriodDatesReference());
		processRosetta(path.newSubPath("resetDatesReference"), processor, ResetDatesReference.class, getResetDatesReference());
		processRosetta(path.newSubPath("valuationDatesReference"), processor, ValuationDatesReference.class, getValuationDatesReference());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("firstPaymentDate"), Date.class, getFirstPaymentDate(), this);
		processor.processBasic(path.newSubPath("lastRegularPaymentDate"), Date.class, getLastRegularPaymentDate(), this);
		processor.processBasic(path.newSubPath("payRelativeTo"), PayRelativeToEnum.class, getPayRelativeTo(), this);
		processRosetta(path.newSubPath("paymentDaysOffset"), processor, Offset.class, getPaymentDaysOffset());
		processRosetta(path.newSubPath("paymentDatesAdjustments"), processor, BusinessDayAdjustments.class, getPaymentDatesAdjustments());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDatesBuilder extends PaymentDates, RosettaModelObjectBuilder {
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference();
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference();
		ResetDatesReference.ResetDatesReferenceBuilder getOrCreateResetDatesReference();
		ResetDatesReference.ResetDatesReferenceBuilder getResetDatesReference();
		ValuationDatesReference.ValuationDatesReferenceBuilder getOrCreateValuationDatesReference();
		ValuationDatesReference.ValuationDatesReferenceBuilder getValuationDatesReference();
		Frequency.FrequencyBuilder getOrCreatePaymentFrequency();
		Frequency.FrequencyBuilder getPaymentFrequency();
		Offset.OffsetBuilder getOrCreatePaymentDaysOffset();
		Offset.OffsetBuilder getPaymentDaysOffset();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreatePaymentDatesAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getPaymentDatesAdjustments();
		PaymentDates.PaymentDatesBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference);
		PaymentDates.PaymentDatesBuilder setResetDatesReference(ResetDatesReference resetDatesReference);
		PaymentDates.PaymentDatesBuilder setValuationDatesReference(ValuationDatesReference valuationDatesReference);
		PaymentDates.PaymentDatesBuilder setPaymentFrequency(Frequency paymentFrequency);
		PaymentDates.PaymentDatesBuilder setFirstPaymentDate(Date firstPaymentDate);
		PaymentDates.PaymentDatesBuilder setLastRegularPaymentDate(Date lastRegularPaymentDate);
		PaymentDates.PaymentDatesBuilder setPayRelativeTo(PayRelativeToEnum payRelativeTo);
		PaymentDates.PaymentDatesBuilder setPaymentDaysOffset(Offset paymentDaysOffset);
		PaymentDates.PaymentDatesBuilder setPaymentDatesAdjustments(BusinessDayAdjustments paymentDatesAdjustments);
		PaymentDates.PaymentDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder.class, getCalculationPeriodDatesReference());
			processRosetta(path.newSubPath("resetDatesReference"), processor, ResetDatesReference.ResetDatesReferenceBuilder.class, getResetDatesReference());
			processRosetta(path.newSubPath("valuationDatesReference"), processor, ValuationDatesReference.ValuationDatesReferenceBuilder.class, getValuationDatesReference());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.FrequencyBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("firstPaymentDate"), Date.class, getFirstPaymentDate(), this);
			processor.processBasic(path.newSubPath("lastRegularPaymentDate"), Date.class, getLastRegularPaymentDate(), this);
			processor.processBasic(path.newSubPath("payRelativeTo"), PayRelativeToEnum.class, getPayRelativeTo(), this);
			processRosetta(path.newSubPath("paymentDaysOffset"), processor, Offset.OffsetBuilder.class, getPaymentDaysOffset());
			processRosetta(path.newSubPath("paymentDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getPaymentDatesAdjustments());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PaymentDates.PaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDates  ***********************/
	class PaymentDatesImpl implements PaymentDates {
		private final CalculationPeriodDatesReference calculationPeriodDatesReference;
		private final ResetDatesReference resetDatesReference;
		private final ValuationDatesReference valuationDatesReference;
		private final Frequency paymentFrequency;
		private final Date firstPaymentDate;
		private final Date lastRegularPaymentDate;
		private final PayRelativeToEnum payRelativeTo;
		private final Offset paymentDaysOffset;
		private final BusinessDayAdjustments paymentDatesAdjustments;
		private final String id;
		
		protected PaymentDatesImpl(PaymentDates.PaymentDatesBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).map(f->f.build()).orElse(null);
			this.resetDatesReference = ofNullable(builder.getResetDatesReference()).map(f->f.build()).orElse(null);
			this.valuationDatesReference = ofNullable(builder.getValuationDatesReference()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.firstPaymentDate = builder.getFirstPaymentDate();
			this.lastRegularPaymentDate = builder.getLastRegularPaymentDate();
			this.payRelativeTo = builder.getPayRelativeTo();
			this.paymentDaysOffset = ofNullable(builder.getPaymentDaysOffset()).map(f->f.build()).orElse(null);
			this.paymentDatesAdjustments = ofNullable(builder.getPaymentDatesAdjustments()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		@RosettaAttribute("resetDatesReference")
		public ResetDatesReference getResetDatesReference() {
			return resetDatesReference;
		}
		
		@Override
		@RosettaAttribute("valuationDatesReference")
		public ValuationDatesReference getValuationDatesReference() {
			return valuationDatesReference;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Frequency getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("firstPaymentDate")
		public Date getFirstPaymentDate() {
			return firstPaymentDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPaymentDate")
		public Date getLastRegularPaymentDate() {
			return lastRegularPaymentDate;
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		public PayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		public Offset getPaymentDaysOffset() {
			return paymentDaysOffset;
		}
		
		@Override
		@RosettaAttribute("paymentDatesAdjustments")
		public BusinessDayAdjustments getPaymentDatesAdjustments() {
			return paymentDatesAdjustments;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PaymentDates build() {
			return this;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder toBuilder() {
			PaymentDates.PaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDates.PaymentDatesBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
			ofNullable(getResetDatesReference()).ifPresent(builder::setResetDatesReference);
			ofNullable(getValuationDatesReference()).ifPresent(builder::setValuationDatesReference);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getFirstPaymentDate()).ifPresent(builder::setFirstPaymentDate);
			ofNullable(getLastRegularPaymentDate()).ifPresent(builder::setLastRegularPaymentDate);
			ofNullable(getPayRelativeTo()).ifPresent(builder::setPayRelativeTo);
			ofNullable(getPaymentDaysOffset()).ifPresent(builder::setPaymentDaysOffset);
			ofNullable(getPaymentDatesAdjustments()).ifPresent(builder::setPaymentDatesAdjustments);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetDatesReference, _that.getResetDatesReference())) return false;
			if (!Objects.equals(valuationDatesReference, _that.getValuationDatesReference())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(firstPaymentDate, _that.getFirstPaymentDate())) return false;
			if (!Objects.equals(lastRegularPaymentDate, _that.getLastRegularPaymentDate())) return false;
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(paymentDatesAdjustments, _that.getPaymentDatesAdjustments())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetDatesReference != null ? resetDatesReference.hashCode() : 0);
			_result = 31 * _result + (valuationDatesReference != null ? valuationDatesReference.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (firstPaymentDate != null ? firstPaymentDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPaymentDate != null ? lastRegularPaymentDate.hashCode() : 0);
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (paymentDatesAdjustments != null ? paymentDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDates {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetDatesReference=" + this.resetDatesReference + ", " +
				"valuationDatesReference=" + this.valuationDatesReference + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"firstPaymentDate=" + this.firstPaymentDate + ", " +
				"lastRegularPaymentDate=" + this.lastRegularPaymentDate + ", " +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"paymentDatesAdjustments=" + this.paymentDatesAdjustments + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentDates  ***********************/
	class PaymentDatesBuilderImpl implements PaymentDates.PaymentDatesBuilder {
	
		protected CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder calculationPeriodDatesReference;
		protected ResetDatesReference.ResetDatesReferenceBuilder resetDatesReference;
		protected ValuationDatesReference.ValuationDatesReferenceBuilder valuationDatesReference;
		protected Frequency.FrequencyBuilder paymentFrequency;
		protected Date firstPaymentDate;
		protected Date lastRegularPaymentDate;
		protected PayRelativeToEnum payRelativeTo;
		protected Offset.OffsetBuilder paymentDaysOffset;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder paymentDatesAdjustments;
		protected String id;
	
		public PaymentDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference() {
			CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder result;
			if (calculationPeriodDatesReference!=null) {
				result = calculationPeriodDatesReference;
			}
			else {
				result = calculationPeriodDatesReference = CalculationPeriodDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetDatesReference")
		public ResetDatesReference.ResetDatesReferenceBuilder getResetDatesReference() {
			return resetDatesReference;
		}
		
		@Override
		public ResetDatesReference.ResetDatesReferenceBuilder getOrCreateResetDatesReference() {
			ResetDatesReference.ResetDatesReferenceBuilder result;
			if (resetDatesReference!=null) {
				result = resetDatesReference;
			}
			else {
				result = resetDatesReference = ResetDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDatesReference")
		public ValuationDatesReference.ValuationDatesReferenceBuilder getValuationDatesReference() {
			return valuationDatesReference;
		}
		
		@Override
		public ValuationDatesReference.ValuationDatesReferenceBuilder getOrCreateValuationDatesReference() {
			ValuationDatesReference.ValuationDatesReferenceBuilder result;
			if (valuationDatesReference!=null) {
				result = valuationDatesReference;
			}
			else {
				result = valuationDatesReference = ValuationDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Frequency.FrequencyBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreatePaymentFrequency() {
			Frequency.FrequencyBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstPaymentDate")
		public Date getFirstPaymentDate() {
			return firstPaymentDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPaymentDate")
		public Date getLastRegularPaymentDate() {
			return lastRegularPaymentDate;
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		public PayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		public Offset.OffsetBuilder getPaymentDaysOffset() {
			return paymentDaysOffset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreatePaymentDaysOffset() {
			Offset.OffsetBuilder result;
			if (paymentDaysOffset!=null) {
				result = paymentDaysOffset;
			}
			else {
				result = paymentDaysOffset = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDatesAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getPaymentDatesAdjustments() {
			return paymentDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreatePaymentDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (paymentDatesAdjustments!=null) {
				result = paymentDatesAdjustments;
			}
			else {
				result = paymentDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public PaymentDates.PaymentDatesBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference) {
			this.calculationPeriodDatesReference = calculationPeriodDatesReference==null?null:calculationPeriodDatesReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("resetDatesReference")
		public PaymentDates.PaymentDatesBuilder setResetDatesReference(ResetDatesReference resetDatesReference) {
			this.resetDatesReference = resetDatesReference==null?null:resetDatesReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDatesReference")
		public PaymentDates.PaymentDatesBuilder setValuationDatesReference(ValuationDatesReference valuationDatesReference) {
			this.valuationDatesReference = valuationDatesReference==null?null:valuationDatesReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public PaymentDates.PaymentDatesBuilder setPaymentFrequency(Frequency paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("firstPaymentDate")
		public PaymentDates.PaymentDatesBuilder setFirstPaymentDate(Date firstPaymentDate) {
			this.firstPaymentDate = firstPaymentDate==null?null:firstPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("lastRegularPaymentDate")
		public PaymentDates.PaymentDatesBuilder setLastRegularPaymentDate(Date lastRegularPaymentDate) {
			this.lastRegularPaymentDate = lastRegularPaymentDate==null?null:lastRegularPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("payRelativeTo")
		public PaymentDates.PaymentDatesBuilder setPayRelativeTo(PayRelativeToEnum payRelativeTo) {
			this.payRelativeTo = payRelativeTo==null?null:payRelativeTo;
			return this;
		}
		@Override
		@RosettaAttribute("paymentDaysOffset")
		public PaymentDates.PaymentDatesBuilder setPaymentDaysOffset(Offset paymentDaysOffset) {
			this.paymentDaysOffset = paymentDaysOffset==null?null:paymentDaysOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDatesAdjustments")
		public PaymentDates.PaymentDatesBuilder setPaymentDatesAdjustments(BusinessDayAdjustments paymentDatesAdjustments) {
			this.paymentDatesAdjustments = paymentDatesAdjustments==null?null:paymentDatesAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PaymentDates.PaymentDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PaymentDates build() {
			return new PaymentDates.PaymentDatesImpl(this);
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDates.PaymentDatesBuilder prune() {
			if (calculationPeriodDatesReference!=null && !calculationPeriodDatesReference.prune().hasData()) calculationPeriodDatesReference = null;
			if (resetDatesReference!=null && !resetDatesReference.prune().hasData()) resetDatesReference = null;
			if (valuationDatesReference!=null && !valuationDatesReference.prune().hasData()) valuationDatesReference = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (paymentDaysOffset!=null && !paymentDaysOffset.prune().hasData()) paymentDaysOffset = null;
			if (paymentDatesAdjustments!=null && !paymentDatesAdjustments.prune().hasData()) paymentDatesAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().hasData()) return true;
			if (getResetDatesReference()!=null && getResetDatesReference().hasData()) return true;
			if (getValuationDatesReference()!=null && getValuationDatesReference().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getFirstPaymentDate()!=null) return true;
			if (getLastRegularPaymentDate()!=null) return true;
			if (getPayRelativeTo()!=null) return true;
			if (getPaymentDaysOffset()!=null && getPaymentDaysOffset().hasData()) return true;
			if (getPaymentDatesAdjustments()!=null && getPaymentDatesAdjustments().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDates.PaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentDates.PaymentDatesBuilder o = (PaymentDates.PaymentDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::setCalculationPeriodDatesReference);
			merger.mergeRosetta(getResetDatesReference(), o.getResetDatesReference(), this::setResetDatesReference);
			merger.mergeRosetta(getValuationDatesReference(), o.getValuationDatesReference(), this::setValuationDatesReference);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getPaymentDaysOffset(), o.getPaymentDaysOffset(), this::setPaymentDaysOffset);
			merger.mergeRosetta(getPaymentDatesAdjustments(), o.getPaymentDatesAdjustments(), this::setPaymentDatesAdjustments);
			
			merger.mergeBasic(getFirstPaymentDate(), o.getFirstPaymentDate(), this::setFirstPaymentDate);
			merger.mergeBasic(getLastRegularPaymentDate(), o.getLastRegularPaymentDate(), this::setLastRegularPaymentDate);
			merger.mergeBasic(getPayRelativeTo(), o.getPayRelativeTo(), this::setPayRelativeTo);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetDatesReference, _that.getResetDatesReference())) return false;
			if (!Objects.equals(valuationDatesReference, _that.getValuationDatesReference())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(firstPaymentDate, _that.getFirstPaymentDate())) return false;
			if (!Objects.equals(lastRegularPaymentDate, _that.getLastRegularPaymentDate())) return false;
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(paymentDatesAdjustments, _that.getPaymentDatesAdjustments())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetDatesReference != null ? resetDatesReference.hashCode() : 0);
			_result = 31 * _result + (valuationDatesReference != null ? valuationDatesReference.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (firstPaymentDate != null ? firstPaymentDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPaymentDate != null ? lastRegularPaymentDate.hashCode() : 0);
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (paymentDatesAdjustments != null ? paymentDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDatesBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetDatesReference=" + this.resetDatesReference + ", " +
				"valuationDatesReference=" + this.valuationDatesReference + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"firstPaymentDate=" + this.firstPaymentDate + ", " +
				"lastRegularPaymentDate=" + this.lastRegularPaymentDate + ", " +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"paymentDatesAdjustments=" + this.paymentDatesAdjustments + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
