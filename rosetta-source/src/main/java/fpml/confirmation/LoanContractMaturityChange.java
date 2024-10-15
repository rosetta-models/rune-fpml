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
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilder;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractMaturityChange;
import fpml.confirmation.LoanContractMaturityChange.LoanContractMaturityChangeBuilder;
import fpml.confirmation.LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl;
import fpml.confirmation.LoanContractMaturityChange.LoanContractMaturityChangeImpl;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.LoanContractMaturityChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a change of maturity date on a one or more outstanding loan contracts.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractMaturityChange", builder=LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl.class, version="${project.version}")
public interface LoanContractMaturityChange extends AbstractLoanContractEvent {

	LoanContractMaturityChangeMeta metaData = new LoanContractMaturityChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The new loan contract maturity date.
	 */
	Date getCurrentMaturityDate();
	/**
	 * The previous loan contract maturity date.
	 */
	Date getPriorMaturityDate();

	/*********************** Build Methods  ***********************/
	LoanContractMaturityChange build();
	
	LoanContractMaturityChange.LoanContractMaturityChangeBuilder toBuilder();
	
	static LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder() {
		return new LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractMaturityChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractMaturityChange> getType() {
		return LoanContractMaturityChange.class;
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
	interface LoanContractMaturityChangeBuilder extends LoanContractMaturityChange, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setComment(String comment);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEffectiveDate(Date effectiveDate);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCurrentMaturityDate(Date currentMaturityDate);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setPriorMaturityDate(Date priorMaturityDate);

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
		

		LoanContractMaturityChange.LoanContractMaturityChangeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractMaturityChange  ***********************/
	class LoanContractMaturityChangeImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanContractMaturityChange {
		private final Date currentMaturityDate;
		private final Date priorMaturityDate;
		
		protected LoanContractMaturityChangeImpl(LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder) {
			super(builder);
			this.currentMaturityDate = builder.getCurrentMaturityDate();
			this.priorMaturityDate = builder.getPriorMaturityDate();
		}
		
		@Override
		@RosettaAttribute("currentMaturityDate")
		public Date getCurrentMaturityDate() {
			return currentMaturityDate;
		}
		
		@Override
		@RosettaAttribute("priorMaturityDate")
		public Date getPriorMaturityDate() {
			return priorMaturityDate;
		}
		
		@Override
		public LoanContractMaturityChange build() {
			return this;
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder toBuilder() {
			LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrentMaturityDate()).ifPresent(builder::setCurrentMaturityDate);
			ofNullable(getPriorMaturityDate()).ifPresent(builder::setPriorMaturityDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractMaturityChange _that = getType().cast(o);
		
			if (!Objects.equals(currentMaturityDate, _that.getCurrentMaturityDate())) return false;
			if (!Objects.equals(priorMaturityDate, _that.getPriorMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currentMaturityDate != null ? currentMaturityDate.hashCode() : 0);
			_result = 31 * _result + (priorMaturityDate != null ? priorMaturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractMaturityChange {" +
				"currentMaturityDate=" + this.currentMaturityDate + ", " +
				"priorMaturityDate=" + this.priorMaturityDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractMaturityChange  ***********************/
	class LoanContractMaturityChangeBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements LoanContractMaturityChange.LoanContractMaturityChangeBuilder {
	
		protected Date currentMaturityDate;
		protected Date priorMaturityDate;
	
		public LoanContractMaturityChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currentMaturityDate")
		public Date getCurrentMaturityDate() {
			return currentMaturityDate;
		}
		
		@Override
		@RosettaAttribute("priorMaturityDate")
		public Date getPriorMaturityDate() {
			return priorMaturityDate;
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currentMaturityDate")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCurrentMaturityDate(Date currentMaturityDate) {
			this.currentMaturityDate = currentMaturityDate==null?null:currentMaturityDate;
			return this;
		}
		@Override
		@RosettaAttribute("priorMaturityDate")
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setPriorMaturityDate(Date priorMaturityDate) {
			this.priorMaturityDate = priorMaturityDate==null?null:priorMaturityDate;
			return this;
		}
		
		@Override
		public LoanContractMaturityChange build() {
			return new LoanContractMaturityChange.LoanContractMaturityChangeImpl(this);
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrentMaturityDate()!=null) return true;
			if (getPriorMaturityDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanContractMaturityChange.LoanContractMaturityChangeBuilder o = (LoanContractMaturityChange.LoanContractMaturityChangeBuilder) other;
			
			
			merger.mergeBasic(getCurrentMaturityDate(), o.getCurrentMaturityDate(), this::setCurrentMaturityDate);
			merger.mergeBasic(getPriorMaturityDate(), o.getPriorMaturityDate(), this::setPriorMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractMaturityChange _that = getType().cast(o);
		
			if (!Objects.equals(currentMaturityDate, _that.getCurrentMaturityDate())) return false;
			if (!Objects.equals(priorMaturityDate, _that.getPriorMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currentMaturityDate != null ? currentMaturityDate.hashCode() : 0);
			_result = 31 * _result + (priorMaturityDate != null ? priorMaturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractMaturityChangeBuilder {" +
				"currentMaturityDate=" + this.currentMaturityDate + ", " +
				"priorMaturityDate=" + this.priorMaturityDate +
			'}' + " " + super.toString();
		}
	}
}
