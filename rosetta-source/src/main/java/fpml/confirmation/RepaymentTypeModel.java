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
import fpml.confirmation.RepaymentTypeModel;
import fpml.confirmation.RepaymentTypeModel.RepaymentTypeModelBuilder;
import fpml.confirmation.RepaymentTypeModel.RepaymentTypeModelBuilderImpl;
import fpml.confirmation.RepaymentTypeModel.RepaymentTypeModelImpl;
import fpml.confirmation.meta.RepaymentTypeModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that establishes the flags that determine the type of repayment that is occurring and the flexibility asociated with it (from the lender&#39;s perspective).
 * @version ${project.version}
 */
@RosettaDataType(value="RepaymentTypeModel", builder=RepaymentTypeModel.RepaymentTypeModelBuilderImpl.class, version="${project.version}")
public interface RepaymentTypeModel extends RosettaModelObject {

	RepaymentTypeModelMeta metaData = new RepaymentTypeModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines whether the lender has an option to accept or deny the payment.
	 */
	Boolean getRefusalAllowed();
	/**
	 * Defines whether the repayment is mandatory from the borrower&#39;s perspective, based on the (amortization) schedule on the credit agreement.
	 */
	Boolean getBorrowerMandatory();
	/**
	 * Defines whether the repayment is a scheduled repayment. This is normally the case when the repayment is defined on the amortization schedule associated with the facility (on the credit agreement).
	 */
	Boolean getScheduledRepayment();

	/*********************** Build Methods  ***********************/
	RepaymentTypeModel build();
	
	RepaymentTypeModel.RepaymentTypeModelBuilder toBuilder();
	
	static RepaymentTypeModel.RepaymentTypeModelBuilder builder() {
		return new RepaymentTypeModel.RepaymentTypeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepaymentTypeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RepaymentTypeModel> getType() {
		return RepaymentTypeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
		processor.processBasic(path.newSubPath("borrowerMandatory"), Boolean.class, getBorrowerMandatory(), this);
		processor.processBasic(path.newSubPath("scheduledRepayment"), Boolean.class, getScheduledRepayment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepaymentTypeModelBuilder extends RepaymentTypeModel, RosettaModelObjectBuilder {
		RepaymentTypeModel.RepaymentTypeModelBuilder setRefusalAllowed(Boolean refusalAllowed);
		RepaymentTypeModel.RepaymentTypeModelBuilder setBorrowerMandatory(Boolean borrowerMandatory);
		RepaymentTypeModel.RepaymentTypeModelBuilder setScheduledRepayment(Boolean scheduledRepayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
			processor.processBasic(path.newSubPath("borrowerMandatory"), Boolean.class, getBorrowerMandatory(), this);
			processor.processBasic(path.newSubPath("scheduledRepayment"), Boolean.class, getScheduledRepayment(), this);
		}
		

		RepaymentTypeModel.RepaymentTypeModelBuilder prune();
	}

	/*********************** Immutable Implementation of RepaymentTypeModel  ***********************/
	class RepaymentTypeModelImpl implements RepaymentTypeModel {
		private final Boolean refusalAllowed;
		private final Boolean borrowerMandatory;
		private final Boolean scheduledRepayment;
		
		protected RepaymentTypeModelImpl(RepaymentTypeModel.RepaymentTypeModelBuilder builder) {
			this.refusalAllowed = builder.getRefusalAllowed();
			this.borrowerMandatory = builder.getBorrowerMandatory();
			this.scheduledRepayment = builder.getScheduledRepayment();
		}
		
		@Override
		@RosettaAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("borrowerMandatory")
		public Boolean getBorrowerMandatory() {
			return borrowerMandatory;
		}
		
		@Override
		@RosettaAttribute("scheduledRepayment")
		public Boolean getScheduledRepayment() {
			return scheduledRepayment;
		}
		
		@Override
		public RepaymentTypeModel build() {
			return this;
		}
		
		@Override
		public RepaymentTypeModel.RepaymentTypeModelBuilder toBuilder() {
			RepaymentTypeModel.RepaymentTypeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepaymentTypeModel.RepaymentTypeModelBuilder builder) {
			ofNullable(getRefusalAllowed()).ifPresent(builder::setRefusalAllowed);
			ofNullable(getBorrowerMandatory()).ifPresent(builder::setBorrowerMandatory);
			ofNullable(getScheduledRepayment()).ifPresent(builder::setScheduledRepayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepaymentTypeModel _that = getType().cast(o);
		
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(borrowerMandatory, _that.getBorrowerMandatory())) return false;
			if (!Objects.equals(scheduledRepayment, _that.getScheduledRepayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (borrowerMandatory != null ? borrowerMandatory.hashCode() : 0);
			_result = 31 * _result + (scheduledRepayment != null ? scheduledRepayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepaymentTypeModel {" +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"borrowerMandatory=" + this.borrowerMandatory + ", " +
				"scheduledRepayment=" + this.scheduledRepayment +
			'}';
		}
	}

	/*********************** Builder Implementation of RepaymentTypeModel  ***********************/
	class RepaymentTypeModelBuilderImpl implements RepaymentTypeModel.RepaymentTypeModelBuilder {
	
		protected Boolean refusalAllowed;
		protected Boolean borrowerMandatory;
		protected Boolean scheduledRepayment;
	
		public RepaymentTypeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("borrowerMandatory")
		public Boolean getBorrowerMandatory() {
			return borrowerMandatory;
		}
		
		@Override
		@RosettaAttribute("scheduledRepayment")
		public Boolean getScheduledRepayment() {
			return scheduledRepayment;
		}
		
		@Override
		@RosettaAttribute("refusalAllowed")
		public RepaymentTypeModel.RepaymentTypeModelBuilder setRefusalAllowed(Boolean refusalAllowed) {
			this.refusalAllowed = refusalAllowed==null?null:refusalAllowed;
			return this;
		}
		@Override
		@RosettaAttribute("borrowerMandatory")
		public RepaymentTypeModel.RepaymentTypeModelBuilder setBorrowerMandatory(Boolean borrowerMandatory) {
			this.borrowerMandatory = borrowerMandatory==null?null:borrowerMandatory;
			return this;
		}
		@Override
		@RosettaAttribute("scheduledRepayment")
		public RepaymentTypeModel.RepaymentTypeModelBuilder setScheduledRepayment(Boolean scheduledRepayment) {
			this.scheduledRepayment = scheduledRepayment==null?null:scheduledRepayment;
			return this;
		}
		
		@Override
		public RepaymentTypeModel build() {
			return new RepaymentTypeModel.RepaymentTypeModelImpl(this);
		}
		
		@Override
		public RepaymentTypeModel.RepaymentTypeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepaymentTypeModel.RepaymentTypeModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRefusalAllowed()!=null) return true;
			if (getBorrowerMandatory()!=null) return true;
			if (getScheduledRepayment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepaymentTypeModel.RepaymentTypeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RepaymentTypeModel.RepaymentTypeModelBuilder o = (RepaymentTypeModel.RepaymentTypeModelBuilder) other;
			
			
			merger.mergeBasic(getRefusalAllowed(), o.getRefusalAllowed(), this::setRefusalAllowed);
			merger.mergeBasic(getBorrowerMandatory(), o.getBorrowerMandatory(), this::setBorrowerMandatory);
			merger.mergeBasic(getScheduledRepayment(), o.getScheduledRepayment(), this::setScheduledRepayment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepaymentTypeModel _that = getType().cast(o);
		
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(borrowerMandatory, _that.getBorrowerMandatory())) return false;
			if (!Objects.equals(scheduledRepayment, _that.getScheduledRepayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (borrowerMandatory != null ? borrowerMandatory.hashCode() : 0);
			_result = 31 * _result + (scheduledRepayment != null ? scheduledRepayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepaymentTypeModelBuilder {" +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"borrowerMandatory=" + this.borrowerMandatory + ", " +
				"scheduledRepayment=" + this.scheduledRepayment +
			'}';
		}
	}
}
