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
import fpml.confirmation.AbstractLoanAllocationSettlementEvent;
import fpml.confirmation.AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder;
import fpml.confirmation.AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventImpl;
import fpml.confirmation.AbstractLoanEvent;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilder;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilderImpl;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.meta.AbstractLoanAllocationSettlementEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract structure defining fundamental settlement event information.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanAllocationSettlementEvent", builder=AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl.class, version="${project.version}")
public interface AbstractLoanAllocationSettlementEvent extends AbstractLoanEvent {

	AbstractLoanAllocationSettlementEventMeta metaData = new AbstractLoanAllocationSettlementEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the loan trade allocation.
	 */
	LoanAllocationReference getAllocationReference();
	/**
	 * Date on which settlement will occur.
	 */
	Date getSettlementDate();

	/*********************** Build Methods  ***********************/
	AbstractLoanAllocationSettlementEvent build();
	
	AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder toBuilder();
	
	static AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder() {
		return new AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanAllocationSettlementEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanAllocationSettlementEvent> getType() {
		return AbstractLoanAllocationSettlementEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanAllocationSettlementEventBuilder extends AbstractLoanAllocationSettlementEvent, AbstractLoanEvent.AbstractLoanEventBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference();
		LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference();
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setComment(String comment);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setAllocationReference(LoanAllocationReference allocationReference);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setSettlementDate(Date settlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
		}
		

		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanAllocationSettlementEvent  ***********************/
	class AbstractLoanAllocationSettlementEventImpl extends AbstractLoanEvent.AbstractLoanEventImpl implements AbstractLoanAllocationSettlementEvent {
		private final LoanAllocationReference allocationReference;
		private final Date settlementDate;
		
		protected AbstractLoanAllocationSettlementEventImpl(AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder) {
			super(builder);
			this.allocationReference = ofNullable(builder.getAllocationReference()).map(f->f.build()).orElse(null);
			this.settlementDate = builder.getSettlementDate();
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationReference getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public Date getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder toBuilder() {
			AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAllocationReference()).ifPresent(builder::setAllocationReference);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationSettlementEvent {" +
				"allocationReference=" + this.allocationReference + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanAllocationSettlementEvent  ***********************/
	class AbstractLoanAllocationSettlementEventBuilderImpl extends AbstractLoanEvent.AbstractLoanEventBuilderImpl  implements AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder {
	
		protected LoanAllocationReference.LoanAllocationReferenceBuilder allocationReference;
		protected Date settlementDate;
	
		public AbstractLoanAllocationSettlementEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference() {
			LoanAllocationReference.LoanAllocationReferenceBuilder result;
			if (allocationReference!=null) {
				result = allocationReference;
			}
			else {
				result = allocationReference = LoanAllocationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public Date getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReference")
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setAllocationReference(LoanAllocationReference allocationReference) {
			this.allocationReference = allocationReference==null?null:allocationReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent build() {
			return new AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventImpl(this);
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder prune() {
			super.prune();
			if (allocationReference!=null && !allocationReference.prune().hasData()) allocationReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAllocationReference()!=null && getAllocationReference().hasData()) return true;
			if (getSettlementDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder o = (AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder) other;
			
			merger.mergeRosetta(getAllocationReference(), o.getAllocationReference(), this::setAllocationReference);
			
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationSettlementEventBuilder {" +
				"allocationReference=" + this.allocationReference + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}
}
