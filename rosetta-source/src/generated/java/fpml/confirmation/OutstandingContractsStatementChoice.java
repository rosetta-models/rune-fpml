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
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LoanContract;
import fpml.confirmation.OutstandingContractsStatementChoice;
import fpml.confirmation.OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder;
import fpml.confirmation.OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilderImpl;
import fpml.confirmation.OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceImpl;
import fpml.confirmation.meta.OutstandingContractsStatementChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OutstandingContractsStatementChoice", builder=OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilderImpl.class, version="${project.version}")
public interface OutstandingContractsStatementChoice extends RosettaModelObject {

	OutstandingContractsStatementChoiceMeta metaData = new OutstandingContractsStatementChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A collection of loan contracts.
	 */
	LoanContract getLoanContract();
	/**
	 * A collection of letter of credits.
	 */
	LetterOfCredit getLetterOfCredit();

	/*********************** Build Methods  ***********************/
	OutstandingContractsStatementChoice build();
	
	OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder toBuilder();
	
	static OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder builder() {
		return new OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OutstandingContractsStatementChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OutstandingContractsStatementChoice> getType() {
		return OutstandingContractsStatementChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanContract"), processor, LoanContract.class, getLoanContract());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OutstandingContractsStatementChoiceBuilder extends OutstandingContractsStatementChoice, RosettaModelObjectBuilder {
		LoanContract.LoanContractBuilder getOrCreateLoanContract();
		LoanContract.LoanContractBuilder getLoanContract();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit();
		LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit();
		OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder setLoanContract(LoanContract loanContract);
		OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder setLetterOfCredit(LetterOfCredit letterOfCredit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanContract"), processor, LoanContract.LoanContractBuilder.class, getLoanContract());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
		}
		

		OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of OutstandingContractsStatementChoice  ***********************/
	class OutstandingContractsStatementChoiceImpl implements OutstandingContractsStatementChoice {
		private final LoanContract loanContract;
		private final LetterOfCredit letterOfCredit;
		
		protected OutstandingContractsStatementChoiceImpl(OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder builder) {
			this.loanContract = ofNullable(builder.getLoanContract()).map(f->f.build()).orElse(null);
			this.letterOfCredit = ofNullable(builder.getLetterOfCredit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContract")
		public LoanContract getLoanContract() {
			return loanContract;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		public LetterOfCredit getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		public OutstandingContractsStatementChoice build() {
			return this;
		}
		
		@Override
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder toBuilder() {
			OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder builder) {
			ofNullable(getLoanContract()).ifPresent(builder::setLoanContract);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OutstandingContractsStatementChoice _that = getType().cast(o);
		
			if (!Objects.equals(loanContract, _that.getLoanContract())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContract != null ? loanContract.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingContractsStatementChoice {" +
				"loanContract=" + this.loanContract + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}

	/*********************** Builder Implementation of OutstandingContractsStatementChoice  ***********************/
	class OutstandingContractsStatementChoiceBuilderImpl implements OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder {
	
		protected LoanContract.LoanContractBuilder loanContract;
		protected LetterOfCredit.LetterOfCreditBuilder letterOfCredit;
	
		public OutstandingContractsStatementChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanContract")
		public LoanContract.LoanContractBuilder getLoanContract() {
			return loanContract;
		}
		
		@Override
		public LoanContract.LoanContractBuilder getOrCreateLoanContract() {
			LoanContract.LoanContractBuilder result;
			if (loanContract!=null) {
				result = loanContract;
			}
			else {
				result = loanContract = LoanContract.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		public LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit() {
			LetterOfCredit.LetterOfCreditBuilder result;
			if (letterOfCredit!=null) {
				result = letterOfCredit;
			}
			else {
				result = letterOfCredit = LetterOfCredit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContract")
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder setLoanContract(LoanContract loanContract) {
			this.loanContract = loanContract==null?null:loanContract.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCredit")
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder setLetterOfCredit(LetterOfCredit letterOfCredit) {
			this.letterOfCredit = letterOfCredit==null?null:letterOfCredit.toBuilder();
			return this;
		}
		
		@Override
		public OutstandingContractsStatementChoice build() {
			return new OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceImpl(this);
		}
		
		@Override
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder prune() {
			if (loanContract!=null && !loanContract.prune().hasData()) loanContract = null;
			if (letterOfCredit!=null && !letterOfCredit.prune().hasData()) letterOfCredit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanContract()!=null && getLoanContract().hasData()) return true;
			if (getLetterOfCredit()!=null && getLetterOfCredit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder o = (OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder) other;
			
			merger.mergeRosetta(getLoanContract(), o.getLoanContract(), this::setLoanContract);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::setLetterOfCredit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OutstandingContractsStatementChoice _that = getType().cast(o);
		
			if (!Objects.equals(loanContract, _that.getLoanContract())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContract != null ? loanContract.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingContractsStatementChoiceBuilder {" +
				"loanContract=" + this.loanContract + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}
}
