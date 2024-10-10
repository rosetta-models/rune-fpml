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
import fpml.confirmation.Borrowing;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.InterestCapitalization;
import fpml.confirmation.LoanContractBaseRateSet;
import fpml.confirmation.LoanInterestPayment;
import fpml.confirmation.Repayment;
import fpml.confirmation.RolloverChoice;
import fpml.confirmation.RolloverChoice.RolloverChoiceBuilder;
import fpml.confirmation.RolloverChoice.RolloverChoiceBuilderImpl;
import fpml.confirmation.RolloverChoice.RolloverChoiceImpl;
import fpml.confirmation.meta.RolloverChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RolloverChoice", builder=RolloverChoice.RolloverChoiceBuilderImpl.class, version="${project.version}")
public interface RolloverChoice extends RosettaModelObject {

	RolloverChoiceMeta metaData = new RolloverChoiceMeta();

	/*********************** Getter Methods  ***********************/
	LoanContractBaseRateSet getBaseRateSet();
	Borrowing getBorrowing();
	CommitmentAdjustment getCommitmentAdjustment();
	InterestCapitalization getInterestCapitalization();
	LoanInterestPayment getInterestPayment();
	Repayment getRepayment();

	/*********************** Build Methods  ***********************/
	RolloverChoice build();
	
	RolloverChoice.RolloverChoiceBuilder toBuilder();
	
	static RolloverChoice.RolloverChoiceBuilder builder() {
		return new RolloverChoice.RolloverChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RolloverChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RolloverChoice> getType() {
		return RolloverChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("baseRateSet"), processor, LoanContractBaseRateSet.class, getBaseRateSet());
		processRosetta(path.newSubPath("borrowing"), processor, Borrowing.class, getBorrowing());
		processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.class, getCommitmentAdjustment());
		processRosetta(path.newSubPath("interestCapitalization"), processor, InterestCapitalization.class, getInterestCapitalization());
		processRosetta(path.newSubPath("interestPayment"), processor, LoanInterestPayment.class, getInterestPayment());
		processRosetta(path.newSubPath("repayment"), processor, Repayment.class, getRepayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RolloverChoiceBuilder extends RolloverChoice, RosettaModelObjectBuilder {
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder getOrCreateBaseRateSet();
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder getBaseRateSet();
		Borrowing.BorrowingBuilder getOrCreateBorrowing();
		Borrowing.BorrowingBuilder getBorrowing();
		CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment();
		CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment();
		InterestCapitalization.InterestCapitalizationBuilder getOrCreateInterestCapitalization();
		InterestCapitalization.InterestCapitalizationBuilder getInterestCapitalization();
		LoanInterestPayment.LoanInterestPaymentBuilder getOrCreateInterestPayment();
		LoanInterestPayment.LoanInterestPaymentBuilder getInterestPayment();
		Repayment.RepaymentBuilder getOrCreateRepayment();
		Repayment.RepaymentBuilder getRepayment();
		RolloverChoice.RolloverChoiceBuilder setBaseRateSet(LoanContractBaseRateSet baseRateSet);
		RolloverChoice.RolloverChoiceBuilder setBorrowing(Borrowing borrowing);
		RolloverChoice.RolloverChoiceBuilder setCommitmentAdjustment(CommitmentAdjustment commitmentAdjustment);
		RolloverChoice.RolloverChoiceBuilder setInterestCapitalization(InterestCapitalization interestCapitalization);
		RolloverChoice.RolloverChoiceBuilder setInterestPayment(LoanInterestPayment interestPayment);
		RolloverChoice.RolloverChoiceBuilder setRepayment(Repayment repayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("baseRateSet"), processor, LoanContractBaseRateSet.LoanContractBaseRateSetBuilder.class, getBaseRateSet());
			processRosetta(path.newSubPath("borrowing"), processor, Borrowing.BorrowingBuilder.class, getBorrowing());
			processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.CommitmentAdjustmentBuilder.class, getCommitmentAdjustment());
			processRosetta(path.newSubPath("interestCapitalization"), processor, InterestCapitalization.InterestCapitalizationBuilder.class, getInterestCapitalization());
			processRosetta(path.newSubPath("interestPayment"), processor, LoanInterestPayment.LoanInterestPaymentBuilder.class, getInterestPayment());
			processRosetta(path.newSubPath("repayment"), processor, Repayment.RepaymentBuilder.class, getRepayment());
		}
		

		RolloverChoice.RolloverChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of RolloverChoice  ***********************/
	class RolloverChoiceImpl implements RolloverChoice {
		private final LoanContractBaseRateSet baseRateSet;
		private final Borrowing borrowing;
		private final CommitmentAdjustment commitmentAdjustment;
		private final InterestCapitalization interestCapitalization;
		private final LoanInterestPayment interestPayment;
		private final Repayment repayment;
		
		protected RolloverChoiceImpl(RolloverChoice.RolloverChoiceBuilder builder) {
			this.baseRateSet = ofNullable(builder.getBaseRateSet()).map(f->f.build()).orElse(null);
			this.borrowing = ofNullable(builder.getBorrowing()).map(f->f.build()).orElse(null);
			this.commitmentAdjustment = ofNullable(builder.getCommitmentAdjustment()).map(f->f.build()).orElse(null);
			this.interestCapitalization = ofNullable(builder.getInterestCapitalization()).map(f->f.build()).orElse(null);
			this.interestPayment = ofNullable(builder.getInterestPayment()).map(f->f.build()).orElse(null);
			this.repayment = ofNullable(builder.getRepayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("baseRateSet")
		public LoanContractBaseRateSet getBaseRateSet() {
			return baseRateSet;
		}
		
		@Override
		@RosettaAttribute("borrowing")
		public Borrowing getBorrowing() {
			return borrowing;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public CommitmentAdjustment getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		@RosettaAttribute("interestCapitalization")
		public InterestCapitalization getInterestCapitalization() {
			return interestCapitalization;
		}
		
		@Override
		@RosettaAttribute("interestPayment")
		public LoanInterestPayment getInterestPayment() {
			return interestPayment;
		}
		
		@Override
		@RosettaAttribute("repayment")
		public Repayment getRepayment() {
			return repayment;
		}
		
		@Override
		public RolloverChoice build() {
			return this;
		}
		
		@Override
		public RolloverChoice.RolloverChoiceBuilder toBuilder() {
			RolloverChoice.RolloverChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RolloverChoice.RolloverChoiceBuilder builder) {
			ofNullable(getBaseRateSet()).ifPresent(builder::setBaseRateSet);
			ofNullable(getBorrowing()).ifPresent(builder::setBorrowing);
			ofNullable(getCommitmentAdjustment()).ifPresent(builder::setCommitmentAdjustment);
			ofNullable(getInterestCapitalization()).ifPresent(builder::setInterestCapitalization);
			ofNullable(getInterestPayment()).ifPresent(builder::setInterestPayment);
			ofNullable(getRepayment()).ifPresent(builder::setRepayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RolloverChoice _that = getType().cast(o);
		
			if (!Objects.equals(baseRateSet, _that.getBaseRateSet())) return false;
			if (!Objects.equals(borrowing, _that.getBorrowing())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			if (!Objects.equals(interestCapitalization, _that.getInterestCapitalization())) return false;
			if (!Objects.equals(interestPayment, _that.getInterestPayment())) return false;
			if (!Objects.equals(repayment, _that.getRepayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseRateSet != null ? baseRateSet.hashCode() : 0);
			_result = 31 * _result + (borrowing != null ? borrowing.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			_result = 31 * _result + (interestCapitalization != null ? interestCapitalization.hashCode() : 0);
			_result = 31 * _result + (interestPayment != null ? interestPayment.hashCode() : 0);
			_result = 31 * _result + (repayment != null ? repayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RolloverChoice {" +
				"baseRateSet=" + this.baseRateSet + ", " +
				"borrowing=" + this.borrowing + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment + ", " +
				"interestCapitalization=" + this.interestCapitalization + ", " +
				"interestPayment=" + this.interestPayment + ", " +
				"repayment=" + this.repayment +
			'}';
		}
	}

	/*********************** Builder Implementation of RolloverChoice  ***********************/
	class RolloverChoiceBuilderImpl implements RolloverChoice.RolloverChoiceBuilder {
	
		protected LoanContractBaseRateSet.LoanContractBaseRateSetBuilder baseRateSet;
		protected Borrowing.BorrowingBuilder borrowing;
		protected CommitmentAdjustment.CommitmentAdjustmentBuilder commitmentAdjustment;
		protected InterestCapitalization.InterestCapitalizationBuilder interestCapitalization;
		protected LoanInterestPayment.LoanInterestPaymentBuilder interestPayment;
		protected Repayment.RepaymentBuilder repayment;
	
		public RolloverChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("baseRateSet")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder getBaseRateSet() {
			return baseRateSet;
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder getOrCreateBaseRateSet() {
			LoanContractBaseRateSet.LoanContractBaseRateSetBuilder result;
			if (baseRateSet!=null) {
				result = baseRateSet;
			}
			else {
				result = baseRateSet = LoanContractBaseRateSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowing")
		public Borrowing.BorrowingBuilder getBorrowing() {
			return borrowing;
		}
		
		@Override
		public Borrowing.BorrowingBuilder getOrCreateBorrowing() {
			Borrowing.BorrowingBuilder result;
			if (borrowing!=null) {
				result = borrowing;
			}
			else {
				result = borrowing = Borrowing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment() {
			CommitmentAdjustment.CommitmentAdjustmentBuilder result;
			if (commitmentAdjustment!=null) {
				result = commitmentAdjustment;
			}
			else {
				result = commitmentAdjustment = CommitmentAdjustment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestCapitalization")
		public InterestCapitalization.InterestCapitalizationBuilder getInterestCapitalization() {
			return interestCapitalization;
		}
		
		@Override
		public InterestCapitalization.InterestCapitalizationBuilder getOrCreateInterestCapitalization() {
			InterestCapitalization.InterestCapitalizationBuilder result;
			if (interestCapitalization!=null) {
				result = interestCapitalization;
			}
			else {
				result = interestCapitalization = InterestCapitalization.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestPayment")
		public LoanInterestPayment.LoanInterestPaymentBuilder getInterestPayment() {
			return interestPayment;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder getOrCreateInterestPayment() {
			LoanInterestPayment.LoanInterestPaymentBuilder result;
			if (interestPayment!=null) {
				result = interestPayment;
			}
			else {
				result = interestPayment = LoanInterestPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("repayment")
		public Repayment.RepaymentBuilder getRepayment() {
			return repayment;
		}
		
		@Override
		public Repayment.RepaymentBuilder getOrCreateRepayment() {
			Repayment.RepaymentBuilder result;
			if (repayment!=null) {
				result = repayment;
			}
			else {
				result = repayment = Repayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("baseRateSet")
		public RolloverChoice.RolloverChoiceBuilder setBaseRateSet(LoanContractBaseRateSet baseRateSet) {
			this.baseRateSet = baseRateSet==null?null:baseRateSet.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("borrowing")
		public RolloverChoice.RolloverChoiceBuilder setBorrowing(Borrowing borrowing) {
			this.borrowing = borrowing==null?null:borrowing.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public RolloverChoice.RolloverChoiceBuilder setCommitmentAdjustment(CommitmentAdjustment commitmentAdjustment) {
			this.commitmentAdjustment = commitmentAdjustment==null?null:commitmentAdjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestCapitalization")
		public RolloverChoice.RolloverChoiceBuilder setInterestCapitalization(InterestCapitalization interestCapitalization) {
			this.interestCapitalization = interestCapitalization==null?null:interestCapitalization.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestPayment")
		public RolloverChoice.RolloverChoiceBuilder setInterestPayment(LoanInterestPayment interestPayment) {
			this.interestPayment = interestPayment==null?null:interestPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("repayment")
		public RolloverChoice.RolloverChoiceBuilder setRepayment(Repayment repayment) {
			this.repayment = repayment==null?null:repayment.toBuilder();
			return this;
		}
		
		@Override
		public RolloverChoice build() {
			return new RolloverChoice.RolloverChoiceImpl(this);
		}
		
		@Override
		public RolloverChoice.RolloverChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RolloverChoice.RolloverChoiceBuilder prune() {
			if (baseRateSet!=null && !baseRateSet.prune().hasData()) baseRateSet = null;
			if (borrowing!=null && !borrowing.prune().hasData()) borrowing = null;
			if (commitmentAdjustment!=null && !commitmentAdjustment.prune().hasData()) commitmentAdjustment = null;
			if (interestCapitalization!=null && !interestCapitalization.prune().hasData()) interestCapitalization = null;
			if (interestPayment!=null && !interestPayment.prune().hasData()) interestPayment = null;
			if (repayment!=null && !repayment.prune().hasData()) repayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBaseRateSet()!=null && getBaseRateSet().hasData()) return true;
			if (getBorrowing()!=null && getBorrowing().hasData()) return true;
			if (getCommitmentAdjustment()!=null && getCommitmentAdjustment().hasData()) return true;
			if (getInterestCapitalization()!=null && getInterestCapitalization().hasData()) return true;
			if (getInterestPayment()!=null && getInterestPayment().hasData()) return true;
			if (getRepayment()!=null && getRepayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RolloverChoice.RolloverChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RolloverChoice.RolloverChoiceBuilder o = (RolloverChoice.RolloverChoiceBuilder) other;
			
			merger.mergeRosetta(getBaseRateSet(), o.getBaseRateSet(), this::setBaseRateSet);
			merger.mergeRosetta(getBorrowing(), o.getBorrowing(), this::setBorrowing);
			merger.mergeRosetta(getCommitmentAdjustment(), o.getCommitmentAdjustment(), this::setCommitmentAdjustment);
			merger.mergeRosetta(getInterestCapitalization(), o.getInterestCapitalization(), this::setInterestCapitalization);
			merger.mergeRosetta(getInterestPayment(), o.getInterestPayment(), this::setInterestPayment);
			merger.mergeRosetta(getRepayment(), o.getRepayment(), this::setRepayment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RolloverChoice _that = getType().cast(o);
		
			if (!Objects.equals(baseRateSet, _that.getBaseRateSet())) return false;
			if (!Objects.equals(borrowing, _that.getBorrowing())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			if (!Objects.equals(interestCapitalization, _that.getInterestCapitalization())) return false;
			if (!Objects.equals(interestPayment, _that.getInterestPayment())) return false;
			if (!Objects.equals(repayment, _that.getRepayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseRateSet != null ? baseRateSet.hashCode() : 0);
			_result = 31 * _result + (borrowing != null ? borrowing.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			_result = 31 * _result + (interestCapitalization != null ? interestCapitalization.hashCode() : 0);
			_result = 31 * _result + (interestPayment != null ? interestPayment.hashCode() : 0);
			_result = 31 * _result + (repayment != null ? repayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RolloverChoiceBuilder {" +
				"baseRateSet=" + this.baseRateSet + ", " +
				"borrowing=" + this.borrowing + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment + ", " +
				"interestCapitalization=" + this.interestCapitalization + ", " +
				"interestPayment=" + this.interestPayment + ", " +
				"repayment=" + this.repayment +
			'}';
		}
	}
}
