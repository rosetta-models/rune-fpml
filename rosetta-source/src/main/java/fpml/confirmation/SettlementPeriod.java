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
import fpml.confirmation.SettlementPeriod;
import fpml.confirmation.SettlementPeriod.SettlementPeriodBuilder;
import fpml.confirmation.SettlementPeriod.SettlementPeriodBuilderImpl;
import fpml.confirmation.SettlementPeriod.SettlementPeriodImpl;
import fpml.confirmation.meta.SettlementPeriodMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementPeriod", builder=SettlementPeriod.SettlementPeriodBuilderImpl.class, version="${project.version}")
public interface SettlementPeriod extends RosettaModelObject {

	SettlementPeriodMeta metaData = new SettlementPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Expiry date for the settlement period.
	 */
	Date getExpiryDate();
	/**
	 * Settlement date for the settlement period.
	 */
	Date getSettlementDate();
	/**
	 * Notional Amount for the settlement period.
	 */
	BigDecimal getNotionalAmount();

	/*********************** Build Methods  ***********************/
	SettlementPeriod build();
	
	SettlementPeriod.SettlementPeriodBuilder toBuilder();
	
	static SettlementPeriod.SettlementPeriodBuilder builder() {
		return new SettlementPeriod.SettlementPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriod> getType() {
		return SettlementPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodBuilder extends SettlementPeriod, RosettaModelObjectBuilder {
		SettlementPeriod.SettlementPeriodBuilder setExpiryDate(Date expiryDate);
		SettlementPeriod.SettlementPeriodBuilder setSettlementDate(Date settlementDate);
		SettlementPeriod.SettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		}
		

		SettlementPeriod.SettlementPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriod  ***********************/
	class SettlementPeriodImpl implements SettlementPeriod {
		private final Date expiryDate;
		private final Date settlementDate;
		private final BigDecimal notionalAmount;
		
		protected SettlementPeriodImpl(SettlementPeriod.SettlementPeriodBuilder builder) {
			this.expiryDate = builder.getExpiryDate();
			this.settlementDate = builder.getSettlementDate();
			this.notionalAmount = builder.getNotionalAmount();
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public Date getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public SettlementPeriod build() {
			return this;
		}
		
		@Override
		public SettlementPeriod.SettlementPeriodBuilder toBuilder() {
			SettlementPeriod.SettlementPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriod.SettlementPeriodBuilder builder) {
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriod {" +
				"expiryDate=" + this.expiryDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriod  ***********************/
	class SettlementPeriodBuilderImpl implements SettlementPeriod.SettlementPeriodBuilder {
	
		protected Date expiryDate;
		protected Date settlementDate;
		protected BigDecimal notionalAmount;
	
		public SettlementPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public Date getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public SettlementPeriod.SettlementPeriodBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public SettlementPeriod.SettlementPeriodBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public SettlementPeriod.SettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount;
			return this;
		}
		
		@Override
		public SettlementPeriod build() {
			return new SettlementPeriod.SettlementPeriodImpl(this);
		}
		
		@Override
		public SettlementPeriod.SettlementPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriod.SettlementPeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExpiryDate()!=null) return true;
			if (getSettlementDate()!=null) return true;
			if (getNotionalAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriod.SettlementPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriod.SettlementPeriodBuilder o = (SettlementPeriod.SettlementPeriodBuilder) other;
			
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodBuilder {" +
				"expiryDate=" + this.expiryDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}';
		}
	}
}
