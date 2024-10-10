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
import fpml.confirmation.Money;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.SinglePayment;
import fpml.confirmation.SinglePayment.SinglePaymentBuilder;
import fpml.confirmation.SinglePayment.SinglePaymentBuilderImpl;
import fpml.confirmation.SinglePayment.SinglePaymentImpl;
import fpml.confirmation.meta.SinglePaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SinglePayment", builder=SinglePayment.SinglePaymentBuilderImpl.class, version="${project.version}")
public interface SinglePayment extends PaymentBase {

	SinglePaymentMeta metaData = new SinglePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A fixed amount payment date that shall be subject to adjustment in accordance with the applicable business day convention if it would otherwise fall on a day that is not a business day. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term: Fixed Rate Payer Payment Date
	 */
	Date getAdjustablePaymentDate();
	/**
	 * The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
	 */
	Date getAdjustedPaymentDate();
	/**
	 * A fixed payment amount. ISDA 2003 Term: Fixed Amount
	 */
	Money getFixedAmount();

	/*********************** Build Methods  ***********************/
	SinglePayment build();
	
	SinglePayment.SinglePaymentBuilder toBuilder();
	
	static SinglePayment.SinglePaymentBuilder builder() {
		return new SinglePayment.SinglePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SinglePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SinglePayment> getType() {
		return SinglePayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("adjustablePaymentDate"), Date.class, getAdjustablePaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("fixedAmount"), processor, Money.class, getFixedAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SinglePaymentBuilder extends SinglePayment, PaymentBase.PaymentBaseBuilder {
		Money.MoneyBuilder getOrCreateFixedAmount();
		Money.MoneyBuilder getFixedAmount();
		SinglePayment.SinglePaymentBuilder setId(String id);
		SinglePayment.SinglePaymentBuilder setAdjustablePaymentDate(Date adjustablePaymentDate);
		SinglePayment.SinglePaymentBuilder setAdjustedPaymentDate(Date adjustedPaymentDate);
		SinglePayment.SinglePaymentBuilder setFixedAmount(Money fixedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("adjustablePaymentDate"), Date.class, getAdjustablePaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("fixedAmount"), processor, Money.MoneyBuilder.class, getFixedAmount());
		}
		

		SinglePayment.SinglePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of SinglePayment  ***********************/
	class SinglePaymentImpl extends PaymentBase.PaymentBaseImpl implements SinglePayment {
		private final Date adjustablePaymentDate;
		private final Date adjustedPaymentDate;
		private final Money fixedAmount;
		
		protected SinglePaymentImpl(SinglePayment.SinglePaymentBuilder builder) {
			super(builder);
			this.adjustablePaymentDate = builder.getAdjustablePaymentDate();
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.fixedAmount = ofNullable(builder.getFixedAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustablePaymentDate")
		public Date getAdjustablePaymentDate() {
			return adjustablePaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		public Money getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public SinglePayment build() {
			return this;
		}
		
		@Override
		public SinglePayment.SinglePaymentBuilder toBuilder() {
			SinglePayment.SinglePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SinglePayment.SinglePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdjustablePaymentDate()).ifPresent(builder::setAdjustablePaymentDate);
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getFixedAmount()).ifPresent(builder::setFixedAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SinglePayment _that = getType().cast(o);
		
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePayment {" +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"fixedAmount=" + this.fixedAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SinglePayment  ***********************/
	class SinglePaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl  implements SinglePayment.SinglePaymentBuilder {
	
		protected Date adjustablePaymentDate;
		protected Date adjustedPaymentDate;
		protected Money.MoneyBuilder fixedAmount;
	
		public SinglePaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustablePaymentDate")
		public Date getAdjustablePaymentDate() {
			return adjustablePaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		public Money.MoneyBuilder getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateFixedAmount() {
			Money.MoneyBuilder result;
			if (fixedAmount!=null) {
				result = fixedAmount;
			}
			else {
				result = fixedAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public SinglePayment.SinglePaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("adjustablePaymentDate")
		public SinglePayment.SinglePaymentBuilder setAdjustablePaymentDate(Date adjustablePaymentDate) {
			this.adjustablePaymentDate = adjustablePaymentDate==null?null:adjustablePaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public SinglePayment.SinglePaymentBuilder setAdjustedPaymentDate(Date adjustedPaymentDate) {
			this.adjustedPaymentDate = adjustedPaymentDate==null?null:adjustedPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("fixedAmount")
		public SinglePayment.SinglePaymentBuilder setFixedAmount(Money fixedAmount) {
			this.fixedAmount = fixedAmount==null?null:fixedAmount.toBuilder();
			return this;
		}
		
		@Override
		public SinglePayment build() {
			return new SinglePayment.SinglePaymentImpl(this);
		}
		
		@Override
		public SinglePayment.SinglePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePayment.SinglePaymentBuilder prune() {
			super.prune();
			if (fixedAmount!=null && !fixedAmount.prune().hasData()) fixedAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdjustablePaymentDate()!=null) return true;
			if (getAdjustedPaymentDate()!=null) return true;
			if (getFixedAmount()!=null && getFixedAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePayment.SinglePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SinglePayment.SinglePaymentBuilder o = (SinglePayment.SinglePaymentBuilder) other;
			
			merger.mergeRosetta(getFixedAmount(), o.getFixedAmount(), this::setFixedAmount);
			
			merger.mergeBasic(getAdjustablePaymentDate(), o.getAdjustablePaymentDate(), this::setAdjustablePaymentDate);
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SinglePayment _that = getType().cast(o);
		
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePaymentBuilder {" +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"fixedAmount=" + this.fixedAmount +
			'}' + " " + super.toString();
		}
	}
}
