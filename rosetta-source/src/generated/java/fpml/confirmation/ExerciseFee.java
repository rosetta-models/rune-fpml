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
import fpml.confirmation.ExerciseFee;
import fpml.confirmation.ExerciseFee.ExerciseFeeBuilder;
import fpml.confirmation.ExerciseFee.ExerciseFeeBuilderImpl;
import fpml.confirmation.ExerciseFee.ExerciseFeeImpl;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.meta.ExerciseFeeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised.
 * @version ${project.version}
 */
@RosettaDataType(value="ExerciseFee", builder=ExerciseFee.ExerciseFeeBuilderImpl.class, version="${project.version}")
public interface ExerciseFee extends RosettaModelObject {

	ExerciseFeeMeta metaData = new ExerciseFeeMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 */
	NotionalReference getNotionalReference();
	/**
	 * The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
	 */
	BigDecimal getFeeAmount();
	/**
	 * A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
	 */
	BigDecimal getFeeRate();
	/**
	 * The date on which exercise fee(s) will be paid. It is specified as a relative date.
	 */
	RelativeDateOffset getFeePaymentDate();

	/*********************** Build Methods  ***********************/
	ExerciseFee build();
	
	ExerciseFee.ExerciseFeeBuilder toBuilder();
	
	static ExerciseFee.ExerciseFeeBuilder builder() {
		return new ExerciseFee.ExerciseFeeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseFee> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExerciseFee> getType() {
		return ExerciseFee.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
		processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
		processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.class, getFeePaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseFeeBuilder extends ExerciseFee, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference();
		NotionalReference.NotionalReferenceBuilder getNotionalReference();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate();
		ExerciseFee.ExerciseFeeBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		ExerciseFee.ExerciseFeeBuilder setNotionalReference(NotionalReference notionalReference);
		ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal feeAmount);
		ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal feeRate);
		ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
			processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
			processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFeePaymentDate());
		}
		

		ExerciseFee.ExerciseFeeBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseFee  ***********************/
	class ExerciseFeeImpl implements ExerciseFee {
		private final PayerReceiverModel payerReceiverModel;
		private final NotionalReference notionalReference;
		private final BigDecimal feeAmount;
		private final BigDecimal feeRate;
		private final RelativeDateOffset feePaymentDate;
		
		protected ExerciseFeeImpl(ExerciseFee.ExerciseFeeBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.feeAmount = builder.getFeeAmount();
			this.feeRate = builder.getFeeRate();
			this.feePaymentDate = ofNullable(builder.getFeePaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("feeAmount")
		public BigDecimal getFeeAmount() {
			return feeAmount;
		}
		
		@Override
		@RosettaAttribute("feeRate")
		public BigDecimal getFeeRate() {
			return feeRate;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		public RelativeDateOffset getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public ExerciseFee build() {
			return this;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			ExerciseFee.ExerciseFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseFee.ExerciseFeeBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getFeeAmount()).ifPresent(builder::setFeeAmount);
			ofNullable(getFeeRate()).ifPresent(builder::setFeeRate);
			ofNullable(getFeePaymentDate()).ifPresent(builder::setFeePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFee {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmount=" + this.feeAmount + ", " +
				"feeRate=" + this.feeRate + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseFee  ***********************/
	class ExerciseFeeBuilderImpl implements ExerciseFee.ExerciseFeeBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected NotionalReference.NotionalReferenceBuilder notionalReference;
		protected BigDecimal feeAmount;
		protected BigDecimal feeRate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder feePaymentDate;
	
		public ExerciseFeeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeAmount")
		public BigDecimal getFeeAmount() {
			return feeAmount;
		}
		
		@Override
		@RosettaAttribute("feeRate")
		public BigDecimal getFeeRate() {
			return feeRate;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (feePaymentDate!=null) {
				result = feePaymentDate;
			}
			else {
				result = feePaymentDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public ExerciseFee.ExerciseFeeBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalReference")
		public ExerciseFee.ExerciseFeeBuilder setNotionalReference(NotionalReference notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeAmount")
		public ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal feeAmount) {
			this.feeAmount = feeAmount==null?null:feeAmount;
			return this;
		}
		@Override
		@RosettaAttribute("feeRate")
		public ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal feeRate) {
			this.feeRate = feeRate==null?null:feeRate;
			return this;
		}
		@Override
		@RosettaAttribute("feePaymentDate")
		public ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate) {
			this.feePaymentDate = feePaymentDate==null?null:feePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFee build() {
			return new ExerciseFee.ExerciseFeeImpl(this);
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (feePaymentDate!=null && !feePaymentDate.prune().hasData()) feePaymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getFeeAmount()!=null) return true;
			if (getFeeRate()!=null) return true;
			if (getFeePaymentDate()!=null && getFeePaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseFee.ExerciseFeeBuilder o = (ExerciseFee.ExerciseFeeBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getFeePaymentDate(), o.getFeePaymentDate(), this::setFeePaymentDate);
			
			merger.mergeBasic(getFeeAmount(), o.getFeeAmount(), this::setFeeAmount);
			merger.mergeBasic(getFeeRate(), o.getFeeRate(), this::setFeeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmount=" + this.feeAmount + ", " +
				"feeRate=" + this.feeRate + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}';
		}
	}
}
