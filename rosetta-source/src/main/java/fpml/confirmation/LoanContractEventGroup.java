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
import fpml.confirmation.LoanContractEventGroup;
import fpml.confirmation.LoanContractEventGroup.LoanContractEventGroupBuilder;
import fpml.confirmation.LoanContractEventGroup.LoanContractEventGroupBuilderImpl;
import fpml.confirmation.LoanContractEventGroup.LoanContractEventGroupImpl;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.LoanContractEventGroupMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Head of the substitution group for all loan contract events.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractEventGroup", builder=LoanContractEventGroup.LoanContractEventGroupBuilderImpl.class, version="${project.version}")
public interface LoanContractEventGroup extends AbstractLoanContractEvent {

	LoanContractEventGroupMeta metaData = new LoanContractEventGroupMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanContractEventGroup build();
	
	LoanContractEventGroup.LoanContractEventGroupBuilder toBuilder();
	
	static LoanContractEventGroup.LoanContractEventGroupBuilder builder() {
		return new LoanContractEventGroup.LoanContractEventGroupBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractEventGroup> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractEventGroup> getType() {
		return LoanContractEventGroup.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractEventGroupBuilder extends LoanContractEventGroup, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		LoanContractEventGroup.LoanContractEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanContractEventGroup.LoanContractEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanContractEventGroup.LoanContractEventGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanContractEventGroup.LoanContractEventGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanContractEventGroup.LoanContractEventGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanContractEventGroup.LoanContractEventGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanContractEventGroup.LoanContractEventGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanContractEventGroup.LoanContractEventGroupBuilder setComment(String comment);
		LoanContractEventGroup.LoanContractEventGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LoanContractEventGroup.LoanContractEventGroupBuilder setEffectiveDate(Date effectiveDate);
		LoanContractEventGroup.LoanContractEventGroupBuilder setLoanContractReference(LoanContractReference loanContractReference);

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
		}
		

		LoanContractEventGroup.LoanContractEventGroupBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractEventGroup  ***********************/
	class LoanContractEventGroupImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanContractEventGroup {
		
		protected LoanContractEventGroupImpl(LoanContractEventGroup.LoanContractEventGroupBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanContractEventGroup build() {
			return this;
		}
		
		@Override
		public LoanContractEventGroup.LoanContractEventGroupBuilder toBuilder() {
			LoanContractEventGroup.LoanContractEventGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractEventGroup.LoanContractEventGroupBuilder builder) {
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
			return "LoanContractEventGroup {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractEventGroup  ***********************/
	class LoanContractEventGroupBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements LoanContractEventGroup.LoanContractEventGroupBuilder {
	
	
		public LoanContractEventGroupBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanContractEventGroup.LoanContractEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractEventGroup.LoanContractEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanContractEventGroup.LoanContractEventGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanContractEventGroup.LoanContractEventGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanContractEventGroup.LoanContractEventGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanContractEventGroup.LoanContractEventGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanContractEventGroup.LoanContractEventGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanContractEventGroup.LoanContractEventGroupBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LoanContractEventGroup.LoanContractEventGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LoanContractEventGroup.LoanContractEventGroupBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractEventGroup.LoanContractEventGroupBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanContractEventGroup build() {
			return new LoanContractEventGroup.LoanContractEventGroupImpl(this);
		}
		
		@Override
		public LoanContractEventGroup.LoanContractEventGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractEventGroup.LoanContractEventGroupBuilder prune() {
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
		public LoanContractEventGroup.LoanContractEventGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanContractEventGroup.LoanContractEventGroupBuilder o = (LoanContractEventGroup.LoanContractEventGroupBuilder) other;
			
			
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
			return "LoanContractEventGroupBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
