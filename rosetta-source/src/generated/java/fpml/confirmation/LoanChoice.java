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
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.LoanChoice;
import fpml.confirmation.LoanChoice.LoanChoiceBuilder;
import fpml.confirmation.LoanChoice.LoanChoiceBuilderImpl;
import fpml.confirmation.LoanChoice.LoanChoiceImpl;
import fpml.confirmation.meta.LoanChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LoanChoice", builder=LoanChoice.LoanChoiceBuilderImpl.class, version="${project.version}")
public interface LoanChoice extends RosettaModelObject {

	LoanChoiceMeta metaData = new LoanChoiceMeta();

	/*********************** Getter Methods  ***********************/
	LegalEntity getBorrower();
	LegalEntityReference getBorrowerReference();

	/*********************** Build Methods  ***********************/
	LoanChoice build();
	
	LoanChoice.LoanChoiceBuilder toBuilder();
	
	static LoanChoice.LoanChoiceBuilder builder() {
		return new LoanChoice.LoanChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanChoice> getType() {
		return LoanChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("borrower"), processor, LegalEntity.class, getBorrower());
		processRosetta(path.newSubPath("borrowerReference"), processor, LegalEntityReference.class, getBorrowerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanChoiceBuilder extends LoanChoice, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateBorrower();
		LegalEntity.LegalEntityBuilder getBorrower();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreateBorrowerReference();
		LegalEntityReference.LegalEntityReferenceBuilder getBorrowerReference();
		LoanChoice.LoanChoiceBuilder setBorrower(LegalEntity borrower);
		LoanChoice.LoanChoiceBuilder setBorrowerReference(LegalEntityReference borrowerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("borrower"), processor, LegalEntity.LegalEntityBuilder.class, getBorrower());
			processRosetta(path.newSubPath("borrowerReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getBorrowerReference());
		}
		

		LoanChoice.LoanChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanChoice  ***********************/
	class LoanChoiceImpl implements LoanChoice {
		private final LegalEntity borrower;
		private final LegalEntityReference borrowerReference;
		
		protected LoanChoiceImpl(LoanChoice.LoanChoiceBuilder builder) {
			this.borrower = ofNullable(builder.getBorrower()).map(f->f.build()).orElse(null);
			this.borrowerReference = ofNullable(builder.getBorrowerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("borrower")
		public LegalEntity getBorrower() {
			return borrower;
		}
		
		@Override
		@RosettaAttribute("borrowerReference")
		public LegalEntityReference getBorrowerReference() {
			return borrowerReference;
		}
		
		@Override
		public LoanChoice build() {
			return this;
		}
		
		@Override
		public LoanChoice.LoanChoiceBuilder toBuilder() {
			LoanChoice.LoanChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanChoice.LoanChoiceBuilder builder) {
			ofNullable(getBorrower()).ifPresent(builder::setBorrower);
			ofNullable(getBorrowerReference()).ifPresent(builder::setBorrowerReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanChoice _that = getType().cast(o);
		
			if (!Objects.equals(borrower, _that.getBorrower())) return false;
			if (!Objects.equals(borrowerReference, _that.getBorrowerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (borrower != null ? borrower.hashCode() : 0);
			_result = 31 * _result + (borrowerReference != null ? borrowerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanChoice {" +
				"borrower=" + this.borrower + ", " +
				"borrowerReference=" + this.borrowerReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanChoice  ***********************/
	class LoanChoiceBuilderImpl implements LoanChoice.LoanChoiceBuilder {
	
		protected LegalEntity.LegalEntityBuilder borrower;
		protected LegalEntityReference.LegalEntityReferenceBuilder borrowerReference;
	
		public LoanChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("borrower")
		public LegalEntity.LegalEntityBuilder getBorrower() {
			return borrower;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateBorrower() {
			LegalEntity.LegalEntityBuilder result;
			if (borrower!=null) {
				result = borrower;
			}
			else {
				result = borrower = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getBorrowerReference() {
			return borrowerReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreateBorrowerReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (borrowerReference!=null) {
				result = borrowerReference;
			}
			else {
				result = borrowerReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrower")
		public LoanChoice.LoanChoiceBuilder setBorrower(LegalEntity borrower) {
			this.borrower = borrower==null?null:borrower.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("borrowerReference")
		public LoanChoice.LoanChoiceBuilder setBorrowerReference(LegalEntityReference borrowerReference) {
			this.borrowerReference = borrowerReference==null?null:borrowerReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanChoice build() {
			return new LoanChoice.LoanChoiceImpl(this);
		}
		
		@Override
		public LoanChoice.LoanChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanChoice.LoanChoiceBuilder prune() {
			if (borrower!=null && !borrower.prune().hasData()) borrower = null;
			if (borrowerReference!=null && !borrowerReference.prune().hasData()) borrowerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBorrower()!=null && getBorrower().hasData()) return true;
			if (getBorrowerReference()!=null && getBorrowerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanChoice.LoanChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanChoice.LoanChoiceBuilder o = (LoanChoice.LoanChoiceBuilder) other;
			
			merger.mergeRosetta(getBorrower(), o.getBorrower(), this::setBorrower);
			merger.mergeRosetta(getBorrowerReference(), o.getBorrowerReference(), this::setBorrowerReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanChoice _that = getType().cast(o);
		
			if (!Objects.equals(borrower, _that.getBorrower())) return false;
			if (!Objects.equals(borrowerReference, _that.getBorrowerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (borrower != null ? borrower.hashCode() : 0);
			_result = 31 * _result + (borrowerReference != null ? borrowerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanChoiceBuilder {" +
				"borrower=" + this.borrower + ", " +
				"borrowerReference=" + this.borrowerReference +
			'}';
		}
	}
}
