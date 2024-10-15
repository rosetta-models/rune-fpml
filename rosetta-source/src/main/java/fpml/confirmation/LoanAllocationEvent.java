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
import fpml.confirmation.AbstractLoanAllocationEvent;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationEvent;
import fpml.confirmation.LoanAllocationEvent.LoanAllocationEventBuilder;
import fpml.confirmation.LoanAllocationEvent.LoanAllocationEventBuilderImpl;
import fpml.confirmation.LoanAllocationEvent.LoanAllocationEventImpl;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.meta.LoanAllocationEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event structure defining information related to a loan trade allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationEvent", builder=LoanAllocationEvent.LoanAllocationEventBuilderImpl.class, version="${project.version}")
public interface LoanAllocationEvent extends AbstractLoanAllocationEvent {

	LoanAllocationEventMeta metaData = new LoanAllocationEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanAllocationEvent build();
	
	LoanAllocationEvent.LoanAllocationEventBuilder toBuilder();
	
	static LoanAllocationEvent.LoanAllocationEventBuilder builder() {
		return new LoanAllocationEvent.LoanAllocationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationEvent> getType() {
		return LoanAllocationEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationEventBuilder extends LoanAllocationEvent, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		LoanAllocationEvent.LoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanAllocationEvent.LoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanAllocationEvent.LoanAllocationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanAllocationEvent.LoanAllocationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanAllocationEvent.LoanAllocationEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanAllocationEvent.LoanAllocationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanAllocationEvent.LoanAllocationEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanAllocationEvent.LoanAllocationEventBuilder setComment(String comment);
		LoanAllocationEvent.LoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference0);
		LoanAllocationEvent.LoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference1, int _idx);
		LoanAllocationEvent.LoanAllocationEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference2);
		LoanAllocationEvent.LoanAllocationEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
		}
		

		LoanAllocationEvent.LoanAllocationEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationEvent  ***********************/
	class LoanAllocationEventImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanAllocationEvent {
		
		protected LoanAllocationEventImpl(LoanAllocationEvent.LoanAllocationEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanAllocationEvent build() {
			return this;
		}
		
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder toBuilder() {
			LoanAllocationEvent.LoanAllocationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationEvent.LoanAllocationEventBuilder builder) {
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
			return "LoanAllocationEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationEvent  ***********************/
	class LoanAllocationEventBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl  implements LoanAllocationEvent.LoanAllocationEventBuilder {
	
	
		public LoanAllocationEventBuilderImpl() {
		}
	
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationEvent.LoanAllocationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LoanAllocationEvent.LoanAllocationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationEvent.LoanAllocationEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanAllocationEvent.LoanAllocationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanAllocationEvent.LoanAllocationEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanAllocationEvent.LoanAllocationEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference) {
			if (allocationReference!=null) this.allocationReference.add(allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference, int _idx) {
			getIndex(this.allocationReference, _idx, () -> allocationReference.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationEvent.LoanAllocationEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("allocationReference")
		public LoanAllocationEvent.LoanAllocationEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences == null)  {
				this.allocationReference = new ArrayList<>();
			}
			else {
				this.allocationReference = allocationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanAllocationEvent build() {
			return new LoanAllocationEvent.LoanAllocationEventImpl(this);
		}
		
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder prune() {
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
		public LoanAllocationEvent.LoanAllocationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationEvent.LoanAllocationEventBuilder o = (LoanAllocationEvent.LoanAllocationEventBuilder) other;
			
			
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
			return "LoanAllocationEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
