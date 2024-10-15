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
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1BuilderImpl;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Impl;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LoanContract;
import fpml.confirmation.meta.FacilityLoanContractDetailsModelChoice1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityLoanContractDetailsModelChoice1", builder=FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1BuilderImpl.class, version="${project.version}")
public interface FacilityLoanContractDetailsModelChoice1 extends RosettaModelObject {

	FacilityLoanContractDetailsModelChoice1Meta metaData = new FacilityLoanContractDetailsModelChoice1Meta();

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
	FacilityLoanContractDetailsModelChoice1 build();
	
	FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder toBuilder();
	
	static FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder builder() {
		return new FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityLoanContractDetailsModelChoice1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityLoanContractDetailsModelChoice1> getType() {
		return FacilityLoanContractDetailsModelChoice1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanContract"), processor, LoanContract.class, getLoanContract());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityLoanContractDetailsModelChoice1Builder extends FacilityLoanContractDetailsModelChoice1, RosettaModelObjectBuilder {
		LoanContract.LoanContractBuilder getOrCreateLoanContract();
		LoanContract.LoanContractBuilder getLoanContract();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit();
		LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit();
		FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder setLoanContract(LoanContract loanContract);
		FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder setLetterOfCredit(LetterOfCredit letterOfCredit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanContract"), processor, LoanContract.LoanContractBuilder.class, getLoanContract());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
		}
		

		FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder prune();
	}

	/*********************** Immutable Implementation of FacilityLoanContractDetailsModelChoice1  ***********************/
	class FacilityLoanContractDetailsModelChoice1Impl implements FacilityLoanContractDetailsModelChoice1 {
		private final LoanContract loanContract;
		private final LetterOfCredit letterOfCredit;
		
		protected FacilityLoanContractDetailsModelChoice1Impl(FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder builder) {
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
		public FacilityLoanContractDetailsModelChoice1 build() {
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder toBuilder() {
			FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder builder) {
			ofNullable(getLoanContract()).ifPresent(builder::setLoanContract);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityLoanContractDetailsModelChoice1 _that = getType().cast(o);
		
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
			return "FacilityLoanContractDetailsModelChoice1 {" +
				"loanContract=" + this.loanContract + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityLoanContractDetailsModelChoice1  ***********************/
	class FacilityLoanContractDetailsModelChoice1BuilderImpl implements FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder {
	
		protected LoanContract.LoanContractBuilder loanContract;
		protected LetterOfCredit.LetterOfCreditBuilder letterOfCredit;
	
		public FacilityLoanContractDetailsModelChoice1BuilderImpl() {
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
		public FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder setLoanContract(LoanContract loanContract) {
			this.loanContract = loanContract==null?null:loanContract.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCredit")
		public FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder setLetterOfCredit(LetterOfCredit letterOfCredit) {
			this.letterOfCredit = letterOfCredit==null?null:letterOfCredit.toBuilder();
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModelChoice1 build() {
			return new FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Impl(this);
		}
		
		@Override
		public FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder prune() {
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
		public FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder o = (FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder) other;
			
			merger.mergeRosetta(getLoanContract(), o.getLoanContract(), this::setLoanContract);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::setLetterOfCredit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityLoanContractDetailsModelChoice1 _that = getType().cast(o);
		
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
			return "FacilityLoanContractDetailsModelChoice1Builder {" +
				"loanContract=" + this.loanContract + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}
}
