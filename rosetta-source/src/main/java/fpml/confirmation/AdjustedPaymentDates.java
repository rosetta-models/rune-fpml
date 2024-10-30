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
import fpml.confirmation.AdjustedPaymentDates;
import fpml.confirmation.AdjustedPaymentDates.AdjustedPaymentDatesBuilder;
import fpml.confirmation.AdjustedPaymentDates.AdjustedPaymentDatesBuilderImpl;
import fpml.confirmation.AdjustedPaymentDates.AdjustedPaymentDatesImpl;
import fpml.confirmation.Money;
import fpml.confirmation.meta.AdjustedPaymentDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AdjustedPaymentDates", builder=AdjustedPaymentDates.AdjustedPaymentDatesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AdjustedPaymentDates extends RosettaModelObject {

	AdjustedPaymentDatesMeta metaData = new AdjustedPaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but my be specified to allow the fee structure to also serve as a cashflow type component (all dates the the Cashflows type are adjusted payment dates).
	 */
	Date getAdjustedPaymentDate();
	/**
	 * The currency amount of the payment.
	 */
	Money getPaymentAmount();

	/*********************** Build Methods  ***********************/
	AdjustedPaymentDates build();
	
	AdjustedPaymentDates.AdjustedPaymentDatesBuilder toBuilder();
	
	static AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder() {
		return new AdjustedPaymentDates.AdjustedPaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustedPaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustedPaymentDates> getType() {
		return AdjustedPaymentDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustedPaymentDatesBuilder extends AdjustedPaymentDates, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreatePaymentAmount();
		Money.MoneyBuilder getPaymentAmount();
		AdjustedPaymentDates.AdjustedPaymentDatesBuilder setAdjustedPaymentDate(Date adjustedPaymentDate);
		AdjustedPaymentDates.AdjustedPaymentDatesBuilder setPaymentAmount(Money paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
		}
		

		AdjustedPaymentDates.AdjustedPaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustedPaymentDates  ***********************/
	class AdjustedPaymentDatesImpl implements AdjustedPaymentDates {
		private final Date adjustedPaymentDate;
		private final Money paymentAmount;
		
		protected AdjustedPaymentDatesImpl(AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder) {
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public AdjustedPaymentDates build() {
			return this;
		}
		
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder toBuilder() {
			AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder) {
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustedPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedPaymentDates {" +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustedPaymentDates  ***********************/
	class AdjustedPaymentDatesBuilderImpl implements AdjustedPaymentDates.AdjustedPaymentDatesBuilder {
	
		protected Date adjustedPaymentDate;
		protected Money.MoneyBuilder paymentAmount;
	
		public AdjustedPaymentDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public Money.MoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePaymentAmount() {
			Money.MoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder setAdjustedPaymentDate(Date adjustedPaymentDate) {
			this.adjustedPaymentDate = adjustedPaymentDate==null?null:adjustedPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder setPaymentAmount(Money paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedPaymentDates build() {
			return new AdjustedPaymentDates.AdjustedPaymentDatesImpl(this);
		}
		
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder prune() {
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedPaymentDate()!=null) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustedPaymentDates.AdjustedPaymentDatesBuilder o = (AdjustedPaymentDates.AdjustedPaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustedPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedPaymentDatesBuilder {" +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}';
		}
	}
}
