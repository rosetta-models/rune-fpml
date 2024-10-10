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
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.PaymentProjection.PaymentProjectionBuilder;
import fpml.confirmation.PaymentProjection.PaymentProjectionBuilderImpl;
import fpml.confirmation.PaymentProjection.PaymentProjectionImpl;
import fpml.confirmation.meta.PaymentProjectionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents interest payment projections.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentProjection", builder=PaymentProjection.PaymentProjectionBuilderImpl.class, version="${project.version}")
public interface PaymentProjection extends RosettaModelObject {

	PaymentProjectionMeta metaData = new PaymentProjectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The next payment for the associated event type is due on this date. This is an actual (adjusted) date.
	 */
	Date getNextPaymentDate();
	/**
	 * Projected amount payable on the next payment date.
	 */
	MoneyWithParticipantShare getProjectedAmount();

	/*********************** Build Methods  ***********************/
	PaymentProjection build();
	
	PaymentProjection.PaymentProjectionBuilder toBuilder();
	
	static PaymentProjection.PaymentProjectionBuilder builder() {
		return new PaymentProjection.PaymentProjectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentProjection> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentProjection> getType() {
		return PaymentProjection.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nextPaymentDate"), Date.class, getNextPaymentDate(), this);
		processRosetta(path.newSubPath("projectedAmount"), processor, MoneyWithParticipantShare.class, getProjectedAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentProjectionBuilder extends PaymentProjection, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateProjectedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getProjectedAmount();
		PaymentProjection.PaymentProjectionBuilder setNextPaymentDate(Date nextPaymentDate);
		PaymentProjection.PaymentProjectionBuilder setProjectedAmount(MoneyWithParticipantShare projectedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nextPaymentDate"), Date.class, getNextPaymentDate(), this);
			processRosetta(path.newSubPath("projectedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getProjectedAmount());
		}
		

		PaymentProjection.PaymentProjectionBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentProjection  ***********************/
	class PaymentProjectionImpl implements PaymentProjection {
		private final Date nextPaymentDate;
		private final MoneyWithParticipantShare projectedAmount;
		
		protected PaymentProjectionImpl(PaymentProjection.PaymentProjectionBuilder builder) {
			this.nextPaymentDate = builder.getNextPaymentDate();
			this.projectedAmount = ofNullable(builder.getProjectedAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nextPaymentDate")
		public Date getNextPaymentDate() {
			return nextPaymentDate;
		}
		
		@Override
		@RosettaAttribute("projectedAmount")
		public MoneyWithParticipantShare getProjectedAmount() {
			return projectedAmount;
		}
		
		@Override
		public PaymentProjection build() {
			return this;
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder toBuilder() {
			PaymentProjection.PaymentProjectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentProjection.PaymentProjectionBuilder builder) {
			ofNullable(getNextPaymentDate()).ifPresent(builder::setNextPaymentDate);
			ofNullable(getProjectedAmount()).ifPresent(builder::setProjectedAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentProjection _that = getType().cast(o);
		
			if (!Objects.equals(nextPaymentDate, _that.getNextPaymentDate())) return false;
			if (!Objects.equals(projectedAmount, _that.getProjectedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nextPaymentDate != null ? nextPaymentDate.hashCode() : 0);
			_result = 31 * _result + (projectedAmount != null ? projectedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentProjection {" +
				"nextPaymentDate=" + this.nextPaymentDate + ", " +
				"projectedAmount=" + this.projectedAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentProjection  ***********************/
	class PaymentProjectionBuilderImpl implements PaymentProjection.PaymentProjectionBuilder {
	
		protected Date nextPaymentDate;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder projectedAmount;
	
		public PaymentProjectionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("nextPaymentDate")
		public Date getNextPaymentDate() {
			return nextPaymentDate;
		}
		
		@Override
		@RosettaAttribute("projectedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getProjectedAmount() {
			return projectedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateProjectedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (projectedAmount!=null) {
				result = projectedAmount;
			}
			else {
				result = projectedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nextPaymentDate")
		public PaymentProjection.PaymentProjectionBuilder setNextPaymentDate(Date nextPaymentDate) {
			this.nextPaymentDate = nextPaymentDate==null?null:nextPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("projectedAmount")
		public PaymentProjection.PaymentProjectionBuilder setProjectedAmount(MoneyWithParticipantShare projectedAmount) {
			this.projectedAmount = projectedAmount==null?null:projectedAmount.toBuilder();
			return this;
		}
		
		@Override
		public PaymentProjection build() {
			return new PaymentProjection.PaymentProjectionImpl(this);
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentProjection.PaymentProjectionBuilder prune() {
			if (projectedAmount!=null && !projectedAmount.prune().hasData()) projectedAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNextPaymentDate()!=null) return true;
			if (getProjectedAmount()!=null && getProjectedAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentProjection.PaymentProjectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentProjection.PaymentProjectionBuilder o = (PaymentProjection.PaymentProjectionBuilder) other;
			
			merger.mergeRosetta(getProjectedAmount(), o.getProjectedAmount(), this::setProjectedAmount);
			
			merger.mergeBasic(getNextPaymentDate(), o.getNextPaymentDate(), this::setNextPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentProjection _that = getType().cast(o);
		
			if (!Objects.equals(nextPaymentDate, _that.getNextPaymentDate())) return false;
			if (!Objects.equals(projectedAmount, _that.getProjectedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nextPaymentDate != null ? nextPaymentDate.hashCode() : 0);
			_result = 31 * _result + (projectedAmount != null ? projectedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentProjectionBuilder {" +
				"nextPaymentDate=" + this.nextPaymentDate + ", " +
				"projectedAmount=" + this.projectedAmount +
			'}';
		}
	}
}
