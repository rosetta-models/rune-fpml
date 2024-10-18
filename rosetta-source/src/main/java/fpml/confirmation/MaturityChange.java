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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractMaturityChange;
import fpml.confirmation.LoanContractMaturityChange.LoanContractMaturityChangeBuilder;
import fpml.confirmation.LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl;
import fpml.confirmation.LoanContractMaturityChange.LoanContractMaturityChangeImpl;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MaturityChange;
import fpml.confirmation.MaturityChange.MaturityChangeBuilder;
import fpml.confirmation.MaturityChange.MaturityChangeBuilderImpl;
import fpml.confirmation.MaturityChange.MaturityChangeImpl;
import fpml.confirmation.meta.MaturityChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="MaturityChange", builder=MaturityChange.MaturityChangeBuilderImpl.class, version="${project.version}")
public interface MaturityChange extends LoanContractMaturityChange {

	MaturityChangeMeta metaData = new MaturityChangeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MaturityChange build();
	
	MaturityChange.MaturityChangeBuilder toBuilder();
	
	static MaturityChange.MaturityChangeBuilder builder() {
		return new MaturityChange.MaturityChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MaturityChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MaturityChange> getType() {
		return MaturityChange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processor.processBasic(path.newSubPath("currentMaturityDate"), Date.class, getCurrentMaturityDate(), this);
		processor.processBasic(path.newSubPath("priorMaturityDate"), Date.class, getPriorMaturityDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MaturityChangeBuilder extends MaturityChange, LoanContractMaturityChange.LoanContractMaturityChangeBuilder {
		MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		MaturityChange.MaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		MaturityChange.MaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		MaturityChange.MaturityChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		MaturityChange.MaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		MaturityChange.MaturityChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		MaturityChange.MaturityChangeBuilder setComment(String comment);
		MaturityChange.MaturityChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		MaturityChange.MaturityChangeBuilder setEffectiveDate(Date effectiveDate);
		MaturityChange.MaturityChangeBuilder setLoanContractReference(LoanContractReference loanContractReference);
		MaturityChange.MaturityChangeBuilder setCurrentMaturityDate(Date currentMaturityDate);
		MaturityChange.MaturityChangeBuilder setPriorMaturityDate(Date priorMaturityDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processor.processBasic(path.newSubPath("currentMaturityDate"), Date.class, getCurrentMaturityDate(), this);
			processor.processBasic(path.newSubPath("priorMaturityDate"), Date.class, getPriorMaturityDate(), this);
		}
		

		MaturityChange.MaturityChangeBuilder prune();
	}

	/*********************** Immutable Implementation of MaturityChange  ***********************/
	class MaturityChangeImpl extends LoanContractMaturityChange.LoanContractMaturityChangeImpl implements MaturityChange {
		
		protected MaturityChangeImpl(MaturityChange.MaturityChangeBuilder builder) {
			super(builder);
		}
		
		@Override
		public MaturityChange build() {
			return this;
		}
		
		@Override
		public MaturityChange.MaturityChangeBuilder toBuilder() {
			MaturityChange.MaturityChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MaturityChange.MaturityChangeBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityChange {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MaturityChange  ***********************/
	class MaturityChangeBuilderImpl extends LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl  implements MaturityChange.MaturityChangeBuilder {
	
	
		public MaturityChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public MaturityChange.MaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MaturityChange.MaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public MaturityChange.MaturityChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public MaturityChange.MaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public MaturityChange.MaturityChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public MaturityChange.MaturityChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public MaturityChange.MaturityChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public MaturityChange.MaturityChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public MaturityChange.MaturityChangeBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currentMaturityDate")
		public MaturityChange.MaturityChangeBuilder setCurrentMaturityDate(Date currentMaturityDate) {
			this.currentMaturityDate = currentMaturityDate==null?null:currentMaturityDate;
			return this;
		}
		@Override
		@RosettaAttribute("priorMaturityDate")
		public MaturityChange.MaturityChangeBuilder setPriorMaturityDate(Date priorMaturityDate) {
			this.priorMaturityDate = priorMaturityDate==null?null:priorMaturityDate;
			return this;
		}
		
		@Override
		public MaturityChange build() {
			return new MaturityChange.MaturityChangeImpl(this);
		}
		
		@Override
		public MaturityChange.MaturityChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityChange.MaturityChangeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityChange.MaturityChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MaturityChange.MaturityChangeBuilder o = (MaturityChange.MaturityChangeBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityChangeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
