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
import fpml.confirmation.ContractIdentifier;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0BuilderImpl;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Impl;
import fpml.confirmation.meta.FacilityLoanContractDetailsModelChoice0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityLoanContractDetailsModelChoice0", builder=FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0BuilderImpl.class, version="${project.version}")
public interface FacilityLoanContractDetailsModelChoice0 extends RosettaModelObject {

	FacilityLoanContractDetailsModelChoice0Meta metaData = new FacilityLoanContractDetailsModelChoice0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A collection of loan contracts.
	 */
	ContractIdentifier getLoanContractIdentifier();
	/**
	 * A collection of letter of credits.
	 */
	ContractIdentifier getLetterOfCreditIdentifier();

	/*********************** Build Methods  ***********************/
	FacilityLoanContractDetailsModelChoice0 build();
	
	FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder toBuilder();
	
	static FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder builder() {
		return new FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityLoanContractDetailsModelChoice0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityLoanContractDetailsModelChoice0> getType() {
		return FacilityLoanContractDetailsModelChoice0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanContractIdentifier"), processor, ContractIdentifier.class, getLoanContractIdentifier());
		processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, ContractIdentifier.class, getLetterOfCreditIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityLoanContractDetailsModelChoice0Builder extends FacilityLoanContractDetailsModelChoice0, RosettaModelObjectBuilder {
		ContractIdentifier.ContractIdentifierBuilder getOrCreateLoanContractIdentifier();
		ContractIdentifier.ContractIdentifierBuilder getLoanContractIdentifier();
		ContractIdentifier.ContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier();
		ContractIdentifier.ContractIdentifierBuilder getLetterOfCreditIdentifier();
		FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder setLoanContractIdentifier(ContractIdentifier loanContractIdentifier);
		FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder setLetterOfCreditIdentifier(ContractIdentifier letterOfCreditIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanContractIdentifier"), processor, ContractIdentifier.ContractIdentifierBuilder.class, getLoanContractIdentifier());
			processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, ContractIdentifier.ContractIdentifierBuilder.class, getLetterOfCreditIdentifier());
		}
		

		FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder prune();
	}

	/*********************** Immutable Implementation of FacilityLoanContractDetailsModelChoice0  ***********************/
	class FacilityLoanContractDetailsModelChoice0Impl implements FacilityLoanContractDetailsModelChoice0 {
		private final ContractIdentifier loanContractIdentifier;
		private final ContractIdentifier letterOfCreditIdentifier;
		
		protected FacilityLoanContractDetailsModelChoice0Impl(FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder builder) {
			this.loanContractIdentifier = ofNullable(builder.getLoanContractIdentifier()).map(f->f.build()).orElse(null);
			this.letterOfCreditIdentifier = ofNullable(builder.getLetterOfCreditIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractIdentifier")
		public ContractIdentifier getLoanContractIdentifier() {
			return loanContractIdentifier;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		public ContractIdentifier getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		public FacilityLoanContractDetailsModelChoice0 build() {
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder toBuilder() {
			FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder builder) {
			ofNullable(getLoanContractIdentifier()).ifPresent(builder::setLoanContractIdentifier);
			ofNullable(getLetterOfCreditIdentifier()).ifPresent(builder::setLetterOfCreditIdentifier);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityLoanContractDetailsModelChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(loanContractIdentifier, _that.getLoanContractIdentifier())) return false;
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContractIdentifier != null ? loanContractIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityLoanContractDetailsModelChoice0 {" +
				"loanContractIdentifier=" + this.loanContractIdentifier + ", " +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityLoanContractDetailsModelChoice0  ***********************/
	class FacilityLoanContractDetailsModelChoice0BuilderImpl implements FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder {
	
		protected ContractIdentifier.ContractIdentifierBuilder loanContractIdentifier;
		protected ContractIdentifier.ContractIdentifierBuilder letterOfCreditIdentifier;
	
		public FacilityLoanContractDetailsModelChoice0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanContractIdentifier")
		public ContractIdentifier.ContractIdentifierBuilder getLoanContractIdentifier() {
			return loanContractIdentifier;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder getOrCreateLoanContractIdentifier() {
			ContractIdentifier.ContractIdentifierBuilder result;
			if (loanContractIdentifier!=null) {
				result = loanContractIdentifier;
			}
			else {
				result = loanContractIdentifier = ContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		public ContractIdentifier.ContractIdentifierBuilder getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier() {
			ContractIdentifier.ContractIdentifierBuilder result;
			if (letterOfCreditIdentifier!=null) {
				result = letterOfCreditIdentifier;
			}
			else {
				result = letterOfCreditIdentifier = ContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractIdentifier")
		public FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder setLoanContractIdentifier(ContractIdentifier loanContractIdentifier) {
			this.loanContractIdentifier = loanContractIdentifier==null?null:loanContractIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		public FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder setLetterOfCreditIdentifier(ContractIdentifier letterOfCreditIdentifier) {
			this.letterOfCreditIdentifier = letterOfCreditIdentifier==null?null:letterOfCreditIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModelChoice0 build() {
			return new FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Impl(this);
		}
		
		@Override
		public FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder prune() {
			if (loanContractIdentifier!=null && !loanContractIdentifier.prune().hasData()) loanContractIdentifier = null;
			if (letterOfCreditIdentifier!=null && !letterOfCreditIdentifier.prune().hasData()) letterOfCreditIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanContractIdentifier()!=null && getLoanContractIdentifier().hasData()) return true;
			if (getLetterOfCreditIdentifier()!=null && getLetterOfCreditIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder o = (FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder) other;
			
			merger.mergeRosetta(getLoanContractIdentifier(), o.getLoanContractIdentifier(), this::setLoanContractIdentifier);
			merger.mergeRosetta(getLetterOfCreditIdentifier(), o.getLetterOfCreditIdentifier(), this::setLetterOfCreditIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityLoanContractDetailsModelChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(loanContractIdentifier, _that.getLoanContractIdentifier())) return false;
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContractIdentifier != null ? loanContractIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityLoanContractDetailsModelChoice0Builder {" +
				"loanContractIdentifier=" + this.loanContractIdentifier + ", " +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier +
			'}';
		}
	}
}
